package com.facebook.common.memory;

import com.facebook.common.memory.MemoryTrimmable;

public interface MemoryTrimmableRegistry {
   void registerMemoryTrimmable(MemoryTrimmable var1);

   void unregisterMemoryTrimmable(MemoryTrimmable var1);
}
