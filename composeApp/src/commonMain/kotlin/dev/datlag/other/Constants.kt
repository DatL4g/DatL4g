package dev.datlag.other

data object Constants {

    const val MIMASU_GITHUB_REPO = "https://github.com/DatL4g/Mimasu"
    const val MIMASU_GOOGLE_PLAY = "https://play.google.com/store/apps/details?id=dev.datlag.mimasu"

    const val OWNER = "Jeff Retz"

    private const val OWNER_CONTACT_1 = "datlag.developer"
    private const val OWNER_CONTACT_2 = "@gmail.com"
    val ownerContact: String
        get() = "$OWNER_CONTACT_1$OWNER_CONTACT_2"

}