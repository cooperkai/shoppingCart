package com.cooper.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cooper.serivce.ExcelService;
import com.cooper.serivce.MailService;
import com.cooper.util.MessageKey;

import java.security.Principal;
import java.util.Set;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.representations.AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {

	private static Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private MailService mailService;
	@Autowired
	private ExcelService excelService;
	
	@RequestMapping("/test")
	public ModelAndView greeting(Principal principal) {
		ModelAndView modelAndView = new ModelAndView("/index");
		try {
			AccessToken accessToken = ((KeycloakPrincipal<?>) principal).getKeycloakSecurityContext().getToken();
			String preferredUsername = accessToken.getPreferredUsername();
			AccessToken.Access realmAccess = accessToken.getRealmAccess();
			Set<String> roles = realmAccess.getRoles();
			logger.info("user：{}, roles：{}", preferredUsername, roles);
			
			// 寄送email
			mailService.sendMail("eatkaikai@gmail.com",
					"test",
					"If you did not log in our website, please contact us as soon as possible!",
					"/loginNotify");
			// 寄送email with attachment
//			String filePath = "C:\\Users\\T3065\\Desktop\\APP後台_管理者功能_推播及活動新增狀態欄位.docx";
//			mailService.sendMailWithAttachment("eatkaikai@gmail.com", "測試信件", "你有附件!", filePath);
		} catch (Exception e) {
			logger.error("{testError}: ", e);
		}
        return modelAndView;
	}
	
	@GetMapping(value = "/excel")
	public ModelAndView makeExcel(Principal principal) {
		ModelAndView model = null;
		try {
//			AccessToken accessToken = ((KeycloakPrincipal<?>) principal).getKeycloakSecurityContext().getToken();
//			String preferredUsername = accessToken.getPreferredUsername();
//			AccessToken.Access realmAccess = accessToken.getRealmAccess();
//			Set<String> roles = realmAccess.getRoles();
//			logger.info("user：{}, roles：{}", preferredUsername, roles);
			
			// make excel
			excelService.makeExcel();
			model = new ModelAndView("/success");
			model.addObject("MSG", MessageKey.MSG002);
		} catch (Exception e) {
			logger.error("{testError}: ", e);
			logger.error("{}: ", e);
			model = new ModelAndView("/fail");
			model.addObject("MSG", MessageKey.MSG003);
			return model;
		}
		return model;
	}
}