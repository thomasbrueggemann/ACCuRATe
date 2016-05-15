package android.support.v4.media;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserCompatUtils;
import android.support.v4.media.MediaBrowserServiceCompatApi21;
import android.support.v4.media.MediaBrowserServiceCompatApi23;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class MediaBrowserServiceCompat extends Service {
   private static final boolean DBG = false;
   public static final String KEY_MEDIA_ITEM = "media_item";
   private static final int RESULT_FLAG_OPTION_NOT_HANDLED = 1;
   public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
   private static final String TAG = "MediaBrowserServiceCompat";
   private final ArrayMap<IBinder, MediaBrowserServiceCompat.ConnectionRecord> mConnections = new ArrayMap();
   private final MediaBrowserServiceCompat.ServiceHandler mHandler = new MediaBrowserServiceCompat.ServiceHandler(null);
   private MediaBrowserServiceCompat.MediaBrowserServiceImpl mImpl;
   MediaSessionCompat.Token mSession;

   private void addSubscription(String var1, MediaBrowserServiceCompat.ConnectionRecord var2, Bundle var3) {
      Object var4 = (List)var2.subscriptions.get(var1);
      if(var4 == null) {
         var4 = new ArrayList();
      }

      Iterator var5 = ((List)var4).iterator();

      do {
         if(!var5.hasNext()) {
            ((List)var4).add(var3);
            var2.subscriptions.put(var1, var4);
            this.performLoadChildren(var1, var2, var3);
            return;
         }
      } while(!MediaBrowserCompatUtils.areSameOptions(var3, (Bundle)var5.next()));

   }

   private List<MediaBrowserCompat.MediaItem> applyOptions(List<MediaBrowserCompat.MediaItem> var1, Bundle var2) {
      int var3 = var2.getInt("android.media.browse.extra.PAGE", -1);
      int var4 = var2.getInt("android.media.browse.extra.PAGE_SIZE", -1);
      if(var3 == -1 && var4 == -1) {
         return var1;
      } else {
         int var5 = var4 * (var3 - 1);
         int var6 = var5 + var4;
         if(var3 >= 1 && var4 >= 1 && var5 < var1.size()) {
            if(var6 > var1.size()) {
               var6 = var1.size();
            }

            return var1.subList(var5, var6);
         } else {
            return Collections.emptyList();
         }
      }
   }

   private boolean isValidPackage(String var1, int var2) {
      if(var1 != null) {
         String[] var3 = this.getPackageManager().getPackagesForUid(var2);
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            if(var3[var5].equals(var1)) {
               return true;
            }
         }
      }

      return false;
   }

   private void notifyChildrenChangedInternal(final String var1, final Bundle var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
      } else {
         this.mHandler.post(new Runnable() {
            public void run() {
               Iterator var1x = MediaBrowserServiceCompat.this.mConnections.keySet().iterator();

               while(true) {
                  while(true) {
                     MediaBrowserServiceCompat.ConnectionRecord var3;
                     List var4;
                     do {
                        if(!var1x.hasNext()) {
                           return;
                        }

                        IBinder var2x = (IBinder)var1x.next();
                        var3 = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(var2x);
                        var4 = (List)var3.subscriptions.get(var1);
                     } while(var4 == null);

                     Iterator var5 = var4.iterator();

                     while(var5.hasNext()) {
                        Bundle var6 = (Bundle)var5.next();
                        if(MediaBrowserCompatUtils.hasDuplicatedItems(var2, var6)) {
                           MediaBrowserServiceCompat.this.performLoadChildren(var1, var3, var6);
                           break;
                        }
                     }
                  }
               }
            }
         });
      }
   }

   private void performLoadChildren(final String var1, final MediaBrowserServiceCompat.ConnectionRecord var2, final Bundle var3) {
      MediaBrowserServiceCompat.Result var4 = new MediaBrowserServiceCompat.Result(var1) {
         void onResultSent(List<MediaBrowserCompat.MediaItem> var1x, int var2x) {
            if(MediaBrowserServiceCompat.this.mConnections.get(var2.callbacks.asBinder()) == var2) {
               List var3x;
               if((var2x & 1) != 0) {
                  var3x = MediaBrowserCompatUtils.applyOptions(var1x, var3);
               } else {
                  var3x = var1x;
               }

               try {
                  var2.callbacks.onLoadChildren(var1, var3x, var3);
               } catch (RemoteException var5) {
                  Log.w("MediaBrowserServiceCompat", "Calling onLoadChildren() failed for id=" + var1 + " package=" + var2.pkg);
               }
            }
         }
      };
      if(var3 == null) {
         this.onLoadChildren(var1, var4);
      } else {
         this.onLoadChildren(var1, var4, var3);
      }

      if(!var4.isDone()) {
         throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + var2.pkg + " id=" + var1);
      }
   }

   private void performLoadItem(final String var1, final ResultReceiver var2) {
      MediaBrowserServiceCompat.Result var3 = new MediaBrowserServiceCompat.Result(var1) {
         void onResultSent(MediaBrowserCompat.MediaItem var1, int var2x) {
            Bundle var3 = new Bundle();
            var3.putParcelable("media_item", var1);
            var2.send(0, var3);
         }
      };
      this.onLoadItem(var1, var3);
      if(!var3.isDone()) {
         throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + var1);
      }
   }

   private boolean removeSubscription(String var1, MediaBrowserServiceCompat.ConnectionRecord var2, Bundle var3) {
      List var4 = (List)var2.subscriptions.get(var1);
      boolean var5 = false;
      if(var4 != null) {
         Iterator var6 = var4.iterator();

         while(true) {
            boolean var7 = var6.hasNext();
            var5 = false;
            if(!var7) {
               break;
            }

            Bundle var9 = (Bundle)var6.next();
            if(MediaBrowserCompatUtils.areSameOptions(var3, var9)) {
               var5 = true;
               var4.remove(var9);
               break;
            }
         }

         if(var4.size() == 0) {
            var2.subscriptions.remove(var1);
         }
      }

      return var5;
   }

   public void dump(FileDescriptor var1, PrintWriter var2, String[] var3) {
   }

   @Nullable
   public MediaSessionCompat.Token getSessionToken() {
      return this.mSession;
   }

   public void notifyChildrenChanged(@NonNull String var1) {
      this.notifyChildrenChangedInternal(var1, (Bundle)null);
   }

   public void notifyChildrenChanged(@NonNull String var1, @NonNull Bundle var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
      } else {
         this.notifyChildrenChangedInternal(var1, var2);
      }
   }

   public IBinder onBind(Intent var1) {
      return this.mImpl.onBind(var1);
   }

   public void onCreate() {
      super.onCreate();
      if(VERSION.SDK_INT >= 23) {
         this.mImpl = new MediaBrowserServiceCompat.MediaBrowserServiceImplApi23();
      } else if(VERSION.SDK_INT >= 21) {
         this.mImpl = new MediaBrowserServiceCompat.MediaBrowserServiceImplApi21();
      } else {
         this.mImpl = new MediaBrowserServiceCompat.MediaBrowserServiceImplBase();
      }

      this.mImpl.onCreate();
   }

   @Nullable
   public abstract MediaBrowserServiceCompat.BrowserRoot onGetRoot(@NonNull String var1, int var2, @Nullable Bundle var3);

   public abstract void onLoadChildren(@NonNull String var1, @NonNull MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> var2);

   public void onLoadChildren(@NonNull String var1, @NonNull MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> var2, @NonNull Bundle var3) {
      var2.setFlags(1);
      this.onLoadChildren(var1, var2);
   }

   public void onLoadItem(String var1, MediaBrowserServiceCompat.Result<MediaBrowserCompat.MediaItem> var2) {
      var2.sendResult((Object)null);
   }

   public void setSessionToken(final MediaSessionCompat.Token var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Session token may not be null.");
      } else if(this.mSession != null) {
         throw new IllegalStateException("The session token has already been set.");
      } else {
         this.mSession = var1;
         this.mHandler.post(new Runnable() {
            public void run() {
               Iterator var1x = MediaBrowserServiceCompat.this.mConnections.keySet().iterator();

               while(var1x.hasNext()) {
                  IBinder var2 = (IBinder)var1x.next();
                  MediaBrowserServiceCompat.ConnectionRecord var3 = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(var2);

                  try {
                     var3.callbacks.onConnect(var3.root.getRootId(), var1, var3.root.getExtras());
                  } catch (RemoteException var5) {
                     Log.w("MediaBrowserServiceCompat", "Connection for " + var3.pkg + " is no longer valid.");
                     MediaBrowserServiceCompat.this.mConnections.remove(var2);
                  }
               }

            }
         });
      }
   }

   public static final class BrowserRoot {
      public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
      public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
      public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";
      private final Bundle mExtras;
      private final String mRootId;

      public BrowserRoot(@NonNull String var1, @Nullable Bundle var2) {
         if(var1 == null) {
            throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
         } else {
            this.mRootId = var1;
            this.mExtras = var2;
         }
      }

      public Bundle getExtras() {
         return this.mExtras;
      }

      public String getRootId() {
         return this.mRootId;
      }
   }

   private class ConnectionRecord {
      MediaBrowserServiceCompat.ServiceCallbacks callbacks;
      String pkg;
      MediaBrowserServiceCompat.BrowserRoot root;
      Bundle rootHints;
      HashMap<String, List<Bundle>> subscriptions;

      private ConnectionRecord() {
         this.subscriptions = new HashMap();
      }

      // $FF: synthetic method
      ConnectionRecord(Object var2) {
         this();
      }
   }

   interface MediaBrowserServiceImpl {
      IBinder onBind(Intent var1);

      void onCreate();
   }

   class MediaBrowserServiceImplApi21 implements MediaBrowserServiceCompat.MediaBrowserServiceImpl {
      private Object mServiceObj;

      public IBinder onBind(Intent var1) {
         return MediaBrowserServiceCompatApi21.onBind(this.mServiceObj, var1);
      }

      public void onCreate() {
         this.mServiceObj = MediaBrowserServiceCompatApi21.createService();
         MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj, MediaBrowserServiceCompat.this.new ServiceImplApi21());
      }
   }

   class MediaBrowserServiceImplApi23 implements MediaBrowserServiceCompat.MediaBrowserServiceImpl {
      private Object mServiceObj;

      public IBinder onBind(Intent var1) {
         return MediaBrowserServiceCompatApi23.onBind(this.mServiceObj, var1);
      }

      public void onCreate() {
         this.mServiceObj = MediaBrowserServiceCompatApi23.createService();
         MediaBrowserServiceCompatApi23.onCreate(this.mServiceObj, MediaBrowserServiceCompat.this.new ServiceImplApi23(null));
      }
   }

   class MediaBrowserServiceImplBase implements MediaBrowserServiceCompat.MediaBrowserServiceImpl {
      private Messenger mMessenger;

      public IBinder onBind(Intent var1) {
         return "android.media.browse.MediaBrowserService".equals(var1.getAction())?this.mMessenger.getBinder():null;
      }

      public void onCreate() {
         this.mMessenger = new Messenger(MediaBrowserServiceCompat.this.mHandler);
      }
   }

   public static class Result<T> {
      private Object mDebug;
      private boolean mDetachCalled;
      private int mFlags;
      private boolean mSendResultCalled;

      Result(Object var1) {
         this.mDebug = var1;
      }

      public void detach() {
         if(this.mDetachCalled) {
            throw new IllegalStateException("detach() called when detach() had already been called for: " + this.mDebug);
         } else if(this.mSendResultCalled) {
            throw new IllegalStateException("detach() called when sendResult() had already been called for: " + this.mDebug);
         } else {
            this.mDetachCalled = true;
         }
      }

      boolean isDone() {
         return this.mDetachCalled || this.mSendResultCalled;
      }

      void onResultSent(T var1, int var2) {
      }

      public void sendResult(T var1) {
         if(this.mSendResultCalled) {
            throw new IllegalStateException("sendResult() called twice for: " + this.mDebug);
         } else {
            this.mSendResultCalled = true;
            this.onResultSent(var1, this.mFlags);
         }
      }

      void setFlags(int var1) {
         this.mFlags = var1;
      }
   }

   private interface ServiceCallbacks {
      IBinder asBinder();

      void onConnect(String var1, MediaSessionCompat.Token var2, Bundle var3) throws RemoteException;

      void onConnectFailed() throws RemoteException;

      void onLoadChildren(String var1, List<MediaBrowserCompat.MediaItem> var2, Bundle var3) throws RemoteException;
   }

   private class ServiceCallbacksApi21 implements MediaBrowserServiceCompat.ServiceCallbacks {
      final MediaBrowserServiceCompatApi21.ServiceCallbacks mCallbacks;
      Messenger mMessenger;

      ServiceCallbacksApi21(MediaBrowserServiceCompatApi21.ServiceCallbacks var2) {
         this.mCallbacks = var2;
      }

      public IBinder asBinder() {
         return this.mCallbacks.asBinder();
      }

      public void onConnect(String var1, MediaSessionCompat.Token var2, Bundle var3) throws RemoteException {
         if(var3 == null) {
            var3 = new Bundle();
         }

         this.mMessenger = new Messenger(MediaBrowserServiceCompat.this.mHandler);
         BundleCompat.putBinder(var3, "extra_messenger", this.mMessenger.getBinder());
         var3.putInt("extra_service_version", 1);
         this.mCallbacks.onConnect(var1, var2.getToken(), var3);
      }

      public void onConnectFailed() throws RemoteException {
         this.mCallbacks.onConnectFailed();
      }

      public void onLoadChildren(String var1, List<MediaBrowserCompat.MediaItem> var2, Bundle var3) throws RemoteException {
         ArrayList var4 = null;
         if(var2 != null) {
            var4 = new ArrayList();
            Iterator var5 = var2.iterator();

            while(var5.hasNext()) {
               MediaBrowserCompat.MediaItem var6 = (MediaBrowserCompat.MediaItem)var5.next();
               Parcel var7 = Parcel.obtain();
               var6.writeToParcel(var7, 0);
               var4.add(var7);
            }
         }

         this.mCallbacks.onLoadChildren(var1, var4);
      }
   }

   private class ServiceCallbacksCompat implements MediaBrowserServiceCompat.ServiceCallbacks {
      final Messenger mCallbacks;

      ServiceCallbacksCompat(Messenger var2) {
         this.mCallbacks = var2;
      }

      private void sendRequest(int var1, Bundle var2) throws RemoteException {
         Message var3 = Message.obtain();
         var3.what = var1;
         var3.arg1 = 1;
         var3.setData(var2);
         this.mCallbacks.send(var3);
      }

      public IBinder asBinder() {
         return this.mCallbacks.getBinder();
      }

      public void onConnect(String var1, MediaSessionCompat.Token var2, Bundle var3) throws RemoteException {
         if(var3 == null) {
            var3 = new Bundle();
         }

         var3.putInt("extra_service_version", 1);
         Bundle var4 = new Bundle();
         var4.putString("data_media_item_id", var1);
         var4.putParcelable("data_media_session_token", var2);
         var4.putBundle("data_root_hints", var3);
         this.sendRequest(1, var4);
      }

      public void onConnectFailed() throws RemoteException {
         this.sendRequest(2, (Bundle)null);
      }

      public void onLoadChildren(String var1, List<MediaBrowserCompat.MediaItem> var2, Bundle var3) throws RemoteException {
         Bundle var4 = new Bundle();
         var4.putString("data_media_item_id", var1);
         var4.putBundle("data_options", var3);
         if(var2 != null) {
            ArrayList var5;
            if(var2 instanceof ArrayList) {
               var5 = (ArrayList)var2;
            } else {
               var5 = new ArrayList(var2);
            }

            var4.putParcelableArrayList("data_media_item_list", var5);
         }

         this.sendRequest(3, var4);
      }
   }

   private final class ServiceHandler extends Handler {
      private final MediaBrowserServiceCompat.ServiceImpl mServiceImpl;

      private ServiceHandler() {
         this.mServiceImpl = MediaBrowserServiceCompat.this.new ServiceImpl(null);
      }

      // $FF: synthetic method
      ServiceHandler(Object var2) {
         this();
      }

      public MediaBrowserServiceCompat.ServiceImpl getServiceImpl() {
         return this.mServiceImpl;
      }

      public void handleMessage(Message var1) {
         Bundle var2 = var1.getData();
         switch(var1.what) {
         case 1:
            this.mServiceImpl.connect(var2.getString("data_package_name"), var2.getInt("data_calling_uid"), var2.getBundle("data_root_hints"), MediaBrowserServiceCompat.this.new ServiceCallbacksCompat(var1.replyTo));
            return;
         case 2:
            this.mServiceImpl.disconnect(MediaBrowserServiceCompat.this.new ServiceCallbacksCompat(var1.replyTo));
            return;
         case 3:
            this.mServiceImpl.addSubscription(var2.getString("data_media_item_id"), var2.getBundle("data_options"), MediaBrowserServiceCompat.this.new ServiceCallbacksCompat(var1.replyTo));
            return;
         case 4:
            this.mServiceImpl.removeSubscription(var2.getString("data_media_item_id"), var2.getBundle("data_options"), MediaBrowserServiceCompat.this.new ServiceCallbacksCompat(var1.replyTo));
            return;
         case 5:
            this.mServiceImpl.getMediaItem(var2.getString("data_media_item_id"), (ResultReceiver)var2.getParcelable("data_result_receiver"));
            return;
         case 6:
            this.mServiceImpl.registerCallbacks(MediaBrowserServiceCompat.this.new ServiceCallbacksCompat(var1.replyTo));
            return;
         default:
            Log.w("MediaBrowserServiceCompat", "Unhandled message: " + var1 + "\n  Service version: " + 1 + "\n  Client version: " + var1.arg1);
         }
      }

      public void postOrRun(Runnable var1) {
         if(Thread.currentThread() == this.getLooper().getThread()) {
            var1.run();
         } else {
            this.post(var1);
         }
      }

      public boolean sendMessageAtTime(Message var1, long var2) {
         Bundle var4 = var1.getData();
         var4.setClassLoader(MediaBrowserCompat.class.getClassLoader());
         var4.putInt("data_calling_uid", Binder.getCallingUid());
         return super.sendMessageAtTime(var1, var2);
      }
   }

   private class ServiceImpl {
      private ServiceImpl() {
      }

      // $FF: synthetic method
      ServiceImpl(Object var2) {
         this();
      }

      public void addSubscription(final String var1, final Bundle var2, final MediaBrowserServiceCompat.ServiceCallbacks var3) {
         MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
            public void run() {
               IBinder var1x = var3.asBinder();
               MediaBrowserServiceCompat.ConnectionRecord var2x = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(var1x);
               if(var2x == null) {
                  Log.w("MediaBrowserServiceCompat", "addSubscription for callback that isn\'t registered id=" + var1);
               } else {
                  MediaBrowserServiceCompat.this.addSubscription(var1, var2x, var2);
               }
            }
         });
      }

      public void connect(final String var1, final int var2, final Bundle var3, final MediaBrowserServiceCompat.ServiceCallbacks var4) {
         if(!MediaBrowserServiceCompat.this.isValidPackage(var1, var2)) {
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + var2 + " package=" + var1);
         } else {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
               public void run() {
                  IBinder var1x = var4.asBinder();
                  MediaBrowserServiceCompat.this.mConnections.remove(var1x);
                  MediaBrowserServiceCompat.ConnectionRecord var3x = MediaBrowserServiceCompat.this.new ConnectionRecord(null);
                  var3x.pkg = var1;
                  var3x.rootHints = var3;
                  var3x.callbacks = var4;
                  var3x.root = MediaBrowserServiceCompat.this.onGetRoot(var1, var2, var3);
                  if(var3x.root == null) {
                     Log.i("MediaBrowserServiceCompat", "No root for client " + var1 + " from service " + this.getClass().getName());

                     try {
                        var4.onConnectFailed();
                     } catch (RemoteException var11) {
                        Log.w("MediaBrowserServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + var1);
                        return;
                     }
                  } else {
                     try {
                        MediaBrowserServiceCompat.this.mConnections.put(var1x, var3x);
                        if(MediaBrowserServiceCompat.this.mSession != null) {
                           var4.onConnect(var3x.root.getRootId(), MediaBrowserServiceCompat.this.mSession, var3x.root.getExtras());
                           return;
                        }
                     } catch (RemoteException var10) {
                        Log.w("MediaBrowserServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + var1);
                        MediaBrowserServiceCompat.this.mConnections.remove(var1x);
                        return;
                     }
                  }

               }
            });
         }
      }

      public void disconnect(final MediaBrowserServiceCompat.ServiceCallbacks var1) {
         MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
            public void run() {
               IBinder var1x = var1.asBinder();
               if((MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.remove(var1x) != null) {
                  ;
               }

            }
         });
      }

      public void getMediaItem(final String var1, final ResultReceiver var2) {
         if(!TextUtils.isEmpty(var1) && var2 != null) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
               public void run() {
                  MediaBrowserServiceCompat.this.performLoadItem(var1, var2);
               }
            });
         }
      }

      public void registerCallbacks(final MediaBrowserServiceCompat.ServiceCallbacks var1) {
         MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
            public void run() {
               IBinder var1x = var1.asBinder();
               MediaBrowserServiceCompat.this.mConnections.remove(var1x);
               MediaBrowserServiceCompat.ConnectionRecord var3 = MediaBrowserServiceCompat.this.new ConnectionRecord(null);
               var3.callbacks = var1;
               MediaBrowserServiceCompat.this.mConnections.put(var1x, var3);
            }
         });
      }

      public void removeSubscription(final String var1, final Bundle var2, final MediaBrowserServiceCompat.ServiceCallbacks var3) {
         MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable() {
            public void run() {
               IBinder var1x = var3.asBinder();
               MediaBrowserServiceCompat.ConnectionRecord var2x = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(var1x);
               if(var2x == null) {
                  Log.w("MediaBrowserServiceCompat", "removeSubscription for callback that isn\'t registered id=" + var1);
               } else if(!MediaBrowserServiceCompat.this.removeSubscription(var1, var2x, var2)) {
                  Log.w("MediaBrowserServiceCompat", "removeSubscription called for " + var1 + " which is not subscribed");
                  return;
               }

            }
         });
      }
   }

   private class ServiceImplApi21 implements MediaBrowserServiceCompatApi21.ServiceImplApi21 {
      final MediaBrowserServiceCompat.ServiceImpl mServiceImpl;

      ServiceImplApi21() {
         this.mServiceImpl = MediaBrowserServiceCompat.this.mHandler.getServiceImpl();
      }

      public void addSubscription(String var1, MediaBrowserServiceCompatApi21.ServiceCallbacks var2) {
         this.mServiceImpl.addSubscription(var1, (Bundle)null, MediaBrowserServiceCompat.this.new ServiceCallbacksApi21(var2));
      }

      public void connect(String var1, Bundle var2, MediaBrowserServiceCompatApi21.ServiceCallbacks var3) {
         this.mServiceImpl.connect(var1, Binder.getCallingUid(), var2, MediaBrowserServiceCompat.this.new ServiceCallbacksApi21(var3));
      }

      public void disconnect(MediaBrowserServiceCompatApi21.ServiceCallbacks var1) {
         this.mServiceImpl.disconnect(MediaBrowserServiceCompat.this.new ServiceCallbacksApi21(var1));
      }

      public void removeSubscription(String var1, MediaBrowserServiceCompatApi21.ServiceCallbacks var2) {
         this.mServiceImpl.removeSubscription(var1, (Bundle)null, MediaBrowserServiceCompat.this.new ServiceCallbacksApi21(var2));
      }
   }

   private class ServiceImplApi23 extends MediaBrowserServiceCompat.ServiceImplApi21 implements MediaBrowserServiceCompatApi23.ServiceImplApi23 {
      private ServiceImplApi23() {
         super();
      }

      // $FF: synthetic method
      ServiceImplApi23(Object var2) {
         this();
      }

      public void getMediaItem(String var1, final MediaBrowserServiceCompatApi23.ItemCallback var2) {
         ResultReceiver var3 = new ResultReceiver(MediaBrowserServiceCompat.this.mHandler) {
            protected void onReceiveResult(int var1, Bundle var2x) {
               MediaBrowserCompat.MediaItem var3 = (MediaBrowserCompat.MediaItem)var2x.getParcelable("media_item");
               Parcel var4 = null;
               if(var3 != null) {
                  var4 = Parcel.obtain();
                  var3.writeToParcel(var4, 0);
               }

               var2.onItemLoaded(var1, var2x, var4);
            }
         };
         this.mServiceImpl.getMediaItem(var1, var3);
      }
   }
}
