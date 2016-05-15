package com.newrelic.agent.android.instrumentation;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.BitmapFactory.Options;
import android.util.TypedValue;
import com.newrelic.agent.android.instrumentation.MetricCategory;
import com.newrelic.agent.android.instrumentation.ReplaceCallSite;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.io.FileDescriptor;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class BitmapFactoryInstrumentation {
   private static final ArrayList<String> categoryParams;

   static {
      String[] var0 = new String[]{"category", MetricCategory.class.getName(), "IMAGE"};
      categoryParams = new ArrayList(Arrays.asList(var0));
   }

   @ReplaceCallSite(
      isStatic = true,
      scope = "android.graphics.BitmapFactory"
   )
   public static Bitmap decodeByteArray(byte[] var0, int var1, int var2) {
      TraceMachine.enterMethod("BitmapFactory#decodeByteArray", categoryParams);
      Bitmap var3 = BitmapFactory.decodeByteArray(var0, var1, var2);
      TraceMachine.exitMethod();
      return var3;
   }

   @ReplaceCallSite(
      isStatic = true,
      scope = "android.graphics.BitmapFactory"
   )
   public static Bitmap decodeByteArray(byte[] var0, int var1, int var2, Options var3) {
      TraceMachine.enterMethod("BitmapFactory#decodeByteArray", categoryParams);
      Bitmap var4 = BitmapFactory.decodeByteArray(var0, var1, var2, var3);
      TraceMachine.exitMethod();
      return var4;
   }

   @ReplaceCallSite(
      isStatic = true,
      scope = "android.graphics.BitmapFactory"
   )
   public static Bitmap decodeFile(String var0) {
      TraceMachine.enterMethod("BitmapFactory#decodeFile", categoryParams);
      Bitmap var1 = BitmapFactory.decodeFile(var0);
      TraceMachine.exitMethod();
      return var1;
   }

   @ReplaceCallSite(
      isStatic = true,
      scope = "android.graphics.BitmapFactory"
   )
   public static Bitmap decodeFile(String var0, Options var1) {
      TraceMachine.enterMethod("BitmapFactory#decodeFile", categoryParams);
      Bitmap var2 = BitmapFactory.decodeFile(var0, var1);
      TraceMachine.exitMethod();
      return var2;
   }

   @ReplaceCallSite(
      isStatic = true,
      scope = "android.graphics.BitmapFactory"
   )
   public static Bitmap decodeFileDescriptor(FileDescriptor var0) {
      TraceMachine.enterMethod("BitmapFactory#decodeFileDescriptor", categoryParams);
      Bitmap var1 = BitmapFactory.decodeFileDescriptor(var0);
      TraceMachine.exitMethod();
      return var1;
   }

   @ReplaceCallSite(
      isStatic = true,
      scope = "android.graphics.BitmapFactory"
   )
   public static Bitmap decodeFileDescriptor(FileDescriptor var0, Rect var1, Options var2) {
      TraceMachine.enterMethod("BitmapFactory#decodeFileDescriptor", categoryParams);
      Bitmap var3 = BitmapFactory.decodeFileDescriptor(var0, var1, var2);
      TraceMachine.exitMethod();
      return var3;
   }

   @ReplaceCallSite(
      isStatic = true,
      scope = "android.graphics.BitmapFactory"
   )
   public static Bitmap decodeResource(Resources var0, int var1) {
      TraceMachine.enterMethod("BitmapFactory#decodeResource", categoryParams);
      Bitmap var2 = BitmapFactory.decodeResource(var0, var1);
      TraceMachine.exitMethod();
      return var2;
   }

   @ReplaceCallSite(
      isStatic = true,
      scope = "android.graphics.BitmapFactory"
   )
   public static Bitmap decodeResource(Resources var0, int var1, Options var2) {
      TraceMachine.enterMethod("BitmapFactory#decodeResource", categoryParams);
      Bitmap var3 = BitmapFactory.decodeResource(var0, var1, var2);
      TraceMachine.exitMethod();
      return var3;
   }

   @ReplaceCallSite(
      isStatic = true,
      scope = "android.graphics.BitmapFactory"
   )
   public static Bitmap decodeResourceStream(Resources var0, TypedValue var1, InputStream var2, Rect var3, Options var4) {
      TraceMachine.enterMethod("BitmapFactory#decodeResourceStream", categoryParams);
      Bitmap var5 = BitmapFactory.decodeResourceStream(var0, var1, var2, var3, var4);
      TraceMachine.exitMethod();
      return var5;
   }

   @ReplaceCallSite(
      isStatic = true,
      scope = "android.graphics.BitmapFactory"
   )
   public static Bitmap decodeStream(InputStream var0) {
      TraceMachine.enterMethod("BitmapFactory#decodeStream", categoryParams);
      Bitmap var1 = BitmapFactory.decodeStream(var0);
      TraceMachine.exitMethod();
      return var1;
   }

   @ReplaceCallSite(
      isStatic = true,
      scope = "android.graphics.BitmapFactory"
   )
   public static Bitmap decodeStream(InputStream var0, Rect var1, Options var2) {
      TraceMachine.enterMethod("BitmapFactory#decodeStream", categoryParams);
      Bitmap var3 = BitmapFactory.decodeStream(var0, var1, var2);
      TraceMachine.exitMethod();
      return var3;
   }
}
