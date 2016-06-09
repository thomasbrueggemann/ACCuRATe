package android.support.v7.media;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.media.MediaItemStatus;
import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaSessionStatus;
import android.util.Log;

public class RemotePlaybackClient {
   private static final boolean DEBUG = Log.isLoggable("RemotePlaybackClient", 3);
   private static final String TAG = "RemotePlaybackClient";
   private final Context mContext;
   private final PendingIntent mItemStatusPendingIntent;
   private final MediaRouter.RouteInfo mRoute;
   private boolean mRouteSupportsQueuing;
   private boolean mRouteSupportsRemotePlayback;
   private boolean mRouteSupportsSessionManagement;
   private String mSessionId;
   private final PendingIntent mSessionStatusPendingIntent;
   private RemotePlaybackClient.StatusCallback mStatusCallback;
   private final RemotePlaybackClient.StatusReceiver mStatusReceiver;

   public RemotePlaybackClient(Context var1, MediaRouter.RouteInfo var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("context must not be null");
      } else if(var2 == null) {
         throw new IllegalArgumentException("route must not be null");
      } else {
         this.mContext = var1;
         this.mRoute = var2;
         IntentFilter var3 = new IntentFilter();
         var3.addAction("android.support.v7.media.actions.ACTION_ITEM_STATUS_CHANGED");
         var3.addAction("android.support.v7.media.actions.ACTION_SESSION_STATUS_CHANGED");
         this.mStatusReceiver = new RemotePlaybackClient.StatusReceiver(null);
         var1.registerReceiver(this.mStatusReceiver, var3);
         Intent var5 = new Intent("android.support.v7.media.actions.ACTION_ITEM_STATUS_CHANGED");
         var5.setPackage(var1.getPackageName());
         this.mItemStatusPendingIntent = PendingIntent.getBroadcast(var1, 0, var5, 0);
         Intent var7 = new Intent("android.support.v7.media.actions.ACTION_SESSION_STATUS_CHANGED");
         var7.setPackage(var1.getPackageName());
         this.mSessionStatusPendingIntent = PendingIntent.getBroadcast(var1, 0, var7, 0);
         this.detectFeatures();
      }
   }

   private void adoptSession(String var1) {
      if(var1 != null) {
         this.setSessionId(var1);
      }

   }

   private static String bundleToString(Bundle var0) {
      if(var0 != null) {
         var0.size();
         return var0.toString();
      } else {
         return "null";
      }
   }

   private void detectFeatures() {
      boolean var1 = true;
      boolean var2;
      if(this.routeSupportsAction("android.media.intent.action.PLAY") && this.routeSupportsAction("android.media.intent.action.SEEK") && this.routeSupportsAction("android.media.intent.action.GET_STATUS") && this.routeSupportsAction("android.media.intent.action.PAUSE") && this.routeSupportsAction("android.media.intent.action.RESUME") && this.routeSupportsAction("android.media.intent.action.STOP")) {
         var2 = var1;
      } else {
         var2 = false;
      }

      this.mRouteSupportsRemotePlayback = var2;
      boolean var3;
      if(this.mRouteSupportsRemotePlayback && this.routeSupportsAction("android.media.intent.action.ENQUEUE") && this.routeSupportsAction("android.media.intent.action.REMOVE")) {
         var3 = var1;
      } else {
         var3 = false;
      }

      this.mRouteSupportsQueuing = var3;
      if(!this.mRouteSupportsRemotePlayback || !this.routeSupportsAction("android.media.intent.action.START_SESSION") || !this.routeSupportsAction("android.media.intent.action.GET_SESSION_STATUS") || !this.routeSupportsAction("android.media.intent.action.END_SESSION")) {
         var1 = false;
      }

      this.mRouteSupportsSessionManagement = var1;
   }

   private void handleError(Intent var1, RemotePlaybackClient.ActionCallback var2, String var3, Bundle var4) {
      int var5;
      if(var4 != null) {
         var5 = var4.getInt("android.media.intent.extra.ERROR_CODE", 0);
      } else {
         var5 = 0;
      }

      if(DEBUG) {
         Log.w("RemotePlaybackClient", "Received error from " + var1.getAction() + ": error=" + var3 + ", code=" + var5 + ", data=" + bundleToString(var4));
      }

      var2.onError(var3, var5, var4);
   }

   private void handleInvalidResult(Intent var1, RemotePlaybackClient.ActionCallback var2, Bundle var3) {
      Log.w("RemotePlaybackClient", "Received invalid result data from " + var1.getAction() + ": data=" + bundleToString(var3));
      var2.onError((String)null, 0, var3);
   }

   private static String inferMissingResult(String var0, String var1) {
      return var1 == null?var0:(var0 != null && !var0.equals(var1)?null:var1);
   }

   private static void logRequest(Intent var0) {
      if(DEBUG) {
         Log.d("RemotePlaybackClient", "Sending request: " + var0);
      }

   }

   private void performItemAction(final Intent var1, final String var2, final String var3, Bundle var4, final RemotePlaybackClient.ItemActionCallback var5) {
      var1.addCategory("android.media.intent.category.REMOTE_PLAYBACK");
      if(var2 != null) {
         var1.putExtra("android.media.intent.extra.SESSION_ID", var2);
      }

      if(var3 != null) {
         var1.putExtra("android.media.intent.extra.ITEM_ID", var3);
      }

      if(var4 != null) {
         var1.putExtras(var4);
      }

      logRequest(var1);
      this.mRoute.sendControlRequest(var1, new MediaRouter.ControlRequestCallback() {
         public void onError(String var1x, Bundle var2x) {
            RemotePlaybackClient.this.handleError(var1, var5, var1x, var2x);
         }

         public void onResult(Bundle var1x) {
            if(var1x != null) {
               String var2x = RemotePlaybackClient.inferMissingResult(var2, var1x.getString("android.media.intent.extra.SESSION_ID"));
               MediaSessionStatus var3x = MediaSessionStatus.fromBundle(var1x.getBundle("android.media.intent.extra.SESSION_STATUS"));
               String var4 = RemotePlaybackClient.inferMissingResult(var3, var1x.getString("android.media.intent.extra.ITEM_ID"));
               MediaItemStatus var5x = MediaItemStatus.fromBundle(var1x.getBundle("android.media.intent.extra.ITEM_STATUS"));
               RemotePlaybackClient.this.adoptSession(var2x);
               if(var2x != null && var4 != null && var5x != null) {
                  if(RemotePlaybackClient.DEBUG) {
                     Log.d("RemotePlaybackClient", "Received result from " + var1.getAction() + ": data=" + RemotePlaybackClient.bundleToString(var1x) + ", sessionId=" + var2x + ", sessionStatus=" + var3x + ", itemId=" + var4 + ", itemStatus=" + var5x);
                  }

                  var5.onResult(var1x, var2x, var3x, var4, var5x);
                  return;
               }
            }

            RemotePlaybackClient.this.handleInvalidResult(var1, var5, var1x);
         }
      });
   }

   private void performSessionAction(final Intent var1, final String var2, Bundle var3, final RemotePlaybackClient.SessionActionCallback var4) {
      var1.addCategory("android.media.intent.category.REMOTE_PLAYBACK");
      if(var2 != null) {
         var1.putExtra("android.media.intent.extra.SESSION_ID", var2);
      }

      if(var3 != null) {
         var1.putExtras(var3);
      }

      logRequest(var1);
      this.mRoute.sendControlRequest(var1, new MediaRouter.ControlRequestCallback() {
         public void onError(String var1x, Bundle var2x) {
            RemotePlaybackClient.this.handleError(var1, var4, var1x, var2x);
         }

         public void onResult(Bundle var1x) {
            if(var1x != null) {
               String var2x = RemotePlaybackClient.inferMissingResult(var2, var1x.getString("android.media.intent.extra.SESSION_ID"));
               MediaSessionStatus var3 = MediaSessionStatus.fromBundle(var1x.getBundle("android.media.intent.extra.SESSION_STATUS"));
               RemotePlaybackClient.this.adoptSession(var2x);
               if(var2x != null) {
                  if(RemotePlaybackClient.DEBUG) {
                     Log.d("RemotePlaybackClient", "Received result from " + var1.getAction() + ": data=" + RemotePlaybackClient.bundleToString(var1x) + ", sessionId=" + var2x + ", sessionStatus=" + var3);
                  }

                  try {
                     var4.onResult(var1x, var2x, var3);
                  } finally {
                     if(var1.getAction().equals("android.media.intent.action.END_SESSION") && var2x.equals(RemotePlaybackClient.this.mSessionId)) {
                        RemotePlaybackClient.this.setSessionId((String)null);
                     }

                  }

                  return;
               }
            }

            RemotePlaybackClient.this.handleInvalidResult(var1, var4, var1x);
         }
      });
   }

   private void playOrEnqueue(Uri var1, String var2, Bundle var3, long var4, Bundle var6, RemotePlaybackClient.ItemActionCallback var7, String var8) {
      if(var1 == null) {
         throw new IllegalArgumentException("contentUri must not be null");
      } else {
         this.throwIfRemotePlaybackNotSupported();
         if(var8.equals("android.media.intent.action.ENQUEUE")) {
            this.throwIfQueuingNotSupported();
         }

         Intent var9 = new Intent(var8);
         var9.setDataAndType(var1, var2);
         var9.putExtra("android.media.intent.extra.ITEM_STATUS_UPDATE_RECEIVER", this.mItemStatusPendingIntent);
         if(var3 != null) {
            var9.putExtra("android.media.intent.extra.ITEM_METADATA", var3);
         }

         if(var4 != 0L) {
            var9.putExtra("android.media.intent.extra.ITEM_POSITION", var4);
         }

         this.performItemAction(var9, this.mSessionId, (String)null, var6, var7);
      }
   }

   private boolean routeSupportsAction(String var1) {
      return this.mRoute.supportsControlAction("android.media.intent.category.REMOTE_PLAYBACK", var1);
   }

   private void throwIfNoCurrentSession() {
      if(this.mSessionId == null) {
         throw new IllegalStateException("There is no current session.");
      }
   }

   private void throwIfQueuingNotSupported() {
      if(!this.mRouteSupportsQueuing) {
         throw new UnsupportedOperationException("The route does not support queuing.");
      }
   }

   private void throwIfRemotePlaybackNotSupported() {
      if(!this.mRouteSupportsRemotePlayback) {
         throw new UnsupportedOperationException("The route does not support remote playback.");
      }
   }

   private void throwIfSessionManagementNotSupported() {
      if(!this.mRouteSupportsSessionManagement) {
         throw new UnsupportedOperationException("The route does not support session management.");
      }
   }

   public void endSession(Bundle var1, RemotePlaybackClient.SessionActionCallback var2) {
      this.throwIfSessionManagementNotSupported();
      this.throwIfNoCurrentSession();
      this.performSessionAction(new Intent("android.media.intent.action.END_SESSION"), this.mSessionId, var1, var2);
   }

   public void enqueue(Uri var1, String var2, Bundle var3, long var4, Bundle var6, RemotePlaybackClient.ItemActionCallback var7) {
      this.playOrEnqueue(var1, var2, var3, var4, var6, var7, "android.media.intent.action.ENQUEUE");
   }

   public String getSessionId() {
      return this.mSessionId;
   }

   public void getSessionStatus(Bundle var1, RemotePlaybackClient.SessionActionCallback var2) {
      this.throwIfSessionManagementNotSupported();
      this.throwIfNoCurrentSession();
      this.performSessionAction(new Intent("android.media.intent.action.GET_SESSION_STATUS"), this.mSessionId, var1, var2);
   }

   public void getStatus(String var1, Bundle var2, RemotePlaybackClient.ItemActionCallback var3) {
      if(var1 == null) {
         throw new IllegalArgumentException("itemId must not be null");
      } else {
         this.throwIfNoCurrentSession();
         this.performItemAction(new Intent("android.media.intent.action.GET_STATUS"), this.mSessionId, var1, var2, var3);
      }
   }

   public boolean hasSession() {
      return this.mSessionId != null;
   }

   public boolean isQueuingSupported() {
      return this.mRouteSupportsQueuing;
   }

   public boolean isRemotePlaybackSupported() {
      return this.mRouteSupportsRemotePlayback;
   }

   public boolean isSessionManagementSupported() {
      return this.mRouteSupportsSessionManagement;
   }

   public void pause(Bundle var1, RemotePlaybackClient.SessionActionCallback var2) {
      this.throwIfNoCurrentSession();
      this.performSessionAction(new Intent("android.media.intent.action.PAUSE"), this.mSessionId, var1, var2);
   }

   public void play(Uri var1, String var2, Bundle var3, long var4, Bundle var6, RemotePlaybackClient.ItemActionCallback var7) {
      this.playOrEnqueue(var1, var2, var3, var4, var6, var7, "android.media.intent.action.PLAY");
   }

   public void release() {
      this.mContext.unregisterReceiver(this.mStatusReceiver);
   }

   public void remove(String var1, Bundle var2, RemotePlaybackClient.ItemActionCallback var3) {
      if(var1 == null) {
         throw new IllegalArgumentException("itemId must not be null");
      } else {
         this.throwIfQueuingNotSupported();
         this.throwIfNoCurrentSession();
         this.performItemAction(new Intent("android.media.intent.action.REMOVE"), this.mSessionId, var1, var2, var3);
      }
   }

   public void resume(Bundle var1, RemotePlaybackClient.SessionActionCallback var2) {
      this.throwIfNoCurrentSession();
      this.performSessionAction(new Intent("android.media.intent.action.RESUME"), this.mSessionId, var1, var2);
   }

   public void seek(String var1, long var2, Bundle var4, RemotePlaybackClient.ItemActionCallback var5) {
      if(var1 == null) {
         throw new IllegalArgumentException("itemId must not be null");
      } else {
         this.throwIfNoCurrentSession();
         Intent var6 = new Intent("android.media.intent.action.SEEK");
         var6.putExtra("android.media.intent.extra.ITEM_POSITION", var2);
         this.performItemAction(var6, this.mSessionId, var1, var4, var5);
      }
   }

   public void setSessionId(String var1) {
      if(this.mSessionId != var1 && (this.mSessionId == null || !this.mSessionId.equals(var1))) {
         if(DEBUG) {
            Log.d("RemotePlaybackClient", "Session id is now: " + var1);
         }

         this.mSessionId = var1;
         if(this.mStatusCallback != null) {
            this.mStatusCallback.onSessionChanged(var1);
         }
      }

   }

   public void setStatusCallback(RemotePlaybackClient.StatusCallback var1) {
      this.mStatusCallback = var1;
   }

   public void startSession(Bundle var1, RemotePlaybackClient.SessionActionCallback var2) {
      this.throwIfSessionManagementNotSupported();
      Intent var3 = new Intent("android.media.intent.action.START_SESSION");
      var3.putExtra("android.media.intent.extra.SESSION_STATUS_UPDATE_RECEIVER", this.mSessionStatusPendingIntent);
      this.performSessionAction(var3, (String)null, var1, var2);
   }

   public void stop(Bundle var1, RemotePlaybackClient.SessionActionCallback var2) {
      this.throwIfNoCurrentSession();
      this.performSessionAction(new Intent("android.media.intent.action.STOP"), this.mSessionId, var1, var2);
   }

   public abstract static class ActionCallback {
      public void onError(String var1, int var2, Bundle var3) {
      }
   }

   public abstract static class ItemActionCallback extends RemotePlaybackClient.ActionCallback {
      public void onResult(Bundle var1, String var2, MediaSessionStatus var3, String var4, MediaItemStatus var5) {
      }
   }

   public abstract static class SessionActionCallback extends RemotePlaybackClient.ActionCallback {
      public void onResult(Bundle var1, String var2, MediaSessionStatus var3) {
      }
   }

   public abstract static class StatusCallback {
      public void onItemStatusChanged(Bundle var1, String var2, MediaSessionStatus var3, String var4, MediaItemStatus var5) {
      }

      public void onSessionChanged(String var1) {
      }

      public void onSessionStatusChanged(Bundle var1, String var2, MediaSessionStatus var3) {
      }
   }

   private final class StatusReceiver extends BroadcastReceiver {
      public static final String ACTION_ITEM_STATUS_CHANGED = "android.support.v7.media.actions.ACTION_ITEM_STATUS_CHANGED";
      public static final String ACTION_SESSION_STATUS_CHANGED = "android.support.v7.media.actions.ACTION_SESSION_STATUS_CHANGED";

      private StatusReceiver() {
      }

      // $FF: synthetic method
      StatusReceiver(Object var2) {
         this();
      }

      public void onReceive(Context var1, Intent var2) {
         String var3 = var2.getStringExtra("android.media.intent.extra.SESSION_ID");
         if(var3 != null && var3.equals(RemotePlaybackClient.this.mSessionId)) {
            MediaSessionStatus var5 = MediaSessionStatus.fromBundle(var2.getBundleExtra("android.media.intent.extra.SESSION_STATUS"));
            String var6 = var2.getAction();
            if(var6.equals("android.support.v7.media.actions.ACTION_ITEM_STATUS_CHANGED")) {
               String var9 = var2.getStringExtra("android.media.intent.extra.ITEM_ID");
               if(var9 == null) {
                  Log.w("RemotePlaybackClient", "Discarding spurious status callback with missing item id.");
                  return;
               }

               MediaItemStatus var10 = MediaItemStatus.fromBundle(var2.getBundleExtra("android.media.intent.extra.ITEM_STATUS"));
               if(var10 == null) {
                  Log.w("RemotePlaybackClient", "Discarding spurious status callback with missing item status.");
                  return;
               }

               if(RemotePlaybackClient.DEBUG) {
                  Log.d("RemotePlaybackClient", "Received item status callback: sessionId=" + var3 + ", sessionStatus=" + var5 + ", itemId=" + var9 + ", itemStatus=" + var10);
               }

               if(RemotePlaybackClient.this.mStatusCallback != null) {
                  RemotePlaybackClient.this.mStatusCallback.onItemStatusChanged(var2.getExtras(), var3, var5, var9, var10);
                  return;
               }
            } else if(var6.equals("android.support.v7.media.actions.ACTION_SESSION_STATUS_CHANGED")) {
               if(var5 == null) {
                  Log.w("RemotePlaybackClient", "Discarding spurious media status callback with missing session status.");
                  return;
               }

               if(RemotePlaybackClient.DEBUG) {
                  Log.d("RemotePlaybackClient", "Received session status callback: sessionId=" + var3 + ", sessionStatus=" + var5);
               }

               if(RemotePlaybackClient.this.mStatusCallback != null) {
                  RemotePlaybackClient.this.mStatusCallback.onSessionStatusChanged(var2.getExtras(), var3, var5);
                  return;
               }
            }
         } else {
            Log.w("RemotePlaybackClient", "Discarding spurious status callback with missing or invalid session id: sessionId=" + var3);
         }

      }
   }
}
