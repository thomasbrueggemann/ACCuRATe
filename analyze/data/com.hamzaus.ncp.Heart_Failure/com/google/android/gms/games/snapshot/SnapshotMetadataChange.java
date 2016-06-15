package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.class_749;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeCreator;
import com.google.android.gms.internal.class_347;

public final class SnapshotMetadataChange implements SafeParcelable {
   public static final SnapshotMetadataChangeCreator CREATOR = new SnapshotMetadataChangeCreator();
   public static final SnapshotMetadataChange EMPTY_CHANGE = new SnapshotMetadataChange();
   // $FF: renamed from: Mm java.lang.String
   private final String field_2710;
   // $FF: renamed from: Ud java.lang.Long
   private final Long field_2711;
   // $FF: renamed from: Ue android.net.Uri
   private final Uri field_2712;
   // $FF: renamed from: Uf com.google.android.gms.common.data.a
   private class_749 field_2713;
   // $FF: renamed from: xJ int
   private final int field_2714;

   SnapshotMetadataChange() {
      this(4, (String)null, (Long)null, (class_749)null, (Uri)null);
   }

   SnapshotMetadataChange(int var1, String var2, Long var3, class_749 var4, Uri var5) {
      boolean var6 = true;
      super();
      this.field_2714 = var1;
      this.field_2710 = var2;
      this.field_2711 = var3;
      this.field_2713 = var4;
      this.field_2712 = var5;
      if(this.field_2713 != null) {
         if(this.field_2712 != null) {
            var6 = false;
         }

         class_347.method_2161(var6, "Cannot set both a URI and an image");
      } else if(this.field_2712 != null) {
         if(this.field_2713 != null) {
            var6 = false;
         }

         class_347.method_2161(var6, "Cannot set both a URI and an image");
         return;
      }

   }

   SnapshotMetadataChange(String var1, Long var2, class_749 var3, Uri var4) {
      this(4, var1, var2, var3, var4);
   }

   public int describeContents() {
      return 0;
   }

   public Bitmap getCoverImage() {
      return this.field_2713 == null?null:this.field_2713.method_4288();
   }

   public Uri getCoverImageUri() {
      return this.field_2712;
   }

   public String getDescription() {
      return this.field_2710;
   }

   public Long getPlayedTimeMillis() {
      return this.field_2711;
   }

   public int getVersionCode() {
      return this.field_2714;
   }

   // $FF: renamed from: iI () com.google.android.gms.common.data.a
   public class_749 method_2783() {
      return this.field_2713;
   }

   public void writeToParcel(Parcel var1, int var2) {
      SnapshotMetadataChangeCreator.method_4513(this, var1, var2);
   }

   public static final class Builder {
      // $FF: renamed from: Mm java.lang.String
      private String field_3818;
      // $FF: renamed from: Ue android.net.Uri
      private Uri field_3819;
      // $FF: renamed from: Ug java.lang.Long
      private Long field_3820;
      // $FF: renamed from: Uh com.google.android.gms.common.data.a
      private class_749 field_3821;

      public SnapshotMetadataChange build() {
         return new SnapshotMetadataChange(this.field_3818, this.field_3820, this.field_3821, this.field_3819);
      }

      public SnapshotMetadataChange.Builder fromMetadata(SnapshotMetadata var1) {
         this.field_3818 = var1.getDescription();
         this.field_3820 = Long.valueOf(var1.getPlayedTime());
         if(this.field_3820.longValue() == -1L) {
            this.field_3820 = null;
         }

         this.field_3819 = var1.getCoverImageUri();
         if(this.field_3819 != null) {
            this.field_3821 = null;
         }

         return this;
      }

      public SnapshotMetadataChange.Builder setCoverImage(Bitmap var1) {
         this.field_3821 = new class_749(var1);
         this.field_3819 = null;
         return this;
      }

      public SnapshotMetadataChange.Builder setDescription(String var1) {
         this.field_3818 = var1;
         return this;
      }

      public SnapshotMetadataChange.Builder setPlayedTimeMillis(long var1) {
         this.field_3820 = Long.valueOf(var1);
         return this;
      }
   }
}
