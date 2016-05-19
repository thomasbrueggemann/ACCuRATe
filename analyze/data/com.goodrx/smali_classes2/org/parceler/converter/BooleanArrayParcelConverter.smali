.class public Lorg/parceler/converter/BooleanArrayParcelConverter;
.super Ljava/lang/Object;
.source "BooleanArrayParcelConverter.java"

# interfaces
.implements Lorg/parceler/ParcelConverter;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lorg/parceler/ParcelConverter",
        "<[Z>;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic fromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 25
    invoke-virtual {p0, p1}, Lorg/parceler/converter/BooleanArrayParcelConverter;->fromParcel(Landroid/os/Parcel;)[Z

    move-result-object v0

    return-object v0
.end method

.method public fromParcel(Landroid/os/Parcel;)[Z
    .locals 3
    .param p1, "parcel"    # Landroid/os/Parcel;

    .prologue
    .line 42
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    .line 43
    .local v1, "size":I
    const/4 v2, -0x1

    if-ne v1, v2, :cond_0

    .line 44
    const/4 v0, 0x0

    .line 49
    .local v0, "array":[Z
    :goto_0
    return-object v0

    .line 46
    .end local v0    # "array":[Z
    :cond_0
    new-array v0, v1, [Z

    .line 47
    .restart local v0    # "array":[Z
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->readBooleanArray([Z)V

    goto :goto_0
.end method

.method public bridge synthetic toParcel(Ljava/lang/Object;Landroid/os/Parcel;)V
    .locals 0

    .prologue
    .line 25
    check-cast p1, [Z

    invoke-virtual {p0, p1, p2}, Lorg/parceler/converter/BooleanArrayParcelConverter;->toParcel([ZLandroid/os/Parcel;)V

    return-void
.end method

.method public toParcel([ZLandroid/os/Parcel;)V
    .locals 1
    .param p1, "array"    # [Z
    .param p2, "parcel"    # Landroid/os/Parcel;

    .prologue
    .line 31
    if-nez p1, :cond_0

    .line 32
    const/4 v0, -0x1

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 37
    :goto_0
    return-void

    .line 34
    :cond_0
    array-length v0, p1

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 35
    invoke-virtual {p2, p1}, Landroid/os/Parcel;->writeBooleanArray([Z)V

    goto :goto_0
.end method
