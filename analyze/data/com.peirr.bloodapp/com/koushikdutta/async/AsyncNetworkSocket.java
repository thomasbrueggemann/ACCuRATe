package com.koushikdutta.async;

import android.util.Log;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.ChannelWrapper;
import com.koushikdutta.async.DatagramChannelWrapper;
import com.koushikdutta.async.SocketChannelWrapper;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.callback.WritableCallback;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

public class AsyncNetworkSocket implements AsyncSocket {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   boolean closeReported;
   private ChannelWrapper mChannel;
   CompletedCallback mClosedHander;
   private CompletedCallback mCompletedCallback;
   DataCallback mDataHandler;
   boolean mEndReported;
   private SelectionKey mKey;
   boolean mPaused = false;
   Exception mPendingEndException;
   private AsyncServer mServer;
   int mToAlloc = 0;
   WritableCallback mWriteableHandler;
   int maxAlloc;
   private ByteBufferList pending = new ByteBufferList();
   InetSocketAddress socketAddress;

   static {
      boolean var0;
      if(!AsyncNetworkSocket.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
   }

   private void handleRemaining(int var1) {
      if(var1 > 0) {
         if(!$assertionsDisabled && this.mChannel.isChunked()) {
            throw new AssertionError();
         } else {
            this.mKey.interestOps(5);
         }
      } else {
         this.mKey.interestOps(1);
      }
   }

   private void spitPending() {
      if(this.pending.hasRemaining()) {
         Util.emitAllData(this, this.pending);
      }

   }

   void attach(DatagramChannel var1) throws IOException {
      this.mChannel = new DatagramChannelWrapper(var1);
      this.maxAlloc = 8192;
   }

   void attach(SocketChannel var1, InetSocketAddress var2) throws IOException {
      this.socketAddress = var2;
      this.maxAlloc = 262144;
      this.mChannel = new SocketChannelWrapper(var1);
   }

   public void close() {
      this.closeInternal();
      this.reportClose((Exception)null);
   }

   public void closeInternal() {
      this.mKey.cancel();

      try {
         this.mChannel.close();
      } catch (IOException var2) {
         ;
      }
   }

   public void end() {
      this.mChannel.shutdownOutput();
   }

   ChannelWrapper getChannel() {
      return this.mChannel;
   }

   public CompletedCallback getClosedCallback() {
      return this.mClosedHander;
   }

   public DataCallback getDataCallback() {
      return this.mDataHandler;
   }

   public CompletedCallback getEndCallback() {
      return this.mCompletedCallback;
   }

   public int getLocalPort() {
      return this.mChannel.getLocalPort();
   }

   public InetSocketAddress getRemoteAddress() {
      return this.socketAddress;
   }

   public AsyncServer getServer() {
      return this.mServer;
   }

   public Object getSocket() {
      return this.getChannel().getSocket();
   }

   public WritableCallback getWriteableCallback() {
      return this.mWriteableHandler;
   }

   public boolean isChunked() {
      return this.mChannel.isChunked();
   }

   public boolean isOpen() {
      return this.mChannel.isConnected() && this.mKey.isValid();
   }

   public boolean isPaused() {
      return this.mPaused;
   }

   public void onDataWritable() {
      if(!$assertionsDisabled && this.mWriteableHandler == null) {
         throw new AssertionError();
      } else {
         this.mWriteableHandler.onWriteable();
      }
   }

   int onReadable() {
      // $FF: Couldn't be decompiled
   }

   public void pause() {
      if(this.mServer.getAffinity() != Thread.currentThread()) {
         this.mServer.run(new Runnable() {
            public void run() {
               AsyncNetworkSocket.this.pause();
            }
         });
      } else if(!this.mPaused) {
         this.mPaused = true;

         try {
            this.mKey.interestOps(-2 & this.mKey.interestOps());
            return;
         } catch (Exception var2) {
            return;
         }
      }

   }

   protected void reportClose(Exception var1) {
      if(!this.closeReported) {
         this.closeReported = true;
         if(this.mClosedHander != null) {
            this.mClosedHander.onCompleted(var1);
            this.mClosedHander = null;
            return;
         }
      }

   }

   void reportEnd(Exception var1) {
      if(!this.mEndReported) {
         this.mEndReported = true;
         if(this.mCompletedCallback != null) {
            this.mCompletedCallback.onCompleted(var1);
            return;
         }

         if(var1 != null) {
            Log.e("NIO", "Unhandled exception", var1);
            return;
         }
      }

   }

   void reportEndPending(Exception var1) {
      if(this.pending.hasRemaining()) {
         this.mPendingEndException = var1;
      } else {
         this.reportEnd(var1);
      }
   }

   public void resume() {
      if(this.mServer.getAffinity() != Thread.currentThread()) {
         this.mServer.run(new Runnable() {
            public void run() {
               AsyncNetworkSocket.this.resume();
            }
         });
      } else if(this.mPaused) {
         this.mPaused = false;

         try {
            this.mKey.interestOps(1 | this.mKey.interestOps());
         } catch (Exception var2) {
            ;
         }

         this.spitPending();
         if(!this.isOpen()) {
            this.reportEndPending(this.mPendingEndException);
            return;
         }
      }

   }

   public void setClosedCallback(CompletedCallback var1) {
      this.mClosedHander = var1;
   }

   public void setDataCallback(DataCallback var1) {
      this.mDataHandler = var1;
   }

   public void setEndCallback(CompletedCallback var1) {
      this.mCompletedCallback = var1;
   }

   public void setWriteableCallback(WritableCallback var1) {
      this.mWriteableHandler = var1;
   }

   void setup(AsyncServer var1, SelectionKey var2) {
      this.mServer = var1;
      this.mKey = var2;
   }

   public void write(final ByteBufferList var1) {
      if(this.mServer.getAffinity() != Thread.currentThread()) {
         this.mServer.run(new Runnable() {
            public void run() {
               AsyncNetworkSocket.this.write(var1);
            }
         });
      } else {
         if(this.mChannel.isConnected()) {
            try {
               ByteBuffer[] var3 = var1.getAllArray();
               this.mChannel.write(var3);
               var1.addAll(var3);
               this.handleRemaining(var1.remaining());
               return;
            } catch (IOException var4) {
               this.close();
               this.reportEndPending(var4);
               this.reportClose(var4);
               return;
            }
         }

         if(!$assertionsDisabled && this.mChannel.isChunked()) {
            throw new AssertionError();
         }
      }

   }

   public void write(final ByteBuffer var1) {
      if(this.mServer.getAffinity() != Thread.currentThread()) {
         this.mServer.run(new Runnable() {
            public void run() {
               AsyncNetworkSocket.this.write(var1);
            }
         });
      } else {
         try {
            if(this.mChannel.isConnected()) {
               this.mChannel.write(var1);
               this.handleRemaining(var1.remaining());
               return;
            }

            if(!$assertionsDisabled && this.mChannel.isChunked()) {
               throw new AssertionError();
            }
         } catch (IOException var3) {
            this.close();
            this.reportEndPending(var3);
            this.reportClose(var3);
            return;
         }
      }

   }
}
