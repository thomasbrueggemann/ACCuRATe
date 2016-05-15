package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.internal.ClientIdentity;
import com.google.android.gms.location.internal.zzm;
import java.util.Collections;
import java.util.List;

public class LocationRequestInternal implements SafeParcelable {
   public static final zzm CREATOR = new zzm();
   static final List<ClientIdentity> zzaOO = Collections.emptyList();
   @Nullable
   String mTag;
   private final int mVersionCode;
   LocationRequest zzaBp;
   boolean zzaOP;
   boolean zzaOQ;
   boolean zzaOR;
   List<ClientIdentity> zzaOS;
   boolean zzaOT;

   LocationRequestInternal(int var1, LocationRequest var2, boolean var3, boolean var4, boolean var5, List<ClientIdentity> var6, @Nullable String var7, boolean var8) {
      this.mVersionCode = var1;
      this.zzaBp = var2;
      this.zzaOP = var3;
      this.zzaOQ = var4;
      this.zzaOR = var5;
      this.zzaOS = var6;
      this.mTag = var7;
      this.zzaOT = var8;
   }

   public static LocationRequestInternal zza(@Nullable String var0, LocationRequest var1) {
      return new LocationRequestInternal(1, var1, false, true, true, zzaOO, var0, false);
   }

   @Deprecated
   public static LocationRequestInternal zzb(LocationRequest var0) {
      return zza((String)null, var0);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof LocationRequestInternal) {
         LocationRequestInternal var2 = (LocationRequestInternal)var1;
         if(zzw.equal(this.zzaBp, var2.zzaBp) && this.zzaOP == var2.zzaOP && this.zzaOQ == var2.zzaOQ && this.zzaOR == var2.zzaOR && this.zzaOT == var2.zzaOT && zzw.equal(this.zzaOS, var2.zzaOS)) {
            return true;
         }
      }

      return false;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      return this.zzaBp.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.zzaBp.toString());
      if(this.mTag != null) {
         var1.append(" tag=").append(this.mTag);
      }

      var1.append(" nlpDebug=").append(this.zzaOP);
      var1.append(" trigger=").append(this.zzaOR);
      var1.append(" restorePIListeners=").append(this.zzaOQ);
      var1.append(" hideAppOps=").append(this.zzaOT);
      var1.append(" clients=").append(this.zzaOS);
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzm.zza(this, var1, var2);
   }
}
