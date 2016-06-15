package com.drugguide.quiz;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import com.drugguide.quiz.Descriptions;
import com.drugguide.quiz.Quiz;
import com.drugguide.quiz.Start;
import com.drugguide.quiz.ViewFacourites;
import java.util.ArrayList;

public class MainActivity extends ListActivity {
   ArrayAdapter arrayAdapter;
   ArrayList<String> drugNames;
   EditText inputSearch;
   // $FF: renamed from: iv android.widget.ImageView
   ImageView field_1;
   // $FF: renamed from: lv android.widget.ListView
   ListView field_2;

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130903041);
      ActionBar var2 = this.getActionBar();
      var2.setBackgroundDrawable(this.getResources().getDrawable(2130837504));
      var2.setDisplayHomeAsUpEnabled(true);
      ((ImageView)this.findViewById(16908332)).setPadding(5, 0, 10, 0);
      this.field_1 = (ImageView)this.findViewById(2131296262);
      this.field_2 = (ListView)this.findViewById(16908298);
      this.drugNames = new ArrayList();
      this.drugNames.add("Heroin");
      this.drugNames.add("Cocaine");
      this.drugNames.add("Barbiturates");
      this.drugNames.add("Street methadone");
      this.drugNames.add("Alcohol");
      this.drugNames.add("Ketamine");
      this.drugNames.add("Benzodiazepines");
      this.drugNames.add("Amphetamine");
      this.drugNames.add("Tobacco");
      this.drugNames.add("MDMA");
      this.drugNames.add("Cannabis");
      this.drugNames.add("Kratom");
      this.drugNames.add("Solvents");
      this.drugNames.add("GHB");
      this.drugNames.add("LSD");
      this.drugNames.add("Salvia");
      this.drugNames.add("Anabolic steroids");
      this.drugNames.add("Clenbuterol");
      this.drugNames.add("PCP");
      this.drugNames.add("Amyl nitrates");
      this.drugNames.add("Crack Cocaine");
      this.drugNames.add("Crystal Meth");
      this.drugNames.add("Oxycodone(prescription opiates)");
      this.drugNames.add("DXM");
      this.drugNames.add("Magic Mushrooms(Psilocybin)");
      this.drugNames.add("Khat");
      this.arrayAdapter = new ArrayAdapter(this, 2130903042, this.drugNames);
      this.field_2.setAdapter(this.arrayAdapter);
   }

   public boolean onCreateOptionsMenu(Menu var1) {
      this.getMenuInflater().inflate(2131230720, var1);
      return true;
   }

   protected void onListItemClick(ListView var1, View var2, int var3, long var4) {
      super.onListItemClick(var1, var2, var3, var4);
      String var6 = (String)this.arrayAdapter.getItem(var3);
      Intent var7 = new Intent(this, Descriptions.class);
      var7.putExtra("clickedItem", var3);
      var7.putExtra("clickedName", var6);
      this.startActivity(var7);
      this.field_1 = (ImageButton)this.findViewById(this.getResources().getIdentifier("imageView1", "id", "com.example.drugguidepro"));
      System.out.println(this.getResources().getIdentifier("image" + var3, "drawable", "com.example.drugguidepro"));
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

   public void search(View var1) {
      this.startActivity(new Intent(this, ViewFacourites.class));
   }

   public void toFavs(View var1) {
      this.startActivity(new Intent(this, ViewFacourites.class));
   }
}
