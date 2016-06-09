.class Lorg/apache/commons/validator/routines/DomainValidator$IDNBUGHOLDER;
.super Ljava/lang/Object;
.source "DomainValidator.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/apache/commons/validator/routines/DomainValidator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "IDNBUGHOLDER"
.end annotation


# static fields
.field private static final IDN_TOASCII_PRESERVES_TRAILING_DOTS:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 1536
    invoke-static {}, Lorg/apache/commons/validator/routines/DomainValidator$IDNBUGHOLDER;->keepsTrailingDot()Z

    move-result v0

    sput-boolean v0, Lorg/apache/commons/validator/routines/DomainValidator$IDNBUGHOLDER;->IDN_TOASCII_PRESERVES_TRAILING_DOTS:Z

    return-void
.end method

.method static synthetic access$000()Z
    .locals 1

    .prologue
    .line 1531
    sget-boolean v0, Lorg/apache/commons/validator/routines/DomainValidator$IDNBUGHOLDER;->IDN_TOASCII_PRESERVES_TRAILING_DOTS:Z

    return v0
.end method

.method private static keepsTrailingDot()Z
    .locals 3

    .prologue
    .line 1533
    const-string v0, "a."

    .line 1534
    .local v0, "input":Ljava/lang/String;
    const-string v1, "a."

    const-string v2, "a."

    invoke-static {v2}, Ljava/net/IDN;->toASCII(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    return v1
.end method
