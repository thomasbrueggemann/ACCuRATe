package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.Log;
import com.google.tagmanager.TypedNumber;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

class Types {
    private static Boolean DEFAULT_BOOLEAN = new Boolean(false);
    private static Double DEFAULT_DOUBLE = new Double(0.0D);
    private static Long DEFAULT_INT64 = new Long(0L);
    private static List<Object> DEFAULT_LIST = new ArrayList(0);
    private static Map<Object, Object> DEFAULT_MAP = new HashMap();
    private static TypedNumber DEFAULT_NUMBER = TypedNumber.numberWithInt64(0L);
    private static final Object DEFAULT_OBJECT = null;
    private static String DEFAULT_STRING = new String("");
    private static TypeSystem.Value DEFAULT_VALUE;

    static {
        DEFAULT_VALUE = objectToValue(DEFAULT_STRING);
    }

    public static TypeSystem.Value functionIdToValue(String var0) {
        TypeSystem.Value var1 = new TypeSystem.Value();
        var1.type = 5;
        var1.functionId = var0;
        return var1;
    }

    public static Boolean getDefaultBoolean() {
        return DEFAULT_BOOLEAN;
    }

    public static Double getDefaultDouble() {
        return DEFAULT_DOUBLE;
    }

    public static Long getDefaultInt64() {
        return DEFAULT_INT64;
    }

    public static List<Object> getDefaultList() {
        return DEFAULT_LIST;
    }

    public static Map<Object, Object> getDefaultMap() {
        return DEFAULT_MAP;
    }

    public static TypedNumber getDefaultNumber() {
        return DEFAULT_NUMBER;
    }

    public static Object getDefaultObject() {
        return DEFAULT_OBJECT;
    }

    public static String getDefaultString() {
        return DEFAULT_STRING;
    }

    public static TypeSystem.Value getDefaultValue() {
        return DEFAULT_VALUE;
    }

    private static double getDouble(Object var0) {
        if(var0 instanceof Number) {
            return ((Number)var0).doubleValue();
        } else {
            Log.method_5503("getDouble received non-Number");
            return 0.0D;
        }
    }

    private static long getInt64(Object var0) {
        if(var0 instanceof Number) {
            return ((Number)var0).longValue();
        } else {
            Log.method_5503("getInt64 received non-Number");
            return 0L;
        }
    }

    private static boolean isDoubleableNumber(Object var0) {
        return var0 instanceof Double || var0 instanceof Float || var0 instanceof TypedNumber && ((TypedNumber)var0).isDouble();
    }

    private static boolean isInt64ableNumber(Object var0) {
        return var0 instanceof Byte || var0 instanceof Short || var0 instanceof Integer || var0 instanceof Long || var0 instanceof TypedNumber && ((TypedNumber)var0).isInt64();
    }

    public static TypeSystem.Value macroReferenceToValue(String var0, int... var1) {
        TypeSystem.Value var2 = new TypeSystem.Value();
        var2.type = 4;
        var2.macroReference = var0;
        var2.containsReferences = true;
        var2.escaping = (int[])var1.clone();
        return var2;
    }

    public static Boolean objectToBoolean(Object var0) {
        return var0 instanceof Boolean?(Boolean)var0:parseBoolean(objectToString(var0));
    }

    public static Double objectToDouble(Object var0) {
        return isDoubleableNumber(var0)?Double.valueOf(getDouble(var0)):parseDouble(objectToString(var0));
    }

    public static Long objectToInt64(Object var0) {
        return isInt64ableNumber(var0)?Long.valueOf(getInt64(var0)):parseInt64(objectToString(var0));
    }

    public static TypedNumber objectToNumber(Object var0) {
        return var0 instanceof TypedNumber?(TypedNumber)var0:(isInt64ableNumber(var0)?TypedNumber.numberWithInt64(getInt64(var0)):(isDoubleableNumber(var0)?TypedNumber.numberWithDouble(Double.valueOf(getDouble(var0))):parseNumber(objectToString(var0))));
    }

    public static String objectToString(Object var0) {
        return var0 == null?DEFAULT_STRING:var0.toString();
    }

    public static TypeSystem.Value objectToValue(Object var0) {
        TypeSystem.Value var1 = new TypeSystem.Value();
        boolean var2 = false;
        if(var0 instanceof TypeSystem.Value) {
            return (TypeSystem.Value)var0;
        } else {
            if(var0 instanceof String) {
                var1.type = 1;
                var1.string = (String)var0;
            } else if(var0 instanceof List) {
                var1.type = 2;
                List var14 = (List)var0;
                ArrayList var15 = new ArrayList(var14.size());

                TypeSystem.Value var17;
                for(Iterator var16 = var14.iterator(); var16.hasNext(); var15.add(var17)) {
                    var17 = objectToValue(var16.next());
                    if(var17 == DEFAULT_VALUE) {
                        return DEFAULT_VALUE;
                    }

                    if(!var2 && !var17.containsReferences) {
                        var2 = false;
                    } else {
                        var2 = true;
                    }
                }

                var1.listItem = (TypeSystem.Value[])var15.toArray(new TypeSystem.Value[0]);
            } else if(!(var0 instanceof Map)) {
                if(isDoubleableNumber(var0)) {
                    var1.type = 1;
                    var1.string = var0.toString();
                    var2 = false;
                } else if(isInt64ableNumber(var0)) {
                    var1.type = 6;
                    var1.integer = getInt64(var0);
                    var2 = false;
                } else {
                    if(!(var0 instanceof Boolean)) {
                        StringBuilder var3 = (new StringBuilder()).append("Converting to Value from unknown object type: ");
                        String var4;
                        if(var0 == null) {
                            var4 = "null";
                        } else {
                            var4 = var0.getClass().toString();
                        }

                        Log.method_5503(var3.append(var4).toString());
                        return DEFAULT_VALUE;
                    }

                    var1.type = 8;
                    var1.boolean_ = ((Boolean)var0).booleanValue();
                    var2 = false;
                }
            } else {
                var1.type = 3;
                Set var5 = ((Map)var0).entrySet();
                ArrayList var6 = new ArrayList(var5.size());
                ArrayList var7 = new ArrayList(var5.size());
                Iterator var8 = var5.iterator();

                while(true) {
                    if(!var8.hasNext()) {
                        var1.mapKey = (TypeSystem.Value[])var6.toArray(new TypeSystem.Value[0]);
                        var1.mapValue = (TypeSystem.Value[])var7.toArray(new TypeSystem.Value[0]);
                        break;
                    }

                    Entry var9 = (Entry)var8.next();
                    TypeSystem.Value var10 = objectToValue(var9.getKey());
                    TypeSystem.Value var11 = objectToValue(var9.getValue());
                    if(var10 == DEFAULT_VALUE || var11 == DEFAULT_VALUE) {
                        return DEFAULT_VALUE;
                    }

                    if(!var2 && !var10.containsReferences && !var11.containsReferences) {
                        var2 = false;
                    } else {
                        var2 = true;
                    }

                    var6.add(var10);
                    var7.add(var11);
                }
            }

            var1.containsReferences = var2;
            return var1;
        }
    }

    private static Boolean parseBoolean(String var0) {
        return "true".equalsIgnoreCase(var0)?Boolean.TRUE:("false".equalsIgnoreCase(var0)?Boolean.FALSE:DEFAULT_BOOLEAN);
    }

    private static Double parseDouble(String var0) {
        TypedNumber var1 = parseNumber(var0);
        return var1 == DEFAULT_NUMBER?DEFAULT_DOUBLE:Double.valueOf(var1.doubleValue());
    }

    private static Long parseInt64(String var0) {
        TypedNumber var1 = parseNumber(var0);
        return var1 == DEFAULT_NUMBER?DEFAULT_INT64:Long.valueOf(var1.longValue());
    }

    private static TypedNumber parseNumber(String var0) {
        try {
            TypedNumber var2 = TypedNumber.numberWithString(var0);
            return var2;
        } catch (NumberFormatException var3) {
            Log.method_5503("Failed to convert \'" + var0 + "\' to a number.");
            return DEFAULT_NUMBER;
        }
    }

    public static TypeSystem.Value templateToValue(TypeSystem.Value... var0) {
        TypeSystem.Value var1 = new TypeSystem.Value();
        var1.type = 7;
        boolean var2 = false;
        var1.templateToken = new TypeSystem.Value[var0.length];

        for(int var3 = 0; var3 < var0.length; ++var3) {
            var1.templateToken[var3] = var0[var3];
            if(!var2 && !var0[var3].containsReferences) {
                var2 = false;
            } else {
                var2 = true;
            }
        }

        var1.containsReferences = var2;
        return var1;
    }

    public static Boolean valueToBoolean(TypeSystem.Value var0) {
        return objectToBoolean(valueToObject(var0));
    }

    public static Double valueToDouble(TypeSystem.Value var0) {
        return objectToDouble(valueToObject(var0));
    }

    public static Long valueToInt64(TypeSystem.Value var0) {
        return objectToInt64(valueToObject(var0));
    }

    public static TypedNumber valueToNumber(TypeSystem.Value var0) {
        return objectToNumber(valueToObject(var0));
    }

    public static Object valueToObject(TypeSystem.Value var0) {
        Object var12;
        if(var0 == null) {
            var12 = DEFAULT_OBJECT;
        } else {
            switch(var0.type) {
                case 1:
                    return var0.string;
                case 2:
                    var12 = new ArrayList(var0.listItem.length);
                    TypeSystem.Value[] var13 = var0.listItem;
                    int var14 = var13.length;

                    for(int var15 = 0; var15 < var14; ++var15) {
                        Object var16 = valueToObject(var13[var15]);
                        if(var16 == DEFAULT_OBJECT) {
                            return DEFAULT_OBJECT;
                        }

                        ((ArrayList)var12).add(var16);
                    }
                    break;
                case 3:
                    if(var0.mapKey.length != var0.mapValue.length) {
                        Log.method_5503("Converting an invalid value to object: " + var0.toString());
                        return DEFAULT_OBJECT;
                    }

                    LinkedHashMap var7 = new LinkedHashMap(var0.mapValue.length);

                    for(int var8 = 0; var8 < var0.mapKey.length; ++var8) {
                        Object var9 = valueToObject(var0.mapKey[var8]);
                        Object var10 = valueToObject(var0.mapValue[var8]);
                        if(var9 == DEFAULT_OBJECT || var10 == DEFAULT_OBJECT) {
                            return DEFAULT_OBJECT;
                        }

                        var7.put(var9, var10);
                    }

                    return var7;
                case 4:
                    Log.method_5503("Trying to convert a macro reference to object");
                    return DEFAULT_OBJECT;
                case 5:
                    Log.method_5503("Trying to convert a function id to object");
                    return DEFAULT_OBJECT;
                case 6:
                    return Long.valueOf(var0.integer);
                case 7:
                    StringBuffer var1 = new StringBuffer();
                    TypeSystem.Value[] var2 = var0.templateToken;
                    int var3 = var2.length;

                    for(int var4 = 0; var4 < var3; ++var4) {
                        String var5 = valueToString(var2[var4]);
                        if(var5 == DEFAULT_STRING) {
                            return DEFAULT_OBJECT;
                        }

                        var1.append(var5);
                    }

                    return var1.toString();
                case 8:
                    return Boolean.valueOf(var0.boolean_);
                default:
                    Log.method_5503("Failed to convert a value of type: " + var0.type);
                    return DEFAULT_OBJECT;
            }
        }

        return var12;
    }

    public static String valueToString(TypeSystem.Value var0) {
        return objectToString(valueToObject(var0));
    }
}
