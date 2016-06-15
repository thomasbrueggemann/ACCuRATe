package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.CreateFileIntentSenderRequest;
import com.google.android.gms.drive.internal.class_299;
import com.google.android.gms.internal.class_335;

// $FF: renamed from: com.google.android.gms.drive.internal.i
public class class_275 {
   // $FF: renamed from: OH java.lang.String
   private String field_571;
   // $FF: renamed from: OJ com.google.android.gms.drive.DriveId
   private DriveId field_572;
   // $FF: renamed from: Pu com.google.android.gms.drive.MetadataChangeSet
   protected MetadataChangeSet field_573;
   // $FF: renamed from: Pv java.lang.Integer
   private Integer field_574;
   // $FF: renamed from: Pw int
   private final int field_575;

   public class_275(int var1) {
      this.field_575 = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.drive.DriveId) void
   public void method_1744(DriveId var1) {
      this.field_572 = (DriveId)class_335.method_2311(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.drive.MetadataChangeSet) void
   public void method_1745(MetadataChangeSet var1) {
      this.field_573 = (MetadataChangeSet)class_335.method_2311(var1);
   }

   // $FF: renamed from: bl (java.lang.String) void
   public void method_1746(String var1) {
      this.field_571 = (String)class_335.method_2311(var1);
   }

   // $FF: renamed from: bq (int) void
   public void method_1747(int var1) {
      this.field_574 = Integer.valueOf(var1);
   }

   public IntentSender build(GoogleApiClient var1) {
      class_335.method_2306(this.field_573, "Must provide initial metadata to CreateFileActivityBuilder.");
      class_335.method_2302(var1.isConnected(), "Client must be connected");
      class_299 var3 = (class_299)var1.method_941(Drive.field_2928);
      this.field_573.method_3001().setContext(var3.getContext());
      int var4;
      if(this.field_574 == null) {
         var4 = -1;
      } else {
         var4 = this.field_574.intValue();
      }

      try {
         IntentSender var6 = var3.method_2075().method_1025(new CreateFileIntentSenderRequest(this.field_573.method_3001(), var4, this.field_571, this.field_572, this.field_575));
         return var6;
      } catch (RemoteException var7) {
         throw new RuntimeException("Unable to connect Drive Play Service", var7);
      }
   }
}
