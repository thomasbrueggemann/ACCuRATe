.class final Lorg/parceler/NonParcelRepository$CharacterParcelable$1;
.super Lorg/parceler/converter/NullableParcelConverter;
.source "NonParcelRepository.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/parceler/NonParcelRepository$CharacterParcelable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/parceler/converter/NullableParcelConverter",
        "<",
        "Ljava/lang/Character;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 1122
    invoke-direct {p0}, Lorg/parceler/converter/NullableParcelConverter;-><init>()V

    return-void
.end method


# virtual methods
.method public nullSafeFromParcel(Landroid/os/Parcel;)Ljava/lang/Character;
    .locals 2
    .param p1, "parcel"    # Landroid/os/Parcel;

    .prologue
    .line 1126
    invoke-virtual {p1}, Landroid/os/Parcel;->createCharArray()[C

    move-result-object v0

    const/4 v1, 0x0

    aget-char v0, v0, v1

    invoke-static {v0}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic nullSafeFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1122
    invoke-virtual {p0, p1}, Lorg/parceler/NonParcelRepository$CharacterParcelable$1;->nullSafeFromParcel(Landroid/os/Parcel;)Ljava/lang/Character;

    move-result-object v0

    return-object v0
.end method

.method public nullSafeToParcel(Ljava/lang/Character;Landroid/os/Parcel;)V
    .locals 3
    .param p1, "input"    # Ljava/lang/Character;
    .param p2, "parcel"    # Landroid/os/Parcel;

    .prologue
    .line 1131
    const/4 v0, 0x1

    new-array v0, v0, [C

    const/4 v1, 0x0

    invoke-virtual {p1}, Ljava/lang/Character;->charValue()C

    move-result v2

    aput-char v2, v0, v1

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->writeCharArray([C)V

    .line 1132
    return-void
.end method

.method public bridge synthetic nullSafeToParcel(Ljava/lang/Object;Landroid/os/Parcel;)V
    .locals 0

    .prologue
    .line 1122
    check-cast p1, Ljava/lang/Character;

    invoke-virtual {p0, p1, p2}, Lorg/parceler/NonParcelRepository$CharacterParcelable$1;->nullSafeToParcel(Ljava/lang/Character;Landroid/os/Parcel;)V

    return-void
.end method
