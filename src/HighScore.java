import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HighScore {
    public static String fileName = "C:\\Users\\Hard Core Computing\\Desktop\\Space_Invaders\\src\\Ranking";
    List<Score> ranking;
    private static String delimiter = "-";
    public HighScore(){
        ranking = new ArrayList<Score>();
        BufferedReader Reader;
        FileReader rankingReader;
        try {
            rankingReader = new FileReader(fileName);
            Reader = new BufferedReader(rankingReader);
            String strCurrentLine;

            while ((strCurrentLine = Reader.readLine()) != null) {

                Score temp;
                String[] parts = strCurrentLine.split(delimiter);
                String name = parts[0];
                int score = Integer.parseInt(parts[1]);
                temp = new Score(name, score);
                ranking.add(temp);
            }
            sortRanking();

            Reader.close();
        } catch (IOException e) {
            System.out.println("File not Found");
        }
    }
    public void sortRanking(){
        ranking.sort(Comparator.comparingDouble(Score::getPoints).reversed());
    }
    public void addToFile(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (int i = 0; i < ranking.size(); i++) {
                Score x = ranking.get(i);
                String name = x.getName();
                writer.write(name + delimiter + x.getPoints());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void deleteLastScoreFromFile(){
        ranking.remove(9);
    }
    public void addScoreToRanking(Score score){
        ranking.add(score);
        sortRanking();
        for (int i = 0; i < ranking.size(); i++) {
            Score newScore = ranking.get(i);
            String name = newScore.getName();
            System.out.println(name + delimiter + newScore.getPoints());
        }

    }
    public boolean isHighScore(int score){
        int rankingSize = ranking.size();
        if (rankingSize < 10){
            return true;

        }
        return score > ranking.get(rankingSize - 1).getPoints();
    }
}
