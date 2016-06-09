package bolts;

import bolts.CancellationTokenSource;
import java.io.Closeable;

public class CancellationTokenRegistration implements Closeable {
   private Runnable action;
   private boolean closed;
   private final Object lock;
   private CancellationTokenSource tokenSource;

   public void close() {
      // $FF: Couldn't be decompiled
   }
}
