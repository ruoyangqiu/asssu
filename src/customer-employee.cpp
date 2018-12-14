#include "customer-employee.h"
#include "receipt.h"
#include <iostream>
#include <vector>
using namespace std;

CustomerEmployee::CustomerEmployee(string name, double salary)
	: Customer(name), Employee(name, salary), Person(name) {
}

// Does its monthly by (a) dispatching on Employee::monthly() which will
// generate a receipt for paying salary, then (b) depositing its salary into its CheckingAccount,
// then, (c) dispatching on Customer::monthly which will charge its CheckingAccount.
// It concatenates and returns receipts from all of those three calls, a Payment,
// a Deposit,  a Service Charge, and a Withdrawal

vector<Receipt> CustomerEmployee::monthly() {
	vector<Receipt> vr;
	vr.push_back( Receipt(this->getID(), Payment, this->getSalary()));
	for(Receipt r : this->getCheckingAccount().monthly()){
		vr.push_back(r);
	}
	return vr;
}
