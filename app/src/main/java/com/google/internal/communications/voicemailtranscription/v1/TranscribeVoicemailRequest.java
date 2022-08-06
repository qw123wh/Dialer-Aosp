// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: packages/apps/Dialer/java/com/android/voicemail/impl/transcribe/grpc/voicemail_transcription.proto

package com.google.internal.communications.voicemailtranscription.v1;

/**
 * <pre>
 * Request for synchronous voicemail transcription.
 * </pre>
 * <p>
 * Protobuf type {@code google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailRequest}
 */
public final class TranscribeVoicemailRequest extends
        com.google.protobuf.GeneratedMessageLite<
                TranscribeVoicemailRequest, TranscribeVoicemailRequest.Builder> implements
        // @@protoc_insertion_point(message_implements:google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailRequest)
        TranscribeVoicemailRequestOrBuilder {
    public static final int VOICEMAIL_DATA_FIELD_NUMBER = 1;
    public static final int AUDIO_FORMAT_FIELD_NUMBER = 2;
    // @@protoc_insertion_point(class_scope:google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailRequest)
    private static final com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailRequest DEFAULT_INSTANCE;
    private static volatile com.google.protobuf.Parser<TranscribeVoicemailRequest> PARSER;

    static {
        DEFAULT_INSTANCE = new TranscribeVoicemailRequest();
        DEFAULT_INSTANCE.makeImmutable();
    }

    private int bitField0_;
    private com.google.protobuf.ByteString voicemailData_;
    private int audioFormat_;

    private TranscribeVoicemailRequest() {
        voicemailData_ = com.google.protobuf.ByteString.EMPTY;
        audioFormat_ = 0;
    }

    public static com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailRequest parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, data);
    }

    public static com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailRequest parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailRequest parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, data);
    }

    public static com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailRequest parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailRequest parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, input);
    }

    public static com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailRequest parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailRequest parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailRequest parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailRequest parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, input);
    }

    public static com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailRequest parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailRequest prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    public static com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.Parser<TranscribeVoicemailRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /**
     * <pre>
     * Voicemail audio file containing the raw bytes we receive from the carrier.
     * </pre>
     *
     * <code>optional bytes voicemail_data = 1;</code>
     */
    public boolean hasVoicemailData() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
    }

    /**
     * <pre>
     * Voicemail audio file containing the raw bytes we receive from the carrier.
     * </pre>
     *
     * <code>optional bytes voicemail_data = 1;</code>
     */
    public com.google.protobuf.ByteString getVoicemailData() {
        return voicemailData_;
    }

    /**
     * <pre>
     * Voicemail audio file containing the raw bytes we receive from the carrier.
     * </pre>
     *
     * <code>optional bytes voicemail_data = 1;</code>
     */
    private void setVoicemailData(com.google.protobuf.ByteString value) {
        if (value == null) {
            throw new NullPointerException();
        }
        bitField0_ |= 0x00000001;
        voicemailData_ = value;
    }

    /**
     * <pre>
     * Voicemail audio file containing the raw bytes we receive from the carrier.
     * </pre>
     *
     * <code>optional bytes voicemail_data = 1;</code>
     */
    private void clearVoicemailData() {
        bitField0_ = (bitField0_ & ~0x00000001);
        voicemailData_ = getDefaultInstance().getVoicemailData();
    }

    /**
     * <pre>
     * Audio format of the voicemail file.
     * </pre>
     *
     * <code>optional .google.internal.communications.voicemailtranscription.v1.AudioFormat audio_format = 2;</code>
     */
    public boolean hasAudioFormat() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
    }

    /**
     * <pre>
     * Audio format of the voicemail file.
     * </pre>
     *
     * <code>optional .google.internal.communications.voicemailtranscription.v1.AudioFormat audio_format = 2;</code>
     */
    public com.google.internal.communications.voicemailtranscription.v1.AudioFormat getAudioFormat() {
        com.google.internal.communications.voicemailtranscription.v1.AudioFormat result = com.google.internal.communications.voicemailtranscription.v1.AudioFormat.forNumber(audioFormat_);
        return result == null ? com.google.internal.communications.voicemailtranscription.v1.AudioFormat.AUDIO_FORMAT_UNSPECIFIED : result;
    }

    /**
     * <pre>
     * Audio format of the voicemail file.
     * </pre>
     *
     * <code>optional .google.internal.communications.voicemailtranscription.v1.AudioFormat audio_format = 2;</code>
     */
    private void setAudioFormat(com.google.internal.communications.voicemailtranscription.v1.AudioFormat value) {
        if (value == null) {
            throw new NullPointerException();
        }
        bitField0_ |= 0x00000002;
        audioFormat_ = value.getNumber();
    }

    /**
     * <pre>
     * Audio format of the voicemail file.
     * </pre>
     *
     * <code>optional .google.internal.communications.voicemailtranscription.v1.AudioFormat audio_format = 2;</code>
     */
    private void clearAudioFormat() {
        bitField0_ = (bitField0_ & ~0x00000002);
        audioFormat_ = 0;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
            output.writeBytes(1, voicemailData_);
        }
        if (((bitField0_ & 0x00000002) == 0x00000002)) {
            output.writeEnum(2, audioFormat_);
        }
        unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
        int size = memoizedSerializedSize;
        if (size != -1) return size;

        size = 0;
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
            size += com.google.protobuf.CodedOutputStream
                    .computeBytesSize(1, voicemailData_);
        }
        if (((bitField0_ & 0x00000002) == 0x00000002)) {
            size += com.google.protobuf.CodedOutputStream
                    .computeEnumSize(2, audioFormat_);
        }
        size += unknownFields.getSerializedSize();
        memoizedSerializedSize = size;
        return size;
    }

    protected final Object dynamicMethod(
            com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
            Object arg0, Object arg1) {
        switch (method) {
            case NEW_MUTABLE_INSTANCE: {
                return new com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailRequest();
            }
            case IS_INITIALIZED: {
                return DEFAULT_INSTANCE;
            }
            case MAKE_IMMUTABLE: {
                return null;
            }
            case NEW_BUILDER: {
                return new Builder();
            }
            case VISIT: {
                Visitor visitor = (Visitor) arg0;
                com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailRequest other = (com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailRequest) arg1;
                voicemailData_ = visitor.visitByteString(
                        hasVoicemailData(), voicemailData_,
                        other.hasVoicemailData(), other.voicemailData_);
                audioFormat_ = visitor.visitInt(hasAudioFormat(), audioFormat_,
                        other.hasAudioFormat(), other.audioFormat_);
                if (visitor == com.google.protobuf.GeneratedMessageLite.MergeFromVisitor
                        .INSTANCE) {
                    bitField0_ |= other.bitField0_;
                }
                return this;
            }
            case MERGE_FROM_STREAM: {
                com.google.protobuf.CodedInputStream input =
                        (com.google.protobuf.CodedInputStream) arg0;
                com.google.protobuf.ExtensionRegistryLite extensionRegistry =
                        (com.google.protobuf.ExtensionRegistryLite) arg1;
                try {
                    boolean done = false;
                    while (!done) {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            default: {
                                if (!parseUnknownField(tag, input)) {
                                    done = true;
                                }
                                break;
                            }
                            case 10: {
                                bitField0_ |= 0x00000001;
                                voicemailData_ = input.readBytes();
                                break;
                            }
                            case 16: {
                                int rawValue = input.readEnum();
                                com.google.internal.communications.voicemailtranscription.v1.AudioFormat value = com.google.internal.communications.voicemailtranscription.v1.AudioFormat.forNumber(rawValue);
                                if (value == null) {
                                    super.mergeVarintField(2, rawValue);
                                } else {
                                    bitField0_ |= 0x00000002;
                                    audioFormat_ = rawValue;
                                }
                                break;
                            }
                        }
                    }
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    throw new RuntimeException(e.setUnfinishedMessage(this));
                } catch (java.io.IOException e) {
                    throw new RuntimeException(
                            new com.google.protobuf.InvalidProtocolBufferException(
                                    e.getMessage()).setUnfinishedMessage(this));
                } finally {
                }
            }
            case GET_DEFAULT_INSTANCE: {
                return DEFAULT_INSTANCE;
            }
            case GET_PARSER: {
                if (PARSER == null) {
                    synchronized (com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailRequest.class) {
                        if (PARSER == null) {
                            PARSER = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        }
                    }
                }
                return PARSER;
            }
        }
        throw new UnsupportedOperationException();
    }

    /**
     * <pre>
     * Request for synchronous voicemail transcription.
     * </pre>
     * <p>
     * Protobuf type {@code google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailRequest}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageLite.Builder<
                    com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailRequest, Builder> implements
            // @@protoc_insertion_point(builder_implements:google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailRequest)
            com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailRequestOrBuilder {
        // Construct using com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailRequest.newBuilder()
        private Builder() {
            super(DEFAULT_INSTANCE);
        }


        /**
         * <pre>
         * Voicemail audio file containing the raw bytes we receive from the carrier.
         * </pre>
         *
         * <code>optional bytes voicemail_data = 1;</code>
         */
        public boolean hasVoicemailData() {
            return instance.hasVoicemailData();
        }

        /**
         * <pre>
         * Voicemail audio file containing the raw bytes we receive from the carrier.
         * </pre>
         *
         * <code>optional bytes voicemail_data = 1;</code>
         */
        public com.google.protobuf.ByteString getVoicemailData() {
            return instance.getVoicemailData();
        }

        /**
         * <pre>
         * Voicemail audio file containing the raw bytes we receive from the carrier.
         * </pre>
         *
         * <code>optional bytes voicemail_data = 1;</code>
         */
        public Builder setVoicemailData(com.google.protobuf.ByteString value) {
            copyOnWrite();
            instance.setVoicemailData(value);
            return this;
        }

        /**
         * <pre>
         * Voicemail audio file containing the raw bytes we receive from the carrier.
         * </pre>
         *
         * <code>optional bytes voicemail_data = 1;</code>
         */
        public Builder clearVoicemailData() {
            copyOnWrite();
            instance.clearVoicemailData();
            return this;
        }

        /**
         * <pre>
         * Audio format of the voicemail file.
         * </pre>
         *
         * <code>optional .google.internal.communications.voicemailtranscription.v1.AudioFormat audio_format = 2;</code>
         */
        public boolean hasAudioFormat() {
            return instance.hasAudioFormat();
        }

        /**
         * <pre>
         * Audio format of the voicemail file.
         * </pre>
         *
         * <code>optional .google.internal.communications.voicemailtranscription.v1.AudioFormat audio_format = 2;</code>
         */
        public com.google.internal.communications.voicemailtranscription.v1.AudioFormat getAudioFormat() {
            return instance.getAudioFormat();
        }

        /**
         * <pre>
         * Audio format of the voicemail file.
         * </pre>
         *
         * <code>optional .google.internal.communications.voicemailtranscription.v1.AudioFormat audio_format = 2;</code>
         */
        public Builder setAudioFormat(com.google.internal.communications.voicemailtranscription.v1.AudioFormat value) {
            copyOnWrite();
            instance.setAudioFormat(value);
            return this;
        }

        /**
         * <pre>
         * Audio format of the voicemail file.
         * </pre>
         *
         * <code>optional .google.internal.communications.voicemailtranscription.v1.AudioFormat audio_format = 2;</code>
         */
        public Builder clearAudioFormat() {
            copyOnWrite();
            instance.clearAudioFormat();
            return this;
        }

        // @@protoc_insertion_point(builder_scope:google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailRequest)
    }
}

