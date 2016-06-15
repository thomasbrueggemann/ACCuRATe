package android.support.v7.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivityDelegate;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class ActionBarActivity extends FragmentActivity implements ActionBar.Callback, TaskStackBuilder.SupportParentable, ActionBarDrawerToggle.DelegateProvider {
   ActionBarActivityDelegate mImpl;

   public void addContentView(View var1, LayoutParams var2) {
      this.mImpl.addContentView(var1, var2);
   }

   public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
      return this.mImpl.getDrawerToggleDelegate();
   }

   public MenuInflater getMenuInflater() {
      return this.mImpl.getMenuInflater();
   }

   public ActionBar getSupportActionBar() {
      return this.mImpl.getSupportActionBar();
   }

   public Intent getSupportParentActivityIntent() {
      return NavUtils.getParentActivityIntent(this);
   }

   public void onBackPressed() {
      if(!this.mImpl.onBackPressed()) {
         super.onBackPressed();
      }

   }

   public void onConfigurationChanged(Configuration var1) {
      super.onConfigurationChanged(var1);
      this.mImpl.onConfigurationChanged(var1);
   }

   public final void onContentChanged() {
      this.mImpl.onContentChanged();
   }

   protected void onCreate(Bundle var1) {
      this.mImpl = ActionBarActivityDelegate.createDelegate(this);
      super.onCreate(var1);
      this.mImpl.onCreate(var1);
   }

   public boolean onCreatePanelMenu(int var1, Menu var2) {
      return this.mImpl.onCreatePanelMenu(var1, var2);
   }

   public View onCreatePanelView(int var1) {
      return var1 == 0?this.mImpl.onCreatePanelView(var1):super.onCreatePanelView(var1);
   }

   public void onCreateSupportNavigateUpTaskStack(TaskStackBuilder var1) {
      var1.addParentStack((Activity)this);
   }

   public final boolean onMenuItemSelected(int var1, MenuItem var2) {
      if(this.mImpl.onMenuItemSelected(var1, var2)) {
         return true;
      } else {
         ActionBar var3 = this.getSupportActionBar();
         return var2.getItemId() == 16908332 && var3 != null && (4 & var3.getDisplayOptions()) != 0?this.onSupportNavigateUp():false;
      }
   }

   protected void onPostResume() {
      super.onPostResume();
      this.mImpl.onPostResume();
   }

   protected boolean onPrepareOptionsPanel(View var1, Menu var2) {
      return this.mImpl.onPrepareOptionsPanel(var1, var2);
   }

   public boolean onPreparePanel(int var1, View var2, Menu var3) {
      return this.mImpl.onPreparePanel(var1, var2, var3);
   }

   public void onPrepareSupportNavigateUpTaskStack(TaskStackBuilder var1) {
   }

   protected void onStop() {
      super.onStop();
      this.mImpl.onStop();
   }

   public void onSupportActionModeFinished(ActionMode var1) {
   }

   public void onSupportActionModeStarted(ActionMode var1) {
   }

   public void onSupportContentChanged() {
   }

   public boolean onSupportNavigateUp() {
      Intent var1 = this.getSupportParentActivityIntent();
      if(var1 != null) {
         if(this.supportShouldUpRecreateTask(var1)) {
            TaskStackBuilder var2 = TaskStackBuilder.create(this);
            this.onCreateSupportNavigateUpTaskStack(var2);
            this.onPrepareSupportNavigateUpTaskStack(var2);
            var2.startActivities();

            try {
               ActivityCompat.finishAffinity(this);
            } catch (IllegalStateException var4) {
               this.finish();
            }
         } else {
            this.supportNavigateUpTo(var1);
         }

         return true;
      } else {
         return false;
      }
   }

   protected void onTitleChanged(CharSequence var1, int var2) {
      super.onTitleChanged(var1, var2);
      this.mImpl.onTitleChanged(var1);
   }

   public void setContentView(int var1) {
      this.mImpl.setContentView(var1);
   }

   public void setContentView(View var1) {
      this.mImpl.setContentView(var1);
   }

   public void setContentView(View var1, LayoutParams var2) {
      this.mImpl.setContentView(var1, var2);
   }

   public void setSupportProgress(int var1) {
      this.mImpl.setSupportProgress(var1);
   }

   public void setSupportProgressBarIndeterminate(boolean var1) {
      this.mImpl.setSupportProgressBarIndeterminate(var1);
   }

   public void setSupportProgressBarIndeterminateVisibility(boolean var1) {
      this.mImpl.setSupportProgressBarIndeterminateVisibility(var1);
   }

   public void setSupportProgressBarVisibility(boolean var1) {
      this.mImpl.setSupportProgressBarVisibility(var1);
   }

   public ActionMode startSupportActionMode(ActionMode.Callback var1) {
      return this.mImpl.startSupportActionMode(var1);
   }

   void superAddContentView(View var1, LayoutParams var2) {
      super.addContentView(var1, var2);
   }

   boolean superOnCreatePanelMenu(int var1, Menu var2) {
      return super.onCreatePanelMenu(var1, var2);
   }

   boolean superOnMenuItemSelected(int var1, MenuItem var2) {
      return super.onMenuItemSelected(var1, var2);
   }

   boolean superOnPrepareOptionsPanel(View var1, Menu var2) {
      return super.onPrepareOptionsPanel(var1, var2);
   }

   boolean superOnPreparePanel(int var1, View var2, Menu var3) {
      return super.onPreparePanel(var1, var2, var3);
   }

   void superSetContentView(int var1) {
      super.setContentView(var1);
   }

   void superSetContentView(View var1) {
      super.setContentView(var1);
   }

   void superSetContentView(View var1, LayoutParams var2) {
      super.setContentView(var1, var2);
   }

   public void supportInvalidateOptionsMenu() {
      if(VERSION.SDK_INT >= 14) {
         super.supportInvalidateOptionsMenu();
      }

      this.mImpl.supportInvalidateOptionsMenu();
   }

   public void supportNavigateUpTo(Intent var1) {
      NavUtils.navigateUpTo(this, var1);
   }

   public boolean supportRequestWindowFeature(int var1) {
      return this.mImpl.supportRequestWindowFeature(var1);
   }

   public boolean supportShouldUpRecreateTask(Intent var1) {
      return NavUtils.shouldUpRecreateTask(this, var1);
   }
}
