package es.iridiobis.threading.core

import android.support.test.annotation.UiThreadTest
import com.google.common.truth.Truth.assertThat
import org.junit.Test


class ThreadCheckerTest {

    @Test
    fun checkIsMainThreadShouldReturnFalseWhenNotInMainThread() {
        assertThat(ThreadChecker().checkIsMainThread()).isFalse()
    }

    @UiThreadTest
    @Test
    fun checkIsMainThreadShouldReturnTrueWhenInMainThread() {
        assertThat(ThreadChecker().checkIsMainThread()).isTrue()
    }

}