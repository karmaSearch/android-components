package karma.service.learnandact.api

import androidx.annotation.VisibleForTesting
import karma.service.learnandact.logger
import mozilla.components.support.ktx.android.org.json.mapNotNull
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


internal class LearnAndActJSONParser {
    /**
     * @return The stories, removing entries that are invalid, or null on error; the list will never be empty.
     */
    fun jsonToLearnAndApi(json: String): List<LearnAndActApi>? = try {
        val rawJSON = JSONObject(json)
        val storiesJSON = rawJSON.getJSONArray(KEY_ARRAY_ITEMS)
        val stories = storiesJSON.mapNotNull(JSONArray::getJSONObject) { jsonToLearnAndActApi(it) }

        // We return null, rather than the empty list, because devs might forget to check an empty list.
        if (stories.isNotEmpty()) stories else null
    } catch (e: JSONException) {
        logger.warn("invalid JSON from the Pocket endpoint", e)
        null
    }

    private fun jsonToLearnAndActApi(json: JSONObject): LearnAndActApi? = try {
        LearnAndActApi(
            // These three properties are required for any valid recommendation.
            bloc_type = json.getString("bloc_type"),
            blog_article_duration = json.getString("blog_article_duration"),
            blog_article_image = json.getString("blog_article_image"),
            blog_article_title = json.getString("blog_article_title"),
            blog_article_description = json.getString("blog_article_description"),
            blog_article_action = json.getString("blog_article_action"),
            blog_article_action_url = json.getString("blog_article_action_url")
            )
    } catch (e: JSONException) {
        logger.warn("invalid JSON from the Pocket endpoint", e)
        null
    }

    companion object {
        @VisibleForTesting
        const val KEY_ARRAY_ITEMS = "blocs"

        /**
         * Returns a new instance of [PocketJSONParser].
         */
        fun newInstance(): LearnAndActJSONParser {
            return LearnAndActJSONParser()
        }
    }
}
