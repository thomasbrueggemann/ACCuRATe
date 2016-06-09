package com.peirr.blooadapp.io;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Patient implements Parcelable {
   public static final Creator<Patient> CREATOR = new Creator() {
      public Patient createFromParcel(Parcel var1) {
         return new Patient(var1, null);
      }

      public Patient[] newArray(int var1) {
         return new Patient[var1];
      }
   };
   public int age;
   public String calc_ts;
   public int calcid;
   public int cardiac;
   public float first_pass_removed;
   public float fluid_prebypass;
   public int gender;
   public float height;
   public float nc_blood_loss;
   public float nc_blood_vol;
   public float nc_required_post_op_level;
   public String operation;
   public float preop_lab_level;
   public float prime_volume;
   public float rbc_required;
   public float required_hb;
   public float urine_prebypass;
   public float weight;

   public Patient() {
   }

   private Patient(Parcel var1) {
      this.calcid = var1.readInt();
      this.age = var1.readInt();
      this.gender = var1.readInt();
      this.cardiac = var1.readInt();
      this.operation = var1.readString();
      this.weight = var1.readFloat();
      this.height = var1.readFloat();
      this.preop_lab_level = var1.readFloat();
      this.first_pass_removed = var1.readFloat();
      this.prime_volume = var1.readFloat();
      this.fluid_prebypass = var1.readFloat();
      this.urine_prebypass = var1.readFloat();
      this.nc_blood_vol = var1.readFloat();
      this.nc_blood_loss = var1.readFloat();
      this.nc_required_post_op_level = var1.readFloat();
      this.required_hb = var1.readFloat();
      this.rbc_required = var1.readFloat();
      this.calc_ts = var1.readString();
   }

   // $FF: synthetic method
   Patient(Parcel var1, Object var2) {
      this(var1);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeInt(this.calcid);
      var1.writeInt(this.age);
      var1.writeInt(this.gender);
      var1.writeInt(this.cardiac);
      var1.writeString(this.operation);
      var1.writeFloat(this.weight);
      var1.writeFloat(this.height);
      var1.writeFloat(this.preop_lab_level);
      var1.writeFloat(this.first_pass_removed);
      var1.writeFloat(this.prime_volume);
      var1.writeFloat(this.fluid_prebypass);
      var1.writeFloat(this.urine_prebypass);
      var1.writeFloat(this.nc_blood_vol);
      var1.writeFloat(this.nc_blood_loss);
      var1.writeFloat(this.nc_required_post_op_level);
      var1.writeFloat(this.required_hb);
      var1.writeFloat(this.rbc_required);
      var1.writeString(this.calc_ts);
   }
}
