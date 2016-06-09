package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzrs;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.zzah;
import com.google.android.gms.tagmanager.zzbg;
import com.google.android.gms.tagmanager.zzbo;
import com.google.android.gms.tagmanager.zzcb;
import com.google.android.gms.tagmanager.zzcp;
import com.google.android.gms.tagmanager.zzdf;
import com.google.android.gms.tagmanager.zzt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Container {
   private final Context mContext;
   private final String zzbhM;
   private final DataLayer zzbhN;
   private zzcp zzbhO;
   private Map<String, Container.FunctionCallMacroCallback> zzbhP = new HashMap();
   private Map<String, Container.FunctionCallTagCallback> zzbhQ = new HashMap();
   private volatile long zzbhR;
   private volatile String zzbhS = "";

   Container(Context var1, DataLayer var2, String var3, long var4, com.google.android.gms.internal.zzaf.zzj var6) {
      this.mContext = var1;
      this.zzbhN = var2;
      this.zzbhM = var3;
      this.zzbhR = var4;
      this.zza(var6.zzju);
      if(var6.zzjt != null) {
         this.zza(var6.zzjt);
      }

   }

   Container(Context var1, DataLayer var2, String var3, long var4, zzrs.zzc var6) {
      this.mContext = var1;
      this.zzbhN = var2;
      this.zzbhM = var3;
      this.zzbhR = var4;
      this.zza(var6);
   }

   private zzcp zzGc() {
      synchronized(this){}

      zzcp var2;
      try {
         var2 = this.zzbhO;
      } finally {
         ;
      }

      return var2;
   }

   private void zza(com.google.android.gms.internal.zzaf.zzf var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         zzrs.zzc var3;
         try {
            var3 = zzrs.zzb(var1);
         } catch (zzrs.zzg var4) {
            zzbg.method_353("Not loading resource: " + var1 + " because it is invalid: " + var4.toString());
            return;
         }

         this.zza(var3);
      }
   }

   private void zza(zzrs.zzc var1) {
      this.zzbhS = var1.getVersion();
      zzah var2 = this.zzfS(this.zzbhS);
      this.zza(new zzcp(this.mContext, var1, this.zzbhN, new Container.zza(), new Container.zzb(), var2));
      if(this.getBoolean("_gtm.loadEventEnabled")) {
         DataLayer var3 = this.zzbhN;
         Object[] var4 = new Object[]{"gtm.id", this.zzbhM};
         var3.pushEvent("gtm.load", DataLayer.mapOf(var4));
      }

   }

   private void zza(zzcp var1) {
      synchronized(this){}

      try {
         this.zzbhO = var1;
      } finally {
         ;
      }

   }

   private void zza(com.google.android.gms.internal.zzaf.zzi[] var1) {
      ArrayList var2 = new ArrayList();
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         var2.add(var1[var4]);
      }

      this.zzGc().zzF(var2);
   }

   public boolean getBoolean(String var1) {
      zzcp var2 = this.zzGc();
      if(var2 == null) {
         zzbg.method_353("getBoolean called for closed container.");
         return zzdf.zzHC().booleanValue();
      } else {
         try {
            boolean var4 = zzdf.zzk((com.google.android.gms.internal.zzag.zza)var2.zzgn(var1).getObject()).booleanValue();
            return var4;
         } catch (Exception var5) {
            zzbg.method_353("Calling getBoolean() threw an exception: " + var5.getMessage() + " Returning default value.");
            return zzdf.zzHC().booleanValue();
         }
      }
   }

   public String getContainerId() {
      return this.zzbhM;
   }

   public long getLastRefreshTime() {
      return this.zzbhR;
   }

   public String getString(String var1) {
      zzcp var2 = this.zzGc();
      if(var2 == null) {
         zzbg.method_353("getString called for closed container.");
         return zzdf.zzHE();
      } else {
         try {
            String var4 = zzdf.zzg((com.google.android.gms.internal.zzag.zza)var2.zzgn(var1).getObject());
            return var4;
         } catch (Exception var5) {
            zzbg.method_353("Calling getString() threw an exception: " + var5.getMessage() + " Returning default value.");
            return zzdf.zzHE();
         }
      }
   }

   public boolean isDefault() {
      return this.getLastRefreshTime() == 0L;
   }

   void release() {
      this.zzbhO = null;
   }

   public String zzGb() {
      return this.zzbhS;
   }

   Container.FunctionCallMacroCallback zzfP(String param1) {
      // $FF: Couldn't be decompiled
   }

   public Container.FunctionCallTagCallback zzfQ(String param1) {
      // $FF: Couldn't be decompiled
   }

   public void zzfR(String var1) {
      this.zzGc().zzfR(var1);
   }

   zzah zzfS(String var1) {
      if(zzcb.zzGU().zzGV().equals(zzcb.zza.zzbjW)) {
         ;
      }

      return new zzbo();
   }

   public interface FunctionCallMacroCallback {
      Object getValue(String var1, Map<String, Object> var2);
   }

   public interface FunctionCallTagCallback {
      void execute(String var1, Map<String, Object> var2);
   }

   private class zza implements zzt.zza {
      private zza() {
      }

      // $FF: synthetic method
      zza(Object var2) {
         this();
      }

      public Object zzc(String var1, Map<String, Object> var2) {
         Container.FunctionCallMacroCallback var3 = Container.this.zzfP(var1);
         return var3 == null?null:var3.getValue(var1, var2);
      }
   }

   private class zzb implements zzt.zza {
      private zzb() {
      }

      // $FF: synthetic method
      zzb(Object var2) {
         this();
      }

      public Object zzc(String var1, Map<String, Object> var2) {
         Container.FunctionCallTagCallback var3 = Container.this.zzfQ(var1);
         if(var3 != null) {
            var3.execute(var1, var2);
         }

         return zzdf.zzHE();
      }
   }
}
