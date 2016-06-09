.class public Lorg/apache/commons/validator/routines/EmailValidator;
.super Ljava/lang/Object;
.source "EmailValidator.java"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final EMAIL_PATTERN:Ljava/util/regex/Pattern;

.field private static final EMAIL_VALIDATOR:Lorg/apache/commons/validator/routines/EmailValidator;

.field private static final EMAIL_VALIDATOR_WITH_LOCAL:Lorg/apache/commons/validator/routines/EmailValidator;

.field private static final EMAIL_VALIDATOR_WITH_LOCAL_WITH_TLD:Lorg/apache/commons/validator/routines/EmailValidator;

.field private static final EMAIL_VALIDATOR_WITH_TLD:Lorg/apache/commons/validator/routines/EmailValidator;

.field private static final IP_DOMAIN_PATTERN:Ljava/util/regex/Pattern;

.field private static final USER_PATTERN:Ljava/util/regex/Pattern;


# instance fields
.field private final allowLocal:Z

.field private final allowTld:Z


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 49
    const-string v0, "^\\s*?(.+)@(.+?)\\s*$"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/validator/routines/EmailValidator;->EMAIL_PATTERN:Ljava/util/regex/Pattern;

    .line 50
    const-string v0, "^\\[(.*)\\]$"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/validator/routines/EmailValidator;->IP_DOMAIN_PATTERN:Ljava/util/regex/Pattern;

    .line 51
    const-string v0, "^\\s*(((\\\\.)|[^\\s\\p{Cntrl}\\(\\)<>@,;:\'\\\\\\\"\\.\\[\\]]|\')+|(\"[^\"]*\"))(\\.(((\\\\.)|[^\\s\\p{Cntrl}\\(\\)<>@,;:\'\\\\\\\"\\.\\[\\]]|\')+|(\"[^\"]*\")))*$"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/validator/routines/EmailValidator;->USER_PATTERN:Ljava/util/regex/Pattern;

    .line 60
    new-instance v0, Lorg/apache/commons/validator/routines/EmailValidator;

    invoke-direct {v0, v1, v1}, Lorg/apache/commons/validator/routines/EmailValidator;-><init>(ZZ)V

    sput-object v0, Lorg/apache/commons/validator/routines/EmailValidator;->EMAIL_VALIDATOR:Lorg/apache/commons/validator/routines/EmailValidator;

    .line 66
    new-instance v0, Lorg/apache/commons/validator/routines/EmailValidator;

    invoke-direct {v0, v1, v2}, Lorg/apache/commons/validator/routines/EmailValidator;-><init>(ZZ)V

    sput-object v0, Lorg/apache/commons/validator/routines/EmailValidator;->EMAIL_VALIDATOR_WITH_TLD:Lorg/apache/commons/validator/routines/EmailValidator;

    .line 72
    new-instance v0, Lorg/apache/commons/validator/routines/EmailValidator;

    invoke-direct {v0, v2, v1}, Lorg/apache/commons/validator/routines/EmailValidator;-><init>(ZZ)V

    sput-object v0, Lorg/apache/commons/validator/routines/EmailValidator;->EMAIL_VALIDATOR_WITH_LOCAL:Lorg/apache/commons/validator/routines/EmailValidator;

    .line 79
    new-instance v0, Lorg/apache/commons/validator/routines/EmailValidator;

    invoke-direct {v0, v2, v2}, Lorg/apache/commons/validator/routines/EmailValidator;-><init>(ZZ)V

    sput-object v0, Lorg/apache/commons/validator/routines/EmailValidator;->EMAIL_VALIDATOR_WITH_LOCAL_WITH_TLD:Lorg/apache/commons/validator/routines/EmailValidator;

    return-void
.end method

.method protected constructor <init>(ZZ)V
    .locals 0
    .param p1, "allowLocal"    # Z
    .param p2, "allowTld"    # Z

    .prologue
    .line 130
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 131
    iput-boolean p1, p0, Lorg/apache/commons/validator/routines/EmailValidator;->allowLocal:Z

    .line 132
    iput-boolean p2, p0, Lorg/apache/commons/validator/routines/EmailValidator;->allowTld:Z

    .line 133
    return-void
.end method

.method public static getInstance()Lorg/apache/commons/validator/routines/EmailValidator;
    .locals 1

    .prologue
    .line 87
    sget-object v0, Lorg/apache/commons/validator/routines/EmailValidator;->EMAIL_VALIDATOR:Lorg/apache/commons/validator/routines/EmailValidator;

    return-object v0
.end method


# virtual methods
.method public isValid(Ljava/lang/String;)Z
    .locals 4
    .param p1, "email"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 154
    if-nez p1, :cond_1

    .line 176
    :cond_0
    :goto_0
    return v1

    .line 158
    :cond_1
    const-string v3, "."

    invoke-virtual {p1, v3}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 163
    sget-object v3, Lorg/apache/commons/validator/routines/EmailValidator;->EMAIL_PATTERN:Ljava/util/regex/Pattern;

    invoke-virtual {v3, p1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    .line 164
    .local v0, "emailMatcher":Ljava/util/regex/Matcher;
    invoke-virtual {v0}, Ljava/util/regex/Matcher;->matches()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 168
    invoke-virtual {v0, v2}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3}, Lorg/apache/commons/validator/routines/EmailValidator;->isValidUser(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 172
    const/4 v3, 0x2

    invoke-virtual {v0, v3}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3}, Lorg/apache/commons/validator/routines/EmailValidator;->isValidDomain(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    move v1, v2

    .line 176
    goto :goto_0
.end method

.method protected isValidDomain(Ljava/lang/String;)Z
    .locals 5
    .param p1, "domain"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x1

    .line 187
    sget-object v4, Lorg/apache/commons/validator/routines/EmailValidator;->IP_DOMAIN_PATTERN:Ljava/util/regex/Pattern;

    invoke-virtual {v4, p1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v2

    .line 189
    .local v2, "ipDomainMatcher":Ljava/util/regex/Matcher;
    invoke-virtual {v2}, Ljava/util/regex/Matcher;->matches()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 190
    invoke-static {}, Lorg/apache/commons/validator/routines/InetAddressValidator;->getInstance()Lorg/apache/commons/validator/routines/InetAddressValidator;

    move-result-object v1

    .line 192
    .local v1, "inetAddressValidator":Lorg/apache/commons/validator/routines/InetAddressValidator;
    invoke-virtual {v2, v3}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lorg/apache/commons/validator/routines/InetAddressValidator;->isValid(Ljava/lang/String;)Z

    move-result v3

    .line 200
    .end local v1    # "inetAddressValidator":Lorg/apache/commons/validator/routines/InetAddressValidator;
    :cond_0
    :goto_0
    return v3

    .line 195
    :cond_1
    iget-boolean v4, p0, Lorg/apache/commons/validator/routines/EmailValidator;->allowLocal:Z

    invoke-static {v4}, Lorg/apache/commons/validator/routines/DomainValidator;->getInstance(Z)Lorg/apache/commons/validator/routines/DomainValidator;

    move-result-object v0

    .line 197
    .local v0, "domainValidator":Lorg/apache/commons/validator/routines/DomainValidator;
    iget-boolean v4, p0, Lorg/apache/commons/validator/routines/EmailValidator;->allowTld:Z

    if-eqz v4, :cond_2

    .line 198
    invoke-virtual {v0, p1}, Lorg/apache/commons/validator/routines/DomainValidator;->isValid(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    invoke-virtual {v0, p1}, Lorg/apache/commons/validator/routines/DomainValidator;->isValidTld(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    const/4 v3, 0x0

    goto :goto_0

    .line 200
    :cond_2
    invoke-virtual {v0, p1}, Lorg/apache/commons/validator/routines/DomainValidator;->isValid(Ljava/lang/String;)Z

    move-result v3

    goto :goto_0
.end method

.method protected isValidUser(Ljava/lang/String;)Z
    .locals 2
    .param p1, "user"    # Ljava/lang/String;

    .prologue
    .line 212
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v1, 0x40

    if-le v0, v1, :cond_1

    .line 213
    :cond_0
    const/4 v0, 0x0

    .line 216
    :goto_0
    return v0

    :cond_1
    sget-object v0, Lorg/apache/commons/validator/routines/EmailValidator;->USER_PATTERN:Ljava/util/regex/Pattern;

    invoke-virtual {v0, p1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/regex/Matcher;->matches()Z

    move-result v0

    goto :goto_0
.end method
