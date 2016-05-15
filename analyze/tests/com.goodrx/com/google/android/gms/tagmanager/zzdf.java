package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.zzbg;
import com.google.android.gms.tagmanager.zzde;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class zzdf {
   private static final Object zzblE = null;
   private static Long zzblF = new Long(0L);
   private static Double zzblG = new Double(0.0D);
   private static zzde zzblH = zzde.zzam(0L);
   private static String zzblI = new String("");
   private static Boolean zzblJ = new Boolean(false);
   private static List<Object> zzblK = new ArrayList(0);
   private static Map<Object, Object> zzblL = new HashMap();
   private static com.google.android.gms.internal.zzag.zza zzblM;

   static {
      zzblM = zzR(zzblI);
   }

   private static double getDouble(Object var0) {
      if(var0 instanceof Number) {
         return ((Number)var0).doubleValue();
      } else {
         zzbg.method_353("getDouble received non-Number");
         return 0.0D;
      }
   }

   public static Long zzHA() {
      return zzblF;
   }

   public static Boolean zzHC() {
      return zzblJ;
   }

   public static zzde zzHD() {
      return zzblH;
   }

   public static String zzHE() {
      return zzblI;
   }

   public static com.google.android.gms.internal.zzag.zza zzHF() {
      return zzblM;
   }

   public static Object zzHz() {
      return zzblE;
   }

   public static String zzM(Object var0) {
      return var0 == null?zzblI:var0.toString();
   }

   public static zzde zzN(Object var0) {
      return var0 instanceof zzde?(zzde)var0:(zzT(var0)?zzde.zzam(zzU(var0)):(zzS(var0)?zzde.zza(Double.valueOf(getDouble(var0))):zzgu(zzM(var0))));
   }

   public static Long zzO(Object var0) {
      return zzT(var0)?Long.valueOf(zzU(var0)):zzgv(zzM(var0));
   }

   public static Boolean zzQ(Object var0) {
      return var0 instanceof Boolean?(Boolean)var0:zzgx(zzM(var0));
   }

   public static com.google.android.gms.internal.zzag.zza zzR(Object var0) {
      boolean var1 = false;
      com.google.android.gms.internal.zzag.zza var2 = new com.google.android.gms.internal.zzag.zza();
      if(var0 instanceof com.google.android.gms.internal.zzag.zza) {
         return (com.google.android.gms.internal.zzag.zza)var0;
      } else {
         if(var0 instanceof String) {
            var2.type = 1;
            var2.zzjx = (String)var0;
         } else if(var0 instanceof List) {
            var2.type = 2;
            List var16 = (List)var0;
            ArrayList var17 = new ArrayList(var16.size());
            Iterator var18 = var16.iterator();

            boolean var19;
            boolean var21;
            for(var19 = false; var18.hasNext(); var19 = var21) {
               com.google.android.gms.internal.zzag.zza var20 = zzR(var18.next());
               if(var20 == zzblM) {
                  return zzblM;
               }

               if(!var19 && !var20.zzjH) {
                  var21 = false;
               } else {
                  var21 = true;
               }

               var17.add(var20);
            }

            var2.zzjy = (com.google.android.gms.internal.zzag.zza[])var17.toArray(new com.google.android.gms.internal.zzag.zza[0]);
            var1 = var19;
         } else if(!(var0 instanceof Map)) {
            if(zzS(var0)) {
               var2.type = 1;
               var2.zzjx = var0.toString();
               var1 = false;
            } else if(zzT(var0)) {
               var2.type = 6;
               var2.zzjD = zzU(var0);
               var1 = false;
            } else {
               if(!(var0 instanceof Boolean)) {
                  StringBuilder var3 = (new StringBuilder()).append("Converting to Value from unknown object type: ");
                  String var4;
                  if(var0 == null) {
                     var4 = "null";
                  } else {
                     var4 = var0.getClass().toString();
                  }

                  zzbg.method_353(var3.append(var4).toString());
                  return zzblM;
               }

               var2.type = 8;
               var2.zzjE = ((Boolean)var0).booleanValue();
               var1 = false;
            }
         } else {
            var2.type = 3;
            Set var5 = ((Map)var0).entrySet();
            ArrayList var6 = new ArrayList(var5.size());
            ArrayList var7 = new ArrayList(var5.size());
            Iterator var8 = var5.iterator();
            boolean var9 = false;

            while(true) {
               if(!var8.hasNext()) {
                  var2.zzjz = (com.google.android.gms.internal.zzag.zza[])var6.toArray(new com.google.android.gms.internal.zzag.zza[0]);
                  var2.zzjA = (com.google.android.gms.internal.zzag.zza[])var7.toArray(new com.google.android.gms.internal.zzag.zza[0]);
                  var1 = var9;
                  break;
               }

               Entry var10 = (Entry)var8.next();
               com.google.android.gms.internal.zzag.zza var11 = zzR(var10.getKey());
               com.google.android.gms.internal.zzag.zza var12 = zzR(var10.getValue());
               if(var11 == zzblM || var12 == zzblM) {
                  return zzblM;
               }

               boolean var13;
               if(!var9 && !var11.zzjH && !var12.zzjH) {
                  var13 = false;
               } else {
                  var13 = true;
               }

               var6.add(var11);
               var7.add(var12);
               var9 = var13;
            }
         }

         var2.zzjH = var1;
         return var2;
      }
   }

   private static boolean zzS(Object var0) {
      return var0 instanceof Double || var0 instanceof Float || var0 instanceof zzde && ((zzde)var0).zzHu();
   }

   private static boolean zzT(Object var0) {
      return var0 instanceof Byte || var0 instanceof Short || var0 instanceof Integer || var0 instanceof Long || var0 instanceof zzde && ((zzde)var0).zzHv();
   }

   private static long zzU(Object var0) {
      if(var0 instanceof Number) {
         return ((Number)var0).longValue();
      } else {
         zzbg.method_353("getInt64 received non-Number");
         return 0L;
      }
   }

   public static String zzg(com.google.android.gms.internal.zzag.zza var0) {
      return zzM(zzl(var0));
   }

   public static com.google.android.gms.internal.zzag.zza zzgt(String var0) {
      com.google.android.gms.internal.zzag.zza var1 = new com.google.android.gms.internal.zzag.zza();
      var1.type = 5;
      var1.zzjC = var0;
      return var1;
   }

   private static zzde zzgu(String var0) {
      try {
         zzde var2 = zzde.zzgs(var0);
         return var2;
      } catch (NumberFormatException var3) {
         zzbg.method_353("Failed to convert \'" + var0 + "\' to a number.");
         return zzblH;
      }
   }

   private static Long zzgv(String var0) {
      zzde var1 = zzgu(var0);
      return var1 == zzblH?zzblF:Long.valueOf(var1.longValue());
   }

   private static Boolean zzgx(String var0) {
      return "true".equalsIgnoreCase(var0)?Boolean.TRUE:("false".equalsIgnoreCase(var0)?Boolean.FALSE:zzblJ);
   }

   public static zzde zzh(com.google.android.gms.internal.zzag.zza var0) {
      return zzN(zzl(var0));
   }

   public static Long zzi(com.google.android.gms.internal.zzag.zza var0) {
      return zzO(zzl(var0));
   }

   public static Boolean zzk(com.google.android.gms.internal.zzag.zza var0) {
      return zzQ(zzl(var0));
   }

   public static Object zzl(com.google.android.gms.internal.zzag.zza var0) {
      int var1 = 0;
      if(var0 == null) {
         return zzblE;
      } else {
         switch(var0.type) {
         case 1:
            return var0.zzjx;
         case 2:
            ArrayList var11 = new ArrayList(var0.zzjy.length);
            com.google.android.gms.internal.zzag.zza[] var12 = var0.zzjy;

            for(int var13 = var12.length; var1 < var13; ++var1) {
               Object var14 = zzl(var12[var1]);
               if(var14 == zzblE) {
                  return zzblE;
               }

               var11.add(var14);
            }

            return var11;
         case 3:
            if(var0.zzjz.length != var0.zzjA.length) {
               zzbg.method_353("Converting an invalid value to object: " + var0.toString());
               return zzblE;
            } else {
               HashMap var7;
               for(var7 = new HashMap(var0.zzjA.length); var1 < var0.zzjz.length; ++var1) {
                  Object var8 = zzl(var0.zzjz[var1]);
                  Object var9 = zzl(var0.zzjA[var1]);
                  if(var8 == zzblE || var9 == zzblE) {
                     return zzblE;
                  }

                  var7.put(var8, var9);
               }

               return var7;
            }
         case 4:
            zzbg.method_353("Trying to convert a macro reference to object");
            return zzblE;
         case 5:
            zzbg.method_353("Trying to convert a function id to object");
            return zzblE;
         case 6:
            return Long.valueOf(var0.zzjD);
         case 7:
            StringBuffer var2 = new StringBuffer();
            com.google.android.gms.internal.zzag.zza[] var3 = var0.zzjF;

            for(int var4 = var3.length; var1 < var4; ++var1) {
               String var5 = zzg(var3[var1]);
               if(var5 == zzblI) {
                  return zzblE;
               }

               var2.append(var5);
            }

            return var2.toString();
         case 8:
            return Boolean.valueOf(var0.zzjE);
         default:
            zzbg.method_353("Failed to convert a value of type: " + var0.type);
            return zzblE;
         }
      }
   }
}
