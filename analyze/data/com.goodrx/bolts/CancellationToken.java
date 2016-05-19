package bolts;

import bolts.CancellationTokenSource;
import java.util.Locale;

public class CancellationToken {
   private final CancellationTokenSource tokenSource;

   public boolean isCancellationRequested() {
      return this.tokenSource.isCancellationRequested();
   }

   public String toString() {
      Locale var1 = Locale.US;
      Object[] var2 = new Object[]{this.getClass().getName(), Integer.toHexString(this.hashCode()), Boolean.toString(this.tokenSource.isCancellationRequested())};
      return String.format(var1, "%s@%s[cancellationRequested=%s]", var2);
   }
}
