package com.goodrx.utils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.goodrx.model.ResponseEntity;
import com.goodrx.utils.DBHelper;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

public class DBManager {
   // $FF: renamed from: db android.database.sqlite.SQLiteDatabase
   private SQLiteDatabase field_129;
   private DBHelper dbHelper;

   public DBManager(Context var1) {
      this.dbHelper = new DBHelper(var1);
   }

   public void clearAllCache() {
      this.field_129 = this.dbHelper.getWritableDatabase();
      SQLiteDatabase var1 = this.field_129;
      if(!(var1 instanceof SQLiteDatabase)) {
         var1.delete("cache", (String)null, (String[])null);
      } else {
         SQLiteInstrumentation.delete((SQLiteDatabase)var1, "cache", (String)null, (String[])null);
      }

      this.field_129.close();
   }

   public void clearLocationSensitiveData() {
      this.field_129 = this.dbHelper.getWritableDatabase();
      SQLiteDatabase var1 = this.field_129;
      String[] var2 = new String[]{"1"};
      if(!(var1 instanceof SQLiteDatabase)) {
         var1.delete("cache", "location_sensitive=?", var2);
      } else {
         SQLiteInstrumentation.delete((SQLiteDatabase)var1, "cache", "location_sensitive=?", var2);
      }

      this.field_129.close();
   }

   public ResponseEntity getDataFromUrl(String var1, String var2) {
      this.field_129 = this.dbHelper.getReadableDatabase();
      SQLiteDatabase var3 = this.field_129;
      String[] var4 = new String[]{var1, var2};
      Cursor var5;
      if(!(var3 instanceof SQLiteDatabase)) {
         var5 = var3.query("cache", (String[])null, "url=? and params=?", var4, (String)null, (String)null, (String)null);
      } else {
         var5 = SQLiteInstrumentation.query((SQLiteDatabase)var3, "cache", (String[])null, "url=? and params=?", var4, (String)null, (String)null, (String)null);
      }

      boolean var6 = var5.moveToNext();
      ResponseEntity var7 = null;
      if(var6) {
         var7 = new ResponseEntity(var1, var2, var5.getString(var5.getColumnIndex("content")), var5.getLong(var5.getColumnIndex("last_modified")), var5.getInt(var5.getColumnIndex("location_sensitive")));
      }

      var5.close();
      this.field_129.close();
      return var7;
   }

   public void insertOrUpdate(ResponseEntity param1) {
      // $FF: Couldn't be decompiled
   }
}
