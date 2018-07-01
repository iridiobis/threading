package es.iridiobis.threading.core.scenario

import javax.inject.Inject

class ScenarioFactory @Inject constructor() {

    fun createScenario(type: Int) =
            when (type) {
                ScenarioType.FULL.value -> FullScenario()
                ScenarioType.CACHE.value -> CacheScenario()
                ScenarioType.NETWORK.value -> NetworkScenario()
                ScenarioType.LOCATION.value -> LocationScenario()
                ScenarioType.DATABASE.value -> DatabaseScenario()
                ScenarioType.MEMORY_CACHE.value -> MemoryCacheScenario()
                ScenarioType.USE_CASE.value -> UseCaseScenario()
                else -> throw IllegalStateException()
            }
}