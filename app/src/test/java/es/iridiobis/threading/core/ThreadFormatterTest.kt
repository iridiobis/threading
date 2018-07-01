package es.iridiobis.threading.core

import com.google.common.truth.Truth.assertThat
import org.junit.*
import org.mockito.*
import org.mockito.Mockito.`when`

class ThreadFormatterTest {

    @Mock
    private lateinit var thread : Thread

    private lateinit var sut : ThreadFormatter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        sut = ThreadFormatter()
    }

    @Test
    fun `format should return a string formed by the name and the id of the tread`() {
        `when`(thread.id).thenReturn(5)
        `when`(thread.name).thenReturn("El hilo")

        val result = sut.format(thread)

        assertThat(result).isEqualTo("El hilo - 5")
    }
}