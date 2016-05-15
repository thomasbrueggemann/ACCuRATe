.class public abstract Lorg/parceler/converter/LinkedListParcelConverter;
.super Lorg/parceler/converter/CollectionParcelConverter;
.source "LinkedListParcelConverter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lorg/parceler/converter/CollectionParcelConverter",
        "<TT;",
        "Ljava/util/LinkedList",
        "<TT;>;>;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    .local p0, "this":Lorg/parceler/converter/LinkedListParcelConverter;, "Lorg/parceler/converter/LinkedListParcelConverter<TT;>;"
    invoke-direct {p0}, Lorg/parceler/converter/CollectionParcelConverter;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic createCollection()Ljava/util/Collection;
    .locals 1

    .prologue
    .line 23
    .local p0, "this":Lorg/parceler/converter/LinkedListParcelConverter;, "Lorg/parceler/converter/LinkedListParcelConverter<TT;>;"
    invoke-virtual {p0}, Lorg/parceler/converter/LinkedListParcelConverter;->createCollection()Ljava/util/LinkedList;

    move-result-object v0

    return-object v0
.end method

.method public createCollection()Ljava/util/LinkedList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/LinkedList",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 26
    .local p0, "this":Lorg/parceler/converter/LinkedListParcelConverter;, "Lorg/parceler/converter/LinkedListParcelConverter<TT;>;"
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    return-object v0
.end method
