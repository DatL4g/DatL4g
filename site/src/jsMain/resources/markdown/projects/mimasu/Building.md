---
layout: .components.layouts.MarkdownLayout
title: Mimasu - Build an Extension
---

# Build a Mimasu Extension

In times of AI anyone can build their own small apps.  
While developing Mimasu I kept that in mind and you can build your own extension app.

You can and should AI interpret this page as well when you want to build your own.

**Introduction:**
- [Multiple Extensions](#but-i-want-to-use-the-original-extension)
- [What do I need](#what-do-i-need)
- [Which programming language](#which-programming-language)
- [Knowing programming](#do-i-need-to-know-something-about-programming)

**Actually Building:**
- [Dependencies](#required-dependencies)
- [Getting Started](#getting-started)
- [Exchanged data Format](#exchanged-data-format)
- [Exchange Data](#exchange-data)

## But I want to use the original extension

No problem!  
You can install multiple extensions alongside.

## What do I need?

Android Studio and an AI of your choice!  
Oh and your phone of course.

From what I've heard [Firebase Studio](https://firebase.studio/) is pretty decent for this task, but I can't tell as I don't use AI to this extent.

## Which programming language?

**Kotlin.**  
You can also use Java (as long as it's a Kotlin project).

However if you understand what you are doing and know how Protobuf and AIDL works you can take whatever language you want, from C++ over JS to Python. Feel free.

## Do I need to know something about programming?

Not really, all you need is some logical thinking and AI can do the rest.  
You'll stumble upon some keywords like **AIDL**, you can simply ask AI about things you don't know.  

Mostly you don't even need to understand these concepts, just the plain logic (where is data coming from and going to).

## Required Dependencies

Dependencies (I refer to libraries here) are precompiled code snippets, that will help you develop apps and features faster.  
These are so crucial that we **depend** on them.

What we need for our Kotlin (or Java) project is the following:

- Kotlin Serialization:
  - Gradle Plugin: `org.jetbrains.kotlin.plugin.serialization`
  - Library: `org.jetbrains.kotlinx:kotlinx-serialization-protobuf:1.9.0`
  - Used to convert (human) readable data to small packages, exchanged between Mimasu and extensions
- Android Lifecycle:
  - Library: `androidx.lifecycle:lifecycle-service:2.9.1`
  - Used to exchange data between Mimasu and extensions using AIDL
- Kotlin Coroutines:
  - Library: `org.jetbrains.kotlinx:kotlinx-coroutines-android:1.10.2`
  - Used for async requests e.g. requesting websites to search for a specific show
- Tooling:
  - Library: `dev.datlag.tooling:tooling-async:1.8.2`
  - Comes with some handy methods you might need. Is used in the `Show` class below.

## Getting Started

Ask your AI to generate an Android Kotlin project with the dependencies mentioned above for your package name and AIDL feature.  
Also tell it to read and think about this page right here (paste the link).

What's my package name? Just use something like `countrycode.yourname.mimasu.extension`, e.g. `de.tom.mimasu.extension`.

As I mentioned AIDL a couple of times already, this is for exchanging data between Mimasu and your extension.  
Just download the exact same files from the original extension here: [Download Directory](https://download-directory.github.io/?url=https%3A%2F%2Fgithub.com%2FDatL4g%2FMimasu-Extension%2Ftree%2Fmimasu%2FcomposeApp%2Fsrc%2FandroidMain%2Faidl)

Make sure to keep the same folder structure, you can compare it with this one: https://github.com/DatL4g/Mimasu-Extension/tree/mimasu/composeApp/src/androidMain/aidl

## Exchanged data Format

Data is exchanged in Protobuf format between apps.

Create this exact class, do **NOT** erase fields even if they are unused:

```kotlin
/**
 * Handles show and episode related request/response in Mimasu.
 *
 * Data is exchanged between Mimasu and extensions using AIDL.
 * Take a look at the AIDL interfaces!
 */
@Serializable
sealed interface Show {

    /**
     * Used to search for shows.
     * This data comes from Mimasu (the base app) and can be used in extensions to search / filter according shows.
     *
     * @param tmdbId ID of the show on TMDB
     * @param imdbId ID of the show on IMDB
     * @param wikidataId ID of the show on Wikidata
     * @param title localized show title (depending on the user language)
     * @param originalTitle show title in it's original language (independent from user language)
     * @param firstReleaseYear year the show was first released / aired in
     * @param isAnimation whether the show is an animation / anime or not
     * @param numberOfNormalSeasons !!! currently not provided !!!
     * @param hasSpecialSeason !!! currently not provided !!!
     * @param season !!! currently not provided !!!
     * @param appLocale user language used in the app
     */
    @Serializable
    data class Request(
        val tmdbId: Int? = null,
        val imdbId: String? = null,
        val wikidataId: String? = null,
        val title: String? = null,
        val originalTitle: String? = null,
        val firstReleaseYear: Int? = null,
        val isAnimation: Boolean? = null,
        val numberOfNormalSeasons: Int? = null,
        val hasSpecialSeason: Boolean? = null,
        val season: Int? = null,
        val appLocale: String? = null
    ) : Show {

        companion object {

            /**
             * Constructor parsing the data coming from Mimasu to [Show.Request]
             */
            @OptIn(ExperimentalSerializationApi::class)
            operator fun invoke(bytes: ByteArray?): Request? {
                if (bytes == null || bytes.isEmpty()) {
                    return null
                }

                return scopeCatching {
                    protobuf.decodeFromByteArray<Request>(bytes)
                }.getOrNull()
            }
        }
    }

    /**
     * Used to search for episodes in shows to check their availability and request streams.
     * This data comes from Mimasu (the base app) and can be used in extensions to search / filter according episodes.
     *
     * @param episodeNumber number of the episode in it's specific season
     * @param episodeTitle title of the episode (depending on the user language)
     * @param numberOfNormalSeasons !!! currently not provided !!!
     * @param hasSpecialSeason !!! currently not provided !!!
     * @param season currently selected season
     * @param appLocale user language used in the app
     */
    @Serializable
    data class EpisodeRequest(
        val episodeNumber: Int? = null,
        val episodeTitle: String? = null,
        val numberOfNormalSeasons: Int? = null,
        val hasSpecialSeason: Boolean? = null,
        val season: Int? = null,
        val appLocale: String? = null
    ) : Show {

        @Transient
        val appLanguage = appLocale
            ?.substringBefore('-')
            ?.substringBefore('_')
            ?.ifBlank { null }
            ?.trim()

        companion object {

            /**
             * Constructor parsing the data coming from Mimasu to [Show.EpisodeRequest]
             */
            @OptIn(ExperimentalSerializationApi::class)
            operator fun invoke(bytes: ByteArray?): EpisodeRequest? {
                if (bytes == null || bytes.isEmpty()) {
                    return null
                }

                return scopeCatching {
                    protobuf.decodeFromByteArray<EpisodeRequest>(bytes)
                }.getOrNull()
            }
        }
    }

    /**
     * Response for streams.
     *
     * @param recapRange !!! currently not used !!!
     * @param introRange !!! currently not used !!!
     * @param outroRange !!! currently not used !!!
     * @param previewRange !!! currently not used !!!
     * @param sources streaming sources and links. Links have to be full URLs.
     * @see SourceInfo
     */
    @Serializable
    data class Response(
        val recapRange: Skipable? = null,
        val introRange: Skipable? = null,
        val outroRange: Skipable? = null,
        val previewRange: Skipable? = null,
        val sources: Map<SourceInfo, List<String>> = emptyMap()
    ) : Show {

        /**
         * Converts the response to data readable in Mimasu.
         */
        @OptIn(ExperimentalSerializationApi::class)
        fun toByteArray(): ByteArray {
            return protobuf.encodeToByteArray(this)
        }

        /**
         * Declares a skip-able time segment in a stream.
         * Example for intros or outros.
         *
         * !!! Currently unused, no need to provide !!!
         */
        @Serializable
        data class Skipable(
            val start: Long? = null,
            val end: Long? = null
        )

        /**
         * Declares where the stream is coming from.
         *
         * @param sourceTitle something like the original website name
         * @param sourceLocale title of the locale e.g. "English" or "German"
         * @param locale locale of the stream e.g. "en" or "de"
         */
        @Serializable
        data class SourceInfo(
            val sourceTitle: String? = null,
            val sourceLocale: String? = null,
            val locale: String? = null
        )
    }

    companion object {

        /**
         * Used to convert the data between Mimasu and extensions.
         */
        @OptIn(ExperimentalSerializationApi::class)
        private val protobuf = ProtoBuf {
            encodeDefaults = false
        }
    }
}
```

You'll need to resolve the imports, maybe the AI will do this for you already.  
But it's easy with Android Studio, it will highlight unresolved types and you just have to click on it.

## Exchange Data

When you prepared all of the above you can listen for data from Mimasu.  
And whenever you are ready you can send data back of course.

You just need to bind to the AIDL service like this:

```kotlin
class ShowService : LifecycleService() {

    override fun onBind(intent: Intent): IBinder? {
        val result = super.onBind(intent)

        return MyBinder(lifecycleScope)
    }

    class MyBinder(
      val scope: CoroutineScope
    ) : IShowInfoProvider.Stub() {

        // Search for shows here.
        // requestInfo is the show currently opened in Mimasu
        override fun requestShowId(request: ByteArray?, callback: ShowCallback?) {
            // RequestInfo holds some information to a show
            val requestInfo = Show.Request(request) ?: return
          
            // This method is for searching for a show.
            // If you found the show the request is looking for you must provide an unique id for this show
            // The same id will be provided when searched for episodes, so you always know which series you are currently looking for
            callback?.onResult(uniqueIdForRequestedShow)
        }

        // Check if an episode is available to watch
        // Always call the callback, either with `true` when available, or `false` if not or when unsure
        override fun requestEpisodeAvailability(
          showId: Int,
          request: ByteArray?,
          callback: EpisodeCallback?
        ) {
            // RequestInfo here holds information to an episode
            val requestInfo = Show.EpisodeRequest(request) ?: return run { 
                callback?.onResult(false)
            }
          
            // This method is for checking if an episode can be watched
            // The showId is the one you specified in the requestShowId callback
            callback?.onResult(isEpisodeAvailable)
        }

        // Load streams for episodes when requestEpisodeAvailability returned `true`
        // Always call the callback, either with the Response data or null
        override fun requestStream(showId: Int, request: ByteArray?, callback: StreamCallback?) {
            // RequestInfo here holds information to an episode, same as in requestEpisodeAvailability
            val requestInfo = Show.EpisodeRequest(request) ?: return run { 
                callback?.onResult(null)
            }
          
            // This method is for loading streams of episodes
            // The showId is the one you specified in the requestShowId callback
            callback?.onResult(Show.Response(...))
        }
    }
}
```

Finally ask AI to add your own service class to the AndroidManifest, if it didn't already.

You can do whatever you want in these methods.  
Doesn't matter which website you request, how you process or handle data, feel free to do whatever you want!