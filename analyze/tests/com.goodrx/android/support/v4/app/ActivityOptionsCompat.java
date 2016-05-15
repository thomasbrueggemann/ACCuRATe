package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v4.app.ActivityOptionsCompat21;
import android.support.v4.app.ActivityOptionsCompatJB;
import android.support.v4.util.Pair;
import android.view.View;

public class ActivityOptionsCompat {
   public static ActivityOptionsCompat makeCustomAnimation(Context var0, int var1, int var2) {
      return (ActivityOptionsCompat)(VERSION.SDK_INT >= 16?new ActivityOptionsCompat.ActivityOptionsImplJB(ActivityOptionsCompatJB.makeCustomAnimation(var0, var1, var2)):new ActivityOptionsCompat());
   }

   public static ActivityOptionsCompat makeScaleUpAnimation(View var0, int var1, int var2, int var3, int var4) {
      return (ActivityOptionsCompat)(VERSION.SDK_INT >= 16?new ActivityOptionsCompat.ActivityOptionsImplJB(ActivityOptionsCompatJB.makeScaleUpAnimation(var0, var1, var2, var3, var4)):new ActivityOptionsCompat());
   }

   public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity var0, View var1, String var2) {
      return (ActivityOptionsCompat)(VERSION.SDK_INT >= 21?new ActivityOptionsCompat.ActivityOptionsImpl21(ActivityOptionsCompat21.makeSceneTransitionAnimation(var0, var1, var2)):new ActivityOptionsCompat());
   }

   public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity var0, Pair... var1) {
      if(VERSION.SDK_INT < 21) {
         return new ActivityOptionsCompat();
      } else {
         String[] var2 = null;
         View[] var3 = null;
         if(var1 != null) {
            var3 = new View[var1.length];
            var2 = new String[var1.length];

            for(int var4 = 0; var4 < var1.length; ++var4) {
               var3[var4] = (View)var1[var4].first;
               var2[var4] = (String)var1[var4].second;
            }
         }

         return new ActivityOptionsCompat.ActivityOptionsImpl21(ActivityOptionsCompat21.makeSceneTransitionAnimation(var0, var3, var2));
      }
   }

   public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View var0, Bitmap var1, int var2, int var3) {
      return (ActivityOptionsCompat)(VERSION.SDK_INT >= 16?new ActivityOptionsCompat.ActivityOptionsImplJB(ActivityOptionsCompatJB.makeThumbnailScaleUpAnimation(var0, var1, var2, var3)):new ActivityOptionsCompat());
   }

   public Bundle toBundle() {
      return null;
   }

   public void update(ActivityOptionsCompat var1) {
   }

   private static class ActivityOptionsImpl21 extends ActivityOptionsCompat {
      private final ActivityOptionsCompat21 mImpl;

      ActivityOptionsImpl21(ActivityOptionsCompat21 var1) {
         this.mImpl = var1;
      }

      public Bundle toBundle() {
         return this.mImpl.toBundle();
      }

      public void update(ActivityOptionsCompat var1) {
         if(var1 instanceof ActivityOptionsCompat.ActivityOptionsImpl21) {
            ActivityOptionsCompat.ActivityOptionsImpl21 var2 = (ActivityOptionsCompat.ActivityOptionsImpl21)var1;
            this.mImpl.update(var2.mImpl);
         }

      }
   }

   private static class ActivityOptionsImplJB extends ActivityOptionsCompat {
      private final ActivityOptionsCompatJB mImpl;

      ActivityOptionsImplJB(ActivityOptionsCompatJB var1) {
         this.mImpl = var1;
      }

      public Bundle toBundle() {
         return this.mImpl.toBundle();
      }

      public void update(ActivityOptionsCompat var1) {
         if(var1 instanceof ActivityOptionsCompat.ActivityOptionsImplJB) {
            ActivityOptionsCompat.ActivityOptionsImplJB var2 = (ActivityOptionsCompat.ActivityOptionsImplJB)var1;
            this.mImpl.update(var2.mImpl);
         }

      }
   }
}
