package com.koushikdutta.async;

import com.koushikdutta.async.AsyncNetworkSocket;
import com.koushikdutta.async.DatagramChannelWrapper;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

public class AsyncDatagramSocket extends AsyncNetworkSocket {
   public void connect(InetSocketAddress var1) throws IOException {
      this.socketAddress = var1;
      ((DatagramChannelWrapper)this.getChannel()).mChannel.connect(var1);
   }

   public void disconnect() throws IOException {
      this.socketAddress = null;
      ((DatagramChannelWrapper)this.getChannel()).disconnect();
   }

   public InetSocketAddress getRemoteAddress() {
      return this.isOpen()?super.getRemoteAddress():((DatagramChannelWrapper)this.getChannel()).getRemoteAddress();
   }

   public void send(final String var1, final int var2, final ByteBuffer var3) {
      if(this.getServer().getAffinity() != Thread.currentThread()) {
         this.getServer().run(new Runnable() {
            public void run() {
               AsyncDatagramSocket.this.send(var1, var2, var3);
            }
         });
      } else {
         try {
            ((DatagramChannelWrapper)this.getChannel()).mChannel.send(var3, new InetSocketAddress(var1, var2));
         } catch (IOException var5) {
            ;
         }
      }
   }

   public void send(final InetSocketAddress var1, final ByteBuffer var2) {
      if(this.getServer().getAffinity() != Thread.currentThread()) {
         this.getServer().run(new Runnable() {
            public void run() {
               AsyncDatagramSocket.this.send(var1, var2);
            }
         });
      } else {
         try {
            ((DatagramChannelWrapper)this.getChannel()).mChannel.send(var2, new InetSocketAddress(var1.getHostName(), var1.getPort()));
         } catch (IOException var4) {
            ;
         }
      }
   }
}
