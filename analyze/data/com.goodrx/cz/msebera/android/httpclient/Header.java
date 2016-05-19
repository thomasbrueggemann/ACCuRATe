package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.ParseException;

public interface Header {
   HeaderElement[] getElements() throws ParseException;

   String getName();

   String getValue();
}
