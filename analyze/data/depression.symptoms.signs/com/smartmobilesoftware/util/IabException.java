package com.smartmobilesoftware.util;

import com.smartmobilesoftware.util.IabResult;

public class IabException extends Exception {
   private static final long serialVersionUID = 1494222924647118158L;
   IabResult mResult;

   public IabException(int var1, String var2) {
      this(new IabResult(var1, var2));
   }

   public IabException(int var1, String var2, Exception var3) {
      this(new IabResult(var1, var2), var3);
   }

   public IabException(IabResult var1) {
      this(var1, (Exception)null);
   }

   public IabException(IabResult var1, Exception var2) {
      super(var1.getMessage(), var2);
      this.mResult = var1;
   }

   public IabResult getResult() {
      return this.mResult;
   }
}
