package com.newrelic.agent.android.util;

import android.util.Base64;
import com.newrelic.agent.android.util.Encoder;

public class AndroidEncoder implements Encoder {
   public String encode(byte[] var1) {
      return Base64.encodeToString(var1, 0);
   }
}
