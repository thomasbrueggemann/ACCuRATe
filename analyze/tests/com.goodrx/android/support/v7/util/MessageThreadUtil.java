package android.support.v7.util;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.ParallelExecutorCompat;
import android.support.v7.util.ThreadUtil;
import android.support.v7.util.TileList;
import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

class MessageThreadUtil<T> implements ThreadUtil<T> {
   public ThreadUtil.BackgroundCallback<T> getBackgroundProxy(final ThreadUtil.BackgroundCallback<T> var1) {
      return new ThreadUtil.BackgroundCallback() {
         private static final int LOAD_TILE = 3;
         private static final int RECYCLE_TILE = 4;
         private static final int REFRESH = 1;
         private static final int UPDATE_RANGE = 2;
         private Runnable mBackgroundRunnable = new Runnable() {
            public void run() {
               while(true) {
                  MessageThreadUtil.SyncQueueItem var1x = mQueue.next();
                  if(var1x == null) {
                     mBackgroundRunning.set(false);
                     return;
                  }

                  switch(var1x.what) {
                  case 1:
                     mQueue.removeMessages(1);
                     var1.refresh(var1x.arg1);
                     break;
                  case 2:
                     mQueue.removeMessages(2);
                     mQueue.removeMessages(3);
                     var1.updateRange(var1x.arg1, var1x.arg2, var1x.arg3, var1x.arg4, var1x.arg5);
                     break;
                  case 3:
                     var1.loadTile(var1x.arg1, var1x.arg2);
                     break;
                  case 4:
                     var1.recycleTile((TileList.Tile)var1x.data);
                     break;
                  default:
                     Log.e("ThreadUtil", "Unsupported message, what=" + var1x.what);
                  }
               }
            }
         };
         AtomicBoolean mBackgroundRunning = new AtomicBoolean(false);
         private final Executor mExecutor = ParallelExecutorCompat.getParallelExecutor();
         private final MessageThreadUtil.MessageQueue mQueue = new MessageThreadUtil.MessageQueue();

         private void maybeExecuteBackgroundRunnable() {
            if(this.mBackgroundRunning.compareAndSet(false, true)) {
               this.mExecutor.execute(this.mBackgroundRunnable);
            }

         }

         private void sendMessage(MessageThreadUtil.SyncQueueItem var1x) {
            this.mQueue.sendMessage(var1x);
            this.maybeExecuteBackgroundRunnable();
         }

         private void sendMessageAtFrontOfQueue(MessageThreadUtil.SyncQueueItem var1x) {
            this.mQueue.sendMessageAtFrontOfQueue(var1x);
            this.maybeExecuteBackgroundRunnable();
         }

         public void loadTile(int var1x, int var2) {
            this.sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage(3, var1x, var2));
         }

         public void recycleTile(TileList.Tile<T> var1x) {
            this.sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage(4, 0, var1x));
         }

         public void refresh(int var1x) {
            this.sendMessageAtFrontOfQueue(MessageThreadUtil.SyncQueueItem.obtainMessage(1, var1x, (Object)null));
         }

         public void updateRange(int var1x, int var2, int var3, int var4, int var5) {
            this.sendMessageAtFrontOfQueue(MessageThreadUtil.SyncQueueItem.obtainMessage(2, var1x, var2, var3, var4, var5, (Object)null));
         }
      };
   }

   public ThreadUtil.MainThreadCallback<T> getMainThreadProxy(final ThreadUtil.MainThreadCallback<T> var1) {
      return new ThreadUtil.MainThreadCallback() {
         private static final int ADD_TILE = 2;
         private static final int REMOVE_TILE = 3;
         private static final int UPDATE_ITEM_COUNT = 1;
         private final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
         private Runnable mMainThreadRunnable = new Runnable() {
            public void run() {
               for(MessageThreadUtil.SyncQueueItem var1x = mQueue.next(); var1x != null; var1x = mQueue.next()) {
                  switch(var1x.what) {
                  case 1:
                     var1.updateItemCount(var1x.arg1, var1x.arg2);
                     break;
                  case 2:
                     var1.addTile(var1x.arg1, (TileList.Tile)var1x.data);
                     break;
                  case 3:
                     var1.removeTile(var1x.arg1, var1x.arg2);
                     break;
                  default:
                     Log.e("ThreadUtil", "Unsupported message, what=" + var1x.what);
                  }
               }

            }
         };
         private final MessageThreadUtil.MessageQueue mQueue = new MessageThreadUtil.MessageQueue();

         private void sendMessage(MessageThreadUtil.SyncQueueItem var1x) {
            this.mQueue.sendMessage(var1x);
            this.mMainThreadHandler.post(this.mMainThreadRunnable);
         }

         public void addTile(int var1x, TileList.Tile<T> var2) {
            this.sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage(2, var1x, var2));
         }

         public void removeTile(int var1x, int var2) {
            this.sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage(3, var1x, var2));
         }

         public void updateItemCount(int var1x, int var2) {
            this.sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage(1, var1x, var2));
         }
      };
   }

   static class MessageQueue {
      private MessageThreadUtil.SyncQueueItem mRoot;

      MessageThreadUtil.SyncQueueItem next() {
         // $FF: Couldn't be decompiled
      }

      void removeMessages(int param1) {
         // $FF: Couldn't be decompiled
      }

      void sendMessage(MessageThreadUtil.SyncQueueItem param1) {
         // $FF: Couldn't be decompiled
      }

      void sendMessageAtFrontOfQueue(MessageThreadUtil.SyncQueueItem var1) {
         synchronized(this){}

         try {
            var1.next = this.mRoot;
            this.mRoot = var1;
         } finally {
            ;
         }

      }
   }

   static class SyncQueueItem {
      private static MessageThreadUtil.SyncQueueItem sPool;
      private static final Object sPoolLock = new Object();
      public int arg1;
      public int arg2;
      public int arg3;
      public int arg4;
      public int arg5;
      public Object data;
      private MessageThreadUtil.SyncQueueItem next;
      public int what;

      // $FF: synthetic method
      static MessageThreadUtil.SyncQueueItem access$200(MessageThreadUtil.SyncQueueItem var0) {
         return var0.next;
      }

      static MessageThreadUtil.SyncQueueItem obtainMessage(int var0, int var1, int var2) {
         return obtainMessage(var0, var1, var2, 0, 0, 0, (Object)null);
      }

      static MessageThreadUtil.SyncQueueItem obtainMessage(int param0, int param1, int param2, int param3, int param4, int param5, Object param6) {
         // $FF: Couldn't be decompiled
      }

      static MessageThreadUtil.SyncQueueItem obtainMessage(int var0, int var1, Object var2) {
         return obtainMessage(var0, var1, 0, 0, 0, 0, var2);
      }

      void recycle() {
         // $FF: Couldn't be decompiled
      }
   }
}
