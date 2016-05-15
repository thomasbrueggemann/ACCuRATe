package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.internal.AbstractFilter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.Operator;
import com.google.android.gms.drive.query.internal.zzf;
import com.google.android.gms.drive.query.internal.zzk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LogicalFilter extends AbstractFilter {
   public static final Creator<LogicalFilter> CREATOR = new zzk();
   final int mVersionCode;
   final Operator zzaug;
   final List<FilterHolder> zzauv;

   LogicalFilter(int var1, Operator var2, List<FilterHolder> var3) {
      this.mVersionCode = var1;
      this.zzaug = var2;
      this.zzauv = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzk.zza(this, var1, var2);
   }

   public <T> T zza(zzf<T> var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = this.zzauv.iterator();

      while(var3.hasNext()) {
         var2.add(((FilterHolder)var3.next()).getFilter().zza(var1));
      }

      return var1.zzb((Operator)this.zzaug, (List)var2);
   }
}
