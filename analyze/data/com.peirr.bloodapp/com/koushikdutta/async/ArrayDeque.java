package com.koushikdutta.async;

import com.koushikdutta.async.Deque;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayDeque<E> extends AbstractCollection<E> implements Deque<E>, Cloneable, Serializable {
   // $FF: synthetic field
   static final boolean $assertionsDisabled = false;
   private static final int MIN_INITIAL_CAPACITY = 8;
   private static final long serialVersionUID = 2340985798034038923L;
   private transient Object[] elements;
   private transient int head;
   private transient int tail;

   static {
      boolean var0;
      if(!ArrayDeque.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
   }

   public ArrayDeque() {
      this.elements = new Object[16];
   }

   public ArrayDeque(int var1) {
      this.allocateElements(var1);
   }

   public ArrayDeque(Collection<? extends E> var1) {
      this.allocateElements(var1.size());
      this.addAll(var1);
   }

   private void allocateElements(int var1) {
      int var2 = 8;
      if(var1 >= var2) {
         int var3 = var1 | var1 >>> 1;
         int var4 = var3 | var3 >>> 2;
         int var5 = var4 | var4 >>> 4;
         int var6 = var5 | var5 >>> 8;
         var2 = 1 + (var6 | var6 >>> 16);
         if(var2 < 0) {
            var2 >>>= 1;
         }
      }

      this.elements = new Object[var2];
   }

   private void checkInvariants() {
      if(!$assertionsDisabled && this.elements[this.tail] != null) {
         throw new AssertionError();
      } else {
         if(!$assertionsDisabled) {
            label35: {
               if(this.head == this.tail) {
                  if(this.elements[this.head] == null) {
                     break label35;
                  }
               } else if(this.elements[this.head] != null && this.elements[-1 + this.tail & -1 + this.elements.length] != null) {
                  break label35;
               }

               throw new AssertionError();
            }
         }

         if(!$assertionsDisabled && this.elements[-1 + this.head & -1 + this.elements.length] != null) {
            throw new AssertionError();
         }
      }
   }

   private <T> T[] copyElements(T[] var1) {
      if(this.head < this.tail) {
         System.arraycopy(this.elements, this.head, var1, 0, this.size());
      } else if(this.head > this.tail) {
         int var2 = this.elements.length - this.head;
         System.arraycopy(this.elements, this.head, var1, 0, var2);
         System.arraycopy(this.elements, 0, var1, var2, this.tail);
         return var1;
      }

      return var1;
   }

   private boolean delete(int var1) {
      this.checkInvariants();
      Object[] var2 = this.elements;
      int var3 = -1 + var2.length;
      int var4 = this.head;
      int var5 = this.tail;
      int var6 = var3 & var1 - var4;
      int var7 = var3 & var5 - var1;
      if(var6 >= (var3 & var5 - var4)) {
         throw new ConcurrentModificationException();
      } else if(var6 < var7) {
         if(var4 <= var1) {
            System.arraycopy(var2, var4, var2, var4 + 1, var6);
         } else {
            System.arraycopy(var2, 0, var2, 1, var1);
            var2[0] = var2[var3];
            System.arraycopy(var2, var4, var2, var4 + 1, var3 - var4);
         }

         var2[var4] = null;
         this.head = var3 & var4 + 1;
         return false;
      } else {
         if(var1 < var5) {
            System.arraycopy(var2, var1 + 1, var2, var1, var7);
            this.tail = var5 - 1;
         } else {
            System.arraycopy(var2, var1 + 1, var2, var1, var3 - var1);
            var2[var3] = var2[0];
            System.arraycopy(var2, 1, var2, 0, var5);
            this.tail = var3 & var5 - 1;
         }

         return true;
      }
   }

   private void doubleCapacity() {
      if(!$assertionsDisabled && this.head != this.tail) {
         throw new AssertionError();
      } else {
         int var1 = this.head;
         int var2 = this.elements.length;
         int var3 = var2 - var1;
         int var4 = var2 << 1;
         if(var4 < 0) {
            throw new IllegalStateException("Sorry, deque too big");
         } else {
            Object[] var5 = new Object[var4];
            System.arraycopy(this.elements, var1, var5, 0, var3);
            System.arraycopy(this.elements, 0, var5, var3, var1);
            this.elements = var5;
            this.head = 0;
            this.tail = var2;
         }
      }
   }

   private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException {
      var1.defaultReadObject();
      int var2 = var1.readInt();
      this.allocateElements(var2);
      this.head = 0;
      this.tail = var2;

      for(int var3 = 0; var3 < var2; ++var3) {
         this.elements[var3] = var1.readObject();
      }

   }

   private void writeObject(ObjectOutputStream var1) throws IOException {
      var1.defaultWriteObject();
      var1.writeInt(this.size());
      int var2 = -1 + this.elements.length;

      for(int var3 = this.head; var3 != this.tail; var3 = var2 & var3 + 1) {
         var1.writeObject(this.elements[var3]);
      }

   }

   public boolean add(E var1) {
      this.addLast(var1);
      return true;
   }

   public void addFirst(E var1) {
      if(var1 == null) {
         throw new NullPointerException("e == null");
      } else {
         Object[] var2 = this.elements;
         int var3 = -1 + this.head & -1 + this.elements.length;
         this.head = var3;
         var2[var3] = var1;
         if(this.head == this.tail) {
            this.doubleCapacity();
         }

      }
   }

   public void addLast(E var1) {
      if(var1 == null) {
         throw new NullPointerException("e == null");
      } else {
         this.elements[this.tail] = var1;
         int var2 = 1 + this.tail & -1 + this.elements.length;
         this.tail = var2;
         if(var2 == this.head) {
            this.doubleCapacity();
         }

      }
   }

   public void clear() {
      int var1 = this.head;
      int var2 = this.tail;
      if(var1 != var2) {
         this.tail = 0;
         this.head = 0;
         int var3 = var1;
         int var4 = -1 + this.elements.length;

         do {
            this.elements[var3] = null;
            var3 = var4 & var3 + 1;
         } while(var3 != var2);
      }

   }

   public ArrayDeque<E> clone() {
      try {
         ArrayDeque var2 = (ArrayDeque)super.clone();
         System.arraycopy(this.elements, 0, var2.elements, 0, this.elements.length);
         return var2;
      } catch (CloneNotSupportedException var3) {
         throw new AssertionError();
      }
   }

   public boolean contains(Object var1) {
      if(var1 != null) {
         int var2 = -1 + this.elements.length;
         int var3 = this.head;

         while(true) {
            Object var4 = this.elements[var3];
            if(var4 == null) {
               break;
            }

            if(var1.equals(var4)) {
               return true;
            }

            var3 = var2 & var3 + 1;
         }
      }

      return false;
   }

   public Iterator<E> descendingIterator() {
      return new ArrayDeque.DescendingIterator();
   }

   public E element() {
      return this.getFirst();
   }

   public E getFirst() {
      Object var1 = this.elements[this.head];
      if(var1 == null) {
         throw new NoSuchElementException();
      } else {
         return var1;
      }
   }

   public E getLast() {
      Object var1 = this.elements[-1 + this.tail & -1 + this.elements.length];
      if(var1 == null) {
         throw new NoSuchElementException();
      } else {
         return var1;
      }
   }

   public boolean isEmpty() {
      return this.head == this.tail;
   }

   public Iterator<E> iterator() {
      return new ArrayDeque.DeqIterator();
   }

   public boolean offer(E var1) {
      return this.offerLast(var1);
   }

   public boolean offerFirst(E var1) {
      this.addFirst(var1);
      return true;
   }

   public boolean offerLast(E var1) {
      this.addLast(var1);
      return true;
   }

   public E peek() {
      return this.peekFirst();
   }

   public E peekFirst() {
      return this.elements[this.head];
   }

   public E peekLast() {
      return this.elements[-1 + this.tail & -1 + this.elements.length];
   }

   public E poll() {
      return this.pollFirst();
   }

   public E pollFirst() {
      int var1 = this.head;
      Object var2 = this.elements[var1];
      if(var2 == null) {
         return null;
      } else {
         this.elements[var1] = null;
         this.head = var1 + 1 & -1 + this.elements.length;
         return var2;
      }
   }

   public E pollLast() {
      int var1 = -1 + this.tail & -1 + this.elements.length;
      Object var2 = this.elements[var1];
      if(var2 == null) {
         return null;
      } else {
         this.elements[var1] = null;
         this.tail = var1;
         return var2;
      }
   }

   public E pop() {
      return this.removeFirst();
   }

   public void push(E var1) {
      this.addFirst(var1);
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

   public boolean removeFirstOccurrence(Object var1) {
      if(var1 != null) {
         int var2 = -1 + this.elements.length;
         int var3 = this.head;

         while(true) {
            Object var4 = this.elements[var3];
            if(var4 == null) {
               break;
            }

            if(var1.equals(var4)) {
               this.delete(var3);
               return true;
            }

            var3 = var2 & var3 + 1;
         }
      }

      return false;
   }

   public E removeLast() {
      Object var1 = this.pollLast();
      if(var1 == null) {
         throw new NoSuchElementException();
      } else {
         return var1;
      }
   }

   public boolean removeLastOccurrence(Object var1) {
      if(var1 != null) {
         int var2 = -1 + this.elements.length;
         int var3 = var2 & -1 + this.tail;

         while(true) {
            Object var4 = this.elements[var3];
            if(var4 == null) {
               break;
            }

            if(var1.equals(var4)) {
               this.delete(var3);
               return true;
            }

            var3 = var2 & var3 - 1;
         }
      }

      return false;
   }

   public int size() {
      return this.tail - this.head & -1 + this.elements.length;
   }

   public Object[] toArray() {
      return this.copyElements(new Object[this.size()]);
   }

   public <T> T[] toArray(T[] var1) {
      int var2 = this.size();
      if(var1.length < var2) {
         var1 = (Object[])((Object[])Array.newInstance(var1.getClass().getComponentType(), var2));
      }

      this.copyElements(var1);
      if(var1.length > var2) {
         var1[var2] = null;
      }

      return var1;
   }

   private class DeqIterator implements Iterator<E> {
      private int cursor;
      private int fence;
      private int lastRet;

      private DeqIterator() {
         this.cursor = ArrayDeque.this.head;
         this.fence = ArrayDeque.this.tail;
         this.lastRet = -1;
      }

      // $FF: synthetic method
      DeqIterator(Object var2) {
         this();
      }

      public boolean hasNext() {
         return this.cursor != this.fence;
      }

      public E next() {
         if(this.cursor == this.fence) {
            throw new NoSuchElementException();
         } else {
            Object var1 = ArrayDeque.this.elements[this.cursor];
            if(ArrayDeque.this.tail == this.fence && var1 != null) {
               this.lastRet = this.cursor;
               this.cursor = 1 + this.cursor & -1 + ArrayDeque.this.elements.length;
               return var1;
            } else {
               throw new ConcurrentModificationException();
            }
         }
      }

      public void remove() {
         if(this.lastRet < 0) {
            throw new IllegalStateException();
         } else {
            if(ArrayDeque.this.delete(this.lastRet)) {
               this.cursor = -1 + this.cursor & -1 + ArrayDeque.this.elements.length;
               this.fence = ArrayDeque.this.tail;
            }

            this.lastRet = -1;
         }
      }
   }

   private class DescendingIterator implements Iterator<E> {
      private int cursor;
      private int fence;
      private int lastRet;

      private DescendingIterator() {
         this.cursor = ArrayDeque.this.tail;
         this.fence = ArrayDeque.this.head;
         this.lastRet = -1;
      }

      // $FF: synthetic method
      DescendingIterator(Object var2) {
         this();
      }

      public boolean hasNext() {
         return this.cursor != this.fence;
      }

      public E next() {
         if(this.cursor == this.fence) {
            throw new NoSuchElementException();
         } else {
            this.cursor = -1 + this.cursor & -1 + ArrayDeque.this.elements.length;
            Object var1 = ArrayDeque.this.elements[this.cursor];
            if(ArrayDeque.this.head == this.fence && var1 != null) {
               this.lastRet = this.cursor;
               return var1;
            } else {
               throw new ConcurrentModificationException();
            }
         }
      }

      public void remove() {
         if(this.lastRet < 0) {
            throw new IllegalStateException();
         } else {
            if(!ArrayDeque.this.delete(this.lastRet)) {
               this.cursor = 1 + this.cursor & -1 + ArrayDeque.this.elements.length;
               this.fence = ArrayDeque.this.head;
            }

            this.lastRet = -1;
         }
      }
   }
}
