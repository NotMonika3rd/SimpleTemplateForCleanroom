plugins {
    id("java")
    id("xyz.wagyourtail.unimined") version "1.4.9-kappa"
}

group = "rip.sayori"
version = "1.0-SNAPSHOT"

unimined.minecraft {
    version = "1.12.2"
    mappings.mcp("stable","39-1.12")
    cleanroom {
        loader("0.4.4-alpha")
        runs.all {
            systemProperty("crl.dev.mixin", "modid.mixin.json")
        }
    }
    defaultRemapJar = false
    remap(tasks.jar.get()) {
        mixinRemap {
            enableBaseMixin()
            enableMixinExtra()
            disableRefmap()
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
}

tasks.jar {
    val attributeMap = mutableMapOf<String, String>()
    attributeMap["ModType"] = "CRL"
    attributeMap["MixinConfigs"] = "modid.mixin.json"
    manifest.attributes(attributeMap)
}