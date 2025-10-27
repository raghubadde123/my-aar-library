plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.ns.paymentgateway"
    compileSdk = 35

    defaultConfig {
        minSdk = 24
        targetSdk = 35
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    // No external dependencies unless your aar needs them
}

afterEvaluate {
    android.libraryVariants.forEach { variant ->
        variant.compileConfiguration.dependencies.add(
            project.dependencies.create(files("libs/sabpaisapaymentgateway.aar"))
        )
    }
}
