// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: packages/apps/Dialer/java/com/fissy/dialer/calllog/database/contract/number_attributes.proto

package com.fissy.dialer;

public interface NumberAttributesOrBuilder extends
        // @@protoc_insertion_point(interface_extends:com.fissy.dialer.NumberAttributes)
        com.google.protobuf.MessageLiteOrBuilder {

    /**
     * <pre>
     * The name (which may be a person's name or business name, but not a number)
     * formatted exactly as it should appear to the user. If the user's locale or
     * name display preferences change, this field should be rewritten.
     * </pre>
     *
     * <code>optional string name = 1;</code>
     */
    boolean hasName();

    /**
     * <pre>
     * The name (which may be a person's name or business name, but not a number)
     * formatted exactly as it should appear to the user. If the user's locale or
     * name display preferences change, this field should be rewritten.
     * </pre>
     *
     * <code>optional string name = 1;</code>
     */
    java.lang.String getName();

    /**
     * <pre>
     * The name (which may be a person's name or business name, but not a number)
     * formatted exactly as it should appear to the user. If the user's locale or
     * name display preferences change, this field should be rewritten.
     * </pre>
     *
     * <code>optional string name = 1;</code>
     */
    com.google.protobuf.ByteString
    getNameBytes();

    /**
     * <pre>
     * A photo URI for the contact to display in the call log list view.
     * </pre>
     *
     * <code>optional string photo_uri = 2;</code>
     */
    boolean hasPhotoUri();

    /**
     * <pre>
     * A photo URI for the contact to display in the call log list view.
     * </pre>
     *
     * <code>optional string photo_uri = 2;</code>
     */
    java.lang.String getPhotoUri();

    /**
     * <pre>
     * A photo URI for the contact to display in the call log list view.
     * </pre>
     *
     * <code>optional string photo_uri = 2;</code>
     */
    com.google.protobuf.ByteString
    getPhotoUriBytes();

    /**
     * <pre>
     * A photo ID (from the contacts provider) for the contact to display in the
     * call log list view.
     * </pre>
     *
     * <code>optional int64 photo_id = 3;</code>
     */
    boolean hasPhotoId();

    /**
     * <pre>
     * A photo ID (from the contacts provider) for the contact to display in the
     * call log list view.
     * </pre>
     *
     * <code>optional int64 photo_id = 3;</code>
     */
    long getPhotoId();

    /**
     * <pre>
     * The contacts provider lookup URI for the contact associated with the call.
     * </pre>
     *
     * <code>optional string lookup_uri = 4;</code>
     */
    boolean hasLookupUri();

    /**
     * <pre>
     * The contacts provider lookup URI for the contact associated with the call.
     * </pre>
     *
     * <code>optional string lookup_uri = 4;</code>
     */
    java.lang.String getLookupUri();

    /**
     * <pre>
     * The contacts provider lookup URI for the contact associated with the call.
     * </pre>
     *
     * <code>optional string lookup_uri = 4;</code>
     */
    com.google.protobuf.ByteString
    getLookupUriBytes();

    /**
     * <pre>
     * The number type as a string to be displayed to the user, for example "Home"
     * or "Mobile". This column should be updated for the appropriate language
     * when the locale changes.
     * </pre>
     *
     * <code>optional string number_type_label = 5;</code>
     */
    boolean hasNumberTypeLabel();

    /**
     * <pre>
     * The number type as a string to be displayed to the user, for example "Home"
     * or "Mobile". This column should be updated for the appropriate language
     * when the locale changes.
     * </pre>
     *
     * <code>optional string number_type_label = 5;</code>
     */
    java.lang.String getNumberTypeLabel();

    /**
     * <pre>
     * The number type as a string to be displayed to the user, for example "Home"
     * or "Mobile". This column should be updated for the appropriate language
     * when the locale changes.
     * </pre>
     *
     * <code>optional string number_type_label = 5;</code>
     */
    com.google.protobuf.ByteString
    getNumberTypeLabelBytes();

    /**
     * <pre>
     * The number is a call to a business from nearby places lookup.
     * </pre>
     *
     * <code>optional bool is_business = 6;</code>
     */
    boolean hasIsBusiness();

    /**
     * <pre>
     * The number is a call to a business from nearby places lookup.
     * </pre>
     *
     * <code>optional bool is_business = 6;</code>
     */
    boolean getIsBusiness();

    /**
     * <pre>
     * Can the number be reported as invalid through People API
     * </pre>
     *
     * <code>optional bool can_report_as_invalid_number = 7;</code>
     */
    boolean hasCanReportAsInvalidNumber();

    /**
     * <pre>
     * Can the number be reported as invalid through People API
     * </pre>
     *
     * <code>optional bool can_report_as_invalid_number = 7;</code>
     */
    boolean getCanReportAsInvalidNumber();

    /**
     * <pre>
     * True if the CP2 information is incomplete and needs to be queried at
     * display time.
     * </pre>
     *
     * <code>optional bool is_cp2_info_incomplete = 8;</code>
     */
    boolean hasIsCp2InfoIncomplete();

    /**
     * <pre>
     * True if the CP2 information is incomplete and needs to be queried at
     * display time.
     * </pre>
     *
     * <code>optional bool is_cp2_info_incomplete = 8;</code>
     */
    boolean getIsCp2InfoIncomplete();

    /**
     * <pre>
     * Whether the number is blocked.
     * </pre>
     *
     * <code>optional bool is_blocked = 9;</code>
     */
    boolean hasIsBlocked();

    /**
     * <pre>
     * Whether the number is blocked.
     * </pre>
     *
     * <code>optional bool is_blocked = 9;</code>
     */
    boolean getIsBlocked();

    /**
     * <pre>
     * Whether the number is spam.
     * </pre>
     *
     * <code>optional bool is_spam = 10;</code>
     */
    boolean hasIsSpam();

    /**
     * <pre>
     * Whether the number is spam.
     * </pre>
     *
     * <code>optional bool is_spam = 10;</code>
     */
    boolean getIsSpam();

    /**
     * <pre>
     * Source of the contact associated with the number.
     * </pre>
     *
     * <code>optional .com.fissy.dialer.logging.ContactSource.Type contact_source = 11;</code>
     */
    boolean hasContactSource();

    /**
     * <pre>
     * Source of the contact associated with the number.
     * </pre>
     *
     * <code>optional .com.fissy.dialer.logging.ContactSource.Type contact_source = 11;</code>
     */
    com.fissy.dialer.logging.ContactSource.Type getContactSource();

    /**
     * <pre>
     * Whether the number can be reached via a carrier video call.
     * </pre>
     *
     * <code>optional bool can_support_carrier_video_call = 12;</code>
     */
    boolean hasCanSupportCarrierVideoCall();

    /**
     * <pre>
     * Whether the number can be reached via a carrier video call.
     * </pre>
     *
     * <code>optional bool can_support_carrier_video_call = 12;</code>
     */
    boolean getCanSupportCarrierVideoCall();

    /**
     * <pre>
     * Description of the number's geolocation (e.g., "Mountain View, CA").
     * This string is for display purpose only.
     * </pre>
     *
     * <code>optional string geolocation = 13;</code>
     */
    boolean hasGeolocation();

    /**
     * <pre>
     * Description of the number's geolocation (e.g., "Mountain View, CA").
     * This string is for display purpose only.
     * </pre>
     *
     * <code>optional string geolocation = 13;</code>
     */
    java.lang.String getGeolocation();

    /**
     * <pre>
     * Description of the number's geolocation (e.g., "Mountain View, CA").
     * This string is for display purpose only.
     * </pre>
     *
     * <code>optional string geolocation = 13;</code>
     */
    com.google.protobuf.ByteString
    getGeolocationBytes();

    /**
     * <pre>
     * Whether the number is an emergency number.
     * </pre>
     *
     * <code>optional bool is_emergency_number = 14;</code>
     */
    boolean hasIsEmergencyNumber();

    /**
     * <pre>
     * Whether the number is an emergency number.
     * </pre>
     *
     * <code>optional bool is_emergency_number = 14;</code>
     */
    boolean getIsEmergencyNumber();
}
