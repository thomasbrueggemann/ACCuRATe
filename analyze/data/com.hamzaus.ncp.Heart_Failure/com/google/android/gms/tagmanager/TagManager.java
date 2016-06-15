package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.tagmanager.ContainerHolder;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.class_160;
import com.google.android.gms.tagmanager.class_515;
import com.google.android.gms.tagmanager.class_570;
import com.google.android.gms.tagmanager.class_571;
import com.google.android.gms.tagmanager.class_578;
import com.google.android.gms.tagmanager.n;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager {
   private static TagManager aid;
   private final DataLayer aer;
   private final class_578 agL;
   private final TagManager.class_1108 aib;
   private final ConcurrentMap<n, Boolean> aic;
   private final Context mContext;

   TagManager(Context var1, TagManager.class_1108 var2, DataLayer var3) {
      if(var1 == null) {
         throw new NullPointerException("context cannot be null");
      } else {
         this.mContext = var1.getApplicationContext();
         this.aib = var2;
         this.aic = new ConcurrentHashMap();
         this.aer = var3;
         this.aer.method_3994(new DataLayer.class_1286() {
            // $FF: renamed from: x (java.util.Map) void
            public void method_823(Map<String, Object> var1) {
               Object var2 = var1.get("event");
               if(var2 != null) {
                  TagManager.this.method_3130(var2.toString());
               }

            }
         });
         this.aer.method_3994(new class_570(this.mContext));
         this.agL = new class_578();
      }
   }

   // $FF: renamed from: cl (java.lang.String) void
   private void method_3130(String var1) {
      Iterator var2 = this.aic.keySet().iterator();

      while(var2.hasNext()) {
         ((class_571)var2.next()).method_3190(var1);
      }

   }

   public static TagManager getInstance(Context param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.n) void
   void method_3131(class_571 var1) {
      this.aic.put(var1, Boolean.valueOf(true));
   }

   // $FF: renamed from: b (com.google.android.gms.tagmanager.n) boolean
   boolean method_3132(class_571 var1) {
      return this.aic.remove(var1) != null;
   }

   public DataLayer getDataLayer() {
      return this.aer;
   }

   // $FF: renamed from: h (android.net.Uri) boolean
   boolean method_3133(Uri param1) {
      // $FF: Couldn't be decompiled
   }

   public PendingResult<ContainerHolder> loadContainerDefaultOnly(String var1, int var2) {
      class_160 var3 = this.aib.method_760(this.mContext, this, (Looper)null, var1, var2, this.agL);
      var3.method_904();
      return var3;
   }

   public PendingResult<ContainerHolder> loadContainerDefaultOnly(String var1, int var2, Handler var3) {
      class_160 var4 = this.aib.method_760(this.mContext, this, var3.getLooper(), var1, var2, this.agL);
      var4.method_904();
      return var4;
   }

   public PendingResult<ContainerHolder> loadContainerPreferFresh(String var1, int var2) {
      class_160 var3 = this.aib.method_760(this.mContext, this, (Looper)null, var1, var2, this.agL);
      var3.method_906();
      return var3;
   }

   public PendingResult<ContainerHolder> loadContainerPreferFresh(String var1, int var2, Handler var3) {
      class_160 var4 = this.aib.method_760(this.mContext, this, var3.getLooper(), var1, var2, this.agL);
      var4.method_906();
      return var4;
   }

   public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String var1, int var2) {
      class_160 var3 = this.aib.method_760(this.mContext, this, (Looper)null, var1, var2, this.agL);
      var3.method_905();
      return var3;
   }

   public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String var1, int var2, Handler var3) {
      class_160 var4 = this.aib.method_760(this.mContext, this, var3.getLooper(), var1, var2, this.agL);
      var4.method_905();
      return var4;
   }

   public void setVerboseLoggingEnabled(boolean var1) {
      byte var2;
      if(var1) {
         var2 = 2;
      } else {
         var2 = 5;
      }

      class_515.setLogLevel(var2);
   }

   interface class_1108 {
      // $FF: renamed from: a (android.content.Context, com.google.android.gms.tagmanager.TagManager, android.os.Looper, java.lang.String, int, com.google.android.gms.tagmanager.r) com.google.android.gms.tagmanager.o
      class_160 method_760(Context var1, TagManager var2, Looper var3, String var4, int var5, class_578 var6);
   }
}
