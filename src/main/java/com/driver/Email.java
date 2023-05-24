package com.driver;

import java.util.concurrent.CompletionException;

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

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(!oldPassword.equals(this.password)) {
            System.out.println("Incorrect Password");
            return;
        }
        if(newPassword.length() < 8) {
            System.out.println("Password Have Atleat 8 Characters");
            return;
        }
        //now check this password have in correct formate or not
        boolean UpperCaseCharacter = false;
        boolean LowerCaseCharacter = false;
        boolean digit = false;
        boolean specialCharacter = false;
        for(int i = 0; i < newPassword.length(); i++) {
            //check every boolean variable now
            char ch = newPassword.charAt(i);
            if (ch >= '0' && ch <= '9')digit = true;
            else if (ch >= 'A' && ch <= 'Z')UpperCaseCharacter = true;
            else if (ch >= 'a' && ch <= 'z')LowerCaseCharacter = true;
            else specialCharacter = true;
        }
        //now if everything is true then only we you are able to change the password
        if(digit && UpperCaseCharacter && LowerCaseCharacter && specialCharacter){
            this.password = newPassword;
            System.out.println("Password Changed Successfully");
        }else if(oldPassword.equals(newPassword)) {
            System.out.println("Your New Password Should Not Be Same");
        }else System.out.println("Your Password Not Meets All The Conditions");
    }
}
