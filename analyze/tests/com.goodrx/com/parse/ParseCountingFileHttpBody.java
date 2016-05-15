package com.parse;

import com.parse.ParseFileHttpBody;
import com.parse.ProgressCallback;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

class ParseCountingFileHttpBody extends ParseFileHttpBody {
   private static final int DEFAULT_CHUNK_SIZE = 4096;
   private static final int EOF = -1;
   private final ProgressCallback progressCallback;

   public ParseCountingFileHttpBody(File var1, ProgressCallback var2) {
      this(var1, (String)null, var2);
   }

   public ParseCountingFileHttpBody(File var1, String var2, ProgressCallback var3) {
      super(var1, var2);
      this.progressCallback = var3;
   }

   public void writeTo(OutputStream param1) throws IOException {
      // $FF: Couldn't be decompiled
   }
}
