package com.koushikdutta.async.http.filter;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.NullDataCallback;
import com.koushikdutta.async.PushParser;
import com.koushikdutta.async.TapCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.http.filter.InflaterInputFilter;
import com.koushikdutta.async.http.libcore.Memory;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public class GZIPInputFilter extends InflaterInputFilter {
   private static final int FCOMMENT = 16;
   private static final int FEXTRA = 4;
   private static final int FHCRC = 2;
   private static final int FNAME = 8;
   protected CRC32 crc = new CRC32();
   boolean mNeedsHeader = true;

   public GZIPInputFilter() {
      super(new Inflater(true));
   }

   public static int unsignedToBytes(byte var0) {
      return var0 & 255;
   }

   public void onDataAvailable(final DataEmitter var1, ByteBufferList var2) {
      if(this.mNeedsHeader) {
         final PushParser var3 = new PushParser(var1);
         var3.readBuffer(10).tap(new TapCallback() {
            int flags;
            boolean hcrc;

            private void next() {
               PushParser var1x = new PushParser(var1);
               DataCallback var2 = new DataCallback() {
                  public void onDataAvailable(DataEmitter var1x, ByteBufferList var2) {
                     if(hcrc) {
                        while(var2.size() > 0) {
                           ByteBuffer var3x = var2.remove();
                           GZIPInputFilter.this.crc.update(var3x.array(), var3x.arrayOffset() + var3x.position(), var3x.remaining());
                           ByteBufferList.reclaim(var3x);
                        }
                     }

                  }
               };
               if((8 & this.flags) != 0) {
                  var1x.until((byte)0, var2);
               }

               if((16 & this.flags) != 0) {
                  var1x.until((byte)0, var2);
               }

               if(this.hcrc) {
                  var1x.readBuffer(2);
               } else {
                  var1x.noop();
               }

               var1x.tap(new TapCallback() {
                  public void tap(byte[] var1x) {
                     if(var1x != null) {
                        short var2 = Memory.peekShort(var1x, 0, ByteOrder.LITTLE_ENDIAN);
                        if((short)((int)GZIPInputFilter.this.crc.getValue()) != var2) {
                           GZIPInputFilter.this.report(new IOException("CRC mismatch"));
                           return;
                        }

                        GZIPInputFilter.this.crc.reset();
                     }

                     GZIPInputFilter.this.mNeedsHeader = false;
                     GZIPInputFilter.this.setDataEmitter(var1);
                  }
               });
            }

            public void tap(byte[] var1x) {
               byte var2 = 1;
               short var3x = Memory.peekShort(var1x, 0, ByteOrder.LITTLE_ENDIAN);
               if(var3x != -29921) {
                  GZIPInputFilter var4 = GZIPInputFilter.this;
                  Object[] var5 = new Object[var2];
                  var5[0] = Short.valueOf(var3x);
                  var4.report(new IOException(String.format("unknown format (magic number %x)", var5)));
                  var1.setDataCallback(new NullDataCallback());
               } else {
                  this.flags = var1x[3];
                  if((2 & this.flags) == 0) {
                     var2 = 0;
                  }

                  this.hcrc = (boolean)var2;
                  if(this.hcrc) {
                     GZIPInputFilter.this.crc.update(var1x, 0, var1x.length);
                  }

                  if((4 & this.flags) != 0) {
                     var3.readBuffer(2).tap(new TapCallback() {
                        public void tap(byte[] var1x) {
                           if(hcrc) {
                              GZIPInputFilter.this.crc.update(var1x, 0, 2);
                           }

                           int var2 = '\uffff' & Memory.peekShort(var1x, 0, ByteOrder.LITTLE_ENDIAN);
                           var3.readBuffer(var2).tap(new TapCallback() {
                              public void tap(byte[] var1x) {
                                 if(hcrc) {
                                    GZIPInputFilter.this.crc.update(var1x, 0, var1x.length);
                                 }

                                 next();
                              }
                           });
                        }
                     });
                  }

                  this.next();
               }
            }
         });
      } else {
         super.onDataAvailable(var1, var2);
      }
   }
}
