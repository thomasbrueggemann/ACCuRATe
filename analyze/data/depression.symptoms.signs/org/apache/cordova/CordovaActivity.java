package org.apache.cordova;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.ValueCallback;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.cordova.AuthenticationToken;
import org.apache.cordova.Config;
import org.apache.cordova.ConfigXmlParser;
import org.apache.cordova.CordovaChromeClient;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaPreferences;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewClient;
import org.apache.cordova.LOG;
import org.apache.cordova.LinearLayoutSoftKeyboardDetect;
import org.apache.cordova.PluginEntry;
import org.apache.cordova.Whitelist;
import org.json.JSONException;
import org.json.JSONObject;

public class CordovaActivity extends Activity implements CordovaInterface {
   private static int ACTIVITY_EXITING = 2;
   private static int ACTIVITY_RUNNING = 1;
   private static int ACTIVITY_STARTING = 0;
   public static String TAG = "CordovaActivity";
   protected CordovaPlugin activityResultCallback = null;
   protected boolean activityResultKeepRunning;
   private int activityState = 0;
   protected CordovaWebView appView;
   protected Whitelist externalWhitelist;
   private String initCallbackClass;
   protected Whitelist internalWhitelist;
   protected boolean keepRunning = true;
   protected String launchUrl;
   protected int loadUrlTimeoutValue = 20000;
   protected ArrayList<PluginEntry> pluginEntries;
   protected CordovaPreferences preferences;
   @Deprecated
   protected LinearLayout root;
   protected ProgressDialog spinnerDialog = null;
   protected Dialog splashDialog;
   protected int splashscreen = 0;
   protected int splashscreenTime = 3000;
   private final ExecutorService threadPool = Executors.newCachedThreadPool();
   @Deprecated
   protected CordovaWebViewClient webViewClient;

   @Deprecated
   public void addService(String var1, String var2) {
      if(this.appView != null && this.appView.pluginManager != null) {
         this.appView.pluginManager.addService(var1, var2);
      }

   }

   @Deprecated
   public boolean backHistory() {
      return this.appView != null?this.appView.backHistory():false;
   }

   @Deprecated
   public void cancelLoadUrl() {
   }

   public void clearAuthenticationTokens() {
      if(this.appView != null && this.appView.viewClient != null) {
         this.appView.viewClient.clearAuthenticationTokens();
      }

   }

   @Deprecated
   public void clearCache() {
      if(this.appView == null) {
         this.init();
      }

      this.appView.clearCache(true);
   }

   @Deprecated
   public void clearHistory() {
      this.appView.clearHistory();
   }

   protected void createViews() {
      Display var1 = this.getWindowManager().getDefaultDisplay();
      this.root = new LinearLayoutSoftKeyboardDetect(this, var1.getWidth(), var1.getHeight());
      this.root.setOrientation(1);
      this.root.setLayoutParams(new LayoutParams(-1, -1, 0.0F));
      this.appView.setId(100);
      this.appView.setLayoutParams(new LayoutParams(-1, -1, 1.0F));
      this.appView.setVisibility(4);
      this.root.addView(this.appView);
      this.setContentView(this.root);
      int var2 = this.preferences.getInteger("BackgroundColor", -16777216);
      this.root.setBackgroundColor(var2);
   }

   public void displayError(final String var1, final String var2, final String var3, final boolean var4) {
      this.runOnUiThread(new Runnable() {
         public void run() {
            try {
               Builder var1x = new Builder(CordovaActivity.this);
               var1x.setMessage(var2);
               var1x.setTitle(var1);
               var1x.setCancelable(false);
               var1x.setPositiveButton(var3, new OnClickListener() {
                  public void onClick(DialogInterface var1x, int var2x) {
                     var1x.dismiss();
                     if(var4) {
                        CordovaActivity.this.endActivity();
                     }

                  }
               });
               var1x.create();
               var1x.show();
            } catch (Exception var3x) {
               CordovaActivity.this.finish();
            }
         }
      });
   }

   public void endActivity() {
      this.activityState = ACTIVITY_EXITING;
      super.finish();
   }

   public Activity getActivity() {
      return this;
   }

   public AuthenticationToken getAuthenticationToken(String var1, String var2) {
      return this.appView != null && this.appView.viewClient != null?this.appView.viewClient.getAuthenticationToken(var1, var2):null;
   }

   @Deprecated
   public boolean getBooleanProperty(String var1, boolean var2) {
      return this.preferences.getBoolean(var1, var2);
   }

   @Deprecated
   public Context getContext() {
      LOG.method_2(TAG, "This will be deprecated December 2012");
      return this;
   }

   @Deprecated
   public double getDoubleProperty(String var1, double var2) {
      return this.preferences.getDouble(var1, var2);
   }

   @Deprecated
   public int getIntegerProperty(String var1, int var2) {
      return this.preferences.getInteger(var1, var2);
   }

   @Deprecated
   public String getStringProperty(String var1, String var2) {
      return this.preferences.getString(var1, var2);
   }

   public ExecutorService getThreadPool() {
      return this.threadPool;
   }

   public void init() {
      this.init(this.appView, (CordovaWebViewClient)null, (CordovaChromeClient)null);
   }

   @Deprecated
   @SuppressLint({"NewApi"})
   public void init(CordovaWebView var1, CordovaWebViewClient var2, CordovaChromeClient var3) {
      LOG.method_2(TAG, "CordovaActivity.init()");
      if(!this.preferences.getBoolean("ShowTitle", false)) {
         this.getWindow().requestFeature(1);
      }

      if(this.preferences.getBoolean("SetFullscreen", false)) {
         Log.d(TAG, "The SetFullscreen configuration is deprecated in favor of Fullscreen, and will be removed in a future version.");
         this.getWindow().setFlags(1024, 1024);
      } else if(this.preferences.getBoolean("Fullscreen", false)) {
         this.getWindow().setFlags(1024, 1024);
      } else {
         this.getWindow().setFlags(2048, 2048);
      }

      if(var1 == null) {
         var1 = this.makeWebView();
      }

      this.appView = var1;
      if(this.appView.pluginManager == null) {
         CordovaWebView var4 = this.appView;
         CordovaWebViewClient var5;
         if(var2 != null) {
            var5 = var2;
         } else {
            var5 = this.makeWebViewClient(this.appView);
         }

         CordovaChromeClient var6;
         if(var3 != null) {
            var6 = var3;
         } else {
            var6 = this.makeChromeClient(this.appView);
         }

         var4.init(this, var5, var6, this.pluginEntries, this.internalWhitelist, this.externalWhitelist, this.preferences);
      }

      if(this.preferences.getBoolean("DisallowOverscroll", false)) {
         this.appView.setOverScrollMode(2);
      }

      this.createViews();
      this.setVolumeControlStream(3);
   }

   @Deprecated
   public boolean isUrlWhiteListed(String var1) {
      return this.internalWhitelist.isUrlWhiteListed(var1);
   }

   protected void loadConfig() {
      ConfigXmlParser var1 = new ConfigXmlParser();
      var1.parse((Activity)this);
      this.preferences = var1.getPreferences();
      this.preferences.setPreferencesBundle(this.getIntent().getExtras());
      this.preferences.copyIntoIntentExtras(this);
      this.internalWhitelist = var1.getInternalWhitelist();
      this.externalWhitelist = var1.getExternalWhitelist();
      this.launchUrl = var1.getLaunchUrl();
      this.pluginEntries = var1.getPluginEntries();
      Config.parser = var1;
   }

   void loadSpinner() {
      String var1;
      if(this.appView != null && this.appView.canGoBack()) {
         var1 = this.preferences.getString("LoadingPageDialog", (String)null);
      } else {
         var1 = this.preferences.getString("LoadingDialog", (String)null);
      }

      if(var1 != null) {
         String var2 = "";
         String var3 = "Loading Application...";
         if(var1.length() > 0) {
            int var4 = var1.indexOf(44);
            if(var4 > 0) {
               var2 = var1.substring(0, var4);
               var3 = var1.substring(var4 + 1);
            } else {
               var2 = "";
               var3 = var1;
            }
         }

         this.spinnerStart(var2, var3);
      }

   }

   public void loadUrl(String var1) {
      if(this.appView == null) {
         this.init();
      }

      this.splashscreenTime = this.preferences.getInteger("SplashScreenDelay", this.splashscreenTime);
      String var2 = this.preferences.getString("SplashScreen", (String)null);
      if(this.splashscreenTime > 0 && var2 != null) {
         this.splashscreen = this.getResources().getIdentifier(var2, "drawable", this.getClass().getPackage().getName());
         if(this.splashscreen != 0) {
            this.showSplashScreen(this.splashscreenTime);
         }
      }

      this.keepRunning = this.preferences.getBoolean("KeepRunning", true);
      if(this.appView.getParent() != null) {
         this.loadSpinner();
      }

      if(this.splashscreen != 0) {
         this.appView.loadUrl(var1, this.splashscreenTime);
      } else {
         this.appView.loadUrl(var1);
      }
   }

   public void loadUrl(String var1, int var2) {
      this.splashscreenTime = var2;
      this.loadUrl(var1);
   }

   protected CordovaChromeClient makeChromeClient(CordovaWebView var1) {
      return var1.makeWebChromeClient(this);
   }

   protected CordovaWebView makeWebView() {
      return new CordovaWebView(this);
   }

   protected CordovaWebViewClient makeWebViewClient(CordovaWebView var1) {
      return var1.makeWebViewClient(this);
   }

   protected void onActivityResult(int var1, int var2, Intent var3) {
      LOG.method_2(TAG, "Incoming Result");
      super.onActivityResult(var1, var2, var3);
      Log.d(TAG, "Request code = " + var1);
      if(this.appView != null && var1 == 5173) {
         ValueCallback var6 = this.appView.getWebChromeClient().getValueCallback();
         Log.d(TAG, "did we get here?");
         if(var6 == null) {
            return;
         }

         Uri var8;
         if(var3 != null && var2 == -1) {
            var8 = var3.getData();
         } else {
            var8 = null;
         }

         Log.d(TAG, "result = " + var8);
         var6.onReceiveValue(var8);
      }

      CordovaPlugin var5 = this.activityResultCallback;
      if(var5 == null && this.initCallbackClass != null) {
         this.activityResultCallback = this.appView.pluginManager.getPlugin(this.initCallbackClass);
         var5 = this.activityResultCallback;
      }

      if(var5 != null) {
         LOG.method_2(TAG, "We have a callback to send this result to");
         var5.onActivityResult(var1, var2, var3);
      }
   }

   public void onCreate(Bundle var1) {
      LOG.method_8(TAG, "Apache Cordova native platform version 3.6.3 is starting");
      LOG.method_2(TAG, "CordovaActivity.onCreate()");
      super.onCreate(var1);
      if(var1 != null) {
         this.initCallbackClass = var1.getString("callbackClass");
      }

      this.loadConfig();
   }

   public boolean onCreateOptionsMenu(Menu var1) {
      this.postMessage("onCreateOptionsMenu", var1);
      return super.onCreateOptionsMenu(var1);
   }

   public void onDestroy() {
      LOG.method_2(TAG, "CordovaActivity.onDestroy()");
      super.onDestroy();
      this.removeSplashScreen();
      if(this.appView != null) {
         this.appView.handleDestroy();
      } else {
         this.activityState = ACTIVITY_EXITING;
      }
   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      return this.appView == null || this.appView.getFocusedChild() == null || var1 != 4 && var1 != 82?super.onKeyDown(var1, var2):this.appView.onKeyDown(var1, var2);
   }

   public boolean onKeyUp(int var1, KeyEvent var2) {
      return this.appView == null || !this.appView.isCustomViewShowing() && this.appView.getFocusedChild() == null || var1 != 4 && var1 != 82?super.onKeyUp(var1, var2):this.appView.onKeyUp(var1, var2);
   }

   public Object onMessage(String var1, Object var2) {
      if(!"onScrollChanged".equals(var1)) {
         LOG.method_2(TAG, "onMessage(" + var1 + "," + var2 + ")");
      }

      if("splashscreen".equals(var1)) {
         if("hide".equals(var2.toString())) {
            this.removeSplashScreen();
         } else if(this.splashDialog == null || !this.splashDialog.isShowing()) {
            String var5 = this.preferences.getString("SplashScreen", (String)null);
            if(var5 != null) {
               this.splashscreen = this.getResources().getIdentifier(var5, "drawable", this.getClass().getPackage().getName());
            }

            this.showSplashScreen(this.splashscreenTime);
            return null;
         }
      } else if("spinner".equals(var1)) {
         if("stop".equals(var2.toString())) {
            this.spinnerStop();
            this.appView.setVisibility(0);
            return null;
         }
      } else {
         if("onReceivedError".equals(var1)) {
            JSONObject var3 = (JSONObject)var2;

            try {
               this.onReceivedError(var3.getInt("errorCode"), var3.getString("description"), var3.getString("url"));
               return null;
            } catch (JSONException var6) {
               var6.printStackTrace();
               return null;
            }
         }

         if("exit".equals(var1)) {
            this.endActivity();
            return null;
         }
      }

      return null;
   }

   protected void onNewIntent(Intent var1) {
      super.onNewIntent(var1);
      if(this.appView != null) {
         this.appView.onNewIntent(var1);
      }

   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      this.postMessage("onOptionsItemSelected", var1);
      return true;
   }

   protected void onPause() {
      super.onPause();
      LOG.method_2(TAG, "Paused the application!");
      if(this.activityState != ACTIVITY_EXITING && this.appView != null) {
         this.appView.handlePause(this.keepRunning);
         this.removeSplashScreen();
      }
   }

   public boolean onPrepareOptionsMenu(Menu var1) {
      this.postMessage("onPrepareOptionsMenu", var1);
      return true;
   }

   public void onReceivedError(int var1, final String var2, final String var3) {
      final String var4 = this.preferences.getString("errorUrl", (String)null);
      if(var4 != null && (var4.startsWith("file://") || this.internalWhitelist.isUrlWhiteListed(var4)) && !var3.equals(var4)) {
         this.runOnUiThread(new Runnable() {
            public void run() {
               CordovaActivity.this.spinnerStop();
               CordovaActivity.this.appView.showWebPage(var4, false, true, (HashMap)null);
            }
         });
      } else {
         final boolean var5;
         if(var1 != -2) {
            var5 = true;
         } else {
            var5 = false;
         }

         this.runOnUiThread(new Runnable() {
            public void run() {
               if(var5) {
                  CordovaActivity.this.appView.setVisibility(8);
                  CordovaActivity.this.displayError("Application Error", var2 + " (" + var3 + ")", "OK", var5);
               }

            }
         });
      }
   }

   protected void onResume() {
      super.onResume();
      LOG.method_2(TAG, "Resuming the App");
      if(this.activityState == ACTIVITY_STARTING) {
         this.activityState = ACTIVITY_RUNNING;
      } else if(this.appView != null) {
         this.getWindow().getDecorView().requestFocus();
         this.appView.handleResume(this.keepRunning, this.activityResultKeepRunning);
         if((!this.keepRunning || this.activityResultKeepRunning) && this.activityResultKeepRunning) {
            this.keepRunning = this.activityResultKeepRunning;
            this.activityResultKeepRunning = false;
            return;
         }
      }

   }

   protected void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      if(this.activityResultCallback != null) {
         var1.putString("callbackClass", this.activityResultCallback.getClass().getName());
      }

   }

   public void postMessage(String var1, Object var2) {
      if(this.appView != null) {
         this.appView.postMessage(var1, var2);
      }

   }

   public AuthenticationToken removeAuthenticationToken(String var1, String var2) {
      return this.appView != null && this.appView.viewClient != null?this.appView.viewClient.removeAuthenticationToken(var1, var2):null;
   }

   public void removeSplashScreen() {
      if(this.splashDialog != null && this.splashDialog.isShowing()) {
         this.splashDialog.dismiss();
         this.splashDialog = null;
      }

   }

   @Deprecated
   public void sendJavascript(String var1) {
      if(this.appView != null) {
         this.appView.bridge.getMessageQueue().addJavaScript(var1);
      }

   }

   public void setActivityResultCallback(CordovaPlugin var1) {
      this.activityResultCallback = var1;
   }

   public void setAuthenticationToken(AuthenticationToken var1, String var2, String var3) {
      if(this.appView != null && this.appView.viewClient != null) {
         this.appView.viewClient.setAuthenticationToken(var1, var2, var3);
      }

   }

   @Deprecated
   public void setBooleanProperty(String var1, boolean var2) {
      Log.d(TAG, "Setting boolean properties in CordovaActivity will be deprecated in 3.0 on July 2013, please use config.xml");
      this.getIntent().putExtra(var1.toLowerCase(), var2);
   }

   @Deprecated
   public void setDoubleProperty(String var1, double var2) {
      Log.d(TAG, "Setting double properties in CordovaActivity will be deprecated in 3.0 on July 2013, please use config.xml");
      this.getIntent().putExtra(var1.toLowerCase(), var2);
   }

   @Deprecated
   public void setIntegerProperty(String var1, int var2) {
      Log.d(TAG, "Setting integer properties in CordovaActivity will be deprecated in 3.0 on July 2013, please use config.xml");
      this.getIntent().putExtra(var1.toLowerCase(), var2);
   }

   @Deprecated
   public void setStringProperty(String var1, String var2) {
      Log.d(TAG, "Setting string properties in CordovaActivity will be deprecated in 3.0 on July 2013, please use config.xml");
      this.getIntent().putExtra(var1.toLowerCase(), var2);
   }

   protected void showSplashScreen(final int var1) {
      this.runOnUiThread(new Runnable() {
         public void run() {
            Display var1x = CordovaActivity.this.getWindowManager().getDefaultDisplay();
            LinearLayout var2 = new LinearLayout(CordovaActivity.this.getActivity());
            var2.setMinimumHeight(var1x.getHeight());
            var2.setMinimumWidth(var1x.getWidth());
            var2.setOrientation(1);
            var2.setBackgroundColor(CordovaActivity.this.preferences.getInteger("backgroundColor", -16777216));
            var2.setLayoutParams(new LayoutParams(-1, -1, 0.0F));
            var2.setBackgroundResource(CordovaActivity.this.splashscreen);
            CordovaActivity.this.splashDialog = new Dialog(CordovaActivity.this, 16973840);
            if((1024 & CordovaActivity.this.getWindow().getAttributes().flags) == 1024) {
               CordovaActivity.this.splashDialog.getWindow().setFlags(1024, 1024);
            }

            CordovaActivity.this.splashDialog.setContentView(var2);
            CordovaActivity.this.splashDialog.setCancelable(false);
            CordovaActivity.this.splashDialog.show();
            (new Handler()).postDelayed(new Runnable() {
               public void run() {
                  CordovaActivity.this.removeSplashScreen();
               }
            }, (long)var1);
         }
      });
   }

   @Deprecated
   public void showWebPage(String var1, boolean var2, boolean var3, HashMap<String, Object> var4) {
      if(this.appView != null) {
         this.appView.showWebPage(var1, var2, var3, var4);
      }

   }

   public void spinnerStart(String var1, String var2) {
      if(this.spinnerDialog != null) {
         this.spinnerDialog.dismiss();
         this.spinnerDialog = null;
      }

      this.spinnerDialog = ProgressDialog.show(this, var1, var2, true, true, new OnCancelListener() {
         public void onCancel(DialogInterface var1) {
            CordovaActivity.this.spinnerDialog = null;
         }
      });
   }

   public void spinnerStop() {
      if(this.spinnerDialog != null && this.spinnerDialog.isShowing()) {
         this.spinnerDialog.dismiss();
         this.spinnerDialog = null;
      }

   }

   public void startActivityForResult(CordovaPlugin var1, Intent var2, int var3) {
      this.activityResultCallback = var1;
      this.activityResultKeepRunning = this.keepRunning;
      if(var1 != null) {
         this.keepRunning = false;
      }

      super.startActivityForResult(var2, var3);
   }
}
