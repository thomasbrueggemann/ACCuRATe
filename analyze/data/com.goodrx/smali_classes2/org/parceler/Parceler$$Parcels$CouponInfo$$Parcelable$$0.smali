.class final Lorg/parceler/Parceler$$Parcels$CouponInfo$$Parcelable$$0;
.super Ljava/lang/Object;
.source "Parceler$$Parcels.java"

# interfaces
.implements Lorg/parceler/Parcels$ParcelableFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/parceler/Parceler$$Parcels;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "CouponInfo$$Parcelable$$0"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lorg/parceler/Parcels$ParcelableFactory",
        "<",
        "Lcom/goodrx/model/CouponInfo;",
        ">;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 64
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lorg/parceler/Parceler$$Parcels$1;)V
    .locals 0
    .param p1, "x0"    # Lorg/parceler/Parceler$$Parcels$1;

    .prologue
    .line 64
    invoke-direct {p0}, Lorg/parceler/Parceler$$Parcels$CouponInfo$$Parcelable$$0;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic buildParcelable(Ljava/lang/Object;)Landroid/os/Parcelable;
    .locals 1

    .prologue
    .line 64
    check-cast p1, Lcom/goodrx/model/CouponInfo;

    invoke-virtual {p0, p1}, Lorg/parceler/Parceler$$Parcels$CouponInfo$$Parcelable$$0;->buildParcelable(Lcom/goodrx/model/CouponInfo;)Lcom/goodrx/model/CouponInfo$$Parcelable;

    move-result-object v0

    return-object v0
.end method

.method public buildParcelable(Lcom/goodrx/model/CouponInfo;)Lcom/goodrx/model/CouponInfo$$Parcelable;
    .locals 1
    .param p1, "input"    # Lcom/goodrx/model/CouponInfo;

    .prologue
    .line 71
    new-instance v0, Lcom/goodrx/model/CouponInfo$$Parcelable;

    invoke-direct {v0, p1}, Lcom/goodrx/model/CouponInfo$$Parcelable;-><init>(Lcom/goodrx/model/CouponInfo;)V

    return-object v0
.end method