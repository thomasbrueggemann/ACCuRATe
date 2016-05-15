.class public Lorg/apache/commons/lang3/builder/HashCodeBuilder;
.super Ljava/lang/Object;
.source "HashCodeBuilder.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;"
    }
.end annotation


# static fields
.field private static final REGISTRY:Ljava/lang/ThreadLocal;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ThreadLocal",
            "<",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Object;",
            ">;>;"
        }
    .end annotation
.end field


# instance fields
.field private final iConstant:I

.field private iTotal:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 119
    new-instance v0, Ljava/lang/ThreadLocal;

    invoke-direct {v0}, Ljava/lang/ThreadLocal;-><init>()V

    sput-object v0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->REGISTRY:Ljava/lang/ThreadLocal;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 535
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 528
    const/4 v0, 0x0

    iput v0, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    .line 536
    const/16 v0, 0x25

    iput v0, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iConstant:I

    .line 537
    const/16 v0, 0x11

    iput v0, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    .line 538
    return-void
.end method


# virtual methods
.method public append(B)Lorg/apache/commons/lang3/builder/HashCodeBuilder;
    .locals 2
    .param p1, "value"    # B

    .prologue
    .line 622
    iget v0, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    iget v1, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iConstant:I

    mul-int/2addr v0, v1

    add-int/2addr v0, p1

    iput v0, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    .line 623
    return-object p0
.end method

.method public append(C)Lorg/apache/commons/lang3/builder/HashCodeBuilder;
    .locals 2
    .param p1, "value"    # C

    .prologue
    .line 658
    iget v0, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    iget v1, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iConstant:I

    mul-int/2addr v0, v1

    add-int/2addr v0, p1

    iput v0, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    .line 659
    return-object p0
.end method

.method public append(D)Lorg/apache/commons/lang3/builder/HashCodeBuilder;
    .locals 3
    .param p1, "value"    # D

    .prologue
    .line 692
    invoke-static {p1, p2}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v0

    invoke-virtual {p0, v0, v1}, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->append(J)Lorg/apache/commons/lang3/builder/HashCodeBuilder;

    move-result-object v0

    return-object v0
.end method

.method public append(F)Lorg/apache/commons/lang3/builder/HashCodeBuilder;
    .locals 2
    .param p1, "value"    # F

    .prologue
    .line 725
    iget v0, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    iget v1, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iConstant:I

    mul-int/2addr v0, v1

    invoke-static {p1}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v1

    add-int/2addr v0, v1

    iput v0, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    .line 726
    return-object p0
.end method

.method public append(I)Lorg/apache/commons/lang3/builder/HashCodeBuilder;
    .locals 2
    .param p1, "value"    # I

    .prologue
    .line 759
    iget v0, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    iget v1, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iConstant:I

    mul-int/2addr v0, v1

    add-int/2addr v0, p1

    iput v0, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    .line 760
    return-object p0
.end method

.method public append(J)Lorg/apache/commons/lang3/builder/HashCodeBuilder;
    .locals 5
    .param p1, "value"    # J

    .prologue
    .line 797
    iget v0, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    iget v1, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iConstant:I

    mul-int/2addr v0, v1

    const/16 v1, 0x20

    shr-long v2, p1, v1

    xor-long/2addr v2, p1

    long-to-int v1, v2

    add-int/2addr v0, v1

    iput v0, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    .line 798
    return-object p0
.end method

.method public append(Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/HashCodeBuilder;
    .locals 2
    .param p1, "object"    # Ljava/lang/Object;

    .prologue
    .line 831
    if-nez p1, :cond_0

    .line 832
    iget v0, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    iget v1, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iConstant:I

    mul-int/2addr v0, v1

    iput v0, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    .line 862
    .end local p1    # "object":Ljava/lang/Object;
    :goto_0
    return-object p0

    .line 835
    .restart local p1    # "object":Ljava/lang/Object;
    :cond_0
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->isArray()Z

    move-result v0

    if-eqz v0, :cond_9

    .line 838
    instance-of v0, p1, [J

    if-eqz v0, :cond_1

    .line 839
    check-cast p1, [J

    .end local p1    # "object":Ljava/lang/Object;
    check-cast p1, [J

    invoke-virtual {p0, p1}, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->append([J)Lorg/apache/commons/lang3/builder/HashCodeBuilder;

    goto :goto_0

    .line 840
    .restart local p1    # "object":Ljava/lang/Object;
    :cond_1
    instance-of v0, p1, [I

    if-eqz v0, :cond_2

    .line 841
    check-cast p1, [I

    .end local p1    # "object":Ljava/lang/Object;
    check-cast p1, [I

    invoke-virtual {p0, p1}, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->append([I)Lorg/apache/commons/lang3/builder/HashCodeBuilder;

    goto :goto_0

    .line 842
    .restart local p1    # "object":Ljava/lang/Object;
    :cond_2
    instance-of v0, p1, [S

    if-eqz v0, :cond_3

    .line 843
    check-cast p1, [S

    .end local p1    # "object":Ljava/lang/Object;
    check-cast p1, [S

    invoke-virtual {p0, p1}, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->append([S)Lorg/apache/commons/lang3/builder/HashCodeBuilder;

    goto :goto_0

    .line 844
    .restart local p1    # "object":Ljava/lang/Object;
    :cond_3
    instance-of v0, p1, [C

    if-eqz v0, :cond_4

    .line 845
    check-cast p1, [C

    .end local p1    # "object":Ljava/lang/Object;
    check-cast p1, [C

    invoke-virtual {p0, p1}, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->append([C)Lorg/apache/commons/lang3/builder/HashCodeBuilder;

    goto :goto_0

    .line 846
    .restart local p1    # "object":Ljava/lang/Object;
    :cond_4
    instance-of v0, p1, [B

    if-eqz v0, :cond_5

    .line 847
    check-cast p1, [B

    .end local p1    # "object":Ljava/lang/Object;
    check-cast p1, [B

    invoke-virtual {p0, p1}, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->append([B)Lorg/apache/commons/lang3/builder/HashCodeBuilder;

    goto :goto_0

    .line 848
    .restart local p1    # "object":Ljava/lang/Object;
    :cond_5
    instance-of v0, p1, [D

    if-eqz v0, :cond_6

    .line 849
    check-cast p1, [D

    .end local p1    # "object":Ljava/lang/Object;
    check-cast p1, [D

    invoke-virtual {p0, p1}, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->append([D)Lorg/apache/commons/lang3/builder/HashCodeBuilder;

    goto :goto_0

    .line 850
    .restart local p1    # "object":Ljava/lang/Object;
    :cond_6
    instance-of v0, p1, [F

    if-eqz v0, :cond_7

    .line 851
    check-cast p1, [F

    .end local p1    # "object":Ljava/lang/Object;
    check-cast p1, [F

    invoke-virtual {p0, p1}, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->append([F)Lorg/apache/commons/lang3/builder/HashCodeBuilder;

    goto :goto_0

    .line 852
    .restart local p1    # "object":Ljava/lang/Object;
    :cond_7
    instance-of v0, p1, [Z

    if-eqz v0, :cond_8

    .line 853
    check-cast p1, [Z

    .end local p1    # "object":Ljava/lang/Object;
    check-cast p1, [Z

    invoke-virtual {p0, p1}, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->append([Z)Lorg/apache/commons/lang3/builder/HashCodeBuilder;

    goto :goto_0

    .line 856
    .restart local p1    # "object":Ljava/lang/Object;
    :cond_8
    check-cast p1, [Ljava/lang/Object;

    .end local p1    # "object":Ljava/lang/Object;
    check-cast p1, [Ljava/lang/Object;

    invoke-virtual {p0, p1}, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->append([Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/HashCodeBuilder;

    goto :goto_0

    .line 859
    .restart local p1    # "object":Ljava/lang/Object;
    :cond_9
    iget v0, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    iget v1, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iConstant:I

    mul-int/2addr v0, v1

    invoke-virtual {p1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    add-int/2addr v0, v1

    iput v0, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    goto :goto_0
.end method

.method public append(S)Lorg/apache/commons/lang3/builder/HashCodeBuilder;
    .locals 2
    .param p1, "value"    # S

    .prologue
    .line 895
    iget v0, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    iget v1, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iConstant:I

    mul-int/2addr v0, v1

    add-int/2addr v0, p1

    iput v0, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    .line 896
    return-object p0
.end method

.method public append(Z)Lorg/apache/commons/lang3/builder/HashCodeBuilder;
    .locals 2
    .param p1, "value"    # Z

    .prologue
    .line 586
    iget v0, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    iget v1, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iConstant:I

    mul-int/2addr v1, v0

    if-eqz p1, :cond_0

    const/4 v0, 0x0

    :goto_0
    add-int/2addr v0, v1

    iput v0, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    .line 587
    return-object p0

    .line 586
    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public append([B)Lorg/apache/commons/lang3/builder/HashCodeBuilder;
    .locals 6
    .param p1, "array"    # [B

    .prologue
    .line 638
    if-nez p1, :cond_1

    .line 639
    iget v4, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    iget v5, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iConstant:I

    mul-int/2addr v4, v5

    iput v4, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    .line 645
    :cond_0
    return-object p0

    .line 641
    :cond_1
    move-object v0, p1

    .local v0, "arr$":[B
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-byte v1, v0, v2

    .line 642
    .local v1, "element":B
    invoke-virtual {p0, v1}, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->append(B)Lorg/apache/commons/lang3/builder/HashCodeBuilder;

    .line 641
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method public append([C)Lorg/apache/commons/lang3/builder/HashCodeBuilder;
    .locals 6
    .param p1, "array"    # [C

    .prologue
    .line 672
    if-nez p1, :cond_1

    .line 673
    iget v4, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    iget v5, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iConstant:I

    mul-int/2addr v4, v5

    iput v4, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    .line 679
    :cond_0
    return-object p0

    .line 675
    :cond_1
    move-object v0, p1

    .local v0, "arr$":[C
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-char v1, v0, v2

    .line 676
    .local v1, "element":C
    invoke-virtual {p0, v1}, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->append(C)Lorg/apache/commons/lang3/builder/HashCodeBuilder;

    .line 675
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method public append([D)Lorg/apache/commons/lang3/builder/HashCodeBuilder;
    .locals 7
    .param p1, "array"    # [D

    .prologue
    .line 705
    if-nez p1, :cond_1

    .line 706
    iget v5, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    iget v6, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iConstant:I

    mul-int/2addr v5, v6

    iput v5, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    .line 712
    :cond_0
    return-object p0

    .line 708
    :cond_1
    move-object v0, p1

    .local v0, "arr$":[D
    array-length v4, v0

    .local v4, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v4, :cond_0

    aget-wide v2, v0, v1

    .line 709
    .local v2, "element":D
    invoke-virtual {p0, v2, v3}, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->append(D)Lorg/apache/commons/lang3/builder/HashCodeBuilder;

    .line 708
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method public append([F)Lorg/apache/commons/lang3/builder/HashCodeBuilder;
    .locals 6
    .param p1, "array"    # [F

    .prologue
    .line 739
    if-nez p1, :cond_1

    .line 740
    iget v4, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    iget v5, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iConstant:I

    mul-int/2addr v4, v5

    iput v4, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    .line 746
    :cond_0
    return-object p0

    .line 742
    :cond_1
    move-object v0, p1

    .local v0, "arr$":[F
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget v1, v0, v2

    .line 743
    .local v1, "element":F
    invoke-virtual {p0, v1}, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->append(F)Lorg/apache/commons/lang3/builder/HashCodeBuilder;

    .line 742
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method public append([I)Lorg/apache/commons/lang3/builder/HashCodeBuilder;
    .locals 6
    .param p1, "array"    # [I

    .prologue
    .line 773
    if-nez p1, :cond_1

    .line 774
    iget v4, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    iget v5, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iConstant:I

    mul-int/2addr v4, v5

    iput v4, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    .line 780
    :cond_0
    return-object p0

    .line 776
    :cond_1
    move-object v0, p1

    .local v0, "arr$":[I
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget v1, v0, v2

    .line 777
    .local v1, "element":I
    invoke-virtual {p0, v1}, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->append(I)Lorg/apache/commons/lang3/builder/HashCodeBuilder;

    .line 776
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method public append([J)Lorg/apache/commons/lang3/builder/HashCodeBuilder;
    .locals 7
    .param p1, "array"    # [J

    .prologue
    .line 811
    if-nez p1, :cond_1

    .line 812
    iget v5, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    iget v6, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iConstant:I

    mul-int/2addr v5, v6

    iput v5, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    .line 818
    :cond_0
    return-object p0

    .line 814
    :cond_1
    move-object v0, p1

    .local v0, "arr$":[J
    array-length v4, v0

    .local v4, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v4, :cond_0

    aget-wide v2, v0, v1

    .line 815
    .local v2, "element":J
    invoke-virtual {p0, v2, v3}, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->append(J)Lorg/apache/commons/lang3/builder/HashCodeBuilder;

    .line 814
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method public append([Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/HashCodeBuilder;
    .locals 6
    .param p1, "array"    # [Ljava/lang/Object;

    .prologue
    .line 875
    if-nez p1, :cond_1

    .line 876
    iget v4, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    iget v5, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iConstant:I

    mul-int/2addr v4, v5

    iput v4, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    .line 882
    :cond_0
    return-object p0

    .line 878
    :cond_1
    move-object v0, p1

    .local v0, "arr$":[Ljava/lang/Object;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v1, v0, v2

    .line 879
    .local v1, "element":Ljava/lang/Object;
    invoke-virtual {p0, v1}, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->append(Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/HashCodeBuilder;

    .line 878
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method public append([S)Lorg/apache/commons/lang3/builder/HashCodeBuilder;
    .locals 6
    .param p1, "array"    # [S

    .prologue
    .line 909
    if-nez p1, :cond_1

    .line 910
    iget v4, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    iget v5, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iConstant:I

    mul-int/2addr v4, v5

    iput v4, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    .line 916
    :cond_0
    return-object p0

    .line 912
    :cond_1
    move-object v0, p1

    .local v0, "arr$":[S
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-short v1, v0, v2

    .line 913
    .local v1, "element":S
    invoke-virtual {p0, v1}, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->append(S)Lorg/apache/commons/lang3/builder/HashCodeBuilder;

    .line 912
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method public append([Z)Lorg/apache/commons/lang3/builder/HashCodeBuilder;
    .locals 6
    .param p1, "array"    # [Z

    .prologue
    .line 600
    if-nez p1, :cond_1

    .line 601
    iget v4, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    iget v5, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iConstant:I

    mul-int/2addr v4, v5

    iput v4, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    .line 607
    :cond_0
    return-object p0

    .line 603
    :cond_1
    move-object v0, p1

    .local v0, "arr$":[Z
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-boolean v1, v0, v2

    .line 604
    .local v1, "element":Z
    invoke-virtual {p0, v1}, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->append(Z)Lorg/apache/commons/lang3/builder/HashCodeBuilder;

    .line 603
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 968
    invoke-virtual {p0}, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->toHashCode()I

    move-result v0

    return v0
.end method

.method public toHashCode()I
    .locals 1

    .prologue
    .line 942
    iget v0, p0, Lorg/apache/commons/lang3/builder/HashCodeBuilder;->iTotal:I

    return v0
.end method
