package com.goodrx;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.multidex.MultiDexApplication;
import com.comscore.analytics.comScore;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.goodrx.model.DrugDetail;
import com.goodrx.model.RecentSearch;
import com.goodrx.utils.AccountInfoUtils;
import com.goodrx.utils.CacheHttpRequestHelper;
import com.goodrx.utils.DBManager;
import com.goodrx.utils.HistoryRecordOperator;
import com.goodrx.utils.InstallInfo;
import com.goodrx.utils.MyRxUtils;
import com.goodrx.utils.RatingPromptManager;
import com.goodrx.utils.locations.LocationUtils;
import com.goodrx.utils.tracker.ContainerHolderSingleton;
import com.goodrx.utils.tracker.GAHelper;
import com.goodrx.utils.tracker.Trackers;
import com.google.android.gms.analytics.ExceptionReporter;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.tagmanager.ContainerHolder;
import com.google.android.gms.tagmanager.TagManager;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.parse.Parse;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import net.danlew.android.joda.JodaTimeAndroid;

public class GrxApplication extends MultiDexApplication {
   private UncaughtExceptionHandler defaultExceptionHandler;

   public void initTagManager() {
      TagManager var1 = TagManager.getInstance(this);
      var1.setVerboseLoggingEnabled(true);
      var1.loadContainerPreferNonDefault("GTM-KB5665", 2131296257).setResultCallback(new ResultCallback() {
         public void onResult(ContainerHolder var1) {
            ContainerHolderSingleton.setContainerHolder(var1);
            if(var1.getStatus().isSuccess()) {
               ContainerHolderSingleton.setContainerHolder(var1);
               var1.setContainerAvailableListener(new ContainerHolder.ContainerAvailableListener() {
                  public void onContainerAvailable(ContainerHolder var1, String var2) {
                  }
               });
            }
         }
      }, 2L, TimeUnit.SECONDS);
   }

   public void initTrackers() {
      comScore.setAppContext(this.getApplicationContext());
      comScore.setCustomerC2("15965709");
      comScore.setPublisherSecret("2233f4d6c284b4c3fbadd366fa68a7b3");

      try {
         Parse.initialize(this, "C1qnTc561USMh2jmuYJQ4munrZczeLXrYo0AWYAm", "xKgFoJG5X6sgMTEnB3z2Vzg3WtWpIwXTdcVHLHVI");
         SharedPreferences var7 = PreferenceManager.getDefaultSharedPreferences(this);
         if(!var7.getBoolean("parse_initialized", false)) {
            Trackers.setParseInstallationData(this, true, true, true);
            var7.edit().putBoolean("parse_initialized", true).apply();
         }
      } catch (Exception var8) {
         ;
      }

      int var2 = InstallInfo.getLastVersion(this);
      if(68 > var2) {
         InstallInfo.setLastVersion(this, 68);
         if(var2 >= 26 && var2 <= 29) {
            if(AccountInfoUtils.getEmail(this) != null) {
               GAHelper.sendGoogleAnalyticsEvent(this, this.getString(2131427470), this.getString(2131427585), (String)null);
            } else if(MyRxUtils.getRx(this).length > 0) {
               GAHelper.sendGoogleAnalyticsEvent(this, this.getString(2131427470), this.getString(2131427580), (String)null);
            }
         }

         if(var2 >= 26 && var2 <= 33) {
            List var3 = HistoryRecordOperator.getDrugDetailList(this);
            if(var3 != null && var3.size() > 0) {
               ArrayList var4 = new ArrayList(var3.size());

               for(int var5 = 0; var5 < var3.size(); ++var5) {
                  var4.add(new RecentSearch((DrugDetail)var3.get(var5)));
               }

               HistoryRecordOperator.save(var4, this);
            }
         }

         if(var2 <= 33) {
            ImageLoader.getInstance().clearDiskCache();
            ImageLoader.getInstance().clearMemoryCache();
            MyRxUtils.clear(this);
         }

         if(var2 <= 61) {
            LocationUtils.clear(this);
            MyRxUtils.clearLocation(this);
         }

         (new DBManager(this)).clearAllCache();
         InstallInfo.setValid(this, false);
         (new RatingPromptManager(this)).reset();
      }

   }

   public void onCreate() {
      super.onCreate();
      DisplayImageOptions var1 = (new DisplayImageOptions.Builder()).showImageOnLoading(2130837674).showImageForEmptyUri(2130837715).showImageOnFail(2130837715).cacheInMemory(true).cacheOnDisk(true).build();
      ImageLoaderConfiguration var2 = (new ImageLoaderConfiguration.Builder(this.getApplicationContext())).defaultDisplayImageOptions(var1).diskCacheSize(31457280).build();
      ImageLoader.getInstance().init(var2);
      Fresco.initialize(this);
      CacheHttpRequestHelper.getInstance().init(this.getApplicationContext());
      this.initTrackers();
      this.initTagManager();
      JodaTimeAndroid.init(this);
      this.defaultExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
      Thread.setDefaultUncaughtExceptionHandler(new ExceptionReporter(GoogleAnalytics.getInstance(this).newTracker(2131230720), new GrxApplication.GrxExceptionHandler(null), this));
   }

   private class GrxExceptionHandler implements UncaughtExceptionHandler {
      private GrxExceptionHandler() {
      }

      // $FF: synthetic method
      GrxExceptionHandler(Object var2) {
         this();
      }

      public void uncaughtException(Thread var1, Throwable var2) {
         (new DBManager(GrxApplication.this)).clearAllCache();
         GrxApplication.this.defaultExceptionHandler.uncaughtException(var1, var2);
      }
   }
}
