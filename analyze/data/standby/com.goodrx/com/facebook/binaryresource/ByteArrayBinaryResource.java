package com.facebook.binaryresource;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.common.internal.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteArrayBinaryResource implements BinaryResource {
   private final byte[] mBytes;

   public ByteArrayBinaryResource(byte[] var1) {
      this.mBytes = (byte[])Preconditions.checkNotNull(var1);
   }

   public InputStream openStream() throws IOException {
      return new ByteArrayInputStream(this.mBytes);
   }

   public byte[] read() {
      return this.mBytes;
   }

   public long size() {
      return (long)this.mBytes.length;
   }
}
