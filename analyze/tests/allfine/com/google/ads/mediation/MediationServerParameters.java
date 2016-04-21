package com.google.ads.mediation;

import com.google.android.gms.internal.class_378;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

@Deprecated
public abstract class MediationServerParameters {
    // $FF: renamed from: a () void
    protected void method_2220() {
    }

    public void load(Map<String, String> var1) throws MediationServerParameters.MappingException {
        HashMap var2 = new HashMap();
        Field[] var3 = this.getClass().getFields();
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Field var16 = var3[var5];
            MediationServerParameters.Parameter var17 = (MediationServerParameters.Parameter)var16.getAnnotation(MediationServerParameters.Parameter.class);
            if(var17 != null) {
                var2.put(var17.name(), var16);
            }
        }

        if(var2.isEmpty()) {
            class_378.method_2461("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
        }

        Iterator var6 = var1.entrySet().iterator();

        while(var6.hasNext()) {
            Entry var12 = (Entry)var6.next();
            Field var13 = (Field)var2.remove(var12.getKey());
            if(var13 != null) {
                try {
                    var13.set(this, var12.getValue());
                } catch (IllegalAccessException var18) {
                    class_378.method_2461("Server option \"" + (String)var12.getKey() + "\" could not be set: Illegal Access");
                } catch (IllegalArgumentException var19) {
                    class_378.method_2461("Server option \"" + (String)var12.getKey() + "\" could not be set: Bad Type");
                }
            } else {
                class_378.method_2457("Unexpected server option: " + (String)var12.getKey() + " = \"" + (String)var12.getValue() + "\"");
            }
        }

        StringBuilder var7 = new StringBuilder();
        Iterator var8 = var2.values().iterator();

        while(var8.hasNext()) {
            Field var9 = (Field)var8.next();
            if(((MediationServerParameters.Parameter)var9.getAnnotation(MediationServerParameters.Parameter.class)).required()) {
                class_378.method_2461("Required server option missing: " + ((MediationServerParameters.Parameter)var9.getAnnotation(MediationServerParameters.Parameter.class)).name());
                if(var7.length() > 0) {
                    var7.append(", ");
                }

                var7.append(((MediationServerParameters.Parameter)var9.getAnnotation(MediationServerParameters.Parameter.class)).name());
            }
        }

        if(var7.length() > 0) {
            throw new MediationServerParameters.MappingException("Required server option(s) missing: " + var7.toString());
        } else {
            this.method_2220();
        }
    }

    public static final class MappingException extends Exception {
        public MappingException(String var1) {
            super(var1);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.FIELD})
    protected @interface Parameter {
        String name();

    boolean required() default true;
    }
}
