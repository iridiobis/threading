package es.iridiobis.threading.solution.solution2

import es.iridiobis.threading.core.process.Process
import es.iridiobis.threading.core.scenario.Scenario
import es.iridiobis.threading.solution.solution2.Repository
import io.reactivex.Completable
import javax.inject.Inject

class UseCase @Inject constructor(private val repository: Repository) {
    fun execute(process: Process, scenario: Scenario): Completable {
        process.runUseCaseProcessBeforeCall()
        return if (scenario.runRepository) {
            repository.request(process, scenario).doOnComplete { process.runUseCaseProcessAfterCall() }
        } else {
            Completable.complete()
        }
    }
}