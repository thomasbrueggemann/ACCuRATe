.class final Lorg/parceler/Parcels$ParcelCodeRepository;
.super Ljava/lang/Object;
.source "Parcels.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/parceler/Parcels;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "ParcelCodeRepository"
.end annotation


# instance fields
.field private generatedMap:Ljava/util/concurrent/ConcurrentMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentMap",
            "<",
            "Ljava/lang/Class;",
            "Lorg/parceler/Parcels$ParcelableFactory;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 189
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 187
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lorg/parceler/Parcels$ParcelCodeRepository;->generatedMap:Ljava/util/concurrent/ConcurrentMap;

    .line 190
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    invoke-virtual {p0, v0}, Lorg/parceler/Parcels$ParcelCodeRepository;->loadRepository(Ljava/lang/ClassLoader;)V

    .line 191
    return-void
.end method

.method private static buildParcelableImplName(Ljava/lang/Class;)Ljava/lang/String;
    .locals 2
    .param p0, "clazz"    # Ljava/lang/Class;

    .prologue
    .line 214
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "$$"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "Parcelable"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public findClass(Ljava/lang/Class;)Lorg/parceler/Parcels$ParcelableFactory;
    .locals 3
    .param p1, "clazz"    # Ljava/lang/Class;

    .prologue
    .line 220
    :try_start_0
    invoke-static {p1}, Lorg/parceler/Parcels$ParcelCodeRepository;->buildParcelableImplName(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    .line 221
    .local v1, "parcelWrapperClass":Ljava/lang/Class;
    new-instance v2, Lorg/parceler/Parcels$ParcelableFactoryReflectionProxy;

    invoke-direct {v2, p1, v1}, Lorg/parceler/Parcels$ParcelableFactoryReflectionProxy;-><init>(Ljava/lang/Class;Ljava/lang/Class;)V
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 223
    .end local v1    # "parcelWrapperClass":Ljava/lang/Class;
    :goto_0
    return-object v2

    .line 222
    :catch_0
    move-exception v0

    .line 223
    .local v0, "e":Ljava/lang/ClassNotFoundException;
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public get(Ljava/lang/Class;)Lorg/parceler/Parcels$ParcelableFactory;
    .locals 5
    .param p1, "clazz"    # Ljava/lang/Class;

    .prologue
    .line 194
    iget-object v2, p0, Lorg/parceler/Parcels$ParcelCodeRepository;->generatedMap:Ljava/util/concurrent/ConcurrentMap;

    invoke-interface {v2, p1}, Ljava/util/concurrent/ConcurrentMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/parceler/Parcels$ParcelableFactory;

    .line 195
    .local v0, "result":Lorg/parceler/Parcels$ParcelableFactory;
    if-nez v0, :cond_1

    .line 196
    invoke-virtual {p0, p1}, Lorg/parceler/Parcels$ParcelCodeRepository;->findClass(Ljava/lang/Class;)Lorg/parceler/Parcels$ParcelableFactory;

    move-result-object v1

    .line 197
    .local v1, "value":Lorg/parceler/Parcels$ParcelableFactory;
    if-nez v1, :cond_0

    .line 198
    new-instance v2, Lorg/parceler/ParcelerRuntimeException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unable to find generated Parcelable class for "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 199
    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", verify that your class is configured properly and that the Parcelable class "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 201
    invoke-static {p1}, Lorg/parceler/Parcels$ParcelCodeRepository;->buildParcelableImplName(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " is generated by Parceler."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lorg/parceler/ParcelerRuntimeException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 204
    :cond_0
    iget-object v2, p0, Lorg/parceler/Parcels$ParcelCodeRepository;->generatedMap:Ljava/util/concurrent/ConcurrentMap;

    invoke-interface {v2, p1, v1}, Ljava/util/concurrent/ConcurrentMap;->putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "result":Lorg/parceler/Parcels$ParcelableFactory;
    check-cast v0, Lorg/parceler/Parcels$ParcelableFactory;

    .line 205
    .restart local v0    # "result":Lorg/parceler/Parcels$ParcelableFactory;
    if-nez v0, :cond_1

    .line 206
    move-object v0, v1

    .line 210
    .end local v1    # "value":Lorg/parceler/Parcels$ParcelableFactory;
    :cond_1
    return-object v0
.end method

.method public loadRepository(Ljava/lang/ClassLoader;)V
    .locals 4
    .param p1, "classLoader"    # Ljava/lang/ClassLoader;

    .prologue
    .line 237
    :try_start_0
    const-string v2, "org.parceler.Parceler$$Parcels"

    invoke-virtual {p1, v2}, Ljava/lang/ClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    .line 238
    .local v1, "repositoryClass":Ljava/lang/Class;
    invoke-virtual {v1}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/parceler/Repository;

    invoke-virtual {p0, v2}, Lorg/parceler/Parcels$ParcelCodeRepository;->loadRepository(Lorg/parceler/Repository;)V
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1

    .line 248
    .end local v1    # "repositoryClass":Ljava/lang/Class;
    :goto_0
    return-void

    .line 243
    :catch_0
    move-exception v0

    .line 244
    .local v0, "e":Ljava/lang/InstantiationException;
    new-instance v2, Lorg/parceler/ParcelerRuntimeException;

    const-string v3, "Unable to instantiate generated Repository"

    invoke-direct {v2, v3, v0}, Lorg/parceler/ParcelerRuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Exception;)V

    throw v2

    .line 245
    .end local v0    # "e":Ljava/lang/InstantiationException;
    :catch_1
    move-exception v0

    .line 246
    .local v0, "e":Ljava/lang/IllegalAccessException;
    new-instance v2, Lorg/parceler/ParcelerRuntimeException;

    const-string v3, "Unable to access generated Repository"

    invoke-direct {v2, v3, v0}, Lorg/parceler/ParcelerRuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Exception;)V

    throw v2

    .line 241
    .end local v0    # "e":Ljava/lang/IllegalAccessException;
    :catch_2
    move-exception v2

    goto :goto_0
.end method

.method public loadRepository(Lorg/parceler/Repository;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/parceler/Repository",
            "<",
            "Lorg/parceler/Parcels$ParcelableFactory;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 251
    .local p1, "repository":Lorg/parceler/Repository;, "Lorg/parceler/Repository<Lorg/parceler/Parcels$ParcelableFactory;>;"
    iget-object v0, p0, Lorg/parceler/Parcels$ParcelCodeRepository;->generatedMap:Ljava/util/concurrent/ConcurrentMap;

    invoke-interface {p1}, Lorg/parceler/Repository;->get()Ljava/util/Map;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/concurrent/ConcurrentMap;->putAll(Ljava/util/Map;)V

    .line 252
    return-void
.end method
