package es.iridiobis.threading.core.process

interface Process {
    fun runUseCaseProcessBeforeCall()
    fun runUseCaseProcessAfterCall()

    fun runRepositoryProcessBeforeCall()
    fun runRepositoryProcessAfterCall()

    fun runNetworkProcessBeforeCall()
    fun runNetworkProcessAfterCall()

    fun runDatabaseProcessBeforeCall()
    fun runDatabaseProcessAfterCall()

    fun runLocationProcessBeforeCall()
    fun runLocationProcessAfterCall()
}