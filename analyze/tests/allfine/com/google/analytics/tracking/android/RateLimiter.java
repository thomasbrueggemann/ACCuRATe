package com.google.analytics.tracking.android;

interface RateLimiter {
    int DEFAULT_MAX_TOKEN_COUNT = 60;
    long DEFAULT_MILLISECONDS_PER_TOKEN = 2000L;

    boolean tokenAvailable();
}
