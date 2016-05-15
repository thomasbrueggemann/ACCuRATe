package com.parse;

import bolts.Task;
import com.parse.ParseException;
import com.parse.ParseExecutors;
import com.parse.ParseRequest;
import com.parse.ProgressCallback;
import com.parse.http.ParseHttpRequest;
import com.parse.http.ParseHttpResponse;
import java.io.File;
import java.util.concurrent.Callable;

class ParseAWSRequest extends ParseRequest<Void> {
   private final File tempFile;

   public ParseAWSRequest(ParseHttpRequest.Method var1, String var2, File var3) {
      super(var1, var2);
      this.tempFile = var3;
   }

   // $FF: synthetic method
   static File access$000(ParseAWSRequest var0) {
      return var0.tempFile;
   }

   protected Task<Void> onResponseAsync(final ParseHttpResponse var1, final ProgressCallback var2) {
      int var3 = var1.getStatusCode();
      if((var3 < 200 || var3 >= 300) && var3 != 304) {
         String var4;
         if(this.method == ParseHttpRequest.Method.GET) {
            var4 = "Download from";
         } else {
            var4 = "Upload to";
         }

         Object[] var5 = new Object[]{var4, var1.getReasonPhrase()};
         return Task.forError(new ParseException(100, String.format("%s S3 failed. %s", var5)));
      } else {
         return this.method != ParseHttpRequest.Method.GET?null:Task.call(new Callable() {
            public Void call() throws Exception {
               // $FF: Couldn't be decompiled
            }
         }, ParseExecutors.method_369());
      }
   }
}
