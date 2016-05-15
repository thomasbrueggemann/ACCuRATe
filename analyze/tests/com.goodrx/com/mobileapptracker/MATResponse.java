package com.mobileapptracker;

import org.json.JSONObject;

public interface MATResponse {
   void didFailWithError(JSONObject var1);

   void didSucceedWithData(JSONObject var1);

   void enqueuedActionWithRefId(String var1);
}
