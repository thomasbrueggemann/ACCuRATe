package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.internal.class_277;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.class_335;

public class CreateFileRequest implements SafeParcelable {
   public static final Creator<CreateFileRequest> CREATOR = new class_277();
   // $FF: renamed from: CK int
   final int field_3871;
   // $FF: renamed from: Oy java.lang.String
   final String field_3872;
   // $FF: renamed from: PA boolean
   final boolean field_3873;
   // $FF: renamed from: PB int
   final int field_3874;
   // $FF: renamed from: PC int
   final int field_3875;
   // $FF: renamed from: Pr com.google.android.gms.drive.Contents
   final Contents field_3876;
   // $FF: renamed from: Px com.google.android.gms.drive.metadata.internal.MetadataBundle
   final MetadataBundle field_3877;
   // $FF: renamed from: Py java.lang.Integer
   final Integer field_3878;
   // $FF: renamed from: Pz com.google.android.gms.drive.DriveId
   final DriveId field_3879;

   CreateFileRequest(int var1, DriveId var2, MetadataBundle var3, Contents var4, Integer var5, boolean var6, String var7, int var8, int var9) {
      if(var4 != null && var9 != 0) {
         boolean var10;
         if(var4.getRequestId() == var9) {
            var10 = true;
         } else {
            var10 = false;
         }

         class_335.method_2308(var10, "inconsistent contents reference");
      }

      if((var5 == null || var5.intValue() == 0) && var4 == null && var9 == 0) {
         throw new IllegalArgumentException("Need a valid contents");
      } else {
         this.field_3871 = var1;
         this.field_3879 = (DriveId)class_335.method_2311(var2);
         this.field_3877 = (MetadataBundle)class_335.method_2311(var3);
         this.field_3876 = var4;
         this.field_3878 = var5;
         this.field_3872 = var7;
         this.field_3874 = var8;
         this.field_3873 = var6;
         this.field_3875 = var9;
      }
   }

   public CreateFileRequest(DriveId var1, MetadataBundle var2, int var3, int var4, ExecutionOptions var5) {
      this(2, var1, var2, (Contents)null, Integer.valueOf(var4), var5.method_4310(), var5.method_4309(), var5.method_4311(), var3);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_277.method_1753(this, var1, var2);
   }
}
