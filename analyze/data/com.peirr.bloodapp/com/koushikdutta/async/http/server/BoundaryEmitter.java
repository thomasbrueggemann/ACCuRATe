package com.koushikdutta.async.http.server;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.FilteredDataEmitter;
import java.nio.ByteBuffer;

public class BoundaryEmitter extends FilteredDataEmitter {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private byte[] boundary;
   int state = 2;

   static {
      boolean var0;
      if(!BoundaryEmitter.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
   }

   public String getBoundary() {
      return this.boundary == null?null:new String(this.boundary, 4, -4 + this.boundary.length);
   }

   public String getBoundaryEnd() {
      if(!$assertionsDisabled && this.boundary == null) {
         throw new AssertionError();
      } else {
         return this.getBoundaryStart() + "--\r\n";
      }
   }

   public String getBoundaryStart() {
      if(!$assertionsDisabled && this.boundary == null) {
         throw new AssertionError();
      } else {
         return new String(this.boundary, 2, -2 + this.boundary.length);
      }
   }

   protected void onBoundaryEnd() {
   }

   protected void onBoundaryStart() {
   }

   public void onDataAvailable(DataEmitter var1, ByteBufferList var2) {
      if(this.state > 0) {
         var2.addFirst(ByteBuffer.wrap(this.boundary, 0, this.state).duplicate());
         this.state = 0;
      }

      int var3 = 0;
      byte[] var4 = new byte[var2.remaining()];
      var2.get(var4);
      int var5 = 0;

      while(true) {
         if(var5 >= var4.length) {
            if(var3 < var4.length) {
               int var6 = Math.max(this.state, 0);
               ByteBuffer var7 = ByteBuffer.wrap(var4, var3, var4.length - var3 - var6);
               ByteBufferList var8 = new ByteBufferList();
               var8.add(var7);
               super.onDataAvailable(this, var8);
               return;
            }
            break;
         }

         if(this.state >= 0) {
            if(var4[var5] == this.boundary[this.state]) {
               ++this.state;
               if(this.state == this.boundary.length) {
                  this.state = -1;
               }
            } else if(this.state > 0) {
               var5 -= this.state;
               this.state = 0;
            }
         } else if(this.state == -1) {
            if(var4[var5] == 13) {
               this.state = -4;
               int var11 = var5 - var3 - this.boundary.length;
               if(var3 != 0 || var11 != 0) {
                  ByteBuffer var12 = ByteBuffer.wrap(var4, var3, var11);
                  ByteBufferList var13 = new ByteBufferList();
                  var13.add(var12);
                  super.onDataAvailable(this, var13);
               }

               this.onBoundaryStart();
            } else {
               if(var4[var5] != 45) {
                  this.report(new Exception("Invalid multipart/form-data. Expected \r or -"));
                  break;
               }

               this.state = -2;
            }
         } else if(this.state == -2) {
            if(var4[var5] != 45) {
               this.report(new Exception("Invalid multipart/form-data. Expected -"));
               return;
            }

            this.state = -3;
         } else if(this.state == -3) {
            if(var4[var5] != 13) {
               this.report(new Exception("Invalid multipart/form-data. Expected \r"));
               return;
            }

            this.state = -4;
            ByteBuffer var9 = ByteBuffer.wrap(var4, var3, -2 + (var5 - var3 - this.boundary.length));
            ByteBufferList var10 = new ByteBufferList();
            var10.add(var9);
            super.onDataAvailable(this, var10);
            this.onBoundaryEnd();
         } else if(this.state == -4) {
            if(var4[var5] == 10) {
               var3 = var5 + 1;
               this.state = 0;
            } else {
               this.report(new Exception("Invalid multipart/form-data. Expected \n"));
            }
         } else {
            if(!$assertionsDisabled) {
               throw new AssertionError();
            }

            this.report(new Exception("Invalid multipart/form-data. Unknown state?"));
         }

         ++var5;
      }

   }

   public void setBoundary(String var1) {
      this.boundary = ("\r\n--" + var1).getBytes();
   }
}
