package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.class_1047;
import com.google.android.gms.fitness.data.q;
import com.google.android.gms.fitness.result.class_930;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_336;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SessionReadResult implements Result, SafeParcelable {
   public static final Creator<SessionReadResult> CREATOR = new class_930();
   // $FF: renamed from: CK int
   private final int field_2722;
   // $FF: renamed from: Eb com.google.android.gms.common.api.Status
   private final Status field_2723;
   // $FF: renamed from: VI java.util.List
   private final List<Session> field_2724;
   // $FF: renamed from: Wv java.util.List
   private final List<q> field_2725;

   SessionReadResult(int var1, List<Session> var2, List<q> var3, Status var4) {
      this.field_2722 = var1;
      this.field_2724 = var2;
      this.field_2725 = Collections.unmodifiableList(var3);
      this.field_2723 = var4;
   }

   public SessionReadResult(List<Session> var1, List<q> var2, Status var3) {
      this.field_2722 = 3;
      this.field_2724 = var1;
      this.field_2725 = Collections.unmodifiableList(var2);
      this.field_2723 = var3;
   }

   // $FF: renamed from: G (com.google.android.gms.common.api.Status) com.google.android.gms.fitness.result.SessionReadResult
   public static SessionReadResult method_3521(Status var0) {
      return new SessionReadResult(new ArrayList(), new ArrayList(), var0);
   }

   // $FF: renamed from: b (com.google.android.gms.fitness.result.SessionReadResult) boolean
   private boolean method_3522(SessionReadResult var1) {
      return this.field_2723.equals(var1.field_2723) && class_336.equal(this.field_2724, var1.field_2724) && class_336.equal(this.field_2725, var1.field_2725);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof SessionReadResult && this.method_3522((SessionReadResult)var1);
   }

   public List<DataSet> getDataSet(Session var1) {
      class_335.method_2309(this.field_2724.contains(var1), "Attempting to read data for session %s which was not returned", new Object[]{var1});
      ArrayList var2 = new ArrayList();
      Iterator var3 = this.field_2725.iterator();

      while(var3.hasNext()) {
         class_1047 var4 = (class_1047)var3.next();
         if(class_336.equal(var1, var4.getSession())) {
            var2.add(var4.method_5751());
         }
      }

      return var2;
   }

   public List<DataSet> getDataSet(Session var1, DataType var2) {
      class_335.method_2309(this.field_2724.contains(var1), "Attempting to read data for session %s which was not returned", new Object[]{var1});
      ArrayList var3 = new ArrayList();
      Iterator var4 = this.field_2725.iterator();

      while(var4.hasNext()) {
         class_1047 var5 = (class_1047)var4.next();
         if(class_336.equal(var1, var5.getSession()) && var2.equals(var5.method_5751().getDataType())) {
            var3.add(var5.method_5751());
         }
      }

      return var3;
   }

   public List<Session> getSessions() {
      return this.field_2724;
   }

   public Status getStatus() {
      return this.field_2723;
   }

   int getVersionCode() {
      return this.field_2722;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_2723, this.field_2724, this.field_2725};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: kv () java.util.List
   public List<q> method_3523() {
      return this.field_2725;
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("status", this.field_2723).method_3424("sessions", this.field_2724).method_3424("sessionDataSets", this.field_2725).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_930.method_5155(this, var1, var2);
   }
}
