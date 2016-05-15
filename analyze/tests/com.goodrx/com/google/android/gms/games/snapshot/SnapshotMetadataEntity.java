package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntityCreator;

public final class SnapshotMetadataEntity implements SafeParcelable, SnapshotMetadata {
   public static final Creator<SnapshotMetadataEntity> CREATOR = new SnapshotMetadataEntityCreator();
   private final int mVersionCode;
   private final String zzaEp;
   private final GameEntity zzaJE;
   private final Uri zzaKQ;
   private final PlayerEntity zzaKT;
   private final String zzaKU;
   private final long zzaKV;
   private final long zzaKW;
   private final float zzaKX;
   private final String zzaKY;
   private final boolean zzaKZ;
   private final long zzaLa;
   private final String zzaLb;
   private final String zzapg;
   private final String zzaxl;

   SnapshotMetadataEntity(int var1, GameEntity var2, PlayerEntity var3, String var4, Uri var5, String var6, String var7, String var8, long var9, long var11, float var13, String var14, boolean var15, long var16, String var18) {
      this.mVersionCode = var1;
      this.zzaJE = var2;
      this.zzaKT = var3;
      this.zzaEp = var4;
      this.zzaKQ = var5;
      this.zzaKU = var6;
      this.zzaKX = var13;
      this.zzapg = var7;
      this.zzaxl = var8;
      this.zzaKV = var9;
      this.zzaKW = var11;
      this.zzaKY = var14;
      this.zzaKZ = var15;
      this.zzaLa = var16;
      this.zzaLb = var18;
   }

   public SnapshotMetadataEntity(SnapshotMetadata var1) {
      this.mVersionCode = 6;
      this.zzaJE = new GameEntity(var1.getGame());
      this.zzaKT = new PlayerEntity(var1.getOwner());
      this.zzaEp = var1.getSnapshotId();
      this.zzaKQ = var1.getCoverImageUri();
      this.zzaKU = var1.getCoverImageUrl();
      this.zzaKX = var1.getCoverImageAspectRatio();
      this.zzapg = var1.getTitle();
      this.zzaxl = var1.getDescription();
      this.zzaKV = var1.getLastModifiedTimestamp();
      this.zzaKW = var1.getPlayedTime();
      this.zzaKY = var1.getUniqueName();
      this.zzaKZ = var1.hasChangePending();
      this.zzaLa = var1.getProgressValue();
      this.zzaLb = var1.getDeviceName();
   }

   static int zza(SnapshotMetadata var0) {
      Object[] var1 = new Object[]{var0.getGame(), var0.getOwner(), var0.getSnapshotId(), var0.getCoverImageUri(), Float.valueOf(var0.getCoverImageAspectRatio()), var0.getTitle(), var0.getDescription(), Long.valueOf(var0.getLastModifiedTimestamp()), Long.valueOf(var0.getPlayedTime()), var0.getUniqueName(), Boolean.valueOf(var0.hasChangePending()), Long.valueOf(var0.getProgressValue()), var0.getDeviceName()};
      return zzw.hashCode(var1);
   }

   static boolean zza(SnapshotMetadata var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof SnapshotMetadata)) {
         var2 = false;
      } else if(var0 != var1) {
         SnapshotMetadata var3 = (SnapshotMetadata)var1;
         if(!zzw.equal(var3.getGame(), var0.getGame()) || !zzw.equal(var3.getOwner(), var0.getOwner()) || !zzw.equal(var3.getSnapshotId(), var0.getSnapshotId()) || !zzw.equal(var3.getCoverImageUri(), var0.getCoverImageUri()) || !zzw.equal(Float.valueOf(var3.getCoverImageAspectRatio()), Float.valueOf(var0.getCoverImageAspectRatio())) || !zzw.equal(var3.getTitle(), var0.getTitle()) || !zzw.equal(var3.getDescription(), var0.getDescription()) || !zzw.equal(Long.valueOf(var3.getLastModifiedTimestamp()), Long.valueOf(var0.getLastModifiedTimestamp())) || !zzw.equal(Long.valueOf(var3.getPlayedTime()), Long.valueOf(var0.getPlayedTime())) || !zzw.equal(var3.getUniqueName(), var0.getUniqueName()) || !zzw.equal(Boolean.valueOf(var3.hasChangePending()), Boolean.valueOf(var0.hasChangePending())) || !zzw.equal(Long.valueOf(var3.getProgressValue()), Long.valueOf(var0.getProgressValue())) || !zzw.equal(var3.getDeviceName(), var0.getDeviceName())) {
            return false;
         }
      }

      return var2;
   }

   static String zzb(SnapshotMetadata var0) {
      return zzw.zzy(var0).zzg("Game", var0.getGame()).zzg("Owner", var0.getOwner()).zzg("SnapshotId", var0.getSnapshotId()).zzg("CoverImageUri", var0.getCoverImageUri()).zzg("CoverImageUrl", var0.getCoverImageUrl()).zzg("CoverImageAspectRatio", Float.valueOf(var0.getCoverImageAspectRatio())).zzg("Description", var0.getDescription()).zzg("LastModifiedTimestamp", Long.valueOf(var0.getLastModifiedTimestamp())).zzg("PlayedTime", Long.valueOf(var0.getPlayedTime())).zzg("UniqueName", var0.getUniqueName()).zzg("ChangePending", Boolean.valueOf(var0.hasChangePending())).zzg("ProgressValue", Long.valueOf(var0.getProgressValue())).zzg("DeviceName", var0.getDeviceName()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return zza(this, var1);
   }

   public SnapshotMetadata freeze() {
      return this;
   }

   public float getCoverImageAspectRatio() {
      return this.zzaKX;
   }

   public Uri getCoverImageUri() {
      return this.zzaKQ;
   }

   public String getCoverImageUrl() {
      return this.zzaKU;
   }

   public String getDescription() {
      return this.zzaxl;
   }

   public String getDeviceName() {
      return this.zzaLb;
   }

   public Game getGame() {
      return this.zzaJE;
   }

   public long getLastModifiedTimestamp() {
      return this.zzaKV;
   }

   public Player getOwner() {
      return this.zzaKT;
   }

   public long getPlayedTime() {
      return this.zzaKW;
   }

   public long getProgressValue() {
      return this.zzaLa;
   }

   public String getSnapshotId() {
      return this.zzaEp;
   }

   public String getTitle() {
      return this.zzapg;
   }

   public String getUniqueName() {
      return this.zzaKY;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public boolean hasChangePending() {
      return this.zzaKZ;
   }

   public int hashCode() {
      return zza(this);
   }

   public String toString() {
      return zzb(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      SnapshotMetadataEntityCreator.zza(this, var1, var2);
   }
}
