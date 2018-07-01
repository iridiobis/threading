package es.iridiobis.threading.core

import javax.inject.Inject


class ThreadFormatter @Inject constructor() {
    fun format(thread: Thread) = "${thread.name} - ${thread.id}"
}