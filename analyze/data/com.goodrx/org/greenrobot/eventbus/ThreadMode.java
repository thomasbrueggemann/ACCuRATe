package org.greenrobot.eventbus;

public enum ThreadMode {
   ASYNC,
   BACKGROUND,
   MAIN,
   POSTING;

   static {
      ThreadMode[] var0 = new ThreadMode[]{POSTING, MAIN, BACKGROUND, ASYNC};
   }
}
