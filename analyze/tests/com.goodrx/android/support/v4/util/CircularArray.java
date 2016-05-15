package android.support.v4.util;

public final class CircularArray<E> {
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
         throw new RuntimeException("Max array capacity exceeded");
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

   public void addFirst(E var1) {
      this.mHead = -1 + this.mHead & this.mCapacityBitmask;
      this.mElements[this.mHead] = var1;
      if(this.mHead == this.mTail) {
         this.doubleCapacity();
      }

   }

   public void addLast(E var1) {
      this.mElements[this.mTail] = var1;
      this.mTail = 1 + this.mTail & this.mCapacityBitmask;
      if(this.mTail == this.mHead) {
         this.doubleCapacity();
      }

   }

   public void clear() {
      this.removeFromStart(this.size());
   }

   public E get(int var1) {
      if(var1 >= 0 && var1 < this.size()) {
         return this.mElements[var1 + this.mHead & this.mCapacityBitmask];
      } else {
         throw new ArrayIndexOutOfBoundsException();
      }
   }

   public E getFirst() {
      if(this.mHead == this.mTail) {
         throw new ArrayIndexOutOfBoundsException();
      } else {
         return this.mElements[this.mHead];
      }
   }

   public E getLast() {
      if(this.mHead == this.mTail) {
         throw new ArrayIndexOutOfBoundsException();
      } else {
         return this.mElements[-1 + this.mTail & this.mCapacityBitmask];
      }
   }

   public boolean isEmpty() {
      return this.mHead == this.mTail;
   }

   public E popFirst() {
      if(this.mHead == this.mTail) {
         throw new ArrayIndexOutOfBoundsException();
      } else {
         Object var1 = this.mElements[this.mHead];
         this.mElements[this.mHead] = null;
         this.mHead = 1 + this.mHead & this.mCapacityBitmask;
         return var1;
      }
   }

   public E popLast() {
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

   public void removeFromEnd(int var1) {
      if(var1 > 0) {
         if(var1 > this.size()) {
            throw new ArrayIndexOutOfBoundsException();
         }

         int var2 = this.mTail;
         int var3 = 0;
         if(var1 < var2) {
            var3 = this.mTail - var1;
         }

         for(int var4 = var3; var4 < this.mTail; ++var4) {
            this.mElements[var4] = null;
         }

         int var5 = this.mTail - var3;
         int var6 = var1 - var5;
         this.mTail -= var5;
         if(var6 > 0) {
            this.mTail = this.mElements.length;
            int var7 = this.mTail - var6;

            for(int var8 = var7; var8 < this.mTail; ++var8) {
               this.mElements[var8] = null;
            }

            this.mTail = var7;
            return;
         }
      }

   }

   public void removeFromStart(int var1) {
      if(var1 > 0) {
         if(var1 > this.size()) {
            throw new ArrayIndexOutOfBoundsException();
         }

         int var2 = this.mElements.length;
         if(var1 < var2 - this.mHead) {
            var2 = var1 + this.mHead;
         }

         for(int var3 = this.mHead; var3 < var2; ++var3) {
            this.mElements[var3] = null;
         }

         int var4 = var2 - this.mHead;
         int var5 = var1 - var4;
         this.mHead = var4 + this.mHead & this.mCapacityBitmask;
         if(var5 > 0) {
            for(int var6 = 0; var6 < var5; ++var6) {
               this.mElements[var6] = null;
            }

            this.mHead = var5;
            return;
         }
      }

   }

   public int size() {
      return this.mTail - this.mHead & this.mCapacityBitmask;
   }
}
