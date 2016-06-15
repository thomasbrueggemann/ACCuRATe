package android.support.v7.internal.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.appcompat.class_639;
import android.util.AttributeSet;

public class ActionBarPolicy {
   private Context mContext;

   private ActionBarPolicy(Context var1) {
      this.mContext = var1;
   }

   public static ActionBarPolicy get(Context var0) {
      return new ActionBarPolicy(var0);
   }

   public boolean enableHomeButtonByDefault() {
      return this.mContext.getApplicationInfo().targetSdkVersion < 14;
   }

   public int getEmbeddedMenuWidthLimit() {
      return this.mContext.getResources().getDisplayMetrics().widthPixels / 2;
   }

   public int getMaxActionButtons() {
      return this.mContext.getResources().getInteger(class_639.integer.abc_max_action_buttons);
   }

   public int getStackedTabMaxWidth() {
      return this.mContext.getResources().getDimensionPixelSize(class_639.dimen.abc_action_bar_stacked_tab_max_width);
   }

   public int getTabContainerHeight() {
      TypedArray var1 = this.mContext.obtainStyledAttributes((AttributeSet)null, class_639.styleable.ActionBar, class_639.attr.actionBarStyle, 0);
      int var2 = var1.getLayoutDimension(1, 0);
      Resources var3 = this.mContext.getResources();
      if(!this.hasEmbeddedTabs()) {
         var2 = Math.min(var2, var3.getDimensionPixelSize(class_639.dimen.abc_action_bar_stacked_max_height));
      }

      var1.recycle();
      return var2;
   }

   public boolean hasEmbeddedTabs() {
      return this.mContext.getResources().getBoolean(class_639.bool.abc_action_bar_embed_tabs_pre_jb);
   }

   public boolean showsOverflowMenuButton() {
      return VERSION.SDK_INT >= 11;
   }
}
