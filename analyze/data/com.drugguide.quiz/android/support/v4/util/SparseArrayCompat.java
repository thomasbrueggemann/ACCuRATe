package android.support.v4.util;

public class SparseArrayCompat<E> {
   private static final Object DELETED = new Object();
   private boolean mGarbage;
   private int[] mKeys;
   private int mSize;
   private Object[] mValues;

   public SparseArrayCompat() {
      this(10);
   }

   public SparseArrayCompat(int var1) {
      this.mGarbage = false;
      int var2 = idealIntArraySize(var1);
      this.mKeys = new int[var2];
      this.mValues = new Object[var2];
      this.mSize = 0;
   }

   private static int binarySearch(int[] var0, int var1, int var2, int var3) {
      int var4 = var1 + var2;
      int var5 = var1 - 1;

      while(var4 - var5 > 1) {
         int var6 = (var4 + var5) / 2;
         if(var0[var6] < var3) {
            var5 = var6;
         } else {
            var4 = var6;
         }
      }

      if(var4 == var1 + var2) {
         var4 = ~(var1 + var2);
      } else if(var0[var4] != var3) {
         return ~var4;
      }

      return var4;
   }

   // $FF: renamed from: gc () void
   private void method_1() {
      int var1 = this.mSize;
      int var2 = 0;
      int[] var3 = this.mKeys;
      Object[] var4 = this.mValues;

      for(int var5 = 0; var5 < var1; ++var5) {
         Object var6 = var4[var5];
         if(var6 != DELETED) {
            if(var5 != var2) {
               var3[var2] = var3[var5];
               var4[var2] = var6;
            }

            ++var2;
         }
      }

      this.mGarbage = false;
      this.mSize = var2;
   }

   static int idealByteArraySize(int var0) {
      for(int var1 = 4; var1 < 32; ++var1) {
         if(var0 <= -12 + (1 << var1)) {
            var0 = -12 + (1 << var1);
            break;
         }
      }

      return var0;
   }

   static int idealIntArraySize(int var0) {
      return idealByteArraySize(var0 * 4) / 4;
   }

   public void append(int var1, E var2) {
      if(this.mSize != 0 && var1 <= this.mKeys[-1 + this.mSize]) {
         this.put(var1, var2);
      } else {
         if(this.mGarbage && this.mSize >= this.mKeys.length) {
            this.method_1();
         }

         int var3 = this.mSize;
         if(var3 >= this.mKeys.length) {
            int var4 = idealIntArraySize(var3 + 1);
            int[] var5 = new int[var4];
            Object[] var6 = new Object[var4];
            System.arraycopy(this.mKeys, 0, var5, 0, this.mKeys.length);
            System.arraycopy(this.mValues, 0, var6, 0, this.mValues.length);
            this.mKeys = var5;
            this.mValues = var6;
         }

         this.mKeys[var3] = var1;
         this.mValues[var3] = var2;
         this.mSize = var3 + 1;
      }
   }

   public void clear() {
      int var1 = this.mSize;
      Object[] var2 = this.mValues;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = null;
      }

      this.mSize = 0;
      this.mGarbage = false;
   }

   public void delete(int var1) {
      int var2 = binarySearch(this.mKeys, 0, this.mSize, var1);
      if(var2 >= 0 && this.mValues[var2] != DELETED) {
         this.mValues[var2] = DELETED;
         this.mGarbage = true;
      }

   }

   public E get(int var1) {
      return this.get(var1, (Object)null);
   }

   public E get(int var1, E var2) {
      int var3 = binarySearch(this.mKeys, 0, this.mSize, var1);
      return var3 >= 0 && this.mValues[var3] != DELETED?this.mValues[var3]:var2;
   }

   public int indexOfKey(int var1) {
      if(this.mGarbage) {
         this.method_1();
      }

      return binarySearch(this.mKeys, 0, this.mSize, var1);
   }

   public int indexOfValue(E var1) {
      if(this.mGarbage) {
         this.method_1();
      }

      for(int var2 = 0; var2 < this.mSize; ++var2) {
         if(this.mValues[var2] == var1) {
            return var2;
         }
      }

      return -1;
   }

   public int keyAt(int var1) {
      if(this.mGarbage) {
         this.method_1();
      }

      return this.mKeys[var1];
   }

   public void put(int var1, E var2) {
      int var3 = binarySearch(this.mKeys, 0, this.mSize, var1);
      if(var3 >= 0) {
         this.mValues[var3] = var2;
      } else {
         int var4 = ~var3;
         if(var4 < this.mSize && this.mValues[var4] == DELETED) {
            this.mKeys[var4] = var1;
            this.mValues[var4] = var2;
         } else {
            if(this.mGarbage && this.mSize >= this.mKeys.length) {
               this.method_1();
               var4 = ~binarySearch(this.mKeys, 0, this.mSize, var1);
            }

            if(this.mSize >= this.mKeys.length) {
               int var5 = idealIntArraySize(1 + this.mSize);
               int[] var6 = new int[var5];
               Object[] var7 = new Object[var5];
               System.arraycopy(this.mKeys, 0, var6, 0, this.mKeys.length);
               System.arraycopy(this.mValues, 0, var7, 0, this.mValues.length);
               this.mKeys = var6;
               this.mValues = var7;
            }

            if(this.mSize - var4 != 0) {
               System.arraycopy(this.mKeys, var4, this.mKeys, var4 + 1, this.mSize - var4);
               System.arraycopy(this.mValues, var4, this.mValues, var4 + 1, this.mSize - var4);
            }

            this.mKeys[var4] = var1;
            this.mValues[var4] = var2;
            ++this.mSize;
         }
      }
   }

   public void remove(int var1) {
      this.delete(var1);
   }

   public void removeAt(int var1) {
      if(this.mValues[var1] != DELETED) {
         this.mValues[var1] = DELETED;
         this.mGarbage = true;
      }

   }

   public void removeAtRange(int var1, int var2) {
      int var3 = Math.min(this.mSize, var1 + var2);

      for(int var4 = var1; var4 < var3; ++var4) {
         this.removeAt(var4);
      }

   }

   public void setValueAt(int var1, E var2) {
      if(this.mGarbage) {
         this.method_1();
      }

      this.mValues[var1] = var2;
   }

   public int size() {
      if(this.mGarbage) {
         this.method_1();
      }

      return this.mSize;
   }

   public E valueAt(int var1) {
      if(this.mGarbage) {
         this.method_1();
      }

      return this.mValues[var1];
   }
}
