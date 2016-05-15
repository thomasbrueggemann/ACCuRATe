.class public Lorg/apache/commons/validator/routines/InetAddressValidator;
.super Ljava/lang/Object;
.source "InetAddressValidator.java"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final VALIDATOR:Lorg/apache/commons/validator/routines/InetAddressValidator;


# instance fields
.field private final ipv4Validator:Lorg/apache/commons/validator/routines/RegexValidator;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 47
    new-instance v0, Lorg/apache/commons/validator/routines/InetAddressValidator;

    invoke-direct {v0}, Lorg/apache/commons/validator/routines/InetAddressValidator;-><init>()V

    sput-object v0, Lorg/apache/commons/validator/routines/InetAddressValidator;->VALIDATOR:Lorg/apache/commons/validator/routines/InetAddressValidator;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    new-instance v0, Lorg/apache/commons/validator/routines/RegexValidator;

    const-string v1, "^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$"

    invoke-direct {v0, v1}, Lorg/apache/commons/validator/routines/RegexValidator;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lorg/apache/commons/validator/routines/InetAddressValidator;->ipv4Validator:Lorg/apache/commons/validator/routines/RegexValidator;

    return-void
.end method

.method public static getInstance()Lorg/apache/commons/validator/routines/InetAddressValidator;
    .locals 1

    .prologue
    .line 57
    sget-object v0, Lorg/apache/commons/validator/routines/InetAddressValidator;->VALIDATOR:Lorg/apache/commons/validator/routines/InetAddressValidator;

    return-object v0
.end method


# virtual methods
.method public isValid(Ljava/lang/String;)Z
    .locals 1
    .param p1, "inetAddress"    # Ljava/lang/String;

    .prologue
    .line 66
    invoke-virtual {p0, p1}, Lorg/apache/commons/validator/routines/InetAddressValidator;->isValidInet4Address(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0, p1}, Lorg/apache/commons/validator/routines/InetAddressValidator;->isValidInet6Address(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isValidInet4Address(Ljava/lang/String;)Z
    .locals 8
    .param p1, "inet4Address"    # Ljava/lang/String;

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 76
    iget-object v7, p0, Lorg/apache/commons/validator/routines/InetAddressValidator;->ipv4Validator:Lorg/apache/commons/validator/routines/RegexValidator;

    invoke-virtual {v7, p1}, Lorg/apache/commons/validator/routines/RegexValidator;->match(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 78
    .local v1, "groups":[Ljava/lang/String;
    if-nez v1, :cond_1

    .line 107
    :cond_0
    :goto_0
    return v5

    .line 83
    :cond_1
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    const/4 v7, 0x3

    if-gt v2, v7, :cond_3

    .line 84
    aget-object v4, v1, v2

    .line 85
    .local v4, "ipSegment":Ljava/lang/String;
    if-eqz v4, :cond_0

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v7

    if-eqz v7, :cond_0

    .line 89
    const/4 v3, 0x0

    .line 92
    .local v3, "iIpSegment":I
    :try_start_0
    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    .line 97
    const/16 v7, 0xff

    if-gt v3, v7, :cond_0

    .line 101
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v7

    if-le v7, v6, :cond_2

    const-string v7, "0"

    invoke-virtual {v4, v7}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_0

    .line 83
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 93
    :catch_0
    move-exception v0

    .line 94
    .local v0, "e":Ljava/lang/NumberFormatException;
    goto :goto_0

    .end local v0    # "e":Ljava/lang/NumberFormatException;
    .end local v3    # "iIpSegment":I
    .end local v4    # "ipSegment":Ljava/lang/String;
    :cond_3
    move v5, v6

    .line 107
    goto :goto_0
.end method

.method public isValidInet6Address(Ljava/lang/String;)Z
    .locals 14
    .param p1, "inet6Address"    # Ljava/lang/String;

    .prologue
    const/16 v13, 0x8

    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 118
    const-string v11, "::"

    invoke-virtual {p1, v11}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    .line 119
    .local v0, "containsCompressedZeroes":Z
    if-eqz v0, :cond_1

    const-string v11, "::"

    invoke-virtual {p1, v11}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v11

    const-string v12, "::"

    invoke-virtual {p1, v12}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v12

    if-eq v11, v12, :cond_1

    .line 183
    :cond_0
    :goto_0
    return v9

    .line 122
    :cond_1
    const-string v11, ":"

    invoke-virtual {p1, v11}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_2

    const-string v11, "::"

    invoke-virtual {p1, v11}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_0

    :cond_2
    const-string v11, ":"

    invoke-virtual {p1, v11}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_3

    const-string v11, "::"

    invoke-virtual {p1, v11}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_0

    .line 126
    :cond_3
    const-string v11, ":"

    invoke-virtual {p1, v11}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v7

    .line 127
    .local v7, "octets":[Ljava/lang/String;
    if-eqz v0, :cond_5

    .line 128
    new-instance v6, Ljava/util/ArrayList;

    invoke-static {v7}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v11

    invoke-direct {v6, v11}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 129
    .local v6, "octetList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const-string v11, "::"

    invoke-virtual {p1, v11}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_7

    .line 131
    const-string v11, ""

    invoke-interface {v6, v11}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 135
    :cond_4
    :goto_1
    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v11

    new-array v11, v11, [Ljava/lang/String;

    invoke-interface {v6, v11}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v7

    .end local v7    # "octets":[Ljava/lang/String;
    check-cast v7, [Ljava/lang/String;

    .line 137
    .end local v6    # "octetList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .restart local v7    # "octets":[Ljava/lang/String;
    :cond_5
    array-length v11, v7

    if-gt v11, v13, :cond_0

    .line 140
    const/4 v8, 0x0

    .line 141
    .local v8, "validOctets":I
    const/4 v2, 0x0

    .line 142
    .local v2, "emptyOctets":I
    const/4 v3, 0x0

    .local v3, "index":I
    :goto_2
    array-length v11, v7

    if-ge v3, v11, :cond_a

    .line 143
    aget-object v4, v7, v3

    .line 144
    .local v4, "octet":Ljava/lang/String;
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v11

    if-nez v11, :cond_8

    .line 145
    add-int/lit8 v2, v2, 0x1

    .line 146
    if-gt v2, v10, :cond_0

    .line 178
    :cond_6
    add-int/lit8 v8, v8, 0x1

    .line 142
    :goto_3
    add-int/lit8 v3, v3, 0x1

    goto :goto_2

    .line 132
    .end local v2    # "emptyOctets":I
    .end local v3    # "index":I
    .end local v4    # "octet":Ljava/lang/String;
    .end local v8    # "validOctets":I
    .restart local v6    # "octetList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_7
    const-string v11, "::"

    invoke-virtual {p1, v11}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_4

    invoke-interface {v6}, Ljava/util/List;->isEmpty()Z

    move-result v11

    if-nez v11, :cond_4

    .line 133
    invoke-interface {v6, v9}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    goto :goto_1

    .line 150
    .end local v6    # "octetList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .restart local v2    # "emptyOctets":I
    .restart local v3    # "index":I
    .restart local v4    # "octet":Ljava/lang/String;
    .restart local v8    # "validOctets":I
    :cond_8
    const/4 v2, 0x0

    .line 151
    const-string v11, "."

    invoke-virtual {v4, v11}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v11

    if-eqz v11, :cond_9

    .line 152
    invoke-virtual {p1, v4}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_0

    .line 155
    array-length v11, v7

    add-int/lit8 v11, v11, -0x1

    if-gt v3, v11, :cond_0

    const/4 v11, 0x6

    if-gt v3, v11, :cond_0

    .line 159
    invoke-virtual {p0, v4}, Lorg/apache/commons/validator/routines/InetAddressValidator;->isValidInet4Address(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_0

    .line 162
    add-int/lit8 v8, v8, 0x2

    .line 163
    goto :goto_3

    .line 165
    :cond_9
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v11

    const/4 v12, 0x4

    if-gt v11, v12, :cond_0

    .line 168
    const/4 v5, 0x0

    .line 170
    .local v5, "octetInt":I
    const/16 v11, 0x10

    :try_start_0
    invoke-static {v4, v11}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;I)Ljava/lang/Integer;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Integer;->intValue()I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v5

    .line 174
    if-ltz v5, :cond_0

    const v11, 0xffff

    if-le v5, v11, :cond_6

    goto/16 :goto_0

    .line 171
    :catch_0
    move-exception v1

    .line 172
    .local v1, "e":Ljava/lang/NumberFormatException;
    goto/16 :goto_0

    .line 180
    .end local v1    # "e":Ljava/lang/NumberFormatException;
    .end local v4    # "octet":Ljava/lang/String;
    .end local v5    # "octetInt":I
    :cond_a
    if-ge v8, v13, :cond_b

    if-eqz v0, :cond_0

    :cond_b
    move v9, v10

    .line 183
    goto/16 :goto_0
.end method
