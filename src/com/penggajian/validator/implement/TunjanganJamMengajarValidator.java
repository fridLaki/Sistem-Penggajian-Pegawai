/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.penggajian.validator.implement;

import com.penggajian.entity.TunjanganJamMengajar;
import com.penggajian.validator.AbstractValidator;
import com.penggajian.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 *
 * @author MY-IT-STAF
 */
@Component
public class TunjanganJamMengajarValidator extends AbstractValidator<TunjanganJamMengajar>{

    @Override
    protected void doValidate(TunjanganJamMengajar data) throws ValidatorException {
        if (data.getStatusKepegawaian()==null) {  
            throwValidatorException("Status Kepegawaian tidak boleh null");
        } else if (data.getStatusKepegawaian().startsWith("--")) {  
            throwValidatorException("Status Kepegawaian tidak boleh kosong");
        } else if (data.getUnitKerja()==null) {  
            throwValidatorException("Unit Kerja tidak boleh null");
        } else if (data.getUnitKerja().startsWith("--")) {  
            throwValidatorException("Unit Kerja tidak boleh kosong");
        } else if (data.getJumlahRombonganBelajar()==null) {  
            throwValidatorException("Jumlah Rombongan Belajar tidak boleh null");
        } else if (data.getJumlahRombonganBelajar().startsWith("--")) {  
            throwValidatorException("Jumlah Rombongan Belajar tidak boleh kosong");
        }
    }
    
}
