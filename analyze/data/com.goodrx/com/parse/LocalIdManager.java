package com.parse;

import com.parse.ParseFileUtils;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

class LocalIdManager {
   private final File diskPath;
   private final Random random;

   LocalIdManager(File var1) {
      this.diskPath = new File(var1, "LocalId");
      this.random = new Random();
   }

   private LocalIdManager.MapEntry getMapEntry(String var1) {
      synchronized(this){}

      LocalIdManager.MapEntry var4;
      try {
         if(!this.isLocalId(var1)) {
            throw new IllegalStateException("Tried to get invalid local id: \"" + var1 + "\".");
         }

         try {
            JSONObject var6 = ParseFileUtils.readFileToJSONObject(new File(this.diskPath, var1));
            var4 = new LocalIdManager.MapEntry();
            var4.retainCount = var6.optInt("retainCount", 0);
            var4.objectId = var6.optString("objectId", (String)null);
            return var4;
         } catch (IOException var10) {
            ;
         } catch (JSONException var11) {
            ;
         }

         var4 = new LocalIdManager.MapEntry();
      } finally {
         ;
      }

      return var4;
   }

   private boolean isLocalId(String var1) {
      if(var1.startsWith("local_")) {
         int var2 = 6;

         while(true) {
            if(var2 >= var1.length()) {
               return true;
            }

            char var3 = var1.charAt(var2);
            if((var3 < 48 || var3 > 57) && (var3 < 97 || var3 > 102)) {
               break;
            }

            ++var2;
         }
      }

      return false;
   }

   private void putMapEntry(String var1, LocalIdManager.MapEntry var2) {
      synchronized(this){}

      try {
         if(!this.isLocalId(var1)) {
            throw new IllegalStateException("Tried to get invalid local id: \"" + var1 + "\".");
         }

         JSONObject var4 = new JSONObject();

         try {
            var4.put("retainCount", var2.retainCount);
            if(var2.objectId != null) {
               var4.put("objectId", var2.objectId);
            }
         } catch (JSONException var13) {
            throw new IllegalStateException("Error creating local id map entry.", var13);
         }

         File var7 = new File(this.diskPath, var1);
         if(!this.diskPath.exists()) {
            this.diskPath.mkdirs();
         }

         try {
            ParseFileUtils.writeJSONObjectToFile(var7, var4);
         } catch (IOException var12) {
            ;
         }
      } finally {
         ;
      }

   }

   private void removeMapEntry(String var1) {
      synchronized(this){}

      try {
         if(!this.isLocalId(var1)) {
            throw new IllegalStateException("Tried to get invalid local id: \"" + var1 + "\".");
         }

         ParseFileUtils.deleteQuietly(new File(this.diskPath, var1));
      } finally {
         ;
      }

   }

   boolean clear() throws IOException {
      // $FF: Couldn't be decompiled
   }

   String createLocalId() {
      synchronized(this){}

      String var4;
      try {
         long var2 = this.random.nextLong();
         var4 = "local_" + Long.toHexString(var2);
         if(!this.isLocalId(var4)) {
            throw new IllegalStateException("Generated an invalid local id: \"" + var4 + "\". " + "This should never happen. Contact us at https://parse.com/help");
         }
      } finally {
         ;
      }

      return var4;
   }

   String getObjectId(String var1) {
      synchronized(this){}

      String var3;
      try {
         var3 = this.getMapEntry(var1).objectId;
      } finally {
         ;
      }

      return var3;
   }

   void releaseLocalIdOnDisk(String var1) {
      synchronized(this){}

      try {
         LocalIdManager.MapEntry var3 = this.getMapEntry(var1);
         var3.retainCount += -1;
         if(var3.retainCount > 0) {
            this.putMapEntry(var1, var3);
         } else {
            this.removeMapEntry(var1);
         }
      } finally {
         ;
      }

   }

   void retainLocalIdOnDisk(String var1) {
      synchronized(this){}

      try {
         LocalIdManager.MapEntry var3 = this.getMapEntry(var1);
         ++var3.retainCount;
         this.putMapEntry(var1, var3);
      } finally {
         ;
      }

   }

   void setObjectId(String var1, String var2) {
      synchronized(this){}

      try {
         LocalIdManager.MapEntry var4 = this.getMapEntry(var1);
         if(var4.retainCount > 0) {
            if(var4.objectId != null) {
               throw new IllegalStateException("Tried to set an objectId for a localId that already has one.");
            }

            var4.objectId = var2;
            this.putMapEntry(var1, var4);
         }
      } finally {
         ;
      }

   }

   private static class MapEntry {
      String objectId;
      int retainCount;

      private MapEntry() {
      }

      // $FF: synthetic method
      MapEntry(Object var1) {
         this();
      }
   }
}
