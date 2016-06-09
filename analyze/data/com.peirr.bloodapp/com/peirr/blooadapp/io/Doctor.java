package com.peirr.blooadapp.io;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Doctor implements Parcelable {
   public static final Creator<Doctor> CREATOR = new Creator() {
      public Doctor createFromParcel(Parcel var1) {
         return new Doctor(var1, null);
      }

      public Doctor[] newArray(int var1) {
         return new Doctor[var1];
      }
   };
   public int cardiac;
   public String country;
   public int docid;
   public String email;
   public String hospital;
   public String name;
   public String position;
   public String profession;
   public String registration_ts;

   public Doctor() {
   }

   private Doctor(Parcel var1) {
      this.docid = var1.readInt();
      this.name = var1.readString();
      this.country = var1.readString();
      this.hospital = var1.readString();
      this.position = var1.readString();
      this.profession = var1.readString();
      this.cardiac = var1.readInt();
      this.email = var1.readString();
      this.registration_ts = var1.readString();
   }

   // $FF: synthetic method
   Doctor(Parcel var1, Object var2) {
      this(var1);
   }

   public int describeContents() {
      return 0;
   }

   public String toString() {
      return "Doctor{docid=" + this.docid + ", name=\'" + this.name + '\'' + ", country=\'" + this.country + '\'' + ", hospital=\'" + this.hospital + '\'' + ", position=\'" + this.position + '\'' + ", profession=\'" + this.profession + '\'' + ", cardiac=" + this.cardiac + ", email=\'" + this.email + '\'' + ", registration_ts=\'" + this.registration_ts + '\'' + '}';
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeInt(this.docid);
      var1.writeString(this.name);
      var1.writeString(this.country);
      var1.writeString(this.hospital);
      var1.writeString(this.position);
      var1.writeString(this.profession);
      var1.writeInt(this.cardiac);
      var1.writeString(this.email);
      var1.writeString(this.registration_ts);
   }
}
