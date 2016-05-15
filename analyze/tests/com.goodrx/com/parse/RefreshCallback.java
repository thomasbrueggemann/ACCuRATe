package com.parse;

import com.parse.ParseCallback2;
import com.parse.ParseException;
import com.parse.ParseObject;

public interface RefreshCallback extends ParseCallback2<ParseObject, ParseException> {
   void done(ParseObject var1, ParseException var2);
}
