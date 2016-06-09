package com.comscore.analytics;

import android.content.Context;
import com.comscore.analytics.Core;
import com.comscore.analytics.comScore;
import com.comscore.applications.EventType;
import java.util.HashMap;

public class Census {
   // $FF: renamed from: a com.comscore.analytics.Census
   private static Census field_462 = null;
   // $FF: renamed from: c java.lang.Object
   private static Object field_463 = new Object();
   // $FF: renamed from: b java.lang.String
   private String field_464;

   public static Census getInstance() {
      // $FF: Couldn't be decompiled
   }

   public void notifyStart(Context var1, String var2, String var3) {
      Core var4 = comScore.getCore();
      var4.setAppContext(var1);
      if(var2 != null && var2.length() > 0) {
         this.field_464 = var2;
      }

      if(var3 != null && var3.length() > 0) {
         var4.setPublisherSecret(var3, true);
      }

      HashMap var5 = new HashMap();
      var5.put("c2", this.field_464);
      var5.put("name", "start");
      String var8;
      if(var4.isSecure()) {
         var8 = "https://sb.scorecardresearch.com/p2?";
      } else {
         var8 = "http://b.scorecardresearch.com/p2?";
      }

      var4.setPixelURL(var8, false);
      var4.notify(EventType.START, var5, true);
   }
}
