package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.class_347;

public final class RealTimeMessage implements Parcelable {
   public static final Creator<RealTimeMessage> CREATOR = new Creator() {
      // $FF: renamed from: bn (android.os.Parcel) com.google.android.gms.games.multiplayer.realtime.RealTimeMessage
      public RealTimeMessage method_3865(Parcel var1) {
         return new RealTimeMessage(var1, null);
      }

      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.method_3865(var1);
      }

      // $FF: renamed from: cz (int) com.google.android.gms.games.multiplayer.realtime.RealTimeMessage[]
      public RealTimeMessage[] method_3866(int var1) {
         return new RealTimeMessage[var1];
      }

      // $FF: synthetic method
      public Object[] newArray(int var1) {
         return this.method_3866(var1);
      }
   };
   public static final int RELIABLE = 1;
   public static final int UNRELIABLE;
   // $FF: renamed from: Te java.lang.String
   private final String field_3280;
   // $FF: renamed from: Tf byte[]
   private final byte[] field_3281;
   // $FF: renamed from: Tg int
   private final int field_3282;

   private RealTimeMessage(Parcel var1) {
      this(var1.readString(), var1.createByteArray(), var1.readInt());
   }

   // $FF: synthetic method
   RealTimeMessage(Parcel var1, Object var2) {
      this(var1);
   }

   public RealTimeMessage(String var1, byte[] var2, int var3) {
      this.field_3280 = (String)class_347.method_2170(var1);
      this.field_3281 = (byte[])((byte[])class_347.method_2170(var2)).clone();
      this.field_3282 = var3;
   }

   public int describeContents() {
      return 0;
   }

   public byte[] getMessageData() {
      return this.field_3281;
   }

   public String getSenderParticipantId() {
      return this.field_3280;
   }

   public boolean isReliable() {
      return this.field_3282 == 1;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.field_3280);
      var1.writeByteArray(this.field_3281);
      var1.writeInt(this.field_3282);
   }
}
