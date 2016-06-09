package com.koushikdutta.async.http;

import android.net.Uri;
import com.koushikdutta.async.http.libcore.RawHeaders;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class Multimap extends Hashtable<String, List<String>> implements Iterable<NameValuePair> {
   public Multimap() {
   }

   public Multimap(RawHeaders var1) {
      var1.toMultimap().putAll(this);
   }

   public Multimap(List<NameValuePair> var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         NameValuePair var3 = (NameValuePair)var2.next();
         this.add(var3.getName(), var3.getValue());
      }

   }

   public static Multimap parseHeader(RawHeaders var0, String var1) {
      return parseHeader(var0.get(var1));
   }

   public static Multimap parseHeader(String var0) {
      Multimap var1 = new Multimap();
      String[] var2 = var0.split(";");
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String[] var5 = var2[var4].split("=", 2);
         String var6 = var5[0].trim();
         int var7 = var5.length;
         String var8 = null;
         if(var7 > 1) {
            var8 = var5[1];
         }

         if(var8 != null && var8.endsWith("\"") && var8.startsWith("\"")) {
            var8 = var8.substring(1, -1 + var8.length());
         }

         var1.add(var6, var8);
      }

      return var1;
   }

   public static Multimap parseQuery(String var0) {
      Multimap var1 = new Multimap();
      String[] var2 = var0.split("&");
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String[] var5 = var2[var4].split("=", 2);
         if(var5.length != 0) {
            String var6 = Uri.decode(var5[0]);
            int var7 = var5.length;
            String var8 = null;
            if(var7 == 2) {
               var8 = Uri.decode(var5[1]);
            }

            var1.add(var6, var8);
         }
      }

      return var1;
   }

   public void add(String var1, String var2) {
      Object var3 = (List)this.get(var1);
      if(var3 == null) {
         var3 = new ArrayList();
         this.put(var1, var3);
      }

      ((List)var3).add(var2);
   }

   public String getString(String var1) {
      List var2 = (List)this.get(var1);
      return var2 != null && var2.size() != 0?(String)var2.get(0):null;
   }

   public Iterator<NameValuePair> iterator() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         Iterator var4 = ((List)this.get(var3)).iterator();

         while(var4.hasNext()) {
            var1.add(new BasicNameValuePair(var3, (String)var4.next()));
         }
      }

      return var1.iterator();
   }

   public void put(String var1, String var2) {
      ArrayList var3 = new ArrayList();
      var3.add(var2);
      this.put(var1, var3);
   }
}
