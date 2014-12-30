package batalhanaval;

import java.awt.Color;

/**
 * Classe Torpedeiro - Representa o Navio do tipo Torpedeiro
 *
 * @version 1.0
 * @author Sibelius Seraphini (Feitiço)
 * @author Fernando Sergent Maia (Violeta)
 */
public class Torpedeiro extends Navio {
    /**
     * Constroi um <code>Torpedeiro</code> com tamanho e cor pré-definidos
     */
    public Torpedeiro() {
        setTamanho(3);
        setCor(Color.orange);
    }
}
