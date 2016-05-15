package com.facebook.imagepipeline.memory;

import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferOutputStream;
import java.io.IOException;
import java.io.InputStream;

public interface PooledByteBufferFactory {
   PooledByteBuffer newByteBuffer(int var1);

   PooledByteBuffer newByteBuffer(InputStream var1) throws IOException;

   PooledByteBuffer newByteBuffer(InputStream var1, int var2) throws IOException;

   PooledByteBuffer newByteBuffer(byte[] var1);

   PooledByteBufferOutputStream newOutputStream();

   PooledByteBufferOutputStream newOutputStream(int var1);
}
