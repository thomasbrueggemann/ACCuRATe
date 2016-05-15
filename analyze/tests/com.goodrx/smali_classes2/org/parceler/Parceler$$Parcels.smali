.class public Lorg/parceler/Parceler$$Parcels;
.super Ljava/lang/Object;
.source "Parceler$$Parcels.java"

# interfaces
.implements Lorg/parceler/Repository;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/parceler/Parceler$$Parcels$SavingsTip$$Parcelable$$0;,
        Lorg/parceler/Parceler$$Parcels$PharmacyLocationObject$$Parcelable$$0;,
        Lorg/parceler/Parceler$$Parcels$Notice$$Parcelable$$0;,
        Lorg/parceler/Parceler$$Parcels$ImageResult$$Parcelable$$0;,
        Lorg/parceler/Parceler$$Parcels$DrugObject$$Parcelable$$0;,
        Lorg/parceler/Parceler$$Parcels$DrugInformation$$Parcelable$$0;,
        Lorg/parceler/Parceler$$Parcels$DataQ$$Parcelable$$0;,
        Lorg/parceler/Parceler$$Parcels$CouponInfo$$Parcelable$$0;,
        Lorg/parceler/Parceler$$Parcels$Condition$$Parcelable$$0;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lorg/parceler/Repository",
        "<",
        "Lorg/parceler/Parcels$ParcelableFactory;",
        ">;"
    }
.end annotation


# instance fields
.field private final map$$0:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Class;",
            "Lorg/parceler/Parcels$ParcelableFactory;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lorg/parceler/Parceler$$Parcels;->map$$0:Ljava/util/Map;

    .line 37
    iget-object v0, p0, Lorg/parceler/Parceler$$Parcels;->map$$0:Ljava/util/Map;

    const-class v1, Lcom/goodrx/model/Notice;

    new-instance v2, Lorg/parceler/Parceler$$Parcels$Notice$$Parcelable$$0;

    invoke-direct {v2, v3}, Lorg/parceler/Parceler$$Parcels$Notice$$Parcelable$$0;-><init>(Lorg/parceler/Parceler$$Parcels$1;)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 38
    iget-object v0, p0, Lorg/parceler/Parceler$$Parcels;->map$$0:Ljava/util/Map;

    const-class v1, Lcom/goodrx/model/Condition;

    new-instance v2, Lorg/parceler/Parceler$$Parcels$Condition$$Parcelable$$0;

    invoke-direct {v2, v3}, Lorg/parceler/Parceler$$Parcels$Condition$$Parcelable$$0;-><init>(Lorg/parceler/Parceler$$Parcels$1;)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 39
    iget-object v0, p0, Lorg/parceler/Parceler$$Parcels;->map$$0:Ljava/util/Map;

    const-class v1, Lcom/goodrx/model/PharmacyLocationObject;

    new-instance v2, Lorg/parceler/Parceler$$Parcels$PharmacyLocationObject$$Parcelable$$0;

    invoke-direct {v2, v3}, Lorg/parceler/Parceler$$Parcels$PharmacyLocationObject$$Parcelable$$0;-><init>(Lorg/parceler/Parceler$$Parcels$1;)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 40
    iget-object v0, p0, Lorg/parceler/Parceler$$Parcels;->map$$0:Ljava/util/Map;

    const-class v1, Lcom/goodrx/model/SavingsTip;

    new-instance v2, Lorg/parceler/Parceler$$Parcels$SavingsTip$$Parcelable$$0;

    invoke-direct {v2, v3}, Lorg/parceler/Parceler$$Parcels$SavingsTip$$Parcelable$$0;-><init>(Lorg/parceler/Parceler$$Parcels$1;)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 41
    iget-object v0, p0, Lorg/parceler/Parceler$$Parcels;->map$$0:Ljava/util/Map;

    const-class v1, Lcom/goodrx/model/DrugInformation;

    new-instance v2, Lorg/parceler/Parceler$$Parcels$DrugInformation$$Parcelable$$0;

    invoke-direct {v2, v3}, Lorg/parceler/Parceler$$Parcels$DrugInformation$$Parcelable$$0;-><init>(Lorg/parceler/Parceler$$Parcels$1;)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 42
    iget-object v0, p0, Lorg/parceler/Parceler$$Parcels;->map$$0:Ljava/util/Map;

    const-class v1, Lcom/goodrx/model/CouponInfo;

    new-instance v2, Lorg/parceler/Parceler$$Parcels$CouponInfo$$Parcelable$$0;

    invoke-direct {v2, v3}, Lorg/parceler/Parceler$$Parcels$CouponInfo$$Parcelable$$0;-><init>(Lorg/parceler/Parceler$$Parcels$1;)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 43
    iget-object v0, p0, Lorg/parceler/Parceler$$Parcels;->map$$0:Ljava/util/Map;

    const-class v1, Lcom/goodrx/model/DrugObject;

    new-instance v2, Lorg/parceler/Parceler$$Parcels$DrugObject$$Parcelable$$0;

    invoke-direct {v2, v3}, Lorg/parceler/Parceler$$Parcels$DrugObject$$Parcelable$$0;-><init>(Lorg/parceler/Parceler$$Parcels$1;)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 44
    iget-object v0, p0, Lorg/parceler/Parceler$$Parcels;->map$$0:Ljava/util/Map;

    const-class v1, Lcom/goodrx/model/ImageResult;

    new-instance v2, Lorg/parceler/Parceler$$Parcels$ImageResult$$Parcelable$$0;

    invoke-direct {v2, v3}, Lorg/parceler/Parceler$$Parcels$ImageResult$$Parcelable$$0;-><init>(Lorg/parceler/Parceler$$Parcels$1;)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 45
    iget-object v0, p0, Lorg/parceler/Parceler$$Parcels;->map$$0:Ljava/util/Map;

    const-class v1, Lcom/goodrx/model/DataQ;

    new-instance v2, Lorg/parceler/Parceler$$Parcels$DataQ$$Parcelable$$0;

    invoke-direct {v2, v3}, Lorg/parceler/Parceler$$Parcels$DataQ$$Parcelable$$0;-><init>(Lorg/parceler/Parceler$$Parcels$1;)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 46
    return-void
.end method


# virtual methods
.method public get()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Class;",
            "Lorg/parceler/Parcels$ParcelableFactory;",
            ">;"
        }
    .end annotation

    .prologue
    .line 49
    iget-object v0, p0, Lorg/parceler/Parceler$$Parcels;->map$$0:Ljava/util/Map;

    return-object v0
.end method
