package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.converter.zzb;
import com.google.android.gms.common.server.converter.zzc;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class StringToIntConverter implements SafeParcelable, FastJsonResponse.zza<String, Integer> {
   public static final zzb CREATOR = new zzb();
   private final int mVersionCode;
   private final HashMap<String, Integer> zzamG;
   private final HashMap<Integer, String> zzamH;
   private final ArrayList<StringToIntConverter.Entry> zzamI;

   public StringToIntConverter() {
      this.mVersionCode = 1;
      this.zzamG = new HashMap();
      this.zzamH = new HashMap();
      this.zzamI = null;
   }

   StringToIntConverter(int var1, ArrayList<StringToIntConverter.Entry> var2) {
      this.mVersionCode = var1;
      this.zzamG = new HashMap();
      this.zzamH = new HashMap();
      this.zzamI = null;
      this.zzd(var2);
   }

   private void zzd(ArrayList<StringToIntConverter.Entry> var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         StringToIntConverter.Entry var3 = (StringToIntConverter.Entry)var2.next();
         this.zzh(var3.zzamJ, var3.zzamK);
      }

   }

   // $FF: synthetic method
   public Object convertBack(Object var1) {
      return this.zzb((Integer)var1);
   }

   public int describeContents() {
      zzb var10000 = CREATOR;
      return 0;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb var10000 = CREATOR;
      zzb.zza(this, var1, var2);
   }

   public String zzb(Integer var1) {
      String var2 = (String)this.zzamH.get(var1);
      if(var2 == null && this.zzamG.containsKey("gms_unknown")) {
         var2 = "gms_unknown";
      }

      return var2;
   }

   public StringToIntConverter zzh(String var1, int var2) {
      this.zzamG.put(var1, Integer.valueOf(var2));
      this.zzamH.put(Integer.valueOf(var2), var1);
      return this;
   }

   ArrayList<StringToIntConverter.Entry> zzri() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.zzamG.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.add(new StringToIntConverter.Entry(var3, ((Integer)this.zzamG.get(var3)).intValue()));
      }

      return var1;
   }

   public int zzrj() {
      return 7;
   }

   public int zzrk() {
      return 0;
   }

   public static final class Entry implements SafeParcelable {
      public static final zzc CREATOR = new zzc();
      final int versionCode;
      final String zzamJ;
      final int zzamK;

      Entry(int var1, String var2, int var3) {
         this.versionCode = var1;
         this.zzamJ = var2;
         this.zzamK = var3;
      }

      Entry(String var1, int var2) {
         this.versionCode = 1;
         this.zzamJ = var1;
         this.zzamK = var2;
      }

      public int describeContents() {
         zzc var10000 = CREATOR;
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         zzc var10000 = CREATOR;
         zzc.zza(this, var1, var2);
      }
   }
}
