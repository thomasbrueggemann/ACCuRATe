package com.goodrx.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

public class DBHelper extends SQLiteOpenHelper {
   public static final String DATABASE_CACHE_COLUMN_CONTENT = "content";
   public static final String DATABASE_CACHE_COLUMN_LAST_MODIFIED = "last_modified";
   public static final String DATABASE_CACHE_COLUMN_LOCATION_SENSITIVE = "location_sensitive";
   public static final String DATABASE_CACHE_COLUMN_PARAMS = "params";
   public static final String DATABASE_CACHE_COLUMN_URL = "url";
   public static final String DATABASE_CACHE_NAME = "cache";
   private static final String DATABASE_NAME = "goodrx.db";
   public static final long DATABASE_SIZE = 20971520L;
   private static final int DATABASE_VERSION = 1;

   public DBHelper(Context var1) {
      super(var1, "goodrx.db", (CursorFactory)null, 1);
   }

   public void onCreate(SQLiteDatabase var1) {
      if(!(var1 instanceof SQLiteDatabase)) {
         var1.execSQL("CREATE TABLE IF NOT EXISTS cache(_id INTEGER PRIMARY KEY AUTOINCREMENT, url TEXT, params TEXT, content TEXT, last_modified LONG,location_sensitive INTEGER)");
      } else {
         SQLiteInstrumentation.execSQL((SQLiteDatabase)var1, "CREATE TABLE IF NOT EXISTS cache(_id INTEGER PRIMARY KEY AUTOINCREMENT, url TEXT, params TEXT, content TEXT, last_modified LONG,location_sensitive INTEGER)");
      }

      var1.setMaximumSize(20971520L);
   }

   public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
   }
}
