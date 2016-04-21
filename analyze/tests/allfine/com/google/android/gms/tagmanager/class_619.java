package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.os.Build.VERSION;
import com.google.android.gms.internal.class_20;
import com.google.android.gms.internal.class_346;
import com.google.android.gms.tagmanager.ap;
import com.google.android.gms.tagmanager.class_612;
import com.google.android.gms.tagmanager.class_615;
import com.google.android.gms.tagmanager.class_632;
import com.google.android.gms.tagmanager.class_642;
import com.google.android.gms.tagmanager.class_660;
import com.google.android.gms.tagmanager.class_72;
import com.google.android.gms.tagmanager.class_73;
import com.google.android.gms.tagmanager.class_84;
import java.util.List;
import org.apache.http.impl.client.DefaultHttpClient;

// $FF: renamed from: com.google.android.gms.tagmanager.cb
class class_619 implements class_72 {
    // $FF: renamed from: AY java.lang.String
    private static final String field_3136 = String.format("CREATE TABLE IF NOT EXISTS %s ( \'%s\' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \'%s\' INTEGER NOT NULL, \'%s\' TEXT NOT NULL,\'%s\' INTEGER NOT NULL);", new Object[] {"gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time"});
    // $FF: renamed from: Bb java.lang.String
    private final String field_3137;
    // $FF: renamed from: Bd long
    private long field_3138;
    // $FF: renamed from: Be int
    private final int field_3139;
    private final class_619.class_1353 apW;
    private volatile class_84 apX;
    private final class_73 apY;
    private final Context mContext;
    // $FF: renamed from: yD com.google.android.gms.internal.ju
    private class_20 field_3140;

    class_619(class_73 var1, Context var2) {
        this(var1, var2, "gtm_urls.db", 2000);
    }

    class_619(class_73 var1, Context var2, String var3, int var4) {
        this.mContext = var2.getApplicationContext();
        this.field_3137 = var3;
        this.apY = var1;
        this.field_3140 = class_346.method_2326();
        this.apW = new class_619.class_1353(this.mContext, this.field_3137);
        this.apX = new class_632(new DefaultHttpClient(), this.mContext, new class_619.class_1352());
        this.field_3138 = 0L;
        this.field_3139 = var4;
    }

    // $FF: renamed from: a (com.google.android.gms.tagmanager.cb, long, long) void
    // $FF: synthetic method
    static void method_3498(class_619 var0, long var1, long var3) {
        var0.method_3502(var1, var3);
    }

    // $FF: renamed from: al (java.lang.String) android.database.sqlite.SQLiteDatabase
    private SQLiteDatabase method_3499(String var1) {
        try {
            SQLiteDatabase var3 = this.apW.getWritableDatabase();
            return var3;
        } catch (SQLiteException var4) {
            class_612.method_3459(var1);
            return null;
        }
    }

    // $FF: renamed from: c (long, long) void
    private void method_3502(long var1, long var3) {
        SQLiteDatabase var5 = this.method_3499("Error opening database for getNumStoredHits.");
        if(var5 != null) {
            ContentValues var6 = new ContentValues();
            var6.put("hit_first_send_time", Long.valueOf(var3));

            try {
                String[] var8 = new String[] {String.valueOf(var1)};
                var5.update("gtm_hits", var6, "hit_id=?", var8);
            } catch (SQLiteException var9) {
                class_612.method_3459("Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + var1);
                this.method_3506(var1);
            }
        }
    }

    // $FF: renamed from: eM () void
    private void method_3503() {
        int var1 = 1 + (this.method_3511() - this.field_3139);
        if(var1 > 0) {
            List var2 = this.method_3507(var1);
            class_612.method_3458("Store full, deleting " + var2.size() + " hits to make room.");
            this.method_3509((String[])var2.toArray(new String[0]));
        }

    }

    // $FF: renamed from: g (long, java.lang.String) void
    private void method_3504(long var1, String var3) {
        SQLiteDatabase var4 = this.method_3499("Error opening database for putHit");
        if(var4 != null) {
            ContentValues var5 = new ContentValues();
            var5.put("hit_time", Long.valueOf(var1));
            var5.put("hit_url", var3);
            var5.put("hit_first_send_time", Integer.valueOf(0));

            try {
                var4.insert("gtm_hits", (String)null, var5);
                this.apY.method_340(false);
            } catch (SQLiteException var7) {
                class_612.method_3459("Error storing hit");
            }
        }
    }

    // $FF: renamed from: y (long) void
    private void method_3506(long var1) {
        String[] var3 = new String[] {String.valueOf(var1)};
        this.method_3509(var3);
    }

    // $FF: renamed from: F (int) java.util.List
    List<String> method_3507(int param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: G (int) java.util.List
    public List<ap> method_3508(int param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b (java.lang.String[]) void
    void method_3509(String[] param1) {
        // $FF: Couldn't be decompiled
    }

    public void dispatch() {
        class_612.method_3458("GTM Dispatch running...");
        if(this.apX.method_367()) {
            List var1 = this.method_3508(40);
            if(var1.isEmpty()) {
                class_612.method_3458("...nothing to dispatch");
                this.apY.method_340(true);
                return;
            }

            this.apX.method_368(var1);
            if(this.method_3512() > 0) {
                class_642.method_3629().dispatch();
                return;
            }
        }

    }

    // $FF: renamed from: eN () int
    int method_3510() {
        byte var1 = 1;
        long var2 = this.field_3140.currentTimeMillis();
        if(var2 > 86400000L + this.field_3138) {
            this.field_3138 = var2;
            SQLiteDatabase var4 = this.method_3499("Error opening database for deleteStaleHits.");
            if(var4 != null) {
                long var5 = this.field_3140.currentTimeMillis() - 2592000000L;
                String[] var7 = new String[var1];
                var7[0] = Long.toString(var5);
                int var8 = var4.delete("gtm_hits", "HIT_TIME < ?", var7);
                class_73 var9 = this.apY;
                if(this.method_3511() != 0) {
                    var1 = 0;
                }

                var9.method_340((boolean)var1);
                return var8;
            }
        }

        return 0;
    }

    // $FF: renamed from: eO () int
    int method_3511() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: f (long, java.lang.String) void
    public void method_339(long var1, String var3) {
        this.method_3510();
        this.method_3503();
        this.method_3504(var1, var3);
    }

    // $FF: renamed from: oH () int
    int method_3512() {
        // $FF: Couldn't be decompiled
    }

    class class_1352 implements class_632.class_1804 {
        // $FF: renamed from: a (com.google.android.gms.tagmanager.ap) void
        public void method_892(class_615 var1) {
            class_619.this.method_3506(var1.method_3473());
        }

        // $FF: renamed from: b (com.google.android.gms.tagmanager.ap) void
        public void method_893(class_615 var1) {
            class_619.this.method_3506(var1.method_3473());
            class_612.method_3458("Permanent failure dispatching hitId: " + var1.method_3473());
        }

        // $FF: renamed from: c (com.google.android.gms.tagmanager.ap) void
        public void method_894(class_615 var1) {
            long var2 = var1.method_3474();
            if(var2 == 0L) {
                class_619.method_3498(class_619.this, var1.method_3473(), class_619.this.field_3140.currentTimeMillis());
            } else if(var2 + 14400000L < class_619.this.field_3140.currentTimeMillis()) {
                class_619.this.method_3506(var1.method_3473());
                class_612.method_3458("Giving up on failed hitId: " + var1.method_3473());
                return;
            }

        }
    }

    class class_1353 extends SQLiteOpenHelper {
        // $FF: renamed from: Bf boolean
        private boolean field_2868;
        // $FF: renamed from: Bg long
        private long field_2869 = 0L;

        class_1353(Context var2, String var3) {
            super(var2, var3, (CursorFactory)null, 1);
        }

        // $FF: renamed from: a (android.database.sqlite.SQLiteDatabase) void
        private void method_3267(SQLiteDatabase param1) {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (java.lang.String, android.database.sqlite.SQLiteDatabase) boolean
        private boolean method_3268(String param1, SQLiteDatabase param2) {
            // $FF: Couldn't be decompiled
        }

        public SQLiteDatabase getWritableDatabase() {
            if(this.field_2868 && 3600000L + this.field_2869 > class_619.this.field_3140.currentTimeMillis()) {
                throw new SQLiteException("Database creation failed");
            } else {
                this.field_2868 = true;
                this.field_2869 = class_619.this.field_3140.currentTimeMillis();

                SQLiteDatabase var3;
                label21: {
                    SQLiteDatabase var4;
                    try {
                        var4 = super.getWritableDatabase();
                    } catch (SQLiteException var5) {
                        class_619.this.mContext.getDatabasePath(class_619.this.field_3137).delete();
                        var3 = null;
                        break label21;
                    }

                    var3 = var4;
                }

                if(var3 == null) {
                    var3 = super.getWritableDatabase();
                }

                this.field_2868 = false;
                return var3;
            }
        }

        public void onCreate(SQLiteDatabase var1) {
            class_660.method_3682(var1.getPath());
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

            if(!this.method_3268("gtm_hits", var1)) {
                var1.execSQL(class_619.field_3136);
            } else {
                this.method_3267(var1);
            }
        }

        public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
        }
    }
}
