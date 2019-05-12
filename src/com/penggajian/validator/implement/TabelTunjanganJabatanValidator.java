/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.penggajian.validator.implement;

import com.penggajian.entity.TabelTunjanganJabatan;
import com.penggajian.validator.AbstractValidator;
import com.penggajian.validator.ValidatorException;

/**
 *
 * @author MY-IT-STAF
 */
public class TabelTunjanganJabatanValidator extends AbstractValidator<TabelTunjanganJabatan>{

    @Override
    protected void doValidate(TabelTunjanganJabatan data) throws ValidatorException {
        if (data.getJabatan()==null) {  
            throwValidatorException("Jabatan tidak boleh null");
        } else if (data.getJabatan().startsWith("--")) {  
            throwValidatorException("Jabatan tidak boleh kosong");
        } else if (data.getGolongan()==null) {  
            throwValidatorException("Golongan tidak boleh null");
        } else if (data.getGolongan().startsWith("--")) {  
            throwValidatorException("Golongan tidak boleh kosong");
        } else if (data.getJumlahRombengan()==null) {  
            throwValidatorException("Jumlah Rombel tidak boleh null");
        } else if (data.getJumlahRombengan().startsWith("--")) {  
            throwValidatorException("Jumlah Rombel tidak boleh kosong");
        }
    }
    
}
