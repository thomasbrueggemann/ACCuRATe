package com.parse;

import bolts.Task;
import com.parse.ParseObject;
import com.parse.ParseOperationSet;
import com.parse.ParseUser;
import java.util.Map;

interface ParseUserController {
   Task<ParseUser.State> getUserAsync(String var1);

   Task<ParseUser.State> logInAsync(ParseUser.State var1, ParseOperationSet var2);

   Task<ParseUser.State> logInAsync(String var1, String var2);

   Task<ParseUser.State> logInAsync(String var1, Map<String, String> var2);

   Task<Void> requestPasswordResetAsync(String var1);

   Task<ParseUser.State> signUpAsync(ParseObject.State var1, ParseOperationSet var2, String var3);
}
