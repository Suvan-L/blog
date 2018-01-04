package com.blog.controller;

import com.blog.reptile.jsoup.JsoupGetStockData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * StockController股票控制器
 */
@Controller
public class StockController {


 /******************************跳转页面******************************/
	/*【填写资料页面】*/
	@RequestMapping(value = "/stock")
	public String toClassmates(HttpServletRequest request,Model model){
		//1.获取请求绝对路径【赋值到全局变量】
		String basePath = request.getScheme()+"://"
				+request.getServerName()+":"
				+request.getServerPort()+
				request.getContextPath()+"/";

		//2.处理数据
		String [] colName = {"股票名字","今日开盘价","收盘价","当前价格","今日最高价","今日最低价",
							 "竞买价(买一价)","竞卖价(卖一价)","成交股票数","成交金额",
							 "买一[股数]","买一[价]",
							 "买二[股数]","买二[价]",
							 "买三[股数]","买三[价]",
							 "买四[股数]","买四[价]",
							 "买五[股数]","买五[价]",
							 "卖一[股数]","卖一[价]",
							 "卖二[股数]","卖二[价]",
							 "卖三[股数]","卖三[价]",
							 "卖四[股数]","卖四[价]",
				             "日期","时间"};


		JsoupGetStockData j  = new JsoupGetStockData();
		j.getStockData("sz300059");


		//3.设置
		model.addAttribute("basePath",basePath);
		model.addAttribute("colName",colName);

		return "stockstatistics";
	}

}
