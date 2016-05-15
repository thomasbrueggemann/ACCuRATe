package com.goodrx.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.goodrx.model.SavingsTip;
import org.parceler.ParcelWrapper;

public class SavingsTip$$Parcelable implements Parcelable, ParcelWrapper<SavingsTip> {
   public static final SavingsTip$$Parcelable.Creator$$8 CREATOR = new SavingsTip$$Parcelable.Creator$$8();
   private SavingsTip savingsTip$$0;

   public SavingsTip$$Parcelable(Parcel var1) {
      SavingsTip var2;
      if(var1.readInt() == -1) {
         var2 = null;
      } else {
         var2 = this.readcom_goodrx_model_SavingsTip(var1);
      }

      this.savingsTip$$0 = var2;
   }

   public SavingsTip$$Parcelable(SavingsTip var1) {
      this.savingsTip$$0 = var1;
   }

   private SavingsTip readcom_goodrx_model_SavingsTip(Parcel var1) {
      byte var2 = 1;
      SavingsTip var3 = new SavingsTip();
      var3.short_description = var1.readString();
      if(var1.readInt() != var2) {
         var2 = 0;
      }

      var3.highlight = (boolean)var2;
      var3.link = var1.readString();
      var3.tip_type = var1.readString();
      var3.icon = var1.readString();
      var3.long_description = var1.readString();
      var3.title = var1.readString();
      var3.link_text = var1.readString();
      var3.slug = var1.readString();
      return var3;
   }

   private void writecom_goodrx_model_SavingsTip(SavingsTip var1, Parcel var2, int var3) {
      var2.writeString(var1.short_description);
      byte var4;
      if(var1.highlight) {
         var4 = 1;
      } else {
         var4 = 0;
      }

      var2.writeInt(var4);
      var2.writeString(var1.link);
      var2.writeString(var1.tip_type);
      var2.writeString(var1.icon);
      var2.writeString(var1.long_description);
      var2.writeString(var1.title);
      var2.writeString(var1.link_text);
      var2.writeString(var1.slug);
   }

   public int describeContents() {
      return 0;
   }

   public SavingsTip getParcel() {
      return this.savingsTip$$0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(this.savingsTip$$0 == null) {
         var1.writeInt(-1);
      } else {
         var1.writeInt(1);
         this.writecom_goodrx_model_SavingsTip(this.savingsTip$$0, var1, var2);
      }
   }

   public static final class Creator$$8 implements Creator<SavingsTip$$Parcelable> {
      public SavingsTip$$Parcelable createFromParcel(Parcel var1) {
         return new SavingsTip$$Parcelable(var1);
      }

      public SavingsTip$$Parcelable[] newArray(int var1) {
         return new SavingsTip$$Parcelable[var1];
      }
   }
}
