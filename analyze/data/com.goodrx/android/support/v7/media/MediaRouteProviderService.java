package android.support.v7.media;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.IBinder.DeathRecipient;
import android.support.v7.media.MediaRouteDiscoveryRequest;
import android.support.v7.media.MediaRouteProvider;
import android.support.v7.media.MediaRouteProviderDescriptor;
import android.support.v7.media.MediaRouteProviderProtocol;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import android.util.Log;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public abstract class MediaRouteProviderService extends Service {
   private static final boolean DEBUG = Log.isLoggable("MediaRouteProviderSrv", 3);
   private static final int PRIVATE_MSG_CLIENT_DIED = 1;
   public static final String SERVICE_INTERFACE = "android.media.MediaRouteProviderService";
   private static final String TAG = "MediaRouteProviderSrv";
   private final ArrayList<MediaRouteProviderService.ClientRecord> mClients = new ArrayList();
   private MediaRouteDiscoveryRequest mCompositeDiscoveryRequest;
   private final MediaRouteProviderService.PrivateHandler mPrivateHandler;
   private MediaRouteProvider mProvider;
   private final MediaRouteProviderService.ProviderCallback mProviderCallback;
   private final MediaRouteProviderService.ReceiveHandler mReceiveHandler = new MediaRouteProviderService.ReceiveHandler(this);
   private final Messenger mReceiveMessenger;

   public MediaRouteProviderService() {
      this.mReceiveMessenger = new Messenger(this.mReceiveHandler);
      this.mPrivateHandler = new MediaRouteProviderService.PrivateHandler(null);
      this.mProviderCallback = new MediaRouteProviderService.ProviderCallback(null);
   }

   private int findClient(Messenger var1) {
      int var2 = this.mClients.size();

      for(int var3 = 0; var3 < var2; ++var3) {
         if(((MediaRouteProviderService.ClientRecord)this.mClients.get(var3)).hasMessenger(var1)) {
            return var3;
         }
      }

      return -1;
   }

   private MediaRouteProviderService.ClientRecord getClient(Messenger var1) {
      int var2 = this.findClient(var1);
      return var2 >= 0?(MediaRouteProviderService.ClientRecord)this.mClients.get(var2):null;
   }

   private static String getClientId(Messenger var0) {
      return "Client connection " + var0.getBinder().toString();
   }

   private void onBinderDied(Messenger var1) {
      int var2 = this.findClient(var1);
      if(var2 >= 0) {
         MediaRouteProviderService.ClientRecord var3 = (MediaRouteProviderService.ClientRecord)this.mClients.remove(var2);
         if(DEBUG) {
            Log.d("MediaRouteProviderSrv", var3 + ": Binder died");
         }

         var3.dispose();
      }

   }

   private boolean onCreateRouteController(Messenger var1, int var2, int var3, String var4) {
      MediaRouteProviderService.ClientRecord var5 = this.getClient(var1);
      if(var5 != null && var5.createRouteController(var4, var3)) {
         if(DEBUG) {
            Log.d("MediaRouteProviderSrv", var5 + ": Route controller created" + ", controllerId=" + var3 + ", routeId=" + var4);
         }

         sendGenericSuccess(var1, var2);
         return true;
      } else {
         return false;
      }
   }

   private boolean onRegisterClient(Messenger var1, int var2, int var3) {
      if(var3 >= 1 && this.findClient(var1) < 0) {
         MediaRouteProviderService.ClientRecord var4 = new MediaRouteProviderService.ClientRecord(var1, var3);
         if(var4.register()) {
            this.mClients.add(var4);
            if(DEBUG) {
               Log.d("MediaRouteProviderSrv", var4 + ": Registered, version=" + var3);
            }

            if(var2 != 0) {
               MediaRouteProviderDescriptor var6 = this.mProvider.getDescriptor();
               Bundle var7;
               if(var6 != null) {
                  var7 = var6.asBundle();
               } else {
                  var7 = null;
               }

               sendReply(var1, 2, var2, 1, var7, (Bundle)null);
            }

            return true;
         }
      }

      return false;
   }

   private boolean onReleaseRouteController(Messenger var1, int var2, int var3) {
      MediaRouteProviderService.ClientRecord var4 = this.getClient(var1);
      if(var4 != null && var4.releaseRouteController(var3)) {
         if(DEBUG) {
            Log.d("MediaRouteProviderSrv", var4 + ": Route controller released" + ", controllerId=" + var3);
         }

         sendGenericSuccess(var1, var2);
         return true;
      } else {
         return false;
      }
   }

   private boolean onRouteControlRequest(final Messenger var1, final int var2, final int var3, final Intent var4) {
      final MediaRouteProviderService.ClientRecord var5 = this.getClient(var1);
      if(var5 != null) {
         MediaRouteProvider.RouteController var6 = var5.getRouteController(var3);
         if(var6 != null) {
            MediaRouter.ControlRequestCallback var7 = null;
            if(var2 != 0) {
               var7 = new MediaRouter.ControlRequestCallback() {
                  public void onError(String var1x, Bundle var2x) {
                     if(MediaRouteProviderService.DEBUG) {
                        Log.d("MediaRouteProviderSrv", var5 + ": Route control request failed" + ", controllerId=" + var3 + ", intent=" + var4 + ", error=" + var1x + ", data=" + var2x);
                     }

                     if(MediaRouteProviderService.this.findClient(var1) >= 0) {
                        if(var1x == null) {
                           MediaRouteProviderService.sendReply(var1, 4, var2, 0, var2x, (Bundle)null);
                           return;
                        }

                        Bundle var3x = new Bundle();
                        var3x.putString("error", var1x);
                        MediaRouteProviderService.sendReply(var1, 4, var2, 0, var2x, var3x);
                     }

                  }

                  public void onResult(Bundle var1x) {
                     if(MediaRouteProviderService.DEBUG) {
                        Log.d("MediaRouteProviderSrv", var5 + ": Route control request succeeded" + ", controllerId=" + var3 + ", intent=" + var4 + ", data=" + var1x);
                     }

                     if(MediaRouteProviderService.this.findClient(var1) >= 0) {
                        MediaRouteProviderService.sendReply(var1, 3, var2, 0, var1x, (Bundle)null);
                     }

                  }
               };
            }

            if(var6.onControlRequest(var4, var7)) {
               if(DEBUG) {
                  Log.d("MediaRouteProviderSrv", var5 + ": Route control request delivered" + ", controllerId=" + var3 + ", intent=" + var4);
               }

               return true;
            }
         }
      }

      return false;
   }

   private boolean onSelectRoute(Messenger var1, int var2, int var3) {
      MediaRouteProviderService.ClientRecord var4 = this.getClient(var1);
      if(var4 != null) {
         MediaRouteProvider.RouteController var5 = var4.getRouteController(var3);
         if(var5 != null) {
            var5.onSelect();
            if(DEBUG) {
               Log.d("MediaRouteProviderSrv", var4 + ": Route selected" + ", controllerId=" + var3);
            }

            sendGenericSuccess(var1, var2);
            return true;
         }
      }

      return false;
   }

   private boolean onSetDiscoveryRequest(Messenger var1, int var2, MediaRouteDiscoveryRequest var3) {
      MediaRouteProviderService.ClientRecord var4 = this.getClient(var1);
      if(var4 != null) {
         boolean var5 = var4.setDiscoveryRequest(var3);
         if(DEBUG) {
            Log.d("MediaRouteProviderSrv", var4 + ": Set discovery request, request=" + var3 + ", actuallyChanged=" + var5 + ", compositeDiscoveryRequest=" + this.mCompositeDiscoveryRequest);
         }

         sendGenericSuccess(var1, var2);
         return true;
      } else {
         return false;
      }
   }

   private boolean onSetRouteVolume(Messenger var1, int var2, int var3, int var4) {
      MediaRouteProviderService.ClientRecord var5 = this.getClient(var1);
      if(var5 != null) {
         MediaRouteProvider.RouteController var6 = var5.getRouteController(var3);
         if(var6 != null) {
            var6.onSetVolume(var4);
            if(DEBUG) {
               Log.d("MediaRouteProviderSrv", var5 + ": Route volume changed" + ", controllerId=" + var3 + ", volume=" + var4);
            }

            sendGenericSuccess(var1, var2);
            return true;
         }
      }

      return false;
   }

   private boolean onUnregisterClient(Messenger var1, int var2) {
      int var3 = this.findClient(var1);
      if(var3 >= 0) {
         MediaRouteProviderService.ClientRecord var4 = (MediaRouteProviderService.ClientRecord)this.mClients.remove(var3);
         if(DEBUG) {
            Log.d("MediaRouteProviderSrv", var4 + ": Unregistered");
         }

         var4.dispose();
         sendGenericSuccess(var1, var2);
         return true;
      } else {
         return false;
      }
   }

   private boolean onUnselectRoute(Messenger var1, int var2, int var3, int var4) {
      MediaRouteProviderService.ClientRecord var5 = this.getClient(var1);
      if(var5 != null) {
         MediaRouteProvider.RouteController var6 = var5.getRouteController(var3);
         if(var6 != null) {
            var6.onUnselect(var4);
            if(DEBUG) {
               Log.d("MediaRouteProviderSrv", var5 + ": Route unselected" + ", controllerId=" + var3);
            }

            sendGenericSuccess(var1, var2);
            return true;
         }
      }

      return false;
   }

   private boolean onUpdateRouteVolume(Messenger var1, int var2, int var3, int var4) {
      MediaRouteProviderService.ClientRecord var5 = this.getClient(var1);
      if(var5 != null) {
         MediaRouteProvider.RouteController var6 = var5.getRouteController(var3);
         if(var6 != null) {
            var6.onUpdateVolume(var4);
            if(DEBUG) {
               Log.d("MediaRouteProviderSrv", var5 + ": Route volume updated" + ", controllerId=" + var3 + ", delta=" + var4);
            }

            sendGenericSuccess(var1, var2);
            return true;
         }
      }

      return false;
   }

   private void sendDescriptorChanged(MediaRouteProviderDescriptor var1) {
      Bundle var2;
      if(var1 != null) {
         var2 = var1.asBundle();
      } else {
         var2 = null;
      }

      int var3 = this.mClients.size();

      for(int var4 = 0; var4 < var3; ++var4) {
         MediaRouteProviderService.ClientRecord var5 = (MediaRouteProviderService.ClientRecord)this.mClients.get(var4);
         sendReply(var5.mMessenger, 5, 0, 0, var2, (Bundle)null);
         if(DEBUG) {
            Log.d("MediaRouteProviderSrv", var5 + ": Sent descriptor change event, descriptor=" + var1);
         }
      }

   }

   private static void sendGenericFailure(Messenger var0, int var1) {
      if(var1 != 0) {
         sendReply(var0, 0, var1, 0, (Object)null, (Bundle)null);
      }

   }

   private static void sendGenericSuccess(Messenger var0, int var1) {
      if(var1 != 0) {
         sendReply(var0, 1, var1, 0, (Object)null, (Bundle)null);
      }

   }

   private static void sendReply(Messenger var0, int var1, int var2, int var3, Object var4, Bundle var5) {
      Message var6 = Message.obtain();
      var6.what = var1;
      var6.arg1 = var2;
      var6.arg2 = var3;
      var6.obj = var4;
      var6.setData(var5);

      try {
         var0.send(var6);
      } catch (DeadObjectException var9) {
         ;
      } catch (RemoteException var10) {
         Log.e("MediaRouteProviderSrv", "Could not send message to " + getClientId(var0), var10);
      }
   }

   private boolean updateCompositeDiscoveryRequest() {
      MediaRouteDiscoveryRequest var1 = null;
      MediaRouteSelector.Builder var2 = null;
      boolean var3 = false;
      int var4 = this.mClients.size();

      for(int var5 = 0; var5 < var4; ++var5) {
         MediaRouteDiscoveryRequest var6 = ((MediaRouteProviderService.ClientRecord)this.mClients.get(var5)).mDiscoveryRequest;
         if(var6 != null && (!var6.getSelector().isEmpty() || var6.isActiveScan())) {
            var3 |= var6.isActiveScan();
            if(var1 == null) {
               var1 = var6;
            } else {
               if(var2 == null) {
                  var2 = new MediaRouteSelector.Builder(var1.getSelector());
               }

               var2.addSelector(var6.getSelector());
            }
         }
      }

      if(var2 != null) {
         var1 = new MediaRouteDiscoveryRequest(var2.build(), var3);
      }

      if(this.mCompositeDiscoveryRequest == var1 || this.mCompositeDiscoveryRequest != null && this.mCompositeDiscoveryRequest.equals(var1)) {
         return false;
      } else {
         this.mCompositeDiscoveryRequest = var1;
         this.mProvider.setDiscoveryRequest(var1);
         return true;
      }
   }

   public MediaRouteProvider getMediaRouteProvider() {
      return this.mProvider;
   }

   public IBinder onBind(Intent var1) {
      if(var1.getAction().equals("android.media.MediaRouteProviderService")) {
         if(this.mProvider == null) {
            MediaRouteProvider var2 = this.onCreateMediaRouteProvider();
            if(var2 != null) {
               String var3 = var2.getMetadata().getPackageName();
               if(!var3.equals(this.getPackageName())) {
                  throw new IllegalStateException("onCreateMediaRouteProvider() returned a provider whose package name does not match the package name of the service.  A media route provider service can only export its own media route providers.  Provider package name: " + var3 + ".  Service package name: " + this.getPackageName() + ".");
               }

               this.mProvider = var2;
               this.mProvider.setCallback(this.mProviderCallback);
            }
         }

         if(this.mProvider != null) {
            return this.mReceiveMessenger.getBinder();
         }
      }

      return null;
   }

   public abstract MediaRouteProvider onCreateMediaRouteProvider();

   private final class ClientRecord implements DeathRecipient {
      private final SparseArray<MediaRouteProvider.RouteController> mControllers = new SparseArray();
      public MediaRouteDiscoveryRequest mDiscoveryRequest;
      public final Messenger mMessenger;
      public final int mVersion;

      public ClientRecord(Messenger var2, int var3) {
         this.mMessenger = var2;
         this.mVersion = var3;
      }

      public void binderDied() {
         MediaRouteProviderService.this.mPrivateHandler.obtainMessage(1, this.mMessenger).sendToTarget();
      }

      public boolean createRouteController(String var1, int var2) {
         if(this.mControllers.indexOfKey(var2) < 0) {
            MediaRouteProvider.RouteController var3 = MediaRouteProviderService.this.mProvider.onCreateRouteController(var1);
            if(var3 != null) {
               this.mControllers.put(var2, var3);
               return true;
            }
         }

         return false;
      }

      public void dispose() {
         int var1 = this.mControllers.size();

         for(int var2 = 0; var2 < var1; ++var2) {
            ((MediaRouteProvider.RouteController)this.mControllers.valueAt(var2)).onRelease();
         }

         this.mControllers.clear();
         this.mMessenger.getBinder().unlinkToDeath(this, 0);
         this.setDiscoveryRequest((MediaRouteDiscoveryRequest)null);
      }

      public MediaRouteProvider.RouteController getRouteController(int var1) {
         return (MediaRouteProvider.RouteController)this.mControllers.get(var1);
      }

      public boolean hasMessenger(Messenger var1) {
         return this.mMessenger.getBinder() == var1.getBinder();
      }

      public boolean register() {
         try {
            this.mMessenger.getBinder().linkToDeath(this, 0);
            return true;
         } catch (RemoteException var2) {
            this.binderDied();
            return false;
         }
      }

      public boolean releaseRouteController(int var1) {
         MediaRouteProvider.RouteController var2 = (MediaRouteProvider.RouteController)this.mControllers.get(var1);
         if(var2 != null) {
            this.mControllers.remove(var1);
            var2.onRelease();
            return true;
         } else {
            return false;
         }
      }

      public boolean setDiscoveryRequest(MediaRouteDiscoveryRequest var1) {
         if(this.mDiscoveryRequest == var1 || this.mDiscoveryRequest != null && this.mDiscoveryRequest.equals(var1)) {
            return false;
         } else {
            this.mDiscoveryRequest = var1;
            return MediaRouteProviderService.this.updateCompositeDiscoveryRequest();
         }
      }

      public String toString() {
         return MediaRouteProviderService.getClientId(this.mMessenger);
      }
   }

   private final class PrivateHandler extends Handler {
      private PrivateHandler() {
      }

      // $FF: synthetic method
      PrivateHandler(Object var2) {
         this();
      }

      public void handleMessage(Message var1) {
         switch(var1.what) {
         case 1:
            MediaRouteProviderService.this.onBinderDied((Messenger)var1.obj);
            return;
         default:
         }
      }
   }

   private final class ProviderCallback extends MediaRouteProvider.Callback {
      private ProviderCallback() {
      }

      // $FF: synthetic method
      ProviderCallback(Object var2) {
         this();
      }

      public void onDescriptorChanged(MediaRouteProvider var1, MediaRouteProviderDescriptor var2) {
         MediaRouteProviderService.this.sendDescriptorChanged(var2);
      }
   }

   private static final class ReceiveHandler extends Handler {
      private final WeakReference<MediaRouteProviderService> mServiceRef;

      public ReceiveHandler(MediaRouteProviderService var1) {
         this.mServiceRef = new WeakReference(var1);
      }

      private boolean processMessage(int var1, Messenger var2, int var3, int var4, Object var5, Bundle var6) {
         MediaRouteProviderService var7 = (MediaRouteProviderService)this.mServiceRef.get();
         if(var7 != null) {
            switch(var1) {
            case 1:
               return var7.onRegisterClient(var2, var3, var4);
            case 2:
               return var7.onUnregisterClient(var2, var3);
            case 3:
               String var12 = var6.getString("routeId");
               if(var12 != null) {
                  return var7.onCreateRouteController(var2, var3, var4, var12);
               }
               break;
            case 4:
               return var7.onReleaseRouteController(var2, var3, var4);
            case 5:
               return var7.onSelectRoute(var2, var3, var4);
            case 6:
               int var11 = 0;
               if(var6 != null) {
                  var11 = var6.getInt("unselectReason", 0);
               }

               return var7.onUnselectRoute(var2, var3, var4, var11);
            case 7:
               int var10 = var6.getInt("volume", -1);
               if(var10 >= 0) {
                  return var7.onSetRouteVolume(var2, var3, var4, var10);
               }
               break;
            case 8:
               int var9 = var6.getInt("volume", 0);
               if(var9 != 0) {
                  return var7.onUpdateRouteVolume(var2, var3, var4, var9);
               }
               break;
            case 9:
               if(var5 instanceof Intent) {
                  return var7.onRouteControlRequest(var2, var3, var4, (Intent)var5);
               }
               break;
            case 10:
               if(var5 == null || var5 instanceof Bundle) {
                  MediaRouteDiscoveryRequest var8 = MediaRouteDiscoveryRequest.fromBundle((Bundle)var5);
                  if(var8 == null || !var8.isValid()) {
                     var8 = null;
                  }

                  return var7.onSetDiscoveryRequest(var2, var3, var8);
               }
            }
         }

         return false;
      }

      public void handleMessage(Message var1) {
         Messenger var2 = var1.replyTo;
         if(MediaRouteProviderProtocol.isValidRemoteMessenger(var2)) {
            int var4 = var1.what;
            int var5 = var1.arg1;
            int var6 = var1.arg2;
            Object var7 = var1.obj;
            Bundle var8 = var1.peekData();
            if(!this.processMessage(var4, var2, var5, var6, var7, var8)) {
               if(MediaRouteProviderService.DEBUG) {
                  Log.d("MediaRouteProviderSrv", MediaRouteProviderService.getClientId(var2) + ": Message failed, what=" + var4 + ", requestId=" + var5 + ", arg=" + var6 + ", obj=" + var7 + ", data=" + var8);
               }

               MediaRouteProviderService.sendGenericFailure(var2, var5);
            }
         } else if(MediaRouteProviderService.DEBUG) {
            Log.d("MediaRouteProviderSrv", "Ignoring message without valid reply messenger.");
            return;
         }

      }
   }
}
