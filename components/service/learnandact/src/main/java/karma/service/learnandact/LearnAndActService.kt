package karma.service.learnandact

import android.content.Context
import mozilla.components.concept.fetch.Client

class LearnAndActService(
    private val client: Client,
    private val context: Context
)  {
    private val useCases = LearnAndActUseCases()
    internal var getLearnAndActUsecase = useCases.GetLearnAndActBlocs(context)

    suspend fun getLearnAndAct(): List<LearnAndAct> {
        LearnAndActUseCases.initialize(client)
        return getLearnAndActUsecase.invoke()
    }
}