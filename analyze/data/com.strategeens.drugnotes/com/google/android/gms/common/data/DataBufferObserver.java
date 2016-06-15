package com.google.android.gms.common.data;

public interface DataBufferObserver {
   void onDataChanged();

   void onDataRangeChanged(int var1, int var2);

   void onDataRangeInserted(int var1, int var2);

   void onDataRangeMoved(int var1, int var2, int var3);

   void onDataRangeRemoved(int var1, int var2);

   public interface Observable {
      void addObserver(DataBufferObserver var1);

      void removeObserver(DataBufferObserver var1);
   }
}
