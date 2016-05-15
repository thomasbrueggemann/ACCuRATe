.class public Lorg/apache/commons/lang3/BooleanUtils;
.super Ljava/lang/Object;
.source "BooleanUtils.java"


# direct methods
.method public static compare(ZZ)I
    .locals 1
    .param p0, "x"    # Z
    .param p1, "y"    # Z

    .prologue
    .line 1099
    if-ne p0, p1, :cond_0

    .line 1100
    const/4 v0, 0x0

    .line 1105
    :goto_0
    return v0

    .line 1102
    :cond_0
    if-eqz p0, :cond_1

    .line 1103
    const/4 v0, 0x1

    goto :goto_0

    .line 1105
    :cond_1
    const/4 v0, -0x1

    goto :goto_0
.end method
