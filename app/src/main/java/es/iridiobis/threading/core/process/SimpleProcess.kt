package es.iridiobis.threading.core.process

import android.util.Log
import es.iridiobis.threading.core.*

class SimpleProcess constructor(private val threadFormatter: ThreadFormatter) : Process {

    override fun runUseCaseProcessBeforeCall() {
        Log.d(TAG, "Run use case before call on " + threadFormatter.format(Thread.currentThread()))
    }

    override fun runUseCaseProcessAfterCall() {
        Log.d(TAG, "Run use case after call on " + threadFormatter.format(Thread.currentThread()))
    }

    override fun runRepositoryProcessBeforeCall() {
        Log.d(TAG, "Run repository before call on " + threadFormatter.format(Thread.currentThread()))
    }

    override fun runRepositoryProcessAfterCall() {
        Log.d(TAG, "Run repository after call on " + threadFormatter.format(Thread.currentThread()))
    }

    override fun runNetworkProcessBeforeCall() {
        Log.d(TAG, "Run network before call on " + threadFormatter.format(Thread.currentThread()))
    }

    override fun runNetworkProcessAfterCall() {
        Log.d(TAG, "Run network after call on " + threadFormatter.format(Thread.currentThread()))
    }

    override fun runDatabaseProcessBeforeCall() {
        Log.d(TAG, "Run database before call on " + threadFormatter.format(Thread.currentThread()))
    }

    override fun runDatabaseProcessAfterCall() {
        Log.d(TAG, "Run database after call on " + threadFormatter.format(Thread.currentThread()))
    }

    override fun runLocationProcessBeforeCall() {
        Log.d(TAG, "Run location before call on " + threadFormatter.format(Thread.currentThread()))
    }

    override fun runLocationProcessAfterCall() {
        Log.d(TAG, "Run location after call on " + threadFormatter.format(Thread.currentThread()))
    }

}