package com.peirr.blooadapp.io;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PreBypassCalculation implements Parcelable {
   public static final Creator<PreBypassCalculation> CREATOR = new Creator() {
      public PreBypassCalculation createFromParcel(Parcel var1) {
         return new PreBypassCalculation(var1, null);
      }

      public PreBypassCalculation[] newArray(int var1) {
         return new PreBypassCalculation[var1];
      }
   };
   public float actualPumpHb;
   public int age;
   public float bloodvolume;
   public boolean cardiac;
   public float expectedLoss;
   public float height;
   public float numberOfUnitsRBCNecessary;
   public String operation;
   public float preOpHb;
   public float predictedHbOnPump;
   public float predictedInitialHbOnPump;
   public float rbc;
   public float requiredHb;
   public float requiredPostOp;
   public float weight;

   public PreBypassCalculation() {
   }

   private PreBypassCalculation(Parcel var1) {
      this.predictedHbOnPump = var1.readFloat();
      this.numberOfUnitsRBCNecessary = var1.readFloat();
      this.predictedInitialHbOnPump = var1.readFloat();
      this.bloodvolume = var1.readFloat();
      this.actualPumpHb = var1.readFloat();
      this.preOpHb = var1.readFloat();
      this.expectedLoss = var1.readFloat();
      this.requiredPostOp = var1.readFloat();
      this.age = var1.readInt();
      this.weight = var1.readFloat();
      this.height = var1.readFloat();
      this.operation = var1.readString();
      boolean var2;
      if(var1.readByte() != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.cardiac = var2;
      this.requiredHb = var1.readFloat();
      this.rbc = var1.readFloat();
   }

   // $FF: synthetic method
   PreBypassCalculation(Parcel var1, Object var2) {
      this(var1);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeFloat(this.predictedHbOnPump);
      var1.writeFloat(this.numberOfUnitsRBCNecessary);
      var1.writeFloat(this.predictedInitialHbOnPump);
      var1.writeFloat(this.bloodvolume);
      var1.writeFloat(this.actualPumpHb);
      var1.writeFloat(this.preOpHb);
      var1.writeFloat(this.expectedLoss);
      var1.writeFloat(this.requiredPostOp);
      var1.writeInt(this.age);
      var1.writeFloat(this.weight);
      var1.writeFloat(this.height);
      var1.writeString(this.operation);
      byte var3;
      if(this.cardiac) {
         var3 = 1;
      } else {
         var3 = 0;
      }

      var1.writeByte(var3);
      var1.writeFloat(this.requiredHb);
      var1.writeFloat(this.rbc);
   }
}
