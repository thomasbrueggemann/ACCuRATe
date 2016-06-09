package android.support.v4.util;

import android.support.v4.util.ContainerHelpers;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

abstract class MapCollections<K, V> {
   MapCollections<K, V>.EntrySet mEntrySet;
   MapCollections<K, V>.KeySet mKeySet;
   MapCollections<K, V>.ValuesCollection mValues;

   public static <K, V> boolean containsAllHelper(Map<K, V> var0, Collection<?> var1) {
      Iterator var2 = var1.iterator();

      do {
         if(!var2.hasNext()) {
            return true;
         }
      } while(var0.containsKey(var2.next()));

      return false;
   }

   public static <T> boolean equalsSetHelper(Set<T> var0, Object var1) {
      boolean var2 = true;
      boolean var4;
      if(var0 == var1) {
         var4 = var2;
      } else {
         boolean var3 = var1 instanceof Set;
         var4 = false;
         if(var3) {
            Set var5 = (Set)var1;

            label25: {
               boolean var8;
               try {
                  if(var0.size() != var5.size()) {
                     break label25;
                  }

                  var8 = var0.containsAll(var5);
               } catch (NullPointerException var9) {
                  return false;
               } catch (ClassCastException var10) {
                  return false;
               }

               if(var8) {
                  return var2;
               }
            }

            var2 = false;
            return var2;
         }
      }

      return var4;
   }

   public static <K, V> boolean removeAllHelper(Map<K, V> var0, Collection<?> var1) {
      int var2 = var0.size();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         var0.remove(var3.next());
      }

      return var2 != var0.size();
   }

   public static <K, V> boolean retainAllHelper(Map<K, V> var0, Collection<?> var1) {
      int var2 = var0.size();
      Iterator var3 = var0.keySet().iterator();

      while(var3.hasNext()) {
         if(!var1.contains(var3.next())) {
            var3.remove();
         }
      }

      if(var2 != var0.size()) {
         return true;
      } else {
         return false;
      }
   }

   protected abstract void colClear();

   protected abstract Object colGetEntry(int var1, int var2);

   protected abstract Map<K, V> colGetMap();

   protected abstract int colGetSize();

   protected abstract int colIndexOfKey(Object var1);

   protected abstract int colIndexOfValue(Object var1);

   protected abstract void colPut(K var1, V var2);

   protected abstract void colRemoveAt(int var1);

   protected abstract V colSetValue(int var1, V var2);

   public Set<Entry<K, V>> getEntrySet() {
      if(this.mEntrySet == null) {
         this.mEntrySet = new MapCollections.EntrySet();
      }

      return this.mEntrySet;
   }

   public Set<K> getKeySet() {
      if(this.mKeySet == null) {
         this.mKeySet = new MapCollections.KeySet();
      }

      return this.mKeySet;
   }

   public Collection<V> getValues() {
      if(this.mValues == null) {
         this.mValues = new MapCollections.ValuesCollection();
      }

      return this.mValues;
   }

   public Object[] toArrayHelper(int var1) {
      int var2 = this.colGetSize();
      Object[] var3 = new Object[var2];

      for(int var4 = 0; var4 < var2; ++var4) {
         var3[var4] = this.colGetEntry(var4, var1);
      }

      return var3;
   }

   public <T> T[] toArrayHelper(T[] var1, int var2) {
      int var3 = this.colGetSize();
      if(var1.length < var3) {
         var1 = (Object[])((Object[])Array.newInstance(var1.getClass().getComponentType(), var3));
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         var1[var4] = this.colGetEntry(var4, var2);
      }

      if(var1.length > var3) {
         var1[var3] = null;
      }

      return var1;
   }

   final class ArrayIterator<T> implements Iterator<T> {
      boolean mCanRemove = false;
      int mIndex;
      final int mOffset;
      int mSize;

      ArrayIterator(int var2) {
         this.mOffset = var2;
         this.mSize = MapCollections.this.colGetSize();
      }

      public boolean hasNext() {
         return this.mIndex < this.mSize;
      }

      public T next() {
         Object var1 = MapCollections.this.colGetEntry(this.mIndex, this.mOffset);
         ++this.mIndex;
         this.mCanRemove = true;
         return var1;
      }

      public void remove() {
         if(!this.mCanRemove) {
            throw new IllegalStateException();
         } else {
            this.mIndex += -1;
            this.mSize += -1;
            this.mCanRemove = false;
            MapCollections.this.colRemoveAt(this.mIndex);
         }
      }
   }

   final class EntrySet implements Set<Entry<K, V>> {
      public boolean add(Entry<K, V> var1) {
         throw new UnsupportedOperationException();
      }

      public boolean addAll(Collection<? extends Entry<K, V>> var1) {
         int var2 = MapCollections.this.colGetSize();
         Iterator var3 = var1.iterator();

         while(var3.hasNext()) {
            Entry var4 = (Entry)var3.next();
            MapCollections.this.colPut(var4.getKey(), var4.getValue());
         }

         return var2 != MapCollections.this.colGetSize();
      }

      public void clear() {
         MapCollections.this.colClear();
      }

      public boolean contains(Object var1) {
         if(var1 instanceof Entry) {
            Entry var2 = (Entry)var1;
            int var3 = MapCollections.this.colIndexOfKey(var2.getKey());
            if(var3 >= 0) {
               return ContainerHelpers.equal(MapCollections.this.colGetEntry(var3, 1), var2.getValue());
            }
         }

         return false;
      }

      public boolean containsAll(Collection<?> var1) {
         Iterator var2 = var1.iterator();

         do {
            if(!var2.hasNext()) {
               return true;
            }
         } while(this.contains(var2.next()));

         return false;
      }

      public boolean equals(Object var1) {
         return MapCollections.equalsSetHelper(this, var1);
      }

      public int hashCode() {
         int var1 = 0;

         for(int var2 = -1 + MapCollections.this.colGetSize(); var2 >= 0; --var2) {
            Object var3 = MapCollections.this.colGetEntry(var2, 0);
            Object var4 = MapCollections.this.colGetEntry(var2, 1);
            int var5;
            if(var3 == null) {
               var5 = 0;
            } else {
               var5 = var3.hashCode();
            }

            int var6;
            if(var4 == null) {
               var6 = 0;
            } else {
               var6 = var4.hashCode();
            }

            var1 += var6 ^ var5;
         }

         return var1;
      }

      public boolean isEmpty() {
         return MapCollections.this.colGetSize() == 0;
      }

      public Iterator<Entry<K, V>> iterator() {
         return MapCollections.this.new MapIterator();
      }

      public boolean remove(Object var1) {
         throw new UnsupportedOperationException();
      }

      public boolean removeAll(Collection<?> var1) {
         throw new UnsupportedOperationException();
      }

      public boolean retainAll(Collection<?> var1) {
         throw new UnsupportedOperationException();
      }

      public int size() {
         return MapCollections.this.colGetSize();
      }

      public Object[] toArray() {
         throw new UnsupportedOperationException();
      }

      public <T> T[] toArray(T[] var1) {
         throw new UnsupportedOperationException();
      }
   }

   final class KeySet implements Set<K> {
      public boolean add(K var1) {
         throw new UnsupportedOperationException();
      }

      public boolean addAll(Collection<? extends K> var1) {
         throw new UnsupportedOperationException();
      }

      public void clear() {
         MapCollections.this.colClear();
      }

      public boolean contains(Object var1) {
         return MapCollections.this.colIndexOfKey(var1) >= 0;
      }

      public boolean containsAll(Collection<?> var1) {
         return MapCollections.containsAllHelper(MapCollections.this.colGetMap(), var1);
      }

      public boolean equals(Object var1) {
         return MapCollections.equalsSetHelper(this, var1);
      }

      public int hashCode() {
         int var1 = 0;

         for(int var2 = -1 + MapCollections.this.colGetSize(); var2 >= 0; --var2) {
            Object var3 = MapCollections.this.colGetEntry(var2, 0);
            int var4;
            if(var3 == null) {
               var4 = 0;
            } else {
               var4 = var3.hashCode();
            }

            var1 += var4;
         }

         return var1;
      }

      public boolean isEmpty() {
         return MapCollections.this.colGetSize() == 0;
      }

      public Iterator<K> iterator() {
         return MapCollections.this.new ArrayIterator(0);
      }

      public boolean remove(Object var1) {
         int var2 = MapCollections.this.colIndexOfKey(var1);
         if(var2 >= 0) {
            MapCollections.this.colRemoveAt(var2);
            return true;
         } else {
            return false;
         }
      }

      public boolean removeAll(Collection<?> var1) {
         return MapCollections.removeAllHelper(MapCollections.this.colGetMap(), var1);
      }

      public boolean retainAll(Collection<?> var1) {
         return MapCollections.retainAllHelper(MapCollections.this.colGetMap(), var1);
      }

      public int size() {
         return MapCollections.this.colGetSize();
      }

      public Object[] toArray() {
         return MapCollections.this.toArrayHelper(0);
      }

      public <T> T[] toArray(T[] var1) {
         return MapCollections.this.toArrayHelper(var1, 0);
      }
   }

   final class MapIterator implements Iterator<Entry<K, V>>, Entry<K, V> {
      int mEnd = -1 + MapCollections.this.colGetSize();
      boolean mEntryValid = false;
      int mIndex = -1;

      public final boolean equals(Object var1) {
         byte var2 = 1;
         if(!this.mEntryValid) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
         } else if(!(var1 instanceof Entry)) {
            return false;
         } else {
            Entry var3 = (Entry)var1;
            if(!ContainerHelpers.equal(var3.getKey(), MapCollections.this.colGetEntry(this.mIndex, 0)) || !ContainerHelpers.equal(var3.getValue(), MapCollections.this.colGetEntry(this.mIndex, var2))) {
               var2 = 0;
            }

            return (boolean)var2;
         }
      }

      public K getKey() {
         if(!this.mEntryValid) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
         } else {
            return MapCollections.this.colGetEntry(this.mIndex, 0);
         }
      }

      public V getValue() {
         if(!this.mEntryValid) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
         } else {
            return MapCollections.this.colGetEntry(this.mIndex, 1);
         }
      }

      public boolean hasNext() {
         return this.mIndex < this.mEnd;
      }

      public final int hashCode() {
         if(!this.mEntryValid) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
         } else {
            Object var1 = MapCollections.this.colGetEntry(this.mIndex, 0);
            Object var2 = MapCollections.this.colGetEntry(this.mIndex, 1);
            int var3;
            if(var1 == null) {
               var3 = 0;
            } else {
               var3 = var1.hashCode();
            }

            int var4 = 0;
            if(var2 != null) {
               var4 = var2.hashCode();
            }

            return var4 ^ var3;
         }
      }

      public Entry<K, V> next() {
         ++this.mIndex;
         this.mEntryValid = true;
         return this;
      }

      public void remove() {
         if(!this.mEntryValid) {
            throw new IllegalStateException();
         } else {
            MapCollections.this.colRemoveAt(this.mIndex);
            this.mIndex += -1;
            this.mEnd += -1;
            this.mEntryValid = false;
         }
      }

      public V setValue(V var1) {
         if(!this.mEntryValid) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
         } else {
            return MapCollections.this.colSetValue(this.mIndex, var1);
         }
      }

      public final String toString() {
         return this.getKey() + "=" + this.getValue();
      }
   }

   final class ValuesCollection implements Collection<V> {
      public boolean add(V var1) {
         throw new UnsupportedOperationException();
      }

      public boolean addAll(Collection<? extends V> var1) {
         throw new UnsupportedOperationException();
      }

      public void clear() {
         MapCollections.this.colClear();
      }

      public boolean contains(Object var1) {
         return MapCollections.this.colIndexOfValue(var1) >= 0;
      }

      public boolean containsAll(Collection<?> var1) {
         Iterator var2 = var1.iterator();

         do {
            if(!var2.hasNext()) {
               return true;
            }
         } while(this.contains(var2.next()));

         return false;
      }

      public boolean isEmpty() {
         return MapCollections.this.colGetSize() == 0;
      }

      public Iterator<V> iterator() {
         return MapCollections.this.new ArrayIterator(1);
      }

      public boolean remove(Object var1) {
         int var2 = MapCollections.this.colIndexOfValue(var1);
         if(var2 >= 0) {
            MapCollections.this.colRemoveAt(var2);
            return true;
         } else {
            return false;
         }
      }

      public boolean removeAll(Collection<?> var1) {
         int var2 = MapCollections.this.colGetSize();
         boolean var3 = false;

         for(int var4 = 0; var4 < var2; ++var4) {
            if(var1.contains(MapCollections.this.colGetEntry(var4, 1))) {
               MapCollections.this.colRemoveAt(var4);
               --var4;
               --var2;
               var3 = true;
            }
         }

         return var3;
      }

      public boolean retainAll(Collection<?> var1) {
         int var2 = MapCollections.this.colGetSize();
         boolean var3 = false;

         for(int var4 = 0; var4 < var2; ++var4) {
            if(!var1.contains(MapCollections.this.colGetEntry(var4, 1))) {
               MapCollections.this.colRemoveAt(var4);
               --var4;
               --var2;
               var3 = true;
            }
         }

         return var3;
      }

      public int size() {
         return MapCollections.this.colGetSize();
      }

      public Object[] toArray() {
         return MapCollections.this.toArrayHelper(1);
      }

      public <T> T[] toArray(T[] var1) {
         return MapCollections.this.toArrayHelper(var1, 1);
      }
   }
}
