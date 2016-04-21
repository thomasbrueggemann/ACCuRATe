package com.frjsh.companion.sense.backgroundplugin.data;

import android.content.Context;
import com.frjsh.companion.sense.backgroundplugin.data.LocationDAO;
import com.frjsh.companion.sense.backgroundplugin.data.sqlite.SQLiteLocationDAO;

public abstract class DAOFactory {
    public static LocationDAO createLocationDAO(Context var0) {
        return new SQLiteLocationDAO(var0);
    }
}
