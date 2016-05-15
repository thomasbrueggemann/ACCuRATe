package cz.msebera.android.httpclient.impl.conn.tsccm;

import cz.msebera.android.httpclient.conn.ConnectionPoolTimeoutException;
import cz.msebera.android.httpclient.impl.conn.tsccm.BasicPoolEntry;
import java.util.concurrent.TimeUnit;

@Deprecated
public interface PoolEntryRequest {
   BasicPoolEntry getPoolEntry(long var1, TimeUnit var3) throws InterruptedException, ConnectionPoolTimeoutException;
}
