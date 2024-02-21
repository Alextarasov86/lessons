package homework.lesson06;

import java.util.Arrays;

public class Task5 {
    public static void main(String[] args) {
        int[] array = {88, 34, 12, 55, 90, 4, 4, 34, 4, 12, 10, 44, 0, 4, 0};
        int[] copyArray1 = new int[array.length];
        int[] copyArray2 = new int[array.length];
        int[] resArray = new int[array.length];
        int index1 = 0;
        int index2 = 0;
        int indexRes = 0;
        int count = 0;
//      Создаем один массив с уникальными эл-ми второй с повторениями
        for(int i = 0; i < array.length; i++){
            boolean flag = false;
            for(int j = i + 1; j < array.length; j++){
                if(array[i] == array[j]){
                    count++;
                    copyArray2[index2] = array[j];
                    index2++;
                    flag = true;
                    break;
                }
            }
            if(!flag){
                copyArray1[index1] = array[i];
                index1++;
            }
        }

//      Добавляем во второй массивы все неуникальные эл-ты массива array
        for(int i = 0; i < index1; i++){
            for(int j = 0; j < index2; j++){
                if(copyArray1[i] == copyArray2[j]){
                    copyArray2[index2] = copyArray1[i];
                    index2++;
                    break;
                }
            }
        }
//      Создаем массив только из уникальных эл-в
        for(int i = 0; i < index1; i++){
            boolean flag = false;
            for(int j = 0; j < index2; j++){
                if(copyArray1[i] == copyArray2[j]){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                resArray[indexRes] = copyArray1[i];
                indexRes++;
            }
        }

//      Создаем искомы массив
        int countRes = indexRes;
        for (int i = 0; i < array.length; i ++){
            boolean flag = false;
            for(int j = 0; j < countRes; j++){
                if(array[i] == resArray[j]){
                    flag =true;
                    break;
                }
            }
            if(!flag){
                resArray[indexRes] = array[i];
                indexRes++;
            }
        }

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(resArray));
   }
}
