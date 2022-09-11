package controler;

public class GridController {
	private ui.Board vueBoard = null;
	private ui.VueInput vueInput  = null;
	private game.CaseList caselistModel = null;
	private int newValueControl;

	public GridController(game.CaseList clModel) {
		caselistModel = clModel;
		vueBoard = new ui.Board(this, clModel);
		vueInput = new ui.VueInput(this);
		clModel.AjouterEcouteurValeur(vueBoard);
	}
	public void AfficherVues(){
        vueBoard.setVisible(true);
    }
	
	public void AfficherVueInput(int ligne, int colonne) {
		if (vueInput.getVueInputShown())
			return;
		vueInput.updateCoords(ligne, colonne);
		vueInput.setVueInputShown(true);
		vueInput.setVisible(true);
	}

	public void NotifierChangementValeur(int ligne, int colonne, int valeur){
		System.out.println("NotificationChangementValeur "+ ligne+" "+colonne+" valeur egale a "+valeur);
		caselistModel.SetValeur(ligne, colonne, valeur);
    }
	public game.CaseList getCaselistModel() {
		return caselistModel;
	}
	public void setCaselistModel(game.CaseList caselistModel) {
		this.caselistModel = caselistModel;
	}
	public int getNewValueControl() {
		return newValueControl;
	}
	public void setNewValueControl(int newValueControl) {
		this.newValueControl = newValueControl;
	}
}
