package es.iridiobis.threading.core.process

import es.iridiobis.threading.core.ThreadChecker

class AllHeavyProcess(
        private val simpleProcess: SimpleProcess,
        private val threadChecker: ThreadChecker) : Process {

    override fun runUseCaseProcessBeforeCall() {
        if (threadChecker.checkIsMainThread()) {
            throw IllegalStateException("ANR on use case before call")
        } else {
            simpleProcess.runUseCaseProcessBeforeCall()
        }
    }

    override fun runUseCaseProcessAfterCall() {
        if (threadChecker.checkIsMainThread()) {
            throw IllegalStateException("ANR on use case after call")
        } else {
            simpleProcess.runUseCaseProcessAfterCall()
        }
    }

    override fun runRepositoryProcessBeforeCall() {
        if (threadChecker.checkIsMainThread()) {
            throw IllegalStateException("ANR on repository before call")
        } else {
            simpleProcess.runRepositoryProcessBeforeCall()
        }
    }

    override fun runRepositoryProcessAfterCall() {
        if (threadChecker.checkIsMainThread()) {
            throw IllegalStateException("ANR on repository after call")
        } else {
            simpleProcess.runRepositoryProcessAfterCall()
        }
    }

    override fun runNetworkProcessBeforeCall() {
        if (threadChecker.checkIsMainThread()) {
            throw IllegalStateException("ANR on network before call")
        } else {
            simpleProcess.runNetworkProcessBeforeCall()
        }
    }

    override fun runNetworkProcessAfterCall() {
        if (threadChecker.checkIsMainThread()) {
            throw IllegalStateException("ANR on network after call")
        } else {
            simpleProcess.runNetworkProcessAfterCall()
        }
    }

    override fun runDatabaseProcessBeforeCall() {
        if (threadChecker.checkIsMainThread()) {
            throw IllegalStateException("ANR on database before call")
        } else {
            simpleProcess.runDatabaseProcessBeforeCall()
        }
    }

    override fun runDatabaseProcessAfterCall() {
        if (threadChecker.checkIsMainThread()) {
            throw IllegalStateException("ANR on database after call")
        } else {
            simpleProcess.runDatabaseProcessAfterCall()
        }
    }

    override fun runLocationProcessBeforeCall() {
        if (threadChecker.checkIsMainThread()) {
            throw IllegalStateException("ANR on location before call")
        } else {
            simpleProcess.runLocationProcessBeforeCall()
        }
    }

    override fun runLocationProcessAfterCall() {
        if (threadChecker.checkIsMainThread()) {
            throw IllegalStateException("ANR on location after call")
        } else {
            simpleProcess.runLocationProcessAfterCall()
        }
    }

}