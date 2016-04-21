package org.apache.cordova;

import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;
import org.apache.cordova.CordovaPreferences;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginEntry;
import org.apache.cordova.Whitelist;
import org.xmlpull.v1.XmlPullParserException;

public class ConfigXmlParser {
    private static String TAG = "ConfigXmlParser";
    private Whitelist externalWhitelist = new Whitelist();
    private Whitelist internalWhitelist = new Whitelist();
    private String launchUrl = "file:///android_asset/www/index.html";
    private ArrayList<PluginEntry> pluginEntries = new ArrayList(20);
    private CordovaPreferences prefs = new CordovaPreferences();

    private void setStartUrl(String var1) {
        if(Pattern.compile("^[a-z-]+://").matcher(var1).find()) {
            this.launchUrl = var1;
        } else {
            if(var1.charAt(0) == 47) {
                var1 = var1.substring(1);
            }

            this.launchUrl = "file:///android_asset/www/" + var1;
        }
    }

    public Whitelist getExternalWhitelist() {
        return this.externalWhitelist;
    }

    public Whitelist getInternalWhitelist() {
        return this.internalWhitelist;
    }

    public String getLaunchUrl() {
        return this.launchUrl;
    }

    public ArrayList<PluginEntry> getPluginEntries() {
        return this.pluginEntries;
    }

    public CordovaPreferences getPreferences() {
        return this.prefs;
    }

    public void parse(Activity var1) {
        int var2 = var1.getResources().getIdentifier("config", "xml", var1.getClass().getPackage().getName());
        if(var2 == 0) {
            var2 = var1.getResources().getIdentifier("config", "xml", var1.getPackageName());
            if(var2 == 0) {
                LOG.method_4282(TAG, "res/xml/config.xml is missing!");
                return;
            }
        }

        this.parse(var1.getResources().getXml(var2));
    }

    public void parse(XmlResourceParser var1) {
        int var2 = -1;
        String var3 = "";
        String var4 = "";
        boolean var5 = false;
        boolean var6 = false;
        ArrayList var7 = null;
        this.internalWhitelist.addWhiteListEntry("file:///*", false);
        this.internalWhitelist.addWhiteListEntry("content:///*", false);
        this.internalWhitelist.addWhiteListEntry("data:*", false);

        while(var2 != 1) {
            if(var2 == 2) {
                String var14 = var1.getName();
                if(var14.equals("url-filter")) {
                    Log.w(TAG, "Plugin " + var3 + " is using deprecated tag <url-filter>");
                    if(var7 == null) {
                        var7 = new ArrayList(2);
                    }

                    String var27 = var1.getAttributeValue((String)null, "value");
                    var7.add(var27);
                } else if(var14.equals("feature")) {
                    var6 = true;
                    var3 = var1.getAttributeValue((String)null, "name");
                } else if(var6 && var14.equals("param")) {
                    String var25 = var1.getAttributeValue((String)null, "name");
                    if(var25.equals("service")) {
                        var3 = var1.getAttributeValue((String)null, "value");
                    } else if(!var25.equals("package") && !var25.equals("android-package")) {
                        if(var25.equals("onload")) {
                            var5 = "true".equals(var1.getAttributeValue((String)null, "value"));
                        }
                    } else {
                        var4 = var1.getAttributeValue((String)null, "value");
                    }
                } else if(var14.equals("access")) {
                    String var18 = var1.getAttributeValue((String)null, "origin");
                    String var19 = var1.getAttributeValue((String)null, "subdomains");
                    boolean var20;
                    if(var1.getAttributeValue((String)null, "launch-external") != null) {
                        var20 = true;
                    } else {
                        var20 = false;
                    }

                    if(var18 != null) {
                        if(var20) {
                            Whitelist var23 = this.externalWhitelist;
                            boolean var24;
                            if(var19 != null && var19.compareToIgnoreCase("true") == 0) {
                                var24 = true;
                            } else {
                                var24 = false;
                            }

                            var23.addWhiteListEntry(var18, var24);
                        } else if("*".equals(var18)) {
                            this.internalWhitelist.addWhiteListEntry("http://*/*", false);
                            this.internalWhitelist.addWhiteListEntry("https://*/*", false);
                        } else {
                            Whitelist var21 = this.internalWhitelist;
                            boolean var22;
                            if(var19 != null && var19.compareToIgnoreCase("true") == 0) {
                                var22 = true;
                            } else {
                                var22 = false;
                            }

                            var21.addWhiteListEntry(var18, var22);
                        }
                    }
                } else if(var14.equals("preference")) {
                    String var16 = var1.getAttributeValue((String)null, "name").toLowerCase(Locale.ENGLISH);
                    String var17 = var1.getAttributeValue((String)null, "value");
                    this.prefs.set(var16, var17);
                } else if(var14.equals("content")) {
                    String var15 = var1.getAttributeValue((String)null, "src");
                    if(var15 != null) {
                        this.setStartUrl(var15);
                    }
                }
            } else if(var2 == 3 && var1.getName().equals("feature")) {
                ArrayList var8 = this.pluginEntries;
                PluginEntry var9 = new PluginEntry(var3, var4, var5, var7);
                var8.add(var9);
                var3 = "";
                var4 = "";
                var6 = false;
                var5 = false;
                var7 = null;
            }

            int var13;
            try {
                var13 = var1.next();
            } catch (XmlPullParserException var28) {
                var28.printStackTrace();
                continue;
            } catch (IOException var29) {
                var29.printStackTrace();
                continue;
            }

            var2 = var13;
        }

    }
}
