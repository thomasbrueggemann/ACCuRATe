package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.Header;
import java.util.Iterator;

public interface HeaderIterator extends Iterator<Object> {
   boolean hasNext();

   Header nextHeader();
}
