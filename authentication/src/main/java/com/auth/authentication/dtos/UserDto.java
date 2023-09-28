package com.auth.authentication.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserDto extends BaseDto {
    @NotNull(message = "Entering this field is mandatory")
    @Pattern(regexp = "^([a-zA-Z]|\\s){3,30}$",message = "your username must be between 3 and 10 characters long.")
    private String username;
    @NotNull(message = "Entering this field is mandatory")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$",message ="Use 8 or more characters with a mix of letters,numbers & symbols for your password")
    private String password;
    @NotNull(message = "Entering this field is mandatory")
    @Pattern(regexp = "^([a-zA-Z]|\\s){3,20}$")
    private String firstName;
    @NotNull(message = "Entering this field is mandatory")
    @Pattern(regexp = "^([a-zA-Z]|\\s){3,40}$")
    private String lastName;
    @NotNull(message = "Entering this field is mandatory")
    @Pattern(regexp ="^\\d{18}$",message = "Use only 18 digits for your accountNumber")
    private String accountNumber;
    @NotNull(message = "Entering this field is mandatory")
    @Pattern(regexp = "^\\d{16}$",message = "Use only 8 digits for your cardNumber")
    private String cardNumber;
    @Pattern(regexp = "^09\\d{9}$",message = "Your phone number is incorrect")
    private String mobile;
    private String profilePicture;
}
