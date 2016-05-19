package com.parse;

import com.parse.ParseCallback2;
import com.parse.ParseException;
import java.io.File;

public interface GetFileCallback extends ParseCallback2<File, ParseException> {
   void done(File var1, ParseException var2);
}
