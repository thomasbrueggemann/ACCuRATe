.class final Lorg/parceler/Parcels$NullParcelable$NullParcelableCreator;
.super Ljava/lang/Object;
.source "Parcels.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/parceler/Parcels$NullParcelable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "NullParcelableCreator"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable$Creator",
        "<",
        "Lorg/parceler/Parcels$NullParcelable;",
        ">;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 129
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lorg/parceler/Parcels$1;)V
    .locals 0
    .param p1, "x0"    # Lorg/parceler/Parcels$1;

    .prologue
    .line 129
    invoke-direct {p0}, Lorg/parceler/Parcels$NullParcelable$NullParcelableCreator;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 129
    invoke-virtual {p0, p1}, Lorg/parceler/Parcels$NullParcelable$NullParcelableCreator;->createFromParcel(Landroid/os/Parcel;)Lorg/parceler/Parcels$NullParcelable;

    move-result-object v0

    return-object v0
.end method

.method public createFromParcel(Landroid/os/Parcel;)Lorg/parceler/Parcels$NullParcelable;
    .locals 2
    .param p1, "parcel"    # Landroid/os/Parcel;

    .prologue
    .line 133
    new-instance v0, Lorg/parceler/Parcels$NullParcelable;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Lorg/parceler/Parcels$NullParcelable;-><init>(Landroid/os/Parcel;Lorg/parceler/Parcels$1;)V

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1

    .prologue
    .line 129
    invoke-virtual {p0, p1}, Lorg/parceler/Parcels$NullParcelable$NullParcelableCreator;->newArray(I)[Lorg/parceler/Parcels$NullParcelable;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lorg/parceler/Parcels$NullParcelable;
    .locals 1
    .param p1, "size"    # I

    .prologue
    .line 138
    new-array v0, p1, [Lorg/parceler/Parcels$NullParcelable;

    return-object v0
.end method
