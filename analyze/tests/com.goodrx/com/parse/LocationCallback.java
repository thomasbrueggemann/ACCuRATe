package com.parse;

import com.parse.ParseCallback2;
import com.parse.ParseException;
import com.parse.ParseGeoPoint;

public interface LocationCallback extends ParseCallback2<ParseGeoPoint, ParseException> {
   void done(ParseGeoPoint var1, ParseException var2);
}
