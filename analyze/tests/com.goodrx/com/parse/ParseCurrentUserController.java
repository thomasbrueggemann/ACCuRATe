package com.parse;

import bolts.Task;
import com.parse.ParseObjectCurrentController;
import com.parse.ParseUser;

interface ParseCurrentUserController extends ParseObjectCurrentController<ParseUser> {
   Task<ParseUser> getAsync(boolean var1);

   Task<String> getCurrentSessionTokenAsync();

   Task<Void> logOutAsync();

   Task<Void> setIfNeededAsync(ParseUser var1);
}
