package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.os.Build.VERSION;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzmt;
import com.google.android.gms.tagmanager.zzac;
import com.google.android.gms.tagmanager.zzal;
import com.google.android.gms.tagmanager.zzaq;
import com.google.android.gms.tagmanager.zzau;
import com.google.android.gms.tagmanager.zzav;
import com.google.android.gms.tagmanager.zzbg;
import com.google.android.gms.tagmanager.zzcu;
import com.google.android.gms.tagmanager.zzcx;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.List;

class zzby implements zzau {
   private static final String zzQR = String.format("CREATE TABLE IF NOT EXISTS %s ( \'%s\' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \'%s\' INTEGER NOT NULL, \'%s\' TEXT NOT NULL,\'%s\' INTEGER NOT NULL);", new Object[]{"gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time"});
   private final Context mContext;
   private final zzby.zzb zzbjE;
   private volatile zzac zzbjF;
   private final zzav zzbjG;
   private final String zzbjH;
   private long zzbjI;
   private final int zzbjJ;
   private zzmq zzqW;

   zzby(zzav var1, Context var2) {
      this(var1, var2, "gtm_urls.db", 2000);
   }

   zzby(zzav var1, Context var2, String var3, int var4) {
      this.mContext = var2.getApplicationContext();
      this.zzbjH = var3;
      this.zzbjG = var1;
      this.zzqW = zzmt.zzsc();
      this.zzbjE = new zzby.zzb(this.mContext, this.zzbjH);
      this.zzbjF = new zzcx(this.mContext, new zzby.zza());
      this.zzbjI = 0L;
      this.zzbjJ = var4;
   }

   private void zzGQ() {
      int var1 = 1 + (this.zzGR() - this.zzbjJ);
      if(var1 > 0) {
         List var2 = this.zzkl(var1);
         zzbg.method_354("Store full, deleting " + var2.size() + " hits to make room.");
         this.zzf((String[])var2.toArray(new String[0]));
      }

   }

   // $FF: synthetic method
   static void zza(zzby var0, long var1, long var3) {
      var0.zzd(var1, var3);
   }

   private void zzd(long var1, long var3) {
      SQLiteDatabase var5 = this.zzgb("Error opening database for getNumStoredHits.");
      if(var5 != null) {
         ContentValues var6 = new ContentValues();
         var6.put("hit_first_send_time", Long.valueOf(var3));

         try {
            String[] var8 = new String[]{String.valueOf(var1)};
            if(!(var5 instanceof SQLiteDatabase)) {
               var5.update("gtm_hits", var6, "hit_id=?", var8);
            } else {
               SQLiteInstrumentation.update((SQLiteDatabase)var5, "gtm_hits", var6, "hit_id=?", var8);
            }
         } catch (SQLiteException var9) {
            zzbg.zzaK("Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + var1);
            this.zzq(var1);
         }
      }
   }

   private SQLiteDatabase zzgb(String var1) {
      try {
         SQLiteDatabase var3 = this.zzbjE.getWritableDatabase();
         return var3;
      } catch (SQLiteException var4) {
         zzbg.zzaK(var1);
         return null;
      }
   }

   private void zzh(long param1, String param3) {
      // $FF: Couldn't be decompiled
   }

   private void zzq(long var1) {
      String[] var3 = new String[]{String.valueOf(var1)};
      this.zzf(var3);
   }

   public void dispatch() {
      zzbg.method_354("GTM Dispatch running...");
      if(this.zzbjF.zzGw()) {
         List var1 = this.zzkm(40);
         if(var1.isEmpty()) {
            zzbg.method_354("...nothing to dispatch");
            this.zzbjG.zzax(true);
            return;
         }

         this.zzbjF.zzE(var1);
         if(this.zzGS() > 0) {
            zzcu.zzHo().dispatch();
            return;
         }
      }

   }

   int zzGR() {
      // $FF: Couldn't be decompiled
   }

   int zzGS() {
      // $FF: Couldn't be decompiled
   }

   void zzf(String[] param1) {
      // $FF: Couldn't be decompiled
   }

   public void zzg(long var1, String var3) {
      this.zzjN();
      this.zzGQ();
      this.zzh(var1, var3);
   }

   int zzjN() {
      byte var1 = 1;
      long var2 = this.zzqW.currentTimeMillis();
      if(var2 > 86400000L + this.zzbjI) {
         this.zzbjI = var2;
         SQLiteDatabase var4 = this.zzgb("Error opening database for deleteStaleHits.");
         if(var4 != null) {
            long var5 = this.zzqW.currentTimeMillis() - 2592000000L;
            String[] var7 = new String[var1];
            var7[0] = Long.toString(var5);
            int var8;
            if(!(var4 instanceof SQLiteDatabase)) {
               var8 = var4.delete("gtm_hits", "HIT_TIME < ?", var7);
            } else {
               var8 = SQLiteInstrumentation.delete((SQLiteDatabase)var4, "gtm_hits", "HIT_TIME < ?", var7);
            }

            zzav var9 = this.zzbjG;
            if(this.zzGR() != 0) {
               var1 = 0;
            }

            var9.zzax((boolean)var1);
            return var8;
         }
      }

      return 0;
   }

   List<String> zzkl(int param1) {
      // $FF: Couldn't be decompiled
   }

   public List<zzaq> zzkm(int param1) {
      // $FF: Couldn't be decompiled
   }

   class zza implements zzcx.zza {
      public void zza(zzaq var1) {
         zzby.this.zzq(var1.zzGD());
      }

      public void zzb(zzaq var1) {
         zzby.this.zzq(var1.zzGD());
         zzbg.method_354("Permanent failure dispatching hitId: " + var1.zzGD());
      }

      public void zzc(zzaq var1) {
         long var2 = var1.zzGE();
         if(var2 == 0L) {
            zzby.zza(zzby.this, var1.zzGD(), zzby.this.zzqW.currentTimeMillis());
         } else if(var2 + 14400000L < zzby.this.zzqW.currentTimeMillis()) {
            zzby.this.zzq(var1.zzGD());
            zzbg.method_354("Giving up on failed hitId: " + var1.zzGD());
            return;
         }

      }
   }

   class zzb extends SQLiteOpenHelper {
      private boolean zzbjL;
      private long zzbjM = 0L;

      zzb(Context var2, String var3) {
         super(var2, var3, (CursorFactory)null, 1);
      }

      private boolean zza(String param1, SQLiteDatabase param2) {
         // $FF: Couldn't be decompiled
      }

      private void zzc(SQLiteDatabase param1) {
         // $FF: Couldn't be decompiled
      }

      public SQLiteDatabase getWritableDatabase() {
         if(this.zzbjL && 3600000L + this.zzbjM > zzby.this.zzqW.currentTimeMillis()) {
            throw new SQLiteException("Database creation failed");
         } else {
            this.zzbjL = true;
            this.zzbjM = zzby.this.zzqW.currentTimeMillis();

            SQLiteDatabase var3;
            label21: {
               SQLiteDatabase var4;
               try {
                  var4 = super.getWritableDatabase();
               } catch (SQLiteException var5) {
                  zzby.this.mContext.getDatabasePath(zzby.this.zzbjH).delete();
                  var3 = null;
                  break label21;
               }

               var3 = var4;
            }

            if(var3 == null) {
               var3 = super.getWritableDatabase();
            }

            this.zzbjL = false;
            return var3;
         }
      }

      public void onCreate(SQLiteDatabase var1) {
         zzal.zzbo(var1.getPath());
      }

      public void onOpen(SQLiteDatabase var1) {
         if(VERSION.SDK_INT < 15) {
            Cursor var3;
            if(!(var1 instanceof SQLiteDatabase)) {
               var3 = var1.rawQuery("PRAGMA journal_mode=memory", (String[])null);
            } else {
               var3 = SQLiteInstrumentation.rawQuery((SQLiteDatabase)var1, "PRAGMA journal_mode=memory", (String[])null);
            }

            try {
               var3.moveToFirst();
            } finally {
               var3.close();
            }
         }

         if(!this.zza("gtm_hits", var1)) {
            String var2 = zzby.zzQR;
            if(!(var1 instanceof SQLiteDatabase)) {
               var1.execSQL(var2);
            } else {
               SQLiteInstrumentation.execSQL((SQLiteDatabase)var1, var2);
            }
         } else {
            this.zzc(var1);
         }
      }

      public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
      }
   }
}
