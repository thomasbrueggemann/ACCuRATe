package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.zzz;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.zze;
import com.google.android.gms.drive.metadata.internal.zzh;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class MetadataBundle implements SafeParcelable {
   public static final Creator<MetadataBundle> CREATOR = new zzh();
   final int mVersionCode;
   final Bundle zzasQ;

   MetadataBundle(int var1, Bundle var2) {
      this.mVersionCode = var1;
      this.zzasQ = (Bundle)zzx.zzz(var2);
      this.zzasQ.setClassLoader(this.getClass().getClassLoader());
      ArrayList var3 = new ArrayList();
      Iterator var4 = this.zzasQ.keySet().iterator();

      while(var4.hasNext()) {
         String var7 = (String)var4.next();
         if(zze.zzdc(var7) == null) {
            var3.add(var7);
            zzz.zzz("MetadataBundle", "Ignored unknown metadata field in bundle: " + var7);
         }
      }

      Iterator var5 = var3.iterator();

      while(var5.hasNext()) {
         String var6 = (String)var5.next();
         this.zzasQ.remove(var6);
      }

   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof MetadataBundle)) {
         return false;
      } else {
         MetadataBundle var2 = (MetadataBundle)var1;
         Set var3 = this.zzasQ.keySet();
         if(!var3.equals(var2.zzasQ.keySet())) {
            return false;
         } else {
            Iterator var4 = var3.iterator();

            String var5;
            do {
               if(!var4.hasNext()) {
                  return true;
               }

               var5 = (String)var4.next();
            } while(zzw.equal(this.zzasQ.get(var5), var2.zzasQ.get(var5)));

            return false;
         }
      }
   }

   public int hashCode() {
      Iterator var1 = this.zzasQ.keySet().iterator();

      int var2;
      String var3;
      for(var2 = 1; var1.hasNext(); var2 = var2 * 31 + this.zzasQ.get(var3).hashCode()) {
         var3 = (String)var1.next();
      }

      return var2;
   }

   public String toString() {
      return "MetadataBundle [values=" + this.zzasQ + "]";
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzh.zza(this, var1, var2);
   }

   public <T> T zza(MetadataField<T> var1) {
      return var1.zzm(this.zzasQ);
   }

   public Set<MetadataField<?>> zztG() {
      HashSet var1 = new HashSet();
      Iterator var2 = this.zzasQ.keySet().iterator();

      while(var2.hasNext()) {
         var1.add(zze.zzdc((String)var2.next()));
      }

      return var1;
   }
}
