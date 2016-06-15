package com.google.android.gms.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.class_211;
import com.google.android.gms.internal.class_216;
import com.google.android.gms.internal.class_334;
import com.google.android.gms.internal.class_335;

public final class SignInButton extends FrameLayout implements OnClickListener {
   public static final int COLOR_DARK = 0;
   public static final int COLOR_LIGHT = 1;
   public static final int SIZE_ICON_ONLY = 2;
   public static final int SIZE_STANDARD = 0;
   public static final int SIZE_WIDE = 1;
   // $FF: renamed from: Jk android.view.View
   private View field_816;
   // $FF: renamed from: Jl android.view.View.OnClickListener
   private OnClickListener field_817;
   private int mColor;
   private int mSize;

   public SignInButton(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public SignInButton(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public SignInButton(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.field_817 = null;
      this.setStyle(0, 0);
   }

   // $FF: renamed from: G (android.content.Context) void
   private void method_2271(Context var1) {
      if(this.field_816 != null) {
         this.removeView(this.field_816);
      }

      try {
         this.field_816 = class_216.method_1525(var1, this.mSize, this.mColor);
      } catch (class_211.class_1565 var3) {
         Log.w("SignInButton", "Sign in button not found, using placeholder instead");
         this.field_816 = method_2272(var1, this.mSize, this.mColor);
      }

      this.addView(this.field_816);
      this.field_816.setEnabled(this.isEnabled());
      this.field_816.setOnClickListener(this);
   }

   // $FF: renamed from: a (android.content.Context, int, int) android.widget.Button
   private static Button method_2272(Context var0, int var1, int var2) {
      class_334 var3 = new class_334(var0);
      var3.method_2299(var0.getResources(), var1, var2);
      return var3;
   }

   public void onClick(View var1) {
      if(this.field_817 != null && var1 == this.field_816) {
         this.field_817.onClick(this);
      }

   }

   public void setColorScheme(int var1) {
      this.setStyle(this.mSize, var1);
   }

   public void setEnabled(boolean var1) {
      super.setEnabled(var1);
      this.field_816.setEnabled(var1);
   }

   public void setOnClickListener(OnClickListener var1) {
      this.field_817 = var1;
      if(this.field_816 != null) {
         this.field_816.setOnClickListener(this);
      }

   }

   public void setSize(int var1) {
      this.setStyle(var1, this.mColor);
   }

   public void setStyle(int var1, int var2) {
      boolean var3;
      if(var1 >= 0 && var1 < 3) {
         var3 = true;
      } else {
         var3 = false;
      }

      Object[] var4 = new Object[]{Integer.valueOf(var1)};
      class_335.method_2303(var3, "Unknown button size %d", var4);
      boolean var5;
      if(var2 >= 0 && var2 < 2) {
         var5 = true;
      } else {
         var5 = false;
      }

      Object[] var6 = new Object[]{Integer.valueOf(var2)};
      class_335.method_2303(var5, "Unknown color scheme %s", var6);
      this.mSize = var1;
      this.mColor = var2;
      this.method_2271(this.getContext());
   }
}
