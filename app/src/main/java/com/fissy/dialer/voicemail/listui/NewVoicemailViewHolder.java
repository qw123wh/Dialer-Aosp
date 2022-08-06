/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */
package com.fissy.dialer.voicemail.listui;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.app.FragmentManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.provider.VoicemailContract.Voicemails;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.recyclerview.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.voicemail.VoicemailClient;
import com.fissy.dialer.R;
import com.fissy.dialer.calllog.database.contract.AnnotatedCallLogContract.AnnotatedCallLog;
import com.fissy.dialer.calllogutils.PhotoInfoBuilder;
import com.fissy.dialer.common.Assert;
import com.fissy.dialer.common.LogUtil;
import com.fissy.dialer.common.concurrent.DialerExecutor.SuccessListener;
import com.fissy.dialer.common.concurrent.DialerExecutor.Worker;
import com.fissy.dialer.common.concurrent.DialerExecutorComponent;
import com.fissy.dialer.compat.android.provider.VoicemailCompat;
import com.fissy.dialer.time.Clock;
import com.fissy.dialer.voicemail.listui.menu.NewVoicemailMenu;
import com.fissy.dialer.voicemail.model.VoicemailEntry;
import com.fissy.dialer.widget.ContactPhotoView;

/**
 * {@link RecyclerView.ViewHolder} for the new voicemail tab.
 */
final class NewVoicemailViewHolder extends RecyclerView.ViewHolder implements OnClickListener {

    private final Context context;
    private final TextView primaryTextView;
    private final TextView secondaryTextView;
    private final TextView transcriptionTextView;
    private final TextView transcriptionBrandingTextView;
    private final ContactPhotoView contactPhotoView;
    private final NewVoicemailMediaPlayerView mediaPlayerView;
    private final ImageView menuButton;
    private final Clock clock;
    private final NewVoicemailViewHolderListener voicemailViewHolderListener;
    private boolean isViewHolderExpanded;
    private long viewHolderId;
    private VoicemailEntry voicemailEntryOfViewHolder;
    @NonNull
    private Uri viewHolderVoicemailUri;

    NewVoicemailViewHolder(
            View view, Clock clock, NewVoicemailViewHolderListener newVoicemailViewHolderListener) {
        super(view);
        LogUtil.enterBlock("NewVoicemailViewHolder");
        this.context = view.getContext();
        primaryTextView = view.findViewById(R.id.primary_text);
        secondaryTextView = view.findViewById(R.id.secondary_text);
        transcriptionTextView = view.findViewById(R.id.transcription_text);
        transcriptionBrandingTextView = view.findViewById(R.id.transcription_branding);
        contactPhotoView = view.findViewById(R.id.contact_photo_view);
        mediaPlayerView = view.findViewById(R.id.new_voicemail_media_player);
        menuButton = view.findViewById(R.id.menu_button);
        this.clock = clock;
        voicemailViewHolderListener = newVoicemailViewHolderListener;

        viewHolderId = -1;
        isViewHolderExpanded = false;
        viewHolderVoicemailUri = null;
    }

    public NewVoicemailMediaPlayerView getMediaPlayerView() {
        return Assert.isNotNull(mediaPlayerView);
    }

    /**
     * When the {@link RecyclerView} displays voicemail entries, it might recycle the views upon
     * scrolling. In that case we need to ensure that the member variables of this {@link
     * NewVoicemailViewHolder} and its views are correctly set, especially when this {@link
     * NewVoicemailViewHolder} is recycled.
     *
     * @param cursor                        the voicemail data from {@link AnnotatedCallLog} generated by the {@link
     *                                      VoicemailCursorLoader} related
     * @param fragmentManager               FragmentManager retrieved from {@link
     *                                      NewVoicemailFragment#getActivity()}
     * @param mediaPlayer
     * @param position                      the position of the item within the adapter's data set.
     * @param currentlyExpandedViewHolderId the value the adapter keeps track of which viewholder if
     */
    void bindViewHolderValuesFromAdapter(
            Cursor cursor,
            FragmentManager fragmentManager,
            NewVoicemailMediaPlayer mediaPlayer,
            int position,
            long currentlyExpandedViewHolderId) {

        LogUtil.i(
                "NewVoicemailViewHolder.bindViewHolderValuesFromAdapter",
                "view holder at pos:%d, adapterPos:%d, cursorPos:%d, cursorSize:%d",
                position,
                getAdapterPosition(),
                cursor.getPosition(),
                cursor.getCount());

        voicemailEntryOfViewHolder = VoicemailCursorLoader.toVoicemailEntry(cursor);
        viewHolderId = voicemailEntryOfViewHolder.getId();
        LogUtil.i(
                "NewVoicemailViewHolder.bindViewHolderValuesFromAdapter", "viewholderId:%d", viewHolderId);
        viewHolderVoicemailUri = Uri.parse(voicemailEntryOfViewHolder.getVoicemailUri());
        primaryTextView.setText(
                VoicemailEntryText.buildPrimaryVoicemailText(context, voicemailEntryOfViewHolder));
        secondaryTextView.setText(
                VoicemailEntryText.buildSecondaryVoicemailText(context, clock, voicemailEntryOfViewHolder));

        String voicemailTranscription = voicemailEntryOfViewHolder.getTranscription();

        if (TextUtils.isEmpty(voicemailTranscription)) {
            transcriptionTextView.setVisibility(GONE);
            transcriptionTextView.setText(null);
        } else {
            transcriptionTextView.setVisibility(View.VISIBLE);
            transcriptionTextView.setText(voicemailTranscription);
        }

        // Bold if voicemail is unread
        boldViewHolderIfUnread();

        itemView.setOnClickListener(this);
        menuButton.setOnClickListener(
                NewVoicemailMenu.createOnClickListener(context, voicemailEntryOfViewHolder));

        contactPhotoView.setPhoto(
                PhotoInfoBuilder.fromVoicemailEntry(voicemailEntryOfViewHolder).build());

        // Update the expanded/collapsed state of this view holder
        // Only update the binding of the mediaPlayerView of the expanded view holder
        if (viewHolderId == currentlyExpandedViewHolderId) {
            LogUtil.i(
                    "NewVoicemailViewHolder.bindViewHolderValuesFromAdapter",
                    "viewHolderId:%d is expanded, update its mediaplayer view",
                    viewHolderId);
            expandAndBindViewHolderAndMediaPlayerViewWithAdapterValues(
                    voicemailEntryOfViewHolder, fragmentManager, mediaPlayer, voicemailViewHolderListener);
            LogUtil.i(
                    "NewVoicemailViewHolder.bindViewHolderValuesFromAdapter",
                    "After 2nd updating the MPPlayerView: viewHolderId:%d, uri:%s, MediaplayerView(after "
                            + "updated):%s, adapter position passed down:%d, getAdapterPos:%d",
                    viewHolderId,
                    String.valueOf(viewHolderVoicemailUri),
                    String.valueOf(mediaPlayerView.getVoicemailUri()),
                    position,
                    getAdapterPosition());
            Assert.checkArgument(
                    mediaPlayerView.getVisibility() == VISIBLE,
                    "a expanded viewholder should have its media player view visible");
        } else {
            LogUtil.i(
                    "NewVoicemailViewHolder.bindViewHolderValuesFromAdapter",
                    "viewHolderId:%d is not the expanded one, collapse it and don't update the MpView",
                    viewHolderId);
            collapseViewHolder();
            Assert.checkArgument(
                    mediaPlayerView.getVisibility() == GONE,
                    "a collapsed viewholder should not have its media player view visible");
        }
        LogUtil.i(
                "NewVoicemailViewHolder.bindViewHolderValuesFromAdapter",
                "Final value after updating: viewHolderId:%d, uri:%s, MediaplayerView(not updated):%s,"
                        + " adapter position passed down:%d, getAdapterPos:%d, MPPlayerVisibility:%b",
                viewHolderId,
                String.valueOf(viewHolderVoicemailUri),
                String.valueOf(mediaPlayerView.getVoicemailUri()),
                position,
                getAdapterPosition(),
                mediaPlayerView.getVisibility() == VISIBLE);
    }

    private void boldViewHolderIfUnread() {
        LogUtil.v(
                "NewVoicemailViewHolder.boldViewHolderIfUnread",
                "id:%d, isRead:%d",
                voicemailEntryOfViewHolder.getId(),
                voicemailEntryOfViewHolder.getIsRead());

        if (voicemailEntryOfViewHolder.getIsRead() == 0) {
            primaryTextView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            secondaryTextView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            transcriptionTextView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        }
    }

    void collapseViewHolder() {
        LogUtil.i(
                "NewVoicemailViewHolder.collapseViewHolder",
                "viewHolderId:%d is being collapsed, its MPViewUri:%s, its Uri is :%s",
                viewHolderId,
                String.valueOf(mediaPlayerView.getVoicemailUri()),
                String.valueOf(viewHolderVoicemailUri));
        transcriptionTextView.setMaxLines(1);
        transcriptionBrandingTextView.setVisibility(GONE);
        isViewHolderExpanded = false;

        mediaPlayerView.reset();
        mediaPlayerView.setVisibility(GONE);
    }

    // When we are recycling the views ensure that we reset the viewHolder, as if its brand new
    public void reset() {
        LogUtil.i(
                "NewVoicemailViewHolder.reset()",
                "Reset the viewholder, currently viewHolderId:%d, uri:%s, isViewHolderExpanded:%b, "
                        + "its MediaPlayerViewUri:%s",
                viewHolderId,
                String.valueOf(viewHolderVoicemailUri),
                isViewHolderExpanded,
                String.valueOf(mediaPlayerView.getVoicemailUri()));

        viewHolderId = -1;
        isViewHolderExpanded = false;
        viewHolderVoicemailUri = null;

        primaryTextView.setTypeface(null, Typeface.NORMAL);
        secondaryTextView.setTypeface(null, Typeface.NORMAL);
        transcriptionTextView.setTypeface(null, Typeface.NORMAL);

        transcriptionBrandingTextView.setVisibility(GONE);

        mediaPlayerView.reset();

        LogUtil.i(
                "NewVoicemailViewHolder.reset()",
                "Reset the viewholder, after resetting viewHolderId:%d, uri:%s, isViewHolderExpanded:%b",
                viewHolderId,
                String.valueOf(viewHolderVoicemailUri),
                isViewHolderExpanded);
    }

    /**
     * Is only called when a user either clicks a {@link NewVoicemailViewHolder} to expand it or if
     * the user had already expanded, then scrolled the {@link NewVoicemailViewHolder} out of view and
     * then scrolled it back into view, and during the binding (as the views are recyled in {@link
     * RecyclerView}) we restore the expanded state of the {@link NewVoicemailViewHolder}.
     *
     * <p>This function also tracks if the state of this viewholder is expanded.
     *
     * @param voicemailEntry              are the voicemail related values from the {@link AnnotatedCallLog}
     * @param fragmentManager             FragmentManager retrieved from {@link
     *                                    NewVoicemailFragment#getActivity()}
     * @param mediaPlayer                 there should only be one instance of this passed down from the {@link
     *                                    NewVoicemailAdapter}
     * @param voicemailViewHolderListener
     */
    void expandAndBindViewHolderAndMediaPlayerViewWithAdapterValues(
            VoicemailEntry voicemailEntry,
            FragmentManager fragmentManager,
            NewVoicemailMediaPlayer mediaPlayer,
            NewVoicemailViewHolderListener voicemailViewHolderListener) {

        Assert.isNotNull(voicemailViewHolderListener);
        Assert.checkArgument(
                voicemailEntry.getId() == viewHolderId, "ensure that the adapter binding has taken place");
        Assert.checkArgument(
                Uri.parse(voicemailEntry.getVoicemailUri()).equals(viewHolderVoicemailUri),
                "ensure that the adapter binding has taken place");
        LogUtil.i(
                "NewVoicemailViewHolder.expandAndBindViewHolderAndMediaPlayerViewWithAdapterValues",
                "voicemail id: %d, value of isViewHolderExpanded:%b, before setting it to be true, and"
                        + " value of ViewholderUri:%s, MPView:%s, VoicemailRead:%d, before updating it",
                viewHolderId,
                isViewHolderExpanded,
                String.valueOf(viewHolderVoicemailUri),
                String.valueOf(mediaPlayerView.getVoicemailUri()),
                voicemailEntry.getIsRead());

        if (voicemailEntry.getIsRead() == 0) {
            // update as read.
            primaryTextView.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
            secondaryTextView.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
            transcriptionTextView.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);

            Uri uri = Uri.parse(voicemailEntry.getVoicemailUri());

            Worker<Pair<Context, Uri>, Integer> markVoicemailRead = this::markVoicemailAsRead;
            SuccessListener<Integer> markedAsReadVoicemailCallBack = this::onVoicemailMarkedAsRead;

            DialerExecutorComponent.get(context)
                    .dialerExecutorFactory()
                    .createUiTaskBuilder(fragmentManager, "mark_voicemail_read", markVoicemailRead)
                    .onSuccess(markedAsReadVoicemailCallBack)
                    .build()
                    .executeSerial(new Pair<>(context, uri));
        }

        transcriptionTextView.setMaxLines(999);
        isViewHolderExpanded = true;
        updateBrandingText(voicemailEntry);
        // Once the media player is visible update its state
        mediaPlayerView.setVisibility(View.VISIBLE);
        mediaPlayerView.bindValuesFromAdapterOfExpandedViewHolderMediaPlayerView(
                this, voicemailEntry, fragmentManager, mediaPlayer, voicemailViewHolderListener);
        LogUtil.i(
                "NewVoicemailViewHolder.expandAndBindViewHolderAndMediaPlayerViewWithAdapterValues",
                "voicemail id: %d, value of isViewHolderExpanded:%b, after setting it to be true, and"
                        + " value of ViewholderUri:%s, MPView:%s, after updating it",
                viewHolderId,
                isViewHolderExpanded,
                String.valueOf(viewHolderVoicemailUri),
                String.valueOf(mediaPlayerView.getVoicemailUri()));
    }

    private void updateBrandingText(VoicemailEntry voicemailEntry) {
        if (voicemailEntry.getTranscriptionState() == VoicemailCompat.TRANSCRIPTION_AVAILABLE
                && !TextUtils.isEmpty(voicemailEntry.getTranscription())) {
            transcriptionBrandingTextView.setVisibility(VISIBLE);
        } else {
            transcriptionBrandingTextView.setVisibility(GONE);
        }
    }

    @WorkerThread
    private Integer markVoicemailAsRead(Pair<Context, Uri> contextUriPair) {
        Assert.isWorkerThread();
        LogUtil.enterBlock("NewVoicemailAdapter.markVoicemailAsRead");
        Context context = contextUriPair.first;
        Uri uri = contextUriPair.second;

        ContentValues values = new ContentValues();
        values.put(Voicemails.IS_READ, true);
        values.put(Voicemails.DIRTY, 1);

        LogUtil.i(
                "NewVoicemailAdapter.markVoicemailAsRead", "marking as read uri:%s", String.valueOf(uri));
        return context.getContentResolver().update(uri, values, null, null);
    }

    private void onVoicemailMarkedAsRead(Integer integer) {
        LogUtil.i("NewVoicemailAdapter.markVoicemailAsRead", "return value:%d", integer);
        Assert.checkArgument(integer > 0, "marking voicemail read was not successful");

        Intent intent = new Intent(VoicemailClient.ACTION_UPLOAD);
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent);
    }

    /**
     * Called when we want to update the voicemail that is currently playing Updates the Seekbar,
     * duration timer and the play/pause button visibility when the expanded voicemail is being
     * played.
     */
    public void updateMediaPlayerViewWithPlayingState(
            NewVoicemailViewHolder newVoicemailViewHolder, NewVoicemailMediaPlayer mp) {

        LogUtil.i(
                "NewVoicemailViewHolder.updateMediaPlayerViewWithPlayingState",
                "viewholderUri:%s, mediaPlayerViewUri:%s, MPPosition:%d, MpDuration:%d, MpIsPlaying:%b",
                newVoicemailViewHolder.getViewHolderVoicemailUri().toString(),
                mediaPlayerView.getVoicemailUri().toString(),
                mp.getCurrentPosition(),
                mp.getDuration(),
                mp.isPlaying());

        Assert.checkArgument(
                mp.isPlaying(),
                "this method is only called when we are certain that the media player is playing");

        LogUtil.i(
                "NewVoicemailViewHolder.updateMediaPlayerViewWithPlayingState",
                "viewholderUri:%s, mediaPlayerViewUri:%s",
                newVoicemailViewHolder.getViewHolderVoicemailUri().toString(),
                mediaPlayerView.getVoicemailUri().toString());
        Assert.checkArgument(
                newVoicemailViewHolder
                        .getViewHolderVoicemailUri()
                        .equals(mediaPlayerView.getVoicemailUri()),
                "the mediaplayer view must be that of the viewholder we are updating");
        Assert.checkArgument(
                mp.getLastPlayedOrPlayingVoicemailUri()
                        .equals(mp.getLastPreparedOrPreparingToPlayVoicemailUri()),
                "the media player view we are attempting to update should be of the "
                        + "currently prepared and playing voicemail");

        mediaPlayerView.updateSeekBarDurationAndShowPlayButton(mp);
    }

    public void setMediaPlayerViewToResetState(
            NewVoicemailViewHolder currentlyExpandedViewHolderOnScreen,
            NewVoicemailMediaPlayer mediaPlayer) {
        Assert.isNotNull(currentlyExpandedViewHolderOnScreen);
        mediaPlayerView.setToResetState(currentlyExpandedViewHolderOnScreen, mediaPlayer);
    }

    public void setPausedStateOfMediaPlayerView(Uri uri, NewVoicemailMediaPlayer mediaPlayer) {
        Assert.checkArgument(viewHolderVoicemailUri.equals(uri));
        Assert.checkArgument(mediaPlayerView.getVoicemailUri().equals(uri));
        Assert.checkArgument(mediaPlayerView.getVoicemailUri().equals(viewHolderVoicemailUri));
        mediaPlayerView.setToPausedState(uri, mediaPlayer);
    }

    boolean isViewHolderExpanded() {
        return isViewHolderExpanded;
    }

    public long getViewHolderId() {
        return viewHolderId;
    }

    public Uri getViewHolderVoicemailUri() {
        return viewHolderVoicemailUri;
    }

    public void clickPlayButtonOfViewHoldersMediaPlayerView(
            NewVoicemailViewHolder expandedViewHolder) {
        LogUtil.i(
                "NewVoicemailViewHolder.clickPlayButtonOfViewHoldersMediaPlayerView",
                "expandedViewHolderID:%d",
                expandedViewHolder.getViewHolderId());

        Assert.checkArgument(
                mediaPlayerView.getVoicemailUri().equals(expandedViewHolder.getViewHolderVoicemailUri()));
        Assert.checkArgument(
                expandedViewHolder.getViewHolderVoicemailUri().equals(getViewHolderVoicemailUri()));
        Assert.checkArgument(
                mediaPlayerView.getVisibility() == View.VISIBLE,
                "the media player must be visible for viewholder id:%d, before we attempt to play");
        mediaPlayerView.clickPlayButton();
    }

    @Override
    public void onClick(View v) {
        LogUtil.i(
                "NewVoicemailViewHolder.onClick",
                "voicemail id: %d, isViewHolderCurrentlyExpanded:%b",
                viewHolderId,
                isViewHolderExpanded);
        if (isViewHolderExpanded) {
            voicemailViewHolderListener.collapseExpandedViewHolder(this);
        } else {
            voicemailViewHolderListener.expandViewHolderFirstTimeAndCollapseAllOtherVisibleViewHolders(
                    this,
                    Assert.isNotNull(voicemailEntryOfViewHolder),
                    Assert.isNotNull(voicemailViewHolderListener));
        }
    }

    interface NewVoicemailViewHolderListener {
        void expandViewHolderFirstTimeAndCollapseAllOtherVisibleViewHolders(
                NewVoicemailViewHolder expandedViewHolder,
                VoicemailEntry voicemailEntryOfViewHolder,
                NewVoicemailViewHolderListener listener);

        void collapseExpandedViewHolder(NewVoicemailViewHolder expandedViewHolder);

        void pauseViewHolder(NewVoicemailViewHolder expandedViewHolder);

        void resumePausedViewHolder(NewVoicemailViewHolder expandedViewHolder);

        void deleteViewHolder(
                Context context,
                FragmentManager fragmentManager,
                NewVoicemailViewHolder expandedViewHolder,
                Uri uri);
    }
}
