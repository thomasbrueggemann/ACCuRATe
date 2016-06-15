package com.strategeens.drugnotes;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.strategeens.drugnotes.DatabaseHandler;
import com.strategeens.drugnotes.MainActivity;
import com.strategeens.drugnotes.MyApplication;
import com.strategeens.drugnotes.model.Drug;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddUpdateDrug extends Activity {
   String Toast_msg = null;
   int USER_ID;
   String add_date;
   EditText add_name;
   EditText add_note;
   ImageButton add_save_btn;
   // $FF: renamed from: c java.util.Calendar
   Calendar field_3685;
   SimpleDateFormat date;
   DatabaseHandler dbHandler = new DatabaseHandler(this);
   ImageButton dlt_btn;
   String formattedDate;
   ImageButton update_btn;
   String valid_name = "";
   String valid_note = "";
   String valid_user_id = "";

   public void Is_Valid_Drug_Name(EditText var1) throws NumberFormatException {
      this.valid_name = var1.getText().toString();
   }

   public void Is_Valid_Note(EditText var1) throws NumberFormatException {
      this.valid_note = var1.getText().toString();
   }

   public void Set_Add_Update_Screen() {
      this.add_name = (EditText)this.findViewById(2131558425);
      this.add_note = (EditText)this.findViewById(2131558426);
      this.dlt_btn = (ImageButton)this.findViewById(2131558428);
   }

   protected void onCreate(Bundle var1) {
      ((MyApplication)this.getApplication()).getTracker(MyApplication.TrackerName.APP_TRACKER);
      super.onCreate(var1);
      this.setContentView(2130903041);
      this.field_3685 = Calendar.getInstance();
      this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      this.formattedDate = this.date.format(this.field_3685.getTime());
      this.Set_Add_Update_Screen();
      if(!this.getIntent().getStringExtra("called").equalsIgnoreCase("add")) {
         Bundle var3 = this.getIntent().getExtras();
         if(var3 != null) {
            this.getWindow().setSoftInputMode(3);
            this.USER_ID = var3.getInt("USER_ID");
            Drug var4 = this.dbHandler.Get_Contact(this.USER_ID);
            this.add_name.setText(var4.getName());
            this.add_note.setText(var4.getNote());
         }
      }

      this.add_note.addTextChangedListener(new TextWatcher() {
         public void afterTextChanged(Editable var1) {
            AddUpdateDrug.this.Is_Valid_Note(AddUpdateDrug.this.add_note);
         }

         public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }

         public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }
      });
      this.add_name.addTextChangedListener(new TextWatcher() {
         public void afterTextChanged(Editable var1) {
            AddUpdateDrug.this.Is_Valid_Drug_Name(AddUpdateDrug.this.add_name);
         }

         public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }

         public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }
      });
      this.dlt_btn.setOnTouchListener(new OnTouchListener() {
         public boolean onTouch(View var1, MotionEvent var2) {
            switch(var2.getAction()) {
            case 0:
               ((ImageButton)var1).getBackground().setColorFilter(1996488704, Mode.SRC_ATOP);
               var1.invalidate();
               break;
            case 1:
               (new DatabaseHandler(AddUpdateDrug.this.getApplicationContext())).Delete_Contact(AddUpdateDrug.this.USER_ID);
               Toast.makeText(AddUpdateDrug.this.getApplicationContext(), "Deleted Successfully", 0).show();
               Intent var4 = new Intent(AddUpdateDrug.this.getApplicationContext(), MainActivity.class);
               AddUpdateDrug.this.startActivity(var4);
               AddUpdateDrug.this.finish();
            case 3:
               ImageButton var3 = (ImageButton)var1;
               var3.getBackground().clearColorFilter();
               var3.invalidate();
            case 2:
            }

            return true;
         }
      });
   }

   public boolean onCreateOptionsMenu(Menu var1) {
      Bundle var2 = this.getIntent().getExtras();
      if(var2 != null) {
         if(var2.getInt("USER_ID") > 0) {
            this.getMenuInflater().inflate(2131492865, var1);
         } else {
            this.getMenuInflater().inflate(2131492864, var1);
         }
      }

      return true;
   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      if(var1 == 4) {
         GoogleAnalytics.getInstance(this).reportActivityStop(this);
         this.finish();
         Intent var3 = new Intent(this, MainActivity.class);
         var3.addFlags(67108864);
         this.startActivity(var3);
         return true;
      } else {
         return super.onKeyDown(var1, var2);
      }
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      super.onOptionsItemSelected(var1);
      if(var1.getItemId() == 2131558440) {
         Bundle var3 = new Bundle();
         var3.putString("called", "add");
         var3.putInt("USER_ID", 0);
         Intent var4 = new Intent(this.getApplicationContext(), MainActivity.class);
         var4.putExtras(var3);
         this.startActivity(var4);
         if(this.getIntent().getExtras().getInt("USER_ID") > 0) {
            this.valid_name = this.add_name.getText().toString();
            this.valid_note = this.add_note.getText().toString();
            this.dbHandler.Update_Contact(new Drug(this.USER_ID, this.valid_name, this.valid_note, this.formattedDate));
            Toast.makeText(this.getApplicationContext(), "Data Update successfully", 0).show();
            this.finish();
         } else {
            this.dbHandler.Add_Contact(new Drug(this.valid_name, this.valid_note, this.formattedDate));
            Toast.makeText(this.getApplicationContext(), "Data Inserted successfully", 0).show();
            this.finish();
         }

         this.finish();
      }

      return super.onOptionsItemSelected(var1);
   }

   public void run(View var1) {
      Bundle var2 = this.getIntent().getExtras();
      if(var2 != null) {
         if(var2.getInt("USER_ID") <= 0) {
            this.dbHandler.Add_Contact(new Drug(this.valid_name, this.valid_note, this.formattedDate));
            Toast.makeText(this.getApplicationContext(), "Data Inserted successfully", 0).show();
            this.startActivity(new Intent(this.getApplicationContext(), MainActivity.class));
            this.finish();
            return;
         }

         this.valid_name = this.add_name.getText().toString();
         this.valid_note = this.add_note.getText().toString();
         this.dbHandler.Update_Contact(new Drug(this.USER_ID, this.valid_name, this.valid_note, this.formattedDate));
         Toast.makeText(this.getApplicationContext(), "Data Update successfully", 0).show();
         this.startActivity(new Intent(this.getApplicationContext(), MainActivity.class));
         this.finish();
      }

   }
}
