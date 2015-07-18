package org.usc.demo.guava.sub;

import java.util.List;

import org.apache.commons.lang3.EnumUtils;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

/**
 *
 * @author Shunli
 */
public class Test {

    public static void main(String[] args) {
        QueryBy by = QueryBy.UID.withId("xxxx");
        System.out.println(by);
        System.out.println(by.getId());
        System.out.println(QueryBy.CID.withId("uuuu").getId());
        System.out.println(by.getId());

        QueryByFactory factory = EnumUtils.getEnum(QueryByFactory.class, by.name());
        if (factory != null) {
            factory.query();
        } else {
            // null;
        }

        List<AbstractGoods> ccyGoodsList = Lists.newArrayList();
        ccyGoodsList.add(new CurrencyGoods(CurrencyGoodsType.GOLD, 20));
        ccyGoodsList.add(new CurrencyGoods(CurrencyGoodsType.INGOT, 30));
        ccyGoodsList.add(new CurrencyGoods(CurrencyGoodsType.BOUND_GOLD, 40));
        ccyGoodsList.add(new CurrencyGoods(CurrencyGoodsType.BOUND_INGOT, 50));

        List<AbstractGoods> itemGoodsList = Lists.newArrayList();
        itemGoodsList.add(new ItemGoods("20000000", 1, false));
        itemGoodsList.add(new ItemGoods("20000001", 1, false));
        itemGoodsList.add(new ItemGoods("20000002", 1, false));
        itemGoodsList.add(new ItemGoods("20000003", 1, false));
        itemGoodsList.add(new ItemGoods("20000004", 1, false));
        itemGoodsList.add(new ItemGoods("20000005", 1, false));

        test1(ccyGoodsList, itemGoodsList);
        System.out.println();
        test2(ccyGoodsList, itemGoodsList);
    }

    private static void test1(List<AbstractGoods> ccyGoodsList, List<AbstractGoods> itemGoodsList) {
        List<List<AbstractGoods>> goods = Lists.newArrayList();
        for (List<AbstractGoods> list : Lists.partition(itemGoodsList, 5)) {
            goods.add(Lists.newArrayList(list));
        }

        if (Iterables.isEmpty(goods)) {
            goods.add(ccyGoodsList);
        } else {
            Iterables.addAll(Iterables.get(goods, 0), ccyGoodsList);
        }

        for (List<AbstractGoods> list : goods) {
            System.out.println(list.size() + "," + list);
        }
    }

    private static void test2(List<AbstractGoods> ccyGoodsList, List<AbstractGoods> itemGoodsList) {
        List<List<AbstractGoods>> goods = Lists.newArrayList();
        goods.add(ccyGoodsList);

        int sizeOfList = itemGoodsList.size();
        int breakApart = 5;
        for (int i = 0; i < sizeOfList; i = i + breakApart) {
            List<AbstractGoods> sub = itemGoodsList.subList(i, Ints.min(sizeOfList, i + breakApart));
            if (i == 0) {
                Iterables.addAll(Iterables.get(goods, 0), sub);
            } else {
                goods.add(sub);
            }
        }

        for (List<AbstractGoods> list : goods) {
            System.out.println(list.size() + "," + list);
        }

    }
}
