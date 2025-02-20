repositories {
    mavenCentral()
    maven("https://repo.nightexpressdev.com/releases")
}
dependencies {
    implementation("su.nightexpress.excellentcrates:ExcellentCrates:6.0.1")
}

plugins {
    kotlin("jvm") version "2.0.21"
    id("com.typewritermc.module-plugin") version "1.1.3"
}

group = "fr.xania"
version = "1.0"

typewriter {
    namespace = "legendsofxania"

    extension {
        name = "ExcellentCraets"
        shortDescription = "Add ExcellentCrates supports to TypeWriter"
        description = """
            |A quest journal for Typewriter that allows players to view and manage their quests
            |in a single menu, organized by status and tracking progress.
            |Create by the Legends of Xania.
            """.trimMargin()
        engineVersion = "0.8.0-beta-153"
        channel = com.typewritermc.moduleplugin.ReleaseChannel.BETA

        dependencies {}

        paper {
            dependency("ExcellentCrates")
        }
    }
}
kotlin {
    jvmToolchain(21)
}
