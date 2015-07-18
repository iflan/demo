package org.usc.demo.guava.sub;

/**
 * 货币物品类型
 *
 * @author Shunli
 */
public enum CurrencyGoodsType {
    /**
     * 金币
     */
    GOLD(0, false) {
        @Override
        public int getQtyRatio() {
            return 10000;
        }
    },
    /**
     * 元宝
     */
    INGOT(1, false),
    /**
     * 绑定金币
     */
    BOUND_GOLD(2, true) {
        @Override
        public int getQtyRatio() {
            return 10000;
        }
    },
    /**
     * 绑定元宝
     */
    BOUND_INGOT(3, true);

    private int type;
    private boolean bound;

    private CurrencyGoodsType(int type, boolean bound) {
        this.type = type;
        this.bound = bound;
    }

    public int getType() {
        return type;
    }

    public boolean isBound() {
        return bound;
    }

    public int getQtyRatio() {
        return 1;
    }

}
