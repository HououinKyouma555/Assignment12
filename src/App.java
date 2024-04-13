import java.util.Scanner;

public class App {
    

    public static void main(String[] args) throws Exception {
        boolean hasNumber = false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasSpecial = false;
        int metRequirements = 0;

        Scanner scnr = new Scanner(System.in);
        
        
        System.out.println("Please enter your desired password");
        String password = scnr.nextLine();
        scnr.close();

        if (password.length() < 8){
            System.out.println("Password is too short. Please enter new pasword");
        } else if (password.length() > 16){
            System.out.println("Password is too long. Please enter new password");
        } else {
            hasLowerCase = checkLowerCase(password, hasLowerCase);
            hasUpperCase = checkUpperCase(password, hasUpperCase);
            hasNumber = checkNumber(password, hasNumber);
            hasSpecial =  checkSpecial(password, hasSpecial);
        }

        System.out.println("Has number is: "+ hasNumber);
        System.out.println("Has lower case is: "+ hasLowerCase);
        System.out.println("Has upper case is: "+ hasUpperCase);
        System.out.println("Has special is: "+ hasSpecial);

        if (hasNumber == true){
            metRequirements++;
        }
        if (hasUpperCase == true){
            metRequirements++;
        }
        if (hasLowerCase == true){
            metRequirements++;
        }
        if (hasSpecial == true){
            metRequirements++;
        }

        if (metRequirements >= 3){
            System.out.println("Congrats! "+ password+" meets enough requirements");
        }
        else{
            System.out.println("Sorry, your password still needs to meet "+ (3-metRequirements) +" requirements");
        }

    }

    private static boolean checkLowerCase(String password, boolean hasLowerCase){
        for (int i = 0; i < password.length(); i++){
            if (password.charAt(i) > 96 && password.charAt(i) < 123){
                    hasLowerCase = true;
                }
        }
        return hasLowerCase;
    }

    private static boolean checkUpperCase(String password, boolean hasUpperCase){
        for (int i = 0; i < password.length(); i++){
            if (password.charAt(i) > 64 && password.charAt(i) < 91){
                    hasUpperCase = true;
                }
            }
        return hasUpperCase;
    }

    private static boolean checkNumber(String password, boolean hasNumber){
        for (int i = 0; i < password.length(); i++){
            if (password.charAt(i) > 47 && password.charAt(i) < 58){
                    hasNumber = true;
                }
        }
        return hasNumber;
    }

    public static boolean  checkSpecial(String password, boolean hasSpecial){
        for (int i = 0; i < password.length(); i++){
            if (password.charAt(i) == '~' || password.charAt(i) == '!' ||
                password.charAt(i) == '@' || password.charAt(i) == '#' ||
                password.charAt(i) == '$' || password.charAt(i) == '%' ||
                password.charAt(i) == '^' || password.charAt(i) == '&' ||
                password.charAt(i) == '*' || password.charAt(i) == '(' ||
                password.charAt(i) == ')' || password.charAt(i) == '-' ||
                password.charAt(i) == '=' || password.charAt(i) == '+' ||
                password.charAt(i) == '_'){
                hasSpecial = true;
            }
        }
        return hasSpecial;
    }
}