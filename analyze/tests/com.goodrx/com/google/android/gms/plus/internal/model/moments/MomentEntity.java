package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.internal.model.moments.ItemScopeEntity;
import com.google.android.gms.plus.internal.model.moments.zzb;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class MomentEntity extends FastSafeParcelableJsonResponse implements Moment {
   public static final zzb CREATOR = new zzb();
   private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap();
   final int mVersionCode;
   String zzJN;
   final Set<Integer> zzbeN;
   String zzbfA;
   ItemScopeEntity zzbfI;
   ItemScopeEntity zzbfJ;
   String zzyv;

   static {
      zzbeM.put("id", FastJsonResponse.Field.zzl("id", 2));
      zzbeM.put("result", FastJsonResponse.Field.zza("result", 4, ItemScopeEntity.class));
      zzbeM.put("startDate", FastJsonResponse.Field.zzl("startDate", 5));
      zzbeM.put("target", FastJsonResponse.Field.zza("target", 6, ItemScopeEntity.class));
      zzbeM.put("type", FastJsonResponse.Field.zzl("type", 7));
   }

   public MomentEntity() {
      this.mVersionCode = 1;
      this.zzbeN = new HashSet();
   }

   MomentEntity(Set<Integer> var1, int var2, String var3, ItemScopeEntity var4, String var5, ItemScopeEntity var6, String var7) {
      this.zzbeN = var1;
      this.mVersionCode = var2;
      this.zzyv = var3;
      this.zzbfI = var4;
      this.zzbfA = var5;
      this.zzbfJ = var6;
      this.zzJN = var7;
   }

   public int describeContents() {
      zzb var10000 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof MomentEntity)) {
         return false;
      } else if(this == var1) {
         return true;
      } else {
         MomentEntity var2 = (MomentEntity)var1;
         Iterator var3 = zzbeM.values().iterator();

         while(var3.hasNext()) {
            FastJsonResponse.Field var4 = (FastJsonResponse.Field)var3.next();
            if(this.zza(var4)) {
               if(!var2.zza(var4)) {
                  return false;
               }

               if(!this.zzb(var4).equals(var2.zzb(var4))) {
                  return false;
               }
            } else if(var2.zza(var4)) {
               return false;
            }
         }

         return true;
      }
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.zzFn();
   }

   public int hashCode() {
      Iterator var1 = zzbeM.values().iterator();

      int var2;
      int var4;
      for(var2 = 0; var1.hasNext(); var2 = var4) {
         FastJsonResponse.Field var3 = (FastJsonResponse.Field)var1.next();
         if(this.zza(var3)) {
            var4 = var2 + var3.zzrs() + this.zzb(var3).hashCode();
         } else {
            var4 = var2;
         }
      }

      return var2;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb var10000 = CREATOR;
      zzb.zza(this, var1, var2);
   }

   public HashMap<String, FastJsonResponse.Field<?, ?>> zzFl() {
      return zzbeM;
   }

   public MomentEntity zzFn() {
      return this;
   }

   protected boolean zza(FastJsonResponse.Field var1) {
      return this.zzbeN.contains(Integer.valueOf(var1.zzrs()));
   }

   protected Object zzb(FastJsonResponse.Field var1) {
      switch(var1.zzrs()) {
      case 2:
         return this.zzyv;
      case 3:
      default:
         throw new IllegalStateException("Unknown safe parcelable id=" + var1.zzrs());
      case 4:
         return this.zzbfI;
      case 5:
         return this.zzbfA;
      case 6:
         return this.zzbfJ;
      case 7:
         return this.zzJN;
      }
   }

   // $FF: synthetic method
   public Map zzrl() {
      return this.zzFl();
   }
}
