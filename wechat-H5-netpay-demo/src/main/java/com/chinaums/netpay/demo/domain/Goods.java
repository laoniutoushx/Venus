package com.chinaums.netpay.demo.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by faliny on 2017/8/25.
 */
@Getter
@Setter
public class Goods {

    public Goods(String goodsId, String goodsName, Long quantity, Long price, String goodsCategory, String body) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.quantity = quantity;
        this.price = price;
        this.goodsCategory = goodsCategory;
        this.body = body;
    }

    private String goodsId;
    private String goodsName;
    private Long quantity;
    private Long price;
    private String goodsCategory;
    private String body;
}
