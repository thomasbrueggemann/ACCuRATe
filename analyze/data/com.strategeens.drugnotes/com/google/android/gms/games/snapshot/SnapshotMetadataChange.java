package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.data.class_970;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;

public abstract class SnapshotMetadataChange {
   public static final SnapshotMetadataChange EMPTY_CHANGE = new SnapshotMetadataChangeEntity();

   public abstract Bitmap getCoverImage();

   public abstract String getDescription();

   public abstract Long getPlayedTimeMillis();

   // $FF: renamed from: mT () com.google.android.gms.common.data.a
   public abstract class_970 method_3258();

   public static final class Builder {
      // $FF: renamed from: UO java.lang.String
      private String field_3907;
      private Long afb;
      private class_970 afc;
      private Uri afd;

      public SnapshotMetadataChange build() {
         return new SnapshotMetadataChangeEntity(this.field_3907, this.afb, this.afc, this.afd);
      }

      public SnapshotMetadataChange.Builder fromMetadata(SnapshotMetadata var1) {
         this.field_3907 = var1.getDescription();
         this.afb = Long.valueOf(var1.getPlayedTime());
         if(this.afb.longValue() == -1L) {
            this.afb = null;
         }

         this.afd = var1.getCoverImageUri();
         if(this.afd != null) {
            this.afc = null;
         }

         return this;
      }

      public SnapshotMetadataChange.Builder setCoverImage(Bitmap var1) {
         this.afc = new class_970(var1);
         this.afd = null;
         return this;
      }

      public SnapshotMetadataChange.Builder setDescription(String var1) {
         this.field_3907 = var1;
         return this;
      }

      public SnapshotMetadataChange.Builder setPlayedTimeMillis(long var1) {
         this.afb = Long.valueOf(var1);
         return this;
      }
   }
}
