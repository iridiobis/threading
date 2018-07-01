package es.iridiobis.threading.dagger

import dagger.*
import dagger.multibindings.*
import es.iridiobis.threading.solution.UI
import es.iridiobis.threading.solution.solution1.Solution1
import es.iridiobis.threading.solution.solution2.Solution2

@Module
class SolutionModule {

    @Provides
    @IntoMap
    @StringKey("Solution 1")
    fun provideSolution1Presenter(solution1: Solution1): UI.Presenter = solution1

    @Provides
    @IntoMap
    @StringKey("Solution 2")
    fun provideSolution2Presenter(solution2: Solution2): UI.Presenter = solution2
}