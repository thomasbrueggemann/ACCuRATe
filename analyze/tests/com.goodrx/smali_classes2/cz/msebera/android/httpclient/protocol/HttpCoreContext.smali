.class public Lcz/msebera/android/httpclient/protocol/HttpCoreContext;
.super Ljava/lang/Object;
.source "HttpCoreContext.java"

# interfaces
.implements Lcz/msebera/android/httpclient/protocol/HttpContext;


# instance fields
.field private final context:Lcz/msebera/android/httpclient/protocol/HttpContext;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 98
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 99
    new-instance v0, Lcz/msebera/android/httpclient/protocol/BasicHttpContext;

    invoke-direct {v0}, Lcz/msebera/android/httpclient/protocol/BasicHttpContext;-><init>()V

    iput-object v0, p0, Lcz/msebera/android/httpclient/protocol/HttpCoreContext;->context:Lcz/msebera/android/httpclient/protocol/HttpContext;

    .line 100
    return-void
.end method

.method public constructor <init>(Lcz/msebera/android/httpclient/protocol/HttpContext;)V
    .locals 0
    .param p1, "context"    # Lcz/msebera/android/httpclient/protocol/HttpContext;

    .prologue
    .line 93
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 94
    iput-object p1, p0, Lcz/msebera/android/httpclient/protocol/HttpCoreContext;->context:Lcz/msebera/android/httpclient/protocol/HttpContext;

    .line 95
    return-void
.end method

.method public static adapt(Lcz/msebera/android/httpclient/protocol/HttpContext;)Lcz/msebera/android/httpclient/protocol/HttpCoreContext;
    .locals 1
    .param p0, "context"    # Lcz/msebera/android/httpclient/protocol/HttpContext;

    .prologue
    .line 82
    const-string v0, "HTTP context"

    invoke-static {p0, v0}, Lcz/msebera/android/httpclient/util/Args;->notNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 83
    instance-of v0, p0, Lcz/msebera/android/httpclient/protocol/HttpCoreContext;

    if-eqz v0, :cond_0

    .line 84
    check-cast p0, Lcz/msebera/android/httpclient/protocol/HttpCoreContext;

    .line 86
    .end local p0    # "context":Lcz/msebera/android/httpclient/protocol/HttpContext;
    :goto_0
    return-object p0

    .restart local p0    # "context":Lcz/msebera/android/httpclient/protocol/HttpContext;
    :cond_0
    new-instance v0, Lcz/msebera/android/httpclient/protocol/HttpCoreContext;

    invoke-direct {v0, p0}, Lcz/msebera/android/httpclient/protocol/HttpCoreContext;-><init>(Lcz/msebera/android/httpclient/protocol/HttpContext;)V

    move-object p0, v0

    goto :goto_0
.end method


# virtual methods
.method public getAttribute(Ljava/lang/String;)Ljava/lang/Object;
    .locals 1
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 103
    iget-object v0, p0, Lcz/msebera/android/httpclient/protocol/HttpCoreContext;->context:Lcz/msebera/android/httpclient/protocol/HttpContext;

    invoke-interface {v0, p1}, Lcz/msebera/android/httpclient/protocol/HttpContext;->getAttribute(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getAttribute(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 2
    .param p1, "attribname"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<TT;>;)TT;"
        }
    .end annotation

    .prologue
    .line 115
    .local p2, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    const-string v1, "Attribute class"

    invoke-static {p2, v1}, Lcz/msebera/android/httpclient/util/Args;->notNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 116
    invoke-virtual {p0, p1}, Lcz/msebera/android/httpclient/protocol/HttpCoreContext;->getAttribute(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 117
    .local v0, "obj":Ljava/lang/Object;
    if-nez v0, :cond_0

    .line 118
    const/4 v1, 0x0

    .line 120
    :goto_0
    return-object v1

    :cond_0
    invoke-virtual {p2, v0}, Ljava/lang/Class;->cast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    goto :goto_0
.end method

.method public getConnection()Lcz/msebera/android/httpclient/HttpConnection;
    .locals 2

    .prologue
    .line 128
    const-string v0, "http.connection"

    const-class v1, Lcz/msebera/android/httpclient/HttpConnection;

    invoke-virtual {p0, v0, v1}, Lcz/msebera/android/httpclient/protocol/HttpCoreContext;->getAttribute(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcz/msebera/android/httpclient/HttpConnection;

    return-object v0
.end method

.method public getRequest()Lcz/msebera/android/httpclient/HttpRequest;
    .locals 2

    .prologue
    .line 132
    const-string v0, "http.request"

    const-class v1, Lcz/msebera/android/httpclient/HttpRequest;

    invoke-virtual {p0, v0, v1}, Lcz/msebera/android/httpclient/protocol/HttpCoreContext;->getAttribute(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcz/msebera/android/httpclient/HttpRequest;

    return-object v0
.end method

.method public getTargetHost()Lcz/msebera/android/httpclient/HttpHost;
    .locals 2

    .prologue
    .line 149
    const-string v0, "http.target_host"

    const-class v1, Lcz/msebera/android/httpclient/HttpHost;

    invoke-virtual {p0, v0, v1}, Lcz/msebera/android/httpclient/protocol/HttpCoreContext;->getAttribute(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcz/msebera/android/httpclient/HttpHost;

    return-object v0
.end method

.method public isRequestSent()Z
    .locals 3

    .prologue
    .line 136
    const-string v1, "http.request_sent"

    const-class v2, Ljava/lang/Boolean;

    invoke-virtual {p0, v1, v2}, Lcz/msebera/android/httpclient/protocol/HttpCoreContext;->getAttribute(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    .line 137
    .local v0, "b":Ljava/lang/Boolean;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public setAttribute(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "obj"    # Ljava/lang/Object;

    .prologue
    .line 107
    iget-object v0, p0, Lcz/msebera/android/httpclient/protocol/HttpCoreContext;->context:Lcz/msebera/android/httpclient/protocol/HttpContext;

    invoke-interface {v0, p1, p2}, Lcz/msebera/android/httpclient/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 108
    return-void
.end method
