package com.koushikdutta.async;

import javax.net.ssl.SSLPeerUnverifiedException;

public class AsyncSSLException extends SSLPeerUnverifiedException {
   private boolean mIgnore = false;

   public AsyncSSLException() {
      super("Peer not trusted by any of the system trust managers.");
   }

   public boolean getIgnore() {
      return this.mIgnore;
   }

   public void setIgnore(boolean var1) {
      this.mIgnore = var1;
   }
}
