package com.google.tagmanager.protobuf.nano;

import com.google.tagmanager.protobuf.nano.MessageNano;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

public final class MessageNanoPrinter {
    private static final String INDENT = "  ";
    private static final int MAX_STRING_LEN = 200;

    private static String deCamelCaseify(String var0) {
        StringBuffer var1 = new StringBuffer();

        for(int var2 = 0; var2 < var0.length(); ++var2) {
            char var3 = var0.charAt(var2);
            if(var2 == 0) {
                var1.append(Character.toLowerCase(var3));
            } else if(Character.isUpperCase(var3)) {
                var1.append('_').append(Character.toLowerCase(var3));
            } else {
                var1.append(var3);
            }
        }

        return var1.toString();
    }

    private static String escapeString(String var0) {
        int var1 = var0.length();
        StringBuilder var2 = new StringBuilder(var1);

        for(int var3 = 0; var3 < var1; ++var3) {
            char var4 = var0.charAt(var3);
            if(var4 >= 32 && var4 <= 126 && var4 != 34 && var4 != 39) {
                var2.append(var4);
            } else {
                Object[] var5 = new Object[] {Integer.valueOf(var4)};
                var2.append(String.format("\\u%04x", var5));
            }
        }

        return var2.toString();
    }

    public static <T extends MessageNano> String print(T var0) {
        if(var0 == null) {
            return "null";
        } else {
            StringBuffer var1 = new StringBuffer();

            try {
                print(var0.getClass().getSimpleName(), var0.getClass(), var0, new StringBuffer(), var1);
            } catch (IllegalAccessException var3) {
                return "Error printing proto: " + var3.getMessage();
            }

            return var1.toString();
        }
    }

    private static void print(String var0, Class<?> var1, Object var2, StringBuffer var3, StringBuffer var4) throws IllegalAccessException {
        if(MessageNano.class.isAssignableFrom(var1)) {
            if(var2 != null) {
                var4.append(var3).append(var0);
                var3.append("  ");
                var4.append(" <\n");
                Field[] var14 = var1.getFields();
                int var15 = var14.length;

                for(int var16 = 0; var16 < var15; ++var16) {
                    Field var19 = var14[var16];
                    int var20 = var19.getModifiers();
                    String var21 = var19.getName();
                    if((var20 & 1) == 1 && (var20 & 8) != 8 && !var21.startsWith("_") && !var21.endsWith("_")) {
                        Class var22 = var19.getType();
                        Object var23 = var19.get(var2);
                        if(var22.isArray()) {
                            Class var24 = var22.getComponentType();
                            if(var24 == Byte.TYPE) {
                                print(var21, var22, var23, var3, var4);
                            } else {
                                int var25;
                                if(var23 == null) {
                                    var25 = 0;
                                } else {
                                    var25 = Array.getLength(var23);
                                }

                                for(int var26 = 0; var26 < var25; ++var26) {
                                    print(var21, var24, Array.get(var23, var26), var3, var4);
                                }
                            }
                        } else {
                            print(var21, var22, var23, var3, var4);
                        }
                    }
                }

                var3.delete(var3.length() - "  ".length(), var3.length());
                var4.append(var3).append(">\n");
                return;
            }
        } else if(var2 != null) {
            String var5 = deCamelCaseify(var0);
            var4.append(var3).append(var5).append(": ");
            if(var2 instanceof String) {
                String var9 = sanitizeString((String)var2);
                var4.append("\"").append(var9).append("\"");
            } else {
                var4.append(var2);
            }

            var4.append("\n");
            return;
        }

    }

    private static String sanitizeString(String var0) {
        if(!var0.startsWith("http") && var0.length() > 200) {
            var0 = var0.substring(0, 200) + "[...]";
        }

        return escapeString(var0);
    }
}
