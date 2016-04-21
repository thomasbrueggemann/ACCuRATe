package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.analytics.tracking.android.Tracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.DataLayer;
import com.google.tagmanager.Log;
import com.google.tagmanager.TrackerProvider;
import com.google.tagmanager.TrackingTag;
import com.google.tagmanager.Types;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

class UniversalAnalyticsTag extends TrackingTag {
    private static final String ACCOUNT;
    private static final String ANALYTICS_FIELDS;
    private static final String ANALYTICS_PASS_THROUGH;
    private static final String DEFAULT_TRACKING_ID = "_GTM_DEFAULT_TRACKER_";
    // $FF: renamed from: ID java.lang.String
    private static final String field_753;
    private static final String TRACK_TRANSACTION;
    private static final String TRANSACTION_DATALAYER_MAP;
    private static final String TRANSACTION_ITEM_DATALAYER_MAP;
    private static Map<String, String> defaultItemMap;
    private static Map<String, String> defaultTransactionMap;
    private final DataLayer mDataLayer;
    private final TrackerProvider mTrackerProvider;
    private final Set<String> mTurnOffAnonymizeIpValues;

    static {
        field_753 = FunctionType.UNIVERSAL_ANALYTICS.toString();
        ACCOUNT = Key.ACCOUNT.toString();
        ANALYTICS_PASS_THROUGH = Key.ANALYTICS_PASS_THROUGH.toString();
        ANALYTICS_FIELDS = Key.ANALYTICS_FIELDS.toString();
        TRACK_TRANSACTION = Key.TRACK_TRANSACTION.toString();
        TRANSACTION_DATALAYER_MAP = Key.TRANSACTION_DATALAYER_MAP.toString();
        TRANSACTION_ITEM_DATALAYER_MAP = Key.TRANSACTION_ITEM_DATALAYER_MAP.toString();
    }

    public UniversalAnalyticsTag(Context var1, DataLayer var2) {
        this(var1, var2, new TrackerProvider(var1));
    }

    @VisibleForTesting
    UniversalAnalyticsTag(Context var1, DataLayer var2, TrackerProvider var3) {
        super(field_753, new String[0]);
        this.mDataLayer = var2;
        this.mTrackerProvider = var3;
        this.mTurnOffAnonymizeIpValues = new HashSet();
        this.mTurnOffAnonymizeIpValues.add("");
        this.mTurnOffAnonymizeIpValues.add("0");
        this.mTurnOffAnonymizeIpValues.add("false");
    }

    private void addParam(Map<String, String> var1, String var2, String var3) {
        if(var3 != null) {
            var1.put(var2, var3);
        }

    }

    private boolean checkBooleanProperty(Map<String, TypeSystem.Value> var1, String var2) {
        TypeSystem.Value var3 = (TypeSystem.Value)var1.get(var2);
        return var3 == null?false:Types.valueToBoolean(var3).booleanValue();
    }

    private Map<String, String> convertToGaFields(TypeSystem.Value var1) {
        Object var2;
        if(var1 == null) {
            var2 = new HashMap();
        } else {
            var2 = this.valueToMap(var1);
            if(var2 == null) {
                return new HashMap();
            }

            String var3 = (String)((Map)var2).get("&aip");
            if(var3 != null && this.mTurnOffAnonymizeIpValues.contains(var3.toLowerCase())) {
                ((Map)var2).remove("&aip");
                return (Map)var2;
            }
        }

        return (Map)var2;
    }

    private String getDataLayerString(String var1) {
        Object var2 = this.mDataLayer.get(var1);
        return var2 == null?null:var2.toString();
    }

    public static String getFunctionId() {
        return field_753;
    }

    private Map<String, String> getTransactionFields(Map<String, TypeSystem.Value> var1) {
        TypeSystem.Value var2 = (TypeSystem.Value)var1.get(TRANSACTION_DATALAYER_MAP);
        if(var2 != null) {
            return this.valueToMap(var2);
        } else {
            if(defaultTransactionMap == null) {
                HashMap var3 = new HashMap();
                var3.put("transactionId", "&ti");
                var3.put("transactionAffiliation", "&ta");
                var3.put("transactionTax", "&tt");
                var3.put("transactionShipping", "&ts");
                var3.put("transactionTotal", "&tr");
                var3.put("transactionCurrency", "&cu");
                defaultTransactionMap = var3;
            }

            return defaultTransactionMap;
        }
    }

    private Map<String, String> getTransactionItemFields(Map<String, TypeSystem.Value> var1) {
        TypeSystem.Value var2 = (TypeSystem.Value)var1.get(TRANSACTION_ITEM_DATALAYER_MAP);
        if(var2 != null) {
            return this.valueToMap(var2);
        } else {
            if(defaultItemMap == null) {
                HashMap var3 = new HashMap();
                var3.put("name", "&in");
                var3.put("sku", "&ic");
                var3.put("category", "&iv");
                var3.put("price", "&ip");
                var3.put("quantity", "&iq");
                var3.put("currency", "&cu");
                defaultItemMap = var3;
            }

            return defaultItemMap;
        }
    }

    private List<Map<String, String>> getTransactionItems() {
        Object var1 = this.mDataLayer.get("transactionProducts");
        if(var1 == null) {
            return null;
        } else if(!(var1 instanceof List)) {
            throw new IllegalArgumentException("transactionProducts should be of type List.");
        } else {
            Iterator var2 = ((List)var1).iterator();

            do {
                if(!var2.hasNext()) {
                    return (List)var1;
                }
            } while(var2.next() instanceof Map);

            throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
        }
    }

    private void sendTransaction(Tracker param1, Map<String, TypeSystem.Value> param2) {
        // $FF: Couldn't be decompiled
    }

    private Map<String, String> valueToMap(TypeSystem.Value var1) {
        Object var2 = Types.valueToObject(var1);
        LinkedHashMap var4;
        if(!(var2 instanceof Map)) {
            var4 = null;
        } else {
            Map var3 = (Map)var2;
            var4 = new LinkedHashMap();
            Iterator var5 = var3.entrySet().iterator();

            while(var5.hasNext()) {
                Entry var6 = (Entry)var5.next();
                var4.put(var6.getKey().toString(), var6.getValue().toString());
            }
        }

        return var4;
    }

    public void evaluateTrackingTag(Map<String, TypeSystem.Value> var1) {
        Tracker var2 = this.mTrackerProvider.getTracker("_GTM_DEFAULT_TRACKER_");
        if(this.checkBooleanProperty(var1, ANALYTICS_PASS_THROUGH)) {
            var2.send(this.convertToGaFields((TypeSystem.Value)var1.get(ANALYTICS_FIELDS)));
        } else if(this.checkBooleanProperty(var1, TRACK_TRANSACTION)) {
            this.sendTransaction(var2, var1);
        } else {
            Log.method_5509("Ignoring unknown tag.");
        }

        this.mTrackerProvider.close(var2);
    }
}
