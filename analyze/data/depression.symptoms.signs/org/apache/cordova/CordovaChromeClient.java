package org.apache.cordova;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;

public class CordovaChromeClient extends WebChromeClient {
   public static final int FILECHOOSER_RESULTCODE = 5173;
   private long MAX_QUOTA = 104857600L;
   private String TAG = "CordovaLog";
   protected CordovaWebView appView;
   protected CordovaInterface cordova;
   public ValueCallback<Uri> mUploadMessage;
   private View mVideoProgressView;

   @Deprecated
   public CordovaChromeClient(CordovaInterface var1) {
      this.cordova = var1;
   }

   public CordovaChromeClient(CordovaInterface var1, CordovaWebView var2) {
      this.cordova = var1;
      this.appView = var2;
   }

   public ValueCallback<Uri> getValueCallback() {
      return this.mUploadMessage;
   }

   public View getVideoLoadingProgressView() {
      if(this.mVideoProgressView == null) {
         LinearLayout var1 = new LinearLayout(this.appView.getContext());
         var1.setOrientation(1);
         LayoutParams var2 = new LayoutParams(-2, -2);
         var2.addRule(13);
         var1.setLayoutParams(var2);
         ProgressBar var3 = new ProgressBar(this.appView.getContext());
         android.widget.LinearLayout.LayoutParams var4 = new android.widget.LinearLayout.LayoutParams(-2, -2);
         var4.gravity = 17;
         var3.setLayoutParams(var4);
         var1.addView(var3);
         this.mVideoProgressView = var1;
      }

      return this.mVideoProgressView;
   }

   public void onConsoleMessage(String var1, int var2, String var3) {
      if(VERSION.SDK_INT == 7) {
         String var4 = this.TAG;
         Object[] var5 = new Object[]{var3, Integer.valueOf(var2), var1};
         LOG.method_4(var4, "%s: Line %d : %s", var5);
         super.onConsoleMessage(var1, var2, var3);
      }

   }

   @TargetApi(8)
   public boolean onConsoleMessage(ConsoleMessage var1) {
      if(var1.message() != null) {
         String var2 = this.TAG;
         Object[] var3 = new Object[]{var1.sourceId(), Integer.valueOf(var1.lineNumber()), var1.message()};
         LOG.method_4(var2, "%s: Line %d : %s", var3);
      }

      return super.onConsoleMessage(var1);
   }

   public void onExceededDatabaseQuota(String var1, String var2, long var3, long var5, long var7, QuotaUpdater var9) {
      String var10 = this.TAG;
      Object[] var11 = new Object[]{Long.valueOf(var5), Long.valueOf(var3), Long.valueOf(var7)};
      LOG.method_4(var10, "onExceededDatabaseQuota estimatedSize: %d  currentQuota: %d  totalUsedQuota: %d", var11);
      var9.updateQuota(this.MAX_QUOTA);
   }

   public void onGeolocationPermissionsShowPrompt(String var1, Callback var2) {
      super.onGeolocationPermissionsShowPrompt(var1, var2);
      var2.invoke(var1, true, false);
   }

   public void onHideCustomView() {
      this.appView.hideCustomView();
   }

   public boolean onJsAlert(WebView var1, String var2, String var3, final JsResult var4) {
      Builder var5 = new Builder(this.cordova.getActivity());
      var5.setMessage(var3);
      var5.setTitle("Alert");
      var5.setCancelable(true);
      var5.setPositiveButton(17039370, new OnClickListener() {
         public void onClick(DialogInterface var1, int var2) {
            var4.confirm();
         }
      });
      var5.setOnCancelListener(new OnCancelListener() {
         public void onCancel(DialogInterface var1) {
            var4.cancel();
         }
      });
      var5.setOnKeyListener(new OnKeyListener() {
         public boolean onKey(DialogInterface var1, int var2, KeyEvent var3) {
            if(var2 == 4) {
               var4.confirm();
               return false;
            } else {
               return true;
            }
         }
      });
      var5.show();
      return true;
   }

   public boolean onJsConfirm(WebView var1, String var2, String var3, final JsResult var4) {
      Builder var5 = new Builder(this.cordova.getActivity());
      var5.setMessage(var3);
      var5.setTitle("Confirm");
      var5.setCancelable(true);
      var5.setPositiveButton(17039370, new OnClickListener() {
         public void onClick(DialogInterface var1, int var2) {
            var4.confirm();
         }
      });
      var5.setNegativeButton(17039360, new OnClickListener() {
         public void onClick(DialogInterface var1, int var2) {
            var4.cancel();
         }
      });
      var5.setOnCancelListener(new OnCancelListener() {
         public void onCancel(DialogInterface var1) {
            var4.cancel();
         }
      });
      var5.setOnKeyListener(new OnKeyListener() {
         public boolean onKey(DialogInterface var1, int var2, KeyEvent var3) {
            if(var2 == 4) {
               var4.cancel();
               return false;
            } else {
               return true;
            }
         }
      });
      var5.show();
      return true;
   }

   public boolean onJsPrompt(WebView var1, String var2, String var3, String var4, final JsPromptResult var5) {
      String var6 = this.appView.bridge.promptOnJsPrompt(var2, var3, var4);
      if(var6 != null) {
         var5.confirm(var6);
      } else {
         Builder var7 = new Builder(this.cordova.getActivity());
         var7.setMessage(var3);
         final EditText var9 = new EditText(this.cordova.getActivity());
         if(var4 != null) {
            var9.setText(var4);
         }

         var7.setView(var9);
         var7.setCancelable(false);
         var7.setPositiveButton(17039370, new OnClickListener() {
            public void onClick(DialogInterface var1, int var2) {
               String var3 = var9.getText().toString();
               var5.confirm(var3);
            }
         });
         var7.setNegativeButton(17039360, new OnClickListener() {
            public void onClick(DialogInterface var1, int var2) {
               var5.cancel();
            }
         });
         var7.show();
      }

      return true;
   }

   public void onShowCustomView(View var1, CustomViewCallback var2) {
      this.appView.showCustomView(var1, var2);
   }

   public void openFileChooser(ValueCallback<Uri> var1) {
      this.openFileChooser(var1, "*/*");
   }

   public void openFileChooser(ValueCallback<Uri> var1, String var2) {
      this.openFileChooser(var1, var2, (String)null);
   }

   public void openFileChooser(ValueCallback<Uri> var1, String var2, String var3) {
      this.mUploadMessage = var1;
      Intent var4 = new Intent("android.intent.action.GET_CONTENT");
      var4.addCategory("android.intent.category.OPENABLE");
      var4.setType("*/*");
      this.cordova.getActivity().startActivityForResult(Intent.createChooser(var4, "File Browser"), 5173);
   }

   @Deprecated
   public void setWebView(CordovaWebView var1) {
      this.appView = var1;
   }
}
