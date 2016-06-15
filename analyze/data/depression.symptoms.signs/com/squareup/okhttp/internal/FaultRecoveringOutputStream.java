package com.squareup.okhttp.internal;

import com.squareup.okhttp.internal.AbstractOutputStream;
import com.squareup.okhttp.internal.Util;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;

public abstract class FaultRecoveringOutputStream extends AbstractOutputStream {
   private final int maxReplayBufferLength;
   private OutputStream out;
   private ByteArrayOutputStream replayBuffer;

   public FaultRecoveringOutputStream(int var1, OutputStream var2) {
      if(var1 < 0) {
         throw new IllegalArgumentException();
      } else {
         this.maxReplayBufferLength = var1;
         this.replayBuffer = new ByteArrayOutputStream(var1);
         this.out = var2;
      }
   }

   private boolean recover(IOException param1) {
      // $FF: Couldn't be decompiled
   }

   public final void close() throws IOException {
      if(!this.closed) {
         while(true) {
            try {
               this.out.close();
               this.closed = true;
               return;
            } catch (IOException var2) {
               if(!this.recover(var2)) {
                  throw var2;
               }
            }
         }
      }
   }

   public final void flush() throws IOException {
      if(!this.closed) {
         while(true) {
            try {
               this.out.flush();
               return;
            } catch (IOException var2) {
               if(!this.recover(var2)) {
                  throw var2;
               }
            }
         }
      }
   }

   public boolean isRecoverable() {
      return this.replayBuffer != null;
   }

   public final void replaceStream(OutputStream var1) throws IOException {
      if(!this.isRecoverable()) {
         throw new IllegalStateException();
      } else if(this.out != var1) {
         this.replayBuffer.writeTo(var1);
         Util.closeQuietly((Closeable)this.out);
         this.out = var1;
      }
   }

   protected abstract OutputStream replacementStream(IOException var1) throws IOException;

   public final void write(byte[] var1, int var2, int var3) throws IOException {
      if(this.closed) {
         throw new IOException("stream closed");
      } else {
         Util.checkOffsetAndCount(var1.length, var2, var3);

         while(true) {
            try {
               this.out.write(var1, var2, var3);
               if(this.replayBuffer == null) {
                  return;
               }

               if(var3 + this.replayBuffer.size() > this.maxReplayBufferLength) {
                  this.replayBuffer = null;
                  return;
               }

               this.replayBuffer.write(var1, var2, var3);
               return;
            } catch (IOException var5) {
               if(!this.recover(var5)) {
                  throw var5;
               }
            }
         }
      }
   }
}
