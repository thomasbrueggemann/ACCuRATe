package org.apache.cordova;

import java.util.List;
import org.apache.cordova.CordovaPlugin;

public class PluginEntry {
    public boolean onload;
    public CordovaPlugin plugin;
    public String pluginClass;
    public String service;
    private List<String> urlFilters;

    public PluginEntry(String var1, String var2, boolean var3) {
        this(var1, var2, var3, (CordovaPlugin)null, (List)null);
    }

    @Deprecated
    public PluginEntry(String var1, String var2, boolean var3, List<String> var4) {
        this.service = var1;
        this.pluginClass = var2;
        this.onload = var3;
        this.urlFilters = var4;
        this.plugin = null;
    }

    private PluginEntry(String var1, String var2, boolean var3, CordovaPlugin var4, List<String> var5) {
        this.service = var1;
        this.pluginClass = var2;
        this.onload = var3;
        this.urlFilters = var5;
        this.plugin = var4;
    }

    public PluginEntry(String var1, CordovaPlugin var2) {
        this(var1, var2.getClass().getName(), true, var2, (List)null);
    }

    public List<String> getUrlFilters() {
        return this.urlFilters;
    }
}
