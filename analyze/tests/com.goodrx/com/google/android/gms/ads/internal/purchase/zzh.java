package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import com.google.android.gms.ads.internal.purchase.zzf;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.Locale;

@zzhb
public class zzh {
   private static final String zzFV;
   private static zzh zzFX;
   private static final Object zzpV;
   private final zzh.zza zzFW;

   static {
      zzFV = String.format(Locale.US, "CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", new Object[]{"InAppPurchase", "purchase_id", "product_id", "developer_payload", "record_time"});
      zzpV = new Object();
   }

   zzh(Context var1) {
      this.zzFW = new zzh.zza(var1, "google_inapp_purchase.db");
   }

   public static zzh zzy(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public int getRecordCount() {
      // $FF: Couldn't be decompiled
   }

   public SQLiteDatabase getWritableDatabase() {
      try {
         SQLiteDatabase var2 = this.zzFW.getWritableDatabase();
         return var2;
      } catch (SQLiteException var3) {
         zzin.zzaK("Error opening writable conversion tracking database");
         return null;
      }
   }

   public zzf zza(Cursor var1) {
      return var1 == null?null:new zzf(var1.getLong(0), var1.getString(1), var1.getString(2));
   }

   public void zza(zzf param1) {
      // $FF: Couldn't be decompiled
   }

   public void zzb(zzf param1) {
      // $FF: Couldn't be decompiled
   }

   public void zzfY() {
      // $FF: Couldn't be decompiled
   }

   public class zza extends SQLiteOpenHelper {
      public zza(Context var2, String var3) {
         super(var2, var3, (CursorFactory)null, 4);
      }

      public void onCreate(SQLiteDatabase var1) {
         String var2 = zzh.zzFV;
         if(!(var1 instanceof SQLiteDatabase)) {
            var1.execSQL(var2);
         } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)var1, var2);
         }
      }

      public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
         zzin.zzaJ("Database updated from version " + var2 + " to version " + var3);
         if(!(var1 instanceof SQLiteDatabase)) {
            var1.execSQL("DROP TABLE IF EXISTS InAppPurchase");
         } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)var1, "DROP TABLE IF EXISTS InAppPurchase");
         }

         this.onCreate(var1);
      }
   }
}
