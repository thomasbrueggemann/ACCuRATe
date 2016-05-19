package com.parse;

import bolts.Continuation;
import bolts.Task;
import com.parse.ConfigCallback;
import com.parse.ParseCallback2;
import com.parse.ParseConfigController;
import com.parse.ParseCorePlugins;
import com.parse.ParseDecoder;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseGeoPoint;
import com.parse.ParseTaskUtils;
import com.parse.ParseUser;
import com.parse.PointerEncoder;
import com.parse.TaskQueue;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class ParseConfig {
   static final TaskQueue taskQueue = new TaskQueue();
   final Map<String, Object> params;

   ParseConfig() {
      this.params = Collections.unmodifiableMap(new HashMap());
   }

   ParseConfig(Map<String, Object> var1) {
      this.params = Collections.unmodifiableMap(var1);
   }

   static ParseConfig decode(JSONObject var0, ParseDecoder var1) {
      Map var2 = (Map)((Map)var1.decode(var0)).get("params");
      if(var2 == null) {
         throw new RuntimeException("Object did not contain the \'params\' key.");
      } else {
         return new ParseConfig(var2);
      }
   }

   public static ParseConfig get() throws ParseException {
      return (ParseConfig)ParseTaskUtils.wait(getInBackground());
   }

   private static Task<ParseConfig> getAsync(final Task<Void> var0) {
      return ParseUser.getCurrentSessionTokenAsync().onSuccessTask(new Continuation() {
         public Task<ParseConfig> then(Task<String> var1) throws Exception {
            final String var2 = (String)var1.getResult();
            return var0.continueWithTask(new Continuation() {
               public Task<ParseConfig> then(Task<Void> var1) throws Exception {
                  return ParseConfig.getConfigController().getAsync(var2);
               }
            });
         }
      });
   }

   static ParseConfigController getConfigController() {
      return ParseCorePlugins.getInstance().getConfigController();
   }

   public static ParseConfig getCurrentConfig() {
      try {
         ParseConfig var1 = (ParseConfig)ParseTaskUtils.wait(getConfigController().getCurrentConfigController().getCurrentConfigAsync());
         return var1;
      } catch (ParseException var2) {
         return new ParseConfig();
      }
   }

   public static Task<ParseConfig> getInBackground() {
      return taskQueue.enqueue(new Continuation() {
         public Task<ParseConfig> then(Task<Void> var1) throws Exception {
            return ParseConfig.getAsync(var1);
         }
      });
   }

   public static void getInBackground(ConfigCallback var0) {
      ParseTaskUtils.callbackOnMainThreadAsync(getInBackground(), (ParseCallback2)var0);
   }

   public Object get(String var1) {
      return this.get(var1, (Object)null);
   }

   public Object get(String var1, Object var2) {
      return !this.params.containsKey(var1)?var2:(this.params.get(var1) == JSONObject.NULL?null:this.params.get(var1));
   }

   public boolean getBoolean(String var1) {
      return this.getBoolean(var1, false);
   }

   public boolean getBoolean(String var1, boolean var2) {
      if(this.params.containsKey(var1)) {
         Object var3 = this.params.get(var1);
         if(var3 instanceof Boolean) {
            return ((Boolean)var3).booleanValue();
         }
      }

      return var2;
   }

   public Date getDate(String var1) {
      return this.getDate(var1, (Date)null);
   }

   public Date getDate(String var1, Date var2) {
      if(!this.params.containsKey(var1)) {
         return var2;
      } else {
         Object var3 = this.params.get(var1);
         if(var3 != null && var3 != JSONObject.NULL) {
            Date var4;
            if(var3 instanceof Date) {
               var4 = (Date)var3;
            } else {
               var4 = var2;
            }

            return var4;
         } else {
            return null;
         }
      }
   }

   public double getDouble(String var1) {
      return this.getDouble(var1, 0.0D);
   }

   public double getDouble(String var1, double var2) {
      Number var4 = this.getNumber(var1);
      if(var4 != null) {
         var2 = var4.doubleValue();
      }

      return var2;
   }

   public int getInt(String var1) {
      return this.getInt(var1, 0);
   }

   public int getInt(String var1, int var2) {
      Number var3 = this.getNumber(var1);
      if(var3 != null) {
         var2 = var3.intValue();
      }

      return var2;
   }

   public JSONArray getJSONArray(String var1) {
      return this.getJSONArray(var1, (JSONArray)null);
   }

   public JSONArray getJSONArray(String var1, JSONArray var2) {
      List var3 = this.getList(var1);
      Object var4;
      if(var3 != null) {
         var4 = PointerEncoder.get().encode(var3);
      } else {
         var4 = null;
      }

      if(var4 == null || var4 instanceof JSONArray) {
         var2 = (JSONArray)var4;
      }

      return var2;
   }

   public JSONObject getJSONObject(String var1) {
      return this.getJSONObject(var1, (JSONObject)null);
   }

   public JSONObject getJSONObject(String var1, JSONObject var2) {
      Map var3 = this.getMap(var1);
      Object var4;
      if(var3 != null) {
         var4 = PointerEncoder.get().encode(var3);
      } else {
         var4 = null;
      }

      if(var4 == null || var4 instanceof JSONObject) {
         var2 = (JSONObject)var4;
      }

      return var2;
   }

   public <T> List<T> getList(String var1) {
      return this.getList(var1, (List)null);
   }

   public <T> List<T> getList(String var1, List<T> var2) {
      if(!this.params.containsKey(var1)) {
         return var2;
      } else {
         Object var3 = this.params.get(var1);
         if(var3 != null && var3 != JSONObject.NULL) {
            List var4;
            if(var3 instanceof List) {
               var4 = (List)var3;
            } else {
               var4 = var2;
            }

            return var4;
         } else {
            return null;
         }
      }
   }

   public long getLong(String var1) {
      return this.getLong(var1, 0L);
   }

   public long getLong(String var1, long var2) {
      Number var4 = this.getNumber(var1);
      if(var4 != null) {
         var2 = var4.longValue();
      }

      return var2;
   }

   public <V> Map<String, V> getMap(String var1) {
      return this.getMap(var1, (Map)null);
   }

   public <V> Map<String, V> getMap(String var1, Map<String, V> var2) {
      if(!this.params.containsKey(var1)) {
         return var2;
      } else {
         Object var3 = this.params.get(var1);
         if(var3 != null && var3 != JSONObject.NULL) {
            Map var4;
            if(var3 instanceof Map) {
               var4 = (Map)var3;
            } else {
               var4 = var2;
            }

            return var4;
         } else {
            return null;
         }
      }
   }

   public Number getNumber(String var1) {
      return this.getNumber(var1, (Number)null);
   }

   public Number getNumber(String var1, Number var2) {
      if(!this.params.containsKey(var1)) {
         return var2;
      } else {
         Object var3 = this.params.get(var1);
         if(var3 != null && var3 != JSONObject.NULL) {
            Number var4;
            if(var3 instanceof Number) {
               var4 = (Number)var3;
            } else {
               var4 = var2;
            }

            return var4;
         } else {
            return null;
         }
      }
   }

   Map<String, Object> getParams() {
      return Collections.unmodifiableMap(new HashMap(this.params));
   }

   public ParseFile getParseFile(String var1) {
      return this.getParseFile(var1, (ParseFile)null);
   }

   public ParseFile getParseFile(String var1, ParseFile var2) {
      if(!this.params.containsKey(var1)) {
         return var2;
      } else {
         Object var3 = this.params.get(var1);
         if(var3 != null && var3 != JSONObject.NULL) {
            ParseFile var4;
            if(var3 instanceof ParseFile) {
               var4 = (ParseFile)var3;
            } else {
               var4 = var2;
            }

            return var4;
         } else {
            return null;
         }
      }
   }

   public ParseGeoPoint getParseGeoPoint(String var1) {
      return this.getParseGeoPoint(var1, (ParseGeoPoint)null);
   }

   public ParseGeoPoint getParseGeoPoint(String var1, ParseGeoPoint var2) {
      if(!this.params.containsKey(var1)) {
         return var2;
      } else {
         Object var3 = this.params.get(var1);
         if(var3 != null && var3 != JSONObject.NULL) {
            ParseGeoPoint var4;
            if(var3 instanceof ParseGeoPoint) {
               var4 = (ParseGeoPoint)var3;
            } else {
               var4 = var2;
            }

            return var4;
         } else {
            return null;
         }
      }
   }

   public String getString(String var1) {
      return this.getString(var1, (String)null);
   }

   public String getString(String var1, String var2) {
      if(!this.params.containsKey(var1)) {
         return var2;
      } else {
         Object var3 = this.params.get(var1);
         if(var3 != null && var3 != JSONObject.NULL) {
            String var4;
            if(var3 instanceof String) {
               var4 = (String)var3;
            } else {
               var4 = var2;
            }

            return var4;
         } else {
            return null;
         }
      }
   }

   public String toString() {
      return "ParseConfig[" + this.params.toString() + "]";
   }
}
