plugins {
    id("java")
    id("dev.architectury.loom") version("1.2-SNAPSHOT")
    id("architectury-plugin") version("3.4-SNAPSHOT")
    kotlin("jvm") version ("1.7.10")
}

group = "org.example"
version = "1.0.0-SNAPSHOT"

architectury {
    platformSetupLoomIde()
    fabric()
}

loom {
    silentMojangMappingsLicense()

    mixin {
        defaultRefmapName.set("mixins.${project.name}.refmap.json")
    }
}

repositories {
    mavenCentral()
    maven(url = "https://dl.cloudsmith.io/public/geckolib3/geckolib/maven/")
    maven("https://maven.impactdev.net/repository/development/")
}

dependencies {
    minecraft("com.mojang:minecraft:1.20.1")
    mappings(loom.officialMojangMappings())
    modImplementation("net.fabricmc:fabric-loader:0.14.21")

    modImplementation("net.fabricmc:fabric-language-kotlin:1.10.10+kotlin.1.9.10")
    modImplementation(fabricApi.module("fabric-command-api-v2", "0.89.3+1.20.1"))
    modImplementation("dev.architectury", "architectury-fabric", "9.1.12")
    modImplementation("com.cobblemon:fabric:1.4.0+1.20.1-SNAPSHOT")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}