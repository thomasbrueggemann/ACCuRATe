package com.goodrx.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.goodrx.model.Condition;
import com.goodrx.model.DrugInformation;
import org.parceler.ParcelWrapper;

public class DrugInformation$$Parcelable implements Parcelable, ParcelWrapper<DrugInformation> {
   public static final DrugInformation$$Parcelable.Creator$$3 CREATOR = new DrugInformation$$Parcelable.Creator$$3();
   private DrugInformation drugInformation$$0;

   public DrugInformation$$Parcelable(Parcel var1) {
      DrugInformation var2;
      if(var1.readInt() == -1) {
         var2 = null;
      } else {
         var2 = this.readcom_goodrx_model_DrugInformation(var1);
      }

      this.drugInformation$$0 = var2;
   }

   public DrugInformation$$Parcelable(DrugInformation var1) {
      this.drugInformation$$0 = var1;
   }

   private Condition readcom_goodrx_model_Condition(Parcel var1) {
      Condition var2 = new Condition();
      var2.display = var1.readString();
      var2.count = var1.readInt();
      var2.slug = var1.readString();
      return var2;
   }

   private DrugInformation readcom_goodrx_model_DrugInformation(Parcel var1) {
      byte var2 = 1;
      DrugInformation var3 = new DrugInformation();
      var3.tip_count = var1.readInt();
      int var4 = var1.readInt();
      Condition[] var5;
      if(var4 < 0) {
         var5 = null;
      } else {
         var5 = new Condition[var4];

         for(int var6 = 0; var6 < var4; ++var6) {
            Condition var7;
            if(var1.readInt() == -1) {
               var7 = null;
            } else {
               var7 = this.readcom_goodrx_model_Condition(var1);
            }

            var5[var6] = var7;
         }
      }

      var3.drug_conditions = var5;
      var3.news_count = var1.readInt();
      var3.image_count = var1.readInt();
      var3.information = var1.readString();
      var3.default_image = var1.readString();
      if(var1.readInt() != var2) {
         var2 = 0;
      }

      var3.education_available = (boolean)var2;
      var3.disclaimer = var1.readString();
      return var3;
   }

   private void writecom_goodrx_model_Condition(Condition var1, Parcel var2, int var3) {
      var2.writeString(var1.display);
      var2.writeInt(var1.count);
      var2.writeString(var1.slug);
   }

   private void writecom_goodrx_model_DrugInformation(DrugInformation var1, Parcel var2, int var3) {
      byte var4 = 1;
      var2.writeInt(var1.tip_count);
      if(var1.drug_conditions == null) {
         var2.writeInt(-1);
      } else {
         var2.writeInt(var1.drug_conditions.length);
         Condition[] var5 = var1.drug_conditions;
         int var6 = var5.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            Condition var8 = var5[var7];
            if(var8 == null) {
               var2.writeInt(-1);
            } else {
               var2.writeInt(var4);
               this.writecom_goodrx_model_Condition(var8, var2, var3);
            }
         }
      }

      var2.writeInt(var1.news_count);
      var2.writeInt(var1.image_count);
      var2.writeString(var1.information);
      var2.writeString(var1.default_image);
      if(!var1.education_available) {
         var4 = 0;
      }

      var2.writeInt(var4);
      var2.writeString(var1.disclaimer);
   }

   public int describeContents() {
      return 0;
   }

   public DrugInformation getParcel() {
      return this.drugInformation$$0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(this.drugInformation$$0 == null) {
         var1.writeInt(-1);
      } else {
         var1.writeInt(1);
         this.writecom_goodrx_model_DrugInformation(this.drugInformation$$0, var1, var2);
      }
   }

   public static final class Creator$$3 implements Creator<DrugInformation$$Parcelable> {
      public DrugInformation$$Parcelable createFromParcel(Parcel var1) {
         return new DrugInformation$$Parcelable(var1);
      }

      public DrugInformation$$Parcelable[] newArray(int var1) {
         return new DrugInformation$$Parcelable[var1];
      }
   }
}
