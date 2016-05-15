package com.goodrx.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.goodrx.activity.AccountCreatedActivity;
import com.goodrx.activity.WebViewActivity;
import com.goodrx.utils.AccountInfoUtils;
import com.goodrx.utils.DialogHelper;
import com.goodrx.utils.Utils;
import com.goodrx.utils.api.GoodRxAPI;
import com.goodrx.utils.api.OnRequestFinishListener;
import com.goodrx.utils.tracker.GAHelper;
import com.goodrx.widget.BaseActivityWithPasscode;
import com.goodrx.widget.MyProgressBar;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.droidparts.widget.ClearableEditText;

public class CreateAccountActivity extends BaseActivityWithPasscode {
   Button btnCreate;
   ClearableEditText etxtEmail;
   ClearableEditText etxtPasswd;
   private GoodRxAPI goodRxAPI;

   void onClicked(View var1) {
      int var2 = var1.getId();
      if(var2 == 2131886270) {
         this.register(this.etxtEmail.getText().toString(), this.etxtPasswd.getText().toString());
      } else if(var2 == 2131886269) {
         this.openTermsofUse();
         return;
      }

   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.enableScreenViewTracking(2131427835);
      this.setContentView(2130968613);
      ButterKnife.bind(this);
      this.etxtPasswd.setTransformationMethod(new PasswordTransformationMethod());
      this.btnCreate.setEnabled(false);
      ((TextView)this.findViewById(2131886269)).setText(Html.fromHtml(this.getString(2131427511) + " <font color=\'#31A7D5\'>Terms of Use</font>."));
      this.goodRxAPI = GoodRxAPI.getInstance();
   }

   void onTextChanged(CharSequence var1) {
      if(this.etxtPasswd.length() > 5 && this.etxtEmail.length() > 0 && Utils.validateEmail(this.etxtEmail.getText().toString())) {
         this.btnCreate.setEnabled(true);
      } else {
         this.btnCreate.setEnabled(false);
      }
   }

   public void openTermsofUse() {
      final MyProgressBar var1 = (MyProgressBar)this.findViewById(2131886399);
      var1.show();
      this.goodRxAPI.getStaticContent(this, "https://www.goodrx.com/mobile-api/v3/static-content/terms", new OnRequestFinishListener() {
         public void onSuccess(String var1x) {
            var1.dismiss();
            String var2 = CreateAccountActivity.this.getString(2131427918);
            WebViewActivity.launch(CreateAccountActivity.this, var2, var1x);
         }
      });
   }

   public void register(final String var1, String var2) {
      final MyProgressBar var3 = (MyProgressBar)this.findViewById(2131886399);
      var3.show();
      this.goodRxAPI.register(this, var1, var2, new OnRequestFinishListener() {
         public void onFailure(int var1x, String var2) {
            super.onFailure(var1x, var2);
            var3.dismiss();
            DialogHelper.showErrorDialog(CreateAccountActivity.this, CreateAccountActivity.this.getResources().getString(2131427791), CreateAccountActivity.this.getResources().getString(2131427792));
         }

         public void onSuccess(String var1x) {
            var3.dismiss();
            JsonObject var2 = (new JsonParser()).parse(var1x).getAsJsonObject();
            String var3x = var2.getAsJsonPrimitive("token").getAsString();
            String var4 = var2.getAsJsonPrimitive("token_id").getAsString();
            AccountInfoUtils.save(CreateAccountActivity.this, var3x, var4, var1);
            GAHelper.sendGoogleAnalyticsEvent(CreateAccountActivity.this, CreateAccountActivity.this.getString(2131427466), CreateAccountActivity.this.getString(2131427579), (String)null);
            GAHelper.sendGoogleAnalyticsEvent(CreateAccountActivity.this, CreateAccountActivity.this.getString(2131427470), CreateAccountActivity.this.getString(2131427579), (String)null);
            Intent var5 = new Intent(CreateAccountActivity.this, AccountCreatedActivity.class);
            var5.setFlags(67108864);
            CreateAccountActivity.this.startActivity(var5);
            CreateAccountActivity.this.finish();
         }
      });
   }
}
