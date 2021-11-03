package edu.citytech.abccounter;

public class ABCService {

    static boolean isVowel(String input){
        var status = input.matches("[AEIOUaeiou]");

        return  status;
    }
    static boolean isConsonant(String input){
        var status = !isVowel(input);

        return  status;
    }
    static boolean isEven(String input){
        int num=Integer.parseInt(input);
        boolean status;

        if (num > 0 &&(num%2)==0 ){
            status = true;
        }else {
            status = false;
        }
        return  status;
    }
    static boolean isOdd(String input){
        int num=Integer.parseInt(input);
        boolean status;

        if (num > 0 &&(num%2)!=0 ){
            status = true;
        }else {
            status = false;
        }
        return  status;
    }

    static boolean isEvery$6(String input){
        int num=Integer.parseInt(input);
        boolean status;

        if ((num%6)==0 ){
            status = true;
        }else {
            status = false;
        }
        return  status;
    }
    static boolean isContains$4or9(String input){//100
        String numbers[]=input.split("");//{"5","6","7"}
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].equals("4") || numbers[i].equals("9")){
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
       var status =  ABCService.isConsonant("C");
        System.out.println("Status: "+status);
        var status1 =  ABCService.isContains$4or9("400");
        System.out.println("Status: "+status1);
    }
}






















