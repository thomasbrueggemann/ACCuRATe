package com.comscore.analytics;

import com.comscore.analytics.ApplicationState;
import com.comscore.analytics.SessionState;

// $FF: renamed from: com.comscore.analytics.ab
// $FF: synthetic class
class class_9 {
   // $FF: renamed from: a int[]
   // $FF: synthetic field
   static final int[] field_18;
   // $FF: renamed from: b int[]
   // $FF: synthetic field
   static final int[] field_19 = new int[SessionState.values().length];

   static {
      try {
         field_19[SessionState.ACTIVE_USER.ordinal()] = 1;
      } catch (NoSuchFieldError var13) {
         ;
      }

      try {
         field_19[SessionState.USER.ordinal()] = 2;
      } catch (NoSuchFieldError var12) {
         ;
      }

      try {
         field_19[SessionState.APPLICATION.ordinal()] = 3;
      } catch (NoSuchFieldError var11) {
         ;
      }

      try {
         field_19[SessionState.INACTIVE.ordinal()] = 4;
      } catch (NoSuchFieldError var10) {
         ;
      }

      field_18 = new int[ApplicationState.values().length];

      try {
         field_18[ApplicationState.INACTIVE.ordinal()] = 1;
      } catch (NoSuchFieldError var9) {
         ;
      }

      try {
         field_18[ApplicationState.BACKGROUND_UX_ACTIVE.ordinal()] = 2;
      } catch (NoSuchFieldError var8) {
         ;
      }

      try {
         field_18[ApplicationState.FOREGROUND.ordinal()] = 3;
      } catch (NoSuchFieldError var7) {
         ;
      }
   }
}
