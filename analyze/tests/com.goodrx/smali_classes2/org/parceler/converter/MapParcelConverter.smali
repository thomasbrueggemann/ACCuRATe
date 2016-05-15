.class public abstract Lorg/parceler/converter/MapParcelConverter;
.super Ljava/lang/Object;
.source "MapParcelConverter.java"

# interfaces
.implements Lorg/parceler/TypeRangeParcelConverter;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<K:",
        "Ljava/lang/Object;",
        "V:",
        "Ljava/lang/Object;",
        "M::",
        "Ljava/util/Map",
        "<TK;TV;>;>",
        "Ljava/lang/Object;",
        "Lorg/parceler/TypeRangeParcelConverter",
        "<",
        "Ljava/util/Map",
        "<TK;TV;>;TM;>;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 27
    .local p0, "this":Lorg/parceler/converter/MapParcelConverter;, "Lorg/parceler/converter/MapParcelConverter<TK;TV;TM;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public abstract createMap()Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TM;"
        }
    .end annotation
.end method

.method public bridge synthetic fromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 27
    .local p0, "this":Lorg/parceler/converter/MapParcelConverter;, "Lorg/parceler/converter/MapParcelConverter<TK;TV;TM;>;"
    invoke-virtual {p0, p1}, Lorg/parceler/converter/MapParcelConverter;->fromParcel(Landroid/os/Parcel;)Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public fromParcel(Landroid/os/Parcel;)Ljava/util/Map;
    .locals 6
    .param p1, "parcel"    # Landroid/os/Parcel;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Parcel;",
            ")TM;"
        }
    .end annotation

    .prologue
    .line 47
    .local p0, "this":Lorg/parceler/converter/MapParcelConverter;, "Lorg/parceler/converter/MapParcelConverter<TK;TV;TM;>;"
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v3

    .line 48
    .local v3, "size":I
    const/4 v5, -0x1

    if-ne v3, v5, :cond_1

    .line 49
    const/4 v2, 0x0

    .line 58
    .local v2, "map":Ljava/util/Map;, "TM;"
    :cond_0
    return-object v2

    .line 51
    .end local v2    # "map":Ljava/util/Map;, "TM;"
    :cond_1
    invoke-virtual {p0}, Lorg/parceler/converter/MapParcelConverter;->createMap()Ljava/util/Map;

    move-result-object v2

    .line 52
    .restart local v2    # "map":Ljava/util/Map;, "TM;"
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v3, :cond_0

    .line 53
    invoke-virtual {p0, p1}, Lorg/parceler/converter/MapParcelConverter;->mapKeyFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v1

    .line 54
    .local v1, "key":Ljava/lang/Object;, "TK;"
    invoke-virtual {p0, p1}, Lorg/parceler/converter/MapParcelConverter;->mapValueFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v4

    .line 55
    .local v4, "value":Ljava/lang/Object;, "TV;"
    invoke-interface {v2, v1, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 52
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method public abstract mapKeyFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Parcel;",
            ")TK;"
        }
    .end annotation
.end method

.method public abstract mapKeyToParcel(Ljava/lang/Object;Landroid/os/Parcel;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;",
            "Landroid/os/Parcel;",
            ")V"
        }
    .end annotation
.end method

.method public abstract mapValueFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Parcel;",
            ")TV;"
        }
    .end annotation
.end method

.method public abstract mapValueToParcel(Ljava/lang/Object;Landroid/os/Parcel;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TV;",
            "Landroid/os/Parcel;",
            ")V"
        }
    .end annotation
.end method

.method public bridge synthetic toParcel(Ljava/lang/Object;Landroid/os/Parcel;)V
    .locals 0

    .prologue
    .line 27
    .local p0, "this":Lorg/parceler/converter/MapParcelConverter;, "Lorg/parceler/converter/MapParcelConverter<TK;TV;TM;>;"
    check-cast p1, Ljava/util/Map;

    invoke-virtual {p0, p1, p2}, Lorg/parceler/converter/MapParcelConverter;->toParcel(Ljava/util/Map;Landroid/os/Parcel;)V

    return-void
.end method

.method public toParcel(Ljava/util/Map;Landroid/os/Parcel;)V
    .locals 3
    .param p2, "parcel"    # Landroid/os/Parcel;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<TK;TV;>;",
            "Landroid/os/Parcel;",
            ")V"
        }
    .end annotation

    .prologue
    .line 33
    .local p0, "this":Lorg/parceler/converter/MapParcelConverter;, "Lorg/parceler/converter/MapParcelConverter<TK;TV;TM;>;"
    .local p1, "input":Ljava/util/Map;, "Ljava/util/Map<TK;TV;>;"
    if-nez p1, :cond_1

    .line 34
    const/4 v1, -0x1

    invoke-virtual {p2, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 42
    :cond_0
    return-void

    .line 36
    :cond_1
    invoke-interface {p1}, Ljava/util/Map;->size()I

    move-result v1

    invoke-virtual {p2, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 37
    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 38
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<TK;TV;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {p0, v2, p2}, Lorg/parceler/converter/MapParcelConverter;->mapKeyToParcel(Ljava/lang/Object;Landroid/os/Parcel;)V

    .line 39
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {p0, v2, p2}, Lorg/parceler/converter/MapParcelConverter;->mapValueToParcel(Ljava/lang/Object;Landroid/os/Parcel;)V

    goto :goto_0
.end method
