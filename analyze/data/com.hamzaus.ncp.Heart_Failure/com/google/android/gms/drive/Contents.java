package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.class_582;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Contents implements SafeParcelable {
   public static final Creator<Contents> CREATOR = new class_582();
   // $FF: renamed from: Fg android.os.ParcelFileDescriptor
   final ParcelFileDescriptor field_3130;
   // $FF: renamed from: HA boolean
   private boolean field_3131 = false;
   // $FF: renamed from: HB boolean
   private boolean field_3132 = false;
   // $FF: renamed from: Hv int
   final int field_3133;
   // $FF: renamed from: Hw com.google.android.gms.drive.DriveId
   final DriveId field_3134;
   // $FF: renamed from: Hx java.lang.String
   String field_3135;
   // $FF: renamed from: Hy boolean
   boolean field_3136;
   // $FF: renamed from: Hz boolean
   private boolean field_3137 = false;
   private boolean mClosed = false;
   // $FF: renamed from: qX int
   final int field_3138;
   // $FF: renamed from: xJ int
   final int field_3139;

   Contents(int var1, ParcelFileDescriptor var2, int var3, int var4, DriveId var5, String var6, boolean var7) {
      this.field_3139 = var1;
      this.field_3130 = var2;
      this.field_3138 = var3;
      this.field_3133 = var4;
      this.field_3134 = var5;
      this.field_3135 = var6;
      this.field_3136 = var7;
   }

   public void close() {
      this.mClosed = true;
   }

   public int describeContents() {
      return 0;
   }

   public DriveId getDriveId() {
      return this.field_3134;
   }

   public InputStream getInputStream() {
      if(this.mClosed) {
         throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
      } else if(this.field_3133 != 268435456) {
         throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
      } else if(this.field_3137) {
         throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
      } else {
         this.field_3137 = true;
         return new FileInputStream(this.field_3130.getFileDescriptor());
      }
   }

   public int getMode() {
      return this.field_3133;
   }

   public OutputStream getOutputStream() {
      if(this.mClosed) {
         throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
      } else if(this.field_3133 != 536870912) {
         throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
      } else if(this.field_3131) {
         throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
      } else {
         this.field_3131 = true;
         return new FileOutputStream(this.field_3130.getFileDescriptor());
      }
   }

   public ParcelFileDescriptor getParcelFileDescriptor() {
      if(this.mClosed) {
         throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
      } else {
         return this.field_3130;
      }
   }

   public int getRequestId() {
      return this.field_3138;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_582.method_3261(this, var1, var2);
   }
}
