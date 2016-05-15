package com.loopj.android.http;

import com.loopj.android.http.AsyncHttpResponseHandler;
import java.io.File;

public abstract class FileAsyncHttpResponseHandler extends AsyncHttpResponseHandler {
   protected final File file;
}
