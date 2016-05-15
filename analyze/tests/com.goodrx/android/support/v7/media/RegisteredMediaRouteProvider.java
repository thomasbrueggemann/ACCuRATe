package android.support.v7.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.IBinder.DeathRecipient;
import android.support.v7.media.MediaRouteDescriptor;
import android.support.v7.media.MediaRouteDiscoveryRequest;
import android.support.v7.media.MediaRouteProvider;
import android.support.v7.media.MediaRouteProviderDescriptor;
import android.support.v7.media.MediaRouteProviderProtocol;
import android.support.v7.media.MediaRouter;
import android.util.Log;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

final class RegisteredMediaRouteProvider extends MediaRouteProvider implements ServiceConnection {
   private static final boolean DEBUG = Log.isLoggable("MediaRouteProviderProxy", 3);
   private static final String TAG = "MediaRouteProviderProxy";
   private RegisteredMediaRouteProvider.Connection mActiveConnection;
   private boolean mBound;
   private final ComponentName mComponentName;
   private boolean mConnectionReady;
   private final ArrayList<RegisteredMediaRouteProvider.Controller> mControllers = new ArrayList();
   private final RegisteredMediaRouteProvider.PrivateHandler mPrivateHandler;
   private boolean mStarted;

   public RegisteredMediaRouteProvider(Context var1, ComponentName var2) {
      super(var1, new MediaRouteProvider.ProviderMetadata(var2));
      this.mComponentName = var2;
      this.mPrivateHandler = new RegisteredMediaRouteProvider.PrivateHandler();
   }

   private void attachControllersToConnection() {
      int var1 = this.mControllers.size();

      for(int var2 = 0; var2 < var1; ++var2) {
         ((RegisteredMediaRouteProvider.Controller)this.mControllers.get(var2)).attachConnection(this.mActiveConnection);
      }

   }

   private void bind() {
      if(!this.mBound) {
         if(DEBUG) {
            Log.d("MediaRouteProviderProxy", this + ": Binding");
         }

         Intent var1 = new Intent("android.media.MediaRouteProviderService");
         var1.setComponent(this.mComponentName);

         try {
            this.mBound = this.getContext().bindService(var1, this, 1);
            if(!this.mBound && DEBUG) {
               Log.d("MediaRouteProviderProxy", this + ": Bind failed");
            }
         } catch (SecurityException var4) {
            if(DEBUG) {
               Log.d("MediaRouteProviderProxy", this + ": Bind failed", var4);
               return;
            }
         }
      }

   }

   private void detachControllersFromConnection() {
      int var1 = this.mControllers.size();

      for(int var2 = 0; var2 < var1; ++var2) {
         ((RegisteredMediaRouteProvider.Controller)this.mControllers.get(var2)).detachConnection();
      }

   }

   private void disconnect() {
      if(this.mActiveConnection != null) {
         this.setDescriptor((MediaRouteProviderDescriptor)null);
         this.mConnectionReady = false;
         this.detachControllersFromConnection();
         this.mActiveConnection.dispose();
         this.mActiveConnection = null;
      }

   }

   private void onConnectionDescriptorChanged(RegisteredMediaRouteProvider.Connection var1, MediaRouteProviderDescriptor var2) {
      if(this.mActiveConnection == var1) {
         if(DEBUG) {
            Log.d("MediaRouteProviderProxy", this + ": Descriptor changed, descriptor=" + var2);
         }

         this.setDescriptor(var2);
      }

   }

   private void onConnectionDied(RegisteredMediaRouteProvider.Connection var1) {
      if(this.mActiveConnection == var1) {
         if(DEBUG) {
            Log.d("MediaRouteProviderProxy", this + ": Service connection died");
         }

         this.disconnect();
      }

   }

   private void onConnectionError(RegisteredMediaRouteProvider.Connection var1, String var2) {
      if(this.mActiveConnection == var1) {
         if(DEBUG) {
            Log.d("MediaRouteProviderProxy", this + ": Service connection error - " + var2);
         }

         this.unbind();
      }

   }

   private void onConnectionReady(RegisteredMediaRouteProvider.Connection var1) {
      if(this.mActiveConnection == var1) {
         this.mConnectionReady = true;
         this.attachControllersToConnection();
         MediaRouteDiscoveryRequest var2 = this.getDiscoveryRequest();
         if(var2 != null) {
            this.mActiveConnection.setDiscoveryRequest(var2);
         }
      }

   }

   private void onControllerReleased(RegisteredMediaRouteProvider.Controller var1) {
      this.mControllers.remove(var1);
      var1.detachConnection();
      this.updateBinding();
   }

   private boolean shouldBind() {
      return this.mStarted && (this.getDiscoveryRequest() != null || !this.mControllers.isEmpty());
   }

   private void unbind() {
      if(this.mBound) {
         if(DEBUG) {
            Log.d("MediaRouteProviderProxy", this + ": Unbinding");
         }

         this.mBound = false;
         this.disconnect();
         this.getContext().unbindService(this);
      }

   }

   private void updateBinding() {
      if(this.shouldBind()) {
         this.bind();
      } else {
         this.unbind();
      }
   }

   public boolean hasComponentName(String var1, String var2) {
      return this.mComponentName.getPackageName().equals(var1) && this.mComponentName.getClassName().equals(var2);
   }

   public MediaRouteProvider.RouteController onCreateRouteController(String var1) {
      MediaRouteProviderDescriptor var2 = this.getDescriptor();
      if(var2 != null) {
         List var3 = var2.getRoutes();
         int var4 = var3.size();

         for(int var5 = 0; var5 < var4; ++var5) {
            if(((MediaRouteDescriptor)var3.get(var5)).getId().equals(var1)) {
               RegisteredMediaRouteProvider.Controller var6 = new RegisteredMediaRouteProvider.Controller(var1);
               this.mControllers.add(var6);
               if(this.mConnectionReady) {
                  var6.attachConnection(this.mActiveConnection);
               }

               this.updateBinding();
               return var6;
            }
         }
      }

      return null;
   }

   public void onDiscoveryRequestChanged(MediaRouteDiscoveryRequest var1) {
      if(this.mConnectionReady) {
         this.mActiveConnection.setDiscoveryRequest(var1);
      }

      this.updateBinding();
   }

   public void onServiceConnected(ComponentName var1, IBinder var2) {
      if(DEBUG) {
         Log.d("MediaRouteProviderProxy", this + ": Connected");
      }

      if(this.mBound) {
         this.disconnect();
         Messenger var3;
         if(var2 != null) {
            var3 = new Messenger(var2);
         } else {
            var3 = null;
         }

         if(!MediaRouteProviderProtocol.isValidRemoteMessenger(var3)) {
            Log.e("MediaRouteProviderProxy", this + ": Service returned invalid messenger binder");
            return;
         }

         RegisteredMediaRouteProvider.Connection var4 = new RegisteredMediaRouteProvider.Connection(var3);
         if(var4.register()) {
            this.mActiveConnection = var4;
         } else if(DEBUG) {
            Log.d("MediaRouteProviderProxy", this + ": Registration failed");
            return;
         }
      }

   }

   public void onServiceDisconnected(ComponentName var1) {
      if(DEBUG) {
         Log.d("MediaRouteProviderProxy", this + ": Service disconnected");
      }

      this.disconnect();
   }

   public void rebindIfDisconnected() {
      if(this.mActiveConnection == null && this.shouldBind()) {
         this.unbind();
         this.bind();
      }

   }

   public void start() {
      if(!this.mStarted) {
         if(DEBUG) {
            Log.d("MediaRouteProviderProxy", this + ": Starting");
         }

         this.mStarted = true;
         this.updateBinding();
      }

   }

   public void stop() {
      if(this.mStarted) {
         if(DEBUG) {
            Log.d("MediaRouteProviderProxy", this + ": Stopping");
         }

         this.mStarted = false;
         this.updateBinding();
      }

   }

   public String toString() {
      return "Service connection " + this.mComponentName.flattenToShortString();
   }

   private final class Connection implements DeathRecipient {
      private int mNextControllerId = 1;
      private int mNextRequestId = 1;
      private final SparseArray<MediaRouter.ControlRequestCallback> mPendingCallbacks = new SparseArray();
      private int mPendingRegisterRequestId;
      private final RegisteredMediaRouteProvider.ReceiveHandler mReceiveHandler;
      private final Messenger mReceiveMessenger;
      private final Messenger mServiceMessenger;
      private int mServiceVersion;

      public Connection(Messenger var2) {
         this.mServiceMessenger = var2;
         this.mReceiveHandler = new RegisteredMediaRouteProvider.ReceiveHandler(this);
         this.mReceiveMessenger = new Messenger(this.mReceiveHandler);
      }

      private void failPendingCallbacks() {
         for(int var1 = 0; var1 < this.mPendingCallbacks.size(); ++var1) {
            ((MediaRouter.ControlRequestCallback)this.mPendingCallbacks.valueAt(var1)).onError((String)null, (Bundle)null);
         }

         this.mPendingCallbacks.clear();
      }

      private boolean sendRequest(int var1, int var2, int var3, Object var4, Bundle var5) {
         Message var6 = Message.obtain();
         var6.what = var1;
         var6.arg1 = var2;
         var6.arg2 = var3;
         var6.obj = var4;
         var6.setData(var5);
         var6.replyTo = this.mReceiveMessenger;

         try {
            this.mServiceMessenger.send(var6);
            return true;
         } catch (DeadObjectException var9) {
            ;
         } catch (RemoteException var10) {
            if(var1 != 2) {
               Log.e("MediaRouteProviderProxy", "Could not send message to service.", var10);
            }
         }

         return false;
      }

      public void binderDied() {
         RegisteredMediaRouteProvider.this.mPrivateHandler.post(new Runnable() {
            public void run() {
               RegisteredMediaRouteProvider.this.onConnectionDied(Connection.this);
            }
         });
      }

      public int createRouteController(String var1) {
         int var2 = this.mNextControllerId;
         this.mNextControllerId = var2 + 1;
         Bundle var3 = new Bundle();
         var3.putString("routeId", var1);
         int var4 = this.mNextRequestId;
         this.mNextRequestId = var4 + 1;
         this.sendRequest(3, var4, var2, (Object)null, var3);
         return var2;
      }

      public void dispose() {
         this.sendRequest(2, 0, 0, (Object)null, (Bundle)null);
         this.mReceiveHandler.dispose();
         this.mServiceMessenger.getBinder().unlinkToDeath(this, 0);
         RegisteredMediaRouteProvider.this.mPrivateHandler.post(new Runnable() {
            public void run() {
               Connection.this.failPendingCallbacks();
            }
         });
      }

      public boolean onControlRequestFailed(int var1, String var2, Bundle var3) {
         MediaRouter.ControlRequestCallback var4 = (MediaRouter.ControlRequestCallback)this.mPendingCallbacks.get(var1);
         if(var4 != null) {
            this.mPendingCallbacks.remove(var1);
            var4.onError(var2, var3);
            return true;
         } else {
            return false;
         }
      }

      public boolean onControlRequestSucceeded(int var1, Bundle var2) {
         MediaRouter.ControlRequestCallback var3 = (MediaRouter.ControlRequestCallback)this.mPendingCallbacks.get(var1);
         if(var3 != null) {
            this.mPendingCallbacks.remove(var1);
            var3.onResult(var2);
            return true;
         } else {
            return false;
         }
      }

      public boolean onDescriptorChanged(Bundle var1) {
         if(this.mServiceVersion != 0) {
            RegisteredMediaRouteProvider.this.onConnectionDescriptorChanged(this, MediaRouteProviderDescriptor.fromBundle(var1));
            return true;
         } else {
            return false;
         }
      }

      public boolean onGenericFailure(int var1) {
         if(var1 == this.mPendingRegisterRequestId) {
            this.mPendingRegisterRequestId = 0;
            RegisteredMediaRouteProvider.this.onConnectionError(this, "Registation failed");
         }

         MediaRouter.ControlRequestCallback var2 = (MediaRouter.ControlRequestCallback)this.mPendingCallbacks.get(var1);
         if(var2 != null) {
            this.mPendingCallbacks.remove(var1);
            var2.onError((String)null, (Bundle)null);
         }

         return true;
      }

      public boolean onGenericSuccess(int var1) {
         return true;
      }

      public boolean onRegistered(int var1, int var2, Bundle var3) {
         if(this.mServiceVersion == 0 && var1 == this.mPendingRegisterRequestId && var2 >= 1) {
            this.mPendingRegisterRequestId = 0;
            this.mServiceVersion = var2;
            RegisteredMediaRouteProvider.this.onConnectionDescriptorChanged(this, MediaRouteProviderDescriptor.fromBundle(var3));
            RegisteredMediaRouteProvider.this.onConnectionReady(this);
            return true;
         } else {
            return false;
         }
      }

      public boolean register() {
         int var1 = this.mNextRequestId;
         this.mNextRequestId = var1 + 1;
         this.mPendingRegisterRequestId = var1;
         if(!this.sendRequest(1, this.mPendingRegisterRequestId, 1, (Object)null, (Bundle)null)) {
            return false;
         } else {
            try {
               this.mServiceMessenger.getBinder().linkToDeath(this, 0);
               return true;
            } catch (RemoteException var3) {
               this.binderDied();
               return false;
            }
         }
      }

      public void releaseRouteController(int var1) {
         int var2 = this.mNextRequestId;
         this.mNextRequestId = var2 + 1;
         this.sendRequest(4, var2, var1, (Object)null, (Bundle)null);
      }

      public void selectRoute(int var1) {
         int var2 = this.mNextRequestId;
         this.mNextRequestId = var2 + 1;
         this.sendRequest(5, var2, var1, (Object)null, (Bundle)null);
      }

      public boolean sendControlRequest(int var1, Intent var2, MediaRouter.ControlRequestCallback var3) {
         int var4 = this.mNextRequestId;
         this.mNextRequestId = var4 + 1;
         if(this.sendRequest(9, var4, var1, var2, (Bundle)null)) {
            if(var3 != null) {
               this.mPendingCallbacks.put(var4, var3);
            }

            return true;
         } else {
            return false;
         }
      }

      public void setDiscoveryRequest(MediaRouteDiscoveryRequest var1) {
         int var2 = this.mNextRequestId;
         this.mNextRequestId = var2 + 1;
         Bundle var3;
         if(var1 != null) {
            var3 = var1.asBundle();
         } else {
            var3 = null;
         }

         this.sendRequest(10, var2, 0, var3, (Bundle)null);
      }

      public void setVolume(int var1, int var2) {
         Bundle var3 = new Bundle();
         var3.putInt("volume", var2);
         int var4 = this.mNextRequestId;
         this.mNextRequestId = var4 + 1;
         this.sendRequest(7, var4, var1, (Object)null, var3);
      }

      public void unselectRoute(int var1, int var2) {
         Bundle var3 = new Bundle();
         var3.putInt("unselectReason", var2);
         int var4 = this.mNextRequestId;
         this.mNextRequestId = var4 + 1;
         this.sendRequest(6, var4, var1, (Object)null, var3);
      }

      public void updateVolume(int var1, int var2) {
         Bundle var3 = new Bundle();
         var3.putInt("volume", var2);
         int var4 = this.mNextRequestId;
         this.mNextRequestId = var4 + 1;
         this.sendRequest(8, var4, var1, (Object)null, var3);
      }
   }

   private final class Controller extends MediaRouteProvider.RouteController {
      private RegisteredMediaRouteProvider.Connection mConnection;
      private int mControllerId;
      private int mPendingSetVolume = -1;
      private int mPendingUpdateVolumeDelta;
      private final String mRouteId;
      private boolean mSelected;

      public Controller(String var2) {
         this.mRouteId = var2;
      }

      public void attachConnection(RegisteredMediaRouteProvider.Connection var1) {
         this.mConnection = var1;
         this.mControllerId = var1.createRouteController(this.mRouteId);
         if(this.mSelected) {
            var1.selectRoute(this.mControllerId);
            if(this.mPendingSetVolume >= 0) {
               var1.setVolume(this.mControllerId, this.mPendingSetVolume);
               this.mPendingSetVolume = -1;
            }

            if(this.mPendingUpdateVolumeDelta != 0) {
               var1.updateVolume(this.mControllerId, this.mPendingUpdateVolumeDelta);
               this.mPendingUpdateVolumeDelta = 0;
            }
         }

      }

      public void detachConnection() {
         if(this.mConnection != null) {
            this.mConnection.releaseRouteController(this.mControllerId);
            this.mConnection = null;
            this.mControllerId = 0;
         }

      }

      public boolean onControlRequest(Intent var1, MediaRouter.ControlRequestCallback var2) {
         return this.mConnection != null?this.mConnection.sendControlRequest(this.mControllerId, var1, var2):false;
      }

      public void onRelease() {
         RegisteredMediaRouteProvider.this.onControllerReleased(this);
      }

      public void onSelect() {
         this.mSelected = true;
         if(this.mConnection != null) {
            this.mConnection.selectRoute(this.mControllerId);
         }

      }

      public void onSetVolume(int var1) {
         if(this.mConnection != null) {
            this.mConnection.setVolume(this.mControllerId, var1);
         } else {
            this.mPendingSetVolume = var1;
            this.mPendingUpdateVolumeDelta = 0;
         }
      }

      public void onUnselect() {
         this.onUnselect(0);
      }

      public void onUnselect(int var1) {
         this.mSelected = false;
         if(this.mConnection != null) {
            this.mConnection.unselectRoute(this.mControllerId, var1);
         }

      }

      public void onUpdateVolume(int var1) {
         if(this.mConnection != null) {
            this.mConnection.updateVolume(this.mControllerId, var1);
         } else {
            this.mPendingUpdateVolumeDelta += var1;
         }
      }
   }

   private final class PrivateHandler extends Handler {
      private PrivateHandler() {
      }

      // $FF: synthetic method
      PrivateHandler(Object var2) {
         this();
      }
   }

   private static final class ReceiveHandler extends Handler {
      private final WeakReference<RegisteredMediaRouteProvider.Connection> mConnectionRef;

      public ReceiveHandler(RegisteredMediaRouteProvider.Connection var1) {
         this.mConnectionRef = new WeakReference(var1);
      }

      private boolean processMessage(RegisteredMediaRouteProvider.Connection var1, int var2, int var3, int var4, Object var5, Bundle var6) {
         switch(var2) {
         case 0:
            var1.onGenericFailure(var3);
            return true;
         case 1:
            var1.onGenericSuccess(var3);
            return true;
         case 2:
            if(var5 != null && !(var5 instanceof Bundle)) {
               break;
            }

            return var1.onRegistered(var3, var4, (Bundle)var5);
         case 3:
            if(var5 != null && !(var5 instanceof Bundle)) {
               break;
            }

            return var1.onControlRequestSucceeded(var3, (Bundle)var5);
         case 4:
            if(var5 != null && !(var5 instanceof Bundle)) {
               break;
            }

            String var7;
            if(var6 == null) {
               var7 = null;
            } else {
               var7 = var6.getString("error");
            }

            return var1.onControlRequestFailed(var3, var7, (Bundle)var5);
         case 5:
            if(var5 == null || var5 instanceof Bundle) {
               return var1.onDescriptorChanged((Bundle)var5);
            }
         }

         return false;
      }

      public void dispose() {
         this.mConnectionRef.clear();
      }

      public void handleMessage(Message var1) {
         RegisteredMediaRouteProvider.Connection var2 = (RegisteredMediaRouteProvider.Connection)this.mConnectionRef.get();
         if(var2 != null && !this.processMessage(var2, var1.what, var1.arg1, var1.arg2, var1.obj, var1.peekData()) && RegisteredMediaRouteProvider.DEBUG) {
            Log.d("MediaRouteProviderProxy", "Unhandled message from server: " + var1);
         }

      }
   }
}
