package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.FunctionCallImplementation;
import com.google.tagmanager.Log;
import com.google.tagmanager.Types;
import com.google.tagmanager.ValueEscapeUtil;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class JoinerMacro extends FunctionCallImplementation {
    private static final String ARG0;
    private static final String DEFAULT_ITEM_SEPARATOR = "";
    private static final String DEFAULT_KEY_VALUE_SEPARATOR = "=";
    private static final String ESCAPE;
    // $FF: renamed from: ID java.lang.String
    private static final String field_749;
    private static final String ITEM_SEPARATOR;
    private static final String KEY_VALUE_SEPARATOR;

    static {
        field_749 = FunctionType.JOINER.toString();
        ARG0 = Key.ARG0.toString();
        ITEM_SEPARATOR = Key.ITEM_SEPARATOR.toString();
        KEY_VALUE_SEPARATOR = Key.KEY_VALUE_SEPARATOR.toString();
        ESCAPE = Key.ESCAPE.toString();
    }

    public JoinerMacro() {
        String var1 = field_749;
        String[] var2 = new String[] {ARG0};
        super(var1, var2);
    }

    private void addTo(Set<Character> var1, String var2) {
        for(int var3 = 0; var3 < var2.length(); ++var3) {
            var1.add(Character.valueOf(var2.charAt(var3)));
        }

    }

    private void append(StringBuilder var1, String var2, JoinerMacro.EscapeType var3, Set<Character> var4) {
        var1.append(this.escape(var2, var3, var4));
    }

    private String escape(String var1, JoinerMacro.EscapeType var2, Set<Character> var3) {
        switch(null.$SwitchMap$com$google$tagmanager$JoinerMacro$EscapeType[var2.ordinal()]) {
            case 1:
                try {
                    String var8 = ValueEscapeUtil.urlEncode(var1);
                    return var8;
                } catch (UnsupportedEncodingException var9) {
                    Log.method_5504("Joiner: unsupported encoding", var9);
                    return var1;
                }
            case 2:
                String var4 = var1.replace("\\", "\\\\");

                String var6;
                for(Iterator var5 = var3.iterator(); var5.hasNext(); var4 = var4.replace(var6, "\\" + var6)) {
                    var6 = ((Character)var5.next()).toString();
                }

                return var4;
            default:
                return var1;
        }
    }

    public static String getFunctionId() {
        return field_749;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> var1) {
        TypeSystem.Value var2 = (TypeSystem.Value)var1.get(ARG0);
        if(var2 == null) {
            return Types.getDefaultValue();
        } else {
            TypeSystem.Value var3 = (TypeSystem.Value)var1.get(ITEM_SEPARATOR);
            String var4;
            if(var3 != null) {
                var4 = Types.valueToString(var3);
            } else {
                var4 = "";
            }

            TypeSystem.Value var5 = (TypeSystem.Value)var1.get(KEY_VALUE_SEPARATOR);
            String var6;
            if(var5 != null) {
                var6 = Types.valueToString(var5);
            } else {
                var6 = "=";
            }

            JoinerMacro.EscapeType var7 = JoinerMacro.EscapeType.NONE;
            TypeSystem.Value var8 = (TypeSystem.Value)var1.get(ESCAPE);
            HashSet var9 = null;
            if(var8 != null) {
                String var22 = Types.valueToString(var8);
                if("url".equals(var22)) {
                    var7 = JoinerMacro.EscapeType.URL;
                } else {
                    if(!"backslash".equals(var22)) {
                        Log.method_5503("Joiner: unsupported escape type: " + var22);
                        return Types.getDefaultValue();
                    }

                    var7 = JoinerMacro.EscapeType.BACKSLASH;
                    var9 = new HashSet();
                    this.addTo(var9, var4);
                    this.addTo(var9, var6);
                    var9.remove(Character.valueOf('\\'));
                }
            }

            StringBuilder var10 = new StringBuilder();
            switch(var2.type) {
                case 2:
                    boolean var16 = true;
                    TypeSystem.Value[] var17 = var2.listItem;
                    int var18 = var17.length;

                    for(int var19 = 0; var19 < var18; var16 = false) {
                        TypeSystem.Value var20 = var17[var19];
                        if(!var16) {
                            var10.append(var4);
                        }

                        this.append(var10, Types.valueToString(var20), var7, var9);
                        ++var19;
                    }

                    return Types.objectToValue(var10.toString());
                case 3:
                    for(int var11 = 0; var11 < var2.mapKey.length; ++var11) {
                        if(var11 > 0) {
                            var10.append(var4);
                        }

                        String var12 = Types.valueToString(var2.mapKey[var11]);
                        String var13 = Types.valueToString(var2.mapValue[var11]);
                        this.append(var10, var12, var7, var9);
                        var10.append(var6);
                        this.append(var10, var13, var7, var9);
                    }

                    return Types.objectToValue(var10.toString());
                default:
                    this.append(var10, Types.valueToString(var2), var7, var9);
                    return Types.objectToValue(var10.toString());
            }
        }
    }

    public boolean isCacheable() {
        return true;
    }

    private static enum EscapeType {
        BACKSLASH,
        NONE,
        URL;

        static {
            JoinerMacro.EscapeType[] var0 = new JoinerMacro.EscapeType[]{NONE, URL, BACKSLASH};
        }
    }
}
