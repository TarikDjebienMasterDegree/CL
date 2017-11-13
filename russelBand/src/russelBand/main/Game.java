package russelBand.main;

import java.util.List;

import java.util.ArrayList;
import java.util.Scanner;

import russelBand.factory.IJoueurFactory;
import russelBand.factory.IPorceletFactory;
import russelBand.factory.impl.JoueurImplFactory;
import russelBand.factory.impl.PorceletImplFactory;
import russelBand.service.ICase;
import russelBand.service.IJoueur;
import russelBand.service.IPlateau;
import russelBand.service.IPorcelet;
import russelBand.service.impl.PlateauImpl;
import russelBand.util.Log;

/**
 * @author djebien rakotobe
 */
public class Game {

	private int nbreJoueur;
	private final int longueurDuPlateau = 8;
	private IPlateau plateauDeJeu;
	private List<IJoueur> lesJoueurs;
	private IJoueurFactory fabriqueDeJoueurs;
	private IPorceletFactory fabriqueDePorcelet;

	/**
	 * Constructeur d'initialisation du jeu
	 * @param nbreJoueur le nombre de joueur
	 */
	public Game(int nbreJoueur){
		this.nbreJoueur=nbreJoueur;
		this.fabriqueDeJoueurs= new JoueurImplFactory();
		this.fabriqueDePorcelet= new PorceletImplFactory();
	}

	/**
	 * Initialise le plateau de jeu
	 */
	public void preparerPlateauDeJeu(){
		plateauDeJeu=new PlateauImpl(longueurDuPlateau);
	}

	/**
	 * Initialise les joueurs pour jouer au jeu
	 */
	public void preparerLesJoueurs(){
		this.lesJoueurs = new ArrayList<IJoueur>(nbreJoueur);
		for(int i=0;i<nbreJoueur;i++){
			String playerName = demanderNom(i+1);
			IJoueur playerToAdd = fabriqueDeJoueurs.create(playerName);
			IPorcelet pionDuJoueur = fabriqueDePorcelet.create();
			pionDuJoueur.setJoueur(playerToAdd);
			playerToAdd.choisirPorcelet(pionDuJoueur, plateauDeJeu);
			lesJoueurs.add(playerToAdd);
		}
	}

	/**
	 * Demande le nom du joueur 
	 * @param numeroJoueur le numero du joueur
	 * @return le nom du joueur selectionnee
	 */
	public String demanderNom(int numeroJoueur){
		Log.logger().info("Quel est le nom du joueur numero "+numeroJoueur);
		Scanner sc = new Scanner(System.in);
		String playerName = sc.nextLine();
		return playerName;
	}

	/**
	 * Methode de jeu du RusselBand
	 */
	public void play(){
		boolean partieTerminee = false;
		List<IJoueur> lesGagnants = new ArrayList<IJoueur>(nbreJoueur);
		do{
			for(IJoueur j : lesJoueurs){
				j.jouer();
			}
			ICase finDuParcours = plateauDeJeu.derniereCarte().troisiemeCase();
			for(IJoueur j : lesJoueurs){
				if(j.recupererPion().estSurLaCase(finDuParcours)){
					partieTerminee = true;
					lesGagnants.add(j);
				}
			}
		}while(!partieTerminee);
		for(IJoueur gagnant : lesGagnants){
			Log.logger().info(gagnant.commentTuTapelles()+" a gagne");
		}
	}
	
	/**
	 * Methode d'usage du programme JAVA pour jouer a russelBand
	 */
	public static void usage(){
		Log.logger().info("$java -jar russelband.jar <nbreJoueur>\n");
		Log.logger().info(" avec <nbreJoueur> = le nombre de joueurs de la partie");
	}

	public static void bienvenue(){
		Log.logger().info("***************************");
		Log.logger().info("Bienvenue dans RusselBand");
		Log.logger().info("***************************");
		Log.logger().info("Author : Djebien & Rakotobe");
		Log.logger().info("***************************");
	}
	/**
	 * Programme principal de notre jeu russelBand
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		try{
			bienvenue();
			
			int nbreJoueur = Integer.valueOf(args[0]);
			Game russelband = new Game(nbreJoueur);
			russelband.preparerPlateauDeJeu();
			russelband.preparerLesJoueurs();
			russelband.play();
		}catch(ArrayIndexOutOfBoundsException aioobe){
			usage();
			Thread.sleep(3000);
			System.exit(0);
		}
	}

}
