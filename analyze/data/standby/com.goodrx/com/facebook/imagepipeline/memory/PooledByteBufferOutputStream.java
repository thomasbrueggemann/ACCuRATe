package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Throwables;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import java.io.IOException;
import java.io.OutputStream;

public abstract class PooledByteBufferOutputStream extends OutputStream {
   public void close() {
      try {
         super.close();
      } catch (IOException var2) {
         Throwables.propagate(var2);
      }
   }

   public abstract int size();

   public abstract PooledByteBuffer toByteBuffer();
}
