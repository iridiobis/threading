package es.iridiobis.threading.external.ddbb

import es.iridiobis.threading.core.ThreadChecker
import io.reactivex.Completable
import javax.inject.Inject

class Database3rdParty @Inject constructor(private val checker: ThreadChecker) {

    fun doADatabaseCall(): Completable =
            Completable.defer {
                if (checker.checkIsMainThread()) {
                    Completable.error(IllegalStateException("Database called from main thread"))
                } else {
                    Completable.complete()
                }
            }
}