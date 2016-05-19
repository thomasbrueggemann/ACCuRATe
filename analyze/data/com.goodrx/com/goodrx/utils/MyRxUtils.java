package com.goodrx.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.goodrx.model.BestPharmacy;
import com.goodrx.model.LocationEntity;
import com.goodrx.model.MyRx;
import com.goodrx.receiver.ReminderAlarmReceiver;
import com.goodrx.utils.tracker.Trackers;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeMap;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class MyRxUtils {
   private static final String BEST_PHARMACY = "best_pharmacy";
   private static final String BEST_PHARMACY_DISTANCE = "distance";
   private static final String IS_NOTIFICATION_ENABLED = "is_notification_enabled";
   private static final String LOCATION = "location";
   private static final int MINUTE_IN_MILLIS = 60000;
   private static final String MYRX_SHARED_PREFERENCE = "my_rx";
   private static final String PHARMACY_UPDATE_TIME = "pharmacy_update_time";
   private static final String PRICE_ALERT_ENABLED = "price_alert_enabled";
   // $FF: renamed from: RX java.lang.String
   private static final String field_636 = "rx";
   private static final String RX_UPDATE_FLAG = "update_flag";
   private static final String SAVINGS_ALERT_ENABLED = "savings_alert_enabled";

   public static boolean checkRxUpdateFlag(Context var0) {
      SharedPreferences var1 = getMyRxSharedPreference(var0);
      boolean var2 = var1.getBoolean("update_flag", false);
      var1.edit().putBoolean("update_flag", false).apply();
      return var2;
   }

   public static void clear(Context var0) {
      Editor var1 = getMyRxSharedPreference(var0).edit();
      var1.putString("location", (String)null);
      var1.putString("rx", (String)null);
      var1.putString("best_pharmacy", (String)null);
      var1.putInt("distance", 3);
      var1.putBoolean("price_alert_enabled", true);
      var1.putBoolean("savings_alert_enabled", true);
      var1.apply();
   }

   public static void clearLocation(Context var0) {
      Editor var1 = getMyRxSharedPreference(var0).edit();
      var1.putString("location", (String)null);
      var1.apply();
   }

   public static boolean containsRx(Context var0, String var1) {
      MyRx[] var2 = getRx(var0);
      int var3 = var2.length;
      int var4 = 0;

      boolean var5;
      while(true) {
         var5 = false;
         if(var4 >= var3) {
            break;
         }

         if(var2[var4].getDrug().getDrug_id().equals(var1)) {
            var5 = true;
            break;
         }

         ++var4;
      }

      return var5;
   }

   public static MyRx findRxByDrugId(Context var0, String var1) {
      MyRx[] var2 = getRx(var0);
      MyRx var3;
      if(var2 != null && var1 != null) {
         int var4 = var2.length;
         int var5 = 0;

         while(true) {
            if(var5 >= var4) {
               return null;
            }

            var3 = var2[var5];
            if(var3.getDrug().getDrug_id().equals(var1)) {
               break;
            }

            ++var5;
         }
      } else {
         var3 = null;
      }

      return var3;
   }

   public static int getBestPharmacyDistance(Context var0) {
      return getMyRxSharedPreference(var0).getInt("distance", 3);
   }

   public static long getBestPharmacyUpdateTime(Context var0) {
      return getMyRxSharedPreference(var0).getLong("pharmacy_update_time", 0L);
   }

   public static BestPharmacy[] getBestpharmacies(Context var0) {
      String var1 = getMyRxSharedPreference(var0).getString("best_pharmacy", (String)null);
      if(var1 == null) {
         return new BestPharmacy[0];
      } else {
         Gson var2 = new Gson();
         Object var3;
         if(!(var2 instanceof Gson)) {
            var3 = var2.fromJson(var1, BestPharmacy[].class);
         } else {
            var3 = GsonInstrumentation.fromJson((Gson)var2, var1, BestPharmacy[].class);
         }

         return (BestPharmacy[])var3;
      }
   }

   public static ArrayList<MyRx> getClosetReminder(Context var0) {
      MyRx[] var1 = getRx(var0);
      TreeMap var2 = new TreeMap();
      long var3 = (new DateTime(new Date(), DateTimeZone.getDefault())).getMillis();

      for(int var5 = 0; var5 < var1.length; ++var5) {
         if(var1[var5].getStatus() == 0 && var1[var5].getReminder().isActive()) {
            int var7 = (int)(var1[var5].getReminder().getCombinedNextDate().getMillis() / 60000L - var3 / 60000L);
            if(var7 >= 1) {
               if(!var2.containsKey(Integer.valueOf(var7))) {
                  var2.put(Integer.valueOf(var7), new ArrayList());
               }

               ((ArrayList)var2.get(Integer.valueOf(var7))).add(var1[var5]);
            }
         }
      }

      Iterator var6 = var2.keySet().iterator();
      if(var6.hasNext()) {
         return (ArrayList)var2.get(Integer.valueOf(((Integer)var6.next()).intValue()));
      } else {
         return new ArrayList(0);
      }
   }

   public static int getConsideredRxCount(Context var0) {
      MyRx[] var1 = getRx(var0);
      int var2 = 0;
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         if(var1[var4].getDrug().isConsidered()) {
            ++var2;
         }
      }

      return var2;
   }

   public static LocationEntity getLocation(Context var0) {
      String var1 = getMyRxSharedPreference(var0).getString("location", (String)null);
      if(var1 == null) {
         return null;
      } else {
         Gson var2 = new Gson();
         Object var3;
         if(!(var2 instanceof Gson)) {
            var3 = var2.fromJson(var1, LocationEntity.class);
         } else {
            var3 = GsonInstrumentation.fromJson((Gson)var2, var1, LocationEntity.class);
         }

         return (LocationEntity)var3;
      }
   }

   private static SharedPreferences getMyRxSharedPreference(Context var0) {
      return var0.getSharedPreferences("my_rx", 0);
   }

   public static int getProcessingCount(Context var0) {
      MyRx[] var1 = getRx(var0);
      int var2 = 0;
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         if(var1[var4].getStatus() != 0) {
            ++var2;
         }
      }

      return var2;
   }

   public static MyRx[] getRx(Context var0) {
      String var1 = getMyRxSharedPreference(var0).getString("rx", (String)null);
      if(var1 != null && var1.length() != 0 && !var1.equals("null")) {
         Gson var2 = new Gson();
         Object var3;
         if(!(var2 instanceof Gson)) {
            var3 = var2.fromJson(var1, MyRx[].class);
         } else {
            var3 = GsonInstrumentation.fromJson((Gson)var2, var1, MyRx[].class);
         }

         return (MyRx[])var3;
      } else {
         return new MyRx[0];
      }
   }

   public static MyRx[] getRxByStatus(Context var0, int var1) {
      ArrayList var2 = new ArrayList();
      MyRx[] var3 = getRx(var0);
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         MyRx var6 = var3[var5];
         if(var6.getStatus() == var1) {
            var2.add(var6);
         }
      }

      return (MyRx[])var2.toArray(new MyRx[var2.size()]);
   }

   public static boolean isBestPharmacyExpired(Context var0) {
      long var1 = getMyRxSharedPreference(var0).getLong("pharmacy_update_time", 0L);
      return (new DateTime(DateTimeZone.getDefault())).getMillis() - var1 > 86400000L;
   }

   public static boolean isNotificationEnabled(Context var0) {
      return getMyRxSharedPreference(var0).getBoolean("is_notification_enabled", true);
   }

   public static boolean isPriceAlertEnabled(Context var0) {
      return getMyRxSharedPreference(var0).getBoolean("price_alert_enabled", true);
   }

   public static boolean isSavingsAlertEnabled(Context var0) {
      return getMyRxSharedPreference(var0).getBoolean("savings_alert_enabled", true);
   }

   public static void markBestPharmacyExpired(Context var0) {
      Editor var1 = getMyRxSharedPreference(var0).edit();
      var1.putLong("pharmacy_update_time", 0L);
      var1.apply();
   }

   public static int removeRx(Context var0, String... var1) {
      int var2 = 0;
      SharedPreferences var3 = getMyRxSharedPreference(var0);
      String var4 = var3.getString("rx", (String)null);
      if(var4 == null) {
         return 0;
      } else {
         Gson var5 = new Gson();
         Object var6;
         if(!(var5 instanceof Gson)) {
            var6 = var5.fromJson(var4, MyRx[].class);
         } else {
            var6 = GsonInstrumentation.fromJson((Gson)var5, var4, MyRx[].class);
         }

         MyRx[] var7 = (MyRx[])var6;
         int var8 = -1;

         for(int var9 = var1.length; var2 < var9; ++var2) {
            String var12 = var1[var2];

            for(int var13 = 0; var13 < var7.length; ++var13) {
               if(var7[var13].getDrug().getDrug_id().equals(var12)) {
                  var8 = var13;
                  break;
               }
            }

            if(var8 != -1) {
               var7 = (MyRx[])org.apache.commons.lang3.ArrayUtils.remove((Object[])var7, var8);
            }
         }

         Editor var10 = var3.edit();
         String var11;
         if(!(var5 instanceof Gson)) {
            var11 = var5.toJson((Object)var7);
         } else {
            var11 = GsonInstrumentation.toJson((Gson)var5, (Object)var7);
         }

         var10.putString("rx", var11).apply();
         markBestPharmacyExpired(var0);
         return var7.length;
      }
   }

   public static void save(Context var0, MyRx[] var1, LocationEntity var2) {
      Editor var3 = getMyRxSharedPreference(var0).edit();
      Gson var4 = new Gson();
      String var5;
      if(!(var4 instanceof Gson)) {
         var5 = var4.toJson((Object)var2);
      } else {
         var5 = GsonInstrumentation.toJson((Gson)var4, (Object)var2);
      }

      var3.putString("location", var5);
      String var7;
      if(!(var4 instanceof Gson)) {
         var7 = var4.toJson((Object)var1);
      } else {
         var7 = GsonInstrumentation.toJson((Gson)var4, (Object)var1);
      }

      var3.putString("rx", var7);
      var3.apply();
      ReminderAlarmReceiver.getInstance().scheduleAlarm(var0);
      markBestPharmacyExpired(var0);
   }

   public static void saveBestPharmacy(Context var0, BestPharmacy[] var1) {
      Editor var2 = getMyRxSharedPreference(var0).edit();
      Gson var3 = new Gson();
      String var4;
      if(!(var3 instanceof Gson)) {
         var4 = var3.toJson((Object)var1);
      } else {
         var4 = GsonInstrumentation.toJson((Gson)var3, (Object)var1);
      }

      var2.putString("best_pharmacy", var4);
      var2.putLong("pharmacy_update_time", (new DateTime(DateTimeZone.getDefault())).getMillis());
      var2.apply();
   }

   public static void saveBestPharmacyDistance(Context var0, int var1) {
      getMyRxSharedPreference(var0).edit().putInt("distance", var1).apply();
   }

   public static void saveRx(Context var0, MyRx[] var1) {
      Editor var2 = getMyRxSharedPreference(var0).edit();
      Gson var3 = new Gson();
      String var4;
      if(!(var3 instanceof Gson)) {
         var4 = var3.toJson((Object)var1);
      } else {
         var4 = GsonInstrumentation.toJson((Gson)var3, (Object)var1);
      }

      var2.putString("rx", var4);
      var2.apply();
      ReminderAlarmReceiver.getInstance().scheduleAlarm(var0);
      markBestPharmacyExpired(var0);
   }

   public static void setNotificationEnabled(Context var0, boolean var1) {
      getMyRxSharedPreference(var0).edit().putBoolean("is_notification_enabled", var1).apply();
   }

   public static void setPriceAlertEnabled(Context var0, boolean var1) {
      getMyRxSharedPreference(var0).edit().putBoolean("price_alert_enabled", var1).apply();
      boolean var2 = isSavingsAlertEnabled(var0);
      Trackers.setParseInstallationData(var0, var1, var2, var2);
   }

   public static void setRxUpdateFlag(Context var0) {
      getMyRxSharedPreference(var0).edit().putBoolean("update_flag", true).apply();
   }

   public static void setSavingsAlertEnabled(Context var0, boolean var1) {
      getMyRxSharedPreference(var0).edit().putBoolean("savings_alert_enabled", var1).apply();
      Trackers.setParseInstallationData(var0, isPriceAlertEnabled(var0), var1, var1);
   }

   public static void updateReminder(Context var0, MyRx var1) {
      Gson var2 = new Gson();
      SharedPreferences var3 = getMyRxSharedPreference(var0);
      String var4 = var3.getString("rx", (String)null);
      MyRx[] var5;
      if(var4 == null) {
         var5 = new MyRx[0];
      } else {
         Object var10;
         if(!(var2 instanceof Gson)) {
            var10 = var2.fromJson(var4, MyRx[].class);
         } else {
            var10 = GsonInstrumentation.fromJson((Gson)var2, var4, MyRx[].class);
         }

         var5 = (MyRx[])var10;
      }

      int var6 = org.apache.commons.lang3.ArrayUtils.indexOf(var5, var1);
      if(var6 == -1) {
         var5 = (MyRx[])org.apache.commons.lang3.ArrayUtils.add(var5, var1);
      } else {
         var5[var6] = var1;
      }

      Editor var7 = var3.edit();
      String var8;
      if(!(var2 instanceof Gson)) {
         var8 = var2.toJson((Object)var5);
      } else {
         var8 = GsonInstrumentation.toJson((Gson)var2, (Object)var5);
      }

      var7.putString("rx", var8);
      var7.apply();
      ReminderAlarmReceiver.getInstance().scheduleAlarm(var0);
   }

   public static void updateRx(Context var0, MyRx var1) {
      Gson var2 = new Gson();
      SharedPreferences var3 = getMyRxSharedPreference(var0);
      String var4 = var3.getString("rx", (String)null);
      MyRx[] var5;
      if(var4 == null) {
         var5 = new MyRx[0];
      } else {
         Object var10;
         if(!(var2 instanceof Gson)) {
            var10 = var2.fromJson(var4, MyRx[].class);
         } else {
            var10 = GsonInstrumentation.fromJson((Gson)var2, var4, MyRx[].class);
         }

         var5 = (MyRx[])var10;
      }

      int var6 = org.apache.commons.lang3.ArrayUtils.indexOf(var5, var1);
      if(var6 == -1) {
         var5 = (MyRx[])org.apache.commons.lang3.ArrayUtils.add(var5, var1);
      } else {
         var5[var6] = var1;
      }

      Editor var7 = var3.edit();
      String var8;
      if(!(var2 instanceof Gson)) {
         var8 = var2.toJson((Object)var5);
      } else {
         var8 = GsonInstrumentation.toJson((Gson)var2, (Object)var5);
      }

      var7.putString("rx", var8);
      var7.apply();
      ReminderAlarmReceiver.getInstance().scheduleAlarm(var0);
      markBestPharmacyExpired(var0);
   }
}
