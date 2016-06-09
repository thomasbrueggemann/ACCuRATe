.class public Lnet/danlew/android/joda/DateUtils;
.super Ljava/lang/Object;
.source "DateUtils.java"


# static fields
.field private static final EPOCH:Lorg/joda/time/DateTime;

.field public static final FORMAT_ABBREV_ALL:I = 0x80000

.field public static final FORMAT_ABBREV_MONTH:I = 0x10000

.field public static final FORMAT_ABBREV_RELATIVE:I = 0x40000

.field public static final FORMAT_ABBREV_TIME:I = 0x4000

.field public static final FORMAT_ABBREV_WEEKDAY:I = 0x8000

.field public static final FORMAT_NO_MIDNIGHT:I = 0x800

.field public static final FORMAT_NO_MONTH_DAY:I = 0x20

.field public static final FORMAT_NO_NOON:I = 0x200

.field public static final FORMAT_NO_YEAR:I = 0x8

.field public static final FORMAT_NUMERIC_DATE:I = 0x20000

.field public static final FORMAT_SHOW_DATE:I = 0x10

.field public static final FORMAT_SHOW_TIME:I = 0x1

.field public static final FORMAT_SHOW_WEEKDAY:I = 0x2

.field public static final FORMAT_SHOW_YEAR:I = 0x4

.field private static final FORMAT_UTC:I = 0x2000


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 64
    new-instance v0, Lorg/joda/time/DateTime;

    const-wide/16 v2, 0x0

    sget-object v1, Lorg/joda/time/DateTimeZone;->UTC:Lorg/joda/time/DateTimeZone;

    invoke-direct {v0, v2, v3, v1}, Lorg/joda/time/DateTime;-><init>(JLorg/joda/time/DateTimeZone;)V

    sput-object v0, Lnet/danlew/android/joda/DateUtils;->EPOCH:Lorg/joda/time/DateTime;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static formatDateRange(Landroid/content/Context;JJI)Ljava/lang/String;
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "startMillis"    # J
    .param p3, "endMillis"    # J
    .param p5, "flags"    # I

    .prologue
    .line 136
    cmp-long v0, p1, p3

    if-eqz v0, :cond_0

    .line 137
    const-wide/16 v0, 0x3e8

    add-long/2addr p3, v0

    .line 140
    :cond_0
    or-int/lit16 v6, p5, 0x2000

    move-object v1, p0

    move-wide v2, p1

    move-wide v4, p3

    invoke-static/range {v1 .. v6}, Landroid/text/format/DateUtils;->formatDateRange(Landroid/content/Context;JJI)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static formatDateRange(Landroid/content/Context;Lorg/joda/time/ReadableInstant;Lorg/joda/time/ReadableInstant;I)Ljava/lang/String;
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "start"    # Lorg/joda/time/ReadableInstant;
    .param p2, "end"    # Lorg/joda/time/ReadableInstant;
    .param p3, "flags"    # I

    .prologue
    .line 130
    invoke-static {p1}, Lnet/danlew/android/joda/DateUtils;->toMillis(Lorg/joda/time/ReadableInstant;)J

    move-result-wide v2

    invoke-static {p2}, Lnet/danlew/android/joda/DateUtils;->toMillis(Lorg/joda/time/ReadableInstant;)J

    move-result-wide v4

    move-object v1, p0

    move v6, p3

    invoke-static/range {v1 .. v6}, Lnet/danlew/android/joda/DateUtils;->formatDateRange(Landroid/content/Context;JJI)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static formatDateRange(Landroid/content/Context;Lorg/joda/time/ReadablePartial;Lorg/joda/time/ReadablePartial;I)Ljava/lang/String;
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "start"    # Lorg/joda/time/ReadablePartial;
    .param p2, "end"    # Lorg/joda/time/ReadablePartial;
    .param p3, "flags"    # I

    .prologue
    .line 112
    invoke-static {p1}, Lnet/danlew/android/joda/DateUtils;->toMillis(Lorg/joda/time/ReadablePartial;)J

    move-result-wide v2

    invoke-static {p2}, Lnet/danlew/android/joda/DateUtils;->toMillis(Lorg/joda/time/ReadablePartial;)J

    move-result-wide v4

    move-object v1, p0

    move v6, p3

    invoke-static/range {v1 .. v6}, Lnet/danlew/android/joda/DateUtils;->formatDateRange(Landroid/content/Context;JJI)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static formatDateTime(Landroid/content/Context;Lorg/joda/time/ReadableInstant;I)Ljava/lang/String;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "time"    # Lorg/joda/time/ReadableInstant;
    .param p2, "flags"    # I

    .prologue
    .line 94
    invoke-static {p1}, Lnet/danlew/android/joda/DateUtils;->toMillis(Lorg/joda/time/ReadableInstant;)J

    move-result-wide v0

    or-int/lit16 v2, p2, 0x2000

    invoke-static {p0, v0, v1, v2}, Landroid/text/format/DateUtils;->formatDateTime(Landroid/content/Context;JI)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static formatDateTime(Landroid/content/Context;Lorg/joda/time/ReadablePartial;I)Ljava/lang/String;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "time"    # Lorg/joda/time/ReadablePartial;
    .param p2, "flags"    # I

    .prologue
    .line 80
    invoke-static {p1}, Lnet/danlew/android/joda/DateUtils;->toMillis(Lorg/joda/time/ReadablePartial;)J

    move-result-wide v0

    or-int/lit16 v2, p2, 0x2000

    invoke-static {p0, v0, v1, v2}, Landroid/text/format/DateUtils;->formatDateTime(Landroid/content/Context;JI)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static formatDuration(Landroid/content/Context;Lorg/joda/time/ReadableDuration;)Ljava/lang/CharSequence;
    .locals 10
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "readableDuration"    # Lorg/joda/time/ReadableDuration;

    .prologue
    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 490
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    .line 491
    .local v3, "res":Landroid/content/res/Resources;
    invoke-interface {p1}, Lorg/joda/time/ReadableDuration;->toDuration()Lorg/joda/time/Duration;

    move-result-object v0

    .line 493
    .local v0, "duration":Lorg/joda/time/Duration;
    invoke-virtual {v0}, Lorg/joda/time/Duration;->getStandardHours()J

    move-result-wide v6

    long-to-int v1, v6

    .line 494
    .local v1, "hours":I
    if-eqz v1, :cond_0

    .line 495
    sget v5, Lnet/danlew/android/joda/R$plurals;->joda_time_android_duration_hours:I

    new-array v6, v9, [Ljava/lang/Object;

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v8

    invoke-virtual {v3, v5, v1, v6}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    .line 504
    :goto_0
    return-object v5

    .line 498
    :cond_0
    invoke-virtual {v0}, Lorg/joda/time/Duration;->getStandardMinutes()J

    move-result-wide v6

    long-to-int v2, v6

    .line 499
    .local v2, "minutes":I
    if-eqz v2, :cond_1

    .line 500
    sget v5, Lnet/danlew/android/joda/R$plurals;->joda_time_android_duration_minutes:I

    new-array v6, v9, [Ljava/lang/Object;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v8

    invoke-virtual {v3, v5, v2, v6}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    goto :goto_0

    .line 503
    :cond_1
    invoke-virtual {v0}, Lorg/joda/time/Duration;->getStandardSeconds()J

    move-result-wide v6

    long-to-int v4, v6

    .line 504
    .local v4, "seconds":I
    sget v5, Lnet/danlew/android/joda/R$plurals;->joda_time_android_duration_seconds:I

    new-array v6, v9, [Ljava/lang/Object;

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v8

    invoke-virtual {v3, v5, v4, v6}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    goto :goto_0
.end method

.method public static formatElapsedTime(Ljava/lang/StringBuilder;Lorg/joda/time/ReadableDuration;)Ljava/lang/String;
    .locals 2
    .param p0, "recycle"    # Ljava/lang/StringBuilder;
    .param p1, "elapsedDuration"    # Lorg/joda/time/ReadableDuration;

    .prologue
    .line 176
    .line 177
    invoke-interface {p1}, Lorg/joda/time/ReadableDuration;->toDuration()Lorg/joda/time/Duration;

    move-result-object v0

    invoke-virtual {v0}, Lorg/joda/time/Duration;->toStandardSeconds()Lorg/joda/time/Seconds;

    move-result-object v0

    invoke-virtual {v0}, Lorg/joda/time/Seconds;->getSeconds()I

    move-result v0

    int-to-long v0, v0

    .line 176
    invoke-static {p0, v0, v1}, Landroid/text/format/DateUtils;->formatElapsedTime(Ljava/lang/StringBuilder;J)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static formatElapsedTime(Lorg/joda/time/ReadableDuration;)Ljava/lang/String;
    .locals 1
    .param p0, "elapsedDuration"    # Lorg/joda/time/ReadableDuration;

    .prologue
    .line 162
    const/4 v0, 0x0

    invoke-static {v0, p0}, Lnet/danlew/android/joda/DateUtils;->formatElapsedTime(Ljava/lang/StringBuilder;Lorg/joda/time/ReadableDuration;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getRelativeDateTimeString(Landroid/content/Context;Lorg/joda/time/ReadableInstant;Lorg/joda/time/ReadablePeriod;I)Ljava/lang/CharSequence;
    .locals 18
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "time"    # Lorg/joda/time/ReadableInstant;
    .param p2, "transitionResolution"    # Lorg/joda/time/ReadablePeriod;
    .param p3, "flags"    # I

    .prologue
    .line 435
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    .line 438
    .local v9, "r":Landroid/content/res/Resources;
    invoke-interface/range {p1 .. p1}, Lorg/joda/time/ReadableInstant;->getZone()Lorg/joda/time/DateTimeZone;

    move-result-object v15

    invoke-static {v15}, Lorg/joda/time/DateTime;->now(Lorg/joda/time/DateTimeZone;)Lorg/joda/time/DateTime;

    move-result-object v15

    const/16 v16, 0x0

    invoke-virtual/range {v15 .. v16}, Lorg/joda/time/DateTime;->withMillisOfSecond(I)Lorg/joda/time/DateTime;

    move-result-object v7

    .line 439
    .local v7, "now":Lorg/joda/time/DateTime;
    new-instance v15, Lorg/joda/time/DateTime;

    move-object/from16 v0, p1

    invoke-direct {v15, v0}, Lorg/joda/time/DateTime;-><init>(Ljava/lang/Object;)V

    const/16 v16, 0x0

    invoke-virtual/range {v15 .. v16}, Lorg/joda/time/DateTime;->withMillisOfSecond(I)Lorg/joda/time/DateTime;

    move-result-object v13

    .line 440
    .local v13, "timeDt":Lorg/joda/time/DateTime;
    invoke-virtual {v7, v13}, Lorg/joda/time/DateTime;->isBefore(Lorg/joda/time/ReadableInstant;)Z

    move-result v15

    if-nez v15, :cond_1

    const/4 v8, 0x1

    .line 441
    .local v8, "past":Z
    :goto_0
    if-eqz v8, :cond_2

    new-instance v4, Lorg/joda/time/Duration;

    invoke-direct {v4, v13, v7}, Lorg/joda/time/Duration;-><init>(Lorg/joda/time/ReadableInstant;Lorg/joda/time/ReadableInstant;)V

    .line 447
    .local v4, "duration":Lorg/joda/time/Duration;
    :goto_1
    sget-object v15, Lorg/joda/time/Days;->ONE:Lorg/joda/time/Days;

    invoke-virtual {v15}, Lorg/joda/time/Days;->toPeriod()Lorg/joda/time/Period;

    move-result-object v15

    invoke-virtual {v15, v13}, Lorg/joda/time/Period;->toDurationTo(Lorg/joda/time/ReadableInstant;)Lorg/joda/time/Duration;

    move-result-object v6

    .line 448
    .local v6, "minDuration":Lorg/joda/time/Duration;
    if-nez p2, :cond_3

    .line 449
    move-object v14, v6

    .line 463
    .local v14, "transitionDuration":Lorg/joda/time/Duration;
    :cond_0
    :goto_2
    const/4 v15, 0x1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p1

    invoke-static {v0, v1, v2, v15}, Lnet/danlew/android/joda/DateUtils;->formatDateRange(Landroid/content/Context;Lorg/joda/time/ReadableInstant;Lorg/joda/time/ReadableInstant;I)Ljava/lang/String;

    move-result-object v12

    .line 466
    .local v12, "timeClause":Ljava/lang/CharSequence;
    invoke-virtual {v4, v14}, Lorg/joda/time/Duration;->isLongerThan(Lorg/joda/time/ReadableDuration;)Z

    move-result v15

    if-nez v15, :cond_6

    .line 467
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move/from16 v2, p3

    invoke-static {v0, v1, v2}, Lnet/danlew/android/joda/DateUtils;->getRelativeTimeSpanString(Landroid/content/Context;Lorg/joda/time/ReadableInstant;I)Ljava/lang/CharSequence;

    move-result-object v10

    .line 468
    .local v10, "relativeClause":Ljava/lang/CharSequence;
    sget v15, Lnet/danlew/android/joda/R$string;->joda_time_android_relative_time:I

    const/16 v16, 0x2

    move/from16 v0, v16

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    aput-object v10, v16, v17

    const/16 v17, 0x1

    aput-object v12, v16, v17

    move-object/from16 v0, v16

    invoke-virtual {v9, v15, v0}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v11

    .line 475
    .end local v10    # "relativeClause":Ljava/lang/CharSequence;
    .local v11, "result":Ljava/lang/String;
    :goto_3
    return-object v11

    .line 440
    .end local v4    # "duration":Lorg/joda/time/Duration;
    .end local v6    # "minDuration":Lorg/joda/time/Duration;
    .end local v8    # "past":Z
    .end local v11    # "result":Ljava/lang/String;
    .end local v12    # "timeClause":Ljava/lang/CharSequence;
    .end local v14    # "transitionDuration":Lorg/joda/time/Duration;
    :cond_1
    const/4 v8, 0x0

    goto :goto_0

    .line 441
    .restart local v8    # "past":Z
    :cond_2
    new-instance v4, Lorg/joda/time/Duration;

    invoke-direct {v4, v7, v13}, Lorg/joda/time/Duration;-><init>(Lorg/joda/time/ReadableInstant;Lorg/joda/time/ReadableInstant;)V

    goto :goto_1

    .line 452
    .restart local v4    # "duration":Lorg/joda/time/Duration;
    .restart local v6    # "minDuration":Lorg/joda/time/Duration;
    :cond_3
    if-eqz v8, :cond_4

    invoke-interface/range {p2 .. p2}, Lorg/joda/time/ReadablePeriod;->toPeriod()Lorg/joda/time/Period;

    move-result-object v15

    invoke-virtual {v15, v7}, Lorg/joda/time/Period;->toDurationTo(Lorg/joda/time/ReadableInstant;)Lorg/joda/time/Duration;

    move-result-object v14

    .line 454
    .restart local v14    # "transitionDuration":Lorg/joda/time/Duration;
    :goto_4
    sget-object v15, Lorg/joda/time/Weeks;->ONE:Lorg/joda/time/Weeks;

    invoke-virtual {v15}, Lorg/joda/time/Weeks;->toPeriod()Lorg/joda/time/Period;

    move-result-object v15

    invoke-virtual {v15, v13}, Lorg/joda/time/Period;->toDurationTo(Lorg/joda/time/ReadableInstant;)Lorg/joda/time/Duration;

    move-result-object v5

    .line 455
    .local v5, "maxDuration":Lorg/joda/time/Duration;
    invoke-virtual {v14, v5}, Lorg/joda/time/Duration;->isLongerThan(Lorg/joda/time/ReadableDuration;)Z

    move-result v15

    if-eqz v15, :cond_5

    .line 456
    move-object v14, v5

    goto :goto_2

    .line 453
    .end local v5    # "maxDuration":Lorg/joda/time/Duration;
    .end local v14    # "transitionDuration":Lorg/joda/time/Duration;
    :cond_4
    invoke-interface/range {p2 .. p2}, Lorg/joda/time/ReadablePeriod;->toPeriod()Lorg/joda/time/Period;

    move-result-object v15

    invoke-virtual {v15, v7}, Lorg/joda/time/Period;->toDurationFrom(Lorg/joda/time/ReadableInstant;)Lorg/joda/time/Duration;

    move-result-object v14

    goto :goto_4

    .line 458
    .restart local v5    # "maxDuration":Lorg/joda/time/Duration;
    .restart local v14    # "transitionDuration":Lorg/joda/time/Duration;
    :cond_5
    invoke-virtual {v14, v6}, Lorg/joda/time/Duration;->isShorterThan(Lorg/joda/time/ReadableDuration;)Z

    move-result v15

    if-eqz v15, :cond_0

    .line 459
    move-object v14, v6

    goto :goto_2

    .line 471
    .end local v5    # "maxDuration":Lorg/joda/time/Duration;
    .restart local v12    # "timeClause":Ljava/lang/CharSequence;
    :cond_6
    const/4 v15, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-static {v0, v1, v15}, Lnet/danlew/android/joda/DateUtils;->getRelativeTimeSpanString(Landroid/content/Context;Lorg/joda/time/ReadableInstant;Z)Ljava/lang/CharSequence;

    move-result-object v3

    .line 472
    .local v3, "dateClause":Ljava/lang/CharSequence;
    sget v15, Lnet/danlew/android/joda/R$string;->joda_time_android_date_time:I

    const/16 v16, 0x2

    move/from16 v0, v16

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    aput-object v3, v16, v17

    const/16 v17, 0x1

    aput-object v12, v16, v17

    move-object/from16 v0, v16

    invoke-virtual {v9, v15, v0}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v11

    .restart local v11    # "result":Ljava/lang/String;
    goto :goto_3
.end method

.method public static getRelativeDateTimeString(Landroid/content/Context;Lorg/joda/time/ReadablePartial;Lorg/joda/time/ReadablePeriod;I)Ljava/lang/CharSequence;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "time"    # Lorg/joda/time/ReadablePartial;
    .param p2, "transitionResolution"    # Lorg/joda/time/ReadablePeriod;
    .param p3, "flags"    # I

    .prologue
    .line 408
    invoke-static {}, Lorg/joda/time/DateTimeFieldType;->hourOfDay()Lorg/joda/time/DateTimeFieldType;

    move-result-object v0

    invoke-interface {p1, v0}, Lorg/joda/time/ReadablePartial;->isSupported(Lorg/joda/time/DateTimeFieldType;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 409
    invoke-static {}, Lorg/joda/time/DateTimeFieldType;->minuteOfHour()Lorg/joda/time/DateTimeFieldType;

    move-result-object v0

    invoke-interface {p1, v0}, Lorg/joda/time/ReadablePartial;->isSupported(Lorg/joda/time/DateTimeFieldType;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 410
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "getRelativeDateTimeString() must be passed a ReadablePartial that supports time, otherwise it makes no sense"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 414
    :cond_1
    invoke-static {}, Lorg/joda/time/DateTime;->now()Lorg/joda/time/DateTime;

    move-result-object v0

    invoke-interface {p1, v0}, Lorg/joda/time/ReadablePartial;->toDateTime(Lorg/joda/time/ReadableInstant;)Lorg/joda/time/DateTime;

    move-result-object v0

    invoke-static {p0, v0, p2, p3}, Lnet/danlew/android/joda/DateUtils;->getRelativeDateTimeString(Landroid/content/Context;Lorg/joda/time/ReadableInstant;Lorg/joda/time/ReadablePeriod;I)Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public static getRelativeTimeSpanString(Landroid/content/Context;Lorg/joda/time/ReadableInstant;)Ljava/lang/CharSequence;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "time"    # Lorg/joda/time/ReadableInstant;

    .prologue
    .line 223
    const v0, 0x10014

    .line 224
    .local v0, "flags":I
    invoke-static {p0, p1, v0}, Lnet/danlew/android/joda/DateUtils;->getRelativeTimeSpanString(Landroid/content/Context;Lorg/joda/time/ReadableInstant;I)Ljava/lang/CharSequence;

    move-result-object v1

    return-object v1
.end method

.method public static getRelativeTimeSpanString(Landroid/content/Context;Lorg/joda/time/ReadableInstant;I)Ljava/lang/CharSequence;
    .locals 13
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "time"    # Lorg/joda/time/ReadableInstant;
    .param p2, "flags"    # I

    .prologue
    const/4 v9, 0x1

    const/4 v10, 0x0

    .line 247
    const/high16 v11, 0xc0000

    and-int/2addr v11, p2

    if-eqz v11, :cond_0

    move v0, v9

    .line 250
    .local v0, "abbrevRelative":Z
    :goto_0
    invoke-interface {p1}, Lorg/joda/time/ReadableInstant;->getZone()Lorg/joda/time/DateTimeZone;

    move-result-object v11

    invoke-static {v11}, Lorg/joda/time/DateTime;->now(Lorg/joda/time/DateTimeZone;)Lorg/joda/time/DateTime;

    move-result-object v11

    invoke-virtual {v11, v10}, Lorg/joda/time/DateTime;->withMillisOfSecond(I)Lorg/joda/time/DateTime;

    move-result-object v5

    .line 251
    .local v5, "now":Lorg/joda/time/DateTime;
    new-instance v11, Lorg/joda/time/DateTime;

    invoke-direct {v11, p1}, Lorg/joda/time/DateTime;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v11, v10}, Lorg/joda/time/DateTime;->withMillisOfSecond(I)Lorg/joda/time/DateTime;

    move-result-object v8

    .line 252
    .local v8, "timeDt":Lorg/joda/time/DateTime;
    invoke-virtual {v5, v8}, Lorg/joda/time/DateTime;->isBefore(Lorg/joda/time/ReadableInstant;)Z

    move-result v11

    if-nez v11, :cond_1

    move v6, v9

    .line 253
    .local v6, "past":Z
    :goto_1
    if-eqz v6, :cond_2

    new-instance v4, Lorg/joda/time/Interval;

    invoke-direct {v4, v8, v5}, Lorg/joda/time/Interval;-><init>(Lorg/joda/time/ReadableInstant;Lorg/joda/time/ReadableInstant;)V

    .line 257
    .local v4, "interval":Lorg/joda/time/Interval;
    :goto_2
    invoke-static {v4}, Lorg/joda/time/Minutes;->minutesIn(Lorg/joda/time/ReadableInterval;)Lorg/joda/time/Minutes;

    move-result-object v11

    sget-object v12, Lorg/joda/time/Minutes;->ONE:Lorg/joda/time/Minutes;

    invoke-virtual {v11, v12}, Lorg/joda/time/Minutes;->isLessThan(Lorg/joda/time/Minutes;)Z

    move-result v11

    if-eqz v11, :cond_6

    .line 258
    invoke-static {v4}, Lorg/joda/time/Seconds;->secondsIn(Lorg/joda/time/ReadableInterval;)Lorg/joda/time/Seconds;

    move-result-object v11

    invoke-virtual {v11}, Lorg/joda/time/Seconds;->getSeconds()I

    move-result v11

    int-to-long v2, v11

    .line 259
    .local v2, "count":J
    if-eqz v6, :cond_4

    .line 260
    if-eqz v0, :cond_3

    .line 261
    sget v7, Lnet/danlew/android/joda/R$plurals;->joda_time_android_abbrev_num_seconds_ago:I

    .line 337
    .local v7, "resId":I
    :goto_3
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    long-to-int v12, v2

    invoke-virtual {v11, v7, v12}, Landroid/content/res/Resources;->getQuantityString(II)Ljava/lang/String;

    move-result-object v1

    .line 338
    .local v1, "format":Ljava/lang/String;
    new-array v9, v9, [Ljava/lang/Object;

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-static {v1, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    .end local v1    # "format":Ljava/lang/String;
    .end local v2    # "count":J
    .end local v7    # "resId":I
    :goto_4
    return-object v9

    .end local v0    # "abbrevRelative":Z
    .end local v4    # "interval":Lorg/joda/time/Interval;
    .end local v5    # "now":Lorg/joda/time/DateTime;
    .end local v6    # "past":Z
    .end local v8    # "timeDt":Lorg/joda/time/DateTime;
    :cond_0
    move v0, v10

    .line 247
    goto :goto_0

    .restart local v0    # "abbrevRelative":Z
    .restart local v5    # "now":Lorg/joda/time/DateTime;
    .restart local v8    # "timeDt":Lorg/joda/time/DateTime;
    :cond_1
    move v6, v10

    .line 252
    goto :goto_1

    .line 253
    .restart local v6    # "past":Z
    :cond_2
    new-instance v4, Lorg/joda/time/Interval;

    invoke-direct {v4, v5, v8}, Lorg/joda/time/Interval;-><init>(Lorg/joda/time/ReadableInstant;Lorg/joda/time/ReadableInstant;)V

    goto :goto_2

    .line 264
    .restart local v2    # "count":J
    .restart local v4    # "interval":Lorg/joda/time/Interval;
    :cond_3
    sget v7, Lnet/danlew/android/joda/R$plurals;->joda_time_android_num_seconds_ago:I

    .restart local v7    # "resId":I
    goto :goto_3

    .line 268
    .end local v7    # "resId":I
    :cond_4
    if-eqz v0, :cond_5

    .line 269
    sget v7, Lnet/danlew/android/joda/R$plurals;->joda_time_android_abbrev_in_num_seconds:I

    .restart local v7    # "resId":I
    goto :goto_3

    .line 272
    .end local v7    # "resId":I
    :cond_5
    sget v7, Lnet/danlew/android/joda/R$plurals;->joda_time_android_in_num_seconds:I

    .restart local v7    # "resId":I
    goto :goto_3

    .line 276
    .end local v2    # "count":J
    .end local v7    # "resId":I
    :cond_6
    invoke-static {v4}, Lorg/joda/time/Hours;->hoursIn(Lorg/joda/time/ReadableInterval;)Lorg/joda/time/Hours;

    move-result-object v11

    sget-object v12, Lorg/joda/time/Hours;->ONE:Lorg/joda/time/Hours;

    invoke-virtual {v11, v12}, Lorg/joda/time/Hours;->isLessThan(Lorg/joda/time/Hours;)Z

    move-result v11

    if-eqz v11, :cond_a

    .line 277
    invoke-static {v4}, Lorg/joda/time/Minutes;->minutesIn(Lorg/joda/time/ReadableInterval;)Lorg/joda/time/Minutes;

    move-result-object v11

    invoke-virtual {v11}, Lorg/joda/time/Minutes;->getMinutes()I

    move-result v11

    int-to-long v2, v11

    .line 278
    .restart local v2    # "count":J
    if-eqz v6, :cond_8

    .line 279
    if-eqz v0, :cond_7

    .line 280
    sget v7, Lnet/danlew/android/joda/R$plurals;->joda_time_android_abbrev_num_minutes_ago:I

    .restart local v7    # "resId":I
    goto :goto_3

    .line 283
    .end local v7    # "resId":I
    :cond_7
    sget v7, Lnet/danlew/android/joda/R$plurals;->joda_time_android_num_minutes_ago:I

    .restart local v7    # "resId":I
    goto :goto_3

    .line 287
    .end local v7    # "resId":I
    :cond_8
    if-eqz v0, :cond_9

    .line 288
    sget v7, Lnet/danlew/android/joda/R$plurals;->joda_time_android_abbrev_in_num_minutes:I

    .restart local v7    # "resId":I
    goto :goto_3

    .line 291
    .end local v7    # "resId":I
    :cond_9
    sget v7, Lnet/danlew/android/joda/R$plurals;->joda_time_android_in_num_minutes:I

    .restart local v7    # "resId":I
    goto :goto_3

    .line 295
    .end local v2    # "count":J
    .end local v7    # "resId":I
    :cond_a
    invoke-static {v4}, Lorg/joda/time/Days;->daysIn(Lorg/joda/time/ReadableInterval;)Lorg/joda/time/Days;

    move-result-object v11

    sget-object v12, Lorg/joda/time/Days;->ONE:Lorg/joda/time/Days;

    invoke-virtual {v11, v12}, Lorg/joda/time/Days;->isLessThan(Lorg/joda/time/Days;)Z

    move-result v11

    if-eqz v11, :cond_e

    .line 296
    invoke-static {v4}, Lorg/joda/time/Hours;->hoursIn(Lorg/joda/time/ReadableInterval;)Lorg/joda/time/Hours;

    move-result-object v11

    invoke-virtual {v11}, Lorg/joda/time/Hours;->getHours()I

    move-result v11

    int-to-long v2, v11

    .line 297
    .restart local v2    # "count":J
    if-eqz v6, :cond_c

    .line 298
    if-eqz v0, :cond_b

    .line 299
    sget v7, Lnet/danlew/android/joda/R$plurals;->joda_time_android_abbrev_num_hours_ago:I

    .restart local v7    # "resId":I
    goto :goto_3

    .line 302
    .end local v7    # "resId":I
    :cond_b
    sget v7, Lnet/danlew/android/joda/R$plurals;->joda_time_android_num_hours_ago:I

    .restart local v7    # "resId":I
    goto :goto_3

    .line 306
    .end local v7    # "resId":I
    :cond_c
    if-eqz v0, :cond_d

    .line 307
    sget v7, Lnet/danlew/android/joda/R$plurals;->joda_time_android_abbrev_in_num_hours:I

    .restart local v7    # "resId":I
    goto :goto_3

    .line 310
    .end local v7    # "resId":I
    :cond_d
    sget v7, Lnet/danlew/android/joda/R$plurals;->joda_time_android_in_num_hours:I

    .restart local v7    # "resId":I
    goto :goto_3

    .line 314
    .end local v2    # "count":J
    .end local v7    # "resId":I
    :cond_e
    invoke-static {v4}, Lorg/joda/time/Weeks;->weeksIn(Lorg/joda/time/ReadableInterval;)Lorg/joda/time/Weeks;

    move-result-object v11

    sget-object v12, Lorg/joda/time/Weeks;->ONE:Lorg/joda/time/Weeks;

    invoke-virtual {v11, v12}, Lorg/joda/time/Weeks;->isLessThan(Lorg/joda/time/Weeks;)Z

    move-result v11

    if-eqz v11, :cond_12

    .line 315
    invoke-static {v4}, Lorg/joda/time/Days;->daysIn(Lorg/joda/time/ReadableInterval;)Lorg/joda/time/Days;

    move-result-object v11

    invoke-virtual {v11}, Lorg/joda/time/Days;->getDays()I

    move-result v11

    int-to-long v2, v11

    .line 316
    .restart local v2    # "count":J
    if-eqz v6, :cond_10

    .line 317
    if-eqz v0, :cond_f

    .line 318
    sget v7, Lnet/danlew/android/joda/R$plurals;->joda_time_android_abbrev_num_days_ago:I

    .restart local v7    # "resId":I
    goto/16 :goto_3

    .line 321
    .end local v7    # "resId":I
    :cond_f
    sget v7, Lnet/danlew/android/joda/R$plurals;->joda_time_android_num_days_ago:I

    .restart local v7    # "resId":I
    goto/16 :goto_3

    .line 325
    .end local v7    # "resId":I
    :cond_10
    if-eqz v0, :cond_11

    .line 326
    sget v7, Lnet/danlew/android/joda/R$plurals;->joda_time_android_abbrev_in_num_days:I

    .restart local v7    # "resId":I
    goto/16 :goto_3

    .line 329
    .end local v7    # "resId":I
    :cond_11
    sget v7, Lnet/danlew/android/joda/R$plurals;->joda_time_android_in_num_days:I

    .restart local v7    # "resId":I
    goto/16 :goto_3

    .line 334
    .end local v2    # "count":J
    .end local v7    # "resId":I
    :cond_12
    invoke-static {p0, p1, p1, p2}, Lnet/danlew/android/joda/DateUtils;->formatDateRange(Landroid/content/Context;Lorg/joda/time/ReadableInstant;Lorg/joda/time/ReadableInstant;I)Ljava/lang/String;

    move-result-object v9

    goto/16 :goto_4
.end method

.method public static getRelativeTimeSpanString(Landroid/content/Context;Lorg/joda/time/ReadableInstant;Z)Ljava/lang/CharSequence;
    .locals 7
    .param p0, "ctx"    # Landroid/content/Context;
    .param p1, "time"    # Lorg/joda/time/ReadableInstant;
    .param p2, "withPreposition"    # Z

    .prologue
    .line 365
    invoke-static {}, Lorg/joda/time/LocalDate;->now()Lorg/joda/time/LocalDate;

    move-result-object v1

    .line 366
    .local v1, "now":Lorg/joda/time/LocalDate;
    new-instance v4, Lorg/joda/time/LocalDate;

    invoke-direct {v4, p1}, Lorg/joda/time/LocalDate;-><init>(Ljava/lang/Object;)V

    .line 369
    .local v4, "timeDate":Lorg/joda/time/LocalDate;
    invoke-static {v1, v4}, Lorg/joda/time/Days;->daysBetween(Lorg/joda/time/ReadablePartial;Lorg/joda/time/ReadablePartial;)Lorg/joda/time/Days;

    move-result-object v5

    invoke-virtual {v5}, Lorg/joda/time/Days;->getDays()I

    move-result v5

    if-nez v5, :cond_1

    .line 371
    const/4 v0, 0x1

    .line 372
    .local v0, "flags":I
    invoke-static {p0, p1, p1, v0}, Lnet/danlew/android/joda/DateUtils;->formatDateRange(Landroid/content/Context;Lorg/joda/time/ReadableInstant;Lorg/joda/time/ReadableInstant;I)Ljava/lang/String;

    move-result-object v3

    .line 373
    .local v3, "result":Ljava/lang/String;
    sget v2, Lnet/danlew/android/joda/R$string;->joda_time_android_preposition_for_time:I

    .line 390
    .local v2, "prepositionId":I
    :goto_0
    if-eqz p2, :cond_0

    .line 391
    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object v3, v5, v6

    invoke-virtual {p0, v2, v5}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 394
    :cond_0
    return-object v3

    .line 375
    .end local v0    # "flags":I
    .end local v2    # "prepositionId":I
    .end local v3    # "result":Ljava/lang/String;
    :cond_1
    invoke-static {v1, v4}, Lorg/joda/time/Years;->yearsBetween(Lorg/joda/time/ReadablePartial;Lorg/joda/time/ReadablePartial;)Lorg/joda/time/Years;

    move-result-object v5

    invoke-virtual {v5}, Lorg/joda/time/Years;->getYears()I

    move-result v5

    if-eqz v5, :cond_2

    .line 377
    const v0, 0x20014

    .line 378
    .restart local v0    # "flags":I
    invoke-static {p0, p1, p1, v0}, Lnet/danlew/android/joda/DateUtils;->formatDateRange(Landroid/content/Context;Lorg/joda/time/ReadableInstant;Lorg/joda/time/ReadableInstant;I)Ljava/lang/String;

    move-result-object v3

    .line 381
    .restart local v3    # "result":Ljava/lang/String;
    sget v2, Lnet/danlew/android/joda/R$string;->joda_time_android_preposition_for_date:I

    .line 382
    .restart local v2    # "prepositionId":I
    goto :goto_0

    .line 385
    .end local v0    # "flags":I
    .end local v2    # "prepositionId":I
    .end local v3    # "result":Ljava/lang/String;
    :cond_2
    const v0, 0x10010

    .line 386
    .restart local v0    # "flags":I
    invoke-static {p0, p1, p1, v0}, Lnet/danlew/android/joda/DateUtils;->formatDateRange(Landroid/content/Context;Lorg/joda/time/ReadableInstant;Lorg/joda/time/ReadableInstant;I)Ljava/lang/String;

    move-result-object v3

    .line 387
    .restart local v3    # "result":Ljava/lang/String;
    sget v2, Lnet/danlew/android/joda/R$string;->joda_time_android_preposition_for_date:I

    .restart local v2    # "prepositionId":I
    goto :goto_0
.end method

.method public static getRelativeTimeSpanString(Landroid/content/Context;Lorg/joda/time/ReadablePartial;)Ljava/lang/CharSequence;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "time"    # Lorg/joda/time/ReadablePartial;

    .prologue
    .line 214
    invoke-static {}, Lorg/joda/time/DateTime;->now()Lorg/joda/time/DateTime;

    move-result-object v0

    invoke-interface {p1, v0}, Lorg/joda/time/ReadablePartial;->toDateTime(Lorg/joda/time/ReadableInstant;)Lorg/joda/time/DateTime;

    move-result-object v0

    invoke-static {p0, v0}, Lnet/danlew/android/joda/DateUtils;->getRelativeTimeSpanString(Landroid/content/Context;Lorg/joda/time/ReadableInstant;)Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public static getRelativeTimeSpanString(Landroid/content/Context;Lorg/joda/time/ReadablePartial;I)Ljava/lang/CharSequence;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "time"    # Lorg/joda/time/ReadablePartial;
    .param p2, "flags"    # I

    .prologue
    .line 233
    invoke-static {}, Lorg/joda/time/DateTime;->now()Lorg/joda/time/DateTime;

    move-result-object v0

    invoke-interface {p1, v0}, Lorg/joda/time/ReadablePartial;->toDateTime(Lorg/joda/time/ReadableInstant;)Lorg/joda/time/DateTime;

    move-result-object v0

    invoke-static {p0, v0, p2}, Lnet/danlew/android/joda/DateUtils;->getRelativeTimeSpanString(Landroid/content/Context;Lorg/joda/time/ReadableInstant;I)Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public static getRelativeTimeSpanString(Landroid/content/Context;Lorg/joda/time/ReadablePartial;Z)Ljava/lang/CharSequence;
    .locals 1
    .param p0, "ctx"    # Landroid/content/Context;
    .param p1, "time"    # Lorg/joda/time/ReadablePartial;
    .param p2, "withPreposition"    # Z

    .prologue
    .line 352
    invoke-static {}, Lorg/joda/time/DateTime;->now()Lorg/joda/time/DateTime;

    move-result-object v0

    invoke-interface {p1, v0}, Lorg/joda/time/ReadablePartial;->toDateTime(Lorg/joda/time/ReadableInstant;)Lorg/joda/time/DateTime;

    move-result-object v0

    invoke-static {p0, v0, p2}, Lnet/danlew/android/joda/DateUtils;->getRelativeTimeSpanString(Landroid/content/Context;Lorg/joda/time/ReadableInstant;Z)Ljava/lang/CharSequence;

    move-result-object v0

    return-object v0
.end method

.method public static isToday(Lorg/joda/time/ReadableInstant;)Z
    .locals 2
    .param p0, "time"    # Lorg/joda/time/ReadableInstant;

    .prologue
    .line 203
    invoke-static {}, Lorg/joda/time/LocalDate;->now()Lorg/joda/time/LocalDate;

    move-result-object v0

    new-instance v1, Lorg/joda/time/LocalDate;

    invoke-direct {v1, p0}, Lorg/joda/time/LocalDate;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v0, v1}, Lorg/joda/time/LocalDate;->compareTo(Lorg/joda/time/ReadablePartial;)I

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isToday(Lorg/joda/time/ReadablePartial;)Z
    .locals 3
    .param p0, "time"    # Lorg/joda/time/ReadablePartial;

    .prologue
    .line 186
    invoke-static {}, Lorg/joda/time/DateTimeFieldType;->dayOfMonth()Lorg/joda/time/DateTimeFieldType;

    move-result-object v1

    invoke-interface {p0, v1}, Lorg/joda/time/ReadablePartial;->isSupported(Lorg/joda/time/DateTimeFieldType;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 187
    invoke-static {}, Lorg/joda/time/DateTimeFieldType;->monthOfYear()Lorg/joda/time/DateTimeFieldType;

    move-result-object v1

    invoke-interface {p0, v1}, Lorg/joda/time/ReadablePartial;->isSupported(Lorg/joda/time/DateTimeFieldType;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 188
    invoke-static {}, Lorg/joda/time/DateTimeFieldType;->year()Lorg/joda/time/DateTimeFieldType;

    move-result-object v1

    invoke-interface {p0, v1}, Lorg/joda/time/ReadablePartial;->isSupported(Lorg/joda/time/DateTimeFieldType;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 189
    :cond_0
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "isToday() must be passed a ReadablePartial that supports day of month, month of year and year."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 193
    :cond_1
    instance-of v1, p0, Lorg/joda/time/LocalDate;

    if-eqz v1, :cond_2

    check-cast p0, Lorg/joda/time/LocalDate;

    .end local p0    # "time":Lorg/joda/time/ReadablePartial;
    move-object v0, p0

    .line 194
    .local v0, "localDate":Lorg/joda/time/LocalDate;
    .restart local p0    # "time":Lorg/joda/time/ReadablePartial;
    :goto_0
    invoke-static {}, Lorg/joda/time/LocalDate;->now()Lorg/joda/time/LocalDate;

    .end local p0    # "time":Lorg/joda/time/ReadablePartial;
    move-result-object v1

    invoke-virtual {v1, v0}, Lorg/joda/time/LocalDate;->compareTo(Lorg/joda/time/ReadablePartial;)I

    move-result v1

    if-nez v1, :cond_3

    const/4 v1, 0x1

    :goto_1
    return v1

    .line 193
    .end local v0    # "localDate":Lorg/joda/time/LocalDate;
    .restart local p0    # "time":Lorg/joda/time/ReadablePartial;
    :cond_2
    new-instance v0, Lorg/joda/time/LocalDate;

    invoke-direct {v0, p0}, Lorg/joda/time/LocalDate;-><init>(Ljava/lang/Object;)V

    goto :goto_0

    .line 194
    .end local p0    # "time":Lorg/joda/time/ReadablePartial;
    .restart local v0    # "localDate":Lorg/joda/time/LocalDate;
    :cond_3
    const/4 v1, 0x0

    goto :goto_1
.end method

.method private static toMillis(Lorg/joda/time/ReadableInstant;)J
    .locals 4
    .param p0, "time"    # Lorg/joda/time/ReadableInstant;

    .prologue
    .line 148
    instance-of v2, p0, Lorg/joda/time/DateTime;

    if-eqz v2, :cond_0

    check-cast p0, Lorg/joda/time/DateTime;

    .end local p0    # "time":Lorg/joda/time/ReadableInstant;
    move-object v0, p0

    .line 149
    .local v0, "dateTime":Lorg/joda/time/DateTime;
    .restart local p0    # "time":Lorg/joda/time/ReadableInstant;
    :goto_0
    sget-object v2, Lorg/joda/time/DateTimeZone;->UTC:Lorg/joda/time/DateTimeZone;

    .end local p0    # "time":Lorg/joda/time/ReadableInstant;
    invoke-virtual {v0, v2}, Lorg/joda/time/DateTime;->withZoneRetainFields(Lorg/joda/time/DateTimeZone;)Lorg/joda/time/DateTime;

    move-result-object v1

    .line 150
    .local v1, "utcDateTime":Lorg/joda/time/DateTime;
    invoke-virtual {v1}, Lorg/joda/time/DateTime;->getMillis()J

    move-result-wide v2

    return-wide v2

    .line 148
    .end local v0    # "dateTime":Lorg/joda/time/DateTime;
    .end local v1    # "utcDateTime":Lorg/joda/time/DateTime;
    .restart local p0    # "time":Lorg/joda/time/ReadableInstant;
    :cond_0
    new-instance v0, Lorg/joda/time/DateTime;

    invoke-direct {v0, p0}, Lorg/joda/time/DateTime;-><init>(Ljava/lang/Object;)V

    goto :goto_0
.end method

.method private static toMillis(Lorg/joda/time/ReadablePartial;)J
    .locals 2
    .param p0, "time"    # Lorg/joda/time/ReadablePartial;

    .prologue
    .line 144
    sget-object v0, Lnet/danlew/android/joda/DateUtils;->EPOCH:Lorg/joda/time/DateTime;

    invoke-interface {p0, v0}, Lorg/joda/time/ReadablePartial;->toDateTime(Lorg/joda/time/ReadableInstant;)Lorg/joda/time/DateTime;

    move-result-object v0

    invoke-virtual {v0}, Lorg/joda/time/DateTime;->getMillis()J

    move-result-wide v0

    return-wide v0
.end method
