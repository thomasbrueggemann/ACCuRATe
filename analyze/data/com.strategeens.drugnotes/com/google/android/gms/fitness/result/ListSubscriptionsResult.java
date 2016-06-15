package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.result.class_931;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_336;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListSubscriptionsResult implements Result, SafeParcelable {
   public static final Creator<ListSubscriptionsResult> CREATOR = new class_931();
   // $FF: renamed from: CK int
   private final int field_2661;
   // $FF: renamed from: Eb com.google.android.gms.common.api.Status
   private final Status field_2662;
   // $FF: renamed from: Wu java.util.List
   private final List<Subscription> field_2663;

   ListSubscriptionsResult(int var1, List<Subscription> var2, Status var3) {
      this.field_2661 = var1;
      this.field_2663 = var2;
      this.field_2662 = var3;
   }

   public ListSubscriptionsResult(List<Subscription> var1, Status var2) {
      this.field_2661 = 3;
      this.field_2663 = Collections.unmodifiableList(var1);
      this.field_2662 = (Status)class_335.method_2306(var2, "status");
   }

   // $FF: renamed from: F (com.google.android.gms.common.api.Status) com.google.android.gms.fitness.result.ListSubscriptionsResult
   public static ListSubscriptionsResult method_3444(Status var0) {
      return new ListSubscriptionsResult(Collections.emptyList(), var0);
   }

   // $FF: renamed from: b (com.google.android.gms.fitness.result.ListSubscriptionsResult) boolean
   private boolean method_3445(ListSubscriptionsResult var1) {
      return this.field_2662.equals(var1.field_2662) && class_336.equal(this.field_2663, var1.field_2663);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof ListSubscriptionsResult && this.method_3445((ListSubscriptionsResult)var1);
   }

   public Status getStatus() {
      return this.field_2662;
   }

   public List<Subscription> getSubscriptions() {
      return this.field_2663;
   }

   public List<Subscription> getSubscriptions(DataType var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = this.field_2663.iterator();

      while(var3.hasNext()) {
         Subscription var4 = (Subscription)var3.next();
         if(var1.equals(var4.method_4755())) {
            var2.add(var4);
         }
      }

      return Collections.unmodifiableList(var2);
   }

   int getVersionCode() {
      return this.field_2661;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_2662, this.field_2663};
      return class_336.hashCode(var1);
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("status", this.field_2662).method_3424("subscriptions", this.field_2663).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_931.method_5158(this, var1, var2);
   }
}
