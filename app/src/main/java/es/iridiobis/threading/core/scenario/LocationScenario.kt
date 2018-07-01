package es.iridiobis.threading.core.scenario

class LocationScenario : Scenario {
    override val runRepository = true
    override val runNetwork = false
    override val runDatabase = false
    override val runLocation = true
}