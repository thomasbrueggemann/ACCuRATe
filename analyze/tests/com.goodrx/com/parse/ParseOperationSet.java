package com.parse;

import com.parse.ParseACL;
import com.parse.ParseDecoder;
import com.parse.ParseEncoder;
import com.parse.ParseFieldOperation;
import com.parse.ParseSetOperation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

class ParseOperationSet extends HashMap<String, ParseFieldOperation> {
   private static final String REST_KEY_IS_SAVE_EVENTUALLY = "__isSaveEventually";
   private static final String REST_KEY_UUID = "__uuid";
   private static final long serialVersionUID = 1L;
   private boolean isSaveEventually;
   private final String uuid;

   public ParseOperationSet() {
      this(UUID.randomUUID().toString());
   }

   public ParseOperationSet(ParseOperationSet var1) {
      super(var1);
      this.isSaveEventually = false;
      this.uuid = var1.getUUID();
      this.isSaveEventually = var1.isSaveEventually;
   }

   private ParseOperationSet(String var1) {
      this.isSaveEventually = false;
      this.uuid = var1;
   }

   public static ParseOperationSet fromRest(JSONObject var0, ParseDecoder var1) throws JSONException {
      Iterator var2 = var0.keys();
      String[] var3 = new String[var0.length()];

      int var16;
      for(int var4 = 0; var2.hasNext(); var4 = var16) {
         String var15 = (String)var2.next();
         var16 = var4 + 1;
         var3[var4] = var15;
      }

      JSONObject var5 = new JSONObject(var0, var3);
      String var6 = (String)var5.remove("__uuid");
      ParseOperationSet var7;
      if(var6 == null) {
         var7 = new ParseOperationSet();
      } else {
         var7 = new ParseOperationSet(var6);
      }

      boolean var8 = var5.optBoolean("__isSaveEventually");
      var5.remove("__isSaveEventually");
      var7.setIsSaveEventually(var8);

      String var11;
      Object var13;
      for(Iterator var10 = var5.keys(); var10.hasNext(); var7.put(var11, var13)) {
         var11 = (String)var10.next();
         Object var12 = var1.decode(var5.get(var11));
         if(var11.equals("ACL")) {
            var12 = ParseACL.createACLFromJSONObject(var5.getJSONObject(var11), var1);
         }

         if(var12 instanceof ParseFieldOperation) {
            var13 = (ParseFieldOperation)var12;
         } else {
            var13 = new ParseSetOperation(var12);
         }
      }

      return var7;
   }

   public String getUUID() {
      return this.uuid;
   }

   public boolean isSaveEventually() {
      return this.isSaveEventually;
   }

   public void mergeFrom(ParseOperationSet var1) {
      String var3;
      ParseFieldOperation var6;
      for(Iterator var2 = var1.keySet().iterator(); var2.hasNext(); this.put(var3, var6)) {
         var3 = (String)var2.next();
         ParseFieldOperation var4 = (ParseFieldOperation)var1.get(var3);
         ParseFieldOperation var5 = (ParseFieldOperation)this.get(var3);
         if(var5 != null) {
            var6 = var5.mergeWithPrevious(var4);
         } else {
            var6 = var4;
         }
      }

   }

   public void setIsSaveEventually(boolean var1) {
      this.isSaveEventually = var1;
   }

   public JSONObject toRest(ParseEncoder var1) throws JSONException {
      JSONObject var2 = new JSONObject();
      Iterator var3 = this.keySet().iterator();

      while(var3.hasNext()) {
         String var6 = (String)var3.next();
         var2.put(var6, ((ParseFieldOperation)this.get(var6)).encode(var1));
      }

      var2.put("__uuid", this.uuid);
      if(this.isSaveEventually) {
         var2.put("__isSaveEventually", true);
      }

      return var2;
   }
}
