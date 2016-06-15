package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.ViewGroup.LayoutParams;
import android.widget.ViewSwitcher;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.class_157;
import com.google.android.gms.dynamic.class_741;
import com.google.android.gms.internal.class_13;
import com.google.android.gms.internal.class_14;
import com.google.android.gms.internal.class_163;
import com.google.android.gms.internal.class_164;
import com.google.android.gms.internal.class_172;
import com.google.android.gms.internal.class_182;
import com.google.android.gms.internal.class_194;
import com.google.android.gms.internal.class_34;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.class_357;
import com.google.android.gms.internal.class_358;
import com.google.android.gms.internal.class_361;
import com.google.android.gms.internal.class_365;
import com.google.android.gms.internal.class_366;
import com.google.android.gms.internal.class_369;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.class_373;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_380;
import com.google.android.gms.internal.class_383;
import com.google.android.gms.internal.class_384;
import com.google.android.gms.internal.class_4;
import com.google.android.gms.internal.class_40;
import com.google.android.gms.internal.class_407;
import com.google.android.gms.internal.class_410;
import com.google.android.gms.internal.class_411;
import com.google.android.gms.internal.class_422;
import com.google.android.gms.internal.class_424;
import com.google.android.gms.internal.class_425;
import com.google.android.gms.internal.class_43;
import com.google.android.gms.internal.class_433;
import com.google.android.gms.internal.class_439;
import com.google.android.gms.internal.class_449;
import com.google.android.gms.internal.class_451;
import com.google.android.gms.internal.class_453;
import com.google.android.gms.internal.class_457;
import com.google.android.gms.internal.class_461;
import com.google.android.gms.internal.class_48;
import com.google.android.gms.internal.class_5;
import com.google.android.gms.internal.class_50;
import com.google.android.gms.internal.class_6;
import com.google.android.gms.internal.class_63;
import com.google.android.gms.internal.class_67;
import com.google.android.gms.internal.class_7;
import com.google.android.gms.internal.class_8;
import com.google.android.gms.internal.class_9;
import com.google.android.gms.internal.eh;
import com.google.android.gms.internal.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

// $FF: renamed from: com.google.android.gms.internal.v
public class class_452 extends class_6.class_996 implements class_8, class_9, class_7, class_14, class_43, class_40, class_425.class_1152, class_34, class_63 {
   // $FF: renamed from: kA com.google.android.gms.internal.v$c
   private final class_452.class_1131 field_2726;
   // $FF: renamed from: kB com.google.android.gms.internal.z
   private final class_451 field_2727;
   // $FF: renamed from: kC com.google.android.gms.internal.ac
   private final class_164 field_2728;
   // $FF: renamed from: kD boolean
   private boolean field_2729;
   // $FF: renamed from: kE android.content.ComponentCallbacks
   private final ComponentCallbacks field_2730 = new ComponentCallbacks() {
      public void onConfigurationChanged(Configuration var1) {
         if(class_452.this.field_2726 != null && class_452.this.field_2726.field_3045 != null && class_452.this.field_2726.field_3045.field_1716 != null) {
            class_452.this.field_2726.field_3045.field_1716.method_2345();
         }

      }

      public void onLowMemory() {
      }
   };
   // $FF: renamed from: kz com.google.android.gms.internal.bu
   private final class_13 field_2731;

   public class_452(Context var1, class_172 var2, String var3, class_13 var4, class_373 var5) {
      this.field_2726 = new class_452.class_1131(var1, var2, var3, var5);
      this.field_2731 = var4;
      this.field_2727 = new class_451(this);
      this.field_2728 = new class_164();
      class_365.method_2310(var1);
      this.method_2795();
   }

   // $FF: renamed from: R () void
   private void method_2795() {
      if(VERSION.SDK_INT >= 14 && this.field_2726 != null && this.field_2726.field_3039 != null) {
         this.field_2726.field_3039.registerComponentCallbacks(this.field_2730);
      }

   }

   // $FF: renamed from: S () void
   private void method_2796() {
      if(VERSION.SDK_INT >= 14 && this.field_2726 != null && this.field_2726.field_3039 != null) {
         this.field_2726.field_3039.unregisterComponentCallbacks(this.field_2730);
      }

   }

   // $FF: renamed from: a (int) void
   private void method_2798(int var1) {
      class_370.method_2358("Failed to load ad: " + var1);
      if(this.field_2726.field_3042 != null) {
         try {
            this.field_2726.field_3042.onAdFailedToLoad(var1);
         } catch (RemoteException var3) {
            class_370.method_2361("Could not call AdListener.onAdFailedToLoad().", var3);
            return;
         }
      }

   }

   // $FF: renamed from: ac () void
   private void method_2799() {
      class_370.method_2356("Ad closing.");
      if(this.field_2726.field_3042 != null) {
         try {
            this.field_2726.field_3042.onAdClosed();
         } catch (RemoteException var2) {
            class_370.method_2361("Could not call AdListener.onAdClosed().", var2);
            return;
         }
      }

   }

   // $FF: renamed from: ad () void
   private void method_2800() {
      class_370.method_2356("Ad leaving application.");
      if(this.field_2726.field_3042 != null) {
         try {
            this.field_2726.field_3042.onAdLeftApplication();
         } catch (RemoteException var2) {
            class_370.method_2361("Could not call AdListener.onAdLeftApplication().", var2);
            return;
         }
      }

   }

   // $FF: renamed from: ae () void
   private void method_2801() {
      class_370.method_2356("Ad opening.");
      if(this.field_2726.field_3042 != null) {
         try {
            this.field_2726.field_3042.onAdOpened();
         } catch (RemoteException var2) {
            class_370.method_2361("Could not call AdListener.onAdOpened().", var2);
            return;
         }
      }

   }

   // $FF: renamed from: af () void
   private void method_2802() {
      class_370.method_2356("Ad finished loading.");
      if(this.field_2726.field_3042 != null) {
         try {
            this.field_2726.field_3042.onAdLoaded();
         } catch (RemoteException var2) {
            class_370.method_2361("Could not call AdListener.onAdLoaded().", var2);
            return;
         }
      }

   }

   // $FF: renamed from: ag () boolean
   private boolean method_2803() {
      boolean var1 = true;
      if(!class_365.method_2298(this.field_2726.field_3039.getPackageManager(), this.field_2726.field_3039.getPackageName(), "android.permission.INTERNET")) {
         if(!this.field_2726.field_3044.field_570) {
            class_371.method_2368(this.field_2726.field_3037, this.field_2726.field_3044, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
         }

         var1 = false;
      }

      if(!class_365.method_2309(this.field_2726.field_3039)) {
         if(!this.field_2726.field_3044.field_570) {
            class_371.method_2368(this.field_2726.field_3037, this.field_2726.field_3044, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
         }

         var1 = false;
      }

      if(!var1 && !this.field_2726.field_3044.field_570) {
         this.field_2726.field_3037.setVisibility(0);
      }

      return var1;
   }

   // $FF: renamed from: ah () void
   private void method_2804() {
      if(this.field_2726.field_3045 == null) {
         class_370.method_2358("Ad state was null when trying to ping click URLs.");
      } else {
         class_370.method_2363("Pinging click URLs.");
         this.field_2726.field_3046.method_2447();
         if(this.field_2726.field_3045.field_1713 != null) {
            class_365.method_2293(this.field_2726.field_3039, this.field_2726.field_3041.field_1607, this.field_2726.field_3045.field_1713);
         }

         if(this.field_2726.field_3045.field_1725 != null && this.field_2726.field_3045.field_1725.field_620 != null) {
            class_194.method_1309(this.field_2726.field_3039, this.field_2726.field_3041.field_1607, this.field_2726.field_3045, this.field_2726.field_3038, false, this.field_2726.field_3045.field_1725.field_620);
            return;
         }
      }

   }

   // $FF: renamed from: ai () void
   private void method_2805() {
      if(this.field_2726.field_3045 != null) {
         this.field_2726.field_3045.field_1716.destroy();
         this.field_2726.field_3045 = null;
      }

   }

   // $FF: renamed from: b (android.view.View) void
   private void method_2806(View var1) {
      LayoutParams var2 = new LayoutParams(-2, -2);
      this.field_2726.field_3037.addView(var1, var2);
   }

   // $FF: renamed from: b (com.google.android.gms.internal.eg) boolean
   private boolean method_2807(class_383 var1) {
      if(var1.field_1720) {
         View var5;
         try {
            var5 = (View)class_741.method_4177(var1.field_1710.getView());
         } catch (RemoteException var10) {
            class_370.method_2361("Could not get View from mediation adapter.", var10);
            return false;
         }

         View var6 = this.field_2726.field_3037.getNextView();
         if(var6 != null) {
            this.field_2726.field_3037.removeView(var6);
         }

         try {
            this.method_2806(var5);
         } catch (Throwable var9) {
            class_370.method_2361("Could not add mediation view to view hierarchy.", var9);
            return false;
         }
      } else if(var1.field_1726 != null) {
         var1.field_1716.method_2340(var1.field_1726);
         this.field_2726.field_3037.removeAllViews();
         this.field_2726.field_3037.setMinimumWidth(var1.field_1726.widthPixels);
         this.field_2726.field_3037.setMinimumHeight(var1.field_1726.heightPixels);
         this.method_2806(var1.field_1716);
      }

      if(this.field_2726.field_3037.getChildCount() > 1) {
         this.field_2726.field_3037.showNext();
      }

      if(this.field_2726.field_3045 != null) {
         View var2 = this.field_2726.field_3037.getNextView();
         if(var2 instanceof class_369) {
            ((class_369)var2).method_2339(this.field_2726.field_3039, this.field_2726.field_3044);
         } else if(var2 != null) {
            this.field_2726.field_3037.removeView(var2);
         }

         if(this.field_2726.field_3045.field_1710 != null) {
            try {
               this.field_2726.field_3045.field_1710.destroy();
            } catch (RemoteException var8) {
               class_370.method_2358("Could not destroy previous mediation adapter.");
            }
         }
      }

      this.field_2726.field_3037.setVisibility(0);
      return true;
   }

   // $FF: renamed from: c (com.google.android.gms.internal.aj) com.google.android.gms.internal.dt$a
   private class_433.class_1158 method_2808(class_182 var1) {
      ApplicationInfo var2 = this.field_2726.field_3039.getApplicationInfo();

      PackageInfo var4;
      label37: {
         PackageInfo var15;
         try {
            var15 = this.field_2726.field_3039.getPackageManager().getPackageInfo(var2.packageName, 0);
         } catch (NameNotFoundException var16) {
            var4 = null;
            break label37;
         }

         var4 = var15;
      }

      Bundle var5;
      if(!this.field_2726.field_3044.field_570 && this.field_2726.field_3037.getParent() != null) {
         int[] var8 = new int[2];
         this.field_2726.field_3037.getLocationOnScreen(var8);
         int var9 = var8[0];
         int var10 = var8[1];
         DisplayMetrics var11 = this.field_2726.field_3039.getResources().getDisplayMetrics();
         int var12 = this.field_2726.field_3037.getWidth();
         int var13 = this.field_2726.field_3037.getHeight();
         byte var14;
         if(this.field_2726.field_3037.isShown() && var9 + var12 > 0 && var10 + var13 > 0 && var9 <= var11.widthPixels && var10 <= var11.heightPixels) {
            var14 = 1;
         } else {
            var14 = 0;
         }

         var5 = new Bundle(5);
         var5.putInt("x", var9);
         var5.putInt("y", var10);
         var5.putInt("width", var12);
         var5.putInt("height", var13);
         var5.putInt("visible", var14);
      } else {
         var5 = null;
      }

      String var6 = class_378.method_2408();
      this.field_2726.field_3046 = new class_384(var6, this.field_2726.field_3038);
      this.field_2726.field_3046.method_2449(var1);
      Bundle var7 = class_378.method_2405(this.field_2726.field_3039, this, var6);
      return new class_433.class_1158(var5, var1, this.field_2726.field_3044, this.field_2726.field_3038, var2, var4, var6, class_378.field_1666, this.field_2726.field_3041, var7);
   }

   // $FF: renamed from: c (boolean) void
   private void method_2809(boolean var1) {
      if(this.field_2726.field_3045 == null) {
         class_370.method_2358("Ad state was null when trying to ping impression URLs.");
      } else {
         class_370.method_2363("Pinging Impression URLs.");
         this.field_2726.field_3046.method_2446();
         if(this.field_2726.field_3045.field_1714 != null) {
            class_365.method_2293(this.field_2726.field_3039, this.field_2726.field_3041.field_1607, this.field_2726.field_3045.field_1714);
         }

         if(this.field_2726.field_3045.field_1725 != null && this.field_2726.field_3045.field_1725.field_621 != null) {
            class_194.method_1309(this.field_2726.field_3039, this.field_2726.field_3041.field_1607, this.field_2726.field_3045, this.field_2726.field_3038, var1, this.field_2726.field_3045.field_1725.field_621);
         }

         if(this.field_2726.field_3045.field_1709 != null && this.field_2726.field_3045.field_1709.field_651 != null) {
            class_194.method_1309(this.field_2726.field_3039, this.field_2726.field_3041.field_1607, this.field_2726.field_3045, this.field_2726.field_3038, var1, this.field_2726.field_3045.field_1709.field_651);
            return;
         }
      }

   }

   // $FF: renamed from: P () com.google.android.gms.dynamic.d
   public class_157 method_8() {
      class_347.method_2164("getAdFrame must be called on the main UI thread.");
      return class_741.method_4178(this.field_2726.field_3037);
   }

   // $FF: renamed from: Q () com.google.android.gms.internal.am
   public class_172 method_9() {
      class_347.method_2164("getAdSize must be called on the main UI thread.");
      return this.field_2726.field_3044;
   }

   // $FF: renamed from: T () void
   public void method_201() {
      this.method_2800();
   }

   // $FF: renamed from: U () void
   public void method_204() {
      this.field_2728.method_1245(this.field_2726.field_3045);
      if(this.field_2726.field_3044.field_570) {
         this.method_2805();
      }

      this.field_2729 = false;
      this.method_2799();
      this.field_2726.field_3046.method_2448();
   }

   // $FF: renamed from: V () void
   public void method_205() {
      if(this.field_2726.field_3044.field_570) {
         this.method_2809(false);
      }

      this.field_2729 = true;
      this.method_2801();
   }

   // $FF: renamed from: W () void
   public void method_25() {
      this.onAdClicked();
   }

   // $FF: renamed from: X () void
   public void method_26() {
      this.method_204();
   }

   // $FF: renamed from: Y () void
   public void method_27() {
      this.method_201();
   }

   // $FF: renamed from: Z () void
   public void method_28() {
      this.method_205();
   }

   // $FF: renamed from: a (com.google.android.gms.internal.am) void
   public void method_10(class_172 var1) {
      class_347.method_2164("setAdSize must be called on the main UI thread.");
      this.field_2726.field_3044 = var1;
      if(this.field_2726.field_3045 != null) {
         this.field_2726.field_3045.field_1716.method_2340(var1);
      }

      if(this.field_2726.field_3037.getChildCount() > 1) {
         this.field_2726.field_3037.removeView(this.field_2726.field_3037.getNextView());
      }

      this.field_2726.field_3037.setMinimumWidth(var1.widthPixels);
      this.field_2726.field_3037.setMinimumHeight(var1.heightPixels);
      this.field_2726.field_3037.requestLayout();
   }

   // $FF: renamed from: a (com.google.android.gms.internal.aq) void
   public void method_11(class_5 var1) {
      class_347.method_2164("setAdListener must be called on the main UI thread.");
      this.field_2726.field_3042 = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.at) void
   public void method_12(class_4 var1) {
      class_347.method_2164("setAppEventListener must be called on the main UI thread.");
      this.field_2726.field_3047 = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.dd) void
   public void method_13(class_48 var1) {
      class_347.method_2164("setInAppPurchaseListener must be called on the main UI thread.");
      this.field_2726.field_3049 = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.dh, java.lang.String) void
   public void method_14(class_50 var1, String var2) {
      class_347.method_2164("setPlayStorePurchaseParams must be called on the main UI thread.");
      this.field_2726.field_3050 = new class_439(var2);
      this.field_2726.field_3048 = var1;
      if(!class_378.method_2410() && var1 != null) {
         (new class_361(this.field_2726.field_3039, this.field_2726.field_3048, this.field_2726.field_3050)).start();
      }

   }

   // $FF: renamed from: a (com.google.android.gms.internal.eg) void
   public void method_759(class_383 var1) {
      this.field_2726.field_3043 = null;
      if(var1.errorCode != -2 && var1.errorCode != 3) {
         class_378.method_2406(this.field_2726.method_3228());
      }

      if(var1.errorCode != -1) {
         boolean var2;
         if(var1.field_1717.extras != null) {
            var2 = var1.field_1717.extras.getBoolean("_noRefresh", false);
         } else {
            var2 = false;
         }

         if(this.field_2726.field_3044.field_570) {
            class_365.method_2295(var1.field_1716);
         } else if(!var2) {
            if(var1.field_1715 > 0L) {
               this.field_2727.method_2791(var1.field_1717, var1.field_1715);
            } else if(var1.field_1725 != null && var1.field_1725.field_624 > 0L) {
               this.field_2727.method_2791(var1.field_1717, var1.field_1725.field_624);
            } else if(!var1.field_1720 && var1.errorCode == 2) {
               this.field_2727.method_2792(var1.field_1717);
            }
         }

         if(var1.errorCode == 3 && var1.field_1725 != null && var1.field_1725.field_622 != null) {
            class_370.method_2363("Pinging no fill URLs.");
            class_194.method_1309(this.field_2726.field_3039, this.field_2726.field_3041.field_1607, var1, this.field_2726.field_3038, false, var1.field_1725.field_622);
         }

         if(var1.errorCode != -2) {
            this.method_2798(var1.errorCode);
         } else {
            if(!this.field_2726.field_3044.field_570) {
               if(!this.method_2807(var1)) {
                  this.method_2798(0);
                  return;
               }

               if(this.field_2726.field_3037 != null) {
                  this.field_2726.field_3037.field_3036.method_2259(var1.field_1723);
               }
            }

            if(this.field_2726.field_3045 != null && this.field_2726.field_3045.field_1712 != null) {
               this.field_2726.field_3045.field_1712.method_1315((class_14)null);
            }

            if(var1.field_1712 != null) {
               var1.field_1712.method_1315(this);
            }

            this.field_2728.method_1245(this.field_2726.field_3045);
            this.field_2726.field_3045 = var1;
            if(var1.field_1726 != null) {
               this.field_2726.field_3044 = var1.field_1726;
            }

            this.field_2726.field_3046.method_2450(var1.field_1727);
            this.field_2726.field_3046.method_2451(var1.field_1728);
            this.field_2726.field_3046.method_2452(this.field_2726.field_3044.field_570);
            this.field_2726.field_3046.method_2453(var1.field_1720);
            if(!this.field_2726.field_3044.field_570) {
               this.method_2809(false);
            }

            if(this.field_2726.field_3051 == null) {
               this.field_2726.field_3051 = new class_380(this.field_2726.field_3038);
            }

            int var3;
            int var4;
            if(var1.field_1725 != null) {
               var3 = var1.field_1725.field_625;
               var4 = var1.field_1725.field_626;
            } else {
               var3 = 0;
               var4 = 0;
            }

            this.field_2726.field_3051.method_2425(var3, var4);
            if(!this.field_2726.field_3044.field_570 && var1.field_1716 != null && (var1.field_1716.method_2349().method_2330() || var1.field_1724 != null)) {
               class_163 var5 = this.field_2728.method_1243(this.field_2726.field_3044, this.field_2726.field_3045);
               if(var1.field_1716.method_2349().method_2330() && var5 != null) {
                  var5.method_1223(new class_449(var1.field_1716));
               }
            }

            this.field_2726.field_3045.field_1716.method_2345();
            this.method_2802();
         }
      }
   }

   // $FF: renamed from: a (java.lang.String, java.util.ArrayList) void
   public void method_18(String var1, ArrayList<String> var2) {
      class_411 var3 = new class_411(var1, var2, this.field_2726.field_3039, this.field_2726.field_3041.field_1607);
      if(this.field_2726.field_3049 != null) {
         try {
            this.field_2726.field_3049.method_208(var3);
         } catch (RemoteException var7) {
            class_370.method_2358("Could not start In-App purchase.");
         }
      } else {
         class_370.method_2358("InAppPurchaseListener is not set. Try to launch default purchase flow.");
         if(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.field_2726.field_3039) != 0) {
            class_370.method_2358("Google Play Service unavailable, cannot launch default purchase flow.");
         } else if(this.field_2726.field_3048 == null) {
            class_370.method_2358("PlayStorePurchaseListener is not set.");
         } else if(this.field_2726.field_3050 == null) {
            class_370.method_2358("PlayStorePurchaseVerifier is not initialized.");
         } else {
            label30: {
               boolean var6;
               try {
                  var6 = this.field_2726.field_3048.isValidPurchase(var1);
               } catch (RemoteException var8) {
                  class_370.method_2358("Could not start In-App purchase.");
                  break label30;
               }

               if(!var6) {
                  return;
               }
            }

            class_410.method_2522(this.field_2726.field_3039, this.field_2726.field_3041.field_1610, new class_407(var3, this.field_2726.field_3048, this.field_2726.field_3050, this.field_2726.field_3039));
         }
      }
   }

   // $FF: renamed from: a (java.util.HashSet) void
   public void method_188(HashSet<eh> var1) {
      this.field_2726.method_3227(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.aj) boolean
   public boolean method_15(class_182 var1) {
      class_347.method_2164("loadAd must be called on the main UI thread.");
      if(this.field_2726.field_3043 != null) {
         class_370.method_2358("An ad request is already in progress. Aborting.");
      } else {
         if(this.field_2726.field_3044.field_570 && this.field_2726.field_3045 != null) {
            class_370.method_2358("An interstitial is already loading. Aborting.");
            return false;
         }

         if(this.method_2803()) {
            class_370.method_2356("Starting ad request.");
            if(!var1.field_582) {
               class_370.method_2356("Use AdRequest.Builder.addTestDevice(\"" + class_371.method_2371(this.field_2726.field_3039) + "\") to get test ads on this device.");
            }

            this.field_2727.cancel();
            this.field_2726.field_3052 = false;
            class_433.class_1158 var2 = this.method_2808(var1);
            class_369 var5;
            if(this.field_2726.field_3044.field_570) {
               class_369 var6 = class_369.method_2333(this.field_2726.field_3039, this.field_2726.field_3044, false, false, this.field_2726.field_3040, this.field_2726.field_3041);
               var6.method_2349().method_2324(this, (class_43)null, this, this, true, this, this);
               var5 = var6;
            } else {
               View var3 = this.field_2726.field_3037.getNextView();
               class_369 var4;
               if(var3 instanceof class_369) {
                  var4 = (class_369)var3;
                  var4.method_2339(this.field_2726.field_3039, this.field_2726.field_3044);
               } else {
                  if(var3 != null) {
                     this.field_2726.field_3037.removeView(var3);
                  }

                  var4 = class_369.method_2333(this.field_2726.field_3039, this.field_2726.field_3044, false, false, this.field_2726.field_3040, this.field_2726.field_3041);
                  if(this.field_2726.field_3044.field_571 == null) {
                     this.method_2806(var4);
                  }
               }

               var4.method_2349().method_2323(this, this, this, this, false, this);
               var5 = var4;
            }

            this.field_2726.field_3043 = class_425.method_2577(this.field_2726.field_3039, var2, this.field_2726.field_3040, var5, this.field_2731, this);
            return true;
         }
      }

      return false;
   }

   // $FF: renamed from: aa () void
   public void method_29() {
      if(this.field_2726.field_3045 != null) {
         class_370.method_2358("Mediation adapter " + this.field_2726.field_3045.field_1711 + " refreshed, but mediation adapters should never refresh.");
      }

      this.method_2809(true);
      this.method_2802();
   }

   // $FF: renamed from: ab () void
   public void method_16() {
      class_347.method_2164("recordManualImpression must be called on the main UI thread.");
      if(this.field_2726.field_3045 == null) {
         class_370.method_2358("Ad state was null when trying to ping manual tracking URLs.");
      } else {
         class_370.method_2363("Pinging manual tracking URLs.");
         if(this.field_2726.field_3045.field_1722 != null) {
            class_365.method_2293(this.field_2726.field_3039, this.field_2726.field_3041.field_1607, this.field_2726.field_3045.field_1722);
            return;
         }
      }

   }

   // $FF: renamed from: b (com.google.android.gms.internal.aj) void
   public void method_2810(class_182 var1) {
      ViewParent var2 = this.field_2726.field_3037.getParent();
      if(var2 instanceof View && ((View)var2).isShown() && class_365.method_2303() && !this.field_2729) {
         this.method_15(var1);
      } else {
         class_370.method_2356("Ad is not visible. Not refreshing ad.");
         this.field_2727.method_2792(var1);
      }
   }

   // $FF: renamed from: b (boolean) void
   public void method_17(boolean var1) {
      this.field_2726.field_3052 = var1;
   }

   public void destroy() {
      class_347.method_2164("destroy must be called on the main UI thread.");
      this.method_2796();
      this.field_2726.field_3042 = null;
      this.field_2726.field_3047 = null;
      this.field_2727.cancel();
      this.field_2728.stop();
      this.stopLoading();
      if(this.field_2726.field_3037 != null) {
         this.field_2726.field_3037.removeAllViews();
      }

      if(this.field_2726.field_3045 != null && this.field_2726.field_3045.field_1716 != null) {
         this.field_2726.field_3045.field_1716.destroy();
      }

      if(this.field_2726.field_3045 != null && this.field_2726.field_3045.field_1710 != null) {
         try {
            this.field_2726.field_3045.field_1710.destroy();
         } catch (RemoteException var2) {
            class_370.method_2358("Could not destroy mediation adapter.");
            return;
         }
      }

   }

   public boolean isReady() {
      class_347.method_2164("isLoaded must be called on the main UI thread.");
      return this.field_2726.field_3043 == null && this.field_2726.field_3045 != null;
   }

   public void onAdClicked() {
      this.method_2804();
   }

   public void onAppEvent(String var1, String var2) {
      if(this.field_2726.field_3047 != null) {
         try {
            this.field_2726.field_3047.onAppEvent(var1, var2);
         } catch (RemoteException var4) {
            class_370.method_2361("Could not call the AppEventListener.", var4);
            return;
         }
      }

   }

   public void pause() {
      class_347.method_2164("pause must be called on the main UI thread.");
      if(this.field_2726.field_3045 != null) {
         class_365.method_2295(this.field_2726.field_3045.field_1716);
      }

      if(this.field_2726.field_3045 != null && this.field_2726.field_3045.field_1710 != null) {
         try {
            this.field_2726.field_3045.field_1710.pause();
         } catch (RemoteException var2) {
            class_370.method_2358("Could not pause mediation adapter.");
         }
      }

      this.field_2728.pause();
      this.field_2727.pause();
   }

   public void resume() {
      class_347.method_2164("resume must be called on the main UI thread.");
      if(this.field_2726.field_3045 != null) {
         class_365.method_2302(this.field_2726.field_3045.field_1716);
      }

      if(this.field_2726.field_3045 != null && this.field_2726.field_3045.field_1710 != null) {
         try {
            this.field_2726.field_3045.field_1710.resume();
         } catch (RemoteException var2) {
            class_370.method_2358("Could not resume mediation adapter.");
         }
      }

      this.field_2727.resume();
      this.field_2728.resume();
   }

   public void showInterstitial() {
      class_347.method_2164("showInterstitial must be called on the main UI thread.");
      if(!this.field_2726.field_3044.field_570) {
         class_370.method_2358("Cannot call showInterstitial on a banner ad.");
      } else if(this.field_2726.field_3045 == null) {
         class_370.method_2358("The interstitial has not loaded.");
      } else if(this.field_2726.field_3045.field_1716.method_2352()) {
         class_370.method_2358("The interstitial is already showing.");
      } else {
         this.field_2726.field_3045.field_1716.method_2354(true);
         if(this.field_2726.field_3045.field_1716.method_2349().method_2330() || this.field_2726.field_3045.field_1724 != null) {
            class_163 var1 = this.field_2728.method_1243(this.field_2726.field_3044, this.field_2726.field_3045);
            if(this.field_2726.field_3045.field_1716.method_2349().method_2330() && var1 != null) {
               var1.method_1223(new class_449(this.field_2726.field_3045.field_1716));
            }
         }

         if(this.field_2726.field_3045.field_1720) {
            try {
               this.field_2726.field_3045.field_1710.showInterstitial();
            } catch (RemoteException var11) {
               class_370.method_2361("Could not show interstitial.", var11);
               this.method_2805();
            }
         } else {
            class_453 var2 = new class_453(this.field_2726.field_3052, false);
            if(this.field_2726.field_3039 instanceof Activity) {
               Window var4 = ((Activity)this.field_2726.field_3039).getWindow();
               Rect var5 = new Rect();
               Rect var6 = new Rect();
               var4.getDecorView().getGlobalVisibleRect(var5);
               var4.getDecorView().getWindowVisibleDisplayFrame(var6);
               if(var5.bottom != 0 && var6.bottom != 0) {
                  boolean var8 = this.field_2726.field_3052;
                  boolean var9;
                  if(var5.top == var6.top) {
                     var9 = true;
                  } else {
                     var9 = false;
                  }

                  var2 = new class_453(var8, var9);
               }
            }

            class_424 var3 = new class_424(this, this, this, this.field_2726.field_3045.field_1716, this.field_2726.field_3045.orientation, this.field_2726.field_3041, this.field_2726.field_3045.field_1723, var2);
            class_422.method_2555(this.field_2726.field_3039, var3);
         }
      }
   }

   public void stopLoading() {
      class_347.method_2164("stopLoading must be called on the main UI thread.");
      if(this.field_2726.field_3045 != null) {
         this.field_2726.field_3045.field_1716.stopLoading();
         this.field_2726.field_3045 = null;
      }

      if(this.field_2726.field_3043 != null) {
         this.field_2726.field_3043.cancel();
      }

   }

   private static final class class_1130 extends ViewSwitcher {
      // $FF: renamed from: kG com.google.android.gms.internal.eq
      private final class_357 field_3036;

      public class_1130(Context var1) {
         super(var1);
         this.field_3036 = new class_357(var1);
      }

      public boolean onInterceptTouchEvent(MotionEvent var1) {
         this.field_3036.method_2258(var1);
         return false;
      }
   }

   private static final class class_1132 implements class_67, Runnable {
      // $FF: renamed from: kA com.google.android.gms.internal.v$c
      private class_452.class_1131 field_3054;
      // $FF: renamed from: kH java.util.List
      private final List<Object[]> field_3055 = new Vector();
      // $FF: renamed from: kI java.util.concurrent.CountDownLatch
      private final CountDownLatch field_3056 = new CountDownLatch(1);
      // $FF: renamed from: kJ java.util.concurrent.atomic.AtomicReference
      private final AtomicReference<h> field_3057 = new AtomicReference();

      public class_1132(class_452.class_1131 var1) {
         this.field_3054 = var1;
         if(class_371.method_2370()) {
            class_366.execute(this);
         } else {
            this.run();
         }
      }

      // $FF: renamed from: aj () void
      private void method_3229() {
         try {
            this.field_3056.await();
         } catch (InterruptedException var2) {
            class_370.method_2361("Interrupted during GADSignals creation.", var2);
         }
      }

      // $FF: renamed from: ak () void
      private void method_3230() {
         if(!this.field_3055.isEmpty()) {
            Iterator var1 = this.field_3055.iterator();

            while(var1.hasNext()) {
               Object[] var2 = (Object[])var1.next();
               if(var2.length == 1) {
                  ((class_67)this.field_3057.get()).method_346((MotionEvent)var2[0]);
               } else if(var2.length == 3) {
                  ((class_67)this.field_3057.get()).method_345(((Integer)var2[0]).intValue(), ((Integer)var2[1]).intValue(), ((Integer)var2[2]).intValue());
               }
            }
         }

      }

      // $FF: renamed from: a (android.content.Context) java.lang.String
      public String method_343(Context var1) {
         this.method_3229();
         this.method_3230();
         return ((class_67)this.field_3057.get()).method_343(var1);
      }

      // $FF: renamed from: a (android.content.Context, java.lang.String) java.lang.String
      public String method_344(Context var1, String var2) {
         this.method_3229();
         this.method_3230();
         return ((class_67)this.field_3057.get()).method_344(var1, var2);
      }

      // $FF: renamed from: a (int, int, int) void
      public void method_345(int var1, int var2, int var3) {
         class_67 var4 = (class_67)this.field_3057.get();
         if(var4 != null) {
            this.method_3230();
            var4.method_345(var1, var2, var3);
         } else {
            List var5 = this.field_3055;
            Object[] var6 = new Object[]{Integer.valueOf(var1), Integer.valueOf(var2), Integer.valueOf(var3)};
            var5.add(var6);
         }
      }

      // $FF: renamed from: a (android.view.MotionEvent) void
      public void method_346(MotionEvent var1) {
         class_67 var2 = (class_67)this.field_3057.get();
         if(var2 != null) {
            this.method_3230();
            var2.method_346(var1);
         } else {
            this.field_3055.add(new Object[]{var1});
         }
      }

      public void run() {
         try {
            this.field_3057.set(class_461.method_2852(this.field_3054.field_3041.field_1607, this.field_3054.field_3039));
         } finally {
            this.field_3056.countDown();
            this.field_3054 = null;
         }

      }
   }

   private static final class class_1131 {
      // $FF: renamed from: kK com.google.android.gms.internal.v$a
      public final class_452.class_1130 field_3037;
      // $FF: renamed from: kL java.lang.String
      public final String field_3038;
      // $FF: renamed from: kM android.content.Context
      public final Context field_3039;
      // $FF: renamed from: kN com.google.android.gms.internal.l
      public final class_457 field_3040;
      // $FF: renamed from: kO com.google.android.gms.internal.ew
      public final class_373 field_3041;
      // $FF: renamed from: kP com.google.android.gms.internal.aq
      public class_5 field_3042;
      // $FF: renamed from: kQ com.google.android.gms.internal.en
      public class_358 field_3043;
      // $FF: renamed from: kR com.google.android.gms.internal.am
      public class_172 field_3044;
      // $FF: renamed from: kS com.google.android.gms.internal.eg
      public class_383 field_3045;
      // $FF: renamed from: kT com.google.android.gms.internal.eh
      public class_384 field_3046;
      // $FF: renamed from: kU com.google.android.gms.internal.at
      public class_4 field_3047;
      // $FF: renamed from: kV com.google.android.gms.internal.dh
      public class_50 field_3048;
      // $FF: renamed from: kW com.google.android.gms.internal.dd
      public class_48 field_3049;
      // $FF: renamed from: kX com.google.android.gms.internal.da
      public class_439 field_3050;
      // $FF: renamed from: kY com.google.android.gms.internal.el
      public class_380 field_3051 = null;
      // $FF: renamed from: kZ boolean
      public boolean field_3052 = false;
      // $FF: renamed from: la java.util.HashSet
      private HashSet<eh> field_3053 = null;

      public class_1131(Context var1, class_172 var2, String var3, class_373 var4) {
         if(var2.field_570) {
            this.field_3037 = null;
         } else {
            this.field_3037 = new class_452.class_1130(var1);
            this.field_3037.setMinimumWidth(var2.widthPixels);
            this.field_3037.setMinimumHeight(var2.heightPixels);
            this.field_3037.setVisibility(4);
         }

         this.field_3044 = var2;
         this.field_3038 = var3;
         this.field_3039 = var1;
         this.field_3041 = var4;
         this.field_3040 = new class_457(new class_452.class_1132(this));
      }

      // $FF: renamed from: a (java.util.HashSet) void
      public void method_3227(HashSet<eh> var1) {
         this.field_3053 = var1;
      }

      // $FF: renamed from: al () java.util.HashSet
      public HashSet<eh> method_3228() {
         return this.field_3053;
      }
   }
}
