package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_757;
import com.google.android.gms.internal.nn;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.class_652;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeofencingRequest implements SafeParcelable {
   public static final Creator<GeofencingRequest> CREATOR = new class_652();
   public static final int INITIAL_TRIGGER_DWELL = 4;
   public static final int INITIAL_TRIGGER_ENTER = 1;
   public static final int INITIAL_TRIGGER_EXIT = 2;
   // $FF: renamed from: CK int
   private final int field_3853;
   private final List<nn> ago;
   private final int agp;

   GeofencingRequest(int var1, List<nn> var2, int var3) {
      this.field_3853 = var1;
      this.ago = var2;
      this.agp = var3;
   }

   private GeofencingRequest(List<nn> var1, int var2) {
      this(1, var1, var2);
   }

   // $FF: synthetic method
   GeofencingRequest(List var1, int var2, Object var3) {
      this(var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public List<Geofence> getGeofences() {
      ArrayList var1 = new ArrayList();
      var1.addAll(this.ago);
      return var1;
   }

   public int getInitialTrigger() {
      return this.agp;
   }

   public int getVersionCode() {
      return this.field_3853;
   }

   // $FF: renamed from: ng () java.util.List
   public List<nn> method_5100() {
      return this.ago;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_652.method_3722(this, var1, var2);
   }

   public static final class Builder {
      private final List<nn> ago = new ArrayList();
      private int agp = 5;

      // $FF: renamed from: ew (int) int
      public static int method_4016(int var0) {
         return var0 & 7;
      }

      public GeofencingRequest.Builder addGeofence(Geofence var1) {
         class_335.method_2306(var1, "geofence can\'t be null.");
         class_335.method_2308(var1 instanceof class_757, "Geofence must be created using Geofence.Builder.");
         this.ago.add((class_757)var1);
         return this;
      }

      public GeofencingRequest.Builder addGeofences(List<Geofence> var1) {
         if(var1 != null && !var1.isEmpty()) {
            Iterator var2 = var1.iterator();

            while(var2.hasNext()) {
               Geofence var3 = (Geofence)var2.next();
               if(var3 != null) {
                  this.addGeofence(var3);
               }
            }
         }

         return this;
      }

      public GeofencingRequest build() {
         boolean var1;
         if(!this.ago.isEmpty()) {
            var1 = true;
         } else {
            var1 = false;
         }

         class_335.method_2308(var1, "No geofence has been added to this request.");
         return new GeofencingRequest(this.ago, this.agp);
      }

      public GeofencingRequest.Builder setInitialTrigger(int var1) {
         this.agp = method_4016(var1);
         return this;
      }
   }
}
