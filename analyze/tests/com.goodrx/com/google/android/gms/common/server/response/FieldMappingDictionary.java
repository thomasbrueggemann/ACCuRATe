package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.zzb;
import com.google.android.gms.common.server.response.zzc;
import com.google.android.gms.common.server.response.zzd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FieldMappingDictionary implements SafeParcelable {
   public static final zzc CREATOR = new zzc();
   private final int mVersionCode;
   private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> zzamV;
   private final ArrayList<FieldMappingDictionary.Entry> zzamW;
   private final String zzamX;

   FieldMappingDictionary(int var1, ArrayList<FieldMappingDictionary.Entry> var2, String var3) {
      this.mVersionCode = var1;
      this.zzamW = null;
      this.zzamV = zze(var2);
      this.zzamX = (String)zzx.zzz(var3);
      this.zzry();
   }

   private static HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> zze(ArrayList<FieldMappingDictionary.Entry> var0) {
      HashMap var1 = new HashMap();
      int var2 = var0.size();

      for(int var3 = 0; var3 < var2; ++var3) {
         FieldMappingDictionary.Entry var4 = (FieldMappingDictionary.Entry)var0.get(var3);
         var1.put(var4.className, var4.zzrC());
      }

      return var1;
   }

   public int describeContents() {
      zzc var10000 = CREATOR;
      return 0;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      Iterator var2 = this.zzamV.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.append(var3).append(":\n");
         Map var5 = (Map)this.zzamV.get(var3);
         Iterator var6 = var5.keySet().iterator();

         while(var6.hasNext()) {
            String var7 = (String)var6.next();
            var1.append("  ").append(var7).append(": ");
            var1.append(var5.get(var7));
         }
      }

      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc var10000 = CREATOR;
      zzc.zza(this, var1, var2);
   }

   public Map<String, FastJsonResponse.Field<?, ?>> zzcR(String var1) {
      return (Map)this.zzamV.get(var1);
   }

   ArrayList<FieldMappingDictionary.Entry> zzrA() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.zzamV.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.add(new FieldMappingDictionary.Entry(var3, (Map)this.zzamV.get(var3)));
      }

      return var1;
   }

   public String zzrB() {
      return this.zzamX;
   }

   public void zzry() {
      Iterator var1 = this.zzamV.keySet().iterator();

      while(var1.hasNext()) {
         String var2 = (String)var1.next();
         Map var3 = (Map)this.zzamV.get(var2);
         Iterator var4 = var3.keySet().iterator();

         while(var4.hasNext()) {
            ((FastJsonResponse.Field)var3.get((String)var4.next())).zza(this);
         }
      }

   }

   public static class Entry implements SafeParcelable {
      public static final zzd CREATOR = new zzd();
      final String className;
      final int versionCode;
      final ArrayList<FieldMappingDictionary.FieldMapPair> zzamY;

      Entry(int var1, String var2, ArrayList<FieldMappingDictionary.FieldMapPair> var3) {
         this.versionCode = var1;
         this.className = var2;
         this.zzamY = var3;
      }

      Entry(String var1, Map<String, FastJsonResponse.Field<?, ?>> var2) {
         this.versionCode = 1;
         this.className = var1;
         this.zzamY = zzM(var2);
      }

      private static ArrayList<FieldMappingDictionary.FieldMapPair> zzM(Map<String, FastJsonResponse.Field<?, ?>> var0) {
         if(var0 == null) {
            return null;
         } else {
            ArrayList var1 = new ArrayList();
            Iterator var2 = var0.keySet().iterator();

            while(var2.hasNext()) {
               String var3 = (String)var2.next();
               var1.add(new FieldMappingDictionary.FieldMapPair(var3, (FastJsonResponse.Field)var0.get(var3)));
            }

            return var1;
         }
      }

      public int describeContents() {
         zzd var10000 = CREATOR;
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         zzd var10000 = CREATOR;
         zzd.zza(this, var1, var2);
      }

      HashMap<String, FastJsonResponse.Field<?, ?>> zzrC() {
         HashMap var1 = new HashMap();
         int var2 = this.zzamY.size();

         for(int var3 = 0; var3 < var2; ++var3) {
            FieldMappingDictionary.FieldMapPair var4 = (FieldMappingDictionary.FieldMapPair)this.zzamY.get(var3);
            var1.put(var4.key, var4.zzamZ);
         }

         return var1;
      }
   }

   public static class FieldMapPair implements SafeParcelable {
      public static final zzb CREATOR = new zzb();
      final String key;
      final int versionCode;
      final FastJsonResponse.Field<?, ?> zzamZ;

      FieldMapPair(int var1, String var2, FastJsonResponse.Field<?, ?> var3) {
         this.versionCode = var1;
         this.key = var2;
         this.zzamZ = var3;
      }

      FieldMapPair(String var1, FastJsonResponse.Field<?, ?> var2) {
         this.versionCode = 1;
         this.key = var1;
         this.zzamZ = var2;
      }

      public int describeContents() {
         zzb var10000 = CREATOR;
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         zzb var10000 = CREATOR;
         zzb.zza(this, var1, var2);
      }
   }
}
