package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.Freezable;
import java.util.ArrayList;

public final class DataBufferUtils {
   public static <T, E extends Freezable<T>> ArrayList<T> freezeAndClose(DataBuffer<E> param0) {
      // $FF: Couldn't be decompiled
   }

   public static boolean hasNextPage(DataBuffer<?> var0) {
      Bundle var1 = var0.method_2615();
      return var1 != null && var1.getString("next_page_token") != null;
   }

   public static boolean hasPrevPage(DataBuffer<?> var0) {
      Bundle var1 = var0.method_2615();
      return var1 != null && var1.getString("prev_page_token") != null;
   }
}
