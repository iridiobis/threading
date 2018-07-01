package es.iridiobis.threading.solution.solution1

import es.iridiobis.threading.core.process.Process
import es.iridiobis.threading.core.scenario.Scenario
import io.reactivex.Completable
import javax.inject.Inject

class Repository @Inject constructor(
        private val network: Network,
        private val database: Database,
        private val location: Location) {

    fun request(process: Process, scenario: Scenario): Completable {
        process.runRepositoryProcessBeforeCall()
        return processNetwork(process, scenario)
                .andThen(processDatabase(process, scenario))
                .andThen(processLocation(process, scenario))
                .doOnComplete { process.runRepositoryProcessAfterCall() }
    }

    private fun processNetwork(process: Process, scenario: Scenario) =
            if (scenario.runNetwork) {
                network.call(process)
            } else {
                Completable.complete()
            }

    private fun processDatabase(process: Process, scenario: Scenario) =
            if (scenario.runDatabase) {
                database.call(process)
            } else {
                Completable.complete()
            }

    private fun processLocation(process: Process, scenario: Scenario) =
            if (scenario.runLocation) {
                location.call(process)
            } else {
                Completable.complete()
            }
}