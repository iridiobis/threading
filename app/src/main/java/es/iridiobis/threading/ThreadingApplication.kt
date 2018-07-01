package es.iridiobis.threading

import dagger.android.*
import es.iridiobis.threading.dagger.DaggerAppComponent

class ThreadingApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
            DaggerAppComponent.builder().create(this)
    
}