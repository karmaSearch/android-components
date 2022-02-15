package karma.service.learnandact

import karma.service.learnandact.api.LearnAndActApi

internal fun LearnAndActApi.toLearnAndAct(): LearnAndAct =
    LearnAndAct(type = bloc_type,
    title = blog_article_title,
    description = blog_article_description,
    duration = blog_article_duration,
    imageUrl = "https://about.karmasearch.org$blog_article_image",
    action = blog_article_action,
    actionUrl = blog_article_action_url)
