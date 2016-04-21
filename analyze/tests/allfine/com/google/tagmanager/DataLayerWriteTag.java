package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.DataLayer;
import com.google.tagmanager.TrackingTag;
import com.google.tagmanager.Types;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class DataLayerWriteTag extends TrackingTag {
    private static final String CLEAR_PERSISTENT_DATA_LAYER_PREFIX;
    // $FF: renamed from: ID java.lang.String
    private static final String field_754;
    private static final String VALUE;
    private final DataLayer mDataLayer;

    static {
        field_754 = FunctionType.DATA_LAYER_WRITE.toString();
        VALUE = Key.VALUE.toString();
        CLEAR_PERSISTENT_DATA_LAYER_PREFIX = Key.CLEAR_PERSISTENT_DATA_LAYER_PREFIX.toString();
    }

    public DataLayerWriteTag(DataLayer var1) {
        String var2 = field_754;
        String[] var3 = new String[] {VALUE};
        super(var2, var3);
        this.mDataLayer = var1;
    }

    private void clearPersistent(TypeSystem.Value var1) {
        if(var1 != null && var1 != Types.getDefaultObject()) {
            String var2 = Types.valueToString(var1);
            if(var2 != Types.getDefaultString()) {
                this.mDataLayer.clearPersistentKeysWithPrefix(var2);
                return;
            }
        }

    }

    public static String getFunctionId() {
        return field_754;
    }

    private void pushToDataLayer(TypeSystem.Value var1) {
        if(var1 != null && var1 != Types.getDefaultObject()) {
            Object var2 = Types.valueToObject(var1);
            if(var2 instanceof List) {
                Iterator var3 = ((List)var2).iterator();

                while(var3.hasNext()) {
                    Object var4 = var3.next();
                    if(var4 instanceof Map) {
                        Map var5 = (Map)var4;
                        this.mDataLayer.push(var5);
                    }
                }
            }
        }

    }

    public void evaluateTrackingTag(Map<String, TypeSystem.Value> var1) {
        this.pushToDataLayer((TypeSystem.Value)var1.get(VALUE));
        this.clearPersistent((TypeSystem.Value)var1.get(CLEAR_PERSISTENT_DATA_LAYER_PREFIX));
    }
}
