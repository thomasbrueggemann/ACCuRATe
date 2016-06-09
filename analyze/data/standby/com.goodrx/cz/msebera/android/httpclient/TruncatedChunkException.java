package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.MalformedChunkCodingException;

public class TruncatedChunkException extends MalformedChunkCodingException {
   public TruncatedChunkException(String var1) {
      super(var1);
   }
}
