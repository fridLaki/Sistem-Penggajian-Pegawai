/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.penggajian.validator.implement;

import com.penggajian.entity.TabelGapokCapegPegawai;
import com.penggajian.validator.AbstractValidator;
import com.penggajian.validator.ValidatorException;

/**
 *
 * @author MY-IT-STAF
 */
public class TabelGapokCapegPegawaiValidator extends AbstractValidator<TabelGapokCapegPegawai>{

    @Override
    protected void doValidate(TabelGapokCapegPegawai data) throws ValidatorException {
        if (data.getStatusKepegawaian()==null) {  
            throwValidatorException("Status Kepegawaian tidak boleh null");
        } else if (data.getStatusKepegawaian().startsWith("--")) {  
            throwValidatorException("Status Kepegawaian tidak boleh kosong");
        } else if (data.getGolongan()==null) {  
            throwValidatorException("Golongan tidak boleh null");
        } else if (data.getGolongan().startsWith("--")) {  
            throwValidatorException("Golongan tidak boleh kosong");
        } else if (data.getSubGolongan()==null) {  
            throwValidatorException("Sub Golongan tidak boleh null");
        } else if (data.getSubGolongan().startsWith("--")) {  
            throwValidatorException("Sub Golongan tidak boleh kosong");
        } else if (data.getMasaKerjaGolongan().startsWith("--")) {  
            throwValidatorException("Masa Kerja tidak boleh kosong");
        } else if (data.getMasaKerjaGolongan()==null) {  
            throwValidatorException("Masa Kerja tidak boleh null");
        }
    }
    
}
