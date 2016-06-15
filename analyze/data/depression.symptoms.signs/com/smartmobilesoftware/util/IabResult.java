package com.smartmobilesoftware.util;

import com.smartmobilesoftware.util.IabHelper;

public class IabResult {
   String mMessage;
   int mResponse;

   public IabResult(int var1, String var2) {
      this.mResponse = var1;
      if(var2 != null && var2.trim().length() != 0) {
         this.mMessage = var2 + " (response: " + IabHelper.getResponseDesc(var1) + ")";
      } else {
         this.mMessage = IabHelper.getResponseDesc(var1);
      }
   }

   public String getMessage() {
      return this.mMessage;
   }

   public int getResponse() {
      return this.mResponse;
   }

   public boolean isFailure() {
      return !this.isSuccess();
   }

   public boolean isSuccess() {
      return this.mResponse == 0;
   }

   public String toString() {
      return "IabResult: " + this.getMessage();
   }
}
