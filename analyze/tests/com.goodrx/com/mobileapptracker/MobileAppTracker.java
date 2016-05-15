package com.mobileapptracker;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Patterns;
import android.widget.Toast;
import com.mobileapptracker.MATConstants;
import com.mobileapptracker.MATDeeplinkListener;
import com.mobileapptracker.MATDeferredDplinkr;
import com.mobileapptracker.MATEncryption;
import com.mobileapptracker.MATEvent;
import com.mobileapptracker.MATEventQueue;
import com.mobileapptracker.MATFBBridge;
import com.mobileapptracker.MATGender;
import com.mobileapptracker.MATParameters;
import com.mobileapptracker.MATPreloadData;
import com.mobileapptracker.MATResponse;
import com.mobileapptracker.MATTestRequest;
import com.mobileapptracker.MATUrlBuilder;
import com.mobileapptracker.MATUrlRequester;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public class MobileAppTracker {
   private static volatile MobileAppTracker tune = null;
   // $FF: renamed from: IV java.lang.String
   private final String field_262 = "heF9BATUfWuISyO8";
   private boolean debugMode;
   private MATDeferredDplinkr dplinkr;
   private MATEncryption encryption;
   protected MATEventQueue eventQueue;
   private boolean fbLogging;
   private boolean firstSession;
   boolean gotGaid;
   boolean gotReferrer;
   private long initTime;
   protected boolean initialized;
   protected boolean isRegistered;
   protected Context mContext;
   private MATPreloadData mPreloadData;
   protected BroadcastReceiver networkStateReceiver;
   boolean notifiedPool;
   protected MATParameters params;
   ExecutorService pool;
   protected ExecutorService pubQueue;
   private long referrerTime;
   private MATResponse tuneListener;
   protected MATTestRequest tuneRequest;
   private MATUrlRequester urlRequester;

   private boolean firstInstall() {
      SharedPreferences var1 = this.mContext.getSharedPreferences("com.mobileapptracking", 0);
      if(var1.contains("mat_installed")) {
         return false;
      } else {
         var1.edit().putBoolean("mat_installed", true).commit();
         return true;
      }
   }

   public static MobileAppTracker getInstance() {
      synchronized(MobileAppTracker.class){}

      MobileAppTracker var1;
      try {
         var1 = tune;
      } finally {
         ;
      }

      return var1;
   }

   public static MobileAppTracker init(Context var0, String var1, String var2) {
      synchronized(MobileAppTracker.class){}

      MobileAppTracker var4;
      try {
         if(tune == null) {
            tune = new MobileAppTracker();
            tune.mContext = var0.getApplicationContext();
            tune.pubQueue = Executors.newSingleThreadExecutor();
            tune.initAll(var1, var2);
         }

         var4 = tune;
      } finally {
         ;
      }

      return var4;
   }

   private void initLocalVariables(String var1) {
      this.pool = Executors.newSingleThreadExecutor();
      this.urlRequester = new MATUrlRequester();
      this.encryption = new MATEncryption(var1.trim(), "heF9BATUfWuISyO8");
      this.initTime = System.currentTimeMillis();
      boolean var2;
      if(this.mContext.getSharedPreferences("com.mobileapptracking", 0).getString("mat_referrer", "").equals("")) {
         var2 = false;
      } else {
         var2 = true;
      }

      this.gotReferrer = var2;
      this.firstSession = true;
      this.initialized = false;
      this.isRegistered = false;
      this.debugMode = false;
      this.fbLogging = false;
   }

   public static boolean isOnline(Context var0) {
      NetworkInfo var1 = ((ConnectivityManager)var0.getSystemService("connectivity")).getActiveNetworkInfo();
      return var1 != null && var1.isConnected();
   }

   private void measure(MATEvent param1) {
      // $FF: Couldn't be decompiled
   }

   private void requestDeeplink() {
      if(this.dplinkr.isEnabled()) {
         this.dplinkr.setUserAgent(this.params.getUserAgent());
         this.dplinkr.checkForDeferredDeeplink(this.mContext, this.urlRequester);
      }

   }

   protected void addEventToQueue(String var1, String var2, JSONObject var3, boolean var4) {
      ExecutorService var5 = this.pool;
      MATEventQueue var6 = this.eventQueue;
      var5.execute(var6.new Add(var1, var2, var3, var4));
   }

   public void checkForDeferredDeeplink(MATDeeplinkListener var1) {
      this.setDeeplinkListener(var1);
      if(this.firstInstall()) {
         this.dplinkr.enable(true);
      } else {
         this.dplinkr.enable(false);
      }

      if(this.dplinkr.getGoogleAdvertisingId() != null || this.dplinkr.getAndroidId() != null) {
         this.requestDeeplink();
      }

   }

   protected void dumpQueue() {
      if(isOnline(this.mContext)) {
         ExecutorService var1 = this.pool;
         MATEventQueue var2 = this.eventQueue;
         var1.execute(var2.new Dump());
      }
   }

   public String getAction() {
      return this.params.getAction();
   }

   public String getAdvertiserId() {
      return this.params.getAdvertiserId();
   }

   public int getAge() {
      return Integer.parseInt(this.params.getAge());
   }

   public double getAltitude() {
      return Double.parseDouble(this.params.getAltitude());
   }

   public String getAndroidId() {
      return this.params.getAndroidId();
   }

   public boolean getAppAdTrackingEnabled() {
      return Integer.parseInt(this.params.getAppAdTrackingEnabled()) == 1;
   }

   public String getAppName() {
      return this.params.getAppName();
   }

   public int getAppVersion() {
      return Integer.parseInt(this.params.getAppVersion());
   }

   public String getConnectionType() {
      return this.params.getConnectionType();
   }

   public String getCountryCode() {
      return this.params.getCountryCode();
   }

   public String getCurrencyCode() {
      return this.params.getCurrencyCode();
   }

   public String getDeviceBrand() {
      return this.params.getDeviceBrand();
   }

   public String getDeviceCarrier() {
      return this.params.getDeviceCarrier();
   }

   public String getDeviceId() {
      return this.params.getDeviceId();
   }

   public String getDeviceModel() {
      return this.params.getDeviceModel();
   }

   public boolean getExistingUser() {
      return Integer.parseInt(this.params.getExistingUser()) == 1;
   }

   public String getFacebookUserId() {
      return this.params.getFacebookUserId();
   }

   public int getGender() {
      return Integer.parseInt(this.params.getGender());
   }

   public boolean getGoogleAdTrackingLimited() {
      return Integer.parseInt(this.params.getGoogleAdTrackingLimited()) != 0;
   }

   public String getGoogleAdvertisingId() {
      return this.params.getGoogleAdvertisingId();
   }

   public String getGoogleUserId() {
      return this.params.getGoogleUserId();
   }

   public long getInstallDate() {
      return Long.parseLong(this.params.getInstallDate());
   }

   public String getInstallReferrer() {
      return this.params.getInstallReferrer();
   }

   public boolean getIsPayingUser() {
      return this.params.getIsPayingUser().equals("1");
   }

   public String getLanguage() {
      return this.params.getLanguage();
   }

   public String getLastOpenLogId() {
      return this.params.getLastOpenLogId();
   }

   public double getLatitude() {
      return Double.parseDouble(this.params.getLatitude());
   }

   public double getLongitude() {
      return Double.parseDouble(this.params.getLongitude());
   }

   public String getMCC() {
      return this.params.getMCC();
   }

   public String getMNC() {
      return this.params.getMNC();
   }

   public String getMacAddress() {
      return this.params.getMacAddress();
   }

   public String getMatId() {
      return this.params.getMatId();
   }

   public String getOpenLogId() {
      return this.params.getOpenLogId();
   }

   public String getOsVersion() {
      return this.params.getOsVersion();
   }

   public String getPackageName() {
      return this.params.getPackageName();
   }

   public String getPluginName() {
      return this.params.getPluginName();
   }

   public String getRefId() {
      return this.params.getRefId();
   }

   public String getReferralSource() {
      return this.params.getReferralSource();
   }

   public String getReferralUrl() {
      return this.params.getReferralUrl();
   }

   public Double getRevenue() {
      return Double.valueOf(Double.parseDouble(this.params.getRevenue()));
   }

   public String getSDKVersion() {
      return this.params.getSdkVersion();
   }

   public String getScreenDensity() {
      return this.params.getScreenDensity();
   }

   public String getScreenHeight() {
      return this.params.getScreenHeight();
   }

   public String getScreenWidth() {
      return this.params.getScreenWidth();
   }

   public String getSiteId() {
      return this.params.getSiteId();
   }

   public String getTRUSTeId() {
      return this.params.getTRUSTeId();
   }

   public String getTwitterUserId() {
      return this.params.getTwitterUserId();
   }

   public String getUserAgent() {
      return this.params.getUserAgent();
   }

   public String getUserEmail() {
      return this.params.getUserEmail();
   }

   public String getUserId() {
      return this.params.getUserId();
   }

   public String getUserName() {
      return this.params.getUserName();
   }

   protected void initAll(String var1, String var2) {
      this.dplinkr = MATDeferredDplinkr.initialize(var1, var2, this.mContext.getPackageName());
      this.params = MATParameters.init(this, this.mContext, var1, var2);
      this.initLocalVariables(var2);
      this.eventQueue = new MATEventQueue(this.mContext, this);
      this.dumpQueue();
      this.networkStateReceiver = new BroadcastReceiver() {
         public void onReceive(Context var1, Intent var2) {
            if(MobileAppTracker.this.isRegistered) {
               MobileAppTracker.this.dumpQueue();
            }

         }
      };
      if(this.isRegistered) {
         try {
            this.mContext.unregisterReceiver(this.networkStateReceiver);
         } catch (IllegalArgumentException var6) {
            ;
         }

         this.isRegistered = false;
      }

      IntentFilter var3 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
      this.mContext.registerReceiver(this.networkStateReceiver, var3);
      this.isRegistered = true;
      this.initialized = true;
   }

   protected boolean makeRequest(String var1, String var2, JSONObject var3) {
      if(this.debugMode) {
         Log.d("MobileAppTracker", "Sending event to server...");
      }

      String var4 = MATUrlBuilder.updateAndEncryptData(var2, this.encryption);
      JSONObject var5 = MATUrlRequester.requestUrl(var1 + "&data=" + var4, var3, this.debugMode);
      if(var5 == null) {
         if(this.tuneListener != null) {
            this.tuneListener.didFailWithError(var5);
         }
      } else {
         if(!var5.has("success")) {
            if(this.debugMode) {
               Log.d("MobileAppTracker", "Request failed, event will remain in queue");
            }

            return false;
         }

         if(this.tuneListener != null) {
            boolean var9;
            try {
               var9 = var5.getString("success").equals("true");
            } catch (JSONException var12) {
               var12.printStackTrace();
               return false;
            }

            boolean var10 = false;
            if(var9) {
               var10 = true;
            }

            if(var10) {
               this.tuneListener.didSucceedWithData(var5);
            } else {
               this.tuneListener.didFailWithError(var5);
            }
         }

         try {
            if(var5.getString("site_event_type").equals("open")) {
               String var7 = var5.getString("log_id");
               if(this.getOpenLogId().equals("")) {
                  this.params.setOpenLogId(var7);
               }

               this.params.setLastOpenLogId(var7);
               return true;
            }
         } catch (JSONException var11) {
            return true;
         }
      }

      return true;
   }

   public void measureEvent(int var1) {
      this.measureEvent(new MATEvent(var1));
   }

   public void measureEvent(final MATEvent var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            MobileAppTracker.this.measure(var1);
         }
      });
   }

   public void measureEvent(String var1) {
      this.measureEvent(new MATEvent(var1));
   }

   public void measureSession() {
      this.notifiedPool = false;
      this.measureEvent(new MATEvent("session"));
   }

   public void setAdvertiserId(final String var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            MobileAppTracker.this.params.setAdvertiserId(var1);
         }
      });
   }

   public void setAge(final int var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            MobileAppTracker.this.params.setAge(Integer.toString(var1));
         }
      });
   }

   public void setAllowDuplicates(final boolean var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            if(var1) {
               MobileAppTracker.this.params.setAllowDuplicates(Integer.toString(1));
            } else {
               MobileAppTracker.this.params.setAllowDuplicates(Integer.toString(0));
            }
         }
      });
      if(var1) {
         (new Handler(Looper.getMainLooper())).post(new Runnable() {
            public void run() {
               Toast.makeText(MobileAppTracker.this.mContext, "TUNE Allow Duplicate Requests Enabled, do not release with this enabled!!", 1).show();
            }
         });
      }

   }

   public void setAltitude(final double var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            MobileAppTracker.this.params.setAltitude(Double.toString(var1));
         }
      });
   }

   public void setAndroidId(String var1) {
      if(this.dplinkr != null) {
         this.dplinkr.setAndroidId(var1);
         this.requestDeeplink();
      }

      if(this.params != null) {
         this.params.setAndroidId(var1);
      }

   }

   public void setAndroidIdMd5(final String var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            MobileAppTracker.this.params.setAndroidIdMd5(var1);
         }
      });
   }

   public void setAndroidIdSha1(final String var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            MobileAppTracker.this.params.setAndroidIdSha1(var1);
         }
      });
   }

   public void setAndroidIdSha256(final String var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            MobileAppTracker.this.params.setAndroidIdSha256(var1);
         }
      });
   }

   public void setAppAdTrackingEnabled(final boolean var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            if(var1) {
               MobileAppTracker.this.params.setAppAdTrackingEnabled(Integer.toString(1));
            } else {
               MobileAppTracker.this.params.setAppAdTrackingEnabled(Integer.toString(0));
            }
         }
      });
   }

   public void setConversionKey(final String var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            MobileAppTracker.this.params.setConversionKey(var1);
         }
      });
   }

   public void setCurrencyCode(final String var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            if(var1 != null && !var1.equals("")) {
               MobileAppTracker.this.params.setCurrencyCode(var1);
            } else {
               MobileAppTracker.this.params.setCurrencyCode("USD");
            }
         }
      });
   }

   public void setDebugMode(final boolean var1) {
      this.debugMode = var1;
      this.pubQueue.execute(new Runnable() {
         public void run() {
            MobileAppTracker.this.params.setDebugMode(var1);
         }
      });
      if(var1) {
         (new Handler(Looper.getMainLooper())).post(new Runnable() {
            public void run() {
               Toast.makeText(MobileAppTracker.this.mContext, "TUNE Debug Mode Enabled, do not release with this enabled!!", 1).show();
            }
         });
      }

   }

   public void setDeeplinkListener(MATDeeplinkListener var1) {
      this.dplinkr.setListener(var1);
   }

   public void setDeviceBrand(final String var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            MobileAppTracker.this.params.setDeviceBrand(var1);
         }
      });
   }

   public void setDeviceId(final String var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            MobileAppTracker.this.params.setDeviceId(var1);
         }
      });
   }

   public void setDeviceModel(final String var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            MobileAppTracker.this.params.setDeviceModel(var1);
         }
      });
   }

   public void setEmailCollection(final boolean var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            int var1x = 0;
            boolean var2;
            if(MobileAppTracker.this.mContext.checkCallingOrSelfPermission("android.permission.GET_ACCOUNTS") == 0) {
               var2 = true;
            } else {
               var2 = false;
            }

            if(var1 && var2) {
               Account[] var3 = AccountManager.get(MobileAppTracker.this.mContext).getAccountsByType("com.google");
               if(var3.length > 0) {
                  MobileAppTracker.this.params.setUserEmail(var3[0].name);
               }

               HashMap var4 = new HashMap();
               Account[] var5 = AccountManager.get(MobileAppTracker.this.mContext).getAccounts();

               for(int var6 = var5.length; var1x < var6; ++var1x) {
                  Account var7 = var5[var1x];
                  if(Patterns.EMAIL_ADDRESS.matcher(var7.name).matches()) {
                     var4.put(var7.name, var7.type);
                  }
               }

               Set var9 = var4.keySet();
               String[] var10 = (String[])var9.toArray(new String[var9.size()]);
               MobileAppTracker.this.params.setUserEmails(var10);
            }

         }
      });
   }

   public void setExistingUser(final boolean var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            if(var1) {
               MobileAppTracker.this.params.setExistingUser(Integer.toString(1));
            } else {
               MobileAppTracker.this.params.setExistingUser(Integer.toString(0));
            }
         }
      });
   }

   public void setFacebookEventLogging(boolean var1, Context var2, boolean var3) {
      this.fbLogging = var1;
      if(var1) {
         MATFBBridge.startLogger(var2, var3);
      }

   }

   public void setFacebookUserId(final String var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            MobileAppTracker.this.params.setFacebookUserId(var1);
         }
      });
   }

   public void setGender(final MATGender var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            MobileAppTracker.this.params.setGender(var1);
         }
      });
   }

   public void setGoogleAdvertisingId(String param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   public void setGoogleUserId(final String var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            MobileAppTracker.this.params.setGoogleUserId(var1);
         }
      });
   }

   public void setInstallReferrer(final String var1) {
      this.gotReferrer = true;
      this.referrerTime = System.currentTimeMillis();
      if(this.params != null) {
         this.params.setReferrerDelay(this.referrerTime - this.initTime);
      }

      this.pubQueue.execute(new Runnable() {
         public void run() {
            MobileAppTracker.this.params.setInstallReferrer(var1);
         }
      });
   }

   public void setIsPayingUser(final boolean var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            if(var1) {
               MobileAppTracker.this.params.setIsPayingUser(Integer.toString(1));
            } else {
               MobileAppTracker.this.params.setIsPayingUser(Integer.toString(0));
            }
         }
      });
   }

   public void setLatitude(final double var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            MobileAppTracker.this.params.setLatitude(Double.toString(var1));
         }
      });
   }

   public void setLocation(final Location var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            MobileAppTracker.this.params.setLocation(var1);
         }
      });
   }

   public void setLongitude(final double var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            MobileAppTracker.this.params.setLongitude(Double.toString(var1));
         }
      });
   }

   public void setMATResponse(MATResponse var1) {
      this.tuneListener = var1;
   }

   public void setMacAddress(final String var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            MobileAppTracker.this.params.setMacAddress(var1);
         }
      });
   }

   public void setOsVersion(final String var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            MobileAppTracker.this.params.setOsVersion(var1);
         }
      });
   }

   public void setPackageName(final String var1) {
      this.dplinkr.setPackageName(var1);
      this.pubQueue.execute(new Runnable() {
         public void run() {
            if(var1 != null && !var1.equals("")) {
               MobileAppTracker.this.params.setPackageName(var1);
            } else {
               MobileAppTracker.this.params.setPackageName(MobileAppTracker.this.mContext.getPackageName());
            }
         }
      });
   }

   public void setPhoneNumber(final String var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            String var1x = var1.replaceAll("\\D+", "");
            StringBuilder var2 = new StringBuilder();

            for(int var3 = 0; var3 < var1x.length(); ++var3) {
               var2.append(Integer.parseInt(String.valueOf(var1x.charAt(var3))));
            }

            MobileAppTracker.this.params.setPhoneNumber(var2.toString());
         }
      });
   }

   public void setPluginName(final String var1) {
      if(Arrays.asList(MATConstants.PLUGIN_NAMES).contains(var1)) {
         this.pubQueue.execute(new Runnable() {
            public void run() {
               MobileAppTracker.this.params.setPluginName(var1);
            }
         });
      } else if(this.debugMode) {
         throw new IllegalArgumentException("Plugin name not acceptable");
      }

   }

   public void setPreloadedApp(MATPreloadData var1) {
      this.mPreloadData = var1;
   }

   public void setReferralSources(final Activity var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            MobileAppTracker.this.params.setReferralSource(var1.getCallingPackage());
            Intent var1x = var1.getIntent();
            if(var1x != null) {
               Uri var2 = var1x.getData();
               if(var2 != null) {
                  MobileAppTracker.this.params.setReferralUrl(var2.toString());
               }
            }

         }
      });
   }

   public void setSiteId(final String var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            MobileAppTracker.this.params.setSiteId(var1);
         }
      });
   }

   public void setTRUSTeId(final String var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            MobileAppTracker.this.params.setTRUSTeId(var1);
         }
      });
   }

   public void setTwitterUserId(final String var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            MobileAppTracker.this.params.setTwitterUserId(var1);
         }
      });
   }

   public void setUserEmail(final String var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            MobileAppTracker.this.params.setUserEmail(var1);
         }
      });
   }

   public void setUserId(final String var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            MobileAppTracker.this.params.setUserId(var1);
         }
      });
   }

   public void setUserName(final String var1) {
      this.pubQueue.execute(new Runnable() {
         public void run() {
            MobileAppTracker.this.params.setUserName(var1);
         }
      });
   }
}
