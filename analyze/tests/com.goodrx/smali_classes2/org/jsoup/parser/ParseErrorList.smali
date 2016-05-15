.class Lorg/jsoup/parser/ParseErrorList;
.super Ljava/util/ArrayList;
.source "ParseErrorList.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/util/ArrayList",
        "<",
        "Lorg/jsoup/parser/ParseError;",
        ">;"
    }
.end annotation


# instance fields
.field private final maxSize:I


# direct methods
.method constructor <init>(II)V
    .locals 0
    .param p1, "initialCapacity"    # I
    .param p2, "maxSize"    # I

    .prologue
    .line 15
    invoke-direct {p0, p1}, Ljava/util/ArrayList;-><init>(I)V

    .line 16
    iput p2, p0, Lorg/jsoup/parser/ParseErrorList;->maxSize:I

    .line 17
    return-void
.end method

.method static noTracking()Lorg/jsoup/parser/ParseErrorList;
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 28
    new-instance v0, Lorg/jsoup/parser/ParseErrorList;

    invoke-direct {v0, v1, v1}, Lorg/jsoup/parser/ParseErrorList;-><init>(II)V

    return-object v0
.end method


# virtual methods
.method canAddError()Z
    .locals 2

    .prologue
    .line 20
    invoke-virtual {p0}, Lorg/jsoup/parser/ParseErrorList;->size()I

    move-result v0

    iget v1, p0, Lorg/jsoup/parser/ParseErrorList;->maxSize:I

    if-ge v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
