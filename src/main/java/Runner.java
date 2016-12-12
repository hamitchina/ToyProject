import Service.FileHandler;
import Service.RobotNameComparator;
import Model.Manufacturer;
import Model.Robot;
import Model.RobotType;
import org.apache.log4j.Logger;
import Service.RobotHandler;

import java.util.*;

public class Runner {


    public static void main(String[] args) {

        Logger logger = Logger.getLogger(Runner.class);
//        logger.info("info");
//        logger.debug("debug");
//        logger.warn("warn");
//        logger.error("error");
//
//        //СЛОЖЕНИЕ И ВЫЧИТАНИЕ МАТРИЦ
//        //n - размерность матриц
//        int n = 2;
//        int[][] A,B,C;
//        A = new int[n][n];
//        B = new int[n][n];
//        C = new int[n][n];
//        int i,j;
//        //заполняем рандомными значениями матрицы А и В
//        System.out.println("Матрица А:");
//        for(i = 0; i < n; i++){
//            for(j = 0; j < n; j++){
//                A[i][j] = (int)(Math.random() * n * 10);
//                System.out.print(A[i][j] + (j == n - 1?"\n":"\t"));
//            }
//        }
//        System.out.println("Матрица B:");
//        for(i = 0; i < n; i++){
//            for(j = 0; j < n; j++){
//                B[i][j] = (int)(Math.random() * n * 10);
//                System.out.print(B[i][j] + (j == n - 1?"\n":"\t"));
//            }
//        }
//        //складываем матрицы А и В
//        System.out.println("Сумма матриц A и B:");
//        for(i = 0; i < n; i++){
//            for(j = 0; j < n; j++){
//                C[i][j] = A[i][j] + B[i][j];
//                System.out.print(C[i][j] + (j == n - 1?"\n":"\t"));
//            }
//        }
//        //вычитаем матрицу В из матрицы А
//        System.out.println("Разность матриц A и B:");
//        for(i = 0; i < n; i++){
//            for(j = 0; j < n; j++){
//                C[i][j] = A[i][j] - B[i][j];
//                System.out.print(C[i][j] + (j == n - 1?"\n":"\t"));
//            }
//        }
//
////        //УМНОЖЕНИЕ МАТРИЦ
////        //размерности матриц (n - количество строк матрицы А; m - количество столбцов/строк матрицы А/B; l - количество столбцов матрицы B)
////        int n = 3,m = 2,l = 3;
////        //сами матрицы
////        int[][] A,B,C;
////        A = new int[n][m];
////        B = new int[m][l];
////        C = new int[n][l];
////        int i,j,k;
////        //заполняем матрицы А,В
////        System.out.println("Матрица А:");
////        for(i=0; i < n; i++){
////            for(j = 0; j < m; j++){
////                A[i][j] = (int)(Math.random() * n * 10);
////                System.out.print(A[i][j] + (j == m - 1?"\n":"\t"));
////            }
////        }
////        System.out.println("Матрица B:");
////        for(i = 0; i < m; i++){
////            for(j=0;j<l;j++){
////                B[i][j] = (int)(Math.random()*n*10);
////                System.out.print(B[i][j] + (j == l - 1?"\n":"\t"));
////            }
////        }
////        //записываем произведение двух матриц в матрицу С
////        System.out.println("Произведение матриц A и B:");
////        for(i = 0; i < n; i++){
////            for(j = 0; j < l; j++){
////                for(k = 0; k < m; k++){
////                    C[i][j] += A[i][k] * B[k][j];
////                }
////                System.out.print(C[i][j] + (j == l - 1?"\n":"\t"));
////            }
////        }
//
//
////вызов метода sound
//        Robot man = new Robot();
//        man.setType(RobotType.HUMAN);
//        man.sound();


// работа со списком роботов ArrayList
        ArrayList<Robot> robotArrayList = new ArrayList<>();
        robotArrayList.add(new Robot(5500, "Optimus Prime", "red", RobotType.TRANSFORMER, false, 200));
        robotArrayList.add(new Robot(5000, "Bumblebee", "yellow", RobotType.TRANSFORMER, true, 150));
        robotArrayList.add(new Robot(6000, "Megatron", "blue", RobotType.TRANSFORMER, true, 210));
        robotArrayList.add(new Robot(6000, "Megatron", "blue", RobotType.TRANSFORMER, true, 210));
        robotArrayList.add(new Robot(8000, "Megatron", "blue", RobotType.TRANSFORMER, true, 250));

        String readFromResource = "newFile";
        String readFromFileSystem = "C:\\newFile.txt";

        logger.info(RobotHandler.presentRobotsAsString(robotArrayList));

        RobotHandler.exportRobotsToFile(readFromFileSystem, robotArrayList);

        logger.info(RobotHandler.getRobotsAsStringFromFile(readFromFileSystem, FileHandler.StoreType.FILESYSTEM));

        List<Robot> robots = RobotHandler.deserializeRobotsFromString(
                RobotHandler.getRobotsAsStringFromFile(readFromFileSystem, FileHandler.StoreType.FILESYSTEM));

        if (robots != null){
            logger.info(robots.toString());
        }
//
//        Collections.sort(robotArrayList, new RobotNameComparator());
//        for (Robot robot : robotArrayList) {
//            System.out.println(robot.getToyName());
//        }
//
//// работа со списком роботов Set
//            Set<Robot> robotSet = new HashSet<>();
//            robotSet.add(new Robot(5500, "Optimus Prime", "red", RobotType.TRANSFORMER, true, 200));
//            robotSet.add(new Robot(5000, "Bumblebee", "yellow", RobotType.TRANSFORMER, true, 150));
//            robotSet.add(new Robot(6000, "Megatron", "blue", RobotType.TRANSFORMER, true, 210));
//            robotSet.add(new Robot(6000, "Megatron", "blue", RobotType.TRANSFORMER, true, 210));
//            System.out.println(robotSet);
//
////работа c Map
//            Map<Robot, Manufacturer> robotManufacturerMap = new HashMap<>();
//
//            Robot robot1 = new Robot(3000, "Dog", "grey", RobotType.ANIMAL, true, 200);
//            Robot robot2 = new Robot(2000, "Policeman", "beige", RobotType.HUMAN, true, 200);
//
//            Manufacturer manufacturer1 = new Manufacturer("Silverlit", "The USA");
//            Manufacturer manufacturer2 = new Manufacturer("XayWay", "China");
//
//            robotManufacturerMap.put(robot1, manufacturer1);
//            robotManufacturerMap.put(robot2, manufacturer2);
//            System.out.println(robotManufacturerMap);
//
//        //Добавить логику по нахождению объектов, соотвествующих какому-то критерию. Добавить логику по удалению объектов, которые соотвествуют переданному критерию.
//        Iterator<Robot> iterator = robotArrayList.iterator();
//        while (iterator.hasNext()) {
//            if (iterator.next().isHasLight() == false) {
//                iterator.remove();
//            }
//        }
//        System.out.println(robotArrayList);
    }
}







