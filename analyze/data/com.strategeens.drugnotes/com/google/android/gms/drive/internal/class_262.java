package com.google.android.gms.drive.internal;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest;
import com.google.android.gms.drive.internal.CloseContentsRequest;
import com.google.android.gms.drive.internal.OpenContentsRequest;
import com.google.android.gms.drive.internal.class_205;
import com.google.android.gms.drive.internal.class_265;
import com.google.android.gms.drive.internal.class_268;
import com.google.android.gms.drive.internal.class_269;
import com.google.android.gms.drive.internal.class_282;
import com.google.android.gms.drive.internal.class_299;
import com.google.android.gms.internal.class_335;
import java.io.InputStream;
import java.io.OutputStream;

// $FF: renamed from: com.google.android.gms.drive.internal.s
public class class_262 implements DriveContents {
   // $FF: renamed from: PW com.google.android.gms.drive.Contents
   private final Contents field_543;
   // $FF: renamed from: PX boolean
   private boolean field_544 = false;
   // $FF: renamed from: PY boolean
   private boolean field_545 = false;
   private boolean mClosed = false;

   public class_262(Contents var1) {
      this.field_543 = (Contents)class_335.method_2311(var1);
   }

   public PendingResult<Status> commit(GoogleApiClient var1, MetadataChangeSet var2) {
      return this.commit(var1, var2, (ExecutionOptions)null);
   }

   public PendingResult<Status> commit(final GoogleApiClient var1, final MetadataChangeSet var2, final ExecutionOptions var3) {
      if(var3 == null) {
         var3 = (new ExecutionOptions.Builder()).build();
      }

      if(this.field_543.getMode() == 268435456) {
         throw new IllegalStateException("Cannot commit contents opened with MODE_READ_ONLY");
      } else if(ExecutionOptions.method_4306(var3.method_4311()) && !this.field_543.method_4002()) {
         throw new IllegalStateException("DriveContents must be valid for conflict detection.");
      } else {
         ExecutionOptions.method_4305(var1, var3);
         if(this.method_952()) {
            throw new IllegalStateException("DriveContents already closed.");
         } else if(this.getDriveId() == null) {
            throw new IllegalStateException("Only DriveContents obtained through DriveFile.open can be committed.");
         } else {
            if(var2 == null) {
               var2 = MetadataChangeSet.field_1610;
            }

            this.method_951();
            return var1.method_944(new class_205.class_1096(var1) {
               // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
               protected void method_1308(class_299 var1) throws RemoteException {
                  var2.method_3001().setContext(var1.getContext());
                  var1.method_2075().method_1032(new CloseContentsAndUpdateMetadataRequest(class_262.this.field_543.getDriveId(), var2.method_3001(), class_262.this.field_543, var3), new class_268(this));
               }
            });
         }
      }
   }

   public void discard(final GoogleApiClient var1) {
      if(this.method_952()) {
         throw new IllegalStateException("DriveContents already closed.");
      } else {
         this.method_951();
         ((<undefinedtype>)var1.method_944(new class_205.class_1096(var1) {
            // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
            protected void method_1309(class_299 var1) throws RemoteException {
               var1.method_2075().method_1033(new CloseContentsRequest(class_262.this.field_543, false), new class_268(this));
            }
         })).setResultCallback(new ResultCallback() {
            // $FF: renamed from: j (com.google.android.gms.common.api.Status) void
            public void method_5356(Status var1) {
               if(!var1.isSuccess()) {
                  class_265.method_1704("DriveContentsImpl", "Error discarding contents");
               } else {
                  class_265.method_1702("DriveContentsImpl", "Contents discarded");
               }
            }

            // $FF: synthetic method
            public void onResult(Result var1) {
               this.method_5356((Status)var1);
            }
         });
      }
   }

   public DriveId getDriveId() {
      return this.field_543.getDriveId();
   }

   public InputStream getInputStream() {
      if(this.method_952()) {
         throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
      } else if(this.field_543.getMode() != 268435456) {
         throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
      } else if(this.field_544) {
         throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
      } else {
         this.field_544 = true;
         return this.field_543.getInputStream();
      }
   }

   public int getMode() {
      return this.field_543.getMode();
   }

   public OutputStream getOutputStream() {
      if(this.method_952()) {
         throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
      } else if(this.field_543.getMode() != 536870912) {
         throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
      } else if(this.field_545) {
         throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
      } else {
         this.field_545 = true;
         return this.field_543.getOutputStream();
      }
   }

   public ParcelFileDescriptor getParcelFileDescriptor() {
      if(this.method_952()) {
         throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
      } else {
         return this.field_543.getParcelFileDescriptor();
      }
   }

   // $FF: renamed from: ir () com.google.android.gms.drive.Contents
   public Contents method_950() {
      return this.field_543;
   }

   // $FF: renamed from: is () void
   public void method_951() {
      this.mClosed = true;
   }

   // $FF: renamed from: it () boolean
   public boolean method_952() {
      return this.mClosed;
   }

   public PendingResult<DriveApi.DriveContentsResult> reopenForWrite(final GoogleApiClient var1) {
      if(this.method_952()) {
         throw new IllegalStateException("DriveContents already closed.");
      } else if(this.field_543.getMode() != 268435456) {
         throw new IllegalStateException("reopenForWrite can only be used with DriveContents opened with MODE_READ_ONLY.");
      } else {
         this.method_951();
         return var1.method_942(new class_282.class_1600(var1) {
            // $FF: renamed from: a (com.google.android.gms.drive.internal.r) void
            protected void method_1317(class_299 var1) throws RemoteException {
               var1.method_2075().method_1043(new OpenContentsRequest(class_262.this.getDriveId(), 536870912, class_262.this.field_543.getRequestId()), new class_269(this, (DriveFile.DownloadProgressListener)null));
            }
         });
      }
   }
}
