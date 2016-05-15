package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.EventParams;
import com.google.android.gms.measurement.internal.zzw;
import java.util.Iterator;

public class zzh {
   final String mName;
   final String zzaUa;
   final String zzaVM;
   final long zzaVN;
   final EventParams zzaVO;
   final long zzaez;

   zzh(zzw var1, String var2, String var3, String var4, long var5, long var7, Bundle var9) {
      com.google.android.gms.common.internal.zzx.zzcM(var3);
      com.google.android.gms.common.internal.zzx.zzcM(var4);
      this.zzaUa = var3;
      this.mName = var4;
      if(TextUtils.isEmpty(var2)) {
         var2 = null;
      }

      this.zzaVM = var2;
      this.zzaez = var5;
      this.zzaVN = var7;
      if(this.zzaVN != 0L && this.zzaVN > this.zzaez) {
         var1.zzAo().zzCF().zzfg("Event created with reverse previous/current timestamps");
      }

      this.zzaVO = this.zza(var1, var9);
   }

   private zzh(zzw var1, String var2, String var3, String var4, long var5, long var7, EventParams var9) {
      com.google.android.gms.common.internal.zzx.zzcM(var3);
      com.google.android.gms.common.internal.zzx.zzcM(var4);
      com.google.android.gms.common.internal.zzx.zzz(var9);
      this.zzaUa = var3;
      this.mName = var4;
      if(TextUtils.isEmpty(var2)) {
         var2 = null;
      }

      this.zzaVM = var2;
      this.zzaez = var5;
      this.zzaVN = var7;
      if(this.zzaVN != 0L && this.zzaVN > this.zzaez) {
         var1.zzAo().zzCF().zzfg("Event created with reverse previous/current timestamps");
      }

      this.zzaVO = var9;
   }

   private EventParams zza(zzw var1, Bundle var2) {
      if(var2 != null && !var2.isEmpty()) {
         Bundle var3 = new Bundle(var2);
         Iterator var4 = var3.keySet().iterator();

         while(var4.hasNext()) {
            String var5 = (String)var4.next();
            if(var5 == null) {
               var4.remove();
            } else {
               Object var6 = var1.zzCk().zzk(var5, var3.get(var5));
               if(var6 == null) {
                  var4.remove();
               } else {
                  var1.zzCk().zza(var3, var5, var6);
               }
            }
         }

         return new EventParams(var3);
      } else {
         return new EventParams(new Bundle());
      }
   }

   public String toString() {
      return "Event{appId=\'" + this.zzaUa + '\'' + ", name=\'" + this.mName + '\'' + ", params=" + this.zzaVO + '}';
   }

   zzh zza(zzw var1, long var2) {
      return new zzh(var1, this.zzaVM, this.zzaUa, this.mName, this.zzaez, var2, this.zzaVO);
   }
}
