package com.squareup.okhttp.internal.spdy;

public enum ErrorCode {
    CANCEL(8, 5, -1),
    COMPRESSION_ERROR(9, -1, -1),
    FLOW_CONTROL_ERROR(3, 7, -1),
    FRAME_TOO_LARGE(6, 11, -1),
    INTERNAL_ERROR(2, 6, 2),
    INVALID_CREDENTIALS(-1, 10, -1),
    INVALID_STREAM(1, 2, -1),
    NO_ERROR(0, -1, 0),
    PROTOCOL_ERROR(1, 1, 1),
    REFUSED_STREAM(7, 3, -1),
    STREAM_ALREADY_CLOSED(1, 9, -1),
    STREAM_CLOSED(5, -1, -1),
    STREAM_IN_USE(1, 8, -1),
    UNSUPPORTED_VERSION(1, 4, -1);

    public final int httpCode;
    public final int spdyGoAwayCode;
    public final int spdyRstCode;

    static {
        ErrorCode[] var0 = new ErrorCode[]{NO_ERROR, PROTOCOL_ERROR, INVALID_STREAM, UNSUPPORTED_VERSION, STREAM_IN_USE, STREAM_ALREADY_CLOSED, INTERNAL_ERROR, FLOW_CONTROL_ERROR, STREAM_CLOSED, FRAME_TOO_LARGE, REFUSED_STREAM, CANCEL, COMPRESSION_ERROR, INVALID_CREDENTIALS};
    }

    private ErrorCode(int var3, int var4, int var5) {
        this.httpCode = var3;
        this.spdyRstCode = var4;
        this.spdyGoAwayCode = var5;
    }

    public static ErrorCode fromHttp2(int var0) {
        ErrorCode[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ErrorCode var4 = var1[var3];
            if(var4.httpCode == var0) {
                return var4;
            }
        }

        return null;
    }

    public static ErrorCode fromSpdy3Rst(int var0) {
        ErrorCode[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ErrorCode var4 = var1[var3];
            if(var4.spdyRstCode == var0) {
                return var4;
            }
        }

        return null;
    }

    public static ErrorCode fromSpdyGoAway(int var0) {
        ErrorCode[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ErrorCode var4 = var1[var3];
            if(var4.spdyGoAwayCode == var0) {
                return var4;
            }
        }

        return null;
    }
}
