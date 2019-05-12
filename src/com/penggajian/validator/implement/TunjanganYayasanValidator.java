/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.penggajian.validator.implement;

import com.penggajian.entity.TunjanganJamMengajar;
import com.penggajian.entity.TunjanganKeluarga;
import com.penggajian.entity.TunjanganKhusus;
import com.penggajian.entity.TunjanganYayasan;
import com.penggajian.validator.AbstractValidator;
import com.penggajian.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 *
 * @author MY-IT-STAF
 */
@Component
public class TunjanganYayasanValidator extends AbstractValidator<TunjanganYayasan>{

    @Override
    protected void doValidate(TunjanganYayasan data) throws ValidatorException {
        if (data.getJabatan()==null) {  
            throwValidatorException("Jabatan tidak boleh null");
        } else if (data.getJabatan().startsWith("--")) {  
            throwValidatorException("Jabatan tidak boleh kosong");
        } else if (data.getGolongan()==null) {  
            throwValidatorException("Golongan tidak boleh null");
        } else if (data.getGolongan().startsWith("--")) {  
            throwValidatorException("Golongan tidak boleh kosong");
        } else if (data.getJenisTunjangan()==null) {  
            throwValidatorException("Jenis Tunjangan tidak boleh null");
        } else if (data.getJenisTunjangan().startsWith("--")) {  
            throwValidatorException("Jenis Tunjangan tidak boleh kosong");
        }
    }
    
}
