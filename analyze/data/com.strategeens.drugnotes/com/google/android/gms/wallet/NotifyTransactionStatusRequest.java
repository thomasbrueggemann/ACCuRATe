package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.wallet.class_945;

public final class NotifyTransactionStatusRequest implements SafeParcelable {
   public static final Creator<NotifyTransactionStatusRequest> CREATOR = new class_945();
   // $FF: renamed from: CK int
   final int field_4195;
   String auL;
   String avL;
   int status;

   NotifyTransactionStatusRequest() {
      this.field_4195 = 1;
   }

   NotifyTransactionStatusRequest(int var1, String var2, int var3, String var4) {
      this.field_4195 = var1;
      this.auL = var2;
      this.status = var3;
      this.avL = var4;
   }

   public static NotifyTransactionStatusRequest.Builder newBuilder() {
      NotifyTransactionStatusRequest var0 = new NotifyTransactionStatusRequest();
      return var0.new Builder();
   }

   public int describeContents() {
      return 0;
   }

   public String getDetailedReason() {
      return this.avL;
   }

   public String getGoogleTransactionId() {
      return this.auL;
   }

   public int getStatus() {
      return this.status;
   }

   public int getVersionCode() {
      return this.field_4195;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_945.method_5221(this, var1, var2);
   }

   public final class Builder {
      private Builder() {
      }

      // $FF: synthetic method
      Builder(Object var2) {
         this();
      }

      public NotifyTransactionStatusRequest build() {
         byte var1 = 1;
         byte var2;
         if(!TextUtils.isEmpty(NotifyTransactionStatusRequest.this.auL)) {
            var2 = var1;
         } else {
            var2 = 0;
         }

         class_335.method_2308((boolean)var2, "googleTransactionId is required");
         if(NotifyTransactionStatusRequest.this.status < var1 || NotifyTransactionStatusRequest.this.status > 8) {
            var1 = 0;
         }

         class_335.method_2308((boolean)var1, "status is an unrecognized value");
         return NotifyTransactionStatusRequest.this;
      }

      public NotifyTransactionStatusRequest.Builder setDetailedReason(String var1) {
         NotifyTransactionStatusRequest.this.avL = var1;
         return this;
      }

      public NotifyTransactionStatusRequest.Builder setGoogleTransactionId(String var1) {
         NotifyTransactionStatusRequest.this.auL = var1;
         return this;
      }

      public NotifyTransactionStatusRequest.Builder setStatus(int var1) {
         NotifyTransactionStatusRequest.this.status = var1;
         return this;
      }
   }

   public interface Status {
      int SUCCESS = 1;
   }

   public interface Error {
      int AVS_DECLINE = 7;
      int BAD_CARD = 4;
      int BAD_CVC = 3;
      int DECLINED = 5;
      int FRAUD_DECLINE = 8;
      int OTHER = 6;
      int UNKNOWN = 2;
   }
}
