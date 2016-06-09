package com.koushikdutta.ion.builder;

import java.io.File;

public interface MultipartBodyBuilder<M extends MultipartBodyBuilder> {
   M setMultipartFile(String var1, File var2);

   M setMultipartParameter(String var1, String var2);
}
