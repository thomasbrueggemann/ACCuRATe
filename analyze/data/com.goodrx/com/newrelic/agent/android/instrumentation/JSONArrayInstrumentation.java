package com.newrelic.agent.android.instrumentation;

import com.newrelic.agent.android.instrumentation.MetricCategory;
import com.newrelic.agent.android.instrumentation.ReplaceCallSite;
import com.newrelic.agent.android.instrumentation.TraceConstructor;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;

public class JSONArrayInstrumentation {
   private static final ArrayList<String> categoryParams;

   static {
      String[] var0 = new String[]{"category", MetricCategory.class.getName(), "JSON"};
      categoryParams = new ArrayList(Arrays.asList(var0));
   }

   @TraceConstructor
   public static JSONArray init(String var0) throws JSONException {
      try {
         TraceMachine.enterMethod("JSONArray#<init>", categoryParams);
         JSONArray var2 = new JSONArray(var0);
         TraceMachine.exitMethod();
         return var2;
      } catch (JSONException var3) {
         TraceMachine.exitMethod();
         throw var3;
      }
   }

   @ReplaceCallSite(
      scope = "org.json.JSONArray"
   )
   public static String toString(JSONArray var0) {
      TraceMachine.enterMethod("JSONArray#toString", categoryParams);
      String var1 = var0.toString();
      TraceMachine.exitMethod();
      return var1;
   }

   @ReplaceCallSite(
      scope = "org.json.JSONArray"
   )
   public static String toString(JSONArray var0, int var1) throws JSONException {
      try {
         TraceMachine.enterMethod("JSONArray#toString", categoryParams);
         String var3 = var0.toString(var1);
         TraceMachine.exitMethod();
         return var3;
      } catch (JSONException var4) {
         TraceMachine.exitMethod();
         throw var4;
      }
   }
}
