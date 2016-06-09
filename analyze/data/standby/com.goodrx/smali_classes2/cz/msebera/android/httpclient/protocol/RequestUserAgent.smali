.class public Lcz/msebera/android/httpclient/protocol/RequestUserAgent;
.super Ljava/lang/Object;
.source "RequestUserAgent.java"

# interfaces
.implements Lcz/msebera/android/httpclient/HttpRequestInterceptor;


# instance fields
.field private final userAgent:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 58
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcz/msebera/android/httpclient/protocol/RequestUserAgent;-><init>(Ljava/lang/String;)V

    .line 59
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "userAgent"    # Ljava/lang/String;

    .prologue
    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 54
    iput-object p1, p0, Lcz/msebera/android/httpclient/protocol/RequestUserAgent;->userAgent:Ljava/lang/String;

    .line 55
    return-void
.end method


# virtual methods
.method public process(Lcz/msebera/android/httpclient/HttpRequest;Lcz/msebera/android/httpclient/protocol/HttpContext;)V
    .locals 3
    .param p1, "request"    # Lcz/msebera/android/httpclient/HttpRequest;
    .param p2, "context"    # Lcz/msebera/android/httpclient/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcz/msebera/android/httpclient/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 63
    const-string v2, "HTTP request"

    invoke-static {p1, v2}, Lcz/msebera/android/httpclient/util/Args;->notNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 64
    const-string v2, "User-Agent"

    invoke-interface {p1, v2}, Lcz/msebera/android/httpclient/HttpRequest;->containsHeader(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 65
    const/4 v1, 0x0

    .line 66
    .local v1, "s":Ljava/lang/String;
    invoke-interface {p1}, Lcz/msebera/android/httpclient/HttpRequest;->getParams()Lcz/msebera/android/httpclient/params/HttpParams;

    move-result-object v0

    .line 67
    .local v0, "params":Lcz/msebera/android/httpclient/params/HttpParams;
    if-eqz v0, :cond_0

    .line 68
    const-string v2, "http.useragent"

    invoke-interface {v0, v2}, Lcz/msebera/android/httpclient/params/HttpParams;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    .end local v1    # "s":Ljava/lang/String;
    check-cast v1, Ljava/lang/String;

    .line 70
    .restart local v1    # "s":Ljava/lang/String;
    :cond_0
    if-nez v1, :cond_1

    .line 71
    iget-object v1, p0, Lcz/msebera/android/httpclient/protocol/RequestUserAgent;->userAgent:Ljava/lang/String;

    .line 73
    :cond_1
    if-eqz v1, :cond_2

    .line 74
    const-string v2, "User-Agent"

    invoke-interface {p1, v2, v1}, Lcz/msebera/android/httpclient/HttpRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 77
    .end local v0    # "params":Lcz/msebera/android/httpclient/params/HttpParams;
    .end local v1    # "s":Ljava/lang/String;
    :cond_2
    return-void
.end method
