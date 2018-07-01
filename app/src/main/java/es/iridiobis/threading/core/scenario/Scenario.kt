package es.iridiobis.threading.core.scenario


interface Scenario {
    val runRepository : Boolean
    val runNetwork : Boolean
    val runDatabase : Boolean
    val runLocation : Boolean
}