package org.apache.cordova;

import android.app.Activity;
import android.util.Log;
import java.util.List;
import org.apache.cordova.ConfigXmlParser;
import org.apache.cordova.CordovaPreferences;
import org.apache.cordova.PluginEntry;
import org.apache.cordova.Whitelist;

@Deprecated
public class Config {
    private static final String TAG = "Config";
    static ConfigXmlParser parser;

    public static void addWhiteListEntry(String var0, boolean var1) {
        if(parser == null) {
            Log.e("Config", "Config was not initialised. Did you forget to Config.init(this)?");
        } else {
            parser.getInternalWhitelist().addWhiteListEntry(var0, var1);
        }
    }

    public static String getErrorUrl() {
        return parser.getPreferences().getString("errorurl", (String)null);
    }

    public static Whitelist getExternalWhitelist() {
        return parser.getExternalWhitelist();
    }

    public static List<PluginEntry> getPluginEntries() {
        return parser.getPluginEntries();
    }

    public static CordovaPreferences getPreferences() {
        return parser.getPreferences();
    }

    public static String getStartUrl() {
        return parser == null?"file:///android_asset/www/index.html":parser.getLaunchUrl();
    }

    public static Whitelist getWhitelist() {
        return parser.getInternalWhitelist();
    }

    public static void init() {
        if(parser == null) {
            parser = new ConfigXmlParser();
        }

    }

    public static void init(Activity var0) {
        parser = new ConfigXmlParser();
        parser.parse(var0);
        parser.getPreferences().setPreferencesBundle(var0.getIntent().getExtras());
        parser.getPreferences().copyIntoIntentExtras(var0);
    }

    public static boolean isInitialized() {
        return parser != null;
    }

    public static boolean isUrlExternallyWhiteListed(String var0) {
        if(parser == null) {
            Log.e("Config", "Config was not initialised. Did you forget to Config.init(this)?");
            return false;
        } else {
            return parser.getExternalWhitelist().isUrlWhiteListed(var0);
        }
    }

    public static boolean isUrlWhiteListed(String var0) {
        if(parser == null) {
            Log.e("Config", "Config was not initialised. Did you forget to Config.init(this)?");
            return false;
        } else {
            return parser.getInternalWhitelist().isUrlWhiteListed(var0);
        }
    }
}
