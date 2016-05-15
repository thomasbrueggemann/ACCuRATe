package com.nostra13.universalimageloader.core.assist;

public enum LoadedFrom {
   DISC_CACHE,
   MEMORY_CACHE,
   NETWORK;

   static {
      LoadedFrom[] var0 = new LoadedFrom[]{NETWORK, DISC_CACHE, MEMORY_CACHE};
   }
}
