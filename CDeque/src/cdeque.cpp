

#include "cdeque.h"
#include <iostream>
using namespace std;



bool CDeque::full() const
{
	return _back == _capacity;
}

bool CDeque::empty() const
{
	return _back == 0;
}

CDeque::CDeque()
{
	_deque = new string[DEFAULT_CAPACITY];
	_capacity = DEFAULT_CAPACITY;
	_back = 0;
}

CDeque::CDeque(const int capacity)
{
	if (capacity < 0)
		throw "Invalid Argument"s;
	_deque = new string [capacity];
	_capacity = capacity;
	_back = 0;
}

bool CDeque::insertBegin(string str)
{
	if (!full() && !str.empty()) {
		string *temp = new string[_capacity];
		_back++;
		temp[0] = str;
		for (int i = 1; i < _back; i++) {
			temp[i] = _deque[i - 1];
		}
		for (int i = 0; i < _back; i++) {
			_deque[i] = temp[i];
		}
		delete temp;
		return true;
	}
	return false;
}

bool CDeque::insertEnd(string str)
{
	if (!full() && !str.empty()) {
		_deque[_back] = str;
		_back ++;
		return true;
	}
	return false;
}

string CDeque::removeBegin()
{
	if (empty()) {
		throw "Remove from empty CDeque"s;
	}
	string str = _deque[0];
	string *temp = new string[_capacity];
	for (int i = 0; i < _back - 1; i++) {
		temp[i] = _deque[i + 1];
	}
	for (int i = 0; i < _back - 1; i++) {
		_deque[i] = temp[i];
	}
	_back--;
	delete temp;
	return str;
}

string CDeque::removeEnd()
{
	if (empty()) {
		throw "Remove from empty CDeque"s;
	}
	_back --;
	return _deque[_back];
}

string CDeque::first() const
{
	if (empty()) {
		throw "Empty CDeque"s;
	}
	return _deque[0];
}

string CDeque::last() const
{
	if (empty()) {
		throw "Empty CDeque"s;
	}
	return _deque[_back - 1];
}

int CDeque::size() const
{
	return _back;
}

bool CDeque::isFull() const
{
	return full();
}

bool CDeque::isEmpty() const
{
	return empty();
}

int CDeque::capacity() const
{
	return _capacity;
}

CDeque::~CDeque()
{
	cout << "Destructor has been called!" << endl;
	delete [] _deque;
}

void print(ostream &o,string & val)
{
	o<< val << " ";
}

ostream & operator<<(ostream &o, const CDeque &cd)
{
	o << "{DQ(" << cd.size() << "/" << cd.capacity();
	if(cd.isEmpty()){
		o << " EMPTY}" << endl;
	} else {

		CDeque temps = cd;
		for(int i = 0; i < cd.size(); i++){
			string temp = temps.first();
			o << " " << temp;
			temps.removeBegin();
			temps.insertEnd(temp);
		}
		o << "}" << endl;
	}
	return o;
}
