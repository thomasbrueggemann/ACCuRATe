package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;

public final class LocalBroadcastManager {
   private static final boolean DEBUG = false;
   static final int MSG_EXEC_PENDING_BROADCASTS = 1;
   private static final String TAG = "LocalBroadcastManager";
   private static LocalBroadcastManager mInstance;
   private static final Object mLock = new Object();
   private final HashMap<String, ArrayList<LocalBroadcastManager.ReceiverRecord>> mActions = new HashMap();
   private final Context mAppContext;
   private final Handler mHandler;
   private final ArrayList<LocalBroadcastManager.BroadcastRecord> mPendingBroadcasts = new ArrayList();
   private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> mReceivers = new HashMap();

   private LocalBroadcastManager(Context var1) {
      this.mAppContext = var1;
      this.mHandler = new Handler(var1.getMainLooper()) {
         public void handleMessage(Message var1) {
            switch(var1.what) {
            case 1:
               LocalBroadcastManager.this.executePendingBroadcasts();
               return;
            default:
               super.handleMessage(var1);
            }
         }
      };
   }

   private void executePendingBroadcasts() {
      // $FF: Couldn't be decompiled
   }

   public static LocalBroadcastManager getInstance(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public void registerReceiver(BroadcastReceiver param1, IntentFilter param2) {
      // $FF: Couldn't be decompiled
   }

   public boolean sendBroadcast(Intent param1) {
      // $FF: Couldn't be decompiled
   }

   public void sendBroadcastSync(Intent var1) {
      if(this.sendBroadcast(var1)) {
         this.executePendingBroadcasts();
      }

   }

   public void unregisterReceiver(BroadcastReceiver param1) {
      // $FF: Couldn't be decompiled
   }

   private static class BroadcastRecord {
      final Intent intent;
      final ArrayList<LocalBroadcastManager.ReceiverRecord> receivers;

      BroadcastRecord(Intent var1, ArrayList<LocalBroadcastManager.ReceiverRecord> var2) {
         this.intent = var1;
         this.receivers = var2;
      }
   }

   private static class ReceiverRecord {
      boolean broadcasting;
      final IntentFilter filter;
      final BroadcastReceiver receiver;

      ReceiverRecord(IntentFilter var1, BroadcastReceiver var2) {
         this.filter = var1;
         this.receiver = var2;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder(128);
         var1.append("Receiver{");
         var1.append(this.receiver);
         var1.append(" filter=");
         var1.append(this.filter);
         var1.append("}");
         return var1.toString();
      }
   }
}
