package com.appsflyer;

import java.util.Map;

public interface AppsFlyerConversionListener {
   void onAppOpenAttribution(Map<String, String> var1);

   void onInstallConversionDataLoaded(Map<String, String> var1);

   void onInstallConversionFailure(String var1);
}
