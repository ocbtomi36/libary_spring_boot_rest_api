package net.myapi.springboot.validation;

import net.myapi.springboot.exception.*;

import java.time.LocalDate;
import java.util.Optional;

public class FieldValidator {

    public static void emailValidate(String email){
        if(email == null || email.trim().isEmpty()){
            throw new NullArgumentException("Email field can't be empty");
        } else {
            String emailRegex =
                    "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
            if(!email.matches(emailRegex)){
                throw new NotValidFormatException("Email filed must be email format");
            }

        }

    }
    public static void notNullFieldValidate(String data, String fieldName, Integer length) {
        if(data == null || data.trim().isEmpty()){
            throw new NullArgumentException(String.format("%s field can't be empty",fieldName));
        } else if(data.length() > length) {
            throw new NotValidFormatException(String.format("%s field too long max length is %s",data,length));
        }
    }
    public static void dataAlreadyExistValidate(Optional optional, String fieldname){
        if(optional.isPresent()){
            throw new DataAlreadyExistException(String.format("%s is already exists", fieldname));
        }
    }
    public static void yearValidate(Integer year) {
        int minYear = 1000;
        if (year == null) {
            throw new NullArgumentException("Year can't be null");
        }
        int maxYear = LocalDate.now().getYear();
        if (year < minYear || year > maxYear) {
            throw new NotValidDateException(
                    String.format("Year is invalid: %d. Year must be between %d and %d.", year, minYear, maxYear)
            );
        }
    }
    public static void idValidate(Integer id, String fieldName) {
        if (id == null) {
            throw new NullArgumentException(String.format("%s can't be null",fieldName));
        } else if (id <= 0) {
            throw new NotMinusValueException(String.format("%s can't be negative number",fieldName));
        }
    }

    public static void pastDateValidate(LocalDate date) {
        if (date == null) {
            throw new NullArgumentException("Year can't be null");
        }
        LocalDate now = LocalDate.now();
        if (date.isBefore(now)) {
            throw new NotValidDateException(
                    String.format("Date is invalid: %s. Year must be after %s", date, now)
            );
        }
    }

    public static void minusIntegerValidate(Integer integer,String fieldName){
        if(integer == null){
            throw new NullArgumentException("Year can't be null");
        }
        if(integer < 0) {
            throw new NotMinusValueException(String.format("%s field can't be negative",fieldName));
        }
    }
}
