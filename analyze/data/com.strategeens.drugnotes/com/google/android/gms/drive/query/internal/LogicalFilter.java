package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.AbstractFilter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.Operator;
import com.google.android.gms.drive.query.internal.class_957;
import com.google.android.gms.drive.query.internal.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LogicalFilter extends AbstractFilter {
   public static final Creator<LogicalFilter> CREATOR = new class_957();
   // $FF: renamed from: CK int
   final int field_1704;
   // $FF: renamed from: Sc java.util.List
   private List<Filter> field_1705;
   // $FF: renamed from: Sh com.google.android.gms.drive.query.internal.Operator
   final Operator field_1706;
   // $FF: renamed from: Su java.util.List
   final List<FilterHolder> field_1707;

   LogicalFilter(int var1, Operator var2, List<FilterHolder> var3) {
      this.field_1704 = var1;
      this.field_1706 = var2;
      this.field_1707 = var3;
   }

   public LogicalFilter(Operator var1, Filter var2, Filter... var3) {
      this.field_1704 = 1;
      this.field_1706 = var1;
      this.field_1707 = new ArrayList(1 + var3.length);
      this.field_1707.add(new FilterHolder(var2));
      this.field_1705 = new ArrayList(1 + var3.length);
      this.field_1705.add(var2);
      int var6 = var3.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         Filter var8 = var3[var7];
         this.field_1707.add(new FilterHolder(var8));
         this.field_1705.add(var8);
      }

   }

   public LogicalFilter(Operator var1, Iterable<Filter> var2) {
      this.field_1704 = 1;
      this.field_1706 = var1;
      this.field_1705 = new ArrayList();
      this.field_1707 = new ArrayList();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         Filter var4 = (Filter)var3.next();
         this.field_1705.add(var4);
         this.field_1707.add(new FilterHolder(var4));
      }

   }

   // $FF: renamed from: a (com.google.android.gms.drive.query.internal.f) java.lang.Object
   public <T> T method_7(f<T> var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = this.field_1707.iterator();

      while(var3.hasNext()) {
         var2.add(((FilterHolder)var3.next()).getFilter().method_7(var1));
      }

      return var1.method_927(this.field_1706, var2);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_957.method_5268(this, var1, var2);
   }
}
