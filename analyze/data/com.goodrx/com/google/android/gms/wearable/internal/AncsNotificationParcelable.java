package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzh;

public class AncsNotificationParcelable implements SafeParcelable {
   public static final Creator<AncsNotificationParcelable> CREATOR = new zzh();
   private int mId;
   final int mVersionCode;
   private String zzTJ;
   private String zzWQ;
   private final String zzaDH;
   private final String zzaUa;
   private final String zzaaH;
   private final String zzapg;
   private final String zzbrH;
   private byte zzbrI;
   private byte zzbrJ;
   private byte zzbrK;
   private byte zzbrL;

   AncsNotificationParcelable(int var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8, byte var9, byte var10, byte var11, byte var12, String var13) {
      this.mId = var2;
      this.mVersionCode = var1;
      this.zzaUa = var3;
      this.zzbrH = var4;
      this.zzaaH = var5;
      this.zzapg = var6;
      this.zzaDH = var7;
      this.zzWQ = var8;
      this.zzbrI = var9;
      this.zzbrJ = var10;
      this.zzbrK = var11;
      this.zzbrL = var12;
      this.zzTJ = var13;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 != null && this.getClass() == var1.getClass()) {
            AncsNotificationParcelable var2 = (AncsNotificationParcelable)var1;
            if(this.zzbrL != var2.zzbrL) {
               return false;
            } else if(this.zzbrK != var2.zzbrK) {
               return false;
            } else if(this.zzbrJ != var2.zzbrJ) {
               return false;
            } else if(this.zzbrI != var2.zzbrI) {
               return false;
            } else if(this.mId != var2.mId) {
               return false;
            } else if(this.mVersionCode != var2.mVersionCode) {
               return false;
            } else if(!this.zzaUa.equals(var2.zzaUa)) {
               return false;
            } else {
               if(this.zzbrH != null) {
                  if(!this.zzbrH.equals(var2.zzbrH)) {
                     return false;
                  }
               } else if(var2.zzbrH != null) {
                  return false;
               }

               if(!this.zzWQ.equals(var2.zzWQ)) {
                  return false;
               } else if(!this.zzaaH.equals(var2.zzaaH)) {
                  return false;
               } else if(!this.zzaDH.equals(var2.zzaDH)) {
                  return false;
               } else if(!this.zzapg.equals(var2.zzapg)) {
                  return false;
               } else {
                  return true;
               }
            }
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   public String getDisplayName() {
      return this.zzWQ == null?this.zzaUa:this.zzWQ;
   }

   public int getId() {
      return this.mId;
   }

   public String getPackageName() {
      return this.zzTJ;
   }

   public String getTitle() {
      return this.zzapg;
   }

   public int hashCode() {
      int var1 = 31 * (31 * (31 * this.mVersionCode + this.mId) + this.zzaUa.hashCode());
      int var2;
      if(this.zzbrH != null) {
         var2 = this.zzbrH.hashCode();
      } else {
         var2 = 0;
      }

      return 31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (var2 + var1) + this.zzaaH.hashCode()) + this.zzapg.hashCode()) + this.zzaDH.hashCode()) + this.zzWQ.hashCode()) + this.zzbrI) + this.zzbrJ) + this.zzbrK) + this.zzbrL;
   }

   public String toString() {
      return "AncsNotificationParcelable{mVersionCode=" + this.mVersionCode + ", mId=" + this.mId + ", mAppId=\'" + this.zzaUa + '\'' + ", mDateTime=\'" + this.zzbrH + '\'' + ", mNotificationText=\'" + this.zzaaH + '\'' + ", mTitle=\'" + this.zzapg + '\'' + ", mSubtitle=\'" + this.zzaDH + '\'' + ", mDisplayName=\'" + this.zzWQ + '\'' + ", mEventId=" + this.zzbrI + ", mEventFlags=" + this.zzbrJ + ", mCategoryId=" + this.zzbrK + ", mCategoryCount=" + this.zzbrL + '}';
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzh.zza(this, var1, var2);
   }

   public String zzIB() {
      return this.zzbrH;
   }

   public String zzIC() {
      return this.zzaaH;
   }

   public byte zzID() {
      return this.zzbrI;
   }

   public byte zzIE() {
      return this.zzbrJ;
   }

   public byte zzIF() {
      return this.zzbrK;
   }

   public byte zzIG() {
      return this.zzbrL;
   }

   public String zzwK() {
      return this.zzaUa;
   }

   public String zzwc() {
      return this.zzaDH;
   }
}
