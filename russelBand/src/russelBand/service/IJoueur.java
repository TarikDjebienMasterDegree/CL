package russelBand.service;

public interface IJoueur {
	
    /**
    * Methode permettant a un joueur de rejouer s'il a fait un 1 aux des
    */    
    public void rejouer();  
    
    /**
     * Methode permettant a un joueur lors du jeu de deplacer
     * la carte du debut vers la fin pour empecher un autre joueur de gagner
     */
    public void strategieDeplacementCase();    
    
    /**
     * Methode permettant a un joueur de lancer les dés
     */
    public int lancerDes();
   
    /**
     * Methode permettant a un joueur de jouer son tour
     */
    public void jouer();
    
    /**
     * Methode permettant a un joueur de choisir son porcelet sur le plateau
     * @param porcelet le porcelet a attribuer au joueur
     * @param plateau le pleateau sur lequel le joueur joue la partie
     */
     public void choisirPorcelet(IPorcelet porcelet , IPlateau plateau);
     
     /**
      * Recupere le porcelet du joueur
      * @return le porcelet du joueur
      */
     public IPorcelet recupererPion();
     
     /**
      * Demande son nom au joueur
      * @return le nom du joueur
      */
     public String commentTuTapelles();

}
