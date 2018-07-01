package es.iridiobis.threading.solution.solution3

import es.iridiobis.threading.core.process.Process
import es.iridiobis.threading.core.scenario.Scenario
import es.iridiobis.threading.solution.UI
import io.reactivex.Completable
import javax.inject.Inject

class Solution3 @Inject constructor(
        private val useCase: UseCase,
        private val executor: Executor
) : UI.Presenter {
    override fun start(process: Process, scenario: Scenario): Completable {
        return executor.execute(useCase, process, scenario)
    }
}