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
import com.google.android.gms.internal.class_284;
import com.google.android.gms.internal.class_349;

public final class SnapshotMetadataEntity implements SafeParcelable, SnapshotMetadata {
   public static final SnapshotMetadataEntityCreator CREATOR = new SnapshotMetadataEntityCreator();
   // $FF: renamed from: HV java.lang.String
   private final String field_3854;
   // $FF: renamed from: Mm java.lang.String
   private final String field_3855;
   // $FF: renamed from: NH java.lang.String
   private final String field_3856;
   // $FF: renamed from: Rq com.google.android.gms.games.GameEntity
   private final GameEntity field_3857;
   // $FF: renamed from: Ue android.net.Uri
   private final Uri field_3858;
   // $FF: renamed from: Ui com.google.android.gms.games.PlayerEntity
   private final PlayerEntity field_3859;
   // $FF: renamed from: Uj java.lang.String
   private final String field_3860;
   // $FF: renamed from: Uk long
   private final long field_3861;
   // $FF: renamed from: Ul long
   private final long field_3862;
   // $FF: renamed from: Um float
   private final float field_3863;
   // $FF: renamed from: Un java.lang.String
   private final String field_3864;
   // $FF: renamed from: xJ int
   private final int field_3865;

   SnapshotMetadataEntity(int var1, GameEntity var2, PlayerEntity var3, String var4, Uri var5, String var6, String var7, String var8, long var9, long var11, float var13, String var14) {
      this.field_3865 = var1;
      this.field_3857 = var2;
      this.field_3859 = var3;
      this.field_3856 = var4;
      this.field_3858 = var5;
      this.field_3860 = var6;
      this.field_3863 = var13;
      this.field_3854 = var7;
      this.field_3855 = var8;
      this.field_3861 = var9;
      this.field_3862 = var11;
      this.field_3864 = var14;
   }

   public SnapshotMetadataEntity(SnapshotMetadata var1) {
      this.field_3865 = 3;
      this.field_3857 = new GameEntity(var1.getGame());
      this.field_3859 = new PlayerEntity(var1.getOwner());
      this.field_3856 = var1.getSnapshotId();
      this.field_3858 = var1.getCoverImageUri();
      this.field_3860 = var1.getCoverImageUrl();
      this.field_3863 = var1.getCoverImageAspectRatio();
      this.field_3854 = var1.getTitle();
      this.field_3855 = var1.getDescription();
      this.field_3861 = var1.getLastModifiedTimestamp();
      this.field_3862 = var1.getPlayedTime();
      this.field_3864 = var1.getUniqueName();
   }

   // $FF: renamed from: a (com.google.android.gms.games.snapshot.SnapshotMetadata) int
   static int method_4072(SnapshotMetadata var0) {
      Object[] var1 = new Object[]{var0.getGame(), var0.getOwner(), var0.getSnapshotId(), var0.getCoverImageUri(), Float.valueOf(var0.getCoverImageAspectRatio()), var0.getTitle(), var0.getDescription(), Long.valueOf(var0.getLastModifiedTimestamp()), Long.valueOf(var0.getPlayedTime()), var0.getUniqueName()};
      return class_349.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.snapshot.SnapshotMetadata, java.lang.Object) boolean
   static boolean method_4073(SnapshotMetadata var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof SnapshotMetadata)) {
         var2 = false;
      } else if(var0 != var1) {
         SnapshotMetadata var3 = (SnapshotMetadata)var1;
         if(!class_349.equal(var3.getGame(), var0.getGame()) || !class_349.equal(var3.getOwner(), var0.getOwner()) || !class_349.equal(var3.getSnapshotId(), var0.getSnapshotId()) || !class_349.equal(var3.getCoverImageUri(), var0.getCoverImageUri()) || !class_349.equal(Float.valueOf(var3.getCoverImageAspectRatio()), Float.valueOf(var0.getCoverImageAspectRatio())) || !class_349.equal(var3.getTitle(), var0.getTitle()) || !class_349.equal(var3.getDescription(), var0.getDescription()) || !class_349.equal(Long.valueOf(var3.getLastModifiedTimestamp()), Long.valueOf(var0.getLastModifiedTimestamp())) || !class_349.equal(Long.valueOf(var3.getPlayedTime()), Long.valueOf(var0.getPlayedTime())) || !class_349.equal(var3.getUniqueName(), var0.getUniqueName())) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.snapshot.SnapshotMetadata) java.lang.String
   static String method_4074(SnapshotMetadata var0) {
      return class_349.method_2174(var0).method_4301("Game", var0.getGame()).method_4301("Owner", var0.getOwner()).method_4301("SnapshotId", var0.getSnapshotId()).method_4301("CoverImageUri", var0.getCoverImageUri()).method_4301("CoverImageUrl", var0.getCoverImageUrl()).method_4301("CoverImageAspectRatio", Float.valueOf(var0.getCoverImageAspectRatio())).method_4301("Description", var0.getDescription()).method_4301("LastModifiedTimestamp", Long.valueOf(var0.getLastModifiedTimestamp())).method_4301("PlayedTime", Long.valueOf(var0.getPlayedTime())).method_4301("UniqueName", var0.getUniqueName()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_4073(this, var1);
   }

   public SnapshotMetadata freeze() {
      return this;
   }

   public float getCoverImageAspectRatio() {
      return this.field_3863;
   }

   public Uri getCoverImageUri() {
      return this.field_3858;
   }

   public String getCoverImageUrl() {
      return this.field_3860;
   }

   public String getDescription() {
      return this.field_3855;
   }

   public void getDescription(CharArrayBuffer var1) {
      class_284.method_1876(this.field_3855, var1);
   }

   public Game getGame() {
      return this.field_3857;
   }

   public long getLastModifiedTimestamp() {
      return this.field_3861;
   }

   public Player getOwner() {
      return this.field_3859;
   }

   public long getPlayedTime() {
      return this.field_3862;
   }

   public String getSnapshotId() {
      return this.field_3856;
   }

   public String getTitle() {
      return this.field_3854;
   }

   public String getUniqueName() {
      return this.field_3864;
   }

   public int getVersionCode() {
      return this.field_3865;
   }

   public int hashCode() {
      return method_4072(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public String toString() {
      return method_4074(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      SnapshotMetadataEntityCreator.method_4182(this, var1, var2);
   }
}
