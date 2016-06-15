package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.class_596;

public class ParcelableCollaborator implements SafeParcelable {
   public static final Creator<ParcelableCollaborator> CREATOR = new class_596();
   // $FF: renamed from: Lh boolean
   final boolean field_3238;
   // $FF: renamed from: Li boolean
   final boolean field_3239;
   // $FF: renamed from: Lj java.lang.String
   final String field_3240;
   // $FF: renamed from: Lk java.lang.String
   final String field_3241;
   // $FF: renamed from: Ll java.lang.String
   final String field_3242;
   // $FF: renamed from: Lm java.lang.String
   final String field_3243;
   // $FF: renamed from: rO java.lang.String
   final String field_3244;
   // $FF: renamed from: xJ int
   final int field_3245;

   ParcelableCollaborator(int var1, boolean var2, boolean var3, String var4, String var5, String var6, String var7, String var8) {
      this.field_3245 = var1;
      this.field_3238 = var2;
      this.field_3239 = var3;
      this.field_3244 = var4;
      this.field_3240 = var5;
      this.field_3241 = var6;
      this.field_3242 = var7;
      this.field_3243 = var8;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof ParcelableCollaborator)) {
         return false;
      } else {
         ParcelableCollaborator var2 = (ParcelableCollaborator)var1;
         return this.field_3244.equals(var2.field_3244);
      }
   }

   public int hashCode() {
      return this.field_3244.hashCode();
   }

   public String toString() {
      return "Collaborator [isMe=" + this.field_3238 + ", isAnonymous=" + this.field_3239 + ", sessionId=" + this.field_3244 + ", userId=" + this.field_3240 + ", displayName=" + this.field_3241 + ", color=" + this.field_3242 + ", photoUrl=" + this.field_3243 + "]";
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_596.method_3344(this, var1, var2);
   }
}
