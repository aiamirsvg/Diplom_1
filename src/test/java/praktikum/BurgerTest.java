package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Mock
    private Ingredient secondIngredient;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsSetsBun() {
        burger.setBuns(bun);

        assertSame(bun, burger.bun);
    }

    @Test
    public void addIngredientAddsIngredient() {
        burger.addIngredient(ingredient);

        assertEquals(1, burger.ingredients.size());
        assertSame(ingredient, burger.ingredients.get(0));
    }
    @Test
    public void removeIngredientRemovesIngredientByIndex() {
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);

        burger.removeIngredient(0);

        assertEquals(1, burger.ingredients.size());
        assertSame(secondIngredient, burger.ingredients.get(0));
    }
    @Test
    public void moveIngredientMovesIngredientToNewIndex() {
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);

        burger.moveIngredient(0, 1);

        assertSame(secondIngredient, burger.ingredients.get(0));
        assertSame(ingredient, burger.ingredients.get(1));
    }
    @Test
    public void getPriceReturnsCorrectPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);

        when(bun.getPrice()).thenReturn(100.0f);
        when(ingredient.getPrice()).thenReturn(25.5f);
        when(secondIngredient.getPrice()).thenReturn(30.0f);

        float actualPrice = burger.getPrice();

        assertEquals(255.5f, actualPrice, 0.001f);
    }
}