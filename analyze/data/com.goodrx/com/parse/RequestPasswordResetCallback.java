package com.parse;

import com.parse.ParseCallback1;
import com.parse.ParseException;

public interface RequestPasswordResetCallback extends ParseCallback1<ParseException> {
   void done(ParseException var1);
}