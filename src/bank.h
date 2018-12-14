#ifndef BANK_H_
#define BANK_H_
#include <map>
#include <vector>
#include "checking-account.h"
#include "person.h"
#include "receipt.h"

class Bank {
private:
	vector<Person*> _people;  // All the Customers, Employees, and CustomerEmployees
	map<int, CheckingAccount*> _checkingAccounts;  // Map from person ID
public:
	Bank();
	// Error if int is not the ID of a Customer or CustomerEmployee
	CheckingAccount* getCheckingAccount(int);
	vector<Receipt> monthly();
	// Error to add customer with empty string name
	int addCustomer(string);
	// Error add employee with empty string name or negative salary
	int addEmployee(string, double);
	// Error to add Customer Employee with empty string name or negative salary
	int addCustomerEmployee(string, double);
};

#endif /* BANK_H_ */
