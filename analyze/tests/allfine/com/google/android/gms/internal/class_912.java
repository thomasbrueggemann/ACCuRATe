package com.google.android.gms.internal;

import com.google.android.gms.internal.class_310;
import com.google.android.gms.internal.pd;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.pc
public final class class_912 {
    // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.pd$a$a[]) int
    private static int method_4732(String var0, class_310.class_1227[] var1) {
        int var2 = var1.length;
        int var3 = 0;

        int var4;
        for(var4 = 14; var3 < var2; ++var3) {
            class_310.class_1227 var5 = var1[var3];
            if(var4 == 14) {
                if(var5.type != 9 && var5.type != 2 && var5.type != 6) {
                    if(var5.type != 14) {
                        throw new IllegalArgumentException("Unexpected TypedValue type: " + var5.type + " for key " + var0);
                    }
                } else {
                    var4 = var5.type;
                }
            } else if(var5.type != var4) {
                throw new IllegalArgumentException("The ArrayList elements should all be the same type, but ArrayList with key " + var0 + " contains items of type " + var4 + " and " + var5.type);
            }
        }

        return var4;
    }

    // $FF: renamed from: a (java.util.List, com.google.android.gms.wearable.Asset) int
    static int method_4733(List<Asset> var0, Asset var1) {
        var0.add(var1);
        return -1 + var0.size();
    }

    // $FF: renamed from: a (com.google.android.gms.wearable.DataMap) com.google.android.gms.internal.pc$a
    public static class_912.class_1371 method_4734(DataMap var0) {
        class_310 var1 = new class_310();
        ArrayList var2 = new ArrayList();
        var1.awd = method_4739(var0, var2);
        return new class_912.class_1371(var1, var2);
    }

    // $FF: renamed from: a (java.util.List, java.lang.Object) com.google.android.gms.internal.pd$a$a
    private static class_310.class_1227 method_4735(List<Asset> var0, Object var1) {
        class_310.class_1227 var2 = new class_310.class_1227();
        if(var1 == null) {
            var2.type = 14;
            return var2;
        } else {
            var2.awh = new class_310.class_1228();
            if(var1 instanceof String) {
                var2.type = 2;
                var2.awh.awj = (String)var1;
            } else if(var1 instanceof Integer) {
                var2.type = 6;
                var2.awh.awn = ((Integer)var1).intValue();
            } else if(var1 instanceof Long) {
                var2.type = 5;
                var2.awh.awm = ((Long)var1).longValue();
            } else if(var1 instanceof Double) {
                var2.type = 3;
                var2.awh.awk = ((Double)var1).doubleValue();
            } else if(var1 instanceof Float) {
                var2.type = 4;
                var2.awh.awl = ((Float)var1).floatValue();
            } else if(var1 instanceof Boolean) {
                var2.type = 8;
                var2.awh.awp = ((Boolean)var1).booleanValue();
            } else if(var1 instanceof Byte) {
                var2.type = 7;
                var2.awh.awo = ((Byte)var1).byteValue();
            } else if(var1 instanceof byte[]) {
                var2.type = 1;
                var2.awh.awi = (byte[])((byte[])var1);
            } else if(var1 instanceof String[]) {
                var2.type = 11;
                var2.awh.aws = (String[])((String[])var1);
            } else if(var1 instanceof long[]) {
                var2.type = 12;
                var2.awh.awt = (long[])((long[])var1);
            } else if(var1 instanceof float[]) {
                var2.type = 15;
                var2.awh.awu = (float[])((float[])var1);
            } else if(var1 instanceof Asset) {
                var2.type = 13;
                var2.awh.awv = (long)method_4733(var0, (Asset)var1);
            } else if(var1 instanceof DataMap) {
                var2.type = 9;
                DataMap var12 = (DataMap)var1;
                Set var13 = var12.keySet();
                class_310.class_1226[] var14 = new class_310.class_1226[var13.size()];
                Iterator var15 = var13.iterator();

                for(int var16 = 0; var15.hasNext(); ++var16) {
                    String var17 = (String)var15.next();
                    var14[var16] = new class_310.class_1226();
                    var14[var16].name = var17;
                    var14[var16].awf = method_4735(var0, var12.get(var17));
                }

                var2.awh.awq = var14;
            } else {
                if(!(var1 instanceof ArrayList)) {
                    throw new RuntimeException("newFieldValueFromValue: unexpected value " + var1.getClass().getSimpleName());
                }

                var2.type = 10;
                ArrayList var3 = (ArrayList)var1;
                class_310.class_1227[] var4 = new class_310.class_1227[var3.size()];
                Object var5 = null;
                int var6 = var3.size();
                int var7 = 0;

                Object var9;
                for(int var8 = 14; var7 < var6; var5 = var9) {
                    var9 = var3.get(var7);
                    class_310.class_1227 var10 = method_4735(var0, var9);
                    if(var10.type != 14 && var10.type != 2 && var10.type != 6 && var10.type != 9) {
                        throw new IllegalArgumentException("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + var9.getClass());
                    }

                    int var11;
                    if(var8 == 14 && var10.type != 14) {
                        var11 = var10.type;
                    } else {
                        if(var10.type != var8) {
                            throw new IllegalArgumentException("ArrayList elements must all be of the sameclass, but this one contains a " + var5.getClass() + " and a " + var9.getClass());
                        }

                        var9 = var5;
                        var11 = var8;
                    }

                    var4[var7] = var10;
                    ++var7;
                    var8 = var11;
                }

                var2.awh.awr = var4;
            }

            return var2;
        }
    }

    // $FF: renamed from: a (com.google.android.gms.internal.pc$a) com.google.android.gms.wearable.DataMap
    public static DataMap method_4736(class_912.class_1371 var0) {
        DataMap var1 = new DataMap();
        class_310.class_1226[] var2 = var0.awb.awd;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            class_310.class_1226 var5 = var2[var4];
            method_4738(var0.awc, var1, var5.name, var5.awf);
        }

        return var1;
    }

    // $FF: renamed from: a (java.util.List, com.google.android.gms.internal.pd$a$a$a, int) java.util.ArrayList
    private static ArrayList method_4737(List<Asset> var0, class_310.class_1228 var1, int var2) {
        ArrayList var3 = new ArrayList(var1.awr.length);
        class_310.class_1227[] var4 = var1.awr;
        int var5 = var4.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            class_310.class_1227 var7 = var4[var6];
            if(var7.type == 14) {
                var3.add((Object)null);
            } else if(var2 != 9) {
                if(var2 == 2) {
                    var3.add(var7.awh.awj);
                } else {
                    if(var2 != 6) {
                        throw new IllegalArgumentException("Unexpected typeOfArrayList: " + var2);
                    }

                    var3.add(Integer.valueOf(var7.awh.awn));
                }
            } else {
                DataMap var8 = new DataMap();
                class_310.class_1226[] var9 = var7.awh.awq;
                int var10 = var9.length;

                for(int var11 = 0; var11 < var10; ++var11) {
                    class_310.class_1226 var13 = var9[var11];
                    method_4738(var0, var8, var13.name, var13.awf);
                }

                var3.add(var8);
            }
        }

        return var3;
    }

    // $FF: renamed from: a (java.util.List, com.google.android.gms.wearable.DataMap, java.lang.String, com.google.android.gms.internal.pd$a$a) void
    private static void method_4738(List<Asset> var0, DataMap var1, String var2, class_310.class_1227 var3) {
        int var4 = var3.type;
        if(var4 == 14) {
            var1.putString(var2, (String)null);
        } else {
            class_310.class_1228 var5 = var3.awh;
            if(var4 == 1) {
                var1.putByteArray(var2, var5.awi);
            } else if(var4 == 11) {
                var1.putStringArray(var2, var5.aws);
            } else if(var4 == 12) {
                var1.putLongArray(var2, var5.awt);
            } else if(var4 == 15) {
                var1.putFloatArray(var2, var5.awu);
            } else if(var4 == 2) {
                var1.putString(var2, var5.awj);
            } else if(var4 == 3) {
                var1.putDouble(var2, var5.awk);
            } else if(var4 == 4) {
                var1.putFloat(var2, var5.awl);
            } else if(var4 == 5) {
                var1.putLong(var2, var5.awm);
            } else if(var4 == 6) {
                var1.putInt(var2, var5.awn);
            } else if(var4 == 7) {
                var1.putByte(var2, (byte)var5.awo);
            } else if(var4 == 8) {
                var1.putBoolean(var2, var5.awp);
            } else if(var4 == 13) {
                if(var0 == null) {
                    throw new RuntimeException("populateBundle: unexpected type for: " + var2);
                } else {
                    var1.putAsset(var2, (Asset)var0.get((int)var5.awv));
                }
            } else if(var4 != 9) {
                if(var4 == 10) {
                    int var11 = method_4732(var2, var5.awr);
                    ArrayList var12 = method_4737(var0, var5, var11);
                    if(var11 == 14) {
                        var1.putStringArrayList(var2, var12);
                    } else if(var11 == 9) {
                        var1.putDataMapArrayList(var2, var12);
                    } else if(var11 == 2) {
                        var1.putStringArrayList(var2, var12);
                    } else if(var11 == 6) {
                        var1.putIntegerArrayList(var2, var12);
                    } else {
                        throw new IllegalStateException("Unexpected typeOfArrayList: " + var11);
                    }
                } else {
                    throw new RuntimeException("populateBundle: unexpected type " + var4);
                }
            } else {
                DataMap var6 = new DataMap();
                class_310.class_1226[] var7 = var5.awq;
                int var8 = var7.length;

                for(int var9 = 0; var9 < var8; ++var9) {
                    class_310.class_1226 var10 = var7[var9];
                    method_4738(var0, var6, var10.name, var10.awf);
                }

                var1.putDataMap(var2, var6);
            }
        }
    }

    // $FF: renamed from: a (com.google.android.gms.wearable.DataMap, java.util.List) com.google.android.gms.internal.pd$a[]
    private static class_310.class_1226[] method_4739(DataMap var0, List<Asset> var1) {
        Set var2 = var0.keySet();
        class_310.class_1226[] var3 = new class_310.class_1226[var2.size()];
        Iterator var4 = var2.iterator();

        for(int var5 = 0; var4.hasNext(); ++var5) {
            String var6 = (String)var4.next();
            Object var7 = var0.get(var6);
            var3[var5] = new class_310.class_1226();
            var3[var5].name = var6;
            var3[var5].awf = method_4735(var1, var7);
        }

        return var3;
    }

    public static class class_1371 {
        public final class_310 awb;
        public final List<Asset> awc;

        public class_1371(pd var1, List<Asset> var2) {
            this.awb = var1;
            this.awc = var2;
        }
    }
}
