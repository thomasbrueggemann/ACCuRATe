package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntityCreator;
import com.google.android.gms.games.PlayerLevelInfo;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.internal.class_284;
import com.google.android.gms.internal.class_322;
import com.google.android.gms.internal.class_349;

public final class PlayerEntity extends GamesDowngradeableSafeParcel implements Player {
   public static final Creator<PlayerEntity> CREATOR = new PlayerEntity.PlayerEntityCreatorCompat();
   // $FF: renamed from: HV java.lang.String
   private final String field_1478;
   // $FF: renamed from: Lk java.lang.String
   private final String field_1479;
   // $FF: renamed from: MA java.lang.String
   private final String field_1480;
   // $FF: renamed from: MP java.lang.String
   private final String field_1481;
   // $FF: renamed from: MQ long
   private final long field_1482;
   // $FF: renamed from: MR int
   private final int field_1483;
   // $FF: renamed from: MS long
   private final long field_1484;
   // $FF: renamed from: MT com.google.android.gms.games.internal.player.MostRecentGameInfoEntity
   private final MostRecentGameInfoEntity field_1485;
   // $FF: renamed from: MU com.google.android.gms.games.PlayerLevelInfo
   private final PlayerLevelInfo field_1486;
   // $FF: renamed from: MV boolean
   private final boolean field_1487;
   // $FF: renamed from: Mo android.net.Uri
   private final Uri field_1488;
   // $FF: renamed from: Mp android.net.Uri
   private final Uri field_1489;
   // $FF: renamed from: Mz java.lang.String
   private final String field_1490;
   // $FF: renamed from: xJ int
   private final int field_1491;

   PlayerEntity(int var1, String var2, String var3, Uri var4, Uri var5, long var6, int var8, long var9, String var11, String var12, String var13, MostRecentGameInfoEntity var14, PlayerLevelInfo var15, boolean var16) {
      this.field_1491 = var1;
      this.field_1481 = var2;
      this.field_1479 = var3;
      this.field_1488 = var4;
      this.field_1490 = var11;
      this.field_1489 = var5;
      this.field_1480 = var12;
      this.field_1482 = var6;
      this.field_1483 = var8;
      this.field_1484 = var9;
      this.field_1478 = var13;
      this.field_1487 = var16;
      this.field_1485 = var14;
      this.field_1486 = var15;
   }

   public PlayerEntity(Player var1) {
      this.field_1491 = 10;
      this.field_1481 = var1.getPlayerId();
      this.field_1479 = var1.getDisplayName();
      this.field_1488 = var1.getIconImageUri();
      this.field_1490 = var1.getIconImageUrl();
      this.field_1489 = var1.getHiResImageUri();
      this.field_1480 = var1.getHiResImageUrl();
      this.field_1482 = var1.getRetrievedTimestamp();
      this.field_1483 = var1.method_226();
      this.field_1484 = var1.getLastPlayedWithTimestamp();
      this.field_1478 = var1.getTitle();
      this.field_1487 = var1.method_227();
      MostRecentGameInfo var2 = var1.method_228();
      MostRecentGameInfoEntity var3;
      if(var2 == null) {
         var3 = null;
      } else {
         var3 = new MostRecentGameInfoEntity(var2);
      }

      this.field_1485 = var3;
      this.field_1486 = var1.getLevelInfo();
      class_322.method_2054(this.field_1481);
      class_322.method_2054(this.field_1479);
      boolean var4;
      if(this.field_1482 > 0L) {
         var4 = true;
      } else {
         var4 = false;
      }

      class_322.method_2050(var4);
   }

   // $FF: renamed from: a (com.google.android.gms.games.Player) int
   static int method_2218(Player var0) {
      Object[] var1 = new Object[]{var0.getPlayerId(), var0.getDisplayName(), var0.getIconImageUri(), var0.getHiResImageUri(), Long.valueOf(var0.getRetrievedTimestamp()), var0.getTitle(), var0.getLevelInfo()};
      return class_349.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.Player, java.lang.Object) boolean
   static boolean method_2219(Player var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof Player)) {
         var2 = false;
      } else if(var0 != var1) {
         Player var3 = (Player)var1;
         if(!class_349.equal(var3.getPlayerId(), var0.getPlayerId()) || !class_349.equal(var3.getDisplayName(), var0.getDisplayName()) || !class_349.equal(var3.getIconImageUri(), var0.getIconImageUri()) || !class_349.equal(var3.getHiResImageUri(), var0.getHiResImageUri()) || !class_349.equal(Long.valueOf(var3.getRetrievedTimestamp()), Long.valueOf(var0.getRetrievedTimestamp())) || !class_349.equal(var3.getTitle(), var0.getTitle()) || !class_349.equal(var3.getLevelInfo(), var0.getLevelInfo())) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.Player) java.lang.String
   static String method_2221(Player var0) {
      return class_349.method_2174(var0).method_4301("PlayerId", var0.getPlayerId()).method_4301("DisplayName", var0.getDisplayName()).method_4301("IconImageUri", var0.getIconImageUri()).method_4301("IconImageUrl", var0.getIconImageUrl()).method_4301("HiResImageUri", var0.getHiResImageUri()).method_4301("HiResImageUrl", var0.getHiResImageUrl()).method_4301("RetrievedTimestamp", Long.valueOf(var0.getRetrievedTimestamp())).method_4301("Title", var0.getTitle()).method_4301("LevelInfo", var0.getLevelInfo()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_2219(this, var1);
   }

   public Player freeze() {
      return this;
   }

   // $FF: renamed from: gN () int
   public int method_226() {
      return this.field_1483;
   }

   // $FF: renamed from: gO () boolean
   public boolean method_227() {
      return this.field_1487;
   }

   // $FF: renamed from: gP () com.google.android.gms.games.internal.player.MostRecentGameInfo
   public MostRecentGameInfo method_228() {
      return this.field_1485;
   }

   public String getDisplayName() {
      return this.field_1479;
   }

   public void getDisplayName(CharArrayBuffer var1) {
      class_284.method_1876(this.field_1479, var1);
   }

   public Uri getHiResImageUri() {
      return this.field_1489;
   }

   public String getHiResImageUrl() {
      return this.field_1480;
   }

   public Uri getIconImageUri() {
      return this.field_1488;
   }

   public String getIconImageUrl() {
      return this.field_1490;
   }

   public long getLastPlayedWithTimestamp() {
      return this.field_1484;
   }

   public PlayerLevelInfo getLevelInfo() {
      return this.field_1486;
   }

   public String getPlayerId() {
      return this.field_1481;
   }

   public long getRetrievedTimestamp() {
      return this.field_1482;
   }

   public String getTitle() {
      return this.field_1478;
   }

   public void getTitle(CharArrayBuffer var1) {
      class_284.method_1876(this.field_1478, var1);
   }

   public int getVersionCode() {
      return this.field_1491;
   }

   public boolean hasHiResImage() {
      return this.getHiResImageUri() != null;
   }

   public boolean hasIconImage() {
      return this.getIconImageUri() != null;
   }

   public int hashCode() {
      return method_2218(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public String toString() {
      return method_2221(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(!this.fm()) {
         PlayerEntityCreator.method_3163(this, var1, var2);
      } else {
         var1.writeString(this.field_1481);
         var1.writeString(this.field_1479);
         String var3;
         if(this.field_1488 == null) {
            var3 = null;
         } else {
            var3 = this.field_1488.toString();
         }

         var1.writeString(var3);
         Uri var4 = this.field_1489;
         String var5 = null;
         if(var4 != null) {
            var5 = this.field_1489.toString();
         }

         var1.writeString(var5);
         var1.writeLong(this.field_1482);
      }
   }

   static final class PlayerEntityCreatorCompat extends PlayerEntityCreator {
      // $FF: renamed from: be (android.os.Parcel) com.google.android.gms.games.PlayerEntity
      public PlayerEntity method_3164(Parcel var1) {
         if(!PlayerEntity.c(PlayerEntity.fl()) && !PlayerEntity.aA(PlayerEntity.class.getCanonicalName())) {
            String var2 = var1.readString();
            String var3 = var1.readString();
            String var4 = var1.readString();
            String var5 = var1.readString();
            Uri var6;
            if(var4 == null) {
               var6 = null;
            } else {
               var6 = Uri.parse(var4);
            }

            Uri var7;
            if(var5 == null) {
               var7 = null;
            } else {
               var7 = Uri.parse(var5);
            }

            return new PlayerEntity(10, var2, var3, var6, var7, var1.readLong(), -1, -1L, (String)null, (String)null, (String)null, (MostRecentGameInfoEntity)null, (PlayerLevelInfo)null, true);
         } else {
            return super.method_3164(var1);
         }
      }

      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.method_3164(var1);
      }
   }
}
