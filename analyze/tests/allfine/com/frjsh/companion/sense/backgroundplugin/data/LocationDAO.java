package com.frjsh.companion.sense.backgroundplugin.data;

import com.frjsh.companion.sense.backgroundplugin.data.Location;

public interface LocationDAO {
    int countLocations();

    void deleteLocation(Location var1);

    Location[] getAllLocations();

    boolean persistLocation(Location var1);
}
