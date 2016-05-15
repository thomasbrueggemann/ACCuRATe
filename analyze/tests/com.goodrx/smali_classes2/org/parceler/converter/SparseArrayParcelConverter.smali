.class public abstract Lorg/parceler/converter/SparseArrayParcelConverter;
.super Ljava/lang/Object;
.source "SparseArrayParcelConverter.java"

# interfaces
.implements Lorg/parceler/ParcelConverter;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lorg/parceler/ParcelConverter",
        "<",
        "Landroid/util/SparseArray",
        "<TT;>;>;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    .local p0, "this":Lorg/parceler/converter/SparseArrayParcelConverter;, "Lorg/parceler/converter/SparseArrayParcelConverter<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public fromParcel(Landroid/os/Parcel;)Landroid/util/SparseArray;
    .locals 5
    .param p1, "parcel"    # Landroid/os/Parcel;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Parcel;",
            ")",
            "Landroid/util/SparseArray",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 42
    .local p0, "this":Lorg/parceler/converter/SparseArrayParcelConverter;, "Lorg/parceler/converter/SparseArrayParcelConverter<TT;>;"
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v3

    .line 43
    .local v3, "size":I
    if-gez v3, :cond_1

    .line 44
    const/4 v0, 0x0

    .line 52
    .local v0, "array":Landroid/util/SparseArray;, "Landroid/util/SparseArray<TT;>;"
    :cond_0
    return-object v0

    .line 46
    .end local v0    # "array":Landroid/util/SparseArray;, "Landroid/util/SparseArray<TT;>;"
    :cond_1
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0, v3}, Landroid/util/SparseArray;-><init>(I)V

    .line 47
    .restart local v0    # "array":Landroid/util/SparseArray;, "Landroid/util/SparseArray<TT;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v3, :cond_0

    .line 48
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    .line 49
    .local v2, "key":I
    invoke-virtual {p0, p1}, Lorg/parceler/converter/SparseArrayParcelConverter;->itemFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v0, v2, v4}, Landroid/util/SparseArray;->append(ILjava/lang/Object;)V

    .line 47
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method public bridge synthetic fromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 25
    .local p0, "this":Lorg/parceler/converter/SparseArrayParcelConverter;, "Lorg/parceler/converter/SparseArrayParcelConverter<TT;>;"
    invoke-virtual {p0, p1}, Lorg/parceler/converter/SparseArrayParcelConverter;->fromParcel(Landroid/os/Parcel;)Landroid/util/SparseArray;

    move-result-object v0

    return-object v0
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

.method public toParcel(Landroid/util/SparseArray;Landroid/os/Parcel;)V
    .locals 2
    .param p2, "parcel"    # Landroid/os/Parcel;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/util/SparseArray",
            "<TT;>;",
            "Landroid/os/Parcel;",
            ")V"
        }
    .end annotation

    .prologue
    .line 28
    .local p0, "this":Lorg/parceler/converter/SparseArrayParcelConverter;, "Lorg/parceler/converter/SparseArrayParcelConverter<TT;>;"
    .local p1, "input":Landroid/util/SparseArray;, "Landroid/util/SparseArray<TT;>;"
    if-nez p1, :cond_1

    .line 29
    const/4 v1, -0x1

    invoke-virtual {p2, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 37
    :cond_0
    return-void

    .line 31
    :cond_1
    invoke-virtual {p1}, Landroid/util/SparseArray;->size()I

    move-result v1

    invoke-virtual {p2, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 32
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {p1}, Landroid/util/SparseArray;->size()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 33
    invoke-virtual {p1, v0}, Landroid/util/SparseArray;->keyAt(I)I

    move-result v1

    invoke-virtual {p2, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 34
    invoke-virtual {p1, v0}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {p0, v1, p2}, Lorg/parceler/converter/SparseArrayParcelConverter;->itemToParcel(Ljava/lang/Object;Landroid/os/Parcel;)V

    .line 32
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method public bridge synthetic toParcel(Ljava/lang/Object;Landroid/os/Parcel;)V
    .locals 0

    .prologue
    .line 25
    .local p0, "this":Lorg/parceler/converter/SparseArrayParcelConverter;, "Lorg/parceler/converter/SparseArrayParcelConverter<TT;>;"
    check-cast p1, Landroid/util/SparseArray;

    invoke-virtual {p0, p1, p2}, Lorg/parceler/converter/SparseArrayParcelConverter;->toParcel(Landroid/util/SparseArray;Landroid/os/Parcel;)V

    return-void
.end method
