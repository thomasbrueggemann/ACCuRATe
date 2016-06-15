package com.google.android.gms.internal;

import com.google.android.gms.internal.class_249;
import com.google.android.gms.internal.lx;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.lw
public final class class_607 {
   // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.lx$a$a[]) int
   private static int method_3575(String var0, class_249.class_882[] var1) {
      int var2 = var1.length;
      int var3 = 0;

      int var4;
      for(var4 = 14; var3 < var2; ++var3) {
         class_249.class_882 var5 = var1[var3];
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
   static int method_3576(List<Asset> var0, Asset var1) {
      var0.add(var1);
      return -1 + var0.size();
   }

   // $FF: renamed from: a (com.google.android.gms.wearable.DataMap) com.google.android.gms.internal.lw$a
   public static class_607.class_831 method_3577(DataMap var0) {
      class_249 var1 = new class_249();
      ArrayList var2 = new ArrayList();
      var1.amo = method_3582(var0, var2);
      return new class_607.class_831(var1, var2);
   }

   // $FF: renamed from: a (java.util.List, java.lang.Object) com.google.android.gms.internal.lx$a$a
   private static class_249.class_882 method_3578(List<Asset> var0, Object var1) {
      class_249.class_882 var2 = new class_249.class_882();
      if(var1 == null) {
         var2.type = 14;
         return var2;
      } else {
         var2.ams = new class_249.class_883();
         if(var1 instanceof String) {
            var2.type = 2;
            var2.ams.amu = (String)var1;
         } else if(var1 instanceof Integer) {
            var2.type = 6;
            var2.ams.amy = ((Integer)var1).intValue();
         } else if(var1 instanceof Long) {
            var2.type = 5;
            var2.ams.amx = ((Long)var1).longValue();
         } else if(var1 instanceof Double) {
            var2.type = 3;
            var2.ams.amv = ((Double)var1).doubleValue();
         } else if(var1 instanceof Float) {
            var2.type = 4;
            var2.ams.amw = ((Float)var1).floatValue();
         } else if(var1 instanceof Boolean) {
            var2.type = 8;
            var2.ams.amA = ((Boolean)var1).booleanValue();
         } else if(var1 instanceof Byte) {
            var2.type = 7;
            var2.ams.amz = ((Byte)var1).byteValue();
         } else if(var1 instanceof byte[]) {
            var2.type = 1;
            var2.ams.amt = (byte[])((byte[])var1);
         } else if(var1 instanceof String[]) {
            var2.type = 11;
            var2.ams.amD = (String[])((String[])var1);
         } else if(var1 instanceof long[]) {
            var2.type = 12;
            var2.ams.amE = (long[])((long[])var1);
         } else if(var1 instanceof float[]) {
            var2.type = 15;
            var2.ams.amF = (float[])((float[])var1);
         } else if(var1 instanceof Asset) {
            var2.type = 13;
            var2.ams.amG = (long)method_3576(var0, (Asset)var1);
         } else if(var1 instanceof DataMap) {
            var2.type = 9;
            DataMap var12 = (DataMap)var1;
            Set var13 = var12.keySet();
            class_249.class_881[] var14 = new class_249.class_881[var13.size()];
            Iterator var15 = var13.iterator();

            for(int var16 = 0; var15.hasNext(); ++var16) {
               String var17 = (String)var15.next();
               var14[var16] = new class_249.class_881();
               var14[var16].name = var17;
               var14[var16].amq = method_3578(var0, var12.get(var17));
            }

            var2.ams.amB = var14;
         } else {
            if(!(var1 instanceof ArrayList)) {
               throw new RuntimeException("newFieldValueFromValue: unexpected value " + var1.getClass().getSimpleName());
            }

            var2.type = 10;
            ArrayList var3 = (ArrayList)var1;
            class_249.class_882[] var4 = new class_249.class_882[var3.size()];
            Object var5 = null;
            int var6 = var3.size();
            int var7 = 0;

            Object var9;
            for(int var8 = 14; var7 < var6; var5 = var9) {
               var9 = var3.get(var7);
               class_249.class_882 var10 = method_3578(var0, var9);
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

            var2.ams.amC = var4;
         }

         return var2;
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.lw$a) com.google.android.gms.wearable.DataMap
   public static DataMap method_3579(class_607.class_831 var0) {
      DataMap var1 = new DataMap();
      class_249.class_881[] var2 = var0.amm.amo;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         class_249.class_881 var5 = var2[var4];
         method_3581(var0.amn, var1, var5.name, var5.amq);
      }

      return var1;
   }

   // $FF: renamed from: a (java.util.List, com.google.android.gms.internal.lx$a$a$a, int) java.util.ArrayList
   private static ArrayList method_3580(List<Asset> var0, class_249.class_883 var1, int var2) {
      ArrayList var3 = new ArrayList(var1.amC.length);
      class_249.class_882[] var4 = var1.amC;
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         class_249.class_882 var7 = var4[var6];
         if(var7.type == 14) {
            var3.add((Object)null);
         } else if(var2 != 9) {
            if(var2 == 2) {
               var3.add(var7.ams.amu);
            } else {
               if(var2 != 6) {
                  throw new IllegalArgumentException("Unexpected typeOfArrayList: " + var2);
               }

               var3.add(Integer.valueOf(var7.ams.amy));
            }
         } else {
            DataMap var8 = new DataMap();
            class_249.class_881[] var9 = var7.ams.amB;
            int var10 = var9.length;

            for(int var11 = 0; var11 < var10; ++var11) {
               class_249.class_881 var13 = var9[var11];
               method_3581(var0, var8, var13.name, var13.amq);
            }

            var3.add(var8);
         }
      }

      return var3;
   }

   // $FF: renamed from: a (java.util.List, com.google.android.gms.wearable.DataMap, java.lang.String, com.google.android.gms.internal.lx$a$a) void
   private static void method_3581(List<Asset> var0, DataMap var1, String var2, class_249.class_882 var3) {
      int var4 = var3.type;
      if(var4 == 14) {
         var1.putString(var2, (String)null);
      } else {
         class_249.class_883 var5 = var3.ams;
         if(var4 == 1) {
            var1.putByteArray(var2, var5.amt);
         } else if(var4 == 11) {
            var1.putStringArray(var2, var5.amD);
         } else if(var4 == 12) {
            var1.putLongArray(var2, var5.amE);
         } else if(var4 == 15) {
            var1.putFloatArray(var2, var5.amF);
         } else if(var4 == 2) {
            var1.putString(var2, var5.amu);
         } else if(var4 == 3) {
            var1.putDouble(var2, var5.amv);
         } else if(var4 == 4) {
            var1.putFloat(var2, var5.amw);
         } else if(var4 == 5) {
            var1.putLong(var2, var5.amx);
         } else if(var4 == 6) {
            var1.putInt(var2, var5.amy);
         } else if(var4 == 7) {
            var1.putByte(var2, (byte)var5.amz);
         } else if(var4 == 8) {
            var1.putBoolean(var2, var5.amA);
         } else if(var4 == 13) {
            if(var0 == null) {
               throw new RuntimeException("populateBundle: unexpected type for: " + var2);
            } else {
               var1.putAsset(var2, (Asset)var0.get((int)var5.amG));
            }
         } else if(var4 != 9) {
            if(var4 == 10) {
               int var11 = method_3575(var2, var5.amC);
               ArrayList var12 = method_3580(var0, var5, var11);
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
            class_249.class_881[] var7 = var5.amB;
            int var8 = var7.length;

            for(int var9 = 0; var9 < var8; ++var9) {
               class_249.class_881 var10 = var7[var9];
               method_3581(var0, var6, var10.name, var10.amq);
            }

            var1.putDataMap(var2, var6);
         }
      }
   }

   // $FF: renamed from: a (com.google.android.gms.wearable.DataMap, java.util.List) com.google.android.gms.internal.lx$a[]
   private static class_249.class_881[] method_3582(DataMap var0, List<Asset> var1) {
      Set var2 = var0.keySet();
      class_249.class_881[] var3 = new class_249.class_881[var2.size()];
      Iterator var4 = var2.iterator();

      for(int var5 = 0; var4.hasNext(); ++var5) {
         String var6 = (String)var4.next();
         Object var7 = var0.get(var6);
         var3[var5] = new class_249.class_881();
         var3[var5].name = var6;
         var3[var5].amq = method_3578(var1, var7);
      }

      return var3;
   }

   public static class class_831 {
      public final class_249 amm;
      public final List<Asset> amn;

      public class_831(lx var1, List<Asset> var2) {
         this.amm = var1;
         this.amn = var2;
      }
   }
}
