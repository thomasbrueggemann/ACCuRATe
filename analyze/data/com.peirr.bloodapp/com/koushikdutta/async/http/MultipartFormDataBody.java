package com.koushikdutta.async.http;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.LineEmitter;
import com.koushikdutta.async.NullDataCallback;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.ContinuationCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.future.Continuation;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.AsyncHttpRequestBody;
import com.koushikdutta.async.http.FilePart;
import com.koushikdutta.async.http.Multimap;
import com.koushikdutta.async.http.Part;
import com.koushikdutta.async.http.StringPart;
import com.koushikdutta.async.http.libcore.RawHeaders;
import com.koushikdutta.async.http.server.BoundaryEmitter;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class MultipartFormDataBody extends BoundaryEmitter implements AsyncHttpRequestBody<Multimap> {
   public static final String CONTENT_TYPE = "multipart/form-data";
   RawHeaders formData;
   ByteBufferList last;
   String lastName;
   LineEmitter liner;
   MultipartFormDataBody.MultipartCallback mCallback;
   private ArrayList<Part> mParts;
   int totalToWrite;
   int written;

   public MultipartFormDataBody() {
   }

   public MultipartFormDataBody(String var1, String[] var2) {
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String[] var5 = var2[var4].split("=");
         if(var5.length == 2 && "boundary".equals(var5[0])) {
            this.setBoundary(var5[1]);
            return;
         }
      }

      this.report(new Exception("No boundary found for multipart/form-data"));
   }

   public void addFilePart(String var1, File var2) {
      this.addPart(new FilePart(var1, var2));
   }

   public void addPart(Part var1) {
      if(this.mParts == null) {
         this.mParts = new ArrayList();
      }

      this.mParts.add(var1);
   }

   public void addStringPart(String var1, String var2) {
      this.addPart(new StringPart(var1, var2));
   }

   public Multimap get() {
      return new Multimap(this.formData);
   }

   public String getContentType() {
      if(this.getBoundary() == null) {
         this.setBoundary("----------------------------" + UUID.randomUUID().toString().replace("-", ""));
      }

      return "multipart/form-data; boundary=" + this.getBoundary();
   }

   public String getField(String var1) {
      return this.formData == null?null:this.formData.get(var1);
   }

   public MultipartFormDataBody.MultipartCallback getMultipartCallback() {
      return this.mCallback;
   }

   void handleLast() {
      if(this.last != null) {
         if(this.formData == null) {
            this.formData = new RawHeaders();
         }

         this.formData.add(this.lastName, this.last.peekString());
         this.lastName = null;
         this.last = null;
      }
   }

   public int length() {
      if(this.getBoundary() == null) {
         this.setBoundary("----------------------------" + UUID.randomUUID().toString().replace("-", ""));
      }

      int var1 = 0;

      Part var4;
      for(Iterator var2 = this.mParts.iterator(); var2.hasNext(); var1 += var4.length() + var4.getRawHeaders().toHeaderString().getBytes().length + "\r\n".length()) {
         var4 = (Part)var2.next();
         var4.getRawHeaders().setStatusLine(this.getBoundaryStart());
         if(var4.length() == -1) {
            return -1;
         }
      }

      int var3 = var1 + (this.getBoundaryEnd() + "\r\n").getBytes().length;
      this.totalToWrite = var3;
      return var3;
   }

   protected void onBoundaryEnd() {
      super.onBoundaryEnd();
      this.handleLast();
   }

   protected void onBoundaryStart() {
      final RawHeaders var1 = new RawHeaders();
      this.liner = new LineEmitter();
      this.liner.setLineCallback(new LineEmitter.StringCallback() {
         public void onStringAvailable(String var1x) {
            if(!"\r".equals(var1x)) {
               var1.addLine(var1x);
            } else {
               MultipartFormDataBody.this.handleLast();
               MultipartFormDataBody.this.liner = null;
               MultipartFormDataBody.this.setDataCallback((DataCallback)null);
               Part var2 = new Part(var1);
               if(MultipartFormDataBody.this.mCallback != null) {
                  MultipartFormDataBody.this.mCallback.onPart(var2);
               }

               if(MultipartFormDataBody.this.getDataCallback() == null) {
                  if(var2.isFile()) {
                     MultipartFormDataBody.this.setDataCallback(new NullDataCallback());
                     return;
                  }

                  MultipartFormDataBody.this.lastName = var2.getName();
                  MultipartFormDataBody.this.last = new ByteBufferList();
                  MultipartFormDataBody.this.setDataCallback(new DataCallback() {
                     public void onDataAvailable(DataEmitter var1x, ByteBufferList var2) {
                        var2.get(MultipartFormDataBody.this.last);
                     }
                  });
                  return;
               }
            }

         }
      });
      this.setDataCallback(this.liner);
   }

   public void parse(DataEmitter var1, CompletedCallback var2) {
      this.setDataEmitter(var1);
      this.setEndCallback(var2);
   }

   public boolean readFullyOnRequest() {
      return false;
   }

   public void setMultipartCallback(MultipartFormDataBody.MultipartCallback var1) {
      this.mCallback = var1;
   }

   public void write(AsyncHttpRequest var1, final DataSink var2, final CompletedCallback var3) {
      if(this.mParts == null) {
         var2.end();
      } else {
         Continuation var4 = new Continuation(new CompletedCallback() {
            public void onCompleted(Exception var1) {
               var3.onCompleted(var1);
            }
         });
         Iterator var5 = this.mParts.iterator();

         while(var5.hasNext()) {
            final Part var8 = (Part)var5.next();
            var4.add(new ContinuationCallback() {
               public void onContinue(Continuation var1, CompletedCallback var2x) throws Exception {
                  var8.getRawHeaders().setStatusLine(MultipartFormDataBody.this.getBoundaryStart());
                  byte[] var3 = var8.getRawHeaders().toHeaderString().getBytes();
                  Util.writeAll(var2, var3, var2x);
                  MultipartFormDataBody var4 = MultipartFormDataBody.this;
                  var4.written += var3.length;
               }
            }).add(new ContinuationCallback() {
               public void onContinue(Continuation var1, CompletedCallback var2x) throws Exception {
                  MultipartFormDataBody var3 = MultipartFormDataBody.this;
                  var3.written += var8.length();
                  var8.write(var2, var2x);
               }
            }).add(new ContinuationCallback() {
               public void onContinue(Continuation var1, CompletedCallback var2x) throws Exception {
                  byte[] var3 = "\r\n".getBytes();
                  Util.writeAll(var2, var3, var2x);
                  MultipartFormDataBody var4 = MultipartFormDataBody.this;
                  var4.written += var3.length;
               }
            });
         }

         var4.add(new ContinuationCallback() {
            // $FF: synthetic field
            static final boolean $assertionsDisabled;

            static {
               boolean var0;
               if(!MultipartFormDataBody.class.desiredAssertionStatus()) {
                  var0 = true;
               } else {
                  var0 = false;
               }

               $assertionsDisabled = var0;
            }

            public void onContinue(Continuation var1, CompletedCallback var2x) throws Exception {
               byte[] var3 = (MultipartFormDataBody.this.getBoundaryEnd() + "\r\n").getBytes();
               Util.writeAll(var2, var3, var2x);
               MultipartFormDataBody var4 = MultipartFormDataBody.this;
               var4.written += var3.length;
               if(!$assertionsDisabled && MultipartFormDataBody.this.written != MultipartFormDataBody.this.totalToWrite) {
                  throw new AssertionError();
               }
            }
         });
         var4.start();
      }
   }

   public interface MultipartCallback {
      void onPart(Part var1);
   }
}
