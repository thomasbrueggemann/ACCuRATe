package com.koushikdutta.async;

import com.koushikdutta.async.ChannelWrapper;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

class SocketChannelWrapper extends ChannelWrapper {
   SocketChannel mChannel;

   SocketChannelWrapper(SocketChannel var1) throws IOException {
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
      return this.mChannel.isConnected();
   }

   public int read(ByteBuffer var1) throws IOException {
      return this.mChannel.read(var1);
   }

   public long read(ByteBuffer[] var1) throws IOException {
      return this.mChannel.read(var1);
   }

   public long read(ByteBuffer[] var1, int var2, int var3) throws IOException {
      return this.mChannel.read(var1, var2, var3);
   }

   public SelectionKey register(Selector var1) throws ClosedChannelException {
      return this.register(var1, 8);
   }

   public void shutdownInput() {
      try {
         this.mChannel.socket().shutdownInput();
      } catch (Exception var2) {
         ;
      }
   }

   public void shutdownOutput() {
      try {
         this.mChannel.socket().shutdownOutput();
      } catch (Exception var2) {
         ;
      }
   }

   public int write(ByteBuffer var1) throws IOException {
      return this.mChannel.write(var1);
   }

   public int write(ByteBuffer[] var1) throws IOException {
      return (int)this.mChannel.write(var1);
   }
}
