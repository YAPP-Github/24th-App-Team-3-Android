pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = java.net.URI("https://devrepo.kakao.com/nexus/content/groups/public/") }
    }
}

rootProject.name = "ShowPot"
include(":app")
include(":feature:home")
include(":feature:common")
include(":core:common")
include(":core:designsystem")
include(":core:domain")
include(":core:data")
include(":core:datastore")
include(":core:database")
include(":core:network")
include(":core:notification")
include(":showpot-design")
include(":feature:design-app")
include(":feature:onboarding")
include(":feature:login")
include(":feature:notification")
include(":feature:mypage")
include(":feature:search")
include(":model")
include(":feature:subscription-genre")
include(":feature:subscription-artist")
include(":feature:show-detail")
include(":feature:myalarm-setting")
include(":feature:settings")
include(":feature:myfinished-show")
include(":feature:myfavorite-show")
include(":feature:withdraw")
