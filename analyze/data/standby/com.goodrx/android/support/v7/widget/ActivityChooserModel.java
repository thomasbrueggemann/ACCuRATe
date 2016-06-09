package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.support.v4.os.AsyncTaskCompat;
import android.text.TextUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ActivityChooserModel extends DataSetObservable {
   private static final String ATTRIBUTE_ACTIVITY = "activity";
   private static final String ATTRIBUTE_TIME = "time";
   private static final String ATTRIBUTE_WEIGHT = "weight";
   private static final boolean DEBUG = false;
   private static final int DEFAULT_ACTIVITY_INFLATION = 5;
   private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0F;
   public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
   public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
   private static final String HISTORY_FILE_EXTENSION = ".xml";
   private static final int INVALID_INDEX = -1;
   private static final String LOG_TAG = ActivityChooserModel.class.getSimpleName();
   private static final String TAG_HISTORICAL_RECORD = "historical-record";
   private static final String TAG_HISTORICAL_RECORDS = "historical-records";
   private static final Map<String, ActivityChooserModel> sDataModelRegistry = new HashMap();
   private static final Object sRegistryLock = new Object();
   private final List<ActivityChooserModel.ActivityResolveInfo> mActivities = new ArrayList();
   private ActivityChooserModel.OnChooseActivityListener mActivityChoserModelPolicy;
   private ActivityChooserModel.ActivitySorter mActivitySorter = new ActivityChooserModel.DefaultSorter();
   private boolean mCanReadHistoricalData = true;
   private final Context mContext;
   private final List<ActivityChooserModel.HistoricalRecord> mHistoricalRecords = new ArrayList();
   private boolean mHistoricalRecordsChanged = true;
   private final String mHistoryFileName;
   private int mHistoryMaxSize = 50;
   private final Object mInstanceLock = new Object();
   private Intent mIntent;
   private boolean mReadShareHistoryCalled = false;
   private boolean mReloadActivities = false;

   private ActivityChooserModel(Context var1, String var2) {
      this.mContext = var1.getApplicationContext();
      if(!TextUtils.isEmpty(var2) && !var2.endsWith(".xml")) {
         this.mHistoryFileName = var2 + ".xml";
      } else {
         this.mHistoryFileName = var2;
      }
   }

   // $FF: synthetic method
   static Context access$200(ActivityChooserModel var0) {
      return var0.mContext;
   }

   // $FF: synthetic method
   static String access$300() {
      return LOG_TAG;
   }

   // $FF: synthetic method
   static String access$400(ActivityChooserModel var0) {
      return var0.mHistoryFileName;
   }

   // $FF: synthetic method
   static boolean access$502(ActivityChooserModel var0, boolean var1) {
      var0.mCanReadHistoricalData = var1;
      return var1;
   }

   private boolean addHisoricalRecord(ActivityChooserModel.HistoricalRecord var1) {
      boolean var2 = this.mHistoricalRecords.add(var1);
      if(var2) {
         this.mHistoricalRecordsChanged = true;
         this.pruneExcessiveHistoricalRecordsIfNeeded();
         this.persistHistoricalDataIfNeeded();
         this.sortActivitiesIfNeeded();
         this.notifyChanged();
      }

      return var2;
   }

   private void ensureConsistentState() {
      boolean var1 = this.loadActivitiesIfNeeded() | this.readHistoricalDataIfNeeded();
      this.pruneExcessiveHistoricalRecordsIfNeeded();
      if(var1) {
         this.sortActivitiesIfNeeded();
         this.notifyChanged();
      }

   }

   public static ActivityChooserModel get(Context param0, String param1) {
      // $FF: Couldn't be decompiled
   }

   private boolean loadActivitiesIfNeeded() {
      boolean var1 = this.mReloadActivities;
      boolean var2 = false;
      if(var1) {
         Intent var3 = this.mIntent;
         var2 = false;
         if(var3 != null) {
            this.mReloadActivities = false;
            this.mActivities.clear();
            List var4 = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
            int var5 = var4.size();

            for(int var6 = 0; var6 < var5; ++var6) {
               ResolveInfo var7 = (ResolveInfo)var4.get(var6);
               this.mActivities.add(new ActivityChooserModel.ActivityResolveInfo(var7));
            }

            var2 = true;
         }
      }

      return var2;
   }

   private void persistHistoricalDataIfNeeded() {
      if(!this.mReadShareHistoryCalled) {
         throw new IllegalStateException("No preceding call to #readHistoricalData");
      } else {
         if(this.mHistoricalRecordsChanged) {
            this.mHistoricalRecordsChanged = false;
            if(!TextUtils.isEmpty(this.mHistoryFileName)) {
               ActivityChooserModel.PersistHistoryAsyncTask var1 = new ActivityChooserModel.PersistHistoryAsyncTask();
               Object[] var2 = new Object[]{new ArrayList(this.mHistoricalRecords), this.mHistoryFileName};
               AsyncTaskCompat.executeParallel(var1, var2);
               return;
            }
         }

      }
   }

   private void pruneExcessiveHistoricalRecordsIfNeeded() {
      int var1 = this.mHistoricalRecords.size() - this.mHistoryMaxSize;
      if(var1 > 0) {
         this.mHistoricalRecordsChanged = true;

         for(int var2 = 0; var2 < var1; ++var2) {
            ActivityChooserModel.HistoricalRecord var10000 = (ActivityChooserModel.HistoricalRecord)this.mHistoricalRecords.remove(0);
         }
      }

   }

   private boolean readHistoricalDataIfNeeded() {
      if(this.mCanReadHistoricalData && this.mHistoricalRecordsChanged && !TextUtils.isEmpty(this.mHistoryFileName)) {
         this.mCanReadHistoricalData = false;
         this.mReadShareHistoryCalled = true;
         this.readHistoricalDataImpl();
         return true;
      } else {
         return false;
      }
   }

   private void readHistoricalDataImpl() {
      // $FF: Couldn't be decompiled
   }

   private boolean sortActivitiesIfNeeded() {
      if(this.mActivitySorter != null && this.mIntent != null && !this.mActivities.isEmpty() && !this.mHistoricalRecords.isEmpty()) {
         this.mActivitySorter.sort(this.mIntent, this.mActivities, Collections.unmodifiableList(this.mHistoricalRecords));
         return true;
      } else {
         return false;
      }
   }

   public Intent chooseActivity(int param1) {
      // $FF: Couldn't be decompiled
   }

   public ResolveInfo getActivity(int param1) {
      // $FF: Couldn't be decompiled
   }

   public int getActivityCount() {
      // $FF: Couldn't be decompiled
   }

   public int getActivityIndex(ResolveInfo param1) {
      // $FF: Couldn't be decompiled
   }

   public ResolveInfo getDefaultActivity() {
      // $FF: Couldn't be decompiled
   }

   public int getHistoryMaxSize() {
      // $FF: Couldn't be decompiled
   }

   public int getHistorySize() {
      // $FF: Couldn't be decompiled
   }

   public Intent getIntent() {
      // $FF: Couldn't be decompiled
   }

   public void setActivitySorter(ActivityChooserModel.ActivitySorter param1) {
      // $FF: Couldn't be decompiled
   }

   public void setDefaultActivity(int param1) {
      // $FF: Couldn't be decompiled
   }

   public void setHistoryMaxSize(int param1) {
      // $FF: Couldn't be decompiled
   }

   public void setIntent(Intent param1) {
      // $FF: Couldn't be decompiled
   }

   public void setOnChooseActivityListener(ActivityChooserModel.OnChooseActivityListener param1) {
      // $FF: Couldn't be decompiled
   }

   public interface ActivityChooserModelClient {
      void setActivityChooserModel(ActivityChooserModel var1);
   }

   public final class ActivityResolveInfo implements Comparable<ActivityChooserModel.ActivityResolveInfo> {
      public final ResolveInfo resolveInfo;
      public float weight;

      public ActivityResolveInfo(ResolveInfo var2) {
         this.resolveInfo = var2;
      }

      public int compareTo(ActivityChooserModel.ActivityResolveInfo var1) {
         return Float.floatToIntBits(var1.weight) - Float.floatToIntBits(this.weight);
      }

      public boolean equals(Object var1) {
         if(this != var1) {
            if(var1 == null) {
               return false;
            }

            if(this.getClass() != var1.getClass()) {
               return false;
            }

            ActivityChooserModel.ActivityResolveInfo var2 = (ActivityChooserModel.ActivityResolveInfo)var1;
            if(Float.floatToIntBits(this.weight) != Float.floatToIntBits(var2.weight)) {
               return false;
            }
         }

         return true;
      }

      public int hashCode() {
         return 31 + Float.floatToIntBits(this.weight);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder();
         var1.append("[");
         var1.append("resolveInfo:").append(this.resolveInfo.toString());
         var1.append("; weight:").append(new BigDecimal((double)this.weight));
         var1.append("]");
         return var1.toString();
      }
   }

   public interface ActivitySorter {
      void sort(Intent var1, List<ActivityChooserModel.ActivityResolveInfo> var2, List<ActivityChooserModel.HistoricalRecord> var3);
   }

   private final class DefaultSorter implements ActivityChooserModel.ActivitySorter {
      private static final float WEIGHT_DECAY_COEFFICIENT = 0.95F;
      private final Map<ComponentName, ActivityChooserModel.ActivityResolveInfo> mPackageNameToActivityMap;

      private DefaultSorter() {
         this.mPackageNameToActivityMap = new HashMap();
      }

      // $FF: synthetic method
      DefaultSorter(Object var2) {
         this();
      }

      public void sort(Intent var1, List<ActivityChooserModel.ActivityResolveInfo> var2, List<ActivityChooserModel.HistoricalRecord> var3) {
         Map var4 = this.mPackageNameToActivityMap;
         var4.clear();
         int var5 = var2.size();

         for(int var6 = 0; var6 < var5; ++var6) {
            ActivityChooserModel.ActivityResolveInfo var12 = (ActivityChooserModel.ActivityResolveInfo)var2.get(var6);
            var12.weight = 0.0F;
            var4.put(new ComponentName(var12.resolveInfo.activityInfo.packageName, var12.resolveInfo.activityInfo.name), var12);
         }

         int var7 = -1 + var3.size();
         float var8 = 1.0F;

         for(int var9 = var7; var9 >= 0; --var9) {
            ActivityChooserModel.HistoricalRecord var10 = (ActivityChooserModel.HistoricalRecord)var3.get(var9);
            ActivityChooserModel.ActivityResolveInfo var11 = (ActivityChooserModel.ActivityResolveInfo)var4.get(var10.activity);
            if(var11 != null) {
               var11.weight += var8 * var10.weight;
               var8 *= 0.95F;
            }
         }

         Collections.sort(var2);
      }
   }

   public static final class HistoricalRecord {
      public final ComponentName activity;
      public final long time;
      public final float weight;

      public HistoricalRecord(ComponentName var1, long var2, float var4) {
         this.activity = var1;
         this.time = var2;
         this.weight = var4;
      }

      public HistoricalRecord(String var1, long var2, float var4) {
         this(ComponentName.unflattenFromString(var1), var2, var4);
      }

      public boolean equals(Object var1) {
         if(this != var1) {
            if(var1 == null) {
               return false;
            }

            if(this.getClass() != var1.getClass()) {
               return false;
            }

            ActivityChooserModel.HistoricalRecord var2 = (ActivityChooserModel.HistoricalRecord)var1;
            if(this.activity == null) {
               if(var2.activity != null) {
                  return false;
               }
            } else if(!this.activity.equals(var2.activity)) {
               return false;
            }

            if(this.time != var2.time) {
               return false;
            }

            if(Float.floatToIntBits(this.weight) != Float.floatToIntBits(var2.weight)) {
               return false;
            }
         }

         return true;
      }

      public int hashCode() {
         int var1;
         if(this.activity == null) {
            var1 = 0;
         } else {
            var1 = this.activity.hashCode();
         }

         return 31 * (31 * (var1 + 31) + (int)(this.time ^ this.time >>> 32)) + Float.floatToIntBits(this.weight);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder();
         var1.append("[");
         var1.append("; activity:").append(this.activity);
         var1.append("; time:").append(this.time);
         var1.append("; weight:").append(new BigDecimal((double)this.weight));
         var1.append("]");
         return var1.toString();
      }
   }

   public interface OnChooseActivityListener {
      boolean onChooseActivity(ActivityChooserModel var1, Intent var2);
   }

   private final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void> {
      private PersistHistoryAsyncTask() {
      }

      // $FF: synthetic method
      PersistHistoryAsyncTask(Object var2) {
         this();
      }

      public Void doInBackground(Object... param1) {
         // $FF: Couldn't be decompiled
      }
   }
}
