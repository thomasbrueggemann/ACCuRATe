package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.class_511;
import com.google.android.gms.fitness.request.w;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_336;
import java.util.concurrent.TimeUnit;

// $FF: renamed from: com.google.android.gms.fitness.request.w
public class class_512 implements SafeParcelable {
   public static final Creator<w> CREATOR = new class_511();
   // $FF: renamed from: CK int
   private final int field_1916;
   // $FF: renamed from: TQ com.google.android.gms.fitness.data.Session
   private final Session field_1917;

   class_512(int var1, Session var2) {
      this.field_1916 = var1;
      this.field_1917 = var2;
   }

   private class_512(class_512.class_1467 var1) {
      this.field_1916 = 1;
      this.field_1917 = var1.field_3187;
   }

   // $FF: synthetic method
   class_512(class_512.class_1467 var1, Object var2) {
      this(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.fitness.request.w) boolean
   private boolean method_3201(class_512 var1) {
      return class_336.equal(this.field_1917, var1.field_1917);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof class_512 && this.method_3201((class_512)var1);
   }

   public Session getSession() {
      return this.field_1917;
   }

   int getVersionCode() {
      return this.field_1916;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_1917};
      return class_336.hashCode(var1);
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("session", this.field_1917).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_511.method_3198(this, var1, var2);
   }

   public static class class_1467 {
      // $FF: renamed from: TQ com.google.android.gms.fitness.data.Session
      private Session field_3187;

      // $FF: renamed from: b (com.google.android.gms.fitness.data.Session) com.google.android.gms.fitness.request.w$a
      public class_512.class_1467 method_4126(Session var1) {
         boolean var2;
         if(var1.getEndTime(TimeUnit.MILLISECONDS) == 0L) {
            var2 = true;
         } else {
            var2 = false;
         }

         class_335.method_2308(var2, "Cannot start a session which has already ended");
         this.field_3187 = var1;
         return this;
      }

      // $FF: renamed from: kk () com.google.android.gms.fitness.request.w
      public class_512 method_4127() {
         return new class_512(this);
      }
   }
}
