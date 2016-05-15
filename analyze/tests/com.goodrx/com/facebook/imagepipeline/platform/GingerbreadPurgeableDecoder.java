package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.MemoryFile;
import com.facebook.common.internal.Throwables;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.platform.DalvikPurgeableDecoder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import javax.annotation.Nullable;

public class GingerbreadPurgeableDecoder extends DalvikPurgeableDecoder {
   private static Method sGetFileDescriptorMethod;
   private final boolean mWebpSupportEnabled;

   public GingerbreadPurgeableDecoder(boolean var1) {
      this.mWebpSupportEnabled = var1;
   }

   private static MemoryFile copyToMemoryFile(CloseableReference<PooledByteBuffer> param0, int param1, @Nullable byte[] param2) throws IOException {
      // $FF: Couldn't be decompiled
   }

   private Method getFileDescriptorMethod() {
      // $FF: Couldn't be decompiled
   }

   private FileDescriptor getMemoryFileDescriptor(MemoryFile var1) {
      try {
         FileDescriptor var3 = (FileDescriptor)this.getFileDescriptorMethod().invoke(var1, new Object[0]);
         return var3;
      } catch (Exception var4) {
         throw Throwables.propagate(var4);
      }
   }

   protected Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> var1, Options var2) {
      return this.decodeFileDescriptorAsPurgeable(var1, ((PooledByteBuffer)var1.get()).size(), (byte[])null, var2);
   }

   protected Bitmap decodeFileDescriptorAsPurgeable(CloseableReference<PooledByteBuffer> param1, int param2, byte[] param3, Options param4) {
      // $FF: Couldn't be decompiled
   }

   protected Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> var1, int var2, Options var3) {
      byte[] var4;
      if(endsWithEOI(var1, var2)) {
         var4 = null;
      } else {
         var4 = EOI;
      }

      return this.decodeFileDescriptorAsPurgeable(var1, var2, var4, var3);
   }
}
