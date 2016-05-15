package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.ReasonPhraseCatalog;
import cz.msebera.android.httpclient.util.Args;
import java.util.Locale;

public class EnglishReasonPhraseCatalog implements ReasonPhraseCatalog {
   public static final EnglishReasonPhraseCatalog INSTANCE = new EnglishReasonPhraseCatalog();
   private static final String[][] REASON_PHRASES;

   static {
      String[][] var0 = new String[][]{null, new String[3], new String[8], new String[8], new String[25], new String[8]};
      REASON_PHRASES = var0;
      setReason(200, "OK");
      setReason(201, "Created");
      setReason(202, "Accepted");
      setReason(204, "No Content");
      setReason(301, "Moved Permanently");
      setReason(302, "Moved Temporarily");
      setReason(304, "Not Modified");
      setReason(400, "Bad Request");
      setReason(401, "Unauthorized");
      setReason(403, "Forbidden");
      setReason(404, "Not Found");
      setReason(500, "Internal Server Error");
      setReason(501, "Not Implemented");
      setReason(502, "Bad Gateway");
      setReason(503, "Service Unavailable");
      setReason(100, "Continue");
      setReason(307, "Temporary Redirect");
      setReason(405, "Method Not Allowed");
      setReason(409, "Conflict");
      setReason(412, "Precondition Failed");
      setReason(413, "Request Too Long");
      setReason(414, "Request-URI Too Long");
      setReason(415, "Unsupported Media Type");
      setReason(300, "Multiple Choices");
      setReason(303, "See Other");
      setReason(305, "Use Proxy");
      setReason(402, "Payment Required");
      setReason(406, "Not Acceptable");
      setReason(407, "Proxy Authentication Required");
      setReason(408, "Request Timeout");
      setReason(101, "Switching Protocols");
      setReason(203, "Non Authoritative Information");
      setReason(205, "Reset Content");
      setReason(206, "Partial Content");
      setReason(504, "Gateway Timeout");
      setReason(505, "Http Version Not Supported");
      setReason(410, "Gone");
      setReason(411, "Length Required");
      setReason(416, "Requested Range Not Satisfiable");
      setReason(417, "Expectation Failed");
      setReason(102, "Processing");
      setReason(207, "Multi-Status");
      setReason(422, "Unprocessable Entity");
      setReason(419, "Insufficient Space On Resource");
      setReason(420, "Method Failure");
      setReason(423, "Locked");
      setReason(507, "Insufficient Storage");
      setReason(424, "Failed Dependency");
   }

   private static void setReason(int var0, String var1) {
      int var2 = var0 / 100;
      int var3 = var0 - var2 * 100;
      REASON_PHRASES[var2][var3] = var1;
   }

   public String getReason(int var1, Locale var2) {
      boolean var3;
      if(var1 >= 100 && var1 < 600) {
         var3 = true;
      } else {
         var3 = false;
      }

      Args.check(var3, "Unknown category for status code " + var1);
      int var4 = var1 / 100;
      int var5 = var1 - var4 * 100;
      int var6 = REASON_PHRASES[var4].length;
      String var7 = null;
      if(var6 > var5) {
         var7 = REASON_PHRASES[var4][var5];
      }

      return var7;
   }
}
