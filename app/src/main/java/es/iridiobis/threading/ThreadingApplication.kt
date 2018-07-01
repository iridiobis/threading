package es.iridiobis.threading

import android.util.Log
import dagger.android.*
import es.iridiobis.threading.core.TAG
import es.iridiobis.threading.dagger.DaggerAppComponent

class ThreadingApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        Thread.setDefaultUncaughtExceptionHandler { _, ex ->
            Log.e(TAG, "Uncaught exception!!! : " + ex.message)
        }
    }
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
            DaggerAppComponent.builder().create(this)
    
}