plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-parcelize")
    id("com.google.devtools.ksp") version "2.0.20-1.0.24"
    id("kotlin-kapt")
}

android {
    namespace = "com.example.work"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.work"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    lint {
        baseline = file("lint-baseline.xml")
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
        compileOptions {

            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
        kotlinOptions {
            jvmTarget = "1.8"
        }
        buildFeatures {
            viewBinding = true

            buildConfig = true
        }
        composeOptions {
            kotlinCompilerExtensionVersion = "1.5.1"
        }
        packaging {
            resources {
                excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }
        }
        sourceSets {
            getByName("main") {
                assets {
                    srcDirs("src\\main\\assets", "src\\main\\assets")
                }
            }
        }


    }

    dependencies {
        implementation ("androidx.room:room-runtime")
        implementation(libs.androidx.room.common.jvm)
        kapt (libs.androidx.room.compiler)


        implementation(libs.androidx.swiperefreshlayout)
        kapt("com.google.dagger:dagger-compiler:2.52")
        implementation(libs.dagger.compiler.v2511)

        // lottie
        implementation (libs.lottie)

        implementation (libs.dagger)
        //Retrofit
        implementation (libs.retrofit)
        implementation (libs.converter.gson)
        implementation (libs.logging.interceptor)

        //Glide
        implementation(libs.glide)
        implementation(libs.androidx.navigation.fragment.ktx)
        implementation(libs.androidx.navigation.ui.ktx)
        annotationProcessor(libs.compiler)

        implementation(libs.material)
        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.appcompat)
        implementation(libs.material)
        implementation(libs.androidx.activity)
        implementation(libs.androidx.constraintlayout)
        implementation(libs.androidx.lifecycle.runtime.ktx)
        implementation(libs.androidx.activity.compose)
        implementation(platform(libs.androidx.compose.bom))
        implementation(libs.androidx.ui)
        implementation(libs.androidx.ui.graphics)
        implementation(libs.androidx.ui.tooling.preview)
        implementation(libs.androidx.material3)
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)
        androidTestImplementation(platform(libs.androidx.compose.bom))
        androidTestImplementation(libs.androidx.ui.test.junit4)
        debugImplementation(libs.androidx.ui.tooling)
        debugImplementation(libs.androidx.ui.test.manifest)

        implementation (libs.dagger.android)
    }

