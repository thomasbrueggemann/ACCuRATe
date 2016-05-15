package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.measurement.internal.zzj;
import java.util.Iterator;

public class EventParams implements SafeParcelable, Iterable<String> {
   public static final zzj CREATOR = new zzj();
   public final int versionCode;
   private final Bundle zzaVS;

   EventParams(int var1, Bundle var2) {
      this.versionCode = var1;
      this.zzaVS = var2;
   }

   EventParams(Bundle var1) {
      com.google.android.gms.common.internal.zzx.zzz(var1);
      this.zzaVS = var1;
      this.versionCode = 1;
   }

   public int describeContents() {
      return 0;
   }

   Object get(String var1) {
      return this.zzaVS.get(var1);
   }

   public Iterator<String> iterator() {
      return new Iterator() {
         Iterator<String> zzaVT;

         {
            this.zzaVT = EventParams.this.zzaVS.keySet().iterator();
         }

         public boolean hasNext() {
            return this.zzaVT.hasNext();
         }

         public String next() {
            return (String)this.zzaVT.next();
         }

         public void remove() {
            throw new UnsupportedOperationException("Remove not supported");
         }
      };
   }

   public int size() {
      return this.zzaVS.size();
   }

   public String toString() {
      return this.zzaVS.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzj.zza(this, var1, var2);
   }

   public Bundle zzCC() {
      return new Bundle(this.zzaVS);
   }
}
