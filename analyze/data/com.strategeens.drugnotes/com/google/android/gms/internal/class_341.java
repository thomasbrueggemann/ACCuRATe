package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Handler.Callback;
import java.util.HashMap;
import java.util.HashSet;

// $FF: renamed from: com.google.android.gms.internal.jn
public final class class_341 implements Callback {
   // $FF: renamed from: Nd java.lang.Object
   private static final Object field_904 = new Object();
   // $FF: renamed from: Ne com.google.android.gms.internal.jn
   private static class_341 field_905;
   // $FF: renamed from: Nf java.util.HashMap
   private final HashMap<String, class_341.class_1077> field_906;
   private final Handler mHandler;
   // $FF: renamed from: mO android.content.Context
   private final Context field_907;

   private class_341(Context var1) {
      this.mHandler = new Handler(var1.getMainLooper(), this);
      this.field_906 = new HashMap();
      this.field_907 = var1.getApplicationContext();
   }

   // $FF: renamed from: J (android.content.Context) com.google.android.gms.internal.jn
   public static class_341 method_2337(Context param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.internal.jn) java.util.HashMap
   // $FF: synthetic method
   static HashMap method_2338(class_341 var0) {
      return var0.field_906;
   }

   // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.jl$f) boolean
   public boolean method_2340(String param1, com/google/android/gms/internal/jl<?>.f param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (java.lang.String, com.google.android.gms.internal.jl$f) void
   public void method_2341(String param1, com/google/android/gms/internal/jl<?>.f param2) {
      // $FF: Couldn't be decompiled
   }

   public boolean handleMessage(Message param1) {
      // $FF: Couldn't be decompiled
   }

   final class class_1077 {
      // $FF: renamed from: Ng java.lang.String
      private final String field_4222;
      // $FF: renamed from: Nh com.google.android.gms.internal.jn$a$a
      private final class_341.class_1078 field_4223;
      // $FF: renamed from: Ni java.util.HashSet
      private final HashSet<com/google/android/gms/internal/jl<?>.f> field_4224;
      // $FF: renamed from: Nj boolean
      private boolean field_4225;
      // $FF: renamed from: Nk android.os.IBinder
      private IBinder field_4226;
      // $FF: renamed from: Nl android.content.ComponentName
      private ComponentName field_4227;
      private int mState;

      public class_1077(String var2) {
         this.field_4222 = var2;
         this.field_4223 = new class_341.class_1078();
         this.field_4224 = new HashSet();
         this.mState = 2;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.jn$a, int) int
      // $FF: synthetic method
      static int method_5452(class_341.class_1077 var0, int var1) {
         var0.mState = var1;
         return var1;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.jn$a, android.content.ComponentName) android.content.ComponentName
      // $FF: synthetic method
      static ComponentName method_5453(class_341.class_1077 var0, ComponentName var1) {
         var0.field_4227 = var1;
         return var1;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.jn$a, android.os.IBinder) android.os.IBinder
      // $FF: synthetic method
      static IBinder method_5454(class_341.class_1077 var0, IBinder var1) {
         var0.field_4226 = var1;
         return var1;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.jn$a) java.util.HashSet
      // $FF: synthetic method
      static HashSet method_5455(class_341.class_1077 var0) {
         return var0.field_4224;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.jl$f) void
      public void method_5456(com/google/android/gms/internal/jl<?>.f var1) {
         this.field_4224.add(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.jl$f) void
      public void method_5457(com/google/android/gms/internal/jl<?>.f var1) {
         this.field_4224.remove(var1);
      }

      // $FF: renamed from: c (com.google.android.gms.internal.jl$f) boolean
      public boolean method_5458(com/google/android/gms/internal/jl<?>.f var1) {
         return this.field_4224.contains(var1);
      }

      public IBinder getBinder() {
         return this.field_4226;
      }

      public ComponentName getComponentName() {
         return this.field_4227;
      }

      public int getState() {
         return this.mState;
      }

      // $FF: renamed from: hA () void
      public void method_5459() {
         Intent var1 = (new Intent(this.field_4222)).setPackage("com.google.android.gms");
         this.field_4225 = class_341.this.field_907.bindService(var1, this.field_4223, 129);
         if(this.field_4225) {
            this.mState = 3;
         } else {
            class_341.this.field_907.unbindService(this.field_4223);
         }
      }

      // $FF: renamed from: hB () void
      public void method_5460() {
         class_341.this.field_907.unbindService(this.field_4223);
         this.field_4225 = false;
         this.mState = 2;
      }

      // $FF: renamed from: hC () java.lang.String
      public String method_5461() {
         return this.field_4222;
      }

      // $FF: renamed from: hD () boolean
      public boolean method_5462() {
         return this.field_4224.isEmpty();
      }

      public boolean isBound() {
         return this.field_4225;
      }
   }

   public class class_1078 implements ServiceConnection {
      public void onServiceConnected(ComponentName param1, IBinder param2) {
         // $FF: Couldn't be decompiled
      }

      public void onServiceDisconnected(ComponentName param1) {
         // $FF: Couldn't be decompiled
      }
   }
}
