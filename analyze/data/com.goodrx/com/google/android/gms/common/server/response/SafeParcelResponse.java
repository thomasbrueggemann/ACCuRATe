package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FieldMappingDictionary;
import com.google.android.gms.common.server.response.zze;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmo;
import com.google.android.gms.internal.zznb;
import com.google.android.gms.internal.zznc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class SafeParcelResponse extends FastJsonResponse implements SafeParcelable {
   public static final zze CREATOR = new zze();
   private final String mClassName;
   private final int mVersionCode;
   private final FieldMappingDictionary zzamT;
   private final Parcel zzana;
   private final int zzanb;
   private int zzanc;
   private int zzand;

   SafeParcelResponse(int var1, Parcel var2, FieldMappingDictionary var3) {
      this.mVersionCode = var1;
      this.zzana = (Parcel)zzx.zzz(var2);
      this.zzanb = 2;
      this.zzamT = var3;
      if(this.zzamT == null) {
         this.mClassName = null;
      } else {
         this.mClassName = this.zzamT.zzrB();
      }

      this.zzanc = 2;
   }

   private static HashMap<Integer, Entry<String, FastJsonResponse.Field<?, ?>>> zzN(Map<String, FastJsonResponse.Field<?, ?>> var0) {
      HashMap var1 = new HashMap();
      Iterator var2 = var0.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.put(Integer.valueOf(((FastJsonResponse.Field)var3.getValue()).zzrs()), var3);
      }

      return var1;
   }

   private void zza(StringBuilder var1, int var2, Object var3) {
      switch(var2) {
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
         var1.append(var3);
         return;
      case 7:
         var1.append("\"").append(zznb.zzcU(var3.toString())).append("\"");
         return;
      case 8:
         var1.append("\"").append(zzmo.zzj((byte[])((byte[])var3))).append("\"");
         return;
      case 9:
         var1.append("\"").append(zzmo.zzk((byte[])((byte[])var3)));
         var1.append("\"");
         return;
      case 10:
         zznc.zza(var1, (HashMap)var3);
         return;
      case 11:
         throw new IllegalArgumentException("Method does not accept concrete type.");
      default:
         throw new IllegalArgumentException("Unknown type = " + var2);
      }
   }

   private void zza(StringBuilder var1, FastJsonResponse.Field<?, ?> var2, Parcel var3, int var4) {
      switch(var2.zzrk()) {
      case 0:
         this.zzb(var1, var2, this.zza(var2, Integer.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzg(var3, var4))));
         return;
      case 1:
         this.zzb(var1, var2, this.zza(var2, com.google.android.gms.common.internal.safeparcel.zza.zzk(var3, var4)));
         return;
      case 2:
         this.zzb(var1, var2, this.zza(var2, Long.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzi(var3, var4))));
         return;
      case 3:
         this.zzb(var1, var2, this.zza(var2, Float.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzl(var3, var4))));
         return;
      case 4:
         this.zzb(var1, var2, this.zza(var2, Double.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzn(var3, var4))));
         return;
      case 5:
         this.zzb(var1, var2, this.zza(var2, com.google.android.gms.common.internal.safeparcel.zza.zzo(var3, var4)));
         return;
      case 6:
         this.zzb(var1, var2, this.zza(var2, Boolean.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzc(var3, var4))));
         return;
      case 7:
         this.zzb(var1, var2, this.zza(var2, com.google.android.gms.common.internal.safeparcel.zza.zzp(var3, var4)));
         return;
      case 8:
      case 9:
         this.zzb(var1, var2, this.zza(var2, com.google.android.gms.common.internal.safeparcel.zza.zzs(var3, var4)));
         return;
      case 10:
         this.zzb(var1, var2, this.zza(var2, zzl(com.google.android.gms.common.internal.safeparcel.zza.zzr(var3, var4))));
         return;
      case 11:
         throw new IllegalArgumentException("Method does not accept concrete type.");
      default:
         throw new IllegalArgumentException("Unknown field out type = " + var2.zzrk());
      }
   }

   private void zza(StringBuilder var1, String var2, FastJsonResponse.Field<?, ?> var3, Parcel var4, int var5) {
      var1.append("\"").append(var2).append("\":");
      if(var3.zzrv()) {
         this.zza(var1, var3, var4, var5);
      } else {
         this.zzb(var1, var3, var4, var5);
      }
   }

   private void zza(StringBuilder var1, Map<String, FastJsonResponse.Field<?, ?>> var2, Parcel var3) {
      HashMap var4 = zzN(var2);
      var1.append('{');
      int var6 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var3);
      boolean var7 = false;

      while(var3.dataPosition() < var6) {
         int var9 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var3);
         Entry var10 = (Entry)var4.get(Integer.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzca(var9)));
         if(var10 != null) {
            if(var7) {
               var1.append(",");
            }

            this.zza(var1, (String)var10.getKey(), (FastJsonResponse.Field)var10.getValue(), var3, var9);
            var7 = true;
         }
      }

      if(var3.dataPosition() != var6) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var6, var3);
      } else {
         var1.append('}');
      }
   }

   private void zzb(StringBuilder var1, FastJsonResponse.Field<?, ?> var2, Parcel var3, int var4) {
      if(!var2.zzrq()) {
         switch(var2.zzrk()) {
         case 0:
            var1.append(com.google.android.gms.common.internal.safeparcel.zza.zzg(var3, var4));
            return;
         case 1:
            var1.append(com.google.android.gms.common.internal.safeparcel.zza.zzk(var3, var4));
            return;
         case 2:
            var1.append(com.google.android.gms.common.internal.safeparcel.zza.zzi(var3, var4));
            return;
         case 3:
            var1.append(com.google.android.gms.common.internal.safeparcel.zza.zzl(var3, var4));
            return;
         case 4:
            var1.append(com.google.android.gms.common.internal.safeparcel.zza.zzn(var3, var4));
            return;
         case 5:
            var1.append(com.google.android.gms.common.internal.safeparcel.zza.zzo(var3, var4));
            return;
         case 6:
            var1.append(com.google.android.gms.common.internal.safeparcel.zza.zzc(var3, var4));
            return;
         case 7:
            String var23 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var3, var4);
            var1.append("\"").append(zznb.zzcU(var23)).append("\"");
            return;
         case 8:
            byte[] var21 = com.google.android.gms.common.internal.safeparcel.zza.zzs(var3, var4);
            var1.append("\"").append(zzmo.zzj(var21)).append("\"");
            return;
         case 9:
            byte[] var18 = com.google.android.gms.common.internal.safeparcel.zza.zzs(var3, var4);
            var1.append("\"").append(zzmo.zzk(var18));
            var1.append("\"");
            return;
         case 10:
            Bundle var6 = com.google.android.gms.common.internal.safeparcel.zza.zzr(var3, var4);
            Set var7 = var6.keySet();
            var7.size();
            var1.append("{");
            Iterator var10 = var7.iterator();

            for(boolean var11 = true; var10.hasNext(); var11 = false) {
               String var13 = (String)var10.next();
               if(!var11) {
                  var1.append(",");
               }

               var1.append("\"").append(var13).append("\"");
               var1.append(":");
               var1.append("\"").append(zznb.zzcU(var6.getString(var13))).append("\"");
            }

            var1.append("}");
            return;
         case 11:
            Parcel var5 = com.google.android.gms.common.internal.safeparcel.zza.zzE(var3, var4);
            var5.setDataPosition(0);
            this.zza(var1, var2.zzrx(), var5);
            return;
         default:
            throw new IllegalStateException("Unknown field type out");
         }
      } else {
         var1.append("[");
         label56:
         switch(var2.zzrk()) {
         case 0:
            zzmn.zza(var1, com.google.android.gms.common.internal.safeparcel.zza.zzv(var3, var4));
            break;
         case 1:
            zzmn.zza((StringBuilder)var1, (Object[])com.google.android.gms.common.internal.safeparcel.zza.zzx(var3, var4));
            break;
         case 2:
            zzmn.zza(var1, com.google.android.gms.common.internal.safeparcel.zza.zzw(var3, var4));
            break;
         case 3:
            zzmn.zza(var1, com.google.android.gms.common.internal.safeparcel.zza.zzy(var3, var4));
            break;
         case 4:
            zzmn.zza(var1, com.google.android.gms.common.internal.safeparcel.zza.zzz(var3, var4));
            break;
         case 5:
            zzmn.zza((StringBuilder)var1, (Object[])com.google.android.gms.common.internal.safeparcel.zza.zzA(var3, var4));
            break;
         case 6:
            zzmn.zza(var1, com.google.android.gms.common.internal.safeparcel.zza.zzu(var3, var4));
            break;
         case 7:
            zzmn.zza(var1, com.google.android.gms.common.internal.safeparcel.zza.zzB(var3, var4));
            break;
         case 8:
         case 9:
         case 10:
            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
         case 11:
            Parcel[] var33 = com.google.android.gms.common.internal.safeparcel.zza.zzF(var3, var4);
            int var34 = var33.length;
            int var35 = 0;

            while(true) {
               if(var35 >= var34) {
                  break label56;
               }

               if(var35 > 0) {
                  var1.append(",");
               }

               var33[var35].setDataPosition(0);
               this.zza(var1, var2.zzrx(), var33[var35]);
               ++var35;
            }
         default:
            throw new IllegalStateException("Unknown field type out.");
         }

         var1.append("]");
      }
   }

   private void zzb(StringBuilder var1, FastJsonResponse.Field<?, ?> var2, Object var3) {
      if(var2.zzrp()) {
         this.zzb(var1, var2, (ArrayList)var3);
      } else {
         this.zza(var1, var2.zzrj(), var3);
      }
   }

   private void zzb(StringBuilder var1, FastJsonResponse.Field<?, ?> var2, ArrayList<?> var3) {
      var1.append("[");
      int var5 = var3.size();

      for(int var6 = 0; var6 < var5; ++var6) {
         if(var6 != 0) {
            var1.append(",");
         }

         this.zza(var1, var2.zzrj(), var3.get(var6));
      }

      var1.append("]");
   }

   public static HashMap<String, String> zzl(Bundle var0) {
      HashMap var1 = new HashMap();
      Iterator var2 = var0.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.put(var3, var0.getString(var3));
      }

      return var1;
   }

   public int describeContents() {
      zze var10000 = CREATOR;
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public String toString() {
      zzx.zzb(this.zzamT, "Cannot convert to JSON on client side.");
      Parcel var2 = this.zzrD();
      var2.setDataPosition(0);
      StringBuilder var3 = new StringBuilder(100);
      this.zza(var3, this.zzamT.zzcR(this.mClassName), var2);
      return var3.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zze var10000 = CREATOR;
      zze.zza(this, var1, var2);
   }

   protected Object zzcN(String var1) {
      throw new UnsupportedOperationException("Converting to JSON does not require this method.");
   }

   protected boolean zzcO(String var1) {
      throw new UnsupportedOperationException("Converting to JSON does not require this method.");
   }

   public Parcel zzrD() {
      switch(this.zzanc) {
      case 0:
         this.zzand = com.google.android.gms.common.internal.safeparcel.zzb.zzav(this.zzana);
         com.google.android.gms.common.internal.safeparcel.zzb.zzI(this.zzana, this.zzand);
         this.zzanc = 2;
         break;
      case 1:
         com.google.android.gms.common.internal.safeparcel.zzb.zzI(this.zzana, this.zzand);
         this.zzanc = 2;
      }

      return this.zzana;
   }

   FieldMappingDictionary zzrE() {
      switch(this.zzanb) {
      case 0:
         return null;
      case 1:
         return this.zzamT;
      case 2:
         return this.zzamT;
      default:
         throw new IllegalStateException("Invalid creation type: " + this.zzanb);
      }
   }

   public Map<String, FastJsonResponse.Field<?, ?>> zzrl() {
      return this.zzamT == null?null:this.zzamT.zzcR(this.mClassName);
   }
}
