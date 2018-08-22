package com.bdcourtyard.business.houseprice.rest;

import basic.common.core.id.IdUtil;
import com.bdcourtyard.business.houseprice.model.RoomsourceHousediscount;
import com.bdcourtyard.business.houseprice.service.RoomsourceHousediscountService;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.page.Page;
import com.bdcourtyard.common.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *  RoomsourceHousediscountController
 *
 * @version : Ver 1.0
 * @date	: 2018-7-24
 */
@RestController
@Api(value = "RoomsourceHousediscountController", description = "房屋折扣表相关")
@RequestMapping(value = "/crm/web/roomsourceHousediscount")
public class RoomsourceHousediscountController { 
	
	   @InitBinder   
	    public void initBinder(WebDataBinder binder) {   
	        DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	        dateFormat.setLenient(true);   
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   
	    }  
	
	@Autowired
	private RoomsourceHousediscountService roomsourceHousediscountService;
	
	@ApiOperation(value = "新增房屋折扣", notes = "新增房屋折扣")
	@RequestMapping(value = "/insertRoomsourceHousediscount", method = RequestMethod.POST)
	public Response<Integer> insertRoomsourceHousediscount(HttpServletRequest request,@RequestBody RoomsourceHousediscount roomsourceHousediscount){
		roomsourceHousediscount.setDiscountId(IdUtil.getId()+"");
		return new Response<Integer>(roomsourceHousediscountService.insertRoomsourceHousediscount(request,roomsourceHousediscount));
	}
	/*@ApiOperation(value = "批量新增", notes = "批量新增")
	@RequestMapping(value = "/insertRoomsourceHousediscountBatch", method = RequestMethod.POST)
	public Response<Integer> insertRoomsourceHousediscountBatch(@RequestBody List<RoomsourceHousediscount> list){
		return  new Response<Integer>(roomsourceHousediscountService.insertRoomsourceHousediscountBatch(list));
	}*/
	@ApiOperation(value = "根据ID修改", notes = "根据ID修改")
	@RequestMapping(value = "/updateRoomsourceHousediscountById", method = RequestMethod.POST)
	public Response<Integer> updateRoomsourceHousediscountById(@RequestBody RoomsourceHousediscount roomsourceHousediscount){
		return new Response<Integer>(roomsourceHousediscountService.updateRoomsourceHousediscountById(roomsourceHousediscount));
	}
	@ApiOperation(value = "根据房屋折扣表ID删除", notes = "（批量删除时，id拼接用英文逗号隔开）")
	@RequestMapping(value = "/deleteRoomsourceHousediscountById", method = RequestMethod.GET)
	public Response<Boolean> deleteRoomsourceHousediscountById( @RequestParam String discountIds  ){

		if(discountIds==null){
			throw new GlobalException("HD004");
		}
		roomsourceHousediscountService.deleteRoomsourceHousediscountByIds(discountIds);
		return new Response<Boolean>(true);
	}
	@ApiOperation(value = "根据房屋折扣表ID获取", notes = "根据房屋折扣表ID获取")
	@RequestMapping(value = "/getRoomsourceHousediscountById", method = RequestMethod.GET)
	public Response<RoomsourceHousediscount> getRoomsourceHousediscountById( @RequestParam String discountId  ){
		return new Response<RoomsourceHousediscount>(roomsourceHousediscountService.getRoomsourceHousediscountById(  discountId  ));
	}
 
	@ApiOperation(value = "根据房屋折扣表对象获取", notes = "根据房屋折扣表对象获取")
	@RequestMapping(value = "/getRoomsourceHousediscounts", method = RequestMethod.POST)
	public  Response<List<RoomsourceHousediscount>> getRoomsourceHousediscounts( @RequestBody RoomsourceHousediscount roomsourceHousediscount){
		return new Response<List<RoomsourceHousediscount>>(roomsourceHousediscountService.getRoomsourceHousediscounts(roomsourceHousediscount));

 	}

	@ApiOperation(value = "根据房屋折扣表对象分页获取", notes = "根据房屋折扣表对象分页获取")
	@RequestMapping(value = "/getRoomsourceHousediscountsForPage", method = RequestMethod.POST)
	public  Response<Page<RoomsourceHousediscount>> getRoomsourceHousediscountsForPage(@RequestBody RoomsourceHousediscount roomsourceHousediscount,
			@RequestParam(value="page", defaultValue="1")  int page,
			@RequestParam(value="pageSize", defaultValue="10") int pageSize){
		Pageable pageable = new PageRequest(page, pageSize);
		Page<RoomsourceHousediscount> pageDto= roomsourceHousediscountService.getRoomsourceHousediscountsForPage(roomsourceHousediscount,pageable);
		return new Response<Page<RoomsourceHousediscount>>(pageDto);
 	}
}
