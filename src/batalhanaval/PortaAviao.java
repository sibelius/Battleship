package batalhanaval;

import java.awt.Color;

/**
 * Classe PortaAviao - Representa o Navio do tipo PortaAviao
 *
 * @version 1.0
 * @author Sibelius Seraphini (Feitiço)
 * @author Fernando Sergent Maia (Violeta)
 */
public class PortaAviao extends Navio {
    /**
     * Constroi um <code>PortaAviao</code> com tamanho e cor pré-definidos
     */
    public PortaAviao() {
        setTamanho(4);
        setCor(Color.green);
    }
}
