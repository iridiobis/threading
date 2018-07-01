package es.iridiobis.threading.external.ddbb

import es.iridiobis.threading.core.ThreadChecker
import org.junit.*
import org.mockito.*

class Database3rdPartyTest {

    @Mock
    private lateinit var threadChecker : ThreadChecker

    private lateinit var sut : Database3rdParty

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        sut = Database3rdParty(threadChecker)
    }

    @Test
    fun `doADatabaseCall should fail when running on the main thread`() {
        Mockito.`when`(threadChecker.checkIsMainThread()).thenReturn(true)

        val testObserver = sut.doADatabaseCall().test()

        testObserver.assertErrorMessage("Database called from main thread")
    }

    @Test
    fun `doADatabaseCall should complete when not running on the main thread`() {
        Mockito.`when`(threadChecker.checkIsMainThread()).thenReturn(false)

        val testObserver = sut.doADatabaseCall().test()

        testObserver.assertComplete()
    }
}