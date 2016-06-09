package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.HeaderElement;
import java.util.Iterator;

public interface HeaderElementIterator extends Iterator<Object> {
   boolean hasNext();

   HeaderElement nextElement();
}
