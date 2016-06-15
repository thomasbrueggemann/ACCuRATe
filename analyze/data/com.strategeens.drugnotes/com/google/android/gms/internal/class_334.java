package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.class_482;
import com.google.android.gms.internal.class_335;

// $FF: renamed from: com.google.android.gms.internal.jz
public final class class_334 extends Button {
   public class_334(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public class_334(Context var1, AttributeSet var2) {
      super(var1, var2, 16842824);
   }

   // $FF: renamed from: b (int, int, int) int
   private int method_2295(int var1, int var2, int var3) {
      switch(var1) {
      case 1:
         var2 = var3;
      case 0:
         return var2;
      default:
         throw new IllegalStateException("Unknown color scheme: " + var1);
      }
   }

   // $FF: renamed from: b (android.content.res.Resources, int, int) void
   private void method_2296(Resources var1, int var2, int var3) {
      int var4;
      switch(var2) {
      case 0:
      case 1:
         var4 = this.method_2295(var3, class_482.drawable.common_signin_btn_text_dark, class_482.drawable.common_signin_btn_text_light);
         break;
      case 2:
         var4 = this.method_2295(var3, class_482.drawable.common_signin_btn_icon_dark, class_482.drawable.common_signin_btn_icon_light);
         break;
      default:
         throw new IllegalStateException("Unknown button size: " + var2);
      }

      if(var4 == -1) {
         throw new IllegalStateException("Could not find background resource!");
      } else {
         this.setBackgroundDrawable(var1.getDrawable(var4));
      }
   }

   // $FF: renamed from: c (android.content.res.Resources) void
   private void method_2297(Resources var1) {
      this.setTypeface(Typeface.DEFAULT_BOLD);
      this.setTextSize(14.0F);
      float var2 = var1.getDisplayMetrics().density;
      this.setMinHeight((int)(0.5F + var2 * 48.0F));
      this.setMinWidth((int)(0.5F + var2 * 48.0F));
   }

   // $FF: renamed from: c (android.content.res.Resources, int, int) void
   private void method_2298(Resources var1, int var2, int var3) {
      this.setTextColor(var1.getColorStateList(this.method_2295(var3, class_482.color.common_signin_btn_text_dark, class_482.color.common_signin_btn_text_light)));
      switch(var2) {
      case 0:
         this.setText(var1.getString(class_482.string.common_signin_button_text));
         return;
      case 1:
         this.setText(var1.getString(class_482.string.common_signin_button_text_long));
         return;
      case 2:
         this.setText((CharSequence)null);
         return;
      default:
         throw new IllegalStateException("Unknown button size: " + var2);
      }
   }

   // $FF: renamed from: a (android.content.res.Resources, int, int) void
   public void method_2299(Resources var1, int var2, int var3) {
      boolean var4;
      if(var2 >= 0 && var2 < 3) {
         var4 = true;
      } else {
         var4 = false;
      }

      Object[] var5 = new Object[]{Integer.valueOf(var2)};
      class_335.method_2303(var4, "Unknown button size %d", var5);
      boolean var6;
      if(var3 >= 0 && var3 < 2) {
         var6 = true;
      } else {
         var6 = false;
      }

      Object[] var7 = new Object[]{Integer.valueOf(var3)};
      class_335.method_2303(var6, "Unknown color scheme %s", var7);
      this.method_2297(var1);
      this.method_2296(var1, var2, var3);
      this.method_2298(var1, var2, var3);
   }
}