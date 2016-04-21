package com.google.analytics.tracking.android;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.SortedSet;
import java.util.TreeSet;

class GAUsage {
    private static final String BASE_64_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";
    private static final GAUsage INSTANCE = new GAUsage();
    private boolean mDisableUsage = false;
    private StringBuilder mSequence = new StringBuilder();
    private SortedSet<GAUsage.Field> mUsedFields = new TreeSet();

    public static GAUsage getInstance() {
        return INSTANCE;
    }

    @VisibleForTesting
    static GAUsage getPrivateInstance() {
        return new GAUsage();
    }

    public String getAndClearSequence() {
        synchronized(this) {}

        String var2;
        try {
            if(this.mSequence.length() > 0) {
                this.mSequence.insert(0, ".");
            }

            var2 = this.mSequence.toString();
            this.mSequence = new StringBuilder();
        } finally {
            ;
        }

        return var2;
    }

    public String getAndClearUsage() {
        // $FF: Couldn't be decompiled
    }

    public void setDisableUsage(boolean var1) {
        synchronized(this) {}

        try {
            this.mDisableUsage = var1;
        } finally {
            ;
        }

    }

    public void setUsage(GAUsage.Field var1) {
        synchronized(this) {}

        try {
            if(!this.mDisableUsage) {
                this.mUsedFields.add(var1);
                this.mSequence.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(var1.ordinal()));
            }
        } finally {
            ;
        }

    }

    public static enum Field {
        BLANK_04,
        BLANK_05,
        BLANK_06,
        BLANK_07,
        BLANK_08,
        BLANK_12,
        BLANK_13,
        BLANK_14,
        BLANK_15,
        BLANK_16,
        BLANK_17,
        BLANK_18,
        BLANK_19,
        BLANK_20,
        BLANK_21,
        BLANK_22,
        BLANK_23,
        BLANK_24,
        BLANK_25,
        BLANK_26,
        BLANK_27,
        BLANK_28,
        BLANK_29,
        BLANK_37,
        BLANK_38,
        BLANK_46,
        BLANK_52,
        BLANK_53,
        CLOSE_TRACKER,
        CONSTRUCT_APP_VIEW,
        CONSTRUCT_EVENT,
        CONSTRUCT_EXCEPTION,
        CONSTRUCT_ITEM,
        CONSTRUCT_RAW_EXCEPTION,
        CONSTRUCT_SOCIAL,
        CONSTRUCT_TIMING,
        CONSTRUCT_TRANSACTION,
        DISPATCH,
        EASY_TRACKER_ACTIVITY_START,
        EASY_TRACKER_ACTIVITY_STOP,
        GET,
        GET_APP_OPT_OUT,
        GET_DEFAULT_TRACKER,
        GET_DRY_RUN,
        GET_EXCEPTION_PARSER,
        GET_TRACKER,
        GET_TRACKER_NAME,
        MAP_BUILDER_GET,
        MAP_BUILDER_SET,
        MAP_BUILDER_SET_ALL,
        MAP_BUILDER_SET_CAMPAIGN_PARAMS,
        REPORT_UNCAUGHT_EXCEPTIONS,
        SEND,
        SET,
        SET_APP_OPT_OUT,
        SET_AUTO_ACTIVITY_TRACKING,
        SET_DEFAULT_TRACKER,
        SET_DISPATCH_PERIOD,
        SET_DRY_RUN,
        SET_EXCEPTION_PARSER,
        SET_FORCE_LOCAL_DISPATCH,
        SET_LOGGER,
        SET_SESSION_TIMEOUT;

        static {
            GAUsage.Field[] var0 = new GAUsage.Field[]{MAP_BUILDER_SET, MAP_BUILDER_SET_ALL, MAP_BUILDER_GET, MAP_BUILDER_SET_CAMPAIGN_PARAMS, BLANK_04, BLANK_05, BLANK_06, BLANK_07, BLANK_08, GET, SET, SEND, BLANK_12, BLANK_13, BLANK_14, BLANK_15, BLANK_16, BLANK_17, BLANK_18, BLANK_19, BLANK_20, BLANK_21, BLANK_22, BLANK_23, BLANK_24, BLANK_25, BLANK_26, BLANK_27, BLANK_28, BLANK_29, SET_EXCEPTION_PARSER, GET_EXCEPTION_PARSER, CONSTRUCT_TRANSACTION, CONSTRUCT_EXCEPTION, CONSTRUCT_RAW_EXCEPTION, CONSTRUCT_TIMING, CONSTRUCT_SOCIAL, BLANK_37, BLANK_38, GET_TRACKER, GET_DEFAULT_TRACKER, SET_DEFAULT_TRACKER, SET_APP_OPT_OUT, GET_APP_OPT_OUT, DISPATCH, SET_DISPATCH_PERIOD, BLANK_46, REPORT_UNCAUGHT_EXCEPTIONS, SET_AUTO_ACTIVITY_TRACKING, SET_SESSION_TIMEOUT, CONSTRUCT_EVENT, CONSTRUCT_ITEM, BLANK_52, BLANK_53, SET_DRY_RUN, GET_DRY_RUN, SET_LOGGER, SET_FORCE_LOCAL_DISPATCH, GET_TRACKER_NAME, CLOSE_TRACKER, EASY_TRACKER_ACTIVITY_START, EASY_TRACKER_ACTIVITY_STOP, CONSTRUCT_APP_VIEW};
        }
    }
}
