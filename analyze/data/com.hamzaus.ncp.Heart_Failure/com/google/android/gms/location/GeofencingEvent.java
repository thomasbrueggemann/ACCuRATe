package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import com.google.android.gms.internal.class_314;
import com.google.android.gms.location.Geofence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeofencingEvent {
   // $FF: renamed from: Vf int
   private final int field_716;
   // $FF: renamed from: Vg java.util.List
   private final List<Geofence> field_717;
   // $FF: renamed from: Vh android.location.Location
   private final Location field_718;
   // $FF: renamed from: pH int
   private final int field_719;

   private GeofencingEvent(int var1, int var2, List<Geofence> var3, Location var4) {
      this.field_719 = var1;
      this.field_716 = var2;
      this.field_717 = var3;
      this.field_718 = var4;
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
            var2.add(class_314.method_2037((byte[])var3.next()));
         }

         return var2;
      }
   }

   public int getErrorCode() {
      return this.field_719;
   }

   public int getGeofenceTransition() {
      return this.field_716;
   }

   public List<Geofence> getTriggeringGeofences() {
      return this.field_717;
   }

   public Location getTriggeringLocation() {
      return this.field_718;
   }

   public boolean hasError() {
      return this.field_719 != -1;
   }
}
