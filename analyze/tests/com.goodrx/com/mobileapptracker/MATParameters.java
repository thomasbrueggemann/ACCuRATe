package com.mobileapptracker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.webkit.WebView;
import com.mobileapptracker.MATGender;
import com.mobileapptracker.MATUtils;
import com.mobileapptracker.MobileAppTracker;
import java.lang.ref.WeakReference;
import org.json.JSONArray;

public class MATParameters {
   private static MATParameters INSTANCE = null;
   private String mAction = null;
   private String mAdvertiserId = null;
   private String mAge = null;
   private String mAllowDups = null;
   private String mAltitude = null;
   private String mAndroidId = null;
   private String mAndroidIdMd5 = null;
   private String mAndroidIdSha1 = null;
   private String mAndroidIdSha256 = null;
   private String mAppAdTracking = null;
   private String mAppName = null;
   private String mAppVersion = null;
   private String mAppVersionName = null;
   private String mConnectionType = null;
   private Context mContext;
   private String mConversionKey = null;
   private String mCountryCode = null;
   private String mCurrencyCode = null;
   private boolean mDebugMode = false;
   private String mDeviceBrand = null;
   private String mDeviceCarrier = null;
   private String mDeviceCpuSubtype = null;
   private String mDeviceCpuType = null;
   private String mDeviceId = null;
   private String mDeviceModel = null;
   private String mExistingUser = null;
   private String mFbUserId = null;
   private String mGaid = null;
   private String mGaidLimited = null;
   private String mGender = null;
   private String mGgUserId = null;
   private String mInstallDate = null;
   private String mInstallerPackage = null;
   private String mLanguage = null;
   private String mLatitude = null;
   private Location mLocation = null;
   private String mLongitude = null;
   private String mMCC = null;
   private String mMNC = null;
   private String mMacAddress = null;
   private String mOsVersion = null;
   private String mPackageName = null;
   private String mPhoneNumberMd5;
   private String mPhoneNumberSha1;
   private String mPhoneNumberSha256;
   private String mPluginName = null;
   private String mPurchaseStatus = null;
   private String mRefId = null;
   private String mReferralSource = null;
   private String mReferralUrl = null;
   private String mReferrerDelay = null;
   private String mRevenue = null;
   private String mScreenDensity = null;
   private String mScreenHeight = null;
   private String mScreenWidth = null;
   private String mSiteId = null;
   private String mTimeZone = null;
   private String mTrackingId = null;
   private String mTrusteId = null;
   private MobileAppTracker mTune;
   private String mTwUserId = null;
   private String mUserAgent = null;
   private String mUserEmailMd5;
   private String mUserEmailSha1;
   private String mUserEmailSha256;
   private JSONArray mUserEmails = null;
   private String mUserNameMd5;
   private String mUserNameSha1;
   private String mUserNameSha256;

   // $FF: synthetic method
   static MobileAppTracker access$0(MATParameters var0) {
      return var0.mTune;
   }

   public static MATParameters getInstance() {
      return INSTANCE;
   }

   public static MATParameters init(MobileAppTracker var0, Context var1, String var2, String var3) {
      if(INSTANCE == null) {
         INSTANCE = new MATParameters();
         INSTANCE.mTune = var0;
         INSTANCE.mContext = var1;
         INSTANCE.populateParams(var1, var2, var3);
      }

      return INSTANCE;
   }

   @SuppressLint({"NewApi"})
   private boolean populateParams(Context param1, String param2, String param3) {
      // $FF: Couldn't be decompiled
   }

   private void setUserAgent(String var1) {
      this.mUserAgent = var1;
   }

   public void clear() {
      INSTANCE = null;
   }

   public String getAction() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mAction;
      } finally {
         ;
      }

      return var2;
   }

   public String getAdvertiserId() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mAdvertiserId;
      } finally {
         ;
      }

      return var2;
   }

   public String getAge() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mAge;
      } finally {
         ;
      }

      return var2;
   }

   public String getAllowDuplicates() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mAllowDups;
      } finally {
         ;
      }

      return var2;
   }

   public String getAltitude() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mAltitude;
      } finally {
         ;
      }

      return var2;
   }

   public String getAndroidId() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mAndroidId;
      } finally {
         ;
      }

      return var2;
   }

   public String getAndroidIdMd5() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mAndroidIdMd5;
      } finally {
         ;
      }

      return var2;
   }

   public String getAndroidIdSha1() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mAndroidIdSha1;
      } finally {
         ;
      }

      return var2;
   }

   public String getAndroidIdSha256() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mAndroidIdSha256;
      } finally {
         ;
      }

      return var2;
   }

   public String getAppAdTrackingEnabled() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mAppAdTracking;
      } finally {
         ;
      }

      return var2;
   }

   public String getAppName() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mAppName;
      } finally {
         ;
      }

      return var2;
   }

   public String getAppVersion() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mAppVersion;
      } finally {
         ;
      }

      return var2;
   }

   public String getAppVersionName() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mAppVersionName;
      } finally {
         ;
      }

      return var2;
   }

   public String getConnectionType() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mConnectionType;
      } finally {
         ;
      }

      return var2;
   }

   public String getConversionKey() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mConversionKey;
      } finally {
         ;
      }

      return var2;
   }

   public String getCountryCode() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mCountryCode;
      } finally {
         ;
      }

      return var2;
   }

   public String getCurrencyCode() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mCurrencyCode;
      } finally {
         ;
      }

      return var2;
   }

   public boolean getDebugMode() {
      synchronized(this){}

      boolean var2;
      try {
         var2 = this.mDebugMode;
      } finally {
         ;
      }

      return var2;
   }

   public String getDeviceBrand() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mDeviceBrand;
      } finally {
         ;
      }

      return var2;
   }

   public String getDeviceCarrier() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mDeviceCarrier;
      } finally {
         ;
      }

      return var2;
   }

   public String getDeviceCpuSubtype() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mDeviceCpuSubtype;
      } finally {
         ;
      }

      return var2;
   }

   public String getDeviceCpuType() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mDeviceCpuType;
      } finally {
         ;
      }

      return var2;
   }

   public String getDeviceId() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mDeviceId;
      } finally {
         ;
      }

      return var2;
   }

   public String getDeviceModel() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mDeviceModel;
      } finally {
         ;
      }

      return var2;
   }

   public String getExistingUser() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mExistingUser;
      } finally {
         ;
      }

      return var2;
   }

   public String getFacebookUserId() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mFbUserId;
      } finally {
         ;
      }

      return var2;
   }

   public String getGender() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mGender;
      } finally {
         ;
      }

      return var2;
   }

   public String getGoogleAdTrackingLimited() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mGaidLimited;
      } finally {
         ;
      }

      return var2;
   }

   public String getGoogleAdvertisingId() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mGaid;
      } finally {
         ;
      }

      return var2;
   }

   public String getGoogleUserId() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mGgUserId;
      } finally {
         ;
      }

      return var2;
   }

   public String getInstallDate() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mInstallDate;
      } finally {
         ;
      }

      return var2;
   }

   public String getInstallReferrer() {
      synchronized(this){}

      String var2;
      try {
         var2 = MATUtils.getStringFromSharedPreferences(this.mContext, "mat_referrer");
      } finally {
         ;
      }

      return var2;
   }

   public String getInstaller() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mInstallerPackage;
      } finally {
         ;
      }

      return var2;
   }

   public String getIsPayingUser() {
      synchronized(this){}

      String var2;
      try {
         var2 = MATUtils.getStringFromSharedPreferences(this.mContext, "mat_is_paying_user");
      } finally {
         ;
      }

      return var2;
   }

   public String getLanguage() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mLanguage;
      } finally {
         ;
      }

      return var2;
   }

   public String getLastOpenLogId() {
      synchronized(this){}

      String var2;
      try {
         var2 = MATUtils.getStringFromSharedPreferences(this.mContext, "mat_log_id_last_open");
      } finally {
         ;
      }

      return var2;
   }

   public String getLatitude() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mLatitude;
      } finally {
         ;
      }

      return var2;
   }

   public Location getLocation() {
      synchronized(this){}

      Location var2;
      try {
         var2 = this.mLocation;
      } finally {
         ;
      }

      return var2;
   }

   public String getLongitude() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mLongitude;
      } finally {
         ;
      }

      return var2;
   }

   public String getMCC() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mMCC;
      } finally {
         ;
      }

      return var2;
   }

   public String getMNC() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mMNC;
      } finally {
         ;
      }

      return var2;
   }

   public String getMacAddress() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mMacAddress;
      } finally {
         ;
      }

      return var2;
   }

   public String getMatId() {
      synchronized(this){}
      boolean var6 = false;

      String var3;
      String var4;
      label55: {
         String var2;
         try {
            var6 = true;
            if(this.mContext.getSharedPreferences("mat_id", 0).contains("mat_id")) {
               var4 = this.mContext.getSharedPreferences("mat_id", 0).getString("mat_id", "");
               var6 = false;
               break label55;
            }

            var2 = MATUtils.getStringFromSharedPreferences(this.mContext, "mat_id");
            var6 = false;
         } finally {
            if(var6) {
               ;
            }
         }

         var3 = var2;
         return var3;
      }

      var3 = var4;
      return var3;
   }

   public String getOpenLogId() {
      synchronized(this){}

      String var2;
      try {
         var2 = MATUtils.getStringFromSharedPreferences(this.mContext, "mat_log_id_open");
      } finally {
         ;
      }

      return var2;
   }

   public String getOsVersion() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mOsVersion;
      } finally {
         ;
      }

      return var2;
   }

   public String getPackageName() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mPackageName;
      } finally {
         ;
      }

      return var2;
   }

   public String getPhoneNumber() {
      synchronized(this){}

      String var2;
      try {
         var2 = MATUtils.getStringFromSharedPreferences(this.mContext, "mat_phone_number");
      } finally {
         ;
      }

      return var2;
   }

   public String getPhoneNumberMd5() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mPhoneNumberMd5;
      } finally {
         ;
      }

      return var2;
   }

   public String getPhoneNumberSha1() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mPhoneNumberSha1;
      } finally {
         ;
      }

      return var2;
   }

   public String getPhoneNumberSha256() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mPhoneNumberSha256;
      } finally {
         ;
      }

      return var2;
   }

   public String getPluginName() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mPluginName;
      } finally {
         ;
      }

      return var2;
   }

   public String getPurchaseStatus() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mPurchaseStatus;
      } finally {
         ;
      }

      return var2;
   }

   public String getRefId() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mRefId;
      } finally {
         ;
      }

      return var2;
   }

   public String getReferralSource() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mReferralSource;
      } finally {
         ;
      }

      return var2;
   }

   public String getReferralUrl() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mReferralUrl;
      } finally {
         ;
      }

      return var2;
   }

   public String getReferrerDelay() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mReferrerDelay;
      } finally {
         ;
      }

      return var2;
   }

   public String getRevenue() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mRevenue;
      } finally {
         ;
      }

      return var2;
   }

   public String getScreenDensity() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mScreenDensity;
      } finally {
         ;
      }

      return var2;
   }

   public String getScreenHeight() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mScreenHeight;
      } finally {
         ;
      }

      return var2;
   }

   public String getScreenWidth() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mScreenWidth;
      } finally {
         ;
      }

      return var2;
   }

   public String getSdkVersion() {
      synchronized(this){}
      return "3.11.1";
   }

   public String getSiteId() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mSiteId;
      } finally {
         ;
      }

      return var2;
   }

   public String getTRUSTeId() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mTrusteId;
      } finally {
         ;
      }

      return var2;
   }

   public String getTimeZone() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mTimeZone;
      } finally {
         ;
      }

      return var2;
   }

   public String getTrackingId() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mTrackingId;
      } finally {
         ;
      }

      return var2;
   }

   public String getTwitterUserId() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mTwUserId;
      } finally {
         ;
      }

      return var2;
   }

   public String getUserAgent() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mUserAgent;
      } finally {
         ;
      }

      return var2;
   }

   public String getUserEmail() {
      synchronized(this){}

      String var2;
      try {
         var2 = MATUtils.getStringFromSharedPreferences(this.mContext, "mat_user_email");
      } finally {
         ;
      }

      return var2;
   }

   public String getUserEmailMd5() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mUserEmailMd5;
      } finally {
         ;
      }

      return var2;
   }

   public String getUserEmailSha1() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mUserEmailSha1;
      } finally {
         ;
      }

      return var2;
   }

   public String getUserEmailSha256() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mUserEmailSha256;
      } finally {
         ;
      }

      return var2;
   }

   public JSONArray getUserEmails() {
      synchronized(this){}

      JSONArray var2;
      try {
         var2 = this.mUserEmails;
      } finally {
         ;
      }

      return var2;
   }

   public String getUserId() {
      synchronized(this){}

      String var2;
      try {
         var2 = MATUtils.getStringFromSharedPreferences(this.mContext, "mat_user_id");
      } finally {
         ;
      }

      return var2;
   }

   public String getUserName() {
      synchronized(this){}

      String var2;
      try {
         var2 = MATUtils.getStringFromSharedPreferences(this.mContext, "mat_user_name");
      } finally {
         ;
      }

      return var2;
   }

   public String getUserNameMd5() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mUserNameMd5;
      } finally {
         ;
      }

      return var2;
   }

   public String getUserNameSha1() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mUserNameSha1;
      } finally {
         ;
      }

      return var2;
   }

   public String getUserNameSha256() {
      synchronized(this){}

      String var2;
      try {
         var2 = this.mUserNameSha256;
      } finally {
         ;
      }

      return var2;
   }

   public void setAction(String var1) {
      synchronized(this){}

      try {
         this.mAction = var1;
      } finally {
         ;
      }

   }

   public void setAdvertiserId(String var1) {
      synchronized(this){}

      try {
         this.mAdvertiserId = var1;
      } finally {
         ;
      }

   }

   public void setAge(String var1) {
      synchronized(this){}

      try {
         this.mAge = var1;
      } finally {
         ;
      }

   }

   public void setAllowDuplicates(String var1) {
      synchronized(this){}

      try {
         this.mAllowDups = var1;
      } finally {
         ;
      }

   }

   public void setAltitude(String var1) {
      synchronized(this){}

      try {
         this.mAltitude = var1;
      } finally {
         ;
      }

   }

   public void setAndroidId(String var1) {
      synchronized(this){}

      try {
         this.mAndroidId = var1;
      } finally {
         ;
      }

   }

   public void setAndroidIdMd5(String var1) {
      synchronized(this){}

      try {
         this.mAndroidIdMd5 = var1;
      } finally {
         ;
      }

   }

   public void setAndroidIdSha1(String var1) {
      synchronized(this){}

      try {
         this.mAndroidIdSha1 = var1;
      } finally {
         ;
      }

   }

   public void setAndroidIdSha256(String var1) {
      synchronized(this){}

      try {
         this.mAndroidIdSha256 = var1;
      } finally {
         ;
      }

   }

   public void setAppAdTrackingEnabled(String var1) {
      synchronized(this){}

      try {
         this.mAppAdTracking = var1;
      } finally {
         ;
      }

   }

   public void setAppName(String var1) {
      synchronized(this){}

      try {
         this.mAppName = var1;
      } finally {
         ;
      }

   }

   public void setAppVersion(String var1) {
      synchronized(this){}

      try {
         this.mAppVersion = var1;
      } finally {
         ;
      }

   }

   public void setAppVersionName(String var1) {
      synchronized(this){}

      try {
         this.mAppVersionName = var1;
      } finally {
         ;
      }

   }

   public void setConnectionType(String var1) {
      synchronized(this){}

      try {
         this.mConnectionType = var1;
      } finally {
         ;
      }

   }

   public void setConversionKey(String var1) {
      synchronized(this){}

      try {
         this.mConversionKey = var1;
      } finally {
         ;
      }

   }

   public void setCountryCode(String var1) {
      synchronized(this){}

      try {
         this.mCountryCode = var1;
      } finally {
         ;
      }

   }

   public void setCurrencyCode(String var1) {
      synchronized(this){}

      try {
         this.mCurrencyCode = var1;
      } finally {
         ;
      }

   }

   public void setDebugMode(boolean var1) {
      synchronized(this){}

      try {
         this.mDebugMode = var1;
      } finally {
         ;
      }

   }

   public void setDeviceBrand(String var1) {
      synchronized(this){}

      try {
         this.mDeviceBrand = var1;
      } finally {
         ;
      }

   }

   public void setDeviceCarrier(String var1) {
      synchronized(this){}

      try {
         this.mDeviceCarrier = var1;
      } finally {
         ;
      }

   }

   public void setDeviceCpuSubtype(String var1) {
      synchronized(this){}

      try {
         this.mDeviceCpuSubtype = var1;
      } finally {
         ;
      }

   }

   public void setDeviceCpuType(String var1) {
      synchronized(this){}

      try {
         this.mDeviceCpuType = var1;
      } finally {
         ;
      }

   }

   public void setDeviceId(String var1) {
      synchronized(this){}

      try {
         this.mDeviceId = var1;
      } finally {
         ;
      }

   }

   public void setDeviceModel(String var1) {
      synchronized(this){}

      try {
         this.mDeviceModel = var1;
      } finally {
         ;
      }

   }

   public void setExistingUser(String var1) {
      synchronized(this){}

      try {
         this.mExistingUser = var1;
      } finally {
         ;
      }

   }

   public void setFacebookUserId(String var1) {
      synchronized(this){}

      try {
         this.mFbUserId = var1;
      } finally {
         ;
      }

   }

   public void setGender(MATGender var1) {
      synchronized(this){}

      try {
         if(var1 == MATGender.MALE) {
            this.mGender = "0";
         } else if(var1 == MATGender.FEMALE) {
            this.mGender = "1";
         } else {
            this.mGender = "";
         }
      } finally {
         ;
      }

   }

   public void setGoogleAdTrackingLimited(String var1) {
      synchronized(this){}

      try {
         this.mGaidLimited = var1;
      } finally {
         ;
      }

   }

   public void setGoogleAdvertisingId(String var1) {
      synchronized(this){}

      try {
         this.mGaid = var1;
      } finally {
         ;
      }

   }

   public void setGoogleUserId(String var1) {
      synchronized(this){}

      try {
         this.mGgUserId = var1;
      } finally {
         ;
      }

   }

   public void setInstallDate(String var1) {
      synchronized(this){}

      try {
         this.mInstallDate = var1;
      } finally {
         ;
      }

   }

   public void setInstallReferrer(String var1) {
      synchronized(this){}

      try {
         MATUtils.saveToSharedPreferences(this.mContext, "mat_referrer", var1);
      } finally {
         ;
      }

   }

   public void setInstaller(String var1) {
      synchronized(this){}

      try {
         this.mInstallerPackage = var1;
      } finally {
         ;
      }

   }

   public void setIsPayingUser(String var1) {
      synchronized(this){}

      try {
         MATUtils.saveToSharedPreferences(this.mContext, "mat_is_paying_user", var1);
      } finally {
         ;
      }

   }

   public void setLanguage(String var1) {
      synchronized(this){}

      try {
         this.mLanguage = var1;
      } finally {
         ;
      }

   }

   public void setLastOpenLogId(String var1) {
      synchronized(this){}

      try {
         MATUtils.saveToSharedPreferences(this.mContext, "mat_log_id_last_open", var1);
      } finally {
         ;
      }

   }

   public void setLatitude(String var1) {
      synchronized(this){}

      try {
         this.mLatitude = var1;
      } finally {
         ;
      }

   }

   public void setLocation(Location var1) {
      synchronized(this){}

      try {
         this.mLocation = var1;
      } finally {
         ;
      }

   }

   public void setLongitude(String var1) {
      synchronized(this){}

      try {
         this.mLongitude = var1;
      } finally {
         ;
      }

   }

   public void setMCC(String var1) {
      synchronized(this){}

      try {
         this.mMCC = var1;
      } finally {
         ;
      }

   }

   public void setMNC(String var1) {
      synchronized(this){}

      try {
         this.mMNC = var1;
      } finally {
         ;
      }

   }

   public void setMacAddress(String var1) {
      synchronized(this){}

      try {
         this.mMacAddress = var1;
      } finally {
         ;
      }

   }

   public void setMatId(String var1) {
      synchronized(this){}

      try {
         MATUtils.saveToSharedPreferences(this.mContext, "mat_id", var1);
      } finally {
         ;
      }

   }

   public void setOpenLogId(String var1) {
      synchronized(this){}

      try {
         MATUtils.saveToSharedPreferences(this.mContext, "mat_log_id_open", var1);
      } finally {
         ;
      }

   }

   public void setOsVersion(String var1) {
      synchronized(this){}

      try {
         this.mOsVersion = var1;
      } finally {
         ;
      }

   }

   public void setPackageName(String var1) {
      synchronized(this){}

      try {
         this.mPackageName = var1;
      } finally {
         ;
      }

   }

   public void setPhoneNumber(String var1) {
      synchronized(this){}

      try {
         MATUtils.saveToSharedPreferences(this.mContext, "mat_phone_number", var1);
         this.setPhoneNumberMd5(MATUtils.md5(var1));
         this.setPhoneNumberSha1(MATUtils.sha1(var1));
         this.setPhoneNumberSha256(MATUtils.sha256(var1));
      } finally {
         ;
      }

   }

   public void setPhoneNumberMd5(String var1) {
      synchronized(this){}

      try {
         this.mPhoneNumberMd5 = var1;
      } finally {
         ;
      }

   }

   public void setPhoneNumberSha1(String var1) {
      synchronized(this){}

      try {
         this.mPhoneNumberSha1 = var1;
      } finally {
         ;
      }

   }

   public void setPhoneNumberSha256(String var1) {
      synchronized(this){}

      try {
         this.mPhoneNumberSha256 = var1;
      } finally {
         ;
      }

   }

   public void setPluginName(String var1) {
      synchronized(this){}

      try {
         this.mPluginName = null;
      } finally {
         ;
      }

   }

   public void setPurchaseStatus(String var1) {
      synchronized(this){}

      try {
         this.mPurchaseStatus = var1;
      } finally {
         ;
      }

   }

   public void setRefId(String var1) {
      synchronized(this){}

      try {
         this.mRefId = var1;
      } finally {
         ;
      }

   }

   public void setReferralSource(String var1) {
      synchronized(this){}

      try {
         this.mReferralSource = var1;
      } finally {
         ;
      }

   }

   public void setReferralUrl(String var1) {
      synchronized(this){}

      try {
         this.mReferralUrl = var1;
      } finally {
         ;
      }

   }

   public void setReferrerDelay(long var1) {
      synchronized(this){}

      try {
         this.mReferrerDelay = Long.toString(var1);
      } finally {
         ;
      }

   }

   public void setRevenue(String var1) {
      synchronized(this){}

      try {
         this.mRevenue = var1;
      } finally {
         ;
      }

   }

   public void setScreenDensity(String var1) {
      synchronized(this){}

      try {
         this.mScreenDensity = var1;
      } finally {
         ;
      }

   }

   public void setScreenHeight(String var1) {
      synchronized(this){}

      try {
         this.mScreenHeight = var1;
      } finally {
         ;
      }

   }

   public void setScreenWidth(String var1) {
      synchronized(this){}

      try {
         this.mScreenWidth = var1;
      } finally {
         ;
      }

   }

   public void setSiteId(String var1) {
      synchronized(this){}

      try {
         this.mSiteId = var1;
      } finally {
         ;
      }

   }

   public void setTRUSTeId(String var1) {
      synchronized(this){}

      try {
         this.mTrusteId = var1;
      } finally {
         ;
      }

   }

   public void setTimeZone(String var1) {
      synchronized(this){}

      try {
         this.mTimeZone = var1;
      } finally {
         ;
      }

   }

   public void setTrackingId(String var1) {
      synchronized(this){}

      try {
         this.mTrackingId = var1;
      } finally {
         ;
      }

   }

   public void setTwitterUserId(String var1) {
      synchronized(this){}

      try {
         this.mTwUserId = var1;
      } finally {
         ;
      }

   }

   public void setUserEmail(String var1) {
      synchronized(this){}

      try {
         MATUtils.saveToSharedPreferences(this.mContext, "mat_user_email", var1);
         this.setUserEmailMd5(MATUtils.md5(var1));
         this.setUserEmailSha1(MATUtils.sha1(var1));
         this.setUserEmailSha256(MATUtils.sha256(var1));
      } finally {
         ;
      }

   }

   public void setUserEmailMd5(String var1) {
      synchronized(this){}

      try {
         this.mUserEmailMd5 = var1;
      } finally {
         ;
      }

   }

   public void setUserEmailSha1(String var1) {
      synchronized(this){}

      try {
         this.mUserEmailSha1 = var1;
      } finally {
         ;
      }

   }

   public void setUserEmailSha256(String var1) {
      synchronized(this){}

      try {
         this.mUserEmailSha256 = var1;
      } finally {
         ;
      }

   }

   public void setUserEmails(String[] param1) {
      // $FF: Couldn't be decompiled
   }

   public void setUserId(String var1) {
      synchronized(this){}

      try {
         MATUtils.saveToSharedPreferences(this.mContext, "mat_user_id", var1);
      } finally {
         ;
      }

   }

   public void setUserName(String var1) {
      synchronized(this){}

      try {
         MATUtils.saveToSharedPreferences(this.mContext, "mat_user_name", var1);
         this.setUserNameMd5(MATUtils.md5(var1));
         this.setUserNameSha1(MATUtils.sha1(var1));
         this.setUserNameSha256(MATUtils.sha256(var1));
      } finally {
         ;
      }

   }

   public void setUserNameMd5(String var1) {
      synchronized(this){}

      try {
         this.mUserNameMd5 = var1;
      } finally {
         ;
      }

   }

   public void setUserNameSha1(String var1) {
      synchronized(this){}

      try {
         this.mUserNameSha1 = var1;
      } finally {
         ;
      }

   }

   public void setUserNameSha256(String var1) {
      synchronized(this){}

      try {
         this.mUserNameSha256 = var1;
      } finally {
         ;
      }

   }

   private class GetGAID implements Runnable {
      private final WeakReference<Context> weakContext;

      public GetGAID(Context var2) {
         this.weakContext = new WeakReference(var2);
      }

      public void run() {
         // $FF: Couldn't be decompiled
      }
   }

   private class GetUserAgent implements Runnable {
      private final WeakReference<Context> weakContext;

      public GetUserAgent(Context var2) {
         this.weakContext = new WeakReference(var2);
      }

      public void run() {
         try {
            WebView var1 = new WebView((Context)this.weakContext.get());
            String var4 = var1.getSettings().getUserAgentString();
            var1.destroy();
            MATParameters.this.setUserAgent(var4);
         } catch (Exception var5) {
            ;
         } catch (VerifyError var6) {
            ;
         }
      }
   }
}
