package com.parse.http;

import com.parse.http.ParseHttpRequest;
import com.parse.http.ParseHttpResponse;
import java.io.IOException;

public interface ParseNetworkInterceptor {
   ParseHttpResponse intercept(ParseNetworkInterceptor.Chain var1) throws IOException;

   public interface Chain {
      ParseHttpRequest getRequest();

      ParseHttpResponse proceed(ParseHttpRequest var1) throws IOException;
   }
}
