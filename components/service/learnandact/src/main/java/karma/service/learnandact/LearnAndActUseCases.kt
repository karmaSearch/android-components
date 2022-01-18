package karma.service.learnandact

import android.content.Context
import androidx.annotation.VisibleForTesting
import karma.service.learnandact.api.LearnAndActEndpoint
import karma.service.learnandact.api.LearnAndActResponse
import mozilla.components.concept.fetch.Client

class LearnAndActUseCases {
    internal inner class GetLearnAndActBlocs(private val context: Context) {
        suspend operator fun invoke(): List<LearnAndAct> {
            val client = fetchClient
            if (client == null) {
                logger.error("Cannot download new stories. Service has incomplete setup")
                return emptyList()
            }

            val endpoint = getLearnAndActEndpoint(client)
            val response = endpoint.getLearnAndActBlocs()

            if (response is LearnAndActResponse.Success) {

                return response.data.map {
                    it.toLearnAndAct()
                }
            }

            return emptyList()
        }
    }

    @VisibleForTesting
    internal fun getLearnAndEndpoint(client: Client) = LearnAndActEndpoint.newInstance(client)

    @VisibleForTesting
    internal fun getLearnAndActEndpoint(client: Client) = LearnAndActEndpoint.newInstance(client)

    internal companion object {
        @VisibleForTesting internal var fetchClient: Client? = null

        /**
         * Convenience method for setting the the HTTP Client which will be used
         * for all REST communications with the Pocket server.
         *
         * Already downloaded data can still be queried but no new data can be downloaded until
         * this parameter is set.
         */
        internal fun initialize(client: Client) {
            fetchClient = client
        }

        /**
         * Convenience method for cleaning up any resources held for communicating with the Pocket server.
         *
         * Already downloaded data can still be queried but no new data can be downloaded until
         * [initialize] is used again.
         */
        internal fun reset() {
            fetchClient = null
        }
    }
}