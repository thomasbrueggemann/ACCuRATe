package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.util.StreamUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.ByteArrayPool;
import com.facebook.imagepipeline.memory.PooledByteArrayBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ProgressiveJpegParser {
   private static final int BUFFER_SIZE = 16384;
   private static final int NOT_A_JPEG = 6;
   private static final int READ_FIRST_JPEG_BYTE = 0;
   private static final int READ_MARKER_FIRST_BYTE_OR_ENTROPY_DATA = 2;
   private static final int READ_MARKER_SECOND_BYTE = 3;
   private static final int READ_SECOND_JPEG_BYTE = 1;
   private static final int READ_SIZE_FIRST_BYTE = 4;
   private static final int READ_SIZE_SECOND_BYTE = 5;
   private int mBestScanEndOffset;
   private int mBestScanNumber;
   private final ByteArrayPool mByteArrayPool;
   private int mBytesParsed;
   private int mLastByteRead;
   private int mNextFullScanNumber;
   private int mParserState;

   public ProgressiveJpegParser(ByteArrayPool var1) {
      this.mByteArrayPool = (ByteArrayPool)Preconditions.checkNotNull(var1);
      this.mBytesParsed = 0;
      this.mLastByteRead = 0;
      this.mNextFullScanNumber = 0;
      this.mBestScanEndOffset = 0;
      this.mBestScanNumber = 0;
      this.mParserState = 0;
   }

   private boolean doParseMoreData(InputStream param1) {
      // $FF: Couldn't be decompiled
   }

   private static boolean doesMarkerStartSegment(int var0) {
      byte var1 = 1;
      if(var0 == var1 || var0 >= 208 && var0 <= 215) {
         return false;
      } else {
         if(var0 == 217 || var0 == 216) {
            var1 = 0;
         }

         return (boolean)var1;
      }
   }

   private void newScanOrImageEndFound(int var1) {
      if(this.mNextFullScanNumber > 0) {
         this.mBestScanEndOffset = var1;
      }

      int var2 = this.mNextFullScanNumber;
      this.mNextFullScanNumber = var2 + 1;
      this.mBestScanNumber = var2;
   }

   public int getBestScanEndOffset() {
      return this.mBestScanEndOffset;
   }

   public int getBestScanNumber() {
      return this.mBestScanNumber;
   }

   public boolean isJpeg() {
      return this.mBytesParsed > 1 && this.mParserState != 6;
   }

   public boolean parseMoreData(EncodedImage var1) {
      if(this.mParserState == 6) {
         return false;
      } else if(var1.getSize() <= this.mBytesParsed) {
         return false;
      } else {
         PooledByteArrayBufferedInputStream var2 = new PooledByteArrayBufferedInputStream(var1.getInputStream(), (byte[])this.mByteArrayPool.get(16384), this.mByteArrayPool);

         try {
            StreamUtil.skip(var2, (long)this.mBytesParsed);
            boolean var8 = this.doParseMoreData(var2);
            return var8;
         } catch (IOException var11) {
            Throwables.propagate(var11);
         } finally {
            Closeables.closeQuietly((InputStream)var2);
         }

         return false;
      }
   }
}
