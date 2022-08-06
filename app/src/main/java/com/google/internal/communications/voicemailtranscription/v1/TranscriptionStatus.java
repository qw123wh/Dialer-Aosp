// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: packages/apps/Dialer/java/com/android/voicemail/impl/transcribe/grpc/voicemail_transcription.proto

package com.google.internal.communications.voicemailtranscription.v1;

/**
 * <pre>
 * Enum that describes the status of the transcription process.
 * </pre>
 * <p>
 * Protobuf enum {@code google.internal.communications.voicemailtranscription.v1.TranscriptionStatus}
 */
public enum TranscriptionStatus
        implements com.google.protobuf.Internal.EnumLite {
    /**
     * <pre>
     * Default but invalid value.
     * </pre>
     *
     * <code>TRANSCRIPTION_STATUS_UNSPECIFIED = 0;</code>
     */
    TRANSCRIPTION_STATUS_UNSPECIFIED(0),
    /**
     * <pre>
     * Transcription was successful and the transcript is present.
     * </pre>
     *
     * <code>SUCCESS = 1;</code>
     */
    SUCCESS(1),
    /**
     * <pre>
     * Transcription is progress. Check again later.
     * </pre>
     *
     * <code>PENDING = 2;</code>
     */
    PENDING(2),
    /**
     * <pre>
     * Transcription was successful, but the expiration period has passed, which
     * means that the sensative data (including the transcript) has been deleted.
     * Resend the voicemail through TranscribeVoicemailAsync to retry.
     * </pre>
     *
     * <code>EXPIRED = 3;</code>
     */
    EXPIRED(3),
    /**
     * <pre>
     * Internal error encountered during the transcription.
     * Resend the voicemail through TranscribeVoicemailAsync to retry.
     * This is a catch-all status for all retriable errors that aren't captured by
     * a more specfic status.
     * </pre>
     *
     * <code>FAILED_RETRY = 4;</code>
     */
    FAILED_RETRY(4),
    /**
     * <pre>
     * Internal error encountered during the transcription.
     * Do not resend the voicemail.
     * This is a catch-all status for all non-retriable errors that aren't
     * captured by a more specfic status.
     * </pre>
     *
     * <code>FAILED_NO_RETRY = 5;</code>
     */
    FAILED_NO_RETRY(5),
    /**
     * <pre>
     * The language detected is not yet supported by this service.
     * Do not resend the voicemail.
     * </pre>
     *
     * <code>FAILED_LANGUAGE_NOT_SUPPORTED = 6;</code>
     */
    FAILED_LANGUAGE_NOT_SUPPORTED(6),
    /**
     * <pre>
     * No speech was detected in the voicemail.
     * Do not resend the voicemail.
     * </pre>
     *
     * <code>FAILED_NO_SPEECH_DETECTED = 7;</code>
     */
    FAILED_NO_SPEECH_DETECTED(7),
    ;

    /**
     * <pre>
     * Default but invalid value.
     * </pre>
     *
     * <code>TRANSCRIPTION_STATUS_UNSPECIFIED = 0;</code>
     */
    public static final int TRANSCRIPTION_STATUS_UNSPECIFIED_VALUE = 0;
    /**
     * <pre>
     * Transcription was successful and the transcript is present.
     * </pre>
     *
     * <code>SUCCESS = 1;</code>
     */
    public static final int SUCCESS_VALUE = 1;
    /**
     * <pre>
     * Transcription is progress. Check again later.
     * </pre>
     *
     * <code>PENDING = 2;</code>
     */
    public static final int PENDING_VALUE = 2;
    /**
     * <pre>
     * Transcription was successful, but the expiration period has passed, which
     * means that the sensative data (including the transcript) has been deleted.
     * Resend the voicemail through TranscribeVoicemailAsync to retry.
     * </pre>
     *
     * <code>EXPIRED = 3;</code>
     */
    public static final int EXPIRED_VALUE = 3;
    /**
     * <pre>
     * Internal error encountered during the transcription.
     * Resend the voicemail through TranscribeVoicemailAsync to retry.
     * This is a catch-all status for all retriable errors that aren't captured by
     * a more specfic status.
     * </pre>
     *
     * <code>FAILED_RETRY = 4;</code>
     */
    public static final int FAILED_RETRY_VALUE = 4;
    /**
     * <pre>
     * Internal error encountered during the transcription.
     * Do not resend the voicemail.
     * This is a catch-all status for all non-retriable errors that aren't
     * captured by a more specfic status.
     * </pre>
     *
     * <code>FAILED_NO_RETRY = 5;</code>
     */
    public static final int FAILED_NO_RETRY_VALUE = 5;
    /**
     * <pre>
     * The language detected is not yet supported by this service.
     * Do not resend the voicemail.
     * </pre>
     *
     * <code>FAILED_LANGUAGE_NOT_SUPPORTED = 6;</code>
     */
    public static final int FAILED_LANGUAGE_NOT_SUPPORTED_VALUE = 6;
    /**
     * <pre>
     * No speech was detected in the voicemail.
     * Do not resend the voicemail.
     * </pre>
     *
     * <code>FAILED_NO_SPEECH_DETECTED = 7;</code>
     */
    public static final int FAILED_NO_SPEECH_DETECTED_VALUE = 7;
    private static final com.google.protobuf.Internal.EnumLiteMap<
            TranscriptionStatus> internalValueMap =
            new com.google.protobuf.Internal.EnumLiteMap<TranscriptionStatus>() {
                public TranscriptionStatus findValueByNumber(int number) {
                    return TranscriptionStatus.forNumber(number);
                }
            };
    private final int value;

    TranscriptionStatus(int value) {
        this.value = value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static TranscriptionStatus valueOf(int value) {
        return forNumber(value);
    }

    public static TranscriptionStatus forNumber(int value) {
        switch (value) {
            case 0:
                return TRANSCRIPTION_STATUS_UNSPECIFIED;
            case 1:
                return SUCCESS;
            case 2:
                return PENDING;
            case 3:
                return EXPIRED;
            case 4:
                return FAILED_RETRY;
            case 5:
                return FAILED_NO_RETRY;
            case 6:
                return FAILED_LANGUAGE_NOT_SUPPORTED;
            case 7:
                return FAILED_NO_SPEECH_DETECTED;
            default:
                return null;
        }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<TranscriptionStatus>
    internalGetValueMap() {
        return internalValueMap;
    }

    public final int getNumber() {
        return value;
    }

    // @@protoc_insertion_point(enum_scope:google.internal.communications.voicemailtranscription.v1.TranscriptionStatus)
}

