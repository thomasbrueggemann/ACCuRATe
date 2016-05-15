package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.memory.ByteArrayPool;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PooledByteStreams {
   private static final int DEFAULT_TEMP_BUF_SIZE = 16384;
   private final ByteArrayPool mByteArrayPool;
   private final int mTempBufSize;

   public PooledByteStreams(ByteArrayPool var1) {
      this(var1, 16384);
   }

   @VisibleForTesting
   PooledByteStreams(ByteArrayPool var1, int var2) {
      boolean var3;
      if(var2 > 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      Preconditions.checkArgument(var3);
      this.mTempBufSize = var2;
      this.mByteArrayPool = var1;
   }

   public long copy(InputStream param1, OutputStream param2) throws IOException {
      // $FF: Couldn't be decompiled
   }

   public long copy(InputStream param1, OutputStream param2, long param3) throws IOException {
      // $FF: Couldn't be decompiled
   }
}
