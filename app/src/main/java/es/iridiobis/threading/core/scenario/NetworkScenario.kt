package es.iridiobis.threading.core.scenario

class NetworkScenario : Scenario {
    override val runRepository = true
    override val runNetwork = true
    override val runDatabase = false
    override val runLocation = false
}