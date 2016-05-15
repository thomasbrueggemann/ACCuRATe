package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.util.Args;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Wire {
   // $FF: renamed from: id java.lang.String
   private final String field_124;
   public HttpClientAndroidLog log;

   public Wire(HttpClientAndroidLog var1) {
      this(var1, "");
   }

   public Wire(HttpClientAndroidLog var1, String var2) {
      this.log = var1;
      this.field_124 = var2;
   }

   private void wire(String var1, InputStream var2) throws IOException {
      StringBuilder var3 = new StringBuilder();

      while(true) {
         while(true) {
            int var4 = var2.read();
            if(var4 == -1) {
               if(var3.length() > 0) {
                  var3.append('\"');
                  var3.insert(0, '\"');
                  var3.insert(0, var1);
                  this.log.debug(this.field_124 + " " + var3.toString());
               }

               return;
            }

            if(var4 == 13) {
               var3.append("[\\r]");
            } else if(var4 == 10) {
               var3.append("[\\n]\"");
               var3.insert(0, "\"");
               var3.insert(0, var1);
               this.log.debug(this.field_124 + " " + var3.toString());
               var3.setLength(0);
            } else if(var4 >= 32 && var4 <= 127) {
               var3.append((char)var4);
            } else {
               var3.append("[0x");
               var3.append(Integer.toHexString(var4));
               var3.append("]");
            }
         }
      }
   }

   public boolean enabled() {
      return this.log.isDebugEnabled();
   }

   public void input(int var1) throws IOException {
      byte[] var2 = new byte[]{(byte)var1};
      this.input(var2);
   }

   public void input(byte[] var1) throws IOException {
      Args.notNull(var1, "Input");
      this.wire("<< ", new ByteArrayInputStream(var1));
   }

   public void input(byte[] var1, int var2, int var3) throws IOException {
      Args.notNull(var1, "Input");
      this.wire("<< ", new ByteArrayInputStream(var1, var2, var3));
   }

   public void output(int var1) throws IOException {
      byte[] var2 = new byte[]{(byte)var1};
      this.output(var2);
   }

   public void output(byte[] var1) throws IOException {
      Args.notNull(var1, "Output");
      this.wire(">> ", new ByteArrayInputStream(var1));
   }

   public void output(byte[] var1, int var2, int var3) throws IOException {
      Args.notNull(var1, "Output");
      this.wire(">> ", new ByteArrayInputStream(var1, var2, var3));
   }
}
