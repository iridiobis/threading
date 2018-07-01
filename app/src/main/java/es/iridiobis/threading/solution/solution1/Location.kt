package es.iridiobis.threading.solution.solution1

import es.iridiobis.threading.core.process.Process
import es.iridiobis.threading.external.location.Location3rdParty
import io.reactivex.Completable
import javax.inject.Inject

class Location @Inject constructor(private val external: Location3rdParty) {

    fun call(process: Process): Completable {
        process.runLocationProcessBeforeCall()
        return external.doALocationCall()
                .doOnComplete { process.runLocationProcessAfterCall() }
    }

}