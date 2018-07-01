package es.iridiobis.threading.solution.solution2

import es.iridiobis.threading.core.process.Process
import es.iridiobis.threading.core.scenario.Scenario
import es.iridiobis.threading.solution.UI
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class Solution2 @Inject constructor(private val useCase: UseCase) : UI.Presenter {
    override fun start(process: Process, scenario: Scenario): Completable {
        process.runUseCaseProcessBeforeCall()
        return useCase.execute(process, scenario)
                .doOnComplete { process.runUseCaseProcessAfterCall() }
                .observeOn(AndroidSchedulers.mainThread())
    }
}