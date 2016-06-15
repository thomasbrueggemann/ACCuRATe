package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.Operator;
import com.google.android.gms.drive.query.internal.class_739;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LogicalFilter implements SafeParcelable, Filter {
   public static final Creator<LogicalFilter> CREATOR = new class_739();
   // $FF: renamed from: KE java.util.List
   private List<Filter> field_4134;
   // $FF: renamed from: KI com.google.android.gms.drive.query.internal.Operator
   final Operator field_4135;
   // $FF: renamed from: KV java.util.List
   final List<FilterHolder> field_4136;
   // $FF: renamed from: xJ int
   final int field_4137;

   LogicalFilter(int var1, Operator var2, List<FilterHolder> var3) {
      this.field_4137 = var1;
      this.field_4135 = var2;
      this.field_4136 = var3;
   }

   public LogicalFilter(Operator var1, Filter var2, Filter... var3) {
      this.field_4137 = 1;
      this.field_4135 = var1;
      this.field_4136 = new ArrayList(1 + var3.length);
      this.field_4136.add(new FilterHolder(var2));
      this.field_4134 = new ArrayList(1 + var3.length);
      this.field_4134.add(var2);
      int var6 = var3.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         Filter var8 = var3[var7];
         this.field_4136.add(new FilterHolder(var8));
         this.field_4134.add(var8);
      }

   }

   public LogicalFilter(Operator var1, Iterable<Filter> var2) {
      this.field_4137 = 1;
      this.field_4135 = var1;
      this.field_4134 = new ArrayList();
      this.field_4136 = new ArrayList();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         Filter var4 = (Filter)var3.next();
         this.field_4134.add(var4);
         this.field_4136.add(new FilterHolder(var4));
      }

   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_739.method_4158(this, var1, var2);
   }
}
