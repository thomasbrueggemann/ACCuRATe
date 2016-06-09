package com.comscore.utils;

import java.io.File;
import java.io.FilenameFilter;

// $FF: renamed from: com.comscore.utils.b
final class class_19 implements FilenameFilter {
   public boolean accept(File var1, String var2) {
      return var2.startsWith("cs_cache_");
   }
}
