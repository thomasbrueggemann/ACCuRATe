.class public final Lcz/msebera/android/httpclient/protocol/ImmutableHttpProcessor;
.super Ljava/lang/Object;
.source "ImmutableHttpProcessor.java"

# interfaces
.implements Lcz/msebera/android/httpclient/protocol/HttpProcessor;


# instance fields
.field private final requestInterceptors:[Lcz/msebera/android/httpclient/HttpRequestInterceptor;

.field private final responseInterceptors:[Lcz/msebera/android/httpclient/HttpResponseInterceptor;


# direct methods
.method public constructor <init>([Lcz/msebera/android/httpclient/HttpRequestInterceptor;[Lcz/msebera/android/httpclient/HttpResponseInterceptor;)V
    .locals 3
    .param p1, "requestInterceptors"    # [Lcz/msebera/android/httpclient/HttpRequestInterceptor;
    .param p2, "responseInterceptors"    # [Lcz/msebera/android/httpclient/HttpResponseInterceptor;

    .prologue
    const/4 v2, 0x0

    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 54
    if-eqz p1, :cond_0

    .line 55
    array-length v0, p1

    .line 56
    .local v0, "l":I
    new-array v1, v0, [Lcz/msebera/android/httpclient/HttpRequestInterceptor;

    iput-object v1, p0, Lcz/msebera/android/httpclient/protocol/ImmutableHttpProcessor;->requestInterceptors:[Lcz/msebera/android/httpclient/HttpRequestInterceptor;

    .line 57
    iget-object v1, p0, Lcz/msebera/android/httpclient/protocol/ImmutableHttpProcessor;->requestInterceptors:[Lcz/msebera/android/httpclient/HttpRequestInterceptor;

    invoke-static {p1, v2, v1, v2, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 61
    .end local v0    # "l":I
    :goto_0
    if-eqz p2, :cond_1

    .line 62
    array-length v0, p2

    .line 63
    .restart local v0    # "l":I
    new-array v1, v0, [Lcz/msebera/android/httpclient/HttpResponseInterceptor;

    iput-object v1, p0, Lcz/msebera/android/httpclient/protocol/ImmutableHttpProcessor;->responseInterceptors:[Lcz/msebera/android/httpclient/HttpResponseInterceptor;

    .line 64
    iget-object v1, p0, Lcz/msebera/android/httpclient/protocol/ImmutableHttpProcessor;->responseInterceptors:[Lcz/msebera/android/httpclient/HttpResponseInterceptor;

    invoke-static {p2, v2, v1, v2, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 68
    .end local v0    # "l":I
    :goto_1
    return-void

    .line 59
    :cond_0
    new-array v1, v2, [Lcz/msebera/android/httpclient/HttpRequestInterceptor;

    iput-object v1, p0, Lcz/msebera/android/httpclient/protocol/ImmutableHttpProcessor;->requestInterceptors:[Lcz/msebera/android/httpclient/HttpRequestInterceptor;

    goto :goto_0

    .line 66
    :cond_1
    new-array v1, v2, [Lcz/msebera/android/httpclient/HttpResponseInterceptor;

    iput-object v1, p0, Lcz/msebera/android/httpclient/protocol/ImmutableHttpProcessor;->responseInterceptors:[Lcz/msebera/android/httpclient/HttpResponseInterceptor;

    goto :goto_1
.end method


# virtual methods
.method public process(Lcz/msebera/android/httpclient/HttpRequest;Lcz/msebera/android/httpclient/protocol/HttpContext;)V
    .locals 4
    .param p1, "request"    # Lcz/msebera/android/httpclient/HttpRequest;
    .param p2, "context"    # Lcz/msebera/android/httpclient/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcz/msebera/android/httpclient/HttpException;
        }
    .end annotation

    .prologue
    .line 130
    iget-object v2, p0, Lcz/msebera/android/httpclient/protocol/ImmutableHttpProcessor;->requestInterceptors:[Lcz/msebera/android/httpclient/HttpRequestInterceptor;

    array-length v3, v2

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v3, :cond_0

    aget-object v0, v2, v1

    .line 131
    .local v0, "requestInterceptor":Lcz/msebera/android/httpclient/HttpRequestInterceptor;
    invoke-interface {v0, p1, p2}, Lcz/msebera/android/httpclient/HttpRequestInterceptor;->process(Lcz/msebera/android/httpclient/HttpRequest;Lcz/msebera/android/httpclient/protocol/HttpContext;)V

    .line 130
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 133
    .end local v0    # "requestInterceptor":Lcz/msebera/android/httpclient/HttpRequestInterceptor;
    :cond_0
    return-void
.end method

.method public process(Lcz/msebera/android/httpclient/HttpResponse;Lcz/msebera/android/httpclient/protocol/HttpContext;)V
    .locals 4
    .param p1, "response"    # Lcz/msebera/android/httpclient/HttpResponse;
    .param p2, "context"    # Lcz/msebera/android/httpclient/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcz/msebera/android/httpclient/HttpException;
        }
    .end annotation

    .prologue
    .line 138
    iget-object v2, p0, Lcz/msebera/android/httpclient/protocol/ImmutableHttpProcessor;->responseInterceptors:[Lcz/msebera/android/httpclient/HttpResponseInterceptor;

    array-length v3, v2

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v3, :cond_0

    aget-object v0, v2, v1

    .line 139
    .local v0, "responseInterceptor":Lcz/msebera/android/httpclient/HttpResponseInterceptor;
    invoke-interface {v0, p1, p2}, Lcz/msebera/android/httpclient/HttpResponseInterceptor;->process(Lcz/msebera/android/httpclient/HttpResponse;Lcz/msebera/android/httpclient/protocol/HttpContext;)V

    .line 138
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 141
    .end local v0    # "responseInterceptor":Lcz/msebera/android/httpclient/HttpResponseInterceptor;
    :cond_0
    return-void
.end method
