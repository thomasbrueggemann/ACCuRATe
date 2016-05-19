package com.parse;

import com.parse.ParseEncoder;
import org.json.JSONException;

interface ParseFieldOperation {
   Object apply(Object var1, String var2);

   Object encode(ParseEncoder var1) throws JSONException;

   ParseFieldOperation mergeWithPrevious(ParseFieldOperation var1);
}
