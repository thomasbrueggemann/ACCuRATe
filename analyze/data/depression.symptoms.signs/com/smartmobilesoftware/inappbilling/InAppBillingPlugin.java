package com.smartmobilesoftware.inappbilling;

import android.content.Intent;
import android.util.Log;
import com.smartmobilesoftware.util.IabHelper;
import com.smartmobilesoftware.util.IabResult;
import com.smartmobilesoftware.util.Inventory;
import com.smartmobilesoftware.util.Purchase;
import java.util.Iterator;
import java.util.List;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InAppBillingPlugin extends CordovaPlugin {
   static final int RC_REQUEST = 10001;
   private final Boolean ENABLE_DEBUG_LOGGING = Boolean.valueOf(true);
   private final String TAG = "CORDOVA_BILLING";
   private final String base64EncodedPublicKey = "";
   CallbackContext callbackContext;
   IabHelper.OnConsumeFinishedListener mConsumeFinishedListener = new IabHelper.OnConsumeFinishedListener() {
      public void onConsumeFinished(Purchase var1, IabResult var2) {
         Log.d("CORDOVA_BILLING", "Consumption finished. Purchase: " + var1 + ", result: " + var2);
         if(var2.isSuccess()) {
            InAppBillingPlugin.this.myInventory.erasePurchase(var1.getSku());
            Log.d("CORDOVA_BILLING", "Consumption successful. .");
            InAppBillingPlugin.this.callbackContext.success(var1.getOriginalJson());
         } else {
            InAppBillingPlugin.this.callbackContext.error("Error while consuming: " + var2);
         }
      }
   };
   IabHelper.QueryInventoryFinishedListener mGotDetailsListener = new IabHelper.QueryInventoryFinishedListener() {
      public void onQueryInventoryFinished(IabResult param1, Inventory param2) {
         // $FF: Couldn't be decompiled
      }
   };
   IabHelper.QueryInventoryFinishedListener mGotInventoryListener = new IabHelper.QueryInventoryFinishedListener() {
      public void onQueryInventoryFinished(IabResult var1, Inventory var2) {
         Log.d("CORDOVA_BILLING", "Inside mGotInventoryListener");
         if(!InAppBillingPlugin.this.hasErrorsAndUpdateInventory(var1, var2).booleanValue()) {
            ;
         }

         Log.d("CORDOVA_BILLING", "Query inventory was successful.");
         InAppBillingPlugin.this.callbackContext.success();
      }
   };
   IabHelper mHelper;
   IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener = new IabHelper.OnIabPurchaseFinishedListener() {
      public void onIabPurchaseFinished(IabResult var1, Purchase var2) {
         Log.d("CORDOVA_BILLING", "Purchase finished: " + var1 + ", purchase: " + var2);
         if(InAppBillingPlugin.this.mHelper == null) {
            InAppBillingPlugin.this.callbackContext.error("The billing helper has been disposed");
         }

         if(var1.isFailure()) {
            InAppBillingPlugin.this.callbackContext.error("Error purchasing: " + var1);
         } else if(!InAppBillingPlugin.this.verifyDeveloperPayload(var2)) {
            InAppBillingPlugin.this.callbackContext.error("Error purchasing. Authenticity verification failed.");
         } else {
            Log.d("CORDOVA_BILLING", "Purchase successful.");
            InAppBillingPlugin.this.myInventory.addPurchase(var2);
            InAppBillingPlugin.this.callbackContext.success(var2.getSku());
         }
      }
   };
   Inventory myInventory;

   private void buy(String var1) {
      if(this.mHelper == null) {
         this.callbackContext.error("Billing plugin was not initialized");
      } else {
         this.cordova.setActivityResultCallback(this);
         this.mHelper.launchPurchaseFlow(this.cordova.getActivity(), var1, 10001, this.mPurchaseFinishedListener, "");
      }
   }

   private void consumePurchase(JSONArray var1) throws JSONException {
      if(this.mHelper == null) {
         this.callbackContext.error("Did you forget to initialize the plugin?");
      } else {
         String var2 = var1.getString(0);
         Purchase var3 = this.myInventory.getPurchase(var2);
         if(var3 != null) {
            this.mHelper.consumeAsync(var3, this.mConsumeFinishedListener);
         } else {
            this.callbackContext.error(var2 + " is not owned so it cannot be consumed");
         }
      }
   }

   private JSONArray getAvailableProducts() {
      // $FF: Couldn't be decompiled
   }

   private void getProductDetails(List<String> var1) {
      if(this.mHelper == null) {
         this.callbackContext.error("Billing plugin was not initialized");
      } else {
         Log.d("CORDOVA_BILLING", "Beginning Sku(s) Query!");
         this.mHelper.queryInventoryAsync(true, var1, this.mGotDetailsListener);
      }
   }

   private JSONArray getPurchases() throws JSONException {
      JSONArray var2;
      if(this.myInventory == null) {
         this.callbackContext.error("Billing plugin was not initialized");
         var2 = new JSONArray();
      } else {
         List var1 = this.myInventory.getAllPurchases();
         var2 = new JSONArray();
         Iterator var3 = var1.iterator();

         while(var3.hasNext()) {
            var2.put(new JSONObject(((Purchase)var3.next()).getOriginalJson()));
         }
      }

      return var2;
   }

   private Boolean hasErrorsAndUpdateInventory(IabResult var1, Inventory var2) {
      if(var1.isFailure()) {
         this.callbackContext.error("Failed to query inventory: " + var1);
         return Boolean.valueOf(true);
      } else if(this.mHelper == null) {
         this.callbackContext.error("The billing helper has been disposed");
         return Boolean.valueOf(true);
      } else {
         this.myInventory = var2;
         return Boolean.valueOf(false);
      }
   }

   private void init(final List<String> var1) {
      Log.d("CORDOVA_BILLING", "init start");
      Log.d("CORDOVA_BILLING", "Creating IAB helper.");
      this.mHelper = new IabHelper(this.cordova.getActivity().getApplicationContext(), "");
      this.mHelper.enableDebugLogging(this.ENABLE_DEBUG_LOGGING.booleanValue());
      Log.d("CORDOVA_BILLING", "Starting setup.");
      this.mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
         public void onIabSetupFinished(IabResult var1x) {
            Log.d("CORDOVA_BILLING", "Setup finished.");
            if(!var1x.isSuccess()) {
               InAppBillingPlugin.this.callbackContext.error("Problem setting up in-app billing: " + var1x);
            } else {
               if(InAppBillingPlugin.this.mHelper == null) {
                  InAppBillingPlugin.this.callbackContext.error("The billing helper has been disposed");
               }

               if(var1.size() <= 0) {
                  Log.d("CORDOVA_BILLING", "Setup successful. Querying inventory.");
                  InAppBillingPlugin.this.mHelper.queryInventoryAsync(InAppBillingPlugin.this.mGotInventoryListener);
               } else {
                  Log.d("CORDOVA_BILLING", "Setup successful. Querying inventory w/ SKUs.");
                  InAppBillingPlugin.this.mHelper.queryInventoryAsync(true, var1, InAppBillingPlugin.this.mGotInventoryListener);
               }
            }
         }
      });
   }

   private void subscribe(String var1) {
      if(this.mHelper == null) {
         this.callbackContext.error("Billing plugin was not initialized");
      } else if(!this.mHelper.subscriptionsSupported()) {
         this.callbackContext.error("Subscriptions not supported on your device yet. Sorry!");
      } else {
         this.cordova.setActivityResultCallback(this);
         Log.d("CORDOVA_BILLING", "Launching purchase flow for subscription.");
         this.mHelper.launchPurchaseFlow(this.cordova.getActivity(), var1, "subs", 10001, this.mPurchaseFinishedListener, "");
      }
   }

   public boolean execute(String param1, JSONArray param2, CallbackContext param3) {
      // $FF: Couldn't be decompiled
   }

   public void onActivityResult(int var1, int var2, Intent var3) {
      Log.d("CORDOVA_BILLING", "onActivityResult(" + var1 + "," + var2 + "," + var3);
      if(!this.mHelper.handleActivityResult(var1, var2, var3)) {
         super.onActivityResult(var1, var2, var3);
      } else {
         Log.d("CORDOVA_BILLING", "onActivityResult handled by IABUtil.");
      }
   }

   public void onDestroy() {
      super.onDestroy();
      Log.d("CORDOVA_BILLING", "Destroying helper.");
      if(this.mHelper != null) {
         this.mHelper.dispose();
         this.mHelper = null;
      }

   }

   boolean verifyDeveloperPayload(Purchase var1) {
      var1.getDeveloperPayload();
      return true;
   }
}
