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
        System.out.println(listSortNumber);
    }

    public static List<Integer> sortArrBigNumber(List<Integer> listNumber, int low, int high) {
        if (listNumber.size() == 0)
            return listNumber;

        if (low >= high)
            return listNumber;

        int middle = low + (high - low) / 2;
        int opora = listNumber.get(middle);

        int i = low, j = high;
        while (i <= j) {
            while (listNumber.get(i) > opora) {
                i++;
            }

            while (listNumber.get(j) < opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = listNumber.get(i);
                listNumber.set(i, listNumber.get(j));
                listNumber.set(j, temp);
                i++;
                j--;
            }
        }

        if (low < j)
            sortArrBigNumber(listNumber, low, j);

        if (high > i)
            sortArrBigNumber(listNumber, i, high);

        return listNumber;
    }
}
