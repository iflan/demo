package org.usc.demo.guava.sub;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 物品
 *
 * @author Shunli
 */
public abstract class AbstractGoods implements java.io.Serializable {
    private static final long serialVersionUID = 8022434455755197000L;

    /**
     * 数量
     */
    private int quantity;

    public AbstractGoods() {
    }

    public AbstractGoods(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract String buildGoods();

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
