package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.support.v4.media.MediaDescriptionCompatApi21;
import android.support.v4.media.MediaDescriptionCompatApi23;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
   public static final Creator<MediaDescriptionCompat> CREATOR = new Creator() {
      public MediaDescriptionCompat createFromParcel(Parcel var1) {
         return VERSION.SDK_INT < 21?new MediaDescriptionCompat(var1, null):MediaDescriptionCompat.fromMediaDescription(MediaDescriptionCompatApi21.fromParcel(var1));
      }

      public MediaDescriptionCompat[] newArray(int var1) {
         return new MediaDescriptionCompat[var1];
      }
   };
   public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";
   public static final String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
   private final CharSequence mDescription;
   private Object mDescriptionObj;
   private final Bundle mExtras;
   private final Bitmap mIcon;
   private final Uri mIconUri;
   private final String mMediaId;
   private final Uri mMediaUri;
   private final CharSequence mSubtitle;
   private final CharSequence mTitle;

   private MediaDescriptionCompat(Parcel var1) {
      this.mMediaId = var1.readString();
      this.mTitle = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(var1);
      this.mSubtitle = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(var1);
      this.mDescription = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(var1);
      this.mIcon = (Bitmap)var1.readParcelable((ClassLoader)null);
      this.mIconUri = (Uri)var1.readParcelable((ClassLoader)null);
      this.mExtras = var1.readBundle();
      this.mMediaUri = (Uri)var1.readParcelable((ClassLoader)null);
   }

   // $FF: synthetic method
   MediaDescriptionCompat(Parcel var1, Object var2) {
      this(var1);
   }

   private MediaDescriptionCompat(String var1, CharSequence var2, CharSequence var3, CharSequence var4, Bitmap var5, Uri var6, Bundle var7, Uri var8) {
      this.mMediaId = var1;
      this.mTitle = var2;
      this.mSubtitle = var3;
      this.mDescription = var4;
      this.mIcon = var5;
      this.mIconUri = var6;
      this.mExtras = var7;
      this.mMediaUri = var8;
   }

   // $FF: synthetic method
   MediaDescriptionCompat(String var1, CharSequence var2, CharSequence var3, CharSequence var4, Bitmap var5, Uri var6, Bundle var7, Uri var8, Object var9) {
      this(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public static MediaDescriptionCompat fromMediaDescription(Object var0) {
      if(var0 != null && VERSION.SDK_INT >= 21) {
         MediaDescriptionCompat.Builder var1 = new MediaDescriptionCompat.Builder();
         var1.setMediaId(MediaDescriptionCompatApi21.getMediaId(var0));
         var1.setTitle(MediaDescriptionCompatApi21.getTitle(var0));
         var1.setSubtitle(MediaDescriptionCompatApi21.getSubtitle(var0));
         var1.setDescription(MediaDescriptionCompatApi21.getDescription(var0));
         var1.setIconBitmap(MediaDescriptionCompatApi21.getIconBitmap(var0));
         var1.setIconUri(MediaDescriptionCompatApi21.getIconUri(var0));
         Bundle var8 = MediaDescriptionCompatApi21.getExtras(var0);
         Uri var9;
         if(var8 == null) {
            var9 = null;
         } else {
            var9 = (Uri)var8.getParcelable("android.support.v4.media.description.MEDIA_URI");
         }

         if(var9 != null) {
            if(var8.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && var8.size() == 2) {
               var8 = null;
            } else {
               var8.remove("android.support.v4.media.description.MEDIA_URI");
               var8.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
            }
         }

         var1.setExtras(var8);
         if(var9 != null) {
            var1.setMediaUri(var9);
         } else if(VERSION.SDK_INT >= 23) {
            var1.setMediaUri(MediaDescriptionCompatApi23.getMediaUri(var0));
         }

         MediaDescriptionCompat var12 = var1.build();
         var12.mDescriptionObj = var0;
         return var12;
      } else {
         return null;
      }
   }

   public int describeContents() {
      return 0;
   }

   @Nullable
   public CharSequence getDescription() {
      return this.mDescription;
   }

   @Nullable
   public Bundle getExtras() {
      return this.mExtras;
   }

   @Nullable
   public Bitmap getIconBitmap() {
      return this.mIcon;
   }

   @Nullable
   public Uri getIconUri() {
      return this.mIconUri;
   }

   public Object getMediaDescription() {
      if(this.mDescriptionObj == null && VERSION.SDK_INT >= 21) {
         Object var1 = MediaDescriptionCompatApi21.Builder.newInstance();
         MediaDescriptionCompatApi21.Builder.setMediaId(var1, this.mMediaId);
         MediaDescriptionCompatApi21.Builder.setTitle(var1, this.mTitle);
         MediaDescriptionCompatApi21.Builder.setSubtitle(var1, this.mSubtitle);
         MediaDescriptionCompatApi21.Builder.setDescription(var1, this.mDescription);
         MediaDescriptionCompatApi21.Builder.setIconBitmap(var1, this.mIcon);
         MediaDescriptionCompatApi21.Builder.setIconUri(var1, this.mIconUri);
         Bundle var2 = this.mExtras;
         if(VERSION.SDK_INT < 23 && this.mMediaUri != null) {
            if(var2 == null) {
               var2 = new Bundle();
               var2.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }

            var2.putParcelable("android.support.v4.media.description.MEDIA_URI", this.mMediaUri);
         }

         MediaDescriptionCompatApi21.Builder.setExtras(var1, var2);
         if(VERSION.SDK_INT >= 23) {
            MediaDescriptionCompatApi23.Builder.setMediaUri(var1, this.mMediaUri);
         }

         this.mDescriptionObj = MediaDescriptionCompatApi21.Builder.build(var1);
         return this.mDescriptionObj;
      } else {
         return this.mDescriptionObj;
      }
   }

   @Nullable
   public String getMediaId() {
      return this.mMediaId;
   }

   @Nullable
   public Uri getMediaUri() {
      return this.mMediaUri;
   }

   @Nullable
   public CharSequence getSubtitle() {
      return this.mSubtitle;
   }

   @Nullable
   public CharSequence getTitle() {
      return this.mTitle;
   }

   public String toString() {
      return this.mTitle + ", " + this.mSubtitle + ", " + this.mDescription;
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(VERSION.SDK_INT < 21) {
         var1.writeString(this.mMediaId);
         TextUtils.writeToParcel(this.mTitle, var1, var2);
         TextUtils.writeToParcel(this.mSubtitle, var1, var2);
         TextUtils.writeToParcel(this.mDescription, var1, var2);
         var1.writeParcelable(this.mIcon, var2);
         var1.writeParcelable(this.mIconUri, var2);
         var1.writeBundle(this.mExtras);
         var1.writeParcelable(this.mMediaUri, var2);
      } else {
         MediaDescriptionCompatApi21.writeToParcel(this.getMediaDescription(), var1, var2);
      }
   }

   public static final class Builder {
      private CharSequence mDescription;
      private Bundle mExtras;
      private Bitmap mIcon;
      private Uri mIconUri;
      private String mMediaId;
      private Uri mMediaUri;
      private CharSequence mSubtitle;
      private CharSequence mTitle;

      public MediaDescriptionCompat build() {
         return new MediaDescriptionCompat(this.mMediaId, this.mTitle, this.mSubtitle, this.mDescription, this.mIcon, this.mIconUri, this.mExtras, this.mMediaUri, null);
      }

      public MediaDescriptionCompat.Builder setDescription(@Nullable CharSequence var1) {
         this.mDescription = var1;
         return this;
      }

      public MediaDescriptionCompat.Builder setExtras(@Nullable Bundle var1) {
         this.mExtras = var1;
         return this;
      }

      public MediaDescriptionCompat.Builder setIconBitmap(@Nullable Bitmap var1) {
         this.mIcon = var1;
         return this;
      }

      public MediaDescriptionCompat.Builder setIconUri(@Nullable Uri var1) {
         this.mIconUri = var1;
         return this;
      }

      public MediaDescriptionCompat.Builder setMediaId(@Nullable String var1) {
         this.mMediaId = var1;
         return this;
      }

      public MediaDescriptionCompat.Builder setMediaUri(@Nullable Uri var1) {
         this.mMediaUri = var1;
         return this;
      }

      public MediaDescriptionCompat.Builder setSubtitle(@Nullable CharSequence var1) {
         this.mSubtitle = var1;
         return this;
      }

      public MediaDescriptionCompat.Builder setTitle(@Nullable CharSequence var1) {
         this.mTitle = var1;
         return this;
      }
   }
}
