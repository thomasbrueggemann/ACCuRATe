package com.strategeens.drugnotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;
import com.strategeens.drugnotes.model.Drug;
import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {
   private static final String DATABASE_NAME = "drugsManager";
   private static final int DATABASE_VERSION = 1;
   private static String DB_PATH = "/data/data/com.strategeens.drugnotes/databases/";
   private static final String KEY_DATE = "date";
   private static final String KEY_ID = "id";
   private static final String KEY_NAME = "name";
   private static final String KEY_NOTE = "note";
   private static final String TABLE_DRUGS = "drugs";
   private final ArrayList<Drug> contact_list = new ArrayList();
   private SQLiteDatabase myDataBase;

   public DatabaseHandler(Context var1) {
      super(var1, "drugsManager", (CursorFactory)null, 1);
   }

   public DatabaseHandler(Context var1, String var2) {
      super(var1, var2, (CursorFactory)null, 1);
   }

   public void Add_Contact(Drug var1) {
      SQLiteDatabase var2 = this.getWritableDatabase();
      ContentValues var3 = new ContentValues();
      var3.put("name", var1.getName());
      var3.put("note", var1.getNote());
      var3.put("date", var1.getDate());
      var2.insert("drugs", (String)null, var3);
      var2.close();
   }

   public void Delete_Contact(int var1) {
      SQLiteDatabase var2 = this.getWritableDatabase();
      String[] var3 = new String[]{String.valueOf(var1)};
      var2.delete("drugs", "id = ?", var3);
      var2.close();
   }

   public Drug Get_Contact(int var1) {
      SQLiteDatabase var2 = this.getReadableDatabase();
      String[] var3 = new String[]{"id", "name", "note", "date"};
      String[] var4 = new String[]{String.valueOf(var1)};
      Cursor var5 = var2.query("drugs", var3, "id=?", var4, "", "", "id ASC", (String)null);
      if(var5 != null && var5.moveToFirst()) {
         ;
      }

      System.out.println(var5.getPosition());
      var5.moveToFirst();
      Drug var7 = new Drug(Integer.parseInt(var5.getString(0)), var5.getString(1), var5.getString(2), var5.getString(3));
      var5.close();
      return var7;
   }

   public Drug Get_Contact(String var1, String var2, String var3) {
      SQLiteDatabase var4 = this.getReadableDatabase();
      if(var2 == null) {
         var2 = "";
      }

      if(var1 == null) {
         var1 = "";
      }

      Cursor var5 = var4.rawQuery("SELECT id, name, note, date FROM drugs WHERE name=?AND date=? AND note=?", new String[]{var2, var3, var1});
      boolean var6 = var5.moveToFirst();
      Drug var7 = null;
      if(var6) {
         var7 = new Drug(Integer.parseInt(var5.getString(0)), var5.getString(1), var5.getString(2), var5.getString(3));
      }

      var5.close();
      return var7 != null?var7:null;
   }

   public ArrayList<Drug> Get_Contacts() {
      try {
         this.contact_list.clear();
         SQLiteDatabase var3 = this.getWritableDatabase();
         Cursor var4 = var3.rawQuery("SELECT  * FROM drugs ORDER BY date DESC", (String[])null);
         if(var4.moveToFirst()) {
            do {
               Drug var5 = new Drug();
               var5.setID(Integer.parseInt(var4.getString(0)));
               var5.setName(var4.getString(1));
               var5.setNote(var4.getString(2));
               var5.setDate(var4.getString(3).split(" ")[0]);
               this.contact_list.add(var5);
            } while(var4.moveToNext());
         }

         var4.close();
         var3.close();
         ArrayList var7 = this.contact_list;
         return var7;
      } catch (Exception var8) {
         Log.e("all_contact", "" + var8);
         return this.contact_list;
      }
   }

   public int Get_Total_Contacts() {
      Cursor var1 = this.getReadableDatabase().rawQuery("SELECT  * FROM drugs", (String[])null);
      var1.close();
      return var1.getCount();
   }

   public int Update_Contact(Drug var1) {
      SQLiteDatabase var2 = this.getWritableDatabase();
      ContentValues var3 = new ContentValues();
      var3.put("name", var1.getName());
      var3.put("note", var1.getNote());
      String[] var4 = new String[]{String.valueOf(var1.getID())};
      return var2.update("drugs", var3, "id = ?", var4);
   }

   public void close() {
      synchronized(this){}

      try {
         if(this.myDataBase != null) {
            this.myDataBase.close();
         }

         super.close();
      } finally {
         ;
      }

   }

   public void onCreate(SQLiteDatabase var1) {
      var1.execSQL("CREATE TABLE drugs(id INTEGER PRIMARY KEY,name TEXT,note TEXT,date TEXT)");
   }

   public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
      var1.execSQL("DROP TABLE IF EXISTS drugs");
      this.onCreate(var1);
   }

   public void openDataBase() throws SQLException {
      this.myDataBase = SQLiteDatabase.openDatabase(DB_PATH + "drugsManager", (CursorFactory)null, 1);
   }
}
