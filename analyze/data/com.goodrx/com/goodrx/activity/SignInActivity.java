package com.goodrx.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.goodrx.model.Key;
import com.goodrx.utils.AccountInfoUtils;
import com.goodrx.utils.CacheHttpRequestHelper;
import com.goodrx.utils.DialogHelper;
import com.goodrx.utils.MyResponseHandler;
import com.goodrx.utils.MyRxUtils;
import com.goodrx.utils.Utils;
import com.goodrx.utils.api.GoodRxAPI;
import com.goodrx.utils.api.OnRequestFinishListener;
import com.goodrx.utils.locations.LocationUtils;
import com.goodrx.utils.tracker.GAHelper;
import com.goodrx.widget.BaseActivityWithPasscode;
import com.goodrx.widget.MyProgressBar;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.loopj.android.http.RequestParams;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.droidparts.widget.ClearableEditText;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SignInActivity extends BaseActivityWithPasscode {
   private Button btnSignIn;
   private ClearableEditText etxtEmail;
   private ClearableEditText etxtPasswd;

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.enableScreenViewTracking(2131427868);
      this.setContentView(2130968643);
      this.etxtEmail = (ClearableEditText)this.findViewById(2131886351);
      this.etxtPasswd = (ClearableEditText)this.findViewById(2131886352);
      this.etxtPasswd.setTransformationMethod(new PasswordTransformationMethod());
      this.btnSignIn = (Button)this.findViewById(2131886354);
      ((TextView)this.findViewById(2131886353)).setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            View var2 = View.inflate(SignInActivity.this, 2130968670, (ViewGroup)null);
            final ClearableEditText var3 = (ClearableEditText)var2.findViewById(2131886422);
            var3.setSingleLine(true);
            var3.setHint(2131427553);
            AlertDialog.Builder var4 = new AlertDialog.Builder(SignInActivity.this);
            var4.setTitle(SignInActivity.this.getResources().getString(2131427563));
            var4.setMessage(SignInActivity.this.getResources().getString(2131427602));
            var4.setView(var2);
            var4.setPositiveButton(2131427537, new android.content.DialogInterface.OnClickListener() {
               public void onClick(final DialogInterface var1, int var2) {
                  if(!Utils.validateEmail(var3.getText().toString())) {
                     var3.setText("");
                     Utils.showToast(SignInActivity.this, SignInActivity.this.getResources().getString(2131427625));
                  } else {
                     Key var3x = AccountInfoUtils.getKey(SignInActivity.this);
                     if(!var3x.isValid()) {
                        Utils.reinitTokens(SignInActivity.this);
                        SignInActivity.this.finish();
                     } else {
                        RequestParams var4 = new RequestParams();
                        var4.add("token", var3x.getToken());
                        var4.add("token_id", var3x.getToken_id());
                        var4.add("email", var3.getText().toString());
                        CacheHttpRequestHelper.getInstance().post("https://www.goodrx.com/mobile-api/forgot-password", var4, new MyResponseHandler(SignInActivity.this) {
                           public void onSuccess(String var1x) {
                              var1.dismiss();

                              try {
                                 new JSONObject;
                                 JSONObject var4 = JSONObjectInstrumentation.init(var1x);
                                 if(var4.getBoolean("success")) {
                                    Utils.showToast(SignInActivity.this, SignInActivity.this.getResources().getString(2131427476));
                                    return;
                                 }

                                 JSONArray var5 = var4.getJSONArray("errors");
                                 if(var5.length() > 0) {
                                    DialogHelper.showErrorDialog(SignInActivity.this, SignInActivity.this.getString(2131427570), var5.getString(0));
                                    return;
                                 }
                              } catch (JSONException var6) {
                                 var6.printStackTrace();
                              }

                           }
                        });
                     }
                  }
               }
            });
            var4.setNegativeButton(2131427459, (android.content.DialogInterface.OnClickListener)null);
            DialogHelper.showDialog(var4);
         }
      });
      this.btnSignIn.setEnabled(false);
      SignInActivity.MyTextWatcher var2 = new SignInActivity.MyTextWatcher(null);
      this.etxtEmail.addTextChangedListener(var2);
      this.etxtPasswd.addTextChangedListener(var2);
   }

   public void signIn(final String var1, String var2) {
      final MyProgressBar var3 = (MyProgressBar)this.findViewById(2131886399);
      var3.show();
      GoodRxAPI.getInstance().signIn(this, var1, var2, new OnRequestFinishListener() {
         public void onFailure(int var1x, String var2) {
            super.onFailure(var1x, var2);
            var3.dismiss();
            SignInActivity.this.etxtPasswd.setText("");
         }

         public void onSuccess(String var1x) {
            var3.dismiss();
            GAHelper.sendGoogleAnalyticsScreenView(SignInActivity.this, 2131427585);
            GAHelper.sendGoogleAnalyticsEvent(SignInActivity.this, SignInActivity.this.getString(2131427466), SignInActivity.this.getString(2131427585), (String)null);
            GAHelper.sendGoogleAnalyticsEvent(SignInActivity.this, SignInActivity.this.getString(2131427470), SignInActivity.this.getString(2131427585), (String)null);
            JsonObject var2 = (new JsonParser()).parse(var1x).getAsJsonObject();
            String var3x = var2.getAsJsonPrimitive("token_id").getAsString();
            String var4 = var2.getAsJsonPrimitive("token").getAsString();
            LocationUtils.clear(SignInActivity.this);
            MyRxUtils.clear(SignInActivity.this);
            AccountInfoUtils.save(SignInActivity.this, var4, var3x, var1);
            SignInActivity.this.setResult(-1);
            SignInActivity.this.finish();
         }
      });
   }

   public void signInClicked(View var1) {
      this.signIn(this.etxtEmail.getText().toString(), this.etxtPasswd.getText().toString());
   }

   private class MyTextWatcher implements TextWatcher {
      private MyTextWatcher() {
      }

      // $FF: synthetic method
      MyTextWatcher(Object var2) {
         this();
      }

      public void afterTextChanged(Editable var1) {
         if(SignInActivity.this.etxtPasswd.length() > 5 && SignInActivity.this.etxtEmail.length() > 0 && Utils.validateEmail(SignInActivity.this.etxtEmail.getText().toString())) {
            SignInActivity.this.btnSignIn.setEnabled(true);
         } else {
            SignInActivity.this.btnSignIn.setEnabled(false);
         }
      }

      public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
      }

      public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
      }
   }
}
