package com.google.gson;

import com.google.gson.JsonElement;
import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class JsonPrimitive extends JsonElement {
   private static final Class<?>[] PRIMITIVE_TYPES;
   private Object value;

   static {
      Class[] var0 = new Class[]{Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
      PRIMITIVE_TYPES = var0;
   }

   public JsonPrimitive(Boolean var1) {
      this.setValue(var1);
   }

   public JsonPrimitive(Character var1) {
      this.setValue(var1);
   }

   public JsonPrimitive(Number var1) {
      this.setValue(var1);
   }

   JsonPrimitive(Object var1) {
      this.setValue(var1);
   }

   public JsonPrimitive(String var1) {
      this.setValue(var1);
   }

   private static boolean isIntegral(JsonPrimitive var0) {
      boolean var1 = var0.value instanceof Number;
      boolean var2 = false;
      if(var1) {
         Number var3 = (Number)var0.value;
         if(!(var3 instanceof BigInteger) && !(var3 instanceof Long) && !(var3 instanceof Integer) && !(var3 instanceof Short)) {
            boolean var4 = var3 instanceof Byte;
            var2 = false;
            if(!var4) {
               return var2;
            }
         }

         var2 = true;
      }

      return var2;
   }

   private static boolean isPrimitiveOrString(Object var0) {
      if(!(var0 instanceof String)) {
         Class var1 = var0.getClass();
         Class[] var2 = PRIMITIVE_TYPES;
         int var3 = var2.length;
         int var4 = 0;

         while(true) {
            if(var4 >= var3) {
               return false;
            }

            if(var2[var4].isAssignableFrom(var1)) {
               break;
            }

            ++var4;
         }
      }

      return true;
   }

   JsonPrimitive deepCopy() {
      return this;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 == null || this.getClass() != var1.getClass()) {
            return false;
         }

         JsonPrimitive var2 = (JsonPrimitive)var1;
         if(this.value == null) {
            if(var2.value != null) {
               return false;
            }
         } else {
            if(!isIntegral(this) || !isIntegral(var2)) {
               if(this.value instanceof Number && var2.value instanceof Number) {
                  double var3 = this.getAsNumber().doubleValue();
                  double var5 = var2.getAsNumber().doubleValue();
                  boolean var7;
                  if(var3 != var5) {
                     boolean var8 = Double.isNaN(var3);
                     var7 = false;
                     if(!var8) {
                        return var7;
                     }

                     boolean var9 = Double.isNaN(var5);
                     var7 = false;
                     if(!var9) {
                        return var7;
                     }
                  }

                  var7 = true;
                  return var7;
               } else {
                  return this.value.equals(var2.value);
               }
            }

            if(this.getAsNumber().longValue() != var2.getAsNumber().longValue()) {
               return false;
            }
         }
      }

      return true;
   }

   public BigDecimal getAsBigDecimal() {
      return this.value instanceof BigDecimal?(BigDecimal)this.value:new BigDecimal(this.value.toString());
   }

   public BigInteger getAsBigInteger() {
      return this.value instanceof BigInteger?(BigInteger)this.value:new BigInteger(this.value.toString());
   }

   public boolean getAsBoolean() {
      return this.isBoolean()?this.getAsBooleanWrapper().booleanValue():Boolean.parseBoolean(this.getAsString());
   }

   Boolean getAsBooleanWrapper() {
      return (Boolean)this.value;
   }

   public byte getAsByte() {
      return this.isNumber()?this.getAsNumber().byteValue():Byte.parseByte(this.getAsString());
   }

   public char getAsCharacter() {
      return this.getAsString().charAt(0);
   }

   public double getAsDouble() {
      return this.isNumber()?this.getAsNumber().doubleValue():Double.parseDouble(this.getAsString());
   }

   public float getAsFloat() {
      return this.isNumber()?this.getAsNumber().floatValue():Float.parseFloat(this.getAsString());
   }

   public int getAsInt() {
      return this.isNumber()?this.getAsNumber().intValue():Integer.parseInt(this.getAsString());
   }

   public long getAsLong() {
      return this.isNumber()?this.getAsNumber().longValue():Long.parseLong(this.getAsString());
   }

   public Number getAsNumber() {
      return (Number)(this.value instanceof String?new LazilyParsedNumber((String)this.value):(Number)this.value);
   }

   public short getAsShort() {
      return this.isNumber()?this.getAsNumber().shortValue():Short.parseShort(this.getAsString());
   }

   public String getAsString() {
      return this.isNumber()?this.getAsNumber().toString():(this.isBoolean()?this.getAsBooleanWrapper().toString():(String)this.value);
   }

   public int hashCode() {
      if(this.value == null) {
         return 31;
      } else if(isIntegral(this)) {
         long var3 = this.getAsNumber().longValue();
         return (int)(var3 ^ var3 >>> 32);
      } else if(this.value instanceof Number) {
         long var1 = Double.doubleToLongBits(this.getAsNumber().doubleValue());
         return (int)(var1 ^ var1 >>> 32);
      } else {
         return this.value.hashCode();
      }
   }

   public boolean isBoolean() {
      return this.value instanceof Boolean;
   }

   public boolean isNumber() {
      return this.value instanceof Number;
   }

   public boolean isString() {
      return this.value instanceof String;
   }

   void setValue(Object var1) {
      if(var1 instanceof Character) {
         this.value = String.valueOf(((Character)var1).charValue());
      } else {
         boolean var2;
         if(!(var1 instanceof Number) && !isPrimitiveOrString(var1)) {
            var2 = false;
         } else {
            var2 = true;
         }

         $Gson$Preconditions.checkArgument(var2);
         this.value = var1;
      }
   }
}
