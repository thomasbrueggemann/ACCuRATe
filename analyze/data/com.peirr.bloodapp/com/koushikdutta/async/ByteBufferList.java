package com.koushikdutta.async;

import android.os.Looper;
import com.koushikdutta.async.ArrayDeque;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class ByteBufferList {
   // $FF: synthetic field
   static final boolean $assertionsDisabled = false;
   public static final ByteBuffer EMPTY_BYTEBUFFER;
   private static final int MAX_SIZE = 1048576;
   static int currentSize;
   static int maxItem;
   static PriorityQueue<ByteBuffer> reclaimed;
   ArrayDeque<ByteBuffer> mBuffers = new ArrayDeque();
   ByteOrder order;
   private int remaining;

   static {
      boolean var0;
      if(!ByteBufferList.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
      reclaimed = new PriorityQueue(8, new ByteBufferList.Reclaimer());
      currentSize = 0;
      maxItem = 0;
      EMPTY_BYTEBUFFER = ByteBuffer.allocate(0);
   }

   public ByteBufferList() {
      this.order = ByteOrder.BIG_ENDIAN;
      this.remaining = 0;
   }

   public ByteBufferList(byte[] var1) {
      this.order = ByteOrder.BIG_ENDIAN;
      this.remaining = 0;
      this.add(ByteBuffer.wrap(var1));
   }

   public ByteBufferList(ByteBuffer... var1) {
      this.order = ByteOrder.BIG_ENDIAN;
      this.remaining = 0;
      this.addAll(var1);
   }

   private void addRemaining(int var1) {
      if(this.remaining() >= 0) {
         this.remaining += var1;
      }

   }

   private static PriorityQueue<ByteBuffer> getReclaimed() {
      return Thread.currentThread() == Looper.getMainLooper().getThread()?null:reclaimed;
   }

   public static ByteBuffer obtain(int param0) {
      // $FF: Couldn't be decompiled
   }

   public static void obtainArray(ByteBuffer[] param0, int param1) {
      // $FF: Couldn't be decompiled
   }

   private ByteBuffer read(int var1) {
      if(this.remaining() < var1) {
         throw new IllegalArgumentException("count");
      } else {
         ByteBuffer var2;
         for(var2 = (ByteBuffer)this.mBuffers.peek(); var2 != null && var2.position() == var2.limit(); var2 = (ByteBuffer)this.mBuffers.peek()) {
            reclaim((ByteBuffer)this.mBuffers.remove());
         }

         if(var2 == null) {
            return EMPTY_BYTEBUFFER;
         } else if(var2.remaining() >= var1) {
            return var2.order(this.order);
         } else {
            ByteBuffer var3 = null;
            int var4 = 0;
            int var5 = 0;

            ByteBuffer var19;
            for(Iterator var6 = this.mBuffers.iterator(); var6.hasNext(); var5 += var19.remaining()) {
               var19 = (ByteBuffer)var6.next();
               if(var5 >= var1) {
                  break;
               }

               if((var3 == null || var19.capacity() > var3.capacity()) && var19.capacity() >= var1) {
                  var3 = var19;
                  var4 = var5;
               }
            }

            if(var3 != null && var3.capacity() > var5) {
               System.arraycopy(var3.array(), var3.arrayOffset() + var3.position(), var3.array(), var4 + var3.arrayOffset(), var3.remaining());
               int var14 = var3.remaining();
               var3.position(0);
               var3.limit(var5);
               int var17 = 0;

               while(var17 < var1) {
                  ByteBuffer var18 = (ByteBuffer)this.mBuffers.remove();
                  if(var18 != var3) {
                     System.arraycopy(var18.array(), var18.arrayOffset() + var18.position(), var3.array(), var17 + var3.arrayOffset(), var18.remaining());
                     var17 += var18.remaining();
                     reclaim(var18);
                  } else {
                     var17 += var14;
                  }
               }

               this.mBuffers.addFirst(var3);
               return var3;
            } else {
               ByteBuffer var7 = obtain(var1);
               var7.limit(var1);
               byte[] var9 = var7.array();
               int var10 = 0;
               ByteBuffer var11 = null;

               while(var10 < var1) {
                  var11 = (ByteBuffer)this.mBuffers.remove();
                  int var12 = Math.min(var1 - var10, var11.remaining());
                  var11.get(var9, var10, var12);
                  var10 += var12;
                  if(var11.remaining() == 0) {
                     reclaim(var11);
                     var11 = null;
                  }
               }

               if(var11 != null && var11.remaining() > 0) {
                  this.mBuffers.addFirst(var11);
               }

               this.mBuffers.addFirst(var7);
               return var7.order(this.order);
            }
         }
      }
   }

   public static void reclaim(ByteBuffer param0) {
      // $FF: Couldn't be decompiled
   }

   public void add(ByteBuffer var1) {
      if(var1.remaining() <= 0) {
         reclaim(var1);
      } else {
         this.addRemaining(var1.remaining());
         this.mBuffers.add(var1);
         this.trim();
      }
   }

   public void addAll(ByteBuffer... var1) {
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         this.add(var1[var3]);
      }

   }

   public void addFirst(ByteBuffer var1) {
      if(var1.remaining() <= 0) {
         reclaim(var1);
      } else {
         this.addRemaining(var1.remaining());
         this.mBuffers.addFirst(var1);
      }
   }

   public byte get() {
      byte var1 = this.read(1).get();
      this.remaining += -1;
      return var1;
   }

   public ByteBufferList get(int var1) {
      ByteBufferList var2 = new ByteBufferList();
      this.get(var2, var1);
      return var2.order(this.order);
   }

   public void get(ByteBufferList var1) {
      this.get(var1, this.remaining());
   }

   public void get(ByteBufferList var1, int var2) {
      if(this.remaining() < var2) {
         throw new IllegalArgumentException("length");
      } else {
         int var3 = 0;

         while(var3 < var2) {
            ByteBuffer var4 = (ByteBuffer)this.mBuffers.remove();
            int var5 = var4.remaining();
            if(var5 == 0) {
               reclaim(var4);
            } else {
               if(var3 + var5 > var2) {
                  int var6 = var2 - var3;
                  ByteBuffer var7 = obtain(var6);
                  var7.limit(var6);
                  var4.get(var7.array(), 0, var6);
                  var1.add(var7);
                  this.mBuffers.addFirst(var4);
                  break;
               }

               var1.add(var4);
               var3 += var5;
            }
         }

         this.remaining -= var2;
      }
   }

   public void get(byte[] var1) {
      this.get(var1, 0, var1.length);
   }

   public void get(byte[] var1, int var2, int var3) {
      if(this.remaining() < var3) {
         throw new IllegalArgumentException("length");
      } else {
         int var4 = var3;

         while(var4 > 0) {
            ByteBuffer var5 = (ByteBuffer)this.mBuffers.peek();
            int var6 = Math.min(var5.remaining(), var4);
            var5.get(var1, var2, var6);
            var4 -= var6;
            var2 += var6;
            if(var5.remaining() == 0) {
               ByteBuffer var8 = (ByteBuffer)this.mBuffers.remove();
               if(!$assertionsDisabled && var5 != var8) {
                  throw new AssertionError();
               }

               reclaim(var5);
            }
         }

         this.remaining -= var3;
      }
   }

   public ByteBuffer getAll() {
      if(this.remaining() == 0) {
         return EMPTY_BYTEBUFFER;
      } else {
         this.read(this.remaining());
         return this.remove();
      }
   }

   public ByteBuffer[] getAllArray() {
      ByteBuffer[] var1 = new ByteBuffer[this.mBuffers.size()];
      ByteBuffer[] var2 = (ByteBuffer[])this.mBuffers.toArray(var1);
      this.mBuffers.clear();
      this.remaining = 0;
      return var2;
   }

   public byte[] getAllByteArray() {
      if(this.mBuffers.size() == 1 && ((ByteBuffer)this.mBuffers.peek()).capacity() == this.remaining()) {
         this.remaining = 0;
         return ((ByteBuffer)this.mBuffers.remove()).array();
      } else {
         byte[] var1 = new byte[this.remaining()];
         this.get(var1);
         return var1;
      }
   }

   public char getByteChar() {
      char var1 = (char)this.read(1).get();
      this.remaining += -1;
      return var1;
   }

   public int getInt() {
      int var1 = this.read(4).getInt();
      this.remaining += -4;
      return var1;
   }

   public long getLong() {
      long var1 = this.read(8).getLong();
      this.remaining += -8;
      return var1;
   }

   public int getShort() {
      short var1 = this.read(2).getShort();
      this.remaining += -2;
      return var1;
   }

   public boolean hasRemaining() {
      return this.remaining() > 0;
   }

   public boolean isEmpty() {
      return this.remaining == 0;
   }

   public ByteBufferList order(ByteOrder var1) {
      this.order = var1;
      return this;
   }

   public ByteOrder order() {
      return this.order;
   }

   public String peekString() {
      StringBuilder var1 = new StringBuilder();
      Iterator var2 = this.mBuffers.iterator();

      while(var2.hasNext()) {
         ByteBuffer var3 = (ByteBuffer)var2.next();
         var1.append(new String(var3.array(), var3.arrayOffset() + var3.position(), var3.remaining()));
      }

      return var1.toString();
   }

   public String readString() {
      StringBuilder var1 = new StringBuilder();

      while(this.mBuffers.size() > 0) {
         ByteBuffer var2 = (ByteBuffer)this.mBuffers.remove();
         var1.append(new String(var2.array(), var2.arrayOffset() + var2.position(), var2.remaining()));
         reclaim(var2);
      }

      this.remaining = 0;
      return var1.toString();
   }

   public void recycle() {
      while(this.mBuffers.size() > 0) {
         reclaim((ByteBuffer)this.mBuffers.remove());
      }

      if(!$assertionsDisabled && this.mBuffers.size() != 0) {
         throw new AssertionError();
      } else {
         this.remaining = 0;
      }
   }

   public int remaining() {
      return this.remaining;
   }

   public ByteBuffer remove() {
      ByteBuffer var1 = (ByteBuffer)this.mBuffers.remove();
      this.remaining -= var1.remaining();
      return var1;
   }

   public int size() {
      return this.mBuffers.size();
   }

   public void spewString() {
      System.out.println(this.peekString());
   }

   public void trim() {
      this.read(0);
   }

   static class Reclaimer implements Comparator<ByteBuffer> {
      public int compare(ByteBuffer var1, ByteBuffer var2) {
         return var1.capacity() == var2.capacity()?0:(var1.capacity() > var2.capacity()?1:-1);
      }
   }
}
