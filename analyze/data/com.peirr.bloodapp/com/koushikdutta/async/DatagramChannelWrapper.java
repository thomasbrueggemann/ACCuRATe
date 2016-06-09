package com.koushikdutta.async;

import com.koushikdutta.async.ChannelWrapper;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

class DatagramChannelWrapper extends ChannelWrapper {
   InetSocketAddress address;
   DatagramChannel mChannel;

   DatagramChannelWrapper(DatagramChannel var1) throws IOException {
      super(var1);
      this.mChannel = var1;
   }

   public void disconnect() throws IOException {
      this.mChannel.disconnect();
   }

   public int getLocalPort() {
      return this.mChannel.socket().getLocalPort();
   }

   public InetSocketAddress getRemoteAddress() {
      return this.address;
   }

   public Object getSocket() {
      return this.mChannel.socket();
   }

   public boolean isChunked() {
      return true;
   }

   public boolean isConnected() {
      return this.mChannel.isConnected();
   }

   public int read(ByteBuffer var1) throws IOException {
      if(!this.isConnected()) {
         int var2 = var1.position();
         this.address = (InetSocketAddress)this.mChannel.receive(var1);
         return this.address == null?-1:var1.position() - var2;
      } else {
         this.address = null;
         return this.mChannel.read(var1);
      }
   }

   public long read(ByteBuffer[] var1) throws IOException {
      return this.mChannel.read(var1);
   }

   public long read(ByteBuffer[] var1, int var2, int var3) throws IOException {
      return this.mChannel.read(var1, var2, var3);
   }

   public SelectionKey register(Selector var1) throws ClosedChannelException {
      return this.register(var1, 1);
   }

   public SelectionKey register(Selector var1, int var2) throws ClosedChannelException {
      return this.mChannel.register(var1, var2);
   }

   public void shutdownInput() {
   }

   public void shutdownOutput() {
   }

   public int write(ByteBuffer var1) throws IOException {
      return this.mChannel.write(var1);
   }

   public int write(ByteBuffer[] var1) throws IOException {
      return (int)this.mChannel.write(var1);
   }
}
