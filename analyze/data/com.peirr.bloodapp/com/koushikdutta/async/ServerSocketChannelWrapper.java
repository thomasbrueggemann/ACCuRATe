package com.koushikdutta.async;

import com.koushikdutta.async.ChannelWrapper;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

class ServerSocketChannelWrapper extends ChannelWrapper {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   ServerSocketChannel mChannel;

   static {
      boolean var0;
      if(!ServerSocketChannelWrapper.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
   }

   ServerSocketChannelWrapper(ServerSocketChannel var1) throws IOException {
      super(var1);
      this.mChannel = var1;
   }

   public int getLocalPort() {
      return this.mChannel.socket().getLocalPort();
   }

   public Object getSocket() {
      return this.mChannel.socket();
   }

   public boolean isConnected() {
      if(!$assertionsDisabled) {
         throw new AssertionError();
      } else {
         return false;
      }
   }

   public int read(ByteBuffer var1) throws IOException {
      if(!$assertionsDisabled) {
         throw new AssertionError();
      } else {
         throw new IOException("Can\'t read ServerSocketChannel");
      }
   }

   public long read(ByteBuffer[] var1) throws IOException {
      if(!$assertionsDisabled) {
         throw new AssertionError();
      } else {
         throw new IOException("Can\'t read ServerSocketChannel");
      }
   }

   public long read(ByteBuffer[] var1, int var2, int var3) throws IOException {
      if(!$assertionsDisabled) {
         throw new AssertionError();
      } else {
         throw new IOException("Can\'t read ServerSocketChannel");
      }
   }

   public SelectionKey register(Selector var1) throws ClosedChannelException {
      return this.mChannel.register(var1, 16);
   }

   public void shutdownInput() {
   }

   public void shutdownOutput() {
   }

   public int write(ByteBuffer var1) throws IOException {
      if(!$assertionsDisabled) {
         throw new AssertionError();
      } else {
         throw new IOException("Can\'t write ServerSocketChannel");
      }
   }

   public int write(ByteBuffer[] var1) throws IOException {
      if(!$assertionsDisabled) {
         throw new AssertionError();
      } else {
         throw new IOException("Can\'t write ServerSocketChannel");
      }
   }
}
