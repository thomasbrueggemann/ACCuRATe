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
import com.google.android.gms.wearable.internal.class_161;
import com.google.android.gms.wearable.internal.class_235;
import java.io.IOException;
import java.io.InputStream;

// $FF: renamed from: com.google.android.gms.wearable.internal.f
public final class class_695 implements DataApi {
   // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.wearable.DataApi$DataListener, android.content.IntentFilter[]) com.google.android.gms.common.api.PendingResult
   private PendingResult<Status> method_4018(GoogleApiClient var1, final DataApi.DataListener var2, final IntentFilter[] var3) {
      return var1.method_772(new class_161() {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.au) void
         protected void method_967(class_235 var1) throws RemoteException {
            var1.method_1464(this, var2, var3);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         public Result method_884(Status var1) {
            return this.method_968(var1);
         }

         // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
         public Status method_968(Status var1) {
            return new Status(13);
         }
      });
   }

   // $FF: renamed from: a (com.google.android.gms.wearable.Asset) void
   private void method_4019(Asset var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("asset is null");
      } else if(var1.getDigest() == null) {
         throw new IllegalArgumentException("invalid asset");
      } else if(var1.getData() != null) {
         throw new IllegalArgumentException("invalid asset");
      }
   }

   public PendingResult<Status> addListener(GoogleApiClient var1, DataApi.DataListener var2) {
      return this.method_4018(var1, var2, (IntentFilter[])null);
   }

   public PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(GoogleApiClient var1, final Uri var2) {
      return var1.method_772(new class_161() {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.au) void
         protected void method_973(class_235 var1) throws RemoteException {
            var1.method_1475(this, var2);
         }

         // $FF: renamed from: as (com.google.android.gms.common.api.Status) com.google.android.gms.wearable.DataApi$DeleteDataItemsResult
         protected DataApi.DeleteDataItemsResult method_974(Status var1) {
            return new class_695.class_1169(var1, 0);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         protected Result method_884(Status var1) {
            return this.method_974(var1);
         }
      });
   }

   public PendingResult<DataApi.DataItemResult> getDataItem(GoogleApiClient var1, final Uri var2) {
      return var1.method_772(new class_161() {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.au) void
         protected void method_959(class_235 var1) throws RemoteException {
            var1.method_1461(this, var2);
         }

         // $FF: renamed from: aq (com.google.android.gms.common.api.Status) com.google.android.gms.wearable.DataApi$DataItemResult
         protected DataApi.DataItemResult method_960(Status var1) {
            return new class_695.class_1171(var1, (DataItem)null);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         protected Result method_884(Status var1) {
            return this.method_960(var1);
         }
      });
   }

   public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient var1) {
      return var1.method_772(new class_161() {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.au) void
         protected void method_961(class_235 var1) throws RemoteException {
            var1.method_1476(this);
         }

         // $FF: renamed from: ar (com.google.android.gms.common.api.Status) com.google.android.gms.wearable.DataItemBuffer
         protected DataItemBuffer method_962(Status var1) {
            return new DataItemBuffer(DataHolder.method_4552(var1.getStatusCode()));
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         protected Result method_884(Status var1) {
            return this.method_962(var1);
         }
      });
   }

   public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient var1, final Uri var2) {
      return var1.method_772(new class_161() {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.au) void
         protected void method_975(class_235 var1) throws RemoteException {
            var1.method_1472(this, var2);
         }

         // $FF: renamed from: ar (com.google.android.gms.common.api.Status) com.google.android.gms.wearable.DataItemBuffer
         protected DataItemBuffer method_976(Status var1) {
            return new DataItemBuffer(DataHolder.method_4552(var1.getStatusCode()));
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         protected Result method_884(Status var1) {
            return this.method_976(var1);
         }
      });
   }

   public PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient var1, final Asset var2) {
      this.method_4019(var2);
      return var1.method_772(new class_161() {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.au) void
         protected void method_971(class_235 var1) throws RemoteException {
            var1.method_1462(this, var2);
         }

         // $FF: renamed from: at (com.google.android.gms.common.api.Status) com.google.android.gms.wearable.DataApi$GetFdForAssetResult
         protected DataApi.GetFdForAssetResult method_972(Status var1) {
            return new class_695.class_1170(var1, (ParcelFileDescriptor)null);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         protected Result method_884(Status var1) {
            return this.method_972(var1);
         }
      });
   }

   public PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient var1, final DataItemAsset var2) {
      return var1.method_772(new class_161() {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.au) void
         protected void method_969(class_235 var1) throws RemoteException {
            var1.method_1465(this, var2);
         }

         // $FF: renamed from: at (com.google.android.gms.common.api.Status) com.google.android.gms.wearable.DataApi$GetFdForAssetResult
         protected DataApi.GetFdForAssetResult method_970(Status var1) {
            return new class_695.class_1170(var1, (ParcelFileDescriptor)null);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         protected Result method_884(Status var1) {
            return this.method_970(var1);
         }
      });
   }

   public PendingResult<DataApi.DataItemResult> putDataItem(GoogleApiClient var1, final PutDataRequest var2) {
      return var1.method_772(new class_161() {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.au) void
         protected void method_963(class_235 var1) throws RemoteException {
            var1.method_1469(this, var2);
         }

         // $FF: renamed from: aq (com.google.android.gms.common.api.Status) com.google.android.gms.wearable.DataApi$DataItemResult
         public DataApi.DataItemResult method_964(Status var1) {
            return new class_695.class_1171(var1, (DataItem)null);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         public Result method_884(Status var1) {
            return this.method_964(var1);
         }
      });
   }

   public PendingResult<Status> removeListener(GoogleApiClient var1, final DataApi.DataListener var2) {
      return var1.method_772(new class_161() {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.au) void
         protected void method_965(class_235 var1) throws RemoteException {
            var1.method_1463(this, var2);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         public Result method_884(Status var1) {
            return this.method_966(var1);
         }

         // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
         public Status method_966(Status var1) {
            return new Status(13);
         }
      });
   }

   public static class class_1171 implements DataApi.DataItemResult {
      private final DataItem alE;
      // $FF: renamed from: yw com.google.android.gms.common.api.Status
      private final Status field_3142;

      public class_1171(Status var1, DataItem var2) {
         this.field_3142 = var1;
         this.alE = var2;
      }

      public DataItem getDataItem() {
         return this.alE;
      }

      public Status getStatus() {
         return this.field_3142;
      }
   }

   public static class class_1169 implements DataApi.DeleteDataItemsResult {
      private final int alF;
      // $FF: renamed from: yw com.google.android.gms.common.api.Status
      private final Status field_3140;

      public class_1169(Status var1, int var2) {
         this.field_3140 = var1;
         this.alF = var2;
      }

      public int getNumDeleted() {
         return this.alF;
      }

      public Status getStatus() {
         return this.field_3140;
      }
   }

   public static class class_1170 implements DataApi.GetFdForAssetResult {
      private final ParcelFileDescriptor alG;
      // $FF: renamed from: yw com.google.android.gms.common.api.Status
      private final Status field_3141;

      public class_1170(Status var1, ParcelFileDescriptor var2) {
         this.field_3141 = var1;
         this.alG = var2;
      }

      public ParcelFileDescriptor getFd() {
         return this.alG;
      }

      public InputStream getInputStream() {
         return new AutoCloseInputStream(this.alG);
      }

      public Status getStatus() {
         return this.field_3141;
      }

      public void release() {
         try {
            this.alG.close();
         } catch (IOException var2) {
            ;
         }
      }
   }
}
