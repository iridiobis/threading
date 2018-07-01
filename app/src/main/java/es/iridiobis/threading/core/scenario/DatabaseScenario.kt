package es.iridiobis.threading.core.scenario

class DatabaseScenario : Scenario {
    override val runRepository = true
    override val runNetwork = false
    override val runDatabase = true
    override val runLocation = false
}