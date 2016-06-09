package com.parse;

import bolts.Task;
import com.parse.ParseDecoder;
import com.parse.ParseObject;
import com.parse.ParseOperationSet;
import java.util.List;

interface ParseObjectController {
   List<Task<Void>> deleteAllAsync(List<ParseObject.State> var1, String var2);

   Task<Void> deleteAsync(ParseObject.State var1, String var2);

   Task<ParseObject.State> fetchAsync(ParseObject.State var1, String var2, ParseDecoder var3);

   List<Task<ParseObject.State>> saveAllAsync(List<ParseObject.State> var1, List<ParseOperationSet> var2, String var3, List<ParseDecoder> var4);

   Task<ParseObject.State> saveAsync(ParseObject.State var1, ParseOperationSet var2, String var3, ParseDecoder var4);
}
