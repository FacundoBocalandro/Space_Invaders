import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

    public class Ranking {
        private String fileName = ".\\src\\Ranking.txt";
        private List<Score> ranking;
        private int rankingSize = 10;
        private String delimiter = "-";

        public Ranking() {
            ranking = new ArrayList<>(rankingSize);
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
                ranking.sort(Comparator.comparingDouble(Score::getPoints).reversed());

                Reader.close();
            } catch (IOException e) {
                System.out.println("File not Found");
            }
        }
        public void render(Graphics g){
            Ranking ranking = new Ranking();
            List<Ranking.Score> highscores = ranking.getRanking();
            g.setColor(Color.green);
            g.setFont(new Font("asd",Font.PLAIN,20));
            g.drawLine(20,20,118,20);
            g.drawString("Highscores:",20,18);
            g.setColor(Color.white);
            g.setFont(new Font("a",Font.ITALIC,14));
            for (int i = 0; i <highscores.size() ; i++) {
                g.drawString(highscores.get(i).getName()+ "   " + highscores.get(i).getPoints(),20,15*i+35);
            }
        }

        public void addScore(Score score) {
                int points = score.getPoints();
                String name = score.getName();
                FileWriter fileWriter;
                BufferedWriter writer;

                try {
                    fileWriter = new FileWriter(fileName, true);
                    writer = new BufferedWriter(fileWriter);
                    writer.newLine();
                    writer.write(name + "-" + points);
                    deleteWorstScore();
                    writer.flush();

                } catch (IOException e) {

                }

        }

        public void deleteWorstScore(){
            String inputFileName = fileName;
            String outputFileName = ".\\src\\temp.txt";
            String lineToRemove = ranking.get(ranking.size()-1).getName()+"-"+ranking.get(ranking.size()-1).getPoints();

            try {
                File inputFile = new File(inputFileName);
                File outputFile = new File(outputFileName);

                try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                     BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (!line.equals(lineToRemove)) {
                            writer.write(line);
                            writer.newLine();
                        }
                    }
                }

                if (inputFile.delete()) {

                    if (!outputFile.renameTo(inputFile)) {
                        throw new IOException("Could not rename " + outputFileName + " to " + inputFileName);
                    }
                } else {
                    throw new IOException("Could not delete original input file " + inputFileName);
                }
            } catch (IOException ex) {

                ex.printStackTrace();
            }
        }

        public boolean isHighScore(Score score){
            return (score.getPoints() > ranking.get(ranking.size()-1).getPoints());
        }


        public List<Score> getRanking() {
            return ranking;
        }


        public static class Score {
            private String name;
            private int points;


            public Score(String name, int points) {
                this.name = name;
                this.points = points;
            }

            public String getName() {
                return name;
            }

            public int getPoints() {
                return points;
            }
        }

}
