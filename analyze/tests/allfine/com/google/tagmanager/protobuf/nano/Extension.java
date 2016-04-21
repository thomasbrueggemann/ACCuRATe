package com.google.tagmanager.protobuf.nano;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class Extension<T> {
    public final int fieldNumber;
    public Class<T> fieldType;
    public boolean isRepeatedField;
    public Class<T> listType;

    private Extension(int var1, Extension.TypeLiteral<T> var2) {
        this.fieldNumber = var1;
        this.isRepeatedField = var2.isList();
        this.fieldType = var2.getTargetClass();
        Class var3;
        if(this.isRepeatedField) {
            var3 = var2.getListType();
        } else {
            var3 = null;
        }

        this.listType = var3;
    }

    public static <T> Extension<T> create(int var0, Extension.TypeLiteral<T> var1) {
        return new Extension(var0, var1);
    }

    public static <T> Extension<List<T>> createRepeated(int var0, Extension.TypeLiteral<List<T>> var1) {
        return new Extension(var0, var1);
    }

    public abstract static class TypeLiteral<T> {
        private final Type type;

        protected TypeLiteral() {
            Type var1 = this.getClass().getGenericSuperclass();
            if(var1 instanceof Class) {
                throw new RuntimeException("Missing type parameter");
            } else {
                this.type = ((ParameterizedType)var1).getActualTypeArguments()[0];
            }
        }

        private Class<T> getListType() {
            return (Class)((ParameterizedType)this.type).getRawType();
        }

        private Class<T> getTargetClass() {
            return this.isList()?(Class)((ParameterizedType)this.type).getActualTypeArguments()[0]:(Class)this.type;
        }

        private boolean isList() {
            return this.type instanceof ParameterizedType;
        }
    }
}
