package com.koushikdutta.ion.builder;

import java.io.File;

public interface LoadBuilder<B> {
   B load(File var1);

   B load(String var1);

   B load(String var1, String var2);
}
