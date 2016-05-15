.class public final Lorg/parceler/NonParcelRepository$CharArrayParcelable;
.super Lorg/parceler/NonParcelRepository$ConverterParcelable;
.source "NonParcelRepository.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/parceler/NonParcelRepository;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "CharArrayParcelable"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/parceler/NonParcelRepository$CharArrayParcelable$CharArrayParcelableCreator;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/parceler/NonParcelRepository$ConverterParcelable",
        "<[C>;"
    }
.end annotation


# static fields
.field private static final CONVERTER:Lorg/parceler/converter/CharArrayParcelConverter;

.field public static final CREATOR:Lorg/parceler/NonParcelRepository$CharArrayParcelable$CharArrayParcelableCreator;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 1093
    new-instance v0, Lorg/parceler/converter/CharArrayParcelConverter;

    invoke-direct {v0}, Lorg/parceler/converter/CharArrayParcelConverter;-><init>()V

    sput-object v0, Lorg/parceler/NonParcelRepository$CharArrayParcelable;->CONVERTER:Lorg/parceler/converter/CharArrayParcelConverter;

    .line 1104
    new-instance v0, Lorg/parceler/NonParcelRepository$CharArrayParcelable$CharArrayParcelableCreator;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lorg/parceler/NonParcelRepository$CharArrayParcelable$CharArrayParcelableCreator;-><init>(Lorg/parceler/NonParcelRepository$1;)V

    sput-object v0, Lorg/parceler/NonParcelRepository$CharArrayParcelable;->CREATOR:Lorg/parceler/NonParcelRepository$CharArrayParcelable$CharArrayParcelableCreator;

    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 2
    .param p1, "parcel"    # Landroid/os/Parcel;

    .prologue
    .line 1096
    sget-object v0, Lorg/parceler/NonParcelRepository$CharArrayParcelable;->CONVERTER:Lorg/parceler/converter/CharArrayParcelConverter;

    const/4 v1, 0x0

    invoke-direct {p0, p1, v0, v1}, Lorg/parceler/NonParcelRepository$ConverterParcelable;-><init>(Landroid/os/Parcel;Lorg/parceler/TypeRangeParcelConverter;Lorg/parceler/NonParcelRepository$1;)V

    .line 1097
    return-void
.end method

.method public constructor <init>([C)V
    .locals 2
    .param p1, "value"    # [C

    .prologue
    .line 1100
    sget-object v0, Lorg/parceler/NonParcelRepository$CharArrayParcelable;->CONVERTER:Lorg/parceler/converter/CharArrayParcelConverter;

    const/4 v1, 0x0

    invoke-direct {p0, p1, v0, v1}, Lorg/parceler/NonParcelRepository$ConverterParcelable;-><init>(Ljava/lang/Object;Lorg/parceler/TypeRangeParcelConverter;Lorg/parceler/NonParcelRepository$1;)V

    .line 1101
    return-void
.end method


# virtual methods
.method public bridge synthetic describeContents()I
    .locals 1

    .prologue
    .line 1091
    invoke-super {p0}, Lorg/parceler/NonParcelRepository$ConverterParcelable;->describeContents()I

    move-result v0

    return v0
.end method

.method public bridge synthetic writeToParcel(Landroid/os/Parcel;I)V
    .locals 0

    .prologue
    .line 1091
    invoke-super {p0, p1, p2}, Lorg/parceler/NonParcelRepository$ConverterParcelable;->writeToParcel(Landroid/os/Parcel;I)V

    return-void
.end method
