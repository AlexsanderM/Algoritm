package sort.practic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BigNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int lengthArr = Integer.parseInt(buf.readLine());
        List<String> list = Arrays.asList(buf.readLine().trim().split(" "));
        List<Integer> listNumber = list.stream().map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> listSortNumber = sortArrBigNumber(listNumber, 0, lengthArr - 1);
        listSortNumber.forEach(System.out::print);
    }

    public static List<Integer> sortArrBigNumber(List<Integer> listNumber, int low, int high) {
        int leftMarker = low;
        int rightMarker = high;
        int pivot = listNumber.get((leftMarker + rightMarker) / 2);
        do {
            while (listNumber.get(leftMarker) != pivot && isEquality(listNumber.get(leftMarker), pivot)) { //*/ (listNumber.get(leftMarker) < pivot) {
                leftMarker++;
            }

            while (listNumber.get(rightMarker) != pivot && !isEquality(listNumber.get(rightMarker), pivot)) { //*/ (listNumber.get(rightMarker) > pivot) {
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

    private static boolean isEquality(int num, int opora) {
        int firstNum = num;
        int secondNum = opora;
        int firstRaz = 0;
        int secondRaz = 0;

        while (firstNum >= 10) {
            firstNum /= 10;
            firstRaz++;
        }

        while (secondNum >= 10) {
            secondNum /= 10;
            secondRaz++;
        }

        if (firstNum == secondNum) {
            if (firstRaz >= 1 && secondRaz >= 1) {
                num %= (int)Math.pow(10, firstRaz);
                opora = opora % (int)Math.pow(10, secondRaz);

                return isEquality(num, opora);
            } else if (firstRaz >= 1) {
                num %= (int)Math.pow(10, firstRaz);
                int temp = num;

                while (temp >= 10)
                    temp /= 10;

                if (temp == opora)
                    isEquality(num, opora);

                return temp > opora;
            } else if (secondRaz >= 1) {
                opora %= (int)Math.pow(10, secondRaz);
                int temp = num;

                while (temp >= 10)
                    temp /= 10;

                if (temp == num)
                    isEquality(num, opora);

                return temp > opora;
            }
        }

        return firstNum > secondNum;
    }
}
