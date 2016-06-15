package com.google.android.gms.drive;

public interface FileUploadPreferences {
   int BATTERY_USAGE_CHARGING_ONLY = 257;
   int BATTERY_USAGE_UNRESTRICTED = 256;
   int NETWORK_TYPE_ANY = 1;
   int NETWORK_TYPE_WIFI_ONLY = 2;
   int PREFERENCE_VALUE_UNKNOWN;

   int getBatteryUsagePreference();

   int getNetworkTypePreference();

   boolean isRoamingAllowed();

   void setBatteryUsagePreference(int var1);

   void setNetworkTypePreference(int var1);

   void setRoamingAllowed(boolean var1);
}
