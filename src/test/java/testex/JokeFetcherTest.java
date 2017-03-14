/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testex;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.mockito.Mock;

/**
 *
 * @author Kim
 */
@RunWith(MockitoJUnitRunner.class)
public class JokeFetcherTest {

    private JokeFetcher jokeFetcher;
    @Mock
    IDateFormatter ifMock;
    @Mock
    IFetcherFactory factory;
    @Mock
    Moma moma;
    @Mock
    ChuckNorris chuck;
    @Mock
    EducationJoke edu;
    @Mock
    TambalJoke tambal;

    @Before
    public void setup() {
        List<IJokeFetcher> fetchers = Arrays.asList(edu, chuck, moma, tambal);
        when(factory.getJokeFetchers("EduJoke,ChuckNorris,Moma,Tambal")).thenReturn(fetchers);
        
        String[] types = {"EduJoke", "ChuckNorris", "Moma", "Tambal"};
        when(factory.getAvailableTypes()).thenReturn(types);
        
        jokeFetcher = new JokeFetcher(factory, ifMock);
    }

    @Test
    public void TestFetcherFactory() {
        IJokeFetcher EduJoke = mock(EducationJoke.class);
        IJokeFetcher ChuckNorris = mock(ChuckNorris.class);
        IJokeFetcher Moma = mock(Moma.class);
        IJokeFetcher Tambal = mock(TambalJoke.class);

        IFetcherFactory fetchFactory = new FetcherFactory();
        List<IJokeFetcher> result = fetchFactory.getJokeFetchers("EduJoke,ChuckNorris,Moma,Tambal");

        assertEquals(4, result.size());
    }
}
