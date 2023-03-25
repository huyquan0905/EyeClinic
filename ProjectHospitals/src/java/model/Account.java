/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Hi! Le Minh Hieu
 */
public class Account {

    private int accountId;
    private String accountName;
    private String accountWord;
    private int roleAdmin;
    private int roleEmployee;

    public Account() {
    }

    public Account(int accountId, String accountName, String accountWord, int roleAdmin, int roleEmployee) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.accountWord = accountWord;
        this.roleAdmin = roleAdmin;
        this.roleEmployee = roleEmployee;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountWord() {
        return accountWord;
    }

    public void setAccountWord(String accountWord) {
        this.accountWord = accountWord;
    }

    public int getRoleAdmin() {
        return roleAdmin;
    }

    public void setRoleAdmin(int roleAdmin) {
        this.roleAdmin = roleAdmin;
    }

    public String getRoleEmployee() {
        if (roleAdmin == 1 && roleEmployee == 1) {
            return "Admin";
        } else if (roleAdmin == 0 && roleEmployee == 1) {
            return "Employee";
        } else {
            return "Customer";

        }
    }
     public int getRoleEmployee1() {
        return roleEmployee;
    }

    public void setRoleEmployee(int roleEmployee) {
        this.roleEmployee = roleEmployee;
    }

    @Override
    public String toString() {
        return "Account{" + "accountId=" + accountId + ", accountName=" + accountName + ", accountWord=" + accountWord + ", roleAdmin=" + roleAdmin + ", roleEmployee=" + roleEmployee + '}';
    }

}
