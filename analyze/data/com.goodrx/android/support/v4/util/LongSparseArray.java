package android.support.v4.util;

import android.support.v4.util.ContainerHelpers;

public class LongSparseArray<E> implements Cloneable {
   private static final Object DELETED = new Object();
   private boolean mGarbage;
   private long[] mKeys;
   private int mSize;
   private Object[] mValues;

   public LongSparseArray() {
      this(10);
   }

   public LongSparseArray(int var1) {
      this.mGarbage = false;
      if(var1 == 0) {
         this.mKeys = ContainerHelpers.EMPTY_LONGS;
         this.mValues = ContainerHelpers.EMPTY_OBJECTS;
      } else {
         int var2 = ContainerHelpers.idealLongArraySize(var1);
         this.mKeys = new long[var2];
         this.mValues = new Object[var2];
      }

      this.mSize = 0;
   }

   // $FF: renamed from: gc () void
   private void method_334() {
      int var1 = this.mSize;
      int var2 = 0;
      long[] var3 = this.mKeys;
      Object[] var4 = this.mValues;

      for(int var5 = 0; var5 < var1; ++var5) {
         Object var6 = var4[var5];
         if(var6 != DELETED) {
            if(var5 != var2) {
               var3[var2] = var3[var5];
               var4[var2] = var6;
               var4[var5] = null;
            }

            ++var2;
         }
      }

      this.mGarbage = false;
      this.mSize = var2;
   }

   public void append(long var1, E var3) {
      if(this.mSize != 0 && var1 <= this.mKeys[-1 + this.mSize]) {
         this.put(var1, var3);
      } else {
         if(this.mGarbage && this.mSize >= this.mKeys.length) {
            this.method_334();
         }

         int var4 = this.mSize;
         if(var4 >= this.mKeys.length) {
            int var5 = ContainerHelpers.idealLongArraySize(var4 + 1);
            long[] var6 = new long[var5];
            Object[] var7 = new Object[var5];
            System.arraycopy(this.mKeys, 0, var6, 0, this.mKeys.length);
            System.arraycopy(this.mValues, 0, var7, 0, this.mValues.length);
            this.mKeys = var6;
            this.mValues = var7;
         }

         this.mKeys[var4] = var1;
         this.mValues[var4] = var3;
         this.mSize = var4 + 1;
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

   public LongSparseArray<E> clone() {
      LongSparseArray var1 = null;

      try {
         var1 = (LongSparseArray)super.clone();
         var1.mKeys = (long[])this.mKeys.clone();
         var1.mValues = (Object[])this.mValues.clone();
         return var1;
      } catch (CloneNotSupportedException var3) {
         return var1;
      }
   }

   public void delete(long var1) {
      int var3 = ContainerHelpers.binarySearch(this.mKeys, this.mSize, var1);
      if(var3 >= 0 && this.mValues[var3] != DELETED) {
         this.mValues[var3] = DELETED;
         this.mGarbage = true;
      }

   }

   public E get(long var1) {
      return this.get(var1, (Object)null);
   }

   public E get(long var1, E var3) {
      int var4 = ContainerHelpers.binarySearch(this.mKeys, this.mSize, var1);
      return var4 >= 0 && this.mValues[var4] != DELETED?this.mValues[var4]:var3;
   }

   public int indexOfKey(long var1) {
      if(this.mGarbage) {
         this.method_334();
      }

      return ContainerHelpers.binarySearch(this.mKeys, this.mSize, var1);
   }

   public int indexOfValue(E var1) {
      if(this.mGarbage) {
         this.method_334();
      }

      for(int var2 = 0; var2 < this.mSize; ++var2) {
         if(this.mValues[var2] == var1) {
            return var2;
         }
      }

      return -1;
   }

   public long keyAt(int var1) {
      if(this.mGarbage) {
         this.method_334();
      }

      return this.mKeys[var1];
   }

   public void put(long var1, E var3) {
      int var4 = ContainerHelpers.binarySearch(this.mKeys, this.mSize, var1);
      if(var4 >= 0) {
         this.mValues[var4] = var3;
      } else {
         int var5 = ~var4;
         if(var5 < this.mSize && this.mValues[var5] == DELETED) {
            this.mKeys[var5] = var1;
            this.mValues[var5] = var3;
         } else {
            if(this.mGarbage && this.mSize >= this.mKeys.length) {
               this.method_334();
               var5 = ~ContainerHelpers.binarySearch(this.mKeys, this.mSize, var1);
            }

            if(this.mSize >= this.mKeys.length) {
               int var6 = ContainerHelpers.idealLongArraySize(1 + this.mSize);
               long[] var7 = new long[var6];
               Object[] var8 = new Object[var6];
               System.arraycopy(this.mKeys, 0, var7, 0, this.mKeys.length);
               System.arraycopy(this.mValues, 0, var8, 0, this.mValues.length);
               this.mKeys = var7;
               this.mValues = var8;
            }

            if(this.mSize - var5 != 0) {
               System.arraycopy(this.mKeys, var5, this.mKeys, var5 + 1, this.mSize - var5);
               System.arraycopy(this.mValues, var5, this.mValues, var5 + 1, this.mSize - var5);
            }

            this.mKeys[var5] = var1;
            this.mValues[var5] = var3;
            ++this.mSize;
         }
      }
   }

   public void remove(long var1) {
      this.delete(var1);
   }

   public void removeAt(int var1) {
      if(this.mValues[var1] != DELETED) {
         this.mValues[var1] = DELETED;
         this.mGarbage = true;
      }

   }

   public void setValueAt(int var1, E var2) {
      if(this.mGarbage) {
         this.method_334();
      }

      this.mValues[var1] = var2;
   }

   public int size() {
      if(this.mGarbage) {
         this.method_334();
      }

      return this.mSize;
   }

   public String toString() {
      if(this.size() <= 0) {
         return "{}";
      } else {
         StringBuilder var1 = new StringBuilder(28 * this.mSize);
         var1.append('{');

         for(int var3 = 0; var3 < this.mSize; ++var3) {
            if(var3 > 0) {
               var1.append(", ");
            }

            var1.append(this.keyAt(var3));
            var1.append('=');
            Object var7 = this.valueAt(var3);
            if(var7 != this) {
               var1.append(var7);
            } else {
               var1.append("(this Map)");
            }
         }

         var1.append('}');
         return var1.toString();
      }
   }

   public E valueAt(int var1) {
      if(this.mGarbage) {
         this.method_334();
      }

      return this.mValues[var1];
   }
}
