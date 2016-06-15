package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.internal.af;
import com.google.android.gms.wearable.internal.class_768;

// $FF: renamed from: com.google.android.gms.wearable.internal.af
public class class_773 implements SafeParcelable, MessageEvent {
   public static final Creator<af> CREATOR = new class_768();
   // $FF: renamed from: TC byte[]
   private final byte[] field_4115;
   private final String alS;
   private final String alT;
   // $FF: renamed from: qX int
   private final int field_4116;
   // $FF: renamed from: xJ int
   final int field_4117;

   class_773(int var1, int var2, String var3, byte[] var4, String var5) {
      this.field_4117 = var1;
      this.field_4116 = var2;
      this.alS = var3;
      this.field_4115 = var4;
      this.alT = var5;
   }

   public int describeContents() {
      return 0;
   }

   public byte[] getData() {
      return this.field_4115;
   }

   public String getPath() {
      return this.alS;
   }

   public int getRequestId() {
      return this.field_4116;
   }

   public String getSourceNodeId() {
      return this.alT;
   }

   public String toString() {
      StringBuilder var1 = (new StringBuilder()).append("MessageEventParcelable[").append(this.field_4116).append(",").append(this.alS).append(", size=");
      Object var2;
      if(this.field_4115 == null) {
         var2 = "null";
      } else {
         var2 = Integer.valueOf(this.field_4115.length);
      }

      return var1.append(var2).append("]").toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_768.method_4347(this, var1, var2);
   }
}
