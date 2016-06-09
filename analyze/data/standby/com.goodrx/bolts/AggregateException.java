package bolts;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AggregateException extends Exception {
   private List<Throwable> innerThrowables;

   public AggregateException(String var1, List<? extends Throwable> var2) {
      Throwable var3;
      if(var2 != null && var2.size() > 0) {
         var3 = (Throwable)var2.get(0);
      } else {
         var3 = null;
      }

      super(var1, var3);
      this.innerThrowables = Collections.unmodifiableList(var2);
   }

   public void printStackTrace(PrintStream var1) {
      super.printStackTrace(var1);
      int var2 = -1;
      Iterator var3 = this.innerThrowables.iterator();

      while(var3.hasNext()) {
         Throwable var4 = (Throwable)var3.next();
         var1.append("\n");
         var1.append("  Inner throwable #");
         ++var2;
         var1.append(Integer.toString(var2));
         var1.append(": ");
         var4.printStackTrace(var1);
         var1.append("\n");
      }

   }

   public void printStackTrace(PrintWriter var1) {
      super.printStackTrace(var1);
      int var2 = -1;
      Iterator var3 = this.innerThrowables.iterator();

      while(var3.hasNext()) {
         Throwable var4 = (Throwable)var3.next();
         var1.append("\n");
         var1.append("  Inner throwable #");
         ++var2;
         var1.append(Integer.toString(var2));
         var1.append(": ");
         var4.printStackTrace(var1);
         var1.append("\n");
      }

   }
}
