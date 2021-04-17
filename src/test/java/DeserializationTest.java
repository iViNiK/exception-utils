import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import it.vinicioflamini.sharedlib.exceptions.apierror.ApiError;
import it.vinicioflamini.sharedlib.exceptions.type.BusinessException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;

public class DeserializationTest {

	@Test
	public void testDeserialization() throws IOException {

		String message = "This is test error message";
		String businessErrorCode = "COD-1000";
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());

		ResponseEntity<Object> entity = handleBusinessException(new BusinessException(businessErrorCode, message));

		byte[] data = objectMapper.writeValueAsBytes(entity.getBody());

		HttpClientErrorException a = HttpClientErrorException.create(HttpStatus.CONFLICT,
				HttpStatus.CONFLICT.getReasonPhrase(), null, data, null);
		String response = a.getResponseBodyAsString();

		ApiError e = objectMapper.readValue(response, ApiError.class);
		Assert.assertNotNull(e);
		Assert.assertEquals(e.getMessage(), message);
		Assert.assertEquals(e.getBusinessErrorCode(), businessErrorCode);
	}

	/**
	 * Copy paste dei metodi di rest Exception handler
	 *
	 * @param ex
	 * @return
	 */
	protected ResponseEntity<Object> handleBusinessException(BusinessException ex) {
		return buildResponseEntity(new ApiError(HttpStatus.CONFLICT, ex), ex);
	}

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError, Exception ex) {
		apiError.setTraceId("trace_id");
		apiError.setSpanId("span_id");
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

}
