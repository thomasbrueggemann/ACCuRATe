package com.goodrx.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.goodrx.model.CouponInfo;
import org.parceler.ParcelWrapper;

public class CouponInfo$$Parcelable implements Parcelable, ParcelWrapper<CouponInfo> {
   public static final CouponInfo$$Parcelable.Creator$$1 CREATOR = new CouponInfo$$Parcelable.Creator$$1();
   private CouponInfo couponInfo$$0;

   public CouponInfo$$Parcelable(Parcel var1) {
      CouponInfo var2;
      if(var1.readInt() == -1) {
         var2 = null;
      } else {
         var2 = this.readcom_goodrx_model_CouponInfo(var1);
      }

      this.couponInfo$$0 = var2;
   }

   public CouponInfo$$Parcelable(CouponInfo var1) {
      this.couponInfo$$0 = var1;
   }

   private CouponInfo readcom_goodrx_model_CouponInfo(Parcel var1) {
      CouponInfo var2 = new CouponInfo();
      var2.member_id = var1.readString();
      var2.pharm_phone = var1.readString();
      var2.phone = var1.readString();
      var2.rxgroup = var1.readString();
      var2.name = var1.readString();
      var2.rxpcn = var1.readString();
      var2.rxbin = var1.readString();
      return var2;
   }

   private void writecom_goodrx_model_CouponInfo(CouponInfo var1, Parcel var2, int var3) {
      var2.writeString(var1.member_id);
      var2.writeString(var1.pharm_phone);
      var2.writeString(var1.phone);
      var2.writeString(var1.rxgroup);
      var2.writeString(var1.name);
      var2.writeString(var1.rxpcn);
      var2.writeString(var1.rxbin);
   }

   public int describeContents() {
      return 0;
   }

   public CouponInfo getParcel() {
      return this.couponInfo$$0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(this.couponInfo$$0 == null) {
         var1.writeInt(-1);
      } else {
         var1.writeInt(1);
         this.writecom_goodrx_model_CouponInfo(this.couponInfo$$0, var1, var2);
      }
   }

   public static final class Creator$$1 implements Creator<CouponInfo$$Parcelable> {
      public CouponInfo$$Parcelable createFromParcel(Parcel var1) {
         return new CouponInfo$$Parcelable(var1);
      }

      public CouponInfo$$Parcelable[] newArray(int var1) {
         return new CouponInfo$$Parcelable[var1];
      }
   }
}
