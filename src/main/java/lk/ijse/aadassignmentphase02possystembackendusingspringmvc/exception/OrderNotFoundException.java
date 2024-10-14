package lk.ijse.aadassignmentphase02possystembackendusingspringmvc.exception;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(){}
    
    public OrderNotFoundException(String message){}

    public OrderNotFoundException(String message,Exception cause){}
}
