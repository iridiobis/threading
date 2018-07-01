package es.iridiobis.threading.dagger

import dagger.*
import dagger.multibindings.*
import es.iridiobis.threading.solution.UI
import es.iridiobis.threading.solution.solution1.Solution1
import es.iridiobis.threading.solution.solution2.Solution2
import es.iridiobis.threading.solution.solution3.Solution3
import es.iridiobis.threading.solution.solution4.Solution4
import es.iridiobis.threading.solution.solution5.Solution5

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

    @Provides
    @IntoMap
    @StringKey("Solution 3")
    fun provideSolution3Presenter(solution3: Solution3): UI.Presenter = solution3

    @Provides
    @IntoMap
    @StringKey("Solution 4")
    fun provideSolution4Presenter(solution4: Solution4): UI.Presenter = solution4

    @Provides
    @IntoMap
    @StringKey("Solution 5")
    fun provideSolution5Presenter(solution5: Solution5): UI.Presenter = solution5
}