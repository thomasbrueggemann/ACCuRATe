package cz.msebera.android.httpclient.config;

public class MessageConstraints implements Cloneable {
   public static final MessageConstraints DEFAULT = (new MessageConstraints.Builder()).build();
   private final int maxHeaderCount;
   private final int maxLineLength;

   MessageConstraints(int var1, int var2) {
      this.maxLineLength = var1;
      this.maxHeaderCount = var2;
   }

   public static MessageConstraints.Builder custom() {
      return new MessageConstraints.Builder();
   }

   protected MessageConstraints clone() throws CloneNotSupportedException {
      return (MessageConstraints)super.clone();
   }

   public int getMaxHeaderCount() {
      return this.maxHeaderCount;
   }

   public int getMaxLineLength() {
      return this.maxLineLength;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("[maxLineLength=").append(this.maxLineLength).append(", maxHeaderCount=").append(this.maxHeaderCount).append("]");
      return var1.toString();
   }

   public static class Builder {
      private int maxHeaderCount = -1;
      private int maxLineLength = -1;

      public MessageConstraints build() {
         return new MessageConstraints(this.maxLineLength, this.maxHeaderCount);
      }

      public MessageConstraints.Builder setMaxHeaderCount(int var1) {
         this.maxHeaderCount = var1;
         return this;
      }

      public MessageConstraints.Builder setMaxLineLength(int var1) {
         this.maxLineLength = var1;
         return this;
      }
   }
}
