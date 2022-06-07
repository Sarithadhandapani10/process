package com.cts.pension.process.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.pension.process.exception.AadharNumberNotFound;
import com.cts.pension.process.exception.AuthorizationException;
import com.cts.pension.process.exception.PensionerDetailException;
import com.cts.pension.process.feignclient.PensionDisbursementFeignClient;
import com.cts.pension.process.feignclient.PensionerDetailFeignClient;
import com.cts.pension.process.model.PensionDetail;
import com.cts.pension.process.model.PensionerDetail;
import com.cts.pension.process.model.PensionerInput;
import com.cts.pension.process.model.ProcessPensionInput;
import com.cts.pension.process.model.ProcessPensionResponse;

@SpringBootTest
public class ProcessPensionServiceTest {

	@InjectMocks
	private ProcessPensionServiceImpl processPensionServiceImpl;
	
	@Mock
	private PensionerDetailFeignClient pensionerDeatailFeignClient;
	
	@Mock
	private PensionDisbursementFeignClient pensionDisbursementFeignClient;
	
	
	@Test
	public void testCalculatePension() throws PensionerDetailException, AuthorizationException, AadharNumberNotFound
	{
		String token = "dummy";
		PensionerInput pensionerInput = new PensionerInput(529585952101l, "Saritha", LocalDate.of(1999, 11, 04), "SBIN0084235", "self");
		PensionDetail pensionDetail =new PensionDetail("Saritha", LocalDate.of(1999, 11, 04), "SBIN0084235", "self", 23100.0);
		PensionerDetail pensionerDetail = new PensionerDetail(529585952101l, "Saritha", LocalDate.of(1999, 11, 04), "SBIN0084235", 27000, 1500, "self", "SBI", "9873450876", "private");
		Mockito.when(pensionerDeatailFeignClient.getPensionerDetailByAadhaar(token, 529585952101l)).thenReturn(pensionerDetail);
		System.out.println("hello"+processPensionServiceImpl.CalculatePension(token, pensionerInput));
		System.out.println("hello11"+pensionDetail);
		assertEquals(processPensionServiceImpl.CalculatePension(token, pensionerInput), pensionDetail); 
	}
	
	@Test
	public void testGetCodePrivate21() throws AuthorizationException, AadharNumberNotFound
	{
		String token = "dummy";
		ProcessPensionInput processPensionInput = new ProcessPensionInput(529585952101l, 28500.0, 500);
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse();
		processPensionResponse.setProcessPensionStatusCode(21);
		Mockito.when(pensionDisbursementFeignClient.getResponse(token, processPensionInput)).thenReturn(processPensionResponse);
		
		assertEquals(processPensionServiceImpl.getCode(token, processPensionInput), processPensionResponse); 
	}
	
	@Test
	public void testGetCodePrivate10() throws AuthorizationException, AadharNumberNotFound
	{
		String token = "dummy";
		ProcessPensionInput processPensionInput = new ProcessPensionInput(529585952101l, 24400.0, 550);
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse();
		processPensionResponse.setProcessPensionStatusCode(10);
		Mockito.when(pensionDisbursementFeignClient.getResponse(token, processPensionInput)).thenReturn(processPensionResponse);
		
		assertEquals(processPensionServiceImpl.getCode(token, processPensionInput), processPensionResponse); 
	}
	@Test
	public void testGetCodePublic21() throws AuthorizationException, AadharNumberNotFound
	{
		String token = "dummy";
		ProcessPensionInput processPensionInput = new ProcessPensionInput(874365952101l, 32002.0, 500);
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse();
		processPensionResponse.setProcessPensionStatusCode(21);
		Mockito.when(pensionDisbursementFeignClient.getResponse(token, processPensionInput)).thenReturn(processPensionResponse);
		
		assertEquals(processPensionServiceImpl.getCode(token, processPensionInput), processPensionResponse); 
	}
	
	@Test
	public void testGetCodePublic10() throws AuthorizationException, AadharNumberNotFound
	{
		String token = "dummy";
		ProcessPensionInput processPensionInput = new ProcessPensionInput(874365952101l, 32002.0, 550);
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse();
		processPensionResponse.setProcessPensionStatusCode(10);
		Mockito.when(pensionDisbursementFeignClient.getResponse(token, processPensionInput)).thenReturn(processPensionResponse);
		
		assertEquals(processPensionServiceImpl.getCode(token, processPensionInput), processPensionResponse); 
	}
}
