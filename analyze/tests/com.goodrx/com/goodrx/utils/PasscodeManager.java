package com.goodrx.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.goodrx.utils.Utils;
import java.util.Iterator;
import java.util.List;
import org.joda.time.DateTime;

public class PasscodeManager {
   private static PasscodeManager instance;

   private String convertIntListToString(List<Integer> var1) {
      StringBuilder var2 = new StringBuilder();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         var2.append(((Integer)var3.next()).intValue());
      }

      return var2.toString();
   }

   public static PasscodeManager getInstance() {
      if(instance == null) {
         instance = new PasscodeManager();
      }

      return instance;
   }

   private SharedPreferences getSharedPreference(Context var1) {
      return PreferenceManager.getDefaultSharedPreferences(var1);
   }

   private long getTimeStamp(Context var1) {
      return this.getSharedPreference(var1).getLong("passcode_time_stamp", 0L);
   }

   public int getFailCounter(Context var1) {
      return this.getSharedPreference(var1).getInt("passcode_fail_counter", 0);
   }

   public long getNextAvailableTime(Context var1) {
      return this.getSharedPreference(var1).getLong("passcode_next_available", 0L);
   }

   public long getValidDuration(Context var1) {
      return this.getSharedPreference(var1).getLong("passcode_valid_duration", 1000L);
   }

   public boolean isActive(Context var1) {
      return this.getSharedPreference(var1).getBoolean("passcode_active", false);
   }

   public boolean isLocalPasscodeAvailable(Context var1) {
      String var2 = this.getSharedPreference(var1).getString("passcode", (String)null);
      return var2 != null && var2.length() != 0;
   }

   public boolean isPassCodeFeatureEnabled(Context var1) {
      return this.getSharedPreference(var1).getBoolean("passcode_feature_enabled", false);
   }

   public boolean isValidPasscode(Context var1, List<Integer> var2) {
      String var3 = Utils.sha1HexEncode(this.convertIntListToString(var2));
      String var4 = this.getSharedPreference(var1).getString("passcode", (String)null);
      if(var4 != null && !var4.equals(var3)) {
         return false;
      } else {
         this.refreshTimeStamp(var1);
         return true;
      }
   }

   public void refreshTimeStamp(Context var1) {
      this.getSharedPreference(var1).edit().putLong("passcode_time_stamp", (new DateTime()).getMillis()).apply();
   }

   public void setActive(Context var1, boolean var2) {
      if(!var2) {
         this.refreshTimeStamp(var1);
      }

      this.getSharedPreference(var1).edit().putBoolean("passcode_active", var2).apply();
   }

   public void setFailCounter(Context var1, int var2) {
      this.getSharedPreference(var1).edit().putInt("passcode_fail_counter", var2).apply();
   }

   public void setNextAvailableTime(Context var1, long var2) {
      this.getSharedPreference(var1).edit().putLong("passcode_next_available", var2).apply();
   }

   public void setPassCodeFeatureEnabled(Context var1, boolean var2) {
      this.getSharedPreference(var1).edit().putBoolean("passcode_feature_enabled", var2).apply();
   }

   public void setPasscode(Context var1, List<Integer> var2) {
      String var3 = null;
      if(var2 != null) {
         var3 = Utils.sha1HexEncode(this.convertIntListToString(var2));
      }

      this.getSharedPreference(var1).edit().putString("passcode", var3).apply();
      this.refreshTimeStamp(var1);
   }

   public void setValidDuration(Context var1, long var2) {
      this.getSharedPreference(var1).edit().putLong("passcode_valid_duration", var2).apply();
   }

   public boolean shouldLockScreen(Context var1) {
      return this.isPassCodeFeatureEnabled(var1) && (new DateTime()).getMillis() - this.getTimeStamp(var1) > this.getValidDuration(var1);
   }
}
