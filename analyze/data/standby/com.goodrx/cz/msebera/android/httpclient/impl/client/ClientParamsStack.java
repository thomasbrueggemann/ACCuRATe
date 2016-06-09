package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.params.AbstractHttpParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;

@Deprecated
public class ClientParamsStack extends AbstractHttpParams {
   protected final HttpParams applicationParams;
   protected final HttpParams clientParams;
   protected final HttpParams overrideParams;
   protected final HttpParams requestParams;

   public ClientParamsStack(HttpParams var1, HttpParams var2, HttpParams var3, HttpParams var4) {
      this.applicationParams = var1;
      this.clientParams = var2;
      this.requestParams = var3;
      this.overrideParams = var4;
   }

   public Object getParameter(String var1) {
      Args.notNull(var1, "Parameter name");
      HttpParams var3 = this.overrideParams;
      Object var4 = null;
      if(var3 != null) {
         var4 = this.overrideParams.getParameter(var1);
      }

      if(var4 == null && this.requestParams != null) {
         var4 = this.requestParams.getParameter(var1);
      }

      if(var4 == null && this.clientParams != null) {
         var4 = this.clientParams.getParameter(var1);
      }

      if(var4 == null && this.applicationParams != null) {
         var4 = this.applicationParams.getParameter(var1);
      }

      return var4;
   }

   public HttpParams setParameter(String var1, Object var2) throws UnsupportedOperationException {
      throw new UnsupportedOperationException("Setting parameters in a stack is not supported.");
   }
}
