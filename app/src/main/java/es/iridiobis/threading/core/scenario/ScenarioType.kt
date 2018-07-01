package es.iridiobis.threading.core.scenario

enum class ScenarioType(val value : Int) {
    FULL(0),
    CACHE(1),
    NETWORK(2),
    LOCATION(3),
    DATABASE(4),
    MEMORY_CACHE(5),
    USE_CASE(6)
}