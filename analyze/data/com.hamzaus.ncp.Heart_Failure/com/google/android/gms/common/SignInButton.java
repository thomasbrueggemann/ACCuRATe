package com.google.android.gms.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.class_176;
import com.google.android.gms.internal.class_180;
import com.google.android.gms.internal.class_341;
import com.google.android.gms.internal.class_347;

public final class SignInButton extends FrameLayout implements OnClickListener {
   public static final int COLOR_DARK = 0;
   public static final int COLOR_LIGHT = 1;
   public static final int SIZE_ICON_ONLY = 2;
   public static final int SIZE_STANDARD = 0;
   public static final int SIZE_WIDE = 1;
   // $FF: renamed from: Dg int
   private int field_947;
   // $FF: renamed from: Dh android.view.View
   private View field_948;
   // $FF: renamed from: Di android.view.View.OnClickListener
   private OnClickListener field_949;
   private int mSize;

   public SignInButton(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public SignInButton(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public SignInButton(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.field_949 = null;
      this.setStyle(0, 0);
   }

   // $FF: renamed from: a (android.content.Context, int, int) android.widget.Button
   private static Button method_1860(Context var0, int var1, int var2) {
      class_341 var3 = new class_341(var0);
      var3.method_2141(var0.getResources(), var1, var2);
      return var3;
   }

   // $FF: renamed from: z (android.content.Context) void
   private void method_1861(Context var1) {
      if(this.field_948 != null) {
         this.removeView(this.field_948);
      }

      try {
         this.field_948 = class_180.method_1289(var1, this.mSize, this.field_947);
      } catch (class_176.class_1202 var3) {
         Log.w("SignInButton", "Sign in button not found, using placeholder instead");
         this.field_948 = method_1860(var1, this.mSize, this.field_947);
      }

      this.addView(this.field_948);
      this.field_948.setEnabled(this.isEnabled());
      this.field_948.setOnClickListener(this);
   }

   public void onClick(View var1) {
      if(this.field_949 != null && var1 == this.field_948) {
         this.field_949.onClick(this);
      }

   }

   public void setColorScheme(int var1) {
      this.setStyle(this.mSize, var1);
   }

   public void setEnabled(boolean var1) {
      super.setEnabled(var1);
      this.field_948.setEnabled(var1);
   }

   public void setOnClickListener(OnClickListener var1) {
      this.field_949 = var1;
      if(this.field_948 != null) {
         this.field_948.setOnClickListener(this);
      }

   }

   public void setSize(int var1) {
      this.setStyle(var1, this.field_947);
   }

   public void setStyle(int var1, int var2) {
      boolean var3;
      if(var1 >= 0 && var1 < 3) {
         var3 = true;
      } else {
         var3 = false;
      }

      Object[] var4 = new Object[]{Integer.valueOf(var1)};
      class_347.method_2162(var3, "Unknown button size %d", var4);
      boolean var5;
      if(var2 >= 0 && var2 < 2) {
         var5 = true;
      } else {
         var5 = false;
      }

      Object[] var6 = new Object[]{Integer.valueOf(var2)};
      class_347.method_2162(var5, "Unknown color scheme %s", var6);
      this.mSize = var1;
      this.field_947 = var2;
      this.method_1861(this.getContext());
   }
}
