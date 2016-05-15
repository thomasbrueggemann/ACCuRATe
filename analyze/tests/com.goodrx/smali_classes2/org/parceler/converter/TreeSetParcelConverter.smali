.class public abstract Lorg/parceler/converter/TreeSetParcelConverter;
.super Lorg/parceler/converter/CollectionParcelConverter;
.source "TreeSetParcelConverter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lorg/parceler/converter/CollectionParcelConverter",
        "<TT;",
        "Ljava/util/TreeSet",
        "<TT;>;>;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    .local p0, "this":Lorg/parceler/converter/TreeSetParcelConverter;, "Lorg/parceler/converter/TreeSetParcelConverter<TT;>;"
    invoke-direct {p0}, Lorg/parceler/converter/CollectionParcelConverter;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic createCollection()Ljava/util/Collection;
    .locals 1

    .prologue
    .line 23
    .local p0, "this":Lorg/parceler/converter/TreeSetParcelConverter;, "Lorg/parceler/converter/TreeSetParcelConverter<TT;>;"
    invoke-virtual {p0}, Lorg/parceler/converter/TreeSetParcelConverter;->createCollection()Ljava/util/TreeSet;

    move-result-object v0

    return-object v0
.end method

.method public createCollection()Ljava/util/TreeSet;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/TreeSet",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 26
    .local p0, "this":Lorg/parceler/converter/TreeSetParcelConverter;, "Lorg/parceler/converter/TreeSetParcelConverter<TT;>;"
    new-instance v0, Ljava/util/TreeSet;

    invoke-direct {v0}, Ljava/util/TreeSet;-><init>()V

    return-object v0
.end method
