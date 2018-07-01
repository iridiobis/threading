package es.iridiobis.threading.core.process

import es.iridiobis.threading.core.ThreadChecker

class HeavyAfterNetworkProcess(
        private val simpleProcess: SimpleProcess,
        private val threadChecker: ThreadChecker) : Process by simpleProcess{

    override fun runNetworkProcessAfterCall() {
        if (threadChecker.checkIsMainThread()) {
            throw IllegalStateException("ANR on network after call")
        } else {
            simpleProcess.runNetworkProcessAfterCall()
        }
    }

}