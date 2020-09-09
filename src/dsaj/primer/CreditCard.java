/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/* Modified by Laura K. Gross
 * Bridgewater State University
 * September, 2020
 */

/* Modified by YOU
 * BSU
 * Date
 */
package dsaj.primer;

/* A package aids in the organization of a large code repository,
 * Java allows a group of related type definitions, such as classes and enums,
 * to be grouped into what is known as a package.
 * For types to belong to a package named packageName,
 * their source code must all be located in a directory named packageName,
 * and each file must begin the with the line
 * package packageName;
 * By convention, the package name starts with a lowercase letter.
 * Packages can be further organized hierarchically into subpackages.
 * For example, the Deflater class in the subpackage zip,
 * which is in the package java.util
 * can be fully qualified with
 * java.util.zip.Deflater.
 * We can do
 * import java.util.Scanner; // import packageName.className;
 * Sanner input = new Scanner(System.in);
 * or we can do
 * java.util.Scanner input = new java.util.Scanner(System.in);
 * Advantages of packages are:
 * Packages help us avoid trouble with name conflicts:
 * We can have a class architecture.Window and gui.Window.
 * It is easier to distribute a set of classes for other programmers to use
 * when those classes are packaged.
 * It is easier to find classes with a related purpose
 * and understand their coordinated use
 * when they are grouped as a package.
* Classes within the same package have access to all of each others' members having public,
* protected, or default visibility (anything but private).
* See textbook, P. 45 for a treatment of how conflicting types---types of the same name
* (locally defined names, names from different packages) are handled.
*/

/**
 * A simple model for a consumer credit card.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class CreditCard {
    // Instance variables:
    private String customer;      // name of the customer (e.g., "John Bowman")
    private String bank;          // name of the bank (e.g., "California Savings")
    private String account;       // account identifier (e.g., "5391 0375 9387 5309")
    private int limit;            // credit limit (measured in dollars)
    protected double balance;     // current balance (measured in dollars)

    // Constructors:
    /**
     * Constructs a new credit card instance.
     * @param cust        the name of the customer (e.g., "John Bowman")
     * @param bk          the name of the bank (e.g., "California Savings")
     * @param acnt        the account identifier (e.g., "5391 0375 9387 5309")
     * @param lim         the credit limit (measured in dollars)
     * @param initialBal  the initial balance (measured in dollars)
     */
    public CreditCard(String cust, String bk, String acnt, int lim, double initialBal) {
        customer = cust;
        bank = bk;
        account = acnt;
        limit = lim;
        balance = initialBal;
    }

    /**
     * Constructs a new credit card instance with default balance of zero.
     * @param cust    the name of the customer (e.g., "John Bowman")
     * @param bk      the name of the bank (e.g., "California Savings")
     * @param acnt    the account identifier (e.g., "5391 0375 9387 5309")
     * @param lim     the credit limit (measured in dollars)
     */
    public CreditCard(String cust, String bk, String acnt, int lim) {
        this(cust, bk, acnt, lim, 0.0);               // use a balance of zero as default
    }

    // Accessor methods:
    /** Returns the name of the customer. */
    public String getCustomer() { return customer; }

    /** Returns the name of the bank */
    public String getBank() { return bank; }

    /** Return the account identifier. */
    public String getAccount() { return account; }

    /** Return the credit limit. */
    public int getLimit() { return limit; }

    /** Return the current balance. */
    public double getBalance() { return balance; }

    // Update methods:
    /**
     * Charges the given price to the card, assuming sufficient credit limit.
     * @param price  the amount to be charged
     * @return true  if charge was accepted; false if charge was denied
     */
    public boolean charge(double price) {               // make a charge
        if (price + balance > limit)                      // if charge would surpass limit
            return false;                                   // refuse the charge
        // at this point, the charge is successful
        balance += price;                                 // update the balance
        return true;                                      // announce the good news
    }

    /**
     * Processes customer payment that reduces balance.
     * @param amount  the amount of payment made
     */
    public void makePayment(double amount) {            // make a payment
        balance -= amount;
    }

    // Utility method to print a card's information
    public static void printSummary(CreditCard card) {
        System.out.println("Customer = " + card.customer);
        System.out.println("Bank = " + card.bank);
        System.out.println("Account = " + card.account);
        System.out.println("Balance = " + card.balance);  // implicit cast
        System.out.println("Limit = " + card.limit);      // implicit cast
    }

}

/*
Output of main:

Customer = John Bowman
Bank = California Savings
Account = 5391 0375 9387 5309
Balance = 408.0
Limit = 5000
New balance = 208.0
New balance = 8.0
Customer = John Bowman
Bank = California Federal
Account = 3485 0399 3395 1954
Balance = 272.0
Limit = 3500
New balance = 72.0
Customer = John Bowman
Bank = California Finance
Account = 5391 0375 9387 5309
Balance = 436.0
Limit = 2500
New balance = 236.0
New balance = 36.0
*/

