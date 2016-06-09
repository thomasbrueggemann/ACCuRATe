package com.goodrx.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.goodrx.model.DataQ;
import com.goodrx.model.PharmacyLocationObject;
import org.parceler.ParcelWrapper;

public class PharmacyLocationObject$$Parcelable implements Parcelable, ParcelWrapper<PharmacyLocationObject> {
   public static final PharmacyLocationObject$$Parcelable.Creator$$7 CREATOR = new PharmacyLocationObject$$Parcelable.Creator$$7();
   private PharmacyLocationObject pharmacyLocationObject$$0;

   public PharmacyLocationObject$$Parcelable(Parcel var1) {
      PharmacyLocationObject var2;
      if(var1.readInt() == -1) {
         var2 = null;
      } else {
         var2 = this.readcom_goodrx_model_PharmacyLocationObject(var1);
      }

      this.pharmacyLocationObject$$0 = var2;
   }

   public PharmacyLocationObject$$Parcelable(PharmacyLocationObject var1) {
      this.pharmacyLocationObject$$0 = var1;
   }

   private DataQ readcom_goodrx_model_DataQ(Parcel var1) {
      DataQ var2 = new DataQ();
      boolean var3;
      if(var1.readInt() == 1) {
         var3 = true;
      } else {
         var3 = false;
      }

      var2.has_features = var3;
      boolean var4;
      if(var1.readInt() == 1) {
         var4 = true;
      } else {
         var4 = false;
      }

      var2.walk_in_clinic = var4;
      int var5 = var1.readInt();
      String[][] var6;
      if(var5 < 0) {
         var6 = (String[][])null;
      } else {
         var6 = new String[var5][];

         for(int var7 = 0; var7 < var5; ++var7) {
            int var8 = var1.readInt();
            String[] var9;
            if(var8 < 0) {
               var9 = null;
            } else {
               var9 = new String[var8];

               for(int var10 = 0; var10 < var8; ++var10) {
                  var9[var10] = var1.readString();
               }
            }

            var6[var7] = var9;
         }
      }

      var2.hours = var6;
      int var11 = var1.readInt();
      String[] var12;
      if(var11 < 0) {
         var12 = null;
      } else {
         var12 = new String[var11];

         for(int var13 = 0; var13 < var11; ++var13) {
            var12[var13] = var1.readString();
         }
      }

      var2.languages = var12;
      int var14 = var1.readInt();
      String[] var15;
      if(var14 < 0) {
         var15 = null;
      } else {
         var15 = new String[var14];

         for(int var16 = 0; var16 < var14; ++var16) {
            var15[var16] = var1.readString();
         }
      }

      var2.provider_codes = var15;
      boolean var17;
      if(var1.readInt() == 1) {
         var17 = true;
      } else {
         var17 = false;
      }

      var2.drive_up_window = var17;
      var2.phone = var1.readString();
      var2.fax = var1.readString();
      boolean var18;
      if(var1.readInt() == 1) {
         var18 = true;
      } else {
         var18 = false;
      }

      var2.delivery_service = var18;
      boolean var19;
      if(var1.readInt() == 1) {
         var19 = true;
      } else {
         var19 = false;
      }

      var2.compounding_service = var19;
      boolean var20;
      if(var1.readInt() == 1) {
         var20 = true;
      } else {
         var20 = false;
      }

      var2.open24 = var20;
      return var2;
   }

   private PharmacyLocationObject readcom_goodrx_model_PharmacyLocationObject(Parcel var1) {
      PharmacyLocationObject var2 = new PharmacyLocationObject();
      var2.distance = var1.readDouble();
      var2.city = var1.readString();
      var2.discount_program_url = var1.readString();
      var2.discount_program_disclaimer = var1.readString();
      Double var3;
      if(var1.readInt() < 0) {
         var3 = null;
      } else {
         var3 = Double.valueOf(var1.readDouble());
      }

      var2.latitude = var3;
      var2.description = var1.readString();
      var2.discount_program_name = var1.readString();
      var2.nabp_display_name = var1.readString();
      var2.discount_program_cost = var1.readString();
      var2.discount_description = var1.readString();
      var2.field_454 = var1.readString();
      var2.state = var1.readString();
      var2.ncpdp = var1.readString();
      var2.fax = var1.readString();
      Double var4;
      if(var1.readInt() < 0) {
         var4 = null;
      } else {
         var4 = Double.valueOf(var1.readDouble());
      }

      var2.longitude = var4;
      var2.nabp_approved = var1.readString();
      var2.address = var1.readString();
      var2.npi = var1.readString();
      var2.is_blacklisted = var1.readString();
      var2.store_type = var1.readString();
      DataQ var5;
      if(var1.readInt() == -1) {
         var5 = null;
      } else {
         var5 = this.readcom_goodrx_model_DataQ(var1);
      }

      var2.data_q = var5;
      var2.url = var1.readString();
      var2.zipcode = var1.readString();
      var2.phone = var1.readString();
      var2.pharmacy_id = var1.readString();
      var2.is_valid = var1.readString();
      var2.name = var1.readString();
      var2.location = var1.readString();
      var2.discount_program_length = var1.readString();
      var2.url_display = var1.readString();
      return var2;
   }

   private void writecom_goodrx_model_DataQ(DataQ var1, Parcel var2, int var3) {
      byte var4 = 1;
      byte var5;
      if(var1.has_features) {
         var5 = var4;
      } else {
         var5 = 0;
      }

      var2.writeInt(var5);
      byte var6;
      if(var1.walk_in_clinic) {
         var6 = var4;
      } else {
         var6 = 0;
      }

      var2.writeInt(var6);
      if(var1.hours == null) {
         var2.writeInt(-1);
      } else {
         var2.writeInt(var1.hours.length);
         String[][] var7 = var1.hours;
         int var8 = var7.length;

         for(int var9 = 0; var9 < var8; ++var9) {
            String[] var10 = var7[var9];
            if(var10 == null) {
               var2.writeInt(-1);
            } else {
               var2.writeInt(var10.length);
               int var11 = var10.length;

               for(int var12 = 0; var12 < var11; ++var12) {
                  var2.writeString(var10[var12]);
               }
            }
         }
      }

      if(var1.languages == null) {
         var2.writeInt(-1);
      } else {
         var2.writeInt(var1.languages.length);
         String[] var13 = var1.languages;
         int var14 = var13.length;

         for(int var15 = 0; var15 < var14; ++var15) {
            var2.writeString(var13[var15]);
         }
      }

      if(var1.provider_codes == null) {
         var2.writeInt(-1);
      } else {
         var2.writeInt(var1.provider_codes.length);
         String[] var16 = var1.provider_codes;
         int var17 = var16.length;

         for(int var18 = 0; var18 < var17; ++var18) {
            var2.writeString(var16[var18]);
         }
      }

      byte var19;
      if(var1.drive_up_window) {
         var19 = var4;
      } else {
         var19 = 0;
      }

      var2.writeInt(var19);
      var2.writeString(var1.phone);
      var2.writeString(var1.fax);
      byte var20;
      if(var1.delivery_service) {
         var20 = var4;
      } else {
         var20 = 0;
      }

      var2.writeInt(var20);
      byte var21;
      if(var1.compounding_service) {
         var21 = var4;
      } else {
         var21 = 0;
      }

      var2.writeInt(var21);
      if(!var1.open24) {
         var4 = 0;
      }

      var2.writeInt(var4);
   }

   private void writecom_goodrx_model_PharmacyLocationObject(PharmacyLocationObject var1, Parcel var2, int var3) {
      var2.writeDouble(var1.distance);
      var2.writeString(var1.city);
      var2.writeString(var1.discount_program_url);
      var2.writeString(var1.discount_program_disclaimer);
      if(var1.latitude == null) {
         var2.writeInt(-1);
      } else {
         var2.writeInt(1);
         var2.writeDouble(var1.latitude.doubleValue());
      }

      var2.writeString(var1.description);
      var2.writeString(var1.discount_program_name);
      var2.writeString(var1.nabp_display_name);
      var2.writeString(var1.discount_program_cost);
      var2.writeString(var1.discount_description);
      var2.writeString(var1.field_454);
      var2.writeString(var1.state);
      var2.writeString(var1.ncpdp);
      var2.writeString(var1.fax);
      if(var1.longitude == null) {
         var2.writeInt(-1);
      } else {
         var2.writeInt(1);
         var2.writeDouble(var1.longitude.doubleValue());
      }

      var2.writeString(var1.nabp_approved);
      var2.writeString(var1.address);
      var2.writeString(var1.npi);
      var2.writeString(var1.is_blacklisted);
      var2.writeString(var1.store_type);
      if(var1.data_q == null) {
         var2.writeInt(-1);
      } else {
         var2.writeInt(1);
         this.writecom_goodrx_model_DataQ(var1.data_q, var2, var3);
      }

      var2.writeString(var1.url);
      var2.writeString(var1.zipcode);
      var2.writeString(var1.phone);
      var2.writeString(var1.pharmacy_id);
      var2.writeString(var1.is_valid);
      var2.writeString(var1.name);
      var2.writeString(var1.location);
      var2.writeString(var1.discount_program_length);
      var2.writeString(var1.url_display);
   }

   public int describeContents() {
      return 0;
   }

   public PharmacyLocationObject getParcel() {
      return this.pharmacyLocationObject$$0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(this.pharmacyLocationObject$$0 == null) {
         var1.writeInt(-1);
      } else {
         var1.writeInt(1);
         this.writecom_goodrx_model_PharmacyLocationObject(this.pharmacyLocationObject$$0, var1, var2);
      }
   }

   public static final class Creator$$7 implements Creator<PharmacyLocationObject$$Parcelable> {
      public PharmacyLocationObject$$Parcelable createFromParcel(Parcel var1) {
         return new PharmacyLocationObject$$Parcelable(var1);
      }

      public PharmacyLocationObject$$Parcelable[] newArray(int var1) {
         return new PharmacyLocationObject$$Parcelable[var1];
      }
   }
}
