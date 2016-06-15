package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ViewSwitcher;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.class_198;
import com.google.android.gms.dynamic.class_960;
import com.google.android.gms.internal.class_10;
import com.google.android.gms.internal.class_199;
import com.google.android.gms.internal.class_200;
import com.google.android.gms.internal.class_207;
import com.google.android.gms.internal.class_208;
import com.google.android.gms.internal.class_218;
import com.google.android.gms.internal.class_226;
import com.google.android.gms.internal.class_227;
import com.google.android.gms.internal.class_237;
import com.google.android.gms.internal.class_238;
import com.google.android.gms.internal.class_24;
import com.google.android.gms.internal.class_240;
import com.google.android.gms.internal.class_241;
import com.google.android.gms.internal.class_243;
import com.google.android.gms.internal.class_29;
import com.google.android.gms.internal.class_3;
import com.google.android.gms.internal.class_31;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_36;
import com.google.android.gms.internal.class_360;
import com.google.android.gms.internal.class_365;
import com.google.android.gms.internal.class_367;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_369;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.class_375;
import com.google.android.gms.internal.class_376;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.class_382;
import com.google.android.gms.internal.class_4;
import com.google.android.gms.internal.class_406;
import com.google.android.gms.internal.class_41;
import com.google.android.gms.internal.class_411;
import com.google.android.gms.internal.class_413;
import com.google.android.gms.internal.class_414;
import com.google.android.gms.internal.class_415;
import com.google.android.gms.internal.class_418;
import com.google.android.gms.internal.class_419;
import com.google.android.gms.internal.class_42;
import com.google.android.gms.internal.class_420;
import com.google.android.gms.internal.class_43;
import com.google.android.gms.internal.class_431;
import com.google.android.gms.internal.class_432;
import com.google.android.gms.internal.class_437;
import com.google.android.gms.internal.class_44;
import com.google.android.gms.internal.class_440;
import com.google.android.gms.internal.class_445;
import com.google.android.gms.internal.class_447;
import com.google.android.gms.internal.class_45;
import com.google.android.gms.internal.class_451;
import com.google.android.gms.internal.class_462;
import com.google.android.gms.internal.class_464;
import com.google.android.gms.internal.class_47;
import com.google.android.gms.internal.class_48;
import com.google.android.gms.internal.class_49;
import com.google.android.gms.internal.class_50;
import com.google.android.gms.internal.class_531;
import com.google.android.gms.internal.class_532;
import com.google.android.gms.internal.class_549;
import com.google.android.gms.internal.class_557;
import com.google.android.gms.internal.class_6;
import com.google.android.gms.internal.class_67;
import com.google.android.gms.internal.class_68;
import com.google.android.gms.internal.class_9;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.fz;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.u
@ey
public class class_548 extends class_6.class_1477 implements class_45, class_47, class_48, class_41, class_49, class_50, class_36, class_406.class_1529, class_437.class_1183, class_24, class_67, class_68 {
   // $FF: renamed from: lA com.google.android.gms.internal.cy
   private final class_43 field_2523;
   // $FF: renamed from: lB com.google.android.gms.internal.u$b
   private final class_548.class_1277 field_2524;
   // $FF: renamed from: lC com.google.android.gms.internal.ab
   private final class_207 field_2525;
   // $FF: renamed from: lD com.google.android.gms.internal.ae
   private final class_200 field_2526;
   // $FF: renamed from: lE boolean
   private boolean field_2527;
   // $FF: renamed from: lF android.content.ComponentCallbacks
   private final ComponentCallbacks field_2528;
   // $FF: renamed from: lz com.google.android.gms.internal.av
   private class_218 field_2529;

   public class_548(Context var1, class_237 var2, String var3, class_43 var4, class_369 var5) {
      this(new class_548.class_1277(var1, var2, var3, var5), var4, (class_207)null);
   }

   class_548(class_548.class_1277 var1, class_43 var2, class_207 var3) {
      this.field_2528 = new ComponentCallbacks() {
         public void onConfigurationChanged(Configuration var1) {
            if(class_548.this.field_2524 != null && class_548.this.field_2524.field_1953 != null && class_548.this.field_2524.field_1953.field_1393 != null) {
               class_548.this.field_2524.field_1953.field_1393.method_2527();
            }

         }

         public void onLowMemory() {
         }
      };
      this.field_2524 = var1;
      this.field_2523 = var2;
      if(var3 == null) {
         var3 = new class_207(this);
      }

      this.field_2525 = var3;
      this.field_2526 = new class_200();
      class_375.method_2577(this.field_2524.field_1946);
      class_381.method_2602(this.field_2524.field_1946, this.field_2524.field_1948);
      this.method_3318();
   }

   // $FF: renamed from: a (com.google.android.gms.internal.av, android.os.Bundle) com.google.android.gms.internal.fh$a
   private class_440.class_1527 method_3314(class_218 var1, Bundle var2) {
      ApplicationInfo var3 = this.field_2524.field_1946.getApplicationInfo();

      PackageInfo var5;
      label31: {
         PackageInfo var23;
         try {
            var23 = this.field_2524.field_1946.getPackageManager().getPackageInfo(var3.packageName, 0);
         } catch (NameNotFoundException var24) {
            var5 = null;
            break label31;
         }

         var5 = var23;
      }

      boolean var6 = this.field_2524.field_1952.field_447;
      Bundle var7 = null;
      if(!var6) {
         ViewParent var10 = this.field_2524.field_1944.getParent();
         var7 = null;
         if(var10 != null) {
            int[] var11 = new int[2];
            this.field_2524.field_1944.getLocationOnScreen(var11);
            int var12 = var11[0];
            int var13 = var11[1];
            DisplayMetrics var14 = this.field_2524.field_1946.getResources().getDisplayMetrics();
            int var15 = this.field_2524.field_1944.getWidth();
            int var16 = this.field_2524.field_1944.getHeight();
            boolean var17 = this.field_2524.field_1944.isShown();
            byte var18 = 0;
            if(var17) {
               int var19 = var12 + var15;
               var18 = 0;
               if(var19 > 0) {
                  int var20 = var13 + var16;
                  var18 = 0;
                  if(var20 > 0) {
                     int var21 = var14.widthPixels;
                     var18 = 0;
                     if(var12 <= var21) {
                        int var22 = var14.heightPixels;
                        var18 = 0;
                        if(var13 <= var22) {
                           var18 = 1;
                        }
                     }
                  }
               }
            }

            var7 = new Bundle(5);
            var7.putInt("x", var12);
            var7.putInt("y", var13);
            var7.putInt("width", var15);
            var7.putInt("height", var16);
            var7.putInt("visible", var18);
         }
      }

      String var8 = class_381.method_2608();
      this.field_2524.field_1955 = new class_431(var8, this.field_2524.field_1945);
      this.field_2524.field_1955.method_2851(var1);
      Bundle var9 = class_381.method_2601(this.field_2524.field_1946, this, var8);
      return new class_440.class_1527(var7, var1, this.field_2524.field_1952, this.field_2524.field_1945, var3, var5, var8, class_381.field_1166, this.field_2524.field_1948, var9, this.field_2524.field_1962, var2, class_381.method_2611());
   }

   // $FF: renamed from: a (com.google.android.gms.internal.v) com.google.android.gms.internal.gu
   private class_371 method_3315(class_549 var1) {
      if(this.field_2524.field_1952.field_447) {
         class_371 var4 = class_371.method_2515(this.field_2524.field_1946, this.field_2524.field_1952, false, false, this.field_2524.field_1947, this.field_2524.field_1948);
         var4.method_2531().method_2449(this, (class_49)null, this, this, true, this, this, var1);
         return var4;
      } else {
         View var2 = this.field_2524.field_1944.getNextView();
         class_371 var3;
         if(var2 instanceof class_371) {
            var3 = (class_371)var2;
            var3.method_2520(this.field_2524.field_1946, this.field_2524.field_1952);
         } else {
            if(var2 != null) {
               this.field_2524.field_1944.removeView(var2);
            }

            var3 = class_371.method_2515(this.field_2524.field_1946, this.field_2524.field_1952, false, false, this.field_2524.field_1947, this.field_2524.field_1948);
            if(this.field_2524.field_1952.field_448 == null) {
               this.method_3328(var3);
            }
         }

         var3.method_2531().method_2450(this, this, this, this, false, this, var1);
         return var3;
      }
   }

   // $FF: renamed from: a (int) void
   private void method_3317(int var1) {
      class_368.method_2506("Failed to load ad: " + var1);
      if(this.field_2524.field_1949 != null) {
         try {
            this.field_2524.field_1949.onAdFailedToLoad(var1);
         } catch (RemoteException var3) {
            class_368.method_2510("Could not call AdListener.onAdFailedToLoad().", var3);
            return;
         }
      }

   }

   // $FF: renamed from: ad () void
   private void method_3318() {
      if(VERSION.SDK_INT >= 14 && this.field_2524 != null && this.field_2524.field_1946 != null) {
         this.field_2524.field_1946.registerComponentCallbacks(this.field_2528);
      }

   }

   // $FF: renamed from: ae () void
   private void method_3319() {
      if(VERSION.SDK_INT >= 14 && this.field_2524 != null && this.field_2524.field_1946 != null) {
         this.field_2524.field_1946.unregisterComponentCallbacks(this.field_2528);
      }

   }

   // $FF: renamed from: ao () void
   private void method_3320() {
      class_368.method_2504("Ad closing.");
      if(this.field_2524.field_1949 != null) {
         try {
            this.field_2524.field_1949.onAdClosed();
         } catch (RemoteException var2) {
            class_368.method_2510("Could not call AdListener.onAdClosed().", var2);
            return;
         }
      }

   }

   // $FF: renamed from: ap () void
   private void method_3321() {
      class_368.method_2504("Ad leaving application.");
      if(this.field_2524.field_1949 != null) {
         try {
            this.field_2524.field_1949.onAdLeftApplication();
         } catch (RemoteException var2) {
            class_368.method_2510("Could not call AdListener.onAdLeftApplication().", var2);
            return;
         }
      }

   }

   // $FF: renamed from: aq () void
   private void method_3322() {
      class_368.method_2504("Ad opening.");
      if(this.field_2524.field_1949 != null) {
         try {
            this.field_2524.field_1949.onAdOpened();
         } catch (RemoteException var2) {
            class_368.method_2510("Could not call AdListener.onAdOpened().", var2);
            return;
         }
      }

   }

   // $FF: renamed from: ar () void
   private void method_3323() {
      class_368.method_2504("Ad finished loading.");
      if(this.field_2524.field_1949 != null) {
         try {
            this.field_2524.field_1949.onAdLoaded();
         } catch (RemoteException var2) {
            class_368.method_2510("Could not call AdListener.onAdLoaded().", var2);
            return;
         }
      }

   }

   // $FF: renamed from: as () void
   private void method_3324() {
      try {
         if(this.field_2524.field_1953.field_1406 instanceof class_240 && this.field_2524.field_1959 != null) {
            this.field_2524.field_1959.method_36((class_240)this.field_2524.field_1953.field_1406);
         }

      } catch (RemoteException var2) {
         class_368.method_2510("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", var2);
      }
   }

   // $FF: renamed from: at () void
   private void method_3325() {
      try {
         if(this.field_2524.field_1953.field_1406 instanceof class_241 && this.field_2524.field_1960 != null) {
            this.field_2524.field_1960.method_212((class_241)this.field_2524.field_1953.field_1406);
         }

      } catch (RemoteException var2) {
         class_368.method_2510("Could not call OnContentAdLoadedListener.onContentAdLoaded().", var2);
      }
   }

   // $FF: renamed from: ax () void
   private void method_3326() {
      if(this.field_2524.field_1953 != null) {
         if(this.field_2524.field_1966 == 0) {
            this.field_2524.field_1953.field_1393.destroy();
         }

         this.field_2524.field_1953 = null;
         this.field_2524.field_1968 = false;
      }

   }

   // $FF: renamed from: b (com.google.android.gms.internal.fy) boolean
   private boolean method_3327(class_432 var1) {
      if(var1.field_1397) {
         View var5;
         try {
            var5 = (View)class_960.method_5292(var1.field_1388.getView());
         } catch (RemoteException var10) {
            class_368.method_2510("Could not get View from mediation adapter.", var10);
            return false;
         }

         View var6 = this.field_2524.field_1944.getNextView();
         if(var6 != null) {
            this.field_2524.field_1944.removeView(var6);
         }

         try {
            this.method_3328(var5);
         } catch (Throwable var9) {
            class_368.method_2510("Could not add mediation view to view hierarchy.", var9);
            return false;
         }
      } else if(var1.field_1403 != null) {
         var1.field_1393.method_2521(var1.field_1403);
         this.field_2524.field_1944.removeAllViews();
         this.field_2524.field_1944.setMinimumWidth(var1.field_1403.widthPixels);
         this.field_2524.field_1944.setMinimumHeight(var1.field_1403.heightPixels);
         this.method_3328(var1.field_1393);
      }

      if(this.field_2524.field_1944.getChildCount() > 1) {
         this.field_2524.field_1944.showNext();
      }

      if(this.field_2524.field_1953 != null) {
         View var2 = this.field_2524.field_1944.getNextView();
         if(var2 instanceof class_371) {
            ((class_371)var2).method_2520(this.field_2524.field_1946, this.field_2524.field_1952);
         } else if(var2 != null) {
            this.field_2524.field_1944.removeView(var2);
         }

         if(this.field_2524.field_1953.field_1388 != null) {
            try {
               this.field_2524.field_1953.field_1388.destroy();
            } catch (RemoteException var8) {
               class_368.method_2506("Could not destroy previous mediation adapter.");
            }
         }
      }

      this.field_2524.field_1944.setVisibility(0);
      return true;
   }

   // $FF: renamed from: c (android.view.View) void
   private void method_3328(View var1) {
      LayoutParams var2 = new LayoutParams(-2, -2);
      this.field_2524.field_1944.addView(var1, var2);
   }

   // $FF: renamed from: e (boolean) void
   private void method_3329(boolean var1) {
      if(this.field_2524.field_1953 == null) {
         class_368.method_2506("Ad state was null when trying to ping impression URLs.");
      } else {
         class_368.method_2502("Pinging Impression URLs.");
         this.field_2524.field_1955.method_2848();
         if(this.field_2524.field_1953.field_1392 != null) {
            class_375.method_2555(this.field_2524.field_1946, this.field_2524.field_1948.field_1121, this.field_2524.field_1953.field_1392);
         }

         if(this.field_2524.field_1953.field_1402 != null && this.field_2524.field_1953.field_1402.field_1490 != null) {
            class_451.method_2918(this.field_2524.field_1946, this.field_2524.field_1948.field_1121, this.field_2524.field_1953, this.field_2524.field_1945, var1, this.field_2524.field_1953.field_1402.field_1490);
         }

         if(this.field_2524.field_1953.field_1387 != null && this.field_2524.field_1953.field_1387.field_1498 != null) {
            class_451.method_2918(this.field_2524.field_1946, this.field_2524.field_1948.field_1121, this.field_2524.field_1953, this.field_2524.field_1945, var1, this.field_2524.field_1953.field_1387.field_1498);
            return;
         }
      }

   }

   // $FF: renamed from: a (com.google.android.gms.internal.an) android.os.Bundle
   Bundle method_3330(class_226 var1) {
      if(var1 != null) {
         if(var1.method_1558()) {
            var1.wakeup();
         }

         class_227 var2 = var1.method_1556();
         String var3;
         if(var2 != null) {
            var3 = var2.method_1565();
            class_368.method_2502("In AdManger: loadAd, " + var2.toString());
         } else {
            var3 = null;
         }

         if(var3 != null) {
            Bundle var4 = new Bundle(1);
            var4.putString("fingerprint", var3);
            var4.putInt("v", 1);
            return var4;
         }
      }

      return null;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.ay) void
   public void method_10(class_237 var1) {
      class_335.method_2304("setAdSize must be called on the main UI thread.");
      this.field_2524.field_1952 = var1;
      if(this.field_2524.field_1953 != null && this.field_2524.field_1966 == 0) {
         this.field_2524.field_1953.field_1393.method_2521(var1);
      }

      if(this.field_2524.field_1944.getChildCount() > 1) {
         this.field_2524.field_1944.removeView(this.field_2524.field_1944.getNextView());
      }

      this.field_2524.field_1944.setMinimumWidth(var1.widthPixels);
      this.field_2524.field_1944.setMinimumHeight(var1.heightPixels);
      this.field_2524.field_1944.requestLayout();
   }

   // $FF: renamed from: a (com.google.android.gms.internal.bc) void
   public void method_11(class_4 var1) {
      class_335.method_2304("setAdListener must be called on the main UI thread.");
      this.field_2524.field_1949 = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.bf) void
   public void method_12(class_3 var1) {
      class_335.method_2304("setAppEventListener must be called on the main UI thread.");
      this.field_2524.field_1956 = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.br) void
   public void method_13(class_10 var1) {
      class_335.method_2304("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
      this.field_2524.field_1961 = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.en) void
   public void method_14(class_31 var1) {
      class_335.method_2304("setInAppPurchaseListener must be called on the main UI thread.");
      this.field_2524.field_1958 = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.er, java.lang.String) void
   public void method_15(class_29 var1, String var2) {
      class_335.method_2304("setPlayStorePurchaseParams must be called on the main UI thread.");
      this.field_2524.field_1963 = new class_415(var2);
      this.field_2524.field_1957 = var1;
      if(!class_381.method_2610() && var1 != null) {
         (new class_365(this.field_2524.field_1946, this.field_2524.field_1957, this.field_2524.field_1963)).start();
      }

   }

   // $FF: renamed from: a (com.google.android.gms.internal.fy$a) void
   public void method_916(class_432.class_1521 var1) {
      this.field_2524.field_1950 = null;
      this.field_2524.field_1954 = var1;
      this.method_3331((List)null);
      class_371 var3;
      if(!var1.field_4105.field_1457) {
         final class_549 var2 = new class_549();
         var3 = this.method_3315(var2);
         var2.method_3335(new class_549.class_1476(var1, var3));
         var3.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View var1, MotionEvent var2x) {
               var2.method_3336();
               return false;
            }
         });
         var3.setOnClickListener(new OnClickListener() {
            public void onClick(View var1) {
               var2.method_3336();
            }
         });
      } else {
         var3 = null;
      }

      if(var1.field_4099 != null) {
         this.field_2524.field_1952 = var1.field_4099;
      }

      if(var1.errorCode != -2) {
         this.method_225(new class_432(var1, var3, (class_447)null, (class_42)null, (String)null, (class_445)null, (class_238.class_1220)null));
      } else {
         if(!var1.field_4105.field_1447 && var1.field_4105.field_1456) {
            String var7 = var1.field_4105.field_1443;
            String var8 = null;
            if(var7 != null) {
               var8 = Uri.parse(var1.field_4105.field_1443).buildUpon().query((String)null).build().toString();
            }

            class_243 var9 = new class_243(this, var8, var1.field_4105.field_1445);

            try {
               if(this.field_2524.field_1961 != null) {
                  this.field_2524.field_1966 = 1;
                  this.field_2524.field_1961.method_37(var9);
                  return;
               }
            } catch (RemoteException var11) {
               class_368.method_2510("Could not call the onCustomRenderedAdLoadedListener.", var11);
            }
         }

         this.field_2524.field_1966 = 0;
         class_548.class_1277 var4 = this.field_2524;
         Context var5 = this.field_2524.field_1946;
         class_43 var6 = this.field_2523;
         var4.field_1951 = class_437.method_2875(var5, this, var1, var3, var6, this);
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.fy) void
   public void method_225(class_432 var1) {
      this.field_2524.field_1951 = null;
      boolean var2;
      if(var1.field_1406 != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      if(var1.errorCode != -2 && var1.errorCode != 3) {
         class_381.method_2604(this.field_2524.method_3227());
      }

      if(var1.errorCode != -1) {
         if(this.method_3332(var1, var2)) {
            class_368.method_2502("Ad refresh scheduled.");
         }

         if(var1.errorCode == 3 && var1.field_1402 != null && var1.field_1402.field_1491 != null) {
            class_368.method_2502("Pinging no fill URLs.");
            class_451.method_2918(this.field_2524.field_1946, this.field_2524.field_1948.field_1121, var1, this.field_2524.field_1945, false, var1.field_1402.field_1491);
         }

         if(var1.errorCode != -2) {
            this.method_3317(var1.errorCode);
            return;
         }

         if(!this.field_2524.field_1952.field_447 && !var2 && this.field_2524.field_1966 == 0) {
            if(!this.method_3327(var1)) {
               this.method_3317(0);
               return;
            }

            if(this.field_2524.field_1944 != null) {
               this.field_2524.field_1944.field_1970.method_2586(var1.field_1400);
            }
         }

         if(this.field_2524.field_1953 != null && this.field_2524.field_1953.field_1390 != null) {
            this.field_2524.field_1953.field_1390.method_2894((class_41)null);
         }

         if(var1.field_1390 != null) {
            var1.field_1390.method_2894(this);
         }

         this.field_2526.method_1101(this.field_2524.field_1953);
         this.field_2524.field_1953 = var1;
         this.field_2524.field_1955.method_2852(var1.field_1404);
         this.field_2524.field_1955.method_2853(var1.field_1405);
         this.field_2524.field_1955.method_2854(this.field_2524.field_1952.field_447);
         this.field_2524.field_1955.method_2855(var1.field_1397);
         if(!this.field_2524.field_1952.field_447 && !var2 && this.field_2524.field_1966 == 0) {
            this.method_3329(false);
         }

         if(this.field_2524.field_1964 == null) {
            this.field_2524.field_1964 = new class_382(this.field_2524.field_1945);
         }

         int var3;
         int var4;
         if(var1.field_1402 != null) {
            var4 = var1.field_1402.field_1485;
            var3 = var1.field_1402.field_1486;
         } else {
            var3 = 0;
            var4 = 0;
         }

         this.field_2524.field_1964.method_2633(var4, var3);
         if(this.field_2524.field_1966 == 0) {
            if(!this.field_2524.field_1952.field_447 && var1.field_1393 != null && (var1.field_1393.method_2531().method_2457() || var1.field_1401 != null)) {
               class_199 var7 = this.field_2526.method_1099(this.field_2524.field_1952, this.field_2524.field_1953);
               if(var1.field_1393.method_2531().method_2457() && var7 != null) {
                  var7.method_1078(new class_208(var1.field_1393));
               }
            }

            if(this.field_2524.field_1953.field_1393 != null) {
               this.field_2524.field_1953.field_1393.method_2527();
               this.field_2524.field_1953.field_1393.method_2531().method_2458();
            }

            if(var2) {
               class_238.class_1220 var6 = var1.field_1406;
               if(var6 instanceof class_241 && this.field_2524.field_1960 != null) {
                  this.method_3325();
               } else {
                  if(!(var6 instanceof class_240) || this.field_2524.field_1959 == null) {
                     class_368.method_2506("No matching listener for retrieved native ad template.");
                     this.method_3317(0);
                     return;
                  }

                  this.method_3324();
               }
            }

            this.method_3323();
            return;
         }

         if(this.field_2524.field_1965 != null && var1.field_1401 != null) {
            this.field_2526.method_1098(this.field_2524.field_1946, this.field_2524.field_1952, this.field_2524.field_1953, this.field_2524.field_1965, this.field_2524.field_1948);
            return;
         }
      }

   }

   // $FF: renamed from: a (java.lang.String, java.util.ArrayList) void
   public void method_214(String var1, ArrayList<String> var2) {
      class_413 var3 = new class_413(var1, var2, this.field_2524.field_1946, this.field_2524.field_1948.field_1121);
      if(this.field_2524.field_1958 == null) {
         class_368.method_2506("InAppPurchaseListener is not set. Try to launch default purchase flow.");
         if(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.field_2524.field_1946) != 0) {
            class_368.method_2506("Google Play Service unavailable, cannot launch default purchase flow.");
         } else if(this.field_2524.field_1957 == null) {
            class_368.method_2506("PlayStorePurchaseListener is not set.");
         } else if(this.field_2524.field_1963 == null) {
            class_368.method_2506("PlayStorePurchaseVerifier is not initialized.");
         } else if(this.field_2524.field_1967) {
            class_368.method_2506("An in-app purchase request is already in progress, abort");
         } else {
            this.field_2524.field_1967 = true;

            try {
               if(!this.field_2524.field_1957.isValidPurchase(var1)) {
                  this.field_2524.field_1967 = false;
                  return;
               }
            } catch (RemoteException var7) {
               class_368.method_2506("Could not start In-App purchase.");
               this.field_2524.field_1967 = false;
               return;
            }

            class_418.method_2774(this.field_2524.field_1946, this.field_2524.field_1948.field_1124, new class_411(this.field_2524.field_1946, this.field_2524.field_1963, var3, this));
         }
      } else {
         try {
            this.field_2524.field_1958.method_190(var3);
         } catch (RemoteException var6) {
            class_368.method_2506("Could not start In-App purchase.");
         }
      }
   }

   // $FF: renamed from: a (java.lang.String, boolean, int, android.content.Intent, com.google.android.gms.internal.ef) void
   public void method_192(String var1, boolean var2, int var3, final Intent var4, class_419 var5) {
      try {
         if(this.field_2524.field_1957 != null) {
            this.field_2524.field_1957.method_189(new class_420(this.field_2524.field_1946, var1, var2, var3, var4, var5));
         }
      } catch (RemoteException var7) {
         class_368.method_2506("Fail to invoke PlayStorePurchaseListener.");
      }

      class_367.field_1120.postDelayed(new Runnable() {
         public void run() {
            if(class_414.method_2744(var4) == 0 && class_548.this.field_2524.field_1953 != null && class_548.this.field_2524.field_1953.field_1393 != null && class_548.this.field_2524.field_1953.field_1393.method_2530() != null) {
               class_548.this.field_2524.field_1953.field_1393.method_2530().close();
            }

            class_548.this.field_2524.field_1967 = false;
         }
      }, 500L);
   }

   // $FF: renamed from: a (java.util.HashSet) void
   public void method_176(HashSet<fz> var1) {
      this.field_2524.method_3226(var1);
   }

   // $FF: renamed from: a (java.util.List) void
   public void method_3331(List<String> var1) {
      class_335.method_2304("setNativeTemplates must be called on the main UI thread.");
      this.field_2524.field_1962 = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.av) boolean
   public boolean method_16(class_218 var1) {
      class_335.method_2304("loadAd must be called on the main UI thread.");
      if(this.field_2524.field_1950 == null && this.field_2524.field_1951 == null) {
         if(this.field_2524.field_1952.field_447 && this.field_2524.field_1953 != null) {
            class_368.method_2506("An interstitial is already loading. Aborting.");
            return false;
         }

         if(this.method_3333()) {
            class_368.method_2504("Starting ad request.");
            if(!var1.field_360) {
               class_368.method_2504("Use AdRequest.Builder.addTestDevice(\"" + class_367.method_2501(this.field_2524.field_1946) + "\") to get test ads on this device.");
            }

            Bundle var2 = this.method_3330(class_381.method_2607().method_2631(this.field_2524.field_1946));
            this.field_2525.cancel();
            this.field_2524.field_1966 = 0;
            class_440.class_1527 var3 = this.method_3314(var1, var2);
            this.field_2524.field_1950 = class_406.method_2712(this.field_2524.field_1946, var3, this.field_2524.field_1947, this);
            return true;
         }
      } else {
         if(this.field_2529 != null) {
            class_368.method_2506("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
         }

         this.field_2529 = var1;
      }

      return false;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.fy, boolean) boolean
   boolean method_3332(class_432 var1, boolean var2) {
      boolean var3 = false;
      class_218 var4;
      if(this.field_2529 != null) {
         var4 = this.field_2529;
         this.field_2529 = null;
      } else {
         var4 = var1.field_1394;
         Bundle var5 = var4.extras;
         var3 = false;
         if(var5 != null) {
            var3 = var4.extras.getBoolean("_noRefresh", false);
         }
      }

      boolean var6 = var3 | var2;
      if(this.field_2524.field_1952.field_447) {
         if(this.field_2524.field_1966 == 0) {
            class_375.method_2560(var1.field_1393);
         }
      } else if(!var6 && this.field_2524.field_1966 == 0) {
         if(var1.field_1386 > 0L) {
            this.field_2525.method_1493(var4, var1.field_1386);
         } else if(var1.field_1402 != null && var1.field_1402.field_1484 > 0L) {
            this.field_2525.method_1493(var4, var1.field_1402.field_1484);
         } else if(!var1.field_1397 && var1.errorCode == 2) {
            this.field_2525.method_1495(var4);
         }
      }

      return this.field_2525.method_1494();
   }

   // $FF: renamed from: ab () com.google.android.gms.dynamic.d
   public class_198 method_17() {
      class_335.method_2304("getAdFrame must be called on the main UI thread.");
      return class_960.method_5293(this.field_2524.field_1944);
   }

   // $FF: renamed from: ac () com.google.android.gms.internal.ay
   public class_237 method_18() {
      class_335.method_2304("getAdSize must be called on the main UI thread.");
      return this.field_2524.field_1952;
   }

   // $FF: renamed from: af () void
   public void method_218() {
      this.method_3321();
   }

   // $FF: renamed from: ag () void
   public void method_216() {
      this.field_2526.method_1101(this.field_2524.field_1953);
      if(this.field_2524.field_1952.field_447) {
         this.method_3326();
      }

      this.field_2527 = false;
      this.method_3320();
      this.field_2524.field_1955.method_2850();
   }

   // $FF: renamed from: ah () void
   public void method_217() {
      if(this.field_2524.field_1952.field_447) {
         this.method_3329(false);
      }

      this.field_2527 = true;
      this.method_3322();
   }

   // $FF: renamed from: ai () void
   public void method_201() {
      this.onAdClicked();
   }

   // $FF: renamed from: aj () void
   public void method_202() {
      this.method_216();
   }

   // $FF: renamed from: ak () void
   public void method_203() {
      this.method_218();
   }

   // $FF: renamed from: al () void
   public void method_204() {
      this.method_217();
   }

   // $FF: renamed from: am () void
   public void method_205() {
      if(this.field_2524.field_1953 != null) {
         class_368.method_2506("Mediation adapter " + this.field_2524.field_1953.field_1389 + " refreshed, but mediation adapters should never refresh.");
      }

      this.method_3329(true);
      this.method_3323();
   }

   // $FF: renamed from: an () void
   public void method_19() {
      class_335.method_2304("recordManualImpression must be called on the main UI thread.");
      if(this.field_2524.field_1953 == null) {
         class_368.method_2506("Ad state was null when trying to ping manual tracking URLs.");
      } else {
         class_368.method_2502("Pinging manual tracking URLs.");
         if(this.field_2524.field_1953.field_1399 != null) {
            class_375.method_2555(this.field_2524.field_1946, this.field_2524.field_1948.field_1121, this.field_2524.field_1953.field_1399);
            return;
         }
      }

   }

   // $FF: renamed from: au () boolean
   public boolean method_3333() {
      boolean var1 = true;
      if(!class_375.method_2563(this.field_2524.field_1946.getPackageManager(), this.field_2524.field_1946.getPackageName(), "android.permission.INTERNET")) {
         if(!this.field_2524.field_1952.field_447) {
            class_367.method_2498(this.field_2524.field_1944, this.field_2524.field_1952, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
         }

         var1 = false;
      }

      if(!class_375.method_2576(this.field_2524.field_1946)) {
         if(!this.field_2524.field_1952.field_447) {
            class_367.method_2498(this.field_2524.field_1944, this.field_2524.field_1952, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
         }

         var1 = false;
      }

      if(!var1 && !this.field_2524.field_1952.field_447) {
         this.field_2524.field_1944.setVisibility(0);
      }

      return var1;
   }

   // $FF: renamed from: av () void
   public void method_375() {
      if(this.field_2524.field_1953 == null) {
         class_368.method_2506("Ad state was null when trying to ping click URLs.");
      } else {
         class_368.method_2502("Pinging click URLs.");
         this.field_2524.field_1955.method_2849();
         if(this.field_2524.field_1953.field_1391 != null) {
            class_375.method_2555(this.field_2524.field_1946, this.field_2524.field_1948.field_1121, this.field_2524.field_1953.field_1391);
         }

         if(this.field_2524.field_1953.field_1402 != null && this.field_2524.field_1953.field_1402.field_1489 != null) {
            class_451.method_2918(this.field_2524.field_1946, this.field_2524.field_1948.field_1121, this.field_2524.field_1953, this.field_2524.field_1945, false, this.field_2524.field_1953.field_1402.field_1489);
            return;
         }
      }

   }

   // $FF: renamed from: aw () void
   public void method_376() {
      this.method_3329(false);
   }

   // $FF: renamed from: b (android.view.View) void
   public void method_377(View var1) {
      this.field_2524.field_1965 = var1;
      this.method_225(new class_432(this.field_2524.field_1954, (class_371)null, (class_447)null, (class_42)null, (String)null, (class_445)null, (class_238.class_1220)null));
   }

   // $FF: renamed from: b (com.google.android.gms.internal.av) void
   public void method_3334(class_218 var1) {
      ViewParent var2 = this.field_2524.field_1944.getParent();
      if(var2 instanceof View && ((View)var2).isShown() && class_375.method_2570() && !this.field_2527) {
         this.method_16(var1);
      } else {
         class_368.method_2504("Ad is not visible. Not refreshing ad.");
         this.field_2525.method_1495(var1);
      }
   }

   // $FF: renamed from: d (boolean) void
   public void method_215(boolean var1) {
      this.field_2524.field_1968 = var1;
   }

   public void destroy() {
      class_335.method_2304("destroy must be called on the main UI thread.");
      this.method_3319();
      this.field_2524.field_1949 = null;
      this.field_2524.field_1956 = null;
      this.field_2524.field_1957 = null;
      this.field_2524.field_1958 = null;
      this.field_2524.field_1961 = null;
      this.field_2525.cancel();
      this.field_2526.stop();
      this.stopLoading();
      if(this.field_2524.field_1944 != null) {
         this.field_2524.field_1944.removeAllViews();
      }

      if(this.field_2524.field_1953 != null && this.field_2524.field_1953.field_1393 != null) {
         this.field_2524.field_1953.field_1393.destroy();
      }

      if(this.field_2524.field_1953 != null && this.field_2524.field_1953.field_1388 != null) {
         try {
            this.field_2524.field_1953.field_1388.destroy();
         } catch (RemoteException var2) {
            class_368.method_2506("Could not destroy mediation adapter.");
            return;
         }
      }

   }

   public String getMediationAdapterClassName() {
      return this.field_2524.field_1953 != null?this.field_2524.field_1953.field_1389:null;
   }

   public boolean isReady() {
      class_335.method_2304("isLoaded must be called on the main UI thread.");
      return this.field_2524.field_1950 == null && this.field_2524.field_1951 == null && this.field_2524.field_1953 != null;
   }

   public void onAdClicked() {
      this.method_375();
   }

   public void onAppEvent(String var1, String var2) {
      if(this.field_2524.field_1956 != null) {
         try {
            this.field_2524.field_1956.onAppEvent(var1, var2);
         } catch (RemoteException var4) {
            class_368.method_2510("Could not call the AppEventListener.", var4);
            return;
         }
      }

   }

   public void pause() {
      class_335.method_2304("pause must be called on the main UI thread.");
      if(this.field_2524.field_1953 != null && this.field_2524.field_1966 == 0) {
         class_375.method_2560(this.field_2524.field_1953.field_1393);
      }

      if(this.field_2524.field_1953 != null && this.field_2524.field_1953.field_1388 != null) {
         try {
            this.field_2524.field_1953.field_1388.pause();
         } catch (RemoteException var2) {
            class_368.method_2506("Could not pause mediation adapter.");
         }
      }

      this.field_2526.pause();
      this.field_2525.pause();
   }

   public void resume() {
      class_335.method_2304("resume must be called on the main UI thread.");
      if(this.field_2524.field_1953 != null && this.field_2524.field_1966 == 0) {
         class_375.method_2565(this.field_2524.field_1953.field_1393);
      }

      if(this.field_2524.field_1953 != null && this.field_2524.field_1953.field_1388 != null) {
         try {
            this.field_2524.field_1953.field_1388.resume();
         } catch (RemoteException var2) {
            class_368.method_2506("Could not resume mediation adapter.");
         }
      }

      this.field_2525.resume();
      this.field_2526.resume();
   }

   public void showInterstitial() {
      class_335.method_2304("showInterstitial must be called on the main UI thread.");
      if(!this.field_2524.field_1952.field_447) {
         class_368.method_2506("Cannot call showInterstitial on a banner ad.");
      } else {
         if(this.field_2524.field_1953 == null) {
            class_368.method_2506("The interstitial has not loaded.");
            return;
         }

         if(this.field_2524.field_1966 != 1) {
            if(this.field_2524.field_1953.field_1393.method_2535()) {
               class_368.method_2506("The interstitial is already showing.");
               return;
            }

            this.field_2524.field_1953.field_1393.method_2538(true);
            if(this.field_2524.field_1953.field_1393.method_2531().method_2457() || this.field_2524.field_1953.field_1401 != null) {
               class_199 var1 = this.field_2526.method_1099(this.field_2524.field_1952, this.field_2524.field_1953);
               if(this.field_2524.field_1953.field_1393.method_2531().method_2457() && var1 != null) {
                  var1.method_1078(new class_208(this.field_2524.field_1953.field_1393));
               }
            }

            if(this.field_2524.field_1953.field_1397) {
               try {
                  this.field_2524.field_1953.field_1388.showInterstitial();
                  return;
               } catch (RemoteException var11) {
                  class_368.method_2510("Could not show interstitial.", var11);
                  this.method_3326();
                  return;
               }
            }

            class_531 var2 = new class_531(this.field_2524.field_1968, false);
            if(this.field_2524.field_1946 instanceof Activity) {
               Window var4 = ((Activity)this.field_2524.field_1946).getWindow();
               Rect var5 = new Rect();
               Rect var6 = new Rect();
               var4.getDecorView().getGlobalVisibleRect(var5);
               var4.getDecorView().getWindowVisibleDisplayFrame(var6);
               if(var5.bottom != 0 && var6.bottom != 0) {
                  boolean var8 = this.field_2524.field_1968;
                  boolean var9;
                  if(var5.top == var6.top) {
                     var9 = true;
                  } else {
                     var9 = false;
                  }

                  var2 = new class_531(var8, var9);
               }
            }

            class_462 var3 = new class_462(this, this, this, this.field_2524.field_1953.field_1393, this.field_2524.field_1953.orientation, this.field_2524.field_1948, this.field_2524.field_1953.field_1400, var2);
            class_464.method_2949(this.field_2524.field_1946, var3);
            return;
         }
      }

   }

   public void stopLoading() {
      class_335.method_2304("stopLoading must be called on the main UI thread.");
      if(this.field_2524.field_1953 != null && this.field_2524.field_1966 == 0) {
         this.field_2524.field_1953.field_1393.stopLoading();
         this.field_2524.field_1953 = null;
      }

      if(this.field_2524.field_1950 != null) {
         this.field_2524.field_1950.cancel();
      }

      if(this.field_2524.field_1951 != null) {
         this.field_2524.field_1951.cancel();
      }

   }

   @ey
   private static final class class_1278 extends ViewSwitcher {
      // $FF: renamed from: lJ com.google.android.gms.internal.gl
      private final class_376 field_1970;

      public class_1278(Context var1) {
         super(var1);
         this.field_1970 = new class_376(var1);
      }

      public boolean onInterceptTouchEvent(MotionEvent var1) {
         this.field_1970.method_2587(var1);
         return false;
      }
   }

   @ey
   static class class_1277 {
      // $FF: renamed from: lK com.google.android.gms.internal.u$a
      public final class_548.class_1278 field_1944;
      // $FF: renamed from: lL java.lang.String
      public final String field_1945;
      // $FF: renamed from: lM android.content.Context
      public final Context field_1946;
      // $FF: renamed from: lN com.google.android.gms.internal.k
      public final class_557 field_1947;
      // $FF: renamed from: lO com.google.android.gms.internal.gs
      public final class_369 field_1948;
      // $FF: renamed from: lP com.google.android.gms.internal.bc
      public class_4 field_1949;
      // $FF: renamed from: lQ com.google.android.gms.internal.gf
      public class_360 field_1950;
      // $FF: renamed from: lR com.google.android.gms.internal.gf
      public class_360 field_1951;
      // $FF: renamed from: lS com.google.android.gms.internal.ay
      public class_237 field_1952;
      // $FF: renamed from: lT com.google.android.gms.internal.fy
      public class_432 field_1953;
      // $FF: renamed from: lU com.google.android.gms.internal.fy$a
      public class_432.class_1521 field_1954;
      // $FF: renamed from: lV com.google.android.gms.internal.fz
      public class_431 field_1955;
      // $FF: renamed from: lW com.google.android.gms.internal.bf
      public class_3 field_1956;
      // $FF: renamed from: lX com.google.android.gms.internal.er
      public class_29 field_1957;
      // $FF: renamed from: lY com.google.android.gms.internal.en
      public class_31 field_1958;
      // $FF: renamed from: lZ com.google.android.gms.internal.by
      public class_9 field_1959;
      // $FF: renamed from: ma com.google.android.gms.internal.bz
      public class_44 field_1960;
      // $FF: renamed from: mb com.google.android.gms.internal.br
      public class_10 field_1961;
      // $FF: renamed from: mc java.util.List
      public List<String> field_1962;
      // $FF: renamed from: md com.google.android.gms.internal.ek
      public class_415 field_1963;
      // $FF: renamed from: me com.google.android.gms.internal.gd
      public class_382 field_1964 = null;
      // $FF: renamed from: mf android.view.View
      public View field_1965 = null;
      // $FF: renamed from: mg int
      public int field_1966 = 0;
      // $FF: renamed from: mh boolean
      public boolean field_1967 = false;
      // $FF: renamed from: mi boolean
      public boolean field_1968 = false;
      // $FF: renamed from: mj java.util.HashSet
      private HashSet<fz> field_1969 = null;

      public class_1277(Context var1, class_237 var2, String var3, class_369 var4) {
         if(var2.field_447) {
            this.field_1944 = null;
         } else {
            this.field_1944 = new class_548.class_1278(var1);
            this.field_1944.setMinimumWidth(var2.widthPixels);
            this.field_1944.setMinimumHeight(var2.heightPixels);
            this.field_1944.setVisibility(4);
         }

         this.field_1952 = var2;
         this.field_1945 = var3;
         this.field_1946 = var1;
         this.field_1948 = var4;
         this.field_1947 = new class_557(new class_532(this));
      }

      // $FF: renamed from: a (java.util.HashSet) void
      public void method_3226(HashSet<fz> var1) {
         this.field_1969 = var1;
      }

      // $FF: renamed from: ay () java.util.HashSet
      public HashSet<fz> method_3227() {
         return this.field_1969;
      }
   }
}
