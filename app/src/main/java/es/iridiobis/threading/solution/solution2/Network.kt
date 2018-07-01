package es.iridiobis.threading.solution.solution2

import es.iridiobis.threading.core.process.Process
import es.iridiobis.threading.external.network.Network3rdParty
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class Network @Inject constructor(private val external: Network3rdParty) {

    fun call(process: Process): Completable {
        process.runNetworkProcessBeforeCall()
        return external.doANetworkCall()
                .doOnComplete { process.runNetworkProcessAfterCall() }
                .subscribeOn(Schedulers.io())
    }

}