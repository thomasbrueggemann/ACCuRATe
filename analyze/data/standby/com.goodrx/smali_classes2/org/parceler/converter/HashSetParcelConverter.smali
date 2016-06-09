.class public abstract Lorg/parceler/converter/HashSetParcelConverter;
.super Lorg/parceler/converter/CollectionParcelConverter;
.source "HashSetParcelConverter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lorg/parceler/converter/CollectionParcelConverter",
        "<TT;",
        "Ljava/util/HashSet",
        "<TT;>;>;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    .local p0, "this":Lorg/parceler/converter/HashSetParcelConverter;, "Lorg/parceler/converter/HashSetParcelConverter<TT;>;"
    invoke-direct {p0}, Lorg/parceler/converter/CollectionParcelConverter;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic createCollection()Ljava/util/Collection;
    .locals 1

    .prologue
    .line 23
    .local p0, "this":Lorg/parceler/converter/HashSetParcelConverter;, "Lorg/parceler/converter/HashSetParcelConverter<TT;>;"
    invoke-virtual {p0}, Lorg/parceler/converter/HashSetParcelConverter;->createCollection()Ljava/util/HashSet;

    move-result-object v0

    return-object v0
.end method

.method public createCollection()Ljava/util/HashSet;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashSet",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 26
    .local p0, "this":Lorg/parceler/converter/HashSetParcelConverter;, "Lorg/parceler/converter/HashSetParcelConverter<TT;>;"
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    return-object v0
.end method
