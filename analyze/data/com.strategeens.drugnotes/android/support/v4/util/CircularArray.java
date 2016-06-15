package android.support.v4.util;

public class CircularArray<E> {
   private int mCapacityBitmask;
   private E[] mElements;
   private int mHead;
   private int mTail;

   public CircularArray() {
      this(8);
   }

   public CircularArray(int var1) {
      if(var1 <= 0) {
         throw new IllegalArgumentException("capacity must be positive");
      } else {
         int var2 = var1;
         if(Integer.bitCount(var1) != 1) {
            var2 = 1 << 1 + Integer.highestOneBit(var1);
         }

         this.mCapacityBitmask = var2 - 1;
         this.mElements = (Object[])(new Object[var2]);
      }
   }

   private void doubleCapacity() {
      int var1 = this.mElements.length;
      int var2 = var1 - this.mHead;
      int var3 = var1 << 1;
      if(var3 < 0) {
         throw new RuntimeException("Too big");
      } else {
         Object[] var4 = new Object[var3];
         System.arraycopy(this.mElements, this.mHead, var4, 0, var2);
         System.arraycopy(this.mElements, 0, var4, var2, this.mHead);
         this.mElements = (Object[])var4;
         this.mHead = 0;
         this.mTail = var1;
         this.mCapacityBitmask = var3 - 1;
      }
   }

   public final void addFirst(E var1) {
      this.mHead = -1 + this.mHead & this.mCapacityBitmask;
      this.mElements[this.mHead] = var1;
      if(this.mHead == this.mTail) {
         this.doubleCapacity();
      }

   }

   public final void addLast(E var1) {
      this.mElements[this.mTail] = var1;
      this.mTail = 1 + this.mTail & this.mCapacityBitmask;
      if(this.mTail == this.mHead) {
         this.doubleCapacity();
      }

   }

   public final E get(int var1) {
      if(var1 >= 0 && var1 < this.size()) {
         int var2 = var1 + this.mHead & this.mCapacityBitmask;
         return this.mElements[var2];
      } else {
         throw new ArrayIndexOutOfBoundsException();
      }
   }

   public final E getFirst() {
      if(this.mHead == this.mTail) {
         throw new ArrayIndexOutOfBoundsException();
      } else {
         return this.mElements[this.mHead];
      }
   }

   public final E getLast() {
      if(this.mHead == this.mTail) {
         throw new ArrayIndexOutOfBoundsException();
      } else {
         return this.mElements[-1 + this.mTail & this.mCapacityBitmask];
      }
   }

   public final boolean isEmpty() {
      return this.mHead == this.mTail;
   }

   public final E popFirst() {
      if(this.mHead == this.mTail) {
         throw new ArrayIndexOutOfBoundsException();
      } else {
         Object var1 = this.mElements[this.mHead];
         this.mElements[this.mHead] = null;
         this.mHead = 1 + this.mHead & this.mCapacityBitmask;
         return var1;
      }
   }

   public final E popLast() {
      if(this.mHead == this.mTail) {
         throw new ArrayIndexOutOfBoundsException();
      } else {
         int var1 = -1 + this.mTail & this.mCapacityBitmask;
         Object var2 = this.mElements[var1];
         this.mElements[var1] = null;
         this.mTail = var1;
         return var2;
      }
   }

   public final int size() {
      return this.mTail - this.mHead & this.mCapacityBitmask;
   }
}
