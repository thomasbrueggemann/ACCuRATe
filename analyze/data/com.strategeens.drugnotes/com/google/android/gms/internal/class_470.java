package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.internal.ey;
import java.util.Date;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.db
@ey
public final class class_470 implements MediationAdRequest {
   // $FF: renamed from: d java.util.Date
   private final Date field_1612;
   // $FF: renamed from: f java.util.Set
   private final Set<String> field_1613;
   // $FF: renamed from: g boolean
   private final boolean field_1614;
   // $FF: renamed from: h android.location.Location
   private final Location field_1615;
   // $FF: renamed from: ow int
   private final int field_1616;
   // $FF: renamed from: qU int
   private final int field_1617;

   public class_470(Date var1, int var2, Set<String> var3, Location var4, boolean var5, int var6) {
      this.field_1612 = var1;
      this.field_1616 = var2;
      this.field_1613 = var3;
      this.field_1615 = var4;
      this.field_1614 = var5;
      this.field_1617 = var6;
   }

   public Date getBirthday() {
      return this.field_1612;
   }

   public int getGender() {
      return this.field_1616;
   }

   public Set<String> getKeywords() {
      return this.field_1613;
   }

   public Location getLocation() {
      return this.field_1615;
   }

   public boolean isTesting() {
      return this.field_1614;
   }

   public int taggedForChildDirectedTreatment() {
      return this.field_1617;
   }
}
