package com.danielcwilson.plugins.analytics;

import com.google.analytics.tracking.android.Fields;
import com.google.analytics.tracking.android.GAServiceManager;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Logger;
import com.google.analytics.tracking.android.MapBuilder;
import com.google.analytics.tracking.android.Tracker;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class UniversalAnalyticsPlugin extends CordovaPlugin {
    public static final String ADD_DIMENSION = "addCustomDimension";
    public static final String ADD_TRANSACTION = "addTransaction";
    public static final String ADD_TRANSACTION_ITEM = "addTransactionItem";
    public static final String DEBUG_MODE = "debugMode";
    public static final String SET_USER_ID = "setUserId";
    public static final String START_TRACKER = "startTrackerWithId";
    public static final String TRACK_EVENT = "trackEvent";
    public static final String TRACK_EXCEPTION = "trackException";
    public static final String TRACK_TIMING = "trackTiming";
    public static final String TRACK_VIEW = "trackView";
    public HashMap<String, String> customDimensions = new HashMap();
    public Boolean debugModeEnabled = Boolean.valueOf(false);
    public Boolean trackerStarted = Boolean.valueOf(false);

    private void addCustomDimension(String var1, String var2, CallbackContext var3) {
        if(var1 != null && var1.length() > 0 && var2 != null && var2.length() > 0) {
            this.customDimensions.put(var1, var2);
        } else {
            var3.error("Expected non-empty string arguments.");
        }
    }

    private void addCustomDimensionsToTracker(Tracker var1) {
        Iterator var2 = this.customDimensions.entrySet().iterator();

        while(var2.hasNext()) {
            Entry var3 = (Entry)var2.next();
            String var4 = (String)var3.getKey();
            String var5 = (String)var3.getValue();
            var1.set(Fields.customDimension(Integer.parseInt(var4)), var5);
        }

    }

    private void addTransaction(String var1, String var2, double var3, double var5, double var7, String var9, CallbackContext var10) {
        if(!this.trackerStarted.booleanValue()) {
            var10.error("Tracker not started");
        } else {
            Tracker var11 = GoogleAnalytics.getInstance(this.cordova.getActivity()).getDefaultTracker();
            this.addCustomDimensionsToTracker(var11);
            if(var1 != null && var1.length() > 0) {
                var11.send(MapBuilder.createTransaction(var1, var2, Double.valueOf(var3), Double.valueOf(var5), Double.valueOf(var7), var9).build());
                var10.success("Add Transaction: " + var1);
            } else {
                var10.error("Expected non-empty ID.");
            }
        }
    }

    private void addTransactionItem(String var1, String var2, String var3, String var4, double var5, long var7, String var9, CallbackContext var10) {
        if(!this.trackerStarted.booleanValue()) {
            var10.error("Tracker not started");
        } else {
            Tracker var11 = GoogleAnalytics.getInstance(this.cordova.getActivity()).getDefaultTracker();
            this.addCustomDimensionsToTracker(var11);
            if(var1 != null && var1.length() > 0) {
                var11.send(MapBuilder.createItem(var1, var2, var3, var4, Double.valueOf(var5), Long.valueOf(var7), var9).build());
                var10.success("Add Transaction Item: " + var1);
            } else {
                var10.error("Expected non-empty ID.");
            }
        }
    }

    private void debugMode(CallbackContext var1) {
        GoogleAnalytics.getInstance(this.cordova.getActivity()).getLogger().setLogLevel(Logger.LogLevel.VERBOSE);
        this.debugModeEnabled = Boolean.valueOf(true);
        var1.success("debugMode enabled");
    }

    private void setUserId(String var1, CallbackContext var2) {
        if(!this.trackerStarted.booleanValue()) {
            var2.error("Tracker not started");
        } else {
            GoogleAnalytics.getInstance(this.cordova.getActivity()).getDefaultTracker().set("&uid", var1);
            var2.success("Set user id" + var1);
        }
    }

    private void startTracker(String var1, CallbackContext var2) {
        if(var1 != null && var1.length() > 0) {
            GoogleAnalytics.getInstance(this.cordova.getActivity()).getTracker(var1);
            var2.success("tracker started");
            this.trackerStarted = Boolean.valueOf(true);
            GAServiceManager.getInstance().setLocalDispatchPeriod(30);
        } else {
            var2.error("tracker id is not valid");
        }
    }

    private void trackEvent(String var1, String var2, String var3, long var4, CallbackContext var6) {
        if(!this.trackerStarted.booleanValue()) {
            var6.error("Tracker not started");
        } else {
            Tracker var7 = GoogleAnalytics.getInstance(this.cordova.getActivity()).getDefaultTracker();
            this.addCustomDimensionsToTracker(var7);
            if(var1 != null && var1.length() > 0) {
                var7.send(MapBuilder.createEvent(var1, var2, var3, Long.valueOf(var4)).build());
                var6.success("Track Event: " + var1);
            } else {
                var6.error("Expected non-empty string arguments.");
            }
        }
    }

    private void trackException(String var1, Boolean var2, CallbackContext var3) {
        if(!this.trackerStarted.booleanValue()) {
            var3.error("Tracker not started");
        } else {
            Tracker var4 = GoogleAnalytics.getInstance(this.cordova.getActivity()).getDefaultTracker();
            this.addCustomDimensionsToTracker(var4);
            if(var1 != null && var1.length() > 0) {
                var4.send(MapBuilder.createException(var1, var2).build());
                var3.success("Track Exception: " + var1);
            } else {
                var3.error("Expected non-empty string arguments.");
            }
        }
    }

    private void trackTiming(String var1, long var2, String var4, String var5, CallbackContext var6) {
        if(!this.trackerStarted.booleanValue()) {
            var6.error("Tracker not started");
        } else {
            Tracker var7 = GoogleAnalytics.getInstance(this.cordova.getActivity()).getDefaultTracker();
            this.addCustomDimensionsToTracker(var7);
            if(var1 != null && var1.length() > 0) {
                var7.send(MapBuilder.createTiming(var1, Long.valueOf(var2), var4, var5).build());
                var6.success("Track Timing: " + var1);
            } else {
                var6.error("Expected non-empty string arguments.");
            }
        }
    }

    private void trackView(String var1, CallbackContext var2) {
        if(!this.trackerStarted.booleanValue()) {
            var2.error("Tracker not started");
        } else {
            Tracker var3 = GoogleAnalytics.getInstance(this.cordova.getActivity()).getDefaultTracker();
            this.addCustomDimensionsToTracker(var3);
            if(var1 != null && var1.length() > 0) {
                var3.set("&cd", var1);
                var3.send(MapBuilder.createAppView().build());
                var2.success("Track Screen: " + var1);
            } else {
                var2.error("Expected one non-empty string argument.");
            }
        }
    }

    public boolean execute(String var1, JSONArray var2, CallbackContext var3) throws JSONException {
        if("startTrackerWithId".equals(var1)) {
            this.startTracker(var2.getString(0), var3);
            return true;
        } else if("trackView".equals(var1)) {
            this.trackView(var2.getString(0), var3);
            return true;
        } else if("trackEvent".equals(var1)) {
            int var30 = var2.length();
            if(var30 > 0) {
                String var31 = var2.getString(0);
                String var32;
                if(var30 > 1) {
                    var32 = var2.getString(1);
                } else {
                    var32 = "";
                }

                String var33;
                if(var30 > 2) {
                    var33 = var2.getString(2);
                } else {
                    var33 = "";
                }

                long var34;
                if(var30 > 3) {
                    var34 = var2.getLong(3);
                } else {
                    var34 = 0L;
                }

                this.trackEvent(var31, var32, var33, var34, var3);
            }

            return true;
        } else if("trackException".equals(var1)) {
            this.trackException(var2.getString(0), Boolean.valueOf(var2.getBoolean(1)), var3);
            return true;
        } else if("trackTiming".equals(var1)) {
            int var24 = var2.length();
            if(var24 > 0) {
                String var25 = var2.getString(0);
                long var26;
                if(var24 > 1) {
                    var26 = var2.getLong(1);
                } else {
                    var26 = 0L;
                }

                String var28;
                if(var24 > 2) {
                    var28 = var2.getString(2);
                } else {
                    var28 = "";
                }

                String var29;
                if(var24 > 3) {
                    var29 = var2.getString(3);
                } else {
                    var29 = "";
                }

                this.trackTiming(var25, var26, var28, var29, var3);
            }

            return true;
        } else if("addCustomDimension".equals(var1)) {
            this.addCustomDimension(var2.getString(0), var2.getString(1), var3);
            return true;
        } else if("addTransaction".equals(var1)) {
            int var14 = var2.length();
            if(var14 > 0) {
                String var15 = var2.getString(0);
                String var16;
                if(var14 > 1) {
                    var16 = var2.getString(1);
                } else {
                    var16 = "";
                }

                double var17;
                if(var14 > 2) {
                    var17 = var2.getDouble(2);
                } else {
                    var17 = 0.0D;
                }

                double var19;
                if(var14 > 3) {
                    var19 = var2.getDouble(3);
                } else {
                    var19 = 0.0D;
                }

                double var21;
                if(var14 > 4) {
                    var21 = var2.getDouble(4);
                } else {
                    var21 = 0.0D;
                }

                String var23;
                if(var14 > 5) {
                    var23 = var2.getString(5);
                } else {
                    var23 = null;
                }

                this.addTransaction(var15, var16, var17, var19, var21, var23, var3);
            }

            return true;
        } else if("addTransactionItem".equals(var1)) {
            int var4 = var2.length();
            if(var4 > 0) {
                String var5 = var2.getString(0);
                String var6;
                if(var4 > 1) {
                    var6 = var2.getString(1);
                } else {
                    var6 = "";
                }

                String var7;
                if(var4 > 2) {
                    var7 = var2.getString(2);
                } else {
                    var7 = "";
                }

                String var8;
                if(var4 > 3) {
                    var8 = var2.getString(3);
                } else {
                    var8 = "";
                }

                double var9;
                if(var4 > 4) {
                    var9 = var2.getDouble(4);
                } else {
                    var9 = 0.0D;
                }

                long var11;
                if(var4 > 5) {
                    var11 = var2.getLong(5);
                } else {
                    var11 = 0L;
                }

                String var13;
                if(var4 > 6) {
                    var13 = var2.getString(6);
                } else {
                    var13 = null;
                }

                this.addTransactionItem(var5, var6, var7, var8, var9, var11, var13, var3);
            }

            return true;
        } else {
            if("setUserId".equals(var1)) {
                this.setUserId(var2.getString(0), var3);
            } else if("debugMode".equals(var1)) {
                this.debugMode(var3);
            }

            return false;
        }
    }
}
