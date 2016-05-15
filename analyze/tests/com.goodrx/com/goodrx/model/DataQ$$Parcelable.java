package com.goodrx.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.goodrx.model.DataQ;
import org.parceler.ParcelWrapper;

public class DataQ$$Parcelable implements Parcelable, ParcelWrapper<DataQ> {
   public static final DataQ$$Parcelable.Creator$$2 CREATOR = new DataQ$$Parcelable.Creator$$2();
   private DataQ dataQ$$0;

   public DataQ$$Parcelable(Parcel var1) {
      DataQ var2;
      if(var1.readInt() == -1) {
         var2 = null;
      } else {
         var2 = this.readcom_goodrx_model_DataQ(var1);
      }

      this.dataQ$$0 = var2;
   }

   public DataQ$$Parcelable(DataQ var1) {
      this.dataQ$$0 = var1;
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

   public int describeContents() {
      return 0;
   }

   public DataQ getParcel() {
      return this.dataQ$$0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(this.dataQ$$0 == null) {
         var1.writeInt(-1);
      } else {
         var1.writeInt(1);
         this.writecom_goodrx_model_DataQ(this.dataQ$$0, var1, var2);
      }
   }

   public static final class Creator$$2 implements Creator<DataQ$$Parcelable> {
      public DataQ$$Parcelable createFromParcel(Parcel var1) {
         return new DataQ$$Parcelable(var1);
      }

      public DataQ$$Parcelable[] newArray(int var1) {
         return new DataQ$$Parcelable[var1];
      }
   }
}
