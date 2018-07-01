package es.iridiobis.threading.external.location

import es.iridiobis.threading.core.ThreadChecker
import io.reactivex.Completable
import javax.inject.Inject

class Location3rdParty @Inject constructor(private val checker: ThreadChecker) {

    fun doALocationCall(): Completable =
            if (checker.checkIsMainThread()) {
                Completable.complete()
            } else {
                Completable.error(IllegalStateException("Location called outside main thread"))
            }

}