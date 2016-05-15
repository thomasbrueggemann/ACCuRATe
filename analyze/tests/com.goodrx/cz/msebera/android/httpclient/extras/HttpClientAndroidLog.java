package cz.msebera.android.httpclient.extras;

import android.util.Log;

public class HttpClientAndroidLog {
   private boolean debugEnabled;
   private boolean errorEnabled;
   private boolean infoEnabled;
   private String logTag;
   private boolean traceEnabled;
   private boolean warnEnabled;

   public HttpClientAndroidLog(Object var1) {
      this.logTag = var1.toString();
      this.debugEnabled = false;
      this.errorEnabled = false;
      this.traceEnabled = false;
      this.warnEnabled = false;
      this.infoEnabled = false;
   }

   public void debug(Object var1) {
      if(this.isDebugEnabled()) {
         Log.d(this.logTag, var1.toString());
      }

   }

   public void debug(Object var1, Throwable var2) {
      if(this.isDebugEnabled()) {
         Log.d(this.logTag, var1.toString(), var2);
      }

   }

   public void error(Object var1) {
      if(this.isErrorEnabled()) {
         Log.e(this.logTag, var1.toString());
      }

   }

   public void error(Object var1, Throwable var2) {
      if(this.isErrorEnabled()) {
         Log.e(this.logTag, var1.toString(), var2);
      }

   }

   public void info(Object var1) {
      if(this.isInfoEnabled()) {
         Log.i(this.logTag, var1.toString());
      }

   }

   public boolean isDebugEnabled() {
      return this.debugEnabled;
   }

   public boolean isErrorEnabled() {
      return this.errorEnabled;
   }

   public boolean isInfoEnabled() {
      return this.infoEnabled;
   }

   public boolean isWarnEnabled() {
      return this.warnEnabled;
   }

   public void warn(Object var1) {
      if(this.isWarnEnabled()) {
         Log.w(this.logTag, var1.toString());
      }

   }

   public void warn(Object var1, Throwable var2) {
      if(this.isWarnEnabled()) {
         Log.w(this.logTag, var1.toString(), var2);
      }

   }
}
