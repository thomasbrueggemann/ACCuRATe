.class public abstract Lorg/parceler/converter/LinkedHashSetParcelConverter;
.super Lorg/parceler/converter/CollectionParcelConverter;
.source "LinkedHashSetParcelConverter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lorg/parceler/converter/CollectionParcelConverter",
        "<TT;",
        "Ljava/util/LinkedHashSet",
        "<TT;>;>;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    .local p0, "this":Lorg/parceler/converter/LinkedHashSetParcelConverter;, "Lorg/parceler/converter/LinkedHashSetParcelConverter<TT;>;"
    invoke-direct {p0}, Lorg/parceler/converter/CollectionParcelConverter;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic createCollection()Ljava/util/Collection;
    .locals 1

    .prologue
    .line 23
    .local p0, "this":Lorg/parceler/converter/LinkedHashSetParcelConverter;, "Lorg/parceler/converter/LinkedHashSetParcelConverter<TT;>;"
    invoke-virtual {p0}, Lorg/parceler/converter/LinkedHashSetParcelConverter;->createCollection()Ljava/util/LinkedHashSet;

    move-result-object v0

    return-object v0
.end method

.method public createCollection()Ljava/util/LinkedHashSet;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/LinkedHashSet",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 26
    .local p0, "this":Lorg/parceler/converter/LinkedHashSetParcelConverter;, "Lorg/parceler/converter/LinkedHashSetParcelConverter<TT;>;"
    new-instance v0, Ljava/util/LinkedHashSet;

    invoke-direct {v0}, Ljava/util/LinkedHashSet;-><init>()V

    return-object v0
.end method
