package com.goodrx.utils.tracker;

import com.google.android.gms.tagmanager.ContainerHolder;

public class ContainerHolderSingleton {
   private static ContainerHolder containerHolder;

   public static ContainerHolder getContainerHolder() {
      return containerHolder;
   }

   public static void setContainerHolder(ContainerHolder var0) {
      containerHolder = var0;
   }
}
