package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.zzhb;

@zzhb
public class zzio extends Handler {
   public zzio(Looper var1) {
      super(var1);
   }

   public void handleMessage(Message var1) {
      try {
         super.handleMessage(var1);
      } catch (Exception var3) {
         com.google.android.gms.ads.internal.zzr.zzbF().zzb(var3, false);
         throw var3;
      }
   }
}
