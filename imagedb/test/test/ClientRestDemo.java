/**
 * Copyright(c) http://www.open-v.com
 */
package test;

import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

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
public class ClientRestDemo {

	private static final Log log = LogFactory.getLog(ClientRestDemo.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		String helloStr = restTemplate.getForObject("http://localhost:8080/imagedb/image/helloToImagedb", String.class);
		log.info(helloStr);
		
		@SuppressWarnings("unchecked")
		Map<String, String> mapObj = restTemplate.getForObject("http://localhost:8080/imagedb/image/jsonHelloToImagedb", Map.class);
		log.info(mapObj);
		
		AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();
		ListenableFuture<ResponseEntity<Map>> future = 
				asyncRestTemplate.getForEntity("http://localhost:8080/imagedb/image/jsonHelloToImagedb", Map.class);
		try {
			//异步调用REST服务
			ResponseEntity<Map> responseEntity = future.get();
			Map map = responseEntity.getBody();
			log.info(map);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
//		//基于回调接口
//		future.addCallback(new ListenableFutureCallback<ResponseEntity<Map>>() {
//			@Override
//			public void onSuccess(ResponseEntity<Map> responseEntity) {
//				log.info(responseEntity.getBody());
//			}
//			
//			@Override
//			public void onFailure(Throwable throwable) {
//				log.error("", throwable);
//			}
//		});
//		
//		//基于回调接口
//		future.addCallback(new SuccessCallback<ResponseEntity<Map>>() {
//			@Override
//			public void onSuccess(ResponseEntity<Map> responseEntity) {
//				log.info(responseEntity.getBody());
//			}
//		}, new FailureCallback() {
//			@Override
//			public void onFailure(Throwable throwable) {
//				log.error("", throwable);
//			}
//		});
	}

}
