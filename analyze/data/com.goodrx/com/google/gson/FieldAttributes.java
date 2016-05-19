package com.google.gson;

import com.google.gson.internal.$Gson$Preconditions;
import java.lang.reflect.Field;

public final class FieldAttributes {
   private final Field field;

   public FieldAttributes(Field var1) {
      $Gson$Preconditions.checkNotNull(var1);
      this.field = var1;
   }
}
