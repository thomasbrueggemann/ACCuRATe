package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.Fragment;

public class zzh implements OnClickListener {
   private final Activity mActivity;
   private final Intent mIntent;
   private final int zzagz;
   private final Fragment zzalg;

   public zzh(Activity var1, Intent var2, int var3) {
      this.mActivity = var1;
      this.zzalg = null;
      this.mIntent = var2;
      this.zzagz = var3;
   }

   public zzh(Fragment var1, Intent var2, int var3) {
      this.mActivity = null;
      this.zzalg = var1;
      this.mIntent = var2;
      this.zzagz = var3;
   }

   public void onClick(DialogInterface param1, int param2) {
      // $FF: Couldn't be decompiled
   }
}
