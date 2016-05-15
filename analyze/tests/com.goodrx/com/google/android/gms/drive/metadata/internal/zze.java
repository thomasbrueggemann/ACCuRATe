package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.zzm;
import com.google.android.gms.internal.zznm;
import com.google.android.gms.internal.zznn;
import com.google.android.gms.internal.zzno;
import com.google.android.gms.internal.zznq;
import java.util.HashMap;
import java.util.Map;

public final class zze {
   private static final Map<String, MetadataField<?>> zzasO = new HashMap();
   private static final Map<String, zze.zza> zzasP = new HashMap();

   static {
      zzb(zznm.zzasU);
      zzb(zznm.zzatA);
      zzb(zznm.zzatr);
      zzb(zznm.zzaty);
      zzb(zznm.zzatB);
      zzb(zznm.zzath);
      zzb(zznm.zzatg);
      zzb(zznm.zzati);
      zzb(zznm.zzatj);
      zzb(zznm.zzatk);
      zzb(zznm.zzate);
      zzb(zznm.zzatm);
      zzb(zznm.zzatn);
      zzb(zznm.zzato);
      zzb(zznm.zzatw);
      zzb(zznm.zzasV);
      zzb(zznm.zzatt);
      zzb(zznm.zzasX);
      zzb(zznm.zzatf);
      zzb(zznm.zzasY);
      zzb(zznm.zzasZ);
      zzb(zznm.zzata);
      zzb(zznm.zzatb);
      zzb(zznm.zzatq);
      zzb(zznm.zzatl);
      zzb(zznm.zzats);
      zzb(zznm.zzatu);
      zzb(zznm.zzatv);
      zzb(zznm.zzatx);
      zzb(zznm.zzatC);
      zzb(zznm.zzatD);
      zzb(zznm.zzatd);
      zzb(zznm.zzatc);
      zzb(zznm.zzatz);
      zzb(zznm.zzatp);
      zzb(zznm.zzasW);
      zzb(zznm.zzatE);
      zzb(zznm.zzatF);
      zzb(zznm.zzatG);
      zzb(zznm.zzatH);
      zzb(zznm.zzatI);
      zzb(zznm.zzatJ);
      zzb(zznm.zzatK);
      zzb(zzno.zzatM);
      zzb(zzno.zzatO);
      zzb(zzno.zzatP);
      zzb(zzno.zzatQ);
      zzb(zzno.zzatN);
      zzb(zzno.zzatR);
      zzb(zznq.zzatT);
      zzb(zznq.zzatU);
      zzm var10000 = zznm.zzatw;
      zza(zzm.zzasT);
      zza(zznn.zzatL);
   }

   private static void zza(zze.zza var0) {
      if(zzasP.put(var0.zztD(), var0) != null) {
         throw new IllegalStateException("A cleaner for key " + var0.zztD() + " has already been registered");
      }
   }

   private static void zzb(MetadataField<?> var0) {
      if(zzasO.containsKey(var0.getName())) {
         throw new IllegalArgumentException("Duplicate field name registered: " + var0.getName());
      } else {
         zzasO.put(var0.getName(), var0);
      }
   }

   public static MetadataField<?> zzdc(String var0) {
      return (MetadataField)zzasO.get(var0);
   }

   public interface zza {
      String zztD();
   }
}
