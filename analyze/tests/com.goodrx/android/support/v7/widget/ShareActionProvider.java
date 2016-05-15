package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.support.v4.view.ActionProvider;
import android.support.v7.appcompat.class_22;
import android.support.v7.widget.ActivityChooserModel;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.AppCompatDrawableManager;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.MenuItem.OnMenuItemClickListener;

public class ShareActionProvider extends ActionProvider {
   private static final int DEFAULT_INITIAL_ACTIVITY_COUNT = 4;
   public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";
   private final Context mContext;
   private int mMaxShownActivityCount = 4;
   private ActivityChooserModel.OnChooseActivityListener mOnChooseActivityListener;
   private final ShareActionProvider.ShareMenuItemOnMenuItemClickListener mOnMenuItemClickListener = new ShareActionProvider.ShareMenuItemOnMenuItemClickListener();
   private ShareActionProvider.OnShareTargetSelectedListener mOnShareTargetSelectedListener;
   private String mShareHistoryFileName = "share_history.xml";

   public ShareActionProvider(Context var1) {
      super(var1);
      this.mContext = var1;
   }

   private void setActivityChooserPolicyIfNeeded() {
      if(this.mOnShareTargetSelectedListener != null) {
         if(this.mOnChooseActivityListener == null) {
            this.mOnChooseActivityListener = new ShareActionProvider.ShareActivityChooserModelPolicy();
         }

         ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName).setOnChooseActivityListener(this.mOnChooseActivityListener);
      }
   }

   private void updateIntent(Intent var1) {
      if(VERSION.SDK_INT >= 21) {
         var1.addFlags(134742016);
      } else {
         var1.addFlags(524288);
      }
   }

   public boolean hasSubMenu() {
      return true;
   }

   public View onCreateActionView() {
      ActivityChooserView var1 = new ActivityChooserView(this.mContext);
      if(!var1.isInEditMode()) {
         var1.setActivityChooserModel(ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName));
      }

      TypedValue var2 = new TypedValue();
      this.mContext.getTheme().resolveAttribute(class_22.attr.actionModeShareDrawable, var2, true);
      var1.setExpandActivityOverflowButtonDrawable(AppCompatDrawableManager.get().getDrawable(this.mContext, var2.resourceId));
      var1.setProvider(this);
      var1.setDefaultActionButtonContentDescription(class_22.string.abc_shareactionprovider_share_with_application);
      var1.setExpandActivityOverflowButtonContentDescription(class_22.string.abc_shareactionprovider_share_with);
      return var1;
   }

   public void onPrepareSubMenu(SubMenu var1) {
      var1.clear();
      ActivityChooserModel var2 = ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName);
      PackageManager var3 = this.mContext.getPackageManager();
      int var4 = var2.getActivityCount();
      int var5 = Math.min(var4, this.mMaxShownActivityCount);

      for(int var6 = 0; var6 < var5; ++var6) {
         ResolveInfo var11 = var2.getActivity(var6);
         var1.add(0, var6, var6, var11.loadLabel(var3)).setIcon(var11.loadIcon(var3)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
      }

      if(var5 < var4) {
         SubMenu var7 = var1.addSubMenu(0, var5, var5, this.mContext.getString(class_22.string.abc_activity_chooser_view_see_all));

         for(int var8 = 0; var8 < var4; ++var8) {
            ResolveInfo var9 = var2.getActivity(var8);
            var7.add(0, var8, var8, var9.loadLabel(var3)).setIcon(var9.loadIcon(var3)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
         }
      }

   }

   public void setOnShareTargetSelectedListener(ShareActionProvider.OnShareTargetSelectedListener var1) {
      this.mOnShareTargetSelectedListener = var1;
      this.setActivityChooserPolicyIfNeeded();
   }

   public void setShareHistoryFileName(String var1) {
      this.mShareHistoryFileName = var1;
      this.setActivityChooserPolicyIfNeeded();
   }

   public void setShareIntent(Intent var1) {
      if(var1 != null) {
         String var2 = var1.getAction();
         if("android.intent.action.SEND".equals(var2) || "android.intent.action.SEND_MULTIPLE".equals(var2)) {
            this.updateIntent(var1);
         }
      }

      ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName).setIntent(var1);
   }

   public interface OnShareTargetSelectedListener {
      boolean onShareTargetSelected(ShareActionProvider var1, Intent var2);
   }

   private class ShareActivityChooserModelPolicy implements ActivityChooserModel.OnChooseActivityListener {
      private ShareActivityChooserModelPolicy() {
      }

      // $FF: synthetic method
      ShareActivityChooserModelPolicy(Object var2) {
         this();
      }

      public boolean onChooseActivity(ActivityChooserModel var1, Intent var2) {
         if(ShareActionProvider.this.mOnShareTargetSelectedListener != null) {
            ShareActionProvider.this.mOnShareTargetSelectedListener.onShareTargetSelected(ShareActionProvider.this, var2);
         }

         return false;
      }
   }

   private class ShareMenuItemOnMenuItemClickListener implements OnMenuItemClickListener {
      private ShareMenuItemOnMenuItemClickListener() {
      }

      // $FF: synthetic method
      ShareMenuItemOnMenuItemClickListener(Object var2) {
         this();
      }

      public boolean onMenuItemClick(MenuItem var1) {
         Intent var2 = ActivityChooserModel.get(ShareActionProvider.this.mContext, ShareActionProvider.this.mShareHistoryFileName).chooseActivity(var1.getItemId());
         if(var2 != null) {
            String var3 = var2.getAction();
            if("android.intent.action.SEND".equals(var3) || "android.intent.action.SEND_MULTIPLE".equals(var3)) {
               ShareActionProvider.this.updateIntent(var2);
            }

            ShareActionProvider.this.mContext.startActivity(var2);
         }

         return true;
      }
   }
}
