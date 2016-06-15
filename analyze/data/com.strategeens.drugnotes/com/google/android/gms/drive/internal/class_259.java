package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.internal.GetMetadataRequest;
import com.google.android.gms.drive.internal.ListParentsRequest;
import com.google.android.gms.drive.internal.OnListParentsResponse;
import com.google.android.gms.drive.internal.OnMetadataResponse;
import com.google.android.gms.drive.internal.SetResourceParentsRequest;
import com.google.android.gms.drive.internal.UpdateMetadataRequest;
import com.google.android.gms.drive.internal.class_205;
import com.google.android.gms.drive.internal.class_267;
import com.google.android.gms.drive.internal.class_268;
import com.google.android.gms.drive.internal.class_279;
import com.google.android.gms.drive.internal.class_282;
import com.google.android.gms.drive.internal.class_299;
import com.google.android.gms.drive.internal.q;
import java.util.List;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.drive.internal.y
public class class_259 implements DriveResource {
   // $FF: renamed from: Oj com.google.android.gms.drive.DriveId
   protected final DriveId field_542;

   protected class_259(DriveId var1) {
      this.field_542 = var1;
   }

   public PendingResult<Status> addChangeListener(GoogleApiClient var1, ChangeListener var2) {
      return ((class_299)var1.method_941(Drive.field_2928)).method_2072(var1, this.field_542, 1, var2);
   }

   public PendingResult<Status> addChangeSubscription(GoogleApiClient var1) {
      return ((class_299)var1.method_941(Drive.field_2928)).method_2071(var1, this.field_542, 1);
   }

   public DriveId getDriveId() {
      return this.field_542;
   }

   public PendingResult<DriveResource.MetadataResult> getMetadata(final GoogleApiClient var1) {
      return var1.method_942(new class_259.class_1593(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
         protected void method_1295(class_299 var1) throws RemoteException {
            var1.method_2075().method_1040(new GetMetadataRequest(class_259.this.field_542), new class_259.class_1591(this));
         }
      });
   }

   public PendingResult<DriveApi.MetadataBufferResult> listParents(final GoogleApiClient var1) {
      return var1.method_942(new class_282.class_1605(var1) {
         // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
         protected void method_1297(class_299 var1) throws RemoteException {
            var1.method_2075().method_1041(new ListParentsRequest(class_259.this.field_542), new class_259.class_1590(this));
         }
      });
   }

   public PendingResult<Status> removeChangeListener(GoogleApiClient var1, ChangeListener var2) {
      return ((class_299)var1.method_941(Drive.field_2928)).method_2074(var1, this.field_542, 1, var2);
   }

   public PendingResult<Status> removeChangeSubscription(GoogleApiClient var1) {
      return ((class_299)var1.method_941(Drive.field_2928)).method_2073(var1, this.field_542, 1);
   }

   public PendingResult<Status> setParents(final GoogleApiClient var1, Set<DriveId> var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("ParentIds must be provided.");
      } else if(var2.isEmpty()) {
         throw new IllegalArgumentException("ParentIds must contain at least one parent.");
      } else {
         return var1.method_944(new class_205.class_1096(var1) {
            // $FF: renamed from: Qu java.util.List
            // $FF: synthetic field
            final List field_213;

            {
               this.field_213 = var3;
            }

            // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
            protected void method_1304(class_299 var1) throws RemoteException {
               var1.method_2075().method_1048(new SetResourceParentsRequest(class_259.this.field_542, this.field_213), new class_268(this));
            }
         });
      }
   }

   public PendingResult<DriveResource.MetadataResult> updateMetadata(final GoogleApiClient var1, final MetadataChangeSet var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("ChangeSet must be provided.");
      } else {
         return var1.method_944(new class_259.class_1593(var1, null) {
            // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
            protected void method_1294(class_299 var1) throws RemoteException {
               var2.method_3001().setContext(var1.getContext());
               var1.method_2075().method_1050(new UpdateMetadataRequest(class_259.this.field_542, var2.method_3001()), new class_259.class_1591(this));
            }
         });
      }
   }

   private static class class_1590 extends class_267 {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<DriveApi.MetadataBufferResult> field_548;

      public class_1590(BaseImplementation.class_1058<DriveApi.MetadataBufferResult> var1) {
         this.field_548 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OnListParentsResponse) void
      public void method_1018(OnListParentsResponse var1) throws RemoteException {
         MetadataBuffer var2 = new MetadataBuffer(var1.method_3028(), (String)null);
         this.field_548.method_110(new class_282.class_1604(Status.field_3960, var2, false));
      }

      // $FF: renamed from: n (com.google.android.gms.common.api.Status) void
      public void method_1024(Status var1) throws RemoteException {
         this.field_548.method_110(new class_282.class_1604(var1, (MetadataBuffer)null, false));
      }
   }

   private static class class_1591 extends class_267 {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<DriveResource.MetadataResult> field_547;

      public class_1591(BaseImplementation.class_1058<DriveResource.MetadataResult> var1) {
         this.field_547 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.drive.internal.OnMetadataResponse) void
      public void method_1020(OnMetadataResponse var1) throws RemoteException {
         this.field_547.method_110(new class_259.class_1592(Status.field_3960, new class_279(var1.method_5866())));
      }

      // $FF: renamed from: n (com.google.android.gms.common.api.Status) void
      public void method_1024(Status var1) throws RemoteException {
         this.field_547.method_110(new class_259.class_1592(var1, (Metadata)null));
      }
   }

   private static class class_1592 implements DriveResource.MetadataResult {
      // $FF: renamed from: Eb com.google.android.gms.common.api.Status
      private final Status field_4362;
      // $FF: renamed from: Qv com.google.android.gms.drive.Metadata
      private final Metadata field_4363;

      public class_1592(Status var1, Metadata var2) {
         this.field_4362 = var1;
         this.field_4363 = var2;
      }

      public Metadata getMetadata() {
         return this.field_4363;
      }

      public Status getStatus() {
         return this.field_4362;
      }
   }

   private abstract class class_1593 extends q<DriveResource.MetadataResult> {
      private class_1593(GoogleApiClient var2) {
         super(var2);
      }

      // $FF: synthetic method
      class_1593(GoogleApiClient var2, Object var3) {
         this();
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1293(var1);
      }

      // $FF: renamed from: u (com.google.android.gms.common.api.Status) com.google.android.gms.drive.DriveResource$MetadataResult
      public DriveResource.MetadataResult method_1293(Status var1) {
         return new class_259.class_1592(var1, (Metadata)null);
      }
   }
}
