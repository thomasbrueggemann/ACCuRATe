.class final Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;
.super Ljava/lang/Object;
.source "HtmlTreeBuilderState.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/jsoup/parser/HtmlTreeBuilderState;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "Constants"
.end annotation


# static fields
.field private static final DdDt:[Ljava/lang/String;

.field private static final Formatters:[Ljava/lang/String;

.field private static final Headings:[Ljava/lang/String;

.field private static final InBodyEndAdoptionFormatters:[Ljava/lang/String;

.field private static final InBodyEndClosers:[Ljava/lang/String;

.field private static final InBodyEndTableFosters:[Ljava/lang/String;

.field private static final InBodyStartApplets:[Ljava/lang/String;

.field private static final InBodyStartDrop:[Ljava/lang/String;

.field private static final InBodyStartEmptyFormatters:[Ljava/lang/String;

.field private static final InBodyStartInputAttribs:[Ljava/lang/String;

.field private static final InBodyStartLiBreakers:[Ljava/lang/String;

.field private static final InBodyStartMedia:[Ljava/lang/String;

.field private static final InBodyStartOptions:[Ljava/lang/String;

.field private static final InBodyStartPClosers:[Ljava/lang/String;

.field private static final InBodyStartPreListing:[Ljava/lang/String;

.field private static final InBodyStartRuby:[Ljava/lang/String;

.field private static final InBodyStartToHead:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 1489
    const/16 v0, 0xa

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "base"

    aput-object v1, v0, v3

    const-string v1, "basefont"

    aput-object v1, v0, v4

    const-string v1, "bgsound"

    aput-object v1, v0, v5

    const-string v1, "command"

    aput-object v1, v0, v6

    const-string v1, "link"

    aput-object v1, v0, v7

    const/4 v1, 0x5

    const-string v2, "meta"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "noframes"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "script"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "style"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "title"

    aput-object v2, v0, v1

    sput-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->InBodyStartToHead:[Ljava/lang/String;

    .line 1490
    const/16 v0, 0x16

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "address"

    aput-object v1, v0, v3

    const-string v1, "article"

    aput-object v1, v0, v4

    const-string v1, "aside"

    aput-object v1, v0, v5

    const-string v1, "blockquote"

    aput-object v1, v0, v6

    const-string v1, "center"

    aput-object v1, v0, v7

    const/4 v1, 0x5

    const-string v2, "details"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "dir"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "div"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "dl"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "fieldset"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "figcaption"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string v2, "figure"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string v2, "footer"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string v2, "header"

    aput-object v2, v0, v1

    const/16 v1, 0xe

    const-string v2, "hgroup"

    aput-object v2, v0, v1

    const/16 v1, 0xf

    const-string v2, "menu"

    aput-object v2, v0, v1

    const/16 v1, 0x10

    const-string v2, "nav"

    aput-object v2, v0, v1

    const/16 v1, 0x11

    const-string v2, "ol"

    aput-object v2, v0, v1

    const/16 v1, 0x12

    const-string v2, "p"

    aput-object v2, v0, v1

    const/16 v1, 0x13

    const-string v2, "section"

    aput-object v2, v0, v1

    const/16 v1, 0x14

    const-string v2, "summary"

    aput-object v2, v0, v1

    const/16 v1, 0x15

    const-string v2, "ul"

    aput-object v2, v0, v1

    sput-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->InBodyStartPClosers:[Ljava/lang/String;

    .line 1493
    const/4 v0, 0x6

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "h1"

    aput-object v1, v0, v3

    const-string v1, "h2"

    aput-object v1, v0, v4

    const-string v1, "h3"

    aput-object v1, v0, v5

    const-string v1, "h4"

    aput-object v1, v0, v6

    const-string v1, "h5"

    aput-object v1, v0, v7

    const/4 v1, 0x5

    const-string v2, "h6"

    aput-object v2, v0, v1

    sput-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->Headings:[Ljava/lang/String;

    .line 1494
    new-array v0, v5, [Ljava/lang/String;

    const-string v1, "pre"

    aput-object v1, v0, v3

    const-string v1, "listing"

    aput-object v1, v0, v4

    sput-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->InBodyStartPreListing:[Ljava/lang/String;

    .line 1495
    new-array v0, v6, [Ljava/lang/String;

    const-string v1, "address"

    aput-object v1, v0, v3

    const-string v1, "div"

    aput-object v1, v0, v4

    const-string v1, "p"

    aput-object v1, v0, v5

    sput-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->InBodyStartLiBreakers:[Ljava/lang/String;

    .line 1496
    new-array v0, v5, [Ljava/lang/String;

    const-string v1, "dd"

    aput-object v1, v0, v3

    const-string v1, "dt"

    aput-object v1, v0, v4

    sput-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->DdDt:[Ljava/lang/String;

    .line 1497
    const/16 v0, 0xc

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "b"

    aput-object v1, v0, v3

    const-string v1, "big"

    aput-object v1, v0, v4

    const-string v1, "code"

    aput-object v1, v0, v5

    const-string v1, "em"

    aput-object v1, v0, v6

    const-string v1, "font"

    aput-object v1, v0, v7

    const/4 v1, 0x5

    const-string v2, "i"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "s"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "small"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "strike"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "strong"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "tt"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string v2, "u"

    aput-object v2, v0, v1

    sput-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->Formatters:[Ljava/lang/String;

    .line 1498
    new-array v0, v6, [Ljava/lang/String;

    const-string v1, "applet"

    aput-object v1, v0, v3

    const-string v1, "marquee"

    aput-object v1, v0, v4

    const-string v1, "object"

    aput-object v1, v0, v5

    sput-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->InBodyStartApplets:[Ljava/lang/String;

    .line 1499
    const/4 v0, 0x6

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "area"

    aput-object v1, v0, v3

    const-string v1, "br"

    aput-object v1, v0, v4

    const-string v1, "embed"

    aput-object v1, v0, v5

    const-string v1, "img"

    aput-object v1, v0, v6

    const-string v1, "keygen"

    aput-object v1, v0, v7

    const/4 v1, 0x5

    const-string v2, "wbr"

    aput-object v2, v0, v1

    sput-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->InBodyStartEmptyFormatters:[Ljava/lang/String;

    .line 1500
    new-array v0, v6, [Ljava/lang/String;

    const-string v1, "param"

    aput-object v1, v0, v3

    const-string v1, "source"

    aput-object v1, v0, v4

    const-string v1, "track"

    aput-object v1, v0, v5

    sput-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->InBodyStartMedia:[Ljava/lang/String;

    .line 1501
    new-array v0, v6, [Ljava/lang/String;

    const-string v1, "name"

    aput-object v1, v0, v3

    const-string v1, "action"

    aput-object v1, v0, v4

    const-string v1, "prompt"

    aput-object v1, v0, v5

    sput-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->InBodyStartInputAttribs:[Ljava/lang/String;

    .line 1502
    new-array v0, v5, [Ljava/lang/String;

    const-string v1, "optgroup"

    aput-object v1, v0, v3

    const-string v1, "option"

    aput-object v1, v0, v4

    sput-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->InBodyStartOptions:[Ljava/lang/String;

    .line 1503
    new-array v0, v5, [Ljava/lang/String;

    const-string v1, "rp"

    aput-object v1, v0, v3

    const-string v1, "rt"

    aput-object v1, v0, v4

    sput-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->InBodyStartRuby:[Ljava/lang/String;

    .line 1504
    const/16 v0, 0xb

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "caption"

    aput-object v1, v0, v3

    const-string v1, "col"

    aput-object v1, v0, v4

    const-string v1, "colgroup"

    aput-object v1, v0, v5

    const-string v1, "frame"

    aput-object v1, v0, v6

    const-string v1, "head"

    aput-object v1, v0, v7

    const/4 v1, 0x5

    const-string v2, "tbody"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "td"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "tfoot"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "th"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "thead"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "tr"

    aput-object v2, v0, v1

    sput-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->InBodyStartDrop:[Ljava/lang/String;

    .line 1505
    const/16 v0, 0x18

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "address"

    aput-object v1, v0, v3

    const-string v1, "article"

    aput-object v1, v0, v4

    const-string v1, "aside"

    aput-object v1, v0, v5

    const-string v1, "blockquote"

    aput-object v1, v0, v6

    const-string v1, "button"

    aput-object v1, v0, v7

    const/4 v1, 0x5

    const-string v2, "center"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "details"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "dir"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "div"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "dl"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "fieldset"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string v2, "figcaption"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string v2, "figure"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string v2, "footer"

    aput-object v2, v0, v1

    const/16 v1, 0xe

    const-string v2, "header"

    aput-object v2, v0, v1

    const/16 v1, 0xf

    const-string v2, "hgroup"

    aput-object v2, v0, v1

    const/16 v1, 0x10

    const-string v2, "listing"

    aput-object v2, v0, v1

    const/16 v1, 0x11

    const-string v2, "menu"

    aput-object v2, v0, v1

    const/16 v1, 0x12

    const-string v2, "nav"

    aput-object v2, v0, v1

    const/16 v1, 0x13

    const-string v2, "ol"

    aput-object v2, v0, v1

    const/16 v1, 0x14

    const-string v2, "pre"

    aput-object v2, v0, v1

    const/16 v1, 0x15

    const-string v2, "section"

    aput-object v2, v0, v1

    const/16 v1, 0x16

    const-string v2, "summary"

    aput-object v2, v0, v1

    const/16 v1, 0x17

    const-string v2, "ul"

    aput-object v2, v0, v1

    sput-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->InBodyEndClosers:[Ljava/lang/String;

    .line 1508
    const/16 v0, 0xe

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "a"

    aput-object v1, v0, v3

    const-string v1, "b"

    aput-object v1, v0, v4

    const-string v1, "big"

    aput-object v1, v0, v5

    const-string v1, "code"

    aput-object v1, v0, v6

    const-string v1, "em"

    aput-object v1, v0, v7

    const/4 v1, 0x5

    const-string v2, "font"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "i"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "nobr"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "s"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "small"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "strike"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string v2, "strong"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string v2, "tt"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string v2, "u"

    aput-object v2, v0, v1

    sput-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->InBodyEndAdoptionFormatters:[Ljava/lang/String;

    .line 1509
    const/4 v0, 0x5

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "table"

    aput-object v1, v0, v3

    const-string v1, "tbody"

    aput-object v1, v0, v4

    const-string v1, "tfoot"

    aput-object v1, v0, v5

    const-string v1, "thead"

    aput-object v1, v0, v6

    const-string v1, "tr"

    aput-object v1, v0, v7

    sput-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->InBodyEndTableFosters:[Ljava/lang/String;

    return-void
.end method

.method static synthetic access$1000()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 1488
    sget-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->InBodyStartPreListing:[Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1100()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 1488
    sget-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->DdDt:[Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1200()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 1488
    sget-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->Formatters:[Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1300()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 1488
    sget-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->InBodyStartApplets:[Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1400()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 1488
    sget-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->InBodyStartMedia:[Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1500()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 1488
    sget-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->InBodyStartInputAttribs:[Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1600()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 1488
    sget-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->InBodyStartOptions:[Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1700()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 1488
    sget-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->InBodyStartRuby:[Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1800()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 1488
    sget-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->InBodyStartDrop:[Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1900()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 1488
    sget-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->InBodyEndAdoptionFormatters:[Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$2000()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 1488
    sget-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->InBodyEndTableFosters:[Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$2100()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 1488
    sget-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->InBodyEndClosers:[Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$500()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 1488
    sget-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->InBodyStartEmptyFormatters:[Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$600()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 1488
    sget-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->InBodyStartPClosers:[Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$700()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 1488
    sget-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->InBodyStartLiBreakers:[Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$800()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 1488
    sget-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->InBodyStartToHead:[Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$900()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 1488
    sget-object v0, Lorg/jsoup/parser/HtmlTreeBuilderState$Constants;->Headings:[Ljava/lang/String;

    return-object v0
.end method
