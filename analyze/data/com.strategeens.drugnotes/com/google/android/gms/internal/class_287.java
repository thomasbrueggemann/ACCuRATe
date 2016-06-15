package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.internal.class_166;
import com.google.android.gms.internal.class_19;
import com.google.android.gms.internal.class_283;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_814;
import com.google.android.gms.internal.class_815;
import com.google.android.gms.internal.class_817;
import com.google.android.gms.internal.class_818;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.oq;

// $FF: renamed from: com.google.android.gms.internal.ox
public class class_287 extends jl<oq> {
   // $FF: renamed from: CS java.lang.String
   private final String field_604;
   private final class_815 anm;
   private final class_817 ann;
   private boolean ano;
   // $FF: renamed from: mH java.lang.Object
   private final Object field_605;

   public class_287(Context var1, class_815 var2) {
      super(var1, var2, var2, new String[0]);
      this.field_604 = var1.getPackageName();
      this.anm = (class_815)class_335.method_2311(var2);
      this.anm.method_4465(this);
      this.ann = new class_817();
      this.field_605 = new Object();
      this.ano = true;
   }

   // $FF: renamed from: c (com.google.android.gms.internal.ov, com.google.android.gms.internal.or) void
   private void method_1831(class_814 var1, class_818 var2) {
      this.ann.method_4470(var1, var2);
   }

   // $FF: renamed from: d (com.google.android.gms.internal.ov, com.google.android.gms.internal.or) void
   private void method_1832(class_814 var1, class_818 var2) {
      try {
         this.method_1833();
         ((class_166)this.hw()).method_841(this.field_604, var1, var2);
      } catch (RemoteException var6) {
         Log.e("PlayLoggerImpl", "Couldn\'t send log event.  Will try caching.");
         this.method_1831(var1, var2);
      } catch (IllegalStateException var7) {
         Log.e("PlayLoggerImpl", "Service was disconnected.  Will try caching.");
         this.method_1831(var1, var2);
      }
   }

   // $FF: renamed from: or () void
   private void method_1833() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: U (boolean) void
   void method_1834(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.internal.jt, com.google.android.gms.internal.jl$e) void
   protected void method_1792(class_19 var1, class_283.class_1230 var2) throws RemoteException {
      Bundle var3 = new Bundle();
      var1.method_149(var2, 6587000, this.getContext().getPackageName(), var3);
   }

   // $FF: renamed from: b (com.google.android.gms.internal.ov, com.google.android.gms.internal.or) void
   public void method_1835(class_814 param1, class_818 param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: bJ (android.os.IBinder) com.google.android.gms.internal.oq
   protected class_166 method_1836(IBinder var1) {
      return class_166.class_1132.method_3812(var1);
   }

   // $FF: renamed from: bK () java.lang.String
   protected String method_1794() {
      return "com.google.android.gms.playlog.service.START";
   }

   // $FF: renamed from: bL () java.lang.String
   protected String method_1795() {
      return "com.google.android.gms.playlog.internal.IPlayLogService";
   }

   // $FF: renamed from: l (android.os.IBinder) android.os.IInterface
   // $FF: synthetic method
   protected IInterface method_1800(IBinder var1) {
      return this.method_1836(var1);
   }

   public void start() {
      // $FF: Couldn't be decompiled
   }

   public void stop() {
      // $FF: Couldn't be decompiled
   }
}
