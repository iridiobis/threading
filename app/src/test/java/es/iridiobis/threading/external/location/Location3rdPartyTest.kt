package es.iridiobis.threading.external.location

import es.iridiobis.threading.core.ThreadChecker
import org.junit.*
import org.mockito.*

class Location3rdPartyTest {

    @Mock
    private lateinit var threadChecker : ThreadChecker

    private lateinit var sut : Location3rdParty

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        sut = Location3rdParty(threadChecker)
    }

    @Test
    fun `doALocationCall should fail when running outside the main thread`() {
        Mockito.`when`(threadChecker.checkIsMainThread()).thenReturn(false)

        val testObserver = sut.doALocationCall().test()

        testObserver.assertErrorMessage("Location called outside main thread")
    }

    @Test
    fun `doALocationCall should complete when running on the main thread`() {
        Mockito.`when`(threadChecker.checkIsMainThread()).thenReturn(true)

        val testObserver = sut.doALocationCall().test()

        testObserver.assertComplete()
    }
}