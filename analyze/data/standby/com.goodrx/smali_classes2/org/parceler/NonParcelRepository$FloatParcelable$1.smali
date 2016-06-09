.class final Lorg/parceler/NonParcelRepository$FloatParcelable$1;
.super Lorg/parceler/converter/NullableParcelConverter;
.source "NonParcelRepository.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/parceler/NonParcelRepository$FloatParcelable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/parceler/converter/NullableParcelConverter",
        "<",
        "Ljava/lang/Float;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 864
    invoke-direct {p0}, Lorg/parceler/converter/NullableParcelConverter;-><init>()V

    return-void
.end method


# virtual methods
.method public nullSafeFromParcel(Landroid/os/Parcel;)Ljava/lang/Float;
    .locals 1
    .param p1, "parcel"    # Landroid/os/Parcel;

    .prologue
    .line 868
    invoke-virtual {p1}, Landroid/os/Parcel;->readFloat()F

    move-result v0

    invoke-static {v0}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic nullSafeFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 864
    invoke-virtual {p0, p1}, Lorg/parceler/NonParcelRepository$FloatParcelable$1;->nullSafeFromParcel(Landroid/os/Parcel;)Ljava/lang/Float;

    move-result-object v0

    return-object v0
.end method

.method public nullSafeToParcel(Ljava/lang/Float;Landroid/os/Parcel;)V
    .locals 1
    .param p1, "input"    # Ljava/lang/Float;
    .param p2, "parcel"    # Landroid/os/Parcel;

    .prologue
    .line 873
    invoke-virtual {p1}, Ljava/lang/Float;->floatValue()F

    move-result v0

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->writeFloat(F)V

    .line 874
    return-void
.end method

.method public bridge synthetic nullSafeToParcel(Ljava/lang/Object;Landroid/os/Parcel;)V
    .locals 0

    .prologue
    .line 864
    check-cast p1, Ljava/lang/Float;

    invoke-virtual {p0, p1, p2}, Lorg/parceler/NonParcelRepository$FloatParcelable$1;->nullSafeToParcel(Ljava/lang/Float;Landroid/os/Parcel;)V

    return-void
.end method
