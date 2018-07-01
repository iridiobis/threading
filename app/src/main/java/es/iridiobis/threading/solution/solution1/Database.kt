package es.iridiobis.threading.solution.solution1

import es.iridiobis.threading.core.process.Process
import es.iridiobis.threading.external.ddbb.Database3rdParty
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class Database @Inject constructor(private val external : Database3rdParty) {

    fun call(process : Process) : Completable {
        process.runDatabaseProcessBeforeCall()
        return external.doADatabaseCall()
                .doOnComplete { process.runDatabaseProcessAfterCall() }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

}