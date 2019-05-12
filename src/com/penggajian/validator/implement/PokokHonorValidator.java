/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.penggajian.validator.implement;

import com.penggajian.entity.PokokHonor;
import com.penggajian.validator.AbstractValidator;
import com.penggajian.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 *
 * @author MY-IT-STAF
 */
@Component
public class PokokHonorValidator extends AbstractValidator<PokokHonor>{

    @Override
    protected void doValidate(PokokHonor data) throws ValidatorException {
        if (data.getStatusKepegawaian()==null) {  
            throwValidatorException("Status Kepegawaian tidak boleh null");
        } else if (data.getStatusKepegawaian().startsWith("--")) {  
            throwValidatorException("Status Kepegawaian tidak boleh kosong");
        } else if (data.getSubStatusKepegawaian()==null) {  
            throwValidatorException("Sub Status Kepegawaian tidak boleh null");
        } else if (data.getSubStatusKepegawaian().startsWith("--")) {  
            throwValidatorException("Sub Status Kepegawaian tidak boleh kosong");
        } else if (data.getPendidikan()==null) {  
            throwValidatorException("Status Kepegawaian tidak boleh null");
        } else if (data.getPendidikan().startsWith("--")) {  
            throwValidatorException("Status Kepegawaian tidak boleh kosong");
        }
    }
    
}
