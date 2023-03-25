plugins {
    id("dev.architectury.loom")
    id("architectury-plugin")
}

dependencies {
    minecraft("com.mojang:minecraft:1.19.2")
    mappings(loom.officialMojangMappings())
    modImplementation("dev.architectury", "architectury", "6.5.69")
    modCompileOnly("com.cobblemon:mod:1.3.0+1.19.2")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}