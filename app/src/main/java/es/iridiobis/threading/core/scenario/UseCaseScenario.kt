package es.iridiobis.threading.core.scenario

class UseCaseScenario : Scenario {
    override val runRepository = false
    override val runNetwork = false
    override val runDatabase = false
    override val runLocation = false
}