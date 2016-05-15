package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.cookie.SetCookie2;
import cz.msebera.android.httpclient.impl.cookie.BasicClientCookie;
import java.util.Date;

public class BasicClientCookie2 extends BasicClientCookie implements SetCookie2 {
   private String commentURL;
   private boolean discard;
   private int[] ports;

   public BasicClientCookie2(String var1, String var2) {
      super(var1, var2);
   }

   public Object clone() throws CloneNotSupportedException {
      BasicClientCookie2 var1 = (BasicClientCookie2)super.clone();
      if(this.ports != null) {
         var1.ports = (int[])this.ports.clone();
      }

      return var1;
   }

   public int[] getPorts() {
      return this.ports;
   }

   public boolean isExpired(Date var1) {
      return this.discard || super.isExpired(var1);
   }

   public boolean isPersistent() {
      return !this.discard && super.isPersistent();
   }

   public void setCommentURL(String var1) {
      this.commentURL = var1;
   }

   public void setDiscard(boolean var1) {
      this.discard = var1;
   }

   public void setPorts(int[] var1) {
      this.ports = var1;
   }
}
