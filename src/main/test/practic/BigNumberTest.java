package practic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sort.practic.BigNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BigNumberTest {
    List<Integer> list = new ArrayList<>();

    @Test
    public void sortArrBigNumberTest() {
        list.add(1);
        list.add(2);
        list.add(5);

        List<Integer> num = BigNumber.sortArrBigNumber(list, 0, list.size() - 1);
        String strNum = getStringFromArr(num);

        Assert.assertEquals("521", strNum);
    }

    @Test
    public void sortArrBigNumberTest2() {
        list.add(1);
        list.add(783);
        list.add(2);

        List<Integer> num = BigNumber.sortArrBigNumber(list, 0, list.size() - 1);
        String strNum = getStringFromArr(num);

        Assert.assertEquals("78321", strNum);
    }

    @Test
    public void sortArrBigNumberTest3() {
        list.add(999);
        list.add(95);
        list.add(9);

        List<Integer> num = BigNumber.sortArrBigNumber(list, 0, list.size() - 1);
        String strNum = getStringFromArr(num);

        Assert.assertEquals("999995", strNum);
    }

    @Test
    public void sortArrBigNumberTest4() {
        list.add(9);
        list.add(999);
        list.add(95);

        List<Integer> num = BigNumber.sortArrBigNumber(list, 0, list.size() - 1);
        String strNum = getStringFromArr(num);

        Assert.assertEquals("999995", strNum);
    }

    @Test
    public void sortArrBigNumberTest5() {
        list.add(9);
        list.add(95);
        list.add(999);

        List<Integer> num = BigNumber.sortArrBigNumber(list, 0, list.size() - 1);
        String strNum = getStringFromArr(num);

        Assert.assertEquals("999995", strNum);
    }

    @Test
    public void sortArrBigNumberTest6() {
        list.add(3);
        list.add(1);
        list.add(13);
        list.add(34);
        list.add(8);

        List<Integer> num = BigNumber.sortArrBigNumber(list, 0, list.size() - 1);
        String strNum = getStringFromArr(num);

        Assert.assertEquals("8343131", strNum);
    }

    @Test
    public void sortArrBigNumberTest7() {
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(1);
        list.add(7);

        List<Integer> num = BigNumber.sortArrBigNumber(list, 0, list.size() - 1);
        String strNum = getStringFromArr(num);

        Assert.assertEquals("71000", strNum);
    }

    @Test
    public void sortArrBigNumberTest8() {
        String[] str = {"3", "1", "7", "8", "9", "2", "4", "6", "5", "0", "15", "29", "32", "41",
                "551", "56", "671", "671", "782", "7820", "88", "880", "91", "912"};

        Arrays.stream(str).forEach(e -> list.add(Integer.parseInt(e)));

        List<Integer> num = BigNumber.sortArrBigNumber(list, 0, list.size() - 1);
        String strNum = getStringFromArr(num);

        Assert.assertEquals("9919128888807827820767167165655514413322921510", strNum);
    }

    @Test
    public void sortArrBigNumberTest9() {
        list.add(9);
        list.add(91);
        list.add(912);

        List<Integer> num = BigNumber.sortArrBigNumber(list, 0, list.size() - 1);
        String strNum = getStringFromArr(num);

        Assert.assertEquals("991912", strNum);
    }

    @Test
    public void sortArrBigNumberTest10() {
        list.add(912);
        list.add(9);
        list.add(91);

        List<Integer> num = BigNumber.sortArrBigNumber(list, 0, list.size() - 1);
        String strNum = getStringFromArr(num);

        Assert.assertEquals("991912", strNum);
    }

    private String getStringFromArr(List<Integer> num) {
        String strNum = "";

        for (Integer i : num) {
            strNum = strNum + i;
        }

        return strNum;
    }
}
