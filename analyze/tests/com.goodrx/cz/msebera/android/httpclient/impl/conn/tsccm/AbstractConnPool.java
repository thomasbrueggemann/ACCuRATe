package cz.msebera.android.httpclient.impl.conn.tsccm;

import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.conn.IdleConnectionHandler;
import cz.msebera.android.httpclient.impl.conn.tsccm.BasicPoolEntry;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated
public abstract class AbstractConnPool {
   protected IdleConnectionHandler idleConnHandler = new IdleConnectionHandler();
   protected volatile boolean isShutDown;
   protected Set<BasicPoolEntry> leasedConnections = new HashSet();
   public HttpClientAndroidLog log = new HttpClientAndroidLog(this.getClass());
   protected final Lock poolLock = new ReentrantLock();

   protected void closeConnection(OperatedClientConnection var1) {
      if(var1 != null) {
         try {
            var1.close();
         } catch (IOException var3) {
            this.log.debug("I/O error closing connection", var3);
            return;
         }
      }

   }

   public void shutdown() {
      // $FF: Couldn't be decompiled
   }
}
