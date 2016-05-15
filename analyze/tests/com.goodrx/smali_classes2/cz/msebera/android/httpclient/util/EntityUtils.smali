.class public final Lcz/msebera/android/httpclient/util/EntityUtils;
.super Ljava/lang/Object;
.source "EntityUtils.java"


# direct methods
.method public static consume(Lcz/msebera/android/httpclient/HttpEntity;)V
    .locals 2
    .param p0, "entity"    # Lcz/msebera/android/httpclient/HttpEntity;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 82
    if-nez p0, :cond_1

    .line 91
    :cond_0
    :goto_0
    return-void

    .line 85
    :cond_1
    invoke-interface {p0}, Lcz/msebera/android/httpclient/HttpEntity;->isStreaming()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 86
    invoke-interface {p0}, Lcz/msebera/android/httpclient/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v0

    .line 87
    .local v0, "instream":Ljava/io/InputStream;
    if-eqz v0, :cond_0

    .line 88
    invoke-virtual {v0}, Ljava/io/InputStream;->close()V

    goto :goto_0
.end method

.method public static toByteArray(Lcz/msebera/android/httpclient/HttpEntity;)[B
    .locals 10
    .param p0, "entity"    # Lcz/msebera/android/httpclient/HttpEntity;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x0

    .line 121
    const-string v6, "Entity"

    invoke-static {p0, v6}, Lcz/msebera/android/httpclient/util/Args;->notNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 122
    invoke-interface {p0}, Lcz/msebera/android/httpclient/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v2

    .line 123
    .local v2, "instream":Ljava/io/InputStream;
    if-nez v2, :cond_0

    .line 124
    const/4 v5, 0x0

    .line 141
    :goto_0
    return-object v5

    .line 127
    :cond_0
    :try_start_0
    invoke-interface {p0}, Lcz/msebera/android/httpclient/HttpEntity;->getContentLength()J

    move-result-wide v6

    const-wide/32 v8, 0x7fffffff

    cmp-long v6, v6, v8

    if-gtz v6, :cond_1

    const/4 v5, 0x1

    :cond_1
    const-string v6, "HTTP entity too large to be buffered in memory"

    invoke-static {v5, v6}, Lcz/msebera/android/httpclient/util/Args;->check(ZLjava/lang/String;)V

    .line 129
    invoke-interface {p0}, Lcz/msebera/android/httpclient/HttpEntity;->getContentLength()J

    move-result-wide v6

    long-to-int v1, v6

    .line 130
    .local v1, "i":I
    if-gez v1, :cond_2

    .line 131
    const/16 v1, 0x1000

    .line 133
    :cond_2
    new-instance v0, Lcz/msebera/android/httpclient/util/ByteArrayBuffer;

    invoke-direct {v0, v1}, Lcz/msebera/android/httpclient/util/ByteArrayBuffer;-><init>(I)V

    .line 134
    .local v0, "buffer":Lcz/msebera/android/httpclient/util/ByteArrayBuffer;
    const/16 v5, 0x1000

    new-array v4, v5, [B

    .line 136
    .local v4, "tmp":[B
    :goto_1
    invoke-virtual {v2, v4}, Ljava/io/InputStream;->read([B)I

    move-result v3

    .local v3, "l":I
    const/4 v5, -0x1

    if-eq v3, v5, :cond_3

    .line 137
    const/4 v5, 0x0

    invoke-virtual {v0, v4, v5, v3}, Lcz/msebera/android/httpclient/util/ByteArrayBuffer;->append([BII)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    .line 141
    .end local v0    # "buffer":Lcz/msebera/android/httpclient/util/ByteArrayBuffer;
    .end local v1    # "i":I
    .end local v3    # "l":I
    .end local v4    # "tmp":[B
    :catchall_0
    move-exception v5

    invoke-virtual {v2}, Ljava/io/InputStream;->close()V

    throw v5

    .line 139
    .restart local v0    # "buffer":Lcz/msebera/android/httpclient/util/ByteArrayBuffer;
    .restart local v1    # "i":I
    .restart local v3    # "l":I
    .restart local v4    # "tmp":[B
    :cond_3
    :try_start_1
    invoke-virtual {v0}, Lcz/msebera/android/httpclient/util/ByteArrayBuffer;->toByteArray()[B
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v5

    .line 141
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V

    goto :goto_0
.end method
