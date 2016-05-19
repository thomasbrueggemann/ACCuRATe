package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Application;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import com.google.android.gms.fitness.data.zzf;

public class DataSource implements SafeParcelable {
   public static final Creator<DataSource> CREATOR = new zzf();
   private final String mName;
   private final int mVersionCode;
   private final int zzabB;
   private final DataType zzavT;
   private final Device zzawr;
   private final Application zzaws;
   private final String zzawt;
   private final String zzawu;

   DataSource(int var1, DataType var2, String var3, int var4, Device var5, Application var6, String var7) {
      this.mVersionCode = var1;
      this.zzavT = var2;
      this.zzabB = var4;
      this.mName = var3;
      this.zzawr = var5;
      this.zzaws = var6;
      this.zzawt = var7;
      this.zzawu = this.zzun();
   }

   private String getTypeString() {
      switch(this.zzabB) {
      case 0:
         return "raw";
      case 1:
         return "derived";
      default:
         throw new IllegalArgumentException("invalid type value");
      }
   }

   private boolean zza(DataSource var1) {
      return this.zzawu.equals(var1.zzawu);
   }

   private String zzun() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.getTypeString());
      var1.append(":").append(this.zzavT.getName());
      if(this.zzaws != null) {
         var1.append(":").append(this.zzaws.getPackageName());
      }

      if(this.zzawr != null) {
         var1.append(":").append(this.zzawr.getStreamIdentifier());
      }

      if(this.zzawt != null) {
         var1.append(":").append(this.zzawt);
      }

      return var1.toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof DataSource && this.zza((DataSource)var1);
   }

   public DataType getDataType() {
      return this.zzavT;
   }

   public Device getDevice() {
      return this.zzawr;
   }

   public String getName() {
      return this.mName;
   }

   public String getStreamName() {
      return this.zzawt;
   }

   public int getType() {
      return this.zzabB;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      return this.zzawu.hashCode();
   }

   public String toDebugString() {
      StringBuilder var1 = new StringBuilder();
      String var2;
      if(this.zzabB == 0) {
         var2 = "r";
      } else {
         var2 = "d";
      }

      StringBuilder var3 = var1.append(var2).append(":").append(this.zzavT.zzuo());
      String var4;
      if(this.zzaws == null) {
         var4 = "";
      } else if(this.zzaws.equals(Application.zzawa)) {
         var4 = ":gms";
      } else {
         var4 = ":" + this.zzaws.getPackageName();
      }

      StringBuilder var5 = var3.append(var4);
      String var6;
      if(this.zzawr != null) {
         var6 = ":" + this.zzawr.getModel() + ":" + this.zzawr.getUid();
      } else {
         var6 = "";
      }

      StringBuilder var7 = var5.append(var6);
      String var8;
      if(this.zzawt != null) {
         var8 = ":" + this.zzawt;
      } else {
         var8 = "";
      }

      return var7.append(var8).toString();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DataSource{");
      var1.append(this.getTypeString());
      if(this.mName != null) {
         var1.append(":").append(this.mName);
      }

      if(this.zzaws != null) {
         var1.append(":").append(this.zzaws);
      }

      if(this.zzawr != null) {
         var1.append(":").append(this.zzawr);
      }

      if(this.zzawt != null) {
         var1.append(":").append(this.zzawt);
      }

      var1.append(":").append(this.zzavT);
      return var1.append("}").toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzf.zza(this, var1, var2);
   }

   public Application zzum() {
      return this.zzaws;
   }
}
