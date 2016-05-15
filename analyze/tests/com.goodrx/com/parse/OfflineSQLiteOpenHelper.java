package com.parse;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.parse.ParseSQLiteOpenHelper;

class OfflineSQLiteOpenHelper extends ParseSQLiteOpenHelper {
   private static final String DATABASE_NAME = "ParseOfflineStore";
   private static final int DATABASE_VERSION = 4;
   static final String KEY_CLASS_NAME = "className";
   static final String KEY_IS_DELETING_EVENTUALLY = "isDeletingEventually";
   static final String KEY_JSON = "json";
   static final String KEY_KEY = "key";
   static final String KEY_OBJECT_ID = "objectId";
   static final String KEY_UUID = "uuid";
   static final String TABLE_DEPENDENCIES = "Dependencies";
   static final String TABLE_OBJECTS = "ParseObjects";

   public OfflineSQLiteOpenHelper(Context var1) {
      super(var1, "ParseOfflineStore", (CursorFactory)null, 4);
   }

   private void createSchema(SQLiteDatabase var1) {
      if(!(var1 instanceof SQLiteDatabase)) {
         var1.execSQL("CREATE TABLE ParseObjects (uuid TEXT PRIMARY KEY, className TEXT NOT NULL, objectId TEXT, json TEXT, isDeletingEventually INTEGER DEFAULT 0, UNIQUE(className, objectId));");
      } else {
         SQLiteInstrumentation.execSQL((SQLiteDatabase)var1, "CREATE TABLE ParseObjects (uuid TEXT PRIMARY KEY, className TEXT NOT NULL, objectId TEXT, json TEXT, isDeletingEventually INTEGER DEFAULT 0, UNIQUE(className, objectId));");
      }

      if(!(var1 instanceof SQLiteDatabase)) {
         var1.execSQL("CREATE TABLE Dependencies (key TEXT NOT NULL, uuid TEXT NOT NULL, PRIMARY KEY(key, uuid));");
      } else {
         SQLiteInstrumentation.execSQL((SQLiteDatabase)var1, "CREATE TABLE Dependencies (key TEXT NOT NULL, uuid TEXT NOT NULL, PRIMARY KEY(key, uuid));");
      }
   }

   public void clearDatabase(Context var1) {
      var1.deleteDatabase("ParseOfflineStore");
   }

   public void onCreate(SQLiteDatabase var1) {
      this.createSchema(var1);
   }

   public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
   }
}
