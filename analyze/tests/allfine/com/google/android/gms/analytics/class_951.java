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
import com.google.android.gms.analytics.class_173;
import com.google.android.gms.analytics.class_175;
import com.google.android.gms.analytics.class_177;
import com.google.android.gms.analytics.class_933;
import com.google.android.gms.analytics.class_936;
import com.google.android.gms.analytics.class_937;
import com.google.android.gms.analytics.class_938;
import com.google.android.gms.analytics.class_952;
import com.google.android.gms.analytics.class_956;
import com.google.android.gms.analytics.w;
import com.google.android.gms.internal.class_20;
import com.google.android.gms.internal.class_346;
import com.google.android.gms.internal.class_409;
import com.google.android.gms.internal.hb;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.impl.client.DefaultHttpClient;

// $FF: renamed from: com.google.android.gms.analytics.ab
class class_951 implements class_175 {
    // $FF: renamed from: AY java.lang.String
    private static final String field_4456 = String.format("CREATE TABLE IF NOT EXISTS %s ( \'%s\' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \'%s\' INTEGER NOT NULL, \'%s\' TEXT NOT NULL, \'%s\' TEXT NOT NULL, \'%s\' INTEGER);", new Object[] {"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});
    // $FF: renamed from: AZ com.google.android.gms.analytics.ab$a
    private final class_951.class_1568 field_4457;
    // $FF: renamed from: Ba com.google.android.gms.analytics.m
    private volatile class_177 field_4458;
    // $FF: renamed from: Bb java.lang.String
    private final String field_4459;
    // $FF: renamed from: Bc com.google.android.gms.analytics.aa
    private class_952 field_4460;
    // $FF: renamed from: Bd long
    private long field_4461;
    // $FF: renamed from: Be int
    private final int field_4462;
    private final Context mContext;
    // $FF: renamed from: yD com.google.android.gms.internal.ju
    private class_20 field_4463;
    // $FF: renamed from: yl com.google.android.gms.analytics.e
    private final class_173 field_4464;

    class_951(class_173 var1, Context var2) {
        this(var1, var2, "google_analytics_v4.db", 2000);
    }

    class_951(class_173 var1, Context var2, String var3, int var4) {
        this.mContext = var2.getApplicationContext();
        this.field_4459 = var3;
        this.field_4464 = var1;
        this.field_4463 = class_346.method_2326();
        this.field_4457 = new class_951.class_1568(this.mContext, this.field_4459);
        this.field_4458 = new class_956(new DefaultHttpClient(), this.mContext);
        this.field_4461 = 0L;
        this.field_4462 = var4;
    }

    // $FF: renamed from: A (java.util.Map) java.lang.String
    static String method_5002(Map<String, String> var0) {
        ArrayList var1 = new ArrayList(var0.size());
        Iterator var2 = var0.entrySet().iterator();

        while(var2.hasNext()) {
            Entry var3 = (Entry)var2.next();
            var1.add(class_936.encode((String)var3.getKey()) + "=" + class_936.encode((String)var3.getValue()));
        }

        return TextUtils.join("&", var1);
    }

    // $FF: renamed from: a (java.util.Map, long, java.lang.String) void
    private void method_5004(Map<String, String> var1, long var2, String var4) {
        SQLiteDatabase var5 = this.method_5006("Error opening database for putHit");
        if(var5 != null) {
            ContentValues var6 = new ContentValues();
            var6.put("hit_string", method_5002(var1));
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
                class_938.method_4861("Empty path: not sending hit");
            } else {
                var6.put("hit_url", var4);

                try {
                    var5.insert("hits2", (String)null, var6);
                    this.field_4464.method_818(false);
                } catch (SQLiteException var15) {
                    class_938.method_4861("Error storing hit");
                }
            }
        }
    }

    // $FF: renamed from: a (java.util.Map, java.util.Collection) void
    private void method_5005(Map<String, String> var1, Collection<hb> var2) {
        String var3 = "&_v".substring(1);
        if(var2 != null) {
            Iterator var4 = var2.iterator();

            while(var4.hasNext()) {
                class_409 var5 = (class_409)var4.next();
                if("appendVersion".equals(var5.getId())) {
                    var1.put(var3, var5.getValue());
                    break;
                }
            }
        }

    }

    // $FF: renamed from: al (java.lang.String) android.database.sqlite.SQLiteDatabase
    private SQLiteDatabase method_5006(String var1) {
        try {
            SQLiteDatabase var3 = this.field_4457.getWritableDatabase();
            return var3;
        } catch (SQLiteException var4) {
            class_938.method_4861(var1);
            return null;
        }
    }

    // $FF: renamed from: eM () void
    private void method_5009() {
        int var1 = 1 + (this.method_5016() - this.field_4462);
        if(var1 > 0) {
            List var2 = this.method_5011(var1);
            class_938.method_4860("Store full, deleting " + var2.size() + " hits to make room.");
            this.method_5014((String[])var2.toArray(new String[0]));
        }

    }

    // $FF: renamed from: F (int) java.util.List
    List<String> method_5011(int param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: G (int) java.util.List
    public List<w> method_5012(int param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (java.util.Map, long, java.lang.String, java.util.Collection) void
    public void method_823(Map<String, String> var1, long var2, String var4, Collection<hb> var5) {
        this.method_5015();
        this.method_5009();
        this.method_5005(var1, var5);
        this.method_5004(var1, var2, var4);
    }

    // $FF: renamed from: b (java.util.Collection) void
    @Deprecated
    void method_5013(Collection<w> var1) {
        if(var1 != null && !var1.isEmpty()) {
            String[] var2 = new String[var1.size()];
            Iterator var3 = var1.iterator();

            int var6;
            for(int var4 = 0; var3.hasNext(); var4 = var6) {
                class_937 var5 = (class_937)var3.next();
                var6 = var4 + 1;
                var2[var4] = String.valueOf(var5.method_4855());
            }

            this.method_5014(var2);
        } else {
            class_938.method_4861("Empty/Null collection passed to deleteHits.");
        }
    }

    // $FF: renamed from: b (java.lang.String[]) void
    void method_5014(String[] param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: dM () com.google.android.gms.analytics.m
    public class_177 method_824() {
        return this.field_4458;
    }

    public void dispatch() {
        boolean var1 = true;
        class_938.method_4860("Dispatch running...");
        if(this.field_4458.method_828()) {
            List var2 = this.method_5012(40);
            if(var2.isEmpty()) {
                class_938.method_4860("...nothing to dispatch");
                this.field_4464.method_818(var1);
            } else {
                if(this.field_4460 == null) {
                    this.field_4460 = new class_952("_t=dispatch&_v=ma4.0.3", var1);
                }

                if(this.method_5016() > var2.size()) {
                    var1 = false;
                }

                int var3 = this.field_4458.method_826(var2, this.field_4460, var1);
                class_938.method_4860("sent " + var3 + " of " + var2.size() + " hits");
                this.method_5013(var2.subList(0, Math.min(var3, var2.size())));
                if(var3 == var2.size() && this.method_5016() > 0) {
                    GoogleAnalytics.getInstance(this.mContext).dispatchLocalHits();
                } else {
                    this.field_4460 = null;
                }
            }
        }
    }

    // $FF: renamed from: eN () int
    int method_5015() {
        byte var1 = 1;
        long var2 = this.field_4463.currentTimeMillis();
        if(var2 > 86400000L + this.field_4461) {
            this.field_4461 = var2;
            SQLiteDatabase var4 = this.method_5006("Error opening database for deleteStaleHits.");
            if(var4 != null) {
                long var5 = this.field_4463.currentTimeMillis() - 2592000000L;
                String[] var7 = new String[var1];
                var7[0] = Long.toString(var5);
                int var8 = var4.delete("hits2", "HIT_TIME < ?", var7);
                class_173 var9 = this.field_4464;
                if(this.method_5016() != 0) {
                    var1 = 0;
                }

                var9.method_818((boolean)var1);
                return var8;
            }
        }

        return 0;
    }

    // $FF: renamed from: eO () int
    int method_5016() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: l (long) void
    public void method_825(long var1) {
        byte var3 = 1;
        SQLiteDatabase var4 = this.method_5006("Error opening database for clearHits");
        if(var4 != null) {
            if(var1 == 0L) {
                var4.delete("hits2", (String)null, (String[])null);
            } else {
                String[] var5 = new String[var3];
                var5[0] = Long.valueOf(var1).toString();
                var4.delete("hits2", "hit_app_id = ?", var5);
            }

            class_173 var7 = this.field_4464;
            if(this.method_5016() != 0) {
                var3 = 0;
            }

            var7.method_818((boolean)var3);
        }

    }

    class class_1568 extends SQLiteOpenHelper {
        // $FF: renamed from: Bf boolean
        private boolean field_3454;
        // $FF: renamed from: Bg long
        private long field_3455 = 0L;

        class_1568(Context var2, String var3) {
            super(var2, var3, (CursorFactory)null, 1);
        }

        // $FF: renamed from: a (android.database.sqlite.SQLiteDatabase) void
        private void method_3904(SQLiteDatabase param1) {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (java.lang.String, android.database.sqlite.SQLiteDatabase) boolean
        private boolean method_3905(String param1, SQLiteDatabase param2) {
            // $FF: Couldn't be decompiled
        }

        public SQLiteDatabase getWritableDatabase() {
            if(this.field_3454 && 3600000L + this.field_3455 > class_951.this.field_4463.currentTimeMillis()) {
                throw new SQLiteException("Database creation failed");
            } else {
                this.field_3454 = true;
                this.field_3455 = class_951.this.field_4463.currentTimeMillis();

                SQLiteDatabase var3;
                label21: {
                    SQLiteDatabase var4;
                    try {
                        var4 = super.getWritableDatabase();
                    } catch (SQLiteException var5) {
                        class_951.this.mContext.getDatabasePath(class_951.this.field_4459).delete();
                        var3 = null;
                        break label21;
                    }

                    var3 = var4;
                }

                if(var3 == null) {
                    var3 = super.getWritableDatabase();
                }

                this.field_3454 = false;
                return var3;
            }
        }

        public void onCreate(SQLiteDatabase var1) {
            class_933.method_4840(var1.getPath());
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

            if(!this.method_3905("hits2", var1)) {
                var1.execSQL(class_951.field_4456);
            } else {
                this.method_3904(var1);
            }
        }

        public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
        }
    }
}
