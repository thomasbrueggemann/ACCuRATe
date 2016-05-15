.class Lorg/parceler/NonParcelRepository$ConverterParcelable;
.super Ljava/lang/Object;
.source "NonParcelRepository.java"

# interfaces
.implements Landroid/os/Parcelable;
.implements Lorg/parceler/ParcelWrapper;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/parceler/NonParcelRepository;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ConverterParcelable"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable;",
        "Lorg/parceler/ParcelWrapper",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final converter:Lorg/parceler/TypeRangeParcelConverter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/parceler/TypeRangeParcelConverter",
            "<TT;TT;>;"
        }
    .end annotation
.end field

.field private final value:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>(Landroid/os/Parcel;Lorg/parceler/TypeRangeParcelConverter;)V
    .locals 1
    .param p1, "parcel"    # Landroid/os/Parcel;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Parcel;",
            "Lorg/parceler/TypeRangeParcelConverter",
            "<TT;TT;>;)V"
        }
    .end annotation

    .prologue
    .line 1212
    .local p0, "this":Lorg/parceler/NonParcelRepository$ConverterParcelable;, "Lorg/parceler/NonParcelRepository$ConverterParcelable<TT;>;"
    .local p2, "converter":Lorg/parceler/TypeRangeParcelConverter;, "Lorg/parceler/TypeRangeParcelConverter<TT;TT;>;"
    invoke-interface {p2, p1}, Lorg/parceler/TypeRangeParcelConverter;->fromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v0

    invoke-direct {p0, v0, p2}, Lorg/parceler/NonParcelRepository$ConverterParcelable;-><init>(Ljava/lang/Object;Lorg/parceler/TypeRangeParcelConverter;)V

    .line 1213
    return-void
.end method

.method synthetic constructor <init>(Landroid/os/Parcel;Lorg/parceler/TypeRangeParcelConverter;Lorg/parceler/NonParcelRepository$1;)V
    .locals 0
    .param p1, "x0"    # Landroid/os/Parcel;
    .param p2, "x1"    # Lorg/parceler/TypeRangeParcelConverter;
    .param p3, "x2"    # Lorg/parceler/NonParcelRepository$1;

    .prologue
    .line 1205
    .local p0, "this":Lorg/parceler/NonParcelRepository$ConverterParcelable;, "Lorg/parceler/NonParcelRepository$ConverterParcelable<TT;>;"
    invoke-direct {p0, p1, p2}, Lorg/parceler/NonParcelRepository$ConverterParcelable;-><init>(Landroid/os/Parcel;Lorg/parceler/TypeRangeParcelConverter;)V

    return-void
.end method

.method private constructor <init>(Ljava/lang/Object;Lorg/parceler/TypeRangeParcelConverter;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;",
            "Lorg/parceler/TypeRangeParcelConverter",
            "<TT;TT;>;)V"
        }
    .end annotation

    .prologue
    .line 1215
    .local p0, "this":Lorg/parceler/NonParcelRepository$ConverterParcelable;, "Lorg/parceler/NonParcelRepository$ConverterParcelable<TT;>;"
    .local p1, "value":Ljava/lang/Object;, "TT;"
    .local p2, "converter":Lorg/parceler/TypeRangeParcelConverter;, "Lorg/parceler/TypeRangeParcelConverter<TT;TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1216
    iput-object p2, p0, Lorg/parceler/NonParcelRepository$ConverterParcelable;->converter:Lorg/parceler/TypeRangeParcelConverter;

    .line 1217
    iput-object p1, p0, Lorg/parceler/NonParcelRepository$ConverterParcelable;->value:Ljava/lang/Object;

    .line 1218
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/Object;Lorg/parceler/TypeRangeParcelConverter;Lorg/parceler/NonParcelRepository$1;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lorg/parceler/TypeRangeParcelConverter;
    .param p3, "x2"    # Lorg/parceler/NonParcelRepository$1;

    .prologue
    .line 1205
    .local p0, "this":Lorg/parceler/NonParcelRepository$ConverterParcelable;, "Lorg/parceler/NonParcelRepository$ConverterParcelable<TT;>;"
    invoke-direct {p0, p1, p2}, Lorg/parceler/NonParcelRepository$ConverterParcelable;-><init>(Ljava/lang/Object;Lorg/parceler/TypeRangeParcelConverter;)V

    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 1227
    .local p0, "this":Lorg/parceler/NonParcelRepository$ConverterParcelable;, "Lorg/parceler/NonParcelRepository$ConverterParcelable<TT;>;"
    const/4 v0, 0x0

    return v0
.end method

.method public getParcel()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 1232
    .local p0, "this":Lorg/parceler/NonParcelRepository$ConverterParcelable;, "Lorg/parceler/NonParcelRepository$ConverterParcelable<TT;>;"
    iget-object v0, p0, Lorg/parceler/NonParcelRepository$ConverterParcelable;->value:Ljava/lang/Object;

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2
    .param p1, "parcel"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 1222
    .local p0, "this":Lorg/parceler/NonParcelRepository$ConverterParcelable;, "Lorg/parceler/NonParcelRepository$ConverterParcelable<TT;>;"
    iget-object v0, p0, Lorg/parceler/NonParcelRepository$ConverterParcelable;->converter:Lorg/parceler/TypeRangeParcelConverter;

    iget-object v1, p0, Lorg/parceler/NonParcelRepository$ConverterParcelable;->value:Ljava/lang/Object;

    invoke-interface {v0, v1, p1}, Lorg/parceler/TypeRangeParcelConverter;->toParcel(Ljava/lang/Object;Landroid/os/Parcel;)V

    .line 1223
    return-void
.end method
