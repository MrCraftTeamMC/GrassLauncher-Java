# GrassLauncher.Core
[English](./Readme.md) | 中文

## 介绍
GrassLauncher 的核心代码部分。

## 用法
你可以 [Maven](https://maven.apache.org) 或 [Gradle](https://gradle.org)。

```pom.xml
<repositories>
    <repository>
        <id>github-packages</id>
        <name>GitHub Packages</name>
        <url>https://maven.pkg.github.com/MrCraftTeamMC/GrassLauncher</url>
    </repository>
    <repository>
        <id>jitpack</id>
        <name>Jitpack</name>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <!-- For GitHub-Packages Repo -->
    <dependency>
        <groupId>xyz.mrcraftteammc.grasslauncher</groupId>
        <artifactId>GrassLauncher-Core</artifactId>
        <version>1.0.0-SNAPSHOT</version>
    </dependency>

    <!-- For Jitpack Repo -->
    <dependency>
        <groupId>com.github.mrcraftteammc.grasslauncher</groupId>
        <artifactId>GrassLauncher-Core</artifactId>
        <version>1.0.0-SNAPSHOT</version>
    </dependency>
</dependencies>
```

```gradle
repositories {
    maven {
        name = "github-packages"
        url = "https://maven.pkg.github.com/MrCraftTeamMC/GrassLauncher"
    }
    maven {
        name = "jitpack"
        url = "https://jitpack.io"
    }
}

dependencies {
    // For GitHub-Packages Repository
    implementation "xyz.mrcraftteammc.grasslauncher:GrassLauncher-Core:1.0.0-SNAPSHOT"
    
    // For Jitpack Repository
    implementation "com.github.mrcraftteammc.grasslauncher:GrassLauncher-Core:1.0.0-SNAPSHOT"
}
```

