package com.comscore.analytics;

public enum SessionState {
   ACTIVE_USER,
   APPLICATION,
   INACTIVE,
   USER;

   static {
      SessionState[] var0 = new SessionState[]{INACTIVE, APPLICATION, USER, ACTIVE_USER};
   }
}
