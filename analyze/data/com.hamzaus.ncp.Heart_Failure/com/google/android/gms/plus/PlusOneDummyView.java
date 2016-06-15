package com.google.android.gms.plus;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class PlusOneDummyView extends FrameLayout {
   public static final String TAG = "PlusOneDummyView";

   public PlusOneDummyView(Context var1, int var2) {
      super(var1);
      Button var3 = new Button(var1);
      var3.setEnabled(false);
      var3.setBackgroundDrawable(this.method_4539().getDrawable(var2));
      Point var4 = this.method_4538(var2);
      this.addView(var3, new LayoutParams(var4.x, var4.y, 17));
   }

   // $FF: renamed from: cY (int) android.graphics.Point
   private Point method_4538(int var1) {
      byte var2 = 24;
      byte var3 = 20;
      Point var4 = new Point();
      switch(var1) {
      case 0:
         var3 = 14;
         break;
      case 1:
         var2 = 32;
         break;
      case 2:
         var2 = 50;
         break;
      default:
         byte var8 = var2;
         var2 = 38;
         var3 = var8;
      }

      DisplayMetrics var5 = this.getResources().getDisplayMetrics();
      float var6 = TypedValue.applyDimension(1, (float)var2, var5);
      float var7 = TypedValue.applyDimension(1, (float)var3, var5);
      var4.x = (int)(0.5D + (double)var6);
      var4.y = (int)(0.5D + (double)var7);
      return var4;
   }

   // $FF: renamed from: jO () com.google.android.gms.plus.PlusOneDummyView$d
   private PlusOneDummyView.class_1274 method_4539() {
      Object var1 = new PlusOneDummyView.class_1276(this.getContext());
      if(!((PlusOneDummyView.class_1274)var1).isValid()) {
         var1 = new PlusOneDummyView.class_1277(this.getContext());
      }

      if(!((PlusOneDummyView.class_1274)var1).isValid()) {
         var1 = new PlusOneDummyView.class_1275(this.getContext());
      }

      return (PlusOneDummyView.class_1274)var1;
   }

   private static class class_1275 implements PlusOneDummyView.class_1274 {
      private Context mContext;

      private class_1275(Context var1) {
         this.mContext = var1;
      }

      // $FF: synthetic method
      class_1275(Context var1, Object var2) {
         this(var1);
      }

      public Drawable getDrawable(int var1) {
         return this.mContext.getResources().getDrawable(17301508);
      }

      public boolean isValid() {
         return true;
      }
   }

   private static class class_1276 implements PlusOneDummyView.class_1274 {
      private Context mContext;

      private class_1276(Context var1) {
         this.mContext = var1;
      }

      // $FF: synthetic method
      class_1276(Context var1, Object var2) {
         this(var1);
      }

      public Drawable getDrawable(int param1) {
         // $FF: Couldn't be decompiled
      }

      public boolean isValid() {
         try {
            this.mContext.createPackageContext("com.google.android.gms", 4).getResources();
            return true;
         } catch (NameNotFoundException var2) {
            return false;
         }
      }
   }

   private static class class_1277 implements PlusOneDummyView.class_1274 {
      private Context mContext;

      private class_1277(Context var1) {
         this.mContext = var1;
      }

      // $FF: synthetic method
      class_1277(Context var1, Object var2) {
         this(var1);
      }

      public Drawable getDrawable(int var1) {
         String var2;
         switch(var1) {
         case 0:
            var2 = "ic_plusone_small_off_client";
            break;
         case 1:
            var2 = "ic_plusone_medium_off_client";
            break;
         case 2:
            var2 = "ic_plusone_tall_off_client";
            break;
         default:
            var2 = "ic_plusone_standard_off_client";
         }

         int var3 = this.mContext.getResources().getIdentifier(var2, "drawable", this.mContext.getPackageName());
         return this.mContext.getResources().getDrawable(var3);
      }

      public boolean isValid() {
         int var1 = this.mContext.getResources().getIdentifier("ic_plusone_small_off_client", "drawable", this.mContext.getPackageName());
         int var2 = this.mContext.getResources().getIdentifier("ic_plusone_medium_off_client", "drawable", this.mContext.getPackageName());
         int var3 = this.mContext.getResources().getIdentifier("ic_plusone_tall_off_client", "drawable", this.mContext.getPackageName());
         int var4 = this.mContext.getResources().getIdentifier("ic_plusone_standard_off_client", "drawable", this.mContext.getPackageName());
         return var1 != 0 && var2 != 0 && var3 != 0 && var4 != 0;
      }
   }

   private interface class_1274 {
      Drawable getDrawable(int var1);

      boolean isValid();
   }
}
