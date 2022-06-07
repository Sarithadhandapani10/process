package com.cts.pension.process;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.pension.process.model.PensionDetail;
import com.cts.pension.process.model.PensionerDetail;
import com.cts.pension.process.model.PensionerInput;
import com.cts.pension.process.model.ProcessPensionInput;
import com.cts.pension.process.model.ProcessPensionResponse;

import nl.jqno.equalsverifier.EqualsVerifier;
@SpringBootTest
class ProcessPensionMicroserviceApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void main()
	{
		ProcessPensionMicroserviceApplication.main(new String[] {});
	}
	
	@Test
	void testPensionerDeatil() {
		EqualsVerifier.simple().forClass(PensionerDetail.class).verify();
	}
	
	@Test
	void testPensionDetail() {
		EqualsVerifier.simple().forClass(PensionDetail.class).verify();
	}
	
	@Test
	void testPensionerInputDeatils() {
		EqualsVerifier.simple().forClass(PensionerInput.class).verify();
	}
	
	@Test
	void testProcessPensionerInput() {
		EqualsVerifier.simple().forClass(ProcessPensionInput.class).verify();
	}
	@Test
	void testProcessPensionResponseDeatils() {
		EqualsVerifier.simple().forClass(ProcessPensionResponse.class).verify();
	}
	
	@Test
	void testSetterMethod()
	{
		PensionerDetail pensionerDetail = new PensionerDetail();
		pensionerDetail.setAadharNumber(529585952101l);
		pensionerDetail.setName("Saritha");
		pensionerDetail.setDateOfBirth(LocalDate.of(1999, 11, 04));
		pensionerDetail.setPan("SBIN0084235");
		pensionerDetail.setSalaryEarned(27000);
		pensionerDetail.setAllowances(1500);
		pensionerDetail.setPensionType("self");
		pensionerDetail.setBankName("SBI");
		pensionerDetail.setAccountNumber("9873450876");
		pensionerDetail.setBankType("private");
		
		assertThat(assertThat(pensionerDetail).isNotNull());
	}
	
	@Test
	void testEqualAndHashCode()
	{
		PensionerDetail pensionerDetail1 = new PensionerDetail(529585952101l, "Saritha", LocalDate.of(1999, 11, 04), "SBIN0084235", 27000, 1500, "self", "SBI", "9873450876", "private");
		PensionerDetail pensionerDetail2 = new PensionerDetail(529585952101l, "Saritha", LocalDate.of(1999, 11, 04), "SBIN0084235", 27000, 1500, "self", "SBI", "9873450876", "private");
		
			assertThat(assertThat(pensionerDetail1).isEqualTo(pensionerDetail2));
	
	}
	@Test
	void testNotEqualAndHashCode()
	{
		PensionerDetail pensionerDetail1 = new PensionerDetail(920559329020l, "Sindhu", LocalDate.of(1999, 05, 15), "LKDPT1155S", 28000, 1200, "self", "SBI", "7428919432", "private");
		PensionerDetail pensionerDetail2 = new PensionerDetail(529585952101l, "Saritha", LocalDate.of(1999, 11, 04), "SBIN0084235", 27000, 1500, "self", "SBI", "9873450876", "private");
		
			assertThat(assertThat(pensionerDetail1).isNotEqualTo(pensionerDetail2));
	
	}
	@Test
	void testNoArgs()
	{
		assertThat(new PensionerDetail()).isNotNull();
	}
	
	@Test
	void testProcessPensionResponce()
	{
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse();
		processPensionResponse.setProcessPensionStatusCode(10);
		assertThat(assertThat(processPensionResponse).isNotNull());
	}
	@Test
	void testProcessPensionResponceNoArgs()
	{
		assertThat(new ProcessPensionResponse()).isNotNull();
	}
	
}
