package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.os.Build.VERSION;
import com.google.android.gms.internal.class_19;
import com.google.android.gms.internal.class_279;
import com.google.android.gms.tagmanager.ap;
import com.google.android.gms.tagmanager.class_515;
import com.google.android.gms.tagmanager.class_518;
import com.google.android.gms.tagmanager.class_543;
import com.google.android.gms.tagmanager.class_546;
import com.google.android.gms.tagmanager.class_548;
import com.google.android.gms.tagmanager.class_72;
import com.google.android.gms.tagmanager.class_73;
import com.google.android.gms.tagmanager.class_84;
import java.util.List;
import org.apache.http.impl.client.DefaultHttpClient;

// $FF: renamed from: com.google.android.gms.tagmanager.ca
class class_522 implements class_72 {
   // $FF: renamed from: wM java.lang.String
   private static final String field_2875 = String.format("CREATE TABLE IF NOT EXISTS %s ( \'%s\' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \'%s\' INTEGER NOT NULL, \'%s\' TEXT NOT NULL,\'%s\' INTEGER NOT NULL);", new Object[]{"gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time"});
   private class_19 aec;
   private final class_522.class_819 agn;
   private volatile class_84 ago;
   private final class_73 agp;
   private final Context mContext;
   // $FF: renamed from: wP java.lang.String
   private final String field_2876;
   // $FF: renamed from: wR long
   private long field_2877;
   // $FF: renamed from: wS int
   private final int field_2878;

   class_522(class_73 var1, Context var2) {
      this(var1, var2, "gtm_urls.db", 2000);
   }

   class_522(class_73 var1, Context var2, String var3, int var4) {
      this.mContext = var2.getApplicationContext();
      this.field_2876 = var3;
      this.agp = var1;
      this.aec = class_279.method_1858();
      this.agn = new class_522.class_819(this.mContext, this.field_2876);
      this.ago = new class_546(new DefaultHttpClient(), this.mContext, new class_522.class_820());
      this.field_2877 = 0L;
      this.field_2878 = var4;
   }

   // $FF: renamed from: S (java.lang.String) android.database.sqlite.SQLiteDatabase
   private SQLiteDatabase method_2952(String var1) {
      try {
         SQLiteDatabase var3 = this.agn.getWritableDatabase();
         return var3;
      } catch (SQLiteException var4) {
         class_515.method_2919(var1);
         return null;
      }
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.ca, long, long) void
   // $FF: synthetic method
   static void method_2955(class_522 var0, long var1, long var3) {
      var0.method_2958(var1, var3);
   }

   // $FF: renamed from: c (long, long) void
   private void method_2958(long var1, long var3) {
      SQLiteDatabase var5 = this.method_2952("Error opening database for getNumStoredHits.");
      if(var5 != null) {
         ContentValues var6 = new ContentValues();
         var6.put("hit_first_send_time", Long.valueOf(var3));

         try {
            String[] var8 = new String[]{String.valueOf(var1)};
            var5.update("gtm_hits", var6, "hit_id=?", var8);
         } catch (SQLiteException var9) {
            class_515.method_2919("Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + var1);
            this.method_2962(var1);
         }
      }
   }

   // $FF: renamed from: dm () void
   private void method_2959() {
      int var1 = 1 + (this.method_2967() - this.field_2878);
      if(var1 > 0) {
         List var2 = this.method_2963(var1);
         class_515.method_2918("Store full, deleting " + var2.size() + " hits to make room.");
         this.method_2965((String[])var2.toArray(new String[0]));
      }

   }

   // $FF: renamed from: g (long, java.lang.String) void
   private void method_2960(long var1, String var3) {
      SQLiteDatabase var4 = this.method_2952("Error opening database for putHit");
      if(var4 != null) {
         ContentValues var5 = new ContentValues();
         var5.put("hit_time", Long.valueOf(var1));
         var5.put("hit_url", var3);
         var5.put("hit_first_send_time", Integer.valueOf(0));

         try {
            var4.insert("gtm_hits", (String)null, var5);
            this.agp.method_369(false);
         } catch (SQLiteException var7) {
            class_515.method_2919("Error storing hit");
         }
      }
   }

   // $FF: renamed from: y (long) void
   private void method_2962(long var1) {
      String[] var3 = new String[]{String.valueOf(var1)};
      this.method_2965(var3);
   }

   // $FF: renamed from: A (int) java.util.List
   List<String> method_2963(int param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: B (int) java.util.List
   public List<ap> method_2964(int param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (java.lang.String[]) void
   void method_2965(String[] param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: cl () void
   public void method_366() {
      class_515.method_2918("GTM Dispatch running...");
      if(this.ago.method_395()) {
         List var1 = this.method_2964(40);
         if(var1.isEmpty()) {
            class_515.method_2918("...nothing to dispatch");
            this.agp.method_369(true);
            return;
         }

         this.ago.method_396(var1);
         if(this.method_2968() > 0) {
            class_543.method_3078().method_3081();
            return;
         }
      }

   }

   // $FF: renamed from: dn () int
   int method_2966() {
      byte var1 = 1;
      long var2 = this.aec.currentTimeMillis();
      if(var2 > 86400000L + this.field_2877) {
         this.field_2877 = var2;
         SQLiteDatabase var4 = this.method_2952("Error opening database for deleteStaleHits.");
         if(var4 != null) {
            long var5 = this.aec.currentTimeMillis() - 2592000000L;
            String[] var7 = new String[var1];
            var7[0] = Long.toString(var5);
            int var8 = var4.delete("gtm_hits", "HIT_TIME < ?", var7);
            class_73 var9 = this.agp;
            if(this.method_2967() != 0) {
               var1 = 0;
            }

            var9.method_369((boolean)var1);
            return var8;
         }
      }

      return 0;
   }

   // $FF: renamed from: do () int
   int method_2967() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: f (long, java.lang.String) void
   public void method_367(long var1, String var3) {
      this.method_2966();
      this.method_2959();
      this.method_2960(var1, var3);
   }

   // $FF: renamed from: lW () int
   int method_2968() {
      // $FF: Couldn't be decompiled
   }

   class class_820 implements class_546.class_1208 {
      // $FF: renamed from: a (com.google.android.gms.tagmanager.ap) void
      public void method_674(class_518 var1) {
         class_522.this.method_2962(var1.method_2934());
      }

      // $FF: renamed from: b (com.google.android.gms.tagmanager.ap) void
      public void method_675(class_518 var1) {
         class_522.this.method_2962(var1.method_2934());
         class_515.method_2918("Permanent failure dispatching hitId: " + var1.method_2934());
      }

      // $FF: renamed from: c (com.google.android.gms.tagmanager.ap) void
      public void method_676(class_518 var1) {
         long var2 = var1.method_2935();
         if(var2 == 0L) {
            class_522.method_2955(class_522.this, var1.method_2934(), class_522.this.aec.currentTimeMillis());
         } else if(var2 + 14400000L < class_522.this.aec.currentTimeMillis()) {
            class_522.this.method_2962(var1.method_2934());
            class_515.method_2918("Giving up on failed hitId: " + var1.method_2934());
            return;
         }

      }
   }

   class class_819 extends SQLiteOpenHelper {
      // $FF: renamed from: wU boolean
      private boolean field_898;
      // $FF: renamed from: wV long
      private long field_899 = 0L;

      class_819(Context var2, String var3) {
         super(var2, var3, (CursorFactory)null, 1);
      }

      // $FF: renamed from: a (android.database.sqlite.SQLiteDatabase) void
      private void method_1781(SQLiteDatabase param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.String, android.database.sqlite.SQLiteDatabase) boolean
      private boolean method_1782(String param1, SQLiteDatabase param2) {
         // $FF: Couldn't be decompiled
      }

      public SQLiteDatabase getWritableDatabase() {
         if(this.field_898 && 3600000L + this.field_899 > class_522.this.aec.currentTimeMillis()) {
            throw new SQLiteException("Database creation failed");
         } else {
            this.field_898 = true;
            this.field_899 = class_522.this.aec.currentTimeMillis();

            SQLiteDatabase var3;
            label21: {
               SQLiteDatabase var4;
               try {
                  var4 = super.getWritableDatabase();
               } catch (SQLiteException var5) {
                  class_522.this.mContext.getDatabasePath(class_522.this.field_2876).delete();
                  var3 = null;
                  break label21;
               }

               var3 = var4;
            }

            if(var3 == null) {
               var3 = super.getWritableDatabase();
            }

            this.field_898 = false;
            return var3;
         }
      }

      public void onCreate(SQLiteDatabase var1) {
         class_548.method_3101(var1.getPath());
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

         if(!this.method_1782("gtm_hits", var1)) {
            var1.execSQL(class_522.field_2875);
         } else {
            this.method_1781(var1);
         }
      }

      public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
      }
   }
}
