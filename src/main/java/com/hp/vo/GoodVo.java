package com.hp.vo;

import com.hp.pojo.Goods;
import com.hp.pojo.Tops;
import com.hp.pojo.Types;
import lombok.Data;

@Data
public class GoodVo {
   private Goods goods;
   private Types types;
   private Tops tops;
}
