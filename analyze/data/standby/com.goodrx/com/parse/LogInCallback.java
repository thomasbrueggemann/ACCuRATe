package com.parse;

import com.parse.ParseCallback2;
import com.parse.ParseException;
import com.parse.ParseUser;

public interface LogInCallback extends ParseCallback2<ParseUser, ParseException> {
   void done(ParseUser var1, ParseException var2);
}
