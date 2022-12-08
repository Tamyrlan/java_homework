package home_work4;

public class controller {
    public static void run(){
        int height = 30;
        int width = 40;
        int[] size = {height, width};
        model currentGame = new model();
        int[][] map = currentGame.createMap(size);
        currentGame.fillMap(map);
        currentGame.searchWay(map);
        view.drawMap(map);
    }
}