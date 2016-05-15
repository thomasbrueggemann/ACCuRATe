.class public Lorg/apache/commons/validator/routines/RegexValidator;
.super Ljava/lang/Object;
.source "RegexValidator.java"

# interfaces
.implements Ljava/io/Serializable;


# instance fields
.field private final patterns:[Ljava/util/regex/Pattern;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "regex"    # Ljava/lang/String;

    .prologue
    .line 84
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Lorg/apache/commons/validator/routines/RegexValidator;-><init>(Ljava/lang/String;Z)V

    .line 85
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 2
    .param p1, "regex"    # Ljava/lang/String;
    .param p2, "caseSensitive"    # Z

    .prologue
    .line 97
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    aput-object p1, v0, v1

    invoke-direct {p0, v0, p2}, Lorg/apache/commons/validator/routines/RegexValidator;-><init>([Ljava/lang/String;Z)V

    .line 98
    return-void
.end method

.method public constructor <init>([Ljava/lang/String;Z)V
    .locals 5
    .param p1, "regexs"    # [Ljava/lang/String;
    .param p2, "caseSensitive"    # Z

    .prologue
    .line 120
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 121
    if-eqz p1, :cond_0

    array-length v2, p1

    if-nez v2, :cond_1

    .line 122
    :cond_0
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "Regular expressions are missing"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 124
    :cond_1
    array-length v2, p1

    new-array v2, v2, [Ljava/util/regex/Pattern;

    iput-object v2, p0, Lorg/apache/commons/validator/routines/RegexValidator;->patterns:[Ljava/util/regex/Pattern;

    .line 125
    if-eqz p2, :cond_3

    const/4 v0, 0x0

    .line 126
    .local v0, "flags":I
    :goto_0
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    array-length v2, p1

    if-ge v1, v2, :cond_5

    .line 127
    aget-object v2, p1, v1

    if-eqz v2, :cond_2

    aget-object v2, p1, v1

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    if-nez v2, :cond_4

    .line 128
    :cond_2
    new-instance v2, Ljava/lang/IllegalArgumentException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Regular expression["

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "] is missing"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 125
    .end local v0    # "flags":I
    .end local v1    # "i":I
    :cond_3
    const/4 v0, 0x2

    goto :goto_0

    .line 130
    .restart local v0    # "flags":I
    .restart local v1    # "i":I
    :cond_4
    iget-object v2, p0, Lorg/apache/commons/validator/routines/RegexValidator;->patterns:[Ljava/util/regex/Pattern;

    aget-object v3, p1, v1

    invoke-static {v3, v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;I)Ljava/util/regex/Pattern;

    move-result-object v3

    aput-object v3, v2, v1

    .line 126
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 132
    :cond_5
    return-void
.end method


# virtual methods
.method public isValid(Ljava/lang/String;)Z
    .locals 3
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 142
    if-nez p1, :cond_1

    .line 150
    :cond_0
    :goto_0
    return v1

    .line 145
    :cond_1
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    iget-object v2, p0, Lorg/apache/commons/validator/routines/RegexValidator;->patterns:[Ljava/util/regex/Pattern;

    array-length v2, v2

    if-ge v0, v2, :cond_0

    .line 146
    iget-object v2, p0, Lorg/apache/commons/validator/routines/RegexValidator;->patterns:[Ljava/util/regex/Pattern;

    aget-object v2, v2, v0

    invoke-virtual {v2, p1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/regex/Matcher;->matches()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 147
    const/4 v1, 0x1

    goto :goto_0

    .line 145
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method public match(Ljava/lang/String;)[Ljava/lang/String;
    .locals 6
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 162
    if-nez p1, :cond_1

    .line 176
    :cond_0
    return-object v1

    .line 165
    :cond_1
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    iget-object v5, p0, Lorg/apache/commons/validator/routines/RegexValidator;->patterns:[Ljava/util/regex/Pattern;

    array-length v5, v5

    if-ge v2, v5, :cond_0

    .line 166
    iget-object v5, p0, Lorg/apache/commons/validator/routines/RegexValidator;->patterns:[Ljava/util/regex/Pattern;

    aget-object v5, v5, v2

    invoke-virtual {v5, p1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v4

    .line 167
    .local v4, "matcher":Ljava/util/regex/Matcher;
    invoke-virtual {v4}, Ljava/util/regex/Matcher;->matches()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 168
    invoke-virtual {v4}, Ljava/util/regex/Matcher;->groupCount()I

    move-result v0

    .line 169
    .local v0, "count":I
    new-array v1, v0, [Ljava/lang/String;

    .line 170
    .local v1, "groups":[Ljava/lang/String;
    const/4 v3, 0x0

    .local v3, "j":I
    :goto_1
    if-ge v3, v0, :cond_0

    .line 171
    add-int/lit8 v5, v3, 0x1

    invoke-virtual {v4, v5}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v1, v3

    .line 170
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 165
    .end local v0    # "count":I
    .end local v1    # "groups":[Ljava/lang/String;
    .end local v3    # "j":I
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 217
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 218
    .local v0, "buffer":Ljava/lang/StringBuilder;
    const-string v2, "RegexValidator{"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 219
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lorg/apache/commons/validator/routines/RegexValidator;->patterns:[Ljava/util/regex/Pattern;

    array-length v2, v2

    if-ge v1, v2, :cond_1

    .line 220
    if-lez v1, :cond_0

    .line 221
    const-string v2, ","

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 223
    :cond_0
    iget-object v2, p0, Lorg/apache/commons/validator/routines/RegexValidator;->patterns:[Ljava/util/regex/Pattern;

    aget-object v2, v2, v1

    invoke-virtual {v2}, Ljava/util/regex/Pattern;->pattern()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 219
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 225
    :cond_1
    const-string v2, "}"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 226
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method
