package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_613;
import com.google.android.gms.tagmanager.class_636;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

// $FF: renamed from: com.google.android.gms.tagmanager.di
class class_635 {
   private static final Object auc = null;
   private static Long aud = new Long(0L);
   private static Double aue = new Double(0.0D);
   private static class_636 auf = class_636.method_3603(0L);
   private static String aug = new String("");
   private static Boolean auh = new Boolean(false);
   private static List<Object> aui = new ArrayList(0);
   private static Map<Object, Object> auj = new HashMap();
   private static class_57.class_1084 auk;

   static {
      auk = method_3597(aug);
   }

   // $FF: renamed from: cZ (java.lang.String) com.google.android.gms.internal.d$a
   public static class_57.class_1084 method_3574(String var0) {
      class_57.class_1084 var1 = new class_57.class_1084();
      var1.type = 5;
      var1.field_727 = var0;
      return var1;
   }

   // $FF: renamed from: da (java.lang.String) com.google.android.gms.tagmanager.dh
   private static class_636 method_3575(String var0) {
      try {
         class_636 var2 = class_636.method_3602(var0);
         return var2;
      } catch (NumberFormatException var3) {
         class_613.method_3491("Failed to convert \'" + var0 + "\' to a number.");
         return auf;
      }
   }

   // $FF: renamed from: db (java.lang.String) java.lang.Long
   private static Long method_3576(String var0) {
      class_636 var1 = method_3575(var0);
      return var1 == auf?aud:Long.valueOf(var1.longValue());
   }

   // $FF: renamed from: dc (java.lang.String) java.lang.Double
   private static Double method_3577(String var0) {
      class_636 var1 = method_3575(var0);
      return var1 == auf?aue:Double.valueOf(var1.doubleValue());
   }

   // $FF: renamed from: dd (java.lang.String) java.lang.Boolean
   private static Boolean method_3578(String var0) {
      return "true".equalsIgnoreCase(var0)?Boolean.TRUE:("false".equalsIgnoreCase(var0)?Boolean.FALSE:auh);
   }

   private static double getDouble(Object var0) {
      if(var0 instanceof Number) {
         return ((Number)var0).doubleValue();
      } else {
         class_613.method_3491("getDouble received non-Number");
         return 0.0D;
      }
   }

   // $FF: renamed from: j (com.google.android.gms.internal.d$a) java.lang.String
   public static String method_3579(class_57.class_1084 var0) {
      return method_3585(method_3584(var0));
   }

   // $FF: renamed from: k (com.google.android.gms.internal.d$a) com.google.android.gms.tagmanager.dh
   public static class_636 method_3580(class_57.class_1084 var0) {
      return method_3586(method_3584(var0));
   }

   // $FF: renamed from: l (com.google.android.gms.internal.d$a) java.lang.Long
   public static Long method_3581(class_57.class_1084 var0) {
      return method_3592(method_3584(var0));
   }

   // $FF: renamed from: m (com.google.android.gms.internal.d$a) java.lang.Double
   public static Double method_3582(class_57.class_1084 var0) {
      return method_3595(method_3584(var0));
   }

   // $FF: renamed from: n (com.google.android.gms.internal.d$a) java.lang.Boolean
   public static Boolean method_3583(class_57.class_1084 var0) {
      return method_3596(method_3584(var0));
   }

   // $FF: renamed from: o (com.google.android.gms.internal.d$a) java.lang.Object
   public static Object method_3584(class_57.class_1084 var0) {
      int var1 = 0;
      if(var0 == null) {
         return auc;
      } else {
         switch(var0.type) {
         case 1:
            return var0.field_733;
         case 2:
            ArrayList var11 = new ArrayList(var0.field_734.length);
            class_57.class_1084[] var12 = var0.field_734;

            for(int var13 = var12.length; var1 < var13; ++var1) {
               Object var14 = method_3584(var12[var1]);
               if(var14 == auc) {
                  return auc;
               }

               var11.add(var14);
            }

            return var11;
         case 3:
            if(var0.field_735.length != var0.field_736.length) {
               class_613.method_3491("Converting an invalid value to object: " + var0.toString());
               return auc;
            } else {
               HashMap var7;
               for(var7 = new HashMap(var0.field_736.length); var1 < var0.field_735.length; ++var1) {
                  Object var8 = method_3584(var0.field_735[var1]);
                  Object var9 = method_3584(var0.field_736[var1]);
                  if(var8 == auc || var9 == auc) {
                     return auc;
                  }

                  var7.put(var8, var9);
               }

               return var7;
            }
         case 4:
            class_613.method_3491("Trying to convert a macro reference to object");
            return auc;
         case 5:
            class_613.method_3491("Trying to convert a function id to object");
            return auc;
         case 6:
            return Long.valueOf(var0.field_728);
         case 7:
            StringBuffer var2 = new StringBuffer();
            class_57.class_1084[] var3 = var0.field_730;

            for(int var4 = var3.length; var1 < var4; ++var1) {
               String var5 = method_3579(var3[var1]);
               if(var5 == aug) {
                  return auc;
               }

               var2.append(var5);
            }

            return var2.toString();
         case 8:
            return Boolean.valueOf(var0.field_729);
         default:
            class_613.method_3491("Failed to convert a value of type: " + var0.type);
            return auc;
         }
      }
   }

   // $FF: renamed from: p (java.lang.Object) java.lang.String
   public static String method_3585(Object var0) {
      return var0 == null?aug:var0.toString();
   }

   // $FF: renamed from: q (java.lang.Object) com.google.android.gms.tagmanager.dh
   public static class_636 method_3586(Object var0) {
      return var0 instanceof class_636?(class_636)var0:(method_3599(var0)?class_636.method_3603(method_3600(var0)):(method_3598(var0)?class_636.method_3601(Double.valueOf(getDouble(var0))):method_3575(method_3585(var0))));
   }

   // $FF: renamed from: qV () java.lang.Object
   public static Object method_3587() {
      return auc;
   }

   // $FF: renamed from: qW () java.lang.Long
   public static Long method_3588() {
      return aud;
   }

   // $FF: renamed from: qX () java.lang.Double
   public static Double method_3589() {
      return aue;
   }

   // $FF: renamed from: qY () java.lang.Boolean
   public static Boolean method_3590() {
      return auh;
   }

   // $FF: renamed from: qZ () com.google.android.gms.tagmanager.dh
   public static class_636 method_3591() {
      return auf;
   }

   // $FF: renamed from: r (java.lang.Object) java.lang.Long
   public static Long method_3592(Object var0) {
      return method_3599(var0)?Long.valueOf(method_3600(var0)):method_3576(method_3585(var0));
   }

   // $FF: renamed from: ra () java.lang.String
   public static String method_3593() {
      return aug;
   }

   // $FF: renamed from: rb () com.google.android.gms.internal.d$a
   public static class_57.class_1084 method_3594() {
      return auk;
   }

   // $FF: renamed from: s (java.lang.Object) java.lang.Double
   public static Double method_3595(Object var0) {
      return method_3598(var0)?Double.valueOf(getDouble(var0)):method_3577(method_3585(var0));
   }

   // $FF: renamed from: t (java.lang.Object) java.lang.Boolean
   public static Boolean method_3596(Object var0) {
      return var0 instanceof Boolean?(Boolean)var0:method_3578(method_3585(var0));
   }

   // $FF: renamed from: u (java.lang.Object) com.google.android.gms.internal.d$a
   public static class_57.class_1084 method_3597(Object var0) {
      boolean var1 = false;
      class_57.class_1084 var2 = new class_57.class_1084();
      if(var0 instanceof class_57.class_1084) {
         return (class_57.class_1084)var0;
      } else {
         if(var0 instanceof String) {
            var2.type = 1;
            var2.field_733 = (String)var0;
         } else if(var0 instanceof List) {
            var2.type = 2;
            List var16 = (List)var0;
            ArrayList var17 = new ArrayList(var16.size());
            Iterator var18 = var16.iterator();

            boolean var19;
            boolean var21;
            for(var19 = false; var18.hasNext(); var19 = var21) {
               class_57.class_1084 var20 = method_3597(var18.next());
               if(var20 == auk) {
                  return auk;
               }

               if(!var19 && !var20.field_732) {
                  var21 = false;
               } else {
                  var21 = true;
               }

               var17.add(var20);
            }

            var2.field_734 = (class_57.class_1084[])var17.toArray(new class_57.class_1084[0]);
            var1 = var19;
         } else if(!(var0 instanceof Map)) {
            if(method_3598(var0)) {
               var2.type = 1;
               var2.field_733 = var0.toString();
               var1 = false;
            } else if(method_3599(var0)) {
               var2.type = 6;
               var2.field_728 = method_3600(var0);
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

                  class_613.method_3491(var3.append(var4).toString());
                  return auk;
               }

               var2.type = 8;
               var2.field_729 = ((Boolean)var0).booleanValue();
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
                  var2.field_735 = (class_57.class_1084[])var6.toArray(new class_57.class_1084[0]);
                  var2.field_736 = (class_57.class_1084[])var7.toArray(new class_57.class_1084[0]);
                  var1 = var9;
                  break;
               }

               Entry var10 = (Entry)var8.next();
               class_57.class_1084 var11 = method_3597(var10.getKey());
               class_57.class_1084 var12 = method_3597(var10.getValue());
               if(var11 == auk || var12 == auk) {
                  return auk;
               }

               boolean var13;
               if(!var9 && !var11.field_732 && !var12.field_732) {
                  var13 = false;
               } else {
                  var13 = true;
               }

               var6.add(var11);
               var7.add(var12);
               var9 = var13;
            }
         }

         var2.field_732 = var1;
         return var2;
      }
   }

   // $FF: renamed from: v (java.lang.Object) boolean
   private static boolean method_3598(Object var0) {
      return var0 instanceof Double || var0 instanceof Float || var0 instanceof class_636 && ((class_636)var0).method_3605();
   }

   // $FF: renamed from: w (java.lang.Object) boolean
   private static boolean method_3599(Object var0) {
      return var0 instanceof Byte || var0 instanceof Short || var0 instanceof Integer || var0 instanceof Long || var0 instanceof class_636 && ((class_636)var0).method_3606();
   }

   // $FF: renamed from: x (java.lang.Object) long
   private static long method_3600(Object var0) {
      if(var0 instanceof Number) {
         return ((Number)var0).longValue();
      } else {
         class_613.method_3491("getInt64 received non-Number");
         return 0L;
      }
   }
}
