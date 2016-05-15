package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeCreator;

public final class SnapshotMetadataChangeEntity extends SnapshotMetadataChange implements SafeParcelable {
   public static final SnapshotMetadataChangeCreator CREATOR = new SnapshotMetadataChangeCreator();
   private final int mVersionCode;
   private final Long zzaKO;
   private final Uri zzaKQ;
   private final Long zzaKR;
   private BitmapTeleporter zzaKS;
   private final String zzaxl;

   SnapshotMetadataChangeEntity() {
      this(5, (String)null, (Long)null, (BitmapTeleporter)null, (Uri)null, (Long)null);
   }

   SnapshotMetadataChangeEntity(int var1, String var2, Long var3, BitmapTeleporter var4, Uri var5, Long var6) {
      boolean var7 = true;
      super();
      this.mVersionCode = var1;
      this.zzaxl = var2;
      this.zzaKR = var3;
      this.zzaKS = var4;
      this.zzaKQ = var5;
      this.zzaKO = var6;
      if(this.zzaKS != null) {
         if(this.zzaKQ != null) {
            var7 = false;
         }

         zzx.zza(var7, "Cannot set both a URI and an image");
      } else if(this.zzaKQ != null) {
         if(this.zzaKS != null) {
            var7 = false;
         }

         zzx.zza(var7, "Cannot set both a URI and an image");
         return;
      }

   }

   public int describeContents() {
      return 0;
   }

   public Uri getCoverImageUri() {
      return this.zzaKQ;
   }

   public String getDescription() {
      return this.zzaxl;
   }

   public Long getPlayedTimeMillis() {
      return this.zzaKR;
   }

   public Long getProgressValue() {
      return this.zzaKO;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      SnapshotMetadataChangeCreator.zza(this, var1, var2);
   }

   public BitmapTeleporter zzxU() {
      return this.zzaKS;
   }
}
