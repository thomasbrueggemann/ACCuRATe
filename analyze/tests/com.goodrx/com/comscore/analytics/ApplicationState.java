package com.comscore.analytics;

public enum ApplicationState {
   BACKGROUND_UX_ACTIVE,
   FOREGROUND,
   INACTIVE;

   static {
      ApplicationState[] var0 = new ApplicationState[]{INACTIVE, BACKGROUND_UX_ACTIVE, FOREGROUND};
   }
}
