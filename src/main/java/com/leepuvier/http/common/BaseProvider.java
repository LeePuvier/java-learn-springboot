package com.leepuvier.http.common;

import com.leepuvier.http.utils.ExcelUitls;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author : LeePuvier
 * @CreateTime : 2019/12/24  7:50 PM
 * @ContentUse :
 */
public class BaseProvider {

    @DataProvider(name = "createOrder")
    public Iterator<Object[]> createOrder() throws IOException {
        List<String> lables = new ArrayList<>();
        lables.add("0级");
        lables.add("1级");
        ArrayList<Object[]> testdata = ExcelUitls.getTestData(ExcelConstant.createOrder, "createorder", lables);
        return testdata.iterator();
    }
}
