package com.parse;

import bolts.Task;
import com.parse.ParseCorePlugins;
import com.parse.ParseDecoder;
import com.parse.ParseExecutors;
import com.parse.ParseFileUtils;
import com.parse.ParseObject;
import com.parse.ParseObjectCurrentCoder;
import com.parse.ParseObjectStore;
import com.parse.ParseObjectSubclassingController;
import com.parse.ParseOperationSet;
import com.parse.PointerEncoder;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

class FileObjectStore<T extends ParseObject> implements ParseObjectStore<T> {
   private final String className;
   private final ParseObjectCurrentCoder coder;
   private final File file;

   public FileObjectStore(Class<T> var1, File var2, ParseObjectCurrentCoder var3) {
      this(getSubclassingController().getClassName(var1), var2, var3);
   }

   public FileObjectStore(String var1, File var2, ParseObjectCurrentCoder var3) {
      this.className = var1;
      this.file = var2;
      this.coder = var3;
   }

   private static <T extends ParseObject> T getFromDisk(ParseObjectCurrentCoder var0, File var1, ParseObject.Init var2) {
      try {
         JSONObject var5 = ParseFileUtils.readFileToJSONObject(var1);
         return ParseObject.from(var0.decode(var2, var5, ParseDecoder.get()).isComplete(true).build());
      } catch (IOException var6) {
         ;
      } catch (JSONException var7) {
         ;
      }

      return null;
   }

   private static ParseObjectSubclassingController getSubclassingController() {
      return ParseCorePlugins.getInstance().getSubclassingController();
   }

   private static void saveToDisk(ParseObjectCurrentCoder var0, ParseObject var1, File var2) {
      JSONObject var3 = var0.encode(var1.getState(), (ParseOperationSet)null, PointerEncoder.get());

      try {
         ParseFileUtils.writeJSONObjectToFile(var2, var3);
      } catch (IOException var5) {
         ;
      }
   }

   public Task<Void> deleteAsync() {
      return Task.call(new Callable() {
         public Void call() throws Exception {
            if(FileObjectStore.this.file.exists() && !ParseFileUtils.deleteQuietly(FileObjectStore.this.file)) {
               throw new RuntimeException("Unable to delete");
            } else {
               return null;
            }
         }
      }, ParseExecutors.method_369());
   }

   public Task<Boolean> existsAsync() {
      return Task.call(new Callable() {
         public Boolean call() throws Exception {
            return Boolean.valueOf(FileObjectStore.this.file.exists());
         }
      }, ParseExecutors.method_369());
   }

   public Task<T> getAsync() {
      return Task.call(new Callable() {
         public T call() throws Exception {
            return !FileObjectStore.this.file.exists()?null:FileObjectStore.getFromDisk(FileObjectStore.this.coder, FileObjectStore.this.file, ParseObject.State.newBuilder(FileObjectStore.this.className));
         }
      }, ParseExecutors.method_369());
   }

   public Task<Void> setAsync(final T var1) {
      return Task.call(new Callable() {
         public Void call() throws Exception {
            FileObjectStore.saveToDisk(FileObjectStore.this.coder, var1, FileObjectStore.this.file);
            return null;
         }
      }, ParseExecutors.method_369());
   }
}
