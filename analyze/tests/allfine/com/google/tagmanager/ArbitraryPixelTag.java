package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.DelayedHitSender;
import com.google.tagmanager.HitSender;
import com.google.tagmanager.TrackingTag;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class ArbitraryPixelTag extends TrackingTag {
    private static final String ADDITIONAL_PARAMS;
    static final String ARBITRARY_PIXEL_UNREPEATABLE;
    // $FF: renamed from: ID java.lang.String
    private static final String field_755;
    private static final String UNREPEATABLE;
    private static final String URL;
    private static final Set<String> unrepeatableIds;
    private final Context mContext;
    private final ArbitraryPixelTag.HitSenderProvider mHitSenderProvider;

    static {
        field_755 = FunctionType.ARBITRARY_PIXEL.toString();
        URL = Key.URL.toString();
        ADDITIONAL_PARAMS = Key.ADDITIONAL_PARAMS.toString();
        UNREPEATABLE = Key.UNREPEATABLE.toString();
        ARBITRARY_PIXEL_UNREPEATABLE = "gtm_" + field_755 + "_unrepeatable";
        unrepeatableIds = new HashSet();
    }

    public ArbitraryPixelTag(final Context var1) {
        this(var1, new ArbitraryPixelTag.HitSenderProvider() {
            public HitSender get() {
                return DelayedHitSender.getInstance(var1);
            }
        });
    }

    @VisibleForTesting
    ArbitraryPixelTag(Context var1, ArbitraryPixelTag.HitSenderProvider var2) {
        String var3 = field_755;
        String[] var4 = new String[] {URL};
        super(var3, var4);
        this.mHitSenderProvider = var2;
        this.mContext = var1;
    }

    public static String getFunctionId() {
        return field_755;
    }

    private boolean idProcessed(String param1) {
        // $FF: Couldn't be decompiled
    }

    @VisibleForTesting
    void clearCache() {
        unrepeatableIds.clear();
    }

    public void evaluateTrackingTag(Map<String, TypeSystem.Value> param1) {
        // $FF: Couldn't be decompiled
    }

    @VisibleForTesting
    boolean idInCache(String var1) {
        return unrepeatableIds.contains(var1);
    }

    @VisibleForTesting
    boolean idInSharedPreferences(String var1) {
        return this.mContext.getSharedPreferences(ARBITRARY_PIXEL_UNREPEATABLE, 0).contains(var1);
    }

    public interface HitSenderProvider {
        HitSender get();
    }
}
