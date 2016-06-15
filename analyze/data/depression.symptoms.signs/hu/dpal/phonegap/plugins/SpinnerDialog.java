package hu.dpal.phonegap.plugins;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class SpinnerDialog extends CordovaPlugin {
   public ProgressDialog spinnerDialog = null;

   public boolean execute(String var1, JSONArray var2, CallbackContext var3) throws JSONException {
      if(var1.equals("show")) {
         final String var5;
         if(var2.getString(0) == "null") {
            var5 = null;
         } else {
            var5 = var2.getString(0);
         }

         final String var6;
         if(var2.getString(1) == "null") {
            var6 = null;
         } else {
            var6 = var2.getString(1);
         }

         if(this.spinnerDialog != null) {
            this.spinnerDialog.dismiss();
            this.spinnerDialog = null;
         }

         Runnable var7 = new Runnable() {
            // $FF: synthetic field
            final CordovaInterface val$cordova;

            {
               this.val$cordova = var2;
            }

            public void run() {
               SpinnerDialog.this.spinnerDialog = ProgressDialog.show(this.val$cordova.getActivity(), var5, var6, true, true, new OnCancelListener() {
                  public void onCancel(DialogInterface var1) {
                     SpinnerDialog.this.spinnerDialog = null;
                  }
               });
            }
         };
         this.cordova.getActivity().runOnUiThread(var7);
      } else if(var1.equals("hide")) {
         Runnable var4 = new Runnable() {
            public void run() {
               if(SpinnerDialog.this.spinnerDialog != null) {
                  SpinnerDialog.this.spinnerDialog.dismiss();
                  SpinnerDialog.this.spinnerDialog = null;
               }

            }
         };
         this.cordova.getActivity().runOnUiThread(var4);
      }

      var3.success();
      return true;
   }
}
