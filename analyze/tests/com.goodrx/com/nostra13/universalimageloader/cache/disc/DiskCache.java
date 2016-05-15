package com.nostra13.universalimageloader.cache.disc;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.utils.IoUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public interface DiskCache {
   void clear();

   File get(String var1);

   boolean save(String var1, Bitmap var2) throws IOException;

   boolean save(String var1, InputStream var2, IoUtils.CopyListener var3) throws IOException;
}
