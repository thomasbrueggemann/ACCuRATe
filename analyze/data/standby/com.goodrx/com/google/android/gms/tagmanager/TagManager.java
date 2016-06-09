package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Looper;
import android.os.Build.VERSION;
import android.support.annotation.RawRes;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.tagmanager.ContainerHolder;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.zzbg;
import com.google.android.gms.tagmanager.zzct;
import com.google.android.gms.tagmanager.zzd;
import com.google.android.gms.tagmanager.zzo;
import com.google.android.gms.tagmanager.zzp;
import com.google.android.gms.tagmanager.zzs;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager {
   private static TagManager zzblm;
   private final Context mContext;
   private final DataLayer zzbhN;
   private final zzs zzbkh;
   private final TagManager.zza zzblj;
   private final zzct zzblk;
   private final ConcurrentMap<zzo, Boolean> zzbll;

   TagManager(Context var1, TagManager.zza var2, DataLayer var3, zzct var4) {
      if(var1 == null) {
         throw new NullPointerException("context cannot be null");
      } else {
         this.mContext = var1.getApplicationContext();
         this.zzblk = var4;
         this.zzblj = var2;
         this.zzbll = new ConcurrentHashMap();
         this.zzbhN = var3;
         this.zzbhN.zza(new DataLayer.zzb() {
            public void zzQ(Map<String, Object> var1) {
               Object var2 = var1.get("event");
               if(var2 != null) {
                  TagManager.this.zzgp(var2.toString());
               }

            }
         });
         this.zzbhN.zza((DataLayer.zzb)(new zzd(this.mContext)));
         this.zzbkh = new zzs();
         this.zzHt();
      }
   }

   @RequiresPermission(
      allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"}
   )
   public static TagManager getInstance(Context param0) {
      // $FF: Couldn't be decompiled
   }

   @TargetApi(14)
   private void zzHt() {
      if(VERSION.SDK_INT >= 14) {
         this.mContext.registerComponentCallbacks(new ComponentCallbacks2() {
            public void onConfigurationChanged(Configuration var1) {
            }

            public void onLowMemory() {
            }

            public void onTrimMemory(int var1) {
               if(var1 == 20) {
                  TagManager.this.dispatch();
               }

            }
         });
      }

   }

   private void zzgp(String var1) {
      Iterator var2 = this.zzbll.keySet().iterator();

      while(var2.hasNext()) {
         ((zzo)var2.next()).zzfR(var1);
      }

   }

   public void dispatch() {
      this.zzblk.dispatch();
   }

   public DataLayer getDataLayer() {
      return this.zzbhN;
   }

   public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String var1, @RawRes int var2) {
      zzp var3 = this.zzblj.zza(this.mContext, this, (Looper)null, var1, var2, this.zzbkh);
      var3.zzGh();
      return var3;
   }

   public void setVerboseLoggingEnabled(boolean var1) {
      byte var2;
      if(var1) {
         var2 = 2;
      } else {
         var2 = 5;
      }

      zzbg.setLogLevel(var2);
   }

   public void zza(zzo var1) {
      this.zzbll.put(var1, Boolean.valueOf(true));
   }

   public boolean zzb(zzo var1) {
      return this.zzbll.remove(var1) != null;
   }

   boolean zzp(Uri param1) {
      // $FF: Couldn't be decompiled
   }

   public interface zza {
      zzp zza(Context var1, TagManager var2, Looper var3, String var4, int var5, zzs var6);
   }
}
