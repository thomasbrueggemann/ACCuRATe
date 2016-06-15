package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.internal.class_332;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.plus.internal.class_212;

public final class PlusOneButton extends FrameLayout {
   public static final int ANNOTATION_BUBBLE = 1;
   public static final int ANNOTATION_INLINE = 2;
   public static final int ANNOTATION_NONE = 0;
   public static final int DEFAULT_ACTIVITY_REQUEST_CODE = -1;
   public static final int SIZE_MEDIUM = 1;
   public static final int SIZE_SMALL = 0;
   public static final int SIZE_STANDARD = 3;
   public static final int SIZE_TALL = 2;
   private int anA;
   private PlusOneButton.OnPlusOneClickListener anB;
   private View any;
   private int anz;
   private int mSize;
   // $FF: renamed from: vf java.lang.String
   private String field_4017;

   public PlusOneButton(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public PlusOneButton(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.mSize = getSize(var1, var2);
      this.anz = getAnnotation(var1, var2);
      this.anA = -1;
      this.method_5303(this.getContext());
      if(this.isInEditMode()) {
         ;
      }

   }

   // $FF: renamed from: G (android.content.Context) void
   private void method_5303(Context var1) {
      if(this.any != null) {
         this.removeView(this.any);
      }

      this.any = class_212.method_1512(var1, this.mSize, this.anz, this.field_4017, this.anA);
      this.setOnPlusOneClickListener(this.anB);
      this.addView(this.any);
   }

   protected static int getAnnotation(Context var0, AttributeSet var1) {
      String var2 = class_332.method_2293("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", var0, var1, true, false, "PlusOneButton");
      byte var4;
      if("INLINE".equalsIgnoreCase(var2)) {
         var4 = 2;
      } else {
         boolean var3 = "NONE".equalsIgnoreCase(var2);
         var4 = 0;
         if(!var3) {
            return 1;
         }
      }

      return var4;
   }

   protected static int getSize(Context var0, AttributeSet var1) {
      String var2 = class_332.method_2293("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", var0, var1, true, false, "PlusOneButton");
      return "SMALL".equalsIgnoreCase(var2)?0:("MEDIUM".equalsIgnoreCase(var2)?1:("TALL".equalsIgnoreCase(var2)?2:3));
   }

   public void initialize(String var1, int var2) {
      class_335.method_2302(this.getContext() instanceof Activity, "To use this method, the PlusOneButton must be placed in an Activity. Use initialize(String, OnPlusOneClickListener).");
      this.field_4017 = var1;
      this.anA = var2;
      this.method_5303(this.getContext());
   }

   public void initialize(String var1, PlusOneButton.OnPlusOneClickListener var2) {
      this.field_4017 = var1;
      this.anA = 0;
      this.method_5303(this.getContext());
      this.setOnPlusOneClickListener(var2);
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      this.any.layout(0, 0, var4 - var2, var5 - var3);
   }

   protected void onMeasure(int var1, int var2) {
      View var3 = this.any;
      this.measureChild(var3, var1, var2);
      this.setMeasuredDimension(var3.getMeasuredWidth(), var3.getMeasuredHeight());
   }

   public void setAnnotation(int var1) {
      this.anz = var1;
      this.method_5303(this.getContext());
   }

   public void setOnPlusOneClickListener(PlusOneButton.OnPlusOneClickListener var1) {
      this.anB = var1;
      this.any.setOnClickListener(new PlusOneButton.DefaultOnPlusOneClickListener(var1));
   }

   public void setSize(int var1) {
      this.mSize = var1;
      this.method_5303(this.getContext());
   }

   protected class DefaultOnPlusOneClickListener implements OnClickListener, PlusOneButton.OnPlusOneClickListener {
      private final PlusOneButton.OnPlusOneClickListener anC;

      public DefaultOnPlusOneClickListener(PlusOneButton.OnPlusOneClickListener var2) {
         this.anC = var2;
      }

      public void onClick(View var1) {
         Intent var2 = (Intent)PlusOneButton.this.any.getTag();
         if(this.anC != null) {
            this.anC.onPlusOneClick(var2);
         } else {
            this.onPlusOneClick(var2);
         }
      }

      public void onPlusOneClick(Intent var1) {
         Context var2 = PlusOneButton.this.getContext();
         if(var2 instanceof Activity && var1 != null) {
            ((Activity)var2).startActivityForResult(var1, PlusOneButton.this.anA);
         }

      }
   }

   public interface OnPlusOneClickListener {
      void onPlusOneClick(Intent var1);
   }
}
