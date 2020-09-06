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

        if (listSortNumber.size() > 0 && listSortNumber.get(0) == 0) {
            System.out.println(0);
        } else {
            for (Integer i : listSortNumber) {
                System.out.print(i);
            }
        }
    }

    public static List<Integer> sortArrBigNumber(List<Integer> listNumber, int low, int high) {
        int leftMarker = low;
        int rightMarker = high;
        int pivot = listNumber.get((leftMarker + rightMarker) / 2);
        do {
            while (listNumber.get(leftMarker) != pivot && isEquality(listNumber.get(leftMarker), pivot)) {
                leftMarker++;
            }

            while (listNumber.get(rightMarker) != pivot && !isEquality(listNumber.get(rightMarker), pivot)) {
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

        if (rightMarker > low)
            sortArrBigNumber(listNumber, low, rightMarker);

        return listNumber;
    }

    private static boolean isEquality(int num, int opora) {
        int firstNum = -1;
        int firstOpora = -1;
        int tempNum = num;
        int tempOpora = opora;

        while (true) {
            int numRaz = 0;
            int oporaRaz = 0;

            while (tempNum >= 10) {
                tempNum /= 10;
                numRaz++;
            }

            while (tempOpora >= 10) {
                tempOpora /= 10;
                oporaRaz++;
            }

            if (tempNum == tempOpora) {
                if (firstNum == -1)
                    firstNum = tempNum;

                if (firstOpora == -1)
                    firstOpora = tempOpora;

                if (numRaz >= 1 && oporaRaz >= 1) {
                    tempNum = num % (int) Math.pow(10, numRaz);
                    tempOpora = opora % (int) Math.pow(10, oporaRaz);

                    continue;
                } else if (numRaz >= 1) {
                   return isCompair(num, firstNum, numRaz);
                } else if (oporaRaz >= 1) {
                    return !isCompair(opora, firstOpora, oporaRaz);
                }
            }

            return tempNum > tempOpora;
        }
    }

    private static boolean isCompair(int num, int firstNum, int numRaz) {
        num %= (int) Math.pow(10, numRaz);
        int tempNum = num >= 10 ? num/10 : num;

        if (firstNum == tempNum) {
            tempNum = num >= 10 ? num%10 : num;
            return firstNum < tempNum;
        }

        return firstNum < tempNum;
    }
}
