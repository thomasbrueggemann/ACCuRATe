.class public Lcz/msebera/android/httpclient/message/BasicHttpRequest;
.super Lcz/msebera/android/httpclient/message/AbstractHttpMessage;
.source "BasicHttpRequest.java"

# interfaces
.implements Lcz/msebera/android/httpclient/HttpRequest;


# instance fields
.field private final method:Ljava/lang/String;

.field private requestline:Lcz/msebera/android/httpclient/RequestLine;

.field private final uri:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcz/msebera/android/httpclient/RequestLine;)V
    .locals 1
    .param p1, "requestline"    # Lcz/msebera/android/httpclient/RequestLine;

    .prologue
    .line 82
    invoke-direct {p0}, Lcz/msebera/android/httpclient/message/AbstractHttpMessage;-><init>()V

    .line 83
    const-string v0, "Request line"

    invoke-static {p1, v0}, Lcz/msebera/android/httpclient/util/Args;->notNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcz/msebera/android/httpclient/RequestLine;

    iput-object v0, p0, Lcz/msebera/android/httpclient/message/BasicHttpRequest;->requestline:Lcz/msebera/android/httpclient/RequestLine;

    .line 84
    invoke-interface {p1}, Lcz/msebera/android/httpclient/RequestLine;->getMethod()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcz/msebera/android/httpclient/message/BasicHttpRequest;->method:Ljava/lang/String;

    .line 85
    invoke-interface {p1}, Lcz/msebera/android/httpclient/RequestLine;->getUri()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcz/msebera/android/httpclient/message/BasicHttpRequest;->uri:Ljava/lang/String;

    .line 86
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcz/msebera/android/httpclient/ProtocolVersion;)V
    .locals 1
    .param p1, "method"    # Ljava/lang/String;
    .param p2, "uri"    # Ljava/lang/String;
    .param p3, "ver"    # Lcz/msebera/android/httpclient/ProtocolVersion;

    .prologue
    .line 73
    new-instance v0, Lcz/msebera/android/httpclient/message/BasicRequestLine;

    invoke-direct {v0, p1, p2, p3}, Lcz/msebera/android/httpclient/message/BasicRequestLine;-><init>(Ljava/lang/String;Ljava/lang/String;Lcz/msebera/android/httpclient/ProtocolVersion;)V

    invoke-direct {p0, v0}, Lcz/msebera/android/httpclient/message/BasicHttpRequest;-><init>(Lcz/msebera/android/httpclient/RequestLine;)V

    .line 74
    return-void
.end method


# virtual methods
.method public getProtocolVersion()Lcz/msebera/android/httpclient/ProtocolVersion;
    .locals 1

    .prologue
    .line 94
    invoke-virtual {p0}, Lcz/msebera/android/httpclient/message/BasicHttpRequest;->getRequestLine()Lcz/msebera/android/httpclient/RequestLine;

    move-result-object v0

    invoke-interface {v0}, Lcz/msebera/android/httpclient/RequestLine;->getProtocolVersion()Lcz/msebera/android/httpclient/ProtocolVersion;

    move-result-object v0

    return-object v0
.end method

.method public getRequestLine()Lcz/msebera/android/httpclient/RequestLine;
    .locals 4

    .prologue
    .line 103
    iget-object v0, p0, Lcz/msebera/android/httpclient/message/BasicHttpRequest;->requestline:Lcz/msebera/android/httpclient/RequestLine;

    if-nez v0, :cond_0

    .line 104
    new-instance v0, Lcz/msebera/android/httpclient/message/BasicRequestLine;

    iget-object v1, p0, Lcz/msebera/android/httpclient/message/BasicHttpRequest;->method:Ljava/lang/String;

    iget-object v2, p0, Lcz/msebera/android/httpclient/message/BasicHttpRequest;->uri:Ljava/lang/String;

    sget-object v3, Lcz/msebera/android/httpclient/HttpVersion;->HTTP_1_1:Lcz/msebera/android/httpclient/HttpVersion;

    invoke-direct {v0, v1, v2, v3}, Lcz/msebera/android/httpclient/message/BasicRequestLine;-><init>(Ljava/lang/String;Ljava/lang/String;Lcz/msebera/android/httpclient/ProtocolVersion;)V

    iput-object v0, p0, Lcz/msebera/android/httpclient/message/BasicHttpRequest;->requestline:Lcz/msebera/android/httpclient/RequestLine;

    .line 106
    :cond_0
    iget-object v0, p0, Lcz/msebera/android/httpclient/message/BasicHttpRequest;->requestline:Lcz/msebera/android/httpclient/RequestLine;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    const/16 v2, 0x20

    .line 111
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcz/msebera/android/httpclient/message/BasicHttpRequest;->method:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcz/msebera/android/httpclient/message/BasicHttpRequest;->uri:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcz/msebera/android/httpclient/message/BasicHttpRequest;->headergroup:Lcz/msebera/android/httpclient/message/HeaderGroup;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
