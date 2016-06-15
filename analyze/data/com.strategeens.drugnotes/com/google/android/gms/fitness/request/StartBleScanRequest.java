package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.class_338;
import com.google.android.gms.fitness.request.class_493;
import com.google.android.gms.fitness.request.class_54;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_724;
import java.util.Collections;
import java.util.List;

public class StartBleScanRequest implements SafeParcelable {
   public static final Creator<StartBleScanRequest> CREATOR = new class_493();
   // $FF: renamed from: CK int
   private final int field_1756;
   // $FF: renamed from: TY java.util.List
   private final List<DataType> field_1757;
   // $FF: renamed from: Wm com.google.android.gms.fitness.request.l
   private final class_54 field_1758;
   // $FF: renamed from: Wn int
   private final int field_1759;

   StartBleScanRequest(int var1, List<DataType> var2, IBinder var3, int var4) {
      this.field_1756 = var1;
      this.field_1757 = var2;
      this.field_1758 = class_54.class_1099.method_2318(var3);
      this.field_1759 = var4;
   }

   private StartBleScanRequest(StartBleScanRequest.Builder var1) {
      this.field_1756 = 2;
      this.field_1757 = class_724.method_4215(var1.field_1506);
      this.field_1758 = var1.field_1507;
      this.field_1759 = var1.field_1508;
   }

   // $FF: synthetic method
   StartBleScanRequest(StartBleScanRequest.Builder var1, Object var2) {
      this(var1);
   }

   public int describeContents() {
      return 0;
   }

   public List<DataType> getDataTypes() {
      return Collections.unmodifiableList(this.field_1757);
   }

   public int getTimeoutSecs() {
      return this.field_1759;
   }

   int getVersionCode() {
      return this.field_1756;
   }

   // $FF: renamed from: km () android.os.IBinder
   public IBinder method_3044() {
      return this.field_1758.asBinder();
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("dataTypes", this.field_1757).method_3424("timeoutSecs", Integer.valueOf(this.field_1759)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_493.method_3110(this, var1, var2);
   }

   public static class Builder {
      // $FF: renamed from: VU com.google.android.gms.fitness.data.DataType[]
      private DataType[] field_1506 = new DataType[0];
      // $FF: renamed from: Wm com.google.android.gms.fitness.request.l
      private class_54 field_1507;
      // $FF: renamed from: Wn int
      private int field_1508 = 10;

      // $FF: renamed from: a (com.google.android.gms.fitness.request.l) com.google.android.gms.fitness.request.StartBleScanRequest$Builder
      public StartBleScanRequest.Builder method_2900(class_54 var1) {
         this.field_1507 = var1;
         return this;
      }

      public StartBleScanRequest build() {
         boolean var1;
         if(this.field_1507 != null) {
            var1 = true;
         } else {
            var1 = false;
         }

         class_335.method_2302(var1, "Must set BleScanCallback");
         return new StartBleScanRequest(this);
      }

      public StartBleScanRequest.Builder setBleScanCallback(BleScanCallback var1) {
         this.method_2900(class_338.class_1321.method_3405().method_3406(var1));
         return this;
      }

      public StartBleScanRequest.Builder setDataTypes(DataType... var1) {
         this.field_1506 = var1;
         return this;
      }

      public StartBleScanRequest.Builder setTimeoutSecs(int var1) {
         boolean var2 = true;
         boolean var3;
         if(var1 > 0) {
            var3 = var2;
         } else {
            var3 = false;
         }

         class_335.method_2308(var3, "Stop time must be greater than zero");
         if(var1 > 60) {
            var2 = false;
         }

         class_335.method_2308(var2, "Stop time must be less than 1 minute");
         this.field_1508 = var1;
         return this;
      }
   }
}
