package es.iridiobis.threading.core

import android.os.Looper
import javax.inject.Inject

class ThreadChecker @Inject constructor() {
    fun checkIsMainThread() = Thread.currentThread() == Looper.getMainLooper().thread
}