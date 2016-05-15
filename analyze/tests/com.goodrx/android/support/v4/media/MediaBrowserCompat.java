package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.MediaBrowserCompatApi21;
import android.support.v4.media.MediaBrowserCompatApi23;
import android.support.v4.media.MediaBrowserCompatUtils;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public final class MediaBrowserCompat {
   public static final String EXTRA_PAGE = "android.media.browse.extra.PAGE";
   public static final String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";
   private static final String TAG = "MediaBrowserCompat";
   private final MediaBrowserCompat.MediaBrowserImpl mImpl;

   public MediaBrowserCompat(Context var1, ComponentName var2, MediaBrowserCompat.ConnectionCallback var3, Bundle var4) {
      if(VERSION.SDK_INT >= 23) {
         this.mImpl = new MediaBrowserCompat.MediaBrowserImplApi23(var1, var2, var3, var4);
      } else if(VERSION.SDK_INT >= 21) {
         this.mImpl = new MediaBrowserCompat.MediaBrowserImplApi21(var1, var2, var3, var4);
      } else {
         this.mImpl = new MediaBrowserCompat.MediaBrowserServiceImplBase(var1, var2, var3, var4);
      }
   }

   public void connect() {
      this.mImpl.connect();
   }

   public void disconnect() {
      this.mImpl.disconnect();
   }

   @Nullable
   public Bundle getExtras() {
      return this.mImpl.getExtras();
   }

   public void getItem(@NonNull String var1, @NonNull MediaBrowserCompat.ItemCallback var2) {
      this.mImpl.getItem(var1, var2);
   }

   @NonNull
   public String getRoot() {
      return this.mImpl.getRoot();
   }

   @NonNull
   public ComponentName getServiceComponent() {
      return this.mImpl.getServiceComponent();
   }

   @NonNull
   public MediaSessionCompat.Token getSessionToken() {
      return this.mImpl.getSessionToken();
   }

   public boolean isConnected() {
      return this.mImpl.isConnected();
   }

   public void subscribe(@NonNull String var1, @NonNull Bundle var2, @NonNull MediaBrowserCompat.SubscriptionCallback var3) {
      if(var2 == null) {
         throw new IllegalArgumentException("options are null");
      } else {
         this.mImpl.subscribe(var1, var2, var3);
      }
   }

   public void subscribe(@NonNull String var1, @NonNull MediaBrowserCompat.SubscriptionCallback var2) {
      this.mImpl.subscribe(var1, (Bundle)null, var2);
   }

   public void unsubscribe(@NonNull String var1) {
      this.mImpl.unsubscribe(var1, (Bundle)null);
   }

   public void unsubscribe(@NonNull String var1, @NonNull Bundle var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("options are null");
      } else {
         this.mImpl.unsubscribe(var1, var2);
      }
   }

   private static class CallbackHandler extends Handler {
      private final MediaBrowserCompat.MediaBrowserServiceCallbackImpl mCallbackImpl;
      private WeakReference<Messenger> mCallbacksMessengerRef;

      CallbackHandler(MediaBrowserCompat.MediaBrowserServiceCallbackImpl var1) {
         this.mCallbackImpl = var1;
      }

      public void handleMessage(Message var1) {
         if(this.mCallbacksMessengerRef != null) {
            Bundle var2 = var1.getData();
            var2.setClassLoader(MediaSessionCompat.class.getClassLoader());
            switch(var1.what) {
            case 1:
               this.mCallbackImpl.onServiceConnected((Messenger)this.mCallbacksMessengerRef.get(), var2.getString("data_media_item_id"), (MediaSessionCompat.Token)var2.getParcelable("data_media_session_token"), var2.getBundle("data_root_hints"));
               return;
            case 2:
               this.mCallbackImpl.onConnectionFailed((Messenger)this.mCallbacksMessengerRef.get());
               return;
            case 3:
               this.mCallbackImpl.onLoadChildren((Messenger)this.mCallbacksMessengerRef.get(), var2.getString("data_media_item_id"), var2.getParcelableArrayList("data_media_item_list"), var2.getBundle("data_options"));
               return;
            default:
               Log.w("MediaBrowserCompat", "Unhandled message: " + var1 + "\n  Client version: " + 1 + "\n  Service version: " + var1.arg1);
            }
         }
      }

      void setCallbacksMessenger(Messenger var1) {
         this.mCallbacksMessengerRef = new WeakReference(var1);
      }
   }

   public static class ConnectionCallback {
      private MediaBrowserCompat.ConnectionCallbackInternal mConnectionCallbackInternal;
      final Object mConnectionCallbackObj;

      public ConnectionCallback() {
         if(VERSION.SDK_INT >= 21) {
            this.mConnectionCallbackObj = MediaBrowserCompatApi21.createConnectionCallback(new MediaBrowserCompat.StubApi21());
         } else {
            this.mConnectionCallbackObj = null;
         }
      }

      public void onConnected() {
      }

      public void onConnectionFailed() {
      }

      public void onConnectionSuspended() {
      }

      void setInternalConnectionCallback(MediaBrowserCompat.ConnectionCallbackInternal var1) {
         this.mConnectionCallbackInternal = var1;
      }
   }

   interface ConnectionCallbackInternal {
      void onConnected();

      void onConnectionFailed();

      void onConnectionSuspended();
   }

   private class StubApi21 implements MediaBrowserCompatApi21.ConnectionCallback {
      private StubApi21() {
      }

      // $FF: synthetic method
      StubApi21(Object var2) {
         this();
      }

      public void onConnected() {
         if(MediaBrowserCompat.super.mConnectionCallbackInternal != null) {
            MediaBrowserCompat.super.mConnectionCallbackInternal.onConnected();
         }

         MediaBrowserCompat.this.onConnected();
      }

      public void onConnectionFailed() {
         if(MediaBrowserCompat.super.mConnectionCallbackInternal != null) {
            MediaBrowserCompat.super.mConnectionCallbackInternal.onConnectionFailed();
         }

         MediaBrowserCompat.this.onConnectionFailed();
      }

      public void onConnectionSuspended() {
         if(MediaBrowserCompat.super.mConnectionCallbackInternal != null) {
            MediaBrowserCompat.super.mConnectionCallbackInternal.onConnectionSuspended();
         }

         MediaBrowserCompat.this.onConnectionSuspended();
      }
   }

   public abstract static class ItemCallback {
      final Object mItemCallbackObj;

      public ItemCallback() {
         if(VERSION.SDK_INT >= 23) {
            this.mItemCallbackObj = MediaBrowserCompatApi23.createItemCallback(new MediaBrowserCompat.StubApi23());
         } else {
            this.mItemCallbackObj = null;
         }
      }

      public void onError(@NonNull String var1) {
      }

      public void onItemLoaded(MediaBrowserCompat.MediaItem var1) {
      }
   }

   private class StubApi23 implements MediaBrowserCompatApi23.ItemCallback {
      private StubApi23() {
      }

      // $FF: synthetic method
      StubApi23(Object var2) {
         this();
      }

      public void onError(@NonNull String var1) {
         MediaBrowserCompat.this.onError(var1);
      }

      public void onItemLoaded(Parcel var1) {
         var1.setDataPosition(0);
         MediaBrowserCompat.MediaItem var2 = (MediaBrowserCompat.MediaItem)MediaBrowserCompat.MediaItem.CREATOR.createFromParcel(var1);
         var1.recycle();
         MediaBrowserCompat.this.onItemLoaded(var2);
      }
   }

   private static class ItemReceiver extends ResultReceiver {
      private final MediaBrowserCompat.ItemCallback mCallback;
      private final String mMediaId;

      ItemReceiver(String var1, MediaBrowserCompat.ItemCallback var2, Handler var3) {
         super(var3);
         this.mMediaId = var1;
         this.mCallback = var2;
      }

      protected void onReceiveResult(int var1, Bundle var2) {
         var2.setClassLoader(MediaBrowserCompat.class.getClassLoader());
         if(var1 == 0 && var2 != null && var2.containsKey("media_item")) {
            Parcelable var3 = var2.getParcelable("media_item");
            if(var3 instanceof MediaBrowserCompat.MediaItem) {
               this.mCallback.onItemLoaded((MediaBrowserCompat.MediaItem)var3);
            } else {
               this.mCallback.onError(this.mMediaId);
            }
         } else {
            this.mCallback.onError(this.mMediaId);
         }
      }
   }

   interface MediaBrowserImpl {
      void connect();

      void disconnect();

      @Nullable
      Bundle getExtras();

      void getItem(@NonNull String var1, @NonNull MediaBrowserCompat.ItemCallback var2);

      @NonNull
      String getRoot();

      ComponentName getServiceComponent();

      @NonNull
      MediaSessionCompat.Token getSessionToken();

      boolean isConnected();

      void subscribe(@NonNull String var1, Bundle var2, @NonNull MediaBrowserCompat.SubscriptionCallback var3);

      void unsubscribe(@NonNull String var1, Bundle var2);
   }

   static class MediaBrowserImplApi21 implements MediaBrowserCompat.ConnectionCallbackInternal, MediaBrowserCompat.MediaBrowserImpl, MediaBrowserCompat.MediaBrowserServiceCallbackImpl {
      private static final boolean DBG;
      protected Object mBrowserObj;
      private Messenger mCallbacksMessenger;
      private final MediaBrowserCompat.CallbackHandler mHandler = new MediaBrowserCompat.CallbackHandler(this);
      private MediaBrowserCompat.ServiceBinderWrapper mServiceBinderWrapper;
      private final ComponentName mServiceComponent;
      private final ArrayMap<String, MediaBrowserCompat.Subscription> mSubscriptions = new ArrayMap();

      public MediaBrowserImplApi21(Context var1, ComponentName var2, MediaBrowserCompat.ConnectionCallback var3, Bundle var4) {
         this.mServiceComponent = var2;
         var3.setInternalConnectionCallback(this);
         this.mBrowserObj = MediaBrowserCompatApi21.createBrowser(var1, var2, var3.mConnectionCallbackObj, var4);
      }

      public void connect() {
         MediaBrowserCompatApi21.connect(this.mBrowserObj);
      }

      public void disconnect() {
         MediaBrowserCompatApi21.disconnect(this.mBrowserObj);
      }

      @Nullable
      public Bundle getExtras() {
         return MediaBrowserCompatApi21.getExtras(this.mBrowserObj);
      }

      public void getItem(@NonNull final String var1, @NonNull final MediaBrowserCompat.ItemCallback var2) {
         if(TextUtils.isEmpty(var1)) {
            throw new IllegalArgumentException("mediaId is empty.");
         } else if(var2 == null) {
            throw new IllegalArgumentException("cb is null.");
         } else if(!MediaBrowserCompatApi21.isConnected(this.mBrowserObj)) {
            Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
            this.mHandler.post(new Runnable() {
               public void run() {
                  var2.onError(var1);
               }
            });
         } else if(this.mServiceBinderWrapper == null) {
            this.mHandler.post(new Runnable() {
               public void run() {
                  var2.onItemLoaded((MediaBrowserCompat.MediaItem)null);
               }
            });
         } else {
            MediaBrowserCompat.ItemReceiver var3 = new MediaBrowserCompat.ItemReceiver(var1, var2, this.mHandler);

            try {
               this.mServiceBinderWrapper.getMediaItem(var1, var3);
            } catch (RemoteException var5) {
               Log.i("MediaBrowserCompat", "Remote error getting media item: " + var1);
               this.mHandler.post(new Runnable() {
                  public void run() {
                     var2.onError(var1);
                  }
               });
            }
         }
      }

      @NonNull
      public String getRoot() {
         return MediaBrowserCompatApi21.getRoot(this.mBrowserObj);
      }

      public ComponentName getServiceComponent() {
         return MediaBrowserCompatApi21.getServiceComponent(this.mBrowserObj);
      }

      @NonNull
      public MediaSessionCompat.Token getSessionToken() {
         return MediaSessionCompat.Token.fromToken(MediaBrowserCompatApi21.getSessionToken(this.mBrowserObj));
      }

      public boolean isConnected() {
         return MediaBrowserCompatApi21.isConnected(this.mBrowserObj);
      }

      public void onConnected() {
         Bundle var1 = MediaBrowserCompatApi21.getExtras(this.mBrowserObj);
         if(var1 != null) {
            IBinder var2 = BundleCompat.getBinder(var1, "extra_messenger");
            if(var2 != null) {
               this.mServiceBinderWrapper = new MediaBrowserCompat.ServiceBinderWrapper(var2);
               this.mCallbacksMessenger = new Messenger(this.mHandler);
               this.mHandler.setCallbacksMessenger(this.mCallbacksMessenger);

               try {
                  this.mServiceBinderWrapper.registerCallbackMessenger(this.mCallbacksMessenger);
               } catch (RemoteException var4) {
                  Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
               }

               this.onServiceConnected(this.mCallbacksMessenger, (String)null, (MediaSessionCompat.Token)null, (Bundle)null);
               return;
            }
         }

      }

      public void onConnectionFailed() {
      }

      public void onConnectionFailed(Messenger var1) {
      }

      public void onConnectionSuspended() {
         this.mServiceBinderWrapper = null;
         this.mCallbacksMessenger = null;
      }

      public void onLoadChildren(Messenger var1, String var2, List var3, @NonNull Bundle var4) {
         if(this.mCallbacksMessenger == var1) {
            MediaBrowserCompat.Subscription var5 = (MediaBrowserCompat.Subscription)this.mSubscriptions.get(var2);
            if(var5 != null) {
               var5.getCallback(var4).onChildrenLoaded(var2, var3, var4);
               return;
            }
         }

      }

      public void onServiceConnected(Messenger var1, String var2, MediaSessionCompat.Token var3, Bundle var4) {
         Iterator var5 = this.mSubscriptions.entrySet().iterator();

         while(var5.hasNext()) {
            Entry var6 = (Entry)var5.next();
            String var7 = (String)var6.getKey();
            MediaBrowserCompat.Subscription var8 = (MediaBrowserCompat.Subscription)var6.getValue();
            List var9 = var8.getOptionsList();
            List var10 = var8.getCallbacks();

            for(int var11 = 0; var11 < var9.size(); ++var11) {
               if(var9.get(var11) == null) {
                  MediaBrowserCompatApi21.subscribe(this.mBrowserObj, var7, ((MediaBrowserCompat.SubscriptionCallbackApi21)var10.get(var11)).mSubscriptionCallbackObj);
               } else {
                  try {
                     this.mServiceBinderWrapper.addSubscription(var7, (Bundle)var9.get(var11), this.mCallbacksMessenger);
                  } catch (RemoteException var13) {
                     Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException parentId=" + var7);
                  }
               }
            }
         }

      }

      public void subscribe(@NonNull String var1, Bundle var2, @NonNull MediaBrowserCompat.SubscriptionCallback var3) {
         MediaBrowserCompat.SubscriptionCallbackApi21 var4 = new MediaBrowserCompat.SubscriptionCallbackApi21(var3, var2);
         MediaBrowserCompat.Subscription var5 = (MediaBrowserCompat.Subscription)this.mSubscriptions.get(var1);
         if(var5 == null) {
            var5 = new MediaBrowserCompat.Subscription();
            this.mSubscriptions.put(var1, var5);
         }

         var5.setCallbackForOptions(var4, var2);
         if(MediaBrowserCompatApi21.isConnected(this.mBrowserObj)) {
            if(var2 != null && this.mServiceBinderWrapper != null) {
               try {
                  this.mServiceBinderWrapper.addSubscription(var1, var2, this.mCallbacksMessenger);
                  return;
               } catch (RemoteException var8) {
                  Log.i("MediaBrowserCompat", "Remote error subscribing media item: " + var1);
                  return;
               }
            }

            MediaBrowserCompatApi21.subscribe(this.mBrowserObj, var1, var4.mSubscriptionCallbackObj);
         }

      }

      public void unsubscribe(@NonNull String var1, Bundle var2) {
         if(TextUtils.isEmpty(var1)) {
            throw new IllegalArgumentException("parentId is empty.");
         } else {
            MediaBrowserCompat.Subscription var3 = (MediaBrowserCompat.Subscription)this.mSubscriptions.get(var1);
            if(var3 != null && var3.remove(var2)) {
               if(var2 != null && this.mServiceBinderWrapper != null) {
                  if(this.mServiceBinderWrapper == null) {
                     try {
                        this.mServiceBinderWrapper.removeSubscription(var1, var2, this.mCallbacksMessenger);
                     } catch (RemoteException var6) {
                        Log.d("MediaBrowserCompat", "removeSubscription failed with RemoteException parentId=" + var1);
                     }
                  }
               } else if(this.mServiceBinderWrapper != null || var3.isEmpty()) {
                  MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, var1);
               }
            }

            if(var3 != null && var3.isEmpty()) {
               this.mSubscriptions.remove(var1);
            }

         }
      }
   }

   static class MediaBrowserImplApi23 extends MediaBrowserCompat.MediaBrowserImplApi21 {
      public MediaBrowserImplApi23(Context var1, ComponentName var2, MediaBrowserCompat.ConnectionCallback var3, Bundle var4) {
         super(var1, var2, var3, var4);
      }

      public void getItem(@NonNull String var1, @NonNull MediaBrowserCompat.ItemCallback var2) {
         MediaBrowserCompatApi23.getItem(this.mBrowserObj, var1, var2.mItemCallbackObj);
      }
   }

   interface MediaBrowserServiceCallbackImpl {
      void onConnectionFailed(Messenger var1);

      void onLoadChildren(Messenger var1, String var2, List var3, Bundle var4);

      void onServiceConnected(Messenger var1, String var2, MediaSessionCompat.Token var3, Bundle var4);
   }

   static class MediaBrowserServiceImplBase implements MediaBrowserCompat.MediaBrowserImpl, MediaBrowserCompat.MediaBrowserServiceCallbackImpl {
      private static final int CONNECT_STATE_CONNECTED = 2;
      private static final int CONNECT_STATE_CONNECTING = 1;
      private static final int CONNECT_STATE_DISCONNECTED = 0;
      private static final int CONNECT_STATE_SUSPENDED = 3;
      private static final boolean DBG;
      private final MediaBrowserCompat.ConnectionCallback mCallback;
      private Messenger mCallbacksMessenger;
      private final Context mContext;
      private Bundle mExtras;
      private final MediaBrowserCompat.CallbackHandler mHandler = new MediaBrowserCompat.CallbackHandler(this);
      private MediaSessionCompat.Token mMediaSessionToken;
      private final Bundle mRootHints;
      private String mRootId;
      private MediaBrowserCompat.ServiceBinderWrapper mServiceBinderWrapper;
      private final ComponentName mServiceComponent;
      private MediaBrowserCompat.MediaServiceConnection mServiceConnection;
      private int mState = 0;
      private final ArrayMap<String, MediaBrowserCompat.Subscription> mSubscriptions = new ArrayMap();

      public MediaBrowserServiceImplBase(Context var1, ComponentName var2, MediaBrowserCompat.ConnectionCallback var3, Bundle var4) {
         if(var1 == null) {
            throw new IllegalArgumentException("context must not be null");
         } else if(var2 == null) {
            throw new IllegalArgumentException("service component must not be null");
         } else if(var3 == null) {
            throw new IllegalArgumentException("connection callback must not be null");
         } else {
            this.mContext = var1;
            this.mServiceComponent = var2;
            this.mCallback = var3;
            this.mRootHints = var4;
         }
      }

      private void forceCloseConnection() {
         if(this.mServiceConnection != null) {
            this.mContext.unbindService(this.mServiceConnection);
         }

         this.mState = 0;
         this.mServiceConnection = null;
         this.mServiceBinderWrapper = null;
         this.mCallbacksMessenger = null;
         this.mRootId = null;
         this.mMediaSessionToken = null;
      }

      private static String getStateLabel(int var0) {
         switch(var0) {
         case 0:
            return "CONNECT_STATE_DISCONNECTED";
         case 1:
            return "CONNECT_STATE_CONNECTING";
         case 2:
            return "CONNECT_STATE_CONNECTED";
         case 3:
            return "CONNECT_STATE_SUSPENDED";
         default:
            return "UNKNOWN/" + var0;
         }
      }

      private boolean isCurrent(Messenger var1, String var2) {
         if(this.mCallbacksMessenger != var1) {
            if(this.mState != 0) {
               Log.i("MediaBrowserCompat", var2 + " for " + this.mServiceComponent + " with mCallbacksMessenger=" + this.mCallbacksMessenger + " this=" + this);
            }

            return false;
         } else {
            return true;
         }
      }

      public void connect() {
         if(this.mState != 0) {
            throw new IllegalStateException("connect() called while not disconnected (state=" + getStateLabel(this.mState) + ")");
         } else if(this.mServiceBinderWrapper != null) {
            throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + this.mServiceBinderWrapper);
         } else if(this.mCallbacksMessenger != null) {
            throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + this.mCallbacksMessenger);
         } else {
            this.mState = 1;
            Intent var1 = new Intent("android.media.browse.MediaBrowserService");
            var1.setComponent(this.mServiceComponent);
            final MediaBrowserCompat.MediaServiceConnection var3 = new MediaBrowserCompat.MediaServiceConnection();
            this.mServiceConnection = var3;

            boolean var6;
            label24: {
               boolean var8;
               try {
                  var8 = this.mContext.bindService(var1, this.mServiceConnection, 1);
               } catch (Exception var9) {
                  Log.e("MediaBrowserCompat", "Failed binding to service " + this.mServiceComponent);
                  var6 = false;
                  break label24;
               }

               var6 = var8;
            }

            if(!var6) {
               this.mHandler.post(new Runnable() {
                  public void run() {
                     if(var3 == MediaBrowserServiceImplBase.this.mServiceConnection) {
                        MediaBrowserServiceImplBase.this.forceCloseConnection();
                        MediaBrowserServiceImplBase.this.mCallback.onConnectionFailed();
                     }

                  }
               });
            }

         }
      }

      public void disconnect() {
         if(this.mCallbacksMessenger != null) {
            try {
               this.mServiceBinderWrapper.disconnect(this.mCallbacksMessenger);
            } catch (RemoteException var2) {
               Log.w("MediaBrowserCompat", "RemoteException during connect for " + this.mServiceComponent);
            }
         }

         this.forceCloseConnection();
      }

      void dump() {
         Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
         Log.d("MediaBrowserCompat", "  mServiceComponent=" + this.mServiceComponent);
         Log.d("MediaBrowserCompat", "  mCallback=" + this.mCallback);
         Log.d("MediaBrowserCompat", "  mRootHints=" + this.mRootHints);
         Log.d("MediaBrowserCompat", "  mState=" + getStateLabel(this.mState));
         Log.d("MediaBrowserCompat", "  mServiceConnection=" + this.mServiceConnection);
         Log.d("MediaBrowserCompat", "  mServiceBinderWrapper=" + this.mServiceBinderWrapper);
         Log.d("MediaBrowserCompat", "  mCallbacksMessenger=" + this.mCallbacksMessenger);
         Log.d("MediaBrowserCompat", "  mRootId=" + this.mRootId);
         Log.d("MediaBrowserCompat", "  mMediaSessionToken=" + this.mMediaSessionToken);
      }

      @Nullable
      public Bundle getExtras() {
         if(!this.isConnected()) {
            throw new IllegalStateException("getExtras() called while not connected (state=" + getStateLabel(this.mState) + ")");
         } else {
            return this.mExtras;
         }
      }

      public void getItem(@NonNull final String var1, @NonNull final MediaBrowserCompat.ItemCallback var2) {
         if(TextUtils.isEmpty(var1)) {
            throw new IllegalArgumentException("mediaId is empty.");
         } else if(var2 == null) {
            throw new IllegalArgumentException("cb is null.");
         } else if(this.mState != 2) {
            Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
            this.mHandler.post(new Runnable() {
               public void run() {
                  var2.onError(var1);
               }
            });
         } else {
            MediaBrowserCompat.ItemReceiver var3 = new MediaBrowserCompat.ItemReceiver(var1, var2, this.mHandler);

            try {
               this.mServiceBinderWrapper.getMediaItem(var1, var3);
            } catch (RemoteException var5) {
               Log.i("MediaBrowserCompat", "Remote error getting media item.");
               this.mHandler.post(new Runnable() {
                  public void run() {
                     var2.onError(var1);
                  }
               });
            }
         }
      }

      @NonNull
      public String getRoot() {
         if(!this.isConnected()) {
            throw new IllegalStateException("getRoot() called while not connected(state=" + getStateLabel(this.mState) + ")");
         } else {
            return this.mRootId;
         }
      }

      @NonNull
      public ComponentName getServiceComponent() {
         if(!this.isConnected()) {
            throw new IllegalStateException("getServiceComponent() called while not connected (state=" + this.mState + ")");
         } else {
            return this.mServiceComponent;
         }
      }

      @NonNull
      public MediaSessionCompat.Token getSessionToken() {
         if(!this.isConnected()) {
            throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.mState + ")");
         } else {
            return this.mMediaSessionToken;
         }
      }

      public boolean isConnected() {
         return this.mState == 2;
      }

      public void onConnectionFailed(Messenger var1) {
         Log.e("MediaBrowserCompat", "onConnectFailed for " + this.mServiceComponent);
         if(this.isCurrent(var1, "onConnectFailed")) {
            if(this.mState != 1) {
               Log.w("MediaBrowserCompat", "onConnect from service while mState=" + getStateLabel(this.mState) + "... ignoring");
            } else {
               this.forceCloseConnection();
               this.mCallback.onConnectionFailed();
            }
         }
      }

      public void onLoadChildren(Messenger var1, String var2, List var3, Bundle var4) {
         if(this.isCurrent(var1, "onLoadChildren")) {
            MediaBrowserCompat.Subscription var5 = (MediaBrowserCompat.Subscription)this.mSubscriptions.get(var2);
            if(var5 != null) {
               MediaBrowserCompat.SubscriptionCallback var6 = var5.getCallback(var4);
               if(var6 != null) {
                  if(var4 == null) {
                     var6.onChildrenLoaded(var2, var3);
                     return;
                  }

                  var6.onChildrenLoaded(var2, var3, var4);
                  return;
               }
            }
         }

      }

      public void onServiceConnected(Messenger param1, String param2, MediaSessionCompat.Token param3, Bundle param4) {
         // $FF: Couldn't be decompiled
      }

      public void subscribe(@NonNull String var1, Bundle var2, @NonNull MediaBrowserCompat.SubscriptionCallback var3) {
         if(TextUtils.isEmpty(var1)) {
            throw new IllegalArgumentException("parentId is empty.");
         } else if(var3 == null) {
            throw new IllegalArgumentException("callback is null");
         } else {
            MediaBrowserCompat.Subscription var4 = (MediaBrowserCompat.Subscription)this.mSubscriptions.get(var1);
            if(var4 == null) {
               var4 = new MediaBrowserCompat.Subscription();
               this.mSubscriptions.put(var1, var4);
            }

            var4.setCallbackForOptions(var3, var2);
            if(this.mState == 2) {
               try {
                  this.mServiceBinderWrapper.addSubscription(var1, var2, this.mCallbacksMessenger);
               } catch (RemoteException var7) {
                  Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException parentId=" + var1);
                  return;
               }
            }

         }
      }

      public void unsubscribe(@NonNull String var1, Bundle var2) {
         if(TextUtils.isEmpty(var1)) {
            throw new IllegalArgumentException("parentId is empty.");
         } else {
            MediaBrowserCompat.Subscription var3 = (MediaBrowserCompat.Subscription)this.mSubscriptions.get(var1);
            if(var3 != null && var3.remove(var2) && this.mState == 2) {
               try {
                  this.mServiceBinderWrapper.removeSubscription(var1, var2, this.mCallbacksMessenger);
               } catch (RemoteException var6) {
                  Log.d("MediaBrowserCompat", "removeSubscription failed with RemoteException parentId=" + var1);
               }
            }

            if(var3 != null && var3.isEmpty()) {
               this.mSubscriptions.remove(var1);
            }

         }
      }
   }

   private class MediaServiceConnection implements ServiceConnection {
      private MediaServiceConnection() {
      }

      // $FF: synthetic method
      MediaServiceConnection(Object var2) {
         this();
      }

      private boolean isCurrent(String var1) {
         if(MediaBrowserCompat.super.mServiceConnection != this) {
            if(MediaBrowserCompat.super.mState != 0) {
               Log.i("MediaBrowserCompat", var1 + " for " + MediaBrowserCompat.super.mServiceComponent + " with mServiceConnection=" + MediaBrowserCompat.super.mServiceConnection + " this=" + this);
            }

            return false;
         } else {
            return true;
         }
      }

      private void postOrRun(Runnable var1) {
         if(Thread.currentThread() == MediaBrowserCompat.super.mHandler.getLooper().getThread()) {
            var1.run();
         } else {
            MediaBrowserCompat.super.mHandler.post(var1);
         }
      }

      public void onServiceConnected(final ComponentName var1, final IBinder var2) {
         this.postOrRun(new Runnable() {
            public void run() {
               if(MediaServiceConnection.this.isCurrent("onServiceConnected")) {
                  MediaBrowserCompat.super.mServiceBinderWrapper = new MediaBrowserCompat.ServiceBinderWrapper(var2);
                  MediaBrowserCompat.super.mCallbacksMessenger = new Messenger(MediaBrowserCompat.super.mHandler);
                  MediaBrowserCompat.super.mHandler.setCallbacksMessenger(MediaBrowserCompat.super.mCallbacksMessenger);
                  MediaBrowserCompat.super.mState = 1;

                  try {
                     MediaBrowserCompat.super.mServiceBinderWrapper.connect(MediaBrowserCompat.super.mContext, MediaBrowserCompat.super.mRootHints, MediaBrowserCompat.super.mCallbacksMessenger);
                  } catch (RemoteException var5) {
                     Log.w("MediaBrowserCompat", "RemoteException during connect for " + MediaBrowserCompat.super.mServiceComponent);
                  }
               }
            }
         });
      }

      public void onServiceDisconnected(final ComponentName var1) {
         this.postOrRun(new Runnable() {
            public void run() {
               if(MediaServiceConnection.this.isCurrent("onServiceDisconnected")) {
                  MediaBrowserCompat.super.mServiceBinderWrapper = null;
                  MediaBrowserCompat.super.mCallbacksMessenger = null;
                  MediaBrowserCompat.super.mHandler.setCallbacksMessenger((Messenger)null);
                  MediaBrowserCompat.super.mState = 3;
                  MediaBrowserCompat.super.mCallback.onConnectionSuspended();
               }
            }
         });
      }
   }

   public static class MediaItem implements Parcelable {
      public static final Creator<MediaBrowserCompat.MediaItem> CREATOR = new Creator() {
         public MediaBrowserCompat.MediaItem createFromParcel(Parcel var1) {
            return new MediaBrowserCompat.MediaItem(var1);
         }

         public MediaBrowserCompat.MediaItem[] newArray(int var1) {
            return new MediaBrowserCompat.MediaItem[var1];
         }
      };
      public static final int FLAG_BROWSABLE = 1;
      public static final int FLAG_PLAYABLE = 2;
      private final MediaDescriptionCompat mDescription;
      private final int mFlags;

      private MediaItem(Parcel var1) {
         this.mFlags = var1.readInt();
         this.mDescription = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(var1);
      }

      // $FF: synthetic method
      MediaItem(Parcel var1, Object var2) {
         this(var1);
      }

      public MediaItem(@NonNull MediaDescriptionCompat var1, int var2) {
         if(var1 == null) {
            throw new IllegalArgumentException("description cannot be null");
         } else if(TextUtils.isEmpty(var1.getMediaId())) {
            throw new IllegalArgumentException("description must have a non-empty media id");
         } else {
            this.mFlags = var2;
            this.mDescription = var1;
         }
      }

      public int describeContents() {
         return 0;
      }

      @NonNull
      public MediaDescriptionCompat getDescription() {
         return this.mDescription;
      }

      public int getFlags() {
         return this.mFlags;
      }

      @NonNull
      public String getMediaId() {
         return this.mDescription.getMediaId();
      }

      public boolean isBrowsable() {
         return (1 & this.mFlags) != 0;
      }

      public boolean isPlayable() {
         return (2 & this.mFlags) != 0;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("MediaItem{");
         var1.append("mFlags=").append(this.mFlags);
         var1.append(", mDescription=").append(this.mDescription);
         var1.append('}');
         return var1.toString();
      }

      public void writeToParcel(Parcel var1, int var2) {
         var1.writeInt(this.mFlags);
         this.mDescription.writeToParcel(var1, var2);
      }
   }

   @Retention(RetentionPolicy.SOURCE)
   public @interface Flags {
   }

   private static class ServiceBinderWrapper {
      private Messenger mMessenger;

      public ServiceBinderWrapper(IBinder var1) {
         this.mMessenger = new Messenger(var1);
      }

      private void sendRequest(int var1, Bundle var2, Messenger var3) throws RemoteException {
         Message var4 = Message.obtain();
         var4.what = var1;
         var4.arg1 = 1;
         var4.setData(var2);
         var4.replyTo = var3;
         this.mMessenger.send(var4);
      }

      void addSubscription(String var1, Bundle var2, Messenger var3) throws RemoteException {
         Bundle var4 = new Bundle();
         var4.putString("data_media_item_id", var1);
         var4.putBundle("data_options", var2);
         this.sendRequest(3, var4, var3);
      }

      void connect(Context var1, Bundle var2, Messenger var3) throws RemoteException {
         Bundle var4 = new Bundle();
         var4.putString("data_package_name", var1.getPackageName());
         var4.putBundle("data_root_hints", var2);
         this.sendRequest(1, var4, var3);
      }

      void disconnect(Messenger var1) throws RemoteException {
         this.sendRequest(2, (Bundle)null, var1);
      }

      void getMediaItem(String var1, ResultReceiver var2) throws RemoteException {
         Bundle var3 = new Bundle();
         var3.putString("data_media_item_id", var1);
         var3.putParcelable("data_result_receiver", var2);
         this.sendRequest(5, var3, (Messenger)null);
      }

      void registerCallbackMessenger(Messenger var1) throws RemoteException {
         this.sendRequest(6, (Bundle)null, var1);
      }

      void removeSubscription(String var1, Bundle var2, Messenger var3) throws RemoteException {
         Bundle var4 = new Bundle();
         var4.putString("data_media_item_id", var1);
         var4.putBundle("data_options", var2);
         this.sendRequest(4, var4, var3);
      }
   }

   private static class Subscription {
      private final List<MediaBrowserCompat.SubscriptionCallback> mCallbacks = new ArrayList();
      private final List<Bundle> mOptionsList = new ArrayList();

      public MediaBrowserCompat.SubscriptionCallback getCallback(Bundle var1) {
         for(int var2 = 0; var2 < this.mOptionsList.size(); ++var2) {
            if(MediaBrowserCompatUtils.areSameOptions((Bundle)this.mOptionsList.get(var2), var1)) {
               return (MediaBrowserCompat.SubscriptionCallback)this.mCallbacks.get(var2);
            }
         }

         return null;
      }

      public List<MediaBrowserCompat.SubscriptionCallback> getCallbacks() {
         return this.mCallbacks;
      }

      public List<Bundle> getOptionsList() {
         return this.mOptionsList;
      }

      public boolean isEmpty() {
         return this.mCallbacks.isEmpty();
      }

      public boolean remove(Bundle var1) {
         for(int var2 = 0; var2 < this.mOptionsList.size(); ++var2) {
            if(MediaBrowserCompatUtils.areSameOptions((Bundle)this.mOptionsList.get(var2), var1)) {
               this.mCallbacks.remove(var2);
               this.mOptionsList.remove(var2);
               return true;
            }
         }

         return false;
      }

      public void setCallbackForOptions(MediaBrowserCompat.SubscriptionCallback var1, Bundle var2) {
         for(int var3 = 0; var3 < this.mOptionsList.size(); ++var3) {
            if(MediaBrowserCompatUtils.areSameOptions((Bundle)this.mOptionsList.get(var3), var2)) {
               this.mCallbacks.set(var3, var1);
               return;
            }
         }

         this.mCallbacks.add(var1);
         this.mOptionsList.add(var2);
      }
   }

   public abstract static class SubscriptionCallback {
      public void onChildrenLoaded(@NonNull String var1, List<MediaBrowserCompat.MediaItem> var2) {
      }

      public void onChildrenLoaded(@NonNull String var1, List<MediaBrowserCompat.MediaItem> var2, @NonNull Bundle var3) {
      }

      public void onError(@NonNull String var1) {
      }

      public void onError(@NonNull String var1, @NonNull Bundle var2) {
      }
   }

   static class SubscriptionCallbackApi21 extends MediaBrowserCompat.SubscriptionCallback {
      private Bundle mOptions;
      MediaBrowserCompat.SubscriptionCallback mSubscriptionCallback;
      private final Object mSubscriptionCallbackObj;

      public SubscriptionCallbackApi21(MediaBrowserCompat.SubscriptionCallback var1, Bundle var2) {
         this.mSubscriptionCallback = var1;
         this.mOptions = var2;
         this.mSubscriptionCallbackObj = MediaBrowserCompatApi21.createSubscriptionCallback(new MediaBrowserCompat.StubApi21());
      }

      public void onChildrenLoaded(@NonNull String var1, List<MediaBrowserCompat.MediaItem> var2) {
         this.mSubscriptionCallback.onChildrenLoaded(var1, var2);
      }

      public void onChildrenLoaded(@NonNull String var1, List<MediaBrowserCompat.MediaItem> var2, @NonNull Bundle var3) {
         this.mSubscriptionCallback.onChildrenLoaded(var1, var2, var3);
      }

      public void onError(@NonNull String var1) {
         this.mSubscriptionCallback.onError(var1);
      }

      public void onError(@NonNull String var1, @NonNull Bundle var2) {
         this.mSubscriptionCallback.onError(var1, var2);
      }
   }

   private class StubApi21 implements MediaBrowserCompatApi21.SubscriptionCallback {
      private StubApi21() {
      }

      // $FF: synthetic method
      StubApi21(Object var2) {
         this();
      }

      public void onChildrenLoaded(@NonNull String var1, List<Parcel> var2) {
         ArrayList var3 = null;
         if(var2 != null) {
            var3 = new ArrayList();
            Iterator var4 = var2.iterator();

            while(var4.hasNext()) {
               Parcel var5 = (Parcel)var4.next();
               var5.setDataPosition(0);
               var3.add(MediaBrowserCompat.MediaItem.CREATOR.createFromParcel(var5));
               var5.recycle();
            }
         }

         if(MediaBrowserCompat.super.mOptions != null) {
            MediaBrowserCompat.this.onChildrenLoaded(var1, MediaBrowserCompatUtils.applyOptions(var3, MediaBrowserCompat.super.mOptions), MediaBrowserCompat.super.mOptions);
         } else {
            MediaBrowserCompat.this.onChildrenLoaded(var1, var3);
         }
      }

      public void onError(@NonNull String var1) {
         if(MediaBrowserCompat.super.mOptions != null) {
            MediaBrowserCompat.this.onError(var1, MediaBrowserCompat.super.mOptions);
         } else {
            MediaBrowserCompat.this.onError(var1);
         }
      }
   }
}
