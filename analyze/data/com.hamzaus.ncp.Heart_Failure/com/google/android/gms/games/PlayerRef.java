package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_206;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.PlayerLevel;
import com.google.android.gms.games.PlayerLevelInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoRef;
import com.google.android.gms.games.internal.player.PlayerColumnNames;

public final class PlayerRef extends class_206 implements Player {
   // $FF: renamed from: MU com.google.android.gms.games.PlayerLevelInfo
   private final PlayerLevelInfo field_691;
   // $FF: renamed from: Nd com.google.android.gms.games.internal.player.PlayerColumnNames
   private final PlayerColumnNames field_692;
   // $FF: renamed from: Ne com.google.android.gms.games.internal.player.MostRecentGameInfoRef
   private final MostRecentGameInfoRef field_693;

   public PlayerRef(DataHolder var1, int var2) {
      this(var1, var2, (String)null);
   }

   public PlayerRef(DataHolder var1, int var2, String var3) {
      super(var1, var2);
      this.field_692 = new PlayerColumnNames(var3);
      this.field_693 = new MostRecentGameInfoRef(var1, var2, this.field_692);
      if(this.method_1368()) {
         int var4 = this.getInteger(this.field_692.field_3548);
         int var5 = this.getInteger(this.field_692.field_3551);
         PlayerLevel var6 = new PlayerLevel(var4, this.getLong(this.field_692.field_3549), this.getLong(this.field_692.field_3550));
         PlayerLevel var7;
         if(var4 != var5) {
            var7 = new PlayerLevel(var5, this.getLong(this.field_692.field_3550), this.getLong(this.field_692.field_3552));
         } else {
            var7 = var6;
         }

         this.field_691 = new PlayerLevelInfo(this.getLong(this.field_692.field_3547), this.getLong(this.field_692.field_3553), var6, var7);
      } else {
         this.field_691 = null;
      }
   }

   // $FF: renamed from: gQ () boolean
   private boolean method_1368() {
      return !this.ax(this.field_692.field_3547) && this.getLong(this.field_692.field_3547) != -1L;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return PlayerEntity.method_2219(this, var1);
   }

   public Player freeze() {
      return new PlayerEntity(this);
   }

   // $FF: renamed from: gN () int
   public int method_226() {
      return this.getInteger(this.field_692.field_3545);
   }

   // $FF: renamed from: gO () boolean
   public boolean method_227() {
      return this.getBoolean(this.field_692.field_3555);
   }

   // $FF: renamed from: gP () com.google.android.gms.games.internal.player.MostRecentGameInfo
   public MostRecentGameInfo method_228() {
      return this.ax(this.field_692.field_3556)?null:this.field_693;
   }

   public String getDisplayName() {
      return this.getString(this.field_692.field_3539);
   }

   public void getDisplayName(CharArrayBuffer var1) {
      this.a(this.field_692.field_3539, var1);
   }

   public Uri getHiResImageUri() {
      return this.aw(this.field_692.field_3542);
   }

   public String getHiResImageUrl() {
      return this.getString(this.field_692.field_3543);
   }

   public Uri getIconImageUri() {
      return this.aw(this.field_692.field_3540);
   }

   public String getIconImageUrl() {
      return this.getString(this.field_692.field_3541);
   }

   public long getLastPlayedWithTimestamp() {
      return this.av(this.field_692.field_3546) && !this.ax(this.field_692.field_3546)?this.getLong(this.field_692.field_3546):-1L;
   }

   public PlayerLevelInfo getLevelInfo() {
      return this.field_691;
   }

   public String getPlayerId() {
      return this.getString(this.field_692.field_3538);
   }

   public long getRetrievedTimestamp() {
      return this.getLong(this.field_692.field_3544);
   }

   public String getTitle() {
      return this.getString(this.field_692.field_3554);
   }

   public void getTitle(CharArrayBuffer var1) {
      this.a(this.field_692.field_3554, var1);
   }

   public boolean hasHiResImage() {
      return this.getHiResImageUri() != null;
   }

   public boolean hasIconImage() {
      return this.getIconImageUri() != null;
   }

   public int hashCode() {
      return PlayerEntity.method_2218(this);
   }

   public String toString() {
      return PlayerEntity.method_2221(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((PlayerEntity)this.freeze()).writeToParcel(var1, var2);
   }
}
