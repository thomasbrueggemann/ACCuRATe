package com.frjsh.companion.sense.backgroundplugin.data.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

public class LocationOpenHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 5;
    private static final String LOCATION_TABLE_COLUMNS = " id INTEGER PRIMARY KEY AUTOINCREMENT, recordedAt TEXT, accuracy REAL, speed REAL, bearing REAL, latitude REAL, longitude REAL, batteryLevel INTEGER, isCharging INTEGER, gsmQuality INTEGER, screenBrightness INTEGER, avgAcceleration REAL, maxAcceleration REAL, isAnchorAlarmActive INTEGER, nmea TEXT, logbook TEXT";
    private static final String LOCATION_TABLE_CREATE = "CREATE TABLE location ( id INTEGER PRIMARY KEY AUTOINCREMENT, recordedAt TEXT, accuracy REAL, speed REAL, bearing REAL, latitude REAL, longitude REAL, batteryLevel INTEGER, isCharging INTEGER, gsmQuality INTEGER, screenBrightness INTEGER, avgAcceleration REAL, maxAcceleration REAL, isAnchorAlarmActive INTEGER, nmea TEXT, logbook TEXT);";
    public static final String LOCATION_TABLE_NAME = "location";
    private static final String SQLITE_DATABASE_NAME = "cordova_bg_locations";

    LocationOpenHelper(Context var1) {
        super(var1, "cordova_bg_locations", (CursorFactory)null, 5);
    }

    public void onCreate(SQLiteDatabase var1) {
        var1.execSQL("CREATE TABLE location ( id INTEGER PRIMARY KEY AUTOINCREMENT, recordedAt TEXT, accuracy REAL, speed REAL, bearing REAL, latitude REAL, longitude REAL, batteryLevel INTEGER, isCharging INTEGER, gsmQuality INTEGER, screenBrightness INTEGER, avgAcceleration REAL, maxAcceleration REAL, isAnchorAlarmActive INTEGER, nmea TEXT, logbook TEXT);");
        Log.d(this.getClass().getName(), "CREATE TABLE location ( id INTEGER PRIMARY KEY AUTOINCREMENT, recordedAt TEXT, accuracy REAL, speed REAL, bearing REAL, latitude REAL, longitude REAL, batteryLevel INTEGER, isCharging INTEGER, gsmQuality INTEGER, screenBrightness INTEGER, avgAcceleration REAL, maxAcceleration REAL, isAnchorAlarmActive INTEGER, nmea TEXT, logbook TEXT);");
    }

    public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
        var1.execSQL("DROP TABLE IF EXISTS location");
        this.onCreate(var1);
    }
}
