package karma.service.learnandact.api

import androidx.annotation.VisibleForTesting
import androidx.annotation.WorkerThread
import karma.learnandact.fetchBodyOrNull
import mozilla.components.concept.fetch.Client
import mozilla.components.concept.fetch.Request
import java.util.*

internal class LearnAndActEndpointRaw internal constructor(
    @VisibleForTesting internal val client: Client
) {
    /**
     * Gets the current stories recommendations from the Pocket server.
     *
     * @return The stories recommendations as a raw JSON string or null on error.
     */
    @WorkerThread
    fun getLearnAndActBlocs(): String? = makeRequest()

    /**
     * @return The requested JSON as a String or null on error.
     */
    @WorkerThread // synchronous request.
    private fun makeRequest(): String? {
        val locale = Locale.getDefault().toString()
        val jsonFile = if (locale.contains("fr")) "learnandact_fr.json" else "learnandact_en.json"
        val request = Request(pocketEndpointUrl+jsonFile)
        return client.fetchBodyOrNull(request)
    }

    companion object {
        private const val pocketEndpointUrl = "https://about.karmasearch.org/i18n/iOS_app/"

        /**
         * Returns a new instance of [PocketEndpointRaw].
         *
         * @param client the HTTP client to use for network requests.
         */
        fun newInstance(client: Client): LearnAndActEndpointRaw {
            return LearnAndActEndpointRaw(client)
        }
    }
}