package com.koushikdutta.async.http.filter;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.FilteredDataEmitter;

public class ChunkedInputFilter extends FilteredDataEmitter {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private int mChunkLength = 0;
   private int mChunkLengthRemaining = 0;
   private ChunkedInputFilter.State mState;

   static {
      boolean var0;
      if(!ChunkedInputFilter.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
   }

   public ChunkedInputFilter() {
      this.mState = ChunkedInputFilter.State.CHUNK_LEN;
   }

   private boolean checkByte(char var1, char var2) {
      if(var1 != var2) {
         this.report(new Exception(var2 + " was expeceted, got " + var1));
         return false;
      } else {
         return true;
      }
   }

   private boolean checkCR(char var1) {
      return this.checkByte(var1, '\r');
   }

   private boolean checkLF(char var1) {
      return this.checkByte(var1, '\n');
   }

   public void onDataAvailable(DataEmitter param1, ByteBufferList param2) {
      // $FF: Couldn't be decompiled
   }

   private static enum State {
      CHUNK,
      CHUNK_CR,
      CHUNK_CRLF,
      CHUNK_LEN,
      CHUNK_LEN_CR,
      CHUNK_LEN_CRLF,
      COMPLETE;

      static {
         ChunkedInputFilter.State[] var0 = new ChunkedInputFilter.State[]{CHUNK_LEN, CHUNK_LEN_CR, CHUNK_LEN_CRLF, CHUNK, CHUNK_CR, CHUNK_CRLF, COMPLETE};
      }
   }
}
