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
import com.drugguide.quiz.MainActivity;
import com.drugguide.quiz.Start;
import com.drugguide.quiz.ViewFacourites;
import com.drugguide.quiz.ViewQuiz;
import java.util.ArrayList;

public class Quiz extends ListActivity {
   int answer;
   ArrayAdapter arrayAdapter;
   ArrayList<String> drugNames;
   // $FF: renamed from: lv android.widget.ListView
   ListView field_10;
   String questionClicked;

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130903045);
      ActionBar var2 = this.getActionBar();
      var2.setBackgroundDrawable(this.getResources().getDrawable(2130837504));
      var2.setDisplayHomeAsUpEnabled(true);
      ((ImageView)this.findViewById(16908332)).setPadding(5, 0, 10, 0);
      this.field_10 = (ListView)this.findViewById(16908298);
      this.drugNames = new ArrayList();
      this.drugNames.add("1. PCP/Angel dust is in what class of drugs? ");
      this.drugNames.add("2. Club drugs are safe to take with alcohol");
      this.drugNames.add("3. What is a side effect of anabolic steroids in men?");
      this.drugNames.add("4. Stimulant drugs are also known as? ");
      this.drugNames.add("5. Caffeine is a? ");
      this.drugNames.add("6. Huffing is the inhalation of fumes?");
      this.drugNames.add("7. Inhalants cause brain damage");
      this.drugNames.add("8. Methamphetamines are...");
      this.drugNames.add("9. What percent those killed in car accidents are teens?");
      this.drugNames.add("10. Addiction is hereditary?");
      this.arrayAdapter = new ArrayAdapter(this, 2130903042, this.drugNames);
      this.field_10.setAdapter(this.arrayAdapter);
   }

   public boolean onCreateOptionsMenu(Menu var1) {
      this.getMenuInflater().inflate(2131230720, var1);
      return true;
   }

   protected void onListItemClick(ListView var1, View var2, int var3, long var4) {
      super.onListItemClick(var1, var2, var3, var4);
      this.questionClicked = Integer.toString(var3);
      String var6 = (String)this.arrayAdapter.getItem(var3);
      switch(var3) {
      case 0:
         this.answer = 2;
         break;
      case 1:
         this.answer = 1;
         break;
      case 2:
         this.answer = 0;
         break;
      case 3:
         this.answer = 0;
         break;
      case 4:
         this.answer = 3;
         break;
      case 5:
         this.answer = 0;
         break;
      case 6:
         this.answer = 0;
         break;
      case 7:
         this.answer = 2;
         break;
      case 8:
         this.answer = 3;
         break;
      case 9:
         this.answer = 0;
      }

      Intent var7 = new Intent(this, ViewQuiz.class);
      var7.putExtra("clickedQuestion", this.questionClicked);
      var7.putExtra("correctAnswer", this.answer);
      var7.putExtra("clickedQuestionName", var6);
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
