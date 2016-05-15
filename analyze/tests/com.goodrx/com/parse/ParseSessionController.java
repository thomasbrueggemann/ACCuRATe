package com.parse;

import bolts.Task;
import com.parse.ParseObject;

interface ParseSessionController {
   Task<ParseObject.State> getSessionAsync(String var1);

   Task<Void> revokeAsync(String var1);

   Task<ParseObject.State> upgradeToRevocable(String var1);
}
