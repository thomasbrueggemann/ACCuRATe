.class Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec$1;
.super Lcz/msebera/android/httpclient/impl/cookie/BasicPathHandler;
.source "BrowserCompatSpec.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec;-><init>([Ljava/lang/String;Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpecFactory$SecurityLevel;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec;


# direct methods
.method constructor <init>(Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec;)V
    .locals 0
    .param p1, "this$0"    # Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec;

    .prologue
    .line 100
    iput-object p1, p0, Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec$1;->this$0:Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec;

    invoke-direct {p0}, Lcz/msebera/android/httpclient/impl/cookie/BasicPathHandler;-><init>()V

    return-void
.end method


# virtual methods
.method public validate(Lcz/msebera/android/httpclient/cookie/Cookie;Lcz/msebera/android/httpclient/cookie/CookieOrigin;)V
    .locals 0
    .param p1, "cookie"    # Lcz/msebera/android/httpclient/cookie/Cookie;
    .param p2, "origin"    # Lcz/msebera/android/httpclient/cookie/CookieOrigin;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcz/msebera/android/httpclient/cookie/MalformedCookieException;
        }
    .end annotation

    .prologue
    .line 104
    return-void
.end method
