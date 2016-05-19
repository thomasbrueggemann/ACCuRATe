package com.parse;

import com.parse.ParseCallback2;
import com.parse.ParseException;
import com.parse.ParseObject;

public interface GetCallback<T extends ParseObject> extends ParseCallback2<T, ParseException> {
   void done(T var1, ParseException var2);
}
