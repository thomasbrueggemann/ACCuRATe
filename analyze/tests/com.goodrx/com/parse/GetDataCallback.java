package com.parse;

import com.parse.ParseCallback2;
import com.parse.ParseException;

public interface GetDataCallback extends ParseCallback2<byte[], ParseException> {
   void done(byte[] var1, ParseException var2);
}
