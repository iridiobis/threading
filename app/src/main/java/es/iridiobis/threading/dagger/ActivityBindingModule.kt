package es.iridiobis.threading.dagger

import dagger.Module
import dagger.android.ContributesAndroidInjector
import es.iridiobis.threading.MainActivity

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector
    abstract fun provideMainActivity() : MainActivity
}