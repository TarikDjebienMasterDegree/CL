package russelBand.service.impl;

import java.util.Scanner;

import russelBand.service.IJoueur;
import russelBand.service.IPlateau;
import russelBand.service.IPorcelet;
import russelBand.util.Log;

public class JoueurImpl implements IJoueur{
	
	 
	private String nom ;
    private IPorcelet porcelet ; 
    private IPlateau plateau ;
    private boolean jokerUtilisable;
    
    /**
    * Constructeur de joueur
    * @param nom le nom du joueur
    */
    public JoueurImpl(String nom) {
        this.nom = nom;
        this.jokerUtilisable=true;
    }
    
    
    /** {@inheritDoc}**/
    public IPorcelet recupererPion(){
    	return porcelet;
    }
    
    /** {@inheritDoc}**/
    @Override
    public void strategieDeplacementCase() {
         this.plateau.deplacerPremiereCarte();
    }     
    
    
    /** {@inheritDoc}**/
    @Override
    public void choisirPorcelet(IPorcelet porcelet , IPlateau plateau) {
        this.porcelet = porcelet ;
        this.plateau = plateau;
        this.porcelet.initPosition(this.plateau.premiereCarte().premiereCase()); 
    }         
    
    
    
    
    /** {@inheritDoc}**/
    @Override
    public int lancerDes() {
        String keylist="1234" ; 
        String temp="" ; 
        int valeur = (int) Math.floor(Math.random()* keylist.length());
        temp += keylist.charAt(valeur) ; 
        return Integer.valueOf(temp);
    }        

    
     /** {@inheritDoc}**/
    @Override
    public void rejouer() {
        Log.logger().infoAvancerCaseSurCarte(
        		Integer.toString(porcelet.retourneLaCase().donneTonIndice()),
        		Integer.toString(porcelet.retourneLaCase().retourneLaCarte().donneTonNumero())
        		);
        Scanner sc = new Scanner(System.in) ;
        Log.logger().info("Voulez vous rejouer ? yes - no");
        String reponse = sc.nextLine().trim();
        if (reponse.equalsIgnoreCase("yes")){
            this.jouer();
        }
    }            
    
    public void appliquerStrategieDeplacementCarte() {
    	if(this.jokerUtilisable){
    	       Scanner sc = new Scanner(System.in) ;
    	       Log.logger().info("Voulez vous utiliser votre joker ? yes-no");
    	       String reponse = sc.nextLine().trim();
    	       if (reponse.equalsIgnoreCase("yes")){
    	            this.plateau.deplacerPremiereCarte();
    	            this.jokerUtilisable=false;
    	        }
    	}
    }
    
    /** {@inheritDoc}**/
    @Override
    public void jouer() {
        int chiffreObtenuParDes = this.lancerDes();
        Log.logger().infoResultatDes(nom, Integer.toString(chiffreObtenuParDes));
        if(chiffreObtenuParDes == 1){
        	this.porcelet.avancer();
            this.rejouer();
        }else{
            for(int i = 0 ; i<chiffreObtenuParDes ; i++){
                this.porcelet.avancer();
            }
            Log.logger().infoAvancerCaseSurCarte(
            		Integer.toString(porcelet.retourneLaCase().donneTonIndice()),
            		Integer.toString(porcelet.retourneLaCase().retourneLaCarte().donneTonNumero())
            		);
            this.appliquerStrategieDeplacementCarte();
        }
		if(porcelet.retourneLaCase().quiEstAuDessus() != porcelet){
			Log.logger().infoEstMonterSur(porcelet.quiEstEnDessous().quiEstMonMaitre().commentTuTapelles());
		}
		
    }

	@Override
	public String commentTuTapelles() {
		return nom;
	}      

}
