.class Lorg/parceler/NonParcelRepository$LinkedHashMapParcelableFactory;
.super Ljava/lang/Object;
.source "NonParcelRepository.java"

# interfaces
.implements Lorg/parceler/Parcels$ParcelableFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/parceler/NonParcelRepository;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "LinkedHashMapParcelableFactory"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lorg/parceler/Parcels$ParcelableFactory",
        "<",
        "Ljava/util/LinkedHashMap;",
        ">;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 156
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lorg/parceler/NonParcelRepository$1;)V
    .locals 0
    .param p1, "x0"    # Lorg/parceler/NonParcelRepository$1;

    .prologue
    .line 156
    invoke-direct {p0}, Lorg/parceler/NonParcelRepository$LinkedHashMapParcelableFactory;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic buildParcelable(Ljava/lang/Object;)Landroid/os/Parcelable;
    .locals 1

    .prologue
    .line 156
    check-cast p1, Ljava/util/LinkedHashMap;

    invoke-virtual {p0, p1}, Lorg/parceler/NonParcelRepository$LinkedHashMapParcelableFactory;->buildParcelable(Ljava/util/LinkedHashMap;)Landroid/os/Parcelable;

    move-result-object v0

    return-object v0
.end method

.method public buildParcelable(Ljava/util/LinkedHashMap;)Landroid/os/Parcelable;
    .locals 1
    .param p1, "input"    # Ljava/util/LinkedHashMap;

    .prologue
    .line 160
    new-instance v0, Lorg/parceler/NonParcelRepository$LinkedHashMapParcelable;

    invoke-direct {v0, p1}, Lorg/parceler/NonParcelRepository$LinkedHashMapParcelable;-><init>(Ljava/util/LinkedHashMap;)V

    return-object v0
.end method
