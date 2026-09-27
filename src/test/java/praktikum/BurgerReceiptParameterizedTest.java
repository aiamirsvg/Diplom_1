package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class BurgerReceiptParameterizedTest {

    private final IngredientType ingredientType;
    private Burger burger;

    public BurgerReceiptParameterizedTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters(name = "Тип ингредиента: {0}")
    public static Object[][] getIngredientTypes() {
        return new Object[][]{
                {IngredientType.SAUCE},
                {IngredientType.FILLING}
        };
    }

    @Before
    public void setUp() {
        Bun bun = mock(Bun.class);
        Ingredient ingredient = mock(Ingredient.class);

        when(bun.getName()).thenReturn("black bun");
        when(bun.getPrice()).thenReturn(100.0f);
        when(ingredient.getType()).thenReturn(ingredientType);
        when(ingredient.getName()).thenReturn("hot sauce");
        when(ingredient.getPrice()).thenReturn(50.0f);

        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
    }

    @Test
    public void getReceiptReturnsCorrectReceipt() {
        String expectedReceipt = String.format(
                "(==== black bun ====)%n" +
                        "= %s hot sauce =%n" +
                        "(==== black bun ====)%n" +
                        "%n" +
                        "Price: %f%n",
                ingredientType.toString().toLowerCase(),
                250.0f
        );

        assertEquals(expectedReceipt, burger.getReceipt());
    }
}