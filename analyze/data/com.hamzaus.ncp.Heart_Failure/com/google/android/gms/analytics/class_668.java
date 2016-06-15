package com.google.android.gms.analytics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.class_133;
import com.google.android.gms.analytics.class_135;
import com.google.android.gms.analytics.class_136;
import com.google.android.gms.analytics.class_139;
import com.google.android.gms.analytics.class_652;
import com.google.android.gms.analytics.class_654;
import com.google.android.gms.analytics.class_657;
import com.google.android.gms.analytics.class_667;
import com.google.android.gms.analytics.class_669;
import com.google.android.gms.analytics.class_672;
import com.google.android.gms.analytics.x;
import com.google.android.gms.internal.class_395;
import com.google.android.gms.internal.fe;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.impl.client.DefaultHttpClient;

// $FF: renamed from: com.google.android.gms.analytics.ac
class class_668 implements class_135 {
   // $FF: renamed from: wM java.lang.String
   private static final String field_3574 = String.format("CREATE TABLE IF NOT EXISTS %s ( \'%s\' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \'%s\' INTEGER NOT NULL, \'%s\' TEXT NOT NULL, \'%s\' TEXT NOT NULL, \'%s\' INTEGER);", new Object[]{"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});
   private final Context mContext;
   // $FF: renamed from: tZ com.google.android.gms.analytics.e
   private final class_133 field_3575;
   // $FF: renamed from: ur com.google.android.gms.analytics.i
   private class_136 field_3576;
   // $FF: renamed from: wN com.google.android.gms.analytics.ac$a
   private final class_668.class_1321 field_3577;
   // $FF: renamed from: wO com.google.android.gms.analytics.n
   private volatile class_139 field_3578;
   // $FF: renamed from: wP java.lang.String
   private final String field_3579;
   // $FF: renamed from: wQ com.google.android.gms.analytics.ab
   private class_667 field_3580;
   // $FF: renamed from: wR long
   private long field_3581;
   // $FF: renamed from: wS int
   private final int field_3582;

   class_668(class_133 var1, Context var2) {
      this(var1, var2, "google_analytics_v4.db", 2000);
   }

   class_668(class_133 var1, Context var2, String var3, int var4) {
      this.mContext = var2.getApplicationContext();
      this.field_3579 = var3;
      this.field_3575 = var1;
      this.field_3576 = new class_136() {
         public long currentTimeMillis() {
            return System.currentTimeMillis();
         }
      };
      this.field_3577 = new class_668.class_1321(this.mContext, this.field_3579);
      this.field_3578 = new class_672(new DefaultHttpClient(), this.mContext);
      this.field_3581 = 0L;
      this.field_3582 = var4;
   }

   // $FF: renamed from: S (java.lang.String) android.database.sqlite.SQLiteDatabase
   private SQLiteDatabase method_3873(String var1) {
      try {
         SQLiteDatabase var3 = this.field_3577.getWritableDatabase();
         return var3;
      } catch (SQLiteException var4) {
         class_669.method_3891(var1);
         return null;
      }
   }

   // $FF: renamed from: a (java.util.Map, long, java.lang.String) void
   private void method_3875(Map<String, String> var1, long var2, String var4) {
      SQLiteDatabase var5 = this.method_3873("Error opening database for putHit");
      if(var5 != null) {
         ContentValues var6 = new ContentValues();
         var6.put("hit_string", method_3881(var1));
         var6.put("hit_time", Long.valueOf(var2));
         long var7;
         if(var1.containsKey("AppUID")) {
            label31: {
               long var13;
               try {
                  var13 = Long.parseLong((String)var1.get("AppUID"));
               } catch (NumberFormatException var16) {
                  var7 = 0L;
                  break label31;
               }

               var7 = var13;
            }
         } else {
            var7 = 0L;
         }

         var6.put("hit_app_id", Long.valueOf(var7));
         if(var4 == null) {
            var4 = "http://www.google-analytics.com/collect";
         }

         if(var4.length() == 0) {
            class_669.method_3891("Empty path: not sending hit");
         } else {
            var6.put("hit_url", var4);

            try {
               var5.insert("hits2", (String)null, var6);
               this.field_3575.method_698(false);
            } catch (SQLiteException var15) {
               class_669.method_3891("Error storing hit");
            }
         }
      }
   }

   // $FF: renamed from: a (java.util.Map, java.util.Collection) void
   private void method_3876(Map<String, String> var1, Collection<fe> var2) {
      String var3 = "&_v".substring(1);
      if(var2 != null) {
         Iterator var4 = var2.iterator();

         while(var4.hasNext()) {
            class_395 var5 = (class_395)var4.next();
            if("appendVersion".equals(var5.getId())) {
               var1.put(var3, var5.getValue());
               break;
            }
         }
      }

   }

   // $FF: renamed from: dm () void
   private void method_3879() {
      int var1 = 1 + (this.method_3887() - this.field_3582);
      if(var1 > 0) {
         List var2 = this.method_3882(var1);
         class_669.method_3890("Store full, deleting " + var2.size() + " hits to make room.");
         this.method_3884((String[])var2.toArray(new String[0]));
      }

   }

   // $FF: renamed from: v (java.util.Map) java.lang.String
   static String method_3881(Map<String, String> var0) {
      ArrayList var1 = new ArrayList(var0.size());
      Iterator var2 = var0.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.add(class_657.encode((String)var3.getKey()) + "=" + class_657.encode((String)var3.getValue()));
      }

      return TextUtils.join("&", var1);
   }

   // $FF: renamed from: A (int) java.util.List
   List<String> method_3882(int param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: B (int) java.util.List
   public List<x> method_3883(int param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (java.util.Map, long, java.lang.String, java.util.Collection) void
   public void method_704(Map<String, String> var1, long var2, String var4, Collection<fe> var5) {
      this.method_3886();
      this.method_3879();
      this.method_3876(var1, var5);
      this.method_3875(var1, var2, var4);
   }

   // $FF: renamed from: a (java.lang.String[]) void
   void method_3884(String[] param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (java.util.Collection) void
   @Deprecated
   void method_3885(Collection<x> var1) {
      if(var1 != null && !var1.isEmpty()) {
         String[] var2 = new String[var1.size()];
         Iterator var3 = var1.iterator();

         int var6;
         for(int var4 = 0; var3.hasNext(); var4 = var6) {
            class_654 var5 = (class_654)var3.next();
            var6 = var4 + 1;
            var2[var4] = String.valueOf(var5.method_3741());
         }

         this.method_3884(var2);
      } else {
         class_669.method_3891("Empty/Null collection passed to deleteHits.");
      }
   }

   // $FF: renamed from: cl () void
   public void method_705() {
      boolean var1 = true;
      class_669.method_3890("Dispatch running...");
      if(this.field_3578.method_710()) {
         List var2 = this.method_3883(40);
         if(var2.isEmpty()) {
            class_669.method_3890("...nothing to dispatch");
            this.field_3575.method_698(var1);
         } else {
            if(this.field_3580 == null) {
               this.field_3580 = new class_667("_t=dispatch&_v=ma4.0.2", var1);
            }

            if(this.method_3887() > var2.size()) {
               var1 = false;
            }

            int var3 = this.field_3578.method_709(var2, this.field_3580, var1);
            class_669.method_3890("sent " + var3 + " of " + var2.size() + " hits");
            this.method_3885(var2.subList(0, Math.min(var3, var2.size())));
            if(var3 == var2.size() && this.method_3887() > 0) {
               GoogleAnalytics.getInstance(this.mContext).dispatchLocalHits();
            } else {
               this.field_3580 = null;
            }
         }
      }
   }

   // $FF: renamed from: cm () com.google.android.gms.analytics.n
   public class_139 method_706() {
      return this.field_3578;
   }

   // $FF: renamed from: dn () int
   int method_3886() {
      byte var1 = 1;
      long var2 = this.field_3576.currentTimeMillis();
      if(var2 > 86400000L + this.field_3581) {
         this.field_3581 = var2;
         SQLiteDatabase var4 = this.method_3873("Error opening database for deleteStaleHits.");
         if(var4 != null) {
            long var5 = this.field_3576.currentTimeMillis() - 2592000000L;
            String[] var7 = new String[var1];
            var7[0] = Long.toString(var5);
            int var8 = var4.delete("hits2", "HIT_TIME < ?", var7);
            class_133 var9 = this.field_3575;
            if(this.method_3887() != 0) {
               var1 = 0;
            }

            var9.method_698((boolean)var1);
            return var8;
         }
      }

      return 0;
   }

   // $FF: renamed from: do () int
   int method_3887() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: l (long) void
   public void method_707(long var1) {
      byte var3 = 1;
      SQLiteDatabase var4 = this.method_3873("Error opening database for clearHits");
      if(var4 != null) {
         if(var1 == 0L) {
            var4.delete("hits2", (String)null, (String[])null);
         } else {
            String[] var5 = new String[var3];
            var5[0] = Long.valueOf(var1).toString();
            var4.delete("hits2", "hit_app_id = ?", var5);
         }

         class_133 var7 = this.field_3575;
         if(this.method_3887() != 0) {
            var3 = 0;
         }

         var7.method_698((boolean)var3);
      }

   }

   class class_1321 extends SQLiteOpenHelper {
      // $FF: renamed from: wU boolean
      private boolean field_3953;
      // $FF: renamed from: wV long
      private long field_3954 = 0L;

      class_1321(Context var2, String var3) {
         super(var2, var3, (CursorFactory)null, 1);
      }

      // $FF: renamed from: a (android.database.sqlite.SQLiteDatabase) void
      private void method_4233(SQLiteDatabase param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.String, android.database.sqlite.SQLiteDatabase) boolean
      private boolean method_4234(String param1, SQLiteDatabase param2) {
         // $FF: Couldn't be decompiled
      }

      public SQLiteDatabase getWritableDatabase() {
         if(this.field_3953 && 3600000L + this.field_3954 > class_668.this.field_3576.currentTimeMillis()) {
            throw new SQLiteException("Database creation failed");
         } else {
            this.field_3953 = true;
            this.field_3954 = class_668.this.field_3576.currentTimeMillis();

            SQLiteDatabase var3;
            label21: {
               SQLiteDatabase var4;
               try {
                  var4 = super.getWritableDatabase();
               } catch (SQLiteException var5) {
                  class_668.this.mContext.getDatabasePath(class_668.this.field_3579).delete();
                  var3 = null;
                  break label21;
               }

               var3 = var4;
            }

            if(var3 == null) {
               var3 = super.getWritableDatabase();
            }

            this.field_3953 = false;
            return var3;
         }
      }

      public void onCreate(SQLiteDatabase var1) {
         class_652.method_3730(var1.getPath());
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

         if(!this.method_4234("hits2", var1)) {
            var1.execSQL(class_668.field_3574);
         } else {
            this.method_4233(var1);
         }
      }

      public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
      }
   }
}
