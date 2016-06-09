package com.goodrx.activity;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Build.VERSION;
import android.util.Log;
import com.goodrx.activity.main.MainActivity;
import com.goodrx.model.Key;
import com.goodrx.utils.AccountInfoUtils;
import com.goodrx.utils.CacheHttpRequestHelper;
import com.goodrx.utils.DialogHelper;
import com.goodrx.utils.MyResponseHandler;
import com.goodrx.utils.locations.GoogleServiceLocationHelper;
import com.goodrx.utils.locations.MyLocationInterface;
import com.goodrx.widget.BaseActivity;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.loopj.android.http.RequestParams;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import cz.msebera.android.httpclient.Header;
import java.lang.ref.WeakReference;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public class WelcomeActivity extends BaseActivity {
   private static final int TIME_LIMIT = 10000;
   private Handler handler;
   private MyLocationInterface locationInterface;

   public String generateRandomId() {
      StringBuilder var1 = new StringBuilder();
      Random var2 = new Random();

      for(int var3 = 0; var3 < 32; ++var3) {
         var1.append(Integer.toHexString(var2.nextInt(16)));
      }

      return var1.toString();
   }

   public void getAdid() {
      if(VERSION.SDK_INT < 23) {
         this.locationInterface = new GoogleServiceLocationHelper(this);
         this.locationInterface.startUpdate();
      }

      (new Thread(new Runnable() {
         public void run() {
            try {
               String var3 = AdvertisingIdClient.getAdvertisingIdInfo(WelcomeActivity.this).getId();
               Message var4 = new Message();
               var4.what = 1;
               var4.obj = var3;
               WelcomeActivity.this.handler.sendMessage(var4);
               Log.d("ADID", var3);
            } catch (Exception var5) {
               WelcomeActivity.this.handler.sendEmptyMessage(0);
            }
         }
      })).start();
   }

   public void initData() {
      super.initData();
      Key var1 = AccountInfoUtils.getKey(this);
      if(var1.isValid()) {
         Log.d("Token Info", "Token: " + var1.getToken() + ", Token ID:" + var1.getToken_id());
         this.success();
      } else {
         this.handler.sendEmptyMessageDelayed(3, 10000L);
         this.getAdid();
      }
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130968648);
      this.handler = new WelcomeActivity.StaticHandler(this);
      this.initData();
   }

   protected void onStop() {
      if(this.locationInterface != null) {
         this.locationInterface.stopUpdate();
      }

      super.onStop();
   }

   public void registerToken(String var1) {
      RequestParams var2 = new RequestParams();
      var2.put("udid", var1);
      CacheHttpRequestHelper.getInstance().get("https://www.goodrx.com/mobile-api/register-for-token", var2, new MyResponseHandler(this) {
         public void onFailure(int var1, Header[] var2, byte[] var3, Throwable var4, String var5) {
            super.onFailure(var1, var2, var3, var4, var5);
            WelcomeActivity.this.handler.sendEmptyMessage(2);
         }

         public void onSuccess(String var1) {
            if(var1.length() != 0 && !var1.equals("null")) {
               try {
                  new JSONObject;
                  JSONObject var5 = JSONObjectInstrumentation.init(var1);
                  String var6 = var5.getString("token");
                  String var7 = var5.getString("token_id");
                  AccountInfoUtils.save(WelcomeActivity.this, var6, var7, (String)null);
                  WelcomeActivity.this.handler.sendEmptyMessage(4);
               } catch (JSONException var8) {
                  var8.printStackTrace();
               }
            } else {
               WelcomeActivity.this.handler.sendEmptyMessage(2);
            }
         }
      });
   }

   public void success() {
      MainActivity.launch(this);
      this.finish();
   }

   private static class StaticHandler extends Handler {
      public static final int MSG_ADID_SUCCESS = 1;
      public static final int MSG_GOOGLEPLAY_ERROR = 0;
      public static final int MSG_REGISTER_SUCCESS = 4;
      public static final int MSG_SERVER_ERROR = 2;
      public static final int MSG_TIMER = 3;
      private WeakReference<WelcomeActivity> mRef;

      public StaticHandler(WelcomeActivity var1) {
         this.mRef = new WeakReference(var1);
      }

      public void handleMessage(Message var1) {
         super.handleMessage(var1);
         if(this.mRef.get() != null) {
            if(var1.what == 0) {
               String var5 = ((WelcomeActivity)this.mRef.get()).generateRandomId();
               Message var6 = new Message();
               var6.what = 1;
               var6.obj = var5;
               this.sendMessage(var6);
               return;
            }

            if(var1.what == 1) {
               Editor var2 = ((WelcomeActivity)this.mRef.get()).getSharedPreferences("goodrx", 0).edit();
               String var3 = (String)var1.obj;
               var2.putString("adid", var3);
               var2.apply();
               ((WelcomeActivity)this.mRef.get()).registerToken(var3);
               return;
            }

            if(var1.what == 4) {
               this.removeMessages(3);
               ((WelcomeActivity)this.mRef.get()).success();
               return;
            }

            if(var1.what == 2) {
               this.removeMessages(3);
               if(!((WelcomeActivity)this.mRef.get()).isFinishing()) {
                  DialogHelper.showErrorDialog((Context)this.mRef.get(), ((WelcomeActivity)this.mRef.get()).getString(2131427886), ((WelcomeActivity)this.mRef.get()).getString(2131427887));
                  return;
               }
            } else if(var1.what == 3 && !((WelcomeActivity)this.mRef.get()).isFinishing()) {
               DialogHelper.showErrorDialog((Context)this.mRef.get(), "Time Out", "Time Out");
               return;
            }
         }

      }
   }
}
