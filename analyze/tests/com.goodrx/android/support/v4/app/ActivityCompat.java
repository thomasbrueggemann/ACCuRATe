package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat21;
import android.support.v4.app.ActivityCompat22;
import android.support.v4.app.ActivityCompatApi23;
import android.support.v4.app.ActivityCompatHoneycomb;
import android.support.v4.app.ActivityCompatJB;
import android.support.v4.app.SharedElementCallback;
import android.support.v4.content.ContextCompat;
import android.view.View;
import java.util.List;
import java.util.Map;

public class ActivityCompat extends ContextCompat {
   private static ActivityCompat21.SharedElementCallback21 createCallback(SharedElementCallback var0) {
      ActivityCompat.SharedElementCallback21Impl var1 = null;
      if(var0 != null) {
         var1 = new ActivityCompat.SharedElementCallback21Impl(var0);
      }

      return var1;
   }

   public static void finishAffinity(Activity var0) {
      if(VERSION.SDK_INT >= 16) {
         ActivityCompatJB.finishAffinity(var0);
      } else {
         var0.finish();
      }
   }

   public static void finishAfterTransition(Activity var0) {
      if(VERSION.SDK_INT >= 21) {
         ActivityCompat21.finishAfterTransition(var0);
      } else {
         var0.finish();
      }
   }

   public static boolean invalidateOptionsMenu(Activity var0) {
      if(VERSION.SDK_INT >= 11) {
         ActivityCompatHoneycomb.invalidateOptionsMenu(var0);
         return true;
      } else {
         return false;
      }
   }

   public static void postponeEnterTransition(Activity var0) {
      if(VERSION.SDK_INT >= 21) {
         ActivityCompat21.postponeEnterTransition(var0);
      }

   }

   public static void requestPermissions(@NonNull final Activity var0, @NonNull final String[] var1, final int var2) {
      if(VERSION.SDK_INT >= 23) {
         ActivityCompatApi23.requestPermissions(var0, var1, var2);
      } else if(var0 instanceof ActivityCompat.OnRequestPermissionsResultCallback) {
         (new Handler(Looper.getMainLooper())).post(new Runnable() {
            public void run() {
               int[] var1x = new int[var1.length];
               PackageManager var2x = var0.getPackageManager();
               String var3 = var0.getPackageName();
               int var4 = var1.length;

               for(int var5 = 0; var5 < var4; ++var5) {
                  var1x[var5] = var2x.checkPermission(var1[var5], var3);
               }

               ((ActivityCompat.OnRequestPermissionsResultCallback)var0).onRequestPermissionsResult(var2, var1, var1x);
            }
         });
         return;
      }

   }

   public static void setEnterSharedElementCallback(Activity var0, SharedElementCallback var1) {
      if(VERSION.SDK_INT >= 21) {
         ActivityCompat21.setEnterSharedElementCallback(var0, createCallback(var1));
      }

   }

   public static void setExitSharedElementCallback(Activity var0, SharedElementCallback var1) {
      if(VERSION.SDK_INT >= 21) {
         ActivityCompat21.setExitSharedElementCallback(var0, createCallback(var1));
      }

   }

   public static boolean shouldShowRequestPermissionRationale(@NonNull Activity var0, @NonNull String var1) {
      return VERSION.SDK_INT >= 23?ActivityCompatApi23.shouldShowRequestPermissionRationale(var0, var1):false;
   }

   public static void startActivity(Activity var0, Intent var1, @Nullable Bundle var2) {
      if(VERSION.SDK_INT >= 16) {
         ActivityCompatJB.startActivity(var0, var1, var2);
      } else {
         var0.startActivity(var1);
      }
   }

   public static void startActivityForResult(Activity var0, Intent var1, int var2, @Nullable Bundle var3) {
      if(VERSION.SDK_INT >= 16) {
         ActivityCompatJB.startActivityForResult(var0, var1, var2, var3);
      } else {
         var0.startActivityForResult(var1, var2);
      }
   }

   public static void startPostponedEnterTransition(Activity var0) {
      if(VERSION.SDK_INT >= 21) {
         ActivityCompat21.startPostponedEnterTransition(var0);
      }

   }

   public Uri getReferrer(Activity var1) {
      Uri var3;
      if(VERSION.SDK_INT >= 22) {
         var3 = ActivityCompat22.getReferrer(var1);
      } else {
         Intent var2 = var1.getIntent();
         var3 = (Uri)var2.getParcelableExtra("android.intent.extra.REFERRER");
         if(var3 == null) {
            String var4 = var2.getStringExtra("android.intent.extra.REFERRER_NAME");
            if(var4 != null) {
               return Uri.parse(var4);
            }

            return null;
         }
      }

      return var3;
   }

   public interface OnRequestPermissionsResultCallback {
      void onRequestPermissionsResult(int var1, @NonNull String[] var2, @NonNull int[] var3);
   }

   private static class SharedElementCallback21Impl extends ActivityCompat21.SharedElementCallback21 {
      private SharedElementCallback mCallback;

      public SharedElementCallback21Impl(SharedElementCallback var1) {
         this.mCallback = var1;
      }

      public Parcelable onCaptureSharedElementSnapshot(View var1, Matrix var2, RectF var3) {
         return this.mCallback.onCaptureSharedElementSnapshot(var1, var2, var3);
      }

      public View onCreateSnapshotView(Context var1, Parcelable var2) {
         return this.mCallback.onCreateSnapshotView(var1, var2);
      }

      public void onMapSharedElements(List<String> var1, Map<String, View> var2) {
         this.mCallback.onMapSharedElements(var1, var2);
      }

      public void onRejectSharedElements(List<View> var1) {
         this.mCallback.onRejectSharedElements(var1);
      }

      public void onSharedElementEnd(List<String> var1, List<View> var2, List<View> var3) {
         this.mCallback.onSharedElementEnd(var1, var2, var3);
      }

      public void onSharedElementStart(List<String> var1, List<View> var2, List<View> var3) {
         this.mCallback.onSharedElementStart(var1, var2, var3);
      }
   }
}
