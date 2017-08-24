package object_oriented_design.call;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 *  Imagine you have a call center with three levels of employees: fresher, technical lead
(TL), product manager (PM). There can be multiple employees, but only one TL or PM.

An incoming telephone call must be allocated to a fresher who is free. If a fresher
can’t handle the call, he or she must escalate the call to technical lead. If the TL is
not free or not able to handle it, then the call should be escalated to PM. Design the
classes and data structures for this problem. Implement a method getCallHandler().
 */
public class CallHandler {

	/*
	 * All three ranks of employees have different work to be done, so those
	 * special functions are profile special. We should keep these special
	 * things within their respective class. There are a few things which are
	 * common to them, like address, name, job title, age, etc. These things can
	 * be kept in one class and can be extended / inherited by others. Finally,
	 * there should be one CallHandler class which would route the calls to the
	 * concerned person.
	 * 
	 * NOTE: On any object oriented design question, there are many ways to
	 * design the objects. Discuss the trade-offs of different solutions with
	 * your interviewer. You should usually design for long term code
	 * flexibility and maintenance.
	 */

	static final int NUM_LEVELS = 3;// we have 3 levels of employees
	static final int NUM_FRESHERS = 5;
	ArrayList<Employee>[] employeeLevels = new ArrayList[NUM_LEVELS];
	// queues for each employee’s rank
	Queue<Call>[] callQueues = new LinkedList[NUM_LEVELS];

	public CallHandler() {
	}

	// routes the call to an available employee, or adds to a queue
	Employee getCallHandler(Call call) {
		for (int level = call.getRank(); level < NUM_LEVELS - 1; level++) {
			ArrayList<Employee> employeeLevel = employeeLevels[level];
			for (Employee emp : employeeLevel) {
				if (emp.free) {
					return emp;
				}
			}
		}
		return null;
	}

	void dispatchCall(Call call) {
		// try to route the call to an employee with minimal rank
		Employee emp = getCallHandler(call);
		if (emp != null) {
			emp.receiveCall(call);
		} else {
			// place the call into queue according to its rank
			callQueues[call.getRank()].add(call);
		}
	}

	// look for call based on employee's rank
	void getNextCall(Employee e) {

	}
}
