package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_206;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.games.internal.player.PlayerColumnNames;

public final class MostRecentGameInfoRef extends class_206 implements MostRecentGameInfo {
   // $FF: renamed from: Nd com.google.android.gms.games.internal.player.PlayerColumnNames
   private final PlayerColumnNames field_688;

   public MostRecentGameInfoRef(DataHolder var1, int var2, PlayerColumnNames var3) {
      super(var1, var2);
      this.field_688 = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return MostRecentGameInfoEntity.method_3924(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_1354();
   }

   public int hashCode() {
      return MostRecentGameInfoEntity.method_3923(this);
   }

   // $FF: renamed from: ik () java.lang.String
   public String method_220() {
      return this.getString(this.field_688.field_3556);
   }

   // $FF: renamed from: il () java.lang.String
   public String method_221() {
      return this.getString(this.field_688.field_3557);
   }

   // $FF: renamed from: im () long
   public long method_222() {
      return this.getLong(this.field_688.field_3558);
   }

   // $FF: renamed from: in () android.net.Uri
   public Uri method_223() {
      return this.aw(this.field_688.field_3559);
   }

   // $FF: renamed from: io () android.net.Uri
   public Uri method_224() {
      return this.aw(this.field_688.field_3560);
   }

   // $FF: renamed from: ip () android.net.Uri
   public Uri method_225() {
      return this.aw(this.field_688.field_3561);
   }

   // $FF: renamed from: iq () com.google.android.gms.games.internal.player.MostRecentGameInfo
   public MostRecentGameInfo method_1354() {
      return new MostRecentGameInfoEntity(this);
   }

   public String toString() {
      return MostRecentGameInfoEntity.method_3925(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((MostRecentGameInfoEntity)this.method_1354()).writeToParcel(var1, var2);
   }
}
