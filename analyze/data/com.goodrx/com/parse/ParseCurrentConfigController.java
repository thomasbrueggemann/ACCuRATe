package com.parse;

import bolts.Task;
import com.parse.NoObjectsEncoder;
import com.parse.ParseConfig;
import com.parse.ParseDecoder;
import com.parse.ParseExecutors;
import com.parse.ParseFileUtils;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

class ParseCurrentConfigController {
   ParseConfig currentConfig;
   private File currentConfigFile;
   private final Object currentConfigMutex = new Object();

   public ParseCurrentConfigController(File var1) {
      this.currentConfigFile = var1;
   }

   // $FF: synthetic method
   static Object access$000(ParseCurrentConfigController var0) {
      return var0.currentConfigMutex;
   }

   void clearCurrentConfigForTesting() {
      // $FF: Couldn't be decompiled
   }

   public Task<ParseConfig> getCurrentConfigAsync() {
      return Task.call(new Callable() {
         public ParseConfig call() throws Exception {
            // $FF: Couldn't be decompiled
         }
      }, ParseExecutors.method_369());
   }

   ParseConfig getFromDisk() {
      try {
         JSONObject var3 = ParseFileUtils.readFileToJSONObject(this.currentConfigFile);
         return ParseConfig.decode(var3, ParseDecoder.get());
      } catch (IOException var4) {
         ;
      } catch (JSONException var5) {
         ;
      }

      return null;
   }

   void saveToDisk(ParseConfig var1) {
      JSONObject var2 = new JSONObject();

      try {
         var2.put("params", (JSONObject)NoObjectsEncoder.get().encode(var1.getParams()));
      } catch (JSONException var7) {
         throw new RuntimeException("could not serialize config to JSON");
      }

      try {
         ParseFileUtils.writeJSONObjectToFile(this.currentConfigFile, var2);
      } catch (IOException var6) {
         ;
      }
   }

   public Task<Void> setCurrentConfigAsync(final ParseConfig var1) {
      return Task.call(new Callable() {
         public Void call() throws Exception {
            // $FF: Couldn't be decompiled
         }
      }, ParseExecutors.method_369());
   }
}
