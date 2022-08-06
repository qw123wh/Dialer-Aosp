// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: packages/apps/Dialer/java/com/android/voicemail/impl/transcribe/grpc/voicemail_transcription.proto

package com.google.internal.communications.voicemailtranscription.v1;

/**
 * <pre>
 * Response for synchronous voicemail transcription.
 * </pre>
 * <p>
 * Protobuf type {@code google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailResponse}
 */
public final class TranscribeVoicemailResponse extends
        com.google.protobuf.GeneratedMessageLite<
                TranscribeVoicemailResponse, TranscribeVoicemailResponse.Builder> implements
        // @@protoc_insertion_point(message_implements:google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailResponse)
        TranscribeVoicemailResponseOrBuilder {
    public static final int TRANSCRIPT_FIELD_NUMBER = 1;
    // @@protoc_insertion_point(class_scope:google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailResponse)
    private static final com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailResponse DEFAULT_INSTANCE;
    private static volatile com.google.protobuf.Parser<TranscribeVoicemailResponse> PARSER;

    static {
        DEFAULT_INSTANCE = new TranscribeVoicemailResponse();
        DEFAULT_INSTANCE.makeImmutable();
    }

    private int bitField0_;
    private java.lang.String transcript_;

    private TranscribeVoicemailResponse() {
        transcript_ = "";
    }

    public static com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailResponse parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, data);
    }

    public static com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailResponse parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailResponse parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, data);
    }

    public static com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailResponse parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, data, extensionRegistry);
    }

    public static com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailResponse parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, input);
    }

    public static com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailResponse parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailResponse parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }

    public static com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailResponse parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailResponse parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, input);
    }

    public static com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailResponse parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageLite.parseFrom(
                DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailResponse prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    public static com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.Parser<TranscribeVoicemailResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /**
     * <pre>
     * The transcribed text of the voicemail.
     * </pre>
     *
     * <code>optional string transcript = 1;</code>
     */
    public boolean hasTranscript() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
    }

    /**
     * <pre>
     * The transcribed text of the voicemail.
     * </pre>
     *
     * <code>optional string transcript = 1;</code>
     */
    public java.lang.String getTranscript() {
        return transcript_;
    }

    /**
     * <pre>
     * The transcribed text of the voicemail.
     * </pre>
     *
     * <code>optional string transcript = 1;</code>
     */
    private void setTranscript(
            java.lang.String value) {
        if (value == null) {
            throw new NullPointerException();
        }
        bitField0_ |= 0x00000001;
        transcript_ = value;
    }

    /**
     * <pre>
     * The transcribed text of the voicemail.
     * </pre>
     *
     * <code>optional string transcript = 1;</code>
     */
    public com.google.protobuf.ByteString
    getTranscriptBytes() {
        return com.google.protobuf.ByteString.copyFromUtf8(transcript_);
    }

    /**
     * <pre>
     * The transcribed text of the voicemail.
     * </pre>
     *
     * <code>optional string transcript = 1;</code>
     */
    private void setTranscriptBytes(
            com.google.protobuf.ByteString value) {
        if (value == null) {
            throw new NullPointerException();
        }
        bitField0_ |= 0x00000001;
        transcript_ = value.toStringUtf8();
    }

    /**
     * <pre>
     * The transcribed text of the voicemail.
     * </pre>
     *
     * <code>optional string transcript = 1;</code>
     */
    private void clearTranscript() {
        bitField0_ = (bitField0_ & ~0x00000001);
        transcript_ = getDefaultInstance().getTranscript();
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
            output.writeString(1, getTranscript());
        }
        unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
        int size = memoizedSerializedSize;
        if (size != -1) return size;

        size = 0;
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
            size += com.google.protobuf.CodedOutputStream
                    .computeStringSize(1, getTranscript());
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
                return new com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailResponse();
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
                com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailResponse other = (com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailResponse) arg1;
                transcript_ = visitor.visitString(
                        hasTranscript(), transcript_,
                        other.hasTranscript(), other.transcript_);
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
                                String s = input.readString();
                                bitField0_ |= 0x00000001;
                                transcript_ = s;
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
                    synchronized (com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailResponse.class) {
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
     * Response for synchronous voicemail transcription.
     * </pre>
     * <p>
     * Protobuf type {@code google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailResponse}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageLite.Builder<
                    com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailResponse, Builder> implements
            // @@protoc_insertion_point(builder_implements:google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailResponse)
            com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailResponseOrBuilder {
        // Construct using com.google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailResponse.newBuilder()
        private Builder() {
            super(DEFAULT_INSTANCE);
        }


        /**
         * <pre>
         * The transcribed text of the voicemail.
         * </pre>
         *
         * <code>optional string transcript = 1;</code>
         */
        public boolean hasTranscript() {
            return instance.hasTranscript();
        }

        /**
         * <pre>
         * The transcribed text of the voicemail.
         * </pre>
         *
         * <code>optional string transcript = 1;</code>
         */
        public java.lang.String getTranscript() {
            return instance.getTranscript();
        }

        /**
         * <pre>
         * The transcribed text of the voicemail.
         * </pre>
         *
         * <code>optional string transcript = 1;</code>
         */
        public Builder setTranscript(
                java.lang.String value) {
            copyOnWrite();
            instance.setTranscript(value);
            return this;
        }

        /**
         * <pre>
         * The transcribed text of the voicemail.
         * </pre>
         *
         * <code>optional string transcript = 1;</code>
         */
        public com.google.protobuf.ByteString
        getTranscriptBytes() {
            return instance.getTranscriptBytes();
        }

        /**
         * <pre>
         * The transcribed text of the voicemail.
         * </pre>
         *
         * <code>optional string transcript = 1;</code>
         */
        public Builder setTranscriptBytes(
                com.google.protobuf.ByteString value) {
            copyOnWrite();
            instance.setTranscriptBytes(value);
            return this;
        }

        /**
         * <pre>
         * The transcribed text of the voicemail.
         * </pre>
         *
         * <code>optional string transcript = 1;</code>
         */
        public Builder clearTranscript() {
            copyOnWrite();
            instance.clearTranscript();
            return this;
        }

        // @@protoc_insertion_point(builder_scope:google.internal.communications.voicemailtranscription.v1.TranscribeVoicemailResponse)
    }
}

