package com.crittercism.error;

public class CRXMLHttpRequestException extends Exception {
    private static final long serialVersionUID = 1515011187293165939L;

    public CRXMLHttpRequestException(String var1) {
        this(var1, (Throwable)null);
    }

    public CRXMLHttpRequestException(String var1, Throwable var2) {
        super(var1, var2);
    }

    public CRXMLHttpRequestException(Throwable var1) {
        super(var1);
    }
}
