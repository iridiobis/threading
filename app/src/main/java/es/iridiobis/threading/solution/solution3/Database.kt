package es.iridiobis.threading.solution.solution3

import es.iridiobis.threading.core.process.Process
import es.iridiobis.threading.external.ddbb.Database3rdParty
import io.reactivex.Completable
import javax.inject.Inject

class Database @Inject constructor(private val external: Database3rdParty) {

    fun call(process: Process): Completable {
        process.runDatabaseProcessBeforeCall()
        return external.doADatabaseCall()
                .doOnComplete { process.runDatabaseProcessAfterCall() }
    }

}