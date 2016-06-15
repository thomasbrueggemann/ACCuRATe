package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_251;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.PlayerLevel;
import com.google.android.gms.games.PlayerLevelInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoRef;
import com.google.android.gms.games.internal.player.PlayerColumnNames;

public final class PlayerRef extends class_251 implements Player {
   // $FF: renamed from: Xm com.google.android.gms.games.PlayerLevelInfo
   private final PlayerLevelInfo field_533;
   // $FF: renamed from: Xv com.google.android.gms.games.internal.player.PlayerColumnNames
   private final PlayerColumnNames field_534;
   // $FF: renamed from: Xw com.google.android.gms.games.internal.player.MostRecentGameInfoRef
   private final MostRecentGameInfoRef field_535;

   public PlayerRef(DataHolder var1, int var2) {
      this(var1, var2, (String)null);
   }

   public PlayerRef(DataHolder var1, int var2, String var3) {
      super(var1, var2);
      this.field_534 = new PlayerColumnNames(var3);
      this.field_535 = new MostRecentGameInfoRef(var1, var2, this.field_534);
      if(this.method_1675()) {
         int var4 = this.getInteger(this.field_534.acV);
         int var5 = this.getInteger(this.field_534.acY);
         PlayerLevel var6 = new PlayerLevel(var4, this.getLong(this.field_534.acW), this.getLong(this.field_534.acX));
         PlayerLevel var7;
         if(var4 != var5) {
            var7 = new PlayerLevel(var5, this.getLong(this.field_534.acX), this.getLong(this.field_534.acZ));
         } else {
            var7 = var6;
         }

         this.field_533 = new PlayerLevelInfo(this.getLong(this.field_534.acU), this.getLong(this.field_534.ada), var6, var7);
      } else {
         this.field_533 = null;
      }
   }

   // $FF: renamed from: kG () boolean
   private boolean method_1675() {
      return !this.aS(this.field_534.acU) && this.getLong(this.field_534.acU) != -1L;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return PlayerEntity.method_2406(this, var1);
   }

   public Player freeze() {
      return new PlayerEntity(this);
   }

   public String getDisplayName() {
      return this.getString(this.field_534.acM);
   }

   public void getDisplayName(CharArrayBuffer var1) {
      this.a(this.field_534.acM, var1);
   }

   public Uri getHiResImageUri() {
      return this.aR(this.field_534.acP);
   }

   public String getHiResImageUrl() {
      return this.getString(this.field_534.acQ);
   }

   public Uri getIconImageUri() {
      return this.aR(this.field_534.acN);
   }

   public String getIconImageUrl() {
      return this.getString(this.field_534.acO);
   }

   public long getLastPlayedWithTimestamp() {
      return this.aQ(this.field_534.acT) && !this.aS(this.field_534.acT)?this.getLong(this.field_534.acT):-1L;
   }

   public PlayerLevelInfo getLevelInfo() {
      return this.field_533;
   }

   public String getPlayerId() {
      return this.getString(this.field_534.acL);
   }

   public long getRetrievedTimestamp() {
      return this.getLong(this.field_534.acR);
   }

   public String getTitle() {
      return this.getString(this.field_534.adb);
   }

   public void getTitle(CharArrayBuffer var1) {
      this.a(this.field_534.adb, var1);
   }

   public boolean hasHiResImage() {
      return this.getHiResImageUri() != null;
   }

   public boolean hasIconImage() {
      return this.getIconImageUri() != null;
   }

   public int hashCode() {
      return PlayerEntity.method_2407(this);
   }

   public boolean isProfileVisible() {
      return this.getBoolean(this.field_534.add);
   }

   // $FF: renamed from: kE () int
   public int method_252() {
      return this.getInteger(this.field_534.acS);
   }

   // $FF: renamed from: kF () com.google.android.gms.games.internal.player.MostRecentGameInfo
   public MostRecentGameInfo method_253() {
      return this.aS(this.field_534.ade)?null:this.field_535;
   }

   public String toString() {
      return PlayerEntity.method_2410(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((PlayerEntity)this.freeze()).writeToParcel(var1, var2);
   }
}
