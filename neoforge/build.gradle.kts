plugins {
    id("java")
    id("dev.architectury.loom") version("1.6-SNAPSHOT")
    id("architectury-plugin") version("3.4-SNAPSHOT")
}


group = "org.example"
version = "1.0-SNAPSHOT"

architectury {
    platformSetupLoomIde()
    neoForge()
}

loom {
    silentMojangMappingsLicense()
}

repositories {
    mavenCentral()
    maven("https://dl.cloudsmith.io/public/geckolib3/geckolib/maven/")
    maven("https://maven.impactdev.net/repository/development/")
    maven("https://hub.spigotmc.org/nexus/content/groups/public/")
    maven("https://thedarkcolour.github.io/KotlinForForge/")
    maven("https://maven.neoforged.net")
}

dependencies {
    minecraft("net.minecraft:minecraft:1.21")
    mappings(loom.officialMojangMappings())
    neoForge("net.neoforged:neoforge:21.0.117-beta")

    modImplementation("com.cobblemon:neoforge:1.6.0+1.21-SNAPSHOT")
    //Needed for cobblemon
    implementation("thedarkcolour:kotlinforforge-neoforge:5.3.0") {
        exclude(group = "net.neoforged.fancymodloader", module = "loader")
    }

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}