package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.DraweeView;
import javax.annotation.Nullable;

public class GenericDraweeView extends DraweeView<GenericDraweeHierarchy> {
   public GenericDraweeView(Context var1) {
      super(var1);
      this.inflateHierarchy(var1, (AttributeSet)null);
   }

   public GenericDraweeView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.inflateHierarchy(var1, var2);
   }

   public GenericDraweeView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.inflateHierarchy(var1, var2);
   }

   @TargetApi(21)
   public GenericDraweeView(Context var1, AttributeSet var2, int var3, int var4) {
      super(var1, var2, var3, var4);
      this.inflateHierarchy(var1, var2);
   }

   public GenericDraweeView(Context var1, GenericDraweeHierarchy var2) {
      super(var1);
      this.setHierarchy(var2);
   }

   private static ScalingUtils.ScaleType getScaleTypeFromXml(TypedArray var0, int var1, ScalingUtils.ScaleType var2) {
      int var3 = var0.getInt(var1, -1);
      return var3 < 0?var2:ScalingUtils.ScaleType.values()[var3];
   }

   private void inflateHierarchy(Context param1, @Nullable AttributeSet param2) {
      // $FF: Couldn't be decompiled
   }
}
