package com.nostra13.universalimageloader.core.assist.deque;

import com.nostra13.universalimageloader.core.assist.deque.BlockingDeque;
import java.io.Serializable;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedBlockingDeque<E> extends AbstractQueue<E> implements BlockingDeque<E>, Serializable {
   private final int capacity;
   private transient int count;
   transient LinkedBlockingDeque.Node<E> first;
   transient LinkedBlockingDeque.Node<E> last;
   final ReentrantLock lock;
   private final Condition notEmpty;
   private final Condition notFull;

   public LinkedBlockingDeque() {
      this(Integer.MAX_VALUE);
   }

   public LinkedBlockingDeque(int var1) {
      this.lock = new ReentrantLock();
      this.notEmpty = this.lock.newCondition();
      this.notFull = this.lock.newCondition();
      if(var1 <= 0) {
         throw new IllegalArgumentException();
      } else {
         this.capacity = var1;
      }
   }

   private boolean linkFirst(LinkedBlockingDeque.Node<E> var1) {
      if(this.count >= this.capacity) {
         return false;
      } else {
         LinkedBlockingDeque.Node var2 = this.first;
         var1.next = var2;
         this.first = var1;
         if(this.last == null) {
            this.last = var1;
         } else {
            var2.prev = var1;
         }

         ++this.count;
         this.notEmpty.signal();
         return true;
      }
   }

   private boolean linkLast(LinkedBlockingDeque.Node<E> var1) {
      if(this.count >= this.capacity) {
         return false;
      } else {
         LinkedBlockingDeque.Node var2 = this.last;
         var1.prev = var2;
         this.last = var1;
         if(this.first == null) {
            this.first = var1;
         } else {
            var2.next = var1;
         }

         ++this.count;
         this.notEmpty.signal();
         return true;
      }
   }

   private E unlinkFirst() {
      LinkedBlockingDeque.Node var1 = this.first;
      if(var1 == null) {
         return null;
      } else {
         LinkedBlockingDeque.Node var2 = var1.next;
         Object var3 = var1.item;
         var1.item = null;
         var1.next = var1;
         this.first = var2;
         if(var2 == null) {
            this.last = null;
         } else {
            var2.prev = null;
         }

         this.count += -1;
         this.notFull.signal();
         return var3;
      }
   }

   private E unlinkLast() {
      LinkedBlockingDeque.Node var1 = this.last;
      if(var1 == null) {
         return null;
      } else {
         LinkedBlockingDeque.Node var2 = var1.prev;
         Object var3 = var1.item;
         var1.item = null;
         var1.prev = var1;
         this.last = var2;
         if(var2 == null) {
            this.first = null;
         } else {
            var2.next = null;
         }

         this.count += -1;
         this.notFull.signal();
         return var3;
      }
   }

   public boolean add(E var1) {
      this.addLast(var1);
      return true;
   }

   public void addLast(E var1) {
      if(!this.offerLast(var1)) {
         throw new IllegalStateException("Deque full");
      }
   }

   public void clear() {
      // $FF: Couldn't be decompiled
   }

   public boolean contains(Object param1) {
      // $FF: Couldn't be decompiled
   }

   public int drainTo(Collection<? super E> var1) {
      return this.drainTo(var1, Integer.MAX_VALUE);
   }

   public int drainTo(Collection<? super E> param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   public E element() {
      return this.getFirst();
   }

   public E getFirst() {
      Object var1 = this.peekFirst();
      if(var1 == null) {
         throw new NoSuchElementException();
      } else {
         return var1;
      }
   }

   public Iterator<E> iterator() {
      return new LinkedBlockingDeque.Itr();
   }

   public boolean offer(E var1) {
      return this.offerLast(var1);
   }

   public boolean offer(E var1, long var2, TimeUnit var4) throws InterruptedException {
      return this.offerLast(var1, var2, var4);
   }

   public boolean offerFirst(E var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         LinkedBlockingDeque.Node var2 = new LinkedBlockingDeque.Node(var1);
         ReentrantLock var3 = this.lock;
         var3.lock();

         boolean var5;
         try {
            var5 = this.linkFirst(var2);
         } finally {
            var3.unlock();
         }

         return var5;
      }
   }

   public boolean offerLast(E var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         LinkedBlockingDeque.Node var2 = new LinkedBlockingDeque.Node(var1);
         ReentrantLock var3 = this.lock;
         var3.lock();

         boolean var5;
         try {
            var5 = this.linkLast(var2);
         } finally {
            var3.unlock();
         }

         return var5;
      }
   }

   public boolean offerLast(E param1, long param2, TimeUnit param4) throws InterruptedException {
      // $FF: Couldn't be decompiled
   }

   public E peek() {
      return this.peekFirst();
   }

   public E peekFirst() {
      // $FF: Couldn't be decompiled
   }

   public E poll() {
      return this.pollFirst();
   }

   public E poll(long var1, TimeUnit var3) throws InterruptedException {
      return this.pollFirst(var1, var3);
   }

   public E pollFirst() {
      ReentrantLock var1 = this.lock;
      var1.lock();

      Object var3;
      try {
         var3 = this.unlinkFirst();
      } finally {
         var1.unlock();
      }

      return var3;
   }

   public E pollFirst(long param1, TimeUnit param3) throws InterruptedException {
      // $FF: Couldn't be decompiled
   }

   public void put(E var1) throws InterruptedException {
      this.putLast(var1);
   }

   public void putLast(E var1) throws InterruptedException {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         LinkedBlockingDeque.Node var2 = new LinkedBlockingDeque.Node(var1);
         ReentrantLock var3 = this.lock;
         var3.lock();

         while(true) {
            boolean var6 = false;

            try {
               var6 = true;
               if(this.linkLast(var2)) {
                  var6 = false;
                  break;
               }

               this.notFull.await();
               var6 = false;
            } finally {
               if(var6) {
                  var3.unlock();
               }
            }
         }

         var3.unlock();
      }
   }

   public int remainingCapacity() {
      ReentrantLock var1 = this.lock;
      var1.lock();
      boolean var7 = false;

      int var3;
      int var4;
      try {
         var7 = true;
         var3 = this.capacity;
         var4 = this.count;
         var7 = false;
      } finally {
         if(var7) {
            var1.unlock();
         }
      }

      int var5 = var3 - var4;
      var1.unlock();
      return var5;
   }

   public E remove() {
      return this.removeFirst();
   }

   public boolean remove(Object var1) {
      return this.removeFirstOccurrence(var1);
   }

   public E removeFirst() {
      Object var1 = this.pollFirst();
      if(var1 == null) {
         throw new NoSuchElementException();
      } else {
         return var1;
      }
   }

   public boolean removeFirstOccurrence(Object param1) {
      // $FF: Couldn't be decompiled
   }

   public int size() {
      ReentrantLock var1 = this.lock;
      var1.lock();

      int var3;
      try {
         var3 = this.count;
      } finally {
         var1.unlock();
      }

      return var3;
   }

   public E take() throws InterruptedException {
      return this.takeFirst();
   }

   public E takeFirst() throws InterruptedException {
      // $FF: Couldn't be decompiled
   }

   public Object[] toArray() {
      // $FF: Couldn't be decompiled
   }

   public <T> T[] toArray(T[] param1) {
      // $FF: Couldn't be decompiled
   }

   public String toString() {
      // $FF: Couldn't be decompiled
   }

   void unlink(LinkedBlockingDeque.Node<E> var1) {
      LinkedBlockingDeque.Node var2 = var1.prev;
      LinkedBlockingDeque.Node var3 = var1.next;
      if(var2 == null) {
         this.unlinkFirst();
      } else if(var3 == null) {
         this.unlinkLast();
      } else {
         var2.next = var3;
         var3.prev = var2;
         var1.item = null;
         this.count += -1;
         this.notFull.signal();
      }
   }

   private abstract class AbstractItr implements Iterator<E> {
      private LinkedBlockingDeque.Node<E> lastRet;
      LinkedBlockingDeque.Node<E> next;
      E nextItem;
      // $FF: synthetic field
      final LinkedBlockingDeque this$0;

      AbstractItr(LinkedBlockingDeque param1) {
         // $FF: Couldn't be decompiled
      }

      private LinkedBlockingDeque.Node<E> succ(LinkedBlockingDeque.Node<E> var1) {
         while(true) {
            LinkedBlockingDeque.Node var2 = this.nextNode(var1);
            if(var2 == null) {
               var2 = null;
            } else if(var2.item == null) {
               if(var2 == var1) {
                  return this.firstNode();
               }

               var1 = var2;
               continue;
            }

            return var2;
         }
      }

      void advance() {
         // $FF: Couldn't be decompiled
      }

      abstract LinkedBlockingDeque.Node<E> firstNode();

      public boolean hasNext() {
         return this.next != null;
      }

      public E next() {
         if(this.next == null) {
            throw new NoSuchElementException();
         } else {
            this.lastRet = this.next;
            Object var1 = this.nextItem;
            this.advance();
            return var1;
         }
      }

      abstract LinkedBlockingDeque.Node<E> nextNode(LinkedBlockingDeque.Node<E> var1);

      public void remove() {
         LinkedBlockingDeque.Node var1 = this.lastRet;
         if(var1 == null) {
            throw new IllegalStateException();
         } else {
            this.lastRet = null;
            ReentrantLock var2 = this.this$0.lock;
            var2.lock();

            try {
               if(var1.item != null) {
                  this.this$0.unlink(var1);
               }
            } finally {
               var2.unlock();
            }

         }
      }
   }

   private class Itr extends LinkedBlockingDeque<E>.com/nostra13/universalimageloader/core/assist/deque/LinkedBlockingDeque$AbstractItr {
      private Itr() {
         super(LinkedBlockingDeque.this);
      }

      // $FF: synthetic method
      Itr(Object var2) {
         this();
      }

      LinkedBlockingDeque.Node<E> firstNode() {
         return LinkedBlockingDeque.this.first;
      }

      LinkedBlockingDeque.Node<E> nextNode(LinkedBlockingDeque.Node<E> var1) {
         return var1.next;
      }
   }

   static final class Node<E> {
      E item;
      LinkedBlockingDeque.Node<E> next;
      LinkedBlockingDeque.Node<E> prev;

      Node(E var1) {
         this.item = var1;
      }
   }
}
