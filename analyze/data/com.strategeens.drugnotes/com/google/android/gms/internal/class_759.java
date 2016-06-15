package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_760;
import com.google.android.gms.internal.oa;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.nq
public class class_759 implements SafeParcelable {
   public static final class_760 CREATOR = new class_760();
   // $FF: renamed from: CK int
   final int field_3422;
   final boolean ahm;
   final List<oa> ahn;
   private final Set<oa> aho;

   class_759(int var1, boolean var2, List<oa> var3) {
      this.field_3422 = var1;
      this.ahm = var2;
      List var4;
      if(var3 == null) {
         var4 = Collections.emptyList();
      } else {
         var4 = Collections.unmodifiableList(var3);
      }

      this.ahn = var4;
      if(this.ahn.isEmpty()) {
         this.aho = Collections.emptySet();
      } else {
         this.aho = Collections.unmodifiableSet(new HashSet(this.ahn));
      }
   }

   public int describeContents() {
      class_760 var10000 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof class_759)) {
            return false;
         }

         class_759 var2 = (class_759)var1;
         if(!this.aho.equals(var2.aho) || this.ahm != var2.ahm) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.aho, Boolean.valueOf(this.ahm)};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: nr () boolean
   public boolean method_4354() {
      return this.ahm;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_760 var10000 = CREATOR;
      class_760.method_4355(this, var1, var2);
   }
}
