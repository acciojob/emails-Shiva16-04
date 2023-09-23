package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        int up=0;
        int lc=0;
        int digit=0;
        int sc=0;
        if(oldPassword.equals(getPassword())){
            if(newPassword.length()>=8){
                for(int i=0; i<newPassword.length();i++){
                    int no=(int)newPassword.charAt(i);
                    if(no>=48 && no<=57)digit++;
                    else if(no>=65 && no<=90)up++;
                    else if(no>=97 && no<=122)lc++;
                    else sc++;
                }
                if(up>0 && lc>0 && sc>0 && digit >0 ){
                    setPassword(newPassword);
                    System.out.println("password changed");
                }
            }
        }
    }
}
