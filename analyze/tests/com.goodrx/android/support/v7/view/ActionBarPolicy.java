package android.support.v7.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v7.appcompat.class_22;
import android.util.AttributeSet;
import android.view.ViewConfiguration;

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
      return this.mContext.getResources().getInteger(class_22.integer.abc_max_action_buttons);
   }

   public int getStackedTabMaxWidth() {
      return this.mContext.getResources().getDimensionPixelSize(class_22.dimen.abc_action_bar_stacked_tab_max_width);
   }

   public int getTabContainerHeight() {
      TypedArray var1 = this.mContext.obtainStyledAttributes((AttributeSet)null, class_22.styleable.ActionBar, class_22.attr.actionBarStyle, 0);
      int var2 = var1.getLayoutDimension(class_22.styleable.ActionBar_height, 0);
      Resources var3 = this.mContext.getResources();
      if(!this.hasEmbeddedTabs()) {
         var2 = Math.min(var2, var3.getDimensionPixelSize(class_22.dimen.abc_action_bar_stacked_max_height));
      }

      var1.recycle();
      return var2;
   }

   public boolean hasEmbeddedTabs() {
      return this.mContext.getApplicationInfo().targetSdkVersion >= 16?this.mContext.getResources().getBoolean(class_22.bool.abc_action_bar_embed_tabs):this.mContext.getResources().getBoolean(class_22.bool.abc_action_bar_embed_tabs_pre_jb);
   }

   public boolean showsOverflowMenuButton() {
      return VERSION.SDK_INT >= 19 || !ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(this.mContext));
   }
}
