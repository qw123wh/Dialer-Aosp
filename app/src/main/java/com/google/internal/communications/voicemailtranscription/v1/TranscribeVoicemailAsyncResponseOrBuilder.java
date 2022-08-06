// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: packages/apps/Dialer/java/com/android/voicemail/impl/transcribe/grpc/voicemail_transcription.proto

package com.google.internal.communications.voicemailtranscription.v1;

public interface TranscribeVoicemailAsyncResponseOrBuilder extends
        // @@protoc_insertion_point(interface_extends:google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailAsyncResponse)
        com.google.protobuf.MessageLiteOrBuilder {

    /**
     * <pre>
     * Unique ID for the transcription. This ID is used for retrieving the
     * voicemail transcript later.
     * </pre>
     *
     * <code>optional string transcription_id = 1;</code>
     */
    boolean hasTranscriptionId();

    /**
     * <pre>
     * Unique ID for the transcription. This ID is used for retrieving the
     * voicemail transcript later.
     * </pre>
     *
     * <code>optional string transcription_id = 1;</code>
     */
    java.lang.String getTranscriptionId();

    /**
     * <pre>
     * Unique ID for the transcription. This ID is used for retrieving the
     * voicemail transcript later.
     * </pre>
     *
     * <code>optional string transcription_id = 1;</code>
     */
    com.google.protobuf.ByteString
    getTranscriptionIdBytes();

    /**
     * <pre>
     * The estimated amount of time in seconds before the transcription will be
     * available.
     * The client should not call GetTranscript until this time has elapsed, but
     * the transcript is not guaranteed to be ready by this time.
     * </pre>
     *
     * <code>optional int64 estimated_wait_secs = 2;</code>
     */
    boolean hasEstimatedWaitSecs();

    /**
     * <pre>
     * The estimated amount of time in seconds before the transcription will be
     * available.
     * The client should not call GetTranscript until this time has elapsed, but
     * the transcript is not guaranteed to be ready by this time.
     * </pre>
     *
     * <code>optional int64 estimated_wait_secs = 2;</code>
     */
    long getEstimatedWaitSecs();
}
