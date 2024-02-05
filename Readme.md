# GrassLauncher

![GitHub Actions Workflow Status](https://img.shields.io/github/actions/workflow/status/MrCraftTeamMC/GrassLauncher/ci.yml)
![GitHub Downloads (all assets, all releases)](https://img.shields.io/github/downloads/MrCraftTeamMC/GrassLauncher/total)
![GitHub Release](https://img.shields.io/github/v/release/MrCraftTeamMC/GrassLauncher)

English | [中文](./Readme_cn.md)

## Introduction
A simple cross-platform Minecraft Launcher (include client and server).

Made with Java. UI is based in `javax.swing` and `java.awt`.

For more details, please see the wiki page.

## Download
Check the `Release` page in the repository.

## Contribution
If you are player, you can commit issues for bugs, enhancements and so on.

For developers, forking this repository and committing PR are welcome.

### Compilation
Please use [Intellij IDEA](https://www.jetbrains.com/idea) and Java 8+ to build.

1. Download the Zip of the repository.
2. Unzip it.
3. Execute the commands here in project root directory:
```shell
# For OSX / Linux

./gradlew clean shadowJar --stacktrace --no-daemon
```

```bat
rem For Windows

.\gradlew.bat clean shadowJar --stacktrace --no-daemon
```

Then you can find the jar ends with `-full` in `build/libs` dir of project `ClientLauncher` and `ServerLauncher`.

## License
This project is under [GNU General Public License v3](./LICENSE).
