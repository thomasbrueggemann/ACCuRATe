package com.drugguide.quiz;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.drugguide.quiz.Descriptions;
import com.drugguide.quiz.FavouritesDatabase;
import com.drugguide.quiz.MainActivity;
import com.drugguide.quiz.Quiz;
import com.drugguide.quiz.Start;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViewFacourites extends ListActivity {
   String[] array2;
   ArrayAdapter arrayAdapter;
   String data;
   String derp;
   // $FF: renamed from: f java.lang.String[]
   String[] field_7;
   List[] list;
   // $FF: renamed from: lv android.widget.ListView
   ListView field_8;
   int pos;
   String pos2;
   String posi;
   private ArrayList<String> results = new ArrayList();
   ArrayList<String> stringList2;

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130903044);
      ActionBar var2 = this.getActionBar();
      var2.setBackgroundDrawable(this.getResources().getDrawable(2130837504));
      var2.setDisplayHomeAsUpEnabled(true);
      ((ImageView)this.findViewById(16908332)).setPadding(5, 0, 10, 0);
      this.field_8 = (ListView)this.findViewById(16908298);
      TextView var10000 = (TextView)this.findViewById(2131296256);
      FavouritesDatabase var4 = new FavouritesDatabase(this);
      var4.open();
      ArrayList var6 = var4.getName();
      ArrayList var7 = var4.getData();
      var4.close();
      if(var7.size() <= 0) {
         Toast.makeText(this.getApplicationContext(), "Nothing saved in favourites", 1).show();
      }

      if(var6.size() >= 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            this.derp = (String)var6.get(var8);
         }

         for(int var9 = 0; var9 < var7.size(); ++var9) {
            this.pos2 = (String)var7.get(var9);
         }

         if(this.derp != null) {
            ArrayList var10 = new ArrayList(Arrays.asList(this.derp.split("(\n)")));
            this.array2 = this.pos2.split("(\n)");
            this.stringList2 = new ArrayList(Arrays.asList(this.array2));
            this.field_7 = (String[])this.stringList2.toArray(new String[0]);
            ArrayAdapter var11 = new ArrayAdapter(this, 2130903042, var10);
            this.arrayAdapter = var11;
            this.field_8.setAdapter(this.arrayAdapter);
         }
      }

   }

   public boolean onCreateOptionsMenu(Menu var1) {
      this.getMenuInflater().inflate(2131230720, var1);
      return true;
   }

   protected void onListItemClick(ListView var1, View var2, int var3, long var4) {
      super.onListItemClick(var1, var2, this.pos, var4);
      this.pos = Integer.parseInt(this.field_7[var3]);
      String var6 = (String)this.field_8.getItemAtPosition(var3);
      Intent var7 = new Intent(this, Descriptions.class);
      var7.putExtra("clickedName", var6);
      var7.putExtra("clickedItem", this.pos);
      this.startActivity(var7);
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
}
