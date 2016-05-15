package com.parse;

import com.parse.ParseCallback2;
import com.parse.ParseException;

public interface FunctionCallback<T> extends ParseCallback2<T, ParseException> {
   void done(T var1, ParseException var2);
}
