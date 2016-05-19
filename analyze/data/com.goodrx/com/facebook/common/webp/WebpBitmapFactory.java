package com.facebook.common.webp;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.BitmapFactory.Options;
import java.io.FileDescriptor;
import java.io.InputStream;

public interface WebpBitmapFactory {
   Bitmap decodeByteArray(byte[] var1, int var2, int var3, Options var4);

   Bitmap decodeFile(String var1, Options var2);

   Bitmap decodeFileDescriptor(FileDescriptor var1, Rect var2, Options var3);

   Bitmap decodeStream(InputStream var1, Rect var2, Options var3);
}
