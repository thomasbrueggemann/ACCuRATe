.class public Lcz/msebera/android/httpclient/protocol/RequestTargetHost;
.super Ljava/lang/Object;
.source "RequestTargetHost.java"

# interfaces
.implements Lcz/msebera/android/httpclient/HttpRequestInterceptor;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 55
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 56
    return-void
.end method


# virtual methods
.method public process(Lcz/msebera/android/httpclient/HttpRequest;Lcz/msebera/android/httpclient/protocol/HttpContext;)V
    .locals 9
    .param p1, "request"    # Lcz/msebera/android/httpclient/HttpRequest;
    .param p2, "context"    # Lcz/msebera/android/httpclient/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcz/msebera/android/httpclient/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 60
    const-string v7, "HTTP request"

    invoke-static {p1, v7}, Lcz/msebera/android/httpclient/util/Args;->notNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 62
    invoke-static {p2}, Lcz/msebera/android/httpclient/protocol/HttpCoreContext;->adapt(Lcz/msebera/android/httpclient/protocol/HttpContext;)Lcz/msebera/android/httpclient/protocol/HttpCoreContext;

    move-result-object v2

    .line 64
    .local v2, "corecontext":Lcz/msebera/android/httpclient/protocol/HttpCoreContext;
    invoke-interface {p1}, Lcz/msebera/android/httpclient/HttpRequest;->getRequestLine()Lcz/msebera/android/httpclient/RequestLine;

    move-result-object v7

    invoke-interface {v7}, Lcz/msebera/android/httpclient/RequestLine;->getProtocolVersion()Lcz/msebera/android/httpclient/ProtocolVersion;

    move-result-object v6

    .line 65
    .local v6, "ver":Lcz/msebera/android/httpclient/ProtocolVersion;
    invoke-interface {p1}, Lcz/msebera/android/httpclient/HttpRequest;->getRequestLine()Lcz/msebera/android/httpclient/RequestLine;

    move-result-object v7

    invoke-interface {v7}, Lcz/msebera/android/httpclient/RequestLine;->getMethod()Ljava/lang/String;

    move-result-object v3

    .line 66
    .local v3, "method":Ljava/lang/String;
    const-string v7, "CONNECT"

    invoke-virtual {v3, v7}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_1

    sget-object v7, Lcz/msebera/android/httpclient/HttpVersion;->HTTP_1_0:Lcz/msebera/android/httpclient/HttpVersion;

    invoke-virtual {v6, v7}, Lcz/msebera/android/httpclient/ProtocolVersion;->lessEquals(Lcz/msebera/android/httpclient/ProtocolVersion;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 93
    :cond_0
    :goto_0
    return-void

    .line 70
    :cond_1
    const-string v7, "Host"

    invoke-interface {p1, v7}, Lcz/msebera/android/httpclient/HttpRequest;->containsHeader(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_0

    .line 71
    invoke-virtual {v2}, Lcz/msebera/android/httpclient/protocol/HttpCoreContext;->getTargetHost()Lcz/msebera/android/httpclient/HttpHost;

    move-result-object v5

    .line 72
    .local v5, "targethost":Lcz/msebera/android/httpclient/HttpHost;
    if-nez v5, :cond_3

    .line 73
    invoke-virtual {v2}, Lcz/msebera/android/httpclient/protocol/HttpCoreContext;->getConnection()Lcz/msebera/android/httpclient/HttpConnection;

    move-result-object v1

    .line 74
    .local v1, "conn":Lcz/msebera/android/httpclient/HttpConnection;
    instance-of v7, v1, Lcz/msebera/android/httpclient/HttpInetConnection;

    if-eqz v7, :cond_2

    move-object v7, v1

    .line 77
    check-cast v7, Lcz/msebera/android/httpclient/HttpInetConnection;

    invoke-interface {v7}, Lcz/msebera/android/httpclient/HttpInetConnection;->getRemoteAddress()Ljava/net/InetAddress;

    move-result-object v0

    .line 78
    .local v0, "address":Ljava/net/InetAddress;
    check-cast v1, Lcz/msebera/android/httpclient/HttpInetConnection;

    .end local v1    # "conn":Lcz/msebera/android/httpclient/HttpConnection;
    invoke-interface {v1}, Lcz/msebera/android/httpclient/HttpInetConnection;->getRemotePort()I

    move-result v4

    .line 79
    .local v4, "port":I
    if-eqz v0, :cond_2

    .line 80
    new-instance v5, Lcz/msebera/android/httpclient/HttpHost;

    .end local v5    # "targethost":Lcz/msebera/android/httpclient/HttpHost;
    invoke-virtual {v0}, Ljava/net/InetAddress;->getHostName()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v5, v7, v4}, Lcz/msebera/android/httpclient/HttpHost;-><init>(Ljava/lang/String;I)V

    .line 83
    .end local v0    # "address":Ljava/net/InetAddress;
    .end local v4    # "port":I
    .restart local v5    # "targethost":Lcz/msebera/android/httpclient/HttpHost;
    :cond_2
    if-nez v5, :cond_3

    .line 84
    sget-object v7, Lcz/msebera/android/httpclient/HttpVersion;->HTTP_1_0:Lcz/msebera/android/httpclient/HttpVersion;

    invoke-virtual {v6, v7}, Lcz/msebera/android/httpclient/ProtocolVersion;->lessEquals(Lcz/msebera/android/httpclient/ProtocolVersion;)Z

    move-result v7

    if-nez v7, :cond_0

    .line 87
    new-instance v7, Lcz/msebera/android/httpclient/ProtocolException;

    const-string v8, "Target host missing"

    invoke-direct {v7, v8}, Lcz/msebera/android/httpclient/ProtocolException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 91
    :cond_3
    const-string v7, "Host"

    invoke-virtual {v5}, Lcz/msebera/android/httpclient/HttpHost;->toHostString()Ljava/lang/String;

    move-result-object v8

    invoke-interface {p1, v7, v8}, Lcz/msebera/android/httpclient/HttpRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
