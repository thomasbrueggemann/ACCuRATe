package cz.msebera.android.httpclient.entity;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpMessage;

public interface ContentLengthStrategy {
   long determineLength(HttpMessage var1) throws HttpException;
}
