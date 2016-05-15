.class final Lorg/parceler/Parcels$ParcelableFactoryReflectionProxy;
.super Ljava/lang/Object;
.source "Parcels.java"

# interfaces
.implements Lorg/parceler/Parcels$ParcelableFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/parceler/Parcels;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "ParcelableFactoryReflectionProxy"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lorg/parceler/Parcels$ParcelableFactory",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final constructor:Ljava/lang/reflect/Constructor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/reflect/Constructor",
            "<+",
            "Landroid/os/Parcelable;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/Class;Ljava/lang/Class;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<TT;>;",
            "Ljava/lang/Class",
            "<+",
            "Landroid/os/Parcelable;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 163
    .local p0, "this":Lorg/parceler/Parcels$ParcelableFactoryReflectionProxy;, "Lorg/parceler/Parcels$ParcelableFactoryReflectionProxy<TT;>;"
    .local p1, "parcelClass":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    .local p2, "parcelWrapperClass":Ljava/lang/Class;, "Ljava/lang/Class<+Landroid/os/Parcelable;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 165
    const/4 v1, 0x1

    :try_start_0
    new-array v1, v1, [Ljava/lang/Class;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    invoke-virtual {p2, v1}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v1

    iput-object v1, p0, Lorg/parceler/Parcels$ParcelableFactoryReflectionProxy;->constructor:Ljava/lang/reflect/Constructor;
    :try_end_0
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_0

    .line 169
    return-void

    .line 166
    :catch_0
    move-exception v0

    .line 167
    .local v0, "e":Ljava/lang/NoSuchMethodException;
    new-instance v1, Lorg/parceler/ParcelerRuntimeException;

    const-string v2, "Unable to create ParcelFactory Type"

    invoke-direct {v1, v2, v0}, Lorg/parceler/ParcelerRuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Exception;)V

    throw v1
.end method


# virtual methods
.method public buildParcelable(Ljava/lang/Object;)Landroid/os/Parcelable;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)",
            "Landroid/os/Parcelable;"
        }
    .end annotation

    .prologue
    .line 174
    .local p0, "this":Lorg/parceler/Parcels$ParcelableFactoryReflectionProxy;, "Lorg/parceler/Parcels$ParcelableFactoryReflectionProxy<TT;>;"
    .local p1, "input":Ljava/lang/Object;, "TT;"
    :try_start_0
    iget-object v1, p0, Lorg/parceler/Parcels$ParcelableFactoryReflectionProxy;->constructor:Ljava/lang/reflect/Constructor;

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-virtual {v1, v2}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/os/Parcelable;
    :try_end_0
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_2

    return-object v1

    .line 175
    :catch_0
    move-exception v0

    .line 176
    .local v0, "e":Ljava/lang/InstantiationException;
    new-instance v1, Lorg/parceler/ParcelerRuntimeException;

    const-string v2, "Unable to create ParcelFactory Type"

    invoke-direct {v1, v2, v0}, Lorg/parceler/ParcelerRuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Exception;)V

    throw v1

    .line 177
    .end local v0    # "e":Ljava/lang/InstantiationException;
    :catch_1
    move-exception v0

    .line 178
    .local v0, "e":Ljava/lang/IllegalAccessException;
    new-instance v1, Lorg/parceler/ParcelerRuntimeException;

    const-string v2, "Unable to create ParcelFactory Type"

    invoke-direct {v1, v2, v0}, Lorg/parceler/ParcelerRuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Exception;)V

    throw v1

    .line 179
    .end local v0    # "e":Ljava/lang/IllegalAccessException;
    :catch_2
    move-exception v0

    .line 180
    .local v0, "e":Ljava/lang/reflect/InvocationTargetException;
    new-instance v1, Lorg/parceler/ParcelerRuntimeException;

    const-string v2, "Unable to create ParcelFactory Type"

    invoke-direct {v1, v2, v0}, Lorg/parceler/ParcelerRuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Exception;)V

    throw v1
.end method
