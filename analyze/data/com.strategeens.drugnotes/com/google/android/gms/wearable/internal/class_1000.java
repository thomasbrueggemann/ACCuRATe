package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.internal.ai;
import com.google.android.gms.wearable.internal.class_1001;

// $FF: renamed from: com.google.android.gms.wearable.internal.ai
public class class_1000 implements SafeParcelable, MessageEvent {
   public static final Creator<ai> CREATOR = new class_1001();
   // $FF: renamed from: CK int
   final int field_4262;
   private final byte[] aeA;
   private final String ahy;
   private final String axW;
   // $FF: renamed from: ve int
   private final int field_4263;

   class_1000(int var1, int var2, String var3, byte[] var4, String var5) {
      this.field_4262 = var1;
      this.field_4263 = var2;
      this.axW = var3;
      this.aeA = var4;
      this.ahy = var5;
   }

   public int describeContents() {
      return 0;
   }

   public byte[] getData() {
      return this.aeA;
   }

   public String getPath() {
      return this.axW;
   }

   public int getRequestId() {
      return this.field_4263;
   }

   public String getSourceNodeId() {
      return this.ahy;
   }

   public String toString() {
      StringBuilder var1 = (new StringBuilder()).append("MessageEventParcelable[").append(this.field_4263).append(",").append(this.axW).append(", size=");
      Object var2;
      if(this.aeA == null) {
         var2 = "null";
      } else {
         var2 = Integer.valueOf(this.aeA.length);
      }

      return var1.append(var2).append("]").toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1001.method_5499(this, var1, var2);
   }
}
