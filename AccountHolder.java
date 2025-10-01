package com.infotech.worker;
import com.infotech.model.Account;

public class AccountHolder implements Runnable {
private Account account;

public AccountHolder(Account account) {
	this.account=account;
}

@Override
public void run() {
	// TODO Auto-generated method stub
	for(int i=1;i<=4;i++) {
		makeWithdrawal(2000);
		if(account.getBalance()<0) {
			System.out.println("Account is overdrawn");
		}
	}
}
private synchronized void makeWithdrawal(int WithdrawAmount) {
	if(account.getBalance()>=WithdrawAmount) {
		System.out.println(Thread.currentThread().getName() + " is going to withdraw $ "+ WithdrawAmount);
	}
	try {
		Thread.sleep(3000);
	}catch(InterruptedException ex) {
		
	}
	account.withdraw(WithdrawAmount);
	System.out.println(Thread.currentThread().getName()+"completes with withdraw of $"+WithdrawAmount);

	System.out.println("Not enough in account for"+Thread.currentThread().getName()+" to withdraw"+account.getBalance());
}
}
