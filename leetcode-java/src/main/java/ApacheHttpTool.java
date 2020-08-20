/*
import co.spring.cloud.gateway.plugins.client.supports.ApiSignatureSpec;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import java.util.logging.Logger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

*/
/**
 * @author zgl
 * @date 2019/8/30 下午3:34
 *//*

public class ApacheHttpTool {

	static Logger logger = Logger.getLogger("Demo");

	public static void main(String[] args) throws Exception {
		testGet();
	}

	public static void testGet() throws Exception{
		//URL, 换成自己需要调用的url
		String url = "http://gateway-one.beta.speiyou.cn/splat/verify/verifySourceRequest?operateType=cashOut&token=af8646d2bf5e528fe32eb77deccf70ab";
		String uri = "/splat/verify/verifySourceRequest?operateType=cashOut&token=af8646d2bf5e528fe32eb77deccf70ab";
		// Http-Request-Headers, 如果有Content-Type, 请在这里put一下
		Map<String, String> httpHeaders = new HashMap<>();
		httpHeaders.put("area", "010");
		httpHeaders.put("version", "3.0");
		httpHeaders.put("X-Ca-platform", "finance");

		//计算新 Http-Headers
		Map<String, String> newHttpHeaders = new ApiSignatureSpec()
				.withUri(uri)
				.withHttpMethod("GET")
				// X-Ca-Key
				.withXCaKey("0ab0e4eb40a14598965013c4850fe739")
				.withHttpHeaders(httpHeaders)
				.withCurrentLog(true)
				// 测试环境, 这个属性设置为true. 响应信息的Http-Response-Header中会有签名错误的trace信息.
				// FIXME 线上环境需要设置为false. 否则会报错
				.withTestStage(true)
				.withDefaultHttpHeaderAccept(true)
				.getHttpHeaders("6dd5c531ffcb178212ea67e0bfb7ee46");


		// 发送请求
		CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);
		newHttpHeaders.entrySet().forEach(entry -> get.setHeader(new BasicHeader(entry.getKey(), entry.getValue())));
		CloseableHttpResponse response = closeableHttpClient.execute(get);
		logger.info(Arrays.toString(response.getAllHeaders()).replaceAll("//n", "\n"));
		logger.info(EntityUtils.toString(response.getEntity()));

		// 使用工具类发送请求
//        String responseString = HttpClientWraper.httpGet(url, newHttpHeaders, null);
//        logger.info(String.format("The response : %s", responseString));
	}

	private static class RestResBean<T>{
		private boolean rlt;
		private String code;
		private String message;
		private boolean success;
		private T data;

		public boolean isRlt() {
			return rlt;
		}

		public void setRlt(boolean rlt) {
			this.rlt = rlt;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public boolean isSuccess() {
			return success;
		}

		public void setSuccess(boolean success) {
			this.success = success;
		}

		@Override
		public String toString() {
			return "RestResBean{" +
					"rlt=" + rlt +
					", code='" + code + '\'' +
					", message='" + message + '\'' +
					", success=" + success +
					", data=" + data +
					'}';
		}
	}
}*/
