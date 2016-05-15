package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zziw;
import com.google.android.gms.internal.zzjp;
import com.google.android.gms.internal.zzjq;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzhb
@TargetApi(11)
public class zzjw extends zzjq {
   public zzjw(zzjp var1, boolean var2) {
      super(var1, var2);
   }

   public WebResourceResponse shouldInterceptRequest(WebView param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   protected WebResourceResponse zzd(Context var1, String var2, String var3) throws IOException, ExecutionException, InterruptedException, TimeoutException {
      HashMap var4 = new HashMap();
      var4.put("User-Agent", com.google.android.gms.ads.internal.zzr.zzbC().zze(var1, var2));
      var4.put("Cache-Control", "max-stale=3600");
      String var7 = (String)(new zziw(var1)).zzb(var3, var4).get(60L, TimeUnit.SECONDS);
      return var7 == null?null:new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(var7.getBytes("UTF-8")));
   }
}
