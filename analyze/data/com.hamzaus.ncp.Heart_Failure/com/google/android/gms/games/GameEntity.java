package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntityCreator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.class_284;
import com.google.android.gms.internal.class_349;

public final class GameEntity extends GamesDowngradeableSafeParcel implements Game {
   public static final Creator<GameEntity> CREATOR = new GameEntity.GameEntityCreatorCompat();
   // $FF: renamed from: Lk java.lang.String
   private final String field_1492;
   // $FF: renamed from: MA java.lang.String
   private final String field_1493;
   // $FF: renamed from: MB java.lang.String
   private final String field_1494;
   // $FF: renamed from: MC boolean
   private final boolean field_1495;
   // $FF: renamed from: MD boolean
   private final boolean field_1496;
   // $FF: renamed from: ME boolean
   private final boolean field_1497;
   // $FF: renamed from: Mk java.lang.String
   private final String field_1498;
   // $FF: renamed from: Ml java.lang.String
   private final String field_1499;
   // $FF: renamed from: Mm java.lang.String
   private final String field_1500;
   // $FF: renamed from: Mn java.lang.String
   private final String field_1501;
   // $FF: renamed from: Mo android.net.Uri
   private final Uri field_1502;
   // $FF: renamed from: Mp android.net.Uri
   private final Uri field_1503;
   // $FF: renamed from: Mq android.net.Uri
   private final Uri field_1504;
   // $FF: renamed from: Mr boolean
   private final boolean field_1505;
   // $FF: renamed from: Ms boolean
   private final boolean field_1506;
   // $FF: renamed from: Mt java.lang.String
   private final String field_1507;
   // $FF: renamed from: Mu int
   private final int field_1508;
   // $FF: renamed from: Mv int
   private final int field_1509;
   // $FF: renamed from: Mw int
   private final int field_1510;
   // $FF: renamed from: Mx boolean
   private final boolean field_1511;
   // $FF: renamed from: My boolean
   private final boolean field_1512;
   // $FF: renamed from: Mz java.lang.String
   private final String field_1513;
   // $FF: renamed from: xJ int
   private final int field_1514;
   // $FF: renamed from: zM java.lang.String
   private final String field_1515;

   GameEntity(int var1, String var2, String var3, String var4, String var5, String var6, String var7, Uri var8, Uri var9, Uri var10, boolean var11, boolean var12, String var13, int var14, int var15, int var16, boolean var17, boolean var18, String var19, String var20, String var21, boolean var22, boolean var23, boolean var24) {
      this.field_1514 = var1;
      this.field_1515 = var2;
      this.field_1492 = var3;
      this.field_1498 = var4;
      this.field_1499 = var5;
      this.field_1500 = var6;
      this.field_1501 = var7;
      this.field_1502 = var8;
      this.field_1513 = var19;
      this.field_1503 = var9;
      this.field_1493 = var20;
      this.field_1504 = var10;
      this.field_1494 = var21;
      this.field_1505 = var11;
      this.field_1506 = var12;
      this.field_1507 = var13;
      this.field_1508 = var14;
      this.field_1509 = var15;
      this.field_1510 = var16;
      this.field_1511 = var17;
      this.field_1512 = var18;
      this.field_1495 = var22;
      this.field_1496 = var23;
      this.field_1497 = var24;
   }

   public GameEntity(Game var1) {
      this.field_1514 = 4;
      this.field_1515 = var1.getApplicationId();
      this.field_1498 = var1.getPrimaryCategory();
      this.field_1499 = var1.getSecondaryCategory();
      this.field_1500 = var1.getDescription();
      this.field_1501 = var1.getDeveloperName();
      this.field_1492 = var1.getDisplayName();
      this.field_1502 = var1.getIconImageUri();
      this.field_1513 = var1.getIconImageUrl();
      this.field_1503 = var1.getHiResImageUri();
      this.field_1493 = var1.getHiResImageUrl();
      this.field_1504 = var1.getFeaturedImageUri();
      this.field_1494 = var1.getFeaturedImageUrl();
      this.field_1505 = var1.method_215();
      this.field_1506 = var1.method_217();
      this.field_1507 = var1.method_218();
      this.field_1508 = var1.method_219();
      this.field_1509 = var1.getAchievementTotalCount();
      this.field_1510 = var1.getLeaderboardCount();
      this.field_1511 = var1.isRealTimeMultiplayerEnabled();
      this.field_1512 = var1.isTurnBasedMultiplayerEnabled();
      this.field_1495 = var1.isMuted();
      this.field_1496 = var1.method_216();
      this.field_1497 = var1.areSnapshotsEnabled();
   }

   // $FF: renamed from: a (com.google.android.gms.games.Game) int
   static int method_2224(Game var0) {
      Object[] var1 = new Object[]{var0.getApplicationId(), var0.getDisplayName(), var0.getPrimaryCategory(), var0.getSecondaryCategory(), var0.getDescription(), var0.getDeveloperName(), var0.getIconImageUri(), var0.getHiResImageUri(), var0.getFeaturedImageUri(), Boolean.valueOf(var0.method_215()), Boolean.valueOf(var0.method_217()), var0.method_218(), Integer.valueOf(var0.method_219()), Integer.valueOf(var0.getAchievementTotalCount()), Integer.valueOf(var0.getLeaderboardCount()), Boolean.valueOf(var0.isRealTimeMultiplayerEnabled()), Boolean.valueOf(var0.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(var0.isMuted()), Boolean.valueOf(var0.method_216()), Boolean.valueOf(var0.areSnapshotsEnabled())};
      return class_349.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.Game, java.lang.Object) boolean
   static boolean method_2225(Game var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof Game)) {
         var2 = false;
      } else if(var0 != var1) {
         Game var3 = (Game)var1;
         if(class_349.equal(var3.getApplicationId(), var0.getApplicationId()) && class_349.equal(var3.getDisplayName(), var0.getDisplayName()) && class_349.equal(var3.getPrimaryCategory(), var0.getPrimaryCategory()) && class_349.equal(var3.getSecondaryCategory(), var0.getSecondaryCategory()) && class_349.equal(var3.getDescription(), var0.getDescription()) && class_349.equal(var3.getDeveloperName(), var0.getDeveloperName()) && class_349.equal(var3.getIconImageUri(), var0.getIconImageUri()) && class_349.equal(var3.getHiResImageUri(), var0.getHiResImageUri()) && class_349.equal(var3.getFeaturedImageUri(), var0.getFeaturedImageUri()) && class_349.equal(Boolean.valueOf(var3.method_215()), Boolean.valueOf(var0.method_215())) && class_349.equal(Boolean.valueOf(var3.method_217()), Boolean.valueOf(var0.method_217())) && class_349.equal(var3.method_218(), var0.method_218()) && class_349.equal(Integer.valueOf(var3.method_219()), Integer.valueOf(var0.method_219())) && class_349.equal(Integer.valueOf(var3.getAchievementTotalCount()), Integer.valueOf(var0.getAchievementTotalCount())) && class_349.equal(Integer.valueOf(var3.getLeaderboardCount()), Integer.valueOf(var0.getLeaderboardCount())) && class_349.equal(Boolean.valueOf(var3.isRealTimeMultiplayerEnabled()), Boolean.valueOf(var0.isRealTimeMultiplayerEnabled()))) {
            Boolean var4 = Boolean.valueOf(var3.isTurnBasedMultiplayerEnabled());
            boolean var5;
            if(var0.isTurnBasedMultiplayerEnabled() && class_349.equal(Boolean.valueOf(var3.isMuted()), Boolean.valueOf(var0.isMuted())) && class_349.equal(Boolean.valueOf(var3.method_216()), Boolean.valueOf(var0.method_216()))) {
               var5 = var2;
            } else {
               var5 = false;
            }

            if(class_349.equal(var4, Boolean.valueOf(var5)) && class_349.equal(Boolean.valueOf(var3.areSnapshotsEnabled()), Boolean.valueOf(var0.areSnapshotsEnabled()))) {
               return var2;
            }
         }

         return false;
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.Game) java.lang.String
   static String method_2227(Game var0) {
      return class_349.method_2174(var0).method_4301("ApplicationId", var0.getApplicationId()).method_4301("DisplayName", var0.getDisplayName()).method_4301("PrimaryCategory", var0.getPrimaryCategory()).method_4301("SecondaryCategory", var0.getSecondaryCategory()).method_4301("Description", var0.getDescription()).method_4301("DeveloperName", var0.getDeveloperName()).method_4301("IconImageUri", var0.getIconImageUri()).method_4301("IconImageUrl", var0.getIconImageUrl()).method_4301("HiResImageUri", var0.getHiResImageUri()).method_4301("HiResImageUrl", var0.getHiResImageUrl()).method_4301("FeaturedImageUri", var0.getFeaturedImageUri()).method_4301("FeaturedImageUrl", var0.getFeaturedImageUrl()).method_4301("PlayEnabledGame", Boolean.valueOf(var0.method_215())).method_4301("InstanceInstalled", Boolean.valueOf(var0.method_217())).method_4301("InstancePackageName", var0.method_218()).method_4301("AchievementTotalCount", Integer.valueOf(var0.getAchievementTotalCount())).method_4301("LeaderboardCount", Integer.valueOf(var0.getLeaderboardCount())).method_4301("RealTimeMultiplayerEnabled", Boolean.valueOf(var0.isRealTimeMultiplayerEnabled())).method_4301("TurnBasedMultiplayerEnabled", Boolean.valueOf(var0.isTurnBasedMultiplayerEnabled())).method_4301("AreSnapshotsEnabled", Boolean.valueOf(var0.areSnapshotsEnabled())).toString();
   }

   public boolean areSnapshotsEnabled() {
      return this.field_1497;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_2225(this, var1);
   }

   public Game freeze() {
      return this;
   }

   // $FF: renamed from: gH () boolean
   public boolean method_215() {
      return this.field_1505;
   }

   // $FF: renamed from: gI () boolean
   public boolean method_216() {
      return this.field_1496;
   }

   // $FF: renamed from: gJ () boolean
   public boolean method_217() {
      return this.field_1506;
   }

   // $FF: renamed from: gK () java.lang.String
   public String method_218() {
      return this.field_1507;
   }

   // $FF: renamed from: gL () int
   public int method_219() {
      return this.field_1508;
   }

   public int getAchievementTotalCount() {
      return this.field_1509;
   }

   public String getApplicationId() {
      return this.field_1515;
   }

   public String getDescription() {
      return this.field_1500;
   }

   public void getDescription(CharArrayBuffer var1) {
      class_284.method_1876(this.field_1500, var1);
   }

   public String getDeveloperName() {
      return this.field_1501;
   }

   public void getDeveloperName(CharArrayBuffer var1) {
      class_284.method_1876(this.field_1501, var1);
   }

   public String getDisplayName() {
      return this.field_1492;
   }

   public void getDisplayName(CharArrayBuffer var1) {
      class_284.method_1876(this.field_1492, var1);
   }

   public Uri getFeaturedImageUri() {
      return this.field_1504;
   }

   public String getFeaturedImageUrl() {
      return this.field_1494;
   }

   public Uri getHiResImageUri() {
      return this.field_1503;
   }

   public String getHiResImageUrl() {
      return this.field_1493;
   }

   public Uri getIconImageUri() {
      return this.field_1502;
   }

   public String getIconImageUrl() {
      return this.field_1513;
   }

   public int getLeaderboardCount() {
      return this.field_1510;
   }

   public String getPrimaryCategory() {
      return this.field_1498;
   }

   public String getSecondaryCategory() {
      return this.field_1499;
   }

   public int getVersionCode() {
      return this.field_1514;
   }

   public int hashCode() {
      return method_2224(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public boolean isMuted() {
      return this.field_1495;
   }

   public boolean isRealTimeMultiplayerEnabled() {
      return this.field_1511;
   }

   public boolean isTurnBasedMultiplayerEnabled() {
      return this.field_1512;
   }

   public String toString() {
      return method_2227(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      byte var3 = 1;
      if(!this.fm()) {
         GameEntityCreator.method_2724(this, var1, var2);
      } else {
         var1.writeString(this.field_1515);
         var1.writeString(this.field_1492);
         var1.writeString(this.field_1498);
         var1.writeString(this.field_1499);
         var1.writeString(this.field_1500);
         var1.writeString(this.field_1501);
         String var4;
         if(this.field_1502 == null) {
            var4 = null;
         } else {
            var4 = this.field_1502.toString();
         }

         var1.writeString(var4);
         String var5;
         if(this.field_1503 == null) {
            var5 = null;
         } else {
            var5 = this.field_1503.toString();
         }

         var1.writeString(var5);
         Uri var6 = this.field_1504;
         String var7 = null;
         if(var6 != null) {
            var7 = this.field_1504.toString();
         }

         var1.writeString(var7);
         byte var8;
         if(this.field_1505) {
            var8 = var3;
         } else {
            var8 = 0;
         }

         var1.writeInt(var8);
         if(!this.field_1506) {
            var3 = 0;
         }

         var1.writeInt(var3);
         var1.writeString(this.field_1507);
         var1.writeInt(this.field_1508);
         var1.writeInt(this.field_1509);
         var1.writeInt(this.field_1510);
      }
   }

   static final class GameEntityCreatorCompat extends GameEntityCreator {
      // $FF: renamed from: bd (android.os.Parcel) com.google.android.gms.games.GameEntity
      public GameEntity method_2725(Parcel var1) {
         if(!GameEntity.c(GameEntity.fl()) && !GameEntity.aA(GameEntity.class.getCanonicalName())) {
            String var2 = var1.readString();
            String var3 = var1.readString();
            String var4 = var1.readString();
            String var5 = var1.readString();
            String var6 = var1.readString();
            String var7 = var1.readString();
            String var8 = var1.readString();
            Uri var9;
            if(var8 == null) {
               var9 = null;
            } else {
               var9 = Uri.parse(var8);
            }

            String var10 = var1.readString();
            Uri var11;
            if(var10 == null) {
               var11 = null;
            } else {
               var11 = Uri.parse(var10);
            }

            String var12 = var1.readString();
            Uri var13;
            if(var12 == null) {
               var13 = null;
            } else {
               var13 = Uri.parse(var12);
            }

            boolean var14;
            if(var1.readInt() > 0) {
               var14 = true;
            } else {
               var14 = false;
            }

            boolean var15;
            if(var1.readInt() > 0) {
               var15 = true;
            } else {
               var15 = false;
            }

            return new GameEntity(4, var2, var3, var4, var5, var6, var7, var9, var11, var13, var14, var15, var1.readString(), var1.readInt(), var1.readInt(), var1.readInt(), false, false, (String)null, (String)null, (String)null, false, false, false);
         } else {
            return super.method_2725(var1);
         }
      }

      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.method_2725(var1);
      }
   }
}
