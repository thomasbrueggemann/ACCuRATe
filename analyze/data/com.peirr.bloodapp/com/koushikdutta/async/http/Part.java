package com.koushikdutta.async.http;

import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.Multimap;
import com.koushikdutta.async.http.libcore.RawHeaders;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;

public class Part {
   // $FF: synthetic field
   static final boolean $assertionsDisabled = false;
   public static final String CONTENT_DISPOSITION = "Content-Disposition";
   private int length = -1;
   Multimap mContentDisposition;
   RawHeaders mHeaders;

   static {
      boolean var0;
      if(!Part.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
   }

   public Part(RawHeaders var1) {
      this.mHeaders = var1;
      this.mContentDisposition = Multimap.parseHeader(this.mHeaders, "Content-Disposition");
   }

   public Part(String var1, int var2, List<NameValuePair> var3) {
      this.length = var2;
      this.mHeaders = new RawHeaders();
      StringBuilder var4 = new StringBuilder(String.format("form-data; name=\"%s\"", new Object[]{var1}));
      if(var3 != null) {
         Iterator var5 = var3.iterator();

         while(var5.hasNext()) {
            NameValuePair var6 = (NameValuePair)var5.next();
            Object[] var7 = new Object[]{var6.getName(), var6.getValue()};
            var4.append(String.format("; %s=\"%s\"", var7));
         }
      }

      this.mHeaders.set("Content-Disposition", var4.toString());
      this.mContentDisposition = Multimap.parseHeader(this.mHeaders, "Content-Disposition");
   }

   public String getContentType() {
      return this.mHeaders.get("Content-Type");
   }

   public String getFilename() {
      String var1 = this.mContentDisposition.getString("filename");
      return var1 == null?null:(new File(var1)).getName();
   }

   public String getName() {
      return this.mContentDisposition.getString("name");
   }

   public RawHeaders getRawHeaders() {
      return this.mHeaders;
   }

   public boolean isFile() {
      return this.mContentDisposition.containsKey("filename");
   }

   public int length() {
      return this.length;
   }

   public void write(DataSink var1, CompletedCallback var2) {
      if(!$assertionsDisabled) {
         throw new AssertionError();
      }
   }
}
