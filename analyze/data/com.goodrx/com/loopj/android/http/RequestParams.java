package com.loopj.android.http;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonStreamerEntity;
import com.loopj.android.http.ResponseHandlerInterface;
import com.loopj.android.http.SimpleMultipartEntity;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.client.entity.UrlEncodedFormEntity;
import cz.msebera.android.httpclient.client.utils.URLEncodedUtils;
import cz.msebera.android.httpclient.message.BasicNameValuePair;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class RequestParams implements Serializable {
   protected String contentEncoding;
   protected String elapsedFieldInJsonStreamer;
   protected final ConcurrentHashMap<String, List<RequestParams.FileWrapper>> fileArrayParams;
   protected final ConcurrentHashMap<String, RequestParams.FileWrapper> fileParams;
   protected boolean forceMultipartEntity;
   protected boolean isRepeatable;
   protected final ConcurrentHashMap<String, RequestParams.StreamWrapper> streamParams;
   protected final ConcurrentHashMap<String, String> urlParams;
   protected final ConcurrentHashMap<String, Object> urlParamsWithObjects;
   protected boolean useJsonStreamer;

   public RequestParams() {
      this((Map)null);
   }

   public RequestParams(final String var1, final String var2) {
      this(new HashMap() {
         {
            this.put(var1, var2);
         }
      });
   }

   public RequestParams(Map<String, String> var1) {
      this.urlParams = new ConcurrentHashMap();
      this.streamParams = new ConcurrentHashMap();
      this.fileParams = new ConcurrentHashMap();
      this.fileArrayParams = new ConcurrentHashMap();
      this.urlParamsWithObjects = new ConcurrentHashMap();
      this.forceMultipartEntity = false;
      this.elapsedFieldInJsonStreamer = "_elapsed";
      this.contentEncoding = "UTF-8";
      if(var1 != null) {
         Iterator var2 = var1.entrySet().iterator();

         while(var2.hasNext()) {
            Entry var3 = (Entry)var2.next();
            this.put((String)var3.getKey(), (String)var3.getValue());
         }
      }

   }

   private HttpEntity createFormEntity() {
      try {
         UrlEncodedFormEntity var1 = new UrlEncodedFormEntity(this.getParamsList(), this.contentEncoding);
         return var1;
      } catch (UnsupportedEncodingException var3) {
         AsyncHttpClient.log.method_4("RequestParams", "createFormEntity failed", var3);
         return null;
      }
   }

   private HttpEntity createJsonStreamerEntity(ResponseHandlerInterface var1) throws IOException {
      boolean var2;
      if(this.fileParams.isEmpty() && this.streamParams.isEmpty()) {
         var2 = false;
      } else {
         var2 = true;
      }

      JsonStreamerEntity var3 = new JsonStreamerEntity(var1, var2, this.elapsedFieldInJsonStreamer);
      Iterator var4 = this.urlParams.entrySet().iterator();

      while(var4.hasNext()) {
         Entry var12 = (Entry)var4.next();
         var3.addPart((String)var12.getKey(), var12.getValue());
      }

      Iterator var5 = this.urlParamsWithObjects.entrySet().iterator();

      while(var5.hasNext()) {
         Entry var11 = (Entry)var5.next();
         var3.addPart((String)var11.getKey(), var11.getValue());
      }

      Iterator var6 = this.fileParams.entrySet().iterator();

      while(var6.hasNext()) {
         Entry var10 = (Entry)var6.next();
         var3.addPart((String)var10.getKey(), var10.getValue());
      }

      Iterator var7 = this.streamParams.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         RequestParams.StreamWrapper var9 = (RequestParams.StreamWrapper)var8.getValue();
         if(var9.inputStream != null) {
            var3.addPart((String)var8.getKey(), RequestParams.StreamWrapper.newInstance(var9.inputStream, var9.name, var9.contentType, var9.autoClose));
         }
      }

      return var3;
   }

   private HttpEntity createMultipartEntity(ResponseHandlerInterface var1) throws IOException {
      SimpleMultipartEntity var2 = new SimpleMultipartEntity(var1);
      var2.setIsRepeatable(this.isRepeatable);
      Iterator var3 = this.urlParams.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var16 = (Entry)var3.next();
         var2.addPartWithCharset((String)var16.getKey(), (String)var16.getValue(), this.contentEncoding);
      }

      Iterator var4 = this.getParamsList((String)null, this.urlParamsWithObjects).iterator();

      while(var4.hasNext()) {
         BasicNameValuePair var15 = (BasicNameValuePair)var4.next();
         var2.addPartWithCharset(var15.getName(), var15.getValue(), this.contentEncoding);
      }

      Iterator var5 = this.streamParams.entrySet().iterator();

      while(var5.hasNext()) {
         Entry var13 = (Entry)var5.next();
         RequestParams.StreamWrapper var14 = (RequestParams.StreamWrapper)var13.getValue();
         if(var14.inputStream != null) {
            var2.addPart((String)var13.getKey(), var14.name, var14.inputStream, var14.contentType);
         }
      }

      Iterator var6 = this.fileParams.entrySet().iterator();

      while(var6.hasNext()) {
         Entry var11 = (Entry)var6.next();
         RequestParams.FileWrapper var12 = (RequestParams.FileWrapper)var11.getValue();
         var2.addPart((String)var11.getKey(), var12.file, var12.contentType, var12.customFileName);
      }

      Iterator var7 = this.fileArrayParams.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         Iterator var9 = ((List)var8.getValue()).iterator();

         while(var9.hasNext()) {
            RequestParams.FileWrapper var10 = (RequestParams.FileWrapper)var9.next();
            var2.addPart((String)var8.getKey(), var10.file, var10.contentType, var10.customFileName);
         }
      }

      return var2;
   }

   private List<BasicNameValuePair> getParamsList(String var1, Object var2) {
      LinkedList var3 = new LinkedList();
      if(var2 instanceof Map) {
         Map var19 = (Map)var2;
         ArrayList var20 = new ArrayList(var19.keySet());
         if(var20.size() > 0 && var20.get(0) instanceof Comparable) {
            Collections.sort(var20);
         }

         Iterator var21 = var20.iterator();

         while(var21.hasNext()) {
            Object var22 = var21.next();
            if(var22 instanceof String) {
               Object var23 = var19.get(var22);
               if(var23 != null) {
                  String var24;
                  if(var1 == null) {
                     var24 = (String)var22;
                  } else {
                     var24 = String.format(Locale.US, "%s[%s]", new Object[]{var1, var22});
                  }

                  var3.addAll(this.getParamsList(var24, var23));
               }
            }
         }
      } else if(var2 instanceof List) {
         List var13 = (List)var2;
         int var14 = var13.size();

         for(int var15 = 0; var15 < var14; ++var15) {
            Locale var16 = Locale.US;
            Object[] var17 = new Object[]{var1, Integer.valueOf(var15)};
            var3.addAll(this.getParamsList(String.format(var16, "%s[%d]", var17), var13.get(var15)));
         }
      } else if(var2 instanceof Object[]) {
         Object[] var7 = (Object[])((Object[])var2);
         int var8 = var7.length;

         for(int var9 = 0; var9 < var8; ++var9) {
            Locale var10 = Locale.US;
            Object[] var11 = new Object[]{var1, Integer.valueOf(var9)};
            var3.addAll(this.getParamsList(String.format(var10, "%s[%d]", var11), var7[var9]));
         }
      } else if(var2 instanceof Set) {
         Iterator var5 = ((Set)var2).iterator();

         while(var5.hasNext()) {
            var3.addAll(this.getParamsList(var1, var5.next()));
         }
      } else {
         var3.add(new BasicNameValuePair(var1, var2.toString()));
      }

      return var3;
   }

   public void add(String var1, String var2) {
      if(var1 != null && var2 != null) {
         Object var3 = this.urlParamsWithObjects.get(var1);
         if(var3 == null) {
            var3 = new HashSet();
            this.put(var1, var3);
         }

         if(var3 instanceof List) {
            ((List)var3).add(var2);
         } else if(var3 instanceof Set) {
            ((Set)var3).add(var2);
            return;
         }
      }

   }

   public HttpEntity getEntity(ResponseHandlerInterface var1) throws IOException {
      return this.useJsonStreamer?this.createJsonStreamerEntity(var1):(!this.forceMultipartEntity && this.streamParams.isEmpty() && this.fileParams.isEmpty() && this.fileArrayParams.isEmpty()?this.createFormEntity():this.createMultipartEntity(var1));
   }

   protected String getParamString() {
      return URLEncodedUtils.format(this.getParamsList(), this.contentEncoding);
   }

   protected List<BasicNameValuePair> getParamsList() {
      LinkedList var1 = new LinkedList();
      Iterator var2 = this.urlParams.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var4 = (Entry)var2.next();
         var1.add(new BasicNameValuePair((String)var4.getKey(), (String)var4.getValue()));
      }

      var1.addAll(this.getParamsList((String)null, this.urlParamsWithObjects));
      return var1;
   }

   public void put(String var1, int var2) {
      if(var1 != null) {
         this.urlParams.put(var1, String.valueOf(var2));
      }

   }

   public void put(String var1, File var2, String var3) throws FileNotFoundException {
      this.put(var1, var2, var3, (String)null);
   }

   public void put(String var1, File var2, String var3, String var4) throws FileNotFoundException {
      if(var2 != null && var2.exists()) {
         if(var1 != null) {
            this.fileParams.put(var1, new RequestParams.FileWrapper(var2, var3, var4));
         }

      } else {
         throw new FileNotFoundException();
      }
   }

   public void put(String var1, Object var2) {
      if(var1 != null && var2 != null) {
         this.urlParamsWithObjects.put(var1, var2);
      }

   }

   public void put(String var1, String var2) {
      if(var1 != null && var2 != null) {
         this.urlParams.put(var1, var2);
      }

   }

   public void remove(String var1) {
      this.urlParams.remove(var1);
      this.streamParams.remove(var1);
      this.fileParams.remove(var1);
      this.urlParamsWithObjects.remove(var1);
      this.fileArrayParams.remove(var1);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      Iterator var2 = this.urlParams.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var27 = (Entry)var2.next();
         if(var1.length() > 0) {
            var1.append("&");
         }

         var1.append((String)var27.getKey());
         var1.append("=");
         var1.append((String)var27.getValue());
      }

      Iterator var3 = this.streamParams.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var22 = (Entry)var3.next();
         if(var1.length() > 0) {
            var1.append("&");
         }

         var1.append((String)var22.getKey());
         var1.append("=");
         var1.append("STREAM");
      }

      Iterator var4 = this.fileParams.entrySet().iterator();

      while(var4.hasNext()) {
         Entry var17 = (Entry)var4.next();
         if(var1.length() > 0) {
            var1.append("&");
         }

         var1.append((String)var17.getKey());
         var1.append("=");
         var1.append("FILE");
      }

      Iterator var5 = this.fileArrayParams.entrySet().iterator();

      while(var5.hasNext()) {
         Entry var12 = (Entry)var5.next();
         if(var1.length() > 0) {
            var1.append("&");
         }

         var1.append((String)var12.getKey());
         var1.append("=");
         var1.append("FILES(SIZE=").append(((List)var12.getValue()).size()).append(")");
      }

      Iterator var6 = this.getParamsList((String)null, this.urlParamsWithObjects).iterator();

      while(var6.hasNext()) {
         BasicNameValuePair var7 = (BasicNameValuePair)var6.next();
         if(var1.length() > 0) {
            var1.append("&");
         }

         var1.append(var7.getName());
         var1.append("=");
         var1.append(var7.getValue());
      }

      return var1.toString();
   }

   public static class FileWrapper implements Serializable {
      public final String contentType;
      public final String customFileName;
      public final File file;

      public FileWrapper(File var1, String var2, String var3) {
         this.file = var1;
         this.contentType = var2;
         this.customFileName = var3;
      }
   }

   public static class StreamWrapper {
      public final boolean autoClose;
      public final String contentType;
      public final InputStream inputStream;
      public final String name;

      public StreamWrapper(InputStream var1, String var2, String var3, boolean var4) {
         this.inputStream = var1;
         this.name = var2;
         this.contentType = var3;
         this.autoClose = var4;
      }

      static RequestParams.StreamWrapper newInstance(InputStream var0, String var1, String var2, boolean var3) {
         if(var2 == null) {
            var2 = "application/octet-stream";
         }

         return new RequestParams.StreamWrapper(var0, var1, var2, var3);
      }
   }
}
