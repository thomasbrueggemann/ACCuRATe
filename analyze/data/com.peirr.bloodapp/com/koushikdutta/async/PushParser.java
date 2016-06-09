package com.koushikdutta.async;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataEmitterReader;
import com.koushikdutta.async.TapCallback;
import com.koushikdutta.async.callback.DataCallback;
import java.lang.reflect.Method;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

public class PushParser {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   static Hashtable<Class, Method> mTable;
   private ArrayList<Object> mArgs = new ArrayList();
   private TapCallback mCallback;
   DataEmitter mEmitter;
   int mNeeded = 0;
   DataEmitterReader mReader;
   private LinkedList<Object> mWaiting = new LinkedList();
   ByteOrder order;

   static {
      boolean var0;
      if(!PushParser.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
      mTable = new Hashtable();
   }

   public PushParser(DataEmitter var1) {
      this.order = ByteOrder.BIG_ENDIAN;
      this.mEmitter = var1;
      this.mReader = new DataEmitterReader();
      this.mEmitter.setDataCallback(this.mReader);
   }

   // $FF: synthetic method
   static LinkedList access$000(PushParser var0) {
      return var0.mWaiting;
   }

   // $FF: synthetic method
   static ArrayList access$100(PushParser var0) {
      return var0.mArgs;
   }

   // $FF: synthetic method
   static TapCallback access$200(PushParser var0) {
      return var0.mCallback;
   }

   // $FF: synthetic method
   static TapCallback access$202(PushParser var0, TapCallback var1) {
      var0.mCallback = var1;
      return var1;
   }

   static Method getTap(TapCallback var0) {
      Method var1 = (Method)mTable.get(var0.getClass());
      if(var1 != null) {
         return var1;
      } else {
         Method[] var2 = var0.getClass().getMethods();
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            Method var5 = var2[var4];
            if("tap".equals(var5.getName())) {
               mTable.put(var0.getClass(), var5);
               return var5;
            }
         }

         if(!$assertionsDisabled) {
            throw new AssertionError();
         } else {
            return null;
         }
      }
   }

   public PushParser noop() {
      this.mWaiting.add(Object.class);
      return this;
   }

   public PushParser order(ByteOrder var1) {
      this.order = var1;
      return this;
   }

   public ByteOrder order() {
      return this.order;
   }

   public PushParser readBuffer(int var1) {
      if(var1 != -1) {
         this.mNeeded += var1;
      }

      PushParser.BufferWaiter var2 = new PushParser.BufferWaiter();
      var2.length = var1;
      this.mWaiting.add(var2);
      return this;
   }

   public PushParser readByte() {
      ++this.mNeeded;
      this.mWaiting.add(Byte.TYPE);
      return this;
   }

   public PushParser readInt() {
      this.mNeeded += 4;
      this.mWaiting.add(Integer.TYPE);
      return this;
   }

   public PushParser readLenBuffer() {
      this.readInt();
      PushParser.BufferWaiter var2 = new PushParser.BufferWaiter();
      var2.length = -1;
      this.mWaiting.add(var2);
      return this;
   }

   public PushParser readLong() {
      this.mNeeded += 8;
      this.mWaiting.add(Long.TYPE);
      return this;
   }

   public PushParser readShort() {
      this.mNeeded += 2;
      this.mWaiting.add(Short.TYPE);
      return this;
   }

   public PushParser readString() {
      this.readInt();
      PushParser.StringWaiter var2 = new PushParser.StringWaiter();
      var2.length = -1;
      this.mWaiting.add(var2);
      return this;
   }

   Exception stack() {
      try {
         throw new Exception();
      } catch (Exception var2) {
         return var2;
      }
   }

   public void tap(TapCallback var1) {
      if(!$assertionsDisabled && this.mCallback != null) {
         throw new AssertionError();
      } else if(!$assertionsDisabled && this.mWaiting.size() <= 0) {
         throw new AssertionError();
      } else {
         this.mCallback = var1;
         DataCallback var10001 = new DataCallback() {
            // $FF: synthetic field
            static final boolean $assertionsDisabled;

            static {
               boolean var0;
               if(!PushParser.class.desiredAssertionStatus()) {
                  var0 = true;
               } else {
                  var0 = false;
               }

               $assertionsDisabled = var0;
            }

            {
               this.onDataAvailable(PushParser.this.mEmitter, (ByteBufferList)null);
            }

            public void onDataAvailable(DataEmitter param1, ByteBufferList param2) {
               // $FF: Couldn't be decompiled
            }
         };
      }
   }

   public PushParser until(byte var1, DataCallback var2) {
      PushParser.UntilWaiter var3 = new PushParser.UntilWaiter();
      var3.value = var1;
      var3.callback = var2;
      this.mWaiting.add(var3);
      ++this.mNeeded;
      return this;
   }

   static class BufferWaiter {
      int length;
   }

   static class StringWaiter extends PushParser.BufferWaiter {
   }

   static class UntilWaiter {
      DataCallback callback;
      byte value;
   }
}
