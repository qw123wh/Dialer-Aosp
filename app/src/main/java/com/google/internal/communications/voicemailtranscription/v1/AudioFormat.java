// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: packages/apps/Dialer/java/com/android/voicemail/impl/transcribe/grpc/voicemail_transcription.proto

package com.google.internal.communications.voicemailtranscription.v1;

/**
 * <pre>
 * Enum that specifies supported audio formats.
 * </pre>
 * <p>
 * Protobuf enum {@code google.internal.communications.voicemailtranscription.v1.AudioFormat}
 */
public enum AudioFormat
        implements com.google.protobuf.Internal.EnumLite {
    /**
     * <pre>
     * Default but invalid value.
     * </pre>
     *
     * <code>AUDIO_FORMAT_UNSPECIFIED = 0;</code>
     */
    AUDIO_FORMAT_UNSPECIFIED(0),
    /**
     * <pre>
     * Adaptive Multi-Rate Narrowband, 8kHz sampling frequency.
     * https://en.wikipedia.org/wiki/Adaptive_Multi-Rate_audio_codec
     * </pre>
     *
     * <code>AMR_NB_8KHZ = 1;</code>
     */
    AMR_NB_8KHZ(1),
    ;

    /**
     * <pre>
     * Default but invalid value.
     * </pre>
     *
     * <code>AUDIO_FORMAT_UNSPECIFIED = 0;</code>
     */
    public static final int AUDIO_FORMAT_UNSPECIFIED_VALUE = 0;
    /**
     * <pre>
     * Adaptive Multi-Rate Narrowband, 8kHz sampling frequency.
     * https://en.wikipedia.org/wiki/Adaptive_Multi-Rate_audio_codec
     * </pre>
     *
     * <code>AMR_NB_8KHZ = 1;</code>
     */
    public static final int AMR_NB_8KHZ_VALUE = 1;
    private static final com.google.protobuf.Internal.EnumLiteMap<
            AudioFormat> internalValueMap =
            new com.google.protobuf.Internal.EnumLiteMap<AudioFormat>() {
                public AudioFormat findValueByNumber(int number) {
                    return AudioFormat.forNumber(number);
                }
            };
    private final int value;

    AudioFormat(int value) {
        this.value = value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static AudioFormat valueOf(int value) {
        return forNumber(value);
    }

    public static AudioFormat forNumber(int value) {
        switch (value) {
            case 0:
                return AUDIO_FORMAT_UNSPECIFIED;
            case 1:
                return AMR_NB_8KHZ;
            default:
                return null;
        }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<AudioFormat>
    internalGetValueMap() {
        return internalValueMap;
    }

    public final int getNumber() {
        return value;
    }

    // @@protoc_insertion_point(enum_scope:google.internal.communications.voicemailtranscription.v1.AudioFormat)
}

