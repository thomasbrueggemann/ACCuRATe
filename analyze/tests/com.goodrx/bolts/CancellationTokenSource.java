package bolts;

import bolts.CancellationTokenRegistration;
import java.io.Closeable;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;

public class CancellationTokenSource implements Closeable {
   private boolean cancellationRequested;
   private boolean closed;
   private final Object lock;
   private final List<CancellationTokenRegistration> registrations;
   private ScheduledFuture<?> scheduledCancellation;

   private void cancelScheduledCancellation() {
      if(this.scheduledCancellation != null) {
         this.scheduledCancellation.cancel(true);
         this.scheduledCancellation = null;
      }

   }

   private void throwIfClosed() {
      if(this.closed) {
         throw new IllegalStateException("Object already closed");
      }
   }

   public void close() {
      // $FF: Couldn't be decompiled
   }

   public boolean isCancellationRequested() {
      // $FF: Couldn't be decompiled
   }

   public String toString() {
      Locale var1 = Locale.US;
      Object[] var2 = new Object[]{this.getClass().getName(), Integer.toHexString(this.hashCode()), Boolean.toString(this.isCancellationRequested())};
      return String.format(var1, "%s@%s[cancellationRequested=%s]", var2);
   }

   void unregister(CancellationTokenRegistration param1) {
      // $FF: Couldn't be decompiled
   }
}
