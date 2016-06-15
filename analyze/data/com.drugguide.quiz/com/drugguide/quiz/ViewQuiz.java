package com.drugguide.quiz;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.drugguide.quiz.MainActivity;
import com.drugguide.quiz.Quiz;
import com.drugguide.quiz.Start;
import com.drugguide.quiz.ViewFacourites;
import java.util.ArrayList;
import java.util.Arrays;

public class ViewQuiz extends ListActivity {
   public static String filename = "MySharedQuiz";
   int answer;
   ArrayAdapter arrayAdapter;
   String clickedQuestion;
   int correctTen = 10;
   ArrayList<String> drugNames;
   // $FF: renamed from: lv android.widget.ListView
   ListView field_5;
   TextView question;
   String questionName;
   int score = 0;
   SharedPreferences someData;

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130903047);
      ActionBar var2 = this.getActionBar();
      var2.setBackgroundDrawable(this.getResources().getDrawable(2130837504));
      var2.setDisplayHomeAsUpEnabled(true);
      ((ImageView)this.findViewById(16908332)).setPadding(5, 0, 10, 0);
      this.field_5 = (ListView)this.findViewById(16908298);
      this.question = (TextView)this.findViewById(2131296272);
      this.drugNames = new ArrayList();
      Intent var3 = this.getIntent();
      this.someData = this.getSharedPreferences(filename, 0);
      this.clickedQuestion = var3.getStringExtra("clickedQuestion");
      this.answer = var3.getIntExtra("correctAnswer", 0);
      this.questionName = var3.getStringExtra("clickedQuestionName");
      this.question.setText(this.questionName);
      this.question.setTextSize(18.0F);
      Editor var4 = this.someData.edit();
      var4.putString("0", "A) Anabolic Steroid" + "\n" + "B) Opiate" + "\n" + "C) Hallucinogen" + "\n" + "D) Depressant");
      var4.putString("1", "A) true" + "\n" + "B) false");
      var4.putString("2", "A) liver damage" + "\n" + "B) over-dose" + "\n" + "C) brain damage" + "\n" + "D) growing a third arm");
      var4.putString("3", "A) uppers" + "\n" + "B) downers" + "\n" + "C) all-rounders" + "\n" + "D) speeders");
      var4.putString("4", "A) depressant" + "\n" + "B) steroid" + "\n" + "C) opiate" + "\n" + "D) stimulant");
      var4.putString("5", "A) true" + "\n" + "B) false");
      var4.putString("6", "A) true" + "\n" + "B) false");
      var4.putString("7", "A) Depressant" + "\n" + "B) Hallucinogen" + "\n" + "C) Stimulant" + "\n" + "D) Benzo");
      var4.putString("8", "A) 12%" + "\n" + "B) 40%" + "\n" + "C) 100%" + "\n" + "D) 60%");
      var4.putString("9", "A) true" + "\n" + "B) false");
      var4.commit();
      this.someData = this.getSharedPreferences(filename, 0);
      String[] var16 = this.someData.getString(this.clickedQuestion, "Couldn\'t load data").split("(\n)");
      ArrayList var17 = new ArrayList(Arrays.asList(var16));
      ArrayAdapter var18 = new ArrayAdapter(this, 2130903042, var17);
      this.arrayAdapter = var18;
      this.field_5.setAdapter(this.arrayAdapter);
   }

   public boolean onCreateOptionsMenu(Menu var1) {
      this.getMenuInflater().inflate(2131230720, var1);
      return true;
   }

   protected void onListItemClick(ListView var1, View var2, int var3, long var4) {
      super.onListItemClick(var1, var2, var3, var4);
      if(var3 == this.answer) {
         this.score += this.correctTen;
         Intent var6 = new Intent(this, Quiz.class);
         var6.putExtra("score", this.score);
         this.startActivity(var6);
         Toast.makeText(this.getApplicationContext(), "Correct!", 1).show();
      } else {
         Toast.makeText(this.getApplicationContext(), "Wrong!", 1).show();
         this.startActivity(new Intent(this, Quiz.class));
      }
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
