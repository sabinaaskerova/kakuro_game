import controler.GridController;
import game.CaseList;

public class Test {
	public static void main(String[] args)
    {
		CaseList cl = new CaseList();
		GridController gc = new GridController(cl);
		gc.AfficherVues();
    }
}
