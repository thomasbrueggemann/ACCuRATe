package com.parse;

import bolts.Continuation;
import bolts.Task;
import bolts.TaskCompletionSource;
import com.parse.GetDataCallback;
import com.parse.GetDataStreamCallback;
import com.parse.GetFileCallback;
import com.parse.ParseCallback1;
import com.parse.ParseCallback2;
import com.parse.ParseCorePlugins;
import com.parse.ParseDecoder;
import com.parse.ParseException;
import com.parse.ParseExecutors;
import com.parse.ParseFileController;
import com.parse.ParseFileUtils;
import com.parse.ParseTaskUtils;
import com.parse.ParseUser;
import com.parse.ProgressCallback;
import com.parse.SaveCallback;
import com.parse.TaskQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseFile {
   static final int MAX_FILE_SIZE = 10485760;
   private Set<TaskCompletionSource<?>> currentTasks;
   byte[] data;
   File file;
   private ParseFile.State state;
   final TaskQueue taskQueue;

   ParseFile(ParseFile.State var1) {
      this.taskQueue = new TaskQueue();
      this.currentTasks = Collections.synchronizedSet(new HashSet());
      this.state = var1;
   }

   public ParseFile(File var1) {
      this((File)var1, (String)null);
   }

   public ParseFile(File var1, String var2) {
      this((new ParseFile.Builder()).name(var1.getName()).mimeType(var2).build());
      if(var1.length() > 10485760L) {
         Object[] var3 = new Object[]{Integer.valueOf(10485760)};
         throw new IllegalArgumentException(String.format("ParseFile must be less than %d bytes", var3));
      } else {
         this.file = var1;
      }
   }

   public ParseFile(String var1, byte[] var2) {
      this(var1, var2, (String)null);
   }

   public ParseFile(String var1, byte[] var2, String var3) {
      this((new ParseFile.Builder()).name(var1).mimeType(var3).build());
      if(var2.length > 10485760) {
         Object[] var4 = new Object[]{Integer.valueOf(10485760)};
         throw new IllegalArgumentException(String.format("ParseFile must be less than %d bytes", var4));
      } else {
         this.data = var2;
      }
   }

   ParseFile(JSONObject var1, ParseDecoder var2) {
      this((new ParseFile.Builder()).name(var1.optString("name")).url(var1.optString("url")).build());
   }

   public ParseFile(byte[] var1) {
      this((String)null, var1, (String)null);
   }

   public ParseFile(byte[] var1, String var2) {
      this((String)null, var1, var2);
   }

   private Task<File> fetchInBackground(final ProgressCallback var1, Task<Void> var2, final Task<Void> var3) {
      return var3 != null && var3.isCancelled()?Task.cancelled():var2.continueWithTask(new Continuation() {
         public Task<File> then(Task<Void> var1x) throws Exception {
            return var3 != null && var3.isCancelled()?Task.cancelled():ParseFile.getFileController().fetchAsync(ParseFile.this.state, (String)null, ParseFile.progressCallbackOnMainThread(var1), var3);
         }
      });
   }

   static ParseFileController getFileController() {
      return ParseCorePlugins.getInstance().getFileController();
   }

   private static ProgressCallback progressCallbackOnMainThread(final ProgressCallback var0) {
      return var0 == null?null:new ProgressCallback() {
         public void done(final Integer var1) {
            Task.call(new Callable() {
               public Void call() throws Exception {
                  var0.done(var1);
                  return null;
               }
            }, ParseExecutors.main());
         }
      };
   }

   private Task<Void> saveAsync(final String var1, final ProgressCallback var2, Task<Void> var3, final Task<Void> var4) {
      return !this.isDirty()?Task.forResult((Object)null):(var4 != null && var4.isCancelled()?Task.cancelled():var3.continueWithTask(new Continuation() {
         public Task<Void> then(Task<Void> var1x) throws Exception {
            if(!ParseFile.this.isDirty()) {
               return Task.forResult((Object)null);
            } else if(var4 != null && var4.isCancelled()) {
               return Task.cancelled();
            } else {
               Task var2x;
               if(ParseFile.this.data != null) {
                  var2x = ParseFile.getFileController().saveAsync(ParseFile.this.state, ParseFile.this.data, var1, ParseFile.progressCallbackOnMainThread(var2), var4);
               } else {
                  var2x = ParseFile.getFileController().saveAsync(ParseFile.this.state, ParseFile.this.file, var1, ParseFile.progressCallbackOnMainThread(var2), var4);
               }

               return var2x.onSuccessTask(new Continuation() {
                  public Task<Void> then(Task<ParseFile.State> var1x) throws Exception {
                     ParseFile.this.state = (ParseFile.State)var1x.getResult();
                     ParseFile.this.data = null;
                     ParseFile.this.file = null;
                     return var1x.makeVoid();
                  }
               });
            }
         }
      }));
   }

   public void cancel() {
      HashSet var1 = new HashSet(this.currentTasks);
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         ((TaskCompletionSource)var2.next()).trySetCancelled();
      }

      this.currentTasks.removeAll(var1);
   }

   JSONObject encode() throws JSONException {
      JSONObject var1 = new JSONObject();
      var1.put("__type", "File");
      var1.put("name", this.getName());
      if(this.getUrl() == null) {
         throw new IllegalStateException("Unable to encode an unsaved ParseFile.");
      } else {
         var1.put("url", this.getUrl());
         return var1;
      }
   }

   public byte[] getData() throws ParseException {
      return (byte[])ParseTaskUtils.wait(this.getDataInBackground());
   }

   public Task<byte[]> getDataInBackground() {
      return this.getDataInBackground((ProgressCallback)null);
   }

   public Task<byte[]> getDataInBackground(final ProgressCallback var1) {
      final TaskCompletionSource var2 = new TaskCompletionSource();
      this.currentTasks.add(var2);
      return this.taskQueue.enqueue(new Continuation() {
         public Task<byte[]> then(Task<Void> var1x) throws Exception {
            return ParseFile.this.fetchInBackground(var1, var1x, var2.getTask()).onSuccess(new Continuation() {
               public byte[] then(Task<File> var1x) throws Exception {
                  File var2x = (File)var1x.getResult();

                  try {
                     byte[] var4 = ParseFileUtils.readFileToByteArray(var2x);
                     return var4;
                  } catch (IOException var5) {
                     return null;
                  }
               }
            });
         }
      }).continueWithTask(new Continuation() {
         public Task<byte[]> then(Task<byte[]> var1) throws Exception {
            var2.trySetResult((Object)null);
            ParseFile.this.currentTasks.remove(var2);
            return var1;
         }
      });
   }

   public void getDataInBackground(GetDataCallback var1) {
      ParseTaskUtils.callbackOnMainThreadAsync(this.getDataInBackground(), (ParseCallback2)var1);
   }

   public void getDataInBackground(GetDataCallback var1, ProgressCallback var2) {
      ParseTaskUtils.callbackOnMainThreadAsync(this.getDataInBackground(var2), (ParseCallback2)var1);
   }

   public InputStream getDataStream() throws ParseException {
      return (InputStream)ParseTaskUtils.wait(this.getDataStreamInBackground());
   }

   public Task<InputStream> getDataStreamInBackground() {
      return this.getDataStreamInBackground((ProgressCallback)null);
   }

   public Task<InputStream> getDataStreamInBackground(final ProgressCallback var1) {
      final TaskCompletionSource var2 = new TaskCompletionSource();
      this.currentTasks.add(var2);
      return this.taskQueue.enqueue(new Continuation() {
         public Task<InputStream> then(Task<Void> var1x) throws Exception {
            return ParseFile.this.fetchInBackground(var1, var1x, var2.getTask()).onSuccess(new Continuation() {
               public InputStream then(Task<File> var1x) throws Exception {
                  return new FileInputStream((File)var1x.getResult());
               }
            });
         }
      }).continueWithTask(new Continuation() {
         public Task<InputStream> then(Task<InputStream> var1) throws Exception {
            var2.trySetResult((Object)null);
            ParseFile.this.currentTasks.remove(var2);
            return var1;
         }
      });
   }

   public void getDataStreamInBackground(GetDataStreamCallback var1) {
      ParseTaskUtils.callbackOnMainThreadAsync(this.getDataStreamInBackground(), (ParseCallback2)var1);
   }

   public void getDataStreamInBackground(GetDataStreamCallback var1, ProgressCallback var2) {
      ParseTaskUtils.callbackOnMainThreadAsync(this.getDataStreamInBackground(var2), (ParseCallback2)var1);
   }

   public File getFile() throws ParseException {
      return (File)ParseTaskUtils.wait(this.getFileInBackground());
   }

   public Task<File> getFileInBackground() {
      return this.getFileInBackground((ProgressCallback)null);
   }

   public Task<File> getFileInBackground(final ProgressCallback var1) {
      final TaskCompletionSource var2 = new TaskCompletionSource();
      this.currentTasks.add(var2);
      return this.taskQueue.enqueue(new Continuation() {
         public Task<File> then(Task<Void> var1x) throws Exception {
            return ParseFile.this.fetchInBackground(var1, var1x, var2.getTask());
         }
      }).continueWithTask(new Continuation() {
         public Task<File> then(Task<File> var1) throws Exception {
            var2.trySetResult((Object)null);
            ParseFile.this.currentTasks.remove(var2);
            return var1;
         }
      });
   }

   public void getFileInBackground(GetFileCallback var1) {
      ParseTaskUtils.callbackOnMainThreadAsync(this.getFileInBackground(), (ParseCallback2)var1);
   }

   public void getFileInBackground(GetFileCallback var1, ProgressCallback var2) {
      ParseTaskUtils.callbackOnMainThreadAsync(this.getFileInBackground(var2), (ParseCallback2)var1);
   }

   public String getName() {
      return this.state.name();
   }

   ParseFile.State getState() {
      return this.state;
   }

   public String getUrl() {
      return this.state.url();
   }

   public boolean isDataAvailable() {
      return this.data != null || getFileController().isDataAvailable(this.state);
   }

   public boolean isDirty() {
      return this.state.url() == null;
   }

   public void save() throws ParseException {
      ParseTaskUtils.wait(this.saveInBackground());
   }

   Task<Void> saveAsync(final String var1, final ProgressCallback var2, final Task<Void> var3) {
      return this.taskQueue.enqueue(new Continuation() {
         public Task<Void> then(Task<Void> var1x) throws Exception {
            return ParseFile.this.saveAsync(var1, var2, var1x, var3);
         }
      });
   }

   public Task<Void> saveInBackground() {
      return this.saveInBackground((ProgressCallback)null);
   }

   public Task<Void> saveInBackground(final ProgressCallback var1) {
      final TaskCompletionSource var2 = new TaskCompletionSource();
      this.currentTasks.add(var2);
      return ParseUser.getCurrentSessionTokenAsync().onSuccessTask(new Continuation() {
         public Task<Void> then(Task<String> var1x) throws Exception {
            String var2x = (String)var1x.getResult();
            return ParseFile.this.saveAsync(var2x, var1, var2.getTask());
         }
      }).continueWithTask(new Continuation() {
         public Task<Void> then(Task<Void> var1) throws Exception {
            var2.trySetResult((Object)null);
            ParseFile.this.currentTasks.remove(var2);
            return var1;
         }
      });
   }

   public void saveInBackground(SaveCallback var1) {
      ParseTaskUtils.callbackOnMainThreadAsync(this.saveInBackground(), (ParseCallback1)var1);
   }

   public void saveInBackground(SaveCallback var1, ProgressCallback var2) {
      ParseTaskUtils.callbackOnMainThreadAsync(this.saveInBackground(var2), (ParseCallback1)var1);
   }

   static class State {
      private final String contentType;
      private final String name;
      private final String url;

      private State(ParseFile.Builder var1) {
         String var2;
         if(var1.name != null) {
            var2 = var1.name;
         } else {
            var2 = "file";
         }

         this.name = var2;
         this.contentType = var1.mimeType;
         this.url = var1.url;
      }

      // $FF: synthetic method
      State(ParseFile.Builder var1, Object var2) {
         this(var1);
      }

      public String mimeType() {
         return this.contentType;
      }

      public String name() {
         return this.name;
      }

      public String url() {
         return this.url;
      }
   }

   static class Builder {
      private String mimeType;
      private String name;
      private String url;

      public Builder() {
      }

      public Builder(ParseFile.State var1) {
         this.name = var1.name();
         this.mimeType = var1.mimeType();
         this.url = var1.url();
      }

      public ParseFile.State build() {
         return new ParseFile.State(this, null);
      }

      public ParseFile.Builder mimeType(String var1) {
         this.mimeType = var1;
         return this;
      }

      public ParseFile.Builder name(String var1) {
         this.name = var1;
         return this;
      }

      public ParseFile.Builder url(String var1) {
         this.url = var1;
         return this;
      }
   }
}
