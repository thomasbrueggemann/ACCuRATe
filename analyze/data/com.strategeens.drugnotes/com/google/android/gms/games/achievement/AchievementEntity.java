package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.achievement.Achievement;
import com.google.android.gms.games.achievement.AchievementEntityCreator;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_349;
import com.google.android.gms.internal.class_719;

public final class AchievementEntity implements SafeParcelable, Achievement {
   public static final AchievementEntityCreator CREATOR = new AchievementEntityCreator();
   // $FF: renamed from: CK int
   private final int field_3242;
   // $FF: renamed from: Gt int
   private final int field_3243;
   // $FF: renamed from: UO java.lang.String
   private final String field_3244;
   // $FF: renamed from: XA android.net.Uri
   private final Uri field_3245;
   // $FF: renamed from: XB java.lang.String
   private final String field_3246;
   // $FF: renamed from: XC int
   private final int field_3247;
   // $FF: renamed from: XD java.lang.String
   private final String field_3248;
   // $FF: renamed from: XE com.google.android.gms.games.PlayerEntity
   private final PlayerEntity field_3249;
   // $FF: renamed from: XF int
   private final int field_3250;
   // $FF: renamed from: XG java.lang.String
   private final String field_3251;
   // $FF: renamed from: XH long
   private final long field_3252;
   // $FF: renamed from: XI long
   private final long field_3253;
   // $FF: renamed from: Xx java.lang.String
   private final String field_3254;
   // $FF: renamed from: Xy android.net.Uri
   private final Uri field_3255;
   // $FF: renamed from: Xz java.lang.String
   private final String field_3256;
   private final String mName;
   private final int mState;

   AchievementEntity(int var1, String var2, int var3, String var4, String var5, Uri var6, String var7, Uri var8, String var9, int var10, String var11, PlayerEntity var12, int var13, int var14, String var15, long var16, long var18) {
      this.field_3242 = var1;
      this.field_3254 = var2;
      this.field_3243 = var3;
      this.mName = var4;
      this.field_3244 = var5;
      this.field_3255 = var6;
      this.field_3256 = var7;
      this.field_3245 = var8;
      this.field_3246 = var9;
      this.field_3247 = var10;
      this.field_3248 = var11;
      this.field_3249 = var12;
      this.mState = var13;
      this.field_3250 = var14;
      this.field_3251 = var15;
      this.field_3252 = var16;
      this.field_3253 = var18;
   }

   public AchievementEntity(Achievement var1) {
      this.field_3242 = 1;
      this.field_3254 = var1.getAchievementId();
      this.field_3243 = var1.getType();
      this.mName = var1.getName();
      this.field_3244 = var1.getDescription();
      this.field_3255 = var1.getUnlockedImageUri();
      this.field_3256 = var1.getUnlockedImageUrl();
      this.field_3245 = var1.getRevealedImageUri();
      this.field_3246 = var1.getRevealedImageUrl();
      this.field_3249 = (PlayerEntity)var1.getPlayer().freeze();
      this.mState = var1.getState();
      this.field_3252 = var1.getLastUpdatedTimestamp();
      this.field_3253 = var1.getXpValue();
      if(var1.getType() == 1) {
         this.field_3247 = var1.getTotalSteps();
         this.field_3248 = var1.getFormattedTotalSteps();
         this.field_3250 = var1.getCurrentSteps();
         this.field_3251 = var1.getFormattedCurrentSteps();
      } else {
         this.field_3247 = 0;
         this.field_3248 = null;
         this.field_3250 = 0;
         this.field_3251 = null;
      }

      class_349.method_2429(this.field_3254);
      class_349.method_2429(this.field_3244);
   }

   // $FF: renamed from: a (com.google.android.gms.games.achievement.Achievement) int
   static int method_4152(Achievement var0) {
      int var1;
      int var2;
      if(var0.getType() == 1) {
         var2 = var0.getCurrentSteps();
         var1 = var0.getTotalSteps();
      } else {
         var1 = 0;
         var2 = 0;
      }

      Object[] var3 = new Object[]{var0.getAchievementId(), var0.getName(), Integer.valueOf(var0.getType()), var0.getDescription(), Long.valueOf(var0.getXpValue()), Integer.valueOf(var0.getState()), Long.valueOf(var0.getLastUpdatedTimestamp()), var0.getPlayer(), Integer.valueOf(var2), Integer.valueOf(var1)};
      return class_336.hashCode(var3);
   }

   // $FF: renamed from: a (com.google.android.gms.games.achievement.Achievement, java.lang.Object) boolean
   static boolean method_4153(Achievement var0, Object var1) {
      byte var2 = 1;
      if(!(var1 instanceof Achievement)) {
         var2 = 0;
      } else if(var0 != var1) {
         Achievement var3 = (Achievement)var1;
         byte var4;
         byte var5;
         if(var0.getType() == var2) {
            var5 = class_336.equal(Integer.valueOf(var3.getCurrentSteps()), Integer.valueOf(var0.getCurrentSteps()));
            var4 = class_336.equal(Integer.valueOf(var3.getTotalSteps()), Integer.valueOf(var0.getTotalSteps()));
         } else {
            var4 = var2;
            var5 = var2;
         }

         if(!class_336.equal(var3.getAchievementId(), var0.getAchievementId()) || !class_336.equal(var3.getName(), var0.getName()) || !class_336.equal(Integer.valueOf(var3.getType()), Integer.valueOf(var0.getType())) || !class_336.equal(var3.getDescription(), var0.getDescription()) || !class_336.equal(Long.valueOf(var3.getXpValue()), Long.valueOf(var0.getXpValue())) || !class_336.equal(Integer.valueOf(var3.getState()), Integer.valueOf(var0.getState())) || !class_336.equal(Long.valueOf(var3.getLastUpdatedTimestamp()), Long.valueOf(var0.getLastUpdatedTimestamp())) || !class_336.equal(var3.getPlayer(), var0.getPlayer()) || var5 == 0 || var4 == 0) {
            return false;
         }
      }

      return (boolean)var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.achievement.Achievement) java.lang.String
   static String method_4154(Achievement var0) {
      class_336.class_1339 var1 = class_336.method_2312(var0).method_3424("Id", var0.getAchievementId()).method_3424("Type", Integer.valueOf(var0.getType())).method_3424("Name", var0.getName()).method_3424("Description", var0.getDescription()).method_3424("Player", var0.getPlayer()).method_3424("State", Integer.valueOf(var0.getState()));
      if(var0.getType() == 1) {
         var1.method_3424("CurrentSteps", Integer.valueOf(var0.getCurrentSteps()));
         var1.method_3424("TotalSteps", Integer.valueOf(var0.getTotalSteps()));
      }

      return var1.toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_4153(this, var1);
   }

   public Achievement freeze() {
      return this;
   }

   public String getAchievementId() {
      return this.field_3254;
   }

   public int getCurrentSteps() {
      return this.field_3250;
   }

   public String getDescription() {
      return this.field_3244;
   }

   public void getDescription(CharArrayBuffer var1) {
      class_719.method_4197(this.field_3244, var1);
   }

   public String getFormattedCurrentSteps() {
      return this.field_3251;
   }

   public void getFormattedCurrentSteps(CharArrayBuffer var1) {
      class_719.method_4197(this.field_3251, var1);
   }

   public String getFormattedTotalSteps() {
      return this.field_3248;
   }

   public void getFormattedTotalSteps(CharArrayBuffer var1) {
      class_719.method_4197(this.field_3248, var1);
   }

   public long getLastUpdatedTimestamp() {
      return this.field_3252;
   }

   public String getName() {
      return this.mName;
   }

   public void getName(CharArrayBuffer var1) {
      class_719.method_4197(this.mName, var1);
   }

   public Player getPlayer() {
      return this.field_3249;
   }

   public Uri getRevealedImageUri() {
      return this.field_3245;
   }

   public String getRevealedImageUrl() {
      return this.field_3246;
   }

   public int getState() {
      return this.mState;
   }

   public int getTotalSteps() {
      return this.field_3247;
   }

   public int getType() {
      return this.field_3243;
   }

   public Uri getUnlockedImageUri() {
      return this.field_3255;
   }

   public String getUnlockedImageUrl() {
      return this.field_3256;
   }

   public int getVersionCode() {
      return this.field_3242;
   }

   public long getXpValue() {
      return this.field_3253;
   }

   public int hashCode() {
      return method_4152(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public String toString() {
      return method_4154(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      AchievementEntityCreator.method_3165(this, var1, var2);
   }
}
