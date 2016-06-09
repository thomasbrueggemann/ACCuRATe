package bolts;

public class ExecutorException extends RuntimeException {
   public ExecutorException(Exception var1) {
      super("An exception was thrown by an Executor", var1);
   }
}
