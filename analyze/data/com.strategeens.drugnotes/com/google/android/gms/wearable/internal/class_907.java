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
import com.google.android.gms.wearable.internal.class_203;
import com.google.android.gms.wearable.internal.class_284;
import com.google.android.gms.wearable.internal.d;
import java.io.InputStream;

// $FF: renamed from: com.google.android.gms.wearable.internal.f
public final class class_907 implements DataApi {
   // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.wearable.DataApi$DataListener, android.content.IntentFilter[]) com.google.android.gms.common.api.PendingResult
   private PendingResult<Status> method_5057(GoogleApiClient var1, DataApi.DataListener var2, IntentFilter[] var3) {
      return var1.method_942(new class_907.class_1533(var1, var2, var3, null));
   }

   // $FF: renamed from: a (com.google.android.gms.wearable.Asset) void
   private void method_5058(Asset var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("asset is null");
      } else if(var1.getDigest() == null) {
         throw new IllegalArgumentException("invalid asset");
      } else if(var1.getData() != null) {
         throw new IllegalArgumentException("invalid asset");
      }
   }

   public PendingResult<Status> addListener(GoogleApiClient var1, DataApi.DataListener var2) {
      return this.method_5057(var1, var2, (IntentFilter[])null);
   }

   public PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(final GoogleApiClient var1, final Uri var2) {
      return var1.method_942(new class_203(var1) {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.ba) void
         protected void method_1195(class_284 var1) throws RemoteException {
            var1.method_1814(this, var2);
         }

         // $FF: renamed from: aG (com.google.android.gms.common.api.Status) com.google.android.gms.wearable.DataApi$DeleteDataItemsResult
         protected DataApi.DeleteDataItemsResult method_1196(Status var1) {
            return new class_907.class_1532(var1, 0);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         protected Result method_1109(Status var1) {
            return this.method_1196(var1);
         }
      });
   }

   public PendingResult<DataApi.DataItemResult> getDataItem(final GoogleApiClient var1, final Uri var2) {
      return var1.method_942(new class_203(var1) {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.ba) void
         protected void method_1183(class_284 var1) throws RemoteException {
            var1.method_1802(this, var2);
         }

         // $FF: renamed from: aE (com.google.android.gms.common.api.Status) com.google.android.gms.wearable.DataApi$DataItemResult
         protected DataApi.DataItemResult method_1184(Status var1) {
            return new class_907.class_1531(var1, (DataItem)null);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         protected Result method_1109(Status var1) {
            return this.method_1184(var1);
         }
      });
   }

   public PendingResult<DataItemBuffer> getDataItems(final GoogleApiClient var1) {
      return var1.method_942(new class_203(var1) {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.ba) void
         protected void method_1185(class_284 var1) throws RemoteException {
            var1.method_1816(this);
         }

         // $FF: renamed from: aF (com.google.android.gms.common.api.Status) com.google.android.gms.wearable.DataItemBuffer
         protected DataItemBuffer method_1186(Status var1) {
            return new DataItemBuffer(DataHolder.method_5824(var1.getStatusCode()));
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         protected Result method_1109(Status var1) {
            return this.method_1186(var1);
         }
      });
   }

   public PendingResult<DataItemBuffer> getDataItems(final GoogleApiClient var1, final Uri var2) {
      return var1.method_942(new class_203(var1) {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.ba) void
         protected void method_1197(class_284 var1) throws RemoteException {
            var1.method_1812(this, var2);
         }

         // $FF: renamed from: aF (com.google.android.gms.common.api.Status) com.google.android.gms.wearable.DataItemBuffer
         protected DataItemBuffer method_1198(Status var1) {
            return new DataItemBuffer(DataHolder.method_5824(var1.getStatusCode()));
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         protected Result method_1109(Status var1) {
            return this.method_1198(var1);
         }
      });
   }

   public PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(final GoogleApiClient var1, final Asset var2) {
      this.method_5058(var2);
      return var1.method_942(new class_203(var1) {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.ba) void
         protected void method_1193(class_284 var1) throws RemoteException {
            var1.method_1803(this, var2);
         }

         // $FF: renamed from: aH (com.google.android.gms.common.api.Status) com.google.android.gms.wearable.DataApi$GetFdForAssetResult
         protected DataApi.GetFdForAssetResult method_1194(Status var1) {
            return new class_907.class_1528(var1, (ParcelFileDescriptor)null);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         protected Result method_1109(Status var1) {
            return this.method_1194(var1);
         }
      });
   }

   public PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(final GoogleApiClient var1, final DataItemAsset var2) {
      return var1.method_942(new class_203(var1) {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.ba) void
         protected void method_1191(class_284 var1) throws RemoteException {
            var1.method_1806(this, var2);
         }

         // $FF: renamed from: aH (com.google.android.gms.common.api.Status) com.google.android.gms.wearable.DataApi$GetFdForAssetResult
         protected DataApi.GetFdForAssetResult method_1192(Status var1) {
            return new class_907.class_1528(var1, (ParcelFileDescriptor)null);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         protected Result method_1109(Status var1) {
            return this.method_1192(var1);
         }
      });
   }

   public PendingResult<DataApi.DataItemResult> putDataItem(final GoogleApiClient var1, final PutDataRequest var2) {
      return var1.method_942(new class_203(var1) {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.ba) void
         protected void method_1187(class_284 var1) throws RemoteException {
            var1.method_1810(this, var2);
         }

         // $FF: renamed from: aE (com.google.android.gms.common.api.Status) com.google.android.gms.wearable.DataApi$DataItemResult
         public DataApi.DataItemResult method_1188(Status var1) {
            return new class_907.class_1531(var1, (DataItem)null);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         public Result method_1109(Status var1) {
            return this.method_1188(var1);
         }
      });
   }

   public PendingResult<Status> removeListener(final GoogleApiClient var1, final DataApi.DataListener var2) {
      return var1.method_942(new class_203(var1) {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.ba) void
         protected void method_1189(class_284 var1) throws RemoteException {
            var1.method_1804(this, var2);
         }

         // $FF: renamed from: b (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
         public Status method_1190(Status var1) {
            return var1;
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         public Result method_1109(Status var1) {
            return this.method_1190(var1);
         }
      });
   }

   private static final class class_1533 extends d<Status> {
      private DataApi.DataListener axC;
      private IntentFilter[] axD;

      private class_1533(GoogleApiClient var1, DataApi.DataListener var2, IntentFilter[] var3) {
         super(var1);
         this.axC = var2;
         this.axD = var3;
      }

      // $FF: synthetic method
      class_1533(GoogleApiClient var1, DataApi.DataListener var2, IntentFilter[] var3, Object var4) {
         this(var1, var2, var3);
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.ba) void
      protected void method_1181(class_284 var1) throws RemoteException {
         var1.method_1805(this, this.axC, this.axD);
         this.axC = null;
         this.axD = null;
      }

      // $FF: renamed from: b (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      public Status method_1182(Status var1) {
         this.axC = null;
         this.axD = null;
         return var1;
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1182(var1);
      }
   }

   public static class class_1531 implements DataApi.DataItemResult {
      // $FF: renamed from: Eb com.google.android.gms.common.api.Status
      private final Status field_3104;
      private final DataItem axE;

      public class_1531(Status var1, DataItem var2) {
         this.field_3104 = var1;
         this.axE = var2;
      }

      public DataItem getDataItem() {
         return this.axE;
      }

      public Status getStatus() {
         return this.field_3104;
      }
   }

   public static class class_1532 implements DataApi.DeleteDataItemsResult {
      // $FF: renamed from: Eb com.google.android.gms.common.api.Status
      private final Status field_3105;
      private final int axF;

      public class_1532(Status var1, int var2) {
         this.field_3105 = var1;
         this.axF = var2;
      }

      public int getNumDeleted() {
         return this.axF;
      }

      public Status getStatus() {
         return this.field_3105;
      }
   }

   public static class class_1528 implements DataApi.GetFdForAssetResult {
      // $FF: renamed from: Eb com.google.android.gms.common.api.Status
      private final Status field_3096;
      // $FF: renamed from: ZO java.io.InputStream
      private volatile InputStream field_3097;
      private volatile ParcelFileDescriptor axG;
      private volatile boolean mClosed = false;

      public class_1528(Status var1, ParcelFileDescriptor var2) {
         this.field_3096 = var1;
         this.axG = var2;
      }

      public ParcelFileDescriptor getFd() {
         if(this.mClosed) {
            throw new IllegalStateException("Cannot access the file descriptor after release().");
         } else {
            return this.axG;
         }
      }

      public InputStream getInputStream() {
         if(this.mClosed) {
            throw new IllegalStateException("Cannot access the input stream after release().");
         } else if(this.axG == null) {
            return null;
         } else {
            if(this.field_3097 == null) {
               this.field_3097 = new AutoCloseInputStream(this.axG);
            }

            return this.field_3097;
         }
      }

      public Status getStatus() {
         return this.field_3096;
      }

      public void release() {
         // $FF: Couldn't be decompiled
      }
   }
}
