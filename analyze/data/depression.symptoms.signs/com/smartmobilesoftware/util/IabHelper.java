package com.smartmobilesoftware.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.android.vending.billing.IInAppBillingService;
import com.smartmobilesoftware.util.IabException;
import com.smartmobilesoftware.util.IabResult;
import com.smartmobilesoftware.util.Inventory;
import com.smartmobilesoftware.util.Purchase;
import com.smartmobilesoftware.util.Security;
import com.smartmobilesoftware.util.SkuDetails;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

public class IabHelper {
   public static final int BILLING_RESPONSE_RESULT_BILLING_UNAVAILABLE = 3;
   public static final int BILLING_RESPONSE_RESULT_DEVELOPER_ERROR = 5;
   public static final int BILLING_RESPONSE_RESULT_ERROR = 6;
   public static final int BILLING_RESPONSE_RESULT_ITEM_ALREADY_OWNED = 7;
   public static final int BILLING_RESPONSE_RESULT_ITEM_NOT_OWNED = 8;
   public static final int BILLING_RESPONSE_RESULT_ITEM_UNAVAILABLE = 4;
   public static final int BILLING_RESPONSE_RESULT_OK = 0;
   public static final int BILLING_RESPONSE_RESULT_USER_CANCELED = 1;
   public static final String GET_SKU_DETAILS_ITEM_LIST = "ITEM_ID_LIST";
   public static final String GET_SKU_DETAILS_ITEM_TYPE_LIST = "ITEM_TYPE_LIST";
   public static final int IABHELPER_BAD_RESPONSE = -1002;
   public static final int IABHELPER_ERROR_BASE = -1000;
   public static final int IABHELPER_INVALID_CONSUMPTION = -1010;
   public static final int IABHELPER_MISSING_TOKEN = -1007;
   public static final int IABHELPER_REMOTE_EXCEPTION = -1001;
   public static final int IABHELPER_SEND_INTENT_FAILED = -1004;
   public static final int IABHELPER_SUBSCRIPTIONS_NOT_AVAILABLE = -1009;
   public static final int IABHELPER_UNKNOWN_ERROR = -1008;
   public static final int IABHELPER_UNKNOWN_PURCHASE_RESPONSE = -1006;
   public static final int IABHELPER_USER_CANCELLED = -1005;
   public static final int IABHELPER_VERIFICATION_FAILED = -1003;
   public static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
   public static final String ITEM_TYPE_INAPP = "inapp";
   public static final String ITEM_TYPE_SUBS = "subs";
   public static final String RESPONSE_BUY_INTENT = "BUY_INTENT";
   public static final String RESPONSE_CODE = "RESPONSE_CODE";
   public static final String RESPONSE_GET_SKU_DETAILS_LIST = "DETAILS_LIST";
   public static final String RESPONSE_INAPP_ITEM_LIST = "INAPP_PURCHASE_ITEM_LIST";
   public static final String RESPONSE_INAPP_PURCHASE_DATA = "INAPP_PURCHASE_DATA";
   public static final String RESPONSE_INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
   public static final String RESPONSE_INAPP_SIGNATURE = "INAPP_DATA_SIGNATURE";
   public static final String RESPONSE_INAPP_SIGNATURE_LIST = "INAPP_DATA_SIGNATURE_LIST";
   boolean mAsyncInProgress = false;
   String mAsyncOperation = "";
   Context mContext;
   boolean mDebugLog = false;
   String mDebugTag = "IabHelper";
   boolean mDisposed = false;
   IabHelper.OnIabPurchaseFinishedListener mPurchaseListener;
   String mPurchasingItemType;
   int mRequestCode;
   IInAppBillingService mService;
   ServiceConnection mServiceConn;
   boolean mSetupDone = false;
   String mSignatureBase64 = null;
   boolean mSubscriptionsSupported = false;

   public IabHelper(Context var1, String var2) {
      this.mContext = var1.getApplicationContext();
      this.mSignatureBase64 = var2;
      this.logDebug("IAB helper created.");
   }

   private void checkNotDisposed() {
      if(this.mDisposed) {
         throw new IllegalStateException("IabHelper was disposed of, so it cannot be used.");
      }
   }

   public static String getResponseDesc(int var0) {
      String[] var1 = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
      String[] var2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
      if(var0 <= -1000) {
         int var3 = -1000 - var0;
         return var3 >= 0 && var3 < var2.length?var2[var3]:var0 + ":Unknown IAB Helper Error";
      } else {
         return var0 >= 0 && var0 < var1.length?var1[var0]:var0 + ":Unknown";
      }
   }

   void checkSetupDone(String var1) {
      if(!this.mSetupDone) {
         this.logError("Illegal state for operation (" + var1 + "): IAB helper is not set up.");
         throw new IllegalStateException("IAB helper is not set up. Can\'t perform operation: " + var1);
      }
   }

   void consume(Purchase param1) throws IabException {
      // $FF: Couldn't be decompiled
   }

   public void consumeAsync(Purchase var1, IabHelper.OnConsumeFinishedListener var2) {
      this.checkNotDisposed();
      this.checkSetupDone("consume");
      ArrayList var3 = new ArrayList();
      var3.add(var1);
      this.consumeAsyncInternal(var3, var2, (IabHelper.OnConsumeMultiFinishedListener)null);
   }

   public void consumeAsync(List<Purchase> var1, IabHelper.OnConsumeMultiFinishedListener var2) {
      this.checkNotDisposed();
      this.checkSetupDone("consume");
      this.consumeAsyncInternal(var1, (IabHelper.OnConsumeFinishedListener)null, var2);
   }

   void consumeAsyncInternal(final List<Purchase> var1, final IabHelper.OnConsumeFinishedListener var2, final IabHelper.OnConsumeMultiFinishedListener var3) {
      final Handler var4 = new Handler();
      this.flagStartAsync("consume");
      (new Thread(new Runnable() {
         public void run() {
            final ArrayList var1x = new ArrayList();
            Iterator var2x = var1.iterator();

            while(var2x.hasNext()) {
               Purchase var5 = (Purchase)var2x.next();

               try {
                  IabHelper.this.consume(var5);
                  var1x.add(new IabResult(0, "Successful consume of sku " + var5.getSku()));
               } catch (IabException var7) {
                  var1x.add(var7.getResult());
               }
            }

            IabHelper.this.flagEndAsync();
            if(!IabHelper.this.mDisposed && var2 != null) {
               var4.post(new Runnable() {
                  public void run() {
                     var2.onConsumeFinished((Purchase)var1.get(0), (IabResult)var1x.get(0));
                  }
               });
            }

            if(!IabHelper.this.mDisposed && var3 != null) {
               var4.post(new Runnable() {
                  public void run() {
                     var3.onConsumeMultiFinished(var1, var1x);
                  }
               });
            }

         }
      })).start();
   }

   public void dispose() {
      this.logDebug("Disposing.");
      this.mSetupDone = false;
      if(this.mServiceConn != null) {
         this.logDebug("Unbinding from service.");
         if(this.mContext != null) {
            this.mContext.unbindService(this.mServiceConn);
         }
      }

      this.mDisposed = true;
      this.mContext = null;
      this.mServiceConn = null;
      this.mService = null;
      this.mPurchaseListener = null;
   }

   public void enableDebugLogging(boolean var1) {
      this.checkNotDisposed();
      this.mDebugLog = var1;
   }

   public void enableDebugLogging(boolean var1, String var2) {
      this.checkNotDisposed();
      this.mDebugLog = var1;
      this.mDebugTag = var2;
   }

   void flagEndAsync() {
      this.logDebug("Ending async operation: " + this.mAsyncOperation);
      this.mAsyncOperation = "";
      this.mAsyncInProgress = false;
   }

   void flagStartAsync(String var1) {
      if(this.mAsyncInProgress) {
         throw new IllegalStateException("Can\'t start async operation (" + var1 + ") because another async operation(" + this.mAsyncOperation + ") is in progress.");
      } else {
         this.mAsyncOperation = var1;
         this.mAsyncInProgress = true;
         this.logDebug("Starting async operation: " + var1);
      }
   }

   int getResponseCodeFromBundle(Bundle var1) {
      Object var2 = var1.get("RESPONSE_CODE");
      if(var2 == null) {
         this.logDebug("Bundle with null response code, assuming OK (known issue)");
         return 0;
      } else if(var2 instanceof Integer) {
         return ((Integer)var2).intValue();
      } else if(var2 instanceof Long) {
         return (int)((Long)var2).longValue();
      } else {
         this.logError("Unexpected type for bundle response code.");
         this.logError(var2.getClass().getName());
         throw new RuntimeException("Unexpected type for bundle response code: " + var2.getClass().getName());
      }
   }

   int getResponseCodeFromIntent(Intent var1) {
      Object var2 = var1.getExtras().get("RESPONSE_CODE");
      if(var2 == null) {
         this.logError("Intent with no response code, assuming OK (known issue)");
         return 0;
      } else if(var2 instanceof Integer) {
         return ((Integer)var2).intValue();
      } else if(var2 instanceof Long) {
         return (int)((Long)var2).longValue();
      } else {
         this.logError("Unexpected type for intent response code.");
         this.logError(var2.getClass().getName());
         throw new RuntimeException("Unexpected type for intent response code: " + var2.getClass().getName());
      }
   }

   public boolean handleActivityResult(int var1, int var2, Intent var3) {
      if(var1 != this.mRequestCode) {
         return false;
      } else {
         this.checkNotDisposed();
         this.checkSetupDone("handleActivityResult");
         this.flagEndAsync();
         if(var3 == null) {
            this.logError("Null data in IAB activity result.");
            IabResult var16 = new IabResult(-1002, "Null data in IAB result");
            if(this.mPurchaseListener != null) {
               this.mPurchaseListener.onIabPurchaseFinished(var16, (Purchase)null);
            }

            return true;
         } else {
            int var4 = this.getResponseCodeFromIntent(var3);
            String var5 = var3.getStringExtra("INAPP_PURCHASE_DATA");
            String var6 = var3.getStringExtra("INAPP_DATA_SIGNATURE");
            if(var2 == -1 && var4 == 0) {
               this.logDebug("Successful resultcode from purchase activity.");
               this.logDebug("Purchase data: " + var5);
               this.logDebug("Data signature: " + var6);
               this.logDebug("Extras: " + var3.getExtras());
               this.logDebug("Expected item type: " + this.mPurchasingItemType);
               if(var5 == null || var6 == null) {
                  this.logError("BUG: either purchaseData or dataSignature is null.");
                  this.logDebug("Extras: " + var3.getExtras().toString());
                  IabResult var10 = new IabResult(-1008, "IAB returned null purchaseData or dataSignature");
                  if(this.mPurchaseListener != null) {
                     this.mPurchaseListener.onIabPurchaseFinished(var10, (Purchase)null);
                  }

                  return true;
               }

               Purchase var11;
               label88: {
                  JSONException var12;
                  label73: {
                     try {
                        var11 = new Purchase(this.mPurchasingItemType, var5, var6);
                     } catch (JSONException var18) {
                        var12 = var18;
                        break label73;
                     }

                     try {
                        String var14 = var11.getSku();
                        if(!TextUtils.isEmpty(this.mSignatureBase64)) {
                           if(!Security.verifyPurchase(this.mSignatureBase64, var5, var6)) {
                              this.logError("Purchase signature verification FAILED for sku " + var14);
                              IabResult var15 = new IabResult(-1003, "Signature verification failed for sku " + var14);
                              if(this.mPurchaseListener != null) {
                                 this.mPurchaseListener.onIabPurchaseFinished(var15, var11);
                              }

                              return true;
                           }

                           this.logDebug("Purchase signature successfully verified.");
                        }
                        break label88;
                     } catch (JSONException var17) {
                        var12 = var17;
                     }
                  }

                  this.logError("Failed to parse purchase data.");
                  var12.printStackTrace();
                  IabResult var13 = new IabResult(-1002, "Failed to parse purchase data.");
                  if(this.mPurchaseListener != null) {
                     this.mPurchaseListener.onIabPurchaseFinished(var13, (Purchase)null);
                  }

                  return true;
               }

               if(this.mPurchaseListener != null) {
                  this.mPurchaseListener.onIabPurchaseFinished(new IabResult(0, "Success"), var11);
               }
            } else if(var2 == -1) {
               this.logDebug("Result code was OK but in-app billing response was not OK: " + getResponseDesc(var4));
               if(this.mPurchaseListener != null) {
                  IabResult var9 = new IabResult(var4, "Problem purchashing item.");
                  this.mPurchaseListener.onIabPurchaseFinished(var9, (Purchase)null);
               }
            } else if(var2 == 0) {
               this.logDebug("Purchase canceled - Response: " + getResponseDesc(var4));
               IabResult var8 = new IabResult(-1005, "User canceled.");
               if(this.mPurchaseListener != null) {
                  this.mPurchaseListener.onIabPurchaseFinished(var8, (Purchase)null);
               }
            } else {
               this.logError("Purchase failed. Result code: " + Integer.toString(var2) + ". Response: " + getResponseDesc(var4));
               IabResult var7 = new IabResult(-1006, "Unknown purchase response.");
               if(this.mPurchaseListener != null) {
                  this.mPurchaseListener.onIabPurchaseFinished(var7, (Purchase)null);
               }
            }

            return true;
         }
      }
   }

   public void launchPurchaseFlow(Activity var1, String var2, int var3, IabHelper.OnIabPurchaseFinishedListener var4) {
      this.launchPurchaseFlow(var1, var2, var3, var4, "");
   }

   public void launchPurchaseFlow(Activity var1, String var2, int var3, IabHelper.OnIabPurchaseFinishedListener var4, String var5) {
      this.launchPurchaseFlow(var1, var2, "inapp", var3, var4, var5);
   }

   public void launchPurchaseFlow(Activity param1, String param2, String param3, int param4, IabHelper.OnIabPurchaseFinishedListener param5, String param6) {
      // $FF: Couldn't be decompiled
   }

   public void launchSubscriptionPurchaseFlow(Activity var1, String var2, int var3, IabHelper.OnIabPurchaseFinishedListener var4) {
      this.launchSubscriptionPurchaseFlow(var1, var2, var3, var4, "");
   }

   public void launchSubscriptionPurchaseFlow(Activity var1, String var2, int var3, IabHelper.OnIabPurchaseFinishedListener var4, String var5) {
      this.launchPurchaseFlow(var1, var2, "subs", var3, var4, var5);
   }

   void logDebug(String var1) {
      if(this.mDebugLog) {
         Log.d(this.mDebugTag, var1);
      }

   }

   void logError(String var1) {
      Log.e(this.mDebugTag, "In-app billing error: " + var1);
   }

   void logWarn(String var1) {
      Log.w(this.mDebugTag, "In-app billing warning: " + var1);
   }

   public Inventory queryInventory(boolean var1, List<String> var2) throws IabException {
      return this.queryInventory(var1, var2, (List)null);
   }

   public Inventory queryInventory(boolean param1, List<String> param2, List<String> param3) throws IabException {
      // $FF: Couldn't be decompiled
   }

   public void queryInventoryAsync(IabHelper.QueryInventoryFinishedListener var1) {
      this.queryInventoryAsync(true, (List)null, var1);
   }

   public void queryInventoryAsync(boolean var1, IabHelper.QueryInventoryFinishedListener var2) {
      this.queryInventoryAsync(var1, (List)null, var2);
   }

   public void queryInventoryAsync(final boolean var1, final List<String> var2, final IabHelper.QueryInventoryFinishedListener var3) {
      final Handler var4 = new Handler();
      this.checkNotDisposed();
      this.checkSetupDone("queryInventory");
      this.flagStartAsync("refresh inventory");
      (new Thread(new Runnable() {
         public void run() {
            final IabResult var1x = new IabResult(0, "Inventory refresh successful.");

            final Inventory var3x;
            label19: {
               Inventory var7;
               try {
                  var7 = IabHelper.this.queryInventory(var1, var2);
               } catch (IabException var8) {
                  var1x = var8.getResult();
                  var3x = null;
                  break label19;
               }

               var3x = var7;
            }

            IabHelper.this.flagEndAsync();
            if(!IabHelper.this.mDisposed && var3 != null) {
               var4.post(new Runnable() {
                  public void run() {
                     var3.onQueryInventoryFinished(var1x, var3x);
                  }
               });
            }

         }
      })).start();
   }

   int queryPurchases(Inventory var1, String var2) throws JSONException, RemoteException {
      this.logDebug("Querying owned items, item type: " + var2);
      this.logDebug("Package name: " + this.mContext.getPackageName());
      boolean var3 = false;
      String var4 = null;

      do {
         this.logDebug("Calling getPurchases with continuation token: " + var4);
         Bundle var5 = this.mService.getPurchases(3, this.mContext.getPackageName(), var2, var4);
         int var6 = this.getResponseCodeFromBundle(var5);
         this.logDebug("Owned items response: " + String.valueOf(var6));
         if(var6 != 0) {
            this.logDebug("getPurchases() failed: " + getResponseDesc(var6));
            return var6;
         }

         if(!var5.containsKey("INAPP_PURCHASE_ITEM_LIST") || !var5.containsKey("INAPP_PURCHASE_DATA_LIST") || !var5.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
            this.logError("Bundle returned from getPurchases() doesn\'t contain required fields.");
            return -1002;
         }

         ArrayList var7 = var5.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
         ArrayList var8 = var5.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
         ArrayList var9 = var5.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");

         for(int var10 = 0; var10 < var8.size(); ++var10) {
            String var12 = (String)var8.get(var10);
            String var13 = (String)var9.get(var10);
            String var14 = (String)var7.get(var10);
            if(!TextUtils.isEmpty(this.mSignatureBase64) && !Security.verifyPurchase(this.mSignatureBase64, var12, var13)) {
               this.logWarn("Purchase signature verification **FAILED**. Not adding item.");
               this.logDebug("   Purchase data: " + var12);
               this.logDebug("   Signature: " + var13);
               var3 = true;
            } else {
               this.logDebug("Sku is owned: " + var14);
               Purchase var15 = new Purchase(var2, var12, var13);
               if(TextUtils.isEmpty(var15.getToken())) {
                  this.logWarn("BUG: empty/null token!");
                  this.logDebug("Purchase data: " + var12);
               }

               var1.addPurchase(var15);
            }
         }

         var4 = var5.getString("INAPP_CONTINUATION_TOKEN");
         this.logDebug("Continuation token: " + var4);
      } while(!TextUtils.isEmpty(var4));

      short var11;
      if(var3) {
         var11 = -1003;
      } else {
         var11 = 0;
      }

      return var11;
   }

   int querySkuDetails(String var1, Inventory var2, List<String> var3) throws RemoteException, JSONException {
      this.logDebug("Querying SKU details.");
      ArrayList var4 = new ArrayList();
      var4.addAll(var2.getAllOwnedSkus(var1));
      if(var3 != null) {
         this.logDebug("moreSkus: Building SKUs List");
         Iterator var11 = var3.iterator();

         while(var11.hasNext()) {
            String var12 = (String)var11.next();
            this.logDebug("moreSkus: " + var12);
            if(!var4.contains(var12)) {
               var4.add(var12);
            }
         }
      }

      if(var4.size() == 0) {
         this.logDebug("queryPrices: nothing to do because there are no SKUs.");
      } else {
         Bundle var6 = new Bundle();
         var6.putStringArrayList("ITEM_ID_LIST", var4);
         Bundle var7 = this.mService.getSkuDetails(3, this.mContext.getPackageName(), var1, var6);
         if(!var7.containsKey("DETAILS_LIST")) {
            int var10 = this.getResponseCodeFromBundle(var7);
            if(var10 != 0) {
               this.logDebug("getSkuDetails() failed: " + getResponseDesc(var10));
               return var10;
            }

            this.logError("getSkuDetails() returned a bundle with neither an error nor a detail list.");
            return -1002;
         }

         Iterator var8 = var7.getStringArrayList("DETAILS_LIST").iterator();

         while(var8.hasNext()) {
            SkuDetails var9 = new SkuDetails(var1, (String)var8.next());
            this.logDebug("Got sku details: " + var9);
            var2.addSkuDetails(var9);
         }
      }

      return 0;
   }

   public void startSetup(final IabHelper.OnIabSetupFinishedListener var1) {
      this.checkNotDisposed();
      if(this.mSetupDone) {
         throw new IllegalStateException("IAB helper is already set up.");
      } else {
         this.logDebug("Starting in-app billing setup.");
         this.mServiceConn = new ServiceConnection() {
            public void onServiceConnected(ComponentName param1, IBinder param2) {
               // $FF: Couldn't be decompiled
            }

            public void onServiceDisconnected(ComponentName var1x) {
               IabHelper.this.logDebug("Billing service disconnected.");
               IabHelper.this.mService = null;
            }
         };
         Intent var2 = new Intent("com.android.vending.billing.InAppBillingService.BIND");
         var2.setPackage("com.android.vending");
         if(!this.mContext.getPackageManager().queryIntentServices(var2, 0).isEmpty()) {
            this.mContext.bindService(var2, this.mServiceConn, 1);
         } else if(var1 != null) {
            var1.onIabSetupFinished(new IabResult(3, "Billing service unavailable on device."));
            return;
         }

      }
   }

   public boolean subscriptionsSupported() {
      this.checkNotDisposed();
      return this.mSubscriptionsSupported;
   }

   public interface OnConsumeFinishedListener {
      void onConsumeFinished(Purchase var1, IabResult var2);
   }

   public interface OnConsumeMultiFinishedListener {
      void onConsumeMultiFinished(List<Purchase> var1, List<IabResult> var2);
   }

   public interface OnIabPurchaseFinishedListener {
      void onIabPurchaseFinished(IabResult var1, Purchase var2);
   }

   public interface OnIabSetupFinishedListener {
      void onIabSetupFinished(IabResult var1);
   }

   public interface QueryInventoryFinishedListener {
      void onQueryInventoryFinished(IabResult var1, Inventory var2);
   }
}
