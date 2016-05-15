package com.comscore.metrics;

import android.content.Context;
import android.os.Build.VERSION;
import com.comscore.analytics.Core;
import com.comscore.measurement.Measurement;
import com.comscore.metrics.class_55;
import com.comscore.utils.CSLog;
import com.comscore.utils.Connectivity;
import com.comscore.utils.Date;
import com.comscore.utils.Permissions;
import com.comscore.utils.Storage;
import com.comscore.utils.TransmissionMode;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.net.Proxy.Type;

public class Request {
   public static final boolean REDIRECTION_SUPPORTED;
   // $FF: renamed from: a java.net.URL
   protected URL field_385;
   // $FF: renamed from: b java.net.Proxy
   protected Proxy field_386;
   // $FF: renamed from: c com.comscore.measurement.Measurement
   private Measurement field_387;
   // $FF: renamed from: d com.comscore.analytics.Core
   private Core field_388;
   // $FF: renamed from: e com.comscore.utils.Storage
   private Storage field_389;

   static {
      int var0 = VERSION.SDK_INT;
      boolean var1;
      if(var0 >= 11 && var0 <= 13) {
         var1 = false;
      } else {
         var1 = true;
      }

      REDIRECTION_SUPPORTED = var1;
   }

   public Request(Core var1, Measurement var2) {
      this.field_388 = var1;
      this.field_389 = var1.getStorage();
      this.field_387 = var2;
      this.field_385 = this.process();
   }

   // $FF: renamed from: a (java.lang.String) java.net.Proxy
   private static Proxy method_273(String var0) {
      int var1 = var0.indexOf(58);
      int var2;
      if(var1 != -1) {
         String var3 = var0.substring(0, var1);
         var2 = Integer.parseInt(var0.substring(var1 + 1));
         var0 = var3;
      } else {
         var2 = 80;
      }

      return new Proxy(Type.HTTP, new InetSocketAddress(var0, var2));
   }

   // $FF: renamed from: c () boolean
   private boolean method_274() {
      this.method_275();
      boolean var1 = this.method_279();
      if(!var1) {
         this.method_276();
      }

      return var1;
   }

   // $FF: renamed from: d () void
   private void method_275() {
      TransmissionMode var1 = this.field_388.getOfflineTransmissionMode();
      if(var1 == TransmissionMode.DEFAULT || var1 == TransmissionMode.WIFIONLY && Connectivity.isConnectedWiFi(this.field_388.getAppContext()) || var1 == TransmissionMode.PIGGYBACK) {
         this.field_388.getOfflineCache().flush();
      }

   }

   // $FF: renamed from: e () void
   private void method_276() {
      CSLog.method_374(this, "Measurement was not transmitted: " + this.field_387.retrieveLabelsAsString(this.field_388.getMeasurementLabelOrder()));
      this.field_388.getOfflineCache().saveEvent(this.field_387);
   }

   // $FF: renamed from: a (java.net.URL) java.net.HttpURLConnection
   protected HttpURLConnection method_277(URL var1) {
      HttpURLConnection var2;
      if(this.field_386 != null) {
         var2 = (HttpURLConnection)HttpInstrumentation.openConnectionWithProxy(var1.openConnection(this.field_386));
      } else {
         var2 = (HttpURLConnection)HttpInstrumentation.openConnection(var1.openConnection());
      }

      var2.setRequestProperty("Connection", "Close");
      return var2;
   }

   // $FF: renamed from: a (java.net.URL, int, java.lang.String) java.net.URL
   protected URL method_278(URL var1, int var2, String var3) {
      switch(var2) {
      case 300:
      case 301:
      case 302:
      case 303:
      case 305:
         if(var3 == null) {
            return null;
         } else if(var2 == 305) {
            boolean var5 = var3.startsWith(var1.getProtocol() + ':');
            int var6 = 0;
            if(var5) {
               var6 = 1 + var1.getProtocol().length();
            }

            if(var3.startsWith("//", var6)) {
               var6 += 2;
            }

            this.field_386 = method_273(var3.substring(var6));
            return var1;
         } else {
            URL var4 = new URL(var1, var3);
            if(!var1.getProtocol().equals(var4.getProtocol())) {
               return null;
            }

            return var4;
         }
      case 304:
      default:
         return null;
      }
   }

   // $FF: renamed from: a () boolean
   protected boolean method_279() {
      // $FF: Couldn't be decompiled
   }

   public Boolean availableConnection() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b () boolean
   protected boolean method_280() {
      return REDIRECTION_SUPPORTED;
   }

   public URL process() {
      return this.process(this.field_387.getPixelURL());
   }

   public URL process(String var1) {
      this.availableConnection();
      String var3 = var1.concat(this.field_387.retrieveLabelsAsString(this.field_388.getMeasurementLabelOrder()));
      String var4;
      if(var3.length() > 4096 && var3.indexOf("&") > 0) {
         int var8 = var3.substring(0, 4088).lastIndexOf("&");
         int var9 = var8 + 1;

         String var11;
         label26: {
            String var12;
            try {
               var12 = URLEncoder.encode(var3.substring(var9), "UTF-8").replace("+", "%20");
            } catch (UnsupportedEncodingException var14) {
               var11 = "0";
               break label26;
            }

            var11 = var12;
         }

         var4 = var3.substring(0, var8) + "&ns_cut=" + var11;
      } else {
         var4 = var3;
      }

      String var5;
      if(var4.length() > 4096) {
         var5 = var4.substring(0, 4096);
      } else {
         var5 = var4;
      }

      try {
         URL var6 = new URL(var5);
         return var6;
      } catch (MalformedURLException var13) {
         return null;
      }
   }

   public boolean send() {
      Context var1 = this.field_388.getAppContext();
      boolean var2 = Permissions.check(var1, "android.permission.ACCESS_NETWORK_STATE").booleanValue();
      TransmissionMode var3 = this.field_388.getLiveTransmissionMode();
      this.field_389.set("lastMeasurementProcessedTimestamp", String.valueOf(Date.unixTime()));
      switch(class_55.field_460[var3.ordinal()]) {
      case 1:
         this.method_276();
         return false;
      case 2:
         this.method_276();
         return false;
      case 3:
         if(var2 && !this.availableConnection().booleanValue()) {
            this.method_276();
            return false;
         }

         return this.method_274();
      case 4:
         if(var2 && !Connectivity.isEmulator() && !Connectivity.isConnectedWiFi(var1) && !Connectivity.isConnectEthernet(var1)) {
            this.method_276();
            return false;
         }

         return this.method_274();
      case 5:
         if(var2 && !Connectivity.isEmulator() && !Connectivity.isConnectedWiFi(var1) && !Connectivity.isDataConnected(var1)) {
            this.method_276();
            return false;
         }

         return this.method_274();
      default:
         return false;
      }
   }
}
