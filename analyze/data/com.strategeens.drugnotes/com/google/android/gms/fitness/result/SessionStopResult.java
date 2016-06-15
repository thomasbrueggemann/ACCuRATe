package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.result.class_932;
import com.google.android.gms.internal.class_336;
import java.util.Collections;
import java.util.List;

public class SessionStopResult implements Result, SafeParcelable {
   public static final Creator<SessionStopResult> CREATOR = new class_932();
   // $FF: renamed from: CK int
   private final int field_4219;
   // $FF: renamed from: Eb com.google.android.gms.common.api.Status
   private final Status field_4220;
   // $FF: renamed from: VI java.util.List
   private final List<Session> field_4221;

   SessionStopResult(int var1, Status var2, List<Session> var3) {
      this.field_4219 = var1;
      this.field_4220 = var2;
      this.field_4221 = Collections.unmodifiableList(var3);
   }

   public SessionStopResult(Status var1, List<Session> var2) {
      this.field_4219 = 3;
      this.field_4220 = var1;
      this.field_4221 = Collections.unmodifiableList(var2);
   }

   // $FF: renamed from: H (com.google.android.gms.common.api.Status) com.google.android.gms.fitness.result.SessionStopResult
   public static SessionStopResult method_5447(Status var0) {
      return new SessionStopResult(var0, Collections.emptyList());
   }

   // $FF: renamed from: b (com.google.android.gms.fitness.result.SessionStopResult) boolean
   private boolean method_5448(SessionStopResult var1) {
      return this.field_4220.equals(var1.field_4220) && class_336.equal(this.field_4221, var1.field_4221);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof SessionStopResult && this.method_5448((SessionStopResult)var1);
   }

   public List<Session> getSessions() {
      return this.field_4221;
   }

   public Status getStatus() {
      return this.field_4220;
   }

   int getVersionCode() {
      return this.field_4219;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_4220, this.field_4221};
      return class_336.hashCode(var1);
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("status", this.field_4220).method_3424("sessions", this.field_4221).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_932.method_5161(this, var1, var2);
   }
}
