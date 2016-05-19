package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzca;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzjp;
import com.google.android.gms.internal.zzjq;
import java.util.Map;
import org.json.JSONObject;

@zzhb
class zzjs extends FrameLayout implements zzjp {
   private final zzjp zzNN;
   private final zzjo zzNO;

   public zzjs(zzjp var1) {
      super(var1.getContext());
      this.zzNN = var1;
      this.zzNO = new zzjo(var1.zzhQ(), this, this);
      zzjq var2 = this.zzNN.zzhU();
      if(var2 != null) {
         var2.zzh((zzjp)this);
      }

      this.addView(this.zzNN.getView());
   }

   public View getView() {
      return this;
   }

   public WebView getWebView() {
      return this.zzNN.getWebView();
   }

   public boolean isDestroyed() {
      return this.zzNN.isDestroyed();
   }

   public void loadDataWithBaseURL(String var1, String var2, String var3, String var4, String var5) {
      this.zzNN.loadDataWithBaseURL(var1, var2, var3, var4, var5);
   }

   public void loadUrl(String var1) {
      this.zzNN.loadUrl(var1);
   }

   public void onPause() {
      this.zzNO.onPause();
      this.zzNN.onPause();
   }

   public void onResume() {
      this.zzNN.onResume();
   }

   public void setBackgroundColor(int var1) {
      this.zzNN.setBackgroundColor(var1);
   }

   public void setContext(Context var1) {
      this.zzNN.setContext(var1);
   }

   public void setOnClickListener(OnClickListener var1) {
      this.zzNN.setOnClickListener(var1);
   }

   public void setOnTouchListener(OnTouchListener var1) {
      this.zzNN.setOnTouchListener(var1);
   }

   public void setRequestedOrientation(int var1) {
      this.zzNN.setRequestedOrientation(var1);
   }

   public void setWebChromeClient(WebChromeClient var1) {
      this.zzNN.setWebChromeClient(var1);
   }

   public void setWebViewClient(WebViewClient var1) {
      this.zzNN.setWebViewClient(var1);
   }

   public void zzD(boolean var1) {
      this.zzNN.zzD(var1);
   }

   public void zzE(boolean var1) {
      this.zzNN.zzE(var1);
   }

   public void zzF(boolean var1) {
      this.zzNN.zzF(var1);
   }

   public void zza(AdSizeParcel var1) {
      this.zzNN.zza(var1);
   }

   public void zza(String var1, Map<String, ?> var2) {
      this.zzNN.zza(var1, var2);
   }

   public void zzaL(String var1) {
      this.zzNN.zzaL(var1);
   }

   public AdSizeParcel zzaN() {
      return this.zzNN.zzaN();
   }

   public void zzb(com.google.android.gms.ads.internal.overlay.zzd var1) {
      this.zzNN.zzb(var1);
   }

   public void zzb(String var1, JSONObject var2) {
      this.zzNN.zzb(var1, var2);
   }

   public void zzc(com.google.android.gms.ads.internal.overlay.zzd var1) {
      this.zzNN.zzc(var1);
   }

   public boolean zzfL() {
      return this.zzNN.zzfL();
   }

   public void zzfr() {
      this.zzNN.zzfr();
   }

   public void zzhN() {
      this.zzNN.zzhN();
   }

   public Activity zzhP() {
      return this.zzNN.zzhP();
   }

   public Context zzhQ() {
      return this.zzNN.zzhQ();
   }

   public com.google.android.gms.ads.internal.zzd zzhR() {
      return this.zzNN.zzhR();
   }

   public com.google.android.gms.ads.internal.overlay.zzd zzhS() {
      return this.zzNN.zzhS();
   }

   public com.google.android.gms.ads.internal.overlay.zzd zzhT() {
      return this.zzNN.zzhT();
   }

   public zzjq zzhU() {
      return this.zzNN.zzhU();
   }

   public boolean zzhV() {
      return this.zzNN.zzhV();
   }

   public zzan zzhW() {
      return this.zzNN.zzhW();
   }

   public VersionInfoParcel zzhX() {
      return this.zzNN.zzhX();
   }

   public boolean zzhY() {
      return this.zzNN.zzhY();
   }

   public void zzhZ() {
      this.zzNO.onDestroy();
      this.zzNN.zzhZ();
   }

   public zzjo zzia() {
      return this.zzNO;
   }

   public zzbz zzib() {
      return this.zzNN.zzib();
   }

   public zzca zzic() {
      return this.zzNN.zzic();
   }

   public void zzid() {
      this.zzNN.zzid();
   }

   public void zzie() {
      this.zzNN.zzie();
   }

   public void zzy(int var1) {
      this.zzNN.zzy(var1);
   }
}
