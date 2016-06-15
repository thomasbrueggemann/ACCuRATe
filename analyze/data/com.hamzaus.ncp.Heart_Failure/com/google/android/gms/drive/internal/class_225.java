package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.CreateFileIntentSenderRequest;
import com.google.android.gms.drive.internal.class_154;
import com.google.android.gms.drive.internal.class_245;
import com.google.android.gms.internal.class_347;

// $FF: renamed from: com.google.android.gms.drive.internal.h
public class class_225 {
   // $FF: renamed from: HV java.lang.String
   private String field_711;
   // $FF: renamed from: HX com.google.android.gms.drive.DriveId
   private DriveId field_712;
   // $FF: renamed from: Ix com.google.android.gms.drive.MetadataChangeSet
   protected MetadataChangeSet field_713;
   // $FF: renamed from: Iy java.lang.Integer
   private Integer field_714;
   // $FF: renamed from: Iz int
   private final int field_715;

   public class_225(int var1) {
      this.field_715 = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.drive.DriveId) void
   public void method_1402(DriveId var1) {
      this.field_712 = (DriveId)class_347.method_2170(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.drive.MetadataChangeSet) void
   public void method_1403(MetadataChangeSet var1) {
      this.field_713 = (MetadataChangeSet)class_347.method_2170(var1);
   }

   // $FF: renamed from: aM (java.lang.String) void
   public void method_1404(String var1) {
      this.field_711 = (String)class_347.method_2170(var1);
   }

   // $FF: renamed from: aS (int) void
   public void method_1405(int var1) {
      this.field_714 = Integer.valueOf(var1);
   }

   public IntentSender build(GoogleApiClient var1) {
      class_347.method_2166(this.field_713, "Must provide initial metadata to CreateFileActivityBuilder.");
      class_347.method_2161(var1.isConnected(), "Client must be connected");
      class_154 var3 = ((class_245)var1.method_771(Drive.field_3068)).method_1708();
      int var4;
      if(this.field_714 == null) {
         var4 = -1;
      } else {
         var4 = this.field_714.intValue();
      }

      try {
         IntentSender var6 = var3.method_836(new CreateFileIntentSenderRequest(this.field_713.method_2667(), var4, this.field_711, this.field_712, this.field_715));
         return var6;
      } catch (RemoteException var7) {
         throw new RuntimeException("Unable to connect Drive Play Service", var7);
      }
   }
}
