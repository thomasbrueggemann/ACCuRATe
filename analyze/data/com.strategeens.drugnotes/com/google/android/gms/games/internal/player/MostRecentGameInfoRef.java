package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_251;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.games.internal.player.PlayerColumnNames;

public final class MostRecentGameInfoRef extends class_251 implements MostRecentGameInfo {
   // $FF: renamed from: Xv com.google.android.gms.games.internal.player.PlayerColumnNames
   private final PlayerColumnNames field_530;

   public MostRecentGameInfoRef(DataHolder var1, int var2, PlayerColumnNames var3) {
      super(var1, var2);
      this.field_530 = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return MostRecentGameInfoEntity.method_4910(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_1661();
   }

   public int hashCode() {
      return MostRecentGameInfoEntity.method_4909(this);
   }

   // $FF: renamed from: mA () android.net.Uri
   public Uri method_246() {
      return this.aR(this.field_530.adi);
   }

   // $FF: renamed from: mB () android.net.Uri
   public Uri method_247() {
      return this.aR(this.field_530.adj);
   }

   // $FF: renamed from: mC () com.google.android.gms.games.internal.player.MostRecentGameInfo
   public MostRecentGameInfo method_1661() {
      return new MostRecentGameInfoEntity(this);
   }

   // $FF: renamed from: mw () java.lang.String
   public String method_248() {
      return this.getString(this.field_530.ade);
   }

   // $FF: renamed from: mx () java.lang.String
   public String method_249() {
      return this.getString(this.field_530.adf);
   }

   // $FF: renamed from: my () long
   public long method_250() {
      return this.getLong(this.field_530.adg);
   }

   // $FF: renamed from: mz () android.net.Uri
   public Uri method_251() {
      return this.aR(this.field_530.adh);
   }

   public String toString() {
      return MostRecentGameInfoEntity.method_4911(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((MostRecentGameInfoEntity)this.method_1661()).writeToParcel(var1, var2);
   }
}
