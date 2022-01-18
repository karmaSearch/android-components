package karma.service.learnandact.helper

import karma.service.learnandact.LearnAndAct
import karma.service.learnandact.api.LearnAndActApi


/**
 * Accessors to resources used in testing.
 */
internal object LearnAndActTestResources {
    val endointFiveStoriesResponse = this::class.java.classLoader!!.getResource(
        "learnandact.json"
    )!!.readText()

    val apiExpectedLearnAndAct: List<LearnAndActApi> = listOf(
        LearnAndActApi(
            blog_article_title = "New global biodiversity goals must take these key lessons into account",
            blog_article_action_url = "https://theconversation.com/new-global-biodiversity-goals-must-take-these-key-lessons-into-account-151315",
            blog_article_image = "/images/home/LearnAct1.webp",
            blog_article_duration = "",
            bloc_type = "learn",
            blog_article_action = "Read more...",
            blog_article_description = "A framework to help countries develop national strategies for the conservation and sustainable use of their natural resources is nearing completion."
        ),
        LearnAndActApi(
            blog_article_title = "End the cage age for all the UK's farm animals",
            blog_article_action_url = "https://action.ciwf.org.uk/page/83793/petition/1",
            blog_article_image = "/images/home/LearnAct2.webp",
            blog_article_duration = "",
            bloc_type = "act",
            blog_article_action = "Sign the petition!",
            blog_article_description = "Caging animals causes immense suffering. Despite the obvious failings of this outdated technology, around 16 million farm animals are trapped in cages every year in the UK. blabahfdshfdsfdsdsfds",
        ),
        LearnAndActApi(
            blog_article_title = "End the cage age for all the UK's farm animals",
            blog_article_action_url = "https://action.ciwf.org.uk/page/83793/petition/1",
            blog_article_image = "/images/home/LearnAct2.webp",
            blog_article_duration = "7 minutes",
            bloc_type = "act",
            blog_article_action = "Sign the petition!",
            blog_article_description = "Caging animals causes immense suffering. Despite the obvious failings of this outdated technology, around 16 million farm animals are trapped in cages every year in the UK. Caging animals causes immense suffering. Despite the obvious failings of this outdated technology, around 16 million farm animals are trapped in cages every year in the UK."
        )
    )
}
