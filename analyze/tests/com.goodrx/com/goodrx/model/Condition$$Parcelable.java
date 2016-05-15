package com.goodrx.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.goodrx.model.Condition;
import org.parceler.ParcelWrapper;

public class Condition$$Parcelable implements Parcelable, ParcelWrapper<Condition> {
   public static final Condition$$Parcelable.Creator$$0 CREATOR = new Condition$$Parcelable.Creator$$0();
   private Condition condition$$0;

   public Condition$$Parcelable(Parcel var1) {
      Condition var2;
      if(var1.readInt() == -1) {
         var2 = null;
      } else {
         var2 = this.readcom_goodrx_model_Condition(var1);
      }

      this.condition$$0 = var2;
   }

   public Condition$$Parcelable(Condition var1) {
      this.condition$$0 = var1;
   }

   private Condition readcom_goodrx_model_Condition(Parcel var1) {
      Condition var2 = new Condition();
      var2.display = var1.readString();
      var2.count = var1.readInt();
      var2.slug = var1.readString();
      return var2;
   }

   private void writecom_goodrx_model_Condition(Condition var1, Parcel var2, int var3) {
      var2.writeString(var1.display);
      var2.writeInt(var1.count);
      var2.writeString(var1.slug);
   }

   public int describeContents() {
      return 0;
   }

   public Condition getParcel() {
      return this.condition$$0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(this.condition$$0 == null) {
         var1.writeInt(-1);
      } else {
         var1.writeInt(1);
         this.writecom_goodrx_model_Condition(this.condition$$0, var1, var2);
      }
   }

   public static final class Creator$$0 implements Creator<Condition$$Parcelable> {
      public Condition$$Parcelable createFromParcel(Parcel var1) {
         return new Condition$$Parcelable(var1);
      }

      public Condition$$Parcelable[] newArray(int var1) {
         return new Condition$$Parcelable[var1];
      }
   }
}
