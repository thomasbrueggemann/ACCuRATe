.class public Lorg/jsoup/parser/Tag;
.super Ljava/lang/Object;
.source "Tag.java"


# static fields
.field private static final blockTags:[Ljava/lang/String;

.field private static final emptyTags:[Ljava/lang/String;

.field private static final formListedTags:[Ljava/lang/String;

.field private static final formSubmitTags:[Ljava/lang/String;

.field private static final formatAsInlineTags:[Ljava/lang/String;

.field private static final inlineTags:[Ljava/lang/String;

.field private static final preserveWhitespaceTags:[Ljava/lang/String;

.field private static final tags:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lorg/jsoup/parser/Tag;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private canContainBlock:Z

.field private canContainInline:Z

.field private empty:Z

.field private formList:Z

.field private formSubmit:Z

.field private formatAsBlock:Z

.field private isBlock:Z

.field private preserveWhitespace:Z

.field private selfClosing:Z

.field private tagName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 10

    .prologue
    const/4 v9, 0x4

    const/4 v8, 0x3

    const/4 v6, 0x2

    const/4 v7, 0x1

    const/4 v2, 0x0

    .line 14
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    sput-object v3, Lorg/jsoup/parser/Tag;->tags:Ljava/util/Map;

    .line 221
    const/16 v3, 0x40

    new-array v3, v3, [Ljava/lang/String;

    const-string v4, "html"

    aput-object v4, v3, v2

    const-string v4, "head"

    aput-object v4, v3, v7

    const-string v4, "body"

    aput-object v4, v3, v6

    const-string v4, "frameset"

    aput-object v4, v3, v8

    const-string v4, "script"

    aput-object v4, v3, v9

    const/4 v4, 0x5

    const-string v5, "noscript"

    aput-object v5, v3, v4

    const/4 v4, 0x6

    const-string v5, "style"

    aput-object v5, v3, v4

    const/4 v4, 0x7

    const-string v5, "meta"

    aput-object v5, v3, v4

    const/16 v4, 0x8

    const-string v5, "link"

    aput-object v5, v3, v4

    const/16 v4, 0x9

    const-string v5, "title"

    aput-object v5, v3, v4

    const/16 v4, 0xa

    const-string v5, "frame"

    aput-object v5, v3, v4

    const/16 v4, 0xb

    const-string v5, "noframes"

    aput-object v5, v3, v4

    const/16 v4, 0xc

    const-string v5, "section"

    aput-object v5, v3, v4

    const/16 v4, 0xd

    const-string v5, "nav"

    aput-object v5, v3, v4

    const/16 v4, 0xe

    const-string v5, "aside"

    aput-object v5, v3, v4

    const/16 v4, 0xf

    const-string v5, "hgroup"

    aput-object v5, v3, v4

    const/16 v4, 0x10

    const-string v5, "header"

    aput-object v5, v3, v4

    const/16 v4, 0x11

    const-string v5, "footer"

    aput-object v5, v3, v4

    const/16 v4, 0x12

    const-string v5, "p"

    aput-object v5, v3, v4

    const/16 v4, 0x13

    const-string v5, "h1"

    aput-object v5, v3, v4

    const/16 v4, 0x14

    const-string v5, "h2"

    aput-object v5, v3, v4

    const/16 v4, 0x15

    const-string v5, "h3"

    aput-object v5, v3, v4

    const/16 v4, 0x16

    const-string v5, "h4"

    aput-object v5, v3, v4

    const/16 v4, 0x17

    const-string v5, "h5"

    aput-object v5, v3, v4

    const/16 v4, 0x18

    const-string v5, "h6"

    aput-object v5, v3, v4

    const/16 v4, 0x19

    const-string v5, "ul"

    aput-object v5, v3, v4

    const/16 v4, 0x1a

    const-string v5, "ol"

    aput-object v5, v3, v4

    const/16 v4, 0x1b

    const-string v5, "pre"

    aput-object v5, v3, v4

    const/16 v4, 0x1c

    const-string v5, "div"

    aput-object v5, v3, v4

    const/16 v4, 0x1d

    const-string v5, "blockquote"

    aput-object v5, v3, v4

    const/16 v4, 0x1e

    const-string v5, "hr"

    aput-object v5, v3, v4

    const/16 v4, 0x1f

    const-string v5, "address"

    aput-object v5, v3, v4

    const/16 v4, 0x20

    const-string v5, "figure"

    aput-object v5, v3, v4

    const/16 v4, 0x21

    const-string v5, "figcaption"

    aput-object v5, v3, v4

    const/16 v4, 0x22

    const-string v5, "form"

    aput-object v5, v3, v4

    const/16 v4, 0x23

    const-string v5, "fieldset"

    aput-object v5, v3, v4

    const/16 v4, 0x24

    const-string v5, "ins"

    aput-object v5, v3, v4

    const/16 v4, 0x25

    const-string v5, "del"

    aput-object v5, v3, v4

    const/16 v4, 0x26

    const-string v5, "s"

    aput-object v5, v3, v4

    const/16 v4, 0x27

    const-string v5, "dl"

    aput-object v5, v3, v4

    const/16 v4, 0x28

    const-string v5, "dt"

    aput-object v5, v3, v4

    const/16 v4, 0x29

    const-string v5, "dd"

    aput-object v5, v3, v4

    const/16 v4, 0x2a

    const-string v5, "li"

    aput-object v5, v3, v4

    const/16 v4, 0x2b

    const-string v5, "table"

    aput-object v5, v3, v4

    const/16 v4, 0x2c

    const-string v5, "caption"

    aput-object v5, v3, v4

    const/16 v4, 0x2d

    const-string v5, "thead"

    aput-object v5, v3, v4

    const/16 v4, 0x2e

    const-string v5, "tfoot"

    aput-object v5, v3, v4

    const/16 v4, 0x2f

    const-string v5, "tbody"

    aput-object v5, v3, v4

    const/16 v4, 0x30

    const-string v5, "colgroup"

    aput-object v5, v3, v4

    const/16 v4, 0x31

    const-string v5, "col"

    aput-object v5, v3, v4

    const/16 v4, 0x32

    const-string v5, "tr"

    aput-object v5, v3, v4

    const/16 v4, 0x33

    const-string v5, "th"

    aput-object v5, v3, v4

    const/16 v4, 0x34

    const-string v5, "td"

    aput-object v5, v3, v4

    const/16 v4, 0x35

    const-string v5, "video"

    aput-object v5, v3, v4

    const/16 v4, 0x36

    const-string v5, "audio"

    aput-object v5, v3, v4

    const/16 v4, 0x37

    const-string v5, "canvas"

    aput-object v5, v3, v4

    const/16 v4, 0x38

    const-string v5, "details"

    aput-object v5, v3, v4

    const/16 v4, 0x39

    const-string v5, "menu"

    aput-object v5, v3, v4

    const/16 v4, 0x3a

    const-string v5, "plaintext"

    aput-object v5, v3, v4

    const/16 v4, 0x3b

    const-string v5, "template"

    aput-object v5, v3, v4

    const/16 v4, 0x3c

    const-string v5, "article"

    aput-object v5, v3, v4

    const/16 v4, 0x3d

    const-string v5, "main"

    aput-object v5, v3, v4

    const/16 v4, 0x3e

    const-string v5, "svg"

    aput-object v5, v3, v4

    const/16 v4, 0x3f

    const-string v5, "math"

    aput-object v5, v3, v4

    sput-object v3, Lorg/jsoup/parser/Tag;->blockTags:[Ljava/lang/String;

    .line 229
    const/16 v3, 0x41

    new-array v3, v3, [Ljava/lang/String;

    const-string v4, "object"

    aput-object v4, v3, v2

    const-string v4, "base"

    aput-object v4, v3, v7

    const-string v4, "font"

    aput-object v4, v3, v6

    const-string v4, "tt"

    aput-object v4, v3, v8

    const-string v4, "i"

    aput-object v4, v3, v9

    const/4 v4, 0x5

    const-string v5, "b"

    aput-object v5, v3, v4

    const/4 v4, 0x6

    const-string v5, "u"

    aput-object v5, v3, v4

    const/4 v4, 0x7

    const-string v5, "big"

    aput-object v5, v3, v4

    const/16 v4, 0x8

    const-string v5, "small"

    aput-object v5, v3, v4

    const/16 v4, 0x9

    const-string v5, "em"

    aput-object v5, v3, v4

    const/16 v4, 0xa

    const-string v5, "strong"

    aput-object v5, v3, v4

    const/16 v4, 0xb

    const-string v5, "dfn"

    aput-object v5, v3, v4

    const/16 v4, 0xc

    const-string v5, "code"

    aput-object v5, v3, v4

    const/16 v4, 0xd

    const-string v5, "samp"

    aput-object v5, v3, v4

    const/16 v4, 0xe

    const-string v5, "kbd"

    aput-object v5, v3, v4

    const/16 v4, 0xf

    const-string v5, "var"

    aput-object v5, v3, v4

    const/16 v4, 0x10

    const-string v5, "cite"

    aput-object v5, v3, v4

    const/16 v4, 0x11

    const-string v5, "abbr"

    aput-object v5, v3, v4

    const/16 v4, 0x12

    const-string v5, "time"

    aput-object v5, v3, v4

    const/16 v4, 0x13

    const-string v5, "acronym"

    aput-object v5, v3, v4

    const/16 v4, 0x14

    const-string v5, "mark"

    aput-object v5, v3, v4

    const/16 v4, 0x15

    const-string v5, "ruby"

    aput-object v5, v3, v4

    const/16 v4, 0x16

    const-string v5, "rt"

    aput-object v5, v3, v4

    const/16 v4, 0x17

    const-string v5, "rp"

    aput-object v5, v3, v4

    const/16 v4, 0x18

    const-string v5, "a"

    aput-object v5, v3, v4

    const/16 v4, 0x19

    const-string v5, "img"

    aput-object v5, v3, v4

    const/16 v4, 0x1a

    const-string v5, "br"

    aput-object v5, v3, v4

    const/16 v4, 0x1b

    const-string v5, "wbr"

    aput-object v5, v3, v4

    const/16 v4, 0x1c

    const-string v5, "map"

    aput-object v5, v3, v4

    const/16 v4, 0x1d

    const-string v5, "q"

    aput-object v5, v3, v4

    const/16 v4, 0x1e

    const-string v5, "sub"

    aput-object v5, v3, v4

    const/16 v4, 0x1f

    const-string v5, "sup"

    aput-object v5, v3, v4

    const/16 v4, 0x20

    const-string v5, "bdo"

    aput-object v5, v3, v4

    const/16 v4, 0x21

    const-string v5, "iframe"

    aput-object v5, v3, v4

    const/16 v4, 0x22

    const-string v5, "embed"

    aput-object v5, v3, v4

    const/16 v4, 0x23

    const-string v5, "span"

    aput-object v5, v3, v4

    const/16 v4, 0x24

    const-string v5, "input"

    aput-object v5, v3, v4

    const/16 v4, 0x25

    const-string v5, "select"

    aput-object v5, v3, v4

    const/16 v4, 0x26

    const-string v5, "textarea"

    aput-object v5, v3, v4

    const/16 v4, 0x27

    const-string v5, "label"

    aput-object v5, v3, v4

    const/16 v4, 0x28

    const-string v5, "button"

    aput-object v5, v3, v4

    const/16 v4, 0x29

    const-string v5, "optgroup"

    aput-object v5, v3, v4

    const/16 v4, 0x2a

    const-string v5, "option"

    aput-object v5, v3, v4

    const/16 v4, 0x2b

    const-string v5, "legend"

    aput-object v5, v3, v4

    const/16 v4, 0x2c

    const-string v5, "datalist"

    aput-object v5, v3, v4

    const/16 v4, 0x2d

    const-string v5, "keygen"

    aput-object v5, v3, v4

    const/16 v4, 0x2e

    const-string v5, "output"

    aput-object v5, v3, v4

    const/16 v4, 0x2f

    const-string v5, "progress"

    aput-object v5, v3, v4

    const/16 v4, 0x30

    const-string v5, "meter"

    aput-object v5, v3, v4

    const/16 v4, 0x31

    const-string v5, "area"

    aput-object v5, v3, v4

    const/16 v4, 0x32

    const-string v5, "param"

    aput-object v5, v3, v4

    const/16 v4, 0x33

    const-string v5, "source"

    aput-object v5, v3, v4

    const/16 v4, 0x34

    const-string v5, "track"

    aput-object v5, v3, v4

    const/16 v4, 0x35

    const-string v5, "summary"

    aput-object v5, v3, v4

    const/16 v4, 0x36

    const-string v5, "command"

    aput-object v5, v3, v4

    const/16 v4, 0x37

    const-string v5, "device"

    aput-object v5, v3, v4

    const/16 v4, 0x38

    const-string v5, "area"

    aput-object v5, v3, v4

    const/16 v4, 0x39

    const-string v5, "basefont"

    aput-object v5, v3, v4

    const/16 v4, 0x3a

    const-string v5, "bgsound"

    aput-object v5, v3, v4

    const/16 v4, 0x3b

    const-string v5, "menuitem"

    aput-object v5, v3, v4

    const/16 v4, 0x3c

    const-string v5, "param"

    aput-object v5, v3, v4

    const/16 v4, 0x3d

    const-string v5, "source"

    aput-object v5, v3, v4

    const/16 v4, 0x3e

    const-string v5, "track"

    aput-object v5, v3, v4

    const/16 v4, 0x3f

    const-string v5, "data"

    aput-object v5, v3, v4

    const/16 v4, 0x40

    const-string v5, "bdi"

    aput-object v5, v3, v4

    sput-object v3, Lorg/jsoup/parser/Tag;->inlineTags:[Ljava/lang/String;

    .line 237
    const/16 v3, 0x15

    new-array v3, v3, [Ljava/lang/String;

    const-string v4, "meta"

    aput-object v4, v3, v2

    const-string v4, "link"

    aput-object v4, v3, v7

    const-string v4, "base"

    aput-object v4, v3, v6

    const-string v4, "frame"

    aput-object v4, v3, v8

    const-string v4, "img"

    aput-object v4, v3, v9

    const/4 v4, 0x5

    const-string v5, "br"

    aput-object v5, v3, v4

    const/4 v4, 0x6

    const-string v5, "wbr"

    aput-object v5, v3, v4

    const/4 v4, 0x7

    const-string v5, "embed"

    aput-object v5, v3, v4

    const/16 v4, 0x8

    const-string v5, "hr"

    aput-object v5, v3, v4

    const/16 v4, 0x9

    const-string v5, "input"

    aput-object v5, v3, v4

    const/16 v4, 0xa

    const-string v5, "keygen"

    aput-object v5, v3, v4

    const/16 v4, 0xb

    const-string v5, "col"

    aput-object v5, v3, v4

    const/16 v4, 0xc

    const-string v5, "command"

    aput-object v5, v3, v4

    const/16 v4, 0xd

    const-string v5, "device"

    aput-object v5, v3, v4

    const/16 v4, 0xe

    const-string v5, "area"

    aput-object v5, v3, v4

    const/16 v4, 0xf

    const-string v5, "basefont"

    aput-object v5, v3, v4

    const/16 v4, 0x10

    const-string v5, "bgsound"

    aput-object v5, v3, v4

    const/16 v4, 0x11

    const-string v5, "menuitem"

    aput-object v5, v3, v4

    const/16 v4, 0x12

    const-string v5, "param"

    aput-object v5, v3, v4

    const/16 v4, 0x13

    const-string v5, "source"

    aput-object v5, v3, v4

    const/16 v4, 0x14

    const-string v5, "track"

    aput-object v5, v3, v4

    sput-object v3, Lorg/jsoup/parser/Tag;->emptyTags:[Ljava/lang/String;

    .line 241
    const/16 v3, 0x13

    new-array v3, v3, [Ljava/lang/String;

    const-string v4, "title"

    aput-object v4, v3, v2

    const-string v4, "a"

    aput-object v4, v3, v7

    const-string v4, "p"

    aput-object v4, v3, v6

    const-string v4, "h1"

    aput-object v4, v3, v8

    const-string v4, "h2"

    aput-object v4, v3, v9

    const/4 v4, 0x5

    const-string v5, "h3"

    aput-object v5, v3, v4

    const/4 v4, 0x6

    const-string v5, "h4"

    aput-object v5, v3, v4

    const/4 v4, 0x7

    const-string v5, "h5"

    aput-object v5, v3, v4

    const/16 v4, 0x8

    const-string v5, "h6"

    aput-object v5, v3, v4

    const/16 v4, 0x9

    const-string v5, "pre"

    aput-object v5, v3, v4

    const/16 v4, 0xa

    const-string v5, "address"

    aput-object v5, v3, v4

    const/16 v4, 0xb

    const-string v5, "li"

    aput-object v5, v3, v4

    const/16 v4, 0xc

    const-string v5, "th"

    aput-object v5, v3, v4

    const/16 v4, 0xd

    const-string v5, "td"

    aput-object v5, v3, v4

    const/16 v4, 0xe

    const-string v5, "script"

    aput-object v5, v3, v4

    const/16 v4, 0xf

    const-string v5, "style"

    aput-object v5, v3, v4

    const/16 v4, 0x10

    const-string v5, "ins"

    aput-object v5, v3, v4

    const/16 v4, 0x11

    const-string v5, "del"

    aput-object v5, v3, v4

    const/16 v4, 0x12

    const-string v5, "s"

    aput-object v5, v3, v4

    sput-object v3, Lorg/jsoup/parser/Tag;->formatAsInlineTags:[Ljava/lang/String;

    .line 245
    new-array v3, v9, [Ljava/lang/String;

    const-string v4, "pre"

    aput-object v4, v3, v2

    const-string v4, "plaintext"

    aput-object v4, v3, v7

    const-string v4, "title"

    aput-object v4, v3, v6

    const-string v4, "textarea"

    aput-object v4, v3, v8

    sput-object v3, Lorg/jsoup/parser/Tag;->preserveWhitespaceTags:[Ljava/lang/String;

    .line 250
    const/16 v3, 0x8

    new-array v3, v3, [Ljava/lang/String;

    const-string v4, "button"

    aput-object v4, v3, v2

    const-string v4, "fieldset"

    aput-object v4, v3, v7

    const-string v4, "input"

    aput-object v4, v3, v6

    const-string v4, "keygen"

    aput-object v4, v3, v8

    const-string v4, "object"

    aput-object v4, v3, v9

    const/4 v4, 0x5

    const-string v5, "output"

    aput-object v5, v3, v4

    const/4 v4, 0x6

    const-string v5, "select"

    aput-object v5, v3, v4

    const/4 v4, 0x7

    const-string v5, "textarea"

    aput-object v5, v3, v4

    sput-object v3, Lorg/jsoup/parser/Tag;->formListedTags:[Ljava/lang/String;

    .line 253
    const/4 v3, 0x5

    new-array v3, v3, [Ljava/lang/String;

    const-string v4, "input"

    aput-object v4, v3, v2

    const-string v4, "keygen"

    aput-object v4, v3, v7

    const-string v4, "object"

    aput-object v4, v3, v6

    const-string v4, "select"

    aput-object v4, v3, v8

    const-string v4, "textarea"

    aput-object v4, v3, v9

    sput-object v3, Lorg/jsoup/parser/Tag;->formSubmitTags:[Ljava/lang/String;

    .line 259
    sget-object v4, Lorg/jsoup/parser/Tag;->blockTags:[Ljava/lang/String;

    array-length v5, v4

    move v3, v2

    .local v0, "tag":Lorg/jsoup/parser/Tag;
    .local v1, "tagName":Ljava/lang/String;
    :goto_0
    if-ge v3, v5, :cond_0

    aget-object v1, v4, v3

    .line 260
    new-instance v0, Lorg/jsoup/parser/Tag;

    .end local v0    # "tag":Lorg/jsoup/parser/Tag;
    invoke-direct {v0, v1}, Lorg/jsoup/parser/Tag;-><init>(Ljava/lang/String;)V

    .line 261
    .restart local v0    # "tag":Lorg/jsoup/parser/Tag;
    invoke-static {v0}, Lorg/jsoup/parser/Tag;->register(Lorg/jsoup/parser/Tag;)V

    .line 259
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 263
    :cond_0
    sget-object v4, Lorg/jsoup/parser/Tag;->inlineTags:[Ljava/lang/String;

    array-length v5, v4

    move v3, v2

    :goto_1
    if-ge v3, v5, :cond_1

    aget-object v1, v4, v3

    .line 264
    new-instance v0, Lorg/jsoup/parser/Tag;

    .end local v0    # "tag":Lorg/jsoup/parser/Tag;
    invoke-direct {v0, v1}, Lorg/jsoup/parser/Tag;-><init>(Ljava/lang/String;)V

    .line 265
    .restart local v0    # "tag":Lorg/jsoup/parser/Tag;
    iput-boolean v2, v0, Lorg/jsoup/parser/Tag;->isBlock:Z

    .line 266
    iput-boolean v2, v0, Lorg/jsoup/parser/Tag;->canContainBlock:Z

    .line 267
    iput-boolean v2, v0, Lorg/jsoup/parser/Tag;->formatAsBlock:Z

    .line 268
    invoke-static {v0}, Lorg/jsoup/parser/Tag;->register(Lorg/jsoup/parser/Tag;)V

    .line 263
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 272
    :cond_1
    sget-object v4, Lorg/jsoup/parser/Tag;->emptyTags:[Ljava/lang/String;

    array-length v5, v4

    move v3, v2

    :goto_2
    if-ge v3, v5, :cond_2

    aget-object v1, v4, v3

    .line 273
    sget-object v6, Lorg/jsoup/parser/Tag;->tags:Ljava/util/Map;

    invoke-interface {v6, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "tag":Lorg/jsoup/parser/Tag;
    check-cast v0, Lorg/jsoup/parser/Tag;

    .line 274
    .restart local v0    # "tag":Lorg/jsoup/parser/Tag;
    invoke-static {v0}, Lorg/jsoup/helper/Validate;->notNull(Ljava/lang/Object;)V

    .line 275
    iput-boolean v2, v0, Lorg/jsoup/parser/Tag;->canContainBlock:Z

    .line 276
    iput-boolean v2, v0, Lorg/jsoup/parser/Tag;->canContainInline:Z

    .line 277
    iput-boolean v7, v0, Lorg/jsoup/parser/Tag;->empty:Z

    .line 272
    add-int/lit8 v3, v3, 0x1

    goto :goto_2

    .line 280
    :cond_2
    sget-object v4, Lorg/jsoup/parser/Tag;->formatAsInlineTags:[Ljava/lang/String;

    array-length v5, v4

    move v3, v2

    :goto_3
    if-ge v3, v5, :cond_3

    aget-object v1, v4, v3

    .line 281
    sget-object v6, Lorg/jsoup/parser/Tag;->tags:Ljava/util/Map;

    invoke-interface {v6, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "tag":Lorg/jsoup/parser/Tag;
    check-cast v0, Lorg/jsoup/parser/Tag;

    .line 282
    .restart local v0    # "tag":Lorg/jsoup/parser/Tag;
    invoke-static {v0}, Lorg/jsoup/helper/Validate;->notNull(Ljava/lang/Object;)V

    .line 283
    iput-boolean v2, v0, Lorg/jsoup/parser/Tag;->formatAsBlock:Z

    .line 280
    add-int/lit8 v3, v3, 0x1

    goto :goto_3

    .line 286
    :cond_3
    sget-object v4, Lorg/jsoup/parser/Tag;->preserveWhitespaceTags:[Ljava/lang/String;

    array-length v5, v4

    move v3, v2

    :goto_4
    if-ge v3, v5, :cond_4

    aget-object v1, v4, v3

    .line 287
    sget-object v6, Lorg/jsoup/parser/Tag;->tags:Ljava/util/Map;

    invoke-interface {v6, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "tag":Lorg/jsoup/parser/Tag;
    check-cast v0, Lorg/jsoup/parser/Tag;

    .line 288
    .restart local v0    # "tag":Lorg/jsoup/parser/Tag;
    invoke-static {v0}, Lorg/jsoup/helper/Validate;->notNull(Ljava/lang/Object;)V

    .line 289
    iput-boolean v7, v0, Lorg/jsoup/parser/Tag;->preserveWhitespace:Z

    .line 286
    add-int/lit8 v3, v3, 0x1

    goto :goto_4

    .line 292
    :cond_4
    sget-object v4, Lorg/jsoup/parser/Tag;->formListedTags:[Ljava/lang/String;

    array-length v5, v4

    move v3, v2

    :goto_5
    if-ge v3, v5, :cond_5

    aget-object v1, v4, v3

    .line 293
    sget-object v6, Lorg/jsoup/parser/Tag;->tags:Ljava/util/Map;

    invoke-interface {v6, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "tag":Lorg/jsoup/parser/Tag;
    check-cast v0, Lorg/jsoup/parser/Tag;

    .line 294
    .restart local v0    # "tag":Lorg/jsoup/parser/Tag;
    invoke-static {v0}, Lorg/jsoup/helper/Validate;->notNull(Ljava/lang/Object;)V

    .line 295
    iput-boolean v7, v0, Lorg/jsoup/parser/Tag;->formList:Z

    .line 292
    add-int/lit8 v3, v3, 0x1

    goto :goto_5

    .line 298
    :cond_5
    sget-object v3, Lorg/jsoup/parser/Tag;->formSubmitTags:[Ljava/lang/String;

    array-length v4, v3

    :goto_6
    if-ge v2, v4, :cond_6

    aget-object v1, v3, v2

    .line 299
    sget-object v5, Lorg/jsoup/parser/Tag;->tags:Ljava/util/Map;

    invoke-interface {v5, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "tag":Lorg/jsoup/parser/Tag;
    check-cast v0, Lorg/jsoup/parser/Tag;

    .line 300
    .restart local v0    # "tag":Lorg/jsoup/parser/Tag;
    invoke-static {v0}, Lorg/jsoup/helper/Validate;->notNull(Ljava/lang/Object;)V

    .line 301
    iput-boolean v7, v0, Lorg/jsoup/parser/Tag;->formSubmit:Z

    .line 298
    add-int/lit8 v2, v2, 0x1

    goto :goto_6

    .line 303
    :cond_6
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;)V
    .locals 2
    .param p1, "tagName"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    iput-boolean v1, p0, Lorg/jsoup/parser/Tag;->isBlock:Z

    .line 18
    iput-boolean v1, p0, Lorg/jsoup/parser/Tag;->formatAsBlock:Z

    .line 19
    iput-boolean v1, p0, Lorg/jsoup/parser/Tag;->canContainBlock:Z

    .line 20
    iput-boolean v1, p0, Lorg/jsoup/parser/Tag;->canContainInline:Z

    .line 21
    iput-boolean v0, p0, Lorg/jsoup/parser/Tag;->empty:Z

    .line 22
    iput-boolean v0, p0, Lorg/jsoup/parser/Tag;->selfClosing:Z

    .line 23
    iput-boolean v0, p0, Lorg/jsoup/parser/Tag;->preserveWhitespace:Z

    .line 24
    iput-boolean v0, p0, Lorg/jsoup/parser/Tag;->formList:Z

    .line 25
    iput-boolean v0, p0, Lorg/jsoup/parser/Tag;->formSubmit:Z

    .line 28
    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lorg/jsoup/parser/Tag;->tagName:Ljava/lang/String;

    .line 29
    return-void
.end method

.method private static register(Lorg/jsoup/parser/Tag;)V
    .locals 2
    .param p0, "tag"    # Lorg/jsoup/parser/Tag;

    .prologue
    .line 306
    sget-object v0, Lorg/jsoup/parser/Tag;->tags:Ljava/util/Map;

    iget-object v1, p0, Lorg/jsoup/parser/Tag;->tagName:Ljava/lang/String;

    invoke-interface {v0, v1, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 307
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lorg/jsoup/parser/Tag;
    .locals 2
    .param p0, "tagName"    # Ljava/lang/String;

    .prologue
    .line 50
    invoke-static {p0}, Lorg/jsoup/helper/Validate;->notNull(Ljava/lang/Object;)V

    .line 51
    sget-object v1, Lorg/jsoup/parser/Tag;->tags:Ljava/util/Map;

    invoke-interface {v1, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/jsoup/parser/Tag;

    .line 53
    .local v0, "tag":Lorg/jsoup/parser/Tag;
    if-nez v0, :cond_0

    .line 54
    invoke-virtual {p0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object p0

    .line 55
    invoke-static {p0}, Lorg/jsoup/helper/Validate;->notEmpty(Ljava/lang/String;)V

    .line 56
    sget-object v1, Lorg/jsoup/parser/Tag;->tags:Ljava/util/Map;

    invoke-interface {v1, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "tag":Lorg/jsoup/parser/Tag;
    check-cast v0, Lorg/jsoup/parser/Tag;

    .line 58
    .restart local v0    # "tag":Lorg/jsoup/parser/Tag;
    if-nez v0, :cond_0

    .line 60
    new-instance v0, Lorg/jsoup/parser/Tag;

    .end local v0    # "tag":Lorg/jsoup/parser/Tag;
    invoke-direct {v0, p0}, Lorg/jsoup/parser/Tag;-><init>(Ljava/lang/String;)V

    .line 61
    .restart local v0    # "tag":Lorg/jsoup/parser/Tag;
    const/4 v1, 0x0

    iput-boolean v1, v0, Lorg/jsoup/parser/Tag;->isBlock:Z

    .line 62
    const/4 v1, 0x1

    iput-boolean v1, v0, Lorg/jsoup/parser/Tag;->canContainBlock:Z

    .line 65
    :cond_0
    return-object v0
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 182
    if-ne p0, p1, :cond_1

    move v2, v1

    .line 196
    :cond_0
    :goto_0
    return v2

    .line 183
    :cond_1
    instance-of v3, p1, Lorg/jsoup/parser/Tag;

    if-eqz v3, :cond_0

    move-object v0, p1

    .line 185
    check-cast v0, Lorg/jsoup/parser/Tag;

    .line 187
    .local v0, "tag":Lorg/jsoup/parser/Tag;
    iget-object v3, p0, Lorg/jsoup/parser/Tag;->tagName:Ljava/lang/String;

    iget-object v4, v0, Lorg/jsoup/parser/Tag;->tagName:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 188
    iget-boolean v3, p0, Lorg/jsoup/parser/Tag;->canContainBlock:Z

    iget-boolean v4, v0, Lorg/jsoup/parser/Tag;->canContainBlock:Z

    if-ne v3, v4, :cond_0

    .line 189
    iget-boolean v3, p0, Lorg/jsoup/parser/Tag;->canContainInline:Z

    iget-boolean v4, v0, Lorg/jsoup/parser/Tag;->canContainInline:Z

    if-ne v3, v4, :cond_0

    .line 190
    iget-boolean v3, p0, Lorg/jsoup/parser/Tag;->empty:Z

    iget-boolean v4, v0, Lorg/jsoup/parser/Tag;->empty:Z

    if-ne v3, v4, :cond_0

    .line 191
    iget-boolean v3, p0, Lorg/jsoup/parser/Tag;->formatAsBlock:Z

    iget-boolean v4, v0, Lorg/jsoup/parser/Tag;->formatAsBlock:Z

    if-ne v3, v4, :cond_0

    .line 192
    iget-boolean v3, p0, Lorg/jsoup/parser/Tag;->isBlock:Z

    iget-boolean v4, v0, Lorg/jsoup/parser/Tag;->isBlock:Z

    if-ne v3, v4, :cond_0

    .line 193
    iget-boolean v3, p0, Lorg/jsoup/parser/Tag;->preserveWhitespace:Z

    iget-boolean v4, v0, Lorg/jsoup/parser/Tag;->preserveWhitespace:Z

    if-ne v3, v4, :cond_0

    .line 194
    iget-boolean v3, p0, Lorg/jsoup/parser/Tag;->selfClosing:Z

    iget-boolean v4, v0, Lorg/jsoup/parser/Tag;->selfClosing:Z

    if-ne v3, v4, :cond_0

    .line 195
    iget-boolean v3, p0, Lorg/jsoup/parser/Tag;->formList:Z

    iget-boolean v4, v0, Lorg/jsoup/parser/Tag;->formList:Z

    if-ne v3, v4, :cond_0

    .line 196
    iget-boolean v3, p0, Lorg/jsoup/parser/Tag;->formSubmit:Z

    iget-boolean v4, v0, Lorg/jsoup/parser/Tag;->formSubmit:Z

    if-ne v3, v4, :cond_2

    :goto_1
    move v2, v1

    goto :goto_0

    :cond_2
    move v1, v2

    goto :goto_1
.end method

.method public formatAsBlock()Z
    .locals 1

    .prologue
    .line 83
    iget-boolean v0, p0, Lorg/jsoup/parser/Tag;->formatAsBlock:Z

    return v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lorg/jsoup/parser/Tag;->tagName:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 5

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 201
    iget-object v1, p0, Lorg/jsoup/parser/Tag;->tagName:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v0

    .line 202
    .local v0, "result":I
    mul-int/lit8 v4, v0, 0x1f

    iget-boolean v1, p0, Lorg/jsoup/parser/Tag;->isBlock:Z

    if-eqz v1, :cond_0

    move v1, v2

    :goto_0
    add-int v0, v4, v1

    .line 203
    mul-int/lit8 v4, v0, 0x1f

    iget-boolean v1, p0, Lorg/jsoup/parser/Tag;->formatAsBlock:Z

    if-eqz v1, :cond_1

    move v1, v2

    :goto_1
    add-int v0, v4, v1

    .line 204
    mul-int/lit8 v4, v0, 0x1f

    iget-boolean v1, p0, Lorg/jsoup/parser/Tag;->canContainBlock:Z

    if-eqz v1, :cond_2

    move v1, v2

    :goto_2
    add-int v0, v4, v1

    .line 205
    mul-int/lit8 v4, v0, 0x1f

    iget-boolean v1, p0, Lorg/jsoup/parser/Tag;->canContainInline:Z

    if-eqz v1, :cond_3

    move v1, v2

    :goto_3
    add-int v0, v4, v1

    .line 206
    mul-int/lit8 v4, v0, 0x1f

    iget-boolean v1, p0, Lorg/jsoup/parser/Tag;->empty:Z

    if-eqz v1, :cond_4

    move v1, v2

    :goto_4
    add-int v0, v4, v1

    .line 207
    mul-int/lit8 v4, v0, 0x1f

    iget-boolean v1, p0, Lorg/jsoup/parser/Tag;->selfClosing:Z

    if-eqz v1, :cond_5

    move v1, v2

    :goto_5
    add-int v0, v4, v1

    .line 208
    mul-int/lit8 v4, v0, 0x1f

    iget-boolean v1, p0, Lorg/jsoup/parser/Tag;->preserveWhitespace:Z

    if-eqz v1, :cond_6

    move v1, v2

    :goto_6
    add-int v0, v4, v1

    .line 209
    mul-int/lit8 v4, v0, 0x1f

    iget-boolean v1, p0, Lorg/jsoup/parser/Tag;->formList:Z

    if-eqz v1, :cond_7

    move v1, v2

    :goto_7
    add-int v0, v4, v1

    .line 210
    mul-int/lit8 v1, v0, 0x1f

    iget-boolean v4, p0, Lorg/jsoup/parser/Tag;->formSubmit:Z

    if-eqz v4, :cond_8

    :goto_8
    add-int v0, v1, v2

    .line 211
    return v0

    :cond_0
    move v1, v3

    .line 202
    goto :goto_0

    :cond_1
    move v1, v3

    .line 203
    goto :goto_1

    :cond_2
    move v1, v3

    .line 204
    goto :goto_2

    :cond_3
    move v1, v3

    .line 205
    goto :goto_3

    :cond_4
    move v1, v3

    .line 206
    goto :goto_4

    :cond_5
    move v1, v3

    .line 207
    goto :goto_5

    :cond_6
    move v1, v3

    .line 208
    goto :goto_6

    :cond_7
    move v1, v3

    .line 209
    goto :goto_7

    :cond_8
    move v2, v3

    .line 210
    goto :goto_8
.end method

.method public isBlock()Z
    .locals 1

    .prologue
    .line 74
    iget-boolean v0, p0, Lorg/jsoup/parser/Tag;->isBlock:Z

    return v0
.end method

.method public isEmpty()Z
    .locals 1

    .prologue
    .line 119
    iget-boolean v0, p0, Lorg/jsoup/parser/Tag;->empty:Z

    return v0
.end method

.method public isFormListed()Z
    .locals 1

    .prologue
    .line 164
    iget-boolean v0, p0, Lorg/jsoup/parser/Tag;->formList:Z

    return v0
.end method

.method public isKnownTag()Z
    .locals 2

    .prologue
    .line 137
    sget-object v0, Lorg/jsoup/parser/Tag;->tags:Ljava/util/Map;

    iget-object v1, p0, Lorg/jsoup/parser/Tag;->tagName:Ljava/lang/String;

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public isSelfClosing()Z
    .locals 1

    .prologue
    .line 128
    iget-boolean v0, p0, Lorg/jsoup/parser/Tag;->empty:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lorg/jsoup/parser/Tag;->selfClosing:Z

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public preserveWhitespace()Z
    .locals 1

    .prologue
    .line 156
    iget-boolean v0, p0, Lorg/jsoup/parser/Tag;->preserveWhitespace:Z

    return v0
.end method

.method setSelfClosing()Lorg/jsoup/parser/Tag;
    .locals 1

    .prologue
    .line 176
    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/jsoup/parser/Tag;->selfClosing:Z

    .line 177
    return-object p0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 216
    iget-object v0, p0, Lorg/jsoup/parser/Tag;->tagName:Ljava/lang/String;

    return-object v0
.end method
