package com.parse;

import bolts.Task;
import com.parse.LocalIdManager;
import com.parse.NoObjectsEncoder;
import com.parse.ParseCorePlugins;
import com.parse.ParseDigestUtils;
import com.parse.ParseHttpClient;
import com.parse.ParseRequest;
import com.parse.ProgressCallback;
import com.parse.http.ParseHttpBody;
import com.parse.http.ParseHttpRequest;
import com.parse.http.ParseHttpResponse;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

class ParseRESTCommand extends ParseRequest<JSONObject> {
   static final String HEADER_APPLICATION_ID = "X-Parse-Application-Id";
   static final String HEADER_APP_BUILD_VERSION = "X-Parse-App-Build-Version";
   static final String HEADER_APP_DISPLAY_VERSION = "X-Parse-App-Display-Version";
   static final String HEADER_CLIENT_KEY = "X-Parse-Client-Key";
   static final String HEADER_CLIENT_VERSION = "X-Parse-Client-Version";
   static final String HEADER_INSTALLATION_ID = "X-Parse-Installation-Id";
   private static final String HEADER_MASTER_KEY = "X-Parse-Master-Key";
   static final String HEADER_OS_VERSION = "X-Parse-OS-Version";
   private static final String HEADER_SESSION_TOKEN = "X-Parse-Session-Token";
   private static final String PARAMETER_METHOD_OVERRIDE = "_method";
   static final String USER_AGENT = "User-Agent";
   static URL server = null;
   String httpPath;
   private String installationId;
   final JSONObject jsonParameters;
   private String localId;
   public String masterKey;
   private String operationSetUUID;
   private final String sessionToken;

   ParseRESTCommand(ParseRESTCommand.Init<?> var1) {
      super(var1.method, createUrl(var1.httpPath));
      this.sessionToken = var1.sessionToken;
      this.installationId = var1.installationId;
      this.masterKey = var1.masterKey;
      this.httpPath = var1.httpPath;
      this.jsonParameters = var1.jsonParameters;
      this.operationSetUUID = var1.operationSetUUID;
      this.localId = var1.localId;
   }

   public ParseRESTCommand(String var1, ParseHttpRequest.Method var2, Map<String, ?> var3, String var4) {
      JSONObject var5;
      if(var3 != null) {
         var5 = (JSONObject)NoObjectsEncoder.get().encode(var3);
      } else {
         var5 = null;
      }

      this(var1, var2, var5, var4);
   }

   public ParseRESTCommand(String var1, ParseHttpRequest.Method var2, JSONObject var3, String var4) {
      this(var1, var2, var3, (String)null, var4);
   }

   private ParseRESTCommand(String var1, ParseHttpRequest.Method var2, JSONObject var3, String var4, String var5) {
      super(var2, createUrl(var1));
      this.httpPath = var1;
      this.jsonParameters = var3;
      this.localId = var4;
      this.sessionToken = var5;
   }

   private static void addToStringer(JSONStringer var0, Object var1) throws JSONException {
      if(var1 instanceof JSONObject) {
         var0.object();
         JSONObject var8 = (JSONObject)var1;
         Iterator var9 = var8.keys();
         ArrayList var10 = new ArrayList();

         while(var9.hasNext()) {
            var10.add(var9.next());
         }

         Collections.sort(var10);
         Iterator var11 = var10.iterator();

         while(var11.hasNext()) {
            String var13 = (String)var11.next();
            var0.key(var13);
            addToStringer(var0, var8.opt(var13));
         }

         var0.endObject();
      } else if(!(var1 instanceof JSONArray)) {
         var0.value(var1);
      } else {
         JSONArray var3 = (JSONArray)var1;
         var0.array();

         for(int var5 = 0; var5 < var3.length(); ++var5) {
            addToStringer(var0, var3.get(var5));
         }

         var0.endArray();
      }
   }

   private static String createUrl(String var0) {
      if(var0 == null) {
         return server.toString();
      } else {
         try {
            String var2 = (new URL(server, var0)).toString();
            return var2;
         } catch (MalformedURLException var3) {
            throw new RuntimeException(var3);
         }
      }
   }

   public static ParseRESTCommand fromJSONObject(JSONObject var0) {
      String var1 = var0.optString("httpPath");
      ParseHttpRequest.Method var2 = ParseHttpRequest.Method.fromString(var0.optString("httpMethod"));
      String var3 = var0.optString("sessionToken", (String)null);
      String var4 = var0.optString("localId", (String)null);
      return new ParseRESTCommand(var1, var2, var0.optJSONObject("parameters"), var4, var3);
   }

   private static LocalIdManager getLocalIdManager() {
      return ParseCorePlugins.getInstance().getLocalIdManager();
   }

   protected static void getLocalPointersIn(Object var0, ArrayList<JSONObject> var1) throws JSONException {
      if(var0 instanceof JSONObject) {
         JSONObject var4 = (JSONObject)var0;
         if("Pointer".equals(var4.opt("__type")) && var4.has("localId")) {
            var1.add((JSONObject)var0);
            return;
         }

         Iterator var5 = var4.keys();

         while(var5.hasNext()) {
            getLocalPointersIn(var4.get((String)var5.next()), var1);
         }
      }

      if(var0 instanceof JSONArray) {
         JSONArray var2 = (JSONArray)var0;

         for(int var3 = 0; var3 < var2.length(); ++var3) {
            getLocalPointersIn(var2.get(var3), var1);
         }
      }

   }

   static boolean isValidCommandJSONObject(JSONObject var0) {
      return var0.has("httpPath");
   }

   static boolean isValidOldFormatCommandJSONObject(JSONObject var0) {
      return var0.has("op");
   }

   private void maybeChangeServerOperation() throws JSONException {
      if(this.localId != null) {
         String var1 = getLocalIdManager().getObjectId(this.localId);
         if(var1 != null) {
            this.localId = null;
            this.httpPath = this.httpPath + String.format("/%s", new Object[]{var1});
            this.url = createUrl(this.httpPath);
            if(this.httpPath.startsWith("classes") && this.method == ParseHttpRequest.Method.POST) {
               this.method = ParseHttpRequest.Method.PUT;
            }
         }
      }

   }

   static String toDeterministicString(Object var0) throws JSONException {
      JSONStringer var1 = new JSONStringer();
      addToStringer(var1, var0);
      return var1.toString();
   }

   protected void addAdditionalHeaders(ParseHttpRequest.Builder var1) {
      if(this.installationId != null) {
         var1.addHeader("X-Parse-Installation-Id", this.installationId);
      }

      if(this.sessionToken != null) {
         var1.addHeader("X-Parse-Session-Token", this.sessionToken);
      }

      if(this.masterKey != null) {
         var1.addHeader("X-Parse-Master-Key", this.masterKey);
      }

   }

   void enableRetrying() {
      this.setMaxRetries(4);
   }

   public Task<JSONObject> executeAsync(ParseHttpClient var1, ProgressCallback var2, ProgressCallback var3, Task<Void> var4) {
      this.resolveLocalIds();
      return super.executeAsync(var1, var2, var3, var4);
   }

   public String getCacheKey() {
      String var1;
      if(this.jsonParameters != null) {
         String var4;
         try {
            var4 = toDeterministicString(this.jsonParameters);
         } catch (JSONException var5) {
            throw new RuntimeException(var5.getMessage());
         }

         var1 = var4;
      } else {
         var1 = "";
      }

      if(this.sessionToken != null) {
         var1 = var1 + this.sessionToken;
      }

      Object[] var2 = new Object[]{this.method.toString(), ParseDigestUtils.md5(this.httpPath), ParseDigestUtils.md5(var1)};
      return String.format("ParseRESTCommand.%s.%s.%s", var2);
   }

   public String getLocalId() {
      return this.localId;
   }

   public String getOperationSetUUID() {
      return this.operationSetUUID;
   }

   public String getSessionToken() {
      return this.sessionToken;
   }

   protected ParseHttpBody newBody(ProgressCallback param1) {
      // $FF: Couldn't be decompiled
   }

   protected ParseHttpRequest newRequest(ParseHttpRequest.Method var1, String var2, ProgressCallback var3) {
      ParseHttpRequest var4;
      if(this.jsonParameters != null && var1 != ParseHttpRequest.Method.POST && var1 != ParseHttpRequest.Method.PUT) {
         var4 = super.newRequest(ParseHttpRequest.Method.POST, var2, var3);
      } else {
         var4 = super.newRequest(var1, var2, var3);
      }

      ParseHttpRequest.Builder var5 = new ParseHttpRequest.Builder(var4);
      this.addAdditionalHeaders(var5);
      return var5.build();
   }

   protected Task<JSONObject> onResponseAsync(ParseHttpResponse param1, ProgressCallback param2) {
      // $FF: Couldn't be decompiled
   }

   public void releaseLocalIds() {
      // $FF: Couldn't be decompiled
   }

   public void resolveLocalIds() {
      // $FF: Couldn't be decompiled
   }

   public void retainLocalIds() {
      // $FF: Couldn't be decompiled
   }

   public void setLocalId(String var1) {
      this.localId = var1;
   }

   void setOperationSetUUID(String var1) {
      this.operationSetUUID = var1;
   }

   public JSONObject toJSONObject() {
      JSONObject var1 = new JSONObject();

      try {
         if(this.httpPath != null) {
            var1.put("httpPath", this.httpPath);
         }

         var1.put("httpMethod", this.method.toString());
         if(this.jsonParameters != null) {
            var1.put("parameters", this.jsonParameters);
         }

         if(this.sessionToken != null) {
            var1.put("sessionToken", this.sessionToken);
         }

         if(this.localId != null) {
            var1.put("localId", this.localId);
         }

         return var1;
      } catch (JSONException var3) {
         throw new RuntimeException(var3.getMessage());
      }
   }

   public static class Builder extends ParseRESTCommand.Init<ParseRESTCommand.Builder> {
      public ParseRESTCommand build() {
         return new ParseRESTCommand(this);
      }

      ParseRESTCommand.Builder self() {
         return this;
      }
   }

   abstract static class Init<T extends ParseRESTCommand.Init<T>> {
      private String httpPath;
      private String installationId;
      private JSONObject jsonParameters;
      private String localId;
      public String masterKey;
      private ParseHttpRequest.Method method;
      private String operationSetUUID;
      private String sessionToken;

      Init() {
         this.method = ParseHttpRequest.Method.GET;
      }

      public T httpPath(String var1) {
         this.httpPath = var1;
         return this.self();
      }

      public T installationId(String var1) {
         this.installationId = var1;
         return this.self();
      }

      public T jsonParameters(JSONObject var1) {
         this.jsonParameters = var1;
         return this.self();
      }

      public T localId(String var1) {
         this.localId = var1;
         return this.self();
      }

      public T masterKey(String var1) {
         this.masterKey = var1;
         return this.self();
      }

      public T method(ParseHttpRequest.Method var1) {
         this.method = var1;
         return this.self();
      }

      public T operationSetUUID(String var1) {
         this.operationSetUUID = var1;
         return this.self();
      }

      abstract T self();

      public T sessionToken(String var1) {
         this.sessionToken = var1;
         return this.self();
      }
   }
}
