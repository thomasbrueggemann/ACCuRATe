package android.support.v4.util;

import android.support.v4.util.ContainerHelpers;

public class SparseArrayCompat<E> implements Cloneable {
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
      if(var1 == 0) {
         this.mKeys = ContainerHelpers.EMPTY_INTS;
         this.mValues = ContainerHelpers.EMPTY_OBJECTS;
      } else {
         int var2 = ContainerHelpers.idealIntArraySize(var1);
         this.mKeys = new int[var2];
         this.mValues = new Object[var2];
      }

      this.mSize = 0;
   }

   // $FF: renamed from: gc () void
   private void method_313() {
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
               var4[var5] = null;
            }

            ++var2;
         }
      }

      this.mGarbage = false;
      this.mSize = var2;
   }

   public void append(int var1, E var2) {
      if(this.mSize != 0 && var1 <= this.mKeys[-1 + this.mSize]) {
         this.put(var1, var2);
      } else {
         if(this.mGarbage && this.mSize >= this.mKeys.length) {
            this.method_313();
         }

         int var3 = this.mSize;
         if(var3 >= this.mKeys.length) {
            int var4 = ContainerHelpers.idealIntArraySize(var3 + 1);
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

   public SparseArrayCompat<E> clone() {
      SparseArrayCompat var1 = null;

      try {
         var1 = (SparseArrayCompat)super.clone();
         var1.mKeys = (int[])this.mKeys.clone();
         var1.mValues = (Object[])this.mValues.clone();
         return var1;
      } catch (CloneNotSupportedException var3) {
         return var1;
      }
   }

   public void delete(int var1) {
      int var2 = ContainerHelpers.binarySearch(this.mKeys, this.mSize, var1);
      if(var2 >= 0 && this.mValues[var2] != DELETED) {
         this.mValues[var2] = DELETED;
         this.mGarbage = true;
      }

   }

   public E get(int var1) {
      return this.get(var1, (Object)null);
   }

   public E get(int var1, E var2) {
      int var3 = ContainerHelpers.binarySearch(this.mKeys, this.mSize, var1);
      return var3 >= 0 && this.mValues[var3] != DELETED?this.mValues[var3]:var2;
   }

   public int indexOfKey(int var1) {
      if(this.mGarbage) {
         this.method_313();
      }

      return ContainerHelpers.binarySearch(this.mKeys, this.mSize, var1);
   }

   public int indexOfValue(E var1) {
      if(this.mGarbage) {
         this.method_313();
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
         this.method_313();
      }

      return this.mKeys[var1];
   }

   public void put(int var1, E var2) {
      int var3 = ContainerHelpers.binarySearch(this.mKeys, this.mSize, var1);
      if(var3 >= 0) {
         this.mValues[var3] = var2;
      } else {
         int var4 = ~var3;
         if(var4 < this.mSize && this.mValues[var4] == DELETED) {
            this.mKeys[var4] = var1;
            this.mValues[var4] = var2;
         } else {
            if(this.mGarbage && this.mSize >= this.mKeys.length) {
               this.method_313();
               var4 = ~ContainerHelpers.binarySearch(this.mKeys, this.mSize, var1);
            }

            if(this.mSize >= this.mKeys.length) {
               int var5 = ContainerHelpers.idealIntArraySize(1 + this.mSize);
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
         this.method_313();
      }

      this.mValues[var1] = var2;
   }

   public int size() {
      if(this.mGarbage) {
         this.method_313();
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
         this.method_313();
      }

      return this.mValues[var1];
   }
}
