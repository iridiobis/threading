package es.iridiobis.threading.core.process

import es.iridiobis.threading.core.ThreadFormatter
import javax.inject.Inject


class ProcessFactory @Inject constructor(private val threadFormatter: ThreadFormatter) {

    fun createProcess(type : ProcessType) : Process {
        return when(type) {
            ProcessType.SIMPLE -> SimpleProcess(threadFormatter)
        }
    }
}