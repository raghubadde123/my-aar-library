plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.ns.paymentgateway"
    compileSdk = 36

    defaultConfig {
        minSdk = 24
        targetSdk = 36
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
