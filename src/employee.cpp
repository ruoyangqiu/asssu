#include "employee.h"
#include <iostream>
using namespace std;

Employee::Employee(string name, double salary) : Person(name) {
	_salary = salary;
}

double Employee::getSalary() const {
	return _salary;
}

// Employee does monthly just by generating a Payment receipt in the
// amount of its salary.  Since it has no account, it can't deposit.

vector<Receipt> Employee::monthly() {
	Receipt r(this->getID(), Payment, this->getSalary());
	vector<Receipt> vr;
	vr.push_back(r);
	return vr;
}

