package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertSame;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bun;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsSetsBun() {
        burger.setBuns(bun);

        assertSame(bun, burger.bun);
    }
}