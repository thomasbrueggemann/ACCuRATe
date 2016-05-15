package android.support.multidex;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

final class ZipUtil {
   private static final int BUFFER_SIZE = 16384;
   private static final int ENDHDR = 22;
   private static final int ENDSIG = 101010256;

   static long computeCrcOfCentralDir(RandomAccessFile var0, ZipUtil.CentralDirectory var1) throws IOException {
      CRC32 var2 = new CRC32();
      long var3 = var1.size;
      var0.seek(var1.offset);
      int var5 = (int)Math.min(16384L, var3);
      byte[] var6 = new byte[16384];

      for(int var7 = var0.read(var6, 0, var5); var7 != -1; var7 = var0.read(var6, 0, (int)Math.min(16384L, var3))) {
         var2.update(var6, 0, var7);
         var3 -= (long)var7;
         if(var3 == 0L) {
            break;
         }
      }

      return var2.getValue();
   }

   static ZipUtil.CentralDirectory findCentralDirectory(RandomAccessFile var0) throws IOException, ZipException {
      long var1 = var0.length() - 22L;
      if(var1 < 0L) {
         throw new ZipException("File too short to be a zip file: " + var0.length());
      } else {
         long var3 = var1 - 65536L;
         if(var3 < 0L) {
            var3 = 0L;
         }

         int var5 = Integer.reverseBytes(101010256);

         do {
            var0.seek(var1);
            if(var0.readInt() == var5) {
               var0.skipBytes(2);
               var0.skipBytes(2);
               var0.skipBytes(2);
               var0.skipBytes(2);
               ZipUtil.CentralDirectory var10 = new ZipUtil.CentralDirectory();
               var10.size = 4294967295L & (long)Integer.reverseBytes(var0.readInt());
               var10.offset = 4294967295L & (long)Integer.reverseBytes(var0.readInt());
               return var10;
            }

            --var1;
         } while(var1 >= var3);

         throw new ZipException("End Of Central Directory signature not found");
      }
   }

   static long getZipCrc(File var0) throws IOException {
      RandomAccessFile var1 = new RandomAccessFile(var0, "r");

      long var3;
      try {
         var3 = computeCrcOfCentralDir(var1, findCentralDirectory(var1));
      } finally {
         var1.close();
      }

      return var3;
   }

   static class CentralDirectory {
      long offset;
      long size;
   }
}
