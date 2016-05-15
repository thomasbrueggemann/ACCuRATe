package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder;
import com.facebook.drawee.view.GenericDraweeView;
import javax.annotation.Nullable;

public class SimpleDraweeView extends GenericDraweeView {
   private static Supplier<? extends SimpleDraweeControllerBuilder> sDraweeControllerBuilderSupplier;
   private SimpleDraweeControllerBuilder mSimpleDraweeControllerBuilder;

   public SimpleDraweeView(Context var1) {
      super(var1);
      this.init();
   }

   public SimpleDraweeView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init();
   }

   public SimpleDraweeView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init();
   }

   @TargetApi(21)
   public SimpleDraweeView(Context var1, AttributeSet var2, int var3, int var4) {
      super(var1, var2, var3, var4);
      this.init();
   }

   public SimpleDraweeView(Context var1, GenericDraweeHierarchy var2) {
      super(var1, var2);
      this.init();
   }

   private void init() {
      if(!this.isInEditMode()) {
         Preconditions.checkNotNull(sDraweeControllerBuilderSupplier, "SimpleDraweeView was not initialized!");
         this.mSimpleDraweeControllerBuilder = (SimpleDraweeControllerBuilder)sDraweeControllerBuilderSupplier.get();
      }
   }

   public static void initialize(Supplier<? extends SimpleDraweeControllerBuilder> var0) {
      sDraweeControllerBuilderSupplier = var0;
   }

   public static void shutDown() {
      sDraweeControllerBuilderSupplier = null;
   }

   protected SimpleDraweeControllerBuilder getControllerBuilder() {
      return this.mSimpleDraweeControllerBuilder;
   }

   public void setImageURI(Uri var1) {
      this.setImageURI(var1, (Object)null);
   }

   public void setImageURI(Uri var1, @Nullable Object var2) {
      this.setController(this.mSimpleDraweeControllerBuilder.setCallerContext(var2).setUri(var1).setOldController(this.getController()).build());
   }
}
