package org.apache.cordova.inappbrowser;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings.PluginState;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.util.HashMap;
import java.util.StringTokenizer;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.Config;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginResult;
import org.apache.cordova.inappbrowser.InAppBrowserDialog;
import org.apache.cordova.inappbrowser.InAppChromeClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"SetJavaScriptEnabled"})
public class InAppBrowser extends CordovaPlugin {
   private static final String CLEAR_ALL_CACHE = "clearcache";
   private static final String CLEAR_SESSION_CACHE = "clearsessioncache";
   private static final String CLOSE_BUTTON_CAPTION = "closebuttoncaption";
   private static final String EXIT_EVENT = "exit";
   private static final String HIDDEN = "hidden";
   private static final String LOAD_ERROR_EVENT = "loaderror";
   private static final String LOAD_START_EVENT = "loadstart";
   private static final String LOAD_STOP_EVENT = "loadstop";
   private static final String LOCATION = "location";
   protected static final String LOG_TAG = "InAppBrowser";
   private static final String NULL = "null";
   private static final String SELF = "_self";
   private static final String SYSTEM = "_system";
   private String buttonLabel = "Done";
   private CallbackContext callbackContext;
   private boolean clearAllCache = false;
   private boolean clearSessionCache = false;
   private InAppBrowserDialog dialog;
   private EditText edittext;
   private WebView inAppWebView;
   private boolean openWindowHidden = false;
   private boolean showLocationBar = true;

   private InAppBrowser getInAppBrowser() {
      return this;
   }

   private boolean getShowLocationBar() {
      return this.showLocationBar;
   }

   private void goBack() {
      if(this.inAppWebView.canGoBack()) {
         this.inAppWebView.goBack();
      }

   }

   private void goForward() {
      if(this.inAppWebView.canGoForward()) {
         this.inAppWebView.goForward();
      }

   }

   private void injectDeferredObject(String var1, String var2) {
      final String var6;
      if(var2 != null) {
         JSONArray var3 = new JSONArray();
         var3.put(var1);
         String var5 = var3.toString();
         var6 = String.format(var2, new Object[]{var5.substring(1, -1 + var5.length())});
      } else {
         var6 = var1;
      }

      this.cordova.getActivity().runOnUiThread(new Runnable() {
         @SuppressLint({"NewApi"})
         public void run() {
            if(VERSION.SDK_INT < 19) {
               InAppBrowser.this.inAppWebView.loadUrl("javascript:" + var6);
            } else {
               InAppBrowser.this.inAppWebView.evaluateJavascript(var6, (ValueCallback)null);
            }
         }
      });
   }

   private void navigate(String var1) {
      ((InputMethodManager)this.cordova.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.edittext.getWindowToken(), 0);
      if(!var1.startsWith("http") && !var1.startsWith("file:")) {
         this.inAppWebView.loadUrl("http://" + var1);
      } else {
         this.inAppWebView.loadUrl(var1);
      }

      this.inAppWebView.requestFocus();
   }

   private HashMap<String, Boolean> parseFeature(String var1) {
      HashMap var2;
      if(var1.equals("null")) {
         var2 = null;
      } else {
         var2 = new HashMap();
         StringTokenizer var3 = new StringTokenizer(var1, ",");

         while(var3.hasMoreElements()) {
            StringTokenizer var4 = new StringTokenizer(var3.nextToken(), "=");
            if(var4.hasMoreElements()) {
               String var5 = var4.nextToken();
               if(var5.equalsIgnoreCase("closebuttoncaption")) {
                  this.buttonLabel = var4.nextToken();
               } else {
                  Boolean var6;
                  if(var4.nextToken().equals("no")) {
                     var6 = Boolean.FALSE;
                  } else {
                     var6 = Boolean.TRUE;
                  }

                  var2.put(var5, var6);
               }
            }
         }
      }

      return var2;
   }

   private void sendUpdate(JSONObject var1, boolean var2) {
      this.sendUpdate(var1, var2, PluginResult.Status.field_13);
   }

   private void sendUpdate(JSONObject var1, boolean var2, PluginResult.Status var3) {
      if(this.callbackContext != null) {
         PluginResult var4 = new PluginResult(var3, var1);
         var4.setKeepCallback(var2);
         this.callbackContext.sendPluginResult(var4);
         if(!var2) {
            this.callbackContext = null;
         }
      }

   }

   public void closeDialog() {
      final WebView var1 = this.inAppWebView;
      if(var1 != null) {
         this.cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
               var1.setWebViewClient(new WebViewClient() {
                  public void onPageFinished(WebView var1x, String var2) {
                     if(InAppBrowser.this.dialog != null) {
                        InAppBrowser.this.dialog.dismiss();
                     }

                  }
               });
               var1.loadUrl("about:blank");
            }
         });

         try {
            JSONObject var2 = new JSONObject();
            var2.put("type", "exit");
            this.sendUpdate(var2, false);
         } catch (JSONException var4) {
            Log.d("InAppBrowser", "Should never happen");
         }
      }
   }

   public boolean execute(String var1, CordovaArgs var2, final CallbackContext var3) throws JSONException {
      boolean var5;
      if(var1.equals("open")) {
         this.callbackContext = var3;
         final String var16 = var2.getString(0);
         final String var17 = var2.optString(1);
         if(var17 == null || var17.equals("") || var17.equals("null")) {
            var17 = "_self";
         }

         final HashMap var19 = this.parseFeature(var2.optString(2));
         Log.d("InAppBrowser", "target = " + var17);
         this.cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
               String var1 = "";
               if("_self".equals(var17)) {
                  Log.d("InAppBrowser", "in self");
                  if(!var16.startsWith("file://") && !var16.startsWith("javascript:") && !Config.isUrlWhiteListed(var16)) {
                     if(var16.startsWith("tel:")) {
                        try {
                           Intent var6 = new Intent("android.intent.action.DIAL");
                           var6.setData(Uri.parse(var16));
                           InAppBrowser.this.cordova.getActivity().startActivity(var6);
                        } catch (ActivityNotFoundException var8) {
                           LOG.method_5("InAppBrowser", "Error dialing " + var16 + ": " + var8.toString());
                        }
                     } else {
                        var1 = InAppBrowser.this.showWebPage(var16, var19);
                     }
                  } else {
                     InAppBrowser.this.webView.loadUrl(var16);
                  }
               } else if("_system".equals(var17)) {
                  Log.d("InAppBrowser", "in system");
                  var1 = InAppBrowser.this.openExternal(var16);
               } else {
                  Log.d("InAppBrowser", "in blank");
                  var1 = InAppBrowser.this.showWebPage(var16, var19);
               }

               PluginResult var3x = new PluginResult(PluginResult.Status.field_13, var1);
               var3x.setKeepCallback(true);
               var3.sendPluginResult(var3x);
            }
         });
      } else if(var1.equals("close")) {
         this.closeDialog();
      } else if(var1.equals("injectScriptCode")) {
         boolean var13 = var2.getBoolean(1);
         String var14 = null;
         if(var13) {
            Object[] var15 = new Object[]{var3.getCallbackId()};
            var14 = String.format("prompt(JSON.stringify([eval(%%s)]), \'gap-iab://%s\')", var15);
         }

         this.injectDeferredObject(var2.getString(0), var14);
      } else if(var1.equals("injectScriptFile")) {
         String var11;
         if(var2.getBoolean(1)) {
            Object[] var12 = new Object[]{var3.getCallbackId()};
            var11 = String.format("(function(d) { var c = d.createElement(\'script\'); c.src = %%s; c.onload = function() { prompt(\'\', \'gap-iab://%s\'); }; d.body.appendChild(c); })(document)", var12);
         } else {
            var11 = "(function(d) { var c = d.createElement(\'script\'); c.src = %s; d.body.appendChild(c); })(document)";
         }

         this.injectDeferredObject(var2.getString(0), var11);
      } else if(var1.equals("injectStyleCode")) {
         String var9;
         if(var2.getBoolean(1)) {
            Object[] var10 = new Object[]{var3.getCallbackId()};
            var9 = String.format("(function(d) { var c = d.createElement(\'style\'); c.innerHTML = %%s; d.body.appendChild(c); prompt(\'\', \'gap-iab://%s\');})(document)", var10);
         } else {
            var9 = "(function(d) { var c = d.createElement(\'style\'); c.innerHTML = %s; d.body.appendChild(c); })(document)";
         }

         this.injectDeferredObject(var2.getString(0), var9);
      } else if(var1.equals("injectStyleFile")) {
         String var7;
         if(var2.getBoolean(1)) {
            Object[] var8 = new Object[]{var3.getCallbackId()};
            var7 = String.format("(function(d) { var c = d.createElement(\'link\'); c.rel=\'stylesheet\'; c.type=\'text/css\'; c.href = %%s; d.head.appendChild(c); prompt(\'\', \'gap-iab://%s\');})(document)", var8);
         } else {
            var7 = "(function(d) { var c = d.createElement(\'link\'); c.rel=\'stylesheet\'; c.type=\'text/css\'; c.href = %s; d.head.appendChild(c); })(document)";
         }

         this.injectDeferredObject(var2.getString(0), var7);
      } else {
         boolean var4 = var1.equals("show");
         var5 = false;
         if(!var4) {
            return var5;
         }

         this.cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
               InAppBrowser.this.dialog.show();
            }
         });
         PluginResult var6 = new PluginResult(PluginResult.Status.field_13);
         var6.setKeepCallback(true);
         this.callbackContext.sendPluginResult(var6);
      }

      var5 = true;
      return var5;
   }

   public void onDestroy() {
      this.closeDialog();
   }

   public void onReset() {
      this.closeDialog();
   }

   public String openExternal(String param1) {
      // $FF: Couldn't be decompiled
   }

   public String showWebPage(final String var1, HashMap<String, Boolean> var2) {
      this.showLocationBar = true;
      this.openWindowHidden = false;
      if(var2 != null) {
         Boolean var4 = (Boolean)var2.get("location");
         if(var4 != null) {
            this.showLocationBar = var4.booleanValue();
         }

         Boolean var5 = (Boolean)var2.get("hidden");
         if(var5 != null) {
            this.openWindowHidden = var5.booleanValue();
         }

         Boolean var6 = (Boolean)var2.get("clearcache");
         if(var6 != null) {
            this.clearAllCache = var6.booleanValue();
         } else {
            Boolean var7 = (Boolean)var2.get("clearsessioncache");
            if(var7 != null) {
               this.clearSessionCache = var7.booleanValue();
            }
         }
      }

      Runnable var3 = new Runnable() {
         // $FF: synthetic field
         final CordovaWebView val$thatWebView;

         {
            this.val$thatWebView = var3;
         }

         private int dpToPixels(int var1x) {
            return (int)TypedValue.applyDimension(1, (float)var1x, InAppBrowser.this.cordova.getActivity().getResources().getDisplayMetrics());
         }

         public void run() {
            InAppBrowser.this.dialog = new InAppBrowserDialog(InAppBrowser.this.cordova.getActivity(), 16973830);
            InAppBrowser.this.dialog.getWindow().getAttributes().windowAnimations = 16973826;
            InAppBrowser.this.dialog.requestWindowFeature(1);
            InAppBrowser.this.dialog.setCancelable(true);
            InAppBrowser.this.dialog.setInAppBroswer(InAppBrowser.this.getInAppBrowser());
            LinearLayout var3 = new LinearLayout(InAppBrowser.this.cordova.getActivity());
            var3.setOrientation(1);
            RelativeLayout var4 = new RelativeLayout(InAppBrowser.this.cordova.getActivity());
            var4.setBackgroundColor(-3355444);
            var4.setLayoutParams(new LayoutParams(-1, this.dpToPixels(44)));
            var4.setPadding(this.dpToPixels(2), this.dpToPixels(2), this.dpToPixels(2), this.dpToPixels(2));
            var4.setHorizontalGravity(3);
            var4.setVerticalGravity(48);
            RelativeLayout var5 = new RelativeLayout(InAppBrowser.this.cordova.getActivity());
            var5.setLayoutParams(new LayoutParams(-2, -2));
            var5.setHorizontalGravity(3);
            var5.setVerticalGravity(16);
            var5.setId(1);
            Button var6 = new Button(InAppBrowser.this.cordova.getActivity());
            LayoutParams var7 = new LayoutParams(-2, -1);
            var7.addRule(5);
            var6.setLayoutParams(var7);
            var6.setContentDescription("Back Button");
            var6.setId(2);
            Resources var8 = InAppBrowser.this.cordova.getActivity().getResources();
            Drawable var9 = var8.getDrawable(var8.getIdentifier("ic_action_previous_item", "drawable", InAppBrowser.this.cordova.getActivity().getPackageName()));
            if(VERSION.SDK_INT < 16) {
               var6.setBackgroundDrawable(var9);
            } else {
               var6.setBackground(var9);
            }

            OnClickListener var10 = new OnClickListener() {
               public void onClick(View var1x) {
                  InAppBrowser.this.goBack();
               }
            };
            var6.setOnClickListener(var10);
            Button var11 = new Button(InAppBrowser.this.cordova.getActivity());
            LayoutParams var12 = new LayoutParams(-2, -1);
            var12.addRule(1, 2);
            var11.setLayoutParams(var12);
            var11.setContentDescription("Forward Button");
            var11.setId(3);
            Drawable var13 = var8.getDrawable(var8.getIdentifier("ic_action_next_item", "drawable", InAppBrowser.this.cordova.getActivity().getPackageName()));
            if(VERSION.SDK_INT < 16) {
               var11.setBackgroundDrawable(var13);
            } else {
               var11.setBackground(var13);
            }

            OnClickListener var14 = new OnClickListener() {
               public void onClick(View var1x) {
                  InAppBrowser.this.goForward();
               }
            };
            var11.setOnClickListener(var14);
            InAppBrowser.this.edittext = new EditText(InAppBrowser.this.cordova.getActivity());
            LayoutParams var16 = new LayoutParams(-1, -1);
            var16.addRule(1, 1);
            var16.addRule(0, 5);
            InAppBrowser.this.edittext.setLayoutParams(var16);
            InAppBrowser.this.edittext.setId(4);
            InAppBrowser.this.edittext.setSingleLine(true);
            InAppBrowser.this.edittext.setText(var1);
            InAppBrowser.this.edittext.setInputType(16);
            InAppBrowser.this.edittext.setImeOptions(2);
            InAppBrowser.this.edittext.setInputType(0);
            EditText var17 = InAppBrowser.this.edittext;
            OnKeyListener var18 = new OnKeyListener() {
               public boolean onKey(View var1x, int var2, KeyEvent var3) {
                  if(var3.getAction() == 0 && var2 == 66) {
                     InAppBrowser.this.navigate(InAppBrowser.this.edittext.getText().toString());
                     return true;
                  } else {
                     return false;
                  }
               }
            };
            var17.setOnKeyListener(var18);
            Button var19 = new Button(InAppBrowser.this.cordova.getActivity());
            LayoutParams var20 = new LayoutParams(-2, -1);
            var20.addRule(11);
            var19.setLayoutParams(var20);
            var11.setContentDescription("Close Button");
            var19.setId(5);
            Drawable var21 = var8.getDrawable(var8.getIdentifier("ic_action_remove", "drawable", InAppBrowser.this.cordova.getActivity().getPackageName()));
            if(VERSION.SDK_INT < 16) {
               var19.setBackgroundDrawable(var21);
            } else {
               var19.setBackground(var21);
            }

            OnClickListener var22 = new OnClickListener() {
               public void onClick(View var1x) {
                  InAppBrowser.this.closeDialog();
               }
            };
            var19.setOnClickListener(var22);
            InAppBrowser.this.inAppWebView = new WebView(InAppBrowser.this.cordova.getActivity());
            InAppBrowser.this.inAppWebView.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -1));
            InAppBrowser.this.inAppWebView.setWebChromeClient(new InAppChromeClient(this.val$thatWebView));
            InAppBrowser.InAppBrowserClient var24 = InAppBrowser.this.new InAppBrowserClient(this.val$thatWebView, InAppBrowser.this.edittext);
            InAppBrowser.this.inAppWebView.setWebViewClient(var24);
            WebSettings var25 = InAppBrowser.this.inAppWebView.getSettings();
            var25.setJavaScriptEnabled(true);
            var25.setJavaScriptCanOpenWindowsAutomatically(true);
            var25.setBuiltInZoomControls(true);
            var25.setPluginState(PluginState.ON);
            Bundle var26 = InAppBrowser.this.cordova.getActivity().getIntent().getExtras();
            boolean var27;
            if(var26 == null) {
               var27 = true;
            } else {
               var27 = var26.getBoolean("InAppBrowserStorageEnabled", true);
            }

            if(var27) {
               var25.setDatabasePath(InAppBrowser.this.cordova.getActivity().getApplicationContext().getDir("inAppBrowserDB", 0).getPath());
               var25.setDatabaseEnabled(true);
            }

            var25.setDomStorageEnabled(true);
            if(InAppBrowser.this.clearAllCache) {
               CookieManager.getInstance().removeAllCookie();
            } else if(InAppBrowser.this.clearSessionCache) {
               CookieManager.getInstance().removeSessionCookie();
            }

            InAppBrowser.this.inAppWebView.loadUrl(var1);
            InAppBrowser.this.inAppWebView.setId(6);
            InAppBrowser.this.inAppWebView.getSettings().setLoadWithOverviewMode(true);
            InAppBrowser.this.inAppWebView.getSettings().setUseWideViewPort(true);
            InAppBrowser.this.inAppWebView.requestFocus();
            InAppBrowser.this.inAppWebView.requestFocusFromTouch();
            var5.addView(var6);
            var5.addView(var11);
            var4.addView(var5);
            var4.addView(InAppBrowser.this.edittext);
            var4.addView(var19);
            if(InAppBrowser.this.getShowLocationBar()) {
               var3.addView(var4);
            }

            var3.addView(InAppBrowser.this.inAppWebView);
            android.view.WindowManager.LayoutParams var30 = new android.view.WindowManager.LayoutParams();
            var30.copyFrom(InAppBrowser.this.dialog.getWindow().getAttributes());
            var30.width = -1;
            var30.height = -1;
            InAppBrowser.this.dialog.setContentView(var3);
            InAppBrowser.this.dialog.show();
            InAppBrowser.this.dialog.getWindow().setAttributes(var30);
            if(InAppBrowser.this.openWindowHidden) {
               InAppBrowser.this.dialog.hide();
            }

         }
      };
      this.cordova.getActivity().runOnUiThread(var3);
      return "";
   }

   public class InAppBrowserClient extends WebViewClient {
      EditText edittext;
      CordovaWebView webView;

      public InAppBrowserClient(CordovaWebView var2, EditText var3) {
         this.webView = var2;
         this.edittext = var3;
      }

      public void onPageFinished(WebView var1, String var2) {
         super.onPageFinished(var1, var2);

         try {
            JSONObject var3 = new JSONObject();
            var3.put("type", "loadstop");
            var3.put("url", var2);
            InAppBrowser.this.sendUpdate(var3, true);
         } catch (JSONException var5) {
            Log.d("InAppBrowser", "Should never happen");
         }
      }

      public void onPageStarted(WebView param1, String param2, Bitmap param3) {
         // $FF: Couldn't be decompiled
      }

      public void onReceivedError(WebView var1, int var2, String var3, String var4) {
         super.onReceivedError(var1, var2, var3, var4);

         try {
            JSONObject var5 = new JSONObject();
            var5.put("type", "loaderror");
            var5.put("url", var4);
            var5.put("code", var2);
            var5.put("message", var3);
            InAppBrowser.this.sendUpdate(var5, true, PluginResult.Status.ERROR);
         } catch (JSONException var7) {
            Log.d("InAppBrowser", "Should never happen");
         }
      }
   }
}
