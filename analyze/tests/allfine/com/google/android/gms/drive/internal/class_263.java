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
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.internal.GetMetadataRequest;
import com.google.android.gms.drive.internal.ListParentsRequest;
import com.google.android.gms.drive.internal.OnListParentsResponse;
import com.google.android.gms.drive.internal.OnMetadataResponse;
import com.google.android.gms.drive.internal.SetResourceParentsRequest;
import com.google.android.gms.drive.internal.UpdateMetadataRequest;
import com.google.android.gms.drive.internal.class_211;
import com.google.android.gms.drive.internal.class_276;
import com.google.android.gms.drive.internal.class_277;
import com.google.android.gms.drive.internal.class_287;
import com.google.android.gms.drive.internal.class_290;
import com.google.android.gms.drive.internal.class_305;
import com.google.android.gms.drive.internal.p;
import java.util.List;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.drive.internal.w
public class class_263 implements DriveResource {
    // $FF: renamed from: MW com.google.android.gms.drive.DriveId
    protected final DriveId field_787;

    protected class_263(DriveId var1) {
        this.field_787 = var1;
    }

    public PendingResult<Status> addChangeListener(GoogleApiClient var1, ChangeListener var2) {
        return ((class_305)var1.method_896(Drive.field_3554)).method_2088(var1, this.field_787, 1, var2);
    }

    public PendingResult<Status> addChangeListener(GoogleApiClient var1, DriveEvent.Listener<ChangeEvent> var2) {
        return ((class_305)var1.method_896(Drive.field_3554)).method_2088(var1, this.field_787, 1, var2);
    }

    public PendingResult<Status> addChangeSubscription(GoogleApiClient var1) {
        return ((class_305)var1.method_896(Drive.field_3554)).method_2087(var1, this.field_787, 1);
    }

    public DriveId getDriveId() {
        return this.field_787;
    }

    public PendingResult<DriveResource.MetadataResult> getMetadata(GoogleApiClient var1) {
        return var1.method_897(new class_263.class_1486(null) {
            // $FF: renamed from: a (com.google.android.gms.drive.internal.q) void
            protected void method_1315(class_305 var1) throws RemoteException {
                var1.method_2091().method_1027(new GetMetadataRequest(class_263.this.field_787), new class_263.class_1485(this));
            }
        });
    }

    public PendingResult<DriveApi.MetadataBufferResult> listParents(GoogleApiClient var1) {
        return var1.method_897(new class_290.class_1727() {
            // $FF: renamed from: a (com.google.android.gms.drive.internal.q) void
            protected void method_1312(class_305 var1) throws RemoteException {
                var1.method_2091().method_1028(new ListParentsRequest(class_263.this.field_787), new class_263.class_1483(this));
            }
        });
    }

    public PendingResult<Status> removeChangeListener(GoogleApiClient var1, ChangeListener var2) {
        return ((class_305)var1.method_896(Drive.field_3554)).method_2090(var1, this.field_787, 1, var2);
    }

    public PendingResult<Status> removeChangeListener(GoogleApiClient var1, DriveEvent.Listener<ChangeEvent> var2) {
        return ((class_305)var1.method_896(Drive.field_3554)).method_2090(var1, this.field_787, 1, var2);
    }

    public PendingResult<Status> removeChangeSubscription(GoogleApiClient var1) {
        return ((class_305)var1.method_896(Drive.field_3554)).method_2089(var1, this.field_787, 1);
    }

    public PendingResult<Status> setParents(GoogleApiClient var1, Set<DriveId> var2) {
        if(var2 == null) {
            throw new IllegalArgumentException("ParentIds must be provided.");
        } else if(var2.isEmpty()) {
            throw new IllegalArgumentException("ParentIds must contain at least one parent.");
        } else {
            return var1.method_899(new class_211.class_1699() {
                // $FF: renamed from: Pc java.util.List
                // $FF: synthetic field
                final List field_236;

                {
                    this.field_236 = var2;
                }

                // $FF: renamed from: a (com.google.android.gms.drive.internal.q) void
                protected void method_1309(class_305 var1) throws RemoteException {
                    var1.method_2091().method_1034(new SetResourceParentsRequest(class_263.this.field_787, this.field_236), new class_277(this));
                }
            });
        }
    }

    public PendingResult<DriveResource.MetadataResult> updateMetadata(GoogleApiClient var1, final MetadataChangeSet var2) {
        if(var2 == null) {
            throw new IllegalArgumentException("ChangeSet must be provided.");
        } else {
            return var1.method_899(new class_263.class_1486(null) {
                // $FF: renamed from: a (com.google.android.gms.drive.internal.q) void
                protected void method_1314(class_305 var1) throws RemoteException {
                    var2.method_2945().setContext(var1.getContext());
                    var1.method_2091().method_1036(new UpdateMetadataRequest(class_263.this.field_787, var2.method_2945()), new class_263.class_1485(this));
                }
            });
        }
    }

    private static class class_1483 extends class_276 {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<DriveApi.MetadataBufferResult> field_844;

        public class_1483(BaseImplementation.class_1147<DriveApi.MetadataBufferResult> var1) {
            this.field_844 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.OnListParentsResponse) void
        public void method_1006(OnListParentsResponse var1) throws RemoteException {
            MetadataBuffer var2 = new MetadataBuffer(var1.method_2998(), (String)null);
            this.field_844.method_120(new class_290.class_1726(Status.field_4739, var2, false));
        }

        // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
        public void method_1012(Status var1) throws RemoteException {
            this.field_844.method_120(new class_290.class_1726(var1, (MetadataBuffer)null, false));
        }
    }

    private static class class_1485 extends class_276 {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<DriveResource.MetadataResult> field_843;

        public class_1485(BaseImplementation.class_1147<DriveResource.MetadataResult> var1) {
            this.field_843 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.drive.internal.OnMetadataResponse) void
        public void method_1008(OnMetadataResponse var1) throws RemoteException {
            this.field_843.method_120(new class_263.class_1484(Status.field_4739, new class_287(var1.method_6021())));
        }

        // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
        public void method_1012(Status var1) throws RemoteException {
            this.field_843.method_120(new class_263.class_1484(var1, (Metadata)null));
        }
    }

    private static class class_1484 implements DriveResource.MetadataResult {
        // $FF: renamed from: CM com.google.android.gms.common.api.Status
        private final Status field_3214;
        // $FF: renamed from: Pd com.google.android.gms.drive.Metadata
        private final Metadata field_3215;

        public class_1484(Status var1, Metadata var2) {
            this.field_3214 = var1;
            this.field_3215 = var2;
        }

        public Metadata getMetadata() {
            return this.field_3215;
        }

        public Status getStatus() {
            return this.field_3214;
        }
    }

    private abstract class class_1486 extends p<DriveResource.MetadataResult> {
        private class_1486() {
        }

        // $FF: synthetic method
        class_1486(Object var2) {
            this();
        }

        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1313(var1);
        }

        // $FF: renamed from: v (com.google.android.gms.common.api.Status) com.google.android.gms.drive.DriveResource$MetadataResult
        public DriveResource.MetadataResult method_1313(Status var1) {
            return new class_263.class_1484(var1, (Metadata)null);
        }
    }
}
