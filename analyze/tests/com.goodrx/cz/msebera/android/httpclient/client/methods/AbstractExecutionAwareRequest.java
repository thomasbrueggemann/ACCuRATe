package cz.msebera.android.httpclient.client.methods;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.client.methods.AbortableHttpRequest;
import cz.msebera.android.httpclient.client.utils.CloneUtils;
import cz.msebera.android.httpclient.concurrent.Cancellable;
import cz.msebera.android.httpclient.conn.ClientConnectionRequest;
import cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger;
import cz.msebera.android.httpclient.message.AbstractHttpMessage;
import cz.msebera.android.httpclient.message.HeaderGroup;
import cz.msebera.android.httpclient.params.HttpParams;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public abstract class AbstractExecutionAwareRequest extends AbstractHttpMessage implements HttpRequest, AbortableHttpRequest, Cloneable {
   private final AtomicBoolean aborted = new AtomicBoolean(false);
   private final AtomicReference<Cancellable> cancellableRef = new AtomicReference((Object)null);

   public Object clone() throws CloneNotSupportedException {
      AbstractExecutionAwareRequest var1 = (AbstractExecutionAwareRequest)super.clone();
      var1.headergroup = (HeaderGroup)CloneUtils.cloneObject(this.headergroup);
      var1.params = (HttpParams)CloneUtils.cloneObject(this.params);
      return var1;
   }

   public boolean isAborted() {
      return this.aborted.get();
   }

   public void setCancellable(Cancellable var1) {
      if(!this.aborted.get()) {
         this.cancellableRef.set(var1);
      }

   }

   @Deprecated
   public void setConnectionRequest(final ClientConnectionRequest var1) {
      this.setCancellable(new Cancellable() {
      });
   }

   @Deprecated
   public void setReleaseTrigger(final ConnectionReleaseTrigger var1) {
      this.setCancellable(new Cancellable() {
      });
   }
}
