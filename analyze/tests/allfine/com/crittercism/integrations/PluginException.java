package com.crittercism.integrations;

import crittercism.android.class_764;

public class PluginException extends Throwable {
    private static final String EMPTY_STRING = "";
    private static final long serialVersionUID = -1947260712494608235L;
    private String exceptionName;

    private PluginException(String var1) {
        super(var1);
        this.exceptionName = null;
    }

    public PluginException(String var1, String var2) {
        this("", var1, var2);
    }

    public PluginException(String var1, String var2, String var3) {
        super(var2);
        this.exceptionName = null;
        this.setExceptionName(checkString(var1), checkString(var2));
        this.setStackTrace(this.createStackTraceArrayFromStack(checkStringStack(var3)));
    }

    public PluginException(String var1, String var2, String[] var3, String[] var4, String[] var5, int[] var6) {
        super(var2);
        this.exceptionName = null;
        this.setExceptionName(checkString(var1), checkString(var2));
        this.setStackTrace(this.createStackTraceArrayFromStack(var3, var4, var5, var6));
    }

    private static String checkString(String var0) {
        if(var0 == null) {
            var0 = "";
        }

        return var0;
    }

    private static String[] checkStringStack(String var0) {
        return var0 == null?new String[0]:var0.split("\\r?\\n");
    }

    private StackTraceElement[] createStackTraceArrayFromStack(String[] var1) {
        StackTraceElement[] var2;
        boolean var3;
        if(var1.length >= 2 && var1[0] != null && var1[1] != null && var1[0].equals(var1[1])) {
            StackTraceElement[] var6 = new StackTraceElement[-1 + var1.length];
            var3 = true;
            var2 = var6;
        } else {
            var2 = null;
            var3 = false;
        }

        int var4 = 0;
        if(!var3) {
            var2 = new StackTraceElement[var1.length];
        }

        for(; var4 < var1.length; ++var4) {
            if(var4 != 0 || !var3) {
                int var5;
                if(var3) {
                    var5 = var4 - 1;
                } else {
                    var5 = var4;
                }

                var2[var5] = new StackTraceElement("", var1[var4], "", -1);
            }
        }

        return var2;
    }

    private StackTraceElement[] createStackTraceArrayFromStack(String[] var1, String[] var2, String[] var3, int[] var4) {
        int var5 = var1.length;
        StackTraceElement[] var6 = new StackTraceElement[var5];

        for(int var7 = 0; var7 < var5; ++var7) {
            int var8 = var4[var7];
            if(var8 <= 0) {
                var8 = -1;
            }

            var6[var7] = new StackTraceElement(checkString(var1[var7]), checkString(var2[var7]), checkString(var3[var7]), var8);
        }

        return var6;
    }

    public static PluginException createUnityException(String var0, String var1) {
        try {
            PluginException var4 = unsafeCreateUnityException(var0, var1);
            return var4;
        } catch (ThreadDeath var5) {
            throw var5;
        } catch (Throwable var6) {
            class_764.method_4018("Unable to log unity exception <" + var0 + "> " + var1, var6);
            return null;
        }
    }

    private static PluginException unsafeCreateUnityException(String var0, String var1) {
        if(var0 == null) {
            var0 = "";
        }

        if(var1 == null) {
            var1 = "";
        }

        int var2 = var0.indexOf(":");
        String var3;
        if(var2 != -1) {
            var3 = var0.substring(0, var2).trim();
            if(var2 + 1 < var0.length()) {
                var0 = var0.substring(var2 + 1).trim();
            }
        } else {
            var3 = var0;
        }

        PluginException var4 = new PluginException(var0);
        var4.exceptionName = var3;
        String var5 = var1.trim();
        if(var5.length() == 0) {
            var4.setStackTrace(new StackTraceElement[0]);
            return var4;
        } else {
            String[] var6 = var5.split("\\r?\\n");
            StackTraceElement[] var7 = new StackTraceElement[var6.length];

            for(int var8 = 0; var8 < var6.length; ++var8) {
                String var9 = var6[var8].trim();
                if(var9.length() != 0) {
                    String var10 = var9.split(" ")[0];
                    int var11 = var10.lastIndexOf(".");
                    if(var11 == -1) {
                        class_764.method_4021("Unable to parse unity exception.  No class and method found for frame frame <" + var9 + ">" + var5);
                        return null;
                    }

                    if(var11 == -1 + var10.length()) {
                        class_764.method_4021("Unable to parse unity exception.  Method is zero length for frame <" + var9 + ">" + var5);
                        return null;
                    }

                    String var12 = var10.substring(0, var11);
                    String var13 = var10.substring(var11 + 1);
                    int var14 = -1;
                    int var15 = var9.indexOf(" (at ");
                    String var16 = null;
                    if(var15 != -1) {
                        String var17 = var9.substring(var15 + 5, -1 + var6[var8].length());
                        String[] var18 = var17.split(":");
                        if(var18.length >= 2) {
                            label67: {
                                var16 = var18[0];

                                String var23;
                                try {
                                    String var22 = var18[-1 + var18.length];
                                    var14 = Integer.parseInt(var22);
                                    var23 = var17.substring(0, -1 + (var17.length() - var22.length()));
                                } catch (NumberFormatException var24) {
                                    (new StringBuilder("Couldn\'t parse integer: ")).append(var18[1]);
                                    class_764.method_4015();
                                    break label67;
                                }

                                var16 = var23;
                            }
                        } else {
                            (new StringBuilder("Unable to parse file & line out of Unity stack trace frame: ")).append(var18).append(" ::: ").append(var6[var8]);
                            class_764.method_4020();
                            var16 = null;
                        }
                    }

                    var7[var8] = new StackTraceElement(var12, var13, var16, var14);
                }
            }

            var4.setStackTrace(var7);
            return var4;
        }
    }

    public String getExceptionName() {
        return this.exceptionName;
    }

    public void setExceptionName(String var1, String var2) {
        if(var1.length() > 0) {
            this.exceptionName = var1;
        } else {
            this.exceptionName = "JavaScript Exception";
        }
    }

    public final String toString() {
        String var1 = this.getLocalizedMessage();
        String var2 = this.getExceptionName();
        return var1 == null?var2:var2 + ": " + var1;
    }
}
