package com.nostra13.universalimageloader.cache.disc.naming;

import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;

public class HashCodeFileNameGenerator implements FileNameGenerator {
   public String generate(String var1) {
      return String.valueOf(var1.hashCode());
   }
}
