package com.frjsh.companion.sense.backgroundplugin.data.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.frjsh.companion.sense.backgroundplugin.data.Location;
import com.frjsh.companion.sense.backgroundplugin.data.LocationDAO;
import com.frjsh.companion.sense.backgroundplugin.data.sqlite.LocationOpenHelper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SQLiteLocationDAO implements LocationDAO {
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String TAG = "SQLiteLocationDAO";
    private Context context;

    public SQLiteLocationDAO(Context var1) {
        this.context = var1;
    }

    private ContentValues getContentValues(Location var1) {
        ContentValues var2 = new ContentValues();
        var2.put("latitude", var1.getLatitude());
        var2.put("longitude", var1.getLongitude());
        var2.put("recordedAt", this.dateToString(var1.getRecordedAt()));
        var2.put("accuracy", var1.getAccuracy());
        var2.put("bearing", var1.getBearing());
        var2.put("speed", var1.getSpeed());
        var2.put("batteryLevel", var1.getBatteryLevel());
        var2.put("isCharging", var1.getIsCharging());
        var2.put("gsmQuality", var1.getGsmQuality());
        var2.put("avgAcceleration", var1.getAvgAcceleration());
        var2.put("maxAcceleration", var1.getMaxAcceleration());
        var2.put("screenBrightness", var1.getScreenBrightness());
        var2.put("isAnchorAlarmActive", var1.getIsAnchorAlarmActive());
        var2.put("nmea", var1.getNMEA());
        var2.put("logbook", var1.getLogbook());
        return var2;
    }

    private Double getDoubleFromCursor(Cursor var1, String var2) {
        int var3 = var1.getColumnIndex(var2);
        return var3 >= 0?Double.valueOf(var1.getDouble(var3)):null;
    }

    private Float getFloatFromCursor(Cursor var1, String var2) {
        int var3 = var1.getColumnIndex(var2);
        return var3 >= 0?Float.valueOf(var1.getFloat(var3)):null;
    }

    private Integer getIntegerFromCursor(Cursor var1, String var2) {
        int var3 = var1.getColumnIndex(var2);
        return var3 >= 0?Integer.valueOf(var1.getInt(var3)):null;
    }

    private String getStringFromCursor(Cursor var1, String var2) {
        int var3 = var1.getColumnIndex(var2);
        return var3 >= 0?var1.getString(var3):null;
    }

    private Location hydrate(Cursor param1) {
        // $FF: Couldn't be decompiled
    }

    public int countLocations() {
        SQLiteDatabase var1 = null;
        Cursor var2 = null;

        int var5;
        try {
            var1 = (new LocationOpenHelper(this.context)).getReadableDatabase();
            var2 = var1.rawQuery("select count(*) from location", (String[])null);
            var2.moveToFirst();
            var5 = var2.getInt(0);
        } finally {
            if(var2 != null) {
                var2.close();
            }

            if(var1 != null) {
                var1.close();
            }

        }

        return var5;
    }

    public String dateToString(Date var1) {
        return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(var1);
    }

    public void deleteLocation(Location var1) {
        SQLiteDatabase var2 = (new LocationOpenHelper(this.context)).getWritableDatabase();
        var2.beginTransaction();
        String[] var3 = new String[] {var1.getId().toString()};
        var2.delete("location", "id = ?", var3);
        var2.setTransactionSuccessful();
        var2.endTransaction();
        var2.close();
    }

    public Location[] getAllLocations() {
        // $FF: Couldn't be decompiled
    }

    public boolean persistLocation(Location var1) {
        SQLiteDatabase var2 = (new LocationOpenHelper(this.context)).getWritableDatabase();
        var2.beginTransaction();
        long var3 = var2.insert("location", (String)null, this.getContentValues(var1));
        Log.d("SQLiteLocationDAO", "After insert, rowId = " + var3);
        var2.setTransactionSuccessful();
        var2.endTransaction();
        var2.close();
        if(var3 > -1L) {
            var1.setId(Long.valueOf(var3));
            return true;
        } else {
            return false;
        }
    }

    public Date stringToDate(String var1) {
        SimpleDateFormat var2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date var5 = var2.parse(var1);
            return var5;
        } catch (ParseException var6) {
            Log.e("DBUtil", "Parsing ISO8601 datetime (" + var1 + ") failed", var6);
            return null;
        }
    }
}
