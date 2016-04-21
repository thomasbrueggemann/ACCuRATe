package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.internal.class_210;
import com.google.android.gms.wearable.internal.class_292;
import java.io.InputStream;

// $FF: renamed from: com.google.android.gms.wearable.internal.f
public final class class_992 implements DataApi {
    // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.wearable.DataApi$DataListener, android.content.IntentFilter[]) com.google.android.gms.common.api.PendingResult
    private PendingResult<Status> method_5209(GoogleApiClient var1, final DataApi.DataListener var2, final IntentFilter[] var3) {
        return var1.method_897(new class_210() {
            // $FF: renamed from: a (com.google.android.gms.wearable.internal.aw) void
            protected void method_1181(class_292 var1) throws RemoteException {
                var1.method_1828(this, var2, var3);
            }

            // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
            // $FF: synthetic method
            public Result method_1104(Status var1) {
                return this.method_1182(var1);
            }

            // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
            public Status method_1182(Status var1) {
                return new Status(13);
            }
        });
    }

    // $FF: renamed from: a (com.google.android.gms.wearable.Asset) void
    private void method_5210(Asset var1) {
        if(var1 == null) {
            throw new IllegalArgumentException("asset is null");
        } else if(var1.getDigest() == null) {
            throw new IllegalArgumentException("invalid asset");
        } else if(var1.getData() != null) {
            throw new IllegalArgumentException("invalid asset");
        }
    }

    public PendingResult<Status> addListener(GoogleApiClient var1, DataApi.DataListener var2) {
        return this.method_5209(var1, var2, (IntentFilter[])null);
    }

    public PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(GoogleApiClient var1, final Uri var2) {
        return var1.method_897(new class_210() {
            // $FF: renamed from: a (com.google.android.gms.wearable.internal.aw) void
            protected void method_1187(class_292 var1) throws RemoteException {
                var1.method_1839(this, var2);
            }

            // $FF: renamed from: aH (com.google.android.gms.common.api.Status) com.google.android.gms.wearable.DataApi$DeleteDataItemsResult
            protected DataApi.DeleteDataItemsResult method_1188(Status var1) {
                return new class_992.class_1642(var1, 0);
            }

            // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
            // $FF: synthetic method
            protected Result method_1104(Status var1) {
                return this.method_1188(var1);
            }
        });
    }

    public PendingResult<DataApi.DataItemResult> getDataItem(GoogleApiClient var1, final Uri var2) {
        return var1.method_897(new class_210() {
            // $FF: renamed from: a (com.google.android.gms.wearable.internal.aw) void
            protected void method_1173(class_292 var1) throws RemoteException {
                var1.method_1825(this, var2);
            }

            // $FF: renamed from: aF (com.google.android.gms.common.api.Status) com.google.android.gms.wearable.DataApi$DataItemResult
            protected DataApi.DataItemResult method_1174(Status var1) {
                return new class_992.class_1644(var1, (DataItem)null);
            }

            // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
            // $FF: synthetic method
            protected Result method_1104(Status var1) {
                return this.method_1174(var1);
            }
        });
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient var1) {
        return var1.method_897(new class_210() {
            // $FF: renamed from: a (com.google.android.gms.wearable.internal.aw) void
            protected void method_1175(class_292 var1) throws RemoteException {
                var1.method_1840(this);
            }

            // $FF: renamed from: aG (com.google.android.gms.common.api.Status) com.google.android.gms.wearable.DataItemBuffer
            protected DataItemBuffer method_1176(Status var1) {
                return new DataItemBuffer(DataHolder.method_5982(var1.getStatusCode()));
            }

            // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
            // $FF: synthetic method
            protected Result method_1104(Status var1) {
                return this.method_1176(var1);
            }
        });
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient var1, final Uri var2) {
        return var1.method_897(new class_210() {
            // $FF: renamed from: a (com.google.android.gms.wearable.internal.aw) void
            protected void method_1189(class_292 var1) throws RemoteException {
                var1.method_1836(this, var2);
            }

            // $FF: renamed from: aG (com.google.android.gms.common.api.Status) com.google.android.gms.wearable.DataItemBuffer
            protected DataItemBuffer method_1190(Status var1) {
                return new DataItemBuffer(DataHolder.method_5982(var1.getStatusCode()));
            }

            // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
            // $FF: synthetic method
            protected Result method_1104(Status var1) {
                return this.method_1190(var1);
            }
        });
    }

    public PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient var1, final Asset var2) {
        this.method_5210(var2);
        return var1.method_897(new class_210() {
            // $FF: renamed from: a (com.google.android.gms.wearable.internal.aw) void
            protected void method_1185(class_292 var1) throws RemoteException {
                var1.method_1826(this, var2);
            }

            // $FF: renamed from: aI (com.google.android.gms.common.api.Status) com.google.android.gms.wearable.DataApi$GetFdForAssetResult
            protected DataApi.GetFdForAssetResult method_1186(Status var1) {
                return new class_992.class_1643(var1, (ParcelFileDescriptor)null);
            }

            // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
            // $FF: synthetic method
            protected Result method_1104(Status var1) {
                return this.method_1186(var1);
            }
        });
    }

    public PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient var1, final DataItemAsset var2) {
        return var1.method_897(new class_210() {
            // $FF: renamed from: a (com.google.android.gms.wearable.internal.aw) void
            protected void method_1183(class_292 var1) throws RemoteException {
                var1.method_1829(this, var2);
            }

            // $FF: renamed from: aI (com.google.android.gms.common.api.Status) com.google.android.gms.wearable.DataApi$GetFdForAssetResult
            protected DataApi.GetFdForAssetResult method_1184(Status var1) {
                return new class_992.class_1643(var1, (ParcelFileDescriptor)null);
            }

            // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
            // $FF: synthetic method
            protected Result method_1104(Status var1) {
                return this.method_1184(var1);
            }
        });
    }

    public PendingResult<DataApi.DataItemResult> putDataItem(GoogleApiClient var1, final PutDataRequest var2) {
        return var1.method_897(new class_210() {
            // $FF: renamed from: a (com.google.android.gms.wearable.internal.aw) void
            protected void method_1177(class_292 var1) throws RemoteException {
                var1.method_1833(this, var2);
            }

            // $FF: renamed from: aF (com.google.android.gms.common.api.Status) com.google.android.gms.wearable.DataApi$DataItemResult
            public DataApi.DataItemResult method_1178(Status var1) {
                return new class_992.class_1644(var1, (DataItem)null);
            }

            // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
            // $FF: synthetic method
            public Result method_1104(Status var1) {
                return this.method_1178(var1);
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient var1, final DataApi.DataListener var2) {
        return var1.method_897(new class_210() {
            // $FF: renamed from: a (com.google.android.gms.wearable.internal.aw) void
            protected void method_1179(class_292 var1) throws RemoteException {
                var1.method_1827(this, var2);
            }

            // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
            // $FF: synthetic method
            public Result method_1104(Status var1) {
                return this.method_1180(var1);
            }

            // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
            public Status method_1180(Status var1) {
                return new Status(13);
            }
        });
    }

    public static class class_1644 implements DataApi.DataItemResult {
        // $FF: renamed from: CM com.google.android.gms.common.api.Status
        private final Status field_3924;
        private final DataItem avs;

        public class_1644(Status var1, DataItem var2) {
            this.field_3924 = var1;
            this.avs = var2;
        }

        public DataItem getDataItem() {
            return this.avs;
        }

        public Status getStatus() {
            return this.field_3924;
        }
    }

    public static class class_1642 implements DataApi.DeleteDataItemsResult {
        // $FF: renamed from: CM com.google.android.gms.common.api.Status
        private final Status field_3921;
        private final int avt;

        public class_1642(Status var1, int var2) {
            this.field_3921 = var1;
            this.avt = var2;
        }

        public int getNumDeleted() {
            return this.avt;
        }

        public Status getStatus() {
            return this.field_3921;
        }
    }

    public static class class_1643 implements DataApi.GetFdForAssetResult {
        // $FF: renamed from: CM com.google.android.gms.common.api.Status
        private final Status field_3922;
        // $FF: renamed from: XX java.io.InputStream
        private volatile InputStream field_3923;
        private volatile ParcelFileDescriptor avu;
        private volatile boolean mClosed = false;

        public class_1643(Status var1, ParcelFileDescriptor var2) {
            this.field_3922 = var1;
            this.avu = var2;
        }

        public ParcelFileDescriptor getFd() {
            if(this.mClosed) {
                throw new IllegalStateException("Cannot access the file descriptor after release().");
            } else {
                return this.avu;
            }
        }

        public InputStream getInputStream() {
            if(this.mClosed) {
                throw new IllegalStateException("Cannot access the input stream after release().");
            } else if(this.avu == null) {
                return null;
            } else {
                if(this.field_3923 == null) {
                    this.field_3923 = new AutoCloseInputStream(this.avu);
                }

                return this.field_3923;
            }
        }

        public Status getStatus() {
            return this.field_3922;
        }

        public void release() {
            // $FF: Couldn't be decompiled
        }
    }
}
