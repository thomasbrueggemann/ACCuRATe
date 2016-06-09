package com.google.ads.conversiontracking;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.net.Uri;
import android.util.Log;
import com.google.ads.conversiontracking.class_76;
import com.google.ads.conversiontracking.d;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.List;
import java.util.Locale;

// $FF: renamed from: com.google.ads.conversiontracking.f
public class class_74 {
   // $FF: renamed from: a java.lang.String
   private static final String field_553;
   // $FF: renamed from: b com.google.ads.conversiontracking.f$a
   private final class_74.class_92 field_554;
   // $FF: renamed from: c java.lang.Object
   private final Object field_555 = new Object();

   static {
      field_553 = String.format(Locale.US, "CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT, %s INTEGER, %s INTEGER, %s TEXT, %s INTEGER, %s INTEGER,%s INTEGER);", new Object[]{"conversiontracking", "conversion_ping_id", "string_url", "preference_key", "is_repeatable", "parameter_is_null", "preference_name", "record_time", "retry_count", "last_retry_time"});
   }

   public class_74(Context var1) {
      this.field_554 = new class_74.class_92(var1, "google_conversion_tracking.db");
   }

   // $FF: renamed from: a () android.database.sqlite.SQLiteDatabase
   public SQLiteDatabase method_501() {
      try {
         SQLiteDatabase var3 = this.field_554.getWritableDatabase();
         return var3;
      } catch (SQLiteException var4) {
         Log.w("GoogleConversionReporter", "Error opening writable conversion tracking database");
         return null;
      }
   }

   // $FF: renamed from: a (android.database.Cursor) com.google.ads.conversiontracking.d
   public class_76 method_502(Cursor var1) {
      byte var2 = 1;
      if(var1 == null) {
         return null;
      } else {
         int var3 = var1.getInt(7);
         String var4 = var1.getString(var2);
         if(var3 > 0) {
            var4 = Uri.parse(var4).buildUpon().appendQueryParameter("retry", Integer.toString(var3)).build().toString();
         }

         long var5 = var1.getLong(0);
         String var7 = var1.getString(2);
         byte var8;
         if(var1.getInt(3) > 0) {
            var8 = var2;
         } else {
            var8 = 0;
         }

         if(var1.getInt(4) <= 0) {
            var2 = 0;
         }

         return new class_76(var5, var4, var7, (boolean)var8, (boolean)var2, var1.getString(5), var1.getLong(6), var3);
      }
   }

   // $FF: renamed from: a (long) java.util.List
   public List<d> method_503(long param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.ads.conversiontracking.d) void
   public void method_504(class_76 param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b () void
   public void method_505() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (com.google.ads.conversiontracking.d) void
   public void method_506(class_76 param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: c () int
   public int method_507() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: c (com.google.ads.conversiontracking.d) void
   public void method_508(class_76 param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: d () void
   public void method_509() {
      // $FF: Couldn't be decompiled
   }

   public class class_92 extends SQLiteOpenHelper {
      public class_92(Context var2, String var3) {
         super(var2, var3, (CursorFactory)null, 5);
      }

      public void onCreate(SQLiteDatabase var1) {
         String var2 = class_74.field_553;
         if(!(var1 instanceof SQLiteDatabase)) {
            var1.execSQL(var2);
         } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)var1, var2);
         }
      }

      public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
         Log.i("GoogleConversionReporter", (new StringBuilder(64)).append("Database updated from version ").append(var2).append(" to version ").append(var3).toString());
         if(!(var1 instanceof SQLiteDatabase)) {
            var1.execSQL("DROP TABLE IF EXISTS conversiontracking");
         } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)var1, "DROP TABLE IF EXISTS conversiontracking");
         }

         this.onCreate(var1);
      }
   }
}
