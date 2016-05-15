.class public Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;
.super Ljava/lang/Object;
.source "BasicHeaderElementIterator.java"

# interfaces
.implements Lcz/msebera/android/httpclient/HeaderElementIterator;


# instance fields
.field private buffer:Lcz/msebera/android/httpclient/util/CharArrayBuffer;

.field private currentElement:Lcz/msebera/android/httpclient/HeaderElement;

.field private cursor:Lcz/msebera/android/httpclient/message/ParserCursor;

.field private final headerIt:Lcz/msebera/android/httpclient/HeaderIterator;

.field private final parser:Lcz/msebera/android/httpclient/message/HeaderValueParser;


# direct methods
.method public constructor <init>(Lcz/msebera/android/httpclient/HeaderIterator;)V
    .locals 1
    .param p1, "headerIterator"    # Lcz/msebera/android/httpclient/HeaderIterator;

    .prologue
    .line 68
    sget-object v0, Lcz/msebera/android/httpclient/message/BasicHeaderValueParser;->INSTANCE:Lcz/msebera/android/httpclient/message/BasicHeaderValueParser;

    invoke-direct {p0, p1, v0}, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;-><init>(Lcz/msebera/android/httpclient/HeaderIterator;Lcz/msebera/android/httpclient/message/HeaderValueParser;)V

    .line 69
    return-void
.end method

.method public constructor <init>(Lcz/msebera/android/httpclient/HeaderIterator;Lcz/msebera/android/httpclient/message/HeaderValueParser;)V
    .locals 1
    .param p1, "headerIterator"    # Lcz/msebera/android/httpclient/HeaderIterator;
    .param p2, "parser"    # Lcz/msebera/android/httpclient/message/HeaderValueParser;

    .prologue
    const/4 v0, 0x0

    .line 61
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 52
    iput-object v0, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->currentElement:Lcz/msebera/android/httpclient/HeaderElement;

    .line 53
    iput-object v0, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->buffer:Lcz/msebera/android/httpclient/util/CharArrayBuffer;

    .line 54
    iput-object v0, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->cursor:Lcz/msebera/android/httpclient/message/ParserCursor;

    .line 62
    const-string v0, "Header iterator"

    invoke-static {p1, v0}, Lcz/msebera/android/httpclient/util/Args;->notNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcz/msebera/android/httpclient/HeaderIterator;

    iput-object v0, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->headerIt:Lcz/msebera/android/httpclient/HeaderIterator;

    .line 63
    const-string v0, "Parser"

    invoke-static {p2, v0}, Lcz/msebera/android/httpclient/util/Args;->notNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcz/msebera/android/httpclient/message/HeaderValueParser;

    iput-object v0, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->parser:Lcz/msebera/android/httpclient/message/HeaderValueParser;

    .line 64
    return-void
.end method

.method private bufferHeaderValue()V
    .locals 5

    .prologue
    const/4 v2, 0x0

    const/4 v4, 0x0

    .line 73
    iput-object v2, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->cursor:Lcz/msebera/android/httpclient/message/ParserCursor;

    .line 74
    iput-object v2, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->buffer:Lcz/msebera/android/httpclient/util/CharArrayBuffer;

    .line 75
    :cond_0
    iget-object v2, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->headerIt:Lcz/msebera/android/httpclient/HeaderIterator;

    invoke-interface {v2}, Lcz/msebera/android/httpclient/HeaderIterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 76
    iget-object v2, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->headerIt:Lcz/msebera/android/httpclient/HeaderIterator;

    invoke-interface {v2}, Lcz/msebera/android/httpclient/HeaderIterator;->nextHeader()Lcz/msebera/android/httpclient/Header;

    move-result-object v0

    .line 77
    .local v0, "h":Lcz/msebera/android/httpclient/Header;
    instance-of v2, v0, Lcz/msebera/android/httpclient/FormattedHeader;

    if-eqz v2, :cond_2

    move-object v2, v0

    .line 78
    check-cast v2, Lcz/msebera/android/httpclient/FormattedHeader;

    invoke-interface {v2}, Lcz/msebera/android/httpclient/FormattedHeader;->getBuffer()Lcz/msebera/android/httpclient/util/CharArrayBuffer;

    move-result-object v2

    iput-object v2, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->buffer:Lcz/msebera/android/httpclient/util/CharArrayBuffer;

    .line 79
    new-instance v2, Lcz/msebera/android/httpclient/message/ParserCursor;

    iget-object v3, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->buffer:Lcz/msebera/android/httpclient/util/CharArrayBuffer;

    invoke-virtual {v3}, Lcz/msebera/android/httpclient/util/CharArrayBuffer;->length()I

    move-result v3

    invoke-direct {v2, v4, v3}, Lcz/msebera/android/httpclient/message/ParserCursor;-><init>(II)V

    iput-object v2, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->cursor:Lcz/msebera/android/httpclient/message/ParserCursor;

    .line 80
    iget-object v2, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->cursor:Lcz/msebera/android/httpclient/message/ParserCursor;

    check-cast v0, Lcz/msebera/android/httpclient/FormattedHeader;

    .end local v0    # "h":Lcz/msebera/android/httpclient/Header;
    invoke-interface {v0}, Lcz/msebera/android/httpclient/FormattedHeader;->getValuePos()I

    move-result v3

    invoke-virtual {v2, v3}, Lcz/msebera/android/httpclient/message/ParserCursor;->updatePos(I)V

    .line 92
    :cond_1
    :goto_0
    return-void

    .line 83
    .restart local v0    # "h":Lcz/msebera/android/httpclient/Header;
    :cond_2
    invoke-interface {v0}, Lcz/msebera/android/httpclient/Header;->getValue()Ljava/lang/String;

    move-result-object v1

    .line 84
    .local v1, "value":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 85
    new-instance v2, Lcz/msebera/android/httpclient/util/CharArrayBuffer;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v3

    invoke-direct {v2, v3}, Lcz/msebera/android/httpclient/util/CharArrayBuffer;-><init>(I)V

    iput-object v2, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->buffer:Lcz/msebera/android/httpclient/util/CharArrayBuffer;

    .line 86
    iget-object v2, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->buffer:Lcz/msebera/android/httpclient/util/CharArrayBuffer;

    invoke-virtual {v2, v1}, Lcz/msebera/android/httpclient/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 87
    new-instance v2, Lcz/msebera/android/httpclient/message/ParserCursor;

    iget-object v3, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->buffer:Lcz/msebera/android/httpclient/util/CharArrayBuffer;

    invoke-virtual {v3}, Lcz/msebera/android/httpclient/util/CharArrayBuffer;->length()I

    move-result v3

    invoke-direct {v2, v4, v3}, Lcz/msebera/android/httpclient/message/ParserCursor;-><init>(II)V

    iput-object v2, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->cursor:Lcz/msebera/android/httpclient/message/ParserCursor;

    goto :goto_0
.end method

.method private parseNextElement()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 96
    :cond_0
    :goto_0
    iget-object v1, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->headerIt:Lcz/msebera/android/httpclient/HeaderIterator;

    invoke-interface {v1}, Lcz/msebera/android/httpclient/HeaderIterator;->hasNext()Z

    move-result v1

    if-nez v1, :cond_1

    iget-object v1, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->cursor:Lcz/msebera/android/httpclient/message/ParserCursor;

    if-eqz v1, :cond_6

    .line 97
    :cond_1
    iget-object v1, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->cursor:Lcz/msebera/android/httpclient/message/ParserCursor;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->cursor:Lcz/msebera/android/httpclient/message/ParserCursor;

    invoke-virtual {v1}, Lcz/msebera/android/httpclient/message/ParserCursor;->atEnd()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 99
    :cond_2
    invoke-direct {p0}, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->bufferHeaderValue()V

    .line 102
    :cond_3
    iget-object v1, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->cursor:Lcz/msebera/android/httpclient/message/ParserCursor;

    if-eqz v1, :cond_0

    .line 104
    :cond_4
    iget-object v1, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->cursor:Lcz/msebera/android/httpclient/message/ParserCursor;

    invoke-virtual {v1}, Lcz/msebera/android/httpclient/message/ParserCursor;->atEnd()Z

    move-result v1

    if-nez v1, :cond_7

    .line 105
    iget-object v1, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->parser:Lcz/msebera/android/httpclient/message/HeaderValueParser;

    iget-object v2, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->buffer:Lcz/msebera/android/httpclient/util/CharArrayBuffer;

    iget-object v3, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->cursor:Lcz/msebera/android/httpclient/message/ParserCursor;

    invoke-interface {v1, v2, v3}, Lcz/msebera/android/httpclient/message/HeaderValueParser;->parseHeaderElement(Lcz/msebera/android/httpclient/util/CharArrayBuffer;Lcz/msebera/android/httpclient/message/ParserCursor;)Lcz/msebera/android/httpclient/HeaderElement;

    move-result-object v0

    .line 106
    .local v0, "e":Lcz/msebera/android/httpclient/HeaderElement;
    invoke-interface {v0}, Lcz/msebera/android/httpclient/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_5

    invoke-interface {v0}, Lcz/msebera/android/httpclient/HeaderElement;->getValue()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_4

    .line 108
    :cond_5
    iput-object v0, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->currentElement:Lcz/msebera/android/httpclient/HeaderElement;

    .line 120
    .end local v0    # "e":Lcz/msebera/android/httpclient/HeaderElement;
    :cond_6
    return-void

    .line 113
    :cond_7
    iget-object v1, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->cursor:Lcz/msebera/android/httpclient/message/ParserCursor;

    invoke-virtual {v1}, Lcz/msebera/android/httpclient/message/ParserCursor;->atEnd()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 115
    iput-object v4, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->cursor:Lcz/msebera/android/httpclient/message/ParserCursor;

    .line 116
    iput-object v4, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->buffer:Lcz/msebera/android/httpclient/util/CharArrayBuffer;

    goto :goto_0
.end method


# virtual methods
.method public hasNext()Z
    .locals 1

    .prologue
    .line 123
    iget-object v0, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->currentElement:Lcz/msebera/android/httpclient/HeaderElement;

    if-nez v0, :cond_0

    .line 124
    invoke-direct {p0}, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->parseNextElement()V

    .line 126
    :cond_0
    iget-object v0, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->currentElement:Lcz/msebera/android/httpclient/HeaderElement;

    if-eqz v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final next()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/util/NoSuchElementException;
        }
    .end annotation

    .prologue
    .line 144
    invoke-virtual {p0}, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->nextElement()Lcz/msebera/android/httpclient/HeaderElement;

    move-result-object v0

    return-object v0
.end method

.method public nextElement()Lcz/msebera/android/httpclient/HeaderElement;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/util/NoSuchElementException;
        }
    .end annotation

    .prologue
    .line 130
    iget-object v1, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->currentElement:Lcz/msebera/android/httpclient/HeaderElement;

    if-nez v1, :cond_0

    .line 131
    invoke-direct {p0}, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->parseNextElement()V

    .line 134
    :cond_0
    iget-object v1, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->currentElement:Lcz/msebera/android/httpclient/HeaderElement;

    if-nez v1, :cond_1

    .line 135
    new-instance v1, Ljava/util/NoSuchElementException;

    const-string v2, "No more header elements available"

    invoke-direct {v1, v2}, Ljava/util/NoSuchElementException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 138
    :cond_1
    iget-object v0, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->currentElement:Lcz/msebera/android/httpclient/HeaderElement;

    .line 139
    .local v0, "element":Lcz/msebera/android/httpclient/HeaderElement;
    const/4 v1, 0x0

    iput-object v1, p0, Lcz/msebera/android/httpclient/message/BasicHeaderElementIterator;->currentElement:Lcz/msebera/android/httpclient/HeaderElement;

    .line 140
    return-object v0
.end method

.method public remove()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/UnsupportedOperationException;
        }
    .end annotation

    .prologue
    .line 148
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "Remove not supported"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
