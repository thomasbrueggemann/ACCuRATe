package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.class_515;
import com.google.android.gms.tagmanager.class_536;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

// $FF: renamed from: com.google.android.gms.tagmanager.dh
class class_537 {
   private static final Object aik = null;
   private static Long ail = new Long(0L);
   private static Double aim = new Double(0.0D);
   private static class_536 ain = class_536.method_2997(0L);
   private static String aio = new String("");
   private static Boolean aip = new Boolean(false);
   private static List<Object> aiq = new ArrayList(0);
   private static Map<Object, Object> air = new HashMap();
   private static class_52.class_816 ais;

   static {
      ais = method_3027(aio);
   }

   // $FF: renamed from: cp (java.lang.String) com.google.android.gms.internal.d$a
   public static class_52.class_816 method_3004(String var0) {
      class_52.class_816 var1 = new class_52.class_816();
      var1.type = 5;
      var1.field_890 = var0;
      return var1;
   }

   // $FF: renamed from: cq (java.lang.String) com.google.android.gms.tagmanager.dg
   private static class_536 method_3005(String var0) {
      try {
         class_536 var2 = class_536.method_2996(var0);
         return var2;
      } catch (NumberFormatException var3) {
         class_515.method_2916("Failed to convert \'" + var0 + "\' to a number.");
         return ain;
      }
   }

   // $FF: renamed from: cr (java.lang.String) java.lang.Long
   private static Long method_3006(String var0) {
      class_536 var1 = method_3005(var0);
      return var1 == ain?ail:Long.valueOf(var1.longValue());
   }

   // $FF: renamed from: cs (java.lang.String) java.lang.Double
   private static Double method_3007(String var0) {
      class_536 var1 = method_3005(var0);
      return var1 == ain?aim:Double.valueOf(var1.doubleValue());
   }

   // $FF: renamed from: ct (java.lang.String) java.lang.Boolean
   private static Boolean method_3008(String var0) {
      return "true".equalsIgnoreCase(var0)?Boolean.TRUE:("false".equalsIgnoreCase(var0)?Boolean.FALSE:aip);
   }

   private static double getDouble(Object var0) {
      if(var0 instanceof Number) {
         return ((Number)var0).doubleValue();
      } else {
         class_515.method_2916("getDouble received non-Number");
         return 0.0D;
      }
   }

   // $FF: renamed from: j (com.google.android.gms.internal.d$a) java.lang.String
   public static String method_3009(class_52.class_816 var0) {
      return method_3013(method_3024(var0));
   }

   // $FF: renamed from: k (com.google.android.gms.internal.d$a) com.google.android.gms.tagmanager.dg
   public static class_536 method_3010(class_52.class_816 var0) {
      return method_3021(method_3024(var0));
   }

   // $FF: renamed from: l (com.google.android.gms.internal.d$a) java.lang.Long
   public static Long method_3011(class_52.class_816 var0) {
      return method_3023(method_3024(var0));
   }

   // $FF: renamed from: m (com.google.android.gms.internal.d$a) java.lang.Double
   public static Double method_3012(class_52.class_816 var0) {
      return method_3025(method_3024(var0));
   }

   // $FF: renamed from: m (java.lang.Object) java.lang.String
   public static String method_3013(Object var0) {
      return var0 == null?aio:var0.toString();
   }

   // $FF: renamed from: mS () java.lang.Object
   public static Object method_3014() {
      return aik;
   }

   // $FF: renamed from: mT () java.lang.Long
   public static Long method_3015() {
      return ail;
   }

   // $FF: renamed from: mU () java.lang.Double
   public static Double method_3016() {
      return aim;
   }

   // $FF: renamed from: mV () java.lang.Boolean
   public static Boolean method_3017() {
      return aip;
   }

   // $FF: renamed from: mW () com.google.android.gms.tagmanager.dg
   public static class_536 method_3018() {
      return ain;
   }

   // $FF: renamed from: mX () java.lang.String
   public static String method_3019() {
      return aio;
   }

   // $FF: renamed from: mY () com.google.android.gms.internal.d$a
   public static class_52.class_816 method_3020() {
      return ais;
   }

   // $FF: renamed from: n (java.lang.Object) com.google.android.gms.tagmanager.dg
   public static class_536 method_3021(Object var0) {
      return var0 instanceof class_536?(class_536)var0:(method_3029(var0)?class_536.method_2997(method_3030(var0)):(method_3028(var0)?class_536.method_2995(Double.valueOf(getDouble(var0))):method_3005(method_3013(var0))));
   }

   // $FF: renamed from: n (com.google.android.gms.internal.d$a) java.lang.Boolean
   public static Boolean method_3022(class_52.class_816 var0) {
      return method_3026(method_3024(var0));
   }

   // $FF: renamed from: o (java.lang.Object) java.lang.Long
   public static Long method_3023(Object var0) {
      return method_3029(var0)?Long.valueOf(method_3030(var0)):method_3006(method_3013(var0));
   }

   // $FF: renamed from: o (com.google.android.gms.internal.d$a) java.lang.Object
   public static Object method_3024(class_52.class_816 var0) {
      int var1 = 0;
      if(var0 == null) {
         return aik;
      } else {
         switch(var0.type) {
         case 1:
            return var0.field_885;
         case 2:
            ArrayList var11 = new ArrayList(var0.field_886.length);
            class_52.class_816[] var12 = var0.field_886;

            for(int var13 = var12.length; var1 < var13; ++var1) {
               Object var14 = method_3024(var12[var1]);
               if(var14 == aik) {
                  return aik;
               }

               var11.add(var14);
            }

            return var11;
         case 3:
            if(var0.field_887.length != var0.field_888.length) {
               class_515.method_2916("Converting an invalid value to object: " + var0.toString());
               return aik;
            } else {
               HashMap var7;
               for(var7 = new HashMap(var0.field_888.length); var1 < var0.field_887.length; ++var1) {
                  Object var8 = method_3024(var0.field_887[var1]);
                  Object var9 = method_3024(var0.field_888[var1]);
                  if(var8 == aik || var9 == aik) {
                     return aik;
                  }

                  var7.put(var8, var9);
               }

               return var7;
            }
         case 4:
            class_515.method_2916("Trying to convert a macro reference to object");
            return aik;
         case 5:
            class_515.method_2916("Trying to convert a function id to object");
            return aik;
         case 6:
            return Long.valueOf(var0.field_891);
         case 7:
            StringBuffer var2 = new StringBuffer();
            class_52.class_816[] var3 = var0.field_893;

            for(int var4 = var3.length; var1 < var4; ++var1) {
               String var5 = method_3009(var3[var1]);
               if(var5 == aio) {
                  return aik;
               }

               var2.append(var5);
            }

            return var2.toString();
         case 8:
            return Boolean.valueOf(var0.field_892);
         default:
            class_515.method_2916("Failed to convert a value of type: " + var0.type);
            return aik;
         }
      }
   }

   // $FF: renamed from: p (java.lang.Object) java.lang.Double
   public static Double method_3025(Object var0) {
      return method_3028(var0)?Double.valueOf(getDouble(var0)):method_3007(method_3013(var0));
   }

   // $FF: renamed from: q (java.lang.Object) java.lang.Boolean
   public static Boolean method_3026(Object var0) {
      return var0 instanceof Boolean?(Boolean)var0:method_3008(method_3013(var0));
   }

   // $FF: renamed from: r (java.lang.Object) com.google.android.gms.internal.d$a
   public static class_52.class_816 method_3027(Object var0) {
      boolean var1 = false;
      class_52.class_816 var2 = new class_52.class_816();
      if(var0 instanceof class_52.class_816) {
         return (class_52.class_816)var0;
      } else {
         if(var0 instanceof String) {
            var2.type = 1;
            var2.field_885 = (String)var0;
         } else if(var0 instanceof List) {
            var2.type = 2;
            List var16 = (List)var0;
            ArrayList var17 = new ArrayList(var16.size());
            Iterator var18 = var16.iterator();

            boolean var19;
            boolean var21;
            for(var19 = false; var18.hasNext(); var19 = var21) {
               class_52.class_816 var20 = method_3027(var18.next());
               if(var20 == ais) {
                  return ais;
               }

               if(!var19 && !var20.field_895) {
                  var21 = false;
               } else {
                  var21 = true;
               }

               var17.add(var20);
            }

            var2.field_886 = (class_52.class_816[])var17.toArray(new class_52.class_816[0]);
            var1 = var19;
         } else if(!(var0 instanceof Map)) {
            if(method_3028(var0)) {
               var2.type = 1;
               var2.field_885 = var0.toString();
               var1 = false;
            } else if(method_3029(var0)) {
               var2.type = 6;
               var2.field_891 = method_3030(var0);
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

                  class_515.method_2916(var3.append(var4).toString());
                  return ais;
               }

               var2.type = 8;
               var2.field_892 = ((Boolean)var0).booleanValue();
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
                  var2.field_887 = (class_52.class_816[])var6.toArray(new class_52.class_816[0]);
                  var2.field_888 = (class_52.class_816[])var7.toArray(new class_52.class_816[0]);
                  var1 = var9;
                  break;
               }

               Entry var10 = (Entry)var8.next();
               class_52.class_816 var11 = method_3027(var10.getKey());
               class_52.class_816 var12 = method_3027(var10.getValue());
               if(var11 == ais || var12 == ais) {
                  return ais;
               }

               boolean var13;
               if(!var9 && !var11.field_895 && !var12.field_895) {
                  var13 = false;
               } else {
                  var13 = true;
               }

               var6.add(var11);
               var7.add(var12);
               var9 = var13;
            }
         }

         var2.field_895 = var1;
         return var2;
      }
   }

   // $FF: renamed from: s (java.lang.Object) boolean
   private static boolean method_3028(Object var0) {
      return var0 instanceof Double || var0 instanceof Float || var0 instanceof class_536 && ((class_536)var0).method_2999();
   }

   // $FF: renamed from: t (java.lang.Object) boolean
   private static boolean method_3029(Object var0) {
      return var0 instanceof Byte || var0 instanceof Short || var0 instanceof Integer || var0 instanceof Long || var0 instanceof class_536 && ((class_536)var0).method_3000();
   }

   // $FF: renamed from: u (java.lang.Object) long
   private static long method_3030(Object var0) {
      if(var0 instanceof Number) {
         return ((Number)var0).longValue();
      } else {
         class_515.method_2916("getInt64 received non-Number");
         return 0L;
      }
   }
}
