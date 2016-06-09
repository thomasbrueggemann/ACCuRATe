package com.peirr.blooadapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.peirr.blooadapp.activities.MainActivity;
import com.peirr.blooadapp.io.Cache;

public class Splash extends Activity {
   private final Handler handler = new Handler();
   private final Runnable runnable = new Runnable() {
      public void run() {
         Intent var1 = new Intent(Splash.this, MainActivity.class);
         Splash.this.startActivity(var1);
         Splash.this.finish();
      }
   };

   public void onCreate(Bundle var1) {
      this.getWindow().setFlags(1024, 1024);
      this.requestWindowFeature(1);
      super.onCreate(var1);
      this.setContentView(2130903043);
      this.startAnimations();
      Cache.getInstance().setFemale(true);
      this.handler.postDelayed(this.runnable, 3000L);
   }

   public void startAnimations() {
      Animation var1 = AnimationUtils.loadAnimation(this, 2130968576);
      var1.reset();
      View var2 = this.findViewById(2131427337);
      var2.clearAnimation();
      var2.startAnimation(var1);
   }
}
