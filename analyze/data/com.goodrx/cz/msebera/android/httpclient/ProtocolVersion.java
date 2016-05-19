package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.util.Args;
import java.io.Serializable;

public class ProtocolVersion implements Serializable, Cloneable {
   protected final int major;
   protected final int minor;
   protected final String protocol;

   public ProtocolVersion(String var1, int var2, int var3) {
      this.protocol = (String)Args.notNull(var1, "Protocol name");
      this.major = Args.notNegative(var2, "Protocol minor version");
      this.minor = Args.notNegative(var3, "Protocol minor version");
   }

   public Object clone() throws CloneNotSupportedException {
      return super.clone();
   }

   public int compareToVersion(ProtocolVersion var1) {
      Args.notNull(var1, "Protocol version");
      Args.check(this.protocol.equals(var1.protocol), "Versions for different protocols cannot be compared: %s %s", new Object[]{this, var1});
      int var3 = this.getMajor() - var1.getMajor();
      if(var3 == 0) {
         var3 = this.getMinor() - var1.getMinor();
      }

      return var3;
   }

   public final boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof ProtocolVersion)) {
            return false;
         }

         ProtocolVersion var2 = (ProtocolVersion)var1;
         if(!this.protocol.equals(var2.protocol) || this.major != var2.major || this.minor != var2.minor) {
            return false;
         }
      }

      return true;
   }

   public ProtocolVersion forVersion(int var1, int var2) {
      return var1 == this.major && var2 == this.minor?this:new ProtocolVersion(this.protocol, var1, var2);
   }

   public final int getMajor() {
      return this.major;
   }

   public final int getMinor() {
      return this.minor;
   }

   public final String getProtocol() {
      return this.protocol;
   }

   public final int hashCode() {
      return this.protocol.hashCode() ^ 100000 * this.major ^ this.minor;
   }

   public boolean isComparable(ProtocolVersion var1) {
      return var1 != null && this.protocol.equals(var1.protocol);
   }

   public final boolean lessEquals(ProtocolVersion var1) {
      return this.isComparable(var1) && this.compareToVersion(var1) <= 0;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.protocol);
      var1.append('/');
      var1.append(Integer.toString(this.major));
      var1.append('.');
      var1.append(Integer.toString(this.minor));
      return var1.toString();
   }
}
