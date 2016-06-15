package org.apache.cordova;

import android.content.Intent;
import android.net.Uri;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPreferences;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

public class CordovaPlugin {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   public CordovaInterface cordova;
   // $FF: renamed from: id java.lang.String
   @Deprecated
   public String field_3;
   protected CordovaPreferences preferences;
   public CordovaWebView webView;

   static {
      boolean var0;
      if(!CordovaPlugin.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
   }

   public boolean execute(String var1, String var2, CallbackContext var3) throws JSONException {
      return this.execute(var1, new JSONArray(var2), var3);
   }

   public boolean execute(String var1, CordovaArgs var2, CallbackContext var3) throws JSONException {
      return false;
   }

   public boolean execute(String var1, JSONArray var2, CallbackContext var3) throws JSONException {
      return this.execute(var1, new CordovaArgs(var2), var3);
   }

   public void initialize(CordovaInterface var1, CordovaWebView var2) {
   }

   public void onActivityResult(int var1, int var2, Intent var3) {
   }

   public void onDestroy() {
   }

   public Object onMessage(String var1, Object var2) {
      return null;
   }

   public void onNewIntent(Intent var1) {
   }

   public boolean onOverrideUrlLoading(String var1) {
      return false;
   }

   public void onPause(boolean var1) {
   }

   public void onReset() {
   }

   public void onResume(boolean var1) {
   }

   protected void pluginInitialize() {
   }

   public final void privateInitialize(CordovaInterface var1, CordovaWebView var2, CordovaPreferences var3) {
      if(!$assertionsDisabled && this.cordova != null) {
         throw new AssertionError();
      } else {
         this.cordova = var1;
         this.webView = var2;
         this.preferences = var3;
         this.initialize(var1, var2);
         this.pluginInitialize();
      }
   }

   public Uri remapUri(Uri var1) {
      return null;
   }
}
