package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntityCreator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_719;

public final class GameEntity extends GamesDowngradeableSafeParcel implements Game {
   public static final Creator<GameEntity> CREATOR = new GameEntity.GameEntityCreatorCompat();
   // $FF: renamed from: CK int
   private final int field_1013;
   // $FF: renamed from: Fo java.lang.String
   private final String field_1014;
   // $FF: renamed from: OS java.lang.String
   private final String field_1015;
   // $FF: renamed from: UO java.lang.String
   private final String field_1016;
   // $FF: renamed from: WA java.lang.String
   private final String field_1017;
   // $FF: renamed from: WB java.lang.String
   private final String field_1018;
   // $FF: renamed from: WC java.lang.String
   private final String field_1019;
   // $FF: renamed from: WD android.net.Uri
   private final Uri field_1020;
   // $FF: renamed from: WE android.net.Uri
   private final Uri field_1021;
   // $FF: renamed from: WF android.net.Uri
   private final Uri field_1022;
   // $FF: renamed from: WG boolean
   private final boolean field_1023;
   // $FF: renamed from: WH boolean
   private final boolean field_1024;
   // $FF: renamed from: WI java.lang.String
   private final String field_1025;
   // $FF: renamed from: WJ int
   private final int field_1026;
   // $FF: renamed from: WK int
   private final int field_1027;
   // $FF: renamed from: WL int
   private final int field_1028;
   // $FF: renamed from: WM boolean
   private final boolean field_1029;
   // $FF: renamed from: WN boolean
   private final boolean field_1030;
   // $FF: renamed from: WO java.lang.String
   private final String field_1031;
   // $FF: renamed from: WP java.lang.String
   private final String field_1032;
   // $FF: renamed from: WQ java.lang.String
   private final String field_1033;
   // $FF: renamed from: WR boolean
   private final boolean field_1034;
   // $FF: renamed from: WS boolean
   private final boolean field_1035;
   // $FF: renamed from: WT boolean
   private final boolean field_1036;
   // $FF: renamed from: WU java.lang.String
   private final String field_1037;

   GameEntity(int var1, String var2, String var3, String var4, String var5, String var6, String var7, Uri var8, Uri var9, Uri var10, boolean var11, boolean var12, String var13, int var14, int var15, int var16, boolean var17, boolean var18, String var19, String var20, String var21, boolean var22, boolean var23, boolean var24, String var25) {
      this.field_1013 = var1;
      this.field_1014 = var2;
      this.field_1015 = var3;
      this.field_1017 = var4;
      this.field_1018 = var5;
      this.field_1016 = var6;
      this.field_1019 = var7;
      this.field_1020 = var8;
      this.field_1031 = var19;
      this.field_1021 = var9;
      this.field_1032 = var20;
      this.field_1022 = var10;
      this.field_1033 = var21;
      this.field_1023 = var11;
      this.field_1024 = var12;
      this.field_1025 = var13;
      this.field_1026 = var14;
      this.field_1027 = var15;
      this.field_1028 = var16;
      this.field_1029 = var17;
      this.field_1030 = var18;
      this.field_1034 = var22;
      this.field_1035 = var23;
      this.field_1036 = var24;
      this.field_1037 = var25;
   }

   public GameEntity(Game var1) {
      this.field_1013 = 5;
      this.field_1014 = var1.getApplicationId();
      this.field_1017 = var1.getPrimaryCategory();
      this.field_1018 = var1.getSecondaryCategory();
      this.field_1016 = var1.getDescription();
      this.field_1019 = var1.getDeveloperName();
      this.field_1015 = var1.getDisplayName();
      this.field_1020 = var1.getIconImageUri();
      this.field_1031 = var1.getIconImageUrl();
      this.field_1021 = var1.getHiResImageUri();
      this.field_1032 = var1.getHiResImageUrl();
      this.field_1022 = var1.getFeaturedImageUri();
      this.field_1033 = var1.getFeaturedImageUrl();
      this.field_1023 = var1.method_232();
      this.field_1024 = var1.method_229();
      this.field_1025 = var1.method_230();
      this.field_1026 = var1.method_231();
      this.field_1027 = var1.getAchievementTotalCount();
      this.field_1028 = var1.getLeaderboardCount();
      this.field_1029 = var1.isRealTimeMultiplayerEnabled();
      this.field_1030 = var1.isTurnBasedMultiplayerEnabled();
      this.field_1034 = var1.isMuted();
      this.field_1035 = var1.method_233();
      this.field_1036 = var1.areSnapshotsEnabled();
      this.field_1037 = var1.getThemeColor();
   }

   // $FF: renamed from: a (com.google.android.gms.games.Game) int
   static int method_2412(Game var0) {
      Object[] var1 = new Object[]{var0.getApplicationId(), var0.getDisplayName(), var0.getPrimaryCategory(), var0.getSecondaryCategory(), var0.getDescription(), var0.getDeveloperName(), var0.getIconImageUri(), var0.getHiResImageUri(), var0.getFeaturedImageUri(), Boolean.valueOf(var0.method_232()), Boolean.valueOf(var0.method_229()), var0.method_230(), Integer.valueOf(var0.method_231()), Integer.valueOf(var0.getAchievementTotalCount()), Integer.valueOf(var0.getLeaderboardCount()), Boolean.valueOf(var0.isRealTimeMultiplayerEnabled()), Boolean.valueOf(var0.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(var0.isMuted()), Boolean.valueOf(var0.method_233()), Boolean.valueOf(var0.areSnapshotsEnabled()), var0.getThemeColor()};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.Game, java.lang.Object) boolean
   static boolean method_2413(Game var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof Game)) {
         var2 = false;
      } else if(var0 != var1) {
         Game var3 = (Game)var1;
         if(class_336.equal(var3.getApplicationId(), var0.getApplicationId()) && class_336.equal(var3.getDisplayName(), var0.getDisplayName()) && class_336.equal(var3.getPrimaryCategory(), var0.getPrimaryCategory()) && class_336.equal(var3.getSecondaryCategory(), var0.getSecondaryCategory()) && class_336.equal(var3.getDescription(), var0.getDescription()) && class_336.equal(var3.getDeveloperName(), var0.getDeveloperName()) && class_336.equal(var3.getIconImageUri(), var0.getIconImageUri()) && class_336.equal(var3.getHiResImageUri(), var0.getHiResImageUri()) && class_336.equal(var3.getFeaturedImageUri(), var0.getFeaturedImageUri()) && class_336.equal(Boolean.valueOf(var3.method_232()), Boolean.valueOf(var0.method_232())) && class_336.equal(Boolean.valueOf(var3.method_229()), Boolean.valueOf(var0.method_229())) && class_336.equal(var3.method_230(), var0.method_230()) && class_336.equal(Integer.valueOf(var3.method_231()), Integer.valueOf(var0.method_231())) && class_336.equal(Integer.valueOf(var3.getAchievementTotalCount()), Integer.valueOf(var0.getAchievementTotalCount())) && class_336.equal(Integer.valueOf(var3.getLeaderboardCount()), Integer.valueOf(var0.getLeaderboardCount())) && class_336.equal(Boolean.valueOf(var3.isRealTimeMultiplayerEnabled()), Boolean.valueOf(var0.isRealTimeMultiplayerEnabled()))) {
            Boolean var4 = Boolean.valueOf(var3.isTurnBasedMultiplayerEnabled());
            boolean var5;
            if(var0.isTurnBasedMultiplayerEnabled() && class_336.equal(Boolean.valueOf(var3.isMuted()), Boolean.valueOf(var0.isMuted())) && class_336.equal(Boolean.valueOf(var3.method_233()), Boolean.valueOf(var0.method_233()))) {
               var5 = var2;
            } else {
               var5 = false;
            }

            if(class_336.equal(var4, Boolean.valueOf(var5)) && class_336.equal(Boolean.valueOf(var3.areSnapshotsEnabled()), Boolean.valueOf(var0.areSnapshotsEnabled())) && class_336.equal(var3.getThemeColor(), var0.getThemeColor())) {
               return var2;
            }
         }

         return false;
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.Game) java.lang.String
   static String method_2414(Game var0) {
      return class_336.method_2312(var0).method_3424("ApplicationId", var0.getApplicationId()).method_3424("DisplayName", var0.getDisplayName()).method_3424("PrimaryCategory", var0.getPrimaryCategory()).method_3424("SecondaryCategory", var0.getSecondaryCategory()).method_3424("Description", var0.getDescription()).method_3424("DeveloperName", var0.getDeveloperName()).method_3424("IconImageUri", var0.getIconImageUri()).method_3424("IconImageUrl", var0.getIconImageUrl()).method_3424("HiResImageUri", var0.getHiResImageUri()).method_3424("HiResImageUrl", var0.getHiResImageUrl()).method_3424("FeaturedImageUri", var0.getFeaturedImageUri()).method_3424("FeaturedImageUrl", var0.getFeaturedImageUrl()).method_3424("PlayEnabledGame", Boolean.valueOf(var0.method_232())).method_3424("InstanceInstalled", Boolean.valueOf(var0.method_229())).method_3424("InstancePackageName", var0.method_230()).method_3424("AchievementTotalCount", Integer.valueOf(var0.getAchievementTotalCount())).method_3424("LeaderboardCount", Integer.valueOf(var0.getLeaderboardCount())).method_3424("RealTimeMultiplayerEnabled", Boolean.valueOf(var0.isRealTimeMultiplayerEnabled())).method_3424("TurnBasedMultiplayerEnabled", Boolean.valueOf(var0.isTurnBasedMultiplayerEnabled())).method_3424("AreSnapshotsEnabled", Boolean.valueOf(var0.areSnapshotsEnabled())).method_3424("ThemeColor", var0.getThemeColor()).toString();
   }

   public boolean areSnapshotsEnabled() {
      return this.field_1036;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_2413(this, var1);
   }

   public Game freeze() {
      return this;
   }

   public int getAchievementTotalCount() {
      return this.field_1027;
   }

   public String getApplicationId() {
      return this.field_1014;
   }

   public String getDescription() {
      return this.field_1016;
   }

   public void getDescription(CharArrayBuffer var1) {
      class_719.method_4197(this.field_1016, var1);
   }

   public String getDeveloperName() {
      return this.field_1019;
   }

   public void getDeveloperName(CharArrayBuffer var1) {
      class_719.method_4197(this.field_1019, var1);
   }

   public String getDisplayName() {
      return this.field_1015;
   }

   public void getDisplayName(CharArrayBuffer var1) {
      class_719.method_4197(this.field_1015, var1);
   }

   public Uri getFeaturedImageUri() {
      return this.field_1022;
   }

   public String getFeaturedImageUrl() {
      return this.field_1033;
   }

   public Uri getHiResImageUri() {
      return this.field_1021;
   }

   public String getHiResImageUrl() {
      return this.field_1032;
   }

   public Uri getIconImageUri() {
      return this.field_1020;
   }

   public String getIconImageUrl() {
      return this.field_1031;
   }

   public int getLeaderboardCount() {
      return this.field_1028;
   }

   public String getPrimaryCategory() {
      return this.field_1017;
   }

   public String getSecondaryCategory() {
      return this.field_1018;
   }

   public String getThemeColor() {
      return this.field_1037;
   }

   public int getVersionCode() {
      return this.field_1013;
   }

   public int hashCode() {
      return method_2412(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public boolean isMuted() {
      return this.field_1034;
   }

   public boolean isRealTimeMultiplayerEnabled() {
      return this.field_1029;
   }

   public boolean isTurnBasedMultiplayerEnabled() {
      return this.field_1030;
   }

   // $FF: renamed from: kA () boolean
   public boolean method_229() {
      return this.field_1024;
   }

   // $FF: renamed from: kB () java.lang.String
   public String method_230() {
      return this.field_1025;
   }

   // $FF: renamed from: kC () int
   public int method_231() {
      return this.field_1026;
   }

   // $FF: renamed from: ky () boolean
   public boolean method_232() {
      return this.field_1023;
   }

   // $FF: renamed from: kz () boolean
   public boolean method_233() {
      return this.field_1035;
   }

   public String toString() {
      return method_2414(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      byte var3 = 1;
      if(!this.hu()) {
         GameEntityCreator.method_3118(this, var1, var2);
      } else {
         var1.writeString(this.field_1014);
         var1.writeString(this.field_1015);
         var1.writeString(this.field_1017);
         var1.writeString(this.field_1018);
         var1.writeString(this.field_1016);
         var1.writeString(this.field_1019);
         String var4;
         if(this.field_1020 == null) {
            var4 = null;
         } else {
            var4 = this.field_1020.toString();
         }

         var1.writeString(var4);
         String var5;
         if(this.field_1021 == null) {
            var5 = null;
         } else {
            var5 = this.field_1021.toString();
         }

         var1.writeString(var5);
         Uri var6 = this.field_1022;
         String var7 = null;
         if(var6 != null) {
            var7 = this.field_1022.toString();
         }

         var1.writeString(var7);
         byte var8;
         if(this.field_1023) {
            var8 = var3;
         } else {
            var8 = 0;
         }

         var1.writeInt(var8);
         if(!this.field_1024) {
            var3 = 0;
         }

         var1.writeInt(var3);
         var1.writeString(this.field_1025);
         var1.writeInt(this.field_1026);
         var1.writeInt(this.field_1027);
         var1.writeInt(this.field_1028);
      }
   }

   static final class GameEntityCreatorCompat extends GameEntityCreator {
      // $FF: renamed from: cl (android.os.Parcel) com.google.android.gms.games.GameEntity
      public GameEntity method_3119(Parcel var1) {
         if(!GameEntity.c(GameEntity.ht()) && !GameEntity.aW(GameEntity.class.getCanonicalName())) {
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

            return new GameEntity(5, var2, var3, var4, var5, var6, var7, var9, var11, var13, var14, var15, var1.readString(), var1.readInt(), var1.readInt(), var1.readInt(), false, false, (String)null, (String)null, (String)null, false, false, false, (String)null);
         } else {
            return super.method_3119(var1);
         }
      }

      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.method_3119(var1);
      }
   }
}
