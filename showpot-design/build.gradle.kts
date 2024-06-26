plugins {
    alias(libs.plugins.showpot.application)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.alreadyoccupiedseat.showpot_design"

    defaultConfig {
        applicationId = "com.alreadyoccupiedseat.showpot_design"
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":feature:design-app"))

}