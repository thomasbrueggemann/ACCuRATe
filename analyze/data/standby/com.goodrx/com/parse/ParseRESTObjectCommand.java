package com.parse;

import android.net.Uri;
import com.parse.ParseObject;
import com.parse.ParseRESTCommand;
import com.parse.http.ParseHttpRequest;
import org.json.JSONObject;

class ParseRESTObjectCommand extends ParseRESTCommand {
   public ParseRESTObjectCommand(String var1, ParseHttpRequest.Method var2, JSONObject var3, String var4) {
      super(var1, var2, var3, var4);
   }

   private static ParseRESTObjectCommand createObjectCommand(String var0, JSONObject var1, String var2) {
      Object[] var3 = new Object[]{Uri.encode(var0)};
      return new ParseRESTObjectCommand(String.format("classes/%s", var3), ParseHttpRequest.Method.POST, var1, var2);
   }

   public static ParseRESTObjectCommand deleteObjectCommand(ParseObject.State var0, String var1) {
      Object[] var2 = new Object[]{Uri.encode(var0.className())};
      String var3 = String.format("classes/%s", var2);
      String var4 = var0.objectId();
      if(var4 != null) {
         StringBuilder var5 = (new StringBuilder()).append(var3);
         Object[] var6 = new Object[]{Uri.encode(var4)};
         var3 = var5.append(String.format("/%s", var6)).toString();
      }

      return new ParseRESTObjectCommand(var3, ParseHttpRequest.Method.DELETE, (JSONObject)null, var1);
   }

   public static ParseRESTObjectCommand getObjectCommand(String var0, String var1, String var2) {
      Object[] var3 = new Object[]{Uri.encode(var1), Uri.encode(var0)};
      return new ParseRESTObjectCommand(String.format("classes/%s/%s", var3), ParseHttpRequest.Method.GET, (JSONObject)null, var2);
   }

   public static ParseRESTObjectCommand saveObjectCommand(ParseObject.State var0, JSONObject var1, String var2) {
      return var0.objectId() == null?createObjectCommand(var0.className(), var1, var2):updateObjectCommand(var0.objectId(), var0.className(), var1, var2);
   }

   private static ParseRESTObjectCommand updateObjectCommand(String var0, String var1, JSONObject var2, String var3) {
      Object[] var4 = new Object[]{Uri.encode(var1), Uri.encode(var0)};
      return new ParseRESTObjectCommand(String.format("classes/%s/%s", var4), ParseHttpRequest.Method.PUT, var2, var3);
   }
}
