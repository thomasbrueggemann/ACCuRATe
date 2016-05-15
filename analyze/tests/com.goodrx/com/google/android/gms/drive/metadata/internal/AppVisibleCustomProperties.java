package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.CustomProperty;
import com.google.android.gms.drive.metadata.internal.zza;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class AppVisibleCustomProperties implements SafeParcelable, Iterable<CustomProperty> {
   public static final Creator<AppVisibleCustomProperties> CREATOR = new zza();
   public static final AppVisibleCustomProperties zzasK = (new AppVisibleCustomProperties.zza()).zztA();
   final int mVersionCode;
   final List<CustomProperty> zzasL;

   AppVisibleCustomProperties(int var1, Collection<CustomProperty> var2) {
      this.mVersionCode = var1;
      zzx.zzz(var2);
      this.zzasL = new ArrayList(var2);
   }

   private AppVisibleCustomProperties(Collection<CustomProperty> var1) {
      this(1, var1);
   }

   // $FF: synthetic method
   AppVisibleCustomProperties(Collection var1, Object var2) {
      this(var1);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1?true:(var1 != null && var1.getClass() == this.getClass()?this.zztz().equals(((AppVisibleCustomProperties)var1).zztz()):false);
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzasL};
      return zzw.hashCode(var1);
   }

   public Iterator<CustomProperty> iterator() {
      return this.zzasL.iterator();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }

   public Map<CustomPropertyKey, String> zztz() {
      HashMap var1 = new HashMap(this.zzasL.size());
      Iterator var2 = this.zzasL.iterator();

      while(var2.hasNext()) {
         CustomProperty var3 = (CustomProperty)var2.next();
         var1.put(var3.zztB(), var3.getValue());
      }

      return Collections.unmodifiableMap(var1);
   }

   public static class zza {
      private final Map<CustomPropertyKey, CustomProperty> zzasM = new HashMap();

      public AppVisibleCustomProperties zztA() {
         return new AppVisibleCustomProperties(this.zzasM.values());
      }
   }
}
