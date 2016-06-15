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
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_349;
import com.google.android.gms.internal.class_719;

public final class PlayerEntity extends GamesDowngradeableSafeParcel implements Player {
   public static final Creator<PlayerEntity> CREATOR = new PlayerEntity.PlayerEntityCreatorCompat();
   // $FF: renamed from: CK int
   private final int field_999;
   // $FF: renamed from: OH java.lang.String
   private final String field_1000;
   // $FF: renamed from: OS java.lang.String
   private final String field_1001;
   // $FF: renamed from: WD android.net.Uri
   private final Uri field_1002;
   // $FF: renamed from: WE android.net.Uri
   private final Uri field_1003;
   // $FF: renamed from: WO java.lang.String
   private final String field_1004;
   // $FF: renamed from: WP java.lang.String
   private final String field_1005;
   // $FF: renamed from: Xh java.lang.String
   private final String field_1006;
   // $FF: renamed from: Xi long
   private final long field_1007;
   // $FF: renamed from: Xj int
   private final int field_1008;
   // $FF: renamed from: Xk long
   private final long field_1009;
   // $FF: renamed from: Xl com.google.android.gms.games.internal.player.MostRecentGameInfoEntity
   private final MostRecentGameInfoEntity field_1010;
   // $FF: renamed from: Xm com.google.android.gms.games.PlayerLevelInfo
   private final PlayerLevelInfo field_1011;
   // $FF: renamed from: Xn boolean
   private final boolean field_1012;

   PlayerEntity(int var1, String var2, String var3, Uri var4, Uri var5, long var6, int var8, long var9, String var11, String var12, String var13, MostRecentGameInfoEntity var14, PlayerLevelInfo var15, boolean var16) {
      this.field_999 = var1;
      this.field_1006 = var2;
      this.field_1001 = var3;
      this.field_1002 = var4;
      this.field_1004 = var11;
      this.field_1003 = var5;
      this.field_1005 = var12;
      this.field_1007 = var6;
      this.field_1008 = var8;
      this.field_1009 = var9;
      this.field_1000 = var13;
      this.field_1012 = var16;
      this.field_1010 = var14;
      this.field_1011 = var15;
   }

   public PlayerEntity(Player var1) {
      this.field_999 = 11;
      this.field_1006 = var1.getPlayerId();
      this.field_1001 = var1.getDisplayName();
      this.field_1002 = var1.getIconImageUri();
      this.field_1004 = var1.getIconImageUrl();
      this.field_1003 = var1.getHiResImageUri();
      this.field_1005 = var1.getHiResImageUrl();
      this.field_1007 = var1.getRetrievedTimestamp();
      this.field_1008 = var1.method_252();
      this.field_1009 = var1.getLastPlayedWithTimestamp();
      this.field_1000 = var1.getTitle();
      this.field_1012 = var1.isProfileVisible();
      MostRecentGameInfo var2 = var1.method_253();
      MostRecentGameInfoEntity var3;
      if(var2 == null) {
         var3 = null;
      } else {
         var3 = new MostRecentGameInfoEntity(var2);
      }

      this.field_1010 = var3;
      this.field_1011 = var1.getLevelInfo();
      class_349.method_2429(this.field_1006);
      class_349.method_2429(this.field_1001);
      boolean var4;
      if(this.field_1007 > 0L) {
         var4 = true;
      } else {
         var4 = false;
      }

      class_349.method_2425(var4);
   }

   // $FF: renamed from: a (com.google.android.gms.games.Player, java.lang.Object) boolean
   static boolean method_2406(Player var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof Player)) {
         var2 = false;
      } else if(var0 != var1) {
         Player var3 = (Player)var1;
         if(!class_336.equal(var3.getPlayerId(), var0.getPlayerId()) || !class_336.equal(var3.getDisplayName(), var0.getDisplayName()) || !class_336.equal(var3.getIconImageUri(), var0.getIconImageUri()) || !class_336.equal(var3.getHiResImageUri(), var0.getHiResImageUri()) || !class_336.equal(Long.valueOf(var3.getRetrievedTimestamp()), Long.valueOf(var0.getRetrievedTimestamp())) || !class_336.equal(var3.getTitle(), var0.getTitle()) || !class_336.equal(var3.getLevelInfo(), var0.getLevelInfo())) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.Player) int
   static int method_2407(Player var0) {
      Object[] var1 = new Object[]{var0.getPlayerId(), var0.getDisplayName(), var0.getIconImageUri(), var0.getHiResImageUri(), Long.valueOf(var0.getRetrievedTimestamp()), var0.getTitle(), var0.getLevelInfo()};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: c (com.google.android.gms.games.Player) java.lang.String
   static String method_2410(Player var0) {
      return class_336.method_2312(var0).method_3424("PlayerId", var0.getPlayerId()).method_3424("DisplayName", var0.getDisplayName()).method_3424("IconImageUri", var0.getIconImageUri()).method_3424("IconImageUrl", var0.getIconImageUrl()).method_3424("HiResImageUri", var0.getHiResImageUri()).method_3424("HiResImageUrl", var0.getHiResImageUrl()).method_3424("RetrievedTimestamp", Long.valueOf(var0.getRetrievedTimestamp())).method_3424("Title", var0.getTitle()).method_3424("LevelInfo", var0.getLevelInfo()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_2406(this, var1);
   }

   public Player freeze() {
      return this;
   }

   public String getDisplayName() {
      return this.field_1001;
   }

   public void getDisplayName(CharArrayBuffer var1) {
      class_719.method_4197(this.field_1001, var1);
   }

   public Uri getHiResImageUri() {
      return this.field_1003;
   }

   public String getHiResImageUrl() {
      return this.field_1005;
   }

   public Uri getIconImageUri() {
      return this.field_1002;
   }

   public String getIconImageUrl() {
      return this.field_1004;
   }

   public long getLastPlayedWithTimestamp() {
      return this.field_1009;
   }

   public PlayerLevelInfo getLevelInfo() {
      return this.field_1011;
   }

   public String getPlayerId() {
      return this.field_1006;
   }

   public long getRetrievedTimestamp() {
      return this.field_1007;
   }

   public String getTitle() {
      return this.field_1000;
   }

   public void getTitle(CharArrayBuffer var1) {
      class_719.method_4197(this.field_1000, var1);
   }

   public int getVersionCode() {
      return this.field_999;
   }

   public boolean hasHiResImage() {
      return this.getHiResImageUri() != null;
   }

   public boolean hasIconImage() {
      return this.getIconImageUri() != null;
   }

   public int hashCode() {
      return method_2407(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public boolean isProfileVisible() {
      return this.field_1012;
   }

   // $FF: renamed from: kE () int
   public int method_252() {
      return this.field_1008;
   }

   // $FF: renamed from: kF () com.google.android.gms.games.internal.player.MostRecentGameInfo
   public MostRecentGameInfo method_253() {
      return this.field_1010;
   }

   public String toString() {
      return method_2410(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(!this.hu()) {
         PlayerEntityCreator.method_3798(this, var1, var2);
      } else {
         var1.writeString(this.field_1006);
         var1.writeString(this.field_1001);
         String var3;
         if(this.field_1002 == null) {
            var3 = null;
         } else {
            var3 = this.field_1002.toString();
         }

         var1.writeString(var3);
         Uri var4 = this.field_1003;
         String var5 = null;
         if(var4 != null) {
            var5 = this.field_1003.toString();
         }

         var1.writeString(var5);
         var1.writeLong(this.field_1007);
      }
   }

   static final class PlayerEntityCreatorCompat extends PlayerEntityCreator {
      // $FF: renamed from: cm (android.os.Parcel) com.google.android.gms.games.PlayerEntity
      public PlayerEntity method_3799(Parcel var1) {
         if(!PlayerEntity.c(PlayerEntity.ht()) && !PlayerEntity.aW(PlayerEntity.class.getCanonicalName())) {
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

            return new PlayerEntity(11, var2, var3, var6, var7, var1.readLong(), -1, -1L, (String)null, (String)null, (String)null, (MostRecentGameInfoEntity)null, (PlayerLevelInfo)null, true);
         } else {
            return super.method_3799(var1);
         }
      }

      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.method_3799(var1);
      }
   }
}
