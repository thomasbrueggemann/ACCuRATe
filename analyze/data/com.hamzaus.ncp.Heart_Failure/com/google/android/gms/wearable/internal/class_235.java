package com.google.android.gms.wearable.internal;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.class_797;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.class_234;
import com.google.android.gms.internal.class_31;
import com.google.android.gms.internal.hc;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.internal.ac;
import com.google.android.gms.wearable.internal.ad;
import com.google.android.gms.wearable.internal.av;
import com.google.android.gms.wearable.internal.class_151;
import com.google.android.gms.wearable.internal.class_640;
import com.google.android.gms.wearable.internal.class_695;
import com.google.android.gms.wearable.internal.class_700;
import com.google.android.gms.wearable.internal.class_703;
import com.google.android.gms.wearable.internal.class_706;
import com.google.android.gms.wearable.internal.class_708;
import com.google.android.gms.wearable.internal.class_710;
import com.google.android.gms.wearable.internal.class_758;
import com.google.android.gms.wearable.internal.class_760;
import com.google.android.gms.wearable.internal.class_764;
import com.google.android.gms.wearable.internal.class_769;
import com.google.android.gms.wearable.internal.class_772;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

// $FF: renamed from: com.google.android.gms.wearable.internal.au
public class class_235 extends hc<ad> {
   private final ExecutorService agR = Executors.newCachedThreadPool();
   private final HashMap<DataApi.DataListener, av> amb = new HashMap();
   private final HashMap<MessageApi.MessageListener, av> amc = new HashMap();
   private final HashMap<NodeApi.NodeListener, av> amd = new HashMap();

   public class_235(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4) {
      super(var1, var2, var3, var4, new String[0]);
   }

   // $FF: renamed from: a (android.os.ParcelFileDescriptor, byte[]) java.util.concurrent.FutureTask
   private FutureTask<Boolean> method_1457(final ParcelFileDescriptor var1, final byte[] var2) {
      return new FutureTask(new Callable() {
         // $FF: synthetic method
         public Object call() throws Exception {
            return this.method_3662();
         }

         // $FF: renamed from: no () java.lang.Boolean
         public Boolean method_3662() {
            if(Log.isLoggable("WearableClient", 3)) {
               Log.d("WearableClient", "processAssets: writing data to FD : " + var1);
            }

            AutoCloseOutputStream var1x = new AutoCloseOutputStream(var1);

            try {
               var1x.write(var2);
               var1x.flush();
               if(Log.isLoggable("WearableClient", 3)) {
                  Log.d("WearableClient", "processAssets: wrote data: " + var1);
               }

               Boolean var9 = Boolean.valueOf(true);
               return var9;
            } catch (IOException var17) {
               Log.w("WearableClient", "processAssets: writing data failed: " + var1);
            } finally {
               try {
                  if(Log.isLoggable("WearableClient", 3)) {
                     Log.d("WearableClient", "processAssets: closing: " + var1);
                  }

                  var1x.close();
               } catch (IOException var16) {
                  ;
               }

            }

            return Boolean.valueOf(false);
         }
      });
   }

   // $FF: renamed from: b (com.google.android.gms.wearable.internal.au) java.util.HashMap
   // $FF: synthetic method
   static HashMap method_1458(class_235 var0) {
      return var0.amb;
   }

   // $FF: renamed from: c (com.google.android.gms.wearable.internal.au) java.util.HashMap
   // $FF: synthetic method
   static HashMap method_1459(class_235 var0) {
      return var0.amc;
   }

   // $FF: renamed from: d (com.google.android.gms.wearable.internal.au) java.util.HashMap
   // $FF: synthetic method
   static HashMap method_1460(class_235 var0) {
      return var0.amd;
   }

   // $FF: renamed from: a (int, android.os.IBinder, android.os.Bundle) void
   protected void method_1446(int param1, IBinder param2, Bundle param3) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, android.net.Uri) void
   public void method_1461(final class_797.class_1206<DataApi.DataItemResult> var1, Uri var2) throws RemoteException {
      ((class_151)this.fo()).method_804(new class_640() {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.v) void
         public void method_786(class_708 var1x) {
            var1.method_673(new class_695.class_1171(new Status(var1x.statusCode), var1x.alL));
         }
      }, var2);
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, com.google.android.gms.wearable.Asset) void
   public void method_1462(final class_797.class_1206<DataApi.GetFdForAssetResult> var1, Asset var2) throws RemoteException {
      ((class_151)this.fo()).method_805(new class_640() {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.x) void
         public void method_787(class_706 var1x) {
            var1.method_673(new class_695.class_1170(new Status(var1x.statusCode), var1x.alM));
         }
      }, var2);
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, com.google.android.gms.wearable.DataApi$DataListener) void
   public void method_1463(class_797.class_1206<Status> param1, DataApi.DataListener param2) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, com.google.android.gms.wearable.DataApi$DataListener, android.content.IntentFilter[]) void
   public void method_1464(class_797.class_1206<Status> param1, DataApi.DataListener param2, IntentFilter[] param3) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, com.google.android.gms.wearable.DataItemAsset) void
   public void method_1465(class_797.class_1206<DataApi.GetFdForAssetResult> var1, DataItemAsset var2) throws RemoteException {
      this.method_1462(var1, Asset.createFromRef(var2.getId()));
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, com.google.android.gms.wearable.MessageApi$MessageListener) void
   public void method_1466(class_797.class_1206<Status> param1, MessageApi.MessageListener param2) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, com.google.android.gms.wearable.MessageApi$MessageListener, android.content.IntentFilter[]) void
   public void method_1467(class_797.class_1206<Status> param1, MessageApi.MessageListener param2, IntentFilter[] param3) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, com.google.android.gms.wearable.NodeApi$NodeListener) void
   public void method_1468(class_797.class_1206<Status> param1, NodeApi.NodeListener param2) throws RemoteException, RemoteException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, com.google.android.gms.wearable.PutDataRequest) void
   public void method_1469(class_797.class_1206<DataApi.DataItemResult> var1, PutDataRequest var2) throws RemoteException {
      Iterator var3 = var2.getAssets().entrySet().iterator();

      Asset var19;
      do {
         if(!var3.hasNext()) {
            PutDataRequest var4 = PutDataRequest.method_1338(var2.getUri());
            var4.setData(var2.getData());
            ArrayList var6 = new ArrayList();
            Iterator var7 = var2.getAssets().entrySet().iterator();

            while(var7.hasNext()) {
               Entry var9 = (Entry)var7.next();
               Asset var10 = (Asset)var9.getValue();
               if(var10.getData() == null) {
                  var4.putAsset((String)var9.getKey(), (Asset)var9.getValue());
               } else {
                  ParcelFileDescriptor[] var12;
                  try {
                     var12 = ParcelFileDescriptor.createPipe();
                  } catch (IOException var21) {
                     throw new IllegalStateException("Unable to create ParcelFileDescriptor for asset in request: " + var2, var21);
                  }

                  if(Log.isLoggable("WearableClient", 3)) {
                     Log.d("WearableClient", "processAssets: replacing data with FD in asset: " + var10 + " read:" + var12[0] + " write:" + var12[1]);
                  }

                  var4.putAsset((String)var9.getKey(), Asset.createFromFd(var12[0]));
                  FutureTask var14 = this.method_1457(var12[1], var10.getData());
                  var6.add(var14);
                  this.agR.submit(var14);
               }
            }

            try {
               ((class_151)this.fo()).method_806(new class_235.class_1323(var1, var6), var4);
               return;
            } catch (NullPointerException var20) {
               throw new IllegalStateException("Unable to putDataItem: " + var2, var20);
            }
         }

         var19 = (Asset)((Entry)var3.next()).getValue();
      } while(var19.getData() != null || var19.getDigest() != null || var19.getFd() != null || var19.getUri() != null);

      throw new IllegalArgumentException("Put for " + var2.getUri() + " contains invalid asset: " + var19);
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, com.google.android.gms.wearable.internal.ac) void
   public void method_1470(final class_797.class_1206<Status> var1, ac var2) throws RemoteException {
      ((class_151)this.fo()).method_808(new class_640() {
         // $FF: renamed from: a (com.google.android.gms.common.api.Status) void
         public void method_779(Status var1x) {
            var1.method_673(var1x);
         }
      }, new class_758(var2));
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$d, java.lang.String, java.lang.String, byte[]) void
   public void method_1471(final class_797.class_1206<MessageApi.SendMessageResult> var1, String var2, String var3, byte[] var4) throws RemoteException {
      ((class_151)this.fo()).method_810(new class_640() {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.aq) void
         public void method_781(class_760 var1x) {
            var1.method_673(new class_772.class_1008(new Status(var1x.statusCode), var1x.alZ));
         }
      }, var2, var3, var4);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.hj, com.google.android.gms.internal.hc$e) void
   protected void method_1448(class_31 var1, class_234.class_911 var2) throws RemoteException {
      var1.method_170(var2, 5077000, this.getContext().getPackageName());
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.a$d, android.net.Uri) void
   public void method_1472(final class_797.class_1206<DataItemBuffer> var1, Uri var2) throws RemoteException {
      ((class_151)this.fo()).method_812(new class_640() {
         // $FF: renamed from: Z (com.google.android.gms.common.data.DataHolder) void
         public void method_778(DataHolder var1x) {
            var1.method_673(new DataItemBuffer(var1x));
         }
      }, var2);
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.a$d, com.google.android.gms.wearable.NodeApi$NodeListener) void
   public void method_1473(class_797.class_1206<Status> param1, NodeApi.NodeListener param2) throws RemoteException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: bp () java.lang.String
   protected String method_1451() {
      return "com.google.android.gms.wearable.BIND";
   }

   // $FF: renamed from: bq () java.lang.String
   protected String method_1452() {
      return "com.google.android.gms.wearable.internal.IWearableService";
   }

   // $FF: renamed from: bz (android.os.IBinder) com.google.android.gms.wearable.internal.ad
   protected class_151 method_1474(IBinder var1) {
      return class_151.class_931.method_4362(var1);
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.a$d, android.net.Uri) void
   public void method_1475(final class_797.class_1206<DataApi.DeleteDataItemsResult> var1, Uri var2) throws RemoteException {
      ((class_151)this.fo()).method_814(new class_640() {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.p) void
         public void method_783(class_700 var1x) {
            var1.method_673(new class_695.class_1169(new Status(var1x.statusCode), var1x.alI));
         }
      }, var2);
   }

   public void disconnect() {
      super.disconnect();
      this.amb.clear();
      this.amc.clear();
      this.amd.clear();
   }

   // $FF: renamed from: o (com.google.android.gms.common.api.a$d) void
   public void method_1476(final class_797.class_1206<DataItemBuffer> var1) throws RemoteException {
      ((class_151)this.fo()).method_815(new class_640() {
         // $FF: renamed from: Z (com.google.android.gms.common.data.DataHolder) void
         public void method_778(DataHolder var1x) {
            var1.method_673(new DataItemBuffer(var1x));
         }
      });
   }

   // $FF: renamed from: p (com.google.android.gms.common.api.a$d) void
   public void method_1477(final class_797.class_1206<NodeApi.GetLocalNodeResult> var1) throws RemoteException {
      ((class_151)this.fo()).method_816(new class_640() {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.z) void
         public void method_788(class_710 var1x) {
            var1.method_673(new class_769.class_1129(new Status(var1x.statusCode), var1x.alN));
         }
      });
   }

   // $FF: renamed from: q (com.google.android.gms.common.api.a$d) void
   public void method_1478(final class_797.class_1206<NodeApi.GetConnectedNodesResult> var1) throws RemoteException {
      ((class_151)this.fo()).method_817(new class_640() {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.t) void
         public void method_785(class_703 var1x) {
            ArrayList var2 = new ArrayList();
            var2.addAll(var1x.alK);
            var1.method_673(new class_769.class_1128(new Status(var1x.statusCode), var2));
         }
      });
   }

   // $FF: renamed from: x (android.os.IBinder) android.os.IInterface
   // $FF: synthetic method
   protected IInterface method_1456(IBinder var1) {
      return this.method_1474(var1);
   }

   private static class class_1323 extends class_640 {
      private final List<FutureTask<Boolean>> amh;
      // $FF: renamed from: yO com.google.android.gms.common.api.a$d
      private final class_797.class_1206<DataApi.DataItemResult> field_3349;

      class_1323(class_797.class_1206<DataApi.DataItemResult> var1, List<FutureTask<Boolean>> var2) {
         this.field_3349 = var1;
         this.amh = var2;
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.am) void
      public void method_780(class_764 var1) {
         this.field_3349.method_673(new class_695.class_1171(new Status(var1.statusCode), var1.alL));
         if(var1.statusCode != 0) {
            Iterator var2 = this.amh.iterator();

            while(var2.hasNext()) {
               ((FutureTask)var2.next()).cancel(true);
            }
         }

      }
   }
}
