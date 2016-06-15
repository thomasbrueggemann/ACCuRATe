package org.apache.cordova;

import android.util.Base64;
import org.json.JSONArray;
import org.json.JSONObject;

public class PluginResult {
   public static final int MESSAGE_TYPE_ARRAYBUFFER = 6;
   public static final int MESSAGE_TYPE_BINARYSTRING = 7;
   public static final int MESSAGE_TYPE_BOOLEAN = 4;
   public static final int MESSAGE_TYPE_JSON = 2;
   public static final int MESSAGE_TYPE_NULL = 5;
   public static final int MESSAGE_TYPE_NUMBER = 3;
   public static final int MESSAGE_TYPE_STRING = 1;
   public static String[] StatusMessages = new String[]{"No result", "OK", "Class not found", "Illegal access", "Instantiation error", "Malformed url", "IO error", "Invalid action", "JSON error", "Error"};
   private String encodedMessage;
   private boolean keepCallback;
   private final int messageType;
   private final int status;
   private String strMessage;

   public PluginResult(PluginResult.Status var1) {
      this(var1, StatusMessages[var1.ordinal()]);
   }

   public PluginResult(PluginResult.Status var1, float var2) {
      this.keepCallback = false;
      this.status = var1.ordinal();
      this.messageType = 3;
      this.encodedMessage = "" + var2;
   }

   public PluginResult(PluginResult.Status var1, int var2) {
      this.keepCallback = false;
      this.status = var1.ordinal();
      this.messageType = 3;
      this.encodedMessage = "" + var2;
   }

   public PluginResult(PluginResult.Status var1, String var2) {
      this.keepCallback = false;
      this.status = var1.ordinal();
      byte var3;
      if(var2 == null) {
         var3 = 5;
      } else {
         var3 = 1;
      }

      this.messageType = var3;
      this.strMessage = var2;
   }

   public PluginResult(PluginResult.Status var1, JSONArray var2) {
      this.keepCallback = false;
      this.status = var1.ordinal();
      this.messageType = 2;
      this.encodedMessage = var2.toString();
   }

   public PluginResult(PluginResult.Status var1, JSONObject var2) {
      this.keepCallback = false;
      this.status = var1.ordinal();
      this.messageType = 2;
      this.encodedMessage = var2.toString();
   }

   public PluginResult(PluginResult.Status var1, boolean var2) {
      this.keepCallback = false;
      this.status = var1.ordinal();
      this.messageType = 4;
      this.encodedMessage = Boolean.toString(var2);
   }

   public PluginResult(PluginResult.Status var1, byte[] var2) {
      this(var1, var2, false);
   }

   public PluginResult(PluginResult.Status var1, byte[] var2, boolean var3) {
      this.keepCallback = false;
      this.status = var1.ordinal();
      byte var4;
      if(var3) {
         var4 = 7;
      } else {
         var4 = 6;
      }

      this.messageType = var4;
      this.encodedMessage = Base64.encodeToString(var2, 2);
   }

   @Deprecated
   public String getJSONString() {
      return "{\"status\":" + this.status + ",\"message\":" + this.getMessage() + ",\"keepCallback\":" + this.keepCallback + "}";
   }

   public boolean getKeepCallback() {
      return this.keepCallback;
   }

   public String getMessage() {
      if(this.encodedMessage == null) {
         this.encodedMessage = JSONObject.quote(this.strMessage);
      }

      return this.encodedMessage;
   }

   public int getMessageType() {
      return this.messageType;
   }

   public int getStatus() {
      return this.status;
   }

   public String getStrMessage() {
      return this.strMessage;
   }

   public void setKeepCallback(boolean var1) {
      this.keepCallback = var1;
   }

   @Deprecated
   public String toCallbackString(String var1) {
      return this.status == PluginResult.Status.NO_RESULT.ordinal() && this.keepCallback?null:(this.status != PluginResult.Status.field_13.ordinal() && this.status != PluginResult.Status.NO_RESULT.ordinal()?this.toErrorCallbackString(var1):this.toSuccessCallbackString(var1));
   }

   @Deprecated
   public String toErrorCallbackString(String var1) {
      return "cordova.callbackError(\'" + var1 + "\', " + this.getJSONString() + ");";
   }

   @Deprecated
   public String toSuccessCallbackString(String var1) {
      return "cordova.callbackSuccess(\'" + var1 + "\'," + this.getJSONString() + ");";
   }

   public static enum Status {
      CLASS_NOT_FOUND_EXCEPTION,
      ERROR,
      ILLEGAL_ACCESS_EXCEPTION,
      INSTANTIATION_EXCEPTION,
      INVALID_ACTION,
      IO_EXCEPTION,
      JSON_EXCEPTION,
      MALFORMED_URL_EXCEPTION,
      NO_RESULT,
      // $FF: renamed from: OK org.apache.cordova.PluginResult$Status
      field_13;

      static {
         PluginResult.Status[] var0 = new PluginResult.Status[]{NO_RESULT, field_13, CLASS_NOT_FOUND_EXCEPTION, ILLEGAL_ACCESS_EXCEPTION, INSTANTIATION_EXCEPTION, MALFORMED_URL_EXCEPTION, IO_EXCEPTION, INVALID_ACTION, JSON_EXCEPTION, ERROR};
      }
   }
}
