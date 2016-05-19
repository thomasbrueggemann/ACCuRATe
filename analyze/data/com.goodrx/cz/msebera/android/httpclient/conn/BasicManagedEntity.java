package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger;
import cz.msebera.android.httpclient.conn.EofSensorInputStream;
import cz.msebera.android.httpclient.conn.EofSensorWatcher;
import cz.msebera.android.httpclient.conn.ManagedClientConnection;
import cz.msebera.android.httpclient.entity.HttpEntityWrapper;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Deprecated
public class BasicManagedEntity extends HttpEntityWrapper implements ConnectionReleaseTrigger, EofSensorWatcher {
   protected final boolean attemptReuse;
   protected ManagedClientConnection managedConn;

   public BasicManagedEntity(HttpEntity var1, ManagedClientConnection var2, boolean var3) {
      super(var1);
      Args.notNull(var2, "Connection");
      this.managedConn = var2;
      this.attemptReuse = var3;
   }

   private void ensureConsumed() throws IOException {
      if(this.managedConn != null) {
         try {
            if(this.attemptReuse) {
               EntityUtils.consume(this.wrappedEntity);
               this.managedConn.markReusable();
            } else {
               this.managedConn.unmarkReusable();
            }
         } finally {
            this.releaseManagedConnection();
         }

      }
   }

   public void abortConnection() throws IOException {
      if(this.managedConn != null) {
         try {
            this.managedConn.abortConnection();
         } finally {
            this.managedConn = null;
         }
      }

   }

   @Deprecated
   public void consumeContent() throws IOException {
      this.ensureConsumed();
   }

   public boolean eofDetected(InputStream var1) throws IOException {
      try {
         if(this.managedConn != null) {
            if(this.attemptReuse) {
               var1.close();
               this.managedConn.markReusable();
            } else {
               this.managedConn.unmarkReusable();
            }
         }
      } finally {
         this.releaseManagedConnection();
      }

      return false;
   }

   public InputStream getContent() throws IOException {
      return new EofSensorInputStream(this.wrappedEntity.getContent(), this);
   }

   public boolean isRepeatable() {
      return false;
   }

   public void releaseConnection() throws IOException {
      this.ensureConsumed();
   }

   protected void releaseManagedConnection() throws IOException {
      if(this.managedConn != null) {
         try {
            this.managedConn.releaseConnection();
         } finally {
            this.managedConn = null;
         }
      }

   }

   public boolean streamAbort(InputStream var1) throws IOException {
      if(this.managedConn != null) {
         this.managedConn.abortConnection();
      }

      return false;
   }

   public boolean streamClosed(InputStream param1) throws IOException {
      // $FF: Couldn't be decompiled
   }

   public void writeTo(OutputStream var1) throws IOException {
      super.writeTo(var1);
      this.ensureConsumed();
   }
}
