package org.apache.cordova;

import android.net.Uri;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

public class Whitelist {
   public static final String TAG = "Whitelist";
   private ArrayList<Whitelist.URLPattern> whiteList = new ArrayList();

   public void addWhiteListEntry(String param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   public boolean isUrlWhiteListed(String var1) {
      if(this.whiteList == null) {
         return true;
      } else {
         Uri var2 = Uri.parse(var1);
         Iterator var3 = this.whiteList.iterator();

         do {
            if(!var3.hasNext()) {
               return false;
            }
         } while(!((Whitelist.URLPattern)var3.next()).matches(var2));

         return true;
      }
   }

   private static class URLPattern {
      public Pattern host;
      public Pattern path;
      public Integer port;
      public Pattern scheme;

      public URLPattern(String param1, String param2, String param3, String param4) throws MalformedURLException {
         // $FF: Couldn't be decompiled
      }

      private String regexFromPattern(String var1, boolean var2) {
         StringBuilder var3 = new StringBuilder();

         for(int var4 = 0; var4 < var1.length(); ++var4) {
            char var5 = var1.charAt(var4);
            if(var5 == 42 && var2) {
               var3.append(".");
            } else if("\\.[]{}()^$?+|".indexOf(var5) > -1) {
               var3.append('\\');
            }

            var3.append(var5);
         }

         return var3.toString();
      }

      public boolean matches(Uri param1) {
         // $FF: Couldn't be decompiled
      }
   }
}
