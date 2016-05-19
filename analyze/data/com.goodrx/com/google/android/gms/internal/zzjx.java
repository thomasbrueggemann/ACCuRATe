package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzjp;
import com.google.android.gms.internal.zzjv;

@zzhb
@TargetApi(14)
public final class zzjx extends zzjv {
   public zzjx(zzjp var1) {
      super(var1);
   }

   public void onShowCustomView(View var1, int var2, CustomViewCallback var3) {
      this.zza(var1, var2, var3);
   }
}
