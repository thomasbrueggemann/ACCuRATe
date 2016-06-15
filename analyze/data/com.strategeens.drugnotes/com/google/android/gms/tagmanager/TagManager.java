package com.google.android.gms.tagmanager;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Build.VERSION;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.tagmanager.ContainerHolder;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.class_202;
import com.google.android.gms.tagmanager.class_613;
import com.google.android.gms.tagmanager.class_642;
import com.google.android.gms.tagmanager.class_671;
import com.google.android.gms.tagmanager.class_672;
import com.google.android.gms.tagmanager.class_679;
import com.google.android.gms.tagmanager.n;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager {
   private static TagManager atW;
   private final DataLayer aqn;
   private final class_679 asD;
   private final TagManager.class_1444 atT;
   private final class_642 atU;
   private final ConcurrentMap<n, Boolean> atV;
   private final Context mContext;

   TagManager(Context var1, TagManager.class_1444 var2, DataLayer var3, class_642 var4) {
      if(var1 == null) {
         throw new NullPointerException("context cannot be null");
      } else {
         this.mContext = var1.getApplicationContext();
         this.atU = var4;
         this.atT = var2;
         this.atV = new ConcurrentHashMap();
         this.aqn = var3;
         this.aqn.method_4994(new DataLayer.class_1643() {
            // $FF: renamed from: C (java.util.Map) void
            public void method_1009(Map<String, Object> var1) {
               Object var2 = var1.get("event");
               if(var2 != null) {
                  TagManager.this.method_3757(var2.toString());
               }

            }
         });
         this.aqn.method_4994(new class_671(this.mContext));
         this.asD = new class_679();
         this.method_3758();
      }
   }

   // $FF: renamed from: cV (java.lang.String) void
   private void method_3757(String var1) {
      Iterator var2 = this.atV.keySet().iterator();

      while(var2.hasNext()) {
         ((class_672)var2.next()).method_3822(var1);
      }

   }

   public static TagManager getInstance(Context param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: qP () void
   private void method_3758() {
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

   // $FF: renamed from: a (com.google.android.gms.tagmanager.n) void
   void method_3759(class_672 var1) {
      this.atV.put(var1, Boolean.valueOf(true));
   }

   // $FF: renamed from: b (com.google.android.gms.tagmanager.n) boolean
   boolean method_3760(class_672 var1) {
      return this.atV.remove(var1) != null;
   }

   public void dispatch() {
      this.atU.dispatch();
   }

   public DataLayer getDataLayer() {
      return this.aqn;
   }

   // $FF: renamed from: i (android.net.Uri) boolean
   boolean method_3761(Uri param1) {
      // $FF: Couldn't be decompiled
   }

   public PendingResult<ContainerHolder> loadContainerDefaultOnly(String var1, int var2) {
      class_202 var3 = this.atT.method_924(this.mContext, this, (Looper)null, var1, var2, this.asD);
      var3.method_1130();
      return var3;
   }

   public PendingResult<ContainerHolder> loadContainerDefaultOnly(String var1, int var2, Handler var3) {
      class_202 var4 = this.atT.method_924(this.mContext, this, var3.getLooper(), var1, var2, this.asD);
      var4.method_1130();
      return var4;
   }

   public PendingResult<ContainerHolder> loadContainerPreferFresh(String var1, int var2) {
      class_202 var3 = this.atT.method_924(this.mContext, this, (Looper)null, var1, var2, this.asD);
      var3.method_1132();
      return var3;
   }

   public PendingResult<ContainerHolder> loadContainerPreferFresh(String var1, int var2, Handler var3) {
      class_202 var4 = this.atT.method_924(this.mContext, this, var3.getLooper(), var1, var2, this.asD);
      var4.method_1132();
      return var4;
   }

   public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String var1, int var2) {
      class_202 var3 = this.atT.method_924(this.mContext, this, (Looper)null, var1, var2, this.asD);
      var3.method_1131();
      return var3;
   }

   public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String var1, int var2, Handler var3) {
      class_202 var4 = this.atT.method_924(this.mContext, this, var3.getLooper(), var1, var2, this.asD);
      var4.method_1131();
      return var4;
   }

   public void setVerboseLoggingEnabled(boolean var1) {
      byte var2;
      if(var1) {
         var2 = 2;
      } else {
         var2 = 5;
      }

      class_613.setLogLevel(var2);
   }

   interface class_1444 {
      // $FF: renamed from: a (android.content.Context, com.google.android.gms.tagmanager.TagManager, android.os.Looper, java.lang.String, int, com.google.android.gms.tagmanager.r) com.google.android.gms.tagmanager.o
      class_202 method_924(Context var1, TagManager var2, Looper var3, String var4, int var5, class_679 var6);
   }
}
