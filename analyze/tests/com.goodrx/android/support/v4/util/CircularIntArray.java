package android.support.v4.util;

public final class CircularIntArray {
   private int mCapacityBitmask;
   private int[] mElements;
   private int mHead;
   private int mTail;

   public CircularIntArray() {
      this(8);
   }

   public CircularIntArray(int var1) {
      if(var1 <= 0) {
         throw new IllegalArgumentException("capacity must be positive");
      } else {
         int var2 = var1;
         if(Integer.bitCount(var1) != 1) {
            var2 = 1 << 1 + Integer.highestOneBit(var1);
         }

         this.mCapacityBitmask = var2 - 1;
         this.mElements = new int[var2];
      }
   }

   private void doubleCapacity() {
      int var1 = this.mElements.length;
      int var2 = var1 - this.mHead;
      int var3 = var1 << 1;
      if(var3 < 0) {
         throw new RuntimeException("Max array capacity exceeded");
      } else {
         int[] var4 = new int[var3];
         System.arraycopy(this.mElements, this.mHead, var4, 0, var2);
         System.arraycopy(this.mElements, 0, var4, var2, this.mHead);
         this.mElements = var4;
         this.mHead = 0;
         this.mTail = var1;
         this.mCapacityBitmask = var3 - 1;
      }
   }

   public void addFirst(int var1) {
      this.mHead = -1 + this.mHead & this.mCapacityBitmask;
      this.mElements[this.mHead] = var1;
      if(this.mHead == this.mTail) {
         this.doubleCapacity();
      }

   }

   public void addLast(int var1) {
      this.mElements[this.mTail] = var1;
      this.mTail = 1 + this.mTail & this.mCapacityBitmask;
      if(this.mTail == this.mHead) {
         this.doubleCapacity();
      }

   }

   public void clear() {
      this.mTail = this.mHead;
   }

   public int get(int var1) {
      if(var1 >= 0 && var1 < this.size()) {
         return this.mElements[var1 + this.mHead & this.mCapacityBitmask];
      } else {
         throw new ArrayIndexOutOfBoundsException();
      }
   }

   public int getFirst() {
      if(this.mHead == this.mTail) {
         throw new ArrayIndexOutOfBoundsException();
      } else {
         return this.mElements[this.mHead];
      }
   }

   public int getLast() {
      if(this.mHead == this.mTail) {
         throw new ArrayIndexOutOfBoundsException();
      } else {
         return this.mElements[-1 + this.mTail & this.mCapacityBitmask];
      }
   }

   public boolean isEmpty() {
      return this.mHead == this.mTail;
   }

   public int popFirst() {
      if(this.mHead == this.mTail) {
         throw new ArrayIndexOutOfBoundsException();
      } else {
         int var1 = this.mElements[this.mHead];
         this.mHead = 1 + this.mHead & this.mCapacityBitmask;
         return var1;
      }
   }

   public int popLast() {
      if(this.mHead == this.mTail) {
         throw new ArrayIndexOutOfBoundsException();
      } else {
         int var1 = -1 + this.mTail & this.mCapacityBitmask;
         int var2 = this.mElements[var1];
         this.mTail = var1;
         return var2;
      }
   }

   public void removeFromEnd(int var1) {
      if(var1 > 0) {
         if(var1 > this.size()) {
            throw new ArrayIndexOutOfBoundsException();
         } else {
            this.mTail = this.mTail - var1 & this.mCapacityBitmask;
         }
      }
   }

   public void removeFromStart(int var1) {
      if(var1 > 0) {
         if(var1 > this.size()) {
            throw new ArrayIndexOutOfBoundsException();
         } else {
            this.mHead = var1 + this.mHead & this.mCapacityBitmask;
         }
      }
   }

   public int size() {
      return this.mTail - this.mHead & this.mCapacityBitmask;
   }
}
