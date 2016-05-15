package com.google.ads.conversiontracking;

import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.FeatureInfo;
import android.content.pm.InstrumentationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.UserHandle;
import com.google.ads.conversiontracking.class_77;
import com.google.ads.conversiontracking.class_78;
import com.google.ads.conversiontracking.class_83;
import java.io.IOException;
import java.util.List;

// $FF: renamed from: com.google.ads.conversiontracking.a
public class class_72 {
   // $FF: renamed from: a android.content.Context
   private Context field_545;

   public class_72(Context var1) {
      this.field_545 = new class_72.class_107(var1);
   }

   // $FF: renamed from: a () com.google.ads.conversiontracking.i$a
   public class_77.class_100 method_487() {
      try {
         class_77.class_100 var5 = class_77.method_519(this.field_545);
         return var5;
      } catch (IOException var6) {
         ;
      } catch (IllegalStateException var7) {
         ;
      } catch (class_78 var8) {
         ;
      } catch (class_83 var9) {
         ;
      }

      return null;
   }

   static class class_107 extends ContextWrapper {
      // $FF: renamed from: a com.google.ads.conversiontracking.a$b
      private final class_72.class_108 field_428;
      // $FF: renamed from: b com.google.ads.conversiontracking.a$c
      private final class_72.class_109 field_429;

      public class_107(Context var1) {
         super(var1);
         this.field_428 = new class_72.class_108(var1);
         this.field_429 = new class_72.class_109(var1.getResources());
      }

      public PackageManager getPackageManager() {
         return this.field_428;
      }

      public Resources getResources() {
         return this.field_429;
      }
   }

   static class class_108 extends PackageManager {
      // $FF: renamed from: a android.content.Context
      private final Context field_430;
      // $FF: renamed from: b android.content.pm.PackageManager
      private final PackageManager field_431;

      public class_108(Context var1) {
         this.field_430 = var1;
         this.field_431 = var1.getPackageManager();
      }

      public void addPackageToPreferred(String var1) {
         this.field_431.addPackageToPreferred(var1);
      }

      public boolean addPermission(PermissionInfo var1) {
         return this.field_431.addPermission(var1);
      }

      public boolean addPermissionAsync(PermissionInfo var1) {
         return this.field_431.addPermissionAsync(var1);
      }

      public void addPreferredActivity(IntentFilter var1, int var2, ComponentName[] var3, ComponentName var4) {
         this.field_431.addPreferredActivity(var1, var2, var3, var4);
      }

      public String[] canonicalToCurrentPackageNames(String[] var1) {
         return this.field_431.canonicalToCurrentPackageNames(var1);
      }

      public int checkPermission(String var1, String var2) {
         return this.field_431.checkPermission(var1, var2);
      }

      public int checkSignatures(int var1, int var2) {
         return this.field_431.checkSignatures(var1, var2);
      }

      public int checkSignatures(String var1, String var2) {
         return this.field_431.checkSignatures(var1, var2);
      }

      public void clearPackagePreferredActivities(String var1) {
         this.field_431.clearPackagePreferredActivities(var1);
      }

      public String[] currentToCanonicalPackageNames(String[] var1) {
         return this.field_431.currentToCanonicalPackageNames(var1);
      }

      public void extendVerificationTimeout(int var1, int var2, long var3) {
         this.field_431.extendVerificationTimeout(var1, var2, var3);
      }

      public Drawable getActivityBanner(ComponentName var1) throws NameNotFoundException {
         return this.field_431.getActivityBanner(var1);
      }

      public Drawable getActivityBanner(Intent var1) throws NameNotFoundException {
         return this.field_431.getActivityBanner(var1);
      }

      public Drawable getActivityIcon(ComponentName var1) throws NameNotFoundException {
         return this.field_431.getActivityIcon(var1);
      }

      public Drawable getActivityIcon(Intent var1) throws NameNotFoundException {
         return this.field_431.getActivityIcon(var1);
      }

      public ActivityInfo getActivityInfo(ComponentName var1, int var2) throws NameNotFoundException {
         return this.field_431.getActivityInfo(var1, var2);
      }

      public Drawable getActivityLogo(ComponentName var1) throws NameNotFoundException {
         return this.field_431.getActivityLogo(var1);
      }

      public Drawable getActivityLogo(Intent var1) throws NameNotFoundException {
         return this.field_431.getActivityLogo(var1);
      }

      public List<PermissionGroupInfo> getAllPermissionGroups(int var1) {
         return this.field_431.getAllPermissionGroups(var1);
      }

      public Drawable getApplicationBanner(ApplicationInfo var1) {
         return this.field_431.getApplicationBanner(var1);
      }

      public Drawable getApplicationBanner(String var1) throws NameNotFoundException {
         return this.field_431.getApplicationBanner(var1);
      }

      public int getApplicationEnabledSetting(String var1) {
         return this.field_431.getApplicationEnabledSetting(var1);
      }

      public Drawable getApplicationIcon(ApplicationInfo var1) {
         return this.field_431.getApplicationIcon(var1);
      }

      public Drawable getApplicationIcon(String var1) throws NameNotFoundException {
         return this.field_431.getApplicationIcon(var1);
      }

      public ApplicationInfo getApplicationInfo(String var1, int var2) throws NameNotFoundException {
         ApplicationInfo var3 = this.field_431.getApplicationInfo(var1, var2);
         if(var1.equals(this.field_430.getPackageName()) && (var2 & 128) == 128) {
            if(var3.metaData == null) {
               var3.metaData = new Bundle();
            }

            var3.metaData.putInt("com.google.android.gms.version", 4323000);
         }

         return var3;
      }

      public CharSequence getApplicationLabel(ApplicationInfo var1) {
         return this.field_431.getApplicationLabel(var1);
      }

      public Drawable getApplicationLogo(ApplicationInfo var1) {
         return this.field_431.getApplicationLogo(var1);
      }

      public Drawable getApplicationLogo(String var1) throws NameNotFoundException {
         return this.field_431.getApplicationLogo(var1);
      }

      public int getComponentEnabledSetting(ComponentName var1) {
         return this.field_431.getComponentEnabledSetting(var1);
      }

      public Drawable getDefaultActivityIcon() {
         return this.field_431.getDefaultActivityIcon();
      }

      public Drawable getDrawable(String var1, int var2, ApplicationInfo var3) {
         return this.field_431.getDrawable(var1, var2, var3);
      }

      public List<ApplicationInfo> getInstalledApplications(int var1) {
         return this.field_431.getInstalledApplications(var1);
      }

      public List<PackageInfo> getInstalledPackages(int var1) {
         return this.field_431.getInstalledPackages(var1);
      }

      public String getInstallerPackageName(String var1) {
         return this.field_431.getInstallerPackageName(var1);
      }

      public InstrumentationInfo getInstrumentationInfo(ComponentName var1, int var2) throws NameNotFoundException {
         return this.field_431.getInstrumentationInfo(var1, var2);
      }

      public Intent getLaunchIntentForPackage(String var1) {
         return this.field_431.getLaunchIntentForPackage(var1);
      }

      public Intent getLeanbackLaunchIntentForPackage(String var1) {
         return this.field_431.getLeanbackLaunchIntentForPackage(var1);
      }

      public String getNameForUid(int var1) {
         return this.field_431.getNameForUid(var1);
      }

      public int[] getPackageGids(String var1) throws NameNotFoundException {
         return this.field_431.getPackageGids(var1);
      }

      public PackageInfo getPackageInfo(String var1, int var2) throws NameNotFoundException {
         return this.field_431.getPackageInfo(var1, var2);
      }

      public PackageInstaller getPackageInstaller() {
         return this.field_431.getPackageInstaller();
      }

      public String[] getPackagesForUid(int var1) {
         return this.field_431.getPackagesForUid(var1);
      }

      public List<PackageInfo> getPackagesHoldingPermissions(String[] var1, int var2) {
         return this.field_431.getPackagesHoldingPermissions(var1, var2);
      }

      public PermissionGroupInfo getPermissionGroupInfo(String var1, int var2) throws NameNotFoundException {
         return this.field_431.getPermissionGroupInfo(var1, var2);
      }

      public PermissionInfo getPermissionInfo(String var1, int var2) throws NameNotFoundException {
         return this.field_431.getPermissionInfo(var1, var2);
      }

      public int getPreferredActivities(List<IntentFilter> var1, List<ComponentName> var2, String var3) {
         return this.field_431.getPreferredActivities(var1, var2, var3);
      }

      public List<PackageInfo> getPreferredPackages(int var1) {
         return this.field_431.getPreferredPackages(var1);
      }

      public ProviderInfo getProviderInfo(ComponentName var1, int var2) throws NameNotFoundException {
         return this.field_431.getProviderInfo(var1, var2);
      }

      public ActivityInfo getReceiverInfo(ComponentName var1, int var2) throws NameNotFoundException {
         return this.field_431.getReceiverInfo(var1, var2);
      }

      public Resources getResourcesForActivity(ComponentName var1) throws NameNotFoundException {
         return this.field_431.getResourcesForActivity(var1);
      }

      public Resources getResourcesForApplication(ApplicationInfo var1) throws NameNotFoundException {
         return this.field_431.getResourcesForApplication(var1);
      }

      public Resources getResourcesForApplication(String var1) throws NameNotFoundException {
         return this.field_431.getResourcesForApplication(var1);
      }

      public ServiceInfo getServiceInfo(ComponentName var1, int var2) throws NameNotFoundException {
         return this.field_431.getServiceInfo(var1, var2);
      }

      public FeatureInfo[] getSystemAvailableFeatures() {
         return this.field_431.getSystemAvailableFeatures();
      }

      public String[] getSystemSharedLibraryNames() {
         return this.field_431.getSystemSharedLibraryNames();
      }

      public CharSequence getText(String var1, int var2, ApplicationInfo var3) {
         return this.field_431.getText(var1, var2, var3);
      }

      public Drawable getUserBadgedDrawableForDensity(Drawable var1, UserHandle var2, Rect var3, int var4) {
         return this.field_431.getUserBadgedDrawableForDensity(var1, var2, var3, var4);
      }

      public Drawable getUserBadgedIcon(Drawable var1, UserHandle var2) {
         return this.field_431.getUserBadgedIcon(var1, var2);
      }

      public CharSequence getUserBadgedLabel(CharSequence var1, UserHandle var2) {
         return this.field_431.getUserBadgedLabel(var1, var2);
      }

      public XmlResourceParser getXml(String var1, int var2, ApplicationInfo var3) {
         return this.field_431.getXml(var1, var2, var3);
      }

      public boolean hasSystemFeature(String var1) {
         return this.field_431.hasSystemFeature(var1);
      }

      public boolean isSafeMode() {
         return this.field_431.isSafeMode();
      }

      public List<ResolveInfo> queryBroadcastReceivers(Intent var1, int var2) {
         return this.field_431.queryBroadcastReceivers(var1, var2);
      }

      public List<ProviderInfo> queryContentProviders(String var1, int var2, int var3) {
         return this.field_431.queryContentProviders(var1, var2, var3);
      }

      public List<InstrumentationInfo> queryInstrumentation(String var1, int var2) {
         return this.field_431.queryInstrumentation(var1, var2);
      }

      public List<ResolveInfo> queryIntentActivities(Intent var1, int var2) {
         return this.field_431.queryIntentActivities(var1, var2);
      }

      public List<ResolveInfo> queryIntentActivityOptions(ComponentName var1, Intent[] var2, Intent var3, int var4) {
         return this.field_431.queryIntentActivityOptions(var1, var2, var3, var4);
      }

      public List<ResolveInfo> queryIntentContentProviders(Intent var1, int var2) {
         return this.field_431.queryIntentContentProviders(var1, var2);
      }

      public List<ResolveInfo> queryIntentServices(Intent var1, int var2) {
         return this.field_431.queryIntentServices(var1, var2);
      }

      public List<PermissionInfo> queryPermissionsByGroup(String var1, int var2) throws NameNotFoundException {
         return this.field_431.queryPermissionsByGroup(var1, var2);
      }

      public void removePackageFromPreferred(String var1) {
         this.field_431.removePackageFromPreferred(var1);
      }

      public void removePermission(String var1) {
         this.field_431.removePermission(var1);
      }

      public ResolveInfo resolveActivity(Intent var1, int var2) {
         return this.field_431.resolveActivity(var1, var2);
      }

      public ProviderInfo resolveContentProvider(String var1, int var2) {
         return this.field_431.resolveContentProvider(var1, var2);
      }

      public ResolveInfo resolveService(Intent var1, int var2) {
         return this.field_431.resolveService(var1, var2);
      }

      public void setApplicationEnabledSetting(String var1, int var2, int var3) {
         this.field_431.setApplicationEnabledSetting(var1, var2, var3);
      }

      public void setComponentEnabledSetting(ComponentName var1, int var2, int var3) {
         this.field_431.setComponentEnabledSetting(var1, var2, var3);
      }

      public void setInstallerPackageName(String var1, String var2) {
         this.field_431.setInstallerPackageName(var1, var2);
      }

      public void verifyPendingInstall(int var1, int var2) {
         this.field_431.verifyPendingInstall(var1, var2);
      }
   }

   static class class_109 extends Resources {
      public class_109(Resources var1) {
         super(var1.getAssets(), var1.getDisplayMetrics(), var1.getConfiguration());
      }

      public String getString(int var1) {
         return "";
      }
   }
}
