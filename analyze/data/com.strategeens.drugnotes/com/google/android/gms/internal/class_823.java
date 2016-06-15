package com.google.android.gms.internal;

import com.google.android.gms.internal.class_303;
import com.google.android.gms.internal.qm;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.ql
public final class class_823 {
   // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.qm$a$a[]) int
   private static int method_4489(String var0, class_303.class_1353[] var1) {
      int var2 = var1.length;
      int var3 = 0;

      int var4;
      for(var4 = 14; var3 < var2; ++var3) {
         class_303.class_1353 var5 = var1[var3];
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
   static int method_4490(List<Asset> var0, Asset var1) {
      var0.add(var1);
      return -1 + var0.size();
   }

   // $FF: renamed from: a (com.google.android.gms.wearable.DataMap) com.google.android.gms.internal.ql$a
   public static class_823.class_1548 method_4491(DataMap var0) {
      class_303 var1 = new class_303();
      ArrayList var2 = new ArrayList();
      var1.ayq = method_4496(var0, var2);
      return new class_823.class_1548(var1, var2);
   }

   // $FF: renamed from: a (java.util.List, java.lang.Object) com.google.android.gms.internal.qm$a$a
   private static class_303.class_1353 method_4492(List<Asset> var0, Object var1) {
      class_303.class_1353 var2 = new class_303.class_1353();
      if(var1 == null) {
         var2.type = 14;
         return var2;
      } else {
         var2.ayu = new class_303.class_1354();
         if(var1 instanceof String) {
            var2.type = 2;
            var2.ayu.ayw = (String)var1;
         } else if(var1 instanceof Integer) {
            var2.type = 6;
            var2.ayu.ayA = ((Integer)var1).intValue();
         } else if(var1 instanceof Long) {
            var2.type = 5;
            var2.ayu.ayz = ((Long)var1).longValue();
         } else if(var1 instanceof Double) {
            var2.type = 3;
            var2.ayu.ayx = ((Double)var1).doubleValue();
         } else if(var1 instanceof Float) {
            var2.type = 4;
            var2.ayu.ayy = ((Float)var1).floatValue();
         } else if(var1 instanceof Boolean) {
            var2.type = 8;
            var2.ayu.ayC = ((Boolean)var1).booleanValue();
         } else if(var1 instanceof Byte) {
            var2.type = 7;
            var2.ayu.ayB = ((Byte)var1).byteValue();
         } else if(var1 instanceof byte[]) {
            var2.type = 1;
            var2.ayu.ayv = (byte[])((byte[])var1);
         } else if(var1 instanceof String[]) {
            var2.type = 11;
            var2.ayu.ayF = (String[])((String[])var1);
         } else if(var1 instanceof long[]) {
            var2.type = 12;
            var2.ayu.ayG = (long[])((long[])var1);
         } else if(var1 instanceof float[]) {
            var2.type = 15;
            var2.ayu.ayH = (float[])((float[])var1);
         } else if(var1 instanceof Asset) {
            var2.type = 13;
            var2.ayu.ayI = (long)method_4490(var0, (Asset)var1);
         } else if(var1 instanceof DataMap) {
            var2.type = 9;
            DataMap var12 = (DataMap)var1;
            Set var13 = var12.keySet();
            class_303.class_1352[] var14 = new class_303.class_1352[var13.size()];
            Iterator var15 = var13.iterator();

            for(int var16 = 0; var15.hasNext(); ++var16) {
               String var17 = (String)var15.next();
               var14[var16] = new class_303.class_1352();
               var14[var16].name = var17;
               var14[var16].ays = method_4492(var0, var12.get(var17));
            }

            var2.ayu.ayD = var14;
         } else {
            if(!(var1 instanceof ArrayList)) {
               throw new RuntimeException("newFieldValueFromValue: unexpected value " + var1.getClass().getSimpleName());
            }

            var2.type = 10;
            ArrayList var3 = (ArrayList)var1;
            class_303.class_1353[] var4 = new class_303.class_1353[var3.size()];
            Object var5 = null;
            int var6 = var3.size();
            int var7 = 0;

            Object var9;
            for(int var8 = 14; var7 < var6; var5 = var9) {
               var9 = var3.get(var7);
               class_303.class_1353 var10 = method_4492(var0, var9);
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

            var2.ayu.ayE = var4;
         }

         return var2;
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.ql$a) com.google.android.gms.wearable.DataMap
   public static DataMap method_4493(class_823.class_1548 var0) {
      DataMap var1 = new DataMap();
      class_303.class_1352[] var2 = var0.ayo.ayq;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         class_303.class_1352 var5 = var2[var4];
         method_4495(var0.ayp, var1, var5.name, var5.ays);
      }

      return var1;
   }

   // $FF: renamed from: a (java.util.List, com.google.android.gms.internal.qm$a$a$a, int) java.util.ArrayList
   private static ArrayList method_4494(List<Asset> var0, class_303.class_1354 var1, int var2) {
      ArrayList var3 = new ArrayList(var1.ayE.length);
      class_303.class_1353[] var4 = var1.ayE;
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         class_303.class_1353 var7 = var4[var6];
         if(var7.type == 14) {
            var3.add((Object)null);
         } else if(var2 != 9) {
            if(var2 == 2) {
               var3.add(var7.ayu.ayw);
            } else {
               if(var2 != 6) {
                  throw new IllegalArgumentException("Unexpected typeOfArrayList: " + var2);
               }

               var3.add(Integer.valueOf(var7.ayu.ayA));
            }
         } else {
            DataMap var8 = new DataMap();
            class_303.class_1352[] var9 = var7.ayu.ayD;
            int var10 = var9.length;

            for(int var11 = 0; var11 < var10; ++var11) {
               class_303.class_1352 var13 = var9[var11];
               method_4495(var0, var8, var13.name, var13.ays);
            }

            var3.add(var8);
         }
      }

      return var3;
   }

   // $FF: renamed from: a (java.util.List, com.google.android.gms.wearable.DataMap, java.lang.String, com.google.android.gms.internal.qm$a$a) void
   private static void method_4495(List<Asset> var0, DataMap var1, String var2, class_303.class_1353 var3) {
      int var4 = var3.type;
      if(var4 == 14) {
         var1.putString(var2, (String)null);
      } else {
         class_303.class_1354 var5 = var3.ayu;
         if(var4 == 1) {
            var1.putByteArray(var2, var5.ayv);
         } else if(var4 == 11) {
            var1.putStringArray(var2, var5.ayF);
         } else if(var4 == 12) {
            var1.putLongArray(var2, var5.ayG);
         } else if(var4 == 15) {
            var1.putFloatArray(var2, var5.ayH);
         } else if(var4 == 2) {
            var1.putString(var2, var5.ayw);
         } else if(var4 == 3) {
            var1.putDouble(var2, var5.ayx);
         } else if(var4 == 4) {
            var1.putFloat(var2, var5.ayy);
         } else if(var4 == 5) {
            var1.putLong(var2, var5.ayz);
         } else if(var4 == 6) {
            var1.putInt(var2, var5.ayA);
         } else if(var4 == 7) {
            var1.putByte(var2, (byte)var5.ayB);
         } else if(var4 == 8) {
            var1.putBoolean(var2, var5.ayC);
         } else if(var4 == 13) {
            if(var0 == null) {
               throw new RuntimeException("populateBundle: unexpected type for: " + var2);
            } else {
               var1.putAsset(var2, (Asset)var0.get((int)var5.ayI));
            }
         } else if(var4 != 9) {
            if(var4 == 10) {
               int var11 = method_4489(var2, var5.ayE);
               ArrayList var12 = method_4494(var0, var5, var11);
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
            class_303.class_1352[] var7 = var5.ayD;
            int var8 = var7.length;

            for(int var9 = 0; var9 < var8; ++var9) {
               class_303.class_1352 var10 = var7[var9];
               method_4495(var0, var6, var10.name, var10.ays);
            }

            var1.putDataMap(var2, var6);
         }
      }
   }

   // $FF: renamed from: a (com.google.android.gms.wearable.DataMap, java.util.List) com.google.android.gms.internal.qm$a[]
   private static class_303.class_1352[] method_4496(DataMap var0, List<Asset> var1) {
      Set var2 = var0.keySet();
      class_303.class_1352[] var3 = new class_303.class_1352[var2.size()];
      Iterator var4 = var2.iterator();

      for(int var5 = 0; var4.hasNext(); ++var5) {
         String var6 = (String)var4.next();
         Object var7 = var0.get(var6);
         var3[var5] = new class_303.class_1352();
         var3[var5].name = var6;
         var3[var5].ays = method_4492(var1, var7);
      }

      return var3;
   }

   public static class class_1548 {
      public final class_303 ayo;
      public final List<Asset> ayp;

      public class_1548(qm var1, List<Asset> var2) {
         this.ayo = var1;
         this.ayp = var2;
      }
   }
}
