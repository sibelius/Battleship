package batalhanaval;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * Classe Navio - pai de todos os tipos de navios
 *
 * @version 1.0
 * @author Sibelius Seraphini (Feitiço)
 * @author Fernando Sergent Maia (Violeta)
 */
public class Navio {

    /**
     * O ponto <code> Point </code> que representa a posição do navio
     * no <code> Oceano </code>
     */
    private Point pos;

    /**
     * Representa o tamanho do Navio
     */
    private int tamanho;

    /**
     * Representa o tamanho atual após ser acertado
     */
    private int tamAtual;

    /**
     * Representa a cor do Navio
     */
    private Color cor;

    /**
     * Enum que representa as possíveis direções do navio
     */
    public enum Direcao {
        /**
         * Direção Vertical
         */
        Cima_Baixo,

        /**
         * Direção Horizontal
         */
        Esquerda_Direita
    }

    /**
     * Representa a Direção do Navio
     */
    private Direcao dir;

    /**
     * Constroi um novo Navio com a direção inicial horizontal
     *
     */
    public Navio() {
        setDirecao(Direcao.Esquerda_Direita);
    }

    /**
     * Retorna a posição do Navio
     * @return um <code>Point</code> representando a posição do Navio
     */
    public Point getPos() {
        return pos;
    }

    /**
     * Define a posição do Navio
     * @param pos um <code>Point</code> que representa a posição do Navio
     */
    public void setPos(Point pos) {
        this.pos = pos;
    }

    /**
     * Retorna o tamanho do Navio
     * @return um inteiro representando o tamanho do navio
     */
    public int getTamanho() {
        return tamanho;
    }

    /**
     * Define o tamanho do Navio
     * @param tamanho um inteiro que representa o tamanho do Navio
     */
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
        setTamAtual(this.tamanho);
    }

    /**
     * Retorna o tamanho atual do Navio
     * @return um inteiro que representa o tamanho atual do Navio
     */
    public int getTamAtual() {
        return tamAtual;
    }

    /**
     * Define o tamanho atual do Navio
     * @param tamAtual - um inteiro que representa o tamanho atual do Navio
     */
    public void setTamAtual(int tamAtual) {
        this.tamAtual = tamAtual;
    }

    /**
     * Retorna a cor do Navio
     * @return Uma <code>Color</code> que representa a cor do Navio
     */
    public Color getCor() {
        return cor;
    }

    /**
     * Define a cor do Navio
     * @param cor - Uma <code>Color</code> que representa a cor do Navio
     */
    public void setCor(Color cor) {
        this.cor = cor;
    }

    /**
     * Retorna a direção do Navio
     * @return Uma <code>Direcao</code> que representa a direção do Navio
     */
    public Direcao getDirecao() {
        return dir;
    }

    /**
     * Define a direção do Navio
     * @param dir - Uma <code>Direcao</code> que representa a direção do Navio
     */
    public void setDirecao(Direcao dir) {
        this.dir = dir;
    }

    /**
     * Verifica se um ponto está contido no Navio
     * @param p - Um <code>Point</code> que representa o ponto a ser verificado
     * @return true caso esteja contido
     *         false caso não esteja contido
     */
    public boolean Contem(Point p) {
        if(dir == Direcao.Cima_Baixo) {
            if( (p.getX() != getPos().getX()) ||
              (p.getY() < getPos().getY()) ||
              (p.getY() > getPos().getY() + getTamanho()-1))
                return false;

        } else { //ESQUERDA_DIREITA
            if( (p.getY() != getPos().getY()) ||
              (p.getX() < getPos().getX()) ||
              (p.getX() > getPos().getX() + getTamanho()-1))
                return false;
        }

        return true;
    }

    /**
     * Verifica se dois navios ocupam posições conflitantes
     * @param n - Um <code>Navio</code> a ser comparado com o this
     * @return true caso as posições sejam conflitantes
     *         false caso as posições não sejam conflitantes
     */
    public boolean Colidiu(Navio n) {
        for(int i=0; i<n.getTamanho(); i++) {

            if(n.getDirecao() == Navio.Direcao.Esquerda_Direita) {
               Point aux = new Point((int)n.getPos().getX()+i,(int) n.getPos().getY());

               if(this.Contem(aux))
                   return true;
            } else {
               Point aux = new Point((int)n.getPos().getX(),(int) n.getPos().getY()+i);

               if(this.Contem(aux))
                   return true;
            }
        }

        return false;
    }

    /**
     * Desenha o Navio
     * @param g - Um <code>Graphics2D</code> responsável pelo desenho do Navio
     */
    public void desenhar(Graphics2D g) {
        g.setPaint(cor);

        for(int i=0; i<tamanho; i++) 
           if(dir == Direcao.Esquerda_Direita)
               g.fill(new Rectangle((int) pos.getX()*40 + i*40+1,(int) pos.getY()*40+1, 39,39));
           else
               g.fill(new Rectangle((int) pos.getX()*40 + 1,(int) pos.getY()*40 + i*40+1, 39,39));
    }
}
