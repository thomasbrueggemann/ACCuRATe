package org.apache.cordova;

import android.util.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CordovaArgs {
   private JSONArray baseArgs;

   public CordovaArgs(JSONArray var1) {
      this.baseArgs = var1;
   }

   public Object get(int var1) throws JSONException {
      return this.baseArgs.get(var1);
   }

   public byte[] getArrayBuffer(int var1) throws JSONException {
      return Base64.decode(this.baseArgs.getString(var1), 0);
   }

   public boolean getBoolean(int var1) throws JSONException {
      return this.baseArgs.getBoolean(var1);
   }

   public double getDouble(int var1) throws JSONException {
      return this.baseArgs.getDouble(var1);
   }

   public int getInt(int var1) throws JSONException {
      return this.baseArgs.getInt(var1);
   }

   public JSONArray getJSONArray(int var1) throws JSONException {
      return this.baseArgs.getJSONArray(var1);
   }

   public JSONObject getJSONObject(int var1) throws JSONException {
      return this.baseArgs.getJSONObject(var1);
   }

   public long getLong(int var1) throws JSONException {
      return this.baseArgs.getLong(var1);
   }

   public String getString(int var1) throws JSONException {
      return this.baseArgs.getString(var1);
   }

   public boolean isNull(int var1) {
      return this.baseArgs.isNull(var1);
   }

   public Object opt(int var1) {
      return this.baseArgs.opt(var1);
   }

   public boolean optBoolean(int var1) {
      return this.baseArgs.optBoolean(var1);
   }

   public double optDouble(int var1) {
      return this.baseArgs.optDouble(var1);
   }

   public int optInt(int var1) {
      return this.baseArgs.optInt(var1);
   }

   public JSONArray optJSONArray(int var1) {
      return this.baseArgs.optJSONArray(var1);
   }

   public JSONObject optJSONObject(int var1) {
      return this.baseArgs.optJSONObject(var1);
   }

   public long optLong(int var1) {
      return this.baseArgs.optLong(var1);
   }

   public String optString(int var1) {
      return this.baseArgs.optString(var1);
   }
}
