.class public Lcz/msebera/android/httpclient/impl/cookie/RFC2965SpecFactory;
.super Ljava/lang/Object;
.source "RFC2965SpecFactory.java"

# interfaces
.implements Lcz/msebera/android/httpclient/cookie/CookieSpecFactory;
.implements Lcz/msebera/android/httpclient/cookie/CookieSpecProvider;


# instance fields
.field private final datepatterns:[Ljava/lang/String;

.field private final oneHeader:Z


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 60
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcz/msebera/android/httpclient/impl/cookie/RFC2965SpecFactory;-><init>([Ljava/lang/String;Z)V

    .line 61
    return-void
.end method

.method public constructor <init>([Ljava/lang/String;Z)V
    .locals 0
    .param p1, "datepatterns"    # [Ljava/lang/String;
    .param p2, "oneHeader"    # Z

    .prologue
    .line 54
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 55
    iput-object p1, p0, Lcz/msebera/android/httpclient/impl/cookie/RFC2965SpecFactory;->datepatterns:[Ljava/lang/String;

    .line 56
    iput-boolean p2, p0, Lcz/msebera/android/httpclient/impl/cookie/RFC2965SpecFactory;->oneHeader:Z

    .line 57
    return-void
.end method


# virtual methods
.method public create(Lcz/msebera/android/httpclient/protocol/HttpContext;)Lcz/msebera/android/httpclient/cookie/CookieSpec;
    .locals 3
    .param p1, "context"    # Lcz/msebera/android/httpclient/protocol/HttpContext;

    .prologue
    .line 83
    new-instance v0, Lcz/msebera/android/httpclient/impl/cookie/RFC2965Spec;

    iget-object v1, p0, Lcz/msebera/android/httpclient/impl/cookie/RFC2965SpecFactory;->datepatterns:[Ljava/lang/String;

    iget-boolean v2, p0, Lcz/msebera/android/httpclient/impl/cookie/RFC2965SpecFactory;->oneHeader:Z

    invoke-direct {v0, v1, v2}, Lcz/msebera/android/httpclient/impl/cookie/RFC2965Spec;-><init>([Ljava/lang/String;Z)V

    return-object v0
.end method

.method public newInstance(Lcz/msebera/android/httpclient/params/HttpParams;)Lcz/msebera/android/httpclient/cookie/CookieSpec;
    .locals 5
    .param p1, "params"    # Lcz/msebera/android/httpclient/params/HttpParams;

    .prologue
    .line 64
    if-eqz p1, :cond_1

    .line 66
    const/4 v1, 0x0

    .line 67
    .local v1, "patterns":[Ljava/lang/String;
    const-string v3, "http.protocol.cookie-datepatterns"

    invoke-interface {p1, v3}, Lcz/msebera/android/httpclient/params/HttpParams;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Collection;

    .line 69
    .local v0, "param":Ljava/util/Collection;, "Ljava/util/Collection<*>;"
    if-eqz v0, :cond_0

    .line 70
    invoke-interface {v0}, Ljava/util/Collection;->size()I

    move-result v3

    new-array v1, v3, [Ljava/lang/String;

    .line 71
    invoke-interface {v0, v1}, Ljava/util/Collection;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v1

    .end local v1    # "patterns":[Ljava/lang/String;
    check-cast v1, [Ljava/lang/String;

    .line 73
    .restart local v1    # "patterns":[Ljava/lang/String;
    :cond_0
    const-string v3, "http.protocol.single-cookie-header"

    const/4 v4, 0x0

    invoke-interface {p1, v3, v4}, Lcz/msebera/android/httpclient/params/HttpParams;->getBooleanParameter(Ljava/lang/String;Z)Z

    move-result v2

    .line 76
    .local v2, "singleHeader":Z
    new-instance v3, Lcz/msebera/android/httpclient/impl/cookie/RFC2965Spec;

    invoke-direct {v3, v1, v2}, Lcz/msebera/android/httpclient/impl/cookie/RFC2965Spec;-><init>([Ljava/lang/String;Z)V

    .line 78
    .end local v0    # "param":Ljava/util/Collection;, "Ljava/util/Collection<*>;"
    .end local v1    # "patterns":[Ljava/lang/String;
    .end local v2    # "singleHeader":Z
    :goto_0
    return-object v3

    :cond_1
    new-instance v3, Lcz/msebera/android/httpclient/impl/cookie/RFC2965Spec;

    invoke-direct {v3}, Lcz/msebera/android/httpclient/impl/cookie/RFC2965Spec;-><init>()V

    goto :goto_0
.end method
