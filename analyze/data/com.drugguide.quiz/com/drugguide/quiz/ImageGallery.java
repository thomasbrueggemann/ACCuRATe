package com.drugguide.quiz;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.drugguide.quiz.MainActivity;
import com.drugguide.quiz.Quiz;
import com.drugguide.quiz.Start;
import com.drugguide.quiz.ViewFacourites;

public class ImageGallery extends Activity {
   ImageButton facebook;
   ImageView imageview;
   ImageButton twitter;

   public void facebook(View var1) {
      Intent var2 = new Intent("android.intent.action.VIEW");
      var2.setData(Uri.parse("https://www.facebook.com/pages/Drug-Effects-Guide/683605121679122"));
      this.startActivity(var2);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130903040);
      ActionBar var2 = this.getActionBar();
      var2.setBackgroundDrawable(this.getResources().getDrawable(2130837504));
      var2.setDisplayHomeAsUpEnabled(true);
      this.facebook = (ImageButton)this.findViewById(2131296259);
      this.twitter = (ImageButton)this.findViewById(2131296260);
   }

   public boolean onCreateOptionsMenu(Menu var1) {
      this.getMenuInflater().inflate(2131230720, var1);
      return true;
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      switch(var1.getItemId()) {
      case 16908332:
         this.startActivity(new Intent(this, Start.class));
         return true;
      case 2131296273:
         this.startActivity(new Intent(this, MainActivity.class));
         return true;
      case 2131296274:
         this.startActivity(new Intent(this, ViewFacourites.class));
         return true;
      case 2131296275:
         this.startActivity(new Intent(this, Quiz.class));
         return true;
      default:
         return super.onOptionsItemSelected(var1);
      }
   }

   public void twitter(View var1) {
      Intent var2 = new Intent("android.intent.action.VIEW");
      var2.setData(Uri.parse("https://twitter.com/DrugEffectsGuid"));
      this.startActivity(var2);
   }
}
