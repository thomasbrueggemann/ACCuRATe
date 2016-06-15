package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Handler.Callback;
import java.util.HashMap;
import java.util.HashSet;

// $FF: renamed from: com.google.android.gms.internal.he
public final class class_354 implements Callback {
   // $FF: renamed from: Gs java.lang.Object
   private static final Object field_1529 = new Object();
   // $FF: renamed from: Gt com.google.android.gms.internal.he
   private static class_354 field_1530;
   // $FF: renamed from: Gu java.util.HashMap
   private final HashMap<String, class_354.class_1126> field_1531;
   // $FF: renamed from: lx android.content.Context
   private final Context field_1532;
   private final Handler mHandler;

   private class_354(Context var1) {
      this.mHandler = new Handler(var1.getMainLooper(), this);
      this.field_1531 = new HashMap();
      this.field_1532 = var1.getApplicationContext();
   }

   // $FF: renamed from: B (android.content.Context) com.google.android.gms.internal.he
   public static class_354 method_2240(Context param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.internal.he) java.util.HashMap
   // $FF: synthetic method
   static HashMap method_2241(class_354 var0) {
      return var0.field_1531;
   }

   // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.hc$f) boolean
   public boolean method_2242(String param1, com/google/android/gms/internal/hc<?>.f param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (java.lang.String, com.google.android.gms.internal.hc$f) void
   public void method_2243(String param1, com/google/android/gms/internal/hc<?>.f param2) {
      // $FF: Couldn't be decompiled
   }

   public boolean handleMessage(Message param1) {
      // $FF: Couldn't be decompiled
   }

   final class class_1126 {
      // $FF: renamed from: GA android.content.ComponentName
      private ComponentName field_4267;
      // $FF: renamed from: Gv java.lang.String
      private final String field_4269;
      // $FF: renamed from: Gw com.google.android.gms.internal.he$a$a
      private final class_354.class_1127 field_4270;
      // $FF: renamed from: Gx java.util.HashSet
      private final HashSet<com/google/android/gms/internal/hc<?>.f> field_4271;
      // $FF: renamed from: Gy boolean
      private boolean field_4272;
      // $FF: renamed from: Gz android.os.IBinder
      private IBinder field_4273;
      private int mState;

      public class_1126(String var2) {
         this.field_4269 = var2;
         this.field_4270 = new class_354.class_1127();
         this.field_4271 = new HashSet();
         this.mState = 0;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.he$a, int) int
      // $FF: synthetic method
      static int method_4499(class_354.class_1126 var0, int var1) {
         var0.mState = var1;
         return var1;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.he$a, android.content.ComponentName) android.content.ComponentName
      // $FF: synthetic method
      static ComponentName method_4500(class_354.class_1126 var0, ComponentName var1) {
         var0.field_4267 = var1;
         return var1;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.he$a, android.os.IBinder) android.os.IBinder
      // $FF: synthetic method
      static IBinder method_4501(class_354.class_1126 var0, IBinder var1) {
         var0.field_4273 = var1;
         return var1;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.he$a) java.util.HashSet
      // $FF: synthetic method
      static HashSet method_4502(class_354.class_1126 var0) {
         return var0.field_4271;
      }

      // $FF: renamed from: B (boolean) void
      public void method_4503(boolean var1) {
         this.field_4272 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.hc$f) void
      public void method_4504(com/google/android/gms/internal/hc<?>.f var1) {
         this.field_4271.add(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.hc$f) void
      public void method_4505(com/google/android/gms/internal/hc<?>.f var1) {
         this.field_4271.remove(var1);
      }

      // $FF: renamed from: c (com.google.android.gms.internal.hc$f) boolean
      public boolean method_4506(com/google/android/gms/internal/hc<?>.f var1) {
         return this.field_4271.contains(var1);
      }

      // $FF: renamed from: fs () com.google.android.gms.internal.he$a$a
      public class_354.class_1127 method_4507() {
         return this.field_4270;
      }

      // $FF: renamed from: ft () java.lang.String
      public String method_4508() {
         return this.field_4269;
      }

      // $FF: renamed from: fu () boolean
      public boolean method_4509() {
         return this.field_4271.isEmpty();
      }

      public IBinder getBinder() {
         return this.field_4273;
      }

      public ComponentName getComponentName() {
         return this.field_4267;
      }

      public int getState() {
         return this.mState;
      }

      public boolean isBound() {
         return this.field_4272;
      }
   }

   public class class_1127 implements ServiceConnection {
      public void onServiceConnected(ComponentName param1, IBinder param2) {
         // $FF: Couldn't be decompiled
      }

      public void onServiceDisconnected(ComponentName param1) {
         // $FF: Couldn't be decompiled
      }
   }
}
