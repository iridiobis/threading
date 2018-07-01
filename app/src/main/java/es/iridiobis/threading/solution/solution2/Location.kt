package es.iridiobis.threading.solution.solution2

import es.iridiobis.threading.core.process.Process
import es.iridiobis.threading.external.location.Location3rdParty
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class Location @Inject constructor(private val external: Location3rdParty) {

    fun call(process: Process): Completable {
        process.runLocationProcessBeforeCall()
        return external.doALocationCall()
                .doOnComplete { process.runLocationProcessAfterCall() }
                .subscribeOn(AndroidSchedulers.mainThread())
    }

}