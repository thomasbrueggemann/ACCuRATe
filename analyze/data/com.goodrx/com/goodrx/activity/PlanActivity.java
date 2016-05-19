package com.goodrx.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.goodrx.widget.BaseActivityWithPasscode;
import java.util.ArrayList;

public class PlanActivity extends BaseActivityWithPasscode {
   public static void launch(Activity var0) {
      var0.startActivity(new Intent(var0, PlanActivity.class));
      var0.overridePendingTransition(2131034132, 2131034138);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130968629);
      ListView var2 = (ListView)this.findViewById(2131886317);
      ArrayList var3 = new ArrayList();
      var3.add("AARP");
      var3.add("Aetna");
      var3.add("Anthem Blue Cross");
      var3.add("Blue Shield");
      var3.add("Cigna-HealthSpring");
      var3.add("EnvisionRxPlus");
      var3.add("Express Scripts");
      var3.add("First Health");
      var3.add("Humana");
      var3.add("Symphonix");
      var3.add("Transamerica");
      var3.add("United American");
      var2.setAdapter(new ArrayAdapter(this, 2130968729, 2131886582, var3));
   }
}
