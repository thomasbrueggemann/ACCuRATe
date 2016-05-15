package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewParent;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzca;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzjq;
import java.util.Map;

@zzhb
public interface zzjp extends zzeh {
   Context getContext();

   LayoutParams getLayoutParams();

   void getLocationOnScreen(int[] var1);

   int getMeasuredHeight();

   int getMeasuredWidth();

   ViewParent getParent();

   View getView();

   WebView getWebView();

   boolean isDestroyed();

   void loadDataWithBaseURL(String var1, String var2, String var3, String var4, String var5);

   void loadUrl(String var1);

   void measure(int var1, int var2);

   void onPause();

   void onResume();

   void setBackgroundColor(int var1);

   void setContext(Context var1);

   void setOnClickListener(OnClickListener var1);

   void setOnTouchListener(OnTouchListener var1);

   void setRequestedOrientation(int var1);

   void setWebChromeClient(WebChromeClient var1);

   void setWebViewClient(WebViewClient var1);

   void zzD(boolean var1);

   void zzE(boolean var1);

   void zzF(boolean var1);

   void zza(AdSizeParcel var1);

   void zza(String var1, Map<String, ?> var2);

   void zzaL(String var1);

   AdSizeParcel zzaN();

   void zzb(com.google.android.gms.ads.internal.overlay.zzd var1);

   void zzc(com.google.android.gms.ads.internal.overlay.zzd var1);

   boolean zzfL();

   void zzfr();

   void zzhN();

   Activity zzhP();

   Context zzhQ();

   com.google.android.gms.ads.internal.zzd zzhR();

   com.google.android.gms.ads.internal.overlay.zzd zzhS();

   com.google.android.gms.ads.internal.overlay.zzd zzhT();

   zzjq zzhU();

   boolean zzhV();

   zzan zzhW();

   VersionInfoParcel zzhX();

   boolean zzhY();

   void zzhZ();

   @Nullable
   zzjo zzia();

   @Nullable
   zzbz zzib();

   zzca zzic();

   void zzid();

   void zzie();

   void zzy(int var1);
}
