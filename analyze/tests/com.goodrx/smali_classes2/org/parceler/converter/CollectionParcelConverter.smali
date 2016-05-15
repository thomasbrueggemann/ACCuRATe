.class public abstract Lorg/parceler/converter/CollectionParcelConverter;
.super Ljava/lang/Object;
.source "CollectionParcelConverter.java"

# interfaces
.implements Lorg/parceler/TypeRangeParcelConverter;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        "C::",
        "Ljava/util/Collection",
        "<TT;>;>",
        "Ljava/lang/Object;",
        "Lorg/parceler/TypeRangeParcelConverter",
        "<",
        "Ljava/util/Collection",
        "<TT;>;TC;>;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 27
    .local p0, "this":Lorg/parceler/converter/CollectionParcelConverter;, "Lorg/parceler/converter/CollectionParcelConverter<TT;TC;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public abstract createCollection()Ljava/util/Collection;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TC;"
        }
    .end annotation
.end method

.method public bridge synthetic fromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 27
    .local p0, "this":Lorg/parceler/converter/CollectionParcelConverter;, "Lorg/parceler/converter/CollectionParcelConverter<TT;TC;>;"
    invoke-virtual {p0, p1}, Lorg/parceler/converter/CollectionParcelConverter;->fromParcel(Landroid/os/Parcel;)Ljava/util/Collection;

    move-result-object v0

    return-object v0
.end method

.method public fromParcel(Landroid/os/Parcel;)Ljava/util/Collection;
    .locals 4
    .param p1, "parcel"    # Landroid/os/Parcel;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Parcel;",
            ")TC;"
        }
    .end annotation

    .prologue
    .line 46
    .local p0, "this":Lorg/parceler/converter/CollectionParcelConverter;, "Lorg/parceler/converter/CollectionParcelConverter<TT;TC;>;"
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    .line 47
    .local v2, "size":I
    const/4 v3, -0x1

    if-ne v2, v3, :cond_1

    .line 48
    const/4 v1, 0x0

    .line 55
    .local v1, "list":Ljava/util/Collection;, "TC;"
    :cond_0
    return-object v1

    .line 50
    .end local v1    # "list":Ljava/util/Collection;, "TC;"
    :cond_1
    invoke-virtual {p0}, Lorg/parceler/converter/CollectionParcelConverter;->createCollection()Ljava/util/Collection;

    move-result-object v1

    .line 51
    .restart local v1    # "list":Ljava/util/Collection;, "TC;"
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v2, :cond_0

    .line 52
    invoke-virtual {p0, p1}, Lorg/parceler/converter/CollectionParcelConverter;->itemFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    .line 51
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method public abstract itemFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Parcel;",
            ")TT;"
        }
    .end annotation
.end method

.method public abstract itemToParcel(Ljava/lang/Object;Landroid/os/Parcel;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;",
            "Landroid/os/Parcel;",
            ")V"
        }
    .end annotation
.end method

.method public bridge synthetic toParcel(Ljava/lang/Object;Landroid/os/Parcel;)V
    .locals 0

    .prologue
    .line 27
    .local p0, "this":Lorg/parceler/converter/CollectionParcelConverter;, "Lorg/parceler/converter/CollectionParcelConverter<TT;TC;>;"
    check-cast p1, Ljava/util/Collection;

    invoke-virtual {p0, p1, p2}, Lorg/parceler/converter/CollectionParcelConverter;->toParcel(Ljava/util/Collection;Landroid/os/Parcel;)V

    return-void
.end method

.method public toParcel(Ljava/util/Collection;Landroid/os/Parcel;)V
    .locals 3
    .param p2, "parcel"    # Landroid/os/Parcel;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<TT;>;",
            "Landroid/os/Parcel;",
            ")V"
        }
    .end annotation

    .prologue
    .line 33
    .local p0, "this":Lorg/parceler/converter/CollectionParcelConverter;, "Lorg/parceler/converter/CollectionParcelConverter<TT;TC;>;"
    .local p1, "input":Ljava/util/Collection;, "Ljava/util/Collection<TT;>;"
    if-nez p1, :cond_1

    .line 34
    const/4 v1, -0x1

    invoke-virtual {p2, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 41
    :cond_0
    return-void

    .line 36
    :cond_1
    invoke-interface {p1}, Ljava/util/Collection;->size()I

    move-result v1

    invoke-virtual {p2, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 37
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    .line 38
    .local v0, "item":Ljava/lang/Object;, "TT;"
    invoke-virtual {p0, v0, p2}, Lorg/parceler/converter/CollectionParcelConverter;->itemToParcel(Ljava/lang/Object;Landroid/os/Parcel;)V

    goto :goto_0
.end method
