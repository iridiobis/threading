package es.iridiobis.threading.core.scenario

class MemoryCacheScenario : Scenario {
    override val runRepository = true
    override val runNetwork = false
    override val runDatabase = false
    override val runLocation = false
}