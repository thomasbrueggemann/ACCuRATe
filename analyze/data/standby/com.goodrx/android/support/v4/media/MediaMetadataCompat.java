package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompatApi21;
import android.support.v4.media.RatingCompat;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;

public final class MediaMetadataCompat implements Parcelable {
   public static final Creator<MediaMetadataCompat> CREATOR;
   private static final ArrayMap<String, Integer> METADATA_KEYS_TYPE = new ArrayMap();
   public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
   public static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
   public static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
   public static final String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
   public static final String METADATA_KEY_ART = "android.media.metadata.ART";
   public static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
   public static final String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
   public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
   public static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
   public static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
   public static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
   public static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
   public static final String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
   public static final String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
   public static final String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
   public static final String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
   public static final String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
   public static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
   public static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
   public static final String METADATA_KEY_MEDIA_ID = "android.media.metadata.MEDIA_ID";
   public static final String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
   public static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
   public static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
   public static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
   public static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
   public static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
   public static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
   private static final int METADATA_TYPE_BITMAP = 2;
   private static final int METADATA_TYPE_LONG = 0;
   private static final int METADATA_TYPE_RATING = 3;
   private static final int METADATA_TYPE_TEXT = 1;
   private static final String[] PREFERRED_BITMAP_ORDER;
   private static final String[] PREFERRED_DESCRIPTION_ORDER;
   private static final String[] PREFERRED_URI_ORDER;
   private static final String TAG = "MediaMetadata";
   private final Bundle mBundle;
   private MediaDescriptionCompat mDescription;
   private Object mMetadataObj;

   static {
      METADATA_KEYS_TYPE.put("android.media.metadata.TITLE", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.ARTIST", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.DURATION", Integer.valueOf(0));
      METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.AUTHOR", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.WRITER", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.COMPOSER", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.COMPILATION", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.DATE", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.YEAR", Integer.valueOf(0));
      METADATA_KEYS_TYPE.put("android.media.metadata.GENRE", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.TRACK_NUMBER", Integer.valueOf(0));
      METADATA_KEYS_TYPE.put("android.media.metadata.NUM_TRACKS", Integer.valueOf(0));
      METADATA_KEYS_TYPE.put("android.media.metadata.DISC_NUMBER", Integer.valueOf(0));
      METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ARTIST", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.ART", Integer.valueOf(2));
      METADATA_KEYS_TYPE.put("android.media.metadata.ART_URI", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ART", Integer.valueOf(2));
      METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ART_URI", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.USER_RATING", Integer.valueOf(3));
      METADATA_KEYS_TYPE.put("android.media.metadata.RATING", Integer.valueOf(3));
      METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_TITLE", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_SUBTITLE", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_DESCRIPTION", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_ICON", Integer.valueOf(2));
      METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_ICON_URI", Integer.valueOf(1));
      METADATA_KEYS_TYPE.put("android.media.metadata.MEDIA_ID", Integer.valueOf(1));
      PREFERRED_DESCRIPTION_ORDER = new String[]{"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};
      PREFERRED_BITMAP_ORDER = new String[]{"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"};
      PREFERRED_URI_ORDER = new String[]{"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"};
      CREATOR = new Creator() {
         public MediaMetadataCompat createFromParcel(Parcel var1) {
            return new MediaMetadataCompat(var1, null);
         }

         public MediaMetadataCompat[] newArray(int var1) {
            return new MediaMetadataCompat[var1];
         }
      };
   }

   private MediaMetadataCompat(Bundle var1) {
      this.mBundle = new Bundle(var1);
   }

   // $FF: synthetic method
   MediaMetadataCompat(Bundle var1, Object var2) {
      this(var1);
   }

   private MediaMetadataCompat(Parcel var1) {
      this.mBundle = var1.readBundle();
   }

   // $FF: synthetic method
   MediaMetadataCompat(Parcel var1, Object var2) {
      this(var1);
   }

   public static MediaMetadataCompat fromMediaMetadata(Object var0) {
      if(var0 != null && VERSION.SDK_INT >= 21) {
         Parcel var1 = Parcel.obtain();
         MediaMetadataCompatApi21.writeToParcel(var0, var1, 0);
         var1.setDataPosition(0);
         MediaMetadataCompat var2 = (MediaMetadataCompat)CREATOR.createFromParcel(var1);
         var1.recycle();
         var2.mMetadataObj = var0;
         return var2;
      } else {
         return null;
      }
   }

   public boolean containsKey(String var1) {
      return this.mBundle.containsKey(var1);
   }

   public int describeContents() {
      return 0;
   }

   public Bitmap getBitmap(String var1) {
      try {
         Bitmap var4 = (Bitmap)this.mBundle.getParcelable(var1);
         return var4;
      } catch (Exception var5) {
         Log.w("MediaMetadata", "Failed to retrieve a key as Bitmap.", var5);
         return null;
      }
   }

   public Bundle getBundle() {
      return this.mBundle;
   }

   public MediaDescriptionCompat getDescription() {
      if(this.mDescription != null) {
         return this.mDescription;
      } else {
         String var1 = this.getString("android.media.metadata.MEDIA_ID");
         CharSequence[] var2 = new CharSequence[3];
         CharSequence var3 = this.getText("android.media.metadata.DISPLAY_TITLE");
         if(!TextUtils.isEmpty(var3)) {
            var2[0] = var3;
            var2[1] = this.getText("android.media.metadata.DISPLAY_SUBTITLE");
            var2[2] = this.getText("android.media.metadata.DISPLAY_DESCRIPTION");
         } else {
            int var4 = 0;

            int var7;
            for(int var5 = 0; var4 < var2.length && var5 < PREFERRED_DESCRIPTION_ORDER.length; var5 = var7) {
               String[] var6 = PREFERRED_DESCRIPTION_ORDER;
               var7 = var5 + 1;
               CharSequence var8 = this.getText(var6[var5]);
               if(!TextUtils.isEmpty(var8)) {
                  int var9 = var4 + 1;
                  var2[var4] = var8;
                  var4 = var9;
               }
            }
         }

         int var10 = 0;

         Bitmap var12;
         while(true) {
            int var11 = PREFERRED_BITMAP_ORDER.length;
            var12 = null;
            if(var10 >= var11) {
               break;
            }

            Bitmap var24 = this.getBitmap(PREFERRED_BITMAP_ORDER[var10]);
            if(var24 != null) {
               var12 = var24;
               break;
            }

            ++var10;
         }

         int var13 = 0;

         Uri var15;
         while(true) {
            int var14 = PREFERRED_URI_ORDER.length;
            var15 = null;
            if(var13 >= var14) {
               break;
            }

            String var23 = this.getString(PREFERRED_URI_ORDER[var13]);
            if(!TextUtils.isEmpty(var23)) {
               var15 = Uri.parse(var23);
               break;
            }

            ++var13;
         }

         MediaDescriptionCompat.Builder var16 = new MediaDescriptionCompat.Builder();
         var16.setMediaId(var1);
         var16.setTitle(var2[0]);
         var16.setSubtitle(var2[1]);
         var16.setDescription(var2[2]);
         var16.setIconBitmap(var12);
         var16.setIconUri(var15);
         this.mDescription = var16.build();
         return this.mDescription;
      }
   }

   public long getLong(String var1) {
      return this.mBundle.getLong(var1, 0L);
   }

   public Object getMediaMetadata() {
      if(this.mMetadataObj == null && VERSION.SDK_INT >= 21) {
         Parcel var1 = Parcel.obtain();
         this.writeToParcel(var1, 0);
         var1.setDataPosition(0);
         this.mMetadataObj = MediaMetadataCompatApi21.createFromParcel(var1);
         var1.recycle();
         return this.mMetadataObj;
      } else {
         return this.mMetadataObj;
      }
   }

   public RatingCompat getRating(String var1) {
      try {
         if(VERSION.SDK_INT >= 21) {
            return RatingCompat.fromRating(this.mBundle.getParcelable(var1));
         } else {
            RatingCompat var4 = (RatingCompat)this.mBundle.getParcelable(var1);
            return var4;
         }
      } catch (Exception var5) {
         Log.w("MediaMetadata", "Failed to retrieve a key as Rating.", var5);
         return null;
      }
   }

   public String getString(String var1) {
      CharSequence var2 = this.mBundle.getCharSequence(var1);
      return var2 != null?var2.toString():null;
   }

   public CharSequence getText(String var1) {
      return this.mBundle.getCharSequence(var1);
   }

   public Set<String> keySet() {
      return this.mBundle.keySet();
   }

   public int size() {
      return this.mBundle.size();
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeBundle(this.mBundle);
   }

   @Retention(RetentionPolicy.SOURCE)
   public @interface BitmapKey {
   }

   public static final class Builder {
      private final Bundle mBundle;

      public Builder() {
         this.mBundle = new Bundle();
      }

      public Builder(MediaMetadataCompat var1) {
         this.mBundle = new Bundle(var1.mBundle);
      }

      public MediaMetadataCompat build() {
         return new MediaMetadataCompat(this.mBundle, null);
      }

      public MediaMetadataCompat.Builder putBitmap(String var1, Bitmap var2) {
         if(MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(var1) && ((Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get(var1)).intValue() != 2) {
            throw new IllegalArgumentException("The " + var1 + " key cannot be used to put a Bitmap");
         } else {
            this.mBundle.putParcelable(var1, var2);
            return this;
         }
      }

      public MediaMetadataCompat.Builder putLong(String var1, long var2) {
         if(MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(var1) && ((Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get(var1)).intValue() != 0) {
            throw new IllegalArgumentException("The " + var1 + " key cannot be used to put a long");
         } else {
            this.mBundle.putLong(var1, var2);
            return this;
         }
      }

      public MediaMetadataCompat.Builder putRating(String var1, RatingCompat var2) {
         if(MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(var1) && ((Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get(var1)).intValue() != 3) {
            throw new IllegalArgumentException("The " + var1 + " key cannot be used to put a Rating");
         } else if(VERSION.SDK_INT >= 21) {
            this.mBundle.putParcelable(var1, (Parcelable)var2.getRating());
            return this;
         } else {
            this.mBundle.putParcelable(var1, var2);
            return this;
         }
      }

      public MediaMetadataCompat.Builder putString(String var1, String var2) {
         if(MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(var1) && ((Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get(var1)).intValue() != 1) {
            throw new IllegalArgumentException("The " + var1 + " key cannot be used to put a String");
         } else {
            this.mBundle.putCharSequence(var1, var2);
            return this;
         }
      }

      public MediaMetadataCompat.Builder putText(String var1, CharSequence var2) {
         if(MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(var1) && ((Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get(var1)).intValue() != 1) {
            throw new IllegalArgumentException("The " + var1 + " key cannot be used to put a CharSequence");
         } else {
            this.mBundle.putCharSequence(var1, var2);
            return this;
         }
      }
   }

   @Retention(RetentionPolicy.SOURCE)
   public @interface LongKey {
   }

   @Retention(RetentionPolicy.SOURCE)
   public @interface RatingKey {
   }

   @Retention(RetentionPolicy.SOURCE)
   public @interface TextKey {
   }
}
