package es.iridiobis.threading.external.network

import es.iridiobis.threading.core.ThreadChecker
import org.junit.*
import org.mockito.*
import org.mockito.Mockito.`when`

class Network3rdPartyTest {

    @Mock
    private lateinit var threadChecker : ThreadChecker

    private lateinit var sut : Network3rdParty

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        sut = Network3rdParty(threadChecker)
    }

    @Test
    fun `doANetworkCall should fail when running on the main thread`() {
        `when`(threadChecker.checkIsMainThread()).thenReturn(true)

        val testObserver = sut.doANetworkCall().test()

        testObserver.assertErrorMessage("Network called from main thread")
    }

    @Test
    fun `doANetworkCall should complete when not running on the main thread`() {
        `when`(threadChecker.checkIsMainThread()).thenReturn(false)

        val testObserver = sut.doANetworkCall().test()

        testObserver.assertComplete()
    }
}