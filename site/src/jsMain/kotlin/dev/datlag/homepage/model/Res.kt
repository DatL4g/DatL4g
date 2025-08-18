package dev.datlag.homepage.model

data object Res {

    data object strings {
        val android: String = "Android"
        val compose: String = "Compose"
        val firebase: String = "Firebase"
        val github: String = "GitHub"
        val gradle: String = "Gradle"
        val kotlin: String = "Kotlin"
        val php: String = "PHP"
        val js: String = "Javascript"
        val git: String = "Git"
        val markdown: String = "Markdown"

        val beginner: String = "Beginner"
        val intermediate: String = "Intermediate"
        val advanced: String = "Advanced"

        val homeGreeting: String = "Hello I'm"
        val name: String = "Jeff Retz"
        val homeSubtitle: String = "A professional Kotlin Multiplatform Developer"
    }

    data object drawables {
        val self: String = "self.jpg"

        val skillsAndroidStudioDark: String = "skills/android_studio_dark.svg"
        val skillsAndroidStudioLight: String = "skills/android_studio_light.svg"
        val skillsCompose: String = "skills/compose.svg"
        val skillsFirebase: String = "skills/firebase.svg"
        val skillsGit: String = "skills/git.svg"
        val skillsGitHubDark: String = "skills/github_dark.svg"
        val skillsGitHubLight: String = "skills/github_light.svg"
        val skillsGradleDark: String = "skills/gradle_dark.svg"
        val skillsGradleLight: String = "skills/gradle_light.svg"
        val skillsJS: String = "skills/js.svg"
        val skillsKotlin: String = "skills/kotlin.svg"
        val skillsMarkdownDark: String = "skills/markdown_dark.svg"
        val skillsMarkdownLight: String = "skills/markdown_light.svg"
        val skillsPHP: String = "skills/php.svg"
    }
}