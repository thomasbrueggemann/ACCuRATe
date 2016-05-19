package com.parse;

import com.parse.ParseCallback2;
import com.parse.ParseConfig;
import com.parse.ParseException;

public interface ConfigCallback extends ParseCallback2<ParseConfig, ParseException> {
   void done(ParseConfig var1, ParseException var2);
}
