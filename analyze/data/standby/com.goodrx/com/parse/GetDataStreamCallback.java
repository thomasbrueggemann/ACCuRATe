package com.parse;

import com.parse.ParseCallback2;
import com.parse.ParseException;
import java.io.InputStream;

public interface GetDataStreamCallback extends ParseCallback2<InputStream, ParseException> {
   void done(InputStream var1, ParseException var2);
}
