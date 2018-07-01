package es.iridiobis.threading.core.scenario


class FullScenario : Scenario {
    override val runRepository = true
    override val runNetwork = true
    override val runDatabase = true
    override val runLocation = true
}