package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzx;

public final class RealTimeMessage implements Parcelable {
   public static final Creator<RealTimeMessage> CREATOR = new Creator() {
      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.zzeu(var1);
      }

      // $FF: synthetic method
      public Object[] newArray(int var1) {
         return this.zzgK(var1);
      }

      public RealTimeMessage zzeu(Parcel var1) {
         return new RealTimeMessage(var1, null);
      }

      public RealTimeMessage[] zzgK(int var1) {
         return new RealTimeMessage[var1];
      }
   };
   private final String zzaJR;
   private final byte[] zzaJS;
   private final int zzaJT;

   private RealTimeMessage(Parcel var1) {
      this(var1.readString(), var1.createByteArray(), var1.readInt());
   }

   // $FF: synthetic method
   RealTimeMessage(Parcel var1, Object var2) {
      this(var1);
   }

   public RealTimeMessage(String var1, byte[] var2, int var3) {
      this.zzaJR = (String)zzx.zzz(var1);
      this.zzaJS = (byte[])((byte[])zzx.zzz(var2)).clone();
      this.zzaJT = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.zzaJR);
      var1.writeByteArray(this.zzaJS);
      var1.writeInt(this.zzaJT);
   }
}
