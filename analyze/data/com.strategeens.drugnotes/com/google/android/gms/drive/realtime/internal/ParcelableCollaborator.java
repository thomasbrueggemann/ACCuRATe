package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.class_701;

public class ParcelableCollaborator implements SafeParcelable {
   public static final Creator<ParcelableCollaborator> CREATOR = new class_701();
   // $FF: renamed from: CK int
   final int field_3192;
   // $FF: renamed from: OS java.lang.String
   final String field_3193;
   // $FF: renamed from: SH boolean
   final boolean field_3194;
   // $FF: renamed from: SI boolean
   final boolean field_3195;
   // $FF: renamed from: SJ java.lang.String
   final String field_3196;
   // $FF: renamed from: SK java.lang.String
   final String field_3197;
   // $FF: renamed from: SL java.lang.String
   final String field_3198;
   // $FF: renamed from: vZ java.lang.String
   final String field_3199;

   ParcelableCollaborator(int var1, boolean var2, boolean var3, String var4, String var5, String var6, String var7, String var8) {
      this.field_3192 = var1;
      this.field_3194 = var2;
      this.field_3195 = var3;
      this.field_3199 = var4;
      this.field_3196 = var5;
      this.field_3193 = var6;
      this.field_3197 = var7;
      this.field_3198 = var8;
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
         return this.field_3199.equals(var2.field_3199);
      }
   }

   public int hashCode() {
      return this.field_3199.hashCode();
   }

   public String toString() {
      return "Collaborator [isMe=" + this.field_3194 + ", isAnonymous=" + this.field_3195 + ", sessionId=" + this.field_3199 + ", userId=" + this.field_3196 + ", displayName=" + this.field_3193 + ", color=" + this.field_3197 + ", photoUrl=" + this.field_3198 + "]";
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_701.method_4010(this, var1, var2);
   }
}
