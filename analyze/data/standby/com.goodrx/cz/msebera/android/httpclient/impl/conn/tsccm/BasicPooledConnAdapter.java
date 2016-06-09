package cz.msebera.android.httpclient.impl.conn.tsccm;

import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.impl.conn.AbstractPoolEntry;
import cz.msebera.android.httpclient.impl.conn.AbstractPooledConnAdapter;
import cz.msebera.android.httpclient.impl.conn.tsccm.ThreadSafeClientConnManager;

@Deprecated
public class BasicPooledConnAdapter extends AbstractPooledConnAdapter {
   protected BasicPooledConnAdapter(ThreadSafeClientConnManager var1, AbstractPoolEntry var2) {
      super(var1, var2);
      this.markReusable();
   }

   protected void detach() {
      super.detach();
   }

   protected ClientConnectionManager getManager() {
      return super.getManager();
   }

   protected AbstractPoolEntry getPoolEntry() {
      return super.getPoolEntry();
   }
}
