package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.support.v4.media.RatingCompatApi21;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class RatingCompat implements Parcelable {
   public static final Creator<RatingCompat> CREATOR = new Creator() {
      public RatingCompat createFromParcel(Parcel var1) {
         return new RatingCompat(var1.readInt(), var1.readFloat(), null);
      }

      public RatingCompat[] newArray(int var1) {
         return new RatingCompat[var1];
      }
   };
   public static final int RATING_3_STARS = 3;
   public static final int RATING_4_STARS = 4;
   public static final int RATING_5_STARS = 5;
   public static final int RATING_HEART = 1;
   public static final int RATING_NONE = 0;
   private static final float RATING_NOT_RATED = -1.0F;
   public static final int RATING_PERCENTAGE = 6;
   public static final int RATING_THUMB_UP_DOWN = 2;
   private static final String TAG = "Rating";
   private Object mRatingObj;
   private final int mRatingStyle;
   private final float mRatingValue;

   private RatingCompat(int var1, float var2) {
      this.mRatingStyle = var1;
      this.mRatingValue = var2;
   }

   // $FF: synthetic method
   RatingCompat(int var1, float var2, Object var3) {
      this(var1, var2);
   }

   public static RatingCompat fromRating(Object var0) {
      if(var0 != null && VERSION.SDK_INT >= 21) {
         int var1 = RatingCompatApi21.getRatingStyle(var0);
         RatingCompat var2;
         if(RatingCompatApi21.isRated(var0)) {
            switch(var1) {
            case 1:
               var2 = newHeartRating(RatingCompatApi21.hasHeart(var0));
               break;
            case 2:
               var2 = newThumbRating(RatingCompatApi21.isThumbUp(var0));
               break;
            case 3:
            case 4:
            case 5:
               var2 = newStarRating(var1, RatingCompatApi21.getStarRating(var0));
               break;
            case 6:
               var2 = newPercentageRating(RatingCompatApi21.getPercentRating(var0));
               break;
            default:
               return null;
            }
         } else {
            var2 = newUnratedRating(var1);
         }

         var2.mRatingObj = var0;
         return var2;
      } else {
         return null;
      }
   }

   public static RatingCompat newHeartRating(boolean var0) {
      float var1;
      if(var0) {
         var1 = 1.0F;
      } else {
         var1 = 0.0F;
      }

      return new RatingCompat(1, var1);
   }

   public static RatingCompat newPercentageRating(float var0) {
      if(var0 >= 0.0F && var0 <= 100.0F) {
         return new RatingCompat(6, var0);
      } else {
         Log.e("Rating", "Invalid percentage-based rating value");
         return null;
      }
   }

   public static RatingCompat newStarRating(int var0, float var1) {
      float var2;
      switch(var0) {
      case 3:
         var2 = 3.0F;
         break;
      case 4:
         var2 = 4.0F;
         break;
      case 5:
         var2 = 5.0F;
         break;
      default:
         Log.e("Rating", "Invalid rating style (" + var0 + ") for a star rating");
         return null;
      }

      if(var1 >= 0.0F && var1 <= var2) {
         return new RatingCompat(var0, var1);
      } else {
         Log.e("Rating", "Trying to set out of range star-based rating");
         return null;
      }
   }

   public static RatingCompat newThumbRating(boolean var0) {
      float var1;
      if(var0) {
         var1 = 1.0F;
      } else {
         var1 = 0.0F;
      }

      return new RatingCompat(2, var1);
   }

   public static RatingCompat newUnratedRating(int var0) {
      switch(var0) {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
         return new RatingCompat(var0, -1.0F);
      default:
         return null;
      }
   }

   public int describeContents() {
      return this.mRatingStyle;
   }

   public float getPercentRating() {
      return this.mRatingStyle == 6 && this.isRated()?this.mRatingValue:-1.0F;
   }

   public Object getRating() {
      if(this.mRatingObj == null && VERSION.SDK_INT >= 21) {
         if(this.isRated()) {
            switch(this.mRatingStyle) {
            case 1:
               this.mRatingObj = RatingCompatApi21.newHeartRating(this.hasHeart());
               break;
            case 2:
               this.mRatingObj = RatingCompatApi21.newThumbRating(this.isThumbUp());
               break;
            case 3:
            case 4:
            case 5:
               this.mRatingObj = RatingCompatApi21.newStarRating(this.mRatingStyle, this.getStarRating());
               break;
            case 6:
               this.mRatingObj = RatingCompatApi21.newPercentageRating(this.getPercentRating());
            default:
               return null;
            }
         } else {
            this.mRatingObj = RatingCompatApi21.newUnratedRating(this.mRatingStyle);
         }

         return this.mRatingObj;
      } else {
         return this.mRatingObj;
      }
   }

   public int getRatingStyle() {
      return this.mRatingStyle;
   }

   public float getStarRating() {
      switch(this.mRatingStyle) {
      case 3:
      case 4:
      case 5:
         if(this.isRated()) {
            return this.mRatingValue;
         }
      default:
         return -1.0F;
      }
   }

   public boolean hasHeart() {
      byte var1 = 1;
      if(this.mRatingStyle != var1) {
         return false;
      } else {
         if(this.mRatingValue != 1.0F) {
            var1 = 0;
         }

         return (boolean)var1;
      }
   }

   public boolean isRated() {
      return this.mRatingValue >= 0.0F;
   }

   public boolean isThumbUp() {
      return this.mRatingStyle == 2 && this.mRatingValue == 1.0F;
   }

   public String toString() {
      StringBuilder var1 = (new StringBuilder()).append("Rating:style=").append(this.mRatingStyle).append(" rating=");
      String var2;
      if(this.mRatingValue < 0.0F) {
         var2 = "unrated";
      } else {
         var2 = String.valueOf(this.mRatingValue);
      }

      return var1.append(var2).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeInt(this.mRatingStyle);
      var1.writeFloat(this.mRatingValue);
   }

   @Retention(RetentionPolicy.SOURCE)
   public @interface StarStyle {
   }

   @Retention(RetentionPolicy.SOURCE)
   public @interface Style {
   }
}
