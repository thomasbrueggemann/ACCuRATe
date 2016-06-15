package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_768;
import com.google.android.gms.internal.nd;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.nl
public class class_767 implements SafeParcelable {
   public static final class_768 CREATOR = new class_768();
   static final List<nd> ahg = Collections.emptyList();
   // $FF: renamed from: CK int
   private final int field_3426;
   // $FF: renamed from: We com.google.android.gms.location.LocationRequest
   LocationRequest field_3427;
   boolean ahh;
   boolean ahi;
   boolean ahj;
   List<nd> ahk;
   final String mTag;

   class_767(int var1, LocationRequest var2, boolean var3, boolean var4, boolean var5, List<nd> var6, String var7) {
      this.field_3426 = var1;
      this.field_3427 = var2;
      this.ahh = var3;
      this.ahi = var4;
      this.ahj = var5;
      this.ahk = var6;
      this.mTag = var7;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof class_767) {
         class_767 var2 = (class_767)var1;
         if(class_336.equal(this.field_3427, var2.field_3427) && this.ahh == var2.ahh && this.ahi == var2.ahi && this.ahj == var2.ahj && class_336.equal(this.ahk, var2.ahk)) {
            return true;
         }
      }

      return false;
   }

   int getVersionCode() {
      return this.field_3426;
   }

   public int hashCode() {
      return this.field_3427.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.field_3427.toString());
      var1.append(" requestNlpDebugInfo=");
      var1.append(this.ahh);
      var1.append(" restorePendingIntentListeners=");
      var1.append(this.ahi);
      var1.append(" triggerUpdate=");
      var1.append(this.ahj);
      var1.append(" clients=");
      var1.append(this.ahk);
      if(this.mTag != null) {
         var1.append(" tag=");
         var1.append(this.mTag);
      }

      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_768.method_4380(this, var1, var2);
   }
}
