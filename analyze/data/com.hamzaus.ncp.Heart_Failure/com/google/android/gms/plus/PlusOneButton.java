package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.internal.class_342;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.plus.internal.class_676;

public final class PlusOneButton extends FrameLayout {
   public static final int ANNOTATION_BUBBLE = 1;
   public static final int ANNOTATION_INLINE = 2;
   public static final int ANNOTATION_NONE = 0;
   public static final int DEFAULT_ACTIVITY_REQUEST_CODE = -1;
   public static final int SIZE_MEDIUM = 1;
   public static final int SIZE_SMALL = 0;
   public static final int SIZE_STANDARD = 3;
   public static final int SIZE_TALL = 2;
   private int abA;
   private PlusOneButton.OnPlusOneClickListener abB;
   private View aby;
   private int abz;
   private int mSize;
   // $FF: renamed from: qV java.lang.String
   private String field_3942;

   public PlusOneButton(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public PlusOneButton(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.mSize = getSize(var1, var2);
      this.abz = getAnnotation(var1, var2);
      this.abA = -1;
      this.method_4225(this.getContext());
      if(this.isInEditMode()) {
         ;
      }

   }

   protected static int getAnnotation(Context var0, AttributeSet var1) {
      String var2 = class_342.method_2142("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", var0, var1, true, false, "PlusOneButton");
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
      String var2 = class_342.method_2142("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", var0, var1, true, false, "PlusOneButton");
      return "SMALL".equalsIgnoreCase(var2)?0:("MEDIUM".equalsIgnoreCase(var2)?1:("TALL".equalsIgnoreCase(var2)?2:3));
   }

   // $FF: renamed from: z (android.content.Context) void
   private void method_4225(Context var1) {
      if(this.aby != null) {
         this.removeView(this.aby);
      }

      this.aby = class_676.method_3936(var1, this.mSize, this.abz, this.field_3942, this.abA);
      this.setOnPlusOneClickListener(this.abB);
      this.addView(this.aby);
   }

   public void initialize(String var1, int var2) {
      class_347.method_2161(this.getContext() instanceof Activity, "To use this method, the PlusOneButton must be placed in an Activity. Use initialize(String, OnPlusOneClickListener).");
      this.field_3942 = var1;
      this.abA = var2;
      this.method_4225(this.getContext());
   }

   public void initialize(String var1, PlusOneButton.OnPlusOneClickListener var2) {
      this.field_3942 = var1;
      this.abA = 0;
      this.method_4225(this.getContext());
      this.setOnPlusOneClickListener(var2);
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      this.aby.layout(0, 0, var4 - var2, var5 - var3);
   }

   protected void onMeasure(int var1, int var2) {
      View var3 = this.aby;
      this.measureChild(var3, var1, var2);
      this.setMeasuredDimension(var3.getMeasuredWidth(), var3.getMeasuredHeight());
   }

   public void setAnnotation(int var1) {
      this.abz = var1;
      this.method_4225(this.getContext());
   }

   public void setOnPlusOneClickListener(PlusOneButton.OnPlusOneClickListener var1) {
      this.abB = var1;
      this.aby.setOnClickListener(new PlusOneButton.DefaultOnPlusOneClickListener(var1));
   }

   public void setSize(int var1) {
      this.mSize = var1;
      this.method_4225(this.getContext());
   }

   protected class DefaultOnPlusOneClickListener implements OnClickListener, PlusOneButton.OnPlusOneClickListener {
      private final PlusOneButton.OnPlusOneClickListener abC;

      public DefaultOnPlusOneClickListener(PlusOneButton.OnPlusOneClickListener var2) {
         this.abC = var2;
      }

      public void onClick(View var1) {
         Intent var2 = (Intent)PlusOneButton.this.aby.getTag();
         if(this.abC != null) {
            this.abC.onPlusOneClick(var2);
         } else {
            this.onPlusOneClick(var2);
         }
      }

      public void onPlusOneClick(Intent var1) {
         Context var2 = PlusOneButton.this.getContext();
         if(var2 instanceof Activity && var1 != null) {
            ((Activity)var2).startActivityForResult(var1, PlusOneButton.this.abA);
         }

      }
   }

   public interface OnPlusOneClickListener {
      void onPlusOneClick(Intent var1);
   }
}
