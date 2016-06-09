package com.koushikdutta.async.http.libcore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public final class RawHeaders {
   private static final Comparator<String> FIELD_NAME_COMPARATOR = new Comparator() {
      public int compare(String var1, String var2) {
         return var1 == var2?0:(var1 == null?-1:(var2 == null?1:String.CASE_INSENSITIVE_ORDER.compare(var1, var2)));
      }
   };
   private int httpMinorVersion = 1;
   private final List<String> namesAndValues = new ArrayList(20);
   private int responseCode = -1;
   private String responseMessage;
   private String statusLine;

   public RawHeaders() {
   }

   public RawHeaders(RawHeaders var1) {
      this.copy(var1);
   }

   public static RawHeaders fromMultimap(Map<String, List<String>> var0) {
      RawHeaders var1 = new RawHeaders();
      Iterator var2 = var0.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         String var4 = (String)var3.getKey();
         List var5 = (List)var3.getValue();
         if(var4 != null) {
            var1.addAll(var4, var5);
         } else if(!var5.isEmpty()) {
            var1.setStatusLine((String)var5.get(-1 + var5.size()));
         }
      }

      return var1;
   }

   public void add(String var1, String var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("fieldName == null");
      } else if(var2 == null) {
         System.err.println("Ignoring HTTP header field \'" + var1 + "\' because its value is null");
      } else {
         this.namesAndValues.add(var1);
         this.namesAndValues.add(var2.trim());
      }
   }

   public void addAll(String var1, List<String> var2) {
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         this.add(var1, (String)var3.next());
      }

   }

   public void addLine(String var1) {
      int var2 = var1.indexOf(":");
      if(var2 == -1) {
         this.add("", var1);
      } else {
         this.add(var1.substring(0, var2), var1.substring(var2 + 1));
      }
   }

   public void copy(RawHeaders var1) {
      this.namesAndValues.addAll(var1.namesAndValues);
      this.statusLine = var1.statusLine;
      this.httpMinorVersion = var1.httpMinorVersion;
      this.responseCode = var1.responseCode;
      this.responseMessage = var1.responseMessage;
   }

   public String get(String var1) {
      for(int var2 = -2 + this.namesAndValues.size(); var2 >= 0; var2 -= 2) {
         if(var1.equalsIgnoreCase((String)this.namesAndValues.get(var2))) {
            return (String)this.namesAndValues.get(var2 + 1);
         }
      }

      return null;
   }

   public RawHeaders getAll(Set<String> var1) {
      RawHeaders var2 = new RawHeaders();

      for(int var3 = 0; var3 < this.namesAndValues.size(); var3 += 2) {
         String var4 = (String)this.namesAndValues.get(var3);
         if(var1.contains(var4)) {
            var2.add(var4, (String)this.namesAndValues.get(var3 + 1));
         }
      }

      return var2;
   }

   public String getFieldName(int var1) {
      int var2 = var1 * 2;
      return var2 >= 0 && var2 < this.namesAndValues.size()?(String)this.namesAndValues.get(var2):null;
   }

   public int getHttpMinorVersion() {
      return this.httpMinorVersion != -1?this.httpMinorVersion:1;
   }

   public int getResponseCode() {
      return this.responseCode;
   }

   public String getResponseMessage() {
      return this.responseMessage;
   }

   public String getStatusLine() {
      return this.statusLine;
   }

   public String getValue(int var1) {
      int var2 = 1 + var1 * 2;
      return var2 >= 0 && var2 < this.namesAndValues.size()?(String)this.namesAndValues.get(var2):null;
   }

   public int length() {
      return this.namesAndValues.size() / 2;
   }

   public void removeAll(String var1) {
      for(int var2 = 0; var2 < this.namesAndValues.size(); var2 += 2) {
         if(var1.equalsIgnoreCase((String)this.namesAndValues.get(var2))) {
            this.namesAndValues.remove(var2);
            this.namesAndValues.remove(var2);
         }
      }

   }

   public void set(String var1, String var2) {
      this.removeAll(var1);
      this.add(var1, var2);
   }

   public void setStatusLine(String var1) {
      String var2 = var1.trim();
      this.statusLine = var2;
      if(var2 != null && var2.startsWith("HTTP/")) {
         String var3 = var2.trim();
         int var4 = 1 + var3.indexOf(" ");
         if(var4 != 0) {
            if(var3.charAt(var4 - 2) != 49) {
               this.httpMinorVersion = 0;
            }

            int var5 = var4 + 3;
            if(var5 > var3.length()) {
               var5 = var3.length();
            }

            this.responseCode = Integer.parseInt(var3.substring(var4, var5));
            if(var5 + 1 <= var3.length()) {
               this.responseMessage = var3.substring(var5 + 1);
               return;
            }
         }
      }

   }

   public String toHeaderString() {
      StringBuilder var1 = new StringBuilder(256);
      var1.append(this.statusLine).append("\r\n");

      for(int var3 = 0; var3 < this.namesAndValues.size(); var3 += 2) {
         var1.append((String)this.namesAndValues.get(var3)).append(": ").append((String)this.namesAndValues.get(var3 + 1)).append("\r\n");
      }

      var1.append("\r\n");
      return var1.toString();
   }

   public Map<String, List<String>> toMultimap() {
      TreeMap var1 = new TreeMap(FIELD_NAME_COMPARATOR);

      for(int var2 = 0; var2 < this.namesAndValues.size(); var2 += 2) {
         String var4 = (String)this.namesAndValues.get(var2);
         String var5 = (String)this.namesAndValues.get(var2 + 1);
         ArrayList var6 = new ArrayList();
         List var7 = (List)var1.get(var4);
         if(var7 != null) {
            var6.addAll(var7);
         }

         var6.add(var5);
         var1.put(var4, Collections.unmodifiableList(var6));
      }

      if(this.statusLine != null) {
         var1.put((Object)null, Collections.unmodifiableList(Collections.singletonList(this.statusLine)));
      }

      return Collections.unmodifiableMap(var1);
   }
}
