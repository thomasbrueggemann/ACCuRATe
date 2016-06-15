package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ResourceEvent;
import com.google.android.gms.drive.events.class_692;
import com.google.android.gms.drive.internal.class_189;
import com.google.android.gms.drive.internal.class_265;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.class_715;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class CompletionEvent implements SafeParcelable, ResourceEvent {
   public static final Creator<CompletionEvent> CREATOR = new class_692();
   public static final int STATUS_CANCELED = 3;
   public static final int STATUS_CONFLICT = 2;
   public static final int STATUS_FAILURE = 1;
   public static final int STATUS_SUCCESS;
   // $FF: renamed from: CK int
   final int field_510;
   // $FF: renamed from: DZ java.lang.String
   final String field_511;
   // $FF: renamed from: FP int
   final int field_512;
   // $FF: renamed from: OY android.os.ParcelFileDescriptor
   final ParcelFileDescriptor field_513;
   // $FF: renamed from: OZ android.os.ParcelFileDescriptor
   final ParcelFileDescriptor field_514;
   // $FF: renamed from: Oj com.google.android.gms.drive.DriveId
   final DriveId field_515;
   // $FF: renamed from: Pa com.google.android.gms.drive.metadata.internal.MetadataBundle
   final MetadataBundle field_516;
   // $FF: renamed from: Pb java.util.List
   final List<String> field_517;
   // $FF: renamed from: Pc android.os.IBinder
   final IBinder field_518;
   // $FF: renamed from: Pd boolean
   private boolean field_519 = false;
   // $FF: renamed from: Pe boolean
   private boolean field_520 = false;
   // $FF: renamed from: Pf boolean
   private boolean field_521 = false;

   CompletionEvent(int var1, DriveId var2, String var3, ParcelFileDescriptor var4, ParcelFileDescriptor var5, MetadataBundle var6, List<String> var7, int var8, IBinder var9) {
      this.field_510 = var1;
      this.field_515 = var2;
      this.field_511 = var3;
      this.field_513 = var4;
      this.field_514 = var5;
      this.field_516 = var6;
      this.field_517 = var7;
      this.field_512 = var8;
      this.field_518 = var9;
   }

   // $FF: renamed from: M (boolean) void
   private void method_1637(boolean var1) {
      this.method_1638();
      this.field_521 = true;
      class_715.method_4189(this.field_513);
      class_715.method_4189(this.field_514);
      if(this.field_518 == null) {
         StringBuilder var5 = (new StringBuilder()).append("No callback on ");
         String var6;
         if(var1) {
            var6 = "snooze";
         } else {
            var6 = "dismiss";
         }

         class_265.method_1704("CompletionEvent", var5.append(var6).toString());
      } else {
         try {
            class_189.class_1123.method_5230(this.field_518).method_1010(var1);
         } catch (RemoteException var7) {
            StringBuilder var3 = (new StringBuilder()).append("RemoteException on ");
            String var4;
            if(var1) {
               var4 = "snooze";
            } else {
               var4 = "dismiss";
            }

            class_265.method_1704("CompletionEvent", var3.append(var4).append(": ").append(var7).toString());
         }
      }
   }

   // $FF: renamed from: iC () void
   private void method_1638() {
      if(this.field_521) {
         throw new IllegalStateException("Event has already been dismissed or snoozed.");
      }
   }

   public int describeContents() {
      return 0;
   }

   public void dismiss() {
      this.method_1637(false);
   }

   public String getAccountName() {
      this.method_1638();
      return this.field_511;
   }

   public InputStream getBaseContentsInputStream() {
      this.method_1638();
      if(this.field_513 == null) {
         return null;
      } else if(this.field_519) {
         throw new IllegalStateException("getBaseInputStream() can only be called once per CompletionEvent instance.");
      } else {
         this.field_519 = true;
         return new FileInputStream(this.field_513.getFileDescriptor());
      }
   }

   public DriveId getDriveId() {
      this.method_1638();
      return this.field_515;
   }

   public InputStream getModifiedContentsInputStream() {
      this.method_1638();
      if(this.field_514 == null) {
         return null;
      } else if(this.field_520) {
         throw new IllegalStateException("getModifiedInputStream() can only be called once per CompletionEvent instance.");
      } else {
         this.field_520 = true;
         return new FileInputStream(this.field_514.getFileDescriptor());
      }
   }

   public MetadataChangeSet getModifiedMetadataChangeSet() {
      this.method_1638();
      return this.field_516 != null?new MetadataChangeSet(this.field_516):null;
   }

   public int getStatus() {
      this.method_1638();
      return this.field_512;
   }

   public List<String> getTrackingTags() {
      this.method_1638();
      return new ArrayList(this.field_517);
   }

   public int getType() {
      return 2;
   }

   public void snooze() {
      this.method_1637(true);
   }

   public String toString() {
      String var1;
      if(this.field_517 == null) {
         var1 = "<null>";
      } else {
         var1 = "\'" + TextUtils.join("\',\'", this.field_517) + "\'";
      }

      Locale var2 = Locale.US;
      Object[] var3 = new Object[]{this.field_515, Integer.valueOf(this.field_512), var1};
      return String.format(var2, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", var3);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_692.method_3962(this, var1, var2);
   }
}
