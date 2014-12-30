package batalhanaval;

import java.awt.Color;

/**
 * Classe Galeao - Representa o Navio do tipo Galeao
 *
 * @version 1.0
 * @author Sibelius Seraphini (Feitiço)
 * @author Fernando Sergent Maia (Violeta)
 */
public class Galeao extends Navio {
    /**
     * Constroi um <code>Galeao</code> com tamanho e cor pré-definidos
     */
    public Galeao() {
        setTamanho(1);
        setCor(Color.red);
    }
}
