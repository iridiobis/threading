package es.iridiobis.threading.solution.solution3

import es.iridiobis.threading.core.process.Process
import es.iridiobis.threading.external.network.Network3rdParty
import io.reactivex.Completable
import javax.inject.Inject


class Network @Inject constructor(private val external: Network3rdParty) {

    fun call(process: Process): Completable {
        process.runNetworkProcessBeforeCall()
        return external.doANetworkCall()
                .doOnComplete { process.runNetworkProcessAfterCall() }
    }

}