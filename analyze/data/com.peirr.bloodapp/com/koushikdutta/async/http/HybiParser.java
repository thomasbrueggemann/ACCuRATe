package com.koushikdutta.async.http;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataEmitterReader;
import com.koushikdutta.async.callback.DataCallback;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

abstract class HybiParser {
   private static final int BYTE = 255;
   private static final int FIN = 128;
   private static final List<Integer> FRAGMENTED_OPCODES;
   private static final int LENGTH = 127;
   private static final int MASK = 128;
   private static final int MODE_BINARY = 2;
   private static final int MODE_TEXT = 1;
   private static final int OPCODE = 15;
   private static final List<Integer> OPCODES;
   private static final int OP_BINARY = 2;
   private static final int OP_CLOSE = 8;
   private static final int OP_CONTINUATION = 0;
   private static final int OP_PING = 9;
   private static final int OP_PONG = 10;
   private static final int OP_TEXT = 1;
   private static final int RSV1 = 64;
   private static final int RSV2 = 32;
   private static final int RSV3 = 16;
   private static final String TAG = "HybiParser";
   private ByteArrayOutputStream mBuffer = new ByteArrayOutputStream();
   private boolean mClosed = false;
   private boolean mFinal;
   private int mLength;
   private int mLengthSize;
   private byte[] mMask = new byte[0];
   private boolean mMasked;
   private boolean mMasking = true;
   private int mMode;
   private int mOpcode;
   private byte[] mPayload = new byte[0];
   private DataEmitterReader mReader = new DataEmitterReader();
   private int mStage;
   DataCallback mStage0 = new DataCallback() {
      public void onDataAvailable(DataEmitter var1, ByteBufferList var2) {
         try {
            HybiParser.this.parseOpcode(var2.get());
         } catch (HybiParser.ProtocolError var4) {
            HybiParser.this.report(var4);
            var4.printStackTrace();
         }

         HybiParser.this.parse();
      }
   };
   DataCallback mStage1 = new DataCallback() {
      public void onDataAvailable(DataEmitter var1, ByteBufferList var2) {
         HybiParser.this.parseLength(var2.get());
         HybiParser.this.parse();
      }
   };
   DataCallback mStage2 = new DataCallback() {
      public void onDataAvailable(DataEmitter var1, ByteBufferList var2) {
         byte[] var3 = new byte[HybiParser.this.mLengthSize];
         var2.get(var3);

         try {
            HybiParser.this.parseExtendedLength(var3);
         } catch (HybiParser.ProtocolError var5) {
            HybiParser.this.report(var5);
            var5.printStackTrace();
         }

         HybiParser.this.parse();
      }
   };
   DataCallback mStage3 = new DataCallback() {
      public void onDataAvailable(DataEmitter var1, ByteBufferList var2) {
         HybiParser.this.mMask = new byte[4];
         var2.get(HybiParser.this.mMask);
         HybiParser.this.mStage = 4;
         HybiParser.this.parse();
      }
   };
   DataCallback mStage4 = new DataCallback() {
      public void onDataAvailable(DataEmitter var1, ByteBufferList var2) {
         HybiParser.this.mPayload = new byte[HybiParser.this.mLength];
         var2.get(HybiParser.this.mPayload);

         try {
            HybiParser.this.emitFrame();
         } catch (IOException var5) {
            HybiParser.this.report(var5);
            var5.printStackTrace();
         }

         HybiParser.this.mStage = 0;
         HybiParser.this.parse();
      }
   };

   static {
      Integer[] var0 = new Integer[]{Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(8), Integer.valueOf(9), Integer.valueOf(10)};
      OPCODES = Arrays.asList(var0);
      Integer[] var1 = new Integer[]{Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2)};
      FRAGMENTED_OPCODES = Arrays.asList(var1);
   }

   public HybiParser(DataEmitter var1) {
      var1.setDataCallback(this.mReader);
      this.parse();
   }

   private static long byteArrayToLong(byte[] var0, int var1, int var2) {
      if(var0.length < var2) {
         throw new IllegalArgumentException("length must be less than or equal to b.length");
      } else {
         long var3 = 0L;

         for(int var5 = 0; var5 < var2; ++var5) {
            int var6 = 8 * (var2 - 1 - var5);
            var3 += (long)((255 & var0[var5 + var1]) << var6);
         }

         return var3;
      }
   }

   private byte[] decode(String var1) {
      try {
         byte[] var3 = var1.getBytes("UTF-8");
         return var3;
      } catch (UnsupportedEncodingException var4) {
         throw new RuntimeException(var4);
      }
   }

   private void emitFrame() throws IOException {
      byte[] var1 = mask(this.mPayload, this.mMask, 0);
      int var2 = this.mOpcode;
      if(var2 == 0) {
         if(this.mMode == 0) {
            throw new HybiParser.ProtocolError("Mode was not set.");
         }

         this.mBuffer.write(var1);
         if(this.mFinal) {
            byte[] var7 = this.mBuffer.toByteArray();
            if(this.mMode == 1) {
               this.onMessage(this.encode(var7));
            } else {
               this.onMessage(var7);
            }

            this.reset();
         }
      } else {
         if(var2 == 1) {
            if(this.mFinal) {
               this.onMessage(this.encode(var1));
               return;
            }

            this.mMode = 1;
            this.mBuffer.write(var1);
            return;
         }

         if(var2 == 2) {
            if(this.mFinal) {
               this.onMessage(var1);
               return;
            }

            this.mMode = 2;
            this.mBuffer.write(var1);
            return;
         }

         if(var2 == 8) {
            int var4 = var1.length;
            int var5 = 0;
            if(var4 >= 2) {
               var5 = 256 * var1[0] + var1[1];
            }

            String var6;
            if(var1.length > 2) {
               var6 = this.encode(this.slice(var1, 2));
            } else {
               var6 = null;
            }

            this.onDisconnect(var5, var6);
            return;
         }

         if(var2 == 9) {
            if(var1.length > 125) {
               throw new HybiParser.ProtocolError("Ping payload too large");
            }

            this.sendFrame(this.frame((byte[])var1, 10, -1));
            return;
         }

         if(var2 == 10) {
            this.encode(var1);
            return;
         }
      }

   }

   private String encode(byte[] var1) {
      try {
         String var2 = new String(var1, "UTF-8");
         return var2;
      } catch (UnsupportedEncodingException var4) {
         throw new RuntimeException(var4);
      }
   }

   private byte[] frame(Object var1, int var2, int var3) {
      byte[] var11;
      if(this.mClosed) {
         var11 = null;
      } else {
         byte[] var4;
         if(var1 instanceof String) {
            var4 = this.decode((String)var1);
         } else {
            var4 = (byte[])((byte[])var1);
         }

         byte var5;
         if(var3 > 0) {
            var5 = 2;
         } else {
            var5 = 0;
         }

         int var6 = var5 + var4.length;
         byte var7;
         if(var6 <= 125) {
            var7 = 2;
         } else if(var6 <= '\uffff') {
            var7 = 4;
         } else {
            var7 = 10;
         }

         byte var8;
         if(this.mMasking) {
            var8 = 4;
         } else {
            var8 = 0;
         }

         int var9 = var7 + var8;
         short var10;
         if(this.mMasking) {
            var10 = 128;
         } else {
            var10 = 0;
         }

         var11 = new byte[var6 + var9];
         var11[0] = (byte)(-128 | (byte)var2);
         if(var6 <= 125) {
            var11[1] = (byte)(var10 | var6);
         } else if(var6 <= '\uffff') {
            var11[1] = (byte)(var10 | 126);
            var11[2] = (byte)((int)Math.floor((double)(var6 / 256)));
            var11[3] = (byte)(var6 & 255);
         } else {
            var11[1] = (byte)(var10 | 127);
            var11[2] = (byte)(255 & (int)Math.floor((double)var6 / Math.pow(2.0D, 56.0D)));
            var11[3] = (byte)(255 & (int)Math.floor((double)var6 / Math.pow(2.0D, 48.0D)));
            var11[4] = (byte)(255 & (int)Math.floor((double)var6 / Math.pow(2.0D, 40.0D)));
            var11[5] = (byte)(255 & (int)Math.floor((double)var6 / Math.pow(2.0D, 32.0D)));
            var11[6] = (byte)(255 & (int)Math.floor((double)var6 / Math.pow(2.0D, 24.0D)));
            var11[7] = (byte)(255 & (int)Math.floor((double)var6 / Math.pow(2.0D, 16.0D)));
            var11[8] = (byte)(255 & (int)Math.floor((double)var6 / Math.pow(2.0D, 8.0D)));
            var11[9] = (byte)(var6 & 255);
         }

         if(var3 > 0) {
            var11[var9] = (byte)(255 & (int)Math.floor((double)(var3 / 256)));
            var11[var9 + 1] = (byte)(var3 & 255);
         }

         System.arraycopy(var4, 0, var11, var9 + var5, var4.length);
         if(this.mMasking) {
            byte[] var12 = new byte[]{(byte)((int)Math.floor(256.0D * Math.random())), (byte)((int)Math.floor(256.0D * Math.random())), (byte)((int)Math.floor(256.0D * Math.random())), (byte)((int)Math.floor(256.0D * Math.random()))};
            System.arraycopy(var12, 0, var11, var7, var12.length);
            mask(var11, var12, var9);
            return var11;
         }
      }

      return var11;
   }

   private byte[] frame(String var1, int var2, int var3) {
      return this.frame((Object)var1, var2, var3);
   }

   private byte[] frame(byte[] var1, int var2, int var3) {
      return this.frame((Object)var1, var2, var3);
   }

   private int getInteger(byte[] var1) throws HybiParser.ProtocolError {
      long var2 = byteArrayToLong(var1, 0, var1.length);
      if(var2 >= 0L && var2 <= 2147483647L) {
         return (int)var2;
      } else {
         throw new HybiParser.ProtocolError("Bad integer: " + var2);
      }
   }

   private static byte[] mask(byte[] var0, byte[] var1, int var2) {
      if(var1.length != 0) {
         for(int var3 = 0; var3 < var0.length - var2; ++var3) {
            var0[var2 + var3] ^= var1[var3 % 4];
         }
      }

      return var0;
   }

   private void parseExtendedLength(byte[] var1) throws HybiParser.ProtocolError {
      this.mLength = this.getInteger(var1);
      byte var2;
      if(this.mMasked) {
         var2 = 3;
      } else {
         var2 = 4;
      }

      this.mStage = var2;
   }

   private void parseLength(byte var1) {
      boolean var2;
      if((var1 & 128) == 128) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.mMasked = var2;
      this.mLength = var1 & 127;
      if(this.mLength >= 0 && this.mLength <= 125) {
         byte var4;
         if(this.mMasked) {
            var4 = 3;
         } else {
            var4 = 4;
         }

         this.mStage = var4;
      } else {
         byte var3;
         if(this.mLength == 126) {
            var3 = 2;
         } else {
            var3 = 8;
         }

         this.mLengthSize = var3;
         this.mStage = 2;
      }
   }

   private void parseOpcode(byte var1) throws HybiParser.ProtocolError {
      boolean var2;
      if((var1 & 64) == 64) {
         var2 = true;
      } else {
         var2 = false;
      }

      boolean var3;
      if((var1 & 32) == 32) {
         var3 = true;
      } else {
         var3 = false;
      }

      boolean var4;
      if((var1 & 16) == 16) {
         var4 = true;
      } else {
         var4 = false;
      }

      if(!var2 && !var3 && !var4) {
         boolean var5;
         if((var1 & 128) == 128) {
            var5 = true;
         } else {
            var5 = false;
         }

         this.mFinal = var5;
         this.mOpcode = var1 & 15;
         this.mMask = new byte[0];
         this.mPayload = new byte[0];
         if(!OPCODES.contains(Integer.valueOf(this.mOpcode))) {
            throw new HybiParser.ProtocolError("Bad opcode");
         } else if(!FRAGMENTED_OPCODES.contains(Integer.valueOf(this.mOpcode)) && !this.mFinal) {
            throw new HybiParser.ProtocolError("Expected non-final packet");
         } else {
            this.mStage = 1;
         }
      } else {
         throw new HybiParser.ProtocolError("RSV not zero");
      }
   }

   private void reset() {
      this.mMode = 0;
      this.mBuffer.reset();
   }

   private byte[] slice(byte[] var1, int var2) {
      byte[] var3 = new byte[var1.length - var2];
      System.arraycopy(var1, var2, var3, 0, var1.length - var2);
      return var3;
   }

   public void close(int var1, String var2) {
      if(!this.mClosed) {
         this.sendFrame(this.frame((String)var2, 8, var1));
         this.mClosed = true;
      }
   }

   public byte[] frame(String var1) {
      return this.frame((String)var1, 1, -1);
   }

   public byte[] frame(byte[] var1) {
      return this.frame((byte[])var1, 2, -1);
   }

   protected abstract void onDisconnect(int var1, String var2);

   protected abstract void onMessage(String var1);

   protected abstract void onMessage(byte[] var1);

   void parse() {
      switch(this.mStage) {
      case 0:
         this.mReader.read(1, this.mStage0);
         return;
      case 1:
         this.mReader.read(1, this.mStage1);
         return;
      case 2:
         this.mReader.read(this.mLengthSize, this.mStage2);
         return;
      case 3:
         this.mReader.read(4, this.mStage3);
         return;
      case 4:
         this.mReader.read(this.mLength, this.mStage4);
         return;
      default:
      }
   }

   public void ping(String var1) {
   }

   protected abstract void report(Exception var1);

   protected abstract void sendFrame(byte[] var1);

   public void setMasking(boolean var1) {
      this.mMasking = var1;
   }

   public static class ProtocolError extends IOException {
      public ProtocolError(String var1) {
         super(var1);
      }
   }
}
