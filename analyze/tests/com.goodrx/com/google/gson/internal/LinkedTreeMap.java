package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Map.Entry;

public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private static final Comparator<Comparable> NATURAL_ORDER;
   Comparator<? super K> comparator;
   private LinkedTreeMap<K, V>.com/google/gson/internal/LinkedTreeMap$EntrySet entrySet;
   final LinkedTreeMap.Node<K, V> header;
   private LinkedTreeMap<K, V>.com/google/gson/internal/LinkedTreeMap$KeySet keySet;
   int modCount;
   LinkedTreeMap.Node<K, V> root;
   int size;

   static {
      boolean var0;
      if(!LinkedTreeMap.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
      NATURAL_ORDER = new Comparator() {
         public int compare(Comparable var1, Comparable var2) {
            return var1.compareTo(var2);
         }
      };
   }

   public LinkedTreeMap() {
      this(NATURAL_ORDER);
   }

   public LinkedTreeMap(Comparator<? super K> var1) {
      this.size = 0;
      this.modCount = 0;
      this.header = new LinkedTreeMap.Node();
      if(var1 == null) {
         var1 = NATURAL_ORDER;
      }

      this.comparator = var1;
   }

   private boolean equal(Object var1, Object var2) {
      return var1 == var2 || var1 != null && var1.equals(var2);
   }

   private void rebalance(LinkedTreeMap.Node<K, V> var1, boolean var2) {
      for(LinkedTreeMap.Node var3 = var1; var3 != null; var3 = var3.parent) {
         LinkedTreeMap.Node var4 = var3.left;
         LinkedTreeMap.Node var5 = var3.right;
         int var6;
         if(var4 != null) {
            var6 = var4.height;
         } else {
            var6 = 0;
         }

         int var7;
         if(var5 != null) {
            var7 = var5.height;
         } else {
            var7 = 0;
         }

         int var8 = var6 - var7;
         if(var8 == -2) {
            LinkedTreeMap.Node var14 = var5.left;
            LinkedTreeMap.Node var15 = var5.right;
            int var16;
            if(var15 != null) {
               var16 = var15.height;
            } else {
               var16 = 0;
            }

            int var17;
            if(var14 != null) {
               var17 = var14.height;
            } else {
               var17 = 0;
            }

            int var18 = var17 - var16;
            if(var18 == -1 || var18 == 0 && !var2) {
               this.rotateLeft(var3);
            } else {
               if(!$assertionsDisabled && var18 != 1) {
                  throw new AssertionError();
               }

               this.rotateRight(var5);
               this.rotateLeft(var3);
            }

            if(var2) {
               break;
            }
         } else if(var8 == 2) {
            LinkedTreeMap.Node var9 = var4.left;
            LinkedTreeMap.Node var10 = var4.right;
            int var11;
            if(var10 != null) {
               var11 = var10.height;
            } else {
               var11 = 0;
            }

            int var12;
            if(var9 != null) {
               var12 = var9.height;
            } else {
               var12 = 0;
            }

            int var13 = var12 - var11;
            if(var13 != 1 && (var13 != 0 || var2)) {
               if(!$assertionsDisabled && var13 != -1) {
                  throw new AssertionError();
               }

               this.rotateLeft(var4);
               this.rotateRight(var3);
            } else {
               this.rotateRight(var3);
            }

            if(var2) {
               break;
            }
         } else if(var8 == 0) {
            var3.height = var6 + 1;
            if(var2) {
               return;
            }
         } else {
            if(!$assertionsDisabled && var8 != -1 && var8 != 1) {
               throw new AssertionError();
            }

            var3.height = 1 + Math.max(var6, var7);
            if(!var2) {
               return;
            }
         }
      }

   }

   private void replaceInParent(LinkedTreeMap.Node<K, V> var1, LinkedTreeMap.Node<K, V> var2) {
      LinkedTreeMap.Node var3 = var1.parent;
      var1.parent = null;
      if(var2 != null) {
         var2.parent = var3;
      }

      if(var3 != null) {
         if(var3.left == var1) {
            var3.left = var2;
         } else if(!$assertionsDisabled && var3.right != var1) {
            throw new AssertionError();
         } else {
            var3.right = var2;
         }
      } else {
         this.root = var2;
      }
   }

   private void rotateLeft(LinkedTreeMap.Node<K, V> var1) {
      LinkedTreeMap.Node var2 = var1.left;
      LinkedTreeMap.Node var3 = var1.right;
      LinkedTreeMap.Node var4 = var3.left;
      LinkedTreeMap.Node var5 = var3.right;
      var1.right = var4;
      if(var4 != null) {
         var4.parent = var1;
      }

      this.replaceInParent(var1, var3);
      var3.left = var1;
      var1.parent = var3;
      int var6;
      if(var2 != null) {
         var6 = var2.height;
      } else {
         var6 = 0;
      }

      int var7;
      if(var4 != null) {
         var7 = var4.height;
      } else {
         var7 = 0;
      }

      var1.height = 1 + Math.max(var6, var7);
      int var8 = var1.height;
      int var9 = 0;
      if(var5 != null) {
         var9 = var5.height;
      }

      var3.height = 1 + Math.max(var8, var9);
   }

   private void rotateRight(LinkedTreeMap.Node<K, V> var1) {
      LinkedTreeMap.Node var2 = var1.left;
      LinkedTreeMap.Node var3 = var1.right;
      LinkedTreeMap.Node var4 = var2.left;
      LinkedTreeMap.Node var5 = var2.right;
      var1.left = var5;
      if(var5 != null) {
         var5.parent = var1;
      }

      this.replaceInParent(var1, var2);
      var2.right = var1;
      var1.parent = var2;
      int var6;
      if(var3 != null) {
         var6 = var3.height;
      } else {
         var6 = 0;
      }

      int var7;
      if(var5 != null) {
         var7 = var5.height;
      } else {
         var7 = 0;
      }

      var1.height = 1 + Math.max(var6, var7);
      int var8 = var1.height;
      int var9 = 0;
      if(var4 != null) {
         var9 = var4.height;
      }

      var2.height = 1 + Math.max(var8, var9);
   }

   public void clear() {
      this.root = null;
      this.size = 0;
      ++this.modCount;
      LinkedTreeMap.Node var1 = this.header;
      var1.prev = var1;
      var1.next = var1;
   }

   public boolean containsKey(Object var1) {
      return this.findByObject(var1) != null;
   }

   public Set<Entry<K, V>> entrySet() {
      LinkedTreeMap.EntrySet var1 = this.entrySet;
      if(var1 != null) {
         return var1;
      } else {
         LinkedTreeMap.EntrySet var2 = new LinkedTreeMap.EntrySet();
         this.entrySet = var2;
         return var2;
      }
   }

   LinkedTreeMap.Node<K, V> find(K var1, boolean var2) {
      Comparator var3 = this.comparator;
      LinkedTreeMap.Node var4 = this.root;
      int var5 = 0;
      LinkedTreeMap.Node var6;
      if(var4 != null) {
         Comparable var9;
         if(var3 == NATURAL_ORDER) {
            var9 = (Comparable)var1;
         } else {
            var9 = null;
         }

         while(true) {
            if(var9 != null) {
               var5 = var9.compareTo(var4.key);
            } else {
               var5 = var3.compare(var1, var4.key);
            }

            if(var5 == 0) {
               var6 = var4;
               return var6;
            }

            LinkedTreeMap.Node var10;
            if(var5 < 0) {
               var10 = var4.left;
            } else {
               var10 = var4.right;
            }

            if(var10 == null) {
               break;
            }

            var4 = var10;
         }
      }

      var6 = null;
      if(var2) {
         LinkedTreeMap.Node var7 = this.header;
         LinkedTreeMap.Node var8;
         if(var4 == null) {
            if(var3 == NATURAL_ORDER && !(var1 instanceof Comparable)) {
               throw new ClassCastException(var1.getClass().getName() + " is not Comparable");
            }

            var8 = new LinkedTreeMap.Node(var4, var1, var7, var7.prev);
            this.root = var8;
         } else {
            var8 = new LinkedTreeMap.Node(var4, var1, var7, var7.prev);
            if(var5 < 0) {
               var4.left = var8;
            } else {
               var4.right = var8;
            }

            this.rebalance(var4, true);
         }

         ++this.size;
         ++this.modCount;
         return var8;
      } else {
         return var6;
      }
   }

   LinkedTreeMap.Node<K, V> findByEntry(Entry<?, ?> var1) {
      LinkedTreeMap.Node var2 = this.findByObject(var1.getKey());
      boolean var3;
      if(var2 != null && this.equal(var2.value, var1.getValue())) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3?var2:null;
   }

   LinkedTreeMap.Node<K, V> findByObject(Object var1) {
      LinkedTreeMap.Node var2 = null;
      if(var1 != null) {
         LinkedTreeMap.Node var4;
         try {
            var4 = this.find(var1, false);
         } catch (ClassCastException var5) {
            return null;
         }

         var2 = var4;
      }

      return var2;
   }

   public V get(Object var1) {
      LinkedTreeMap.Node var2 = this.findByObject(var1);
      return var2 != null?var2.value:null;
   }

   public Set<K> keySet() {
      LinkedTreeMap.KeySet var1 = this.keySet;
      if(var1 != null) {
         return var1;
      } else {
         LinkedTreeMap.KeySet var2 = new LinkedTreeMap.KeySet();
         this.keySet = var2;
         return var2;
      }
   }

   public V put(K var1, V var2) {
      if(var1 == null) {
         throw new NullPointerException("key == null");
      } else {
         LinkedTreeMap.Node var3 = this.find(var1, true);
         Object var4 = var3.value;
         var3.value = var2;
         return var4;
      }
   }

   public V remove(Object var1) {
      LinkedTreeMap.Node var2 = this.removeInternalByKey(var1);
      return var2 != null?var2.value:null;
   }

   void removeInternal(LinkedTreeMap.Node<K, V> var1, boolean var2) {
      if(var2) {
         var1.prev.next = var1.next;
         var1.next.prev = var1.prev;
      }

      LinkedTreeMap.Node var3 = var1.left;
      LinkedTreeMap.Node var4 = var1.right;
      LinkedTreeMap.Node var5 = var1.parent;
      if(var3 != null && var4 != null) {
         LinkedTreeMap.Node var6;
         if(var3.height > var4.height) {
            var6 = var3.last();
         } else {
            var6 = var4.first();
         }

         this.removeInternal(var6, false);
         LinkedTreeMap.Node var7 = var1.left;
         int var8 = 0;
         if(var7 != null) {
            var8 = var7.height;
            var6.left = var7;
            var7.parent = var6;
            var1.left = null;
         }

         LinkedTreeMap.Node var9 = var1.right;
         int var10 = 0;
         if(var9 != null) {
            var10 = var9.height;
            var6.right = var9;
            var9.parent = var6;
            var1.right = null;
         }

         var6.height = 1 + Math.max(var8, var10);
         this.replaceInParent(var1, var6);
      } else {
         if(var3 != null) {
            this.replaceInParent(var1, var3);
            var1.left = null;
         } else if(var4 != null) {
            this.replaceInParent(var1, var4);
            var1.right = null;
         } else {
            this.replaceInParent(var1, (LinkedTreeMap.Node)null);
         }

         this.rebalance(var5, false);
         this.size += -1;
         ++this.modCount;
      }
   }

   LinkedTreeMap.Node<K, V> removeInternalByKey(Object var1) {
      LinkedTreeMap.Node var2 = this.findByObject(var1);
      if(var2 != null) {
         this.removeInternal(var2, true);
      }

      return var2;
   }

   public int size() {
      return this.size;
   }

   class EntrySet extends AbstractSet<Entry<K, V>> {
      public void clear() {
         LinkedTreeMap.this.clear();
      }

      public boolean contains(Object var1) {
         return var1 instanceof Entry && LinkedTreeMap.this.findByEntry((Entry)var1) != null;
      }

      public Iterator<Entry<K, V>> iterator() {
         return new LinkedTreeMap.LinkedTreeMapIterator() {
            public Entry<K, V> next() {
               return this.nextNode();
            }
         };
      }

      public boolean remove(Object var1) {
         if(var1 instanceof Entry) {
            LinkedTreeMap.Node var2 = LinkedTreeMap.this.findByEntry((Entry)var1);
            if(var2 != null) {
               LinkedTreeMap.this.removeInternal(var2, true);
               return true;
            }
         }

         return false;
      }

      public int size() {
         return LinkedTreeMap.this.size;
      }
   }

   final class KeySet extends AbstractSet<K> {
      public void clear() {
         LinkedTreeMap.this.clear();
      }

      public boolean contains(Object var1) {
         return LinkedTreeMap.this.containsKey(var1);
      }

      public Iterator<K> iterator() {
         return new LinkedTreeMap.LinkedTreeMapIterator() {
            public K next() {
               return this.nextNode().key;
            }
         };
      }

      public boolean remove(Object var1) {
         return LinkedTreeMap.this.removeInternalByKey(var1) != null;
      }

      public int size() {
         return LinkedTreeMap.this.size;
      }
   }

   private abstract class LinkedTreeMapIterator<T> implements Iterator<T> {
      int expectedModCount;
      LinkedTreeMap.Node<K, V> lastReturned;
      LinkedTreeMap.Node<K, V> next;

      LinkedTreeMapIterator() {
         this.next = LinkedTreeMap.this.header.next;
         this.lastReturned = null;
         this.expectedModCount = LinkedTreeMap.this.modCount;
      }

      public final boolean hasNext() {
         return this.next != LinkedTreeMap.this.header;
      }

      final LinkedTreeMap.Node<K, V> nextNode() {
         LinkedTreeMap.Node var1 = this.next;
         if(var1 == LinkedTreeMap.this.header) {
            throw new NoSuchElementException();
         } else if(LinkedTreeMap.this.modCount != this.expectedModCount) {
            throw new ConcurrentModificationException();
         } else {
            this.next = var1.next;
            this.lastReturned = var1;
            return var1;
         }
      }

      public final void remove() {
         if(this.lastReturned == null) {
            throw new IllegalStateException();
         } else {
            LinkedTreeMap.this.removeInternal(this.lastReturned, true);
            this.lastReturned = null;
            this.expectedModCount = LinkedTreeMap.this.modCount;
         }
      }
   }

   static final class Node<K, V> implements Entry<K, V> {
      int height;
      final K key;
      LinkedTreeMap.Node<K, V> left;
      LinkedTreeMap.Node<K, V> next;
      LinkedTreeMap.Node<K, V> parent;
      LinkedTreeMap.Node<K, V> prev;
      LinkedTreeMap.Node<K, V> right;
      V value;

      Node() {
         this.key = null;
         this.prev = this;
         this.next = this;
      }

      Node(LinkedTreeMap.Node<K, V> var1, K var2, LinkedTreeMap.Node<K, V> var3, LinkedTreeMap.Node<K, V> var4) {
         this.parent = var1;
         this.key = var2;
         this.height = 1;
         this.next = var3;
         this.prev = var4;
         var4.next = this;
         var3.prev = this;
      }

      public boolean equals(Object var1) {
         boolean var2 = var1 instanceof Entry;
         boolean var3 = false;
         if(var2) {
            Entry var4 = (Entry)var1;
            if(this.key == null) {
               Object var8 = var4.getKey();
               var3 = false;
               if(var8 != null) {
                  return var3;
               }
            } else {
               boolean var5 = this.key.equals(var4.getKey());
               var3 = false;
               if(!var5) {
                  return var3;
               }
            }

            if(this.value == null) {
               Object var7 = var4.getValue();
               var3 = false;
               if(var7 != null) {
                  return var3;
               }
            } else {
               boolean var6 = this.value.equals(var4.getValue());
               var3 = false;
               if(!var6) {
                  return var3;
               }
            }

            var3 = true;
         }

         return var3;
      }

      public LinkedTreeMap.Node<K, V> first() {
         LinkedTreeMap.Node var1 = this;

         for(LinkedTreeMap.Node var2 = this.left; var2 != null; var2 = var2.left) {
            var1 = var2;
         }

         return var1;
      }

      public K getKey() {
         return this.key;
      }

      public V getValue() {
         return this.value;
      }

      public int hashCode() {
         int var1;
         if(this.key == null) {
            var1 = 0;
         } else {
            var1 = this.key.hashCode();
         }

         Object var2 = this.value;
         int var3 = 0;
         if(var2 != null) {
            var3 = this.value.hashCode();
         }

         return var1 ^ var3;
      }

      public LinkedTreeMap.Node<K, V> last() {
         LinkedTreeMap.Node var1 = this;

         for(LinkedTreeMap.Node var2 = this.right; var2 != null; var2 = var2.right) {
            var1 = var2;
         }

         return var1;
      }

      public V setValue(V var1) {
         Object var2 = this.value;
         this.value = var1;
         return var2;
      }

      public String toString() {
         return this.key + "=" + this.value;
      }
   }
}
