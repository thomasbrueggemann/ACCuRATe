.class public abstract Lorg/parceler/converter/NullableParcelConverter;
.super Ljava/lang/Object;
.source "NullableParcelConverter.java"

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
        "<TT;>;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 26
    .local p0, "this":Lorg/parceler/converter/NullableParcelConverter;, "Lorg/parceler/converter/NullableParcelConverter<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public fromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 3
    .param p1, "parcel"    # Landroid/os/Parcel;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Parcel;",
            ")TT;"
        }
    .end annotation

    .prologue
    .line 44
    .local p0, "this":Lorg/parceler/converter/NullableParcelConverter;, "Lorg/parceler/converter/NullableParcelConverter<TT;>;"
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    const/4 v2, -0x1

    if-ne v1, v2, :cond_0

    .line 45
    const/4 v0, 0x0

    .line 49
    :goto_0
    return-object v0

    .line 47
    :cond_0
    invoke-virtual {p0, p1}, Lorg/parceler/converter/NullableParcelConverter;->nullSafeFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    .local v0, "result":Ljava/lang/Object;, "TT;"
    goto :goto_0
.end method

.method public abstract nullSafeFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Parcel;",
            ")TT;"
        }
    .end annotation
.end method

.method public abstract nullSafeToParcel(Ljava/lang/Object;Landroid/os/Parcel;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;",
            "Landroid/os/Parcel;",
            ")V"
        }
    .end annotation
.end method

.method public toParcel(Ljava/lang/Object;Landroid/os/Parcel;)V
    .locals 1
    .param p2, "parcel"    # Landroid/os/Parcel;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;",
            "Landroid/os/Parcel;",
            ")V"
        }
    .end annotation

    .prologue
    .line 33
    .local p0, "this":Lorg/parceler/converter/NullableParcelConverter;, "Lorg/parceler/converter/NullableParcelConverter<TT;>;"
    .local p1, "input":Ljava/lang/Object;, "TT;"
    if-nez p1, :cond_0

    .line 34
    const/4 v0, -0x1

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 39
    :goto_0
    return-void

    .line 36
    :cond_0
    const/4 v0, 0x1

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 37
    invoke-virtual {p0, p1, p2}, Lorg/parceler/converter/NullableParcelConverter;->nullSafeToParcel(Ljava/lang/Object;Landroid/os/Parcel;)V

    goto :goto_0
.end method
