package com.newrelic.agent.android;

import java.util.HashSet;
import java.util.Set;

public enum FeatureFlag {
   AnalyticsEvents,
   CrashReporting,
   DefaultInteractions,
   HttpResponseBodyCapture,
   InteractionTracing;

   public static final Set<FeatureFlag> enabledFeatures;

   static {
      FeatureFlag[] var0 = new FeatureFlag[]{HttpResponseBodyCapture, CrashReporting, AnalyticsEvents, InteractionTracing, DefaultInteractions};
      enabledFeatures = new HashSet();
      enableFeature(HttpResponseBodyCapture);
      enableFeature(CrashReporting);
      enableFeature(AnalyticsEvents);
      enableFeature(InteractionTracing);
      enableFeature(DefaultInteractions);
   }

   public static void disableFeature(FeatureFlag var0) {
      enabledFeatures.remove(var0);
   }

   public static void enableFeature(FeatureFlag var0) {
      enabledFeatures.add(var0);
   }

   public static boolean featureEnabled(FeatureFlag var0) {
      return enabledFeatures.contains(var0);
   }
}
