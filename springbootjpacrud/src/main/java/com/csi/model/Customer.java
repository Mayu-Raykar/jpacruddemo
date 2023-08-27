package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private int custId;

    @Size(min = 2, message = "Customer Name should be atleast 2 character")
    private String custName;

    private String custAddress;

    @Range(min = 1000000000, max = 9999999999L, message = "Customer Contact Number must be 10 digit")
    @Column(unique = true)
    private long custContactNumber;

    private double custAccountBalance;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date custDOB;

    @Email(message = "Email Id Must be valid")
    @Column(unique = true)
    private String custEmailId;

    @Size(min = 4, message = "Password should be atleast 4 character")
    private String custPassword;
}
