package es.iridiobis.threading.solution.solution1

import es.iridiobis.threading.core.process.Process
import es.iridiobis.threading.core.scenario.Scenario
import es.iridiobis.threading.solution.UI
import io.reactivex.Completable
import javax.inject.Inject

class Solution1 @Inject constructor(private val useCase: UseCase) : UI.Presenter {
    override fun start(process: Process, scenario: Scenario): Completable {
        return useCase.execute(process, scenario)
    }
}