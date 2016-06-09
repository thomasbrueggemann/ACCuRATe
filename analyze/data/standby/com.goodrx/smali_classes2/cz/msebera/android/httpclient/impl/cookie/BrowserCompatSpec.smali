.class public Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec;
.super Lcz/msebera/android/httpclient/impl/cookie/CookieSpecBase;
.source "BrowserCompatSpec.java"


# static fields
.field private static final DEFAULT_DATE_PATTERNS:[Ljava/lang/String;


# instance fields
.field private final datepatterns:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 68
    const/16 v0, 0xe

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "EEE, dd MMM yyyy HH:mm:ss zzz"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "EEE, dd-MMM-yy HH:mm:ss zzz"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "EEE MMM d HH:mm:ss yyyy"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "EEE, dd-MMM-yyyy HH:mm:ss z"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "EEE, dd-MMM-yyyy HH-mm-ss z"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string v2, "EEE, dd MMM yy HH:mm:ss z"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "EEE dd-MMM-yyyy HH:mm:ss z"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "EEE dd MMM yyyy HH:mm:ss z"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "EEE dd-MMM-yyyy HH-mm-ss z"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "EEE dd-MMM-yy HH:mm:ss z"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "EEE dd MMM yy HH:mm:ss z"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string v2, "EEE,dd-MMM-yy HH:mm:ss z"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string v2, "EEE,dd-MMM-yyyy HH:mm:ss z"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string v2, "EEE, dd-MM-yyyy HH:mm:ss z"

    aput-object v2, v0, v1

    sput-object v0, Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec;->DEFAULT_DATE_PATTERNS:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 128
    const/4 v0, 0x0

    sget-object v1, Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpecFactory$SecurityLevel;->SECURITYLEVEL_DEFAULT:Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpecFactory$SecurityLevel;

    invoke-direct {p0, v0, v1}, Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec;-><init>([Ljava/lang/String;Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpecFactory$SecurityLevel;)V

    .line 129
    return-void
.end method

.method public constructor <init>([Ljava/lang/String;)V
    .locals 1
    .param p1, "datepatterns"    # [Ljava/lang/String;

    .prologue
    .line 123
    sget-object v0, Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpecFactory$SecurityLevel;->SECURITYLEVEL_DEFAULT:Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpecFactory$SecurityLevel;

    invoke-direct {p0, p1, v0}, Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec;-><init>([Ljava/lang/String;Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpecFactory$SecurityLevel;)V

    .line 124
    return-void
.end method

.method public constructor <init>([Ljava/lang/String;Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpecFactory$SecurityLevel;)V
    .locals 3
    .param p1, "datepatterns"    # [Ljava/lang/String;
    .param p2, "securityLevel"    # Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpecFactory$SecurityLevel;

    .prologue
    .line 89
    invoke-direct {p0}, Lcz/msebera/android/httpclient/impl/cookie/CookieSpecBase;-><init>()V

    .line 90
    if-eqz p1, :cond_0

    .line 91
    invoke-virtual {p1}, [Ljava/lang/String;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/String;

    iput-object v0, p0, Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec;->datepatterns:[Ljava/lang/String;

    .line 95
    :goto_0
    sget-object v0, Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec$2;->$SwitchMap$cz$msebera$android$httpclient$impl$cookie$BrowserCompatSpecFactory$SecurityLevel:[I

    invoke-virtual {p2}, Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpecFactory$SecurityLevel;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 109
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Unknown security level"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 93
    :cond_0
    sget-object v0, Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec;->DEFAULT_DATE_PATTERNS:[Ljava/lang/String;

    iput-object v0, p0, Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec;->datepatterns:[Ljava/lang/String;

    goto :goto_0

    .line 97
    :pswitch_0
    const-string v0, "path"

    new-instance v1, Lcz/msebera/android/httpclient/impl/cookie/BasicPathHandler;

    invoke-direct {v1}, Lcz/msebera/android/httpclient/impl/cookie/BasicPathHandler;-><init>()V

    invoke-virtual {p0, v0, v1}, Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec;->registerAttribHandler(Ljava/lang/String;Lcz/msebera/android/httpclient/cookie/CookieAttributeHandler;)V

    .line 112
    :goto_1
    const-string v0, "domain"

    new-instance v1, Lcz/msebera/android/httpclient/impl/cookie/BasicDomainHandler;

    invoke-direct {v1}, Lcz/msebera/android/httpclient/impl/cookie/BasicDomainHandler;-><init>()V

    invoke-virtual {p0, v0, v1}, Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec;->registerAttribHandler(Ljava/lang/String;Lcz/msebera/android/httpclient/cookie/CookieAttributeHandler;)V

    .line 113
    const-string v0, "max-age"

    new-instance v1, Lcz/msebera/android/httpclient/impl/cookie/BasicMaxAgeHandler;

    invoke-direct {v1}, Lcz/msebera/android/httpclient/impl/cookie/BasicMaxAgeHandler;-><init>()V

    invoke-virtual {p0, v0, v1}, Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec;->registerAttribHandler(Ljava/lang/String;Lcz/msebera/android/httpclient/cookie/CookieAttributeHandler;)V

    .line 114
    const-string v0, "secure"

    new-instance v1, Lcz/msebera/android/httpclient/impl/cookie/BasicSecureHandler;

    invoke-direct {v1}, Lcz/msebera/android/httpclient/impl/cookie/BasicSecureHandler;-><init>()V

    invoke-virtual {p0, v0, v1}, Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec;->registerAttribHandler(Ljava/lang/String;Lcz/msebera/android/httpclient/cookie/CookieAttributeHandler;)V

    .line 115
    const-string v0, "comment"

    new-instance v1, Lcz/msebera/android/httpclient/impl/cookie/BasicCommentHandler;

    invoke-direct {v1}, Lcz/msebera/android/httpclient/impl/cookie/BasicCommentHandler;-><init>()V

    invoke-virtual {p0, v0, v1}, Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec;->registerAttribHandler(Ljava/lang/String;Lcz/msebera/android/httpclient/cookie/CookieAttributeHandler;)V

    .line 116
    const-string v0, "expires"

    new-instance v1, Lcz/msebera/android/httpclient/impl/cookie/BasicExpiresHandler;

    iget-object v2, p0, Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec;->datepatterns:[Ljava/lang/String;

    invoke-direct {v1, v2}, Lcz/msebera/android/httpclient/impl/cookie/BasicExpiresHandler;-><init>([Ljava/lang/String;)V

    invoke-virtual {p0, v0, v1}, Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec;->registerAttribHandler(Ljava/lang/String;Lcz/msebera/android/httpclient/cookie/CookieAttributeHandler;)V

    .line 118
    const-string v0, "version"

    new-instance v1, Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatVersionAttributeHandler;

    invoke-direct {v1}, Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatVersionAttributeHandler;-><init>()V

    invoke-virtual {p0, v0, v1}, Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec;->registerAttribHandler(Ljava/lang/String;Lcz/msebera/android/httpclient/cookie/CookieAttributeHandler;)V

    .line 119
    return-void

    .line 100
    :pswitch_1
    const-string v0, "path"

    new-instance v1, Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec$1;

    invoke-direct {v1, p0}, Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec$1;-><init>(Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec;)V

    invoke-virtual {p0, v0, v1}, Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec;->registerAttribHandler(Ljava/lang/String;Lcz/msebera/android/httpclient/cookie/CookieAttributeHandler;)V

    goto :goto_1

    .line 95
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private static isQuoteEnclosed(Ljava/lang/String;)Z
    .locals 1
    .param p0, "s"    # Ljava/lang/String;

    .prologue
    .line 203
    if-eqz p0, :cond_0

    const-string v0, "\""

    invoke-virtual {p0, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "\""

    invoke-virtual {p0, v0}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public formatCookies(Ljava/util/List;)Ljava/util/List;
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcz/msebera/android/httpclient/cookie/Cookie;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Lcz/msebera/android/httpclient/Header;",
            ">;"
        }
    .end annotation

    .prologue
    .line 207
    .local p1, "cookies":Ljava/util/List;, "Ljava/util/List<Lcz/msebera/android/httpclient/cookie/Cookie;>;"
    const-string v6, "List of cookies"

    invoke-static {p1, v6}, Lcz/msebera/android/httpclient/util/Args;->notEmpty(Ljava/util/Collection;Ljava/lang/String;)Ljava/util/Collection;

    .line 208
    new-instance v0, Lcz/msebera/android/httpclient/util/CharArrayBuffer;

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v6

    mul-int/lit8 v6, v6, 0x14

    invoke-direct {v0, v6}, Lcz/msebera/android/httpclient/util/CharArrayBuffer;-><init>(I)V

    .line 209
    .local v0, "buffer":Lcz/msebera/android/httpclient/util/CharArrayBuffer;
    const-string v6, "Cookie"

    invoke-virtual {v0, v6}, Lcz/msebera/android/httpclient/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 210
    const-string v6, ": "

    invoke-virtual {v0, v6}, Lcz/msebera/android/httpclient/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 211
    const/4 v5, 0x0

    .local v5, "i":I
    :goto_0
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v6

    if-ge v5, v6, :cond_3

    .line 212
    invoke-interface {p1, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcz/msebera/android/httpclient/cookie/Cookie;

    .line 213
    .local v1, "cookie":Lcz/msebera/android/httpclient/cookie/Cookie;
    if-lez v5, :cond_0

    .line 214
    const-string v6, "; "

    invoke-virtual {v0, v6}, Lcz/msebera/android/httpclient/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 216
    :cond_0
    invoke-interface {v1}, Lcz/msebera/android/httpclient/cookie/Cookie;->getName()Ljava/lang/String;

    move-result-object v2

    .line 217
    .local v2, "cookieName":Ljava/lang/String;
    invoke-interface {v1}, Lcz/msebera/android/httpclient/cookie/Cookie;->getValue()Ljava/lang/String;

    move-result-object v3

    .line 218
    .local v3, "cookieValue":Ljava/lang/String;
    invoke-interface {v1}, Lcz/msebera/android/httpclient/cookie/Cookie;->getVersion()I

    move-result v6

    if-lez v6, :cond_2

    invoke-static {v3}, Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec;->isQuoteEnclosed(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_2

    .line 219
    sget-object v6, Lcz/msebera/android/httpclient/message/BasicHeaderValueFormatter;->INSTANCE:Lcz/msebera/android/httpclient/message/BasicHeaderValueFormatter;

    new-instance v7, Lcz/msebera/android/httpclient/message/BasicHeaderElement;

    invoke-direct {v7, v2, v3}, Lcz/msebera/android/httpclient/message/BasicHeaderElement;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v8, 0x0

    invoke-virtual {v6, v0, v7, v8}, Lcz/msebera/android/httpclient/message/BasicHeaderValueFormatter;->formatHeaderElement(Lcz/msebera/android/httpclient/util/CharArrayBuffer;Lcz/msebera/android/httpclient/HeaderElement;Z)Lcz/msebera/android/httpclient/util/CharArrayBuffer;

    .line 211
    :cond_1
    :goto_1
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 225
    :cond_2
    invoke-virtual {v0, v2}, Lcz/msebera/android/httpclient/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 226
    const-string v6, "="

    invoke-virtual {v0, v6}, Lcz/msebera/android/httpclient/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 227
    if-eqz v3, :cond_1

    .line 228
    invoke-virtual {v0, v3}, Lcz/msebera/android/httpclient/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    goto :goto_1

    .line 232
    .end local v1    # "cookie":Lcz/msebera/android/httpclient/cookie/Cookie;
    .end local v2    # "cookieName":Ljava/lang/String;
    .end local v3    # "cookieValue":Ljava/lang/String;
    :cond_3
    new-instance v4, Ljava/util/ArrayList;

    const/4 v6, 0x1

    invoke-direct {v4, v6}, Ljava/util/ArrayList;-><init>(I)V

    .line 233
    .local v4, "headers":Ljava/util/List;, "Ljava/util/List<Lcz/msebera/android/httpclient/Header;>;"
    new-instance v6, Lcz/msebera/android/httpclient/message/BufferedHeader;

    invoke-direct {v6, v0}, Lcz/msebera/android/httpclient/message/BufferedHeader;-><init>(Lcz/msebera/android/httpclient/util/CharArrayBuffer;)V

    invoke-interface {v4, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 234
    return-object v4
.end method

.method public getVersion()I
    .locals 1

    .prologue
    .line 238
    const/4 v0, 0x0

    return v0
.end method

.method public getVersionHeader()Lcz/msebera/android/httpclient/Header;
    .locals 1

    .prologue
    .line 242
    const/4 v0, 0x0

    return-object v0
.end method

.method public parse(Lcz/msebera/android/httpclient/Header;Lcz/msebera/android/httpclient/cookie/CookieOrigin;)Ljava/util/List;
    .locals 22
    .param p1, "header"    # Lcz/msebera/android/httpclient/Header;
    .param p2, "origin"    # Lcz/msebera/android/httpclient/cookie/CookieOrigin;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcz/msebera/android/httpclient/Header;",
            "Lcz/msebera/android/httpclient/cookie/CookieOrigin;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcz/msebera/android/httpclient/cookie/Cookie;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcz/msebera/android/httpclient/cookie/MalformedCookieException;
        }
    .end annotation

    .prologue
    .line 133
    const-string v19, "Header"

    move-object/from16 v0, p1

    move-object/from16 v1, v19

    invoke-static {v0, v1}, Lcz/msebera/android/httpclient/util/Args;->notNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 134
    const-string v19, "Cookie origin"

    move-object/from16 v0, p2

    move-object/from16 v1, v19

    invoke-static {v0, v1}, Lcz/msebera/android/httpclient/util/Args;->notNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 135
    invoke-interface/range {p1 .. p1}, Lcz/msebera/android/httpclient/Header;->getName()Ljava/lang/String;

    move-result-object v9

    .line 136
    .local v9, "headername":Ljava/lang/String;
    const-string v19, "Set-Cookie"

    move-object/from16 v0, v19

    invoke-virtual {v9, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v19

    if-nez v19, :cond_0

    .line 137
    new-instance v19, Lcz/msebera/android/httpclient/cookie/MalformedCookieException;

    new-instance v20, Ljava/lang/StringBuilder;

    invoke-direct/range {v20 .. v20}, Ljava/lang/StringBuilder;-><init>()V

    const-string v21, "Unrecognized cookie header \'"

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    .line 138
    invoke-virtual/range {p1 .. p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v21

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    const-string v21, "\'"

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v20

    invoke-direct/range {v19 .. v20}, Lcz/msebera/android/httpclient/cookie/MalformedCookieException;-><init>(Ljava/lang/String;)V

    throw v19

    .line 140
    :cond_0
    invoke-interface/range {p1 .. p1}, Lcz/msebera/android/httpclient/Header;->getElements()[Lcz/msebera/android/httpclient/HeaderElement;

    move-result-object v11

    .line 141
    .local v11, "helems":[Lcz/msebera/android/httpclient/HeaderElement;
    const/16 v18, 0x0

    .line 142
    .local v18, "versioned":Z
    const/4 v14, 0x0

    .line 143
    .local v14, "netscape":Z
    array-length v0, v11

    move/from16 v20, v0

    const/16 v19, 0x0

    :goto_0
    move/from16 v0, v19

    move/from16 v1, v20

    if-ge v0, v1, :cond_3

    aget-object v10, v11, v19

    .line 144
    .local v10, "helem":Lcz/msebera/android/httpclient/HeaderElement;
    const-string v21, "version"

    move-object/from16 v0, v21

    invoke-interface {v10, v0}, Lcz/msebera/android/httpclient/HeaderElement;->getParameterByName(Ljava/lang/String;)Lcz/msebera/android/httpclient/NameValuePair;

    move-result-object v21

    if-eqz v21, :cond_1

    .line 145
    const/16 v18, 0x1

    .line 147
    :cond_1
    const-string v21, "expires"

    move-object/from16 v0, v21

    invoke-interface {v10, v0}, Lcz/msebera/android/httpclient/HeaderElement;->getParameterByName(Ljava/lang/String;)Lcz/msebera/android/httpclient/NameValuePair;

    move-result-object v21

    if-eqz v21, :cond_2

    .line 148
    const/4 v14, 0x1

    .line 143
    :cond_2
    add-int/lit8 v19, v19, 0x1

    goto :goto_0

    .line 151
    .end local v10    # "helem":Lcz/msebera/android/httpclient/HeaderElement;
    :cond_3
    if-nez v14, :cond_4

    if-nez v18, :cond_c

    .line 154
    :cond_4
    sget-object v15, Lcz/msebera/android/httpclient/impl/cookie/NetscapeDraftHeaderParser;->DEFAULT:Lcz/msebera/android/httpclient/impl/cookie/NetscapeDraftHeaderParser;

    .line 157
    .local v15, "parser":Lcz/msebera/android/httpclient/impl/cookie/NetscapeDraftHeaderParser;
    move-object/from16 v0, p1

    instance-of v0, v0, Lcz/msebera/android/httpclient/FormattedHeader;

    move/from16 v19, v0

    if-eqz v19, :cond_6

    move-object/from16 v19, p1

    .line 158
    check-cast v19, Lcz/msebera/android/httpclient/FormattedHeader;

    invoke-interface/range {v19 .. v19}, Lcz/msebera/android/httpclient/FormattedHeader;->getBuffer()Lcz/msebera/android/httpclient/util/CharArrayBuffer;

    move-result-object v4

    .line 159
    .local v4, "buffer":Lcz/msebera/android/httpclient/util/CharArrayBuffer;
    new-instance v6, Lcz/msebera/android/httpclient/message/ParserCursor;

    check-cast p1, Lcz/msebera/android/httpclient/FormattedHeader;

    .line 160
    .end local p1    # "header":Lcz/msebera/android/httpclient/Header;
    invoke-interface/range {p1 .. p1}, Lcz/msebera/android/httpclient/FormattedHeader;->getValuePos()I

    move-result v19

    .line 161
    invoke-virtual {v4}, Lcz/msebera/android/httpclient/util/CharArrayBuffer;->length()I

    move-result v20

    move/from16 v0, v19

    move/from16 v1, v20

    invoke-direct {v6, v0, v1}, Lcz/msebera/android/httpclient/message/ParserCursor;-><init>(II)V

    .line 171
    .local v6, "cursor":Lcz/msebera/android/httpclient/message/ParserCursor;
    :goto_1
    invoke-virtual {v15, v4, v6}, Lcz/msebera/android/httpclient/impl/cookie/NetscapeDraftHeaderParser;->parseHeader(Lcz/msebera/android/httpclient/util/CharArrayBuffer;Lcz/msebera/android/httpclient/message/ParserCursor;)Lcz/msebera/android/httpclient/HeaderElement;

    move-result-object v7

    .line 172
    .local v7, "elem":Lcz/msebera/android/httpclient/HeaderElement;
    invoke-interface {v7}, Lcz/msebera/android/httpclient/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v13

    .line 173
    .local v13, "name":Ljava/lang/String;
    invoke-interface {v7}, Lcz/msebera/android/httpclient/HeaderElement;->getValue()Ljava/lang/String;

    move-result-object v17

    .line 174
    .local v17, "value":Ljava/lang/String;
    if-eqz v13, :cond_5

    invoke-static {v13}, Lcz/msebera/android/httpclient/util/TextUtils;->isBlank(Ljava/lang/CharSequence;)Z

    move-result v19

    if-eqz v19, :cond_8

    .line 175
    :cond_5
    new-instance v19, Lcz/msebera/android/httpclient/cookie/MalformedCookieException;

    const-string v20, "Cookie name may not be empty"

    invoke-direct/range {v19 .. v20}, Lcz/msebera/android/httpclient/cookie/MalformedCookieException;-><init>(Ljava/lang/String;)V

    throw v19

    .line 163
    .end local v4    # "buffer":Lcz/msebera/android/httpclient/util/CharArrayBuffer;
    .end local v6    # "cursor":Lcz/msebera/android/httpclient/message/ParserCursor;
    .end local v7    # "elem":Lcz/msebera/android/httpclient/HeaderElement;
    .end local v13    # "name":Ljava/lang/String;
    .end local v17    # "value":Ljava/lang/String;
    .restart local p1    # "header":Lcz/msebera/android/httpclient/Header;
    :cond_6
    invoke-interface/range {p1 .. p1}, Lcz/msebera/android/httpclient/Header;->getValue()Ljava/lang/String;

    move-result-object v16

    .line 164
    .local v16, "s":Ljava/lang/String;
    if-nez v16, :cond_7

    .line 165
    new-instance v19, Lcz/msebera/android/httpclient/cookie/MalformedCookieException;

    const-string v20, "Header value is null"

    invoke-direct/range {v19 .. v20}, Lcz/msebera/android/httpclient/cookie/MalformedCookieException;-><init>(Ljava/lang/String;)V

    throw v19

    .line 167
    :cond_7
    new-instance v4, Lcz/msebera/android/httpclient/util/CharArrayBuffer;

    invoke-virtual/range {v16 .. v16}, Ljava/lang/String;->length()I

    move-result v19

    move/from16 v0, v19

    invoke-direct {v4, v0}, Lcz/msebera/android/httpclient/util/CharArrayBuffer;-><init>(I)V

    .line 168
    .restart local v4    # "buffer":Lcz/msebera/android/httpclient/util/CharArrayBuffer;
    move-object/from16 v0, v16

    invoke-virtual {v4, v0}, Lcz/msebera/android/httpclient/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 169
    new-instance v6, Lcz/msebera/android/httpclient/message/ParserCursor;

    const/16 v19, 0x0

    invoke-virtual {v4}, Lcz/msebera/android/httpclient/util/CharArrayBuffer;->length()I

    move-result v20

    move/from16 v0, v19

    move/from16 v1, v20

    invoke-direct {v6, v0, v1}, Lcz/msebera/android/httpclient/message/ParserCursor;-><init>(II)V

    .restart local v6    # "cursor":Lcz/msebera/android/httpclient/message/ParserCursor;
    goto :goto_1

    .line 177
    .end local v16    # "s":Ljava/lang/String;
    .end local p1    # "header":Lcz/msebera/android/httpclient/Header;
    .restart local v7    # "elem":Lcz/msebera/android/httpclient/HeaderElement;
    .restart local v13    # "name":Ljava/lang/String;
    .restart local v17    # "value":Ljava/lang/String;
    :cond_8
    new-instance v5, Lcz/msebera/android/httpclient/impl/cookie/BasicClientCookie;

    move-object/from16 v0, v17

    invoke-direct {v5, v13, v0}, Lcz/msebera/android/httpclient/impl/cookie/BasicClientCookie;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 178
    .local v5, "cookie":Lcz/msebera/android/httpclient/impl/cookie/BasicClientCookie;
    invoke-static/range {p2 .. p2}, Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec;->getDefaultPath(Lcz/msebera/android/httpclient/cookie/CookieOrigin;)Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v5, v0}, Lcz/msebera/android/httpclient/impl/cookie/BasicClientCookie;->setPath(Ljava/lang/String;)V

    .line 179
    invoke-static/range {p2 .. p2}, Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec;->getDefaultDomain(Lcz/msebera/android/httpclient/cookie/CookieOrigin;)Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v5, v0}, Lcz/msebera/android/httpclient/impl/cookie/BasicClientCookie;->setDomain(Ljava/lang/String;)V

    .line 182
    invoke-interface {v7}, Lcz/msebera/android/httpclient/HeaderElement;->getParameters()[Lcz/msebera/android/httpclient/NameValuePair;

    move-result-object v3

    .line 183
    .local v3, "attribs":[Lcz/msebera/android/httpclient/NameValuePair;
    array-length v0, v3

    move/from16 v19, v0

    add-int/lit8 v12, v19, -0x1

    .local v12, "j":I
    :goto_2
    if-ltz v12, :cond_a

    .line 184
    aget-object v2, v3, v12

    .line 185
    .local v2, "attrib":Lcz/msebera/android/httpclient/NameValuePair;
    invoke-interface {v2}, Lcz/msebera/android/httpclient/NameValuePair;->getName()Ljava/lang/String;

    move-result-object v19

    sget-object v20, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual/range {v19 .. v20}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v16

    .line 186
    .restart local v16    # "s":Ljava/lang/String;
    invoke-interface {v2}, Lcz/msebera/android/httpclient/NameValuePair;->getValue()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v16

    move-object/from16 v1, v19

    invoke-virtual {v5, v0, v1}, Lcz/msebera/android/httpclient/impl/cookie/BasicClientCookie;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 187
    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec;->findAttribHandler(Ljava/lang/String;)Lcz/msebera/android/httpclient/cookie/CookieAttributeHandler;

    move-result-object v8

    .line 188
    .local v8, "handler":Lcz/msebera/android/httpclient/cookie/CookieAttributeHandler;
    if-eqz v8, :cond_9

    .line 189
    invoke-interface {v2}, Lcz/msebera/android/httpclient/NameValuePair;->getValue()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-interface {v8, v5, v0}, Lcz/msebera/android/httpclient/cookie/CookieAttributeHandler;->parse(Lcz/msebera/android/httpclient/cookie/SetCookie;Ljava/lang/String;)V

    .line 183
    :cond_9
    add-int/lit8 v12, v12, -0x1

    goto :goto_2

    .line 193
    .end local v2    # "attrib":Lcz/msebera/android/httpclient/NameValuePair;
    .end local v8    # "handler":Lcz/msebera/android/httpclient/cookie/CookieAttributeHandler;
    .end local v16    # "s":Ljava/lang/String;
    :cond_a
    if-eqz v14, :cond_b

    .line 194
    const/16 v19, 0x0

    move/from16 v0, v19

    invoke-virtual {v5, v0}, Lcz/msebera/android/httpclient/impl/cookie/BasicClientCookie;->setVersion(I)V

    .line 196
    :cond_b
    invoke-static {v5}, Ljava/util/Collections;->singletonList(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v19

    .line 198
    .end local v3    # "attribs":[Lcz/msebera/android/httpclient/NameValuePair;
    .end local v4    # "buffer":Lcz/msebera/android/httpclient/util/CharArrayBuffer;
    .end local v5    # "cookie":Lcz/msebera/android/httpclient/impl/cookie/BasicClientCookie;
    .end local v6    # "cursor":Lcz/msebera/android/httpclient/message/ParserCursor;
    .end local v7    # "elem":Lcz/msebera/android/httpclient/HeaderElement;
    .end local v12    # "j":I
    .end local v13    # "name":Ljava/lang/String;
    .end local v15    # "parser":Lcz/msebera/android/httpclient/impl/cookie/NetscapeDraftHeaderParser;
    .end local v17    # "value":Ljava/lang/String;
    :goto_3
    return-object v19

    .restart local p1    # "header":Lcz/msebera/android/httpclient/Header;
    :cond_c
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-virtual {v0, v11, v1}, Lcz/msebera/android/httpclient/impl/cookie/BrowserCompatSpec;->parse([Lcz/msebera/android/httpclient/HeaderElement;Lcz/msebera/android/httpclient/cookie/CookieOrigin;)Ljava/util/List;

    move-result-object v19

    goto :goto_3
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 247
    const-string v0, "compatibility"

    return-object v0
.end method
