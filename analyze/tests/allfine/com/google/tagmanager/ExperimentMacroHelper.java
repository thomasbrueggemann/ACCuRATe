package com.google.tagmanager;

import com.google.analytics.containertag.proto.Serving;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.DataLayer;
import com.google.tagmanager.Log;
import com.google.tagmanager.Types;
import java.util.Map;

public class ExperimentMacroHelper {
    private static void clearKeys(DataLayer var0, Serving.GaExperimentSupplemental var1) {
        TypeSystem.Value[] var2 = var1.valueToClear;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            var0.clearPersistentKeysWithPrefix(Types.valueToString(var2[var4]));
        }

    }

    public static void handleExperimentSupplemental(DataLayer var0, Serving.Supplemental var1) {
        if(var1.experimentSupplemental == null) {
            Log.method_5509("supplemental missing experimentSupplemental");
        } else {
            clearKeys(var0, var1.experimentSupplemental);
            pushValues(var0, var1.experimentSupplemental);
            setRandomValues(var0, var1.experimentSupplemental);
        }
    }

    private static void pushValues(DataLayer var0, Serving.GaExperimentSupplemental var1) {
        TypeSystem.Value[] var2 = var1.valueToPush;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Map var5 = valueToMap(var2[var4]);
            if(var5 != null) {
                var0.push(var5);
            }
        }

    }

    private static void setRandomValues(DataLayer var0, Serving.GaExperimentSupplemental var1) {
        Serving.GaExperimentRandom[] var2 = var1.experimentRandom;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Serving.GaExperimentRandom var5 = var2[var4];
            if(var5.key == null) {
                Log.method_5509("GaExperimentRandom: No key");
            } else {
                Object var6 = var0.get(var5.key);
                Long var7;
                if(!(var6 instanceof Number)) {
                    var7 = null;
                } else {
                    var7 = Long.valueOf(((Number)var6).longValue());
                }

                long var8 = var5.minRandom;
                long var10 = var5.maxRandom;
                if(!var5.retainOriginalValue || var7 == null || var7.longValue() < var8 || var7.longValue() > var10) {
                    if(var8 > var10) {
                        Log.method_5509("GaExperimentRandom: random range invalid");
                        continue;
                    }

                    var6 = Long.valueOf(Math.round(Math.random() * (double)(var10 - var8) + (double)var8));
                }

                var0.clearPersistentKeysWithPrefix(var5.key);
                Map var12 = var0.expandKeyValue(var5.key, var6);
                if(var5.lifetimeInMilliseconds > 0L) {
                    if(!var12.containsKey("gtm")) {
                        Object[] var15 = new Object[] {"lifetime", Long.valueOf(var5.lifetimeInMilliseconds)};
                        var12.put("gtm", DataLayer.mapOf(var15));
                    } else {
                        Object var13 = var12.get("gtm");
                        if(var13 instanceof Map) {
                            ((Map)var13).put("lifetime", Long.valueOf(var5.lifetimeInMilliseconds));
                        } else {
                            Log.method_5509("GaExperimentRandom: gtm not a map");
                        }
                    }
                }

                var0.push(var12);
            }
        }

    }

    private static Map<Object, Object> valueToMap(TypeSystem.Value var0) {
        Object var1 = Types.valueToObject(var0);
        if(!(var1 instanceof Map)) {
            Log.method_5509("value: " + var1 + " is not a map value, ignored.");
            return null;
        } else {
            return (Map)var1;
        }
    }
}
