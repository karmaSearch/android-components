package karma.service.learnandact

import karma.service.learnandact.api.LearnAndActApi

internal fun LearnAndActApi.toLearnAndAct(): LearnAndAct =
    LearnAndAct(type = type,
    title = title,
    description = description,
    duration = duration,
    imageUrl = mobile_image,
    action = action,
    actionUrl = link)
