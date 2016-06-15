package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.class_335;

public final class RealTimeMessage implements Parcelable {
   public static final Creator<RealTimeMessage> CREATOR = new Creator() {
      // $FF: renamed from: cB (android.os.Parcel) com.google.android.gms.games.multiplayer.realtime.RealTimeMessage
      public RealTimeMessage method_4837(Parcel var1) {
         return new RealTimeMessage(var1, null);
      }

      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.method_4837(var1);
      }

      // $FF: renamed from: en (int) com.google.android.gms.games.multiplayer.realtime.RealTimeMessage[]
      public RealTimeMessage[] method_4838(int var1) {
         return new RealTimeMessage[var1];
      }

      // $FF: synthetic method
      public Object[] newArray(int var1) {
         return this.method_4838(var1);
      }
   };
   public static final int RELIABLE = 1;
   public static final int UNRELIABLE;
   private final String aee;
   private final byte[] aef;
   private final int aeg;

   private RealTimeMessage(Parcel var1) {
      this(var1.readString(), var1.createByteArray(), var1.readInt());
   }

   // $FF: synthetic method
   RealTimeMessage(Parcel var1, Object var2) {
      this(var1);
   }

   public RealTimeMessage(String var1, byte[] var2, int var3) {
      this.aee = (String)class_335.method_2311(var1);
      this.aef = (byte[])((byte[])class_335.method_2311(var2)).clone();
      this.aeg = var3;
   }

   public int describeContents() {
      return 0;
   }

   public byte[] getMessageData() {
      return this.aef;
   }

   public String getSenderParticipantId() {
      return this.aee;
   }

   public boolean isReliable() {
      return this.aeg == 1;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.aee);
      var1.writeByteArray(this.aef);
      var1.writeInt(this.aeg);
   }
}
