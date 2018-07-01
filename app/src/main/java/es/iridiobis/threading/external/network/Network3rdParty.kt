package es.iridiobis.threading.external.network

import es.iridiobis.threading.core.ThreadChecker
import io.reactivex.Completable
import javax.inject.Inject

class Network3rdParty @Inject constructor(private val checker: ThreadChecker) {

    fun doANetworkCall(): Completable =
            Completable.defer {
                if (checker.checkIsMainThread()) {
                    Completable.error(IllegalStateException("Network called from main thread"))
                } else {
                    Completable.complete()
                }
            }


}