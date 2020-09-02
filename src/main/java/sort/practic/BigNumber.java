package sort.practic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BigNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int lengthArr = Integer.parseInt(buf.readLine());
        List<String> list = Arrays.asList(buf.readLine().trim().split(" "));

        List<Integer> listNumber = new ArrayList<>();

        for (String s : list)
            listNumber.add(Integer.parseInt(s));

        List<Integer> listSortNumber = sortArrBigNumber(listNumber, 0, lengthArr - 1);

        for (Integer i : listSortNumber)
            System.out.print(i);
    }

    public static List<Integer> sortArrBigNumber(List<Integer> listNumber, int low, int high) {
        int leftMarker = low;
        int rightMarker = high;
        int pivot = listNumber.get((leftMarker + rightMarker) / 2);
        do {
            while (listNumber.get(leftMarker) != pivot && isEquality(listNumber.get(leftMarker), pivot, -1)) { //*/ (listNumber.get(leftMarker) < pivot) {
                leftMarker++;
            }

            while (listNumber.get(rightMarker) != pivot && !isEquality(listNumber.get(rightMarker), pivot, -1)) { //*/ (listNumber.get(rightMarker) > pivot) {
                rightMarker--;
            }

            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    int tmp = listNumber.get(leftMarker);
                    listNumber.set(leftMarker, listNumber.get(rightMarker));
                    listNumber.set(rightMarker, tmp);
                }

                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        if (leftMarker < high)
            sortArrBigNumber(listNumber, leftMarker, high);

        if (low < rightMarker)
            sortArrBigNumber(listNumber, low, rightMarker);

        return listNumber;
    }

    private static boolean isEquality(int num, int opora, int firstNumber) {
        int firstNum = num;
        int firstOpora = opora;
        int firstNumRaz = 0;
        int firstOporaRaz = 0;

        while (firstNum >= 10) {
            firstNum /= 10;
            firstNumRaz++;
        }

        while (firstOpora >= 10) {
            firstOpora /= 10;
            firstOporaRaz++;
        }

        if (firstNum == firstOpora) {
            if (firstNumRaz >= 1 && firstOporaRaz >= 1) {
                num %= (int) Math.pow(10, firstNumRaz);
                opora %= (int) Math.pow(10, firstOporaRaz);

                return isEquality(num, opora, firstNum);
            } else if (firstNumRaz >= 1) {
                if (firstNumber != -1)
                    opora = firstNumber;

                num %= (int) Math.pow(10, firstNumRaz);
                int temp = num;

                while (temp >= 10)
                    temp /= 10;

                if (temp == opora)
                    isEquality(num, opora, firstNumber);

                return temp > opora;
            } else if (firstOporaRaz >= 1) {
//                if (firstNumber != 1)
//                    num = firstNumber;

                opora %= (int) Math.pow(10, firstOporaRaz);
                int temp = opora;

                while (temp >= 10)
                    temp /= 10;

                if (temp == num)
                    isEquality(num, opora, firstNumber);

                return temp < num;
            }
        }

        return firstNum > firstOpora;
    }
}
