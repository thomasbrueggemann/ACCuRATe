.class public Lnet/danlew/android/joda/ResourceZoneInfoProvider;
.super Ljava/lang/Object;
.source "ResourceZoneInfoProvider.java"

# interfaces
.implements Lorg/joda/time/tz/Provider;


# instance fields
.field private final iZoneInfoMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field private mAppContext:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    if-nez p1, :cond_0

    .line 35
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Context must not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 38
    :cond_0
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lnet/danlew/android/joda/ResourceZoneInfoProvider;->mAppContext:Landroid/content/Context;

    .line 39
    const-string v0, "ZoneInfoMap"

    invoke-direct {p0, v0}, Lnet/danlew/android/joda/ResourceZoneInfoProvider;->openResource(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v0

    invoke-static {v0}, Lnet/danlew/android/joda/ResourceZoneInfoProvider;->loadZoneInfoMap(Ljava/io/InputStream;)Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lnet/danlew/android/joda/ResourceZoneInfoProvider;->iZoneInfoMap:Ljava/util/Map;

    .line 40
    return-void
.end method

.method private loadZoneData(Ljava/lang/String;)Lorg/joda/time/DateTimeZone;
    .locals 5
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 132
    const/4 v1, 0x0

    .line 134
    .local v1, "in":Ljava/io/InputStream;
    :try_start_0
    invoke-direct {p0, p1}, Lnet/danlew/android/joda/ResourceZoneInfoProvider;->openResource(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v1

    .line 135
    invoke-static {v1, p1}, Lorg/joda/time/tz/DateTimeZoneBuilder;->readFrom(Ljava/io/InputStream;Ljava/lang/String;)Lorg/joda/time/DateTimeZone;

    move-result-object v2

    .line 136
    .local v2, "tz":Lorg/joda/time/DateTimeZone;
    iget-object v3, p0, Lnet/danlew/android/joda/ResourceZoneInfoProvider;->iZoneInfoMap:Ljava/util/Map;

    new-instance v4, Ljava/lang/ref/SoftReference;

    invoke-direct {v4, v2}, Ljava/lang/ref/SoftReference;-><init>(Ljava/lang/Object;)V

    invoke-interface {v3, p1, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 146
    if-eqz v1, :cond_0

    .line 147
    :try_start_1
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2

    .line 151
    .end local v2    # "tz":Lorg/joda/time/DateTimeZone;
    :cond_0
    :goto_0
    return-object v2

    .line 139
    :catch_0
    move-exception v0

    .line 140
    .local v0, "ex":Ljava/io/IOException;
    :try_start_2
    invoke-virtual {p0, v0}, Lnet/danlew/android/joda/ResourceZoneInfoProvider;->uncaughtException(Ljava/lang/Exception;)V

    .line 141
    iget-object v3, p0, Lnet/danlew/android/joda/ResourceZoneInfoProvider;->iZoneInfoMap:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 142
    const/4 v2, 0x0

    .line 146
    if-eqz v1, :cond_0

    .line 147
    :try_start_3
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_0

    .line 150
    :catch_1
    move-exception v3

    goto :goto_0

    .line 145
    .end local v0    # "ex":Ljava/io/IOException;
    :catchall_0
    move-exception v3

    .line 146
    if-eqz v1, :cond_1

    .line 147
    :try_start_4
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_3

    .line 151
    :cond_1
    :goto_1
    throw v3

    .line 150
    .restart local v2    # "tz":Lorg/joda/time/DateTimeZone;
    :catch_2
    move-exception v3

    goto :goto_0

    .end local v2    # "tz":Lorg/joda/time/DateTimeZone;
    :catch_3
    move-exception v4

    goto :goto_1
.end method

.method private static loadZoneInfoMap(Ljava/io/InputStream;)Ljava/util/Map;
    .locals 5
    .param p0, "in"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/InputStream;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 163
    new-instance v1, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v1}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    .line 164
    .local v1, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    new-instance v0, Ljava/io/DataInputStream;

    invoke-direct {v0, p0}, Ljava/io/DataInputStream;-><init>(Ljava/io/InputStream;)V

    .line 166
    .local v0, "din":Ljava/io/DataInputStream;
    :try_start_0
    invoke-static {v0, v1}, Lnet/danlew/android/joda/ResourceZoneInfoProvider;->readZoneInfoMap(Ljava/io/DataInputStream;Ljava/util/Map;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 170
    :try_start_1
    invoke-virtual {v0}, Ljava/io/DataInputStream;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    .line 175
    :goto_0
    const-string v2, "UTC"

    new-instance v3, Ljava/lang/ref/SoftReference;

    sget-object v4, Lorg/joda/time/DateTimeZone;->UTC:Lorg/joda/time/DateTimeZone;

    invoke-direct {v3, v4}, Ljava/lang/ref/SoftReference;-><init>(Ljava/lang/Object;)V

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 176
    return-object v1

    .line 169
    :catchall_0
    move-exception v2

    .line 170
    :try_start_2
    invoke-virtual {v0}, Ljava/io/DataInputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    .line 173
    :goto_1
    throw v2

    .line 172
    :catch_0
    move-exception v2

    goto :goto_0

    :catch_1
    move-exception v3

    goto :goto_1
.end method

.method private openResource(Ljava/lang/String;)Ljava/io/InputStream;
    .locals 6
    .param p1, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 109
    iget-object v3, p0, Lnet/danlew/android/joda/ResourceZoneInfoProvider;->mAppContext:Landroid/content/Context;

    if-nez v3, :cond_0

    .line 110
    new-instance v3, Ljava/lang/RuntimeException;

    const-string v4, "Need to call JodaTimeAndroid.init() before using joda-time-android"

    invoke-direct {v3, v4}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 113
    :cond_0
    invoke-static {p1}, Lnet/danlew/android/joda/ResUtils;->getTzResource(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 114
    .local v2, "resName":Ljava/lang/String;
    const-class v3, Lnet/danlew/android/joda/R$raw;

    invoke-static {v3, v2}, Lnet/danlew/android/joda/ResUtils;->getIdentifier(Ljava/lang/Class;Ljava/lang/String;)I

    move-result v1

    .line 116
    .local v1, "resId":I
    if-nez v1, :cond_1

    .line 117
    new-instance v3, Ljava/io/IOException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Resource not found: \""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\" (resName: \""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 120
    :cond_1
    iget-object v3, p0, Lnet/danlew/android/joda/ResourceZoneInfoProvider;->mAppContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, v1}, Landroid/content/res/Resources;->openRawResource(I)Ljava/io/InputStream;

    move-result-object v0

    .line 122
    .local v0, "in":Ljava/io/InputStream;
    return-object v0
.end method

.method private static readZoneInfoMap(Ljava/io/DataInputStream;Ljava/util/Map;)V
    .locals 6
    .param p0, "din"    # Ljava/io/DataInputStream;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/DataInputStream;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 187
    .local p1, "zimap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-virtual {p0}, Ljava/io/DataInputStream;->readUnsignedShort()I

    move-result v3

    .line 188
    .local v3, "size":I
    new-array v2, v3, [Ljava/lang/String;

    .line 189
    .local v2, "pool":[Ljava/lang/String;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v3, :cond_0

    .line 190
    invoke-virtual {p0}, Ljava/io/DataInputStream;->readUTF()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v1

    .line 189
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 194
    :cond_0
    invoke-virtual {p0}, Ljava/io/DataInputStream;->readUnsignedShort()I

    move-result v3

    .line 195
    const/4 v1, 0x0

    :goto_1
    if-ge v1, v3, :cond_1

    .line 197
    :try_start_0
    invoke-virtual {p0}, Ljava/io/DataInputStream;->readUnsignedShort()I

    move-result v4

    aget-object v4, v2, v4

    invoke-virtual {p0}, Ljava/io/DataInputStream;->readUnsignedShort()I

    move-result v5

    aget-object v5, v2, v5

    invoke-interface {p1, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/ArrayIndexOutOfBoundsException; {:try_start_0 .. :try_end_0} :catch_0

    .line 195
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 199
    :catch_0
    move-exception v0

    .line 200
    .local v0, "ex":Ljava/lang/ArrayIndexOutOfBoundsException;
    new-instance v4, Ljava/io/IOException;

    const-string v5, "Corrupt zone info map"

    invoke-direct {v4, v5}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 203
    .end local v0    # "ex":Ljava/lang/ArrayIndexOutOfBoundsException;
    :cond_1
    return-void
.end method


# virtual methods
.method public getAvailableIDs()Ljava/util/Set;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 89
    new-instance v0, Ljava/util/TreeSet;

    iget-object v1, p0, Lnet/danlew/android/joda/ResourceZoneInfoProvider;->iZoneInfoMap:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/TreeSet;-><init>(Ljava/util/Collection;)V

    return-object v0
.end method

.method public getZone(Ljava/lang/String;)Lorg/joda/time/DateTimeZone;
    .locals 4
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 51
    if-nez p1, :cond_1

    .line 77
    :cond_0
    :goto_0
    return-object v2

    .line 55
    :cond_1
    iget-object v3, p0, Lnet/danlew/android/joda/ResourceZoneInfoProvider;->iZoneInfoMap:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 56
    .local v0, "obj":Ljava/lang/Object;
    if-eqz v0, :cond_0

    .line 60
    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 62
    invoke-direct {p0, p1}, Lnet/danlew/android/joda/ResourceZoneInfoProvider;->loadZoneData(Ljava/lang/String;)Lorg/joda/time/DateTimeZone;

    move-result-object v2

    goto :goto_0

    .line 65
    :cond_2
    instance-of v3, v0, Ljava/lang/ref/SoftReference;

    if-eqz v3, :cond_3

    move-object v1, v0

    .line 67
    check-cast v1, Ljava/lang/ref/SoftReference;

    .line 68
    .local v1, "ref":Ljava/lang/ref/SoftReference;, "Ljava/lang/ref/SoftReference<Lorg/joda/time/DateTimeZone;>;"
    invoke-virtual {v1}, Ljava/lang/ref/SoftReference;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/joda/time/DateTimeZone;

    .line 69
    .local v2, "tz":Lorg/joda/time/DateTimeZone;
    if-nez v2, :cond_0

    .line 73
    invoke-direct {p0, p1}, Lnet/danlew/android/joda/ResourceZoneInfoProvider;->loadZoneData(Ljava/lang/String;)Lorg/joda/time/DateTimeZone;

    move-result-object v2

    goto :goto_0

    .line 77
    .end local v1    # "ref":Ljava/lang/ref/SoftReference;, "Ljava/lang/ref/SoftReference<Lorg/joda/time/DateTimeZone;>;"
    .end local v2    # "tz":Lorg/joda/time/DateTimeZone;
    :cond_3
    check-cast v0, Ljava/lang/String;

    .end local v0    # "obj":Ljava/lang/Object;
    invoke-virtual {p0, v0}, Lnet/danlew/android/joda/ResourceZoneInfoProvider;->getZone(Ljava/lang/String;)Lorg/joda/time/DateTimeZone;

    move-result-object v2

    goto :goto_0
.end method

.method protected uncaughtException(Ljava/lang/Exception;)V
    .locals 0
    .param p1, "ex"    # Ljava/lang/Exception;

    .prologue
    .line 98
    invoke-virtual {p1}, Ljava/lang/Exception;->printStackTrace()V

    .line 99
    return-void
.end method
