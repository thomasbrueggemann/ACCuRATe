package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntityCreator;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_719;

public final class SnapshotMetadataEntity implements SafeParcelable, SnapshotMetadata {
   public static final SnapshotMetadataEntityCreator CREATOR = new SnapshotMetadataEntityCreator();
   // $FF: renamed from: CK int
   private final int field_3936;
   // $FF: renamed from: OH java.lang.String
   private final String field_3937;
   // $FF: renamed from: UO java.lang.String
   private final String field_3938;
   // $FF: renamed from: YB java.lang.String
   private final String field_3939;
   private final GameEntity acs;
   private final Uri afd;
   private final PlayerEntity afg;
   private final String afh;
   private final long afi;
   private final long afj;
   private final float afk;
   private final String afl;
   private final boolean afm;

   SnapshotMetadataEntity(int var1, GameEntity var2, PlayerEntity var3, String var4, Uri var5, String var6, String var7, String var8, long var9, long var11, float var13, String var14, boolean var15) {
      this.field_3936 = var1;
      this.acs = var2;
      this.afg = var3;
      this.field_3939 = var4;
      this.afd = var5;
      this.afh = var6;
      this.afk = var13;
      this.field_3937 = var7;
      this.field_3938 = var8;
      this.afi = var9;
      this.afj = var11;
      this.afl = var14;
      this.afm = var15;
   }

   public SnapshotMetadataEntity(SnapshotMetadata var1) {
      this.field_3936 = 4;
      this.acs = new GameEntity(var1.getGame());
      this.afg = new PlayerEntity(var1.getOwner());
      this.field_3939 = var1.getSnapshotId();
      this.afd = var1.getCoverImageUri();
      this.afh = var1.getCoverImageUrl();
      this.afk = var1.getCoverImageAspectRatio();
      this.field_3937 = var1.getTitle();
      this.field_3938 = var1.getDescription();
      this.afi = var1.getLastModifiedTimestamp();
      this.afj = var1.getPlayedTime();
      this.afl = var1.getUniqueName();
      this.afm = var1.hasChangePending();
   }

   // $FF: renamed from: a (com.google.android.gms.games.snapshot.SnapshotMetadata) int
   static int method_5178(SnapshotMetadata var0) {
      Object[] var1 = new Object[]{var0.getGame(), var0.getOwner(), var0.getSnapshotId(), var0.getCoverImageUri(), Float.valueOf(var0.getCoverImageAspectRatio()), var0.getTitle(), var0.getDescription(), Long.valueOf(var0.getLastModifiedTimestamp()), Long.valueOf(var0.getPlayedTime()), var0.getUniqueName(), Boolean.valueOf(var0.hasChangePending())};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.snapshot.SnapshotMetadata, java.lang.Object) boolean
   static boolean method_5179(SnapshotMetadata var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof SnapshotMetadata)) {
         var2 = false;
      } else if(var0 != var1) {
         SnapshotMetadata var3 = (SnapshotMetadata)var1;
         if(!class_336.equal(var3.getGame(), var0.getGame()) || !class_336.equal(var3.getOwner(), var0.getOwner()) || !class_336.equal(var3.getSnapshotId(), var0.getSnapshotId()) || !class_336.equal(var3.getCoverImageUri(), var0.getCoverImageUri()) || !class_336.equal(Float.valueOf(var3.getCoverImageAspectRatio()), Float.valueOf(var0.getCoverImageAspectRatio())) || !class_336.equal(var3.getTitle(), var0.getTitle()) || !class_336.equal(var3.getDescription(), var0.getDescription()) || !class_336.equal(Long.valueOf(var3.getLastModifiedTimestamp()), Long.valueOf(var0.getLastModifiedTimestamp())) || !class_336.equal(Long.valueOf(var3.getPlayedTime()), Long.valueOf(var0.getPlayedTime())) || !class_336.equal(var3.getUniqueName(), var0.getUniqueName()) || !class_336.equal(Boolean.valueOf(var3.hasChangePending()), Boolean.valueOf(var0.hasChangePending()))) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.snapshot.SnapshotMetadata) java.lang.String
   static String method_5180(SnapshotMetadata var0) {
      return class_336.method_2312(var0).method_3424("Game", var0.getGame()).method_3424("Owner", var0.getOwner()).method_3424("SnapshotId", var0.getSnapshotId()).method_3424("CoverImageUri", var0.getCoverImageUri()).method_3424("CoverImageUrl", var0.getCoverImageUrl()).method_3424("CoverImageAspectRatio", Float.valueOf(var0.getCoverImageAspectRatio())).method_3424("Description", var0.getDescription()).method_3424("LastModifiedTimestamp", Long.valueOf(var0.getLastModifiedTimestamp())).method_3424("PlayedTime", Long.valueOf(var0.getPlayedTime())).method_3424("UniqueName", var0.getUniqueName()).method_3424("ChangePending", Boolean.valueOf(var0.hasChangePending())).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_5179(this, var1);
   }

   public SnapshotMetadata freeze() {
      return this;
   }

   public float getCoverImageAspectRatio() {
      return this.afk;
   }

   public Uri getCoverImageUri() {
      return this.afd;
   }

   public String getCoverImageUrl() {
      return this.afh;
   }

   public String getDescription() {
      return this.field_3938;
   }

   public void getDescription(CharArrayBuffer var1) {
      class_719.method_4197(this.field_3938, var1);
   }

   public Game getGame() {
      return this.acs;
   }

   public long getLastModifiedTimestamp() {
      return this.afi;
   }

   public Player getOwner() {
      return this.afg;
   }

   public long getPlayedTime() {
      return this.afj;
   }

   public String getSnapshotId() {
      return this.field_3939;
   }

   public String getTitle() {
      return this.field_3937;
   }

   public String getUniqueName() {
      return this.afl;
   }

   public int getVersionCode() {
      return this.field_3936;
   }

   public boolean hasChangePending() {
      return this.afm;
   }

   public int hashCode() {
      return method_5178(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public String toString() {
      return method_5180(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      SnapshotMetadataEntityCreator.method_5297(this, var1, var2);
   }
}
