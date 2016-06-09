package com.parse;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import bolts.Task;
import com.parse.ParseSQLiteDatabase;

abstract class ParseSQLiteOpenHelper {
   private final SQLiteOpenHelper helper;

   public ParseSQLiteOpenHelper(final Context var1, final String var2, final CursorFactory var3, final int var4) {
      this.helper = new SQLiteOpenHelper(var1, var2, var3, var4) {
         public void onCreate(SQLiteDatabase var1) {
            ParseSQLiteOpenHelper.this.onCreate(var1);
         }

         public void onOpen(SQLiteDatabase var1) {
            super.onOpen(var1);
            ParseSQLiteOpenHelper.this.onOpen(var1);
         }

         public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
            ParseSQLiteOpenHelper.this.onUpgrade(var1, var2, var3);
         }
      };
   }

   private Task<ParseSQLiteDatabase> getDatabaseAsync(boolean var1) {
      SQLiteOpenHelper var2 = this.helper;
      byte var3;
      if(!var1) {
         var3 = 1;
      } else {
         var3 = 0;
      }

      return ParseSQLiteDatabase.openDatabaseAsync(var2, var3);
   }

   public Task<ParseSQLiteDatabase> getReadableDatabaseAsync() {
      return this.getDatabaseAsync(false);
   }

   public Task<ParseSQLiteDatabase> getWritableDatabaseAsync() {
      return this.getDatabaseAsync(true);
   }

   public abstract void onCreate(SQLiteDatabase var1);

   public void onOpen(SQLiteDatabase var1) {
   }

   public abstract void onUpgrade(SQLiteDatabase var1, int var2, int var3);
}
