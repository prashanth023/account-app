package com.account.app.controller;

import java.util.List;


import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.app.entity.Account;
import com.account.app.service.AccountService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RefreshScope
@RestController
@RequestMapping(value = "/account")
public class AccountController {

	private final AccountService accountService;

	@GetMapping("/findAll")
	public List<Account> findAllAccount() {

		return accountService.findAllAccount();
	}

	@GetMapping("/findAccount/{accName}")
	public Account findAccountByName(@PathVariable("accName") String accountName) {

		return accountService.findAccountByName(accountName);
	}

}
