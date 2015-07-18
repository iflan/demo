package org.usc.demo.guava.sub;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 礼包物品
 *
 * @author Shunli
 */
public class ItemGoods extends AbstractGoods {
    private static final long serialVersionUID = 3722313623231362591L;

    /**
     * 礼包物品ID
     */
    private String id;
    /**
     * 是否绑定
     */
    private boolean bound = true;

    public ItemGoods() {
    }

    public ItemGoods(String id, int quantity, boolean bound) {
        super(quantity);
        this.id = id;
        this.bound = bound;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isBound() {
        return bound;
    }

    public void setBound(boolean bound) {
        this.bound = bound;
    }

    @Override
    public String buildGoods() {
        return StringUtils.join(new Object[] { 4, BooleanUtils.toInteger(bound), id, getQuantity() }, ".");
    }

}
