package org.apache.cordova;

import android.app.Activity;
import android.os.Bundle;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.apache.cordova.LOG;

public class CordovaPreferences {
   private Bundle preferencesBundleExtras;
   private HashMap<String, String> prefs = new HashMap(20);

   public void copyIntoIntentExtras(Activity var1) {
      Iterator var2 = this.prefs.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         String var4 = (String)this.prefs.get(var3);
         if(var4 != null) {
            if(var3.equals("loglevel")) {
               LOG.setLogLevel(var4);
            } else if(var3.equals("splashscreen")) {
               int var18 = var1.getResources().getIdentifier(var4, "drawable", var1.getClass().getPackage().getName());
               var1.getIntent().putExtra(var3, var18);
            } else if(var3.equals("backgroundcolor")) {
               int var16 = (int)Long.decode(var4).longValue();
               var1.getIntent().putExtra(var3, var16);
            } else if(var3.equals("loadurltimeoutvalue")) {
               int var14 = Integer.decode(var4).intValue();
               var1.getIntent().putExtra(var3, var14);
            } else if(var3.equals("splashscreendelay")) {
               int var12 = Integer.decode(var4).intValue();
               var1.getIntent().putExtra(var3, var12);
            } else if(var3.equals("keeprunning")) {
               boolean var10 = Boolean.parseBoolean(var4);
               var1.getIntent().putExtra(var3, var10);
            } else if(var3.equals("inappbrowserstorageenabled")) {
               boolean var8 = Boolean.parseBoolean(var4);
               var1.getIntent().putExtra(var3, var8);
            } else if(var3.equals("disallowoverscroll")) {
               boolean var6 = Boolean.parseBoolean(var4);
               var1.getIntent().putExtra(var3, var6);
            } else {
               var1.getIntent().putExtra(var3, var4);
            }
         }
      }

      if(this.preferencesBundleExtras == null) {
         this.preferencesBundleExtras = var1.getIntent().getExtras();
      }

   }

   public Map<String, String> getAll() {
      return this.prefs;
   }

   public boolean getBoolean(String var1, boolean var2) {
      String var3 = var1.toLowerCase(Locale.ENGLISH);
      String var4 = (String)this.prefs.get(var3);
      if(var4 != null) {
         var2 = Boolean.parseBoolean(var4);
      } else if(this.preferencesBundleExtras != null) {
         Object var5 = this.preferencesBundleExtras.get(var3);
         if(var5 instanceof String) {
            return "true".equals(var5);
         }

         return this.preferencesBundleExtras.getBoolean(var3, var2);
      }

      return var2;
   }

   public double getDouble(String var1, double var2) {
      String var4 = var1.toLowerCase(Locale.ENGLISH);
      String var5 = (String)this.prefs.get(var4);
      if(var5 != null) {
         var2 = Double.valueOf(var5).doubleValue();
      } else if(this.preferencesBundleExtras != null) {
         Object var6 = this.preferencesBundleExtras.get(var4);
         if(var6 instanceof String) {
            return Double.valueOf((String)var6).doubleValue();
         }

         return this.preferencesBundleExtras.getDouble(var4, var2);
      }

      return var2;
   }

   public int getInteger(String var1, int var2) {
      String var3 = var1.toLowerCase(Locale.ENGLISH);
      String var4 = (String)this.prefs.get(var3);
      if(var4 != null) {
         var2 = (int)Long.decode(var4).longValue();
      } else if(this.preferencesBundleExtras != null) {
         Object var5 = this.preferencesBundleExtras.get(var3);
         if(var5 instanceof String) {
            return Integer.valueOf((String)var5).intValue();
         }

         return this.preferencesBundleExtras.getInt(var3, var2);
      }

      return var2;
   }

   public String getString(String var1, String var2) {
      String var3 = var1.toLowerCase(Locale.ENGLISH);
      String var4 = (String)this.prefs.get(var3);
      if(var4 != null) {
         return var4;
      } else {
         if(this.preferencesBundleExtras != null && !"errorurl".equals(var3)) {
            Object var5 = this.preferencesBundleExtras.get(var3);
            if(var5 != null) {
               return var5.toString();
            }
         }

         return var2;
      }
   }

   public void set(String var1, double var2) {
      this.set(var1, "" + var2);
   }

   public void set(String var1, int var2) {
      this.set(var1, "" + var2);
   }

   public void set(String var1, String var2) {
      this.prefs.put(var1.toLowerCase(Locale.ENGLISH), var2);
   }

   public void set(String var1, boolean var2) {
      this.set(var1, "" + var2);
   }

   public void setPreferencesBundle(Bundle var1) {
      this.preferencesBundleExtras = var1;
   }
}
