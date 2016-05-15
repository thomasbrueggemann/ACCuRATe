.class final Lorg/parceler/NonParcelRepository$SparseBooleanArrayParcelable$1;
.super Lorg/parceler/converter/NullableParcelConverter;
.source "NonParcelRepository.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/parceler/NonParcelRepository$SparseBooleanArrayParcelable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/parceler/converter/NullableParcelConverter",
        "<",
        "Landroid/util/SparseBooleanArray;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 704
    invoke-direct {p0}, Lorg/parceler/converter/NullableParcelConverter;-><init>()V

    return-void
.end method


# virtual methods
.method public nullSafeFromParcel(Landroid/os/Parcel;)Landroid/util/SparseBooleanArray;
    .locals 1
    .param p1, "parcel"    # Landroid/os/Parcel;

    .prologue
    .line 708
    invoke-virtual {p1}, Landroid/os/Parcel;->readSparseBooleanArray()Landroid/util/SparseBooleanArray;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic nullSafeFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 704
    invoke-virtual {p0, p1}, Lorg/parceler/NonParcelRepository$SparseBooleanArrayParcelable$1;->nullSafeFromParcel(Landroid/os/Parcel;)Landroid/util/SparseBooleanArray;

    move-result-object v0

    return-object v0
.end method

.method public nullSafeToParcel(Landroid/util/SparseBooleanArray;Landroid/os/Parcel;)V
    .locals 0
    .param p1, "input"    # Landroid/util/SparseBooleanArray;
    .param p2, "parcel"    # Landroid/os/Parcel;

    .prologue
    .line 713
    invoke-virtual {p2, p1}, Landroid/os/Parcel;->writeSparseBooleanArray(Landroid/util/SparseBooleanArray;)V

    .line 714
    return-void
.end method

.method public bridge synthetic nullSafeToParcel(Ljava/lang/Object;Landroid/os/Parcel;)V
    .locals 0

    .prologue
    .line 704
    check-cast p1, Landroid/util/SparseBooleanArray;

    invoke-virtual {p0, p1, p2}, Lorg/parceler/NonParcelRepository$SparseBooleanArrayParcelable$1;->nullSafeToParcel(Landroid/util/SparseBooleanArray;Landroid/os/Parcel;)V

    return-void
.end method
