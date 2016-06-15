package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.class_684;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Contents implements SafeParcelable {
   public static final Creator<Contents> CREATOR = new class_684();
   // $FF: renamed from: CK int
   final int field_3098;
   // $FF: renamed from: LG android.os.ParcelFileDescriptor
   final ParcelFileDescriptor field_3099;
   // $FF: renamed from: Oi int
   final int field_3100;
   // $FF: renamed from: Oj com.google.android.gms.drive.DriveId
   final DriveId field_3101;
   // $FF: renamed from: Ok boolean
   final boolean field_3102;
   // $FF: renamed from: ve int
   final int field_3103;

   Contents(int var1, ParcelFileDescriptor var2, int var3, int var4, DriveId var5, boolean var6) {
      this.field_3098 = var1;
      this.field_3099 = var2;
      this.field_3103 = var3;
      this.field_3100 = var4;
      this.field_3101 = var5;
      this.field_3102 = var6;
   }

   public int describeContents() {
      return 0;
   }

   public DriveId getDriveId() {
      return this.field_3101;
   }

   public InputStream getInputStream() {
      return new FileInputStream(this.field_3099.getFileDescriptor());
   }

   public int getMode() {
      return this.field_3100;
   }

   public OutputStream getOutputStream() {
      return new FileOutputStream(this.field_3099.getFileDescriptor());
   }

   public ParcelFileDescriptor getParcelFileDescriptor() {
      return this.field_3099;
   }

   public int getRequestId() {
      return this.field_3103;
   }

   // $FF: renamed from: ip () boolean
   public boolean method_4002() {
      return this.field_3102;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_684.method_3868(this, var1, var2);
   }
}
