import org.junit.jupiter.api.Test;
import triangle.Triangle;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTriangule {

    private Triangle triangle;

    @Test
    public void testTrianguloIsImpossivle() {
        String excepted = "impossible";

        triangle = new Triangle(12, 2, -3);
        assertEquals(excepted, triangle.classify(), "Como -3 é negativo o triangulo é impossivel");

        triangle.setSideLengths(12, -2, -3);
        assertEquals(excepted, triangle.classify(), "Como dois dos lados são negativos o triangulo é impossivel");

        triangle.setSideLengths(-12, -2, -3);
        assertEquals(excepted, triangle.classify(), "Como todos os lados são negativos o triangulo é impossivel");

        triangle.setSideLengths(12, 2, 3);
        assertEquals(excepted, triangle.classify(), "Como a soma do lado 1 com o 2 é maior que o 3º lado do  triangulo é impossivel");

        triangle.setSideLengths(0, 0, 0);
        assertEquals(excepted, triangle.classify(), "Como o valor de todos os lados é menor que 1 vai dar false");

        triangle.setSideLengths(1, 2, 0);
        assertEquals(excepted, triangle.classify(), "Como o triangulo possui pelo menos 1 lado menor ou igual a 0 via dar false");
    }

    @Test
    public void testTrianguloIsEquilatero() {
        String excepted = "equilateral";

        triangle = new Triangle(12, 12, 12);
        assertEquals(excepted, triangle.classify(), "Como todos os lados são iguais o triangulo é equilatero");

        excepted = "isossceles";

        triangle.setSideLengths(1, 1, 2);
        assertEquals(excepted, triangle.classify(), "Como um dos lados é diferente dos outros dois o triangulo é isoceles e não equilatero");

    }

    @Test
    public void testTrianguloIsIsoceles() {
        String excepted = "isossceles";

        triangle = new Triangle(1, 1, 2);
        assertEquals(excepted, triangle.classify(), "Como um dos lados é diferente dos outros dois o triangulo é isoceles");

        /* Faile proposital
          triangle.setSideLengths(1, 3, 2);
        assertEquals(excepted, triangle.classify(), "Como todos os lados são diferentes o triangulo não é isoceles");
         * */
    }

    @Test
    public void testTrianguloIsRectangulo() {
        String excepted = "right-angled";
        triangle = new Triangle(5, 3, 4);
        assertEquals(excepted, triangle.classify(), "Como 5^2 = 3^2 + 4^2 o triangulo é retangulo");

        excepted = "scalene";
        triangle.setSideLengths(5, 3, 8);
        assertEquals(excepted, triangle.classify(), "O triangulo vai dar escaleno pois a soma do C^2 ≠ h^2 + h^2, mas é escaleno por causa da conta para ser escaleno");

        excepted = "equilateral";
        triangle.setSideLengths(1, 1, 1);
        assertEquals(excepted, triangle.classify(), "O triangulo vai dar equilatero pois mesmo 1^2 = 1^2 + 1^2 a condição de ser equilatero aparece em 1º lugar");
    }

    @Test
    public void testTrianguloIsEscaleno() {
        //Se as 3 medidas forem diferentes não é escaleno
        String excepted = "scalene";
        triangle = new Triangle(5, 3, 8);
        assertEquals(excepted, triangle.classify(), "O triangulo vai dar escaleno pois a soma do C^2 ≠ h^2 + h^2, mas é escaleno por causa da conta para ser escaleno");
    }

    //Outros testes
    @Test
    public void testPerimter() {
        triangle = new Triangle(5, 3, 8);
        int excepted = 16;
        assertEquals(excepted, triangle.getPerimeter(), "O perimtero vai dar 16, porque 5 + 3 + 8 = 16");

        //Validar se aqui também é preciso um if
        triangle = new Triangle(0, 0, 0);
        excepted = -1;
        assertEquals(excepted, triangle.getPerimeter(), "O perimtero vai dar -1, porque o triangulo é impossível");
    }

    @Test
    public void testGetAreaTriangule() {
        triangle = new Triangle(7, 10, 5);
        double excepted = 16.24807680927192;
        assertEquals(excepted, triangle.getArea(), "O perimtero vai dar 16.25");

        triangle = new Triangle(0, 0, 0);
        excepted = -1;
        assertEquals(excepted, triangle.getArea(), "A area vai dar -1, porque o triangulo é impossível");
    }

    @Test
    public void testGetSideTrianguleAndGetSetSideTriangle() {
        triangle = new Triangle(7, 10, 5);
        String excepted = "7,10,5";
        assertEquals(excepted, triangle.getSideLengths(), "A string retornada vai ser: 7,10,5");

        triangle.setSideLengths(10, 5, 7);
        excepted = "10,5,7";
        assertEquals(excepted, triangle.getSideLengths(), "A string retornada vai ser: 10,5,7");
    }
}