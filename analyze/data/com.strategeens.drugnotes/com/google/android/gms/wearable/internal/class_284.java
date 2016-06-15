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
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_19;
import com.google.android.gms.internal.class_283;
import com.google.android.gms.internal.jl;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.internal.af;
import com.google.android.gms.wearable.internal.ag;
import com.google.android.gms.wearable.internal.class_188;
import com.google.android.gms.wearable.internal.class_707;
import com.google.android.gms.wearable.internal.class_991;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

// $FF: renamed from: com.google.android.gms.wearable.internal.ba
public class class_284 extends jl<af> {
   private final ExecutorService asJ = Executors.newCachedThreadPool();
   private final ag<DataApi.DataListener> ayg = new class_707.class_1512();
   private final ag<MessageApi.MessageListener> ayh = new class_707.class_1513();
   private final ag<NodeApi.NodeListener> ayi = new class_707.class_1514();

   public class_284(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4) {
      super(var1, var2, var3, var4, new String[0]);
   }

   // $FF: renamed from: a (android.os.ParcelFileDescriptor, byte[]) java.util.concurrent.FutureTask
   private FutureTask<Boolean> method_1801(final ParcelFileDescriptor var1, final byte[] var2) {
      return new FutureTask(new Callable() {
         // $FF: synthetic method
         public Object call() throws Exception {
            return this.method_5463();
         }

         // $FF: renamed from: rr () java.lang.Boolean
         public Boolean method_5463() {
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

   // $FF: renamed from: a (int, android.os.IBinder, android.os.Bundle) void
   protected void method_1790(int var1, IBinder var2, Bundle var3) {
      if(Log.isLoggable("WearableClient", 2)) {
         Log.d("WearableClient", "onPostInitHandler: statusCode " + var1);
      }

      if(var1 == 0) {
         this.ayg.method_4148(var2);
         this.ayh.method_4148(var2);
         this.ayi.method_4148(var2);
      }

      super.method_1790(var1, var2, var3);
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, android.net.Uri) void
   public void method_1802(BaseImplementation.class_1058<DataApi.DataItemResult> var1, Uri var2) throws RemoteException {
      ((class_188)this.hw()).method_981(new class_991.class_1568(var1), var2);
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, com.google.android.gms.wearable.Asset) void
   public void method_1803(BaseImplementation.class_1058<DataApi.GetFdForAssetResult> var1, Asset var2) throws RemoteException {
      ((class_188)this.hw()).method_982(new class_991.class_1577(var1), var2);
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, com.google.android.gms.wearable.DataApi$DataListener) void
   public void method_1804(BaseImplementation.class_1058<Status> var1, DataApi.DataListener var2) throws RemoteException {
      this.ayg.method_4145(this, var1, var2);
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, com.google.android.gms.wearable.DataApi$DataListener, android.content.IntentFilter[]) void
   public void method_1805(BaseImplementation.class_1058<Status> var1, DataApi.DataListener var2, IntentFilter[] var3) throws RemoteException {
      this.ayg.method_4146(this, var1, var2, var3);
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, com.google.android.gms.wearable.DataItemAsset) void
   public void method_1806(BaseImplementation.class_1058<DataApi.GetFdForAssetResult> var1, DataItemAsset var2) throws RemoteException {
      this.method_1803(var1, Asset.createFromRef(var2.getId()));
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, com.google.android.gms.wearable.MessageApi$MessageListener) void
   public void method_1807(BaseImplementation.class_1058<Status> var1, MessageApi.MessageListener var2) throws RemoteException {
      this.ayh.method_4145(this, var1, var2);
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, com.google.android.gms.wearable.MessageApi$MessageListener, android.content.IntentFilter[]) void
   public void method_1808(BaseImplementation.class_1058<Status> var1, MessageApi.MessageListener var2, IntentFilter[] var3) throws RemoteException {
      this.ayh.method_4146(this, var1, var2, var3);
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, com.google.android.gms.wearable.NodeApi$NodeListener) void
   public void method_1809(BaseImplementation.class_1058<Status> var1, NodeApi.NodeListener var2) throws RemoteException, RemoteException {
      this.ayi.method_4146(this, var1, var2, (IntentFilter[])null);
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, com.google.android.gms.wearable.PutDataRequest) void
   public void method_1810(BaseImplementation.class_1058<DataApi.DataItemResult> var1, PutDataRequest var2) throws RemoteException {
      Iterator var3 = var2.getAssets().entrySet().iterator();

      Asset var19;
      do {
         if(!var3.hasNext()) {
            PutDataRequest var4 = PutDataRequest.method_1640(var2.getUri());
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
                  FutureTask var14 = this.method_1801(var12[1], var10.getData());
                  var6.add(var14);
                  this.asJ.submit(var14);
               }
            }

            try {
               ((class_188)this.hw()).method_983(new class_991.class_1570(var1, var6), var4);
               return;
            } catch (NullPointerException var20) {
               throw new IllegalStateException("Unable to putDataItem: " + var2, var20);
            }
         }

         var19 = (Asset)((Entry)var3.next()).getValue();
      } while(var19.getData() != null || var19.getDigest() != null || var19.getFd() != null || var19.getUri() != null);

      throw new IllegalArgumentException("Put for " + var2.getUri() + " contains invalid asset: " + var19);
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$b, java.lang.String, java.lang.String, byte[]) void
   public void method_1811(BaseImplementation.class_1058<MessageApi.SendMessageResult> var1, String var2, String var3, byte[] var4) throws RemoteException {
      ((class_188)this.hw()).method_988(new class_991.class_1573(var1), var2, var3, var4);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.jt, com.google.android.gms.internal.jl$e) void
   protected void method_1792(class_19 var1, class_283.class_1230 var2) throws RemoteException {
      var1.method_146(var2, 6587000, this.getContext().getPackageName());
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b, android.net.Uri) void
   public void method_1812(BaseImplementation.class_1058<DataItemBuffer> var1, Uri var2) throws RemoteException {
      ((class_188)this.hw()).method_990(new class_991.class_1576(var1), var2);
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$b, com.google.android.gms.wearable.NodeApi$NodeListener) void
   public void method_1813(BaseImplementation.class_1058<Status> var1, NodeApi.NodeListener var2) throws RemoteException {
      this.ayi.method_4145(this, var1, var2);
   }

   // $FF: renamed from: bK () java.lang.String
   protected String method_1794() {
      return "com.google.android.gms.wearable.BIND";
   }

   // $FF: renamed from: bL () java.lang.String
   protected String method_1795() {
      return "com.google.android.gms.wearable.internal.IWearableService";
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.BaseImplementation$b, android.net.Uri) void
   public void method_1814(BaseImplementation.class_1058<DataApi.DeleteDataItemsResult> var1, Uri var2) throws RemoteException {
      ((class_188)this.hw()).method_994(new class_991.class_1566(var1), var2);
   }

   // $FF: renamed from: cb (android.os.IBinder) com.google.android.gms.wearable.internal.af
   protected class_188 method_1815(IBinder var1) {
      return class_188.class_1127.method_2725(var1);
   }

   public void disconnect() {
      this.ayg.method_4147(this);
      this.ayh.method_4147(this);
      this.ayi.method_4147(this);
      super.disconnect();
   }

   // $FF: renamed from: l (android.os.IBinder) android.os.IInterface
   // $FF: synthetic method
   protected IInterface method_1800(IBinder var1) {
      return this.method_1815(var1);
   }

   // $FF: renamed from: n (com.google.android.gms.common.api.BaseImplementation$b) void
   public void method_1816(BaseImplementation.class_1058<DataItemBuffer> var1) throws RemoteException {
      ((class_188)this.hw()).method_989(new class_991.class_1576(var1));
   }

   // $FF: renamed from: o (com.google.android.gms.common.api.BaseImplementation$b) void
   public void method_1817(BaseImplementation.class_1058<NodeApi.GetLocalNodeResult> var1) throws RemoteException {
      ((class_188)this.hw()).method_993(new class_991.class_1574(var1));
   }

   // $FF: renamed from: p (com.google.android.gms.common.api.BaseImplementation$b) void
   public void method_1818(BaseImplementation.class_1058<NodeApi.GetConnectedNodesResult> var1) throws RemoteException {
      ((class_188)this.hw()).method_996(new class_991.class_1569(var1));
   }
}
