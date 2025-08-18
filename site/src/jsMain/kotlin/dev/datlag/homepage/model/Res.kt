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

        val home: String = "Home"
        val homeGreeting: String = "Hello I'm"
        val name: String = "Jeff Retz"
        val homeSubtitle: String = "A professional Kotlin Multiplatform Developer"

        val about: String = "About"
        val aboutMe: String = "About Me"
        val aboutMeText1: String = "I am a qualified Software Developer from \uD83C\uDDE9\uD83C\uDDEA Germany."
        val aboutMeText2: String = "After 3 years of dual apprenticeship and additional 3-4 years professional experience, I started my studies and am self-employed."
        val aboutMeText3: String = "I specialized in the Kotlin ecosystem, especially in the multiplatform context and contribute to several open source projects."

        val contact: String = "Contact"
        val contactText1: String = "Don't hesitate to get help or just chat with me!"
        val contactText2: String = "Check my social media platforms below."
        val contactEmail: String = "Email Me"
        val contactLinkedIn: String = "LinkedIn"
        val contactGitHub: String = "GitHub"
        val contactInstagram: String = "Instagram"
        val contactSendMessage: String = "Send a Message"
        val contactFieldName: String = "Name"
        val contactFieldSubject: String = "Subject"
        val contactFieldMessage: String = "Your message"
        val contactEmailName: String = "contact@datlag.dev"
        val contactLinkedInName: String = "jeff-retz"
        val contactGitHubName: String = "DatL4g"
        val contactInstagramName: String = "the_dev_jeff"
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