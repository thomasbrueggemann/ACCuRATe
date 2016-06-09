.class Lorg/joda/time/DateTimeUtils$FixedMillisProvider;
.super Ljava/lang/Object;
.source "DateTimeUtils.java"

# interfaces
.implements Lorg/joda/time/DateTimeUtils$MillisProvider;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/joda/time/DateTimeUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "FixedMillisProvider"
.end annotation


# instance fields
.field private final iMillis:J


# direct methods
.method constructor <init>(J)V
    .locals 1

    .prologue
    .line 559
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 560
    iput-wide p1, p0, Lorg/joda/time/DateTimeUtils$FixedMillisProvider;->iMillis:J

    .line 561
    return-void
.end method


# virtual methods
.method public getMillis()J
    .locals 2

    .prologue
    .line 568
    iget-wide v0, p0, Lorg/joda/time/DateTimeUtils$FixedMillisProvider;->iMillis:J

    return-wide v0
.end method
