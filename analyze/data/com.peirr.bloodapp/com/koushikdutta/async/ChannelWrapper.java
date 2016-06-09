package com.koushikdutta.async;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractSelectableChannel;

abstract class ChannelWrapper implements ReadableByteChannel, ScatteringByteChannel {
   private AbstractSelectableChannel mChannel;

   ChannelWrapper(AbstractSelectableChannel var1) throws IOException {
      var1.configureBlocking(false);
      this.mChannel = var1;
   }

   public void close() throws IOException {
      this.mChannel.close();
   }

   public abstract int getLocalPort();

   public abstract Object getSocket();

   public boolean isChunked() {
      return false;
   }

   public abstract boolean isConnected();

   public boolean isOpen() {
      return this.mChannel.isOpen();
   }

   public abstract SelectionKey register(Selector var1) throws ClosedChannelException;

   public SelectionKey register(Selector var1, int var2) throws ClosedChannelException {
      return this.mChannel.register(var1, var2);
   }

   public abstract void shutdownInput();

   public abstract void shutdownOutput();

   public abstract int write(ByteBuffer var1) throws IOException;

   public abstract int write(ByteBuffer[] var1) throws IOException;
}
