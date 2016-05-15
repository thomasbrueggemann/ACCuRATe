package com.facebook.common.time;

public interface Clock {
   long MAX_TIME = Long.MAX_VALUE;

   long now();
}
