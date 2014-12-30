package batalhanaval;

import java.awt.Color;

/**
 * Classe Cruzador - Representa o Navio do tipo Cruzador
 *
 * @version 1.0
 * @author Sibelius Seraphini (Feitiço)
 * @author Fernando Sergent Maia (Violeta)
 */
public class Cruzador extends Navio {
    /**
     * Constroi um <code>Cruzador</code> com tamanho e cor pré-definidos
     */
    public Cruzador() {
        setTamanho(2);
        setCor(new Color(150, 150, 150));
    }
}
