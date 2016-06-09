package com.goodrx.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.goodrx.model.ImageResult;
import org.parceler.ParcelWrapper;

public class ImageResult$$Parcelable implements Parcelable, ParcelWrapper<ImageResult> {
   public static final ImageResult$$Parcelable.Creator$$5 CREATOR = new ImageResult$$Parcelable.Creator$$5();
   private ImageResult imageResult$$0;

   public ImageResult$$Parcelable(Parcel var1) {
      ImageResult var2;
      if(var1.readInt() == -1) {
         var2 = null;
      } else {
         var2 = this.readcom_goodrx_model_ImageResult(var1);
      }

      this.imageResult$$0 = var2;
   }

   public ImageResult$$Parcelable(ImageResult var1) {
      this.imageResult$$0 = var1;
   }

   private ImageResult readcom_goodrx_model_ImageResult(Parcel var1) {
      ImageResult var2 = new ImageResult();
      var2.image = var1.readString();
      var2.company_name = var1.readString();
      var2.description = var1.readString();
      var2.product_name_long = var1.readString();
      var2.image_id = var1.readString();
      return var2;
   }

   private void writecom_goodrx_model_ImageResult(ImageResult var1, Parcel var2, int var3) {
      var2.writeString(var1.image);
      var2.writeString(var1.company_name);
      var2.writeString(var1.description);
      var2.writeString(var1.product_name_long);
      var2.writeString(var1.image_id);
   }

   public int describeContents() {
      return 0;
   }

   public ImageResult getParcel() {
      return this.imageResult$$0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(this.imageResult$$0 == null) {
         var1.writeInt(-1);
      } else {
         var1.writeInt(1);
         this.writecom_goodrx_model_ImageResult(this.imageResult$$0, var1, var2);
      }
   }

   public static final class Creator$$5 implements Creator<ImageResult$$Parcelable> {
      public ImageResult$$Parcelable createFromParcel(Parcel var1) {
         return new ImageResult$$Parcelable(var1);
      }

      public ImageResult$$Parcelable[] newArray(int var1) {
         return new ImageResult$$Parcelable[var1];
      }
   }
}
