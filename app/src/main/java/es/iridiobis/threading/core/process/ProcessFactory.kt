package es.iridiobis.threading.core.process

import es.iridiobis.threading.core.*
import javax.inject.Inject

class ProcessFactory @Inject constructor(
        private val simpleProcess: SimpleProcess,
        private val threadChecker: ThreadChecker
) {

    fun createProcess(type: Int) =
            when (type) {
                ProcessType.SIMPLE.value -> simpleProcess
                ProcessType.HEAVY_AFTER_NETWORK.value -> HeavyAfterNetworkProcess(simpleProcess, threadChecker)
                ProcessType.ALL_HEAVY.value -> AllHeavyProcess(simpleProcess, threadChecker)
                else -> throw IllegalStateException()
            }
}