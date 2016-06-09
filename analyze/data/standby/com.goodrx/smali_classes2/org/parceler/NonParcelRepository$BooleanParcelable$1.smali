.class final Lorg/parceler/NonParcelRepository$BooleanParcelable$1;
.super Lorg/parceler/converter/NullableParcelConverter;
.source "NonParcelRepository.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/parceler/NonParcelRepository$BooleanParcelable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/parceler/converter/NullableParcelConverter",
        "<",
        "Ljava/lang/Boolean;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 1053
    invoke-direct {p0}, Lorg/parceler/converter/NullableParcelConverter;-><init>()V

    return-void
.end method


# virtual methods
.method public nullSafeFromParcel(Landroid/os/Parcel;)Ljava/lang/Boolean;
    .locals 2
    .param p1, "parcel"    # Landroid/os/Parcel;

    .prologue
    .line 1057
    invoke-virtual {p1}, Landroid/os/Parcel;->createBooleanArray()[Z

    move-result-object v0

    const/4 v1, 0x0

    aget-boolean v0, v0, v1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic nullSafeFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1053
    invoke-virtual {p0, p1}, Lorg/parceler/NonParcelRepository$BooleanParcelable$1;->nullSafeFromParcel(Landroid/os/Parcel;)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method

.method public nullSafeToParcel(Ljava/lang/Boolean;Landroid/os/Parcel;)V
    .locals 3
    .param p1, "input"    # Ljava/lang/Boolean;
    .param p2, "parcel"    # Landroid/os/Parcel;

    .prologue
    .line 1062
    const/4 v0, 0x1

    new-array v0, v0, [Z

    const/4 v1, 0x0

    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    aput-boolean v2, v0, v1

    invoke-virtual {p2, v0}, Landroid/os/Parcel;->writeBooleanArray([Z)V

    .line 1063
    return-void
.end method

.method public bridge synthetic nullSafeToParcel(Ljava/lang/Object;Landroid/os/Parcel;)V
    .locals 0

    .prologue
    .line 1053
    check-cast p1, Ljava/lang/Boolean;

    invoke-virtual {p0, p1, p2}, Lorg/parceler/NonParcelRepository$BooleanParcelable$1;->nullSafeToParcel(Ljava/lang/Boolean;Landroid/os/Parcel;)V

    return-void
.end method
