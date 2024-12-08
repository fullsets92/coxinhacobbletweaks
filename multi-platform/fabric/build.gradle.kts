plugins {
    id("dev.architectury.loom")
    id("architectury-plugin")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

architectury {
    platformSetupLoomIde()
    fabric()
}

loom {
    enableTransitiveAccessWideners.set(true)
    silentMojangMappingsLicense()

    mixin {
        defaultRefmapName.set("mixins.${project.name}.refmap.json")
    }
}
val shadowCommon = configurations.create("shadowCommon")

dependencies {
    minecraft("net.minecraft:minecraft:1.21")
    mappings(loom.officialMojangMappings())
    modImplementation("net.fabricmc:fabric-loader:0.16.0")

    modRuntimeOnly("net.fabricmc.fabric-api:fabric-api:0.100.7+1.21")
    modImplementation(fabricApi.module("fabric-command-api-v2", "0.100.7+1.21"))
    modImplementation("com.cobblemon:fabric:1.6.0+1.21-SNAPSHOT")

    implementation(project(":common", configuration = "namedElements"))
    "developmentFabric"(project(":common", configuration = "namedElements"))

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
    shadowCommon(project(":common"))

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks {

    jar {
        archiveBaseName.set("${project.name}")
        archiveClassifier.set("dev-slim")
    }

    shadowJar {
        archiveBaseName.set("${project.name}")
        configurations = listOf(shadowCommon)
    }

    remapJar {
        dependsOn(shadowJar)
        inputFile.set(shadowJar.flatMap { it.archiveFile })
        archiveBaseName.set("${project.name}")
        archiveVersion.set("${rootProject.version}")
    }

}