package com.facebook.common.logging;

import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.common.logging.LoggingDelegate;
import java.util.Locale;

public class FLog {
   public static final int ASSERT = 7;
   public static final int DEBUG = 3;
   public static final int ERROR = 6;
   public static final int INFO = 4;
   public static final int VERBOSE = 2;
   public static final int WARN = 5;
   private static LoggingDelegate sHandler = FLogDefaultLoggingDelegate.getInstance();

   // $FF: renamed from: d (java.lang.Class, java.lang.String) void
   public static void method_377(Class<?> var0, String var1) {
      if(sHandler.isLoggable(3)) {
         sHandler.method_9(getTag(var0), var1);
      }

   }

   // $FF: renamed from: d (java.lang.Class, java.lang.String, java.lang.Object) void
   public static void method_378(Class<?> var0, String var1, Object var2) {
      if(sHandler.isLoggable(3)) {
         sHandler.method_9(getTag(var0), formatString(var1, new Object[]{var2}));
      }

   }

   // $FF: renamed from: d (java.lang.Class, java.lang.String, java.lang.Object, java.lang.Object) void
   public static void method_379(Class<?> var0, String var1, Object var2, Object var3) {
      if(sHandler.isLoggable(3)) {
         sHandler.method_9(getTag(var0), formatString(var1, new Object[]{var2, var3}));
      }

   }

   // $FF: renamed from: d (java.lang.Class, java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object) void
   public static void method_380(Class<?> var0, String var1, Object var2, Object var3, Object var4) {
      if(sHandler.isLoggable(3)) {
         sHandler.method_9(getTag(var0), formatString(var1, new Object[]{var2, var3, var4}));
      }

   }

   // $FF: renamed from: d (java.lang.Class, java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object) void
   public static void method_381(Class<?> var0, String var1, Object var2, Object var3, Object var4, Object var5) {
      if(sHandler.isLoggable(3)) {
         sHandler.method_9(getTag(var0), formatString(var1, new Object[]{var2, var3, var4, var5}));
      }

   }

   // $FF: renamed from: d (java.lang.Class, java.lang.String, java.lang.Throwable) void
   public static void method_382(Class<?> var0, String var1, Throwable var2) {
      if(sHandler.isLoggable(3)) {
         sHandler.method_10(getTag(var0), var1, var2);
      }

   }

   // $FF: renamed from: d (java.lang.Class, java.lang.String, java.lang.Object[]) void
   public static void method_383(Class<?> var0, String var1, Object... var2) {
      if(sHandler.isLoggable(3)) {
         sHandler.method_9(getTag(var0), formatString(var1, var2));
      }

   }

   // $FF: renamed from: d (java.lang.Class, java.lang.Throwable, java.lang.String, java.lang.Object[]) void
   public static void method_384(Class<?> var0, Throwable var1, String var2, Object... var3) {
      if(sHandler.isLoggable(3)) {
         sHandler.method_10(getTag(var0), formatString(var2, var3), var1);
      }

   }

   // $FF: renamed from: d (java.lang.String, java.lang.String) void
   public static void method_385(String var0, String var1) {
      if(sHandler.isLoggable(3)) {
         sHandler.method_9(var0, var1);
      }

   }

   // $FF: renamed from: d (java.lang.String, java.lang.String, java.lang.Object) void
   public static void method_386(String var0, String var1, Object var2) {
      if(sHandler.isLoggable(3)) {
         sHandler.method_9(var0, formatString(var1, new Object[]{var2}));
      }

   }

   // $FF: renamed from: d (java.lang.String, java.lang.String, java.lang.Object, java.lang.Object) void
   public static void method_387(String var0, String var1, Object var2, Object var3) {
      if(sHandler.isLoggable(3)) {
         sHandler.method_9(var0, formatString(var1, new Object[]{var2, var3}));
      }

   }

   // $FF: renamed from: d (java.lang.String, java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object) void
   public static void method_388(String var0, String var1, Object var2, Object var3, Object var4) {
      if(sHandler.isLoggable(3)) {
         sHandler.method_9(var0, formatString(var1, new Object[]{var2, var3, var4}));
      }

   }

   // $FF: renamed from: d (java.lang.String, java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object) void
   public static void method_389(String var0, String var1, Object var2, Object var3, Object var4, Object var5) {
      if(sHandler.isLoggable(3)) {
         sHandler.method_9(var0, formatString(var1, new Object[]{var2, var3, var4, var5}));
      }

   }

   // $FF: renamed from: d (java.lang.String, java.lang.String, java.lang.Throwable) void
   public static void method_390(String var0, String var1, Throwable var2) {
      if(sHandler.isLoggable(3)) {
         sHandler.method_10(var0, var1, var2);
      }

   }

   // $FF: renamed from: d (java.lang.String, java.lang.String, java.lang.Object[]) void
   public static void method_391(String var0, String var1, Object... var2) {
      if(sHandler.isLoggable(3)) {
         method_385(var0, formatString(var1, var2));
      }

   }

   // $FF: renamed from: d (java.lang.String, java.lang.Throwable, java.lang.String, java.lang.Object[]) void
   public static void method_392(String var0, Throwable var1, String var2, Object... var3) {
      if(sHandler.isLoggable(3)) {
         method_390(var0, formatString(var2, var3), var1);
      }

   }

   // $FF: renamed from: e (java.lang.Class, java.lang.String) void
   public static void method_393(Class<?> var0, String var1) {
      if(sHandler.isLoggable(6)) {
         sHandler.method_11(getTag(var0), var1);
      }

   }

   // $FF: renamed from: e (java.lang.Class, java.lang.String, java.lang.Throwable) void
   public static void method_394(Class<?> var0, String var1, Throwable var2) {
      if(sHandler.isLoggable(6)) {
         sHandler.method_12(getTag(var0), var1, var2);
      }

   }

   // $FF: renamed from: e (java.lang.Class, java.lang.String, java.lang.Object[]) void
   public static void method_395(Class<?> var0, String var1, Object... var2) {
      if(sHandler.isLoggable(6)) {
         sHandler.method_11(getTag(var0), formatString(var1, var2));
      }

   }

   // $FF: renamed from: e (java.lang.Class, java.lang.Throwable, java.lang.String, java.lang.Object[]) void
   public static void method_396(Class<?> var0, Throwable var1, String var2, Object... var3) {
      if(sHandler.isLoggable(6)) {
         sHandler.method_12(getTag(var0), formatString(var2, var3), var1);
      }

   }

   // $FF: renamed from: e (java.lang.String, java.lang.String) void
   public static void method_397(String var0, String var1) {
      if(sHandler.isLoggable(6)) {
         sHandler.method_11(var0, var1);
      }

   }

   // $FF: renamed from: e (java.lang.String, java.lang.String, java.lang.Throwable) void
   public static void method_398(String var0, String var1, Throwable var2) {
      if(sHandler.isLoggable(6)) {
         sHandler.method_12(var0, var1, var2);
      }

   }

   // $FF: renamed from: e (java.lang.String, java.lang.String, java.lang.Object[]) void
   public static void method_399(String var0, String var1, Object... var2) {
      if(sHandler.isLoggable(6)) {
         sHandler.method_11(var0, formatString(var1, var2));
      }

   }

   // $FF: renamed from: e (java.lang.String, java.lang.Throwable, java.lang.String, java.lang.Object[]) void
   public static void method_400(String var0, Throwable var1, String var2, Object... var3) {
      if(sHandler.isLoggable(6)) {
         sHandler.method_12(var0, formatString(var2, var3), var1);
      }

   }

   private static String formatString(String var0, Object... var1) {
      return String.format((Locale)null, var0, var1);
   }

   public static int getMinimumLoggingLevel() {
      return sHandler.getMinimumLoggingLevel();
   }

   private static String getTag(Class<?> var0) {
      return var0.getSimpleName();
   }

   // $FF: renamed from: i (java.lang.Class, java.lang.String) void
   public static void method_401(Class<?> var0, String var1) {
      if(sHandler.isLoggable(4)) {
         sHandler.method_13(getTag(var0), var1);
      }

   }

   // $FF: renamed from: i (java.lang.Class, java.lang.String, java.lang.Object) void
   public static void method_402(Class<?> var0, String var1, Object var2) {
      if(sHandler.isLoggable(4)) {
         sHandler.method_13(getTag(var0), formatString(var1, new Object[]{var2}));
      }

   }

   // $FF: renamed from: i (java.lang.Class, java.lang.String, java.lang.Object, java.lang.Object) void
   public static void method_403(Class<?> var0, String var1, Object var2, Object var3) {
      if(sHandler.isLoggable(4)) {
         sHandler.method_13(getTag(var0), formatString(var1, new Object[]{var2, var3}));
      }

   }

   // $FF: renamed from: i (java.lang.Class, java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object) void
   public static void method_404(Class<?> var0, String var1, Object var2, Object var3, Object var4) {
      if(sHandler.isLoggable(4)) {
         sHandler.method_13(getTag(var0), formatString(var1, new Object[]{var2, var3, var4}));
      }

   }

   // $FF: renamed from: i (java.lang.Class, java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object) void
   public static void method_405(Class<?> var0, String var1, Object var2, Object var3, Object var4, Object var5) {
      if(sHandler.isLoggable(4)) {
         sHandler.method_13(getTag(var0), formatString(var1, new Object[]{var2, var3, var4, var5}));
      }

   }

   // $FF: renamed from: i (java.lang.Class, java.lang.String, java.lang.Throwable) void
   public static void method_406(Class<?> var0, String var1, Throwable var2) {
      if(sHandler.isLoggable(4)) {
         sHandler.method_14(getTag(var0), var1, var2);
      }

   }

   // $FF: renamed from: i (java.lang.Class, java.lang.String, java.lang.Object[]) void
   public static void method_407(Class<?> var0, String var1, Object... var2) {
      if(sHandler.isLoggable(4)) {
         sHandler.method_13(getTag(var0), formatString(var1, var2));
      }

   }

   // $FF: renamed from: i (java.lang.Class, java.lang.Throwable, java.lang.String, java.lang.Object[]) void
   public static void method_408(Class<?> var0, Throwable var1, String var2, Object... var3) {
      if(isLoggable(4)) {
         sHandler.method_14(getTag(var0), formatString(var2, var3), var1);
      }

   }

   // $FF: renamed from: i (java.lang.String, java.lang.String) void
   public static void method_409(String var0, String var1) {
      if(sHandler.isLoggable(4)) {
         sHandler.method_13(var0, var1);
      }

   }

   // $FF: renamed from: i (java.lang.String, java.lang.String, java.lang.Object) void
   public static void method_410(String var0, String var1, Object var2) {
      if(sHandler.isLoggable(4)) {
         sHandler.method_13(var0, formatString(var1, new Object[]{var2}));
      }

   }

   // $FF: renamed from: i (java.lang.String, java.lang.String, java.lang.Object, java.lang.Object) void
   public static void method_411(String var0, String var1, Object var2, Object var3) {
      if(sHandler.isLoggable(4)) {
         sHandler.method_13(var0, formatString(var1, new Object[]{var2, var3}));
      }

   }

   // $FF: renamed from: i (java.lang.String, java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object) void
   public static void method_412(String var0, String var1, Object var2, Object var3, Object var4) {
      if(sHandler.isLoggable(4)) {
         sHandler.method_13(var0, formatString(var1, new Object[]{var2, var3, var4}));
      }

   }

   // $FF: renamed from: i (java.lang.String, java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object) void
   public static void method_413(String var0, String var1, Object var2, Object var3, Object var4, Object var5) {
      if(sHandler.isLoggable(4)) {
         sHandler.method_13(var0, formatString(var1, new Object[]{var2, var3, var4, var5}));
      }

   }

   // $FF: renamed from: i (java.lang.String, java.lang.String, java.lang.Throwable) void
   public static void method_414(String var0, String var1, Throwable var2) {
      if(sHandler.isLoggable(4)) {
         sHandler.method_14(var0, var1, var2);
      }

   }

   // $FF: renamed from: i (java.lang.String, java.lang.String, java.lang.Object[]) void
   public static void method_415(String var0, String var1, Object... var2) {
      if(sHandler.isLoggable(4)) {
         sHandler.method_13(var0, formatString(var1, var2));
      }

   }

   // $FF: renamed from: i (java.lang.String, java.lang.Throwable, java.lang.String, java.lang.Object[]) void
   public static void method_416(String var0, Throwable var1, String var2, Object... var3) {
      if(sHandler.isLoggable(4)) {
         sHandler.method_14(var0, formatString(var2, var3), var1);
      }

   }

   public static boolean isLoggable(int var0) {
      return sHandler.isLoggable(var0);
   }

   public static void setLoggingDelegate(LoggingDelegate var0) {
      if(var0 == null) {
         throw new IllegalArgumentException();
      } else {
         sHandler = var0;
      }
   }

   public static void setMinimumLoggingLevel(int var0) {
      sHandler.setMinimumLoggingLevel(var0);
   }

   // $FF: renamed from: v (java.lang.Class, java.lang.String) void
   public static void method_417(Class<?> var0, String var1) {
      if(sHandler.isLoggable(2)) {
         sHandler.method_15(getTag(var0), var1);
      }

   }

   // $FF: renamed from: v (java.lang.Class, java.lang.String, java.lang.Object) void
   public static void method_418(Class<?> var0, String var1, Object var2) {
      if(sHandler.isLoggable(2)) {
         sHandler.method_15(getTag(var0), formatString(var1, new Object[]{var2}));
      }

   }

   // $FF: renamed from: v (java.lang.Class, java.lang.String, java.lang.Object, java.lang.Object) void
   public static void method_419(Class<?> var0, String var1, Object var2, Object var3) {
      if(sHandler.isLoggable(2)) {
         sHandler.method_15(getTag(var0), formatString(var1, new Object[]{var2, var3}));
      }

   }

   // $FF: renamed from: v (java.lang.Class, java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object) void
   public static void method_420(Class<?> var0, String var1, Object var2, Object var3, Object var4) {
      if(isLoggable(2)) {
         method_417(var0, formatString(var1, new Object[]{var2, var3, var4}));
      }

   }

   // $FF: renamed from: v (java.lang.Class, java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object) void
   public static void method_421(Class<?> var0, String var1, Object var2, Object var3, Object var4, Object var5) {
      if(sHandler.isLoggable(2)) {
         sHandler.method_15(getTag(var0), formatString(var1, new Object[]{var2, var3, var4, var5}));
      }

   }

   // $FF: renamed from: v (java.lang.Class, java.lang.String, java.lang.Throwable) void
   public static void method_422(Class<?> var0, String var1, Throwable var2) {
      if(sHandler.isLoggable(2)) {
         sHandler.method_16(getTag(var0), var1, var2);
      }

   }

   // $FF: renamed from: v (java.lang.Class, java.lang.String, java.lang.Object[]) void
   public static void method_423(Class<?> var0, String var1, Object... var2) {
      if(sHandler.isLoggable(2)) {
         sHandler.method_15(getTag(var0), formatString(var1, var2));
      }

   }

   // $FF: renamed from: v (java.lang.Class, java.lang.Throwable, java.lang.String, java.lang.Object[]) void
   public static void method_424(Class<?> var0, Throwable var1, String var2, Object... var3) {
      if(sHandler.isLoggable(2)) {
         sHandler.method_16(getTag(var0), formatString(var2, var3), var1);
      }

   }

   // $FF: renamed from: v (java.lang.String, java.lang.String) void
   public static void method_425(String var0, String var1) {
      if(sHandler.isLoggable(2)) {
         sHandler.method_15(var0, var1);
      }

   }

   // $FF: renamed from: v (java.lang.String, java.lang.String, java.lang.Object) void
   public static void method_426(String var0, String var1, Object var2) {
      if(sHandler.isLoggable(2)) {
         sHandler.method_15(var0, formatString(var1, new Object[]{var2}));
      }

   }

   // $FF: renamed from: v (java.lang.String, java.lang.String, java.lang.Object, java.lang.Object) void
   public static void method_427(String var0, String var1, Object var2, Object var3) {
      if(sHandler.isLoggable(2)) {
         sHandler.method_15(var0, formatString(var1, new Object[]{var2, var3}));
      }

   }

   // $FF: renamed from: v (java.lang.String, java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object) void
   public static void method_428(String var0, String var1, Object var2, Object var3, Object var4) {
      if(sHandler.isLoggable(2)) {
         sHandler.method_15(var0, formatString(var1, new Object[]{var2, var3, var4}));
      }

   }

   // $FF: renamed from: v (java.lang.String, java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object) void
   public static void method_429(String var0, String var1, Object var2, Object var3, Object var4, Object var5) {
      if(sHandler.isLoggable(2)) {
         sHandler.method_15(var0, formatString(var1, new Object[]{var2, var3, var4, var5}));
      }

   }

   // $FF: renamed from: v (java.lang.String, java.lang.String, java.lang.Throwable) void
   public static void method_430(String var0, String var1, Throwable var2) {
      if(sHandler.isLoggable(2)) {
         sHandler.method_16(var0, var1, var2);
      }

   }

   // $FF: renamed from: v (java.lang.String, java.lang.String, java.lang.Object[]) void
   public static void method_431(String var0, String var1, Object... var2) {
      if(sHandler.isLoggable(2)) {
         sHandler.method_15(var0, formatString(var1, var2));
      }

   }

   // $FF: renamed from: v (java.lang.String, java.lang.Throwable, java.lang.String, java.lang.Object[]) void
   public static void method_432(String var0, Throwable var1, String var2, Object... var3) {
      if(sHandler.isLoggable(2)) {
         sHandler.method_16(var0, formatString(var2, var3), var1);
      }

   }

   // $FF: renamed from: w (java.lang.Class, java.lang.String) void
   public static void method_433(Class<?> var0, String var1) {
      if(sHandler.isLoggable(5)) {
         sHandler.method_17(getTag(var0), var1);
      }

   }

   // $FF: renamed from: w (java.lang.Class, java.lang.String, java.lang.Throwable) void
   public static void method_434(Class<?> var0, String var1, Throwable var2) {
      if(sHandler.isLoggable(5)) {
         sHandler.method_18(getTag(var0), var1, var2);
      }

   }

   // $FF: renamed from: w (java.lang.Class, java.lang.String, java.lang.Object[]) void
   public static void method_435(Class<?> var0, String var1, Object... var2) {
      if(sHandler.isLoggable(5)) {
         sHandler.method_17(getTag(var0), formatString(var1, var2));
      }

   }

   // $FF: renamed from: w (java.lang.Class, java.lang.Throwable, java.lang.String, java.lang.Object[]) void
   public static void method_436(Class<?> var0, Throwable var1, String var2, Object... var3) {
      if(isLoggable(5)) {
         method_434(var0, formatString(var2, var3), var1);
      }

   }

   // $FF: renamed from: w (java.lang.String, java.lang.String) void
   public static void method_437(String var0, String var1) {
      if(sHandler.isLoggable(5)) {
         sHandler.method_17(var0, var1);
      }

   }

   // $FF: renamed from: w (java.lang.String, java.lang.String, java.lang.Throwable) void
   public static void method_438(String var0, String var1, Throwable var2) {
      if(sHandler.isLoggable(5)) {
         sHandler.method_18(var0, var1, var2);
      }

   }

   // $FF: renamed from: w (java.lang.String, java.lang.String, java.lang.Object[]) void
   public static void method_439(String var0, String var1, Object... var2) {
      if(sHandler.isLoggable(5)) {
         sHandler.method_17(var0, formatString(var1, var2));
      }

   }

   // $FF: renamed from: w (java.lang.String, java.lang.Throwable, java.lang.String, java.lang.Object[]) void
   public static void method_440(String var0, Throwable var1, String var2, Object... var3) {
      if(sHandler.isLoggable(5)) {
         sHandler.method_18(var0, formatString(var2, var3), var1);
      }

   }

   public static void wtf(Class<?> var0, String var1) {
      if(sHandler.isLoggable(6)) {
         sHandler.wtf(getTag(var0), var1);
      }

   }

   public static void wtf(Class<?> var0, String var1, Throwable var2) {
      if(sHandler.isLoggable(6)) {
         sHandler.wtf(getTag(var0), var1, var2);
      }

   }

   public static void wtf(Class<?> var0, String var1, Object... var2) {
      if(sHandler.isLoggable(6)) {
         sHandler.wtf(getTag(var0), formatString(var1, var2));
      }

   }

   public static void wtf(Class<?> var0, Throwable var1, String var2, Object... var3) {
      if(sHandler.isLoggable(6)) {
         sHandler.wtf(getTag(var0), formatString(var2, var3), var1);
      }

   }

   public static void wtf(String var0, String var1) {
      if(sHandler.isLoggable(6)) {
         sHandler.wtf(var0, var1);
      }

   }

   public static void wtf(String var0, String var1, Throwable var2) {
      if(sHandler.isLoggable(6)) {
         sHandler.wtf(var0, var1, var2);
      }

   }

   public static void wtf(String var0, String var1, Object... var2) {
      if(sHandler.isLoggable(6)) {
         sHandler.wtf(var0, formatString(var1, var2));
      }

   }

   public static void wtf(String var0, Throwable var1, String var2, Object... var3) {
      if(sHandler.isLoggable(6)) {
         sHandler.wtf(var0, formatString(var2, var3), var1);
      }

   }
}
