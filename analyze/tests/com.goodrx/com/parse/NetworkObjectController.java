package com.parse;

import bolts.Continuation;
import bolts.Task;
import com.parse.ParseDecoder;
import com.parse.ParseHttpClient;
import com.parse.ParseObject;
import com.parse.ParseObjectCoder;
import com.parse.ParseObjectController;
import com.parse.ParseOperationSet;
import com.parse.ParseRESTObjectBatchCommand;
import com.parse.ParseRESTObjectCommand;
import com.parse.PointerEncoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

class NetworkObjectController implements ParseObjectController {
   private ParseHttpClient client;
   private ParseObjectCoder coder;

   public NetworkObjectController(ParseHttpClient var1) {
      this.client = var1;
      this.coder = ParseObjectCoder.get();
   }

   public List<Task<Void>> deleteAllAsync(List<ParseObject.State> var1, String var2) {
      int var3 = var1.size();
      ArrayList var4 = new ArrayList(var3);

      for(int var5 = 0; var5 < var3; ++var5) {
         ParseRESTObjectCommand var10 = ParseRESTObjectCommand.deleteObjectCommand((ParseObject.State)var1.get(var5), var2);
         var10.enableRetrying();
         var4.add(var10);
      }

      List var6 = ParseRESTObjectBatchCommand.executeBatch(this.client, var4, var2);
      ArrayList var7 = new ArrayList(var3);

      for(int var8 = 0; var8 < var3; ++var8) {
         var7.add(((Task)var6.get(var8)).makeVoid());
      }

      return var7;
   }

   public Task<Void> deleteAsync(ParseObject.State var1, String var2) {
      ParseRESTObjectCommand var3 = ParseRESTObjectCommand.deleteObjectCommand(var1, var2);
      var3.enableRetrying();
      return var3.executeAsync(this.client).makeVoid();
   }

   public Task<ParseObject.State> fetchAsync(final ParseObject.State var1, String var2, final ParseDecoder var3) {
      ParseRESTObjectCommand var4 = ParseRESTObjectCommand.getObjectCommand(var1.objectId(), var1.className(), var2);
      var4.enableRetrying();
      return var4.executeAsync(this.client).onSuccess(new Continuation() {
         public ParseObject.State then(Task<JSONObject> var1x) throws Exception {
            JSONObject var2 = (JSONObject)var1x.getResult();
            ParseObject.Init var3x = var1.newBuilder().clear();
            return NetworkObjectController.this.coder.decode(var3x, var2, var3).isComplete(true).build();
         }
      });
   }

   public List<Task<ParseObject.State>> saveAllAsync(List<ParseObject.State> var1, List<ParseOperationSet> var2, String var3, List<ParseDecoder> var4) {
      int var5 = var1.size();
      ArrayList var6 = new ArrayList(var5);
      PointerEncoder var7 = PointerEncoder.get();

      for(int var8 = 0; var8 < var5; ++var8) {
         ParseObject.State var15 = (ParseObject.State)var1.get(var8);
         ParseOperationSet var16 = (ParseOperationSet)var2.get(var8);
         var6.add(ParseRESTObjectCommand.saveObjectCommand(var15, this.coder.encode(var15, var16, var7), var3));
      }

      List var9 = ParseRESTObjectBatchCommand.executeBatch(this.client, var6, var3);
      ArrayList var10 = new ArrayList(var5);

      for(int var11 = 0; var11 < var5; ++var11) {
         final ParseObject.State var12 = (ParseObject.State)var1.get(var11);
         final ParseDecoder var13 = (ParseDecoder)var4.get(var11);
         var10.add(((Task)var9.get(var11)).onSuccess(new Continuation() {
            public ParseObject.State then(Task<JSONObject> var1) throws Exception {
               JSONObject var2 = (JSONObject)var1.getResult();
               ParseObject.Init var3 = var12.newBuilder().clear();
               return NetworkObjectController.this.coder.decode(var3, var2, var13).isComplete(false).build();
            }
         }));
      }

      return var10;
   }

   public Task<ParseObject.State> saveAsync(final ParseObject.State var1, ParseOperationSet var2, String var3, final ParseDecoder var4) {
      ParseRESTObjectCommand var5 = ParseRESTObjectCommand.saveObjectCommand(var1, this.coder.encode(var1, var2, PointerEncoder.get()), var3);
      var5.enableRetrying();
      return var5.executeAsync(this.client).onSuccess(new Continuation() {
         public ParseObject.State then(Task<JSONObject> var1x) throws Exception {
            JSONObject var2 = (JSONObject)var1x.getResult();
            ParseObject.Init var3 = var1.newBuilder().clear();
            return NetworkObjectController.this.coder.decode(var3, var2, var4).isComplete(false).build();
         }
      });
   }
}
