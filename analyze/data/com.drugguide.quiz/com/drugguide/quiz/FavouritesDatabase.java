package com.drugguide.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import java.util.ArrayList;

public class FavouritesDatabase {
   private static final String DATABASE_NAME = "database10";
   private static final String DATABASE_TABLE = "drugsnames10";
   private static final int DATABASE_VERSION = 1;
   public static final String KEY_NAME = "persons_name";
   public static final String KEY_ROWID = "id";
   private final Context ourContext;
   private SQLiteDatabase ourDatabase;
   private FavouritesDatabase.DbHelper ourHelper;

   public FavouritesDatabase(Context var1) {
      this.ourContext = var1;
   }

   public void close() {
      this.ourHelper.close();
   }

   public long createEntry(int var1, String var2) {
      ContentValues var3 = new ContentValues();
      var3.put("id", Integer.valueOf(var1));
      var3.put("persons_name", var2);
      return this.ourDatabase.insert("drugsnames10", (String)null, var3);
   }

   public void deleteRow(int var1) {
      this.ourDatabase.delete("drugsnames10", "id=" + var1, (String[])null);
   }

   public ArrayList getData() {
      ArrayList var1 = new ArrayList();
      String[] var2 = new String[]{"id"};
      Cursor var3 = this.ourDatabase.query("drugsnames10", var2, (String)null, (String[])null, (String)null, (String)null, (String)null);
      String var4 = "";
      int var5 = var3.getColumnIndex("id");
      var3.moveToFirst();

      while(!var3.isAfterLast()) {
         var4 = var4 + var3.getString(var5) + "\n";
         var1.add(var4);
         var3.moveToNext();
      }

      return var1;
   }

   public ArrayList getName() {
      ArrayList var1 = new ArrayList();
      String[] var2 = new String[]{"persons_name"};
      Cursor var3 = this.ourDatabase.query("drugsnames10", var2, (String)null, (String[])null, (String)null, (String)null, (String)null);
      String var4 = "";
      int var5 = var3.getColumnIndex("persons_name");
      var3.moveToFirst();

      while(!var3.isAfterLast()) {
         var4 = var4 + var3.getString(var5) + "\n";
         var1.add(var4);
         var3.moveToNext();
      }

      return var1;
   }

   public FavouritesDatabase open() throws SQLException {
      this.ourHelper = new FavouritesDatabase.DbHelper(this.ourContext);
      this.ourDatabase = this.ourHelper.getWritableDatabase();
      return this;
   }

   private static class DbHelper extends SQLiteOpenHelper {
      public DbHelper(Context var1) {
         super(var1, "database10", (CursorFactory)null, 1);
      }

      public void onCreate(SQLiteDatabase var1) {
         var1.execSQL("CREATE TABLE drugsnames10 (id INTEGER, persons_name TEXT NOT NULL );");
      }

      public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
         var1.execSQL("DROP TABLE IF EXISTS drugsnames10");
         this.onCreate(var1);
      }
   }
}
