package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.class_797;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.internal.GetMetadataRequest;
import com.google.android.gms.drive.internal.ListParentsRequest;
import com.google.android.gms.drive.internal.OnListParentsResponse;
import com.google.android.gms.drive.internal.OnMetadataResponse;
import com.google.android.gms.drive.internal.UpdateMetadataRequest;
import com.google.android.gms.drive.internal.class_202;
import com.google.android.gms.drive.internal.class_229;
import com.google.android.gms.drive.internal.class_233;
import com.google.android.gms.drive.internal.class_245;
import com.google.android.gms.drive.internal.q;

// $FF: renamed from: com.google.android.gms.drive.internal.v
public class class_214 implements DriveResource {
   // $FF: renamed from: Hw com.google.android.gms.drive.DriveId
   protected final DriveId field_705;

   protected class_214(DriveId var1) {
      this.field_705 = var1;
   }

   public PendingResult<Status> addChangeListener(GoogleApiClient var1, DriveEvent.Listener<ChangeEvent> var2) {
      return ((class_245)var1.method_771(Drive.field_3068)).method_1706(var1, this.field_705, 1, var2);
   }

   public DriveId getDriveId() {
      return this.field_705;
   }

   public PendingResult<DriveResource.MetadataResult> getMetadata(GoogleApiClient var1) {
      return var1.method_772(new class_214.class_901(null) {
         // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
         protected void method_1057(class_245 var1) throws RemoteException {
            var1.method_1708().method_850(new GetMetadataRequest(class_214.this.field_705), new class_214.class_904(this));
         }
      });
   }

   public PendingResult<DriveApi.MetadataBufferResult> listParents(GoogleApiClient var1) {
      return var1.method_772(new class_214.class_905(null) {
         // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
         protected void method_1055(class_245 var1) throws RemoteException {
            var1.method_1708().method_851(new ListParentsRequest(class_214.this.field_705), new class_214.class_900(this));
         }
      });
   }

   public PendingResult<Status> removeChangeListener(GoogleApiClient var1, DriveEvent.Listener<ChangeEvent> var2) {
      return ((class_245)var1.method_771(Drive.field_3068)).method_1707(var1, this.field_705, 1, var2);
   }

   public PendingResult<DriveResource.MetadataResult> updateMetadata(GoogleApiClient var1, final MetadataChangeSet var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("ChangeSet must be provided.");
      } else {
         return var1.method_773(new class_214.class_896(null) {
            // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
            protected void method_1059(class_245 var1) throws RemoteException {
               var1.method_1708().method_858(new UpdateMetadataRequest(class_214.this.field_705, var2.method_2667()), new class_214.class_904(this));
            }
         });
      }
   }

   private abstract class class_901 extends q<DriveResource.MetadataResult> {
      private class_901() {
      }

      // $FF: synthetic method
      class_901(Object var2) {
         this();
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_1056(var1);
      }

      // $FF: renamed from: u (com.google.android.gms.common.api.Status) com.google.android.gms.drive.DriveResource$MetadataResult
      public DriveResource.MetadataResult method_1056(Status var1) {
         return new class_214.class_897(var1, (Metadata)null);
      }
   }

   private static class class_900 extends class_202 {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<DriveApi.MetadataBufferResult> field_662;

      public class_900(class_797.class_1206<DriveApi.MetadataBufferResult> var1) {
         this.field_662 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OnListParentsResponse) void
      public void method_829(OnListParentsResponse var1) throws RemoteException {
         MetadataBuffer var2 = new MetadataBuffer(var1.method_3449(), (String)null);
         this.field_662.method_673(new class_233.class_1238(Status.field_3880, var2, false));
      }

      // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
      public void method_835(Status var1) throws RemoteException {
         this.field_662.method_673(new class_233.class_1238(var1, (MetadataBuffer)null, false));
      }
   }

   private abstract class class_905 extends q<DriveApi.MetadataBufferResult> {
      private class_905() {
      }

      // $FF: synthetic method
      class_905(Object var2) {
         this();
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_1054(var1);
      }

      // $FF: renamed from: r (com.google.android.gms.common.api.Status) com.google.android.gms.drive.DriveApi$MetadataBufferResult
      public DriveApi.MetadataBufferResult method_1054(Status var1) {
         return new class_233.class_1238(var1, (MetadataBuffer)null, false);
      }
   }

   private static class class_904 extends class_202 {
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<DriveResource.MetadataResult> field_661;

      public class_904(class_797.class_1206<DriveResource.MetadataResult> var1) {
         this.field_661 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OnMetadataResponse) void
      public void method_831(OnMetadataResponse var1) throws RemoteException {
         this.field_661.method_673(new class_214.class_897(Status.field_3880, new class_229(var1.method_4602())));
      }

      // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
      public void method_835(Status var1) throws RemoteException {
         this.field_661.method_673(new class_214.class_897(var1, (Metadata)null));
      }
   }

   private static class class_897 implements DriveResource.MetadataResult {
      // $FF: renamed from: Jj com.google.android.gms.drive.Metadata
      private final Metadata field_2127;
      // $FF: renamed from: yw com.google.android.gms.common.api.Status
      private final Status field_2128;

      public class_897(Status var1, Metadata var2) {
         this.field_2128 = var1;
         this.field_2127 = var2;
      }

      public Metadata getMetadata() {
         return this.field_2127;
      }

      public Status getStatus() {
         return this.field_2128;
      }
   }

   private abstract class class_896 extends q<DriveResource.MetadataResult> {
      private class_896() {
      }

      // $FF: synthetic method
      class_896(Object var2) {
         this();
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_1058(var1);
      }

      // $FF: renamed from: u (com.google.android.gms.common.api.Status) com.google.android.gms.drive.DriveResource$MetadataResult
      public DriveResource.MetadataResult method_1058(Status var1) {
         return new class_214.class_897(var1, (Metadata)null);
      }
   }
}
