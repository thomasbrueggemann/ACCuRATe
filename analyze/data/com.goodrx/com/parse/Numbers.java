package com.parse;

class Numbers {
   static Number add(Number var0, Number var1) {
      if(!(var0 instanceof Double) && !(var1 instanceof Double)) {
         if(!(var0 instanceof Float) && !(var1 instanceof Float)) {
            if(!(var0 instanceof Long) && !(var1 instanceof Long)) {
               if(!(var0 instanceof Integer) && !(var1 instanceof Integer)) {
                  if(!(var0 instanceof Short) && !(var1 instanceof Short)) {
                     if(!(var0 instanceof Byte) && !(var1 instanceof Byte)) {
                        throw new RuntimeException("Unknown number type.");
                     } else {
                        return Integer.valueOf(var0.byteValue() + var1.byteValue());
                     }
                  } else {
                     return Integer.valueOf(var0.shortValue() + var1.shortValue());
                  }
               } else {
                  return Integer.valueOf(var0.intValue() + var1.intValue());
               }
            } else {
               return Long.valueOf(var0.longValue() + var1.longValue());
            }
         } else {
            return Float.valueOf(var0.floatValue() + var1.floatValue());
         }
      } else {
         return Double.valueOf(var0.doubleValue() + var1.doubleValue());
      }
   }

   static int compare(Number var0, Number var1) {
      if(!(var0 instanceof Double) && !(var1 instanceof Double)) {
         if(!(var0 instanceof Float) && !(var1 instanceof Float)) {
            if(!(var0 instanceof Long) && !(var1 instanceof Long)) {
               if(!(var0 instanceof Integer) && !(var1 instanceof Integer)) {
                  if(!(var0 instanceof Short) && !(var1 instanceof Short)) {
                     if(!(var0 instanceof Byte) && !(var1 instanceof Byte)) {
                        throw new RuntimeException("Unknown number type.");
                     } else {
                        return var0.byteValue() - var1.byteValue();
                     }
                  } else {
                     return var0.shortValue() - var1.shortValue();
                  }
               } else {
                  return var0.intValue() - var1.intValue();
               }
            } else {
               long var2 = var0.longValue() - var1.longValue();
               return var2 < 0L?-1:(var2 > 0L?1:0);
            }
         } else {
            return (int)Math.signum(var0.floatValue() - var1.floatValue());
         }
      } else {
         return (int)Math.signum(var0.doubleValue() - var1.doubleValue());
      }
   }

   static Number subtract(Number var0, Number var1) {
      if(!(var0 instanceof Double) && !(var1 instanceof Double)) {
         if(!(var0 instanceof Float) && !(var1 instanceof Float)) {
            if(!(var0 instanceof Long) && !(var1 instanceof Long)) {
               if(!(var0 instanceof Integer) && !(var1 instanceof Integer)) {
                  if(!(var0 instanceof Short) && !(var1 instanceof Short)) {
                     if(!(var0 instanceof Byte) && !(var1 instanceof Byte)) {
                        throw new RuntimeException("Unknown number type.");
                     } else {
                        return Integer.valueOf(var0.byteValue() - var1.byteValue());
                     }
                  } else {
                     return Integer.valueOf(var0.shortValue() - var1.shortValue());
                  }
               } else {
                  return Integer.valueOf(var0.intValue() - var1.intValue());
               }
            } else {
               return Long.valueOf(var0.longValue() - var1.longValue());
            }
         } else {
            return Float.valueOf(var0.floatValue() - var1.floatValue());
         }
      } else {
         return Double.valueOf(var0.doubleValue() - var1.doubleValue());
      }
   }
}
