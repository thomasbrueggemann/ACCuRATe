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
import com.google.android.gms.analytics.ab;
import com.google.android.gms.analytics.class_168;
import com.google.android.gms.analytics.class_170;
import com.google.android.gms.analytics.class_173;
import com.google.android.gms.analytics.class_174;
import com.google.android.gms.analytics.class_839;
import com.google.android.gms.analytics.class_850;
import com.google.android.gms.analytics.class_863;
import com.google.android.gms.analytics.class_864;
import com.google.android.gms.analytics.class_865;
import com.google.android.gms.analytics.class_869;
import com.google.android.gms.internal.class_141;
import com.google.android.gms.internal.class_400;
import com.google.android.gms.internal.class_720;
import com.google.android.gms.internal.ha;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.impl.client.DefaultHttpClient;

// $FF: renamed from: com.google.android.gms.analytics.ag
class class_871 implements class_170 {
   // $FF: renamed from: BS java.lang.String
   private static final String field_3723 = String.format("CREATE TABLE IF NOT EXISTS %s ( \'%s\' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \'%s\' INTEGER NOT NULL, \'%s\' TEXT NOT NULL, \'%s\' TEXT NOT NULL, \'%s\' INTEGER);", new Object[]{"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});
   // $FF: renamed from: BT com.google.android.gms.analytics.ag$a
   private final class_871.class_1338 field_3724;
   // $FF: renamed from: BU com.google.android.gms.analytics.r
   private volatile class_173 field_3725;
   // $FF: renamed from: BV java.lang.String
   private final String field_3726;
   // $FF: renamed from: BW com.google.android.gms.analytics.af
   private class_869 field_3727;
   // $FF: renamed from: BX long
   private long field_3728;
   // $FF: renamed from: BY int
   private final int field_3729;
   private final Context mContext;
   // $FF: renamed from: wb com.google.android.gms.internal.ld
   private class_141 field_3730;
   // $FF: renamed from: ys com.google.android.gms.analytics.o
   private class_174 field_3731;
   // $FF: renamed from: yt boolean
   private volatile boolean field_3732;
   // $FF: renamed from: zc com.google.android.gms.analytics.e
   private final class_168 field_3733;

   class_871(class_168 var1, Context var2, class_174 var3) {
      this(var1, var2, "google_analytics_v4.db", 2000, var3);
   }

   class_871(class_168 var1, Context var2, String var3, int var4, class_174 var5) {
      this.field_3732 = true;
      this.mContext = var2.getApplicationContext();
      this.field_3731 = var5;
      this.field_3726 = var3;
      this.field_3733 = var1;
      this.field_3730 = class_720.method_4198();
      this.field_3724 = new class_871.class_1338(this.mContext, this.field_3726);
      this.field_3725 = new class_839(new DefaultHttpClient(), this.mContext, this.field_3731);
      this.field_3728 = 0L;
      this.field_3729 = var4;
   }

   // $FF: renamed from: A (java.util.Map) java.lang.String
   static String method_4884(Map<String, String> var0) {
      ArrayList var1 = new ArrayList(var0.size());
      Iterator var2 = var0.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.add(class_865.encode((String)var3.getKey()) + "=" + class_865.encode((String)var3.getValue()));
      }

      return TextUtils.join("&", var1);
   }

   // $FF: renamed from: a (java.util.Map, long, java.lang.String) void
   private void method_4886(Map<String, String> var1, long var2, String var4) {
      SQLiteDatabase var5 = this.method_4888("Error opening database for putHit");
      if(var5 != null) {
         ContentValues var6 = new ContentValues();
         var6.put("hit_string", method_4884(var1));
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
            class_863.method_4842("Empty path: not sending hit");
         } else {
            var6.put("hit_url", var4);

            try {
               var5.insert("hits2", (String)null, var6);
               this.field_3733.method_844(false);
            } catch (SQLiteException var15) {
               class_863.method_4842("Error storing hit");
            }
         }
      }
   }

   // $FF: renamed from: a (java.util.Map, java.util.Collection) void
   private void method_4887(Map<String, String> var1, Collection<ha> var2) {
      String var3 = "&_v".substring(1);
      if(var2 != null) {
         Iterator var4 = var2.iterator();

         while(var4.hasNext()) {
            class_400 var5 = (class_400)var4.next();
            if("appendVersion".equals(var5.getId())) {
               var1.put(var3, var5.getValue());
               break;
            }
         }
      }

   }

   // $FF: renamed from: al (java.lang.String) android.database.sqlite.SQLiteDatabase
   private SQLiteDatabase method_4888(String var1) {
      try {
         SQLiteDatabase var3 = this.field_3724.getWritableDatabase();
         return var3;
      } catch (SQLiteException var4) {
         class_863.method_4842(var1);
         return null;
      }
   }

   // $FF: renamed from: fh () void
   private void method_4891() {
      int var1 = 1 + (this.method_4898() - this.field_3729);
      if(var1 > 0) {
         List var2 = this.method_4893(var1);
         class_863.method_4841("Store full, deleting " + var2.size() + " hits to make room.");
         this.method_4896((String[])var2.toArray(new String[0]));
      }

   }

   // $FF: renamed from: G (int) java.util.List
   List<String> method_4893(int param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: H (int) java.util.List
   public List<ab> method_4894(int param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (java.util.Map, long, java.lang.String, java.util.Collection) void
   public void method_850(Map<String, String> var1, long var2, String var4, Collection<ha> var5) {
      this.method_4897();
      this.method_4891();
      this.method_4887(var1, var5);
      this.method_4886(var1, var2, var4);
   }

   // $FF: renamed from: b (java.util.Collection) void
   @Deprecated
   void method_4895(Collection<ab> var1) {
      if(var1 != null && !var1.isEmpty()) {
         String[] var2 = new String[var1.size()];
         Iterator var3 = var1.iterator();

         int var6;
         for(int var4 = 0; var3.hasNext(); var4 = var6) {
            class_864 var5 = (class_864)var3.next();
            var6 = var4 + 1;
            var2[var4] = String.valueOf(var5.method_4847());
         }

         this.method_4896(var2);
      } else {
         class_863.method_4842("Empty/Null collection passed to deleteHits.");
      }
   }

   // $FF: renamed from: b (java.lang.String[]) void
   void method_4896(String[] param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: dV () com.google.android.gms.analytics.r
   public class_173 method_851() {
      return this.field_3725;
   }

   public void dispatch() {
      boolean var1 = true;
      class_863.method_4841("Dispatch running...");
      if(this.field_3725.method_855()) {
         List var2 = this.method_4894(20);
         if(var2.isEmpty()) {
            class_863.method_4841("...nothing to dispatch");
            this.field_3733.method_844(var1);
         } else {
            if(this.field_3727 == null) {
               this.field_3727 = new class_869("_t=dispatch&_v=ma4.0.4", false);
            }

            if(this.method_4898() > var2.size()) {
               var1 = false;
            }

            int var3 = this.field_3725.method_853(var2, this.field_3727, var1);
            class_863.method_4841("sent " + var3 + " of " + var2.size() + " hits");
            this.method_4895(var2.subList(0, Math.min(var3, var2.size())));
            if(var3 == var2.size() && this.method_4898() > 0) {
               GoogleAnalytics.getInstance(this.mContext).dispatchLocalHits();
            } else {
               this.field_3727 = null;
            }
         }
      }
   }

   // $FF: renamed from: fi () int
   int method_4897() {
      byte var1 = 1;
      long var2 = this.field_3730.currentTimeMillis();
      if(var2 > 86400000L + this.field_3728) {
         this.field_3728 = var2;
         SQLiteDatabase var4 = this.method_4888("Error opening database for deleteStaleHits.");
         if(var4 != null) {
            long var5 = this.field_3730.currentTimeMillis() - 2592000000L;
            String[] var7 = new String[var1];
            var7[0] = Long.toString(var5);
            int var8 = var4.delete("hits2", "HIT_TIME < ?", var7);
            class_168 var9 = this.field_3733;
            if(this.method_4898() != 0) {
               var1 = 0;
            }

            var9.method_844((boolean)var1);
            return var8;
         }
      }

      return 0;
   }

   // $FF: renamed from: fj () int
   int method_4898() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: l (long) void
   public void method_852(long var1) {
      byte var3 = 1;
      SQLiteDatabase var4 = this.method_4888("Error opening database for clearHits");
      if(var4 != null) {
         if(var1 == 0L) {
            var4.delete("hits2", (String)null, (String[])null);
         } else {
            String[] var5 = new String[var3];
            var5[0] = Long.valueOf(var1).toString();
            var4.delete("hits2", "hit_app_id = ?", var5);
         }

         class_168 var7 = this.field_3733;
         if(this.method_4898() != 0) {
            var3 = 0;
         }

         var7.method_844((boolean)var3);
      }

   }

   public void setDryRun(boolean var1) {
      this.field_3732 = var1;
      if(this.field_3725 != null) {
         this.field_3725.setDryRun(var1);
      }

   }

   class class_1338 extends SQLiteOpenHelper {
      // $FF: renamed from: BZ boolean
      private boolean field_2874;
      // $FF: renamed from: Ca long
      private long field_2875 = 0L;

      class_1338(Context var2, String var3) {
         super(var2, var3, (CursorFactory)null, 1);
      }

      // $FF: renamed from: a (android.database.sqlite.SQLiteDatabase) void
      private void method_3784(SQLiteDatabase param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.String, android.database.sqlite.SQLiteDatabase) boolean
      private boolean method_3785(String param1, SQLiteDatabase param2) {
         // $FF: Couldn't be decompiled
      }

      public SQLiteDatabase getWritableDatabase() {
         if(this.field_2874 && 3600000L + this.field_2875 > class_871.this.field_3730.currentTimeMillis()) {
            throw new SQLiteException("Database creation failed");
         } else {
            this.field_2874 = true;
            this.field_2875 = class_871.this.field_3730.currentTimeMillis();

            SQLiteDatabase var3;
            label21: {
               SQLiteDatabase var4;
               try {
                  var4 = super.getWritableDatabase();
               } catch (SQLiteException var5) {
                  class_871.this.mContext.getDatabasePath(class_871.this.field_3726).delete();
                  var3 = null;
                  break label21;
               }

               var3 = var4;
            }

            if(var3 == null) {
               var3 = super.getWritableDatabase();
            }

            this.field_2874 = false;
            return var3;
         }
      }

      public void onCreate(SQLiteDatabase var1) {
         class_850.method_4710(var1.getPath());
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

         if(!this.method_3785("hits2", var1)) {
            var1.execSQL(class_871.field_3723);
         } else {
            this.method_3784(var1);
         }
      }

      public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
      }
   }
}
