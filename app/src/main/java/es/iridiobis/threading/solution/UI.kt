package es.iridiobis.threading.solution

import android.util.Log
import es.iridiobis.threading.core.*
import es.iridiobis.threading.core.process.*
import es.iridiobis.threading.core.scenario.*
import io.reactivex.Completable
import javax.inject.Inject


class UI @Inject constructor(
        private val threadChecker: ThreadChecker,
        private val scenarioFactory: ScenarioFactory,
        private val processFactory: ProcessFactory,
        private val solutions: Map<String, @JvmSuppressWildcards UI.Presenter>
) {

    fun analyzeSolution(
            scenarioId: Int,
            processId: Int,
            solutionKey: String) {

        solutions[solutionKey]?.let {
            it.start(
                    processFactory.createProcess(processId),
                    scenarioFactory.createScenario(scenarioId)
            ).subscribe(
                    { showMessage("Complete") },
                    { exception -> showMessage(exception.message ?: "Error") }
            )
        }
    }

    private fun showMessage(message: String) {
        Log.d(TAG, message)
        if (!threadChecker.checkIsMainThread()) {
            Log.e(TAG, "UI receive response outside main thread")
        }
    }

    interface Presenter {
        fun start(process: Process, scenario: Scenario): Completable
    }

}