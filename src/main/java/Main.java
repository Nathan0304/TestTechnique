
import model.Ranges;
import utils.FileReaderPerso;
import utils.MarchingLabels;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileReaderPerso fileReader = new FileReaderPerso();
        String rangeFileName = "src/main/resources/intervalles.txt";
        String itemFileName = "src/main/resources/itemsATester.txt";
        if(args.length>0){
            rangeFileName = args[0];
            if(args.length>1){
                itemFileName = args[1];
            }else{
                System.out.println("Utilisation du fichier d'items par default");
            }
        }else{
            System.out.println("Utilisation des fichiers par default");
        }
        try{
            List<Ranges> rangesList = fileReader.readFileListeIntervals(rangeFileName);
            List<Integer> itemList = fileReader.readFileListeItems(itemFileName);
            MarchingLabels marchingLabels = new MarchingLabels(rangesList.toArray(Ranges[]::new));
            for(int item: itemList){
                System.out.printf("Les labels pour l'item %d sont : %s%n", item, marchingLabels.marchingLabels(item).toString());
            }
        }catch (Exception e){
            System.err.println("Erreur lors de la lecture d'un fichier");
            e.printStackTrace();
        }
    }
}