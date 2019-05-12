/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.penggajian.validator.implement;

import com.penggajian.entity.TunjanganJamMengajar;
import com.penggajian.entity.TunjanganKeluarga;
import com.penggajian.entity.TunjanganKhusus;
import com.penggajian.entity.TunjanganStaffKurikulumEkstrakurikuluer;
import com.penggajian.validator.AbstractValidator;
import com.penggajian.validator.ValidatorException;
import org.springframework.stereotype.Component;

/**
 *
 * @author MY-IT-STAF
 */
@Component
public class TunjanganStaffKurikulumEkstrakurikuluerValidator extends AbstractValidator<TunjanganStaffKurikulumEkstrakurikuluer>{

    @Override
    protected void doValidate(TunjanganStaffKurikulumEkstrakurikuluer data) throws ValidatorException {
        if (data.getJenisTunjangan()==null) {  
            throwValidatorException("Jenis Tunjangan tidak boleh null");
        } else if (data.getJenisTunjangan().startsWith("--")) {  
            throwValidatorException("Jenis Tunjangan tidak boleh kosong");
        } else if (data.getUnitKerja()==null) {  
            throwValidatorException("Unit Kerja tidak boleh null");
        } else if (data.getUnitKerja().startsWith("--")) {  
            throwValidatorException("Unit Kerja tidak boleh kosong");
        } else if (data.getJumlahJam()==null) {  
            throwValidatorException("Jumlah Jam tidak boleh null");
        } else if (data.getJumlahJam().startsWith("--")) {  
            throwValidatorException("Jumlah Jam tidak boleh kosong");
        }
    }
    
}
