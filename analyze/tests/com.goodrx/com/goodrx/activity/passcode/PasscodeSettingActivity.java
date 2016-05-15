package com.goodrx.activity.passcode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.goodrx.utils.DialogHelper;
import com.goodrx.utils.PasscodeManager;
import com.goodrx.utils.Utils;
import com.goodrx.widget.Passcode.PasscodeInputFinishListener;
import com.goodrx.widget.Passcode.PasscodeView;
import java.util.ArrayList;
import java.util.List;

public class PasscodeSettingActivity extends AppCompatActivity {
   private List<Integer> input;
   private PasscodeView passcodeView;

   private void showSuccessDialog() {
      AlertDialog.Builder var1 = new AlertDialog.Builder(this);
      View var2 = View.inflate(this, 2130968669, (ViewGroup)null);
      ((TextView)var2.findViewById(2131886421)).setText(2131427720);
      var1.setView(var2);
      var1.setTitle("Passcode Setting");
      var1.setPositiveButton(2131427537, new OnClickListener() {
         public void onClick(DialogInterface var1, int var2) {
            PasscodeManager.getInstance().refreshTimeStamp(PasscodeSettingActivity.this);
            PasscodeSettingActivity.this.finish();
         }
      });
      DialogHelper.showDialog(var1);
   }

   public void onBackPressed() {
      this.setResult(0);
      PasscodeManager.getInstance().refreshTimeStamp(this);
      super.onBackPressed();
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130968627);
      this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      final PasscodeSettingActivity.NewPasscodeInputFinishListener var2 = new PasscodeSettingActivity.NewPasscodeInputFinishListener(null);
      this.passcodeView = (PasscodeView)this.findViewById(2131886304);
      if(this.getIntent().getBooleanExtra("require_pin", false)) {
         this.passcodeView.setTitle(2131427567);
         this.passcodeView.setOnInputFinishListener(new PasscodeInputFinishListener() {
            public void onInputFinish(List<Integer> var1) {
               if(PasscodeManager.getInstance().isValidPasscode(PasscodeSettingActivity.this, var1)) {
                  PasscodeSettingActivity.this.passcodeView.setTitle(2131427565);
                  PasscodeSettingActivity.this.passcodeView.setOnInputFinishListener(var2);
                  PasscodeSettingActivity.this.passcodeView.clear();
               } else {
                  PasscodeSettingActivity.this.passcodeView.shake();
               }
            }
         });
      } else {
         this.passcodeView.setTitle(2131427557);
         this.passcodeView.setOnInputFinishListener(var2);
      }
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      switch(var1.getItemId()) {
      case 16908332:
         this.onBackPressed();
         return true;
      default:
         return super.onOptionsItemSelected(var1);
      }
   }

   private class NewPasscodeInputFinishListener extends PasscodeInputFinishListener {
      private NewPasscodeInputFinishListener() {
      }

      // $FF: synthetic method
      NewPasscodeInputFinishListener(Object var2) {
         this();
      }

      public void onInputFinish(List<Integer> var1) {
         if(PasscodeSettingActivity.this.input == null) {
            PasscodeSettingActivity.this.input = new ArrayList(var1);
            PasscodeSettingActivity.this.passcodeView.setTitle(2131427492);
            PasscodeSettingActivity.this.passcodeView.clear();
         } else if(var1.equals(PasscodeSettingActivity.this.input)) {
            PasscodeManager.getInstance().setPassCodeFeatureEnabled(PasscodeSettingActivity.this, true);
            PasscodeManager.getInstance().setPasscode(PasscodeSettingActivity.this, var1);
            PasscodeSettingActivity.this.setResult(-1);
            PasscodeSettingActivity.this.showSuccessDialog();
         } else {
            PasscodeSettingActivity.this.input = null;
            PasscodeSettingActivity.this.passcodeView.setTitle(2131427557);
            PasscodeSettingActivity.this.passcodeView.shake();
            Utils.showToast(PasscodeSettingActivity.this, PasscodeSettingActivity.this.getString(2131427751));
         }
      }
   }
}
