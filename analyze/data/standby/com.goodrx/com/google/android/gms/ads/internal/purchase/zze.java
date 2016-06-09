package com.google.android.gms.ads.internal.purchase;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel;
import com.google.android.gms.ads.internal.purchase.zzb;
import com.google.android.gms.ads.internal.purchase.zzf;
import com.google.android.gms.ads.internal.purchase.zzh;
import com.google.android.gms.ads.internal.purchase.zzj;
import com.google.android.gms.ads.internal.purchase.zzk;
import com.google.android.gms.internal.zzgc;
import com.google.android.gms.internal.zzge;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;

@zzhb
public class zze extends zzge.zza implements ServiceConnection {
   private final Activity mActivity;
   private zzb zzFC;
   zzh zzFD;
   private zzk zzFF;
   private Context zzFK;
   private zzgc zzFL;
   private zzf zzFM;
   private zzj zzFN;
   private String zzFO = null;

   public zze(Activity var1) {
      this.mActivity = var1;
      this.zzFD = zzh.zzy(this.mActivity.getApplicationContext());
   }

   public void onActivityResult(int param1, int param2, Intent param3) {
      // $FF: Couldn't be decompiled
   }

   public void onCreate() {
      GInAppPurchaseManagerInfoParcel var1 = GInAppPurchaseManagerInfoParcel.zzc(this.mActivity.getIntent());
      this.zzFN = var1.zzFy;
      this.zzFF = var1.zzrI;
      this.zzFL = var1.zzFw;
      this.zzFC = new zzb(this.mActivity.getApplicationContext());
      this.zzFK = var1.zzFx;
      if(this.mActivity.getResources().getConfiguration().orientation == 2) {
         this.mActivity.setRequestedOrientation(zzr.zzbE().zzhv());
      } else {
         this.mActivity.setRequestedOrientation(zzr.zzbE().zzhw());
      }

      Intent var2 = new Intent("com.android.vending.billing.InAppBillingService.BIND");
      var2.setPackage("com.android.vending");
      this.mActivity.bindService(var2, this, 1);
   }

   public void onDestroy() {
      this.mActivity.unbindService(this);
      this.zzFC.destroy();
   }

   public void onServiceConnected(ComponentName param1, IBinder param2) {
      // $FF: Couldn't be decompiled
   }

   public void onServiceDisconnected(ComponentName var1) {
      zzin.zzaJ("In-app billing service disconnected.");
      this.zzFC.destroy();
   }

   protected void zza(String var1, boolean var2, int var3, Intent var4) {
      if(this.zzFN != null) {
         this.zzFN.zza(var1, var2, var3, var4, this.zzFM);
      }

   }
}
