/**
 * Copyright(c) http://www.open-v.com
 */
package org.springframework.samples.imagedb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <pre>
 * 程序的中文名称。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
@Controller
@ResponseBody
public class ResponseBodyController {

	@RequestMapping(value="/helloToImagedb", method=RequestMethod.GET)
	public String sayHelloToImagedb(){
		return "hello, imagedb!";
	}
}
