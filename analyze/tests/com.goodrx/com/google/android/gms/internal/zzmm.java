package com.google.android.gms.internal;

import android.support.v4.util.ArrayMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

public class zzmm<E> extends AbstractSet<E> {
   private final ArrayMap<E, E> zzanZ;

   public zzmm() {
      this.zzanZ = new ArrayMap();
   }

   public zzmm(int var1) {
      this.zzanZ = new ArrayMap(var1);
   }

   public zzmm(Collection<E> var1) {
      this(var1.size());
      this.addAll(var1);
   }

   public boolean add(E var1) {
      if(this.zzanZ.containsKey(var1)) {
         return false;
      } else {
         this.zzanZ.put(var1, var1);
         return true;
      }
   }

   public boolean addAll(Collection<? extends E> var1) {
      return var1 instanceof zzmm?this.zza((zzmm)var1):super.addAll(var1);
   }

   public void clear() {
      this.zzanZ.clear();
   }

   public boolean contains(Object var1) {
      return this.zzanZ.containsKey(var1);
   }

   public Iterator<E> iterator() {
      return this.zzanZ.keySet().iterator();
   }

   public boolean remove(Object var1) {
      if(!this.zzanZ.containsKey(var1)) {
         return false;
      } else {
         this.zzanZ.remove(var1);
         return true;
      }
   }

   public int size() {
      return this.zzanZ.size();
   }

   public boolean zza(zzmm<? extends E> var1) {
      int var2 = this.size();
      this.zzanZ.putAll(var1.zzanZ);
      return this.size() > var2;
   }
}
