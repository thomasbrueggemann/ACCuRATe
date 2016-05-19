package android.support.v7.media;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.support.v7.media.MediaRouteProvider;
import android.support.v7.media.RegisteredMediaRouteProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

final class RegisteredMediaRouteProviderWatcher {
   private final RegisteredMediaRouteProviderWatcher.Callback mCallback;
   private final Context mContext;
   private final Handler mHandler;
   private final PackageManager mPackageManager;
   private final ArrayList<RegisteredMediaRouteProvider> mProviders = new ArrayList();
   private boolean mRunning;
   private final BroadcastReceiver mScanPackagesReceiver = new BroadcastReceiver() {
      public void onReceive(Context var1, Intent var2) {
         RegisteredMediaRouteProviderWatcher.this.scanPackages();
      }
   };
   private final Runnable mScanPackagesRunnable = new Runnable() {
      public void run() {
         RegisteredMediaRouteProviderWatcher.this.scanPackages();
      }
   };

   public RegisteredMediaRouteProviderWatcher(Context var1, RegisteredMediaRouteProviderWatcher.Callback var2) {
      this.mContext = var1;
      this.mCallback = var2;
      this.mHandler = new Handler();
      this.mPackageManager = var1.getPackageManager();
   }

   private int findProvider(String var1, String var2) {
      int var3 = this.mProviders.size();

      for(int var4 = 0; var4 < var3; ++var4) {
         if(((RegisteredMediaRouteProvider)this.mProviders.get(var4)).hasComponentName(var1, var2)) {
            return var4;
         }
      }

      return -1;
   }

   private void scanPackages() {
      if(this.mRunning) {
         int var1 = 0;
         Intent var2 = new Intent("android.media.MediaRouteProviderService");
         Iterator var3 = this.mPackageManager.queryIntentServices(var2, 0).iterator();

         while(var3.hasNext()) {
            ServiceInfo var7 = ((ResolveInfo)var3.next()).serviceInfo;
            if(var7 != null) {
               int var8 = this.findProvider(var7.packageName, var7.name);
               if(var8 < 0) {
                  RegisteredMediaRouteProvider var9 = new RegisteredMediaRouteProvider(this.mContext, new ComponentName(var7.packageName, var7.name));
                  var9.start();
                  ArrayList var10 = this.mProviders;
                  int var11 = var1 + 1;
                  var10.add(var1, var9);
                  this.mCallback.addProvider(var9);
                  var1 = var11;
               } else if(var8 >= var1) {
                  RegisteredMediaRouteProvider var12 = (RegisteredMediaRouteProvider)this.mProviders.get(var8);
                  var12.start();
                  var12.rebindIfDisconnected();
                  ArrayList var13 = this.mProviders;
                  int var14 = var1 + 1;
                  Collections.swap(var13, var8, var1);
                  var1 = var14;
               }
            }
         }

         if(var1 < this.mProviders.size()) {
            for(int var4 = -1 + this.mProviders.size(); var4 >= var1; --var4) {
               RegisteredMediaRouteProvider var5 = (RegisteredMediaRouteProvider)this.mProviders.get(var4);
               this.mCallback.removeProvider(var5);
               this.mProviders.remove(var5);
               var5.stop();
            }
         }
      }

   }

   public void start() {
      if(!this.mRunning) {
         this.mRunning = true;
         IntentFilter var1 = new IntentFilter();
         var1.addAction("android.intent.action.PACKAGE_ADDED");
         var1.addAction("android.intent.action.PACKAGE_REMOVED");
         var1.addAction("android.intent.action.PACKAGE_CHANGED");
         var1.addAction("android.intent.action.PACKAGE_REPLACED");
         var1.addAction("android.intent.action.PACKAGE_RESTARTED");
         var1.addDataScheme("package");
         this.mContext.registerReceiver(this.mScanPackagesReceiver, var1, (String)null, this.mHandler);
         this.mHandler.post(this.mScanPackagesRunnable);
      }

   }

   public void stop() {
      if(this.mRunning) {
         this.mRunning = false;
         this.mContext.unregisterReceiver(this.mScanPackagesReceiver);
         this.mHandler.removeCallbacks(this.mScanPackagesRunnable);

         for(int var1 = -1 + this.mProviders.size(); var1 >= 0; --var1) {
            ((RegisteredMediaRouteProvider)this.mProviders.get(var1)).stop();
         }
      }

   }

   public interface Callback {
      void addProvider(MediaRouteProvider var1);

      void removeProvider(MediaRouteProvider var1);
   }
}
