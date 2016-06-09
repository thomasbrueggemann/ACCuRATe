.class public Lcz/msebera/android/httpclient/util/VersionInfo;
.super Ljava/lang/Object;
.source "VersionInfo.java"


# instance fields
.field private final infoClassloader:Ljava/lang/String;

.field private final infoModule:Ljava/lang/String;

.field private final infoPackage:Ljava/lang/String;

.field private final infoRelease:Ljava/lang/String;

.field private final infoTimestamp:Ljava/lang/String;


# direct methods
.method protected constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "pckg"    # Ljava/lang/String;
    .param p2, "module"    # Ljava/lang/String;
    .param p3, "release"    # Ljava/lang/String;
    .param p4, "time"    # Ljava/lang/String;
    .param p5, "clsldr"    # Ljava/lang/String;

    .prologue
    .line 89
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 90
    const-string v0, "Package identifier"

    invoke-static {p1, v0}, Lcz/msebera/android/httpclient/util/Args;->notNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 91
    iput-object p1, p0, Lcz/msebera/android/httpclient/util/VersionInfo;->infoPackage:Ljava/lang/String;

    .line 92
    if-eqz p2, :cond_0

    .end local p2    # "module":Ljava/lang/String;
    :goto_0
    iput-object p2, p0, Lcz/msebera/android/httpclient/util/VersionInfo;->infoModule:Ljava/lang/String;

    .line 93
    if-eqz p3, :cond_1

    .end local p3    # "release":Ljava/lang/String;
    :goto_1
    iput-object p3, p0, Lcz/msebera/android/httpclient/util/VersionInfo;->infoRelease:Ljava/lang/String;

    .line 94
    if-eqz p4, :cond_2

    .end local p4    # "time":Ljava/lang/String;
    :goto_2
    iput-object p4, p0, Lcz/msebera/android/httpclient/util/VersionInfo;->infoTimestamp:Ljava/lang/String;

    .line 95
    if-eqz p5, :cond_3

    .end local p5    # "clsldr":Ljava/lang/String;
    :goto_3
    iput-object p5, p0, Lcz/msebera/android/httpclient/util/VersionInfo;->infoClassloader:Ljava/lang/String;

    .line 96
    return-void

    .line 92
    .restart local p2    # "module":Ljava/lang/String;
    .restart local p3    # "release":Ljava/lang/String;
    .restart local p4    # "time":Ljava/lang/String;
    .restart local p5    # "clsldr":Ljava/lang/String;
    :cond_0
    const-string p2, "UNAVAILABLE"

    goto :goto_0

    .line 93
    .end local p2    # "module":Ljava/lang/String;
    :cond_1
    const-string p3, "UNAVAILABLE"

    goto :goto_1

    .line 94
    .end local p3    # "release":Ljava/lang/String;
    :cond_2
    const-string p4, "UNAVAILABLE"

    goto :goto_2

    .line 95
    .end local p4    # "time":Ljava/lang/String;
    :cond_3
    const-string p5, "UNAVAILABLE"

    goto :goto_3
.end method

.method protected static fromMap(Ljava/lang/String;Ljava/util/Map;Ljava/lang/ClassLoader;)Lcz/msebera/android/httpclient/util/VersionInfo;
    .locals 6
    .param p0, "pckg"    # Ljava/lang/String;
    .param p2, "clsldr"    # Ljava/lang/ClassLoader;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<**>;",
            "Ljava/lang/ClassLoader;",
            ")",
            "Lcz/msebera/android/httpclient/util/VersionInfo;"
        }
    .end annotation

    .prologue
    .local p1, "info":Ljava/util/Map;, "Ljava/util/Map<**>;"
    const/4 v1, 0x1

    .line 268
    const-string v0, "Package identifier"

    invoke-static {p0, v0}, Lcz/msebera/android/httpclient/util/Args;->notNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 269
    const/4 v2, 0x0

    .line 270
    .local v2, "module":Ljava/lang/String;
    const/4 v3, 0x0

    .line 271
    .local v3, "release":Ljava/lang/String;
    const/4 v4, 0x0

    .line 273
    .local v4, "timestamp":Ljava/lang/String;
    if-eqz p1, :cond_4

    .line 274
    const-string v0, "info.module"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .end local v2    # "module":Ljava/lang/String;
    check-cast v2, Ljava/lang/String;

    .line 275
    .restart local v2    # "module":Ljava/lang/String;
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v0

    if-ge v0, v1, :cond_0

    .line 276
    const/4 v2, 0x0

    .line 279
    :cond_0
    const-string v0, "info.release"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .end local v3    # "release":Ljava/lang/String;
    check-cast v3, Ljava/lang/String;

    .line 280
    .restart local v3    # "release":Ljava/lang/String;
    if-eqz v3, :cond_2

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v0

    if-lt v0, v1, :cond_1

    const-string v0, "${pom.version}"

    .line 281
    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 282
    :cond_1
    const/4 v3, 0x0

    .line 285
    :cond_2
    const-string v0, "info.timestamp"

    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    .end local v4    # "timestamp":Ljava/lang/String;
    check-cast v4, Ljava/lang/String;

    .line 286
    .restart local v4    # "timestamp":Ljava/lang/String;
    if-eqz v4, :cond_4

    .line 287
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v0

    if-lt v0, v1, :cond_3

    const-string v0, "${mvn.timestamp}"

    .line 288
    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 290
    :cond_3
    const/4 v4, 0x0

    .line 294
    :cond_4
    const/4 v5, 0x0

    .line 295
    .local v5, "clsldrstr":Ljava/lang/String;
    if-eqz p2, :cond_5

    .line 296
    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    .line 299
    :cond_5
    new-instance v0, Lcz/msebera/android/httpclient/util/VersionInfo;

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lcz/msebera/android/httpclient/util/VersionInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public static loadVersionInfo(Ljava/lang/String;Ljava/lang/ClassLoader;)Lcz/msebera/android/httpclient/util/VersionInfo;
    .locals 8
    .param p0, "pckg"    # Ljava/lang/String;
    .param p1, "clsldr"    # Ljava/lang/ClassLoader;

    .prologue
    .line 225
    const-string v5, "Package identifier"

    invoke-static {p0, v5}, Lcz/msebera/android/httpclient/util/Args;->notNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 226
    if-eqz p1, :cond_2

    move-object v0, p1

    .line 228
    .local v0, "cl":Ljava/lang/ClassLoader;
    :goto_0
    const/4 v4, 0x0

    .line 232
    .local v4, "vip":Ljava/util/Properties;
    :try_start_0
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const/16 v6, 0x2e

    const/16 v7, 0x2f

    .line 233
    invoke-virtual {p0, v6, v7}, Ljava/lang/String;->replace(CC)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "/"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "version.properties"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/lang/ClassLoader;->getResourceAsStream(Ljava/lang/String;)Ljava/io/InputStream;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 234
    .local v1, "is":Ljava/io/InputStream;
    if-eqz v1, :cond_0

    .line 236
    :try_start_1
    new-instance v2, Ljava/util/Properties;

    invoke-direct {v2}, Ljava/util/Properties;-><init>()V

    .line 237
    .local v2, "props":Ljava/util/Properties;
    invoke-virtual {v2, v1}, Ljava/util/Properties;->load(Ljava/io/InputStream;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 238
    move-object v4, v2

    .line 240
    :try_start_2
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    .line 247
    .end local v1    # "is":Ljava/io/InputStream;
    .end local v2    # "props":Ljava/util/Properties;
    :cond_0
    :goto_1
    const/4 v3, 0x0

    .line 248
    .local v3, "result":Lcz/msebera/android/httpclient/util/VersionInfo;
    if-eqz v4, :cond_1

    .line 249
    invoke-static {p0, v4, v0}, Lcz/msebera/android/httpclient/util/VersionInfo;->fromMap(Ljava/lang/String;Ljava/util/Map;Ljava/lang/ClassLoader;)Lcz/msebera/android/httpclient/util/VersionInfo;

    move-result-object v3

    .line 252
    :cond_1
    return-object v3

    .line 226
    .end local v0    # "cl":Ljava/lang/ClassLoader;
    .end local v3    # "result":Lcz/msebera/android/httpclient/util/VersionInfo;
    .end local v4    # "vip":Ljava/util/Properties;
    :cond_2
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Thread;->getContextClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    goto :goto_0

    .line 240
    .restart local v0    # "cl":Ljava/lang/ClassLoader;
    .restart local v1    # "is":Ljava/io/InputStream;
    .restart local v4    # "vip":Ljava/util/Properties;
    :catchall_0
    move-exception v5

    :try_start_3
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V

    throw v5
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0

    .line 243
    .end local v1    # "is":Ljava/io/InputStream;
    :catch_0
    move-exception v5

    goto :goto_1
.end method


# virtual methods
.method public final getRelease()Ljava/lang/String;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcz/msebera/android/httpclient/util/VersionInfo;->infoRelease:Ljava/lang/String;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    const/16 v3, 0x3a

    .line 159
    new-instance v0, Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcz/msebera/android/httpclient/util/VersionInfo;->infoPackage:Ljava/lang/String;

    .line 160
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    add-int/lit8 v1, v1, 0x14

    iget-object v2, p0, Lcz/msebera/android/httpclient/util/VersionInfo;->infoModule:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    add-int/2addr v1, v2

    iget-object v2, p0, Lcz/msebera/android/httpclient/util/VersionInfo;->infoRelease:Ljava/lang/String;

    .line 161
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    add-int/2addr v1, v2

    iget-object v2, p0, Lcz/msebera/android/httpclient/util/VersionInfo;->infoTimestamp:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    add-int/2addr v1, v2

    iget-object v2, p0, Lcz/msebera/android/httpclient/util/VersionInfo;->infoClassloader:Ljava/lang/String;

    .line 162
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    add-int/2addr v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 164
    .local v0, "sb":Ljava/lang/StringBuilder;
    const-string v1, "VersionInfo("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcz/msebera/android/httpclient/util/VersionInfo;->infoPackage:Ljava/lang/String;

    .line 165
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcz/msebera/android/httpclient/util/VersionInfo;->infoModule:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 169
    const-string v1, "UNAVAILABLE"

    iget-object v2, p0, Lcz/msebera/android/httpclient/util/VersionInfo;->infoRelease:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 170
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcz/msebera/android/httpclient/util/VersionInfo;->infoRelease:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 172
    :cond_0
    const-string v1, "UNAVAILABLE"

    iget-object v2, p0, Lcz/msebera/android/httpclient/util/VersionInfo;->infoTimestamp:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 173
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcz/msebera/android/httpclient/util/VersionInfo;->infoTimestamp:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 176
    :cond_1
    const/16 v1, 0x29

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 178
    const-string v1, "UNAVAILABLE"

    iget-object v2, p0, Lcz/msebera/android/httpclient/util/VersionInfo;->infoClassloader:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 179
    const/16 v1, 0x40

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcz/msebera/android/httpclient/util/VersionInfo;->infoClassloader:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 182
    :cond_2
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
