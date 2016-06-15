package com.drugguide.quiz;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.drugguide.quiz.ImageGallery;
import com.drugguide.quiz.MainActivity;
import com.drugguide.quiz.Quiz;
import com.drugguide.quiz.ViewFacourites;

public class Start extends Activity implements OnClickListener {
   ImageButton about;
   ImageButton drugs;
   ImageButton favs;
   // $FF: renamed from: fb android.widget.ImageButton
   ImageButton field_9;
   ImageButton help;
   TextView title;

   private void initVars() {
      this.drugs = (ImageButton)this.findViewById(2131296268);
      this.favs = (ImageButton)this.findViewById(2131296263);
      this.help = (ImageButton)this.findViewById(2131296270);
      this.about = (ImageButton)this.findViewById(2131296271);
      this.help.setOnClickListener(this);
      this.drugs.setOnClickListener(this);
      this.favs.setOnClickListener(this);
      this.about.setOnClickListener(this);
   }

   public void onClick(View var1) {
      switch(var1.getId()) {
      case 2131296263:
         this.startActivity(new Intent(this, ViewFacourites.class));
         return;
      case 2131296264:
      case 2131296265:
      case 2131296266:
      case 2131296267:
      case 2131296269:
      default:
         return;
      case 2131296268:
         this.startActivity(new Intent(this, MainActivity.class));
         return;
      case 2131296270:
         this.startActivity(new Intent(this, Quiz.class));
         return;
      case 2131296271:
         this.startActivity(new Intent(this, ImageGallery.class));
      }
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130903046);
      this.getActionBar().setBackgroundDrawable(this.getResources().getDrawable(2130837504));
      ImageView var2 = (ImageView)this.findViewById(16908332);
      this.title = (TextView)this.findViewById(2131296266);
      var2.setPadding(5, 0, 10, 0);
      Typeface var3 = Typeface.createFromAsset(this.getAssets(), "fonts/CantoraOne-Regular.ttf");
      this.title.setTypeface(var3);
      this.title.setTextSize(23.0F);
      this.initVars();
   }

   public boolean onCreateOptionsMenu(Menu var1) {
      this.getMenuInflater().inflate(2131230720, var1);
      return true;
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      switch(var1.getItemId()) {
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
}
