/*
score: 9 + 1 (extra credit)
comments: perfect work!
*/
/**
 * Created by Rose on 1/21/17.
 * Assignment for your lecture 2. Please finish all the questions under
 * 'Assignment'. Assignment 2 includes 3 interview prepare questions. They
 * are similar to what you will meet during your technical interviews.Write some tests as practice.
 * Please try to think the extra credit question. The deadline of this assignment is 01/26/2017 23:59 PST.
 * Please feel free to contact me for any questions.
 */

class Employee {
    String name;
    int age;
    Gender gender;
    double salary;// salary per month


    public Employee(String name, int age, Gender gender, double salary) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void raiseSalary(double byPercent){
    	this.salary = byPercent * this.salary;
    }
}

enum Gender {
    MALE,
    FEMALE;
}


public class Assignment2 {
    // Assignment

    /**
     * Write a method to calculate the Social Security Tax of an employee and print it.
     * If the salary is less than or equal to 8900, the Social Security Tax is 6.2% of the salary.
     * If the salary is more than 8900, the Social Security Tax is 6.2% of 106,800.
     */
    public double socialSecurityTax(Employee employee) {                                  //correct
        //write your code here
    	double sst = 0;
    	if(employee.salary <= 8900){
            sst = employee.salary * 0.062;     
        } else {
            sst = 106800 * 0.062;
        }
    	System.out.println("The employee's Social Security Tax is" + sst);
    	return sst;
    }

    /**
     * Write a method to calculate an employee's contribution for insurance coverage and print it.
     * Amount of deduction is computed as follows:
     * If the employee is under 35, rate is 3% of salary; if the employee is between 35 and 50(inclusive), rate is 4% of salary;
     * If the employee is between 50 and 60(exclusive), rate is 5% of salary; If the employee is above 60, rate is 6% of salary.
     */
    public double insuranceCoverage(Employee employee) {                       //correct
        //write your code here
    	double rate = 0;
    	if(employee.age < 35) {
            rate = employee.salary * 0.03;
        } else if(employee.age >= 35 && employee.age < 50) {
            rate = employee.salary * 0.04;
        } else if(employee.age>= 50 && employee.age < 60) {
            rate = employee.salary * 0.05;
        } else{
            rate = employee.salary * 0.06;     
        } 
    	System.out.println("The employee's Rate is" + rate);
    	return rate;
    }

    /**
     * Write a method to sort three employees' salary from low to high, and then print their name in order.
     * For example, Alice's salary is 1000, John's salary is 500, Jenny's salary is 1200, you should print:
     * John Alice Jenny
     */
    public void sortSalary(Employee e1, Employee e2, Employee e3) {                    //correct
        //write your code here 
    	Employee[] employees = {e1,e2,e3};
		Employee tmp;
		for(int i = 0; i < employees.length - 1; i++){
			for(int j = 0 ; j < employees.length - i - 1; j++){
				if(employees[j].salary > employees[j + 1].salary){
					tmp = employees[j];
					employees[j] = employees[j + 1];
					employees[j+1] = tmp;
				}
			}
		}
		
		for(int i = 0; i < employees.length; i++){
			System.out.print(employees[i].name + " ");
		}
    }

    /**
     * Write a method to raise an employee's salary to three times of his/her original salary.
     * Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
     * Do not change the input of this method.
     * Try to add a new method in Employee class: public void raiseSalary(double byPercent)
     */
    public void tripleSalary(Employee employee) {                  //correct
        //write your code here
    	employee.salary = 3 * employee.salary; 	
    }

    //Interview prepare questions

    /**
     * Write a method to determine whether a number is prime
     */
    public boolean isPrime(int n) {                                 //miss one corner case: if n is 2, your return is false, but 2 is a prime number
        //write your code here
    	if (n%2 == 0)
    		return false;
    	for (int a = 3; a*a <= n; a += 2) {
    		if (n%a == 0)
    			return false;
    	}
    		return true;
    }

    /**
     * Given a non-negative integer n, repeatedly add all its digits until the
     * result has only one digit. For example: Given n = 38, the process is
     * like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
     */
    public int addDigits(int n) {                                      //smart solution!
        //write your code here
    	return (n - 1)%9 + 1;
    }

    /**
     * Write a program to check whether a given number is an ugly number. Ugly
     * numbers are positive numbers whose prime factors only include 2, 3, 5.
     * For example, 6, 8 are ugly, while 14 is not ugly since it includes
     * another prime factor 7. Note that 1 is typically treated as an ugly
     * number.
     */
    public boolean isUgly(int n) {                          //correct
        //write your code here
    	if(n == 0)
    		return false;
    	if(n == 1)
			return true;
    	if (n % 2 == 0) {
    		n = n/2;
    		return isUgly(n);
    	}
    	if ( n % 3 == 0) {
    		n = n/3;
    		return isUgly(n);
    	}
    	if (n % 5 == 0) {
    		n = n/5;
    		return isUgly(n);
    	}
    	return false;		
    }

    //Extra credit

    /**
     * I have written some code below. What I want is to swap two Employee objects.
     * One is Jenny and one is John. But after running it, I got the result below:
     * Before: a=Jenny
     * Before: b=John
     * After: a=Jenny
     * After: b=John
     * There is no change after swap()! Do you know the reason why my swap failed?
     * Write your understanding of the reason and explain it.
     */
    /*
    //correct
     write your understanding here.
     In java, there is only one type of passing and it is value. x and y are only the copy of a and b, 
     so we should write "System.out.println("After: x=" + x.getName()); " and "System.out.println("After: y=" + y.getName());" in the "swap" method
     and below "y = temp".
     The orginal value of a and b are not be affected.
    */
    public static void main(String[] args) {
        Employee a = new Employee("Jenny", 20, Gender.FEMALE, 2000);
        Employee b = new Employee("John", 30, Gender.MALE, 2500);
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        
        
        swap(a, b);
    //     System.out.println("After: a=" + a.getName());
    //     System.out.println("After: b=" + b.getName());
    }

    public static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
        
        System.out.println("After: x=" + x.getName());
        System.out.println("After: y=" + y.getName());    
        
    }
}
