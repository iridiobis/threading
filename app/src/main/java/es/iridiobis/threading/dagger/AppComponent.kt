package es.iridiobis.threading.dagger

import dagger.Component
import dagger.android.*
import es.iridiobis.threading.ThreadingApplication

@Component(modules = arrayOf(AndroidInjectionModule::class, ActivityBindingModule::class))
interface AppComponent : AndroidInjector<ThreadingApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<ThreadingApplication>()
}