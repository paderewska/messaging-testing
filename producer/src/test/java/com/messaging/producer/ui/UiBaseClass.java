//package com.messaging.producer.ui;
//
//import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
//import com.messaging.producer.application.ApplyForLoanService;
//import com.messaging.producer.model.Loan;
//import org.junit.Before;
//import org.junit.runner.RunWith;
//import org.mockito.BDDMockito;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import java.util.Optional;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = UiBaseClass.Config.class)
//@EnableWebMvc
//public class UiBaseClass {
//
//    private static final String VALID_PERSONAL_ID = "85101406622";
//    private static final String INVALID_PERSONAL_ID = "52101406622";
//
//    @Autowired
//    WebApplicationContext context;
//
//    @Before
//    public void setup() {
//        RestAssuredMockMvc.webAppContextSetup(this.context);
//    }
//
//    @Configuration
//    static class Config {
//
//        @Bean
//        LoanApplicationController loanApplicationController() {
//            ApplyForLoanService service = Mockito.mock(ApplyForLoanService.class);
//            BDDMockito.given(service.apply(BDDMockito.anyString()))
//                    .willReturn(Optional.of(Loan.withDefaultLimit(VALID_PERSONAL_ID)));
//            BDDMockito.given(service.apply(INVALID_PERSONAL_ID))
//                    .willReturn(Optional.empty());
//            return new LoanApplicationController(service);
//        }
//    }
//}
