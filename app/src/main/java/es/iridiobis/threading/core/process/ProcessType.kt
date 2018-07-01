package es.iridiobis.threading.core.process


enum class ProcessType(val value : Int) {
    SIMPLE(0),
    HEAVY_AFTER_NETWORK(1),
    ALL_HEAVY(2)
}