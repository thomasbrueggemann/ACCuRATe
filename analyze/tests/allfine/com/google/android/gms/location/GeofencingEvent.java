package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import com.google.android.gms.internal.class_828;
import com.google.android.gms.location.Geofence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeofencingEvent {
    private final int aep;
    private final List<Geofence> aeq;
    private final Location aer;
    // $FF: renamed from: tc int
    private final int field_863;

    private GeofencingEvent(int var1, int var2, List<Geofence> var3, Location var4) {
        this.field_863 = var1;
        this.aep = var2;
        this.aeq = var3;
        this.aer = var4;
    }

    public static GeofencingEvent fromIntent(Intent var0) {
        return var0 == null?null:new GeofencingEvent(var0.getIntExtra("gms_error_code", -1), getGeofenceTransition(var0), getTriggeringGeofences(var0), (Location)var0.getParcelableExtra("com.google.android.location.intent.extra.triggering_location"));
    }

    private static int getGeofenceTransition(Intent var0) {
        int var1 = var0.getIntExtra("com.google.android.location.intent.extra.transition", -1);
        return var1 != -1 && (var1 == 1 || var1 == 2 || var1 == 4)?var1:-1;
    }

    private static List<Geofence> getTriggeringGeofences(Intent var0) {
        ArrayList var1 = (ArrayList)var0.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
        if(var1 == null) {
            return null;
        } else {
            ArrayList var2 = new ArrayList(var1.size());
            Iterator var3 = var1.iterator();

            while(var3.hasNext()) {
                var2.add(class_828.method_4444((byte[])var3.next()));
            }

            return var2;
        }
    }

    public int getErrorCode() {
        return this.field_863;
    }

    public int getGeofenceTransition() {
        return this.aep;
    }

    public List<Geofence> getTriggeringGeofences() {
        return this.aeq;
    }

    public Location getTriggeringLocation() {
        return this.aer;
    }

    public boolean hasError() {
        return this.field_863 != -1;
    }
}
