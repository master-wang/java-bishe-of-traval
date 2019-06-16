package com.acat.controller;

import com.acat.util.AlipayUtil.AlipayUtil;
import com.acat.util.AlipayUtil.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/alipay")
@Api(value = "alipay",tags = {"通过第三方支付宝接口进行支付"})
public class AlipayController {

    private static final Logger logger = LoggerFactory.getLogger(AlipayController.class);

    @ApiOperation(value = "通过第三方支付宝接口进行支付",notes = "通过第三方支付宝接口进行支付")
    @ApiImplicitParam(value = "money",name = "money")
    @GetMapping("/getAlipay/{money}")
    public String getAlipay(@PathVariable("money") String money,HttpServletResponse response){

        String result = null;

        String orderId = RandomUtil.getRandom();

        //订单名称，必填
        String name = "xx景点门票";

        //商品描述，可空
        String info = "该xx景点是xx省xx市的5A级景区，该景区是xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";

        try{
            result = AlipayUtil.pay(response, money, info, name, orderId);
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

}
