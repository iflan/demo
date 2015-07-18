package org.usc.demo.guava.sub;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 货币物品
 *
 * @author Shunli
 */
public class CurrencyGoods extends AbstractGoods {
    private static final long serialVersionUID = -5588111366993338193L;
    /**
     * 货币物品类型
     */
    private CurrencyGoodsType goodsType;

    public CurrencyGoods() {
    }

    public CurrencyGoods(CurrencyGoodsType goodsType, int quantity) {
        super(quantity);
        this.goodsType = goodsType;
    }

    public CurrencyGoodsType getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(CurrencyGoodsType goodsType) {
        this.goodsType = goodsType;
    }

    @Override
    public String buildGoods() {
        return StringUtils.join(new Object[] { goodsType.getType(), BooleanUtils.toInteger(goodsType.isBound()), "0", getQuantity() * goodsType.getQtyRatio() }, ".");
    }
}
