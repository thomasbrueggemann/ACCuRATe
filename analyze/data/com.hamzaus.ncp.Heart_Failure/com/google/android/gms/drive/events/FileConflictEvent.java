package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.class_589;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.ArrayList;

public final class FileConflictEvent implements SafeParcelable, DriveEvent {
   public static final Creator<FileConflictEvent> CREATOR = new class_589();
   // $FF: renamed from: Hw com.google.android.gms.drive.DriveId
   final DriveId field_4345;
   // $FF: renamed from: Ig android.os.ParcelFileDescriptor
   final ParcelFileDescriptor field_4346;
   // $FF: renamed from: Ih android.os.ParcelFileDescriptor
   final ParcelFileDescriptor field_4347;
   // $FF: renamed from: Ii com.google.android.gms.drive.metadata.internal.MetadataBundle
   final MetadataBundle field_4348;
   // $FF: renamed from: Ij java.util.ArrayList
   final ArrayList<String> field_4349;
   // $FF: renamed from: Ik boolean
   private boolean field_4350 = false;
   // $FF: renamed from: Il boolean
   private boolean field_4351 = false;
   // $FF: renamed from: Im boolean
   private boolean field_4352 = false;
   // $FF: renamed from: xJ int
   final int field_4353;
   // $FF: renamed from: yN java.lang.String
   final String field_4354;

   FileConflictEvent(int var1, DriveId var2, String var3, ParcelFileDescriptor var4, ParcelFileDescriptor var5, MetadataBundle var6, ArrayList<String> var7) {
      this.field_4353 = var1;
      this.field_4345 = var2;
      this.field_4354 = var3;
      this.field_4346 = var4;
      this.field_4347 = var5;
      this.field_4348 = var6;
      this.field_4349 = var7;
   }

   public int describeContents() {
      return 0;
   }

   public DriveId getDriveId() {
      return this.field_4345;
   }

   public int getType() {
      return 2;
   }

   public String toString() {
      Object[] var1 = new Object[]{this.field_4345};
      return String.format("FileConflictEvent [id=%s]", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_589.method_3318(this, var1, var2);
   }
}
