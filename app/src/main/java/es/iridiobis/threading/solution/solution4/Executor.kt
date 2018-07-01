package es.iridiobis.threading.solution.solution4

import es.iridiobis.threading.core.process.Process
import es.iridiobis.threading.core.scenario.Scenario
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class Executor @Inject constructor() {

    fun execute(useCase: UseCase, process: Process, scenario: Scenario) : Completable {
        return useCase.execute(process, scenario)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

}