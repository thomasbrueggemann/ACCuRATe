package com.peirr.blooadapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.peirr.blooadapp.fragments.DisclaimerFragment;
import com.peirr.blooadapp.fragments.LoginAndRegisterFragment;
import com.peirr.blooadapp.fragments.doctor.CalculationHistoryActivity;
import com.peirr.blooadapp.io.Settings;

public class MainActivity extends Activity {
   private Settings settings;

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.settings = new Settings(this);
      this.setContentView(2130903041);
      if(var1 == null) {
         if(!this.settings.getBoolean("accepted")) {
            this.getFragmentManager().beginTransaction().replace(2131427331, new DisclaimerFragment()).commit();
            return;
         }

         if(this.settings.getInt("docid") != -1) {
            this.startActivity(new Intent(this, CalculationHistoryActivity.class));
            this.finish();
            return;
         }

         this.getFragmentManager().beginTransaction().replace(2131427331, new LoginAndRegisterFragment()).commit();
      }

   }
}
