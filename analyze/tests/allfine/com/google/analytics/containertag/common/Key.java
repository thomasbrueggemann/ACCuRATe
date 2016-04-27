package com.google.analytics.containertag.common;

public enum Key {
    ACCOUNT("account"),
    ACTIVITY("activity"),
    ADDITIONAL_PARAMS("additional_params"),
    ADVERTISER("advertiser"),
    ALGORITHM("algorithm"),
    ALLOW_ANCHOR("allow_anchor"),
    ALLOW_HASH("allow_hash"),
    ALLOW_LINKER("allow_linker"),
    ANALYTICS_FIELDS("analytics_fields"),
    ANALYTICS_PASS_THROUGH("analytics_pass_through"),
    ANONYMIZE_IP("anonymize_ip"),
    APP_NAME("app_name"),
    APP_VERSION("app_version"),
    ARG0("arg0"),
    ARG1("arg1"),
    ATTRIBUTE("attribute"),
    AUTO_LINK_DOMAINS("auto_link_domains"),
    CACHE_BUSTER("cache_buster"),
    CACHE_BUSTER_VALUE("cache_buster_value"),
    CAMPAIGN_CONTENT_KEY("campaign_content_key"),
    CAMPAIGN_CONTENT_OVERRIDE("campaign_content_override"),
    CAMPAIGN_COOKIE_TIMEOUT("campaign_cookie_timeout"),
    CAMPAIGN_MEDIUM_KEY("campaign_medium_key"),
    CAMPAIGN_MEDIUM_OVERRIDE("campaign_medium_override"),
    CAMPAIGN_NAME_KEY("campaign_name_key"),
    CAMPAIGN_NAME_OVERRIDE("campaign_name_override"),
    CAMPAIGN_NO_KEY("campaign_no_key"),
    CAMPAIGN_SOURCE_KEY("campaign_source_key"),
    CAMPAIGN_SOURCE_OVERRIDE("campaign_source_override"),
    CAMPAIGN_TERM_KEY("campaign_term_key"),
    CAMPAIGN_TERM_OVERRIDE("campaign_term_override"),
    CAMPAIGN_TRACK("campaign_track"),
    CATEGORY("category"),
    CHECK_VALIDATION("check_validation"),
    CLEAR_PERSISTENT_DATA_LAYER_PREFIX("clear_data_layer_prefix"),
    CLICK_ID("click_id"),
    CLIENT_INFO("client_info"),
    COMPANY("company"),
    COMPONENT("component"),
    CONTENT_DESCRIPTION("content_description"),
    CONTENT_GROUP("content_group"),
    CONVERSION_ID("conversion_id"),
    COOKIE_DOMAIN("cookie_domain"),
    COOKIE_EXPIRATION("cookie_expiration"),
    COOKIE_NAME("cookie_name"),
    COOKIE_PATH("cookie_path"),
    COOKIE_PATH_COPY("cookie_path_copy"),
    COUNTRY("country"),
    CURRENCY_CODE("currency_code"),
    CUSTOMER_ID("customer_id"),
    CUSTOM_VARS("custom_vars"),
    DATA_LAYER_VERSION("data_layer_version"),
    DATA_PROVIDER_ID("data_provider_id"),
    DEBUG("debug"),
    DECORATE_FORM("decorate_form"),
    DECORATE_FORMS_AUTO_LINK("decorate_forms_auto_link"),
    DECORATE_LINK("decorate_link"),
    DEFAULT_PAGES("default_pages"),
    DEFAULT_VALUE("default_value"),
    DEPENDENCIES("dependencies"),
    DETECT_FLASH("detect_flash"),
    DETECT_TITLE("detect_title"),
    DIMENSION("dimension"),
    DOMAIN_NAME("domain_name"),
    DOUBLE_CLICK("double_click"),
    ECOMMERCE_MACRO_DATA("ecommerce_macro_data"),
    ECOMMERCE_USE_DATA_LAYER("ecommerce_use_data_layer"),
    ELEMENT("element"),
    EMAIL("email"),
    EMPLOYEE_RANGE("employee_range"),
    ENABLE_ECOMMERCE("enable_ecommerce"),
    ESCAPE("escape"),
    EVENT_ACTION("event_action"),
    EVENT_CATEGORY("event_category"),
    EVENT_LABEL("event_label"),
    EVENT_VALUE("event_value"),
    EXCEPTION_DESCRIPTION("exception_description"),
    EXCEPTION_FATAL("exception_fatal"),
    FIELDS_TO_SET("fields_to_set"),
    FORCE_SSL("force_ssl"),
    FORM_OBJECT("form_object"),
    FUNCTION("function"),
    FUNCTION_CALL_NAME("function_call_macro_name"),
    GROUP("group"),
    GTM_ON_FAILURE("gtmOnFailure"),
    GTM_ON_SUCCESS("gtmOnSuccess"),
    HIT_CALLBACK("hit_callback"),
    HTML("html"),
    // $FF: renamed from: ID com.google.analytics.containertag.common.Key
    field_4009("id"),
    IGNORED_ORGANIC("ignored_organic"),
    IGNORED_REF("ignored_ref"),
    IGNORE_CASE("ignore_case"),
    INPUT("input"),
    INPUT_FORMAT("input_format"),
    INSTANCE_LABEL("instance_label"),
    INSTANCE_NAME("instance_name"),
    INTERVAL("interval"),
    ITEM_SEPARATOR("item_separator"),
    JAVASCRIPT("javascript"),
    KEYWORD("keyword"),
    KEY_VALUE_SEPARATOR("key_value_separator"),
    LABEL("label"),
    LANGUAGE("language"),
    LIMIT("limit"),
    LINK("link"),
    LINK_BY_POST("link_by_post"),
    LINK_ID("link_id"),
    LIVE_ONLY("live_only"),
    LOCAL_GIF_PATH("local_gif_path"),
    LOCATION("location"),
    MAP("map"),
    MAX("max"),
    METRIC("metric"),
    MIN("min"),
    NAME("name"),
    NAMESPACE_CODE("namespace_code"),
    NAMESPACE_ID("namespace_id"),
    NAMESPACE_VALUE("namespace_value"),
    NONINTERACTION("noninteraction"),
    NOT_DEFAULT_MACRO("not_default_macro"),
    NO_PADDING("no_padding"),
    NUMBER("number"),
    OPTOUT("optout"),
    ORDER("order"),
    ORDER_ID("order_id"),
    ORDER_VALUE("order_value"),
    ORDINAL("ordinal"),
    ORGANIC("organic"),
    OUTPUT_FORMAT("output_format"),
    PAGE("page"),
    PAGE_PATH("page_path"),
    PARTITION("partition"),
    PIXEL("pixel"),
    PLATFORM("platform"),
    PRICES("prices"),
    PRIORITY("priority"),
    PRODUCT("product"),
    PRODUCT_ID("product_id"),
    PRODUCT_IDS("product_ids"),
    PUSH_AFTER_EVALUATE("push_after_evaluate"),
    QUANTITY("quantity"),
    QUERY_KEY("query_key"),
    REFERRER("referrer"),
    REFERRER_OVERRIDE("referrer_override"),
    REVENUE("revenue"),
    SAMPLE_RATE("sample_rate"),
    SEND_HITS_TO_GOOGLE("send_hits_to_google"),
    SERVER_SIDE("server_side"),
    SESSION_CONTROL("session_control"),
    SESSION_COOKIE_TIMEOUT("session_cookie_timeout"),
    SITE_SPEED_SAMPLE_RATE("site_speed_sample_rate"),
    SOCIAL_ACTION("social_action"),
    SOCIAL_ACTION_TARGET("social_action_target"),
    SOCIAL_NETWORK("social_network"),
    SOCIAL_USE_DATA_LAYER("social_use_data_layer"),
    STANDARD_INDUSTRIAL_CLASSIFICATION("standard_industrial_classification"),
    STRIP_WWW("strip_www"),
    TAG_ID("tag_id"),
    TARGET_URL("target_url"),
    TIMING_CATEGORY("timing_category"),
    TIMING_LABEL("timing_label"),
    TIMING_SAMPLE_RATE("timing_sample_rate"),
    TIMING_VALUE("timing_value"),
    TIMING_VAR("timing_var"),
    TITLE("title"),
    TRACKER_NAME("tracker_name"),
    TRACK_APPVIEW("track_appview"),
    TRACK_DATA("track_data"),
    TRACK_EVENT("track_event"),
    TRACK_EXCEPTION("track_exception"),
    TRACK_SOCIAL("track_social"),
    TRACK_TIMING("track_timing"),
    TRACK_TRANSACTION("track_transaction"),
    TRANSACTION_DATALAYER_MAP("transaction_datalayer_map"),
    TRANSACTION_ID("transaction_id"),
    TRANSACTION_ITEM_DATALAYER_MAP("transaction_item_datalayer_map"),
    TRANSACTION_VARIABLE("transaction_variable"),
    TYPE("type"),
    UNREPEATABLE("unrepeatable"),
    URL("url"),
    USER_ID("user_id"),
    USER_VARIABLE("user_variable"),
    USE_DATA_LAYER("use_data_layer"),
    USE_HASH("use_hash"),
    USE_IFRAME("use_iframe"),
    USE_IMAGE_TAG("use_image_tag"),
    USE_POSTSCRIBE("use_postscribe"),
    VALUE("value"),
    VALUE_IN_DOLLARS("value_in_dollars"),
    VISITOR_COOKIE_TIMEOUT("visitor_cookie_timeout"),
    WAIT_FOR_TAGS("wait_for_tags"),
    WAIT_FOR_TAGS_TIMEOUT("wait_for_tags_timeout"),
    WIDGET_IDS("widget_ids");

    // $FF: renamed from: id java.lang.String
    private final String field_4010;

    static {
        Key[] var0 = new Key[]{ACCOUNT, ACTIVITY, ADDITIONAL_PARAMS, ADVERTISER, ALGORITHM, ALLOW_ANCHOR, ALLOW_HASH, ALLOW_LINKER, ANALYTICS_FIELDS, ANALYTICS_PASS_THROUGH, ANONYMIZE_IP, APP_NAME, APP_VERSION, ARG0, ARG1, ATTRIBUTE, AUTO_LINK_DOMAINS, CACHE_BUSTER, CACHE_BUSTER_VALUE, CAMPAIGN_CONTENT_KEY, CAMPAIGN_CONTENT_OVERRIDE, CAMPAIGN_COOKIE_TIMEOUT, CAMPAIGN_MEDIUM_KEY, CAMPAIGN_MEDIUM_OVERRIDE, CAMPAIGN_NAME_KEY, CAMPAIGN_NAME_OVERRIDE, CAMPAIGN_NO_KEY, CAMPAIGN_SOURCE_KEY, CAMPAIGN_SOURCE_OVERRIDE, CAMPAIGN_TERM_KEY, CAMPAIGN_TERM_OVERRIDE, CAMPAIGN_TRACK, CATEGORY, CHECK_VALIDATION, CLEAR_PERSISTENT_DATA_LAYER_PREFIX, CLICK_ID, CLIENT_INFO, COMPANY, COMPONENT, CONTENT_DESCRIPTION, CONTENT_GROUP, CONVERSION_ID, COOKIE_DOMAIN, COOKIE_EXPIRATION, COOKIE_NAME, COOKIE_PATH, COOKIE_PATH_COPY, COUNTRY, CURRENCY_CODE, CUSTOM_VARS, CUSTOMER_ID, DATA_LAYER_VERSION, DATA_PROVIDER_ID, DEBUG, DECORATE_FORM, DECORATE_FORMS_AUTO_LINK, DECORATE_LINK, DEFAULT_PAGES, DEFAULT_VALUE, DEPENDENCIES, DETECT_FLASH, DETECT_TITLE, DIMENSION, DOMAIN_NAME, DOUBLE_CLICK, ECOMMERCE_MACRO_DATA, ECOMMERCE_USE_DATA_LAYER, ELEMENT, EMAIL, EMPLOYEE_RANGE, ENABLE_ECOMMERCE, ESCAPE, EVENT_ACTION, EVENT_CATEGORY, EVENT_LABEL, EVENT_VALUE, EXCEPTION_DESCRIPTION, EXCEPTION_FATAL, FIELDS_TO_SET, FORCE_SSL, FORM_OBJECT, FUNCTION, FUNCTION_CALL_NAME, GROUP, GTM_ON_SUCCESS, GTM_ON_FAILURE, HIT_CALLBACK, HTML, field_4009, IGNORED_ORGANIC, IGNORED_REF, IGNORE_CASE, INPUT, INPUT_FORMAT, INSTANCE_NAME, INSTANCE_LABEL, INTERVAL, ITEM_SEPARATOR, JAVASCRIPT, KEYWORD, KEY_VALUE_SEPARATOR, LABEL, LANGUAGE, LIMIT, LINK, LINK_BY_POST, LINK_ID, LIVE_ONLY, LOCAL_GIF_PATH, LOCATION, MAP, MAX, MIN, METRIC, NAME, NAMESPACE_CODE, NAMESPACE_ID, NAMESPACE_VALUE, NONINTERACTION, NOT_DEFAULT_MACRO, NO_PADDING, NUMBER, OPTOUT, ORDER, ORDER_ID, ORDER_VALUE, ORDINAL, ORGANIC, OUTPUT_FORMAT, PAGE, PAGE_PATH, PARTITION, PIXEL, PLATFORM, PRICES, PRIORITY, PRODUCT, PRODUCT_ID, PRODUCT_IDS, PUSH_AFTER_EVALUATE, QUANTITY, QUERY_KEY, REFERRER, REFERRER_OVERRIDE, REVENUE, SAMPLE_RATE, SEND_HITS_TO_GOOGLE, SESSION_CONTROL, SESSION_COOKIE_TIMEOUT, SITE_SPEED_SAMPLE_RATE, SOCIAL_ACTION, SOCIAL_ACTION_TARGET, SOCIAL_NETWORK, SOCIAL_USE_DATA_LAYER, SERVER_SIDE, STANDARD_INDUSTRIAL_CLASSIFICATION, STRIP_WWW, TAG_ID, TARGET_URL, TIMING_CATEGORY, TIMING_LABEL, TIMING_SAMPLE_RATE, TIMING_VALUE, TIMING_VAR, TITLE, TRACK_APPVIEW, TRACK_DATA, TRACK_EVENT, TRACK_EXCEPTION, TRACK_SOCIAL, TRACK_TIMING, TRACK_TRANSACTION, TRACKER_NAME, TRANSACTION_DATALAYER_MAP, TRANSACTION_ID, TRANSACTION_ITEM_DATALAYER_MAP, TRANSACTION_VARIABLE, TYPE, UNREPEATABLE, URL, USE_DATA_LAYER, USE_HASH, USE_IFRAME, USE_IMAGE_TAG, USE_POSTSCRIBE, USER_ID, USER_VARIABLE, VALUE, VALUE_IN_DOLLARS, VISITOR_COOKIE_TIMEOUT, WAIT_FOR_TAGS, WAIT_FOR_TAGS_TIMEOUT, WIDGET_IDS};
    }

    private Key(String var3) {
        this.field_4010 = var3;
    }

    public String toString() {
        return this.field_4010;
    }
}