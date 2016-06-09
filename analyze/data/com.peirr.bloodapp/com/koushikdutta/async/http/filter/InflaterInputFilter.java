package com.koushikdutta.async.http.filter;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.FilteredDataEmitter;
import java.io.IOException;
import java.util.zip.Inflater;

public class InflaterInputFilter extends FilteredDataEmitter {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private Inflater mInflater;
   ByteBufferList transformed;

   static {
      boolean var0;
      if(!InflaterInputFilter.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
   }

   public InflaterInputFilter() {
      this(new Inflater());
   }

   public InflaterInputFilter(Inflater var1) {
      this.transformed = new ByteBufferList();
      this.mInflater = var1;
   }

   public void onDataAvailable(DataEmitter param1, ByteBufferList param2) {
      // $FF: Couldn't be decompiled
   }

   protected void report(Exception var1) {
      if(var1 != null && this.mInflater.getRemaining() > 0) {
         var1 = new IOException("data still remaining in inflater");
      }

      super.report((Exception)var1);
   }
}
