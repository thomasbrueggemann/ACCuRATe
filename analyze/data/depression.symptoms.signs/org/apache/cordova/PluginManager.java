package org.apache.cordova;

import android.content.Intent;
import android.net.Uri;
import android.os.Debug;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.cordova.ConfigXmlParser;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginEntry;

public class PluginManager {
   private static final int SLOW_EXEC_WARNING_THRESHOLD;
   private static String TAG = "PluginManager";
   private final CordovaWebView app;
   private final CordovaInterface ctx;
   private final HashMap<String, PluginEntry> entryMap;
   private final HashMap<String, CordovaPlugin> pluginMap;
   protected HashMap<String, List<String>> urlMap;

   static {
      byte var0;
      if(Debug.isDebuggerConnected()) {
         var0 = 60;
      } else {
         var0 = 16;
      }

      SLOW_EXEC_WARNING_THRESHOLD = var0;
   }

   @Deprecated
   PluginManager(CordovaWebView var1, CordovaInterface var2) {
      this(var1, var2, (List)null);
   }

   PluginManager(CordovaWebView var1, CordovaInterface var2, List<PluginEntry> var3) {
      this.pluginMap = new HashMap();
      this.entryMap = new HashMap();
      this.urlMap = new HashMap();
      this.ctx = var2;
      this.app = var1;
      if(var3 == null) {
         ConfigXmlParser var4 = new ConfigXmlParser();
         var4.parse(this.ctx.getActivity());
         var3 = var4.getPluginEntries();
      }

      this.setPluginEntries((List)var3);
   }

   private CordovaPlugin instantiatePlugin(String param1) {
      // $FF: Couldn't be decompiled
   }

   public void addService(String var1, String var2) {
      this.addService(new PluginEntry(var1, var2, false));
   }

   public void addService(PluginEntry var1) {
      this.entryMap.put(var1.service, var1);
      List var3 = var1.getUrlFilters();
      if(var3 != null) {
         this.urlMap.put(var1.service, var3);
      }

      if(var1.plugin != null) {
         var1.plugin.privateInitialize(this.ctx, this.app, this.app.getPreferences());
         this.pluginMap.put(var1.service, var1.plugin);
      }

   }

   @Deprecated
   public void clearPluginObjects() {
      this.pluginMap.clear();
   }

   public void exec(String param1, String param2, String param3, String param4) {
      // $FF: Couldn't be decompiled
   }

   @Deprecated
   public void exec(String var1, String var2, String var3, String var4, boolean var5) {
      this.exec(var1, var2, var3, var4);
   }

   public CordovaPlugin getPlugin(String var1) {
      CordovaPlugin var2 = (CordovaPlugin)this.pluginMap.get(var1);
      if(var2 == null) {
         PluginEntry var3 = (PluginEntry)this.entryMap.get(var1);
         if(var3 == null) {
            return null;
         }

         if(var3.plugin != null) {
            var2 = var3.plugin;
         } else {
            var2 = this.instantiatePlugin(var3.pluginClass);
         }

         var2.privateInitialize(this.ctx, this.app, this.app.getPreferences());
         this.pluginMap.put(var1, var2);
      }

      return var2;
   }

   public void init() {
      LOG.method_2(TAG, "init()");
      this.onPause(false);
      this.onDestroy();
      this.pluginMap.clear();
      this.startupPlugins();
   }

   @Deprecated
   public void loadPlugins() {
   }

   public void onDestroy() {
      Iterator var1 = this.pluginMap.values().iterator();

      while(var1.hasNext()) {
         ((CordovaPlugin)var1.next()).onDestroy();
      }

   }

   public void onNewIntent(Intent var1) {
      Iterator var2 = this.pluginMap.values().iterator();

      while(var2.hasNext()) {
         ((CordovaPlugin)var2.next()).onNewIntent(var1);
      }

   }

   public boolean onOverrideUrlLoading(String var1) {
      Iterator var2 = this.entryMap.values().iterator();

      while(true) {
         while(var2.hasNext()) {
            PluginEntry var3 = (PluginEntry)var2.next();
            List var4 = (List)this.urlMap.get(var3.service);
            if(var4 != null) {
               Iterator var6 = var4.iterator();

               while(var6.hasNext()) {
                  if(var1.startsWith((String)var6.next())) {
                     return this.getPlugin(var3.service).onOverrideUrlLoading(var1);
                  }
               }
            } else {
               CordovaPlugin var5 = (CordovaPlugin)this.pluginMap.get(var3.service);
               if(var5 != null && var5.onOverrideUrlLoading(var1)) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   public void onPause(boolean var1) {
      Iterator var2 = this.pluginMap.values().iterator();

      while(var2.hasNext()) {
         ((CordovaPlugin)var2.next()).onPause(var1);
      }

   }

   public void onReset() {
      Iterator var1 = this.pluginMap.values().iterator();

      while(var1.hasNext()) {
         ((CordovaPlugin)var1.next()).onReset();
      }

   }

   public void onResume(boolean var1) {
      Iterator var2 = this.pluginMap.values().iterator();

      while(var2.hasNext()) {
         ((CordovaPlugin)var2.next()).onResume(var1);
      }

   }

   public Object postMessage(String var1, Object var2) {
      Object var3 = this.ctx.onMessage(var1, var2);
      if(var3 != null) {
         return var3;
      } else {
         Iterator var4 = this.pluginMap.values().iterator();

         Object var5;
         do {
            if(!var4.hasNext()) {
               return null;
            }

            var5 = ((CordovaPlugin)var4.next()).onMessage(var1, var2);
         } while(var5 == null);

         return var5;
      }
   }

   Uri remapUri(Uri var1) {
      Iterator var2 = this.pluginMap.values().iterator();

      Uri var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = ((CordovaPlugin)var2.next()).remapUri(var1);
      } while(var3 == null);

      return var3;
   }

   public void setPluginEntries(List<PluginEntry> var1) {
      this.onPause(false);
      this.onDestroy();
      this.pluginMap.clear();
      this.urlMap.clear();
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         this.addService((PluginEntry)var2.next());
      }

   }

   @Deprecated
   public void startupPlugins() {
      Iterator var1 = this.entryMap.values().iterator();

      while(var1.hasNext()) {
         PluginEntry var2 = (PluginEntry)var1.next();
         if(var2.onload) {
            this.getPlugin(var2.service);
         }
      }

   }
}
