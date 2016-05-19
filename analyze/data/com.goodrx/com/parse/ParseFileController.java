package com.parse;

import bolts.Continuation;
import bolts.Task;
import com.parse.ParseAWSRequest;
import com.parse.ParseExecutors;
import com.parse.ParseFile;
import com.parse.ParseFileUtils;
import com.parse.ParseHttpClient;
import com.parse.ParseRESTFileCommand;
import com.parse.ProgressCallback;
import com.parse.http.ParseHttpRequest;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import org.json.JSONObject;

class ParseFileController {
   private ParseHttpClient awsClient;
   private final File cachePath;
   private final Object lock = new Object();
   private final ParseHttpClient restClient;

   public ParseFileController(ParseHttpClient var1, File var2) {
      this.restClient = var1;
      this.cachePath = var2;
   }

   ParseFileController awsClient(ParseHttpClient param1) {
      // $FF: Couldn't be decompiled
   }

   ParseHttpClient awsClient() {
      // $FF: Couldn't be decompiled
   }

   public void clearCache() {
      File[] var1 = this.cachePath.listFiles();
      if(var1 != null) {
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            ParseFileUtils.deleteQuietly(var1[var3]);
         }
      }

   }

   public Task<File> fetchAsync(final ParseFile.State var1, String var2, final ProgressCallback var3, final Task<Void> var4) {
      if(var4 != null && var4.isCancelled()) {
         return Task.cancelled();
      } else {
         final File var5 = this.getCacheFile(var1);
         return Task.call(new Callable() {
            public Boolean call() throws Exception {
               return Boolean.valueOf(var5.exists());
            }
         }, ParseExecutors.method_369()).continueWithTask(new Continuation() {
            public Task<File> then(Task<Boolean> var1x) throws Exception {
               if(((Boolean)var1x.getResult()).booleanValue()) {
                  return Task.forResult(var5);
               } else if(var4 != null && var4.isCancelled()) {
                  return Task.cancelled();
               } else {
                  final File var2 = ParseFileController.this.getTempFile(var1);
                  return (new ParseAWSRequest(ParseHttpRequest.Method.GET, var1.url(), var2)).executeAsync(ParseFileController.this.awsClient(), (ProgressCallback)null, var3, var4).continueWithTask(new Continuation() {
                     public Task<File> then(Task<Void> var1x) throws Exception {
                        if(var4 != null && var4.isCancelled()) {
                           throw new CancellationException();
                        } else if(var1x.isFaulted()) {
                           ParseFileUtils.deleteQuietly(var2);
                           return var1x.cast();
                        } else {
                           ParseFileUtils.deleteQuietly(var5);
                           ParseFileUtils.moveFile(var2, var5);
                           return Task.forResult(var5);
                        }
                     }
                  }, ParseExecutors.method_369());
               }
            }
         });
      }
   }

   public File getCacheFile(ParseFile.State var1) {
      return new File(this.cachePath, var1.name());
   }

   File getTempFile(ParseFile.State var1) {
      return var1.url() == null?null:new File(this.cachePath, var1.url() + ".tmp");
   }

   public boolean isDataAvailable(ParseFile.State var1) {
      return this.getCacheFile(var1).exists();
   }

   public Task<ParseFile.State> saveAsync(final ParseFile.State var1, final File var2, String var3, ProgressCallback var4, Task<Void> var5) {
      if(var1.url() != null) {
         return Task.forResult(var1);
      } else if(var5 != null && var5.isCancelled()) {
         return Task.cancelled();
      } else {
         ParseRESTFileCommand var6 = ((ParseRESTFileCommand.Builder)(new ParseRESTFileCommand.Builder()).fileName(var1.name()).file(var2).contentType(var1.mimeType()).sessionToken(var3)).build();
         var6.enableRetrying();
         return var6.executeAsync(this.restClient, var4, (ProgressCallback)null, var5).onSuccess(new Continuation() {
            public ParseFile.State then(Task<JSONObject> var1x) throws Exception {
               JSONObject var2x = (JSONObject)var1x.getResult();
               ParseFile.State var3 = (new ParseFile.Builder(var1)).name(var2x.getString("name")).url(var2x.getString("url")).build();

               try {
                  ParseFileUtils.copyFile(var2, ParseFileController.this.getCacheFile(var3));
                  return var3;
               } catch (IOException var5) {
                  return var3;
               }
            }
         }, ParseExecutors.method_369());
      }
   }

   public Task<ParseFile.State> saveAsync(final ParseFile.State var1, final byte[] var2, String var3, ProgressCallback var4, Task<Void> var5) {
      if(var1.url() != null) {
         return Task.forResult(var1);
      } else if(var5 != null && var5.isCancelled()) {
         return Task.cancelled();
      } else {
         ParseRESTFileCommand var6 = ((ParseRESTFileCommand.Builder)(new ParseRESTFileCommand.Builder()).fileName(var1.name()).data(var2).contentType(var1.mimeType()).sessionToken(var3)).build();
         var6.enableRetrying();
         return var6.executeAsync(this.restClient, var4, (ProgressCallback)null, var5).onSuccess(new Continuation() {
            public ParseFile.State then(Task<JSONObject> var1x) throws Exception {
               JSONObject var2x = (JSONObject)var1x.getResult();
               ParseFile.State var3 = (new ParseFile.Builder(var1)).name(var2x.getString("name")).url(var2x.getString("url")).build();

               try {
                  ParseFileUtils.writeByteArrayToFile(ParseFileController.this.getCacheFile(var3), var2);
                  return var3;
               } catch (IOException var5) {
                  return var3;
               }
            }
         }, ParseExecutors.method_369());
      }
   }
}
