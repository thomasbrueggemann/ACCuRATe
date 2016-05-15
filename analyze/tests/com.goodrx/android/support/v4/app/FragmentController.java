package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentHostCallback;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.util.SimpleArrayMap;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FragmentController {
   private final FragmentHostCallback<?> mHost;

   private FragmentController(FragmentHostCallback<?> var1) {
      this.mHost = var1;
   }

   public static final FragmentController createController(FragmentHostCallback<?> var0) {
      return new FragmentController(var0);
   }

   public void attachHost(Fragment var1) {
      this.mHost.mFragmentManager.attachController(this.mHost, this.mHost, var1);
   }

   public void dispatchActivityCreated() {
      this.mHost.mFragmentManager.dispatchActivityCreated();
   }

   public void dispatchConfigurationChanged(Configuration var1) {
      this.mHost.mFragmentManager.dispatchConfigurationChanged(var1);
   }

   public boolean dispatchContextItemSelected(MenuItem var1) {
      return this.mHost.mFragmentManager.dispatchContextItemSelected(var1);
   }

   public void dispatchCreate() {
      this.mHost.mFragmentManager.dispatchCreate();
   }

   public boolean dispatchCreateOptionsMenu(Menu var1, MenuInflater var2) {
      return this.mHost.mFragmentManager.dispatchCreateOptionsMenu(var1, var2);
   }

   public void dispatchDestroy() {
      this.mHost.mFragmentManager.dispatchDestroy();
   }

   public void dispatchDestroyView() {
      this.mHost.mFragmentManager.dispatchDestroyView();
   }

   public void dispatchLowMemory() {
      this.mHost.mFragmentManager.dispatchLowMemory();
   }

   public boolean dispatchOptionsItemSelected(MenuItem var1) {
      return this.mHost.mFragmentManager.dispatchOptionsItemSelected(var1);
   }

   public void dispatchOptionsMenuClosed(Menu var1) {
      this.mHost.mFragmentManager.dispatchOptionsMenuClosed(var1);
   }

   public void dispatchPause() {
      this.mHost.mFragmentManager.dispatchPause();
   }

   public boolean dispatchPrepareOptionsMenu(Menu var1) {
      return this.mHost.mFragmentManager.dispatchPrepareOptionsMenu(var1);
   }

   public void dispatchReallyStop() {
      this.mHost.mFragmentManager.dispatchReallyStop();
   }

   public void dispatchResume() {
      this.mHost.mFragmentManager.dispatchResume();
   }

   public void dispatchStart() {
      this.mHost.mFragmentManager.dispatchStart();
   }

   public void dispatchStop() {
      this.mHost.mFragmentManager.dispatchStop();
   }

   public void doLoaderDestroy() {
      this.mHost.doLoaderDestroy();
   }

   public void doLoaderRetain() {
      this.mHost.doLoaderRetain();
   }

   public void doLoaderStart() {
      this.mHost.doLoaderStart();
   }

   public void doLoaderStop(boolean var1) {
      this.mHost.doLoaderStop(var1);
   }

   public void dumpLoaders(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
      this.mHost.dumpLoaders(var1, var2, var3, var4);
   }

   public boolean execPendingActions() {
      return this.mHost.mFragmentManager.execPendingActions();
   }

   @Nullable
   Fragment findFragmentByWho(String var1) {
      return this.mHost.mFragmentManager.findFragmentByWho(var1);
   }

   public List<Fragment> getActiveFragments(List<Fragment> var1) {
      if(this.mHost.mFragmentManager.mActive == null) {
         return null;
      } else {
         if(var1 == null) {
            var1 = new ArrayList(this.getActiveFragmentsCount());
         }

         ((List)var1).addAll(this.mHost.mFragmentManager.mActive);
         return (List)var1;
      }
   }

   public int getActiveFragmentsCount() {
      ArrayList var1 = this.mHost.mFragmentManager.mActive;
      return var1 == null?0:var1.size();
   }

   public FragmentManager getSupportFragmentManager() {
      return this.mHost.getFragmentManagerImpl();
   }

   public LoaderManager getSupportLoaderManager() {
      return this.mHost.getLoaderManagerImpl();
   }

   public void noteStateNotSaved() {
      this.mHost.mFragmentManager.noteStateNotSaved();
   }

   public View onCreateView(View var1, String var2, Context var3, AttributeSet var4) {
      return this.mHost.mFragmentManager.onCreateView(var1, var2, var3, var4);
   }

   public void reportLoaderStart() {
      this.mHost.reportLoaderStart();
   }

   public void restoreAllState(Parcelable var1, List<Fragment> var2) {
      this.mHost.mFragmentManager.restoreAllState(var1, var2);
   }

   public void restoreLoaderNonConfig(SimpleArrayMap<String, LoaderManager> var1) {
      this.mHost.restoreLoaderNonConfig(var1);
   }

   public SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig() {
      return this.mHost.retainLoaderNonConfig();
   }

   public List<Fragment> retainNonConfig() {
      return this.mHost.mFragmentManager.retainNonConfig();
   }

   public Parcelable saveAllState() {
      return this.mHost.mFragmentManager.saveAllState();
   }
}
