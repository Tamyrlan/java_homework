package home_work4;

import java.util.LinkedList;
import java.util.Random;

    /**
    *  Методы реализующие решение задачи
    */
public class model {
    int [] pointStart = new int[4];
    int [] pointFinishFirst = new int[4];
    int [] pointFinishSecond = new int[4];
    int [][] indexs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

  
    public int[][] createMap(int[] size){
        int[][] map = new int [size[0]][size[1]];

        for (int i = 0; i < size[1]; i++) map[0][i] = -1;
        for (int i = 0; i < size[1]; i++) map[size[0] - 1][i] = -1;
        for (int i = 0; i < size[0]; i++) map[i][0] = -1;
        for (int i = 0; i < size[0]; i++) map[i][size[1] - 1] = -1;

        Random random = new Random();
        int temp;

        for(int i = 1; i < size[0] - 1; i++){
            for(int j = 1; j < size[1] - 1; j++){
                temp = random.ints(0, 8).findFirst().getAsInt();
                if (temp == 7) map[i][j] = -1;
            }
        }
        int start = -2;
        int finish = -3;
        pointStart = choosePoint(start, map);
        pointFinishFirst = choosePoint(finish, map);
        pointFinishSecond = choosePoint(finish, map);
        return map;
    }

    public void fillMap(int[][] map){
        LinkedList<int[]> pointOnMap = new LinkedList<int[]>();
        pointOnMap.offer(pointStart);
        while(pointOnMap.peek() != null){
            int[] currentPoint = pointOnMap.poll();
            for (int i = -1; i < 2; i++){
                for (int j = -1; j < 2; j++){
                    if(map[currentPoint[0] + i][currentPoint[1] + j] == 0){
                        int[] temp = new int [3];
                        temp[0] = currentPoint[0] + i;
                        temp[1] = currentPoint[1] + j;
                        temp[2] = currentPoint[2] + 1;
                        pointOnMap.offer(temp);
                        map[currentPoint[0] + i][currentPoint[1] + j] = temp[2];
                    }
                }
            }
        }
    }

    public void searchWay(int[][] map){
        searchMinValue(pointFinishFirst, map);
        searchMinValue(pointFinishSecond, map);
        int min = 0;
        int[] currentPoint = new int [2];
        if(pointFinishFirst[2] < pointFinishSecond[2]){
            currentPoint[0] = pointFinishFirst[0] + indexs[pointFinishFirst[3]][0];
            currentPoint[1] = pointFinishFirst[1] + indexs[pointFinishFirst[3]][1];
            min = pointFinishFirst[2];
        }
        else{
            currentPoint[0] = pointFinishSecond[0] + indexs[pointFinishSecond[3]][0];
            currentPoint[1] = pointFinishSecond[1] + indexs[pointFinishSecond[3]][1];
            min = pointFinishSecond[2];
        }
        map[currentPoint[0]][currentPoint[1]] = -4;

        while (min > 0){
            for (int i = 0; i < 8; i++){
                if(map[currentPoint[0] + indexs[i][0]][currentPoint[1] + indexs[i][1]] < min
                && (map[currentPoint[0] + indexs[i][0]][currentPoint[1] + indexs[i][1]] > 0 || map[currentPoint[0] + indexs[i][0]][currentPoint[1] + indexs[i][1]] == -2)){
                    min = map[currentPoint[0] + indexs[i][0]][currentPoint[1] + indexs[i][1]];
                    currentPoint[0] = currentPoint[0] + indexs[i][0];
                    currentPoint[1] = currentPoint[1] + indexs[i][1];
                    if (min == -2);
                    else map[currentPoint[0]][currentPoint[1]] = -4;
                    break;
                }
            }  
        }   
    }


    public int[] choosePoint(int sign, int[][] map){
        int sizeY = map.length - 1;
        int sizeX = map[0].length - 1;
        int coordinateY;
        int coordinateX;
        int[] point = new int [4]; 
        boolean check = false;
        Random random = new Random();
        while(!check){
            coordinateY = random.ints(1, sizeY).findFirst().getAsInt();
            coordinateX = random.ints(1, sizeX).findFirst().getAsInt();
            if(map[coordinateY][coordinateX] == 0){
                map[coordinateY][coordinateX] = sign;
                point[0] = coordinateY;
                point[1] = coordinateX;
                point[2] = 0;
                point[3] = 0;
                check = true;
            } 
        }
        return point;
    }

    public void searchMinValue(int[] point, int[][] map){
        for (int i = 0; i < 8; i++){
                if(map[point[0] + indexs[i][0]][point[1] + indexs[i][1]] > 0 && point[2] > map[point[0] + indexs[i][0]][point[1] + indexs[i][1]]){
                    point[2] = map[point[0] + indexs[i][0]][point[1] + indexs[i][1]];
                    point[3] = i;
                }
                else if(map[point[0] + indexs[i][0]][point[1] + indexs[i][1]] > 0 && point[2] == 0){
                    point[2] = map[point[0] + indexs[i][0]][point[1] + indexs[i][1]];
                    point[3] = i;
            }
        }
    }
}