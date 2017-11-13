package russelBand.util;

public class Log {
	
	private static Log logger = new Log();
	
	private Log(){}
	
	public static Log logger(){
		return logger;
	}
	
	public void info(String message){
		System.out.println(message);
	}
	
	public void infoResultatDes(String playerName, String resultatDes){
		System.out.println("[Le joueur "+playerName+" lance le de, il obtient "+resultatDes+"]");
	}
	
	public void infoAvancerCaseSurCarte(String caseNumber, String carteNumber){
		int numCase = Integer.parseInt(caseNumber)+1;
		int numCarte = Integer.parseInt(carteNumber)+1;
		System.out.println(
				"[Il avance sur la case numero "+numCase+", "+
				"il atterit sur la carte numero "+numCarte+"]"
				);
	}
		
	public void infoEstMonterSur(String playerName){
		System.out.println("[Il monte sur le porcelet du joueur "+playerName+"]");
	}

}