package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.os.Build.VERSION;
import com.google.android.gms.internal.class_141;
import com.google.android.gms.internal.class_720;
import com.google.android.gms.tagmanager.ap;
import com.google.android.gms.tagmanager.class_613;
import com.google.android.gms.tagmanager.class_616;
import com.google.android.gms.tagmanager.class_633;
import com.google.android.gms.tagmanager.class_643;
import com.google.android.gms.tagmanager.class_647;
import com.google.android.gms.tagmanager.class_77;
import com.google.android.gms.tagmanager.class_78;
import com.google.android.gms.tagmanager.class_89;
import java.util.List;
import org.apache.http.impl.client.DefaultHttpClient;

// $FF: renamed from: com.google.android.gms.tagmanager.cb
class class_620 implements class_77 {
   // $FF: renamed from: BS java.lang.String
   private static final String field_2729 = String.format("CREATE TABLE IF NOT EXISTS %s ( \'%s\' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \'%s\' INTEGER NOT NULL, \'%s\' TEXT NOT NULL,\'%s\' INTEGER NOT NULL);", new Object[]{"gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time"});
   // $FF: renamed from: BV java.lang.String
   private final String field_2730;
   // $FF: renamed from: BX long
   private long field_2731;
   // $FF: renamed from: BY int
   private final int field_2732;
   private final class_620.class_1295 asf;
   private volatile class_89 asg;
   private final class_78 ash;
   private final Context mContext;
   // $FF: renamed from: wb com.google.android.gms.internal.ld
   private class_141 field_2733;

   class_620(class_78 var1, Context var2) {
      this(var1, var2, "gtm_urls.db", 2000);
   }

   class_620(class_78 var1, Context var2, String var3, int var4) {
      this.mContext = var2.getApplicationContext();
      this.field_2730 = var3;
      this.ash = var1;
      this.field_2733 = class_720.method_4198();
      this.asf = new class_620.class_1295(this.mContext, this.field_2730);
      this.asg = new class_633(new DefaultHttpClient(), this.mContext, new class_620.class_1294());
      this.field_2731 = 0L;
      this.field_2732 = var4;
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.cb, long, long) void
   // $FF: synthetic method
   static void method_3534(class_620 var0, long var1, long var3) {
      var0.method_3538(var1, var3);
   }

   // $FF: renamed from: al (java.lang.String) android.database.sqlite.SQLiteDatabase
   private SQLiteDatabase method_3535(String var1) {
      try {
         SQLiteDatabase var3 = this.asf.getWritableDatabase();
         return var3;
      } catch (SQLiteException var4) {
         class_613.method_3494(var1);
         return null;
      }
   }

   // $FF: renamed from: c (long, long) void
   private void method_3538(long var1, long var3) {
      SQLiteDatabase var5 = this.method_3535("Error opening database for getNumStoredHits.");
      if(var5 != null) {
         ContentValues var6 = new ContentValues();
         var6.put("hit_first_send_time", Long.valueOf(var3));

         try {
            String[] var8 = new String[]{String.valueOf(var1)};
            var5.update("gtm_hits", var6, "hit_id=?", var8);
         } catch (SQLiteException var9) {
            class_613.method_3494("Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + var1);
            this.method_3542(var1);
         }
      }
   }

   // $FF: renamed from: fh () void
   private void method_3539() {
      int var1 = 1 + (this.method_3547() - this.field_2732);
      if(var1 > 0) {
         List var2 = this.method_3543(var1);
         class_613.method_3493("Store full, deleting " + var2.size() + " hits to make room.");
         this.method_3545((String[])var2.toArray(new String[0]));
      }

   }

   // $FF: renamed from: g (long, java.lang.String) void
   private void method_3540(long var1, String var3) {
      SQLiteDatabase var4 = this.method_3535("Error opening database for putHit");
      if(var4 != null) {
         ContentValues var5 = new ContentValues();
         var5.put("hit_time", Long.valueOf(var1));
         var5.put("hit_url", var3);
         var5.put("hit_first_send_time", Integer.valueOf(0));

         try {
            var4.insert("gtm_hits", (String)null, var5);
            this.ash.method_410(false);
         } catch (SQLiteException var7) {
            class_613.method_3494("Error storing hit");
         }
      }
   }

   // $FF: renamed from: y (long) void
   private void method_3542(long var1) {
      String[] var3 = new String[]{String.valueOf(var1)};
      this.method_3545(var3);
   }

   // $FF: renamed from: G (int) java.util.List
   List<String> method_3543(int param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: H (int) java.util.List
   public List<ap> method_3544(int param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (java.lang.String[]) void
   void method_3545(String[] param1) {
      // $FF: Couldn't be decompiled
   }

   public void dispatch() {
      class_613.method_3493("GTM Dispatch running...");
      if(this.asg.method_436()) {
         List var1 = this.method_3544(40);
         if(var1.isEmpty()) {
            class_613.method_3493("...nothing to dispatch");
            this.ash.method_410(true);
            return;
         }

         this.asg.method_437(var1);
         if(this.method_3548() > 0) {
            class_643.method_3665().dispatch();
            return;
         }
      }

   }

   // $FF: renamed from: f (long, java.lang.String) void
   public void method_408(long var1, String var3) {
      this.method_3546();
      this.method_3539();
      this.method_3540(var1, var3);
   }

   // $FF: renamed from: fi () int
   int method_3546() {
      byte var1 = 1;
      long var2 = this.field_2733.currentTimeMillis();
      if(var2 > 86400000L + this.field_2731) {
         this.field_2731 = var2;
         SQLiteDatabase var4 = this.method_3535("Error opening database for deleteStaleHits.");
         if(var4 != null) {
            long var5 = this.field_2733.currentTimeMillis() - 2592000000L;
            String[] var7 = new String[var1];
            var7[0] = Long.toString(var5);
            int var8 = var4.delete("gtm_hits", "HIT_TIME < ?", var7);
            class_78 var9 = this.ash;
            if(this.method_3547() != 0) {
               var1 = 0;
            }

            var9.method_410((boolean)var1);
            return var8;
         }
      }

      return 0;
   }

   // $FF: renamed from: fj () int
   int method_3547() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: pY () int
   int method_3548() {
      // $FF: Couldn't be decompiled
   }

   class class_1294 implements class_633.class_1679 {
      // $FF: renamed from: a (com.google.android.gms.tagmanager.ap) void
      public void method_935(class_616 var1) {
         class_620.this.method_3542(var1.method_3509());
      }

      // $FF: renamed from: b (com.google.android.gms.tagmanager.ap) void
      public void method_936(class_616 var1) {
         class_620.this.method_3542(var1.method_3509());
         class_613.method_3493("Permanent failure dispatching hitId: " + var1.method_3509());
      }

      // $FF: renamed from: c (com.google.android.gms.tagmanager.ap) void
      public void method_937(class_616 var1) {
         long var2 = var1.method_3510();
         if(var2 == 0L) {
            class_620.method_3534(class_620.this, var1.method_3509(), class_620.this.field_2733.currentTimeMillis());
         } else if(var2 + 14400000L < class_620.this.field_2733.currentTimeMillis()) {
            class_620.this.method_3542(var1.method_3509());
            class_613.method_3493("Giving up on failed hitId: " + var1.method_3509());
            return;
         }

      }
   }

   class class_1295 extends SQLiteOpenHelper {
      // $FF: renamed from: BZ boolean
      private boolean field_2510;
      // $FF: renamed from: Ca long
      private long field_2511 = 0L;

      class_1295(Context var2, String var3) {
         super(var2, var3, (CursorFactory)null, 1);
      }

      // $FF: renamed from: a (android.database.sqlite.SQLiteDatabase) void
      private void method_3268(SQLiteDatabase param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.String, android.database.sqlite.SQLiteDatabase) boolean
      private boolean method_3269(String param1, SQLiteDatabase param2) {
         // $FF: Couldn't be decompiled
      }

      public SQLiteDatabase getWritableDatabase() {
         if(this.field_2510 && 3600000L + this.field_2511 > class_620.this.field_2733.currentTimeMillis()) {
            throw new SQLiteException("Database creation failed");
         } else {
            this.field_2510 = true;
            this.field_2511 = class_620.this.field_2733.currentTimeMillis();

            SQLiteDatabase var3;
            label21: {
               SQLiteDatabase var4;
               try {
                  var4 = super.getWritableDatabase();
               } catch (SQLiteException var5) {
                  class_620.this.mContext.getDatabasePath(class_620.this.field_2730).delete();
                  var3 = null;
                  break label21;
               }

               var3 = var4;
            }

            if(var3 == null) {
               var3 = super.getWritableDatabase();
            }

            this.field_2510 = false;
            return var3;
         }
      }

      public void onCreate(SQLiteDatabase var1) {
         class_647.method_3681(var1.getPath());
      }

      public void onOpen(SQLiteDatabase var1) {
         if(VERSION.SDK_INT < 15) {
            Cursor var2 = var1.rawQuery("PRAGMA journal_mode=memory", (String[])null);

            try {
               var2.moveToFirst();
            } finally {
               var2.close();
            }
         }

         if(!this.method_3269("gtm_hits", var1)) {
            var1.execSQL(class_620.field_2729);
         } else {
            this.method_3268(var1);
         }
      }

      public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
      }
   }
}
