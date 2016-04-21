package com.google.android.gms.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_424;
import com.google.android.gms.internal.ea;
import com.google.android.gms.internal.ez;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.ec
@ez
public class class_426 {
    // $FF: renamed from: mw java.lang.Object
    private static final Object field_1566 = new Object();
    // $FF: renamed from: sG java.lang.String
    private static final String field_1567 = String.format("CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", new Object[] {"InAppPurchase", "purchase_id", "product_id", "developer_payload", "record_time"});
    // $FF: renamed from: sI com.google.android.gms.internal.ec
    private static class_426 field_1568;
    // $FF: renamed from: sH com.google.android.gms.internal.ec$a
    private final class_426.class_1616 field_1569;

    private class_426(Context var1) {
        this.field_1569 = new class_426.class_1616(var1, "google_inapp_purchase.db");
    }

    // $FF: renamed from: j (android.content.Context) com.google.android.gms.internal.ec
    public static class_426 method_2685(Context param0) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (android.database.Cursor) com.google.android.gms.internal.ea
    public class_424 method_2686(Cursor var1) {
        return var1 == null?null:new class_424(var1.getLong(0), var1.getString(1), var1.getString(2));
    }

    // $FF: renamed from: a (com.google.android.gms.internal.ea) void
    public void method_2687(class_424 param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b (com.google.android.gms.internal.ea) void
    public void method_2688(class_424 param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: cr () void
    public void method_2689() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: d (long) java.util.List
    public List<ea> method_2690(long param1) {
        // $FF: Couldn't be decompiled
    }

    public int getRecordCount() {
        // $FF: Couldn't be decompiled
    }

    public SQLiteDatabase getWritableDatabase() {
        try {
            SQLiteDatabase var2 = this.field_1569.getWritableDatabase();
            return var2;
        } catch (SQLiteException var3) {
            class_378.method_2461("Error opening writable conversion tracking database");
            return null;
        }
    }

    public class class_1616 extends SQLiteOpenHelper {
        public class_1616(Context var2, String var3) {
            super(var2, var3, (CursorFactory)null, 4);
        }

        public void onCreate(SQLiteDatabase var1) {
            var1.execSQL(class_426.field_1567);
        }

        public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
            class_378.method_2459("Database updated from version " + var2 + " to version " + var3);
            var1.execSQL("DROP TABLE IF EXISTS InAppPurchase");
            this.onCreate(var1);
        }
    }
}
