package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.class_970;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeCreator;
import com.google.android.gms.internal.class_335;

public final class SnapshotMetadataChangeEntity extends SnapshotMetadataChange implements SafeParcelable {
   public static final SnapshotMetadataChangeCreator CREATOR = new SnapshotMetadataChangeCreator();
   // $FF: renamed from: CK int
   private final int field_2495;
   // $FF: renamed from: UO java.lang.String
   private final String field_2496;
   private final Uri afd;
   private final Long afe;
   private class_970 aff;

   SnapshotMetadataChangeEntity() {
      this(4, (String)null, (Long)null, (class_970)null, (Uri)null);
   }

   SnapshotMetadataChangeEntity(int var1, String var2, Long var3, class_970 var4, Uri var5) {
      boolean var6 = true;
      super();
      this.field_2495 = var1;
      this.field_2496 = var2;
      this.afe = var3;
      this.aff = var4;
      this.afd = var5;
      if(this.aff != null) {
         if(this.afd != null) {
            var6 = false;
         }

         class_335.method_2302(var6, "Cannot set both a URI and an image");
      } else if(this.afd != null) {
         if(this.aff != null) {
            var6 = false;
         }

         class_335.method_2302(var6, "Cannot set both a URI and an image");
         return;
      }

   }

   SnapshotMetadataChangeEntity(String var1, Long var2, class_970 var3, Uri var4) {
      this(4, var1, var2, var3, var4);
   }

   public int describeContents() {
      return 0;
   }

   public Bitmap getCoverImage() {
      return this.aff == null?null:this.aff.method_5400();
   }

   public Uri getCoverImageUri() {
      return this.afd;
   }

   public String getDescription() {
      return this.field_2496;
   }

   public Long getPlayedTimeMillis() {
      return this.afe;
   }

   public int getVersionCode() {
      return this.field_2495;
   }

   // $FF: renamed from: mT () com.google.android.gms.common.data.a
   public class_970 method_3258() {
      return this.aff;
   }

   public void writeToParcel(Parcel var1, int var2) {
      SnapshotMetadataChangeCreator.method_5773(this, var1, var2);
   }
}
