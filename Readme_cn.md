# GrassLauncher

![GitHub Actions Workflow Status](https://img.shields.io/github/actions/workflow/status/MrCraftTeamMC/GrassLauncher/ci.yml)
![GitHub Downloads (all assets, all releases)](https://img.shields.io/github/downloads/MrCraftTeamMC/GrassLauncher/total)
![GitHub Release](https://img.shields.io/github/v/release/MrCraftTeamMC/GrassLauncher)

[![Jitpack Maven Release](https://jitpack.io/v/MrCraftTeamMC/GrassLauncher-Java.svg)](https://jitpack.io/#MrCraftTeamMC/GrassLauncher-Java)

[English](./Readme.md) | 中文

## 介绍
一个简单、跨平台的 MC 开服器。

使用 Java 编写。UI 是基于 `javax.swing` 和 `java.awt`。

更多信息请查看 Wiki。

## 下载
点击 `Release` 然后再找最新版（`Latest`）下载即可。

## 贡献
如果你是玩家，你可以提交关于 bug，功能等的 Issues。

欢迎 Fork 和提交 PR。

### 编译
请使用 [Intellij IDEA](https://www.jetbrains.com/idea) 和 Java 8及以上 版本。

1. 下载仓库的 Zip 
2. 解压那个 zip
3. 在仓库的根目录下运行这里的命令：
```shell
# For OSX / Linux

./gradlew clean shadowJar --stacktrace --no-daemon
```

```bat
rem For Windows

.\gradlew.bat clean shadowJar --stacktrace --no-daemon
```

然后，你可以`ClientLauncher` 和 `ServerLauncher`里的 `build/libs` 中获得可运行的 jar。 (文件名以`-all`结尾)

## 许可证
本项目的许可证为 [GPL v3](./LICENSE)。
