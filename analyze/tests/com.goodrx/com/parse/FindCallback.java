package com.parse;

import com.parse.ParseCallback2;
import com.parse.ParseException;
import com.parse.ParseObject;
import java.util.List;

public interface FindCallback<T extends ParseObject> extends ParseCallback2<List<T>, ParseException> {
   void done(List<T> var1, ParseException var2);
}
