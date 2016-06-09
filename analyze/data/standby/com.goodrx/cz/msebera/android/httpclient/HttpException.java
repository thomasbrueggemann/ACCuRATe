package cz.msebera.android.httpclient;

public class HttpException extends Exception {
   public HttpException() {
   }

   public HttpException(String var1) {
      super(var1);
   }

   public HttpException(String var1, Throwable var2) {
      super(var1);
      this.initCause(var2);
   }
}
