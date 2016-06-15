package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBufferObserver;
import java.util.HashSet;
import java.util.Iterator;

public final class DataBufferObserverSet implements DataBufferObserver, DataBufferObserver.Observable {
   // $FF: renamed from: KY java.util.HashSet
   private HashSet<DataBufferObserver> field_2770 = new HashSet();

   public void addObserver(DataBufferObserver var1) {
      this.field_2770.add(var1);
   }

   public void clear() {
      this.field_2770.clear();
   }

   public boolean hasObservers() {
      return !this.field_2770.isEmpty();
   }

   public void onDataChanged() {
      Iterator var1 = this.field_2770.iterator();

      while(var1.hasNext()) {
         ((DataBufferObserver)var1.next()).onDataChanged();
      }

   }

   public void onDataRangeChanged(int var1, int var2) {
      Iterator var3 = this.field_2770.iterator();

      while(var3.hasNext()) {
         ((DataBufferObserver)var3.next()).onDataRangeChanged(var1, var2);
      }

   }

   public void onDataRangeInserted(int var1, int var2) {
      Iterator var3 = this.field_2770.iterator();

      while(var3.hasNext()) {
         ((DataBufferObserver)var3.next()).onDataRangeInserted(var1, var2);
      }

   }

   public void onDataRangeMoved(int var1, int var2, int var3) {
      Iterator var4 = this.field_2770.iterator();

      while(var4.hasNext()) {
         ((DataBufferObserver)var4.next()).onDataRangeMoved(var1, var2, var3);
      }

   }

   public void onDataRangeRemoved(int var1, int var2) {
      Iterator var3 = this.field_2770.iterator();

      while(var3.hasNext()) {
         ((DataBufferObserver)var3.next()).onDataRangeRemoved(var1, var2);
      }

   }

   public void removeObserver(DataBufferObserver var1) {
      this.field_2770.remove(var1);
   }
}
