package android.support.v7.util;

import android.support.v7.util.TileList;

interface ThreadUtil<T> {
   ThreadUtil.BackgroundCallback<T> getBackgroundProxy(ThreadUtil.BackgroundCallback<T> var1);

   ThreadUtil.MainThreadCallback<T> getMainThreadProxy(ThreadUtil.MainThreadCallback<T> var1);

   public interface BackgroundCallback<T> {
      void loadTile(int var1, int var2);

      void recycleTile(TileList.Tile<T> var1);

      void refresh(int var1);

      void updateRange(int var1, int var2, int var3, int var4, int var5);
   }

   public interface MainThreadCallback<T> {
      void addTile(int var1, TileList.Tile<T> var2);

      void removeTile(int var1, int var2);

      void updateItemCount(int var1, int var2);
   }
}
